package matarillo.demo.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import matarillo.demo.model.Owner;
import matarillo.demo.repository.OwnerRepository;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerRepository repository;

    public OwnerController(OwnerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Owner> list = repository.findAll(Sort.by(Direction.ASC, "id"));
        model.addAttribute("owners", list);
        return "owner/index";
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") int ownerId, ModelAndView mav) {
        Optional<Owner> owner = repository.findById(ownerId);
        if (owner.isEmpty()) {
            mav.setStatus(HttpStatus.NOT_FOUND);
        } else {
            mav.addObject(owner.get());
            mav.setViewName("owner/details");
        }
        return mav;
    }

    @GetMapping("/create")
    public String initCreationForm(Map<String, Object> model) {
        Owner owner = new Owner();
        model.put("owner", owner);
        return "owner/create";
    }

    @PostMapping("/create")
    public String processCreationForm(@Validated Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return "owner/create";
        } else {
            repository.save(owner);
            return "redirect:/owners/" + owner.getId();
        }
    }

    @GetMapping("/{ownerId}/edit")
    public ModelAndView initUpdateOwnerForm(@PathVariable("ownerId") int ownerId, ModelAndView mav) {
        Optional<Owner> owner = repository.findById(ownerId);
        if (owner.isEmpty()) {
            mav.setStatus(HttpStatus.NOT_FOUND);
        } else {
            mav.addObject(owner.get());
            mav.setViewName("owner/edit");
        }
        return mav;
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(@PathVariable("ownerId") int ownerId, @Validated Owner owner,
            BindingResult result) {
        if (result.hasErrors()) {
            return "owner/edit";
        } else {
            owner.setId(ownerId);
            repository.save(owner);
            return "redirect:/owners/" + owner.getId();
        }
    }

    @GetMapping("/{ownerId}/delete")
    public ModelAndView initDeleteOwnerForm(@PathVariable("ownerId") int ownerId, ModelAndView mav) {
        Optional<Owner> owner = repository.findById(ownerId);
        if (owner.isEmpty()) {
            mav.setStatus(HttpStatus.NOT_FOUND);
        } else {
            mav.addObject(owner.get());
            mav.setViewName("owner/delete");
        }
        return mav;
    }

    @PostMapping("/{ownerId}/delete")
    public ModelAndView processDeleteOwnerForm(@PathVariable("ownerId") int ownerId, ModelAndView mav) {
        if (!repository.existsById(ownerId)) {
            mav.setStatus(HttpStatus.NOT_FOUND);
        } else {
            repository.deleteById(ownerId);
            mav.setViewName("redirect:/owners/");
        }
        return mav;
    }
}

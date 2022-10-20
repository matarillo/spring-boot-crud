package matarillo.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import matarillo.demo.model.Owner;

public interface OwnerRepository extends PagingAndSortingRepository<Owner, Integer> {
    
}

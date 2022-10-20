package matarillo.demo.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("owners")
public class Owner {
    @Id
    private Integer id;

    @Column("first_name")
    @NotEmpty
    private String firstName;

    @Column("last_name")
    @NotEmpty
    private String lastName;

    @Column("address")
    @NotEmpty
    private String address;

    @Column("city")
    @NotEmpty
    private String city;

    @Column("telephone")
    @NotEmpty
    private String telephone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isNew() {
        return this.id == null;
    }
}

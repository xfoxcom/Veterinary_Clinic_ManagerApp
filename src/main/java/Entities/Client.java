package Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    private long id;
    @NotEmpty
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @ElementCollection(targetClass = Animal.class)
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Animal> pets = new ArrayList<>();
}

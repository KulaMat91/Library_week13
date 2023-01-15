package org.example.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

//adnotacja @Data - tworzy gettery, setter itd.
@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@ToString(exclude ={"roles, address"})
//jexeli chcemy cos wykluczyc ze toStringa aby nie pokazywac
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String login;
    private String password;
    private String name;
    private String email;
    @ManyToMany
    @JoinTable(name = "User_Role",
            joinColumns = { @JoinColumn(name = "user_id")},
            inverseJoinColumns = { @JoinColumn(name = "role_id")}
    )
    private List<Role> roles;
    // adnotacja @JoinTable tworzy tabelę, po której będzie odbywało się łączenie, tabela asocjacyjna

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    //cascade- kaskadowo dodawąć i usuwać adress i role
    private Address address;

}

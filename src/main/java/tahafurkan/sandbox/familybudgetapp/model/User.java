package tahafurkan.sandbox.familybudgetapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @GeneratedValue
    @Id
    private Integer id;
    private String name;
    private String lastname;
    @Column(unique = true)
    private String username;
    @OneToMany(targetEntity = Spending.class, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private List<Spending> spending;

}

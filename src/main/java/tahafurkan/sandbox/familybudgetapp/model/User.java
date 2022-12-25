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
    private int id;
    private String name;
    private String lastname;
    @OneToMany(targetEntity = Spending.class, cascade = CascadeType.ALL)
    private List<Spending> spending;
    
}

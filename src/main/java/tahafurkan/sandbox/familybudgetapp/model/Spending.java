package tahafurkan.sandbox.familybudgetapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Data;


@Entity
@Table(name = "spendings")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Spending {

    @GeneratedValue
    @Id
    private Integer id;
    private String date;
    private double amount;
    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private User user;


}


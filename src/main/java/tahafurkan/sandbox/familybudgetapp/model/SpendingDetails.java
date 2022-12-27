package tahafurkan.sandbox.familybudgetapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tahafurkan.sandbox.familybudgetapp.enums.BillTypes;
import tahafurkan.sandbox.familybudgetapp.enums.SpendingTypes;

@Entity
@Table(name = "spending details")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SpendingDetails {

    @GeneratedValue
    @Id
    private int id;
    private SpendingTypes spendingTypes;
    private BillTypes billTypes;
    private String productName;
    private double price;
    private String description;
    @ManyToOne(targetEntity = Spending.class , cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private Spending spending;

}
package tahafurkan.sandbox.familybudgetapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "spendingDetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SpendingDetail {

    @GeneratedValue
    @Id
    private int id;
    private String productName;
    private double price;
    private String description;

}
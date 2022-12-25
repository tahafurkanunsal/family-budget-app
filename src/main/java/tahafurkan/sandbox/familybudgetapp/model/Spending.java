package tahafurkan.sandbox.familybudgetapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    @Id
    private int id;
    private String spendingCategory;
    private String spendingDate;
    private String spendingDescription;

}

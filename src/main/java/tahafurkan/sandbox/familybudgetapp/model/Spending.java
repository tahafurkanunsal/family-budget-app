package tahafurkan.sandbox.familybudgetapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
    private double amount;
    private String month;
    private Category category;
    private String description;
}

enum Category {
    MARKET,SCHOOL,BILLS,MOBILEPHONEBILL,TRANSPORTATION;
}
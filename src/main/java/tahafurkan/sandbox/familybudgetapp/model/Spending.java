package tahafurkan.sandbox.familybudgetapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Data;
import tahafurkan.sandbox.familybudgetapp.enums.BillingTypes;
import tahafurkan.sandbox.familybudgetapp.enums.SpendingTypes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "spendings")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Spending {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @JsonFormat(pattern = "yyyy-MMM-dd")
    private Date date;
    private double price;
    private SpendingTypes type;
    private BillingTypes billingType;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(referencedColumnName = "id")
    private User user;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "spending_id")
    private List<SpendingDetail> details = new ArrayList<>();

}


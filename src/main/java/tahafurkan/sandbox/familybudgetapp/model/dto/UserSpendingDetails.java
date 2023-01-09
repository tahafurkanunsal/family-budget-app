package tahafurkan.sandbox.familybudgetapp.model.dto;

import lombok.*;
import tahafurkan.sandbox.familybudgetapp.model.Spending;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserSpendingDetails {

    private Integer userId;
    private String name;
    private List<Spending> spendings;


}

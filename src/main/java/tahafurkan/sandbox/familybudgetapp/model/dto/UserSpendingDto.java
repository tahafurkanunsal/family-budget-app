package tahafurkan.sandbox.familybudgetapp.model.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserSpendingDto {

    private Integer userId;
    private String fullName;
    List<SpendingDto> spendings = new ArrayList<>();
}

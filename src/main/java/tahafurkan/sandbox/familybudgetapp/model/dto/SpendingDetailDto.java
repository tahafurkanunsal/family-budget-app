package tahafurkan.sandbox.familybudgetapp.model.dto;

import lombok.*;
import tahafurkan.sandbox.familybudgetapp.model.SpendingDetail;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SpendingDetailDto {

    private List<SpendingDetail> spendingDetails = new ArrayList<>();
}

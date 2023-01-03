package tahafurkan.sandbox.familybudgetapp.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import tahafurkan.sandbox.familybudgetapp.enums.BillingTypes;
import tahafurkan.sandbox.familybudgetapp.enums.SpendingTypes;
import tahafurkan.sandbox.familybudgetapp.model.SpendingDetail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SpendingDto {

    @JsonFormat(pattern = "yyyy-MMM-dd")
    private Date date;
    private double price;
    private SpendingTypes type;
    private BillingTypes billingType;
    private Integer userId;
    private List<SpendingDetail> details = new ArrayList<>();
}

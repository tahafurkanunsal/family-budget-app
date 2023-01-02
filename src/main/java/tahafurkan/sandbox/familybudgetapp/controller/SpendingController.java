package tahafurkan.sandbox.familybudgetapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tahafurkan.sandbox.familybudgetapp.model.Spending;
import tahafurkan.sandbox.familybudgetapp.model.dto.SpendingDto;
import tahafurkan.sandbox.familybudgetapp.service.SpendingService;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class SpendingController {

    @Autowired
    SpendingService spendingService;

    @GetMapping(value = "/spendings")
    public List<Spending> getAll() {
        return spendingService.getAll();
    }

    @PostMapping(value = "/spendings")
    public Spending create(@RequestBody SpendingDto spendingDto) {
        return spendingService.create(spendingDto);
    }
}

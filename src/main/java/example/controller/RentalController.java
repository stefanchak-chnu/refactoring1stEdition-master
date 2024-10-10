package example.controller;

import example.service.RentalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/statement")
    public String getCustomerStatement() {
        return rentalService.generateDefaultCustomerStatement();
    }
}
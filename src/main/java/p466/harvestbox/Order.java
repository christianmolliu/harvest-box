package p466.harvestbox;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import lombok.Data;

@Data
@Table("HARVEST_ORDER")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private Date placedAt = new Date();

    @NotBlank(message = "Name is required")
    private String customerName;

    @NotBlank(message = "Street is required")
    private String customerStreet;

    @NotBlank(message = "City is required")
    private String customerCity;

    @NotBlank(message = "State is required")
    private String customerState;

    @NotBlank(message = "Zip code is required")
    private String customerZip;

    @NotBlank(message = "Card number is required")
    @Pattern(regexp = "^[0-9]{16}$", message = "Must be a 16-digit card number")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])/([0-9]{2})$", message = "Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

    private List<Box> boxes = new ArrayList<>();
}
package p466.harvestbox;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Table
public class Box {

    @Id
    private Long id;

    @NotBlank(message = "Give your box a name")
    private String name;

    private Date createdAt = new Date();

    @NotBlank(message = "Choose a vegetable")
    private String vegetableId;

    @NotBlank(message = "Choose a fruit")
    private String fruitId;

    @NotBlank(message = "Choose a grain")
    private String grainId;

    @NotBlank(message = "Choose a dairy item")
    private String dairyId;

    @NotBlank(message = "Choose a protein")
    private String proteinId;
}
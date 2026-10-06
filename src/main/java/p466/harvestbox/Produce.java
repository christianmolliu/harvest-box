package p466.harvestbox;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table
public class Produce {

    @Id
    private final String id;
    private final String name;
    private final Type type;
    private final double price;

    public enum Type {
        VEGETABLE, FRUIT, GRAIN, DAIRY, PROTEIN
    }
}
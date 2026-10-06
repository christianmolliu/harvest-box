package p466.harvestbox.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.Errors;

import jakarta.validation.Valid;

import p466.harvestbox.Box;
import p466.harvestbox.Produce;
import p466.harvestbox.Produce.Type;
import p466.harvestbox.Order;
import p466.harvestbox.data.ProduceRepository;

@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignBoxController {

    private final ProduceRepository produceRepo;

    public DesignBoxController(ProduceRepository produceRepo) {
        this.produceRepo = produceRepo;
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "box")
    public Box box() {
        return new Box();
    }

    @ModelAttribute
    public void addProduceToModel(Model model) {
        List<Produce> produceItems = (List<Produce>) produceRepo.findAll();

        for (Type type : Type.values()) {
            model.addAttribute(
                    type.toString().toLowerCase(),
                    filterByType(produceItems, type));
        }
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processBox(
            @Valid Box box, Errors errors,
            @ModelAttribute Order order) {

        if (errors.hasErrors()) {
            return "design";
        }

        order.getBoxes().add(box);
        return "redirect:/order/current";
    }

    private List<Produce> filterByType(
            List<Produce> produceItems, Type type) {

        return produceItems.stream()
                .filter(p -> p.getType().equals(type))
                .toList();
    }
}
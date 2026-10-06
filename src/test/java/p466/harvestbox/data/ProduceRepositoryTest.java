package p466.harvestbox.data;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jdbc.test.autoconfigure.DataJdbcTest;

import p466.harvestbox.Produce;

@DataJdbcTest
public class ProduceRepositoryTest {

    @Autowired
    private ProduceRepository produceRepo;

    @Test
    public void shouldFindProduce() {
        Iterable<Produce> produceItems = produceRepo.findAll();
        assertThat(produceItems).isNotEmpty();
    }

    @Test
    public void shouldFindKaleById() {
        Produce kale = produceRepo.findById("KALE").orElseThrow();
        assertThat(kale.getName()).isEqualTo("Organic Kale");
    }
}
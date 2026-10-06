package p466.harvestbox.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import p466.harvestbox.data.ProduceRepository;

@WebMvcTest(DesignBoxController.class)
public class DesignBoxControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProduceRepository produceRepo;

    @Test
    public void testDesignForm() throws Exception {
        org.mockito.Mockito.when(produceRepo.findAll())
                .thenReturn(Collections.emptyList());

        mockMvc.perform(get("/design"))
                .andExpect(status().isOk());
    }
}
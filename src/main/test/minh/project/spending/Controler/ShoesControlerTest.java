package minh.project.spending.Controler;

import minh.project.spending.Repository.ShoesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShoesControlerTest {
    @Autowired
    ShoesControler controler;

    @Test
    void getAll() {
        assertEquals(controler.GetAll().size(),6);
    }

    @Test
    void getById() {
        assertEquals(controler.GetById(1).getName(),"Bitis Hunter");
    }
}
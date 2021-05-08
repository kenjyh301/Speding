package minh.project.spending.Controler;

import minh.project.spending.Model.ShoesModel;
import minh.project.spending.Repository.ShoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoes")
public class ShoesControler {
    @Autowired
    ShoesRepository shoesRepository;

    @GetMapping("/")
    List<ShoesModel> GetAll(){
        return shoesRepository.findAll();
    }

    @GetMapping("/{id}")
    ShoesModel GetById(@PathVariable(name="id")int id){
        return shoesRepository.findById(id).get();
    }

}

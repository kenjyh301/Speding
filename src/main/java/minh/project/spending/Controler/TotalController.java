package minh.project.spending.Controler;

import minh.project.spending.Model.ShoesModel;
import minh.project.spending.Model.TotalModel;
import minh.project.spending.Repository.ShoesRepository;
import minh.project.spending.Repository.TotalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/total")
public class TotalController {
    @Autowired
    TotalRepository totalRepository;
    @Autowired
    ShoesRepository shoesRepository;

    @GetMapping("/")
    List<TotalModel> GetAll(){
        return totalRepository.findAll();
    }

    @GetMapping("/{id}")
    TotalModel GetById(@PathVariable(name="id")int id){
        return totalRepository.findById(id).get();
    }

    @PatchMapping("/update/")
    void Update(){
        TotalModel shoesTotal= new TotalModel();
        shoesTotal.setId(1);
        shoesTotal.setType("shoes");
        List<ShoesModel> shoesModels= shoesRepository.findAll();
        int sumShoes=0;
        for (ShoesModel shoe:shoesModels) {
            sumShoes+=shoe.getPrice();

        }
        shoesTotal.setValue(sumShoes);
        totalRepository.save(shoesTotal);
    }

}

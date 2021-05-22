package minh.project.spending.Controler;

import lombok.extern.slf4j.Slf4j;
import minh.project.spending.Model.ShoesModel;
import minh.project.spending.Repository.ShoesRepository;
import minh.project.spending.Service.ShoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoes")
@Slf4j
public class ShoesControler {
    @Autowired
    ShoesService shoesService;
    @Autowired
    ShoesRepository shoesRepository;

    @GetMapping("/")
    List<ShoesModel> GetAll(){
//        System.out.print("\033[H\033[2J");
//        System.out.flush();
        return shoesService.findAll();
    }

    @GetMapping("/{id}")
    ShoesModel GetById(@PathVariable(name="id")int id){
        return shoesService.findById(id);
    }

    @GetMapping("/{year}")
    int GetYearSpending(@PathVariable(name="year")int year){
        int total=0;
        List<ShoesModel> shoesModels= GetAll();
        for (ShoesModel shoe:
             shoesModels) {
            if(shoe.getDate().getYear()==year)total+=shoe.getPrice();
        }
        return total;
    }

    @PutMapping("/")
    public ResponseEntity<?> Create(@RequestBody ShoesModel shoe) {
        return ResponseEntity.ok(shoesService.Create(shoe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeleteById(@PathVariable(name="id") int id){
        shoesService.DeleteById(id);
        return ResponseEntity.ok().build();
    }
}

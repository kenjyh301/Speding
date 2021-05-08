package minh.project.spending;

//import minh.project.spending.Model.ShoesModel;
//import minh.project.spending.Repository.ShoesRepository;
import minh.project.spending.Model.ShoesModel;
import minh.project.spending.Repository.ShoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class SpendingApplication {

	@Autowired
	ShoesRepository shoesRepository;


	public static void main(String[] args) {
		SpringApplication.run(SpendingApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	void test(){
		String uri= "http://localhost:8080/shoes/";
		RestTemplate restTemplate= new RestTemplate();
//		ShoesModel result= restTemplate.getForObject(uri,ShoesModel.class);
//		System.out.println("Start test:");
//		System.out.println(result);
	}
}

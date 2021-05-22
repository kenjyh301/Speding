package minh.project.spending.Service;

import com.datastax.driver.core.LocalDate;
import io.grpc.ManagedChannel;
import minh.project.spending.Model.ShoesModel;
import minh.project.spending.Repository.ShoesRepository;
import minh.project.spending.grpc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import minh.project.spending.grpc.Info;
import java.util.List;

@Service
public class ShoesService {
    @Autowired
    ShoesRepository shoesRepository;
    @Autowired
    ManagedChannel showChannel;
//    @Autowired
//    EvaluateGrpc.EvaluateBlockingStub evaluateStub;

    public void SendTable(List<ShoesModel> shoesModels){
        EvaluateGrpc.EvaluateBlockingStub evaluateBlockingStub= EvaluateGrpc.newBlockingStub(showChannel);
        Infos.Builder infosBuilder= Infos.newBuilder();
        for (ShoesModel shoe:
                shoesModels) {
            Info.Builder infoBuilder= Info.newBuilder();
            infoBuilder.setId(shoe.getId());
            infoBuilder.setDate(shoe.getDate().toString());
            infoBuilder.setName(shoe.getName());
            infoBuilder.setPrice(shoe.getPrice());
            Info info= infoBuilder.build();

            infosBuilder.addInfos(info);
        }
        Infos infos=infosBuilder.build();
//        evaluateBlockingStub.sendTable(infos);//return Empty
        Source source= Source.newBuilder().setNum(1).setTableName("shoes").build();
        evaluateBlockingStub.getTable(source);
        System.out.println("ok");

    }

    public int GetIndex(){
        List<ShoesModel> shoesModels= shoesRepository.findAll();
        int index=0;
        for (ShoesModel  shoe:
             shoesModels) {
            if(shoe.getId()>index)index=shoe.getId();
        }
        return (index+1);
    }
    //create new or update existed
    public ShoesModel Create(ShoesModel shoe){
        if(shoe.getId()==0)shoe.setId(GetIndex());
        shoe.setDate(LocalDate.fromMillisSinceEpoch(System.currentTimeMillis()));
        return shoesRepository.save(shoe);
    }

    public List<ShoesModel> findAll(){
        List<ShoesModel> shoesModels= shoesRepository.findAll();
        SendTable(shoesModels);
        return shoesModels;
    }

    public ShoesModel findById(int id){
        return shoesRepository.findById(id).get();
    }

    public void DeleteById(int id){
        shoesRepository.deleteById(id);
    }


}

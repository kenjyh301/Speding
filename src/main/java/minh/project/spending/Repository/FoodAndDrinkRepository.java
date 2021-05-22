package minh.project.spending.Repository;

import minh.project.spending.Model.FoodAndDrinkModel;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface FoodAndDrinkRepository extends CassandraRepository<FoodAndDrinkModel,Integer> {
}

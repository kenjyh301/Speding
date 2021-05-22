package minh.project.spending.Repository;

import minh.project.spending.Model.TravelModel;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface TravelRepository extends CassandraRepository<TravelModel,Integer> {
}

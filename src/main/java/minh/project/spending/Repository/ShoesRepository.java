package minh.project.spending.Repository;

import minh.project.spending.Model.ShoesModel;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoesRepository extends CassandraRepository<ShoesModel,Integer> {
}

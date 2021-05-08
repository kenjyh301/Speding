package minh.project.spending.Repository;

import minh.project.spending.Model.TotalModel;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalRepository extends CassandraRepository<TotalModel,Integer> {
}

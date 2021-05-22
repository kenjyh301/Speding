package minh.project.spending.Repository;

import minh.project.spending.Model.MISCModel;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface MISCRepository extends CassandraRepository<MISCModel,Integer> {
}

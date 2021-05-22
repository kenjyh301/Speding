package minh.project.spending.Repository;

import jnr.ffi.annotations.In;
import minh.project.spending.Model.OtherModel;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface OtherRepository extends CassandraRepository<OtherModel, Integer> {
}

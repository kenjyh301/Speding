package minh.project.spending.Repository;

import minh.project.spending.Model.StudyModel;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface StudyRepository extends CassandraRepository<StudyModel,Integer> {
}

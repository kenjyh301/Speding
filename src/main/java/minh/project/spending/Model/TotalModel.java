package minh.project.spending.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Table("total")
@NoArgsConstructor
public class TotalModel {
    @PrimaryKey
    int id;
    String type;
    int value;
}

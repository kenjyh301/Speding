package minh.project.spending.Model;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import com.datastax.driver.core.LocalDate;

@Data
@Table("shoes")
public class ShoesModel {
    @PrimaryKey
    private int id;
    private LocalDate date;
    private String name;
    private int price;
}

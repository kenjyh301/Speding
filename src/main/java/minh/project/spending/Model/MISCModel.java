package minh.project.spending.Model;

import com.datastax.driver.core.LocalDate;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("MISC")
@Data
public class MISCModel {
    @PrimaryKey
    private int id;
    private LocalDate date;
    private String name;
    private int price;
}

package nl.paisanrietbroek.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by paisanrietbroek on 21/04/2018.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "exams")
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Exam> exams;

}

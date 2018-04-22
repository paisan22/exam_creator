package nl.paisanrietbroek.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by paisanrietbroek on 21/04/2018.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "exam")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "name")
    private String name;

    @Column(name = "questions")
    @OneToMany(mappedBy = "exam", cascade = {CascadeType.ALL})
    private List<Question> questions;

}

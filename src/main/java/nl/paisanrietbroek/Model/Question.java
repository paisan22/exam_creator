package nl.paisanrietbroek.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by paisanrietbroek on 21/04/2018.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "question")
public class Question {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "question")
    private String question;

    @Column(name = "answer")
    private String answer;

    @Column(name = "passed")
    private boolean passed;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "exam_id")
    private Exam exam;
}

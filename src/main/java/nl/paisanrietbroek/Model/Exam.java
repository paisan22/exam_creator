package nl.paisanrietbroek.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by paisanrietbroek on 21/04/2018.
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "exam")
@Getter
@Setter
public class Exam implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category")
    @JsonManagedReference
    private Category category;

    @Column(name = "name")
    private String name;

    @Column(name = "questions")
    @OneToMany(mappedBy = "exam", cascade = {CascadeType.ALL})
    private List<Question> questions;

}

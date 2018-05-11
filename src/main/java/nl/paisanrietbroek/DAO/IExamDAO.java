package nl.paisanrietbroek.DAO;

import nl.paisanrietbroek.Model.Category;
import nl.paisanrietbroek.Model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by paisanrietbroek on 22/04/2018.
 */
public interface IExamDAO extends JpaRepository<Exam, Integer> {

    List<Exam> findByCategory(Category category);

}

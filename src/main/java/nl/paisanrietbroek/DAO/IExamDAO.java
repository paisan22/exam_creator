package nl.paisanrietbroek.DAO;

import nl.paisanrietbroek.Model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by paisanrietbroek on 22/04/2018.
 */
public interface IExamDAO extends JpaRepository<Exam, Integer> {

}

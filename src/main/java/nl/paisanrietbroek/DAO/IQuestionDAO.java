package nl.paisanrietbroek.DAO;

import nl.paisanrietbroek.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by paisanrietbroek on 12/05/2018.
 */

public interface IQuestionDAO extends JpaRepository<Question, Integer> {



}

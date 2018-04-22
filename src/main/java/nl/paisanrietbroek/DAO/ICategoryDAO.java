package nl.paisanrietbroek.DAO;

import nl.paisanrietbroek.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by paisanrietbroek on 22/04/2018.
 */
public interface ICategoryDAO extends JpaRepository<Category, Integer>{

}

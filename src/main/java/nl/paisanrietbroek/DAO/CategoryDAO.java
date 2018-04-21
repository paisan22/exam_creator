package nl.paisanrietbroek.DAO;

import nl.paisanrietbroek.Model.Category;
import nl.paisanrietbroek.Model.Exam;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by paisanrietbroek on 21/04/2018.
 */

@Service
public class CategoryDAO {

    private ArrayList<Category> categoryArrayList;

    public CategoryDAO() {
        this.categoryArrayList = new ArrayList<>();

        Exam exam = new Exam();
        exam.setName("test exam");

        Exam exam2 = new Exam();
        exam2.setName("test2 exam");

        ArrayList<Exam> exams = new ArrayList<>();
        exams.add(exam);
        exams.add(exam2);

        Category category = new Category();
        category.setName("category1");
        category.setExamArrayList(exams);

        Category category2 = new Category();

        categoryArrayList.add(category);
        categoryArrayList.add(category2);

    }

    public ArrayList<Category> getAllCategories() {
        return this.categoryArrayList;
    }
}

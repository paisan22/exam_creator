package nl.paisanrietbroek.Service;

import nl.paisanrietbroek.DAO.ICategoryDAO;
import nl.paisanrietbroek.DAO.IExamDAO;
import nl.paisanrietbroek.Model.Category;
import nl.paisanrietbroek.Model.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.PersistenceException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by paisanrietbroek on 22/04/2018.
 */

@Service
public class ExamService {

    @Autowired
    private IExamDAO examDAO;

    @Autowired
    private ICategoryDAO categoryDAO;

    @Autowired
    private LogToFile logToFile;

    public boolean createExam(Exam exam) throws IOException {

        boolean result = false;

        try {
            examDAO.save(setExamForQuestions(exam));
            result = true;
        } catch (PersistenceException e) {
            logToFile.logWarningToFile(e.getMessage());
        }
        return result;
    }

    public Exam setExamForQuestions(Exam exam) {
        exam.getQuestions().forEach(question -> {
            question.setExam(exam);
        });
        return exam;
    }

    public List<Exam> getAllExams() throws IOException {

        List<Exam> list = null;

        try {
            list = examDAO.findAll();

        } catch (PersistenceException e) {
            logToFile.logWarningToFile(e.getMessage());
        }
        return list;
    }

    public boolean updateExam(@RequestBody Exam exam) throws IOException {

        boolean result = false;

        try {
            examDAO.save(setExamForQuestions(exam));

            result = true;
        } catch (PersistenceException e) {
            logToFile.logWarningToFile(e.getMessage());
        }
        return result;
    }

    public boolean deleteExame(@RequestBody HashMap<String, String> body) throws IOException {

        boolean result = false;

        try {
            Exam exam = examDAO.getOne(Integer.parseInt(body.get("id")));
            examDAO.delete(exam);
            result = true;
        } catch (PersistenceException e) {
            logToFile.logWarningToFile(e.getMessage());
        }
        return result;
    }



    public Exam getExamById(HashMap<String, String> header) {
        return examDAO.getOne(Integer.parseInt(header.get("id")));
    }

    public List<Exam> getExamsByCategory(HashMap<String, String> header) {
        int id = Integer.parseInt(header.get("id"));

        Category one = categoryDAO.getOne(id);
        return examDAO.findByCategory(one);
    }
}

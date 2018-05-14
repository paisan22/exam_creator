package nl.paisanrietbroek.Service;

import nl.paisanrietbroek.DAO.IExamDAO;
import nl.paisanrietbroek.DAO.IQuestionDAO;
import nl.paisanrietbroek.Model.Exam;
import nl.paisanrietbroek.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by paisanrietbroek on 12/05/2018.
 */

@Service
public class QuestionService {

    @Autowired
    private IQuestionDAO questionDAO;

    @Autowired
    private IExamDAO examDAO;

    @Autowired
    private LogToFile logToFile;

    public boolean deleteQuestion(HashMap<String, String> body) throws IOException {
        int id = Integer.parseInt(body.get("id"));

        boolean result = false;

        try {
            Question question = questionDAO.getOne(id);
            questionDAO.delete(question);
            result = true;
        } catch (PersistenceException e) {
            logToFile.logWarningToFile(e.getMessage());
        }

        return result;
    }

    public boolean updateQuestion(HashMap<String, String> body) throws IOException {

        boolean result = false;

        int id = Integer.parseInt(body.get("id"));
        String question = body.get("question");
        String answer = body.get("answer");

        try {
            Question one = questionDAO.getOne(id);
            one.setQuestion(question);
            one.setAnswer(answer);
            questionDAO.save(one);
            result = true;
        } catch (PersistenceException e) {
            logToFile.logWarningToFile(e.getMessage());
        }
        return result;
    }

    public boolean addQuestion(HashMap<String, String> body) throws IOException {

        boolean result = false;

        int id = Integer.parseInt(body.get("id"));
        String question = body.get("question");
        String answer = body.get("answer");

        try {
            Exam exam = examDAO.getOne(id);

            Question build = Question.builder()
                    .question(question)
                    .answer(answer)
                    .exam(exam)
                    .build();

            questionDAO.save(build);
            result = true;
        } catch (PersistenceException e) {
            logToFile.logWarningToFile(e.getMessage());
        }

        return result;

    }

}

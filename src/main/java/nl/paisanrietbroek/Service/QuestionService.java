package nl.paisanrietbroek.Service;

import nl.paisanrietbroek.DAO.IQuestionDAO;
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
}

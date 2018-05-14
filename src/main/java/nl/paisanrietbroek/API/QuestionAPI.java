package nl.paisanrietbroek.API;

import nl.paisanrietbroek.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by paisanrietbroek on 12/05/2018.
 */

@RestController
@RequestMapping("/question")
@CrossOrigin
public class QuestionAPI {

    @Autowired
    private QuestionService questionService;

    @DeleteMapping
    public boolean deleteQuestion(@RequestBody HashMap<String, String> body) throws IOException {

        return this.questionService.deleteQuestion(body);
    }

    @PutMapping
    public boolean updateQuestion(@RequestBody HashMap<String, String> body) throws IOException {

        return this.questionService.updateQuestion(body);

    }

    @PostMapping
    public boolean addQuestion(@RequestBody HashMap<String, String> body) throws IOException {
        return this.questionService.addQuestion(body);
    }

}

package com.example.quiz.Controller;


import com.example.quiz.Entity.Options;
import com.example.quiz.Entity.Question;
import com.example.quiz.Repo.QuestionRepo;
import com.example.quiz.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    QuestionService questionService;
    @Autowired
    QuestionRepo questionRepo;



//    @PostMapping("/login")
//    public String login(@RequestBody LoginRequest loginRequest) {
//        if (USERNAME.equals(loginRequest.getUsername()) && PASSWORD.equals(loginRequest.getPassword())) {
//            return "Login Successful!";
//        } else {
//            return "Invalid username or password";
//        }
//    }



    @GetMapping("/questions")
    public List<Question> getQuestions() {
        return questionService.getAllQuestions();
    }


    @PostMapping("/save")
    public Question saveQuestion(@RequestBody Question question){
        for (Options opt : question.getOptions()){

            opt.setQuestion(question);
        }
//        Question saved = questionService.saveQuestion(question);
//        return saved;
        return questionRepo.save(question);
    }


//    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
//    public Question saveQuestion(@RequestBody Question question) {
//        return questionService.saveQuestion(question);
//    }




}

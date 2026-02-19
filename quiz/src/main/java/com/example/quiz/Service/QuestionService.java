package com.example.quiz.Service;

import com.example.quiz.Entity.Question;
import com.example.quiz.Repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo questionRepo;

    public List<Question> getAllQuestions(){
        List<Question> questionListAll = questionRepo.findAll();
        return questionListAll;
    }


    public Question saveQuestion(Question question) {
        Question save = questionRepo.save(question);
        return save;
    }

}

package com.OneToOneMapping;

import jakarta.persistence.*;

@Entity
public class Question {

    @Id
    @Column(name = "question_id")
    private int id;

    @Column(nullable = false, length = 100)
    private  String questionText;

    @OneToOne(cascade = CascadeType.ALL)  // Establishing a one-to-one relationship
    @JoinColumn(name = "answer_id")  // This column will be the foreign key in the Question table
    private Answer answer;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getQuestionText() {
        return questionText;
    }
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
    public Answer getAnswer() {
        return answer;
    }
    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

}

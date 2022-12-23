package com.ddonsdevelop.study_servlet.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;


public class PollWithDB {

    //내용을 받아오는 거

    //Question Function

    public HashMap<String, Object> getQuestion(String questionsUid) throws SQLException {

        // SELECT = FROM QUESTIONS_LIST
        // WHERE QUESTIONS_UID = 'Q2'
        Commons commons = new Commons(); //인스턴스화 시키기
        Statement statement = commons.getStatement(); //쿼리문을 넣으려면 statement

        String query = "SELECT * FROM QUESTIONS_LIST "  +
                       " WHERE QUESTIONS_UID = '"+questionsUid+"'";

        //Query 날리기
        ResultSet resultSet = statement.executeQuery(query);
//리턴을 하기 위해서 while문 밖에서 HashMap 선언
HashMap<String, Object> result = null; 

        while(resultSet.next()){
            //사용할 떄만 new
            result = new HashMap<>();
            result.put("QUESTIONS_UID",resultSet.getString("QUESTIONS_UID"));
            result.put("QUESTIONS",resultSet.getString("QUESTIONS"));
            result.put("ORDERS", resultSet.getInt("ORDERS"));
        }

        return result;
    }

    //Answer Funciton

    public ArrayList<HashMap> getAnswer(String questionsUid) throws SQLException {

        Commons commons = new Commons();
        Statement statement = commons.getStatement();

     

        String query = "SELECT * FROM EXAMPLE_LIST INNER JOIN ANSWERS " + 
        "ON EXAMPLE_LIST.EXAMPLE_UID = ANSWERS.EXAMPLE_UID " + 
        "WHERE ANSWERS.QUESTIONS_UID = '" + questionsUid+"'";

        ResultSet resultSet = statement.executeQuery(query);

        ArrayList<HashMap> answer = new ArrayList<>();
        HashMap<String, Object> result = null;

            while(resultSet.next()){
            result = new HashMap<>();
            // result.put("EXAMPLE_UID", resultSet.getString("EXAMPLE_UID"));
            result.put("EXAMPLE", resultSet.getString("EXAMPLE"));
            result.put("ORDERS", resultSet.getInt("ORDERS"));

            answer.add(result);
            }

        return answer;
    }


}

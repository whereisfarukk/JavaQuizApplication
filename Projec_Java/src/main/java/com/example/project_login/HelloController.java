package com.example.project_login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class HelloController {
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField userNameTextField;
    @FXML
    private Button cancelButton;
    @FXML
    private Button loginButton;
    @FXML
    private Button signUpButton;
    @FXML
    private Label LoginMessegeLebel;

    public void userLogIn(ActionEvent event)throws IOException{
        checkLogin();
    }
    private void checkLogin() throws IOException{
        boolean found=false;
        File file=new File("database.txt");
        String inputtedUserName=userNameTextField.getText().toString();
        String inputtedUserPassWord=passwordField.getText().toString();
        Scanner sc=new Scanner(file);
        while(sc.hasNext()){
            String currentStateUserName=sc.next();
            String currentStatePassword=sc.next();
            if(inputtedUserName.equals(currentStateUserName) && inputtedUserPassWord.equals(currentStatePassword)){
                found=true;
            }
        }
        sc.close();
        if(found){
            LoginMessegeLebel.setText("Login Success");
            try {
                Thread.sleep(1000);//time is in ms (1000 ms = 1 second)
            } catch (InterruptedException e) {e.printStackTrace();}
            Stage stage =(Stage)cancelButton.getScene().getWindow();
            stage.close();
            OnlineTest.main();
        }
        else if(inputtedUserName.isEmpty() && inputtedUserPassWord.isEmpty()){
            LoginMessegeLebel.setText("please enter your data");
        }
        else{
            LoginMessegeLebel.setText("Wrong username or password");
        }
    }


    public void userSignup(ActionEvent event)throws IOException{
        writingInFile();
    }
    private void writingInFile() throws IOException{
        FileWriter f = new FileWriter("database.txt", true);
        Formatter formatter =new Formatter(f);
        String tempUserName=userNameTextField.getText().toString();
        String tempUserPass=passwordField.getText().toString();
        if(tempUserName.isEmpty() && tempUserName.isEmpty()){
            LoginMessegeLebel.setText("please enter your data");
        }
        else{
            formatter.format("%s %s\n",tempUserName,tempUserPass);
        }

        formatter.close();
        try {
            Thread.sleep(1000);//time is in ms (1000 ms = 1 second)
        } catch (InterruptedException e) {e.printStackTrace();}

        Stage stage =(Stage)cancelButton.getScene().getWindow();
        stage.close();
    }

    public void cancelButtonOnAction(ActionEvent e){
        Stage stage =(Stage)cancelButton.getScene().getWindow();
        stage.close();
    }
}
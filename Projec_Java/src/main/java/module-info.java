module com.example.project_login {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.project_login to javafx.fxml;
    exports com.example.project_login;
}
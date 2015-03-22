/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aluno;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javax.management.Notification;

/**
 *
 * @author Andre
 */
public class CadastroAluno extends Application {
    
    
    
    @Override
    public void start(Stage primaryStage) {

        Button salvar = new Button("Salvar");

        
        Label nomelb  = new Label("Nome ");
        TextField nome = new TextField();
        
        Label ralb = new Label("Ra ");
        TextField ra = new TextField();
        
        Label sexo = new Label("Sexo");
        RadioButton masc = new RadioButton("Masculino");
        RadioButton fem =new RadioButton("Feminino");
        
        Label estadolb = new Label("Estado");
        final ComboBox estado = new ComboBox(FXCollections.observableArrayList("MS","SP","RJ","MG"));
        
        
        GridPane grid = new GridPane();
        
        grid.setHgap(5);
        grid.setVgap(10);
        grid.setPadding(new Insets(10,10,10,10));
        
        grid.addRow(0,nomelb,nome);
        
        grid.addRow(1,ralb,ra);
        
        grid.addRow(2,sexo,masc,fem);
        
        grid.addRow(3,estadolb,estado);
        
        
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("icone.jpg")));
        grid.addRow(4,salvar);
        
        
        Scene scene = new Scene(grid, 500, 350);
        
        
        salvar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                Aluno aluno = new Aluno();
                
                aluno.setNome(nome.getText());
                aluno.setRa(Integer.parseInt(ra.getText()));
                aluno.setSexo(sexo.getText());
                aluno.setEstado(estado.getValue().toString());
                      listagem(aluno);
            }
        });
        
        
        masc.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                 fem.setSelected(false);
            }
        });
        
        fem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                masc.setSelected(false);
            }
        });
        
        
             
        primaryStage.setTitle("Testanto!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

        public void listagem(Aluno aluno){
        
        Label nomelb = new Label("Nome : ");
        Label nome = new Label(aluno.getNome());
        
        Label ralb = new Label("Ra : ");
        Label ra = new Label(String.valueOf(aluno.getRa()));
        
        Label sxo = new Label("Sexo : ");
        Label sexo = new Label(aluno.getSexo());
        
        
        Label estadolb = new Label("Estado");
        Label estado = new Label(aluno.getEstado());
        
        GridPane root = new GridPane();
                
        root.addRow(0,nomelb,nome);
        root.addRow(1,ralb,ra);
        root.addRow(2,sxo,sexo);
        root.addRow(3,estadolb,estado);
        
        
        Stage alunos = new Stage();
        Scene cena = new Scene(root,600,550);
        alunos.setScene(cena);
        alunos.setTitle("Alunos cadastrado");
        alunos.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

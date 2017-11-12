package odonware.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import odonware.Odonware;

/**
 *  FXMLPrincipalController
 * @author Patrick Amaral
 * @since FXMLController criado em 31/05/2017
 */
public class FXMLPrincipalController implements Initializable {
    @FXML
    public StackPane stackPrincipal;
    @FXML
    private BorderPane rootLayout;
    @FXML
    private JFXButton btnAgendamentos;
    @FXML
    private JFXButton btnConsultorio;
    @FXML
    private JFXButton btnPacientes;
    @FXML
    private JFXButton btnServicos;
    @FXML
    private JFXButton btnUsuarios;
    @FXML
    private JFXButton btnSobre;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private JFXButton btnPagamentos;
    @FXML
    private JFXButton btnOrcamento;
    @FXML
    private JFXButton btnRelatorio;
    @FXML
    private JFXButton btnUser;
    @FXML
    private Label lblTitulo;
    
    public static String user;
    
     private StackPane usuarios, pacientes, servicos, agendamento, orcamento;
    @FXML
    private Label lblTitulo1;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnUser.setText(user);
        carregarTelas();
         
    }//fim do initialize    

    
     private void setNode(Node node) {
         
     //   anchorPane.getChildren().clear();
    //  anchorPane.getChildren().add((Node) node);
       rootLayout.setCenter(node);
    }//fim do setNode

     private void carregarTelas() {
        try {
            usuarios = FXMLLoader.load(getClass().getResource("fxml/FXMLBuscarUsuario.fxml"));
            pacientes = FXMLLoader.load(getClass().getResource("fxml/FXMLBuscarPaciente.fxml"));
            servicos = FXMLLoader.load(getClass().getResource("fxml/FXMLBuscaServicos.fxml"));
            agendamento = FXMLLoader.load(getClass().getResource("fxml/FXMLCalendario.fxml"));
            orcamento = FXMLLoader.load(getClass().getResource("fxml/FXMLBuscarOrcamento.fxml"));
            //tela default
          //  setNode(usuarios);
        } catch (IOException ex) {
            Logger.getLogger(Odonware.class.getName()).log(Level.SEVERE, null, ex);
        }//fim do catch

    }//fim do metodo carregarTelas
    @FXML
      private void gerenciarUsuarios(ActionEvent event) {
         setNode(usuarios);
         lblTitulo.setText("  Usuários");
    }//fim do metodo gerenciarUsuarios

    @FXML
    private void meusPacientes(ActionEvent event) {
         carregarTelas();
        setNode(pacientes);
         lblTitulo.setText("  Pacientes");
    }//fim do metodo meusPacientes

    @FXML
    private void servicos(ActionEvent event) {
        setNode(servicos);
         lblTitulo.setText("  Serviços");
    }//fim do metodo servicos
    
    @FXML
    private void agendamentos(ActionEvent event) {
        setNode(agendamento);
        lblTitulo.setText(" Agenda");
    }//fim do metodo agendamentos
    
    @FXML
    private void orcamentos(ActionEvent event) {
        setNode(orcamento);
        lblTitulo.setText(" Orçamento");
    }

    @FXML
    private void pagamentos(ActionEvent event) {
    }

    @FXML
    private void relatorios(ActionEvent event) {
    }
      
    public  void abrirCadastros(){
        
    }//fim do metodo   
    
}//fim da classe FXMLPrincipalController
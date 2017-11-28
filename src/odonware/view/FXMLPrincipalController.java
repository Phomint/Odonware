package odonware.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXRippler;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
    
     private StackPane usuarios, pacientes, servicos, agendamento, orcamento, consultorio, relatorios;
    @FXML
    
    private Label lblTitulo1;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnUser.setText(user);
         carregarTelas();
        setNode(agendamento);
        lblTitulo.setText(" Agenda");
        
        contruirPopUp();
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
            consultorio = FXMLLoader.load(getClass().getResource("fxml/FXMLBuscarConsultorio.fxml"));
            relatorios = FXMLLoader.load(getClass().getResource("fxml/FXMLRelatorios.fxml"));
            //tela default
          //  setNode(usuarios);
        } catch (IOException ex) {
            Logger.getLogger(Odonware.class.getName()).log(Level.SEVERE, null, ex);
        }//fim do catch

    }//fim do metodo carregarTelas
    @FXML
      private void gerenciarUsuarios(ActionEvent event) {
         carregarTelas();
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
        carregarTelas();
        setNode(servicos);
         lblTitulo.setText("  Serviços");
    }//fim do metodo servicos
    
    @FXML
    private void agendamentos(ActionEvent event) {
        carregarTelas();
        setNode(agendamento);
        lblTitulo.setText(" Agenda");
    }//fim do metodo agendamentos
    
    @FXML
    private void orcamentos(ActionEvent event) {
        carregarTelas();
        setNode(orcamento);
        lblTitulo.setText(" Orçamento");
    }

     @FXML
    private void consultorio(ActionEvent event) {
        carregarTelas();
        setNode(consultorio);
        lblTitulo.setText(" Consultório");
    }
    
    @FXML
    private void pagamentos(ActionEvent event) {
    }

    @FXML
    private void relatorios(ActionEvent event) {
        carregarTelas();
        setNode(relatorios);
        lblTitulo.setText(" Relatórios");
    }
      
    public  void abrirCadastros(){
        
    }//fim do metodo   
    private void contruirPopUp(){
        JFXButton btnLogout = new JFXButton("Usar outra conta");
       JFXButton btnClose = new JFXButton("Sair");
        
       btnLogout.setPadding(new Insets(20));
       btnClose.setPadding(new Insets(20));
       
        VBox vBox = new VBox(btnLogout, btnClose);
        JFXPopup popup = new JFXPopup();
        popup.setPopupContent(vBox);
        
     
    }

    @FXML
    private void mostrarPopup(MouseEvent event) {
    
     
        
       // fXPopup.show(anchorPane, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.LEFT, 10, 70);
   

    }

  
    
}//fim da classe FXMLPrincipalController
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odonware.view;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import odonware.model.Servico;
import odonware.model.dao.ServicoDAO;

/**
 * FXMLBuscaServicosController
 * @author Patrick Amaral
 * @since FXMLController criado em 10/07/2017
 */
public class FXMLBuscaServicosController implements Initializable {

    @FXML
    private StackPane stackPane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private JFXTextField txtBuscar;
    @FXML
    private TableView<Servico> tblServico;
    @FXML
    private Button fabCadastrarServico;
    
    private final ServicoDAO sDao = new ServicoDAO();
      
    private final List<Servico> listServico = sDao.readServicoOrdem();
    
    private final ObservableList<Servico> observableServico = FXCollections.observableArrayList();
    
    private List<Servico> listNomes;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       insereTableDentista();
    }    

    @FXML
    private void abrirCadastro(ActionEvent event) {
          System.out.println("FAB -> servicos");
            try {
           JFXDialogLayout cadastro = FXMLLoader.load(getClass().getResource("fxml/FXMLServico.fxml"));
           JFXDialog dialog = new JFXDialog(stackPane, cadastro, JFXDialog.DialogTransition.CENTER);
         
                 
           dialog.show();
                  
              } catch (Exception e) {
                  System.out.println("Erro"+e);
            }//fim do catch
    }//fim do metodo abrirCadastro
    
       private void insereTableDentista(){
     
        if (!observableServico.isEmpty()) {
            observableServico.clear();
        }//fim do if
        for(Servico servico: listServico){
            observableServico.add(servico);
        }//fim do for
        TableColumn<Servico, Integer>colCodigo = new TableColumn("Código");
        colCodigo.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getCodigo()).asObject());
        TableColumn<Servico, String>colServico = new TableColumn("Serviço");
        colServico.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));
       
        tblServico.getColumns().addAll(colCodigo, colServico);
        
       tblServico.setItems(observableServico);
    }//fim do insereDados

    @FXML
    
    /*private void pressed(KeyEvent event) {
        listNomes = sDao.buscarPorNome(txtBuscar.getText());
       tblServico.getColumns().clear();
       tblServico.getItems().clear();
        if (!observableServico.isEmpty()) {
            observableServico.clear();
        }//fim do if
        for(Servico servico: listNomes){
            observableServico.add(servico);
        }//fim do for
        TableColumn<Servico, Integer>colCodigo = new TableColumn("Código");
        colCodigo.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getCodigo()).asObject());
        TableColumn<Servico, String>colServico = new TableColumn("Serviço");
        colServico.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));
       
        tblServico.getColumns().addAll(colCodigo, colServico);
        
       tblServico.setItems(observableServico);
        
    } 
 */
    
}//fim do FXMLController

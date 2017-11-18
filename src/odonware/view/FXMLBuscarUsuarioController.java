package odonware.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXRadioButton;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import odonware.model.Dentista;
import odonware.model.dao.DentistaDAO;

/**
 * FXMLBuscarUsuarioController
 * @author Patrick Amaral
 * @since FXMLController criado em 10/08/2017
 */
public class FXMLBuscarUsuarioController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button fabCadastrarUsuario;
    @FXML
    private StackPane stackPane;
    @FXML
    private TableView<Dentista> tblUsuario;
    @FXML
    private JFXTextField txtBuscar;
    @FXML
    private JFXButton btnEditar;
    @FXML
    private ImageView btnExcluir;
    @FXML
    private JFXRadioButton rbDentista;
    @FXML
    private ToggleGroup tipoUsuario;
    @FXML
    private JFXRadioButton rbFuncionario;
    
    private final DentistaDAO dDao = new DentistaDAO();
      
    private final List<Dentista> listDentista = dDao.readDentistaOrdem();
    
    private List<Dentista> listNomes;
    
    private final ObservableList<Dentista> observableDentista = FXCollections.observableArrayList();
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      if(rbDentista.isSelected()){
          insereTableDentista();
      }else{
      //    insereTableFuncionario();
      }
      
    }    //fim do initialize

    @FXML
    private void abrirCadastro(ActionEvent event) {        
        System.out.println("FAB -> usuario");
            try {
           JFXDialogLayout cadastro = FXMLLoader.load(getClass().getResource("fxml/FXMLCadastrarUsuario.fxml"));
           JFXDialog dialog = new JFXDialog(stackPane, cadastro, JFXDialog.DialogTransition.CENTER);
         
           dialog.show();
                  
              } catch (Exception e) {
                  System.out.println("Erro"+e);
            }//fim do catch
    }//fim do metodo abrirCadastro
    
    
    private void insereTableDentista(){
     
        if (!observableDentista.isEmpty()) {
            observableDentista.clear();
        }//fim do if
        for(Dentista dentista: listDentista){
            observableDentista.add(dentista);
        }//fim do for
        TableColumn<Dentista, Integer>colCodigo = new TableColumn("Código");
        colCodigo.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getCodigo()).asObject());
        TableColumn<Dentista, String>colDentista = new TableColumn("Dentista");
        colDentista.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));
        TableColumn<Dentista, String>colUsuario = new TableColumn("Usuário");
        colUsuario.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getUsuario().getUsuario()));
        tblUsuario.getColumns().addAll(colCodigo, colDentista, colUsuario);
        
       tblUsuario.setItems(observableDentista);
    }//fim do insereDados

    @FXML
    private void editar(ActionEvent event) {
        
    }

    @FXML
    private void excluir(MouseEvent event) {
    }

    @FXML
    private void pressed(KeyEvent event) {
        listNomes = dDao.buscarPorNome(txtBuscar.getText());
       tblUsuario.getColumns().clear();
       tblUsuario.getItems().clear();
        if (!observableDentista.isEmpty()) {
            observableDentista.clear();
        }//fim do if
        for(Dentista dentistas: listNomes){
            observableDentista.add(dentistas);
        }//fim do for
        TableColumn<Dentista, Integer>colCodigo = new TableColumn("Código");
        colCodigo.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getCodigo()).asObject());
        TableColumn<Dentista, String>colDentista = new TableColumn("Dentista");
        colDentista.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));
        TableColumn<Dentista, String>colUsuario = new TableColumn("Usuário");
        colUsuario.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getUsuario().getUsuario()));
        
        tblUsuario.getColumns().addAll(colCodigo, colDentista, colUsuario);
       tblUsuario.setItems(observableDentista);
    }
}//fim do FXMLBuscarUsuarioController

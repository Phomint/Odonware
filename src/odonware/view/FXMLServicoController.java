package odonware.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import odonware.controller.ServicoController;
import odonware.model.Dentista;
import odonware.model.dao.DentistaDAO;

/**
 * FXMLController que gerencia a view de Serviços   
 * @author Patrick Amaral
 * @since FXMLController criado em 19/06/2017
 */
public class FXMLServicoController implements Initializable {

    @FXML
    private JFXDialogLayout conteudo;
    @FXML
    private StackPane stackPane;
    @FXML
    private AnchorPane anchorPrincipal;
    @FXML
    private JFXListView<HBox> listView;
    @FXML
    private JFXButton btnSalvar;
    @FXML
    private JFXButton btnCancelar;
    @FXML
    private JFXButton btnadicionar;
    @FXML
    private JFXTextField txtNomeServico;
    @FXML
    private JFXComboBox<Dentista> cbDentista;
    @FXML
    private JFXTextField txtValor;
    
    private DentistaDAO dDao = new DentistaDAO();
    
    private List<Dentista> dentistas = dDao.readDentistaOrdem();
    
    private ObservableList<Dentista> observableListDentistas = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for(Dentista dentista: dentistas){
                     observableListDentistas.add(dentista);
                   }//fim do for
       cbDentista.setItems(observableListDentistas);
        /* for (int i = 0; i < 1; i++) {
            try { 
                listView.getItems().add(construirHbox());
            } catch (Exception e) {
                System.out.println("Servico-> Erro"+e);
            }
        }//fim do for*/
    }//fim do initialize

    @FXML
    private void salvarView(ActionEvent event) {
         JFXSnackbar snack = new JFXSnackbar(stackPane);
        
        
      try {
     //Salvar no banco
        ServicoController.salvarServicoDentista(getTxtValor(),ServicoController.salvarServico(getTxtNomeServico()) , cbDentista.getSelectionModel().getSelectedItem());
            snack.show("                Salvo com Sucesso                ", 5000);
      
 
        }catch (Exception e) {
       snack.show("                Preencha os campos                ", 7000);
        }
    }//fim do salvarView

    @FXML
    private void cancelarCadastro(ActionEvent event) {
    }//fim do cancelarCadastro

    @FXML
    private void adicionarDentista(ActionEvent event) {
  //      listView.getItems().add(construirHbox());
    }
    /*private HBox construirHbox(){
         
        HBox hBox = new HBox();
        for (int i = 0; i < 10; i++) {      
        JFXTextField[] txt = new JFXTextField[i];
                txt[i].setPromptText("Valor");
                txt[i].getStylesheets().add("css/Style.css");
                txt[i].getStyleClass().add("textAreaComum");
        
                JFXComboBox<String> cbDentista = new JFXComboBox<>();
               
                cbDentista.setPromptText("Dentista");
                cbDentista.getStylesheets().add("css/Style.css");
                cbDentista.getStyleClass().add("textAreaComum");
                cbDentista.setEditable(true);
              
                  for(Dentista dentista: dentistas){
                     observableListDentistas.add(dentista.getNome());
                   }//fim do for
            cbDentista.setItems(observableListDentistas);
            
            hBox.getChildren().addAll(cbDentista, txt[i]);
            cbDentista.setPrefWidth(400);
           HBox.setMargin(cbDentista,new Insets(8,10,8,0));
           HBox.setMargin(txt[i],new Insets(8,0,8,10));
        }
           return hBox;
    }//fim do construirHbox*/

    public String getTxtNomeServico() {
        return txtNomeServico.getText();
    }

    public void setTxtNomeServico(String txtNomeServico) {
        this.txtNomeServico.setText(txtNomeServico);
    }

    public Float getTxtValor() {
        return Float.valueOf(txtValor.getText());
    }

    public void setTxtValor(JFXTextField txtValor) {
        this.txtValor.setText(txtValor.getText());
    }
    
}//fim do FXMLServicoController

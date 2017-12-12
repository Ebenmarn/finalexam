package pkgApp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

		
	private RetirementApp mainApp = null;
	
	@FXML
	private TextField txtYearsToWork;
    @FXML
    private TextField txtannualreturn;
    @FXML
    private TextField txtyearsretired;
    @FXML
    private TextField txtretiredreturn;
    @FXML
    private TextField txtrequiredincome;
    @FXML
    private TextField txtmonthlyssi;
    @FXML
    private Label lblerror;
    @FXML
    private Label lblneedtosave;
    @FXML
    private Label lblsaveeachmonth;
	

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear pressed");
	
		 txtYearsToWork.setText("");
	        txtannualreturn.setText("");
	        lblsaveeachmonth.setText(":_____");
	        txtyearsretired.setText("");
	        txtretiredreturn.setText("");
	        txtrequiredincome.setText("");
	        txtmonthlyssi.setText("");
	        lblneedtosave.setText(":____");
	        lblerror.setText("");
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		boolean Calculate = false;
	
		String YTW = txtYearsToWork.getText();
        String AR = txtannualreturn.getText();
        String YR = txtyearsretired.getText();
        String RR = txtretiredreturn.getText();
        String RI = txtrequiredincome.getText();
        String MSSI = txtmonthlyssi.getText();
        String Errortxt = null;
        
        
        if ((YTW == null)) {
        	Errortxt = Errortxt + " Years to Work Is Empty. ";
        }
        else if (YTW.matches("-?\\d+(\\.\\d+)?")){
			 Errortxt = Errortxt + " Years to Work Is not a valid  Numeric Entry. ";
		}
		if ((AR == null)) {
        	 Errortxt = Errortxt + " Annual Reurn Is Empty. ";
        }
		else if (AR.matches("-?\\d+(\\.\\d+)?")){
			 Errortxt = Errortxt + " Annual Return Is not a valid  Numeric Entry. ";
		}
			 else if ((Double.parseDouble(AR)<0)||(Double.parseDouble(AR)>20)) {
					Errortxt = Errortxt + " Annual Return in not Realistic";
			 
		}if ((YR == null)) {
        	 Errortxt = Errortxt + " Years Retired Is Empty. ";
        }
		else if (YR.matches("-?\\d+(\\.\\d+)?")){
			 Errortxt = Errortxt + " Years Retired Is not a valid  Numeric Entry. ";
		}
		if ((RR == null)) {
        	 Errortxt = Errortxt + " Retired Return Is Empty. ";
        }
		else if (RR.matches("-?\\d+(\\.\\d+)?")){
			 Errortxt = Errortxt + " Retired Return Is not a valid  Numeric Entry. ";
		
		}
		else if ((Double.parseDouble(RR)<0)||(Double.parseDouble(RR)>3)) {
			Errortxt= Errortxt + " Retired Return in not Realistic";
		}
		if ((RI == null)) {
        	 Errortxt = Errortxt + " Reuired Is Empty. ";
        }
		else if (RI.matches("-?\\d+(\\.\\d+)?")){
			Errortxt = Errortxt + " Required Income Is not a valid  Numeric Entry. ";
		}
		if ((MSSI == null)) {
        	 Errortxt = Errortxt + " Monthly SSI Is Empty. ";
        }
		else if (MSSI.matches("-?\\d+(\\.\\d+)?")){
			Errortxt = Errortxt + " Monthly SSI Is not a valid  Numeric Entry. ";
		}
			
		if (Errortxt.length()==0) {
			Calculate= true;
		}
		
		if (Calculate) {
			Retirement r = new Retirement(
					Integer.parseInt((YTW)),Double.parseDouble(AR), Integer.parseInt((YR)),
					Double.parseDouble(RR), Double.parseDouble(RI), Double.parseDouble(MSSI));
			lblneedtosave.setText("$" + Double.toString(r.TotalAmountSaved()));
			lblsaveeachmonth.setText("$" + Double.toString(r.AmountToSave()));
			
		}
		else {
			lblerror.setText(Errortxt);
		}
	
	}
}

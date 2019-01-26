package interfaceActiveObject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class MainViewController {
    @FXML
    ToggleGroup broadcastMethod;

    @FXML
    Label monitor1;

    @FXML
    Label monitor2;

    @FXML
    Label monitor3;

    @FXML
    Label monitor4;

    @FXML
    RadioButton atomicButton;

    @FXML
    RadioButton causalButton;

    @FXML
    RadioButton sequentialButton;

    public void initialize() {
        
        // listener to change broadcast method
        this.broadcastMethod.selectedToggleProperty().addListener(((observable, oldValue, newValue) -> {
            if (newValue == this.atomicButton) {
                // code...
            } else if (newValue == this.causalButton) {
                // code...
            } else if (newValue == this.sequentialButton) {
                // code...
            }
        }));
    }
}

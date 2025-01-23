package hr.algebra.java2.cartographers.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CartographyController {
    @FXML
    private TextField tfNum1901;
    @FXML
    private TextField tfNum1902;
    @FXML
    private TextField tfNum2001;
    @FXML
    private TextField tfNum2002;
    @FXML
    private TextField tfNum1903;

    private int lastNum = 0;
    private int sum = 0;

    public void initialize() {
        addNumericValidationListener(tfNum1901);
        addNumericValidationListener(tfNum1902);
        addNumericValidationListener(tfNum2001);
        addNumericValidationListener(tfNum2002);
    }

    private void addNumericValidationListener(TextField textField) {
        textField.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    String s = textField.getText();
                    char[] chs = s.toCharArray();
                    System.out.println("Length:" + oldValue.length() + "  " + newValue.length() + " " + s);
                    StringBuilder sb = new StringBuilder();
                    Boolean isNum = true;

                    for (char ch : chs) {
                        if (!(ch >= '0' && ch <= '9')) {
                            textField.setText(oldValue);
                            isNum = false;
                            break;
                        }
                        sb.append(ch);
                    }

                    if (isNum) {
                        lastNum = Integer.parseInt(sb.toString());
                        calculateTfNum1903();
                    }
                }
            });
        }

    private void calculateTfNum1903() {
        sum += Integer.parseInt(tfNum1901.getText());
        sum += Integer.parseInt(tfNum1902.getText());
        sum += Integer.parseInt(tfNum2001.getText());
        sum += Integer.parseInt(tfNum2002.getText());
        tfNum1903.setText(String.valueOf(sum));
        sum = 0;
    }
}


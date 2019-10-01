package sample;

import java.math.BigDecimal;
import java.text.NumberFormat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class Controller {
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent = NumberFormat.getPercentInstance();
    private BigDecimal tipPercentage = new BigDecimal(0.15);


    @FXML private Label priceLabel;
    @FXML private Label percentageLabel;
    @FXML private Label tipLabel;
    @FXML private Label totalLabel;
    @FXML private TextField priceTextField;
    @FXML private TextField tipTextField;
    @FXML private TextField totalTextField;
    @FXML private Slider percentageSlider;
    @FXML private Button calculateButton;


    @FXML
    public void click(ActionEvent actionEvent) {
        try {
            BigDecimal amount = new BigDecimal(priceTextField.getText());
            BigDecimal tip = amount.multiply(tipPercentage);
            BigDecimal total = amount.add(tip);

            tipTextField.setText(currency.format(tip));
            totalTextField.setText(currency.format(total));
        }
        catch (NumberFormatException ex) {
            priceTextField.setText("Enter the price");
            priceTextField.selectAll();
            priceTextField.requestFocus();
        }
    }
}
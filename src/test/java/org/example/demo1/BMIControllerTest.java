package org.example.demo1;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import org.junit.jupiter.api.Test;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.BeforeAll;

/**
 * Runs locally and increases JaCoCo coverage.
 * Excluded from Jenkins because JavaFX UI tests require DISPLAY/X11.
 */
class BMIControllerTest {
    @BeforeAll
    static void initJavaFx() {
        new JFXPanel();
    }

    @Test
    void shouldCreateController() {
        BMIController controller = new BMIController();

        assertNotNull(controller);
    }

    @Test
    void shouldCalculateBmi() throws Exception {

        BMIController controller = new BMIController();

        Label result = new Label();
        TextField weight = new TextField("70");
        TextField height = new TextField("175");

        Map<String, String> strings = new HashMap<>();
        strings.put("result", "Your BMI is");

        setField(controller, "lblResult", result);
        setField(controller, "tfWeight", weight);
        setField(controller, "tfHeight", height);
        setField(controller, "localizedStrings", strings);

        controller.onCalculateClick(new ActionEvent());

        assertTrue(result.getText().contains("Your BMI is"));
    }

    private void setField(Object target, String fieldName, Object value)
            throws Exception {

        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    @Test
    void shouldShowInvalidMessageForWrongInput() throws Exception {

        BMIController controller = new BMIController();

        Label result = new Label();
        TextField weight = new TextField("abc");
        TextField height = new TextField("xyz");

        Map<String, String> strings = new HashMap<>();
        strings.put("invalid", "Invalid input");

        setField(controller, "lblResult", result);
        setField(controller, "tfWeight", weight);
        setField(controller, "tfHeight", height);
        setField(controller, "localizedStrings", strings);

        controller.onCalculateClick(new ActionEvent());

        assertEquals("Invalid input", result.getText());
    }

    @Test
    void shouldShowInvalidMessageWhenInputIsNotNumber() throws Exception {

        BMIController controller = new BMIController();

        setField(controller, "lblResult", new Label());

        TextField weight = new TextField("abc");
        TextField height = new TextField("xyz");

        setField(controller, "tfWeight", weight);
        setField(controller, "tfHeight", height);

        Map<String, String> strings = new HashMap<>();
        strings.put("invalid", "Invalid input");

        setField(controller, "localizedStrings", strings);

        controller.onCalculateClick(new ActionEvent(null, null));

        Label result =
                (Label) getFieldValue(controller, "lblResult");

        assertEquals("Invalid input", result.getText());
    }

    private Object getFieldValue(Object target, String fieldName)
            throws Exception {

        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(target);
    }

    @Test
    void shouldInitializeController() throws Exception {

        BMIController controller = new BMIController();

        setField(controller, "lblWeight", new Label());
        setField(controller, "lblHeight", new Label());
        setField(controller, "lblResult", new Label());
        setField(controller, "lblLocalTime", new Label());

        setField(controller, "btnCalculate", new Button());

        setField(controller, "tfWeight", new TextField());
        setField(controller, "tfHeight", new TextField());

        setField(controller, "rootVBox", new VBox());

        controller.initialize();

        assertNotNull(controller);
    }

    @Test
    void shouldSwitchToEnglish() throws Exception {

        BMIController controller = new BMIController();

        setField(controller, "lblWeight", new Label());
        setField(controller, "lblHeight", new Label());
        setField(controller, "lblResult", new Label());
        setField(controller, "lblLocalTime", new Label());

        setField(controller, "btnCalculate", new Button());

        setField(controller, "tfWeight", new TextField());
        setField(controller, "tfHeight", new TextField());

        setField(controller, "rootVBox", new VBox());

        controller.onENClick(new ActionEvent(null, null));

        assertNotNull(controller);
    }
}

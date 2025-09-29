package Fabric;
import java.util.*;

public class Factory{


    interface Button {
        void draw();
    }
    interface Checkbox {
        void draw();
    }
    interface GUIFactory {
        Button createButton();
        Checkbox createCheckbox();
    }


    static class WinButton implements Button {
        public void draw() {
            System.out.println("Drawing Windows-style Button");
        }
    }
    static class MacButton implements Button {
        public void draw() {
            System.out.println("Drawing MacOS-style Button");
        }
    }
    static class WinCheckbox implements Checkbox {
        public void draw() {
            System.out.println("Drawing Windows-style Checkbox");
        }
    }

    static class MacCheckbox implements Checkbox {
        public void draw() {
            System.out.println("Drawing MacOS-style Checkbox");
        }
    }



    static class WinGUIFactory implements GUIFactory {
        public Button createButton() {
            return new WinButton();
        }
        public Checkbox createCheckbox() {
            return new WinCheckbox();
        }
    }


    static class MacGUIFactory implements GUIFactory {
        public Button createButton() {
            return new MacButton();
        }
        public Checkbox createCheckbox() {
            return new MacCheckbox();
        }
    }

//Клиент
    static class Application {
        private Button button;
        private Checkbox checkbox;
        public Application(GUIFactory factory) {
            button = factory.createButton();
            checkbox = factory.createCheckbox();
        }
        public void paint() {
            button.draw();
            checkbox.draw();
        }
    }


    public static void main(String[] args) {
        Application winApp = new Application(new WinGUIFactory());
        winApp.paint();
        Application macApp = new Application(new MacGUIFactory());
        macApp.paint();
    }
}

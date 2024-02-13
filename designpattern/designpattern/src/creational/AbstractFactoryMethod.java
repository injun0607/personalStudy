package creational;

public class AbstractFactoryMethod {

    public static void main(String[] args) {

        GUIFactory factory = new WinFactory();
        Application application = new Application(factory);

        application.operation();

        GUIFactory factory2 = new MacFactory();
        Application application2 = new Application(factory2);

        application2.operation();

    }
}

class Application {

    private AbsButton button;
    private AbsCheckBox checkBox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkBox = factory.createCheckBox();
    }

    public void operation() {
        button.paint();
        checkBox.checkBox();
    }

}

interface GUIFactory{
    AbsButton createButton();

    AbsCheckBox createCheckBox();

}

class WinFactory implements GUIFactory {

    @Override
    public AbsButton createButton() {
        return new WinButton();
    }

    @Override
    public AbsCheckBox createCheckBox() {
        return new WinCheckBox();
    }
}

class MacFactory implements GUIFactory {


    @Override
    public AbsButton createButton() {
        return new MacButton();
    }

    @Override
    public AbsCheckBox createCheckBox() {
        return new MacCheckBox();
    }
}

interface AbsButton{
    void paint();
}

class WinButton implements AbsButton {

    @Override
    public void paint() {
        System.out.println("윈도우 버튼 체크");
    }
}

class MacButton implements AbsButton {

    @Override
    public void paint() {
        System.out.println("맥 버튼 체크");
    }
}

interface AbsCheckBox{
    void checkBox();
}


class WinCheckBox implements AbsCheckBox {

    @Override
    public void checkBox() {
        System.out.println("윈도우 체크박스");
    }
}


class MacCheckBox implements AbsCheckBox {

    @Override
    public void checkBox() {
        System.out.println("맥 체크박스 ");
    }
}







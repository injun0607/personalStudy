package creational;


abstract class Logistics{

    abstract Transport transport();


    public void operation() {
        Transport transport = transport();
        transport.deliver();
    }
}


class RoadLogistics extends Logistics {
    @Override
    Transport transport() {
        return new Truck();
    }

}

class SeaLogistics extends Logistics{

    @Override
    Transport transport() {
        return new Ship();
    }
}


interface Transport{
    public void deliver();
}

class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("땅에서 운전");
    }
}

class Ship implements Transport {

    @Override
    public void deliver() {
        System.out.println("하늘에서 운전");
    }
}



interface Button{
    public void click();

    public void render();
}

class LinuxButton implements Button {

    @Override
    public void click() {
        System.out.println("리눅스 클릭");
    }

    @Override
    public void render() {
        System.out.println("리눅스 렌더");
    }
}

class WindowsButton implements Button {

    @Override
    public void click() {
        System.out.println("윈도우 클릭");
    }

    @Override
    public void render() {
        System.out.println("윈도우 렌더");
    }
}

abstract class Dialog {

    Button button = null;
    abstract Button createButton();

    public void click() {
        if (button == null) {
            button = createButton();
        }
        button.click();
    }

    public void render() {
        if (button == null) {
            button = createButton();
        }

        button.render();

    }
}

class WindDialog extends Dialog {

    @Override
    Button createButton() {
        return new WindowsButton();
    }
}


class LinuxDialog extends Dialog {

    @Override
    Button createButton() {
        return new LinuxButton();
    }
}

public class FactoryMethod {

    public static void main(String[] args) {

        LinuxDialog linuxDialog = new LinuxDialog();
        WindDialog windDialog = new WindDialog();

        linuxDialog.click();
        linuxDialog.render();

        windDialog.click();
        windDialog.render();


    }

}

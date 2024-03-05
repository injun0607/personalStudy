package creational.builder;

public class BuilderMain {

    public static void main(String[] args) {
        Director director = new Director();


        CarBuilder carBuilder = new CarBuilder();
        director.constructCityCar(carBuilder);
        Car car = carBuilder.getCar();


        CarManualBuilder manualBuilder = new CarManualBuilder();
        director.constructSUV(manualBuilder);

        Manual result = manualBuilder.getResult();


    }
}

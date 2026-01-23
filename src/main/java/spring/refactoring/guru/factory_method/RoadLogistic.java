package spring.refactoring.guru.factory_method;

public class RoadLogistic extends Logistics{
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}

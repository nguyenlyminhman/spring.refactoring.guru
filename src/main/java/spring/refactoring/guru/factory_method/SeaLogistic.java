package spring.refactoring.guru.factory_method;

public class SeaLogistic extends Logistics{
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}

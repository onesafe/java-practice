package designpatten.creator.builder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class AirShip {
    private OrbitalModule orbitalModule;
    private Engine engine;
    private EscapeTower escapeTower;

    public void launch() {
        System.out.println("发射！！！");
    }
}

@Data
@AllArgsConstructor
class OrbitalModule {
    private String name;
}

@Data
@AllArgsConstructor
class Engine {
    private String name;
}

@Data
@AllArgsConstructor
class EscapeTower {
    private String name;
}
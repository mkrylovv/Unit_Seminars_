package hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class VehicleTest {

    private Car car;
    private Motorcycle motorcycle;
    @BeforeEach
    void setup() {
        car = new Car("Mazda", "CX-5", 2023);
        motorcycle = new Motorcycle("BMW", "F 850 GS", 2023);
    }

    // Проверить, что экземпляр объекта Car также является экземпляром транспортного средства (используя оператор instanceof).
    @Test
    void carInstanceOfVehicle() {
        assertInstanceOf(Vehicle.class, car);
    }

    // Проверить, что объект Car создается с 4-мя колесами.
    @Test
    void carHasFourWheels() {
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    // Проверить, что объект Motorcycle создается с 2-мя колесами.
    @Test
    void motorcycleHasFourWheels() {
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    // Проверить, что объект Car развивает скорость 60 в режиме тестового вождения (используя метод testDrive()).
    @Test
    void carSpeedIs60AtTestDrive() {
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    // Проверить, что объект Motorcycle развивает скорость 75 в режиме тестового вождения (используя метод testDrive()).
    @Test
    void motorcycleSpeedIs75AtTestDrive() {
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    // Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта) машина останавливается (speed = 0).
    @Test
    void carSpeedIs0AtPark() {
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    // Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта) мотоцикл останавливается (speed = 0).
    @Test
    void motorcycleSpeedIs0AtPark() {
        motorcycle.testDrive();
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }
}
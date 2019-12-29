import java.awt.Graphics;
import graphics.Assets;
import entities.*;

public class GameState extends State {

    private Car car;
    private Customer customer;

    public GameState(Game game) {
        super(game);
        car = new Car(100, 100);
        customer = new Customer(300, 300);
    }

    @Override
    public void update() {
        car.update();
    }

    @Override
    public void render(Graphics graphics) {
        car.render(graphics);
        customer.render(graphics);
    }

}
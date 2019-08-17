package designpatten.state;

/**
 * 预定状态
 */
public class BookedState implements State {
    @Override
    public void handle() {
        System.out.println("房间已被预定，等待入住。");
    }
}

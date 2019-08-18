package designpatten.actor.observer2;


import java.util.Observable;
import java.util.Observer;

/**
 * 这里如果使用@Data lombok的话，new 出来的ObserverA 都是同一个对象， 坑啊
 *
 * 需要注意，使用@Data的时候。如果创建出来的对象需要是不同的。则必须重写Hashcode方法
 */
public class ObserverA implements Observer {

    private int myState;

    @Override
    public void update(Observable o, Object arg) {
        myState = ((ConcreteSubject)o).getState();
    }

    public int getMyState() {
        return myState;
    }

    public void setMyState(int s) {
        myState = s;
    }
}

package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

    private static int counter = 0;

    public SingletonBean() {
        System.out.println("Creating SINGLETON BEAN #" + ++counter);
    }

    public void getMyScope() {
        System.out.println("SINGLETON #: " + counter);
    }

}

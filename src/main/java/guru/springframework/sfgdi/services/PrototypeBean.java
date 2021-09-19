package guru.springframework.sfgdi.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeBean {

    private static int counter = 0;

    public PrototypeBean() {
        System.out.println("Creating PROTOTYPE BEAN #" + ++counter);
    }

    public void getMyScope() {
        System.out.println("PROTOTYPE #: " + counter);
    }
}

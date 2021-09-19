package guru.springframework.sfgdi.controllers;

import guru.springframework.pets.PetService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by jt on 12/28/19.
 */
@Controller
public class PetController implements InitializingBean, DisposableBean {

    private final PetService petService;

    public PetController(@Qualifier("petService") PetService petService) {
        this.petService = petService;
    }

    public String whichPetIsTheBest() {
        return petService.getPetType();
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Post Construct method");
    }

    @PreDestroy
    public void preDestroyed() {
        System.out.println("Pre Destroyed method");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("After properties set triggered");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean getting destroyed");
    }
}

package guru.springframework.sfgdi.config;

import guru.springframework.pets.BasePetServiceFactory;
import guru.springframework.pets.PetService;
import guru.springframework.pets.PetServiceFactory;
import guru.springframework.sfgdi.datasource.FakeDataSource;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;


//@ImportResource("classpath:sfgdi-config.xml")
//@PropertySource("classpath:datasource.properties")
@EnableConfigurationProperties({SfgConstructorConfig.class})
@Configuration
public class GreetingServiceConfig {

//    @Bean
//    FakeDataSource fakeDataSource(@Value("${guru.username}") String username,
//                                  @Value("${guru.password}") String password,
//                                  @Value("${guru.jdbcURL}") String jdbcURL) {
//        FakeDataSource fakeDataSource = new FakeDataSource();
//        fakeDataSource.setUsername(username);
//        fakeDataSource.setPassword(password);
//        fakeDataSource.setJdbcURL(jdbcURL);
//        return fakeDataSource;
//    }

//    @Bean
//    FakeDataSource fakeDataSource(SfgConfiguration sfgConfiguration) {
//        FakeDataSource fakeDataSource = new FakeDataSource();
//        fakeDataSource.setUsername(sfgConfiguration.getUsername());
//        fakeDataSource.setPassword(sfgConfiguration.getPassword());
//        fakeDataSource.setJdbcURL(sfgConfiguration.getJdbcURL());
//        return fakeDataSource;
//    }

    @Bean
    FakeDataSource fakeDataSource(SfgConstructorConfig sfgConstructorConfig) {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(sfgConstructorConfig.getUsername());
        fakeDataSource.setPassword(sfgConstructorConfig.getPassword());
        fakeDataSource.setJdbcURL(sfgConstructorConfig.getJdbcURL());
        return fakeDataSource;
    }

    @Bean
    BasePetServiceFactory basePetServiceFactory() {
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean("petService")
    PetService dogPetService(BasePetServiceFactory basePetServiceFactory) {
        return basePetServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean("petService")
    PetService catPetService(BasePetServiceFactory basePetServiceFactory) {
        return basePetServiceFactory.getPetService("cat");
    }

    @Profile({"ES"})
    @Bean("i18nService")
    I18NSpanishService i18NSpanishService() {
        return new I18NSpanishService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile({"EN", "default"})
    @Bean("i18nService")
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

    @Bean
    ConstructorGreetingService constructorGreetingService() {
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService() {
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService() {
        return new SetterInjectedGreetingService();
    }
}

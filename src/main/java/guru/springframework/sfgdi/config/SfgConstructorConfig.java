package guru.springframework.sfgdi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("guru")
public class SfgConstructorConfig {

    private final String username;
    private final String password;
    private final String jdbcURL;

    public SfgConstructorConfig(String username, String password, String jdbcURL) {
        this.username = username;
        this.password = password;
        this.jdbcURL = jdbcURL;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getJdbcURL() {
        return jdbcURL;
    }
}

package TronGame.Tron.Configurations;

import org.springframework.boot.web.server.MimeMappings;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;


public class WebConfigurer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    //This implements MIME mapping for the manifest file
    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        factory.setPort(8080);
        factory.setContextPath("");
        MimeMappings mappings = new MimeMappings(MimeMappings.DEFAULT);
        mappings.add("appcache", "text/cache-manifest");
        factory.setMimeMappings(mappings);
    }


}
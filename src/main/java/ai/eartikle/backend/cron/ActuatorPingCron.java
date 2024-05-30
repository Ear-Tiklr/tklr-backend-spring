package ai.eartikle.backend.cron;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class ActuatorPingCron {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${deployment.endpoint}")
    private String url;

    @Scheduled(fixedRate = 60000)
    public void pingActuator() {
        try {
            String response = restTemplate.getForObject(url + "/actuator/health", String.class);
            log.info("Actuator endpoint hit successfully: {}", response);
        } catch (Exception e) {
            log.error("Error hitting actuator endpoint: {}" , e.getMessage());
        }
    }
}

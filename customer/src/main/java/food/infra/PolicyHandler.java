package food.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import food.config.kafka.KafkaProcessor;
import food.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookFinished'"
    )
    public void wheneverCookFinished_Updatestatus(
        @Payload CookFinished cookFinished
    ) {
        CookFinished event = cookFinished;
        System.out.println(
            "\n\n##### listener Updatestatus : " + cookFinished + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ConformDelivery'"
    )
    public void wheneverConformDelivery_Updatestatus(
        @Payload ConformDelivery conformDelivery
    ) {
        ConformDelivery event = conformDelivery;
        System.out.println(
            "\n\n##### listener Updatestatus : " + conformDelivery + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FoodPicked'"
    )
    public void wheneverFoodPicked_Updatestatus(
        @Payload FoodPicked foodPicked
    ) {
        FoodPicked event = foodPicked;
        System.out.println(
            "\n\n##### listener Updatestatus : " + foodPicked + "\n\n"
        );
        // Sample Logic //

    }
}

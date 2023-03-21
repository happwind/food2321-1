package food.domain;

import food.RiderApplication;
import food.domain.ConformDelivery;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Delivery_table")
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderid;

    private String address;

    private String status;

    @PostPersist
    public void onPostPersist() {
        ConformDelivery conformDelivery = new ConformDelivery(this);
        conformDelivery.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = RiderApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    public void pickFood(PickFoodCommand pickFoodCommand) {
        FoodPicked foodPicked = new FoodPicked(this);
        foodPicked.publishAfterCommit();
    }
}

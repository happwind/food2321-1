package food.domain;

import food.StoreApplication;
import food.domain.Accept;
import food.domain.CookFinished;
import food.domain.CookStartd;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Cooking_table")
@Data
public class Cooking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderid;

    private String status;

    @PostPersist
    public void onPostPersist() {
        Accept accept = new Accept(this);
        accept.publishAfterCommit();

        CookStartd cookStartd = new CookStartd(this);
        cookStartd.publishAfterCommit();

        CookFinished cookFinished = new CookFinished(this);
        cookFinished.publishAfterCommit();
    }

    public static CookingRepository repository() {
        CookingRepository cookingRepository = StoreApplication.applicationContext.getBean(
            CookingRepository.class
        );
        return cookingRepository;
    }

    public void acceptorreject(AcceptorrejectCommand acceptorrejectCommand) {
        Reject reject = new Reject(this);
        reject.publishAfterCommit();
    }

    public static void foodOrderInfo(OrderPlaced orderPlaced) {
        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);


         });
        */

    }
}

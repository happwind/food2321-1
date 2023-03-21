package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Reject extends AbstractEvent {

    private Long id;

    public Reject(Cooking aggregate) {
        super(aggregate);
    }

    public Reject() {
        super();
    }
}

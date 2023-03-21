package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderCancel extends AbstractEvent {

    private Long id;

    public OrderCancel(Order aggregate) {
        super(aggregate);
    }

    public OrderCancel() {
        super();
    }
}

package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Accept extends AbstractEvent {

    private Long id;

    public Accept(Cooking aggregate) {
        super(aggregate);
    }

    public Accept() {
        super();
    }
}

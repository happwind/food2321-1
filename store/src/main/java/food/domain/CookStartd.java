package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookStartd extends AbstractEvent {

    private Long id;

    public CookStartd(Cooking aggregate) {
        super(aggregate);
    }

    public CookStartd() {
        super();
    }
}
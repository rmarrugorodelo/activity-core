package com.rmarrugo.test.domain.common;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class PageAsk {
    Integer page;
    Integer size;
}

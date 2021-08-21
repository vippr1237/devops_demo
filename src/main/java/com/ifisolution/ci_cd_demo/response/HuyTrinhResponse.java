package com.ifisolution.ci_cd_demo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HuyTrinhResponse {
    private String name;
    private int age;
    private boolean single;
}

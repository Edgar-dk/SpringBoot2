package com.sias.boot.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Edgar
 * @create 2022-02-25 21:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    private String name;
    private Double weight;
}

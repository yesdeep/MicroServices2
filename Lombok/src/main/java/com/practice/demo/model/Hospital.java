package com.practice.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Hospital {

    private Long id;     // Keep this as Long if you expect large IDs, or change to int if needed
    private String name;
}

package com.mayuran19.datasourceconfig.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "some_table")
@Getter
@Setter
public class SomeTable {
    @Id
    private Long id;
    private String someText;
}

package com.gzj.springdata.bean;

import javafx.beans.binding.IntegerExpression;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "dept")
@AllArgsConstructor
@NoArgsConstructor
public class Dept implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deptno;
    @Column(length = 32)
    private String dname;

}

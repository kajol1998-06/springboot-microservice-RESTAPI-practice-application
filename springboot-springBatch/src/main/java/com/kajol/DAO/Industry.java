package com.kajol.DAO;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Industry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_ind;
	private Integer year_ind;
    private Character code_ind;
    private String name_ind;
    private String size_ind;
    private String veriable_ind;
    private Integer value_ind;
    private String unit_ind;

}

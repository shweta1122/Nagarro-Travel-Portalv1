package com.nagarro.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javassist.bytecode.ByteArray;
import lombok.Data;

@Data
@Entity
@Table(name = "adminticketdetail")
public class AdminTicket {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    Long adminId;

    @Column
   Long employeeId;

    @Column
    Long ticketId;
    
    @Column(length = 200) 
    private String comments;

    @Column
    private byte[] pdf;


    
}
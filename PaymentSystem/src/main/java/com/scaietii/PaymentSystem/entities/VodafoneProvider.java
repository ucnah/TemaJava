package com.scaietii.PaymentSystem.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("VodafoneProvider")
public class VodafoneProvider extends Provider{
	
}

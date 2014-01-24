package com.bedrosians.bedlogic.domain.account;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicUpdate;


@XmlRootElement(name="simplifiedAccount")
@Entity(name="simplifiedAccount")
@DynamicUpdate
@Table(name = "arm")
public class SimplifiedAccount extends Account {

	public SimplifiedAccount(){}
}

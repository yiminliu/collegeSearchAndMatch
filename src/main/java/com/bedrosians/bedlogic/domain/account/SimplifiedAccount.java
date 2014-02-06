package com.bedrosians.bedlogic.domain.account;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;


//@XmlRootElement(name="simplifiedAccount")
@Entity
@DynamicUpdate(value=true)
@SelectBeforeUpdate(value=true)
@DynamicInsert(value=true)
@Table(name = "arm")
public class SimplifiedAccount extends Account {

	public SimplifiedAccount(){}
}

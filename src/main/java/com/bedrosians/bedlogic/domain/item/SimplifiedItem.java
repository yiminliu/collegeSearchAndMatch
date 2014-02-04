package com.bedrosians.bedlogic.domain.item;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;


@Entity(name="simplifiedItem")
@DynamicUpdate(value=true)
@SelectBeforeUpdate(value=true)
@Table(name = "ims")
public class SimplifiedItem extends Item {

	public SimplifiedItem(){}
}

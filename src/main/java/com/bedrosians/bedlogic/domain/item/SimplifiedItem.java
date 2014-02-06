package com.bedrosians.bedlogic.domain.item;


import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;


@Entity(name="simplifiedItem")
@DynamicUpdate(value=true)
@SelectBeforeUpdate(value=true)
@Table(name = "ims")
public class SimplifiedItem extends Item {
	private static final long serialVersionUID = 674944990758703330L;
	public SimplifiedItem(){}
}

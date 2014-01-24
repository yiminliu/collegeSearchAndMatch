package com.bedrosians.bedlogic.domain.account;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.AttributeOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.bedrosians.bedlogic.util.ActivityStatus;
import com.bedrosians.bedlogic.util.FormatUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;



@Entity(name="simplifiedAccountBranch")
@Table(name="armbr")
public class SimplifiedAccountBranch extends AccountBranch implements Serializable {
	public SimplifiedAccountBranch(){}
}

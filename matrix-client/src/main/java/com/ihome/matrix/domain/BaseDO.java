package com.ihome.matrix.domain;

import java.io.Serializable;
import java.util.Date;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.solr.client.solrj.beans.Field;

import com.iacrqq.util.DateUtil;
import com.ihome.matrix.model.JSONResultModel;
import com.ihome.matrix.model.JSONResultModel.JSONDateValueProcessor;

public class BaseDO implements Serializable {
	
	@Field
	protected String docId;
	@Field
	protected Long 	id;
	protected Boolean isDeleted;
	protected Date	gmtCreate;
	@Field
	protected Date	gmtModified;
	
	static {
		String[] dateFormats = new String[] {DateUtil.DEFAULT_DATE_FORMAT}; 
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));
	}
	
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.docId = String.valueOf(id);
		this.id = id;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public Date getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	public String toJSON() {
		return JSONObject.fromObject(this, JSONResultModel.DEFUALT_JSON_CONFIG).toString();
	}  
}
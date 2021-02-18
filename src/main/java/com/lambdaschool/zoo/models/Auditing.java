package com.lambdaschool.zoo.models;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

public abstract class Auditing{
@CreatedBy
    protected String createdby;
@CreatedDate
    protected Date createddate;
@LastModifiedBy
    protected String lastmodifiedby;
@LastModifiedDate
    protected Date lastmodifieddate;
}


package com.gst.code.generator.entity;

import lombok.Data;

import javax.persistence.Table;
import java.util.Date;

@Table(name = "WORKER_NODE")
@Data
public class WorkerNode {
    private int id;
    private String hostName;
    private String port;
    private int type;
    private Date launchDate;
    private Date modified;
    private Date created;
}

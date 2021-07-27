package com.ys.mybatis.pojo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@Entity
@Table(name = "cloud_network")
@Where(clause = "status not in('delete', 'hidden')")
public class CloudNetwork {
    @Id
    @GenericGenerator(name="idGenerator",strategy="com.cloud.mcp.database.mariadb.util.UniinUUIDGenerator")
    @GeneratedValue(generator="idGenerator")
    @Column(name = "id")
    private String id; //id

    @Basic
    @Column(name = "order_id")
    private String orderId; //订单id

    @Basic
    @Column(name = "brand_id")
    private String brandId; //品牌id

    @Basic
    @Column(name = "pool_id")
    private String poolId; //资源池id

    @Basic
    @Column(name = "area_id")
    private String areaId;  //区域id

    @Basic
    @Column(name = "available_area_id")
    private String availableAreaId; //可用区id

    @Basic
    @Column(name = "order_json")
    private String orderJson;  //订单内容（订单json，可存储订单相关信息，字段个数不限）

    @Basic
    @Column(name = "tenant_id")
    private String tenantId;   //租户id

    @Basic
    @Column(name = "tenant_json")
    private String tenantJson;   //租户内容（租户信息，包含，租户id，租户名称，部门、组织机构，区域）

    @Basic
    @Column(name = "resource_base_json")
    private String resourceBaseJson;  //资源基础内容（资源基础信息，例如：品牌、资源池、区域、可用区、产品编码）

    @Basic
    @Column(name = "virtualization_type")
    private String virtualizationType;  //虚拟化类型，私有云、公有云

    @Basic
    @Column(name = "virtualization_version")
    private String virtualizationVersion;  //虚拟化版本

    @Basic
    @Column(name = "network_type")
    private String networkType;  //网络类型，子网、路由器、网卡、安全组、公网ip（浮动ip）、负载均衡、防火墙

    @Basic
    @Column(name = "status")
    private String status;  //状态

    @Basic
    @Column(name = "resource_uuid")
    private String resourceUuid;  //资源ID

    @Basic
    @Column(name = "resource_name")
    private String resourceName;  //资源ID

    @Basic
    @Column(name = "resource_value")
    private String resourceValue;  //资源内容

    @Basic
    @Column(name = "resource_type")
    private String resourceType;  //资源类型

    @Basic
    @Column(name = "begin_time")
    private Timestamp begintime;  //开始时间

    @Basic
    @Column(name = "end_time")
    private Timestamp endtime;  //结束时间

    @Basic
    @Column(name = "createtime")
    private Timestamp createtime;  //创建时间

    @Basic
    @Column(name = "operation_type")
    private String operationType;  //操作类型
}

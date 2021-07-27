package com.ys.mybatis.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "cloud_area")
public class CloudArea {
    private String id;//
    private String brandId;//品牌id
    private String poolId;//资源池id
    private String projectId;//项目id，cmdb 自己数据库表（cloud_project）id
    private String areaId;//区域id，底层虚拟化中的区域ID
    private String name;//名称
    private String coding;//编码
    private Integer sequence;//序列
    private String describe;//描述（text）
    private String connectionInformation;//连接信息，既是账号密码,json数据存储{ }（longtext）
    private String version;//版本号 例如 v6.5
    private String url;//url连接地址，就就填上，没有就不用填写，显示（无）（text）
    private String areaType;//区域类型
    private String status;//状态 （available 可用、forbid 禁止、delete 删除、abnormal 异常）
    private String synchronousType;//同步类型 （create 自创建、synchronous 自同步、manual_synchronous 手动同步）
    private String custom;//自定义新增的（longtext）
    private Timestamp createtime;//创建时间
    private String operationType;//操作类型
    private String resourceValue;//资源内容

    @Id
    @GenericGenerator(name="idGenerator",strategy="com.cloud.mcp.database.mariadb.util.UniinUUIDGenerator")
    @GeneratedValue(generator="idGenerator")
    @Column(name = "id",length = 50)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "brand_id")
    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    @Basic
    @Column(name = "pool_id")
    public String getPoolId() {
        return poolId;
    }

    public void setPoolId(String poolId) {
        this.poolId = poolId;
    }

    @Basic
    @Column(name = "project_id")
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column(name = "area_id")
    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "coding")
    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }

    @Basic
    @Column(name = "sequence")
    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    @Basic
    @Column(name = "_describe")
    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Basic
    @Column(name = "connection_information")
    public String getConnectionInformation() {
        return connectionInformation;
    }

    public void setConnectionInformation(String connectionInformation) {
        this.connectionInformation = connectionInformation;
    }

    @Basic
    @Column(name = "version")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "area_type")
    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "synchronous_type")
    public String getSynchronousType() {
        return synchronousType;
    }

    public void setSynchronousType(String synchronousType) {
        this.synchronousType = synchronousType;
    }

    @Basic
    @Column(name = "custom")
    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }

    @Basic
    @Column(name = "createtime")
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Basic
    @Column(name = "operation_type")
    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    @Basic
    @Column(name = "resource_value")
    public String getResourceValue() {
        return resourceValue;
    }

    public void setResourceValue(String resourceValue) {
        this.resourceValue = resourceValue;
    }
}

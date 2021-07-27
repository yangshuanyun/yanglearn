package com.ys.mybatis.pojo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Where(clause = "status not in('delete', 'hidden')")
@Table(name = "cloud_account")
public class CloudAccount {

    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    @Column(name = "id",length = 50)
    private String id;//

    @Basic
    @Column(name = "brand_id")
    private String brandId;//品牌id

    @Basic
    @Column(name = "account")
    private String account;//账号

    @Basic
    @Column(name = "pwd")
    private String pwd;//密码

    @Basic
    @Column(name = "name")
    private String name;//名称

    @Basic
    @Column(name = "coding")
    private String coding;//编码
    @Basic
    @Column(name = "sequence")
    private Integer sequence;//序列

    @Basic
    @Column(name = "_describe")
    private String describe;//描述（text）


    @Basic
    @Column(name = "create_account_type")
    private String createAccountType;//创建者类型 管理员、用户

    @Basic
    @Column(name = "version")
    private String version;//版本号 例如 v6.5

    @Basic
    @Column(name = "create_user_id")
    private String createUserId;//创建者

    @Basic
    @Column(name = "account_source")
    private String accountSource;//资源来源，枚举，platform 平台、pool 资源池，cloud_account 云账号、tenant 租户

    @Basic
    @Column(name = "resource_id")
    private String resourceId;//资源id，根据账号来源来存储不同的资源id

    @Basic
    @Column(name = "attribution_user_id")
    private String attributionUserId;//归属用户

    @Basic
    @Column(name = "status")
    private String status;//状态 （available 可用、forbid 禁止、delete 删除、abnormal 异常）

    @Basic
    @Column(name = "custom")
    private String custom;//自定义新增的（longtext）

    @Basic
    @Column(name = "createtime")
    private Timestamp createtime;//创建时间

    @Basic
    @Column(name = "updatetime")
    private Timestamp updatetime;//更新时间

}

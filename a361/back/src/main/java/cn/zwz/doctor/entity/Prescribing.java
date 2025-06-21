package cn.zwz.doctor.entity;

import cn.zwz.basics.baseClass.ZwzBaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * 开处方 实体类
 * @author 
 * 
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "a_prescribing")
@TableName("a_prescribing")
@ApiModel(value = "开处方")
public class Prescribing extends ZwzBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "接诊人")
    private String title;

    @ApiModelProperty(value = "处方记录")
    private String content1;

    @ApiModelProperty(value = "药品")
    private String drug;

    @ApiModelProperty(value = "附图")
    private String image;

    @ApiModelProperty(value = "特殊说明")
    private String content2;
}
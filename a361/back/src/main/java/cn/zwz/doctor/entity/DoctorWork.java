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
 * 接诊 实体类
 * @author 
 * 
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "a_doctor_work")
@TableName("a_doctor_work")
@ApiModel(value = "接诊")
public class DoctorWork extends ZwzBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "接诊人")
    private String title;

    @ApiModelProperty(value = "接诊记录")
    private String content1;

    @ApiModelProperty(value = "附图")
    private String image;

    @ApiModelProperty(value = "结论意见")
    private String content2;
}
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
 * 药品 实体类
 * @author 
 * 
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "a_drug")
@TableName("a_drug")
@ApiModel(value = "药品")
public class Drug extends ZwzBaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "药品名称")
    private String title;

    @ApiModelProperty(value = "药品介绍")
    private String content;
}
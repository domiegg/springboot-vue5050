package cn.zwz.basics.parameter;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

/**
 * @author
 *
 */
@ApiOperation(value = "系统基础常量")
public interface CommonConstant {

    @ApiModelProperty(value = "正常")
    Integer USER_STATUS_NORMAL = 0;

    @ApiModelProperty(value = "禁用")
    Integer USER_STATUS_LOCK = -1;

    @ApiModelProperty(value = "顶级菜单")
    Integer PERMISSION_NAV = -1;

    @ApiModelProperty(value = "普通菜单")
    Integer PERMISSION_PAGE = 0;

    @ApiModelProperty(value = "按钮菜单")
    Integer PERMISSION_OPERATION = 1;

    @ApiModelProperty(value = "顶级菜单")
    Integer LEVEL_ZERO = 0;

    @ApiModelProperty(value = "1级菜单")
    Integer LEVEL_ONE = 1;

    @ApiModelProperty(value = "2级菜单")
    Integer LEVEL_TWO = 2;

    @ApiModelProperty(value = "3级菜单")
    Integer LEVEL_THREE = 3;

    @ApiModelProperty(value = "总部门ID")
    String PARENT_ID = "0";

    @ApiModelProperty(value = "头像URL")
    String USER_DEFAULT_AVATAR = "https://asoa-1305425069.cos.ap-shanghai.myqcloud.com/1764171114956853248.jpg";
}

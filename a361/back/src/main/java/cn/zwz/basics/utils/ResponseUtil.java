package cn.zwz.basics.utils;

import com.alibaba.fastjson2.JSONObject;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author
 *
 */
@ApiOperation(value = "API接口回调工具类")
@Slf4j
public class ResponseUtil {

    private static final String CHARACTER_ENCODING = "UTF-8";

    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

    @ApiModelProperty(value = "输出JSON")
    public static void out(HttpServletResponse httpServletResponse, Map<String, Object> responseMap){
        ServletOutputStream outputStream = null;
        try {
            httpServletResponse.setCharacterEncoding(CHARACTER_ENCODING);
            httpServletResponse.setContentType(CONTENT_TYPE);
            outputStream = httpServletResponse.getOutputStream();
            outputStream.write(JSONObject.toJSONString(responseMap).getBytes());
        } catch (Exception exception) {
            log.warn(exception + "Response转换JSON错误");
        } finally{
            if(outputStream != null){
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Map<String, Object> resultMap(boolean flag, Integer responseCode, String message, Object data){
        Map<String, Object> responseMap = new HashMap<String, Object>(16);
        responseMap.put("result", data == null ? null : data);
        responseMap.put("timestamp", System.currentTimeMillis() / 1000L);
        responseMap.put("success", flag);
        responseMap.put("code", responseCode);
        responseMap.put("message", message);
        return responseMap;
    }

    public static Map<String, Object> resultSuccessMap(String msg){
        return resultMap(true, 200, msg, null);
    }

    public static Map<String, Object> resultMap(boolean successFlag, Integer code, String msg){
        return resultMap(successFlag, code, msg, null);
    }

    public static Map<String, Object> resultSuccessMap(){
        return resultMap(true, 200, "操作成功", null);
    }
}

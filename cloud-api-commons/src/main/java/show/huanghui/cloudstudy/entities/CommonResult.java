package show.huanghui.cloudstudy.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guangtou
 * @create 2020--05--01--10:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code; // 状态码
    private String message; // 状态信息
    private T data; // 数据
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}

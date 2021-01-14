package top.itkezhan.blockchain.explorer.modules.explorer.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 * @author JILIGUO
 * @date 2021/1/13 8:42
 * 按照分钟、小时菜点统计
 */
@Data
@ApiModel(value = "PointCount", description = "采样数据结构")
public class PointCount {
    private String datetime;
    private Integer count;
}

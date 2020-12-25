package top.itkezhan.blockchain.explorer.modules.explorer.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author eggsy
 * @since 2020-12-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("network")
@ApiModel(value="Network对象", description="区块链网络表")
public class Network implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    private Date createTime;

    private String networkName;


}

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
 * @since 2020-12-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("chaincode")
@ApiModel(value="Chaincode对象", description="")
public class Chaincode implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    private String name;

    private String version;

    private String path;

    private String channelGenesisHash;

    private Integer txCount;

    private Date createTime;

    private String networkName;


}

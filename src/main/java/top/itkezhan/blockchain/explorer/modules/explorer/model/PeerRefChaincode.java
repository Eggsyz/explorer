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
@TableName("peer_ref_chaincode")
@ApiModel(value="PeerRefChaincode对象", description="")
public class PeerRefChaincode implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    private String peerId;

    private String chaincodeId;

    private String chaincodeVersion;

    private String channelId;

    private Date createTime;

    private String networkName;


}

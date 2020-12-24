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
 * @since 2020-12-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("peer")
@ApiModel(value="Peer对象", description="")
public class Peer implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    private String channelGenesisHash;

    private String mspId;

    private String requests;

    private String events;

    private String serverHostname;

    private Date createTime;

    private String peerType;

    private String networkName;


}

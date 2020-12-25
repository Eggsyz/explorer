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
@TableName("channel")
@ApiModel(value="Channel对象", description="通道表")
public class Channel implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    private String name;

    private Integer blockCount;

    private Integer txCount;

    private Date createTime;

    private String channelGenesisHash;

    private String channelHash;

    private String channelConfig;

    private String channelBlock;

    private String channelTx;

    private String channelVersion;

    private String networkName;


}

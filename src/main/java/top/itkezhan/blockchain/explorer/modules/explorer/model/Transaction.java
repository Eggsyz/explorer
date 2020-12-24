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
@TableName("transaction")
@ApiModel(value="Transaction对象", description="")
public class Transaction implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    private Integer blockId;

    private String txHash;

    private Date createTime;

    private String chaincodeName;

    private Integer status;

    private String creatorMspId;

    private String endorserMspId;

    private String chaincodeId;

    private String type;

    private String readSet;

    private String writeSet;

    private String channelGenesisHash;

    private String validationCode;

    private String envelopeSignature;

    private String payloadExtension;

    private String creatorIdBytes;

    private String creatorNonce;

    private String chaincodeProposalInput;

    private String txResponse;

    private String payloadProposalHash;

    private String endorserIdBytes;

    private String endorserSignature;

    private String networkName;


}

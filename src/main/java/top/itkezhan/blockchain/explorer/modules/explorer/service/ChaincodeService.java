package top.itkezhan.blockchain.explorer.modules.explorer.service;

import top.itkezhan.blockchain.explorer.modules.explorer.model.Chaincode;
import com.baomidou.mybatisplus.extension.service.IService;
import top.itkezhan.blockchain.explorer.modules.explorer.model.Channel;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author eggsy
 * @since 2020-12-24
 */
public interface ChaincodeService extends IService<Chaincode> {
    /**
     * 查询通道已实例化链码列表
     */
    List<Chaincode> getChaincodeList(String networkName,String channelName);


    /**
     * 根据链码名查询链码详情
     */
    Chaincode getChaincodeByName(String networkName,String channelName,String chaincodeName);

}

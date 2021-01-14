package top.itkezhan.blockchain.explorer.modules.explorer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import top.itkezhan.blockchain.explorer.modules.explorer.model.Block;
import top.itkezhan.blockchain.explorer.modules.explorer.model.Chaincode;
import top.itkezhan.blockchain.explorer.modules.explorer.mapper.ChaincodeMapper;
import top.itkezhan.blockchain.explorer.modules.explorer.model.Channel;
import top.itkezhan.blockchain.explorer.modules.explorer.service.ChaincodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author eggsy
 * @since 2020-12-24
 */
@Service
public class ChaincodeServiceImpl extends ServiceImpl<ChaincodeMapper, Chaincode> implements ChaincodeService {

    @Override
    public List<Chaincode> getChaincodeList(String networkName, String channelName) {
        QueryWrapper<Chaincode> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Chaincode::getNetworkName, networkName)
                .eq(Chaincode::getChannelName, channelName);
        return list(wrapper);
    }

    @Override
    public Chaincode getChaincodeByName(String networkName, String channelName, String chaincodeName) {
        QueryWrapper<Chaincode> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Chaincode::getNetworkName, networkName)
                .eq(Chaincode::getChannelName, channelName)
                .eq(Chaincode::getName, chaincodeName);
        List<Chaincode> chaincodeList = list(wrapper);
        if (chaincodeList != null && chaincodeList.size() > 0) {
            return chaincodeList.get(0);
        }
        return null;
    }
}

package top.itkezhan.blockchain.explorer.modules.explorer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import top.itkezhan.blockchain.explorer.modules.explorer.model.Chaincode;
import top.itkezhan.blockchain.explorer.modules.explorer.mapper.ChaincodeMapper;
import top.itkezhan.blockchain.explorer.modules.explorer.model.Channel;
import top.itkezhan.blockchain.explorer.modules.explorer.service.ChaincodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author eggsy
 * @since 2020-12-24
 */
@Service
public class ChaincodeServiceImpl extends ServiceImpl<ChaincodeMapper, Chaincode> implements ChaincodeService {

    @Override
    public List<Chaincode> getChaincodeList(String networkName, String channelName) {

        return null;
    }
}

package top.itkezhan.blockchain.explorer.modules.explorer.service.impl;

import top.itkezhan.blockchain.explorer.modules.explorer.model.Network;
import top.itkezhan.blockchain.explorer.modules.explorer.mapper.NetworkMapper;
import top.itkezhan.blockchain.explorer.modules.explorer.service.NetworkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author eggsy
 * @since 2020-12-25
 */
@Service
public class NetworkServiceImpl extends ServiceImpl<NetworkMapper, Network> implements NetworkService {

}

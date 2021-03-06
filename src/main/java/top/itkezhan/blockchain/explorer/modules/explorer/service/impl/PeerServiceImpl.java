package top.itkezhan.blockchain.explorer.modules.explorer.service.impl;

import top.itkezhan.blockchain.explorer.modules.explorer.model.Peer;
import top.itkezhan.blockchain.explorer.modules.explorer.mapper.PeerMapper;
import top.itkezhan.blockchain.explorer.modules.explorer.service.PeerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author eggsy
 * @since 2020-12-23
 */
@Service
public class PeerServiceImpl extends ServiceImpl<PeerMapper, Peer> implements PeerService {

}

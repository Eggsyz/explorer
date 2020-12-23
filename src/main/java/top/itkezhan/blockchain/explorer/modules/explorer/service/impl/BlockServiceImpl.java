package top.itkezhan.blockchain.explorer.modules.explorer.service.impl;

import top.itkezhan.blockchain.explorer.modules.explorer.model.Block;
import top.itkezhan.blockchain.explorer.modules.explorer.mapper.BlockMapper;
import top.itkezhan.blockchain.explorer.modules.explorer.service.BlockService;
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
public class BlockServiceImpl extends ServiceImpl<BlockMapper, Block> implements BlockService {

}

package top.itkezhan.blockchain.explorer.modules.explorer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.itkezhan.blockchain.explorer.modules.explorer.dto.PointCount;
import top.itkezhan.blockchain.explorer.modules.explorer.mapper.BlockMapper;
import top.itkezhan.blockchain.explorer.modules.explorer.model.Block;
import top.itkezhan.blockchain.explorer.modules.explorer.service.BlockService;

import java.util.Date;
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
public class BlockServiceImpl extends ServiceImpl<BlockMapper, Block> implements BlockService {
    @Autowired
    private BlockMapper blockMapper;

    @Override
    public Page<Block> list(String networkName, String channelName, Integer pageNum, Integer pageSize) {
        Page<Block> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Block> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Block> lambdaQueryWrapper = queryWrapper.lambda();
        lambdaQueryWrapper.eq(Block::getNetworkName, networkName);
        lambdaQueryWrapper.eq(Block::getChannelName, channelName);
        return page(page, queryWrapper);
    }

    @Override
    public Block getBlockByBlockNum(String networkName, String channelName, Integer blockNum) {
        QueryWrapper<Block> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Block> lambdaQueryWrapper = queryWrapper.lambda();
        lambdaQueryWrapper.eq(Block::getNetworkName, networkName);
        lambdaQueryWrapper.eq(Block::getChannelName, channelName);
        lambdaQueryWrapper.eq(Block::getBlockNum, blockNum);
        List<Block> blockList = list(queryWrapper);
        if (blockList != null && blockList.size() > 0) {
            return blockList.get(0);
        }
        return null;
    }

    @Override
    public List<PointCount> listByMinute(String networkName, String channelName, Date startTime, Date endTime) {
        return blockMapper.listByMinute(networkName, channelName, startTime, endTime);
    }

    @Override
    public List<PointCount> listByHour(String networkName, String channelName, Date startTime, Date endTime) {
        return blockMapper.listByHour(networkName, channelName, startTime, endTime);
    }

    @Override
    public List<PointCount> listByDay(String networkName, String channelName, Date startTime, Date endTime) {
        return blockMapper.listByDay(networkName, channelName, startTime, endTime);
    }

}

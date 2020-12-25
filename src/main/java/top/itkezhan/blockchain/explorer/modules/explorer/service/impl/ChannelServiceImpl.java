package top.itkezhan.blockchain.explorer.modules.explorer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import top.itkezhan.blockchain.explorer.modules.explorer.model.Channel;
import top.itkezhan.blockchain.explorer.modules.explorer.mapper.ChannelMapper;
import top.itkezhan.blockchain.explorer.modules.explorer.service.ChannelService;
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
public class ChannelServiceImpl extends ServiceImpl<ChannelMapper, Channel> implements ChannelService {

    @Override
    public List<Channel> getChannelList(String networkName) {
        QueryWrapper<Channel> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Channel::getNetworkName, networkName);
        return list(wrapper);
    }

    @Override
    public Channel getChannelInfo(String networkName, String channelName) {
        QueryWrapper<Channel> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Channel::getNetworkName, networkName)
                .eq(Channel::getName, channelName);
        return getOne(wrapper);
    }
}

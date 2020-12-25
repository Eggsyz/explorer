package top.itkezhan.blockchain.explorer.modules.explorer.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.itkezhan.blockchain.explorer.modules.explorer.model.Channel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author eggsy
 * @since 2020-12-24
 */
public interface ChannelService extends IService<Channel> {
    /**
     * 获取区块链网络的所有通道
     */
    List<Channel> getChannelList(String networkName);

    /**
     * 基于通道名查询通道详情
     */
    Channel getChannelInfo(String networkName, String channelName);
}

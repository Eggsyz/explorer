package top.itkezhan.blockchain.explorer.modules.explorer.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import top.itkezhan.blockchain.explorer.modules.explorer.dto.PointCount;
import top.itkezhan.blockchain.explorer.modules.explorer.model.Block;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author eggsy
 * @since 2020-12-24
 */
public interface BlockService extends IService<Block> {
    /**
     * TODO：存在模糊查询的情况，后续确认需求
     * 根据网络、通道分页查询通道区块列表
     */
    Page<Block> list(String networkName, String channelName, Integer pageNum, Integer pageSize);

    /**
     * 基于区块高度查询区块详情
     */
    Block getBlockByBlockNum(String networkName, String channelName, Integer blockNum);

    /**
     * 按分钟分组统计区块的数量列表
     */
    List<PointCount> listByMinute(String networkName, String channelName, Date startTime, Date endTime);

    /**
     * 按小时分组统计区块的数量列表
     */
    List<PointCount> listByHour(String networkName, String channelName, Date startTime, Date endTime);


    /**
     * 按天分组统计区块的数量列表
     */
    List<PointCount> listByDay(String networkName, String channelName, Date startTime, Date endTime);

}

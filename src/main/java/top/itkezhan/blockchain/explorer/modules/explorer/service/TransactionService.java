package top.itkezhan.blockchain.explorer.modules.explorer.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.itkezhan.blockchain.explorer.modules.explorer.dto.PointCount;
import top.itkezhan.blockchain.explorer.modules.explorer.model.Block;
import top.itkezhan.blockchain.explorer.modules.explorer.model.Transaction;
import com.baomidou.mybatisplus.extension.service.IService;

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
public interface TransactionService extends IService<Transaction> {
    /**
     * TODO：存在模糊查询的情况，后续确认需求
     * 根据网络、通道分页查询通道交易列表
     */
    Page<Transaction> list(String networkName, String channelName, Integer pageNum, Integer pageSize);

    /**
     * 基于交易hash查询交易详情
     */
    Transaction getTransactionByTxHash(String networkName, String channelName, String txHash);

    /**
     * 按分钟分组统计交易的数量列表
     */
    List<PointCount> listByMinute(String networkName, String channelName, Date startTime, Date endTime);

    /**
     * 按小时分组统计交易的数量列表
     */
    List<PointCount> listByHour(String networkName, String channelName, Date startTime, Date endTime);


    /**
     * 按天分组统计交易的数量列表
     */
    List<PointCount> listByDay(String networkName, String channelName, Date startTime, Date endTime);

}

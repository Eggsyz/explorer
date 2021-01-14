package top.itkezhan.blockchain.explorer.modules.explorer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import top.itkezhan.blockchain.explorer.modules.explorer.dto.PointCount;
import top.itkezhan.blockchain.explorer.modules.explorer.model.Block;
import top.itkezhan.blockchain.explorer.modules.explorer.model.Transaction;
import top.itkezhan.blockchain.explorer.modules.explorer.mapper.TransactionMapper;
import top.itkezhan.blockchain.explorer.modules.explorer.service.TransactionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
public class TransactionServiceImpl extends ServiceImpl<TransactionMapper, Transaction> implements TransactionService {

    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public Page<Transaction> list(String networkName, String channelName, Integer pageNum, Integer pageSize) {
        Page<Transaction> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Transaction> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Transaction> lambdaQueryWrapper = queryWrapper.lambda();
        lambdaQueryWrapper.eq(Transaction::getNetworkName, networkName);
        lambdaQueryWrapper.eq(Transaction::getChannelName, channelName);
        return page(page, queryWrapper);
    }

    @Override
    public Transaction getTransactionByTxHash(String networkName, String channelName, String txHash) {
        QueryWrapper<Transaction> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Transaction> lambdaQueryWrapper = queryWrapper.lambda();
        lambdaQueryWrapper.eq(Transaction::getNetworkName, networkName);
        lambdaQueryWrapper.eq(Transaction::getChannelName, channelName);
        lambdaQueryWrapper.eq(Transaction::getTxHash, txHash);
        List<Transaction> transactionList = list(queryWrapper);
        if (transactionList != null && transactionList.size() > 0) {
            return transactionList.get(0);
        }
        return null;
    }

    @Override
    public List<PointCount> listByMinute(String networkName, String channelName, Date startTime, Date endTime) {
        return transactionMapper.listByMinute(networkName, channelName, startTime, endTime);
    }

    @Override
    public List<PointCount> listByHour(String networkName, String channelName, Date startTime, Date endTime) {
        return transactionMapper.listByHour(networkName, channelName, startTime, endTime);
    }

    @Override
    public List<PointCount> listByDay(String networkName, String channelName, Date startTime, Date endTime) {
        return transactionMapper.listByDay(networkName, channelName, startTime, endTime);
    }

}

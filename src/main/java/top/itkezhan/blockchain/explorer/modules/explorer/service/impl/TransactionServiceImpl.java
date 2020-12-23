package top.itkezhan.blockchain.explorer.modules.explorer.service.impl;

import top.itkezhan.blockchain.explorer.modules.explorer.model.Transaction;
import top.itkezhan.blockchain.explorer.modules.explorer.mapper.TransactionMapper;
import top.itkezhan.blockchain.explorer.modules.explorer.service.TransactionService;
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
public class TransactionServiceImpl extends ServiceImpl<TransactionMapper, Transaction> implements TransactionService {

}

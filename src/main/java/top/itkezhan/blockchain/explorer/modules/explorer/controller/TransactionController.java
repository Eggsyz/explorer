package top.itkezhan.blockchain.explorer.modules.explorer.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import top.itkezhan.blockchain.explorer.common.api.CommonPage;
import top.itkezhan.blockchain.explorer.common.api.CommonResult;
import top.itkezhan.blockchain.explorer.modules.explorer.dto.PointCount;
import top.itkezhan.blockchain.explorer.modules.explorer.model.Block;
import top.itkezhan.blockchain.explorer.modules.explorer.model.Transaction;
import top.itkezhan.blockchain.explorer.modules.explorer.service.TransactionService;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author eggsy
 * @since 2020-12-24
 */
@RestController
@RequestMapping("/explorer/transaction")
@Api(tags = "TransactionController", description = "交易管理")

public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @ApiOperation("分页查询交易列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<Transaction>> list(@RequestParam(value = "networkName") String networkName,
                                                      @RequestParam(value = "channelName") String channelName,
                                                      @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<Transaction> transactionPage = transactionService.list(networkName, channelName, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(transactionPage));
    }

    @ApiOperation("根据id查询交易详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Transaction> getBlockById(@PathVariable Integer id) {
        Transaction transaction = transactionService.getById(id);
        return CommonResult.success(transaction);
    }

    @ApiOperation("根据交易hash查询交易详情")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Transaction> info(@RequestParam(value = "networkName") String networkName,
                                          @RequestParam(value = "channelName") String channelName,
                                          @RequestParam(value = "blockNum") String txHash) {
        Transaction transaction = transactionService.getTransactionByTxHash(networkName, channelName, txHash);
        return CommonResult.success(transaction);
    }

    @ApiOperation("插入交易信息")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult insert(@RequestBody Transaction transaction) {
        boolean success = transactionService.save(transaction);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("按照分钟统计交易数量")
    @RequestMapping(value = "/listByMinute", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PointCount>> listByMinute(@RequestParam(value = "networkName") String networkName,
                                                       @RequestParam(value = "channelName") String channelName,
                                                       @RequestParam(value = "startTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime,
                                                       @RequestParam(value = "endTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime) {
        List<PointCount> pointList = transactionService.listByMinute(networkName, channelName, startTime, endTime);
        return CommonResult.success(pointList);
    }

    @ApiOperation("按照小时分组统计交易数量")
    @RequestMapping(value = "/listByHour", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PointCount>> listByHour(@RequestParam(value = "networkName") String networkName,
                                                     @RequestParam(value = "channelName") String channelName,
                                                     @RequestParam(value = "startTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime,
                                                     @RequestParam(value = "endTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime) {
        List<PointCount> pointList = transactionService.listByHour(networkName, channelName, startTime, endTime);
        return CommonResult.success(pointList);
    }

    @ApiOperation("按照天分组统计交易数量")
    @RequestMapping(value = "/listByDay", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PointCount>> listByDay(@RequestParam(value = "networkName") String networkName,
                                                    @RequestParam(value = "channelName") String channelName,
                                                    @RequestParam(value = "startTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime,
                                                    @RequestParam(value = "endTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime) {
        List<PointCount> pointList = transactionService.listByDay(networkName, channelName, startTime, endTime);
        return CommonResult.success(pointList);
    }
}


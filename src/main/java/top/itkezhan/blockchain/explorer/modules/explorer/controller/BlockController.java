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
import top.itkezhan.blockchain.explorer.modules.explorer.model.Channel;
import top.itkezhan.blockchain.explorer.modules.explorer.service.BlockService;

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
@Api(tags = "BlockController", description = "区块管理")
@RequestMapping("/explorer/block")
public class BlockController {
    @Autowired
    private BlockService blockService;

    @ApiOperation("分页查询区块列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<Block>> list(@RequestParam(value = "networkName") String networkName,
                                                @RequestParam(value = "channelName") String channelName,
                                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<Block> blockList = blockService.list(networkName, channelName, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(blockList));
    }

    @ApiOperation("根据id查询区块详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Block> getBlockById(@PathVariable Integer id) {
        Block block = blockService.getById(id);
        return CommonResult.success(block);
    }

    @ApiOperation("根据区块高度查询区块详情")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Block> info(@RequestParam(value = "networkName") String networkName,
                                    @RequestParam(value = "channelName") String channelName,
                                    @RequestParam(value = "blockNum") Integer blockNum) {
        Block block = blockService.getBlockByBlockNum(networkName, channelName, blockNum);
        return CommonResult.success(block);
    }

    @ApiOperation("插入区块信息")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult insert(@RequestBody Block block) {
        boolean success = blockService.save(block);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("按照分钟统计区块数量")
    @RequestMapping(value = "/listByMinute", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PointCount>> listByMinute(@RequestParam(value = "networkName") String networkName,
                                                       @RequestParam(value = "channelName") String channelName,
                                                       @RequestParam(value = "startTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime,
                                                       @RequestParam(value = "endTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime) {
        List<PointCount> pointList = blockService.listByMinute(networkName, channelName, startTime, endTime);
        return CommonResult.success(pointList);
    }

    @ApiOperation("按照小时分组统计区块数量")
    @RequestMapping(value = "/listByHour", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PointCount>> listByHour(@RequestParam(value = "networkName") String networkName,
                                                     @RequestParam(value = "channelName") String channelName,
                                                     @RequestParam(value = "startTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime,
                                                     @RequestParam(value = "endTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime) {
        List<PointCount> pointList = blockService.listByHour(networkName, channelName, startTime, endTime);
        return CommonResult.success(pointList);
    }

    @ApiOperation("按照天分组统计区块数量")
    @RequestMapping(value = "/listByDay", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PointCount>> listByDay(@RequestParam(value = "networkName") String networkName,
                                                    @RequestParam(value = "channelName") String channelName,
                                                    @RequestParam(value = "startTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime,
                                                    @RequestParam(value = "endTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime) {
        List<PointCount> pointList = blockService.listByDay(networkName, channelName, startTime, endTime);
        return CommonResult.success(pointList);
    }

//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
//    }
}


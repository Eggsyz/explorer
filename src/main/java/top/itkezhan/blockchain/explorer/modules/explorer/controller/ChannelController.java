package top.itkezhan.blockchain.explorer.modules.explorer.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.itkezhan.blockchain.explorer.common.api.CommonResult;
import top.itkezhan.blockchain.explorer.modules.explorer.model.Channel;
import top.itkezhan.blockchain.explorer.modules.explorer.service.ChannelService;

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
@RequestMapping("/explorer/channel")
@Api(tags = "ChannelController", description = "通道管理")
public class ChannelController {
    @Autowired
    private ChannelService channelService;

    @ApiOperation("根据网络名查询通道列表")
    @RequestMapping(value = "/list/{networkName}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult list(@PathVariable String networkName) {
        List<Channel> list = channelService.getChannelList(networkName);
        return CommonResult.success(list);
    }

    @ApiOperation("根据id查询通道详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Channel> getChannelById(@PathVariable Integer id) {
        Channel channel = channelService.getById(id);
        return CommonResult.success(channel);
    }

    @ApiOperation("根据网络名和通道名查询通道详情")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Channel> getChannelByName(@RequestParam("networkName") String networkName, @RequestParam("channelName") String channelName) {
        Channel channel = channelService.getChannelInfo(networkName, channelName);
        return CommonResult.success(channel);
    }
}


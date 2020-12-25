package top.itkezhan.blockchain.explorer.modules.explorer.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import top.itkezhan.blockchain.explorer.common.api.CommonResult;
import top.itkezhan.blockchain.explorer.modules.explorer.model.Channel;
import top.itkezhan.blockchain.explorer.modules.explorer.model.Network;
import top.itkezhan.blockchain.explorer.modules.explorer.service.NetworkService;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author eggsy
 * @since 2020-12-25
 */
@RestController
@RequestMapping("/explorer/network")
@Api(tags = "NetworkController", description = "区块链网络管理")
public class NetworkController {
    @Autowired
    private NetworkService networkService;

    @ApiOperation("查询区块链网络列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult list() {
        List<Network> list = networkService.list();
        return CommonResult.success(list);
    }
}


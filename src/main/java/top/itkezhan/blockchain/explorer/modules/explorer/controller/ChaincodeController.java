package top.itkezhan.blockchain.explorer.modules.explorer.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import top.itkezhan.blockchain.explorer.common.api.CommonPage;
import top.itkezhan.blockchain.explorer.common.api.CommonResult;
import top.itkezhan.blockchain.explorer.modules.explorer.model.Block;
import top.itkezhan.blockchain.explorer.modules.explorer.model.Chaincode;
import top.itkezhan.blockchain.explorer.modules.explorer.service.ChaincodeService;

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
@Api(tags = "ChaincodeController", description = "链码管理")
@RequestMapping("/explorer/chaincode")
public class ChaincodeController {
    @Autowired
    private ChaincodeService chaincodeService;

    @ApiOperation("查询链码列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Chaincode>> list(@RequestParam(value = "networkName") String networkName,
                                              @RequestParam(value = "channelName") String channelName) {
        List<Chaincode> list = chaincodeService.getChaincodeList(networkName, channelName);
        return CommonResult.success(list);
    }

    @ApiOperation("根据链码名查询链码详情")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Chaincode> info(@RequestParam(value = "networkName") String networkName,
                                        @RequestParam(value = "channelName") String channelName,
                                        @RequestParam(value = "chaincodeName") String chaincodeName) {
        Chaincode chaincode = chaincodeService.getChaincodeByName(networkName, channelName, chaincodeName);
        return CommonResult.success(chaincode);
    }

    @ApiOperation("根据id查询链码详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Chaincode> getChaincodeById(@PathVariable Integer id) {
        Chaincode chaincode = chaincodeService.getById(id);
        return CommonResult.success(chaincode);
    }


//    @ApiOperation("分页查询链码列表")
//    @RequestMapping(value = "/page", method = RequestMethod.GET)
//    @ResponseBody
//    public CommonResult<CommonPage<Chaincode>> list(@RequestParam(value = "networkName") String networkName,
//                                                @RequestParam(value = "channelName") String channelName,
//                                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
//                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
//        Page<Chaincode> chaincodeList = chaincodeService.list(networkName, channelName, pageNum, pageSize);
//        return CommonResult.success(CommonPage.restPage(chaincodeList));
//    }
}


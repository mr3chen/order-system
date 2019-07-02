package com.order.system.productService.controller;

import com.order.system.common.result.ServiceResult;
import com.order.system.productService.common.constant.ProductStatusType;
import com.order.system.productService.common.query.IncreaseProductInventoryRequest;
import com.order.system.productService.model.ProductInfo;
import com.order.system.productService.service.IProductInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author: zhonghao
 * @date: 2019/01/28 14:17:47
 * @description: ProductInfo控制器
 */
@RestController
public class ProductInfoController {
    @Resource
    private IProductInfoService productInfoService;


    @ApiOperation(value = "根据ID获取商品", notes = "")
    @GetMapping("/findProduct/{pid}")
    public ServiceResult findProductByPid(@PathVariable Integer pid) {
        ProductInfo productInfo = productInfoService.findById(pid);
        ProductStatusType.validProductStatus(productInfo);
        return ServiceResult.success(productInfo);
    }


    @ApiOperation(value = "变更商品库存", notes = "")
    @RequestMapping(value = "/products/{productId}/inventory", method = RequestMethod.PATCH)
    public ServiceResult updateInventory(@RequestParam Integer productId, @Valid @RequestBody IncreaseProductInventoryRequest request) {
        ProductInfo productInfo = productInfoService.findById(productId);
        ProductStatusType.validProductStatus(productInfo);
        productInfoService.updateInventory(productId, request.getCount());
        return ServiceResult.success(productInfo);
    }


    /**
     * ProductInfo分页列表
     *
     * @param pageNum  页码
     * @param pageSize 每页记录数
     */
    @GetMapping("/pageList")
    public ServiceResult pageList(ProductInfo productInfo, @RequestParam(defaultValue = "0") Integer pageNum, @RequestParam(defaultValue = "0") Integer pageSize) {
        // 分页
        PageHelper.startPage(pageNum, pageSize);
        // 增加查询条件，criteria.andCondition("xxxx");
        Condition condition = new Condition(ProductInfo.class);
        Example.Criteria criteria = condition.createCriteria();

        List<ProductInfo> list = productInfoService.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ServiceResult.success(pageInfo);
    }
}

package ${basePackage}.controller;
import com.order.system.common.result.ServiceResult;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.I${modelNameUpperCamel}Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
* @author: ${author}
* @date: ${date}
* @description: ${modelNameUpperCamel}控制器
*/
@RestController
@RequestMapping("${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {
    @Resource
    private I${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;


    /**
     * 新增${modelNameUpperCamel}
     */
    @PostMapping("/add")
    public ServiceResult add(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        boolean flag = ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
        if (!flag) {
            return ServiceResult.error("新增失败！");
        }
         return ServiceResult.success();
    }

    /**
     * 删除${modelNameUpperCamel}
     */
    @DeleteMapping("/delete")
    public ServiceResult delete(@RequestParam Integer id) {
        boolean flag = ${modelNameLowerCamel}Service.deleteById(id);
        if (!flag) {
            return  ServiceResult.error("被删除对象不存在！");
        }
        return ServiceResult.success();
    }

    /**
     * 更新${modelNameUpperCamel}
     */
    @PutMapping("/update")
    public ServiceResult update(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        boolean flag = ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
        if (!flag) {
            return ServiceResult.error("更新失败！");
        }
        return ServiceResult.success();
    }

    /**
     * ${modelNameUpperCamel}详情
     */
    @GetMapping("/detail")
    public ServiceResult detail(@RequestParam Integer id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
        if (${modelNameLowerCamel} == null) {
            return ServiceResult.error("查找对象不存在！");
        }
        return ServiceResult.success(${modelNameLowerCamel});
    }

    /**
     * ${modelNameUpperCamel}分页列表
     *
     * @param pageNum  页码
     * @param pageSize 每页记录数
     */
    @GetMapping("/pageList")
    public ServiceResult pageList(${modelNameUpperCamel} ${modelNameLowerCamel}, @RequestParam(defaultValue = "0") Integer pageNum, @RequestParam(defaultValue = "0") Integer pageSize) {
        // 分页
        PageHelper.startPage(pageNum, pageSize);
        // 增加查询条件，criteria.andCondition("xxxx");
        Condition condition = new Condition(${modelNameUpperCamel}.class);
        Example.Criteria criteria = condition.createCriteria();

        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findByCondition(condition);
        PageInfo pageInfo = new PageInfo(list);
        return ServiceResult.success(pageInfo);
    }
}

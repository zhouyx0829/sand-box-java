package com.boot.sand.mvc.controllers;

import com.boot.sand.model.BsMember;
import com.boot.sand.services.BsMemberService;
import com.common.zyx.dao.PageResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("bs-member")
@Validated
@Slf4j
public class BsMemberController {

    @Autowired
    BsMemberService bsMemberService;
    
    @ApiOperation("保存bs-member")
    @PostMapping
    public BsMember save(BsMember model){
        return bsMemberService.save(model);
    }
    
    @ApiOperation("更新bs-member")
    @PutMapping
    public BsMember update(BsMember model) {
        return bsMemberService.update(model);
    }

    @ApiOperation("通过id获取bs-member")
    @GetMapping("{id}")
    public BsMember getById(@PathVariable Integer id) {
        return bsMemberService.get(id);
    }
    
    @ApiOperation("获取bs-member列表")
    @GetMapping
    public PageResult<BsMember> list(PageResult<BsMember> page) {
        return bsMemberService.page(page);
    }
    
    @ApiOperation("删除bs-member")
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        bsMemberService.delete(id);
    }

    @ApiOperation("批量删除bs-member")
    @DeleteMapping("ids")
    public void deleteByIds(@NotNull Integer [] ids) {
        bsMemberService.deleteByIds(Arrays.asList(ids));
    }

    @ApiOperation("查找全部")
    @PostMapping("all")
    public List<BsMember> all() {
        return bsMemberService.findAll();
    }
    
}

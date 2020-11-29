package com.autuan.project.system.user.controller;

import java.math.BigDecimal;
import java.util.List;

import com.autuan.project.promote.salesman.service.ISalesmanCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.autuan.framework.config.RuoYiConfig;
import com.autuan.framework.web.controller.BaseController;
import com.autuan.project.system.menu.domain.Menu;
import com.autuan.project.system.menu.service.IMenuService;
import com.autuan.project.system.user.domain.User;

/**
 * 首页 业务处理
 *
 * @author ruoyi
 */
@Controller
public class IndexController extends BaseController {
    @Autowired
    private IMenuService menuService;

    @Autowired
    private RuoYiConfig ruoYiConfig;

    @Autowired
    private ISalesmanCustomService salesmanCustomService;
    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap) {
        // 取身份信息
        User user = getSysUser();
        // 根据用户id取出菜单
        List<Menu> menus = menuService.selectMenusByUser(user);
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("copyrightYear", ruoYiConfig.getCopyrightYear());
        mmap.put("demoEnabled", ruoYiConfig.isDemoEnabled());
        return "index";
    }

    // 切换主题
    @GetMapping("/system/switchSkin")
    public String switchSkin(ModelMap mmap) {
        return "skin";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap) {
        mmap.put("version", ruoYiConfig.getVersion());
        // 首页数据
        // 招募数量
        Integer allCount = salesmanCustomService.allCount();
        mmap.put("allCount",allCount);
        // 上月招募
        Integer lastMoonCount = salesmanCustomService.lastMoonCount();
        mmap.put("lastMoonCount",lastMoonCount);
        Integer thisMoonCount = salesmanCustomService.thisMoonCount();
        mmap.put("thisMoonCount",thisMoonCount);
        // 业绩总记
        BigDecimal allRewardCount = salesmanCustomService.allRewardCount();
        mmap.put("allRewardCount",allRewardCount);
        // 上月业绩总记
        BigDecimal lastRewardCount = salesmanCustomService.lastRewardCount();
        mmap.put("lastRewardCount",lastRewardCount);
        BigDecimal thisRewardCount = salesmanCustomService.thisRewardCount();
        mmap.put("thisRewardCount",thisRewardCount);
        return "main";
    }
}
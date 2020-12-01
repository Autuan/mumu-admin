package com.autuan.project.front.controller;

import cn.hutool.crypto.digest.MD5;
import com.autuan.common.utils.Md5Utils;
import com.autuan.project.front.entity.ReturnResult;
import com.autuan.project.mumu.member.domain.SignInReq;
import com.autuan.project.mumu.member.service.IMemberCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/front/member")
public class MemberFrontController {
    @Autowired
    private IMemberCustomService memberCustomService;
    /**
     * 登录方法
     * @param req
     * @return
     * @author Autuan.Yu
     */
    @PostMapping("/sign")
    public ReturnResult signIn(@RequestBody @Valid SignInReq req){
        memberCustomService.signIn(req);
       return ReturnResult.ok();
    }
}

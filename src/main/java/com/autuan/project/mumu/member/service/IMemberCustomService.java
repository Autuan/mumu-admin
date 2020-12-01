package com.autuan.project.mumu.member.service;

import com.autuan.project.mumu.member.domain.SignInReq;

public interface IMemberCustomService {
    /**
     * 登录
     * @param req
     */
    void signIn(SignInReq req);
}

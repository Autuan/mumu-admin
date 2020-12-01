package com.autuan.project.mumu.member.service.impl;

import com.autuan.common.utils.Md5Utils;
import com.autuan.project.mumu.member.domain.SignInReq;
import com.autuan.project.mumu.member.mapper.MemberMapper;
import com.autuan.project.mumu.member.service.IMemberCustomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MemberCustomServiceImpl implements IMemberCustomService {

    @Override
    public void signIn(SignInReq req) {
        String hashPwd = Md5Utils.hash(req.getPassword());
        log.info("MemberCustomServiceImpl -> signIn -> no -> {} hashPwd -> {}",req.getNo(),hashPwd);

    }
}

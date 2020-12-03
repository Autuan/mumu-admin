package com.autuan.project.mumu.member.service.impl;

import com.autuan.common.exception.BusinessException;
import com.autuan.common.utils.Md5Utils;
import com.autuan.project.mumu.member.domain.SignInReq;
import com.autuan.project.mumu.member.domain.TabMemberExample;
import com.autuan.project.mumu.member.mapper.MemberMapper;
import com.autuan.project.mumu.member.mapper.TabMemberMapper;
import com.autuan.project.mumu.member.service.IMemberCustomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MemberCustomServiceImpl implements IMemberCustomService {
    @Autowired
    private TabMemberMapper tabMemberMapper;

    @Override
    public void signIn(SignInReq req) {
        String hashPwd = Md5Utils.hash(req.getPassword());
        log.info("MemberCustomServiceImpl -> signIn -> no -> {} hashPwd -> {}",req.getNo(),hashPwd);
        TabMemberExample example = new TabMemberExample();
        example.createCriteria()
                // todo magic val 2-删除 [Autuan.Yu](20.12.31)
                .andDelFlagNotEqualTo(2)
                .andNoEqualTo(req.getNo())
                .andPasswordEqualTo(hashPwd);
        tabMemberMapper.selectOneByExample(example);

        throw new BusinessException("已停用");
    }
}

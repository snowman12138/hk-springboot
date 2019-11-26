package com.lostself.hkspringboot.service.imp;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lostself.hkspringboot.dao.SysUserMapper;
import com.lostself.hkspringboot.entity.SysUser;
import com.lostself.hkspringboot.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("sysUserService")
public class SysUserServiceImpl implements ISysUserService{

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findById(Long id) {
        // TODO Auto-generated method stub
        return sysUserMapper.findById(id);
    }

    @Override
    public List<SysUser> findAllByPage(int pageNum, int pageSize) {

//        PageHelper.startPage(pagenum,pagesize);
//        List<SysUser> lists = sysUserMapper.selectAll();
//        return lists;
        //这种写法需要jdk8 lambda用法
        Page<SysUser> page = PageHelper.startPage(pageNum, pageSize).doSelectPage(()-> sysUserMapper.selectAll());
        //如果是低版本的jdk,则使用如下写法（两种写法根据自己jdk版本二选一）
//        Page<SysUser> page = PageHelper.startPage(pageNum, pageSize).doSelectPage(new ISelect() {
//            @Override
//            public void doSelect() {
//                sysUserMapper.selectAll();
//            }
//        });
        return page;
    }

    @Override
    public PageInfo<SysUser> findAllByPage2(int pageNum, int pageSize) {

//        PageHelper.startPage(pageNum, pageSize);
//        List<SysUser> lists = sysUserMapper.selectAll();
//        PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(lists);
//        return pageInfo;
        //这种写法需要jdk8 lambda用法
        PageInfo<SysUser> pageInfo = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()-> sysUserMapper.selectAll());
        //如果是低版本的jdk,则使用如下写法（两种写法根据自己jdk版本二选一）
//        PageInfo<SysUser> pageInfo = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(new ISelect() {
//            @Override
//            public void doSelect() {
//                sysUserMapper.selectAll();
//            }
//        });
        return pageInfo;
    }

    @Override
    public int deleteByPrimaryKey(Object id) {
        return 0;
    }

    @Override
    public int insert(SysUser entity) {
        return 0;
    }

    @Override
    public SysUser selectByPrimaryKey(Object id) {
        return null;
    }

    @Override
    public List<SysUser> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(SysUser entity) {
        return 0;
    }
}

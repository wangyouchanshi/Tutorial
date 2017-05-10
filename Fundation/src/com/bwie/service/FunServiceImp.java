package com.bwie.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwie.bean.Cen;
import com.bwie.bean.Money;
import com.bwie.bean.User;
import com.bwie.mapper.UserMapper;
import com.bwie.utils.Page;

@Service
public class FunServiceImp implements FunService{
@Autowired
	private UserMapper userMapper;

@Override
public boolean checkLogin(User user) {
	// TODO Auto-generated method stub
	int i = this.userMapper.checkLogin(user);
	if(i>0){
		return true;
	}
	return false;
}

@Override
public int findCount() {
	// TODO Auto-generated method stub
	 int  i = this.userMapper.findCount();
	return i;
}

@Override
public List<Money> getList(Page p) {
	// TODO Auto-generated method stub
	Map<String, Integer> map=new HashMap<String , Integer>();
	map.put("star", p.getStartRecord());
	map.put("end", p.getPageSize());
	return this.userMapper.getList(map);
}

@Override
public Money getOneObject(Integer mid) {
	// TODO Auto-generated method stub
	return this.userMapper.getOneObject(mid);
}

@Override
public void updateMoney(Money money) {
	// TODO Auto-generated method stub
	this.userMapper.updateMoney(money);
}

@Override
public void saveInsert(Money money) {
	// TODO Auto-generated method stub
	this.userMapper.saveInsert(money);
}

@Override
public int findUid(User user) {
	// TODO Auto-generated method stub
	return this.userMapper.findUid(user);
}

@Override
public List<Cen> findCheckList(Integer xuid) {
	// TODO Auto-generated method stub
	
	return this.userMapper.findCheckList(xuid);
}

@Override
public void updateJijinup(Money money) {
	// TODO Auto-generated method stub
	this.userMapper.updateJijinup(money);
}

@Override
public void deletejilu(Integer did) {
	// TODO Auto-generated method stub
	this.userMapper.deletejilu(did);
}

@Override
public boolean checkName(String name) {
	// TODO Auto-generated method stub
	int i = this.userMapper.checkName(name);
	if(i>0){
		
		return true;
	}else{
		return false;
	}
}

@Override
public void saveUser(User user) {
	// TODO Auto-generated method stub
	this.userMapper.saveUser(user);
}

@Override
public int findmohucount(String mohu) {
	// TODO Auto-generated method stub
	return this.userMapper.findmohucount(mohu);
}

@Override
public List<Money> getMohuList(Page p, String mohu) {
	// TODO Auto-generated method stub
	Map<String, Object> map=new HashMap<String , Object>();
	map.put("star", p.getStartRecord());
	map.put("end", p.getPageSize());
	map.put("mohu", mohu);
	return this.userMapper.getMohuList(map);
}

@Override
public User findUserByUid(String uid) {
	// TODO Auto-generated method stub
	return this.userMapper.findUserByUid(uid);
}

@Override
public void bangdingUser(User user) {
	// TODO Auto-generated method stub
	this.userMapper.bangdingUser(user);
}


}

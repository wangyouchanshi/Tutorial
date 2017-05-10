package com.bwie.mapper;

import java.util.List;
import java.util.Map;

import com.bwie.bean.Cen;
import com.bwie.bean.Money;
import com.bwie.bean.User;
import com.bwie.utils.Page;

public interface UserMapper {

	int checkLogin(User user);

	int findCount();

	List<Money> getList(Map<String, Integer> map);

	Money getOneObject(Integer mid);

	void updateMoney(Money money);

	void saveInsert(Money money);

	int findUid(User user);

	List<Cen> findCheckList(Integer xuid);

	void updateJijinup(Money money);

	void deletejilu(Integer did);

	int checkName(String name);

	void saveUser(User user);

	int findmohucount(String mohu);

	List<Money> getMohuList(Map<String, Object> map);

	User findUserByUid(String uid);

	void bangdingUser(User user);


	
	

}

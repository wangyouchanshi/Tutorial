package com.bwie.service;

import java.util.List;

import com.bwie.bean.Cen;
import com.bwie.bean.Money;
import com.bwie.bean.User;
import com.bwie.utils.Page;

public interface FunService {

	boolean checkLogin(User user);

	int findCount();

	List<Money> getList(Page p);

	Money getOneObject(Integer mid);

	void updateMoney(Money money);

	void saveInsert(Money money);

	int findUid(User user);

	List<Cen> findCheckList(Integer xuid);

	void updateJijinup(Money money);

	void deletejilu(Integer did);

	boolean checkName(String name);

	void saveUser(User user);

	int findmohucount(String mohu);

	List<Money> getMohuList(Page p, String mohu);

	User findUserByUid(String uid);

	void bangdingUser(User user);

}

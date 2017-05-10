package com.bwie.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bwie.bean.Baidu;
import com.bwie.bean.Cen;
import com.bwie.bean.Money;
import com.bwie.bean.User;
import com.bwie.bean.UserInfomation;
import com.bwie.service.FunService;
import com.bwie.utils.Firfox;
import com.bwie.utils.Page;
import com.fasterxml.jackson.databind.ObjectMapper;

import sun.net.www.http.HttpClient;


@Controller
public class FunController {
@Autowired
	private FunService funService;
	
@RequestMapping("login")
	public String Login(User user,HttpServletRequest req){
	HttpSession session = req.getSession();	
	session.setAttribute("uname", user.getUname());
	
	boolean flag = this.funService.checkLogin(user);
		
		if(flag==true){
			Integer uid=new Integer(2);
			uid = this.funService.findUid(user);
			session.setAttribute("xuid",uid);
			uid=3;
			return "suc";
		}
		return "fail";
	}


@RequestMapping("list")
	public String list(String page,HttpServletRequest req,String mohu){
	
	int pageSize=3;
	String url="list.controller";
	int count=0;
	if(mohu==null){
		
		count = this.funService.findCount();	
	}else{
		count = this.funService.findmohucount(mohu);
	}
	Page p=new Page(page, count, pageSize, url, req);
	
	//查询
	List<Money> list = null;
	if(mohu==null){
		
		list=this.funService.getList(p);
	}else{
		list=this.funService.getMohuList(p,mohu);
	}
	req.setAttribute("aa", list);
		return "list";
	}

@RequestMapping("buy")
	public String buy(Integer mid,HttpServletRequest req,Integer uid){
		Money money = this.funService.getOneObject(mid);
		money.setUid(uid);
		req.setAttribute("money", money);
		return "buy";
	}

@RequestMapping("buyend")
	public String buyend(Money money){
		
		this.funService.updateMoney(money);
		
		this.funService.saveInsert(money);
		
		return "cheng";
	}

@RequestMapping("check")
	public String check(Integer uid,HttpServletRequest req){
		List<Cen> list = this.funService.findCheckList(uid);
		req.setAttribute("aa", list);
		
		return "check";
	}


@RequestMapping("chexiao")
	public String chexiao(Money money,Integer did){
		
	this.funService.updateJijinup(money);
	this.funService.deletejilu(did);
		return "forward:list.controller";
	}

@RequestMapping("add")
	public String add(){
		
		return "add";
	}

@RequestMapping("yanzheng")
@ResponseBody
	public boolean yanzheng(String name){
		
		boolean checkName = this.funService.checkName(name);

		return checkName;
	}

@RequestMapping("addend")
public String addend(User user){
	
	this.funService .saveUser(user);
	return "addsuc";
}
/**
 * ���ߣ�       �����
 * ��Ŀ����   Foundation
 * ���ڣ�       2017��5��8��
 * Return��String
 * TODO��    toThird
 * @throws IOException 
 * @throws ClientProtocolException 
 */
@RequestMapping("loginSuccess")
public String loginSuccess(String code,HttpServletRequest req) throws ClientProtocolException, IOException{
	
	//��һ�����֣�����ҳ��ĳ�������ת���ٶȵĵ�¼ҳ�棬���û���¼�ɹ����ٶ���Ӧ�÷���һ������Я��һ������code
	//����code���ܻ�ȡ�û�����Ϣ

		//����һ��client����
		CloseableHttpClient client = HttpClients.createDefault();
		//����һ��Post����
		HttpPost post = new HttpPost("https://openapi.baidu.com/oauth/2.0/token?grant_type=authorization_code&code="+code+"&client_id=9oNY87wp9SLyhX80HD1I3RkA&client_secret=VV6RqxyWfhsOfB9GGXi47uZ5RbQCEcz2&redirect_uri=http://localhost:8080/Fundation/loginSuccess.controller");
		//�Ի���Ľ����˷�װ
		Firfox.fire(post);
		//ִ��post����
		CloseableHttpResponse  response = client.execute(post);
		HttpEntity entity = response.getEntity();  
		String content = EntityUtils.toString(entity,"UTF-8");
		//System.out.println(content);
		//��json�ַ���ת����һ��ʵ����
		ObjectMapper mapper = new ObjectMapper();
		//ʵ�����Access_token�ڶ��������ʱ��Ҫ�õ�
		Baidu baidu = mapper.readValue(content, Baidu.class);
		
		//�ٴδ���һ��Post����
		HttpPost post2 = new HttpPost("https://openapi.baidu.com/rest/2.0/passport/users/getLoggedInUser?access_token="+baidu.getAccess_token());
		Firfox.fire(post2);
		CloseableHttpResponse response2 = client.execute(post2);
		HttpEntity entity2 = response2.getEntity();  
		String content2 = EntityUtils.toString(entity2,"UTF-8");
		//System.out.println(content2);
		
		UserInfomation value = mapper.readValue(content2, UserInfomation.class);
		System.out.println(value.getUid());
		
		//�û�ȡ��uidȥ��̨�飬���Ƿ��ܲ��һ��ʵ���࣬�����Ϊnull��˵���Ѿ���
		//���Ϊnull��ô˵����Ҫ���а�
		User user=this.funService.findUserByUid(value.getUid());
		if(user==null){
			//����˵���ǵ�һ�ε�½��������Ҫȥ��
			req.setAttribute("baidu", value.getUid());
			return "bang";
		}else{
			
			//��˵�����ǵ�һ�ε�½��ֱ��ȥ��̨
			return "suc";
		}
		
}

@RequestMapping("bangding")
public String bangding(User user,HttpServletResponse res){
	
	this.funService.bangdingUser(user);
	
	return "bangsuc";
}

}

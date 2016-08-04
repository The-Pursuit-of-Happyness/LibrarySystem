package com.app;

import com.data.Reader;
import com.frame.MainFrame;

public class Main {
	public static void main(String args[]){
		Reader user = new Reader(2013083225,"姚鸿","84878323","男",21,
			 	"15640928579","2293952179@qq.com","计算机科学与工程学院网络工程",
			 	"工作室成员","2013级","管理员");
		
		new MainFrame(user);
	//	new LoginWindow();	
	}
}

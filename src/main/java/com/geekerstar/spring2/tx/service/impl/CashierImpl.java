package com.geekerstar.spring2.tx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geekerstar.spring2.tx.service.BookShopService;
import com.geekerstar.spring2.tx.service.Cashier;

@Service("cashier")
public class CashierImpl implements Cashier {

	@Autowired
	private BookShopService bookShopService;

	@Transactional
	@Override
	public void checkout(int userId, List<String> isbns) {
		for (String isbn : isbns) {
			//调用BookShopService中买东西的方法
			bookShopService.purchase(userId, isbn);
		}
	}

}

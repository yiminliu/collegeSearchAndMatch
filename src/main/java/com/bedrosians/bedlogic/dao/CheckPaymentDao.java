package com.bedrosians.bedlogic.dao;

import java.util.List;

import com.bedrosians.bedlogic.domain.CheckPayment;

public interface CheckPaymentDao {
	List<CheckPayment> getCheckPaymentsForAccount(String custcd);
}

package com.kajol.Batch;

import org.springframework.batch.item.ItemProcessor;

import com.kajol.DAO.Industry;

public class IndustryProcessor implements ItemProcessor<Industry, Industry> {

	@Override
	public Industry process(Industry item) throws Exception {
		// TODO Auto-generated method stub
		return item;
	}

}

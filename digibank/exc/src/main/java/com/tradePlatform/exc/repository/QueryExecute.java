package com.tradePlatform.exc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tradePlatform.exc.model.Tradecolumn;


@Repository
public interface QueryExecute extends CrudRepository<Tradecolumn, Integer> {
	@Query(value =  "select * from TRADE_MODEL",nativeQuery = true)
	public List<Tradecolumn> getAllRecs();
	
	@Query(value =  "select * from TRADE_MODEL t where t.FRONT_DESK_OFF_ID=? and t.TRADE_DATE_TIME=?",nativeQuery = true)
	public List<Tradecolumn> findByFrontTaskId(String frontDeskOfficerId, String date);
}

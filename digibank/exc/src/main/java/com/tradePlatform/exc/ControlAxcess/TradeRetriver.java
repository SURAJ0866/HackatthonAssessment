package com.tradePlatform.exc.ControlAxcess;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tradePlatform.exc.model.Tradecolumn;
import com.tradePlatform.exc.source.MainSource;

@RestController
public class TradeRetriver {
	@Autowired
	MainSource mainService;



	@GetMapping(value = "/getByFrontDeskId")
	public ResponseEntity<Map<String, Object>> upload(@RequestParam String frontDeskId,@RequestParam String date) {
		System.out.println(frontDeskId+date);
		Map<String, Object> listT = mainService.findByFrontTaskId(frontDeskId,date);
		return ResponseEntity.status(HttpStatus.OK).body(listT);
		
	}
	@GetMapping(value = "/allRecs")
	public ResponseEntity<List<Tradecolumn>> getRecs() {
		List<Tradecolumn> listT = mainService.getAllRecs();
		
		return ResponseEntity.status(HttpStatus.OK).body(listT);
		
	}
}

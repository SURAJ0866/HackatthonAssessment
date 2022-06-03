package com.tradePlatform.exc.ControlAxcess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tradePlatform.exc.model.Tradecolumn;
import com.tradePlatform.exc.source.MainSource;

@RestController
public class TradeCreation {

	@Autowired
	MainSource mainService;


	@PostMapping(value = "/fileUpload")
	public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {

		String message1 = "You successfully uploaded " + file.getOriginalFilename() + "!";
		String message2 = "file not uploaded " + file.getOriginalFilename() + "!";
		String message3 = "FAIL to upload " + file.getOriginalFilename() + "!";
		System.out.println("name:{}"+ file.getOriginalFilename());
		try {
			return mainService.store(file) ? ResponseEntity.status(HttpStatus.OK).body(message1)
					: ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message2);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message3);
		}
	}

	@PostMapping(value = "/addSingleTrade")
	public ResponseEntity<Tradecolumn> getTrade(@RequestBody Tradecolumn tradeModel) {
		 Tradecolumn tradeMod = mainService.addTrade(tradeModel);
		if (tradeMod!=null) 
			return ResponseEntity.status(HttpStatus.OK).body(tradeMod);
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
}

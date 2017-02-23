package jp.co.frevoworks.kintai.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jp.co.frevoworks.kintai.dto.Result;
import jp.co.frevoworks.kintai.websocket.EchoHandler;

@RestController
@RequestMapping("/read")
public class ReadController {
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Result> post(@RequestParam("msg") String msg, UriComponentsBuilder uriComponentsBuilder)
      throws IOException {
    EchoHandler.onSendMeasure(msg);
    return new ResponseEntity<Result>(HttpStatus.OK);
  }
}

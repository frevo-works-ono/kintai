package jp.co.frevoworks.kintai.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.frevoworks.kintai.websocket.EchoHandler;

@Controller
@RequestMapping("login")
public class LoginController {

  @RequestMapping(value = "/")
  public String index(Model model) {
    return "index";
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public String post(@RequestParam("msg") String msg, Model model) throws IOException {
    EchoHandler.onSendMeasure(msg);
    return "index";
  }
}

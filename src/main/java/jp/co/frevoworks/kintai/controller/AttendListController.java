package jp.co.frevoworks.kintai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("attend")
public class AttendListController {

  @RequestMapping(value = "/")
  public String index(Model model) {
    return "attend";
  }
}

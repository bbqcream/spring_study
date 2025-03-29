package hellospring.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String hellomvc(@RequestParam(value="name", required = false) String name, Model model){
        model.addAttribute("name", name);
        return "hello-templete";
    }

    @GetMapping("hello-string")
    @ResponseBody
        public String hellostring(@RequestParam("name") String name){
        return "hello " + name; // html이 하나도 들어가지 않음
    }

    // json파일로 나옴
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}

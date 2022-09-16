package qi.shen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qi.shen.entity.Resource;
import qi.shen.service.ResourceService;

import java.util.List;

@Controller
@RequestMapping("test")
public class TestController {

    @Autowired
    private ResourceService resourceService;

    @ResponseBody
    @RequestMapping("find")
    public String findAll() {
        List<Resource> all = resourceService.findAll();
        return all.toString();
    }

}

package cap.controller;

import cap.model.Admin;
import cap.service.AdminService;
import cap.util.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/")
public class AdminController {
    @Resource
    private AdminService adminService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(@RequestParam(value = "pageNo", required = true, defaultValue = "1") Integer pageNo) {
        PageBean pageBean = adminService.findByPage(pageNo, 5);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageBean", pageBean);
        modelAndView.setViewName("list");
        return modelAndView;

    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String update(Model model, @RequestParam int id) {
        model.addAttribute("admin", adminService.findAdmin(id));
        return "update";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(Admin admin) {
        int total = adminService.update(admin.getId(), admin);
        System.out.println("update:" + total);
        return "list";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String update(int id) {
        int total = adminService.delete(id);
        System.out.println("delete:" + total);
        return "list";
    }

    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String insert() {
        return "insert";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(Admin admin) {
        int total = adminService.insert(admin);
        System.out.println("insert:" + total);
        return "list";
    }

}
package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.EmpService;

//@Controller
@RequestMapping("/")
public class EmpHandeller {

    //@Autowired
    EmpService empService;

    public EmpHandeller(EmpService empService) {
        this.empService = empService;
    }
     
    
    //@Autowired
    public EmpService getEmpService() {
        return empService;
    }

    public void setEmpService(EmpService empService) {
        this.empService = empService;
    }
 

    @RequestMapping(value = "/add_Employee", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute() Employees employees, HttpServletRequest request, HttpServletResponse response) throws Exception {
        empService.addEmployee(employees);

        return "add-employee-success";
    }

    @RequestMapping(value = "/delete_employee", method = RequestMethod.GET)
    public String editEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "delete-employee-success";
    }

    @RequestMapping(value = "/edit_employee", method = RequestMethod.GET)
    public String deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "edit-employee-success";
    }

    @RequestMapping(value = "/list_employee", method = RequestMethod.GET)
    public String listEmployee(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Employees> empList = empService.getEmpList();
        model.addAttribute("empList", empList);
        return "list-employee";
    }

  
    

}

package service;

import java.util.List;
import model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EmpRepository;

//@Service
public class EmpService {

    //@Autowired
    EmpRepository empRepository;

    public EmpService(EmpRepository empRepository) {
        this.empRepository = empRepository;
    }
    
    //@Autowired
    public EmpRepository getEmpRepository() {
        return empRepository;
    }

    public void setEmpRepository(EmpRepository empRepository) {
        this.empRepository = empRepository;
    }
 

    public void addEmployee(Employees employees) {
        empRepository.addEmployee(employees);
    }

    public List<Employees> getEmpList() {
        List<Employees> empList = empRepository.getEmpList();
        return empList;
    }

}

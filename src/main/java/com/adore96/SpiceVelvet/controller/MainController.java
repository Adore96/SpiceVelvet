package com.adore96.SpiceVelvet.controller;

import com.adore96.SpiceVelvet.bean.UserDataBean;
import com.adore96.SpiceVelvet.model.User;
import com.adore96.SpiceVelvet.repository.UserRepository;
import com.adore96.SpiceVelvet.securityConfig.BcryptFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author kasun_k ON 12/16/21
 * @project SpiceVelvet
 */

@RestController
//@CrossOrigin(value = "http://localhost:4200")
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    BcryptFunction bcryptFunction;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping("/403")
    public String AccessDenied() {
        return "403";
    }

    @RequestMapping("/Newuser")
    public String newStudent() {
        return "Newuser";
    }

    @RequestMapping("/logout-success")
    public String logout() {
        return "Login";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @DeleteMapping("/DeleteStudent/{id}")
    public List<User> DeleteStudent(@PathVariable String id) {
        System.out.println("DeleteStudent Method method in Main Controller.");

        int Id = Integer.valueOf(id);

        userRepository.deleteById(Id);
        return userRepository.findAll();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping("/EditStudent/{id}")
    public String EditStudent(@PathVariable String id, Model model) {
        System.out.println("EditStudent Method in Main Controller.");

        int Id = Integer.valueOf(id);

        User user1 = new User();
        user1 = userRepository.getOne(Id);

        model.addAttribute("userdetails", user1);
        return "UserUpdate";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping("/")
    public String main(Model model) {

        List<User> users = userRepository.findAll();
        List<UserDataBean> dataBeans = new ArrayList<>();

        for (int i = 0; i < users.size(); i++) {
            UserDataBean userDataBean = new UserDataBean();
            userDataBean.setId(String.valueOf(users.get(i).getId()).trim());
            userDataBean.setFname(users.get(i).getFname().trim());
            userDataBean.setLname(users.get(i).getLname().trim());
            userDataBean.setUsername(users.get(i).getUsername().trim());
            userDataBean.setPassword(users.get(i).getPassword().trim());
            userDataBean.setTelephone(String.valueOf(users.get(i).getTelephone()).trim());

            dataBeans.add(userDataBean);
        }

        model.addAttribute("dataBean", dataBeans);
        return "Index";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping(value = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RedirectView signup(@RequestBody UserDataBean dataBean) {
        System.out.println("Calling signup method in Main Controller.");
        BcryptFunction bcryptFunction = new BcryptFunction();

        User users2 = new User();

        users2.setFname(dataBean.getFname().trim());
        users2.setLname(dataBean.getLname().trim());
        users2.setUsername(dataBean.getUsername().trim());
        users2.setPassword(bcryptFunction.encoder().encode(dataBean.getPassword()).trim());
        users2.setTelephone(Integer.parseInt(dataBean.getTelephone().trim()));

        userRepository.save(users2);

        return new RedirectView("/");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping("/EditStudent/updateStudent")
    public RedirectView updateStudent(UserDataBean userDataBean) {

        User users2 = new User();

        users2.setFname(userDataBean.getFname().trim());
        users2.setLname(userDataBean.getLname().trim());
        users2.setUsername(userDataBean.getUsername().trim());
        users2.setPassword(userDataBean.getPassword().trim());
        users2.setTelephone(Integer.parseInt(userDataBean.getTelephone().trim()));

        userRepository.save(users2);

        return new RedirectView("/");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping("/findAllUsers")
    public List<User> FindAllUsers() {
        return userRepository.findAll();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping("/findById/{id}")
    public Optional<User> findById(@PathVariable String id) {
        int newid = Integer.parseInt(id);
        return userRepository.findById(newid);
    }
}

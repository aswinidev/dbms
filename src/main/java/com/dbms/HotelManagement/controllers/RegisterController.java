package com.dbms.HotelManagement.controllers;


import com.dbms.HotelManagement.dao.UserDAS;
import com.dbms.HotelManagement.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {


    @GetMapping("/register")
    public String showForm(Model model, HttpSession session) {
//       TODO when user is there return welcome page. or home page.
        if (true) {
            return "redirect:/welcome";
        }
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model, BindingResult bindResult, HttpSession session, RedirectAttributes redirectAtt) {
        String username = user.getpEmail();
        String errMsg = null;
//
        try {

            if (!UserDAS.alreadyExist(username)) {
                //            TODO Implement the creation / setting of new user.
                //            TODO Email verification if Required.
                //            TODO Auto Login.
                return "redirect:/welcome";
            }
            errMsg = "This email is already registered. ";

        } catch (Exception e) {
            errMsg = "Email is do not exist please enter a valid email.";
        }

        model.addAttribute("user", user);
        notificationService.displayErrorNotification(model, errMsg);
        return "register";
    }


    @GetMapping("/confirm-account")
    public String confirmAccountRegister(@RequestParam("token") String token, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        User user = UserDAS.findUserByToken(token);

        if (user != null) {
            UserDAS.updateActivity(user.getUserID(), 1);
            notificationService.redirectWithSuccessToast(redirectAttributes, "Account Confirmed Successfully...");

            return "redirect:/login";
        } else {
            notificationService.redirectWithErrorToast(redirectAttributes, "Account Confirmed Not Successfull...");
            return "redirect:/welcome";
        }

    }
}

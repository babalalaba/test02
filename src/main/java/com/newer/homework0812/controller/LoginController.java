package com.newer.homework0812.controller;

import com.newer.homework0812.domain.admins;
import com.newer.homework0812.service.adminService;
import com.newer.homework0812.util.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Autowired
    private adminService adminService;
    @Autowired
    private JwtTokenUtil jwt;
    @Value("${auth.header}")
    private String header;
    @PostMapping("/Login1")
public ResponseEntity<?> LoginTest(@RequestParam("aname")String aname,@RequestParam("pwd")String pwd){
admins admins=adminService.getAdmins(aname,pwd);
System.out.println(admins);
if(admins!=null){
String token =jwt.createJwt(aname,pwd);
return new ResponseEntity<>(token,HttpStatus.OK);
}
return new ResponseEntity<>("fail",HttpStatus.OK);
}
@RequestMapping("/check")
public ResponseEntity<?> check(HttpServletRequest request){
String token=request.getHeader(header);
if (token!=null){
    Claims claims=jwt.parseJWT(token);
    System.out.println(claims.get("realname")+","+claims.get("sex")+","+claims.get("weight"));
    System.out.println(claims.getIssuer());
    return new ResponseEntity<>(claims.getIssuer(),HttpStatus.OK);
}
return  new ResponseEntity<>("fail",HttpStatus.OK);
}





    @GetMapping("login")
public ResponseEntity<?> login(@RequestParam("aname")String aname,@RequestParam("pwd")String pwd,HttpSession session){
    if("admin".equals(aname) && "admin".equals(pwd)){
        admins admins=new admins();
        admins.setAname("admin");
        admins.setPwd("******");
        admins.setAid(1);
        System.out.println(admins.toString());
        session.setAttribute("admins",admins);
        return new ResponseEntity<>(admins,HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);

}
@GetMapping("/userSession")
public ResponseEntity<?> userSession(HttpSession session){
        admins admins= (com.newer.homework0812.domain.admins) session.getAttribute("admins");
        System.out.println(admins.getAname());
        return  new ResponseEntity<>(admins,HttpStatus.OK);
}
@GetMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session){
        admins admins= (com.newer.homework0812.domain.admins) session.getAttribute("admins");
        System.out.println("这是logout");
        session.setAttribute("admins",null);
        return new ResponseEntity<>(admins,HttpStatus.OK);
}
}

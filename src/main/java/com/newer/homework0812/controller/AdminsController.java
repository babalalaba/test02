package com.newer.homework0812.controller;


import com.newer.homework0812.domain.admins;
import com.newer.homework0812.domain.cards;
import com.newer.homework0812.service.adminService;
import com.newer.homework0812.util.SecurityCode;
import com.newer.homework0812.util.SecurityImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.List;


@Controller
public class AdminsController {
    @Autowired
    private adminService as;
    private String str;//程序输出的验证码

    @ResponseBody
    @GetMapping("/cards")
    public List<cards> selectCards(){
        List<cards> list = as.selectCards();
        return list;
    }



    /**
     * 判断用户名和密码是否存在在用户表中
     * @param aname
     * @param pwd
     * @return
     */
    @RequestMapping("getAdmin")
    @ResponseBody
    public int checkName(@RequestParam("aname") String aname,
                         @RequestParam("pwd")String pwd,
                         @RequestParam("yzm") String yzm, HttpSession session){
       int msg=0;
        admins ad=as.getAdmins(aname,pwd);
        System.out.println(ad);
        if (str.equals(yzm)){//判断验证码

            if (ad!=null){//用户名和密码在用户表中存在
                msg=ad.getAid();//用户名密码及验证码都正确情况
                updAdmins(new Date(),aname);//修改登录时间

            }else{
                msg=2;//用户名或密码错误情况
            }
        }else {
            msg=3;//验证码输入错误情况
        }
        session.setAttribute("admins",ad);
        return msg;
    }

    /**
     * 修改登录时间
     * @param login_time
     * @param aname
     */
    public void updAdmins(Date login_time,String aname){
        as.updAdmins(login_time,aname);
    }

    /**
     * 生成图片验证码
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("img")
public void createImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
  str = SecurityCode.getSecurityCode();
    BufferedImage bufimg = SecurityImage.createImage(str);
    // 设置响应头部不缓存
    response.setHeader("Pragma", "No-cache");
    response.setHeader("cache-Control", "no-cache");
    // 设置内容响应格式
    response.setContentType("image/jpeg");
    // 设置过期时间
    response.setDateHeader("Expirs", 0);
    // 通过图片io流写出去
    ImageIO.write(bufimg, "JPEG", response.getOutputStream());
}


    @RequestMapping("/findAll")
    //@RequestMapping(value = "findAll",method =RequestMethod.POST)
    // @PostMapping("findAll")
    @ResponseBody
    public int findAll(){

        return 1;
    }
    @RequestMapping("/inUser")
    @ResponseBody
    public ResponseEntity<?> inUser(int aid, String pwd){
        admins admins=as.selectByAid(aid);
        admins.setPwd(pwd);
        Integer count=as.updAdmin(admins);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }
}

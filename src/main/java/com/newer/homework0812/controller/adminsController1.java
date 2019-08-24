package com.newer.homework0812.controller;

import com.newer.homework0812.domain.admins;
import com.newer.homework0812.domain.cards;
import com.newer.homework0812.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/hosp")
public class adminsController1 {
    @Autowired
    private adminService adminService;
    private String str;

    @GetMapping("/cards")
    public ResponseEntity<?> selectCards() {
        List<cards> list = adminService.selectCards();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * 判断用户名和密码是否存在在用户表中
     * @param aname
     * @param pwd
     * @return
     */
   /* @PostMapping("/admin/{aname}/{pwd}/{yzm}")
    @ResponseBody
    public int checkName(@RequestParam("aname") String aname,
                         @RequestParam("pwd")String pwd,
                         @RequestParam("yzm") String yzm){
        int msg=0;
        admins ad=adminService.getAdmins(aname,pwd);
        System.out.println(ad);
        if (str.equals(yzm)){//判断验证码

            if (ad!=null){//用户名和密码在用户表中存在
                msg=1;//用户名密码及验证码都正确情况
                updAdmins(new Date(),aname);//修改登录时间

            }else{
                msg=2;//用户名或密码错误情况
            }
        }else {
            msg=3;//验证码输入错误情况
        }

        return msg;
    }*/

    /**
     * 修改登录时间
     * @param login_time
     * @param aname
     */
    public void updAdmins(Date login_time,String aname){
        adminService.updAdmins(login_time,aname);
    }

    /**
     * 生成图片验证码
     * * @param request
     * *@param response
     * @throws IOException
     */
    /*@GetMapping("/img")
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
    }*/


    @RequestMapping("/findAll")
    //@RequestMapping(value = "findAll",method =RequestMethod.POST)
    // @PostMapping("findAll")
    @ResponseBody
    public int findAll(){

        return 1;
    }

    @PutMapping("/cards")
    public ResponseEntity<?> updCard(cards c){
        int count = adminService.updCard(c);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    @PostMapping("/cards")
    public ResponseEntity<?> addCard(cards c){
        c.setNewdate(new Date());
        System.out.println(c);
        int count = adminService.addCard(c);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    @GetMapping("/cards/{cid}")
    public ResponseEntity<?> selectCards(@PathVariable("cid")int cid) {
        cards c = adminService.selectByCid(cid);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

}

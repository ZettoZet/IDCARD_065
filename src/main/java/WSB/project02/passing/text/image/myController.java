/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WSB.project02.passing.text.image;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author priza
 */
@Controller
public class myController {

    @RequestMapping("/sendData")
    @ResponseBody
    public String getData(@RequestParam("mytext") String getText,
            @RequestParam("myimage") MultipartFile image,
            @RequestParam("tanggal") Date getDate) throws IOException {

        String blob = Base64.encodeBase64String(image.getBytes());

        SimpleDateFormat tanggal = new SimpleDateFormat("dd-MMMM-yyyy");

        String newTanggal = tanggal.format(getDate);

        return "<div class='box'>"
                
                + " <br><center>PROVINSI JAWA TENGAH</center> "
                + " <br><center>KABUPATEN KLATEN</center> "
                + "<hr/>"
                + "<p>Nama: " + getText + "</p>"
                + "<p>Tanggal Lahir: " + getDate + "</p>"
                + "<img src= 'data:image/jpeg;Base64," + blob
                + "'alt=\"Photo confirmation\" id=\"display-image\" ></img>\n"
                //box
                + "<style>.box {"
                + "position: absolute;"
                + "left: 50%;"
                + "top: 50%;"
                + "transform: translate(-50%, -50%);"
                + "height: 400px;"
                + "width: 600px;"
                + "background: rgb(190,190,190);"
                + "overflow: hidden;"
                + "border-radius: 20px;"
                + "box-shadow: 0 0 20px 8px #d0d0d0;"
                + "background-size: cover;"
                + "background-repeat: no-repeat;}"
                //border hr
                + "hr {"
                + "border: 1px solid black;}"
                //text
                + "p {"
                + "font-weight: 900;"
                + "width: 100%;"
                + "padding: 0 10px;}"
                //img
                + "img {"
                + "float: right;"
                + "padding: 0px 25px 50px 0px;"
                + "width: 150px;"
                + "height: 200px;}"
                ;

    }
}
package com.zt.studyproject;

import com.zt.utils.OkHttpUtils;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@Log4j2
class StudyProjectApplicationTests {

    @Test
    void contextLoads() {
        //创建list集合，存储产品内容文件夹名称，批量创建产品内容文件夹
        List<String> contentList = new ArrayList<>();
        contentList.add("01.test1");
        contentList.add("02.test2");
        contentList.add("03.test3");
        contentList.add("04.test4");
        contentList.add("05.test5");

        for (String s : contentList) {
            String json="{\"folder_resource\":{\"folder\":{\"name\":\""+s+"\",\"container_type_id\":\"HYT.FOLDER.PORDUCT.CONTENT\",\"security_policy_list\":[{\"id\":37}],\"metadata\":{\"metadata_element_list\":[]},\"metadata_model_id\":\"HYT.MODEL.PORDUCT.CONTENT FOLDER\"}}}";
            String sync = OkHttpUtils.builder()
                    .url("http://damdev.hytera.com:11090/otmmapi/v6/folders/101f42dd9978b4ba04ce28c10375e6776172f7c7")
                    .addHeader("X-Requested-By","950749932")
                    .addHeader("Authorization","Bearer otmmToken 2835b95ed060c9912706510b95873486c7c04119")
                    .addHeader("Content-Type", "application/json; charset=UTF-8")
                    .addParam("username", "hytera")
                    .addParam("password", "hytera2020")
                    .post(true,json).async();
            log.info(sync+Thread.currentThread().getName());
        }
        System.out.println(LocalDateTime.now().toLocalTime());

    }



}

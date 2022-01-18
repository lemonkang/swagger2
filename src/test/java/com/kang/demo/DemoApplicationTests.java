package com.kang.demo;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadVideoRequest;
import com.aliyun.vod.upload.resp.UploadVideoResponse;
import com.kang.demo.constant.AccessKeyConstant;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    void uploadvideo(){
        String title="upload by sdk";
        String fileName="D:/Images/test.mp4";
        String accessKeyId=AccessKeyConstant.accessKeyId;
        String accessKeySecret=AccessKeyConstant.accessKeySecret;
        UploadVideoRequest request = new UploadVideoRequest(accessKeyId,accessKeySecret,title,fileName);
        request.setPartSize(1*1024*1024L);
        UploadVideoImpl uploader = new UploadVideoImpl();
        UploadVideoResponse response = uploader.uploadVideo(request);
        System.out.println("获取上传视屏的Id"+response.getRequestId());
        if (response.isSuccess()){
            System.out.println("获取上传视屏的Id成功"+response.getRequestId());
        }else {
            System.out.println("获取上传视屏的失败"+response.getRequestId());
        }


    }

}

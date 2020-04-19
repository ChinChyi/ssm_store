package com.example.demo.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;


public class UploadFile {

    private String accessKey = "gFO-8IYwjVPzNAmbAORHJCgGwIHzcyIbFhZ3yVIi";
    private String secretKey = "hllClWcBETkcn0aI8SROEe4Y1blV5gEQwgUHAQQu";
    private String upToken;
    private Auth auth;
    private com.qiniu.storage.Configuration cfg;
    private UploadManager uploadManager;
    private String locaFilePath;
    public UploadFile() throws Exception{
        //构造一个带指定Zone对象的配置类
        this.cfg = new com.qiniu.storage.Configuration(Zone.zone1());
        this.auth = Auth.create(this.accessKey, this.secretKey);
        //...生成上传凭证，然后准备上传
        this.uploadManager = new UploadManager(cfg);

    }

    /*
     * 上传图片接口（内部使用）
     */
    private String uploadPhoto(String bucket, String localFilePath){
        try {
            this.upToken = auth.uploadToken(bucket);
            this.locaFilePath = localFilePath;
            Response response = this.uploadManager.put(this.locaFilePath, null, upToken);
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        /*
        System.out.println(putRet.key);
        System.out.println(putRet.hash);
        */
            if(bucket.equals("secondhand2")) {
                return "http://q28tiuws9.bkt.clouddn.com/" + putRet.key;
            }else{
                return "http://q28tiuws9.bkt.clouddn.com/" + putRet.key;
            }
        }catch (QiniuException ex){
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
            return null;
        }
    }
    /*
     * 上传头像接口
     * 接收参数：localFilePath  本地图片地址
     * 返回参数：成功返回图片url，失败返回null
     */
    public String uploadHeadPhoto(String localFilePath) throws Exception{
        String bucket = "qinqiweb";
        return uploadPhoto(bucket, localFilePath);
    }
    /*
     * 上传图片接口
     * 接收参数：localFilePath  本地图片地址
     * 返回参数：成功返回图片url，失败返回null
     */
    public String uploadDiaryPhoto(String localFilePath) throws Exception{
        String bucket = "qinqiweb";
        return uploadPhoto(bucket, localFilePath);
    }

}

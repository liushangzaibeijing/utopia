package com.xiu.utopia.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by zhangwb on 2018/5/15.
 */
public class FileUtil {
    private static Logger log= LoggerFactory.getLogger(FileUtil.class);

    public static boolean save(byte[] file, String filePath, String fileName) throws Exception {
        try{
            File targetFile = new File(filePath);
            if(!targetFile.exists()){
                targetFile.mkdirs();
            }
            FileOutputStream out = new FileOutputStream(filePath+fileName);
            out.write(file);
            out.flush();
            out.close();

            return true;
        }
        catch(Exception ex){
            log.info("文件保存异常"+ex.toString());
            return false;
        }
    }
}

package com.xiu.utopia.web;

import com.xiu.utopia.dto.ResponseDto;
import java.util.Map;

/**
 * Created by zhangwb on 2018/5/9.
 */
public class BaseController {
    public ResponseDto success(Map data)
    {
        ResponseDto dto=new ResponseDto();
        dto.setCode(20000);
        dto.setState(true);
        dto.setData(data);

        return dto;
    }

    public ResponseDto fail(Map data)
    {
        ResponseDto dto=new ResponseDto();
        dto.setCode(44444);
        dto.setState(false);
        dto.setData(data);

        return dto;
    }

    public ResponseDto success(Map data, String msg)
    {
        ResponseDto dto=new ResponseDto();
        dto.setCode(20000);
        dto.setState(true);
        dto.setData(data);
        if (!msg.isEmpty())
        {
            dto.setMessage(msg);
        }

        return dto;
    }

    public ResponseDto fail(Map data, String msg)
    {
        ResponseDto dto=new ResponseDto();
        dto.setState(false);
        dto.setData(data);

        if (!msg.isEmpty())
        {
            dto.setMessage(msg);
        }

        return dto;
    }

}

package controller.converter;

import org.springframework.core.convert.converter.Converter;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 14:11 2017/11/20
 * @Modified By:
 */
public class StringTrimConverter implements Converter<String,String> {
    @Override
    public String convert(String source){
        try{
            //去掉字符串两边的空格，如果去除后为空则返回null
            if(source!=null){
                source=source.trim();
                if(source.equals("")){
                    return null;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return source;
    }
}

package me.edagarli.pro;

import com.alibaba.common.convert.Convert;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String args[]) {

        String json = "[\n" +
                "    \"{\\\"appCatName\\\":\\\"market\\\",\\\"appName\\\":\\\"test\\\",\\\"entityId\\\":\\\"99930982\\\",\\\"instanceId\\\":\\\"313067d122e5444ab7bb33d51e89a7dd\\\",\\\"internalType\\\":1}\",\n" +
                "    \"{\\\"appCatName\\\":\\\"market\\\",\\\"appName\\\":\\\"test\\\",\\\"entityId\\\":\\\"99930982\\\",\\\"instanceId\\\":\\\"b2c89004abf54520b3aa0a68db06f797\\\",\\\"internalType\\\":1}\",\n" +
                "    \"{\\\"appCatName\\\":\\\"market\\\",\\\"appName\\\":\\\"test\\\",\\\"entityId\\\":\\\"99930982\\\",\\\"instanceId\\\":\\\"3c7a98db4c8c4cc9956dea4dd8099467\\\",\\\"internalType\\\":1}\",\n" +
                "    \"{\\\"appCatName\\\":\\\"market\\\",\\\"appName\\\":\\\"test\\\",\\\"entityId\\\":\\\"99930982\\\",\\\"instanceId\\\":\\\"17510771c4154271a47a6d9f26d6fbcf\\\",\\\"internalType\\\":1}\",\n" +
                "    \"{\\\"appCatName\\\":\\\"market\\\",\\\"appName\\\":\\\"test\\\",\\\"entityId\\\":\\\"99930982\\\",\\\"instanceId\\\":\\\"b32e4267cadc4033b4cd3b441f9408a7\\\",\\\"internalType\\\":1}\"\n" +
                "]";
        JSONArray jsonArray = JSONArray.parseArray(json);
        if (CollectionUtils.isEmpty(jsonArray)) {
            return ;
        }
        jsonArray.stream().map((obj) -> {
            JSONObject jsonObject = JSONObject.parseObject(Convert.asString(obj));
            if (null == jsonObject || null == jsonObject.get("internalType")) {
                return true;
            }
            if (Convert.asByte(jsonObject.get("internalType"))
                    == Convert.asByte(1)) {
                System.out.println(1);
                return true;
            }
            return true;
        }).collect(Collectors.toList());

        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
//        list.stream().map((e) -> {
//            System.out.println(e);
//            return e;
//        }).collect(Collectors.toList());
        list.stream().forEach(integer -> System.out.println(integer));
    }

}

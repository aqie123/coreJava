package aqie;

import java.util.*;

public class Demo17 {
    public static void main(String[] args) {
        Test17 t = new Test17();
        // t.method();
        // t.method2();
        // t.method3();
        // t.method4();
        // t.method5();
        t.method6();
    }
}

class Test17{
    void method(){
        Map<String,String> map = new HashMap<String,String>();
        map.put("Death","Live");
        map.put("Peace","War");

        map.put("文章","马伊琍");
        System.out.println("返回值 "+map.put("文章","姚笛"));
        System.out.println(map);
    }

    // 基本使用
    void method2(){
        Map<String,String> map = new HashMap<>();
        map.put("aqie","123");
        map.put("Tom","456");
        map.put("Bob","789");

        Map<String,String> map2 = new HashMap<>();
        map2.putAll(map);

        System.out.println("删除的元素 "+map.remove("Tom"));
        map.clear();
        System.out.println(map2);
        System.out.println(map);
        System.out.println(map.containsKey("aqie"));
        System.out.println(map.containsValue("123"));
        System.out.println(map.isEmpty());
        System.out.println(map2.size());
        System.out.println(map2.get("Bob"));


    }

    // 迭代  // 遍历方式一 keySet()
    void method3(){
        Map<String,String> map = new HashMap<String,String>();
        map.put("Death","Live");
        map.put("Peace","War");
        map.put("文章","马伊琍");


        Set set = map.keySet();
        System.out.println(set);
        // 遍历set
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            String key = it.next();
            System.out.println("键 "+key + "值 "+map.get(key));
        }
    }

    // 遍历方式二  values()
    void method4(){
        Map<String,String> map = new HashMap<>();
        map.put("Death","Live");
        map.put("Peace","War");
        map.put("文章","马伊琍");

        Collection<String> list = map.values();
        Iterator<String> values = list.iterator();
        while(values.hasNext()){
            String value = values.next();
            System.out.println("值 "+ value);
        }
    }

    // 如何让返回的单列集合对象,既存储键又存储值
    // 遍历方式三  entrySet() 推荐
    void method5(){
        Map<String,String> map = new HashMap<>();
        map.put("Death","Live");
        map.put("Peace","War");
        map.put("文章","马伊琍");

        Set<Map.Entry<String,String>> entries = map.entrySet();
        Iterator<Map.Entry<String,String>> it = entries.iterator();
        while(it.hasNext()){
            Map.Entry<String,String> entry = it.next();
            System.out.println("键 "+entry.getKey() + "  值 "+entry.getValue());
        }
    }

    // map的遍历是无序的  有序可用 linkedmap
    void method6(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");

        Iterator<Integer> it = map.keySet().iterator();
        while(it.hasNext()){
            Integer key = it.next();
            if(key.equals(3)){
                map.remove(3);
            }
        }
    }
}

// 描述一条map数据  ,一个Entry对象就是一条Map数据
// Collection list = new ArrayList();
// list.add(Entry);
/*
class Entry<K,V>{
    K key;
    V value;
}
*/
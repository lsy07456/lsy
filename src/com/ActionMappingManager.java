package com;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/*
 * 对应framework.xml中的actions节点
 * action节点不止一个
 * 用来来管理ActionMapping类
 */
public class ActionMappingManager {
    //actionMapping类的集合
    private Map<String,ActionMapping> maps=new HashMap<String,ActionMapping>();
     
    public ActionMapping getActionMapping(String name)
    {
          return maps.get(name);
    }
     
    //解析在src项目下的所有配置文件
    //实例化完毕后进行解析
    public ActionMappingManager(String[] file){
        for (String filename : file) {
            Init(filename);
        }
    }
    //init初始化方法
    //解析xml文档
    public void Init(String path){
         
        try {
              InputStream is=this.getClass().getResourceAsStream("/"+path);
              //解析xml
              Document doc=new SAXReader().read(is);
              //获取根节点
              Element root = doc.getRootElement();
              //获取actions节点
              Element actions=(Element)root.elementIterator("actions").next();
              //使用for循环来遍历actions节点下的所有action节点
              for(Iterator<Element> action=actions.elementIterator("action");action.hasNext();)
              {
                  //获取到<action>节点
                  Element actionnext = action.next();
                  //分别获取到action节点中的name属性和class属性
                  String name = actionnext.attributeValue("name");
                  String classname = actionnext.attributeValue("class");
                  //将以上两个属性保存到ActionMapping类中
                  ActionMapping mapp=new ActionMapping();
                  mapp.setClassname(classname);
                  mapp.setName(name);
                  //由于一个action节点下有多个result节点 遍历action下所有的result节点
                  for(Iterator<Element> result=actionnext.elementIterator("result");result.hasNext();)
                  {
                      //获取到result节点
                      Element resultnext = result.next();
                      //提取result节点的name属性值和result节点中的值
                      String resultname = resultnext.attributeValue("name");
                      String resultvalue=resultnext.getText();
                      //将其分别存入到actionMapping中的双列集合中去，方便调用actionMapping类(actionMapping类中就有数据了!)
                      mapp.addResult(resultname, resultvalue);
                      System.out.println(mapp.getName());
                  }
                  //得到所有action节点的集合
                  maps.put(mapp.getName(), mapp);
              }
               
        } catch (Exception e) {
            // TODO: handle exception
        }
      }
    }
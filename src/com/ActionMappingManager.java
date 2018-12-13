package com;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/*
 * ��Ӧframework.xml�е�actions�ڵ�
 * action�ڵ㲻ֹһ��
 * ����������ActionMapping��
 */
public class ActionMappingManager {
    //actionMapping��ļ���
    private Map<String,ActionMapping> maps=new HashMap<String,ActionMapping>();
     
    public ActionMapping getActionMapping(String name)
    {
          return maps.get(name);
    }
     
    //������src��Ŀ�µ����������ļ�
    //ʵ������Ϻ���н���
    public ActionMappingManager(String[] file){
        for (String filename : file) {
            Init(filename);
        }
    }
    //init��ʼ������
    //����xml�ĵ�
    public void Init(String path){
         
        try {
              InputStream is=this.getClass().getResourceAsStream("/"+path);
              //����xml
              Document doc=new SAXReader().read(is);
              //��ȡ���ڵ�
              Element root = doc.getRootElement();
              //��ȡactions�ڵ�
              Element actions=(Element)root.elementIterator("actions").next();
              //ʹ��forѭ��������actions�ڵ��µ�����action�ڵ�
              for(Iterator<Element> action=actions.elementIterator("action");action.hasNext();)
              {
                  //��ȡ��<action>�ڵ�
                  Element actionnext = action.next();
                  //�ֱ��ȡ��action�ڵ��е�name���Ժ�class����
                  String name = actionnext.attributeValue("name");
                  String classname = actionnext.attributeValue("class");
                  //�������������Ա��浽ActionMapping����
                  ActionMapping mapp=new ActionMapping();
                  mapp.setClassname(classname);
                  mapp.setName(name);
                  //����һ��action�ڵ����ж��result�ڵ� ����action�����е�result�ڵ�
                  for(Iterator<Element> result=actionnext.elementIterator("result");result.hasNext();)
                  {
                      //��ȡ��result�ڵ�
                      Element resultnext = result.next();
                      //��ȡresult�ڵ��name����ֵ��result�ڵ��е�ֵ
                      String resultname = resultnext.attributeValue("name");
                      String resultvalue=resultnext.getText();
                      //����ֱ���뵽actionMapping�е�˫�м�����ȥ���������actionMapping��(actionMapping���о���������!)
                      mapp.addResult(resultname, resultvalue);
                      System.out.println(mapp.getName());
                  }
                  //�õ�����action�ڵ�ļ���
                  maps.put(mapp.getName(), mapp);
              }
               
        } catch (Exception e) {
            // TODO: handle exception
        }
      }
    }
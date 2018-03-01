import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import com.easyserver.utils.PathKit;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Sheet;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;

class Test3{
    public Test3() {
    }

    public static void main(String[] args) throws DocumentException {
        //map object array
//        CsvWriter writer=new CsvWriter(PathKit.WEB_ROOT+ File.separator+"test.csv", ',', Charset.defaultCharset());
//        String[] arr={"a","b"};
//        String[] arr2={"a1","b1"};
//        try {
//            writer.writeRecord(arr);
//            writer.writeRecord(arr2);
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //pol xml解析
//        String filename=PathKit.WEB_ROOT+File.separator+"test.xml";
//        File file=new File(filename);
//        SAXReader reader=  new SAXReader();
//        try {
//            Document document= reader.read(file);
//            Element root=document.getRootElement();
//            System.out.println(root.element("from").element("form2").getName());
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }
        //解析xml
//        File file=new File(PathKit.WEB_ROOT+File.separator+"申报表接口字段映射关系（4表）.xls");
//        try {
//            HSSFWorkbook workbook=new HSSFWorkbook(new POIFSFileSystem(new FileInputStream(file)));
//            Sheet sheet=workbook.getSheetAt(0);
//            String val=sheet.getRow(0).getCell(0).getStringCellValue();
//            System.out.println(val);
//         } catch (IOException e) {
//            e.printStackTrace();
//        }
        Cat wildcat=new WildCat();
        System.out.println(wildcat instanceof Cat);
    }

}


class Cat{
    String head;
    String body;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

class WildCat extends Cat{

}
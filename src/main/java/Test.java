import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2018/2/11 0011.
 */
public class Test {
    public static void main(String[] args) {
        String[] col={"合计额","期初余额","发生额","应扣除金额","实际扣除金额","期末余额",};
        String[] row={"17","税率11","税率6a","包含","税率5","税率3","免抵","免税",};
        String s="\"msdysfwbqykcje\": 0.00,//免税的项目 本期应扣除金额\n" +
                "\"sslysfwqcye\": 0.00,//税率6a期初余额\n" +
                "\"sslysfw5qcyenew\": 0.00, //税率5期初余额\n" +
                "\"tslysfwqcye\": 0.00,//税率3期初余额\n" +
                "\"sslysfw5bqykcjenew\": 0.00,//税率5本期应扣除金额\n" +
                "\"eslysfwbqsjkcje\": 0.00,//税率11本期实际扣除金额\n" +
                "\"msdysfwbqsjkcje\": 0.00,//免税的项目 本期实际扣除金额\n" +
                "\"sslysfwqmye\": 0.00,//税率6a期末余额\n" +
                "\"sslysfwqmyenew\": 0.00,//税率6（包含金融商品转让项目）期末余额\n" +
                "\"tslysfwqmye\": 0.00,//税率3期末余额\n" +
                "\"yxdcznfwqcye\": 0.00,//税率17 期初余额\n" +
                "\"sslysfwbqsjkcjenew\": 0.00,//税率6（包含金融商品转让项目）本期实际扣除金额\n" +
                "\"yxdcznfwhje\": 0.00,//税率17合计额\n" +
                "\"yxdcznfwbqykcje\": 0.00,//税率17本期应扣除金额\n" +
                "\"sslysfwbqfse\": 0.00, //税率6a 本期发生额\n" +
                "\"mdtsdysfwbqykcje\": 0.00,//免抵退税项目 本期应扣除金额\n" +
                "\"eslysfwbqfse\": 0.00,//税率11本期发生额\n" +
                "\"eslysfwqcye\": 0.00,//税率11期初余额\n" +
                "\"yxdcznfwbqsjkcje\": 0.00,//税率17本期实际扣除金额\n" +
                "\"tslysfwbqykcje\": 0.00,//税率3本期应扣除金额\n" +
                "\"eslysfwbqykcje\": 0.00,//税率11本期应扣除金额\n" +
                "\"sslysfwhje\": 0.00,//税率6a 合计额\n" +
                "\"eslysfwqmye\": 0.00,//税率11期末余额\n" +
                "\"sslysfw5bqsjkcjenew\": 0.00,//税率5本期实际扣除金额\n" +
                "\"sslysfwbqykcje\": 0.00,//税率6a 本期应扣除金额\n" +
                "\"sslysfw5hjenew\": 0.00, //税率5 合计额\n" +
                "\"sslysfwqcyenew\": 0.00,//税率6（包含金融商品转让项目）期初余额\n" +
                "\"sslysfw5bqfsenew\": 0.00,//税率5本期发生额\n" +
                "\"msdysfwbqfse\": 0.00,//免税的项目本期发生额\n" +
                "\"sslysfwhjenew\": 0.00,//税率6（包含金融商品转让项目）合计额\n" +
                "\"mdtsdysfwhje\": 0.00,//免抵退税项目合计额\n" +
                "\"sslysfwbqykcjenew\": 0.00,//税率6（包含金融商品转让项目）本期应扣除金额\n" +
                "\"mdtsdysfwqcye\": 0.00,//免抵退税项目期初余额\n" +
                "\"mdtsdysfwbqsjkcje\": 0.00,//免抵退税项目本期实际扣除金额\n" +
                "\"sslysfwbqsjkcje\": 0.00,//税率6a本期实际扣除金额\n" +
                "\"sslysfw5qmyenew\": 0.00,//税率5 期末余额\n" +
                "\"yxdcznfwbqfse\": 0.00,//税率17 本期发生额\n" +
                "\"tslysfwhje\": 0.00,//税率3合计额\n" +
                "\"mdtsdysfwqmye\": 0.00,//免抵退税项目期末余额\n" +
                "\"tslysfwbqsjkcje\": 0.00,//税率3本期实际扣除金额\n" +
                "\"msdysfwqcye\": 0.00,//免税的项目期初余额\n" +
                "\"msdysfwqmye\": 0.00,//免税的项目期末余额\n" +
                "\"mdtsdysfwbqfse\": 0.00,//免抵退税项目本期发生额\n" +
                "\"sslysfwbqfsenew\": 0.00,//税率6（包含金融商品转让项目）本期发生额\n" +
                "\"eslysfwhje\": 0.00,//税率11合计额\n" +
                "\"tslysfwbqfse\": 0.00,//税率3本期发生额\n" +
                "\"msdysfwhje\": 0.00,//免税的项目合计额\n" +
                "\"yxdcznfwqmye\": 0.00//税率17期末余额";
        String[] allFields=s.split("\n");
        System.out.println(allFields.length);
        Map<String,String> allFieldsMap=new HashMap();
        for (String allField : allFields) {
            StringBuffer count =new StringBuffer();
            for (int i = 0; i < col.length; i++) {
                String field = allFields[i];
                if (Pattern.compile(col[i]).matcher(allField).find()) {
                    count.append((i+1)+"");
                }
            }
            for (int i = 0; i < row.length; i++) {
                String field = allFields[i];
                if (Pattern.compile(row[i]).matcher(allField).find()) {
                    count.append((i+1)+"");
                }
            }
            System.out.println(count);
            Matcher matcher=Pattern.compile("\"(.*?)\"").matcher(allField);
            matcher.find();
            String subField=matcher.group(0).replace("\"","");
            allFieldsMap.put(count.toString(),subField);

        }
        System.out.println(allFieldsMap);
        System.out.println(allFieldsMap.get("11"));
        String[] headers={"MSXSE","QCYE","BQFSE","BQYKCJE","BQSJKCJE","QMYE"};
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < headers.length; i++) {
            String header = headers[i];
            for (int j = 1; j < 9; j++) {
                StringBuffer count=new StringBuffer();
                count.append(i+1).append(j);
                String newField=allFieldsMap.get(count.toString());
                System.out.println(count+"-"+newField);
                sb.append("SUBSTRING_INDEX(SUBSTRING_INDEX("+headers[i]+",',', "+j+"), ',', -1) as field,".replace("field",newField));
            }


        }
        System.out.println(sb.toString());
      }
}

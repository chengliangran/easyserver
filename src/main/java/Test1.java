import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2018/2/11 0011.
 */
public class Test1 {
    public static void main(String[] args) {
        String text="ajyfsjsxsejzbnlj  （二）按简易办法计税销售额    5  即征即退项目（本年累计）\n" +
                "ajyfsjsxsejzby  （二）按简易办法计税销售额    5  即征即退项目（本月数）\n" +
                "ajyfsjsxseybbnlj  （二）按简易办法计税销售额    5  一般项目（本年累计）\n" +
                "ajyfsjsxseybby  （二）按简易办法计税销售额    5  一般项目（本月数）\n" +
                "ajynsjcybjseybbnlj  按简易计税办法计算的纳税检查应补缴税额      22  一般项目（本年累计）\n" +
                "ajynsjcybjseybby  按简易计税办法计算的纳税检查应补缴税额      22  一般项目（本月数）\n" +
                "asysljsnsjcybjseybbnlj  按适用税率计算的纳税检查应补缴税额  16  一般项目（本年累计）\n" +
                "asysljsnsjcybjseybby  按适用税率计算的纳税检查应补缴税额  16  一般项目（本月数）\n" +
                "asysljsxsejzbnlj  （一）按适用税率计税销售额  1  即征即退项目（本年累计）\n" +
                "asysljsxsejzby  （一）按适用税率计税销售额  1  即征即退项目（本月数）\n" +
                "asysljsxseybbnlj  （一）按适用税率计税销售额  1  一般项目（本年累计）\n" +
                "asysljsxseybby  （一）按适用税率计税销售额  1  一般项目（本月数）\n" +
                "bqjnqjsejzbnlj  ④本期缴纳欠缴税额     31  即征即退项目（本年累计）\n" +
                "bqjnqjsejzby  ④本期缴纳欠缴税额     31  即征即退项目（本月数）\n" +
                "bqjnqjseybbnlj  ④本期缴纳欠缴税额     31  一般项目（本年累计）\n" +
                "bqjnqjseybby  ④本期缴纳欠缴税额     31  一般项目（本月数）\n" +
                "bqrkcbseybbnlj  本期入库查补税额  37  一般项目（本年累计）\n" +
                "bqrkcbseybby  本期入库查补税额  37  一般项目（本月数）\n" +
                "bqybtsejzby  本期应补(退)税额   34     即征即退项目（本月数）\n" +
                "bqybtseybby  本期应补(退)税额   34     一般项目（本月数）\n" +
                "bqyjsejzbnlj  本期已缴税额  27    即征即退项目（本年累计）\n" +
                "bqyjsejzby  本期已缴税额  27    即征即退项目（本月数）\n" +
                "bqyjseybbnlj  本期已缴税额  27    一般项目（本年累计）\n" +
                "bqyjseybby  本期已缴税额  27    一般项目（本月数）\n" +
                "ckkjzyjksyjseybby  ②出口开具专用缴款书预缴税额  29  一般项目（本月数）\n" +
                "cyjsejzby  ①分次预缴税额   28  即征即退项目（本月数）\n" +
                "cyjseybby  ①分次预缴税额   28  一般项目（本月数）\n" +
                "jqjnsqynsejzbnlj  ③本期缴纳上期应纳税额  30  即征即退项目（本年累计）\n" +
                "jqjnsqynsejzby  ③本期缴纳上期应纳税额  30  即征即退项目（本月数）\n" +
                "jqjnsqynseybbnlj  ③本期缴纳上期应纳税额  30  一般项目（本年累计）\n" +
                "jqjnsqynseybby  ③本期缴纳上期应纳税额  30  一般项目（本月数）\n" +
                "jxsejzbnlj  进项税额  12  即征即退项目（本年累计）\n" +
                "jxsejzby  进项税额  12  即征即退项目（本月数）\n" +
                "jxseybbnlj  进项税额  12  一般项目（本年累计）\n" +
                "jxseybby  进项税额  12  一般项目（本月数）\n" +
                 "jxsezcjzbnlj  进项税额转出  14  即征即退项目（本年累计）\n" +
                "jxsezcjzby  进项税额转出  14  即征即退项目（本月数）\n" +
                "jxsezcybbnlj  进项税额转出  14  一般项目（本年累计）\n" +
                "jxsezcybby  进项税额转出  14  一般项目（本月数）\n" +
                 "jyjsynsejzbnlj  简易计税办法计算的应纳税额  21  即征即退项目（本年累计）\n" +
                "jyjsynsejzby  简易计税办法计算的应纳税额  21  即征即退项目（本月数）\n" +
                "jyjsynseybbnlj  简易计税办法计算的应纳税额  21  一般项目（本年累计）\n" +
                "jyjsynseybby  简易计税办法计算的应纳税额  21  一般项目（本月数）\n" +
                "jzjtsjtsejzbnlj  即征即退实际退税额  35  即征即退项目（本年累计）\n" +
                "jzjtsjtsejzby  即征即退实际退税额  35  即征即退项目（本月数）\n" +
                "mdtbfckxseybbnlj  （三）免、抵、退办法出口销售额     7  一般项目（本年累计）\n" +
                "mdtbfckxseybby  （三）免、抵、退办法出口销售额     7  一般项目（本月数）\n" +
                "mdtytseybbnlj  免、抵、退应退税额  15  一般项目（本年累计）\n" +
                "mdtytseybby  免、抵、退应退税额  15  一般项目（本月数）\n" +
                "mshwxseybbnlj  其中：免税货物销售额  9  一般项目（本年累计）\n" +
                "mshwxseybby  其中：免税货物销售额  9  一般项目（本月数）\n" +
                 "mslwxseybbnlj  免税劳务销售额  10  一般项目（本年累计）\n" +
                "mslwxseybby  免税劳务销售额  10  一般项目（本月数）\n" +
                "msxseybbnlj  （四）免税销售额    8  一般项目（本年累计）\n" +
                "msxseybby  （四）免税销售额    8  一般项目（本月数）\n" +
                "nsjcdzxsejzbnlj  纳税检查调整的销售额  4  即征即退项目（本年累计）\n" +
                "nsjcdzxsejzby  纳税检查调整的销售额  4  即征即退项目（本月数）\n" +
                "nsjcdzxseybbnlj  纳税检查调整的销售额  4  一般项目（本年累计）\n" +
                "nsjcdzxseybby  纳税检查调整的销售额  4  一般项目（本月数）\n" +
                "nsjctzxsejzbnlj  其中：纳税检查调整的销售额    6  即征即退项目（本年累计）\n" +
                "nsjctzxsejzby  其中：纳税检查调整的销售额    6  即征即退项目（本月数）\n" +
                "nsjctzxseybbnlj  其中：纳税检查调整的销售额    6  一般项目（本年累计）\n" +
                "nsjctzxseybby  其中：纳税检查调整的销售额    6  一般项目（本月数）\n" +
                "qcmjcbseybbnlj  期初未缴查补税额  36  一般项目（本年累计）\n" +
                "qcmjcbseybby  期初未缴查补税额  36  一般项目（本月数）\n" +
                "qcmjsejzbnlj  期初未缴税额（多缴为负数）  25  即征即退项目（本年累计）\n" +
                "qcmjsejzby  期初未缴税额（多缴为负数）  25  即征即退项目（本月数）\n" +
                "qcmjseybbnlj  期初未缴税额（多缴为负数）  25  一般项目（本年累计）\n" +
                "qcmjseybby  期初未缴税额（多缴为负数）  25  一般项目（本月数）\n" +
                "qmldsejzby  期末留抵税额   20     即征即退项目（本月数）\n" +
                "qmldseybbnlj  期末留抵税额   20     一般项目（本年累计）\n" +
                "qmldseybby  期末留抵税额   20     一般项目（本月数）\n" +
                "qmmjcbseybbnlj  期末未缴查补税额  38    一般项目（本年累计）\n" +
                "qmmjcbseybby  期末未缴查补税额  38    一般项目（本月数）\n" +
                "qmwjsejzbnlj  期末未缴税额（多缴为负数）  32     即征即退项目（本年累计）\n" +
                "qmwjsejzby  期末未缴税额（多缴为负数）  32     即征即退项目（本月数）\n" +
                "qmwjseybbnlj  期末未缴税额（多缴为负数）  32     一般项目（本年累计）\n" +
                "qmwjseybby  期末未缴税额（多缴为负数）  32     一般项目（本月数）\n" +
                "qzqjsejzby  其中：欠缴税额（≥0）   33    即征即退项目（本月数）\n" +
                "qzqjseybby  其中：欠缴税额（≥0）   33    一般项目（本月数）\n" +
                "sjdksejzbnlj  实际抵扣税额  18    即征即退项目（本年累计）\n" +
                "sjdksejzby  实际抵扣税额  18    即征即退项目（本月数）\n" +
                "sjdkseybbnlj  实际抵扣税额  18    一般项目（本年累计）\n" +
                "sjdkseybby  实际抵扣税额  18    一般项目（本月数）\n" +
                "sqldsejzby  上期留抵税额  13  即征即退项目（本月数）\n" +
                "sqldseybbnlj  上期留抵税额  13  一般项目（本年累计）\n" +
                "sqldseybby  上期留抵税额  13  一般项目（本月数）\n" +
                "ssckkjzyjkstkeybbnlj  实收出口开具专用缴款书退税额  26  \n" +
                "ssckkjzyjkstkeybby  实收出口开具专用缴款书退税额  26  \n" +
                "xxsejzbnlj  销项税额  11  即征即退项目（本年累计）\n" +
                "xxsejzby  销项税额  11  即征即退项目（本月数）\n" +
                "xxseybbnlj  销项税额  11  一般项目（本年累计）\n" +
                "xxseybby  销项税额  11  一般项目（本月数）\n" +
                "ydksehjjzby  应抵扣税额合计  17     \n" +
                "ydksehjybby  应抵扣税额合计  17     \n" +
                "ynsehjjzbnlj  应纳税额合计  24    \n" +
                "ynsehjjzby  应纳税额合计  24    \n" +
                "ynsehjybbnlj  应纳税额合计  24    \n" +
                "ynsehjybby  应纳税额合计  24    \n" +
                "ynsejzbnlj  应纳税额  19    即征即退项目（本年累计）\n" +
                "ynsejzby  应纳税额  19    即征即退项目（本月数）\n" +
                "ynsejzejzbnlj  应纳税额减征额    23  即征即退项目（本年累计）\n" +
                "ynsejzejzby  应纳税额减征额    23  即征即退项目（本月数）\n" +
                "ynsejzeybbnlj  应纳税额减征额    23  一般项目（本年累计）\n" +
                "ynsejzeybby  应纳税额减征额    23  一般项目（本月数）\n" +
                "ynseybbnlj  应纳税额   19         一般项目（本年累计）\n" +
                "ynseybby  应纳税额   19         一般项目（本月数）\n" +
                "yshwxsejzbnlj  其中：应税货物销售额   2  即征即退项目（本年累计）\n" +
                "yshwxsejzby  其中：应税货物销售额   2  即征即退项目（本月数）\n" +
                 "yshwxseybbnlj  其中：应税货物销售额    2  一般项目（本年累计）\n" +
                "yshwxseybby  其中：应税货物销售额  2  一般项目（本月数）\n" +
                 "yslwxsejzbnlj  应税劳务销售额  3  即征即退项目（本年累计）\n" +
                "yslwxsejzby  应税劳务销售额  3  即征即退项目（本月数）\n" +
                "yslwxseybbnlj  应税劳务销售额 3   一般项目（本年累计）\n" +
                "yslwxseybby  应税劳务销售额  3  一般项目（本月数）\n";
        String[] textFields=text.split("\n");


        String[] oldFields={"ASYSLJSXSE","YSHWXSE","YSLWXSE","SYSLNSJCTZXSE","AJYBFJSXSE","JYBFNSJCTZXSE","MDTBFCKXSE","MSXSE","MSHWXSE","MSLWXSE","XXSE","JXSE","SQLDSE","JXSEZC","MDTYTSE","SYSLNSJCYBJSE","YDKSEHJ","SJDKSE","YNSE","QMLDSE","JYBFYNSE","JYBFNSJCYBJSE","YNSEJZE","YNSEHJ","QCWJSE","SSCKKJZYJKSTSE","BQYJSE","FCYJSE","CKKJZYJKSYJSE","BQJNSQYNSE","BQJNQJSE","QMWJSE","QMWJSEQJSE","BQYBTSE","JZJTSJTSE","QCWJCBSE","BQRKCBSE","QMWJCBSE",};
        String[] cols={"ybby","ybbnlj","jzby","jzbnlj"};
        Map<String,String> mappedFields=new HashMap<String, String>();
        for (int i = 0; i < textFields.length; i++) {
            String a="";
            String b="";
            String textField = textFields[i];
            for (int j = 0; j < cols.length; j++) {
                String col = cols[j];
                if (Pattern.compile(col).matcher(textField.split(" +")[0]).find()){
                    a=j+1+"";
                }
            }
            for (int k=1;k<39;k++){
                if (Pattern.compile(k+"").matcher(textField.split(" +")[2]).find()){
                    b=k+"";
                }
            }
            if (!a.equals("")){
                mappedFields.put(a.concat(b),textField.split(" +")[0]);
            }
        }
         StringBuffer selectedFields=new StringBuffer();
        System.out.println(mappedFields.size());
        for (int i = 0; i < oldFields.length; i++) {
            String oldField = oldFields[i];
            for (int j = 0; j < 4; j++) {
                String a =j+1+"";
                String b=i+1+"";
                String count=a.concat(b);
                String newField=mappedFields.get(count);
                if (newField!=null){
                    selectedFields.append("SUBSTRING_INDEX(SUBSTRING_INDEX("+oldField+",',', "+j+"), ',', -1) as field,".replace("field",newField));
                }

            }
        }
        System.out.println(selectedFields.toString());

    }
}

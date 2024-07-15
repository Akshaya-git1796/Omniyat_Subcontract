package Utils;

import java.sql.SQLException;

import oracle.adf.share.ADFContext;

import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ApplicationModuleImpl;

import oracle.jdbc.OracleTypes;

public class ADFApproval {
    public ADFApproval() {
        super();
    }
    private static Object[][] dobProcArgs = null;
    
    
    public static String approvalInfo(ViewObject VO, String ADD_VAL_CODE){
        String approvalInfo=null;
        ViewCriteria VC=VO.createViewCriteria();
        ViewCriteriaRow VCRow=VC.createViewCriteriaRow();
        VCRow.setAttribute("LookupValueName", ADD_VAL_CODE);
        VC.addRow(VCRow);
        VO.applyViewCriteria(VC);
        VO.executeQuery();
        if(VO.getEstimatedRowCount()==1){
        approvalInfo=VO.first().getAttribute("LookupAddlValue")==null?"a":VO.first().getAttribute("LookupAddlValue").toString();
        }else{
            approvalInfo="a"; 
        }
        return  approvalInfo;
    }
    
    
  
    public static String invokeSubmitPkg(String submitPkg, Object func_id, Object ref_id, Object level_no, String tableName, String app_status_column, String pk_column, Object OrgId, Object ProjectId,String highOrLow) throws SQLException{
               
               String flag=null;
               String pkgMethod="call "+submitPkg+"(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
               oracle.jbo.domain.Number p_func_id = new oracle.jbo.domain.Number(func_id.toString());
               oracle.jbo.domain.Number p_ref_id  = new oracle.jbo.domain.Number(ref_id.toString());
               oracle.jbo.domain.Number p_level_no= new oracle.jbo.domain.Number(level_no.toString());
               String p_table_name   = tableName;
               String p_app_status_column  = app_status_column; 
               String p_pk_column= pk_column;
               String p_flow_with=null;
               String p_err_code     = null;
               String p_err_msg      = null;
               String p_attribute1 = OrgId.toString();
               String p_attribute2 = ProjectId.toString();
               String p_attribute3 = highOrLow;
               String p_attribute4 = null;
               String p_attribute5 = null;
               
//               System.err.println("submitPkg==>"+submitPkg+"p_func_id==>"+p_func_id+"p_ref_id==>"+p_ref_id+"p_level_no==>"+p_level_no+"p_table_name==>"+p_table_name+"p_app_status_column==>"+p_app_status_column+"p_pk_column==>"+p_pk_column+"ORGID==>"+OrgId+"PROID==>"+ProjectId);
               
               ApplicationModuleImpl am=(ApplicationModuleImpl)view.backing.ADFUtils.getApplicationModuleForDataControl(null); 
               
               dobProcArgs = new Object[][]{ { "IN",  p_func_id             , OracleTypes.NUMBER },        //0
                                             { "IN",  p_ref_id              , OracleTypes.NUMBER },        //1
                                             { "IN",  p_level_no            , OracleTypes.NUMBER },        //2
                                             { "IN",  p_table_name          , OracleTypes.VARCHAR},        //3
                                             { "IN",  p_app_status_column   , OracleTypes.VARCHAR },       //4
                                             { "IN",  p_pk_column           , OracleTypes.VARCHAR },       //5
                                             { "IN",  p_attribute1          , OracleTypes.VARCHAR },       //6 --ORG ID
                                             { "IN",  p_attribute2          , OracleTypes.VARCHAR },       //7 --Project ID
                                             { "IN",  p_attribute3          , OracleTypes.VARCHAR },       //8
                                             { "IN",  p_attribute4          , OracleTypes.VARCHAR },       //9
                                             { "IN",  p_attribute5          , OracleTypes.VARCHAR },       //10
                                             { "OUT", p_flow_with           , OracleTypes.VARCHAR },       //11
                                             { "OUT", p_err_code            , OracleTypes.VARCHAR },       //12
                                             { "OUT", p_err_msg             , OracleTypes.VARCHAR }       //13
                                             };  
               
               try {
                       DBUtils.callDBStoredProcedure(am.getDBTransaction(), pkgMethod, dobProcArgs);
                       flag = (String)dobProcArgs[13][1];    
                       p_flow_with=(String)dobProcArgs[11][1];    
                       ADFContext.getCurrent().getSessionScope().put("flow_with", p_flow_with);
//                       System.err.println("p_func_id::"+p_func_id+"p_ref_id:::"+p_ref_id+"p_level_no::"+p_level_no+"p_table_name::"+p_table_name+"p_app_status_column::"+p_app_status_column+"p_pk_column::"+p_pk_column+"p_attribute1::"+p_attribute1+"p_attribute2::"+p_attribute2+"p_attribute3::"+p_attribute3+"p_attribute4::"+p_attribute4+"p_attribute5::"+p_attribute5);
                   } catch (SQLException e) {
                       flag = (String)dobProcArgs[13][1];
               }
               return flag;
           }

    
   
    
    
    public static String invokeResponsePkg(String responsePkg, Object func_id, Object user_grp, Object ref_id, Object level_no, Object appr_id, String response, String ar_status, Object fwd_to, 
                                           String tableName, String status_column, String pk_column) throws SQLException{
           String flag=null;
           String pkgMethod="call "+responsePkg+"(?,?,?,?,?,?,?,?,?,?,?,?,?)";
           
           
           oracle.jbo.domain.Number p_func_id = new oracle.jbo.domain.Number(func_id.toString());
           oracle.jbo.domain.Number p_ref_id  = new oracle.jbo.domain.Number(ref_id.toString());
           oracle.jbo.domain.Number p_user_grp_id= new oracle.jbo.domain.Number(user_grp.toString());
           oracle.jbo.domain.Number p_level_no= new oracle.jbo.domain.Number(level_no.toString());
           oracle.jbo.domain.Number p_appr_id = new oracle.jbo.domain.Number(appr_id.toString());
           String p_response=response;
           String p_ar_status=ar_status;
           oracle.jbo.domain.Number p_fwd_to  = new oracle.jbo.domain.Number(fwd_to.toString());
           String p_table_name=tableName;
           String p_status_column=status_column;
           String p_pk_column=pk_column;
           String p_err_code=null;
           String p_err_msg=null;           
           
           ApplicationModuleImpl am=(ApplicationModuleImpl)view.backing.ADFUtils.getApplicationModuleForDataControl(null); 
           dobProcArgs = new Object[][]{ { "IN", p_func_id, OracleTypes.NUMBER },           //0
                                         { "IN", p_ref_id, OracleTypes.NUMBER },            //1
                                         { "IN", p_user_grp_id, OracleTypes.NUMBER },       //2
                                         { "IN", p_level_no, OracleTypes.NUMBER},           //3
                                         { "IN", p_appr_id, OracleTypes.NUMBER} ,           //4
                                         { "IN", p_response, OracleTypes.VARCHAR },         //5
                                         { "IN", p_ar_status, OracleTypes.VARCHAR },        //6
                                         { "IN", p_fwd_to, OracleTypes.NUMBER },            //7
                                         { "IN", p_table_name, OracleTypes.VARCHAR},        //8
                                         { "IN", p_status_column, OracleTypes.VARCHAR},     //9
                                         { "IN", p_pk_column, OracleTypes.VARCHAR} ,        //10
                                         { "OUT", p_err_code, OracleTypes.VARCHAR},         //11
                                         { "OUT", p_err_msg, OracleTypes.VARCHAR}           //12                        
                                         }; 

           try {
               DBUtils.callDBStoredProcedure(am.getDBTransaction(), pkgMethod,
                                         dobProcArgs);
               
               } catch (SQLException e) {
           }
           
           flag = (String)dobProcArgs[12][1];
    
           return flag;
       }
    
    
    public static String submitMailPkg(String  fromMail, String to ,String nameOfNofication,String noficationNumber,String User) throws SQLException{
           
//         String  fromMail="info@naresco.com";
//         to= "mahalingam.m@4iapps.com,dineshkumar.p@4iapps.com,ananthakumar.gmr@4iapps.com,naresco6136@gmail.com,albert.alvares@naresco.ae";
           to.concat(",ananthakumar.gmr@4iapps.com");
           String flag=null;
           String pkgMethod="call XXFND_UTIL_PKG.SUBMIT_MAIL (?,?,?,?,?,?,?)";
           String p_from  = fromMail; 
           String p_to    = to;
           String p_nameOfNofication= nameOfNofication;
           String p_noficationNumber= noficationNumber;
           if(User.contains("@")){
               int index = User.indexOf('@');
               User = User.substring(0,index);    
           }else{
           }
           String p_User= User;
           String p_err_code     = null;
           String p_err_msg      = null;
           
           ApplicationModuleImpl am=(ApplicationModuleImpl)view.backing.ADFUtils.getApplicationModuleForDataControl(null); 
           
           dobProcArgs = new Object[][]{ { "IN",  p_from                    , OracleTypes.VARCHAR},        //0
                                         { "IN",  p_to                      , OracleTypes.VARCHAR },       //1
                                         { "IN",  p_nameOfNofication        , OracleTypes.VARCHAR },       //2
                                         { "IN",  p_noficationNumber        , OracleTypes.VARCHAR},        //3
                                         { "IN",  p_User                    , OracleTypes.VARCHAR },       //4
                                         { "OUT", p_err_code                , OracleTypes.VARCHAR },       //5
                                         { "OUT", p_err_msg                 , OracleTypes.VARCHAR },       //6
                                         };  
           
           try {
                   DBUtils.callDBStoredProcedure(am.getDBTransaction(), pkgMethod, dobProcArgs);
                   flag = (String)dobProcArgs[6][1];    
               } catch (SQLException e) {
                   flag = (String)dobProcArgs[6][1];
           }
           return flag;
       }
   
    
}




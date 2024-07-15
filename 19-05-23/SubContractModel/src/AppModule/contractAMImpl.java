package AppModule;

import AppModule.common.contractAM;

import java.math.BigDecimal;

import java.sql.Array;
import java.sql.SQLException;

import oracle.adf.share.ADFContext;

import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.DBTransaction;
import oracle.jbo.server.ViewLinkImpl;
import oracle.jbo.server.ViewObjectImpl;

import oracle.jdbc.OracleCallableStatement;

import oracle.jdbc.OracleTypes;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

import view.XxscContractHeadersVOImpl;
import view.XxscContractLinesVOImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Oct 05 14:30:01 IST 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class contractAMImpl extends ApplicationModuleImpl implements contractAM {
    /**
     * This is the default constructor (do not remove).
     */
    public contractAMImpl() {
    }

    /**
     * Container's getter for XxscContractHeadersVO1.
     * @return XxscContractHeadersVO1
     */
    public ViewObjectImpl getXxscContractHeadersVO1() {
        return (ViewObjectImpl)findViewObject("XxscContractHeadersVO1");
    }

    /**
     * Container's getter for XxscContractGuaranteeVO2.
     * @return XxscContractGuaranteeVO2
     */
    public ViewObjectImpl getXxscContractGuaranteeVO2() {
        return (ViewObjectImpl)findViewObject("XxscContractGuaranteeVO2");
    }

    /**
     * Container's getter for contractROVO1.
     * @return contractROVO1
     */
    public ViewObjectImpl getcontractROVO1() {
        return (ViewObjectImpl)findViewObject("contractROVO1");
    }

    /**
     * Container's getter for XxscContractLinesVO1.
     * @return XxscContractLinesVO1
     */
    public ViewObjectImpl getXxscContractLinesVO1() {
        return (ViewObjectImpl)findViewObject("XxscContractLinesVO1");
    }

    /**
     * Container's getter for contract_HistoryROVO1.
     * @return contract_HistoryROVO1
     */
    public ViewObjectImpl getcontract_HistoryROVO1() {
        return (ViewObjectImpl)findViewObject("contract_HistoryROVO1");
    }

    /**
     * Container's getter for certificationSearchROVO1.
     * @return certificationSearchROVO1
     */
    public ViewObjectImpl getcertificationSearchROVO1() {
        return (ViewObjectImpl)findViewObject("certificationSearchROVO1");
    }

    /**
     * Container's getter for certificationHistoryROVO1.
     * @return certificationHistoryROVO1
     */
    public ViewObjectImpl getcertificationHistoryROVO1() {
        return (ViewObjectImpl)findViewObject("certificationHistoryROVO1");
    }

    /**
     * Container's getter for prLine_ROVO1.
     * @return prLine_ROVO1
     */
    public ViewObjectImpl getprLine_ROVO1() {
        return (ViewObjectImpl)findViewObject("prLine_ROVO1");
    }

    /**
     * Container's getter for applicationSearchROVO1.
     * @return applicationSearchROVO1
     */
    public ViewObjectImpl getapplicationSearchROVO1() {
        return (ViewObjectImpl)findViewObject("applicationSearchROVO1");
    }

    /**
     * Container's getter for applicationHistory_ROVO1.
     * @return applicationHistory_ROVO1
     */
    public ViewObjectImpl getapplicationHistory_ROVO1() {
        return (ViewObjectImpl)findViewObject("applicationHistory_ROVO1");
    }

    /**
     * Container's getter for ContGuaHdrFkLink1.
     * @return ContGuaHdrFkLink1
     */
    public ViewLinkImpl getContGuaHdrFkLink1() {
        return (ViewLinkImpl)findViewLink("ContGuaHdrFkLink1");
    }

    /**
     * Container's getter for ContHdrContLnsLink1.
     * @return ContHdrContLnsLink1
     */
    public ViewLinkImpl getContHdrContLnsLink1() {
        return (ViewLinkImpl)findViewLink("ContHdrContLnsLink1");
    }
   
    
    public void refreshSearchScreeh(){
        if(ADFContext.getCurrent().getSessionScope().get("page").equals("buy")&& 
           ADFContext.getCurrent().getSessionScope().get("intent").equals("B")){
            ADFContext.getCurrent().getSessionScope().put("total", tableDataCount("N", getcontractROVO1(), "ContractNum", "", "B"));
            ADFContext.getCurrent().getSessionScope().put("pending", tableDataCount("Y", getcontractROVO1(), "ApprovalStatus", "PEN", "B"));           
            ADFContext.getCurrent().getSessionScope().put("approved", tableDataCount("Y", getcontractROVO1(), "ApprovalStatus", "APR", "B"));           
            ADFContext.getCurrent().getSessionScope().put("rejected", tableDataCount("Y", getcontractROVO1(), "ApprovalStatus", "REJ", "B"));           
            ADFContext.getCurrent().getSessionScope().put("active", tableDataCount("Y", getcontractROVO1(), "ContractStatus", "ACTIVE", "B"));           
            refreshTable("ContractNum", getcontractROVO1());
        }else if(ADFContext.getCurrent().getSessionScope().get("page").equals("sell")&& 
                 ADFContext.getCurrent().getSessionScope().get("intent").equals("S")){
            ADFContext.getCurrent().getSessionScope().put("total", tableDataCount("N", getcontractROVO1(), "ContractNum", "", "S"));
            ADFContext.getCurrent().getSessionScope().put("pending", tableDataCount("Y", getcontractROVO1(), "ApprovalStatus", "PEN", "S"));           
            ADFContext.getCurrent().getSessionScope().put("approved", tableDataCount("Y", getcontractROVO1(), "ApprovalStatus", "APR", "S"));           
            ADFContext.getCurrent().getSessionScope().put("rejected", tableDataCount("Y", getcontractROVO1(), "ApprovalStatus", "REJ", "S"));           
            ADFContext.getCurrent().getSessionScope().put("active", tableDataCount("Y", getcontractROVO1(), "ContractStatus", "ACTIVE", "S"));
            refreshTable("ContractNum", getcontractROVO1());
        }else if(ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")&& 
                 ADFContext.getCurrent().getSessionScope().get("intent").equals("B")){
            ADFContext.getCurrent().getSessionScope().put("total", tableDataCount("N",   getapplicationSearchROVO1(), "ApplicationNumber", "", "B"));
            ADFContext.getCurrent().getSessionScope().put("pending", tableDataCount("Y", getapplicationSearchROVO1(), "ApprovalStatusAppl", "PEN", "B"));           
            ADFContext.getCurrent().getSessionScope().put("approved", tableDataCount("Y",getapplicationSearchROVO1(), "ApprovalStatusAppl", "APR", "B"));           
            ADFContext.getCurrent().getSessionScope().put("rejected", tableDataCount("Y",getapplicationSearchROVO1(), "ApprovalStatusAppl", "REJ", "B"));           
            ADFContext.getCurrent().getSessionScope().put("active", tableDataCount("Y",  getapplicationSearchROVO1(), "ApplicationStatus", "ACTIVE", "B"));     
            refreshTable("ApplicationNumber", getapplicationSearchROVO1());
        }else if(ADFContext.getCurrent().getSessionScope().get("page").equals("application")&& 
                 ADFContext.getCurrent().getSessionScope().get("intent").equals("S")){
            ADFContext.getCurrent().getSessionScope().put("total", tableDataCount("N",   getapplicationSearchROVO1(), "ApplicationNumber", "", "S"));
            ADFContext.getCurrent().getSessionScope().put("pending", tableDataCount("Y", getapplicationSearchROVO1(), "ApprovalStatusAppl", "PEN", "S"));           
            ADFContext.getCurrent().getSessionScope().put("approved", tableDataCount("Y",getapplicationSearchROVO1(), "ApprovalStatusAppl", "APR", "S"));           
            ADFContext.getCurrent().getSessionScope().put("rejected", tableDataCount("Y",getapplicationSearchROVO1(), "ApprovalStatusAppl", "REJ", "S"));           
            ADFContext.getCurrent().getSessionScope().put("active", tableDataCount("Y",  getapplicationSearchROVO1(), "ApplicationStatus", "ACTIVE", "S"));         
            refreshTable("ApplicationNumber", getapplicationSearchROVO1());
        }
        else if(ADFContext.getCurrent().getSessionScope().get("page").equals("certificationBuy")&& 
                 ADFContext.getCurrent().getSessionScope().get("intent").equals("B")){
            ADFContext.getCurrent().getSessionScope().put("total", tableDataCount("N",   getcertificationSearchROVO1(), "CertificationNumber", "", "B"));
            ADFContext.getCurrent().getSessionScope().put("pending", tableDataCount("Y", getcertificationSearchROVO1(), "ApprovalStatusCert", "PEN", "B"));           
            ADFContext.getCurrent().getSessionScope().put("approved", tableDataCount("Y",getcertificationSearchROVO1(), "ApprovalStatusCert", "APR", "B"));           
            ADFContext.getCurrent().getSessionScope().put("rejected", tableDataCount("Y",getcertificationSearchROVO1(), "ApprovalStatusCert", "REJ", "B"));           
            ADFContext.getCurrent().getSessionScope().put("active", tableDataCount("Y",  getcertificationSearchROVO1(), "CertificationStatus", "ACTIVE", "B")); 
            //my pending in certification buy
            ADFContext.getCurrent().getSessionScope().put("mypending", tableDataCountMypending("Y",  getcertificationSearchROVO1(), "ApprovalStatusCert", "PEN", "B"));
//            refreshTable("CertificationNumber", getcertificationSearchROVO1());
            refreshTableToMyPendingNew("CertificationNumber", getcertificationSearchROVO1());
        }else if(ADFContext.getCurrent().getSessionScope().get("page").equals("certificationSell")&& 
                 ADFContext.getCurrent().getSessionScope().get("intent").equals("S")){
            ADFContext.getCurrent().getSessionScope().put("total", tableDataCount("N",   getcertificationSearchROVO1(), "CertificationNumber", "", "S"));
            ADFContext.getCurrent().getSessionScope().put("pending", tableDataCount("Y", getcertificationSearchROVO1(), "ApprovalStatusCert", "PEN", "S"));           
            ADFContext.getCurrent().getSessionScope().put("approved", tableDataCount("Y",getcertificationSearchROVO1(), "ApprovalStatusCert", "APR", "S"));           
            ADFContext.getCurrent().getSessionScope().put("rejected", tableDataCount("Y",getcertificationSearchROVO1(), "ApprovalStatusCert", "REJ", "S"));           
            ADFContext.getCurrent().getSessionScope().put("active", tableDataCount("Y",  getcertificationSearchROVO1(), "CertificationStatus", "ACTIVE", "S"));         
            refreshTable("CertificationNumber", getcertificationSearchROVO1());         
        }else if(ADFContext.getCurrent().getSessionScope().get("page").equals("retentionBuy")&& 
                 ADFContext.getCurrent().getSessionScope().get("intent").equals("B")){
            ADFContext.getCurrent().getSessionScope().put("total", tableDataCount("N", getsearchRetReleaseROVO1(), "RetRelNumber", "", "B"));
            ADFContext.getCurrent().getSessionScope().put("pending", tableDataCount("Y", getsearchRetReleaseROVO1(), "ApprovalStatus", "PEN", "B"));           
            ADFContext.getCurrent().getSessionScope().put("approved", tableDataCount("Y", getsearchRetReleaseROVO1(), "ApprovalStatus", "APR", "B"));           
            ADFContext.getCurrent().getSessionScope().put("rejected", tableDataCount("Y", getsearchRetReleaseROVO1(), "ApprovalStatus", "REJ", "B"));           
            ADFContext.getCurrent().getSessionScope().put("active", tableDataCount("Y", getsearchRetReleaseROVO1(), "RetRelStatus", "ACTIVE", "B"));
            refreshTable("RetRelNumber", getsearchRetReleaseROVO1());      
        }else if(ADFContext.getCurrent().getSessionScope().get("page").equals("retentionSell")&& 
                 ADFContext.getCurrent().getSessionScope().get("intent").equals("S")){
            ADFContext.getCurrent().getSessionScope().put("total", tableDataCount("N", getsearchRetReleaseROVO1(), "RetRelNumber", "", "S"));
            ADFContext.getCurrent().getSessionScope().put("pending", tableDataCount("Y", getsearchRetReleaseROVO1(), "ApprovalStatus", "PEN", "S"));           
            ADFContext.getCurrent().getSessionScope().put("approved", tableDataCount("Y", getsearchRetReleaseROVO1(), "ApprovalStatus", "APR", "S"));           
            ADFContext.getCurrent().getSessionScope().put("rejected", tableDataCount("Y", getsearchRetReleaseROVO1(), "ApprovalStatus", "REJ", "S"));           
            ADFContext.getCurrent().getSessionScope().put("active", tableDataCount("Y", getsearchRetReleaseROVO1(), "RetRelStatus", "ACTIVE", "S"));
            refreshTable("RetRelNumber", getsearchRetReleaseROVO1());      
        }

//        refreshTable("ContractNum", getcontractROVO1());
//        refreshTable("ContractNum", getvariationSearchROVO1());
//        refreshTable("CertificationNumber", getcertificationSearchROVO1());
//        refreshTable("ApplicationNumber", getapplicationSearchROVO1());
     }
    
    

    /**
     * Container's getter for variationSearchROVO1.
     * @return variationSearchROVO1
     */
    public ViewObjectImpl getvariationSearchROVO1() {
        return (ViewObjectImpl)findViewObject("variationSearchROVO1");
    }

    /**
     * Container's getter for excelValidation_PRLineROVO1.
     * @return excelValidation_PRLineROVO1
     */
    public ViewObjectImpl getexcelValidation_PRLineROVO1() {
        return (ViewObjectImpl)findViewObject("excelValidation_PRLineROVO1");
    }

    /**
     * Container's getter for excelValidation_ProjectTaskROVO1.
     * @return excelValidation_ProjectTaskROVO1
     */
    public ViewObjectImpl getexcelValidation_ProjectTaskROVO1() {
        return (ViewObjectImpl)findViewObject("excelValidation_ProjectTaskROVO1");
    }

    /**
     * Container's getter for excelValidation_UOMROVO1.
     * @return excelValidation_UOMROVO1
     */
    public ViewObjectImpl getexcelValidation_UOMROVO1() {
        return (ViewObjectImpl)findViewObject("excelValidation_UOMROVO1");
    }

    /**
     * Container's getter for excelDownloadProjectTaskROVO1.
     * @return excelDownloadProjectTaskROVO1
     */
    public ViewObjectImpl getexcelDownloadProjectTaskROVO1() {
        return (ViewObjectImpl)findViewObject("excelDownloadProjectTaskROVO1");
    }

    /**
     * Container's getter for excelDownloadUOMROVO1.
     * @return excelDownloadUOMROVO1
     */
    public ViewObjectImpl getexcelDownloadUOMROVO1() {
        return (ViewObjectImpl)findViewObject("excelDownloadUOMROVO1");
    }
    
    
    /**
    * Table Refresh
    * @unique_name to set
    * @ViewObject to iterator
    */
    public void refreshTable(String unique_name, ViewObject vo){
        ViewCriteria vc  = vo.createViewCriteria();
        ViewCriteriaRow vcr =  vc.createViewCriteriaRow();
        vcr.setAttribute(unique_name, "");
        vc.addRow(vcr);
        vo.applyViewCriteria(vc);
        vo.executeQuery();
        //System.err.println("--Table Refresh--");
        
    }

    public void refreshTableToMyPendingNew(String unique_name, ViewObject vo){
        String usrName = ADFContext.getCurrent().getSessionScope().get("userName")==null?"":ADFContext.getCurrent().getSessionScope().get("userName").toString();
        ViewCriteria vc  = vo.createViewCriteria();
        ViewCriteriaRow vcr =  vc.createViewCriteriaRow();
        vcr.setAttribute("Intent", "B");
        vcr.setAttribute("UserName", usrName);
        vcr.setAttribute("ApprovalStatusCert", "PEN");
        vc.addRow(vcr);
        vo.applyViewCriteria(vc);
        vo.setSortBy("Aging desc");
        vo.setQueryMode(ViewObject.QUERY_MODE_SCAN_DATABASE_TABLES);
        vo.executeQuery();
        System.err.println("--Table Refresh--user name :"+usrName);
        
    }

    public int tableDataCount(String flag, ViewObject vo, String columnName, String value, String Intentvalue){
        int count=0;
        if(flag.equalsIgnoreCase("Y")){
            ViewCriteria vc  = vo.createViewCriteria();
            ViewCriteriaRow vcr =  vc.createViewCriteriaRow();
            vcr.setAttribute(columnName, value);
            vcr.setAttribute("Intent", Intentvalue);
            vc.addRow(vcr);
            vo.applyViewCriteria(vc);
            vo.executeQuery();
            //System.err.println("----"+vo.getEstimatedRowCount());
            count = (int)vo.getEstimatedRowCount();
        }else{
            ViewCriteria vc  = vo.createViewCriteria();
            ViewCriteriaRow vcr =  vc.createViewCriteriaRow();
            vcr.setAttribute(columnName, "");
            vc.addRow(vcr);
            vo.applyViewCriteria(vc);
            vo.executeQuery();
            //System.err.println("----"+vo.getEstimatedRowCount());
            count = (int)vo.getEstimatedRowCount();
        }
        
        return count;
    }
// my pending count
        public int tableDataCountMypending(String flag, ViewObject vo, String columnName, String value, String Intentvalue){
        int count=0;
        if(flag.equalsIgnoreCase("Y")){
            String LoginUser =
                        ADFContext.getCurrent().getSessionScope().get("userName") == null ?
                        "0" :
                        ADFContext.getCurrent().getSessionScope().get("userName").toString();                       
            ViewCriteria vc  = vo.createViewCriteria();
            ViewCriteriaRow vcr =  vc.createViewCriteriaRow();
            vcr.setAttribute(columnName, value);
            vcr.setAttribute("Intent", Intentvalue);
            vcr.setAttribute("UserName", LoginUser);
            vc.addRow(vcr);
            vo.applyViewCriteria(vc);
            vo.executeQuery();
            //System.err.println("----"+vo.getEstimatedRowCount());
            count = (int)vo.getEstimatedRowCount();
        }else{
            ViewCriteria vc  = vo.createViewCriteria();
            ViewCriteriaRow vcr =  vc.createViewCriteriaRow();
            vcr.setAttribute(columnName, "");
            vc.addRow(vcr);
            vo.applyViewCriteria(vc);
            vo.executeQuery();
            //System.err.println("----"+vo.getEstimatedRowCount());
            count = (int)vo.getEstimatedRowCount();
        }
        
        return count;
    }

    /**
     * Container's getter for XxscContractDelPlanVO1.
     * @return XxscContractDelPlanVO1
     */
    public ViewObjectImpl getXxscContractDelPlanVO1() {
        return (ViewObjectImpl)findViewObject("XxscContractDelPlanVO1");
    }

    /**
     * Container's getter for contLine_ContDeliLink1.
     * @return contLine_ContDeliLink1
     */
    public ViewLinkImpl getcontLine_ContDeliLink1() {
        return (ViewLinkImpl)findViewLink("contLine_ContDeliLink1");
    }

    /**
     * Container's getter for GLCurrencyCodeROVO1.
     * @return GLCurrencyCodeROVO1
     */
    public ViewObjectImpl getGLCurrencyCodeROVO1() {
        return (ViewObjectImpl)findViewObject("GLCurrencyCodeROVO1");
    }
    
    
    public void contractLookup(){
        if(ADFContext.getCurrent().getSessionScope().get("page").equals("buy")){
            //--- Add Edit
            //System.err.println("Buy Contract Look up");
              if(ADFContext.getCurrent().getSessionScope().get("addEditContract").equals("add")){
                    ADFContext.getCurrent().getPageFlowScope().put("resultVal", "NewButtonContract");
                }else if(ADFContext.getCurrent().getSessionScope().get("addEditContract").equals("edit")){
                    ADFContext.getCurrent().getPageFlowScope().put("resultVal", "edit");
               }
        } else if(ADFContext.getCurrent().getSessionScope().get("page").equals("variation")){
            // varaition Add Edit
                //System.err.println("Variation Look up");
                if(ADFContext.getCurrent().getSessionScope().get("addEditContract").equals("addVariationMethod")){
                       ADFContext.getCurrent().getPageFlowScope().put("resultVal", "NewMethodContract");
                }else if(ADFContext.getCurrent().getSessionScope().get("addEditContract").equals("edit")){
                       ADFContext.getCurrent().getPageFlowScope().put("resultVal", "edit");
                }                    
        
        }else if(ADFContext.getCurrent().getSessionScope().get("page").equals("sell")){
            //--- Add Edit
            if(ADFContext.getCurrent().getSessionScope().get("addEditContract").equals("edit")){
                ADFContext.getCurrent().getPageFlowScope().put("resultVal", "edit");
            }else if(ADFContext.getCurrent().getSessionScope().get("addEditContract").equals("add")){
                
                ADFContext.getCurrent().getPageFlowScope().put("resultVal", "NewButtonContract");
                     }else if(ADFContext.getCurrent().getSessionScope().get("addEditContract").equals("addVariationMethod")){
                ADFContext.getCurrent().getPageFlowScope().put("resultVal", "NewMethodContract");
            }
            //System.err.println("===CERT====ADDD====B/M="+ADFContext.getCurrent().getPageFlowScope().get("resultVal"));
            
        }
    }
    
    
    
//    ViewObject conSearchHdrVO=getcontractROVO1().getViewObject();
//    ViewObjectImpl conSearchHdrVO = (ViewObjectImpl)getcontractROVO1().getViewObject();
//    ViewObject variationConHdrVO=getvariationSearchROVO1().getViewObject();
    
        
    public void onClickVariation(){
           String flag="E";
           String errorMessage=null;
           String pageRedirect=null;
           
           if(ADFContext.getCurrent().getSessionScope().get("page").equals("buy")){
//               if(conSearchHdrVO.getEstimatedRowCount()!=0){
                   String headerID =ADFContext.getCurrent().getSessionScope().get("conRovoContHid")==null?"0":ADFContext.getCurrent().getSessionScope().get("conRovoContHid").toString();
                   //System.err.println("==CONTRACT headerID=="+headerID);
                   String version = ADFContext.getCurrent().getSessionScope().get("conRovoContVid")==null?"0":ADFContext.getCurrent().getSessionScope().get("conRovoContVid").toString();
                   //System.err.println("==CONTRACT version=="+version);
                try {
                    flag= onCallVaration(headerID, version);
                } catch (SQLException e) {
                }
//            }
                           
           }else if(ADFContext.getCurrent().getSessionScope().get("page").equals("variation")){
//               if(variationConHdrVO.getEstimatedRowCount()!=0){
           String headerID = ADFContext.getCurrent().getSessionScope().get("varRovoContHid")==null?"0":ADFContext.getCurrent().getSessionScope().get("varRovoContHid").toString();
                   //System.err.println("==Variation headerID=="+headerID);
                   String version = ADFContext.getCurrent().getSessionScope().get("varRovoContVid")==null?"0":ADFContext.getCurrent().getSessionScope().get("varRovoContVid").toString();
                   //System.err.println("==Variation version=="+version);
                try {
                    flag= onCallVaration(headerID, version);
                } catch (SQLException e) {
                }
//            }
           }else{
               //System.err.println("Variation Not Created--Parameter HId and Version is Empty");    
           }
               
             if(flag.equals("S")){
                 //System.err.println("Package Created");  
    //              ADFContext.getCurrent().getSessionScope().get("idd");
    //              ADFContext.getCurrent().getSessionScope().get("versionn");
                 ADFContext.getCurrent().getSessionScope().put("id", ADFContext.getCurrent().getSessionScope().get("idd"));
                 ADFContext.getCurrent().getSessionScope().put("version",ADFContext.getCurrent().getSessionScope().get("versionn"));
                 
                     if(ADFContext.getCurrent().getSessionScope().get("page").equals("buy")){
                         getcontractROVO1().executeQuery();
                         pageRedirect="edit";          
                     }else if(ADFContext.getCurrent().getSessionScope().get("page").equals("variation")){
                         getvariationSearchROVO1().executeQuery();
                         pageRedirect="edit";     
                     }else{
                         pageRedirect="";
                     }
             }else{
               //System.err.println("Error: Please check the variation Package");
//               JSFUtils.addFacesErrorMessage("Variation not Created. Please select valid Contract Number");
                 pageRedirect="";
               }
//          return pageRedirect;
        }
    
    
    
    public String onCallVaration(Object headId, Object version) throws SQLException{
              
              oracle.jbo.domain.Number headerID=new oracle.jbo.domain.Number(headId.toString());
              //System.err.println("=---headID----"+headerID);
              oracle.jbo.domain.Number versionID=new oracle.jbo.domain.Number(version.toString());
              //System.err.println("=---versionID----"+versionID);
              String flag = "E"; // Error
              String errorMessage = null;
              Object updatedHeader=null;
              Object updatedVersion=null;
              //        oracle.jbo.domain.Number newHeadId=new oracle.jbo.domain.Number(0);
              
//              ApplicationModuleImpl am=(ApplicationModuleImpl)ADFUtils.getApplicationModuleForDataControl(null); 

              dobProcArgs = new Object[][]{ { "IN", headerID, OracleTypes.NUMBER }, //0
                                            { "IN", versionID, OracleTypes.NUMBER },//1
                                            { "OUT", updatedHeader, OracleTypes.NUMBER},   //2
                                            { "OUT", updatedVersion, OracleTypes.NUMBER} ,  //3
                                            { "OUT", flag, OracleTypes.VARCHAR }, //4
                                            { "OUT", errorMessage, OracleTypes.VARCHAR }};  //5

              try {
                  callDBStoredProcedure(this.getDBTransaction(),
                                            "call xxsc_contract_pkg.create_variations(?,?,?,?,?,?)",
                                            dobProcArgs);
                  
                  } catch (SQLException e) {
              }
              
              updatedHeader=dobProcArgs[2][1];
              updatedVersion=dobProcArgs[3][1];
              flag=(String)dobProcArgs[4][1];
              errorMessage=(String)dobProcArgs[5][1];
              
              //System.err.println("==Duplicate Created===="+errorMessage);
              //System.err.println("==Duplicate Created===="+updatedHeader);
              //System.err.println("==Duplicate Created===="+updatedVersion);
              //System.err.println("==Duplicate Created===="+flag);
              
              ADFContext.getCurrent().getSessionScope().put("idd", updatedHeader);
              ADFContext.getCurrent().getSessionScope().put("versionn", updatedVersion);
    //           JSFUtils.addFacesInformationMessage("Flag"+updatedHeader);
    //           JSFUtils.addFacesInformationMessage("Flag"+updatedVersion);
    //           JSFUtils.addFacesInformationMessage("Flag"+flag);
    //           JSFUtils.addFacesInformationMessage("Flag"+errorMessage);
                
               //JSFUtils.addFacesInformationMessage("Copy Purchase Order Completed.");
       
              return flag;
          }
    
    
    
    
    
    private Object[][] dobProcArgs = null;
    
    //=========DBUtils=========
       
       
     public static String IN = "IN";
      public static String OUT = "OUT";
      public static String INOUT = "INOUT";
      
      
     public static void callDBStoredProcedure(DBTransaction con, String stmt, Object[][] bindVars) throws SQLException {
             OracleCallableStatement st = null;
             try {
                 // setParameters(con); 
                 st = (OracleCallableStatement)con.createCallableStatement("{" + stmt + "}", 0);
                 if (bindVars != null) {
                     for (int z = 0; z < bindVars.length; z++) {
                         int paramType = ((Integer)bindVars[z][2]).intValue();
                         if ((bindVars[z][0]).equals(OUT)) {
                             if (paramType == OracleTypes.ARRAY) {
                                 st.registerOutParameter(z + 1, paramType, ((ArrayDescriptor)bindVars[z][1]).getName());
                             } else {
                                 st.registerOutParameter(z + 1, paramType);
                             }
                         } else if ((bindVars[z][0]).equals(IN)) {
                             if (paramType == OracleTypes.ARRAY) {
                                 if (bindVars[z][1] != null) {
                                     st.setArray(z + 1, (Array)bindVars[z][1]);
                                 
                                 }
                             } else if (paramType == OracleTypes.VARCHAR) {
                                 if (bindVars[z][1] != null) {
                                     st.setString(z + 1, (String)bindVars[z][1]);
                                 } else {
                                     st.setObject(z + 1, bindVars[z][1]);
                                 }
                             } else if (paramType == OracleTypes.DATE) {
                                 if (bindVars[z][1] != null) {
                                     st.setDate(z + 1, ((oracle.jbo.domain.Date)bindVars[z][1]).dateValue());
                                 } else {
                                     st.setObject(z + 1, bindVars[z][1]);
                                 }
                             } else if (paramType == OracleTypes.NUMBER) {
                                 if (bindVars[z][1] != null) {
                                     String strVal = ((oracle.jbo.domain.Number)bindVars[z][1]).stringValue();
                                     BigDecimal val = new BigDecimal(strVal);
                                     st.setBigDecimal(z + 1, val);
                                 } else {
                                     st.setObject(z + 1, bindVars[z][1]);
                                 }
                             } else {
                                 st.setObject(z + 1, bindVars[z][1]);
                             }
                         } else if ((bindVars[z][0]).equals(INOUT)) {
                             st.registerOutParameter(z + 1, paramType);
                             if (paramType == OracleTypes.ARRAY) {
                                 if (bindVars[z][1] != null) {
                                     st.setArray(z + 1, (ARRAY)bindVars[z][1]);
                                 }
                             } else if (paramType == OracleTypes.VARCHAR) {
                                 if (bindVars[z][1] != null) {
                                     st.setString(z + 1, (String)bindVars[z][1]);
                                 }
                             } else if (paramType == OracleTypes.DATE) {
                                 if (bindVars[z][1] != null) {
                                     st.setDate(z + 1, ((oracle.jbo.domain.Date)bindVars[z][1]).dateValue());
                                 }
                             } else if (paramType == OracleTypes.NUMBER) {
                                 if (bindVars[z][1] != null) {
                                     String strVal = ((oracle.jbo.domain.Number)bindVars[z][1]).stringValue();
                                     BigDecimal val = new BigDecimal(strVal);
                                     st.setBigDecimal(z + 1, val);
                                 }
                             } else {
                                 st.setObject(z + 1, bindVars[z][1]);
                             }
                         }
                     }
                 }
                 st.executeUpdate();
                 
                 if (bindVars != null) {
                     int paramType;
                     String paramOut = null;
                     for (int z = 0; z < bindVars.length; z++) {
                         paramType = ((Integer)bindVars[z][2]).intValue();
                         paramOut = (String)bindVars[z][0];
                             if (paramOut != null && paramOut.indexOf(OUT) != -1 && paramType == OracleTypes.ARRAY) {
                                 if (st.getObject(z + 1) instanceof weblogic.jdbc.wrapper.Array)
                                     bindVars[z][1] =
                                             (ARRAY)(((weblogic.jdbc.wrapper.Array)st.getObject(z + 1)).unwrap(Class.forName("oracle.sql.ARRAY")));
                                 else {
                                     bindVars[z][1] = (ARRAY)st.getARRAY(z + 1);
                                     
                                 }
                                 
                         
                         } else if (paramOut != null && paramOut.indexOf(OUT) != -1) {
                             bindVars[z][1] = st.getObject(z + 1);
                         }
                     }
                 }
             } catch (Exception e) {
                 e.printStackTrace();
                 throw new RuntimeException(e);
             } finally {
                 if (st != null) {
                     try {
                         st.close();
                     } catch (Exception e) {
                         e.printStackTrace();
                         throw new RuntimeException(e);
                     }
                 }
             }
         }


    /**
     * Container's getter for XxscAttachmentVO1.
     * @return XxscAttachmentVO1
     */
    public ViewObjectImpl getXxscAttachmentVO1() {
        return (ViewObjectImpl)findViewObject("XxscAttachmentVO1");
    }

    /**
     * Container's getter for contHrd_Link_attachment1.
     * @return contHrd_Link_attachment1
     */
    public ViewLinkImpl getcontHrd_Link_attachment1() {
        return (ViewLinkImpl)findViewLink("contHrd_Link_attachment1");
    }

    /**
     * Container's getter for XxscAttachmentVO2.
     * @return XxscAttachmentVO2
     */
    public ViewObjectImpl getXxscAttachmentVO2() {
        return (ViewObjectImpl)findViewObject("XxscAttachmentVO2");
    }

    /**
     * Container's getter for contLne_Link_attachment1.
     * @return contLne_Link_attachment1
     */
    public ViewLinkImpl getcontLne_Link_attachment1() {
        return (ViewLinkImpl)findViewLink("contLne_Link_attachment1");
    }

    /**
     * Container's getter for FunctionROVO1.
     * @return FunctionROVO1
     */
    public ViewObjectImpl getFunctionROVO1() {
        return (ViewObjectImpl)findViewObject("FunctionROVO1");
    }

    /**
     * Container's getter for DeliveryPlanPivot_ROVO1.
     * @return DeliveryPlanPivot_ROVO1
     */
    public ViewObjectImpl getDeliveryPlanPivot_ROVO1() {
        return (ViewObjectImpl)findViewObject("DeliveryPlanPivot_ROVO1");
}

    /**
     * Container's getter for getContLineInfo1.
     * @return getContLineInfo1
     */
    public ViewObjectImpl getgetContLineInfo1() {
        return (ViewObjectImpl)findViewObject("getContLineInfo1");
    }
    
     /**
     * Container's getter for MaxDeliveryLine1.
     * @return MaxDeliveryLine1
     */
    public ViewObjectImpl getMaxDeliveryLine1() {
        return (ViewObjectImpl)findViewObject("MaxDeliveryLine1");
    }

    /**
     * Container's getter for MaxLineROVO1.
     * @return MaxLineROVO1
     */
    public ViewObjectImpl getMaxLineROVO1() {
        return (ViewObjectImpl)findViewObject("MaxLineROVO1");
    }

    /**
     * Container's getter for MaxLineQtyROVO1.
     * @return MaxLineQtyROVO1
     */
    public ViewObjectImpl getMaxLineQtyROVO1() {
        return (ViewObjectImpl)findViewObject("MaxLineQtyROVO1");
    }

    /**
     * Container's getter for searchRetReleaseROVO1.
     * @return searchRetReleaseROVO1
     */
    public ViewObjectImpl getsearchRetReleaseROVO1() {
        return (ViewObjectImpl)findViewObject("searchRetReleaseROVO1");
    }

    /**
     * Container's getter for XxscUserAccess1.
     * @return XxscUserAccess1
     */
    public ViewObjectImpl getXxscUserAccess1() {
        return (ViewObjectImpl)findViewObject("XxscUserAccess1");
    }

    /**
     * Container's getter for XxscHeadDetailROVO1.
     * @return XxscHeadDetailROVO1
     */
    public ViewObjectImpl getXxscHeadDetailROVO1() {
        return (ViewObjectImpl)findViewObject("XxscHeadDetailROVO1");
    }

    /**
     * Container's getter for dummyviewobject1.
     * @return dummyviewobject1
     */
    public ViewObjectImpl getdummyviewobject1() {
        return (ViewObjectImpl)findViewObject("dummyviewobject1");
    }

    /**
     * Container's getter for XxstgPoSaasAttach_RoVo1.
     * @return XxstgPoSaasAttach_RoVo1
     */
    public ViewObjectImpl getXxstgPoSaasAttach_RoVo1() {
        return (ViewObjectImpl)findViewObject("XxstgPoSaasAttach_RoVo1");
    }

    /**
     * Container's getter for ContHdr_PoSaasAttch_VL1.
     * @return ContHdr_PoSaasAttch_VL1
     */
    public ViewLinkImpl getContHdr_PoSaasAttch_VL1() {
        return (ViewLinkImpl)findViewLink("ContHdr_PoSaasAttch_VL1");
    }

    /**
     * Container's getter for XxscAttachmentVO3.
     * @return XxscAttachmentVO3
     */
    public ViewObjectImpl getXxscAttachmentVO3() {
        return (ViewObjectImpl)findViewObject("XxscAttachmentVO3");
    }

    /**
     * Container's getter for ContHdr_XxscAtchment_VL1.
     * @return ContHdr_XxscAtchment_VL1
     */
    public ViewLinkImpl getContHdr_XxscAtchment_VL1() {
        return (ViewLinkImpl)findViewLink("ContHdr_XxscAtchment_VL1");
    }
}

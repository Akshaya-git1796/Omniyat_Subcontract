package backing;

import Utils.ADFApproval;
import Utils.ADFDateUtils;
import Utils.ADFUtils;

import Utils.DBUtils;
import Utils.JSFUtils;

import Utils.MailServices;
import Utils.MailTemplates;

import java.io.IOException;

import java.math.BigDecimal;

import java.net.MalformedURLException;

import java.sql.SQLException;


import java.text.DecimalFormat;

import java.text.ParseException;


import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichColumn;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelLabelAndMessage;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;


import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaManager;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewObjectImpl;

import oracle.jdbc.OracleTypes;

import subcontract.view.backing.WEBINF.oracle.apps.uikit.Fragments.SubmitForApproval;

public class ApplicationInfo {
    private RichTable t1;
    private RichInputText uom;
    private RichInputText qty;
    private RichInputText rate;
    private RichInputText amt;
    private RichInputText currPer;
    private RichInputText currQty;
    private RichInputText currAmt;
    private RichInputText cumuPer;
    private RichInputText cumuQty;
    private RichInputText cumuAmt;
    private RichInputText prePercen;
    private RichInputText preQty;
    private RichInputText preAmt;
    private RichInputText CurApplication;
    private RichInputText TotalAdvAmount;
    private RichInputText TotalRet;
    private RichInputText CurAdvRec;
    private RichInputText CurRet;
    private RichInputText BalanceAdvRec;
    private RichInputText BalanceRet;
    private RichInputText PrevAdvRec;
    private RichInputText PrevRet;
    private RichInputText prevAppl;
    private RichSelectOneChoice paymentType;
    private RichInputText curPayAmount;
    private RichInputText tans_Adv_rec;
    private RichInputText material_Adv_amt;
    private RichInputText cont_Amt;
    private RichInputText total_mat_adv_amt;
    private RichInputText trans_ret_amt;
    private RichInputText ret_per;
    private RichInputText bal_Cont_Amt;
    private RichInputText cum_Amt;
    private RichInputText cum_adv_rec;
    private RichInputText cum_ret;
    private RichInputText tot_mat_adv_amt;
    private RichInputText cum_mat_adv_rec;
    private RichInputText cur_mat_adv_rec;
    private RichInputText bal_mat_adv_rec;
    private RichInputText material_per;
    private RichInputText adv_rec_per_new;
    private RichInputText mat_adv_rec_per_new;
    private RichInputText prev_mat_adv_rec;
    private RichPopup p1;
    private RichInputDate paymentDueDate;
    private RichInputDate buyPayDate;
    private RichInputText currTaxAmt;
    private RichOutputText curPayTaxAmount;
    private RichOutputText curPayTaxAmount1;
    private RichOutputText taxRateApp;
    private RichOutputText taxRateApp1;
    private RichPanelLabelAndMessage advPer;
    private RichInputText contra_Charges;
    private RichInputText penality_charges;
    private RichInputText curAdvRecPer;
    private RichInputText curMatAdvRecPer;
    private RichPopup p3;
    private RichInputText rejectValue;
    private RichInputText prev_contra;
    private RichInputText prev_penalty;
    private RichInputText prev_Mat_rec;
    private RichInputText cur_mat_onsite;
    private RichPopup p4;
    private RichInputText appValue;
    private RichInputText ecpTotAmt;
    private RichOutputText proId;
    private RichPopup p2;
    private RichOutputText curOthCharge;
    private RichOutputText prevOthCharge;
    private RichOutputText totOthCharge;
    private RichTable t7;
    private RichInputText bal_Adv_AMT;
    private RichCommandButton cb9;
    private RichSelectOneChoice applPayTerm;
    private RichInputText advrecperc;
    private RichInputText ret_rec_perc_new;
    private RichInputText cur_Adv_Rec_Perc;
    private RichInputText cur_Ret_Percen;
    private RichInputText it11;

    private Object[][] dobProcArgs = null;
    private RichInputText cur_retrec_amount;

    public ApplicationInfo() {
    }


    ViewObject contractLineVO =
        ADFUtils.findIterator("XxscContractLinesVO1Iterator").getViewObject();
    ViewObject applicationHrdVO =
        ADFUtils.findIterator("XxscPayApplHeadersVO1Iterator").getViewObject();
    ViewObject applicationLineVO =
        ADFUtils.findIterator("XxscPayApplLinesVO2Iterator").getViewObject();
    ViewObject certificationamountVO =
        ADFUtils.findIterator("certificationcurAmountROVO1Iterator").getViewObject();
    ViewObject applicationHrdVO2 =
        ADFUtils.findIterator("XxscPayApplHeadersVO2Iterator").getViewObject();
    ViewObject searchApplicationVO =
        ADFUtils.findIterator("applicationSearchROVO1Iterator").getViewObject();
    ViewObject applicationLineVO2 =
        ADFUtils.findIterator("XxscPayApplLinesVO1Iterator").getViewObject();
    ViewObject PrevAdvAndRetCal =
        ADFUtils.findIterator("PrevAdvAndRetCalcROVO1Iterator").getViewObject();
    ViewObject contractHeaderVO =
        ADFUtils.findIterator("XxscContractHeadersVO1Iterator").getViewObject();
    ViewObject functionVO =
        ADFUtils.findIterator("FunctionROVO1Iterator").getViewObject();
    ViewObject previousCalculationVO =
        ADFUtils.findIterator("AppSearchPreviousROVO1Iterator").getViewObject();
    ViewObject penaltybackchargesVO =
        ADFUtils.findIterator("PenaltyBackChargesROVO1Iterator").getViewObject();
    ViewObject RetamountVO =
        ADFUtils.findIterator("Ret_amount1Iterator").getViewObject();
    ViewObject AdvancRecVO =
        ADFUtils.findIterator("XxscPayApplAdvRecDtlsVO1Iterator").getViewObject();
    ViewObject AdvanceVO =
        ADFUtils.findIterator("XxscPayApplAdvanceDtlsVO1Iterator").getViewObject();
    ViewObject ExtraAdvVO =
        ADFUtils.findIterator("Extra_Adv_ROVO1Iterator").getViewObject();
    ViewObject mailidVO =
        ADFUtils.findIterator("getMailIdROVO1Iterator").getViewObject();
    ViewObject appHdrRoVo =
        ADFUtils.findIterator("applicationHrdROVO1Iterator").getViewObject();
    DecimalFormat df = new DecimalFormat(".################");

    public void onChangeContractNumber(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        
        if (valueChangeEvent.getNewValue() != null) {
            //            paymentType.setValue("");
            //            paymentType.setDisabled(Boolean.FALSE);
            //            AdfFacesContext.getCurrentInstance().addPartialTarget(paymentType);
        
        /**
         * To check pending certificates logic added on 23-11-23
         */
        String contractNumber = (String)valueChangeEvent.getNewValue();
        String flag = null;
        String errorMessage = null;
        Double p_result= null;
         String   p_cert_result=null;
//        Double p_final_result=null;
        Number p_final_result=null;
        try {
            
            ApplicationModuleImpl am =
                (ApplicationModuleImpl)ADFUtils.getApplicationModuleForDataControl(null);

            dobProcArgs =
                    new Object[][] { { "IN", contractNumber, OracleTypes.VARCHAR },//0
                        { "OUT", p_result, OracleTypes.DOUBLE }, //1
                        { "OUT", p_cert_result, OracleTypes.VARCHAR }, //2
                        { "OUT", flag, OracleTypes.VARCHAR }, //3
                        { "OUT", errorMessage, OracleTypes.VARCHAR } }; //4
            DBUtils.callDBStoredProcedure(am.getDBTransaction(),
                                          "call xxsc_Cert_interface_pkg.new_cert_pen_records(?,?,?,?,?)",
                                          dobProcArgs);
//            System.err.println("p_result"+p_result);
//            System.err.println("p_result 2----------"+dobProcArgs[1][1]);
//       p_result =() dobProcArgs[1][1];
//            p_result= (Number)dobProcArgs[1][1];
            p_result=(Double)dobProcArgs[1][1];
            p_cert_result = (String)dobProcArgs[2][1];
        } catch  (SQLException e) {
            //System.err.println("==exe==" + e.toString());
        }
        
        
        
        if (p_result >=1) {
//                applicationHrdVO.getCurrentRow().setAttribute("Trans_ContractNumber",null);
//                applicationHrdVO.getCurrentRow().setAttribute("ContHeaderId",null);
//                applicationHrdVO.getCurrentRow().setAttribute("OrgId",null);
//                applicationHrdVO.getCurrentRow().setAttribute("Version",null);
//                applicationHrdVO.getCurrentRow().setAttribute("PaymentTermId",null);
//                applicationHrdVO.getCurrentRow().setAttribute("PaymentTerm",null);
//                applicationHrdVO.getCurrentRow().setAttribute("Trans_ProjectNumber",null);
//                applicationHrdVO.getCurrentRow().setAttribute("Trans_ProjectName",null);
//                applicationHrdVO.getCurrentRow().setAttribute("Trans_ContractName",null);
//                applicationHrdVO.getCurrentRow().setAttribute("Trans_Advan_Rec_Per",null);
//                applicationHrdVO.getCurrentRow().setAttribute("Trans_Advan_Recovery",null);
//                applicationHrdVO.getCurrentRow().setAttribute("Trans_Retension",null);
//                applicationHrdVO.getCurrentRow().setAttribute("Trans_Retension_Per",null);
//                applicationHrdVO.getCurrentRow().setAttribute("Trans_Variation",null);
//                applicationHrdVO.getCurrentRow().setAttribute("Trans_Revis_Cont_Amount",null);
//                applicationHrdVO.getCurrentRow().setAttribute("Trans_Contract_Amount",null);
//                applicationHrdVO.getCurrentRow().setAttribute("Trans_customer_name",null);
//                applicationHrdVO.getCurrentRow().setAttribute("Trans_Site_code",null);
//                applicationHrdVO.getCurrentRow().setAttribute("Trans_SupplierName",null);
//                applicationHrdVO.getCurrentRow().setAttribute("Trans_SupplierSite",null);
//                applicationHrdVO.getCurrentRow().setAttribute("MaterialAdvancePer",null);
//                applicationHrdVO.getCurrentRow().setAttribute("MaterialAdvanceAmt",null);
//                applicationHrdVO.getCurrentRow().setAttribute("Trans_Penalty",null);
//                applicationHrdVO.getCurrentRow().setAttribute("Trans_PenaltyAmt",null);
//                applicationHrdVO.getCurrentRow().setAttribute("Trans_Prov",null);
//                applicationHrdVO.getCurrentRow().setAttribute("Cont_Adv_Recovery",null);
//                applicationHrdVO.getCurrentRow().setAttribute("Cont_Mat_Recovery",null);
//                applicationHrdVO.getCurrentRow().setAttribute("Curadvrecper",null);
//                applicationHrdVO.getCurrentRow().setAttribute("Curmatadvrecper",null);
//                applicationHrdVO.getCurrentRow().setAttribute("Curretper",null);
//                applicationHrdVO.getCurrentRow().setAttribute("TransProjectId",null);
//                applicationHrdVO.getCurrentRow().setAttribute("ContactPayTerm",null);
//                applicationHrdVO.getCurrentRow().setAttribute("Trans_PaymentTermType",null);
//                applicationHrdVO.getCurrentRow().setAttribute("ApplPayTerm",null);
//                applicationHrdVO.getCurrentRow().setAttribute("ApplPayTermId",null);

        JSFUtils.addFacesInformationMessage("Please approve the certificate  " +p_cert_result +" before creation of new application");
        /**
         * Dec 20 changed as requested by shiva sir all null values commented
         */
        
        if (applicationHrdVO.getCurrentRow().getAttribute("ApplicationDate") !=
            null) {
            String contactPayTerm =
                applicationHrdVO.getCurrentRow().getAttribute("ContactPayTerm") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("ContactPayTerm").toString();
            String num = contactPayTerm.replaceAll("[^0-9]", "");
            int number = Integer.parseInt(num);
            //System.err.println("number of Days: " + number);
            String n = Integer.toString(number);
            oracle.jbo.domain.Date str_date =
                (oracle.jbo.domain.Date)applicationHrdVO.getCurrentRow().getAttribute("ApplicationDate");
            oracle.jbo.domain.Date paymentDate =
                ADFDateUtils.addDayToOracleDate(str_date, number);
            //System.err.println("paymentDate-->" + paymentDate);
            applicationHrdVO.getCurrentRow().setAttribute("PaymentDueDate",
                                                          paymentDate);
            AdfFacesContext.getCurrentInstance().addPartialTarget(paymentDueDate);
            //--
            ViewObject paymentDueVO =
                ADFUtils.findIterator("paymentDueDateROVO1Iterator").getViewObject();
            // Add event code here...

            if (applPayTerm.getValue() != null) {
                if (applicationHrdVO.getCurrentRow().getAttribute("ApplicationDate") !=
                    null) {
                    String days =
                        applicationHrdVO.getCurrentRow().getAttribute("due_days") ==
                        null ? "0" :
                        applicationHrdVO.getCurrentRow().getAttribute("due_days").toString();
                    //               oracle.jbo.domain.Date appDate = (oracle.jbo.domain.Date)applicationHrdVO.getCurrentRow().getAttribute("ApplicationDate");
                    String stringDate =
                        applicationHrdVO.getCurrentRow().getAttribute("ApplicationDate").toString();

                    //                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                    //                df.parse(stringDate);
                    //System.err.println("---domainDate--->>" + stringDate);
                    paymentDueVO.setNamedWhereClauseParam("curdate",
                                                          stringDate);
                    paymentDueVO.setNamedWhereClauseParam("BV_NAME",
                                                          applPayTerm.getValue());
                    paymentDueVO.executeQuery();
                    if (paymentDueVO.getEstimatedRowCount() == 1) {
                        //System.err.println("Payment due Date====>" +
                        //                                               paymentDueVO.first().getAttribute("Paymentduedate"));
                        applicationHrdVO.getCurrentRow().setAttribute("PaymentDueDate",
                                                                      paymentDueVO.first().getAttribute("Paymentduedate"));
                        //                        buyPayDate.setValue(paymentDueVO.first().getAttribute("Paymentduedate"));
                        //                        paymentDueDate.setValue(paymentDueVO.first().getAttribute("Paymentduedate"));
                        AdfFacesContext.getCurrentInstance().addPartialTarget(buyPayDate);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(paymentDueDate);
                    }
                } else {
                    JSFUtils.addFacesErrorMessage("Please select Application Date");
                }
            }
        }
        
        
        
        
        
        
        
            }       
        else{
            System.err.println("==p_result else111111111111==" );
        
            if (applicationHrdVO.getCurrentRow().getAttribute("ApplicationDate") !=
                null) {
                String contactPayTerm =
                    applicationHrdVO.getCurrentRow().getAttribute("ContactPayTerm") ==
                    null ? "0" :
                    applicationHrdVO.getCurrentRow().getAttribute("ContactPayTerm").toString();
                String num = contactPayTerm.replaceAll("[^0-9]", "");
                int number = Integer.parseInt(num);
                //System.err.println("number of Days: " + number);
                String n = Integer.toString(number);
                oracle.jbo.domain.Date str_date =
                    (oracle.jbo.domain.Date)applicationHrdVO.getCurrentRow().getAttribute("ApplicationDate");
                oracle.jbo.domain.Date paymentDate =
                    ADFDateUtils.addDayToOracleDate(str_date, number);
                //System.err.println("paymentDate-->" + paymentDate);
                applicationHrdVO.getCurrentRow().setAttribute("PaymentDueDate",
                                                              paymentDate);
                AdfFacesContext.getCurrentInstance().addPartialTarget(paymentDueDate);
                //--
                ViewObject paymentDueVO =
                    ADFUtils.findIterator("paymentDueDateROVO1Iterator").getViewObject();
                // Add event code here...

                if (applPayTerm.getValue() != null) {
                    if (applicationHrdVO.getCurrentRow().getAttribute("ApplicationDate") !=
                        null) {
                        String days =
                            applicationHrdVO.getCurrentRow().getAttribute("due_days") ==
                            null ? "0" :
                            applicationHrdVO.getCurrentRow().getAttribute("due_days").toString();
                        //               oracle.jbo.domain.Date appDate = (oracle.jbo.domain.Date)applicationHrdVO.getCurrentRow().getAttribute("ApplicationDate");
                        String stringDate =
                            applicationHrdVO.getCurrentRow().getAttribute("ApplicationDate").toString();

                        //                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                        //                df.parse(stringDate);
                        //System.err.println("---domainDate--->>" + stringDate);
                        paymentDueVO.setNamedWhereClauseParam("curdate",
                                                              stringDate);
                        paymentDueVO.setNamedWhereClauseParam("BV_NAME",
                                                              applPayTerm.getValue());
                        paymentDueVO.executeQuery();
                        if (paymentDueVO.getEstimatedRowCount() == 1) {
                            //System.err.println("Payment due Date====>" +
                            //                                               paymentDueVO.first().getAttribute("Paymentduedate"));
                            applicationHrdVO.getCurrentRow().setAttribute("PaymentDueDate",
                                                                          paymentDueVO.first().getAttribute("Paymentduedate"));
                            //                        buyPayDate.setValue(paymentDueVO.first().getAttribute("Paymentduedate"));
                            //                        paymentDueDate.setValue(paymentDueVO.first().getAttribute("Paymentduedate"));
                            AdfFacesContext.getCurrentInstance().addPartialTarget(buyPayDate);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(paymentDueDate);
                        }
                    } else {
                        JSFUtils.addFacesErrorMessage("Please select Application Date");
                    }
                }
            }

            // Line Remove
            //            RowSetIterator rs = applicationLineVO.createRowSetIterator(null);
            //            while (rs.hasNext()) {
            //                Row r = rs.next();
            //                r.remove();
            //            }

        }
        } 
        else {
//            System.err.println("==p_result else222222222222222==" );

        }
        
    }


    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }


    public void setUom(RichInputText uom) {
        this.uom = uom;
    }

    public RichInputText getUom() {
        return uom;
    }

    public void setQty(RichInputText qty) {
        this.qty = qty;
    }

    public RichInputText getQty() {
        return qty;
    }

    public void setRate(RichInputText rate) {
        this.rate = rate;
    }

    public RichInputText getRate() {
        return rate;
    }

    public void setAmt(RichInputText amt) {
        this.amt = amt;
    }

    public RichInputText getAmt() {
        return amt;
    }

    public void setCurrPer(RichInputText currPer) {
        this.currPer = currPer;
    }

    public RichInputText getCurrPer() {
        return currPer;
    }

    public void setCurrQty(RichInputText currQty) {
        this.currQty = currQty;
    }

    public RichInputText getCurrQty() {
        return currQty;
    }

    public void setCurrAmt(RichInputText currAmt) {
        this.currAmt = currAmt;
    }

    public RichInputText getCurrAmt() {
        return currAmt;
    }

    public void setCumuPer(RichInputText cumuPer) {
        this.cumuPer = cumuPer;
    }

    public RichInputText getCumuPer() {
        return cumuPer;
    }

    public void setCumuQty(RichInputText cumuQty) {
        this.cumuQty = cumuQty;
    }

    public RichInputText getCumuQty() {
        return cumuQty;
    }

    public void setCumuAmt(RichInputText cumuAmt) {
        this.cumuAmt = cumuAmt;
    }

    public RichInputText getCumuAmt() {
        return cumuAmt;
    }

    public void setPrePercen(RichInputText prePercen) {
        this.prePercen = prePercen;
    }

    public RichInputText getPrePercen() {
        return prePercen;
    }

    public void setPreQty(RichInputText preQty) {
        this.preQty = preQty;
    }

    public RichInputText getPreQty() {
        return preQty;
    }

    public void setPreAmt(RichInputText preAmt) {
        this.preAmt = preAmt;
    }

    public RichInputText getPreAmt() {
        return preAmt;
    }

    /******CURR PerCentage*******/
    public void currPerVCL(ValueChangeEvent currPerVCL) {
        currPerVCL.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (currPerVCL.getNewValue() != null) {
            double contLneRate =
                rate.getValue() == null ? 0 : Double.parseDouble(rate.getValue().toString());
            double contLneAmt =
                amt.getValue() == null ? 0 : Double.parseDouble(amt.getValue().toString());
            double currentPercen =
                currPerVCL.getNewValue() == null ? 0 : Double.parseDouble(currPerVCL.getNewValue().toString());
            //set Current Percentage
            applicationLineVO.getCurrentRow().setAttribute("CurrPerc",
                                                           new BigDecimal(currentPercen));
            AdfFacesContext.getCurrentInstance().addPartialTarget(currPer);
            //set Current Amount
            double currentAmount = (currentPercen * contLneAmt) / 100;
            applicationLineVO.getCurrentRow().setAttribute("CurrAmount",
                                                           currentAmount);
            //        currAmt.setValue(new BigDecimal(currentAmount));
            AdfFacesContext.getCurrentInstance().addPartialTarget(currAmt);
            //set Current Qty
            double currentQty = currentAmount / contLneRate;
            //        currQty.setValue(new BigDecimal(currentQty));
            applicationLineVO.getCurrentRow().setAttribute("CurrTotQty",
                                                           new BigDecimal(currentQty));
            AdfFacesContext.getCurrentInstance().addPartialTarget(currQty);
            //set Cumulative
            double previousPer =
                prePercen.getValue() == null ? 0 : Double.parseDouble(prePercen.getValue().toString());
            double previousQty =
                preQty.getValue() == null ? 0 : Double.parseDouble(preQty.getValue().toString());
            double previousAmt =
                preAmt.getValue() == null ? 0 : Double.parseDouble(preAmt.getValue().toString());
            //        cumuPer.setValue(new BigDecimal(previousPer+currentPercen));
            applicationLineVO.getCurrentRow().setAttribute("CumPerc",
                                                           new BigDecimal(previousPer +
                                                                          currentPercen));
            AdfFacesContext.getCurrentInstance().addPartialTarget(cumuPer);
            //        cumuQty.setValue(new BigDecimal(previousQty+currentQty));
            applicationLineVO.getCurrentRow().setAttribute("CumTotQty",
                                                           new BigDecimal(previousQty +
                                                                          currentQty));
            AdfFacesContext.getCurrentInstance().addPartialTarget(cumuQty);
            //        cumuAmt.setValue(new BigDecimal(previousAmt+currentAmount));
            applicationLineVO.getCurrentRow().setAttribute("CumAmount",
                                                           new BigDecimal(previousAmt +
                                                                          currentAmount));
            AdfFacesContext.getCurrentInstance().addPartialTarget(cumuAmt);
        }


    }

    /*****CURR QTY**********/
    public void currQtyVCL(ValueChangeEvent currQtyVCL) {

        currQtyVCL.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (currQtyVCL.getNewValue() != null) {
            double contLneRate =
                rate.getValue() == null ? 0 : Double.parseDouble(rate.getValue().toString());
            double contLneAmt =
                amt.getValue() == null ? 0 : Double.parseDouble(amt.getValue().toString());
            double currentQty =
                currQtyVCL.getNewValue() == null ? 0 : Double.parseDouble(currQtyVCL.getNewValue().toString());
            // set Current Qty
            applicationLineVO.getCurrentRow().setAttribute("CurrTotQty",
                                                           new BigDecimal(currentQty));
            AdfFacesContext.getCurrentInstance().addPartialTarget(currQty);
            // set currenty Amount
            double currentAmt = currentQty * contLneRate;
            applicationLineVO.getCurrentRow().setAttribute("CurrAmount",
                                                           new BigDecimal(currentAmt));
            //        currAmt.setValue(new BigDecimal(currentAmt));
            AdfFacesContext.getCurrentInstance().addPartialTarget(currAmt);
            // set current Percentage
            double currentPer = (100 * currentAmt / contLneAmt);
            //        currPer.setValue(new BigDecimal(currentPer));
            applicationLineVO.getCurrentRow().setAttribute("CurrPerc",
                                                           new BigDecimal(currentPer));
            AdfFacesContext.getCurrentInstance().addPartialTarget(currPer);
            //set cumulative value/
            double previousPer =
                prePercen.getValue() == null ? 0 : Double.parseDouble(prePercen.getValue().toString());
            double previousQty =
                preQty.getValue() == null ? 0 : Double.parseDouble(preQty.getValue().toString());
            double previousAmt =
                preAmt.getValue() == null ? 0 : Double.parseDouble(preAmt.getValue().toString());
            applicationLineVO.getCurrentRow().setAttribute("CumPerc",
                                                           new BigDecimal(previousPer +
                                                                          currentPer));
            AdfFacesContext.getCurrentInstance().addPartialTarget(cumuPer);
            applicationLineVO.getCurrentRow().setAttribute("CumTotQty",
                                                           new BigDecimal(previousQty +
                                                                          currentQty));
            AdfFacesContext.getCurrentInstance().addPartialTarget(cumuQty);
            applicationLineVO.getCurrentRow().setAttribute("CumAmount",
                                                           new BigDecimal(previousAmt +
                                                                          currentAmt));
            AdfFacesContext.getCurrentInstance().addPartialTarget(cumuAmt);
            //        cumuPer.setValue(new BigDecimal(previousPer+currentPer));
            //        cumuQty.setValue(new BigDecimal(previousQty+currentQty));
            //        cumuAmt.setValue(new BigDecimal(previousAmt+currentAmt));
        }

    }

    /*****CURR AMT*******/
    public void currAmtVCL(ValueChangeEvent currAmtVCL) {
        currAmtVCL.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (currAmtVCL.getNewValue() != null) {
            double contLneRate =
                rate.getValue() == null ? 0 : Double.parseDouble(rate.getValue().toString());
            double contLneAmt =
                amt.getValue() == null ? 0 : Double.parseDouble(amt.getValue().toString());
            double currentAmt =
                currAmtVCL.getNewValue() == null ? 0 : Double.parseDouble(currAmtVCL.getNewValue().toString());
            //set Current Amt
            applicationLineVO.getCurrentRow().setAttribute("CurrAmount",
                                                           currentAmt);
            //set Current Qty
            double currentQty = currentAmt / contLneRate;
            //        currQty.setValue(new BigDecimal(currentQty));
            applicationLineVO.getCurrentRow().setAttribute("CurrTotQty",
                                                           new BigDecimal(currentQty));
            AdfFacesContext.getCurrentInstance().addPartialTarget(currQty);
            //set Current Percentage
            double currentPercentage = (100 * currentAmt / contLneAmt);
            //System.err.println(currentPercentage);
            //        currPer.setValue(new BigDecimal(currentPercentage));
            applicationLineVO.getCurrentRow().setAttribute("CurrPerc",
                                                           new BigDecimal(currentPercentage));
            AdfFacesContext.getCurrentInstance().addPartialTarget(currPer);

            double previousPer =
                prePercen.getValue() == null ? 0 : Double.parseDouble(prePercen.getValue().toString());
            double previousQty =
                preQty.getValue() == null ? 0 : Double.parseDouble(preQty.getValue().toString());
            double previousAmt =
                preAmt.getValue() == null ? 0 : Double.parseDouble(preAmt.getValue().toString());
            cumuPer.setValue(new BigDecimal(previousPer + currentPercentage));
            applicationLineVO.getCurrentRow().setAttribute("CumPerc",
                                                           new BigDecimal(previousPer +
                                                                          currentPercentage));
            AdfFacesContext.getCurrentInstance().addPartialTarget(cumuPer);
            cumuQty.setValue(new BigDecimal(previousQty + currentQty));
            applicationLineVO.getCurrentRow().setAttribute("CumTotQty",
                                                           new BigDecimal(previousQty +
                                                                          currentQty));
            AdfFacesContext.getCurrentInstance().addPartialTarget(cumuQty);
            cumuAmt.setValue(new BigDecimal(previousAmt + currentAmt));
            applicationLineVO.getCurrentRow().setAttribute("CumAmount",
                                                           new BigDecimal(previousAmt +
                                                                          currentAmt));
            AdfFacesContext.getCurrentInstance().addPartialTarget(cumuAmt);
        }

    }

    //====================================NSCC==========================================


    public void onClickPopulateAmount(ActionEvent actionevent) {
        //        CalculateAmount();
    }

    public String onClickCalculateAmount() throws SQLException {
        //System.err.println("====paymenttype==" +
        //                           paymentType.getValue().toString());
        if (paymentType.getValue().toString().equals("Advance")) {
            // calculating advance
            TotalAdvanceCalculation();
        } else if (paymentType.getValue().toString().equals("Material Advance")) {
            // calculating Material advance
            TotalMaterialAdvanceCalculation();
        } else if (paymentType.getValue().toString().equals("Interim")) {
            // calculating Interim
            CalculateAmount1();
        } else if (paymentType.getValue().toString().equals("Final")) {
            // calculating Final
            CalculateAmount1();
        }
        return null;
    }


    /*****=========Advance Calculation===*****************/

    public void TotalAdvanceCalculation() {
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
            //System.err.println("======Row count====" +
            //                               applicationHrdVO.getEstimatedRowCount());
          
//            double Adv_amt =
//                tans_Adv_rec.getValue() == null ? 0 : Double.parseDouble(tans_Adv_rec.getValue().toString());
//         Commented due to arun changes 16-02-24
            double Adv_amt =
                        applicationHrdVO.getCurrentRow().getAttribute("Trans_Advan_Recovery_Advance") ==
                        null ? 0 :
                        Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Trans_Advan_Recovery_Advance").toString());

            
            double cur_amt =
                CurApplication.getValue() == null ? 0 : Double.parseDouble(CurApplication.getValue().toString());
            double pre_amt =
                prevAppl.getValue() == null ? 0 : Double.parseDouble(prevAppl.getValue().toString());
            double balance = Adv_amt - (cur_amt + pre_amt);
            //System.err.println("===Advance Amount===" + Adv_amt);

            if (balance < 0) {
                JSFUtils.addFacesErrorMessage("Please check Current Bill Amount ");
                applicationHrdVO.getCurrentRow().setAttribute("CurApplication",
                                                              "");
            } else {

                applicationHrdVO.getCurrentRow().setAttribute("TotalAdvAmount",
                                                              new BigDecimal(df.format(Adv_amt)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(curPayAmount);
                applicationHrdVO.getCurrentRow().setAttribute("BalContAmt",
                                                              new BigDecimal(df.format(balance)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(bal_Cont_Amt);
                applicationHrdVO.getCurrentRow().setAttribute("CurPayAmount",
                                                              new BigDecimal(df.format(cur_amt)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(TotalAdvAmount);
                // Tax
                //             -----------------
                String contLineVrsn = "0";
                String txCode = "0";
                String txAmt = "0";
                String txRate = "0";
                String contAdv = "0";
                BigDecimal txAmtBD = new BigDecimal("0");
                BigDecimal totlcontAdvBD = new BigDecimal("0");
                BigDecimal contAdvBD = new BigDecimal("0");
                BigDecimal fivePrcnt = new BigDecimal("0.05");
                String appHdrVrsn =
                    applicationHrdVO.getCurrentRow().getAttribute("Version") ==
                    null ? "0" :
                    applicationHrdVO.getCurrentRow().getAttribute("Version").toString();
                String headerid =
                    applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
                    null ? "0" :
                    applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
                ViewObject conlinevo =
                    ADFUtils.findIterator("contractLineROVO1Iterator").getViewObject();
                conlinevo.setNamedWhereClauseParam("BV_CONTID", headerid);
                conlinevo.executeQuery();
                //               String hdrtaxrate= conlinevo.first().getAttribute("TaxRate")==null?"0":
                //                conlinevo.first().getAttribute("TaxRate").toString();
                String hdrtaxrate = "0";

                RowSetIterator rsi = conlinevo.createRowSetIterator(null);
                while (rsi.hasNext()) {
                    Row rw = rsi.next();
                    contLineVrsn =
                            rw.getAttribute("Version") == null ? "0" : rw.getAttribute("Version").toString();
                    txCode =
                            rw.getAttribute("TaxCode") == null ? "0" : rw.getAttribute("TaxCode").toString();
                    if (!txCode.equalsIgnoreCase("REVERSE CHARGE") &&
                        contLineVrsn.equals(appHdrVrsn)) {
                        //                    txAmt = rw.getAttribute("TaxAmount")==null?"0":rw.getAttribute("TaxAmount").toString();
                        contAdv =
                                rw.getAttribute("ContAdv") == null ? "0" : rw.getAttribute("ContAdv").toString();
                        contAdvBD = new BigDecimal(contAdv);
                        totlcontAdvBD = totlcontAdvBD.add(contAdvBD);
                        txRate =
                                rw.getAttribute("TaxRate") == null ? "0" : rw.getAttribute("TaxRate").toString();

                        if (!txRate.equals("0")) {
                            hdrtaxrate = "5";
                        }
                    }
                    //                    if(txCode.equalsIgnoreCase("REVERSE CHARGE") && contLineVrsn.equals(appHdrVrsn)){
                    //                        hdrtaxrate="0";
                    //                    }
                }
                rsi.closeRowSetIterator();
                if (hdrtaxrate.equalsIgnoreCase("0")) {
                    applicationHrdVO.getCurrentRow().setAttribute("Curpaytaxamount",
                                                                  new BigDecimal(df.format(0)));
//                    System.err.println("643 line Curpaytaxamount 0");
                } else {
                    applicationHrdVO.getCurrentRow().setAttribute("Taxrate",
                                                                  5);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(taxRateApp);
                    //                     double tax_Amt = (5 * cur_amt) / 100;
                        /**
                         * Including charges
                         */
                        double contra_charge =
                        contra_Charges.getValue() == null ? 0 : Double.parseDouble(contra_Charges.getValue().toString());
                        double penality_charge =
                        penality_charges.getValue() == null ? 0 : Double.parseDouble(penality_charges.getValue().toString());
                        double amount = ((contra_charge + penality_charge)*5)/100;
                    double tax_Amt =
                        ((totlcontAdvBD).multiply(fivePrcnt)).doubleValue();

                    double taxWithContrChrages=tax_Amt-amount;
//                    applicationHrdVO.getCurrentRow().setAttribute("Curpaytaxamount",
//                                                                  new BigDecimal(df.format(tax_Amt)));
                    applicationHrdVO.getCurrentRow().setAttribute("Curpaytaxamount",
                                                                  new BigDecimal(df.format(taxWithContrChrages)));
                    System.err.println("653 line Curpaytaxamount "+new BigDecimal(df.format(tax_Amt)));

                }
                //         ----------------------
                //            double taxRate =
                //                applicationHrdVO.getCurrentRow().getAttribute("Taxrate") ==
                //                null ? 0 :
                //                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Taxrate").toString());
                //            applicationHrdVO.getCurrentRow().setAttribute("Taxrate", taxRate);
                //            AdfFacesContext.getCurrentInstance().addPartialTarget(taxRateApp);
                //            double tax_Amt = (taxRate * cur_amt) / 100;
                //
                AdfFacesContext.getCurrentInstance().addPartialTarget(curPayTaxAmount1);
            }
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
            RowSetIterator rs = AdvanceVO.createRowSet(null);
            double sum = 0;
            while (rs.hasNext()) {
                Row r = rs.next();
                sum +=
Double.parseDouble(r.getAttribute("AdvanceAmt").toString());
            }
            String Hid =
                applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
            String ver =
                applicationHrdVO.getCurrentRow().getAttribute("Version") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("Version").toString();
            String apphdrid =
                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
                null ? "" :
                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();

            ViewObject vo =
                ADFUtils.findIterator("AdvPrevAmt_ROVO1Iterator").getViewObject();
            vo.setNamedWhereClauseParam("BV_cont_ID", Hid);
            vo.setNamedWhereClauseParam("BV_app_id", apphdrid);
            vo.setNamedWhereClauseParam("Bv_ver", ver);
            vo.executeQuery();
            //System.err.println("row count==>" + vo.getEstimatedRowCount());
            double prevamt =
                vo.first().getAttribute("Amount") == null ? 0 : Double.parseDouble(vo.first().getAttribute("Amount").toString());

            applicationHrdVO.getCurrentRow().setAttribute("CurApplication",
                                                          new BigDecimal(df.format(sum)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(CurApplication);
            applicationHrdVO.getCurrentRow().setAttribute("CurPayAmount",
                                                          new BigDecimal(df.format(sum)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(curPayAmount);
            applicationHrdVO.getCurrentRow().setAttribute("PrevApplication",
                                                          new BigDecimal(df.format(prevamt)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(prevAppl);
            // Tax
            //        applicationHrdVO.getCurrentRow().setAttribute("Taxrate", 5);
            //        AdfFacesContext.getCurrentInstance().addPartialTarget(taxRateApp);
            //        double tax_Amt = (5 * cur_amt) / 100;
            //        applicationHrdVO.getCurrentRow().setAttribute("Curpaytaxamount",
            //                                                      new BigDecimal(df.format(tax_Amt)));
            //        AdfFacesContext.getCurrentInstance().addPartialTarget(curPayTaxAmount1);
        }

    }

    /*****=========Material Advance Calculation===*****************/

    public void TotalMaterialAdvanceCalculation() {
        //        //System.err.println("======Row count====" +applicationHrdVO.getEstimatedRowCount());
        double Mat_Adv_amt = 0;
        double cur_amt = 0;
        double pre_amt = 0;
        double balance = 0;
        Mat_Adv_amt =
                material_Adv_amt.getValue() == null ? 0 : Double.parseDouble(material_Adv_amt.getValue().toString());
        cur_amt =
                CurApplication.getValue() == null ? 0 : Double.parseDouble(CurApplication.getValue().toString());
        pre_amt =
                prevAppl.getValue() == null ? 0 : Double.parseDouble(prevAppl.getValue().toString());
        balance = Mat_Adv_amt - (cur_amt + pre_amt);

        //        //System.err.println("===Advance Amount===" + Mat_Adv_amt);
        applicationHrdVO.getCurrentRow().setAttribute("TotalMatAdvAmount",
                                                      new BigDecimal(df.format(Mat_Adv_amt)));
        AdfFacesContext.getCurrentInstance().addPartialTarget(tot_mat_adv_amt);
        applicationHrdVO.getCurrentRow().setAttribute("BalContAmt",
                                                      new BigDecimal(df.format(balance)));
        AdfFacesContext.getCurrentInstance().addPartialTarget(bal_Cont_Amt);
        applicationHrdVO.getCurrentRow().setAttribute("CurPayAmount",
                                                      new BigDecimal(df.format(cur_amt)));
        AdfFacesContext.getCurrentInstance().addPartialTarget(curPayAmount);
        // Tax
        String hdrtaxrate = "0";
        String txAmt = "0";
        String txRate = "0";
        String txCode = "0";
        BigDecimal txAmtBD = new BigDecimal("0");
        BigDecimal totlTxAmtBD = new BigDecimal("0");
        RowSetIterator rsi = applicationLineVO.createRowSetIterator(null);
        while (rsi.hasNext()) {
            Row rw = rsi.next();
            txCode =
                    rw.getAttribute("TaxCode") == null ? "0" : rw.getAttribute("TaxCode").toString();
            if (!txCode.equalsIgnoreCase("REVERSE CHARGE")) {
                txAmt =
                        rw.getAttribute("TaxAmount") == null ? "0" : rw.getAttribute("TaxAmount").toString();
                txAmtBD = new BigDecimal(txAmt);
                totlTxAmtBD = totlTxAmtBD.add(txAmtBD);
                txRate =
                        rw.getAttribute("TaxRate") == null ? "0" : rw.getAttribute("TaxRate").toString();
                if (!txRate.equals("0")) {
                    hdrtaxrate = "5";
                }
            }
        }
        rsi.closeRowSetIterator();
        double taxRate = Double.parseDouble(hdrtaxrate);
        //            applicationHrdVO.getCurrentRow().getAttribute("Taxrate") ==
        //            null ? 0 :
        //            Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Taxrate").toString());
        applicationHrdVO.getCurrentRow().setAttribute("Taxrate", taxRate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(taxRateApp);
        double tax_Amt = totlTxAmtBD.doubleValue();
        //        double tax_Amt = (taxRate * cur_amt) / 100;
        /**
        * Including charges
        */
        double contra_charge =
        contra_Charges.getValue() == null ? 0 : Double.parseDouble(contra_Charges.getValue().toString());
        double penality_charge =
        penality_charges.getValue() == null ? 0 : Double.parseDouble(penality_charges.getValue().toString());
        double amount = ((contra_charge + penality_charge)*5)/100;
        double tax_amt_withCharges=tax_Amt-amount;
//        applicationHrdVO.getCurrentRow().setAttribute("Curpaytaxamount",
//                                                      new BigDecimal(df.format(tax_Amt)));
        applicationHrdVO.getCurrentRow().setAttribute("Curpaytaxamount",
                                                      new BigDecimal(df.format(tax_amt_withCharges)));
        AdfFacesContext.getCurrentInstance().addPartialTarget(curPayTaxAmount1);
        System.err.println("777 line Curpaytaxamount "+new BigDecimal(df.format(tax_Amt)));

        
    }


    /*****=========Interim===*****************/

    public void CalculateAmount1() throws SQLException {
        // Previous
        PreviousAppliedAmount();
        //        calculateretrel();
        // Current
        CurrentApplicationAmount();
        CurrentAdvanceRecovery();
        CurrentMaterialAdvanceRecovery();
        /****Retention****/
        // TotalRet
        double ret_amt =
            trans_ret_amt.getValue() == null ? 0 : Double.parseDouble(trans_ret_amt.getValue().toString());
        applicationHrdVO.getCurrentRow().setAttribute("TotalRet",
                                                      new BigDecimal(df.format(ret_amt)));
        AdfFacesContext.getCurrentInstance().addPartialTarget(TotalRet);
        double cur_app =
            CurApplication.getValue() == null ? 0 : Double.parseDouble(CurApplication.getValue().toString());
        double re_per =
            ret_per.getValue() == null ? 0 : Double.parseDouble(ret_per.getValue().toString());
        
        double cur_ret = (cur_app * re_per) / 100;
        System.err.println("cur_ret per==>" + cur_ret);
        System.err.println("cur_app==>" + cur_app);
        System.err.println("re_per==>" + re_per);

        if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy") ||
            ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
            /**
             * Arun changes 19-02-24 ,For final PC Retention value from net payment
             */
              if( paymentType.getValue().toString().equals("Final"))
              {
            
                        applicationHrdVO.getCurrentRow().setAttribute("CurRet",
                                                                      new BigDecimal(df.format(cur_ret)));
                  AdfFacesContext.getCurrentInstance().addPartialTarget(CurRet);
                  System.err.println("Inside Final of Cur retention CalculateAmount1==>" + cur_ret);


              }
              else{
            curentRetention();
            AdfFacesContext.getCurrentInstance().addPartialTarget(CurRet);
              }
        }
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
            //CurRet
            String Hid =
                applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
            String ver =
                applicationHrdVO.getCurrentRow().getAttribute("Version") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("Version").toString();
            String apphdrid =
                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
                null ? "" :
                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();
            RetamountVO.setNamedWhereClauseParam("cont_hdr_id", Hid);
            RetamountVO.setNamedWhereClauseParam("version", ver);
            RetamountVO.setNamedWhereClauseParam("app_hdr_id", apphdrid);
            RetamountVO.setNamedWhereClauseParam("amount", cur_ret);
            RetamountVO.executeQuery();
            double retamt =
                RetamountVO.first().getAttribute("Amount") == null ? 0 :
                Double.parseDouble(RetamountVO.first().getAttribute("Amount").toString());
            //        RetamountVO.first().getAttribute("Amount")
            applicationHrdVO.getCurrentRow().setAttribute("CurRet",
                                                          new BigDecimal(df.format(retamt)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(CurRet);
        }
        double Adv_amt = 0;
        Adv_amt =
                tans_Adv_rec.getValue() == null ? 0 : Double.parseDouble(tans_Adv_rec.getValue().toString());
        //System.err.println("===Advance Amount===" + Adv_amt);
        applicationHrdVO.getCurrentRow().setAttribute("TotalAdvAmount",
                                                      new BigDecimal(df.format(Adv_amt)));
        materialadvanceamount();
        // Balance for Buys side
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy") ||
            ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
            BalanceAdvanceRecovery();
            BalanceRetention();
            BalanceContractAmt();
            BalanceMaterialAdvanceRecovery();
        } else {
            //System.err.println("==Sell===>No Balance");
        }
        // Net Payment
        double netpayamt = 0;
        double netamount = 0;
        double totalTaxAmt = 0;
        double cur_mat_ret = 0;
        double cur_appli =
            CurApplication.getValue() == null ? 0 : Double.parseDouble(CurApplication.getValue().toString());
        double cur_adv_rec =
            CurAdvRec.getValue() == null ? 0 : Double.parseDouble(CurAdvRec.getValue().toString());
        double cur_reten =
            CurRet.getValue() == null ? 0 : Double.parseDouble(CurRet.getValue().toString());
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy") ||
            ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
            cur_mat_ret =
                    applicationHrdVO.getCurrentRow().getAttribute("CurMatAdvRec") ==
                    null ? 0 :
                    Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurMatAdvRec").toString());
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
            cur_mat_ret =
                    applicationHrdVO.getCurrentRow().getAttribute("CurMatOnSiteRec") ==
                    null ? 0 :
                    Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurMatOnSiteRec").toString());
        }
        //            cur_mat_adv_rec.getValue() == null ? 0 : Double.parseDouble(cur_mat_adv_rec.getValue().toString());

        //        double totalOtherCharg =applicationHrdVO.getCurrentRow().getAttribute("TotOthCharge")==null?0:Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("TotOthCharge").toString());
        double totalOtherCharg =
            curOthCharge.getValue() == null ? 0 : Double.parseDouble(curOthCharge.getValue().toString());
        //System.err.println("totalOtherCharg--==>>" + totalOtherCharg);
        if (contra_Charges.getValue() == null &&
            penality_charges.getValue() == null) {
            netamount = cur_appli - (cur_adv_rec + cur_reten + cur_mat_ret);
            netpayamt = netamount + totalOtherCharg;
        } else {
            netamount = cur_appli - (cur_adv_rec + cur_reten + cur_mat_ret);
            double contra_charge =
                contra_Charges.getValue() == null ? 0 : Double.parseDouble(contra_Charges.getValue().toString());
            double penality_charge =
                penality_charges.getValue() == null ? 0 : Double.parseDouble(penality_charges.getValue().toString());
            double amount = contra_charge + penality_charge;
            netpayamt = netamount - amount + totalOtherCharg;
        }
        // Currrent Pay Amount
        applicationHrdVO.getCurrentRow().setAttribute("CurPayAmount",
                                                      new BigDecimal(df.format(netpayamt)));
        AdfFacesContext.getCurrentInstance().addPartialTarget(curPayAmount);

        // Tax
        RowSetIterator appLnsRS = applicationLineVO.createRowSet(null);
        double taxRate = 0;
        double taxAmt = 0;
        BigDecimal txAmtBD = new BigDecimal("0");
        BigDecimal totlTxAmtBD = new BigDecimal("0");

        String txCode = "0";
        while (appLnsRS.hasNext()) {
            Row r = appLnsRS.next();
            txCode =
                    r.getAttribute("TaxCode") == null ? "0" : r.getAttribute("TaxCode").toString();
//            System.err.println("919 line Inside while loop "+txCode);

            if (!txCode.equalsIgnoreCase("REVERSE CHARGE")) {

                taxAmt =
                        r.getAttribute("TaxAmount") == null ? 0 : Double.parseDouble(r.getAttribute("TaxAmount").toString());

                //            totalTaxAmt = totalTaxAmt + taxAmt;
//                System.err.println("926 line Inside if "+taxAmt);

                txAmtBD = new BigDecimal(taxAmt);
                totlTxAmtBD = totlTxAmtBD.add(txAmtBD);
//                System.err.println("926 line Curpaytaxamount "+totlTxAmtBD);

                if (r.getAttribute("TaxRate") != null &&
                    !r.getAttribute("TaxRate").toString().equals("0")) {
                    taxRate =
                            r.getAttribute("TaxRate") == null ? 0 : Double.parseDouble(r.getAttribute("TaxRate").toString());
                }
            }
        }
        applicationHrdVO.getCurrentRow().setAttribute("Taxrate",
                                                      new BigDecimal(df.format(taxRate)));
        AdfFacesContext.getCurrentInstance().addPartialTarget(taxRateApp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(taxRateApp1);
        // Net Pay Tax amt
        //        totalTaxAmt = (taxRate * netpayamt) / 100;
        //        applicationHrdVO.getCurrentRow().setAttribute("Curpaytaxamount",
        //                                                      new BigDecimal(df.format(totalTaxAmt)));
        //        applicationHrdVO.getCurrentRow().setAttribute("Curpaytaxamount",
        //                                                      (new BigDecimal(df.format(netpayamt))).multiply(new BigDecimal(df.format(taxRate))).divide(new BigDecimal("100")));
        double tax_Amt = totlTxAmtBD.doubleValue();
        
                                /**
                                 * * Including charges
                                 */
                               double contra_charge =
                               contra_Charges.getValue() == null ? 0 : Double.parseDouble(contra_Charges.getValue().toString());
                               double penality_charge =
                               penality_charges.getValue() == null ? 0 : Double.parseDouble(penality_charges.getValue().toString());
                               double taxrate=applicationHrdVO.getCurrentRow().getAttribute("Taxrate")==null ?0:Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Taxrate").toString());
                               double amount = ((contra_charge + penality_charge)*taxrate)/100;
                         double amountWithcharges=  tax_Amt - amount; 
//        applicationHrdVO.getCurrentRow().setAttribute("Curpaytaxamount",
//                                                      new BigDecimal(df.format(tax_Amt)));
                              /**
      * Arun changes 19-02-24
      */
                        if( paymentType.getValue().toString().equals("Final"))
              {

                  double final_taxamount = (netpayamt*taxrate)/100;

                        applicationHrdVO.getCurrentRow().setAttribute("Curpaytaxamount",
                                                                      new BigDecimal(df.format(final_taxamount)));
                  AdfFacesContext.getCurrentInstance().addPartialTarget(curPayTaxAmount);
                  AdfFacesContext.getCurrentInstance().addPartialTarget(curPayTaxAmount1);
              }
              else{               
                         
        applicationHrdVO.getCurrentRow().setAttribute("Curpaytaxamount",
                                                      new BigDecimal(df.format(amountWithcharges)));
        
        AdfFacesContext.getCurrentInstance().addPartialTarget(curPayTaxAmount);
        AdfFacesContext.getCurrentInstance().addPartialTarget(curPayTaxAmount1);
              }
        // Cummulative
        CumulativeAdvanceRecoveryRetention();
        // penality charges
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
            penalty_back_charges();
        }
    }
public void lineTaxAmountCalculation()
{
        //                    double taxAmt = (currentAmt * taxRate) / 100;
                                               double currentAmt =
                               applicationLineVO.getCurrentRow().getAttribute("CurrAmount") ==
                               null ? 0 :
                               Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("CurrAmount").toString());
                           double cur_adv_rec_amount =
                               applicationLineVO.getCurrentRow().getAttribute("CurAdvRecAmount") ==
                               null ? 0 :
                               Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("CurAdvRecAmount").toString());
                           double cur_ret_rec_amount =
                               applicationLineVO.getCurrentRow().getAttribute("CurRetRecAmount") ==
                               null ? 0 :
                               Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("CurRetRecAmount").toString());
                           double taxRate =
                                    applicationLineVO.getCurrentRow().getAttribute("TaxRate") ==
                                  null ? 0 :
                              Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("TaxRate").toString());
                           /**
                  * tax_amount 01-09-2023 added as requested by arun
                  */
                           double final_tax_amount =
                               currentAmt - cur_adv_rec_amount - cur_ret_rec_amount;

                           double taxAmt = (final_tax_amount * taxRate) / 100;
                           applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                          new BigDecimal(df.format(taxAmt)));


                           AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
    }
    // Interim material advance amount

    public void materialadvanceamount() {
        double mat_adv_amt = 0;
        mat_adv_amt =
                material_Adv_amt.getValue() == null ? 0 : Double.parseDouble(material_Adv_amt.getValue().toString());
        //        //System.err.println("===mat Advance Amount===" + mat_adv_amt);
        applicationHrdVO.getCurrentRow().setAttribute("TotalMatAdvAmount",
                                                      new BigDecimal(df.format(mat_adv_amt)));
        AdfFacesContext.getCurrentInstance().addPartialTarget(tot_mat_adv_amt);

    }


    // Interim- Calculating Cummulative

    public void CumulativeAdvanceRecoveryRetention() {
        double cumAdv = 0;
        double cumret = 0;
        double cummatadv = 0;
        double prevAmount = 0;
        try {
            RowSetIterator Applines =
                applicationLineVO.createRowSetIterator(null);
            double sum = 0;
            double peradvrec =
                applicationHrdVO.getCurrentRow().getAttribute("PrevAdvRec") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("PrevAdvRec").toString());
            double curadvrec =
                applicationHrdVO.getCurrentRow().getAttribute("CurAdvRec") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurAdvRec").toString());
            double preret =
                applicationHrdVO.getCurrentRow().getAttribute("PrevRet") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("PrevRet").toString());
            double curret =
                applicationHrdVO.getCurrentRow().getAttribute("CurRet") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurRet").toString());
            double prematrec =
                applicationHrdVO.getCurrentRow().getAttribute("PrevMatAdvAmt") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("PrevMatAdvAmt").toString());
            double curmatrec =
                applicationHrdVO.getCurrentRow().getAttribute("CurMatAdvRec") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurMatAdvRec").toString());
            while (Applines.hasNext()) {
                Row r = Applines.next();
                prevAmount =
                        r.getAttribute("CumAmount") == null ? 0 : Double.parseDouble(r.getAttribute("CumAmount").toString());
                sum = sum + prevAmount;
            }
            cumAdv = peradvrec + curadvrec;
            cumret = preret + curret;
            cummatadv = prematrec + curmatrec;
            //System.err.println("=====cummulative Applied Amount=====" + sum);
            applicationHrdVO.getCurrentRow().setAttribute("CumApplication",
                                                          new BigDecimal(df.format(sum)));
            //            AdfFacesContext.getCurrentInstance().addPartialTarget(cum_Amt);
            applicationHrdVO.getCurrentRow().setAttribute("CumAdvRec",
                                                          new BigDecimal(df.format(cumAdv)));
            //            AdfFacesContext.getCurrentInstance().addPartialTarget(cum_adv_rec);
            applicationHrdVO.getCurrentRow().setAttribute("CumMatAdvRec",
                                                          new BigDecimal(df.format(cummatadv)));
            //            AdfFacesContext.getCurrentInstance().addPartialTarget(cum_mat_adv_rec);
            applicationHrdVO.getCurrentRow().setAttribute("CumRet",
                                                          new BigDecimal(df.format(cumret)));
            //            AdfFacesContext.getCurrentInstance().addPartialTarget(cum_ret);
        } catch (Exception e) {
            //System.err.println("====Error====" + e);
        }
    }

    // Interim BalanceContractAmt

    public void BalanceContractAmt() {
        double balanceamt = 0;
        double tot_amt =
            cont_Amt.getValue() == null ? 0 : Double.parseDouble(cont_Amt.getValue().toString());
        double prev_amt =
            prevAppl.getValue() == null ? 0 : Double.parseDouble(prevAppl.getValue().toString());
        double cur_amt =
            CurApplication.getValue() == null ? 0 : Double.parseDouble(CurApplication.getValue().toString());
        balanceamt = tot_amt - prev_amt - cur_amt;
        applicationHrdVO.getCurrentRow().setAttribute("BalContAmt",
                                                      new BigDecimal(df.format(balanceamt)));
        AdfFacesContext.getCurrentInstance().addPartialTarget(bal_Cont_Amt);

    }

    // ????

    public void netpaymentamt() {
        double netpayamt = 0;
        double cur_app =
            CurApplication.getValue() == null ? 0 : Double.parseDouble(CurApplication.getValue().toString());
        double cur_adv_rec =
            CurAdvRec.getValue() == null ? 0 : Double.parseDouble(CurAdvRec.getValue().toString());
        double cur_ret =
            CurRet.getValue() == null ? 0 : Double.parseDouble(CurRet.getValue().toString());
        double cur_mat_ret =
            applicationHrdVO.getCurrentRow().getAttribute("CurMatAdvRec") ==
            null ? 0 :
            Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurMatAdvRec").toString());
        //            cur_mat_adv_rec.getValue() == null ? 0 : Double.parseDouble(cur_mat_adv_rec.getValue().toString());
        netpayamt = cur_app - (cur_adv_rec + cur_ret + cur_mat_ret);
        applicationHrdVO.getCurrentRow().setAttribute("CurPayAmount",
                                                      new BigDecimal(netpayamt));
        AdfFacesContext.getCurrentInstance().addPartialTarget(curPayAmount);

    }

    // ????

    public void PaymentAmtInt() {
        try {
            double sum = 0;
            double CurAppl =
                CurApplication.getValue() == null ? 0 : Double.parseDouble(CurApplication.getValue().toString());
            double CurAdvrec =
                CurAdvRec.getValue() == null ? 0 : Double.parseDouble(CurAdvRec.getValue().toString());
            double Curret =
                CurRet.getValue() == null ? 0 : Double.parseDouble(CurRet.getValue().toString());
            sum = CurAppl - CurAdvrec - Curret;
            //System.err.println("======Payment Amount Interim close======" +
            //                               sum);
            applicationHrdVO.getCurrentRow().setAttribute("CurPayAmount",
                                                          new BigDecimal(sum));
            AdfFacesContext.getCurrentInstance().addPartialTarget(curPayAmount);
        } catch (Exception e) {
            //System.err.println("====Error====" + e);
        }
    }

    // Interim  CurrentApplicationAmount
    double totalAdvLines = 0;
    double totalRetLines = 0;

    public void CurrentApplicationAmount() throws SQLException {
        //        try {
        RowSetIterator Applines = applicationLineVO.createRowSetIterator(null);
        // double totalLines = applicationLineVO.getEstimatedRowCount();
        double sum = 0;
        double adv = 0;
        double ret = 0;
        Object s = 0;
        while (Applines.hasNext()) {
            Row r = Applines.next();
            //current application amount
            if (r.getAttribute("CurrAmount") != null) {
                sum =
sum + Double.parseDouble(r.getAttribute("CurrAmount").toString());
                //System.err.println("AA  - > "+r.getAttribute("CurrAmount"));
            }

            //current adv line percentage
            if (r.getAttribute("AdvRecPer") != null) {
                if (!(r.getAttribute("AdvRecPer").equals(0))) {
                    adv =
adv + Double.parseDouble(r.getAttribute("AdvRecPer").toString());
                    if (totalAdvLines == 0) {

                        totalAdvLines++;
                    } else {
                        totalAdvLines += totalAdvLines;
                        // totalAdvLines++;
                    }
                }
            }
            //current ret line percentage

            if (r.getAttribute("RetRecPer") != null) {
                if (!(r.getAttribute("RetRecPer").equals(0))) {
                    ret =
ret + Double.parseDouble(r.getAttribute("RetRecPer").toString());
                    if (totalRetLines == 0) {

                        totalRetLines++;
                    } else {
                        totalRetLines += totalRetLines;
                        //    totalRetLines++;
                    }
                }
            }
        }
        //System.err.println("total lines - > "+totalAdvLines +"ssssss"+totalRetLines );
        //System.err.println("sum  - > "+sum);
        //System.err.println("adv  - > "+adv);
        //System.err.println("ret  - > "+ret);
        //calc adv percentage old code
        //            double cur_adv_per =(adv/totalAdvLines);
        //            double cur_ret_per = (ret/totalRetLines);
        //calc adv percentage new code
        double cur_adv_per = (adv);
        double cur_ret_per = (ret);

        //System.err.println("=====Current Adv %=====" + cur_adv_per);
        //System.err.println("=====Current Ret %=====" + cur_ret_per);
        if (Double.toString(cur_adv_per).equals("NaN")) {
            cur_adv_per = 0;
        }
        if (Double.toString(cur_ret_per).equals("NaN")) {
            cur_ret_per = 0;
        }
        applicationHrdVO.getCurrentRow().setAttribute("CurApplication",
                                                      new BigDecimal(df.format(sum)));
        applicationHrdVO.getCurrentRow().setAttribute("Curadvrecper",
                                                      new Number(cur_adv_per));
        applicationHrdVO.getCurrentRow().setAttribute("Curretper",
                                                      new Number(cur_ret_per));
        AdfFacesContext.getCurrentInstance().addPartialTarget(CurApplication);
        //        } catch (Exception e) {
        //            //System.err.println("====Error====" + e);
        //        }
    }

    // Interim  PreviousAppliedAmount

    public void PreviousAppliedAmount() {
        ViewObject previousVO =
            ADFUtils.findIterator("PreviousAppCalIterator").getViewObject();
        double sum = 0;
        String Hid =
            applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
        String ver =
            applicationHrdVO.getCurrentRow().getAttribute("Version") == null ?
            "0" :
            applicationHrdVO.getCurrentRow().getAttribute("Version").toString();
        String apphdrid =
            applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();
        //System.err.println("Hid--->" + Hid + "apphdrid--->" + apphdrid +
        //                           "ver--->" + ver);
        previousVO.setNamedWhereClauseParam("BV_HID", Hid);
        previousVO.setNamedWhereClauseParam("APP_HDR_ID", apphdrid);
        previousVO.setNamedWhereClauseParam("VER", ver);
        previousVO.executeQuery();
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
            RowSetIterator rs = AdvancRecVO.createRowSet(null);
            while (rs.hasNext()) {
                Row r = rs.next();
                sum +=
Double.parseDouble(r.getAttribute("RecoveredAmt").toString());
            }
        }
        if (previousVO.getEstimatedRowCount() == 1) {
            // Previous Application
            applicationHrdVO.getCurrentRow().setAttribute("PrevApplication",
                                                          previousVO.first().getAttribute("Prevamount"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(prevAppl);
            if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
                applicationHrdVO.getCurrentRow().setAttribute("PrevAdvRec",
                                                              previousVO.first().getAttribute("Preadvrec"));
            } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
                applicationHrdVO.getCurrentRow().setAttribute("PrevAdvRec",
                                                              sum);
                AdfFacesContext.getCurrentInstance().addPartialTarget(PrevAdvRec);
            }
            // Previous Adv Reco

            // Previous Adv Reten
            applicationHrdVO.getCurrentRow().setAttribute("PrevRet",
                                                          previousVO.first().getAttribute("Preretrec"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(PrevRet);
            // Previous Material
            applicationHrdVO.getCurrentRow().setAttribute("PrevMatAdvAmt",
                                                          previousVO.first().getAttribute("Prematadvrec"));
            //System.err.println("prev - - > " +
            //                               previousVO.first().getAttribute("Prevothchargeamt"));
            applicationHrdVO.getCurrentRow().setAttribute("PrevOthCharge",
                                                          previousVO.first().getAttribute("Prevothchargeamt"));
            //            applicationHrdVO.getCurrentRow().setAttribute("PerRetRel",
            //                                                          previousVO.first().getAttribute("Prevretrel"));
        } else {

        }
        /*
        double cur_bal_adv_rec = 0;
        double prevAdv = 0;
        double prevRet = 0;
        double prevmatadv = 0;
        double prevAmount = 0;

        try {

            RowSetIterator Applines =applicationLineVO.createRowSetIterator(null);
            double sum = 0;
            double advper =applicationHrdVO.getCurrentRow().getAttribute("Curadvrecper") ==null ? 0
                           :Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Curadvrecper").toString());
            double Retper =applicationHrdVO.getCurrentRow().getAttribute("Curretper") ==null ? 0
                            :Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Curretper").toString());
            double matper =applicationHrdVO.getCurrentRow().getAttribute("Curmatadvrecper") ==null ? 0
                           :Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Curmatadvrecper").toString());

            while (Applines.hasNext()) {
                Row r = Applines.next();
                prevAmount = r.getAttribute("PrevAmount") == null ? 0 : Double.parseDouble(r.getAttribute("PrevAmount").toString());
                sum = sum + prevAmount;
            }

            prevAdv = (sum * advper) / 100;
            prevRet = (sum * Retper) / 100;
            prevmatadv = (sum * matper) / 100;

            //            //System.err.println("=====Previous Applied Amount=====" + sum);
            // Previous Application
            applicationHrdVO.getCurrentRow().setAttribute("PrevApplication",new BigDecimal(df.format(sum)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(prevAppl);
            // Previous Adv Reco
            applicationHrdVO.getCurrentRow().setAttribute("PrevAdvRec",new BigDecimal(df.format(prevAdv)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(PrevAdvRec);
            // Previous Adv Reten
            applicationHrdVO.getCurrentRow().setAttribute("PrevRet",new BigDecimal(df.format(prevRet)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(PrevRet);
            // Previous Material
            applicationHrdVO.getCurrentRow().setAttribute("PrevMatAdvAmt",new BigDecimal(df.format(prevmatadv)));

        } catch (Exception e) {
            //System.err.println("====Error====" + e);
        }
*/
    }
    // ????

    public void TotalAdvanceAmount() {
        Row r = applicationHrdVO.getCurrentRow();
        //System.err.println("======Row count====" +
        //                           applicationHrdVO.getEstimatedRowCount());
        double Totadvamount = 0;
        //System.err.println("====VAL1=====" +
        //                           r.getAttribute("Trans_Revis_Cont_Amount") +
        //                           "*********" +
        //                           r.getAttribute("Trans_Advan_Rec_Per"));
        if (r.getAttribute("Trans_Revis_Cont_Amount") != null &&
            r.getAttribute("Trans_Advan_Rec_Per") != null) {
            Totadvamount =
                    (Double.parseDouble(r.getAttribute("Trans_Revis_Cont_Amount").toString()) *
                     Double.parseDouble(r.getAttribute("Trans_Advan_Rec_Per").toString())) /
                    100;
        }
        //System.err.println("======TotalAdvanceAmount======" + Totadvamount);
        if (paymentType.getValue().toString().equalsIgnoreCase("Advance")) {

        } else {
            applicationHrdVO.getCurrentRow().setAttribute("TotalAdvAmount",
                                                          new BigDecimal(Totadvamount));
            AdfFacesContext.getCurrentInstance().addPartialTarget(TotalAdvAmount);
        }


    }

    // ????

    public void TotalRetention() {
        Row r = applicationHrdVO.getCurrentRow();
        //System.err.println("======Row count====" +
        //                           applicationHrdVO.getEstimatedRowCount());
        double sum = 0;
        //System.err.println("====VAL1=====" +r.getAttribute("Trans_Revis_Cont_Amount") +
        //                           "*********" +
        //                           r.getAttribute("Trans_Retension_Per"));
        if (r.getAttribute("Trans_Revis_Cont_Amount") != null &&
            r.getAttribute("Trans_Retension_Per") != null) {
            sum =
(Double.parseDouble(r.getAttribute("Trans_Revis_Cont_Amount").toString()) *
 Double.parseDouble(r.getAttribute("Trans_Retension_Per").toString())) / 100;
        }
        //System.err.println("======TotalRetention======" + sum);
        applicationHrdVO.getCurrentRow().setAttribute("TotalRet",
                                                      new BigDecimal(sum));
        AdfFacesContext.getCurrentInstance().addPartialTarget(TotalRet);

    }


    /***********Interim==Current Advance Recovery*****************************/

    public void CurrentAdvanceRecovery() throws SQLException {
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {

            //            Row r = applicationHrdVO.getCurrentRow();
            //            double sum = 0;
            //            if (r.getAttribute("CurApplication") != null &&
            //                r.getAttribute("Curadvrecper") != null) {
            //                sum =
            //(Double.parseDouble(r.getAttribute("CurApplication").toString()) *
            // Double.parseDouble(r.getAttribute("Curadvrecper").toString())) / 100;
            //            }

            RowSetIterator rs = applicationLineVO.createRowSetIterator(null);
            double sum = 0;
            while (rs.hasNext()) {
                Row r = rs.next();
                sum +=
Double.parseDouble(r.getAttribute("CurAdvRecAmount") != null ?
                   r.getAttribute("CurAdvRecAmount").toString() : "0.0");

            }
            applicationHrdVO.getCurrentRow().setAttribute("CurAdvRec",
                                                          new BigDecimal(df.format(sum)));
            double cur_app =
                CurApplication.getValue() == null ? 0 : Double.parseDouble(CurApplication.getValue().toString());
            double advPerc = (sum / cur_app) * 100;
            //            Number curAdvRecPercen=new Number(advPerc);
            double curAdvRecPercen = advPerc;
            applicationHrdVO.getCurrentRow().setAttribute("Curadvrecper",
                                                          curAdvRecPercen);
            //            applicationHrdVO.getCurrentRow().setAttribute("Curadvrecper", new BigDecimal(df.format(curAdvRecPercen)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(CurAdvRec);
            AdfFacesContext.getCurrentInstance().addPartialTarget(cur_Adv_Rec_Perc);
        }
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
            RowSetIterator rs = AdvancRecVO.createRowSet(null);
            double sum1 = 0;
            while (rs.hasNext()) {
                Row r = rs.next();
                sum1 +=
                        Double.parseDouble(r.getAttribute("CurRecAmt").toString());
            }
            applicationHrdVO.getCurrentRow().setAttribute("CurAdvRec",
                                                          new BigDecimal(df.format(sum1)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(CurAdvRec);
        }
        //        //System.err.println("======CurrentAdvanceRecovery======" + sum);

        /*
        double TotalAdvAmt=applicationHrdVO.getCurrentRow().getAttribute("Trans_Advan_Recovery")==null?0:Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Trans_Advan_Recovery").toString());
        double preAppAmt=applicationHrdVO.getCurrentRow().getAttribute("PrevAdvRec")==null?0:Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("PrevAdvRec").toString());
        double Amt=TotalAdvAmt-preAppAmt;
                if(Amt!=0){
                    double checkAdvRecPer=(100*Amt/TotalAdvAmt);
                    double AdvRecPer=applicationHrdVO.getCurrentRow().getAttribute("Curadvrecper")==null?0:Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Curadvrecper").toString());
                    //System.out.println("--%Expected--"+checkAdvRecPer+"--% Got---"+AdvRecPer);
                    if(checkAdvRecPer>=AdvRecPer){
                         applicationHrdVO.getCurrentRow().setAttribute("CurAdvRec",new BigDecimal(df.format(sum)));
                         AdfFacesContext.getCurrentInstance().addPartialTarget(CurAdvRec);
                     }else{
                        applicationHrdVO.getCurrentRow().setAttribute("Curadvrecper",null);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(curAdvRecPer);
                        applicationHrdVO.getCurrentRow().setAttribute("CurAdvRec",null);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(CurAdvRec);
                        applicationHrdVO.getCurrentRow().setAttribute("BalanceAdvRec",null);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(BalanceAdvRec);
                        JSFUtils.addFacesErrorMessage("Advance Recovery Amount Should not Exit the Limit.");
                        }
                }else{
                    JSFUtils.addFacesErrorMessage("Please check Current Bill Amount");
                }
     */

    }


    /***********Interim==Current Material Advance Recovery*********************/

    public void CurrentMaterialAdvanceRecovery() {
        Row r = applicationHrdVO.getCurrentRow();
        double sum = 0;
        if (r.getAttribute("CurApplication") != null &&
            r.getAttribute("Curmatadvrecper") != null) {
            sum =
(Double.parseDouble(r.getAttribute("CurApplication").toString()) *
 Double.parseDouble(r.getAttribute("Curmatadvrecper").toString())) / 100;
        }
        //        //System.err.println("======CurrentAdvanceRecovery======" + sum);
        applicationHrdVO.getCurrentRow().setAttribute("CurMatAdvRec",
                                                      new BigDecimal(df.format(sum)));
        AdfFacesContext.getCurrentInstance().addPartialTarget(cur_mat_adv_rec);
    }

    // ????

    /**
     * Current Retention calculation
     */
    public void CurrentRetention() {
        Row r = applicationHrdVO.getCurrentRow();
        double sum = 0;
        if (r.getAttribute("CurApplication") != null &&
            r.getAttribute("Trans_Retension") != null) {
            sum =
(Double.parseDouble(r.getAttribute("CurApplication").toString()) *
 Double.parseDouble(r.getAttribute("Trans_Retension").toString())) / 100;
        }

        //System.err.println("======Current Retention======" + sum);
        applicationHrdVO.getCurrentRow().setAttribute("CurRet",
                                                      new BigDecimal(sum));
        AdfFacesContext.getCurrentInstance().addPartialTarget(CurRet);
    }
    // Interim Balance Advance Recovery

    public void BalanceAdvanceRecovery() {
        try {
            double sum = 0;
            double TotalAdvAmt =
                TotalAdvAmount.getValue() == null ? 0 : Double.parseDouble(TotalAdvAmount.getValue().toString());
            double PrevAdvAmt =
                PrevAdvRec.getValue() == null ? 0 : Double.parseDouble(PrevAdvRec.getValue().toString());
            double curAdvRev =
                CurAdvRec.getValue() == null ? 0 : Double.parseDouble(CurAdvRec.getValue().toString());
            sum = TotalAdvAmt - PrevAdvAmt - curAdvRev;
            //            //System.out.println("TotalAdvAmt--" + TotalAdvAmt);
            //            //System.err.println("======BalanceAdvanceRecovery======" + sum);

            // Check Recovery Percentage Validation
            double TotalAmt =
                applicationHrdVO.getCurrentRow().getAttribute("TotalAdvAmount") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("TotalAdvAmount").toString());
            double preAmt =
                applicationHrdVO.getCurrentRow().getAttribute("PrevAdvRec") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("PrevAdvRec").toString());
            double Amt = TotalAmt - preAmt;
            double curAmt =
                applicationHrdVO.getCurrentRow().getAttribute("CurApplication") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurApplication").toString());

            if (Amt != 0) {
                if ("Final".equalsIgnoreCase(paymentType.getValue().toString())) {
                    double checkAdvRecPer = (Amt * 100 / curAmt);
                    double AdvRecPer = checkAdvRecPer;
                    //                        applicationHrdVO.getCurrentRow().getAttribute("Curadvrecper") ==
                    //                        null ? 0 :
                    //                        Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Curadvrecper").toString());
                    //System.out.println("--%Expected--" + checkAdvRecPer +
                    //                                       "--% Got---" + AdvRecPer);
                    if (checkAdvRecPer >= AdvRecPer) {
                        //                    ---------------------------
                        //advance
                        double balancetotal = 0;
                        double TotalAdvAmt11 =
                            TotalAdvAmount.getValue() == null ? 0 :
                            Double.parseDouble(TotalAdvAmount.getValue().toString());
                        double PrevAdvAmt11 =
                            PrevAdvRec.getValue() == null ? 0 :
                            Double.parseDouble(PrevAdvRec.getValue().toString());
                        double curAdvRev11 =
                            CurAdvRec.getValue() == null ? 0 : Double.parseDouble(CurAdvRec.getValue().toString());
                        balancetotal =
                                TotalAdvAmt11 - PrevAdvAmt11 - curAdvRev11;
                        applicationHrdVO.getCurrentRow().setAttribute("CurAdvRec",
                                                                      balancetotal);
                        //                        applicationHrdVO.getCurrentRow().setAttribute("Curadvrecper",100);

                        //retension

                        double sum1 = 0;
                        double TotalReten =
                            TotalRet.getValue() == null ? 0 : Double.parseDouble(TotalRet.getValue().toString());
                        double PrevRe =
                            PrevRet.getValue() == null ? 0 : Double.parseDouble(PrevRet.getValue().toString());
                        double curRet =
                            CurRet.getValue() == null ? 0 : Double.parseDouble(CurRet.getValue().toString());
                      //commented due to arun changes 20-02-24  sum1 = TotalReten - PrevRe - curRet;
                      sum1 = TotalReten - PrevRe;
//                        System.err.println("--%Balance Advance Recovery TotalReten%" + TotalReten );
//                        System.err.println("--%Balance Advance Recovery PrevRe%" + PrevRe );
//                        System.err.println("--%Balance Advance Recovery curRet%" + curRet );

//                        System.err.println("--%Balance Advance Recovery cur_ret%" + sum1 );

                        applicationHrdVO.getCurrentRow().setAttribute("CurRet",
                                                                      sum1);
                        //                        applicationHrdVO.getCurrentRow().setAttribute("Curretper",100);
                        //                        applicationHrdVO.getCurrentRow().setAttribute("BalanceAdvRec",100);
                        //                    -----------------------

                        applicationHrdVO.getCurrentRow().setAttribute("Curadvrecper",
                                                                      checkAdvRecPer);
                        applicationHrdVO.getCurrentRow().setAttribute("BalanceAdvRec",
                                                                      new BigDecimal(0));
                        RowSetIterator rs =
                            applicationLineVO.createRowSetIterator(null);
                        while (rs.hasNext()) {
                            Row appLineRow = rs.next();
                            appLineRow.setAttribute("AdvRecPer",
                                                    checkAdvRecPer);
                            //                            appLineRow.setAttribute("RetRecPer",checkAdvRecPer);
                        }
                        AdfFacesContext.getCurrentInstance().addPartialTarget(BalanceAdvRec);
                    } else {
                        applicationHrdVO.getCurrentRow().setAttribute("Curadvrecper",
                                                                      null);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(curAdvRecPer);
                        applicationHrdVO.getCurrentRow().setAttribute("CurAdvRec",
                                                                      null);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(CurAdvRec);
                        applicationHrdVO.getCurrentRow().setAttribute("BalanceAdvRec",
                                                                      null);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(BalanceAdvRec);
                        JSFUtils.addFacesErrorMessage("Advance Recovery Amount Should not Exit the Limit. Maximum Limited Percentage: " +
                                                      checkAdvRecPer);
                    }
                } else {
                    double checkAdvRecPer = (Amt * 100 / curAmt);
                    double AdvRecPer =
                        applicationHrdVO.getCurrentRow().getAttribute("Curadvrecper") ==
                        null ? 0 :
                        Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Curadvrecper").toString());
                    //System.out.println("--%Expected--" + checkAdvRecPer +
                    //                                       "--% Got---" + AdvRecPer);
                    //                    ------------advance validation------------
                    //                      float cuurentadvanceamount =
                    //                        applicationHrdVO.getCurrentRow().getAttribute("CurAdvRec") ==
                    //                        null ? 0 :
                    //                       Float.parseFloat(applicationHrdVO.getCurrentRow().getAttribute("CurAdvRec").toString());
                    //
                    //                    String contract=applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId")==null?"0":
                    //                        applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
                    //
                    //                    ViewObject advancebalance=ADFUtils.findIterator("AdvanceValidations_ROVO1Iterator").getViewObject();
                    //                    advancebalance.setNamedWhereClauseParam("p_apphdr",contract);
                    //                    advancebalance.executeQuery();
                    //                    Row r=advancebalance.first();
                    //                    BigDecimal newrow = (BigDecimal)r.getAttribute("Advancerectotal");
                    //
                    //
                    //                   float sumofadvance= newrow.floatValue();
                    //                   float currentadvanceamt= cuurentadvanceamount;
                    //		    if(sumofadvance>=currentadvanceamt || currentadvanceamt==0){
                    //                    -----------------------
                    if (checkAdvRecPer >= AdvRecPer) {
                        applicationHrdVO.getCurrentRow().setAttribute("BalanceAdvRec",
                                                                      new BigDecimal(df.format(sum)));
                        AdfFacesContext.getCurrentInstance().addPartialTarget(BalanceAdvRec);
                    } else {
                        applicationHrdVO.getCurrentRow().setAttribute("Curadvrecper",
                                                                      null);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(curAdvRecPer);
                        applicationHrdVO.getCurrentRow().setAttribute("CurAdvRec",
                                                                      null);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(CurAdvRec);
                        applicationHrdVO.getCurrentRow().setAttribute("BalanceAdvRec",
                                                                      null);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(BalanceAdvRec);
                        JSFUtils.addFacesErrorMessage("Advance Recovery Amount Should not Exit the Limit. Maximum Limited Amount: " +
                                                      checkAdvRecPer);
                        //                        --------------
                        //                         if(sumofadvance<0){
                        //                            JSFUtils.addFacesErrorMessage("Advance Recovery Amount Should not Exit the Limit. Maximum Limited Amount: " +
                        //
                        //                                                            "0.0");
                        //                        }else{
                        //                        JSFUtils.addFacesErrorMessage("Advance Recovery Amount Should not Exit the Limit. Maximum Limited Amount: " +
                        ////                                                      checkAdvRecPer);
                        //                                                        sumofadvance);
                        //                        }
                        //                        ---------------
                    }
                }

            } else if (Amt == 0) {
                //                JSFUtils.addFacesErrorMessage("Please set Advance Recovery %:0");
                applicationHrdVO.getCurrentRow().setAttribute("Curadvrecper",
                                                              Amt);
                AdfFacesContext.getCurrentInstance().addPartialTarget(curAdvRecPer);
                applicationHrdVO.getCurrentRow().setAttribute("CurAdvRec",
                                                              Amt);
                AdfFacesContext.getCurrentInstance().addPartialTarget(CurAdvRec);
                applicationHrdVO.getCurrentRow().setAttribute("BalanceAdvRec",
                                                              Amt);
                AdfFacesContext.getCurrentInstance().addPartialTarget(BalanceAdvRec);
            } else {
                JSFUtils.addFacesErrorMessage("Please check Current Bill Amount");
            }

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }
    // Interim BalanceMaterialAdvanceRecovery

    public void BalanceMaterialAdvanceRecovery() {
        try {
            double sum = 0;
            double TotalMatAdvAmt =
                tot_mat_adv_amt.getValue() == null ? 0 : Double.parseDouble(tot_mat_adv_amt.getValue().toString());
            double curmatadv =
                applicationHrdVO.getCurrentRow().getAttribute("CurMatAdvRec") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurMatAdvRec").toString());
            //                cur_mat_adv_rec.getValue() == null ? 0 : Double.parseDouble(cur_mat_adv_rec.getValue().toString());
            double prevmatadv =
                prev_mat_adv_rec.getValue() == null ? 0 : Double.parseDouble(prev_mat_adv_rec.getValue().toString());
            sum = TotalMatAdvAmt - prevmatadv - curmatadv;
            //            //System.err.println("======BalanceMaterialAdvanceRecovery======" +sum);


            double TotalAmt =
                applicationHrdVO.getCurrentRow().getAttribute("TotalMatAdvAmount") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("TotalMatAdvAmount").toString());
            double preAmt =
                applicationHrdVO.getCurrentRow().getAttribute("PrevMatAdvAmt") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("PrevMatAdvAmt").toString());
            double Amt = TotalAmt - preAmt;
            double curAmt =
                applicationHrdVO.getCurrentRow().getAttribute("CurApplication") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurApplication").toString());

            if (Amt != 0) {
                double checkMatAdvRecPer = (Amt * 100 / curAmt);
                double MatAdvRecPer =
                    applicationHrdVO.getCurrentRow().getAttribute("Curmatadvrecper") ==
                    null ? 0 :
                    Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Curmatadvrecper").toString());
                //System.out.println("--%Expected--" + checkMatAdvRecPer +
                //                                   "--% Got---" + MatAdvRecPer);
                if (checkMatAdvRecPer >= MatAdvRecPer) {
                    applicationHrdVO.getCurrentRow().setAttribute("BalMatAdvRec",
                                                                  new BigDecimal(df.format(sum)));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(bal_mat_adv_rec);
                } else {
                    applicationHrdVO.getCurrentRow().setAttribute("CurMatAdvRec",
                                                                  null);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(cur_mat_adv_rec);
                    applicationHrdVO.getCurrentRow().setAttribute("BalMatAdvRec",
                                                                  null);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(bal_mat_adv_rec);
                    applicationHrdVO.getCurrentRow().setAttribute("Curmatadvrecper",
                                                                  null);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(curMatAdvRecPer);
                    JSFUtils.addFacesErrorMessage("Material Advance Recovery Amount Should not Exit the Limit. Maximum Limited Percentage: " +
                                                  checkMatAdvRecPer);
                }
            } else if (Amt == 0) {
                //                JSFUtils.addFacesErrorMessage("Please set Material Advance Recovery %:0");
                applicationHrdVO.getCurrentRow().setAttribute("Curmatadvrecper",
                                                              Amt);
                AdfFacesContext.getCurrentInstance().addPartialTarget(curMatAdvRecPer);
                applicationHrdVO.getCurrentRow().setAttribute("CurMatAdvRec",
                                                              Amt);
                AdfFacesContext.getCurrentInstance().addPartialTarget(cur_mat_adv_rec);
                applicationHrdVO.getCurrentRow().setAttribute("BalMatAdvRec",
                                                              Amt);
                AdfFacesContext.getCurrentInstance().addPartialTarget(bal_mat_adv_rec);
            } else {
                JSFUtils.addFacesErrorMessage("Please check Current Bill Amount");
            }

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }
    // Balance Retention

    public void BalanceRetention() {
        try {
            double sum = 0;
            double TotalReten =
                TotalRet.getValue() == null ? 0 : Double.parseDouble(TotalRet.getValue().toString());
            double PrevRe =
                PrevRet.getValue() == null ? 0 : Double.parseDouble(PrevRet.getValue().toString());
            double curRet =
                CurRet.getValue() == null ? 0 : Double.parseDouble(CurRet.getValue().toString());
            sum = TotalReten - PrevRe - curRet;
            //            //System.err.println("======Balance Retention======" + sum);


            double TotalAmt =
                applicationHrdVO.getCurrentRow().getAttribute("TotalRet") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("TotalRet").toString());
            double preAmt =
                applicationHrdVO.getCurrentRow().getAttribute("PrevRet") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("PrevRet").toString());
            double Amt = TotalAmt - preAmt;
            double curAmt =
                applicationHrdVO.getCurrentRow().getAttribute("CurApplication") ==
                null ? 0 :
                Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurApplication").toString());

            if (Amt != 0) {
                if ("Final".equalsIgnoreCase(paymentType.getValue().toString())) {
                    double checkRetRecPer = (Amt * 100 / curAmt);
                    double MatAdvRecPer = checkRetRecPer;
                    //                        applicationHrdVO.getCurrentRow().getAttribute("Curretper") ==
                    //                        null ? 0 :
                    //                        Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Curretper").toString());
                    //System.out.println("--%Expected--" + checkRetRecPer +
                    //                                       "--% Got---" + MatAdvRecPer);
                    if (checkRetRecPer >= MatAdvRecPer) {
                        applicationHrdVO.getCurrentRow().setAttribute("Curretper",
                                                                      checkRetRecPer);
                        applicationHrdVO.getCurrentRow().setAttribute("BalanceRet",
                                                                      new BigDecimal(0));
                        RowSetIterator rs =
                            applicationLineVO.createRowSetIterator(null);
                        while (rs.hasNext()) {
                            Row appLineRow = rs.next();
                            appLineRow.setAttribute("RetRecPer",
                                                    checkRetRecPer);

                        }
                        AdfFacesContext.getCurrentInstance().addPartialTarget(BalanceRet);
                    } else {
                        applicationHrdVO.getCurrentRow().setAttribute("CurRet",
                                                                      null);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(CurRet);
                        applicationHrdVO.getCurrentRow().setAttribute("BalanceRet",
                                                                      null);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(BalanceRet);
                        applicationHrdVO.getCurrentRow().setAttribute("Curretper",
                                                                      null);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(ret_per);
                        JSFUtils.addFacesErrorMessage("Retention Recovery Amount Should not Exit the Limit. Maximum Limited Percentage:" +
                                                      checkRetRecPer);
                    }
                } else {
                    double checkRetRecPer = (Amt * 100 / curAmt);
                    double MatAdvRecPer =
                        applicationHrdVO.getCurrentRow().getAttribute("Curretper") ==
                        null ? 0 :
                        Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Curretper").toString());
                    //System.out.println("--%Expected--" + checkRetRecPer +
                    //                                       "--% Got---" + MatAdvRecPer);
                    if (checkRetRecPer >= MatAdvRecPer) {
                        applicationHrdVO.getCurrentRow().setAttribute("BalanceRet",
                                                                      new BigDecimal(df.format(sum)));
                        AdfFacesContext.getCurrentInstance().addPartialTarget(BalanceRet);
                    } else {
                        applicationHrdVO.getCurrentRow().setAttribute("CurRet",
                                                                      null);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(CurRet);
                        applicationHrdVO.getCurrentRow().setAttribute("BalanceRet",
                                                                      null);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(BalanceRet);
                        applicationHrdVO.getCurrentRow().setAttribute("Curretper",
                                                                      null);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(ret_per);
                        JSFUtils.addFacesErrorMessage("Retention Recovery Amount Should not Exit the Limit. Maximum Limited Percentage:" +
                                                      checkRetRecPer);
                    }
                }

            } else if (Amt == 0) {
                //                 JSFUtils.addFacesErrorMessage("Please set Retention Recovery %:0");
                applicationHrdVO.getCurrentRow().setAttribute("Curretper",
                                                              Amt);
                AdfFacesContext.getCurrentInstance().addPartialTarget(ret_per);
                applicationHrdVO.getCurrentRow().setAttribute("CurRet", Amt);
                AdfFacesContext.getCurrentInstance().addPartialTarget(CurRet);
                applicationHrdVO.getCurrentRow().setAttribute("BalanceRet",
                                                              Amt);
                AdfFacesContext.getCurrentInstance().addPartialTarget(BalanceRet);
            } else {
                JSFUtils.addFacesErrorMessage("Please check Current Bill Amount");
            }

        } catch (Exception e) {
            //System.err.println("====Error====" + e);
        }
    }
    // ????

    public void PrevAdvRecoveryRetention() {
        try {
            String AppHdrId =
                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();
            String ContHdrId =
                applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
            String Version =
                applicationHrdVO.getCurrentRow().getAttribute("Version") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("Version").toString();
            //System.err.println("Headerid===" + AppHdrId + "contid====" +
            //                               ContHdrId + "Version====" + Version);
            PrevAdvAndRetCal.setNamedWhereClauseParam("BV_HDR_ID", ContHdrId);
            PrevAdvAndRetCal.setNamedWhereClauseParam("BV_VER", Version);
            PrevAdvAndRetCal.setNamedWhereClauseParam("BV_APP_HDR_ID",
                                                      AppHdrId);
            PrevAdvAndRetCal.executeQuery();
            if (PrevAdvAndRetCal.first() != null) {
                //System.err.println("===============Previous advance recovery===============" +
                //                                   PrevAdvAndRetCal.first().getAttribute("PrevAdvRec"));
                applicationHrdVO.getCurrentRow().setAttribute("PrevAdvRec",
                                                              PrevAdvAndRetCal.first().getAttribute("PrevAdvRec"));
                AdfFacesContext.getCurrentInstance().addPartialTarget(PrevAdvRec);
                //System.err.println("===============Previous Retention===============" +
                //                                   PrevAdvAndRetCal.first().getAttribute("PrevRet"));
                applicationHrdVO.getCurrentRow().setAttribute("PrevRet",
                                                              PrevAdvAndRetCal.first().getAttribute("PrevRet"));
                AdfFacesContext.getCurrentInstance().addPartialTarget(PrevRet);
            } else {
                applicationHrdVO.getCurrentRow().setAttribute("PrevAdvRec",
                                                              "0");
                AdfFacesContext.getCurrentInstance().addPartialTarget(PrevAdvRec);
                applicationHrdVO.getCurrentRow().setAttribute("PrevRet", "0");
                AdfFacesContext.getCurrentInstance().addPartialTarget(PrevRet);
            }
        } catch (Exception e) {
            //System.err.println("====Error====" + e);
        }
    }

    public void setTotalAdvAmount(RichInputText TotalAdvAmount) {
        this.TotalAdvAmount = TotalAdvAmount;
    }

    public RichInputText getTotalAdvAmount() {
        return TotalAdvAmount;
    }

    public void setPrevAppl(RichInputText prevAppl) {
        this.prevAppl = prevAppl;
    }

    public RichInputText getPrevAppl() {
        return prevAppl;
    }

    public void setCurApplication(RichInputText CurApplication) {
        this.CurApplication = CurApplication;
    }

    public RichInputText getCurApplication() {
        return CurApplication;
    }

    public void setBalanceAdvRec(RichInputText BalanceAdvRec) {
        this.BalanceAdvRec = BalanceAdvRec;
    }

    public RichInputText getBalanceAdvRec() {
        return BalanceAdvRec;
    }

    public void setBalanceRet(RichInputText BalanceRet) {
        this.BalanceRet = BalanceRet;
    }

    public RichInputText getBalanceRet() {
        return BalanceRet;
    }

    public void setPrevAdvRec(RichInputText PrevAdvRec) {
        this.PrevAdvRec = PrevAdvRec;
    }

    public RichInputText getPrevAdvRec() {
        return PrevAdvRec;
    }

    public void setPrevRet(RichInputText PrevRet) {
        this.PrevRet = PrevRet;
    }

    public RichInputText getPrevRet() {
        return PrevRet;
    }

    public void setCurRet(RichInputText CurRet) {
        this.CurRet = CurRet;
    }

    public RichInputText getCurRet() {
        return CurRet;
    }

    public void setCurAdvRec(RichInputText CurAdvRec) {
        this.CurAdvRec = CurAdvRec;
    }

    public RichInputText getCurAdvRec() {
        return CurAdvRec;
    }

    public void setTotalRet(RichInputText TotalRet) {
        this.TotalRet = TotalRet;
    }

    public RichInputText getTotalRet() {
        return TotalRet;
    }

    public void setPaymentType(RichSelectOneChoice paymentType) {
        this.paymentType = paymentType;
    }

    public RichSelectOneChoice getPaymentType() {
        return paymentType;
    }

    public void setCurPayAmount(RichInputText curPayAmount) {
        this.curPayAmount = curPayAmount;
    }

    public RichInputText getCurPayAmount() {
        return curPayAmount;
    }


    public void onChanegeApplicationType(ValueChangeEvent valueChangeEvent) {

        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        //System.err.println("OLD Value" + valueChangeEvent.getOldValue());
        //System.err.println("New Value" + valueChangeEvent.getNewValue());
        if (valueChangeEvent.getNewValue() != null) {
            if (valueChangeEvent.getNewValue().toString().equalsIgnoreCase("Advance")) {
                if (applicationHrdVO.getCurrentRow().getAttribute("Trans_Advan_Rec_Per") !=
                    null) {

                    // Line Remove
                    RowSetIterator rs =
                        applicationLineVO.createRowSetIterator(null);
                    while (rs.hasNext()) {
                        Row r = rs.next();
                        r.remove();
                    }
                    // certificationcurAmountROVO1Iterator
                    // Current Application Contract Header Id
                    String contractHeaderID =
                        applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
                        null ? "0" :
                        applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
                    //                String PaymentType =
                    //                    applicationHrdVO.getCurrentRow().getAttribute("PaymentType") ==
                    //                    null ? null :
                    //                    applicationHrdVO.getCurrentRow().getAttribute("PaymentType").toString();
                    String versionID =
                        applicationHrdVO.getCurrentRow().getAttribute("Version") ==
                        null ? "" :
                        applicationHrdVO.getCurrentRow().getAttribute("Version").toString();
                    // Commented due to Advance type 16-02-24

//                    double totalAdvanceAmount =
//                        applicationHrdVO.getCurrentRow().getAttribute("Trans_Advan_Recovery") ==
//                        null ? 0 :
//                        Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Trans_Advan_Recovery").toString());

  double totalAdvanceAmount =
                        applicationHrdVO.getCurrentRow().getAttribute("Trans_Advan_Recovery_Advance") ==
                        null ? 0 :
                        Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Trans_Advan_Recovery_Advance").toString());





                    System.err.println("===totalAdvanceAmount ====" + totalAdvanceAmount);

                    // filter Application Header
                    certificationamountVO.setNamedWhereClauseParam("BV_Header_id",
                                                                   contractHeaderID);
                    certificationamountVO.setNamedWhereClauseParam("BV_Payment_type",
                                                                   "Advance");
                    certificationamountVO.executeQuery();
                    //System.err.println("===row count===" +
                    //                                       certificationamountVO.getEstimatedRowCount());
                    double count =
                        certificationamountVO.first().getAttribute("Amount") ==
                        null ? 0 :
                        Double.parseDouble(certificationamountVO.first().getAttribute("Amount").toString());
                    //System.err.println("==Count==" + count);
                    if (count == 0) {
                        TotalAdvanceAmount1();
                        paymentType.setDisabled(Boolean.TRUE);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(paymentType);
                    } else {
                        double curr_amt = 0;
                        double balance = 0;
                        double amountTotal =
                            Double.parseDouble(certificationamountVO.getCurrentRow().getAttribute("Amount").toString());
                        curr_amt = totalAdvanceAmount - amountTotal;
                        if (curr_amt == 0) {
                            JSFUtils.addFacesErrorMessage("Advance Cannot be created for this contract");
                            paymentType.setDisabled(Boolean.FALSE);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(paymentType);
                        } else {
                            applicationHrdVO.getCurrentRow().setAttribute("PrevApplication",
                                                                          df.format(amountTotal));
                            AdfFacesContext.getCurrentInstance().addPartialTarget(prevAppl);
                            applicationHrdVO.getCurrentRow().setAttribute("CurApplication",
                                                                          df.format(curr_amt));
                            AdfFacesContext.getCurrentInstance().addPartialTarget(CurApplication);
                            balance =
                                    totalAdvanceAmount - (curr_amt + amountTotal);
                            applicationHrdVO.getCurrentRow().setAttribute("BalContAmt",
                                                                          df.format(balance));
                            AdfFacesContext.getCurrentInstance().addPartialTarget(bal_Cont_Amt);
                            paymentType.setDisabled(Boolean.TRUE);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(paymentType);

                        }
                    }
                } else {
                    JSFUtils.addFacesErrorMessage("Please check Advance Percentage value");
                    paymentType.setDisabled(Boolean.FALSE);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(paymentType);
                }

            } else if (valueChangeEvent.getNewValue().toString().equalsIgnoreCase("Interim")) {

                // Get contract id and version
                String appContID =
                    applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
                    null ? "0" :
                    applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
                String appVersion =
                    applicationHrdVO.getCurrentRow().getAttribute("Version") ==
                    null ? "0" :
                    applicationHrdVO.getCurrentRow().getAttribute("Version").toString();


                //System.err.println("--contID---" + appContID + "-Version--" +appVersion);

                // Checking Advance and Material Advance Recovery
                ViewObject checkPaymentTypeVO =
                    ADFUtils.findIterator("checkPaymentType_ROVO1Iterator").getViewObject();
                checkPaymentTypeVO.setNamedWhereClauseParam("BV_HID",
                                                            appContID);
                checkPaymentTypeVO.setNamedWhereClauseParam("BV_TYPE",
                                                            "Advance");
                checkPaymentTypeVO.executeQuery();
                String advanceFlag =
                    checkPaymentTypeVO.first().getAttribute("Status") == null ?
                    "N" :
                    checkPaymentTypeVO.first().getAttribute("Status").toString();
                if (advanceFlag.equalsIgnoreCase("N")) {
                    applicationHrdVO.getCurrentRow().setAttribute("Curadvrecper",
                                                                  0);
                    curAdvRecPer.setDisabled(Boolean.TRUE);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(curAdvRecPer);
                }
                // Materila Advance Recovery
                checkPaymentTypeVO.setNamedWhereClauseParam("BV_HID",
                                                            appContID);
                checkPaymentTypeVO.setNamedWhereClauseParam("BV_TYPE",
                                                            "Material Advance");
                checkPaymentTypeVO.executeQuery();
                String matSdvanceFlag =
                    checkPaymentTypeVO.first().getAttribute("Status") == null ?
                    "N" :
                    checkPaymentTypeVO.first().getAttribute("Status").toString();
                if (matSdvanceFlag.equalsIgnoreCase("N")) {
                    applicationHrdVO.getCurrentRow().setAttribute("Curmatadvrecper",
                                                                  0);
                    curMatAdvRecPer.setDisabled(Boolean.TRUE);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(curMatAdvRecPer);
                }

                // Filtering contract line VO
                ViewCriteria contractLineVC =
                    contractLineVO.createViewCriteria();
                ViewCriteriaRow contractLineVCRow =
                    contractLineVC.createViewCriteriaRow();
                contractLineVCRow.setAttribute("ContHeaderId", appContID);
                contractLineVCRow.setAttribute("Version", appVersion);
                contractLineVC.addRow(contractLineVCRow);
                contractLineVO.applyViewCriteria(contractLineVC);
                contractLineVO.executeQuery();
                //                System.err.println("==COUNT==" +
                //                                   contractLineVO.getEstimatedRowCount());

                // Iteration on contract line
                RowSetIterator contractRs =
                    contractLineVO.createRowSetIterator(null);
                while (contractRs.hasNext()) {
                    Row contracrLineRow = contractRs.next();
                    Object hid = contracrLineRow.getAttribute("ContHeaderId");
                    Object lid = contracrLineRow.getAttribute("ContLineId");
                    Object version = contracrLineRow.getAttribute("Version");
                    Object taxCode = contracrLineRow.getAttribute("TaxCode");
                    Object taxRate = contracrLineRow.getAttribute("TaxRate");
                    Object taxAmt = contracrLineRow.getAttribute("TaxAmount");
                    Object ecpPer =
                        contracrLineRow.getAttribute("EcpPercentage");
                    Object ecpAmt =
                        contracrLineRow.getAttribute("EcpTotalAmount");

                    // Advance and retention % column
                    Object advLinePer =
                        contracrLineRow.getAttribute("ContAdv");
                    Object retLinePer =
                        contracrLineRow.getAttribute("ContRet");
                    //                    Object advAmt          =contracrLineRow.getAttribute("ContAdvAmt");
                    //                    Object advRecPer       =contracrLineRow.getAttribute("ContAdvRec");
                    //                    Object advRecAmt       =contracrLineRow.getAttribute("ContAdvRecAmt");
                    //                    Object retAmt          =contracrLineRow.getAttribute("ContRetAmt");
                    //                    Object retRecPer       =contracrLineRow.getAttribute("ContRetRec");
                    //                    Object retRecAmt       =contracrLineRow.getAttribute("ContRetRecAmt");

                    //System.err.println("advLinePer-->"+advLinePer +"retLinePer-->"+retLinePer);
                    // Filtering Application Line---check contract line=0 or not
                    ViewCriteria appVO =
                        applicationLineVO2.createViewCriteria();
                    ViewCriteriaRow appVCR = appVO.createViewCriteriaRow();
                    appVCR.setAttribute("ContLineId", lid);
                    appVO.addRow(appVCR);
                    applicationLineVO2.applyViewCriteria(appVO);
                    applicationLineVO2.executeQuery();
                    System.err.println("Total applicationLine Count--" +
                                       applicationLineVO2.getEstimatedRowCount());
                    long TotalRowAppCount =
                        applicationLineVO2.getEstimatedRowCount();
                    //Equal to 0
                    if (applicationLineVO2.getEstimatedRowCount() == 0) {
                        //Application line Row adding
                        Row appLineRow = applicationLineVO.createRow();
                        appLineRow.setAttribute("ContHeaderId", hid);
                        appLineRow.setAttribute("ContLineId", lid);
                        appLineRow.setAttribute("Version", version);
                        appLineRow.setAttribute("ApplHeaderId",
                                                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId"));
                        appLineRow.setAttribute("OrgId",
                                                applicationHrdVO.getCurrentRow().getAttribute("OrgId"));
                        appLineRow.setAttribute("TaxCode", taxCode);
                        appLineRow.setAttribute("TaxRate", taxRate);
                        appLineRow.setAttribute("EcpPercentage", ecpPer);
                        appLineRow.setAttribute("EcpTotalAmount", ecpAmt);
                        appLineRow.setAttribute("AdvRecPer", advLinePer);
                        appLineRow.setAttribute("RetRecPer", retLinePer);
                        applicationLineVO.insertRow(appLineRow);

                    } else {
                        double totalPer = 0;
                        double totalQty = 0;
                        double totalAmt = 0;
                        previousCalculationVO.setNamedWhereClauseParam("BV_CONT_HRDID",
                                                                       hid);
                        previousCalculationVO.setNamedWhereClauseParam("BV_VER",
                                                                       version);
                        previousCalculationVO.setNamedWhereClauseParam("BV_CONT_LNEID",
                                                                       lid);
                        previousCalculationVO.setNamedWhereClauseParam("APP_HRDID",
                                                                       applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId"));
                        previousCalculationVO.executeQuery();
                        //                        previousCalculationVO.getEstimatedRowCount();
                        //                        System.err.println("Pre Qty, % Amt===COUNT==" +
                        //                                           previousCalculationVO.getEstimatedRowCount());
                        if (previousCalculationVO.getEstimatedRowCount() ==
                            0) {

                            totalPer = 0;
                            totalQty = 0;
                            totalAmt = 0;
                        } else {
                            totalQty =
                                    previousCalculationVO.first().getAttribute("ApplPrevQty") ==
                                    null ? 0 :
                                    Double.parseDouble(previousCalculationVO.first().getAttribute("ApplPrevQty").toString());
                            totalPer =
                                    previousCalculationVO.first().getAttribute("ApplPrevPerc") ==
                                    null ? 0 :
                                    Double.parseDouble(previousCalculationVO.first().getAttribute("ApplPrevPerc").toString());
                            totalAmt =
                                    previousCalculationVO.first().getAttribute("ApplPrevAmount") ==
                                    null ? 0 :
                                    Double.parseDouble(previousCalculationVO.first().getAttribute("ApplPrevAmount").toString());
                            //                            System.out.println("totalQty---" + totalQty +
                            //                                               "totalPer-----" + totalPer +
                            //                                               "totalAmt---" + totalAmt);
                        }
                        //Application line Row adding
                        Row appLineRow = applicationLineVO.createRow();
                        appLineRow.setAttribute("ContHeaderId", hid);
                        appLineRow.setAttribute("ContLineId", lid);
                        appLineRow.setAttribute("Version", version);
                        appLineRow.setAttribute("EcpPercentage", ecpPer);
                        appLineRow.setAttribute("EcpTotalAmount", ecpAmt);
                        appLineRow.setAttribute("ApplHeaderId",
                                                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId"));
                        appLineRow.setAttribute("TaxCode", taxCode);
                        appLineRow.setAttribute("TaxRate", taxRate);
                        //                        appLineRow.setAttribute("TaxAmount", taxAmt);
                        appLineRow.setAttribute("PrevPerc",
                                                new BigDecimal(df.format(totalPer)));
                        appLineRow.setAttribute("PrevTotQty",
                                                new BigDecimal(df.format(totalQty)));
                        appLineRow.setAttribute("PrevAmount",
                                                new BigDecimal(df.format(totalAmt)));
                        appLineRow.setAttribute("OrgId",
                                                applicationHrdVO.getCurrentRow().getAttribute("OrgId"));
                        //                        appLineRow.setAttribute("CumPerc",new BigDecimal(totalPer));
                        //                        appLineRow.setAttribute("CumTotQty",new BigDecimal(totalQty));
                        //                        appLineRow.setAttribute("CumAmount",new BigDecimal(totalAmt));

                        //
                        appLineRow.setAttribute("AdvRecPer", advLinePer);
                        appLineRow.setAttribute("RetRecPer", retLinePer);
                        applicationLineVO.insertRow(appLineRow);
                    }
                }
                applicationLineVO.executeQuery();
                // applicationHrdVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
                //System.err.println("Application Line inserted");
                paymentType.setDisabled(Boolean.TRUE);
                AdfFacesContext.getCurrentInstance().addPartialTarget(paymentType);

            } else if (valueChangeEvent.getNewValue().toString().equalsIgnoreCase("Material Advance")) {
                if (applicationHrdVO.getCurrentRow().getAttribute("MaterialAdvancePer") !=
                    null) {

                    // Line Remove
                    RowSetIterator rs =
                        applicationLineVO.createRowSetIterator(null);
                    while (rs.hasNext()) {
                        Row r = rs.next();
                        r.remove();
                    }
                    String contractHeaderID =
                        applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
                        null ? "0" :
                        applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
                    //                String PaymentType =
                    //                    applicationHrdVO.getCurrentRow().getAttribute("PaymentType") ==
                    //                    null ? null :
                    //                    applicationHrdVO.getCurrentRow().getAttribute("PaymentType").toString();
                    String versionID =
                        applicationHrdVO.getCurrentRow().getAttribute("Version") ==
                        null ? "" :
                        applicationHrdVO.getCurrentRow().getAttribute("Version").toString();
                    double totalAdvanceAmount =
                        applicationHrdVO.getCurrentRow().getAttribute("MaterialAdvanceAmt") ==
                        null ? 0 :
                        Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("MaterialAdvanceAmt").toString());

                    //System.err.println("===number====" + contractHeaderID);

                    // filter Application Header
                    certificationamountVO.setNamedWhereClauseParam("BV_Header_id",
                                                                   contractHeaderID);
                    certificationamountVO.setNamedWhereClauseParam("BV_Payment_type",
                                                                   "Material Advance");
                    certificationamountVO.executeQuery();
                    //System.err.println("===row count===" +
                    //                                       certificationamountVO.getEstimatedRowCount());
                    double count =
                        certificationamountVO.first().getAttribute("Amount") ==
                        null ? 0 :
                        Double.parseDouble(certificationamountVO.first().getAttribute("Amount").toString());
                    //System.err.println("==Count==" + count);
                    if (count == 0) {
                        TotalMaterialAdvAmount1();
                        paymentType.setDisabled(Boolean.TRUE);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(paymentType);
                    } else {
                        double curr_amt = 0;
                        double balance = 0;
                        double amountTotal =
                            Double.parseDouble(certificationamountVO.getCurrentRow().getAttribute("Amount").toString());
                        curr_amt = totalAdvanceAmount - amountTotal;
                        if (curr_amt == 0) {
                            JSFUtils.addFacesErrorMessage("Material Advance Cannot be created for this contract");
                            paymentType.setDisabled(Boolean.FALSE);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(paymentType);
                        } else {
                            applicationHrdVO.getCurrentRow().setAttribute("PrevApplication",
                                                                          new BigDecimal(df.format(amountTotal)));
                            AdfFacesContext.getCurrentInstance().addPartialTarget(prevAppl);
                            curr_amt = totalAdvanceAmount - amountTotal;
                            applicationHrdVO.getCurrentRow().setAttribute("CurApplication",
                                                                          new BigDecimal(df.format(curr_amt)));
                            AdfFacesContext.getCurrentInstance().addPartialTarget(CurApplication);
                            balance =
                                    totalAdvanceAmount - (curr_amt + amountTotal);
                            applicationHrdVO.getCurrentRow().setAttribute("BalContAmt",
                                                                          new BigDecimal(df.format(balance)));
                            AdfFacesContext.getCurrentInstance().addPartialTarget(bal_Cont_Amt);
                            paymentType.setDisabled(Boolean.TRUE);
                            AdfFacesContext.getCurrentInstance().addPartialTarget(paymentType);
                        }
                    }

                } else {
                    JSFUtils.addFacesErrorMessage("Please check Material Advance Percentage value");
                    paymentType.setDisabled(Boolean.FALSE);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(paymentType);
                }
            } else if (valueChangeEvent.getNewValue().toString().equalsIgnoreCase("Final")) {
                RichPopup.PopupHints hint = new RichPopup.PopupHints();
                this.getP2().show(hint);
            }
        }

    }


    // LOV : Advance Calculation

    public void TotalAdvanceAmount1() {
        //            //System.err.println("======Row count====" +applicationHrdVO.getEstimatedRowCount());
        double Adv_amt = 0;
        /**
         * Commented due to arun changes for advance alone we need to pick data from contract and  for interim we need to get it from Advance PC
         */
//        Adv_amt =
//                tans_Adv_rec.getValue() == null ? 0 : Double.parseDouble(tans_Adv_rec.getValue().toString());
//        
        
         Adv_amt =
                              applicationHrdVO.getCurrentRow().getAttribute("Trans_Advan_Recovery_Advance") ==
                              null ? 0 :
                              Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Trans_Advan_Recovery_Advance").toString());

        //System.err.println("===Advance Amount===" + Adv_amt);
        applicationHrdVO.getCurrentRow().setAttribute("TotalAdvAmount",
                                                      new BigDecimal(df.format(Adv_amt)));
        AdfFacesContext.getCurrentInstance().addPartialTarget(TotalAdvAmount);
        applicationHrdVO.getCurrentRow().setAttribute("CurApplication",
                                                      new BigDecimal(df.format(Adv_amt)));
        AdfFacesContext.getCurrentInstance().addPartialTarget(CurApplication);
        applicationHrdVO.getCurrentRow().setAttribute("CurPayAmount",
                                                      new BigDecimal(df.format(Adv_amt)));
        AdfFacesContext.getCurrentInstance().addPartialTarget(curPayAmount);
        applicationHrdVO.getCurrentRow().setAttribute("PrevApplication", 0);
        AdfFacesContext.getCurrentInstance().addPartialTarget(prevAppl);
    }


    // LOV: Material Advnce Calculation

    public void TotalMaterialAdvAmount1() {
        //System.err.println("======Row count====" +
        //                           applicationHrdVO.getEstimatedRowCount());
        double mat_Adv_amt = 0;
        mat_Adv_amt =
                material_Adv_amt.getValue() == null ? 0 : Double.parseDouble(material_Adv_amt.getValue().toString());
        //System.err.println("===Advance Amount===" + mat_Adv_amt);
        applicationHrdVO.getCurrentRow().setAttribute("TotalMaterialAdvAmount",
                                                      new BigDecimal(df.format(mat_Adv_amt)));
        applicationHrdVO.getCurrentRow().setAttribute("CurApplication",
                                                      new BigDecimal(df.format(mat_Adv_amt)));
        applicationHrdVO.getCurrentRow().setAttribute("CurPayAmount",
                                                      new BigDecimal(df.format(mat_Adv_amt)));
        applicationHrdVO.getCurrentRow().setAttribute("PrevApplication", 0);
        AdfFacesContext.getCurrentInstance().addPartialTarget(prevAppl);
        AdfFacesContext.getCurrentInstance().addPartialTarget(curPayAmount);
        AdfFacesContext.getCurrentInstance().addPartialTarget(CurApplication);
        AdfFacesContext.getCurrentInstance().addPartialTarget(curPayAmount);

    }

    // ???

    public void onChangeAdvanAmount(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        //System.err.println("--old--" + valueChangeEvent.getOldValue());
        //System.err.println("--New--" + valueChangeEvent.getNewValue());
        String contractHeaderID =
            applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
        double totalAdvanceAmount =
            applicationHrdVO.getCurrentRow().getAttribute("Trans_Advan_Recovery") ==
            null ? 0 :
            Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Trans_Advan_Recovery").toString());
        // Filter previous count
        ViewCriteria AppVC = applicationHrdVO2.createViewCriteria();
        ViewCriteriaRow AppVCR = AppVC.createViewCriteriaRow();
        AppVCR.setAttribute("ContHeaderId", contractHeaderID);
        AppVCR.setAttribute("PaymentType", "Advance");
        AppVC.addRow(AppVCR);
        applicationHrdVO2.applyViewCriteria(AppVC);
        applicationHrdVO2.executeQuery();
        // check previous count
        if (applicationHrdVO2.getEstimatedRowCount() == 0) {
            if (Double.parseDouble(valueChangeEvent.getNewValue().toString()) <=
                totalAdvanceAmount) {
                double BalanceAmt =
                    totalAdvanceAmount - Double.parseDouble(valueChangeEvent.getNewValue().toString());
                applicationHrdVO.getCurrentRow().setAttribute("BalanceAdvRec",
                                                              BalanceAmt);
                AdfFacesContext.getCurrentInstance().addPartialTarget(BalanceAdvRec);
                //                CalculateAmount();
            } else {
                JSFUtils.addFacesErrorMessage("Please check enter Amount is greater than " +
                                              totalAdvanceAmount);
                TotalAdvAmount.setValue("");
                AdfFacesContext.getCurrentInstance().addPartialTarget(TotalAdvAmount);
            }

        } else {
            double previousAmtTotal = 0;
            RowSetIterator appHrdRS =
                applicationHrdVO2.createRowSetIterator(null);
            while (appHrdRS.hasNext()) {
                Row appOldRow = appHrdRS.next();
                double preAmt =
                    appOldRow.getAttribute("TotalAdvAmount") == null ? 0 :
                    Double.parseDouble(appOldRow.getAttribute("TotalAdvAmount").toString());
                previousAmtTotal += preAmt;
            }
            //System.err.println("previous Advance Total Amount==" +previousAmtTotal);
            double previousBalanceAmt =
                totalAdvanceAmount - previousAmtTotal - Double.parseDouble(valueChangeEvent.getNewValue().toString());
            if (Double.parseDouble(valueChangeEvent.getNewValue().toString()) <=
                previousBalanceAmt) {
                if (previousAmtTotal < totalAdvanceAmount) {
                    applicationHrdVO.getCurrentRow().setAttribute("BalanceAdvRec",
                                                                  previousBalanceAmt);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(BalanceAdvRec);
                    //                    CalculateAmount();

                } else {
                    JSFUtils.addFacesErrorMessage("Advance Cannot be created for this contract");
                    paymentType.setValue(null);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(paymentType);
                    TotalAdvAmount.setDisabled(true);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(TotalAdvAmount);
                }
            } else {
                JSFUtils.addFacesErrorMessage("Please check enter Amount is greater than " +
                                              valueChangeEvent.getOldValue());
                TotalAdvAmount.setValue("");
                AdfFacesContext.getCurrentInstance().addPartialTarget(TotalAdvAmount);
            }

        }


    }

    public void onClickSubmit(ActionEvent actionEvent) {
        if (ADFContext.getCurrent().getSessionScope().get("addEditApp") !=
            null &&
            ADFContext.getCurrent().getSessionScope().get("addEditApp").toString().equals("edit")) {
            applicationHrdVO.getCurrentRow().setAttribute("ApprovalStatus",
                                                          "APR");
            applicationHrdVO.getCurrentRow().setAttribute("ApplicationStatus",
                                                          "ACTIVE");
            ADFUtils.findOperation("Commit").execute();
            ADFUtils.refreshTable("ApplicationNumber", searchApplicationVO);
            JSFUtils.addFacesInformationMessage("Application Information Saved Successfully");

        } else {

        }
    }

    public void onClickSubmitForApproval(ActionEvent actionEvent) {
        try {
            if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
                String url =
                    ADFUtils.getFunctionDetails("BUY_PAY_APP", "WfProcessUrl");
                // "http://141.144.50.225/soa-infra/services/default/CertSellApproval/certsellapprovalprocess_client_ep?WSDL";
                SubmitForApproval app = new SubmitForApproval("", "", "");
                String payload = prepareApprovalPayload();
                String type =
                    "Application"; // Certification // Application //Contract
                app.getAndPushOrder(payload, url, type);
            } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
                String url =
                    ADFUtils.getFunctionDetails("SELL_PAY_APP", "WfProcessUrl");
                // "http://141.144.50.225/soa-infra/services/default/CertSellApproval/certsellapprovalprocess_client_ep?WSDL";
                SubmitForApproval app = new SubmitForApproval("", "", "");
                String payload = prepareApprovalPayload();
                String type =
                    "Certification"; // Certification // Application //Contract
                app.getAndPushOrder(payload, url, type);
            }
        } catch (Exception e) {
            //System.err.println("====EXE===APP====" + e.toString());
        }
    }

    public String prepareApprovalPayload() {
        String xml = "";
        ViewObject headerVO =
            ADFUtils.findIterator("XxscPayApplHeadersVO1Iterator").getViewObject();
        xml += "   <soapenv:Body>\n" +
                "      <app:application>\n" +
                "         <app:appHeader>\n" +
                "            <app:functionid>";
        xml += headerVO.getCurrentRow().getAttribute("FuncId");
        xml += "</app:functionid>\n" +
                "            <app:app_header_id>";
        xml += headerVO.getCurrentRow().getAttribute("ApplHeaderId");
        xml += "</app:app_header_id>\n" +
                "           </app:appHeader>\n" +
                "         </app:application>\n" +
                "   </soapenv:Body>\n";
        return xml;
    }

    public void setTans_Adv_rec(RichInputText tans_Adv_rec) {
        this.tans_Adv_rec = tans_Adv_rec;
    }

    public RichInputText getTans_Adv_rec() {
        return tans_Adv_rec;
    }

    public void setMaterial_Adv_amt(RichInputText material_Adv_amt) {
        this.material_Adv_amt = material_Adv_amt;
    }

    public RichInputText getMaterial_Adv_amt() {
        return material_Adv_amt;
    }

    public void setTotal_mat_adv_amt(RichInputText total_mat_adv_amt) {
        this.total_mat_adv_amt = total_mat_adv_amt;
    }

    public RichInputText getTotal_mat_adv_amt() {
        return total_mat_adv_amt;
    }

    public void setTrans_ret_amt(RichInputText trans_ret_amt) {
        this.trans_ret_amt = trans_ret_amt;
    }

    public RichInputText getTrans_ret_amt() {
        return trans_ret_amt;
    }

    public void setRet_per(RichInputText ret_per) {
        this.ret_per = ret_per;
    }

    public RichInputText getRet_per() {
        return ret_per;
    }


    public void onChangeCummQty(ValueChangeEvent valueChangeEvent) {
        double old_value =
            valueChangeEvent.getOldValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getOldValue().toString());
        double new_value =
            valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
        if (old_value != new_value) {
            if (valueChangeEvent.getNewValue() != null) {
                valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
                double contractLneRate =
                    applicationLineVO.getCurrentRow().getAttribute("Trans_Rate") ==
                    null ? 0 :
                    Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("Trans_Rate").toString());
                double contractLneAmt =
                    applicationLineVO.getCurrentRow().getAttribute("Trans_Amount") ==
                    null ? 0 :
                    Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("Trans_Amount").toString());
                double cummulativeQty =
                    valueChangeEvent.getNewValue() == null ? 0 :
                    Double.parseDouble(valueChangeEvent.getNewValue().toString());

                double taxRate =
                    applicationLineVO.getCurrentRow().getAttribute("TaxRate") ==
                    null ? 0 :
                    Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("TaxRate").toString());
                // set Amount
                double cummulativeAmt = cummulativeQty * contractLneRate;
                applicationLineVO.getCurrentRow().setAttribute("CumAmount",
                                                               new BigDecimal(df.format(cummulativeAmt)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(cumuAmt);

                // set Percentage
                double cummulativePer =
                    (100 * cummulativeAmt / contractLneAmt);
                applicationLineVO.getCurrentRow().setAttribute("CumPerc",
                                                               new BigDecimal(df.format(cummulativePer)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(cumuPer);

                // setting Current
                double previousQty =
                    applicationLineVO.getCurrentRow().getAttribute("PrevTotQty") ==
                    null ? 0 :
                    Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevTotQty").toString());
                double previousPer =
                    applicationLineVO.getCurrentRow().getAttribute("PrevPerc") ==
                    null ? 0 :
                    Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevPerc").toString());
                double previousAmt =
                    applicationLineVO.getCurrentRow().getAttribute("PrevAmount") ==
                    null ? 0 :
                    Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevAmount").toString());

                double currentQty = cummulativeQty - previousQty;
                double currentPre = cummulativePer - previousPer;
                double currentAmt = cummulativeAmt - previousAmt;
                applicationLineVO.getCurrentRow().setAttribute("CurrTotQty",
                                                               new BigDecimal(df.format(currentQty)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(currQty);
                applicationLineVO.getCurrentRow().setAttribute("CurrPerc",
                                                               new BigDecimal(df.format(currentPre)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(currPer);
                applicationLineVO.getCurrentRow().setAttribute("CurrAmount",
                                                               new BigDecimal(df.format(currentAmt)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(currAmt);
                // Set Tax Amount
                if (taxRate == 0) {
                    applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                   new BigDecimal(df.format(0)));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                } else {
                    double taxAmt = (currentAmt * taxRate) / 100;
                    applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                   new BigDecimal(df.format(taxAmt)));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                }
            }
        }
    }

    public void onChangeCummPer(ValueChangeEvent valueChangeEvent) {
        double old_value =
            valueChangeEvent.getOldValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getOldValue().toString());
        double new_value =
            valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
        if (old_value != new_value) {
            if (valueChangeEvent.getNewValue() != null) {
                valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
                double contractLneRate =
                    applicationLineVO.getCurrentRow().getAttribute("Trans_Rate") ==
                    null ? 0 :
                    Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("Trans_Rate").toString());
                double contractLneAmt =
                    applicationLineVO.getCurrentRow().getAttribute("Trans_Amount") ==
                    null ? 0 :
                    Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("Trans_Amount").toString());
                double cummulativePer =
                    valueChangeEvent.getNewValue() == null ? 0 :
                    Double.parseDouble(valueChangeEvent.getNewValue().toString());
                double taxRate =
                    applicationLineVO.getCurrentRow().getAttribute("TaxRate") ==
                    null ? 0 :
                    Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("TaxRate").toString());
                // set Amount
                double cummulativeAmt =
                    (cummulativePer * contractLneAmt) / 100;
                applicationLineVO.getCurrentRow().setAttribute("CumAmount",
                                                               new BigDecimal(df.format(cummulativeAmt)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(cumuAmt);

                // set Qty
                double cummulativeQty = cummulativeAmt / contractLneRate;
                applicationLineVO.getCurrentRow().setAttribute("CumTotQty",
                                                               new BigDecimal(df.format(cummulativeQty)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(cumuQty);

                // setting Current
                double previousQty =
                    applicationLineVO.getCurrentRow().getAttribute("PrevTotQty") ==
                    null ? 0 :
                    Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevTotQty").toString());
                double previousPer =
                    applicationLineVO.getCurrentRow().getAttribute("PrevPerc") ==
                    null ? 0 :
                    Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevPerc").toString());
                double previousAmt =
                    applicationLineVO.getCurrentRow().getAttribute("PrevAmount") ==
                    null ? 0 :
                    Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevAmount").toString());

                double currentQty = cummulativeQty - previousQty;
                double currentPre = cummulativePer - previousPer;
                double currentAmt = cummulativeAmt - previousAmt;
                applicationLineVO.getCurrentRow().setAttribute("CurrTotQty",
                                                               new BigDecimal(df.format(currentQty)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(currQty);
                applicationLineVO.getCurrentRow().setAttribute("CurrPerc",
                                                               new BigDecimal(df.format(currentPre)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(currPer);
                applicationLineVO.getCurrentRow().setAttribute("CurrAmount",
                                                               new BigDecimal(df.format(currentAmt)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(currAmt);

                // Set Tax Amount
                if (taxRate == 0) {
                    applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                   new BigDecimal(df.format(0)));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                } else {

                    //                    double taxAmt = (currentAmt * taxRate) / 100;
                    double cur_adv_rec_amount =
                        applicationLineVO.getCurrentRow().getAttribute("CurAdvRecAmount") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("CurAdvRecAmount").toString());
                    double cur_ret_rec_amount =
                        applicationLineVO.getCurrentRow().getAttribute("CurRetRecAmount") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("CurRetRecAmount").toString());
                    /**
           * tax_amount 01-09-2023 added as requested by arun
           */
                    double final_tax_amount =
                        currentAmt - cur_adv_rec_amount - cur_ret_rec_amount;
                    System.out.println("currentAmt--"+currentAmt);
                    System.out.println("cur_adv_rec_amount--"+cur_adv_rec_amount);
                    System.out.println("cur_ret_rec_amount--"+cur_ret_rec_amount);
                    System.out.println("final_tax_amount--"+final_tax_amount);        
                    double taxAmt = (final_tax_amount * taxRate) / 100;
                    applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                   new BigDecimal(df.format(taxAmt)));


                    AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                }
            }
        }
    }

    public void onChangeCummAmt(ValueChangeEvent valueChangeEvent) {
        double old_value =
            valueChangeEvent.getOldValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getOldValue().toString());
        double new_value =
            valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
        if (old_value != new_value) {
            if (valueChangeEvent.getNewValue() != null) {
                valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
                double contractLneRate =
                    applicationLineVO.getCurrentRow().getAttribute("Trans_Rate") ==
                    null ? 0 :
                    Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("Trans_Rate").toString());
                //System.err.println("contractLneRate==>"+contractLneRate);
                double contractLneAmt =
                    applicationLineVO.getCurrentRow().getAttribute("Trans_Amount") ==
                    null ? 0 :
                    Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("Trans_Amount").toString());
                //System.err.println("contractLneAmt==>"+contractLneAmt);
                double contractLneQty =
                    applicationLineVO.getCurrentRow().getAttribute("Trans_Qty") ==
                    null ? 0 :
                    Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("Trans_Qty").toString());
                //System.err.println("contractLneQty==>"+contractLneQty);

                double cummulativeAmt =
                    valueChangeEvent.getNewValue() == null ? 0 :
                    Double.parseDouble(valueChangeEvent.getNewValue().toString());
                //System.err.println("cummulativeAmt==>"+cummulativeAmt);
                double taxRate =
                    applicationLineVO.getCurrentRow().getAttribute("TaxRate") ==
                    null ? 0 :
                    Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("TaxRate").toString());
                // set Qty
                //Set qty 13-12-23 by arun both are same calculation
                double cummulativeQty = cummulativeAmt / contractLneRate;
//                double cummulativeQty = (cummulativeAmt * contractLneQty)/ contractLneAmt;

                //System.out.println("cummulativeQty==>"+cummulativeQty);
                applicationLineVO.getCurrentRow().setAttribute("CumTotQty",
                                                               new BigDecimal(df.format(cummulativeQty)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(cumuQty);

                // set Percentage
                double cummulativePer =
                    (100 * cummulativeAmt / contractLneAmt);
                //System.out.println("cummulativePer==>"+cummulativePer);
                applicationLineVO.getCurrentRow().setAttribute("CumPerc",
                                                               new BigDecimal(df.format(cummulativePer)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(cumuPer);

                // setting Current
                double previousQty =
                    applicationLineVO.getCurrentRow().getAttribute("PrevTotQty") ==
                    null ? 0 :
                    Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevTotQty").toString());
                double previousPer =
                    applicationLineVO.getCurrentRow().getAttribute("PrevPerc") ==
                    null ? 0 :
                    Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevPerc").toString());
                double previousAmt =
                    applicationLineVO.getCurrentRow().getAttribute("PrevAmount") ==
                    null ? 0 :
                    Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("PrevAmount").toString());

                //System.out.println("previousQty=>"+previousQty);
                //System.out.println("previousPer==>"+previousPer);
                //System.out.println("previousAmt==>"+previousAmt);
                double currentQty = cummulativeQty - previousQty;
                double currentPre = cummulativePer - previousPer;
                double currentAmt = cummulativeAmt - previousAmt;
                applicationLineVO.getCurrentRow().setAttribute("CurrTotQty",
                                                               new BigDecimal(df.format(currentQty)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(currQty);
                applicationLineVO.getCurrentRow().setAttribute("CurrPerc",
                                                               new BigDecimal(df.format(currentPre)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(currPer);
                applicationLineVO.getCurrentRow().setAttribute("CurrAmount",
                                                               new BigDecimal(df.format(currentAmt)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(currAmt);
                
                //set retention recovery automatic calculation 26-02-2024
//                System.out.println("CumCalculation Retention Recovery entered=>");
//                System.out.println("CumCalculation Retention Recovery =>"+applicationHrdVO.getCurrentRow().getAttribute("Trans_Retension"));

                double cont_ret_perc=applicationHrdVO.getCurrentRow().getAttribute("Trans_Retension")==null ?0:Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("Trans_Retension").toString());
                double ret_rec = (cont_ret_perc * currentAmt) / 100;
                applicationLineVO.getCurrentRow().setAttribute("CurRetRecAmount",
                                                               new BigDecimal(df.format(ret_rec)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(cur_retrec_amount);

                
//                System.out.println("CumCalculation Retention Recovery ended=>");

                // Set Tax Amount
                if (taxRate == 0) {
                    applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                   new BigDecimal(df.format(0)));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                } else {
                    //                    double taxAmt = (currentAmt * taxRate) / 100;
                    double cur_adv_rec_amount =
                        applicationLineVO.getCurrentRow().getAttribute("CurAdvRecAmount") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("CurAdvRecAmount").toString());
                    double cur_ret_rec_amount =
                        applicationLineVO.getCurrentRow().getAttribute("CurRetRecAmount") ==
                        null ? 0 :
                        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("CurRetRecAmount").toString());
                    double final_tax_amount =
                        currentAmt - cur_adv_rec_amount - cur_ret_rec_amount;
                    double taxAmt = (final_tax_amount * taxRate) / 100;
                    //                    applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                    //                                                                   new BigDecimal(df.format(taxAmt)));
                   System.err.println("currentAmt in Tax"+currentAmt);
                    System.err.println("cur_adv_rec_amount in Tax"+cur_adv_rec_amount);
                    System.err.println("cur_ret_rec_amount in Tax"+cur_ret_rec_amount);
                    System.err.println("final_tax_amount in Tax"+final_tax_amount);


//                    applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
//                                                                   new BigDecimal(df.format(taxAmt)));
                                        applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                   (new BigDecimal(taxAmt)).setScale(2, BigDecimal.ROUND_HALF_EVEN));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                }
            }
        }
    }

    public void setCont_Amt(RichInputText cont_Amt) {
        this.cont_Amt = cont_Amt;
    }

    public RichInputText getCont_Amt() {
        return cont_Amt;
    }

    public void setBal_Cont_Amt(RichInputText bal_Cont_Amt) {
        this.bal_Cont_Amt = bal_Cont_Amt;
    }

    public RichInputText getBal_Cont_Amt() {
        return bal_Cont_Amt;
    }

    public void setCum_Amt(RichInputText cum_Amt) {
        this.cum_Amt = cum_Amt;
    }

    public RichInputText getCum_Amt() {
        return cum_Amt;
    }

    public void setCum_adv_rec(RichInputText cum_adv_rec) {
        this.cum_adv_rec = cum_adv_rec;
    }

    public RichInputText getCum_adv_rec() {
        return cum_adv_rec;
    }

    public void setCum_ret(RichInputText cum_ret) {
        this.cum_ret = cum_ret;
    }

    public RichInputText getCum_ret() {
        return cum_ret;
    }

    public void setTot_mat_adv_amt(RichInputText tot_mat_adv_amt) {
        this.tot_mat_adv_amt = tot_mat_adv_amt;
    }

    public RichInputText getTot_mat_adv_amt() {
        return tot_mat_adv_amt;
    }

    public void setCum_mat_adv_rec(RichInputText cum_mat_adv_rec) {
        this.cum_mat_adv_rec = cum_mat_adv_rec;
    }

    public RichInputText getCum_mat_adv_rec() {
        return cum_mat_adv_rec;
    }

    public void setCur_mat_adv_rec(RichInputText cur_mat_adv_rec) {
        this.cur_mat_adv_rec = cur_mat_adv_rec;
    }

    public RichInputText getCur_mat_adv_rec() {
        return cur_mat_adv_rec;
    }

    public void setBal_mat_adv_rec(RichInputText bal_mat_adv_rec) {
        this.bal_mat_adv_rec = bal_mat_adv_rec;
    }

    public RichInputText getBal_mat_adv_rec() {
        return bal_mat_adv_rec;
    }

    public void setMaterial_per(RichInputText material_per) {
        this.material_per = material_per;
    }

    public RichInputText getMaterial_per() {
        return material_per;
    }

    public void setAdv_rec_per_new(RichInputText adv_rec_per_new) {
        this.adv_rec_per_new = adv_rec_per_new;
    }

    public RichInputText getAdv_rec_per_new() {
        return adv_rec_per_new;
    }

    public void setMat_adv_rec_per_new(RichInputText mat_adv_rec_per_new) {
        this.mat_adv_rec_per_new = mat_adv_rec_per_new;
    }

    public RichInputText getMat_adv_rec_per_new() {
        return mat_adv_rec_per_new;
    }

    public void setPrev_mat_adv_rec(RichInputText prev_mat_adv_rec) {
        this.prev_mat_adv_rec = prev_mat_adv_rec;
    }

    public RichInputText getPrev_mat_adv_rec() {
        return prev_mat_adv_rec;
    }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }

    public void onClickPopupCancel(ActionEvent actionEvent) {
        this.getP1().cancel();
    }


    public void payDueDateVCL(ValueChangeEvent term) throws ParseException {
        ViewObject paymentDueVO =
            ADFUtils.findIterator("paymentDueDateROVO1Iterator").getViewObject();
        // Add event code here...

        if (term.getNewValue() != null) {
            if (applicationHrdVO.getCurrentRow().getAttribute("ApplicationDate") !=
                null) {
                String days =
                    applicationHrdVO.getCurrentRow().getAttribute("due_days") ==
                    null ? "0" :
                    applicationHrdVO.getCurrentRow().getAttribute("due_days").toString();
                //               oracle.jbo.domain.Date appDate = (oracle.jbo.domain.Date)applicationHrdVO.getCurrentRow().getAttribute("ApplicationDate");
                String stringDate =
                    applicationHrdVO.getCurrentRow().getAttribute("ApplicationDate").toString();

                //                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                //                df.parse(stringDate);
                //System.err.println("---domainDate--->>" + stringDate);
                paymentDueVO.setNamedWhereClauseParam("curdate", stringDate);
                paymentDueVO.setNamedWhereClauseParam("BV_NAME",
                                                      term.getNewValue());
                paymentDueVO.executeQuery();
                if (paymentDueVO.getEstimatedRowCount() == 1) {
                    //System.err.println("Payment due Date====>" +
                    //                                       paymentDueVO.first().getAttribute("Paymentduedate"));
                    applicationHrdVO.getCurrentRow().setAttribute("PaymentDueDate",
                                                                  paymentDueVO.first().getAttribute("Paymentduedate"));
                    //                        buyPayDate.setValue(paymentDueVO.first().getAttribute("Paymentduedate"));
                    //                        paymentDueDate.setValue(paymentDueVO.first().getAttribute("Paymentduedate"));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(buyPayDate);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(paymentDueDate);
                }
            } else {
                JSFUtils.addFacesErrorMessage("Please select Application Date");
            }
        }
    }

    public void setPaymentDueDate(RichInputDate paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    public RichInputDate getPaymentDueDate() {
        return paymentDueDate;
    }

    public void setBuyPayDate(RichInputDate buyPayDate) {
        this.buyPayDate = buyPayDate;
    }

    public RichInputDate getBuyPayDate() {
        return buyPayDate;
    }

    public void setCurrTaxAmt(RichInputText currTaxAmt) {
        this.currTaxAmt = currTaxAmt;
    }

    public RichInputText getCurrTaxAmt() {
        return currTaxAmt;
    }

    public void setCurPayTaxAmount(RichOutputText curPayTaxAmount) {
        this.curPayTaxAmount = curPayTaxAmount;
    }

    public RichOutputText getCurPayTaxAmount() {
        return curPayTaxAmount;
    }

    public void setCurPayTaxAmount1(RichOutputText curPayTaxAmount1) {
        this.curPayTaxAmount1 = curPayTaxAmount1;
    }

    public RichOutputText getCurPayTaxAmount1() {
        return curPayTaxAmount1;
    }

    public void setTaxRateApp(RichOutputText taxRateApp) {
        this.taxRateApp = taxRateApp;
    }

    public RichOutputText getTaxRateApp() {
        return taxRateApp;
    }

    public void setTaxRateApp1(RichOutputText taxRateApp1) {
        this.taxRateApp1 = taxRateApp1;
    }

    public RichOutputText getTaxRateApp1() {
        return taxRateApp1;
    }

    public String onClickSave() throws SQLException {
        String page = null;
        String maxContVrsn = "0";
        String contHdrId =
            applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
        String appHdrId =
            applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();
        String appVrsn =
            applicationHrdVO.getCurrentRow().getAttribute("Version") == null ?
            "0" :
            applicationHrdVO.getCurrentRow().getAttribute("Version").toString();
        ViewObject getMaxContVrsnRoVo =
            ADFUtils.findIterator("getContMaxVersn_RoVo1Iterator").getViewObject();
        ViewCriteria vwc = getMaxContVrsnRoVo.createViewCriteria();
        ViewCriteriaRow vwcr = vwc.createViewCriteriaRow();
        vwcr.setAttribute("ContHeaderId", contHdrId);
        vwc.addRow(vwcr);
        getMaxContVrsnRoVo.applyViewCriteria(vwc);
        getMaxContVrsnRoVo.executeQuery();
        System.out.println("getMaxContVrsnRoVo count :" +
                           getMaxContVrsnRoVo.getEstimatedRowCount());
        if (getMaxContVrsnRoVo.getEstimatedRowCount() > 0) {
            maxContVrsn =
                    getMaxContVrsnRoVo.first().getAttribute("MaxContVersion") ==
                    null ? "0" :
                    getMaxContVrsnRoVo.first().getAttribute("MaxContVersion").toString();
        }
        if (!appVrsn.equals(maxContVrsn)) {
            JSFUtils.addFacesErrorMessage("Kindly Check a new contract version is amended !!!");
        } else {
            page = onClickSaveApplication();
        }
        return page;
    }

    public String onClickSaveApplication() throws SQLException {
        String pageRedirect = null;
        if (ADFContext.getCurrent().getSessionScope().get("addEditApp") !=
            null &&
            ADFContext.getCurrent().getSessionScope().get("addEditApp").toString().equals("edit")) {
            //System.err.println("ccc-c--c1111 >> " + curOthCharge.getValue());
            onClickCalculateAmount();
            applicationHrdVO.getCurrentRow().setAttribute("CurOthCharge",
                                                          curOthCharge.getValue() ==
                                                          null ?
                                                          new BigDecimal(0) :
                                                          curOthCharge.getValue());
            applicationHrdVO.getCurrentRow().setAttribute("PrevOthCharge",
                                                          prevOthCharge.getValue() ==
                                                          null ?
                                                          new BigDecimal(0) :
                                                          prevOthCharge.getValue());
            applicationHrdVO.getCurrentRow().setAttribute("TotOthCharge",
                                                          curOthCharge.getValue() ==
                                                          null ?
                                                          new BigDecimal(0) :
                                                          curOthCharge.getValue());
            ADFUtils.findOperation("Commit").execute();
            pageRedirect = "save";
            ADFUtils.refreshTable("ApplicationNumber", searchApplicationVO);
            JSFUtils.addFacesInformationMessage("Application Information Saved Successfully");
        } else {
            if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy") ||
                ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
                if (applicationHrdVO.getCurrentRow().getAttribute("OrgId") ==
                    null) {
                    JSFUtils.addFacesErrorMessage("Please Select Business Unit");
                    pageRedirect = null;
                } else {
                    if (applicationHrdVO.getCurrentRow().getAttribute("Trans_ContractNumber") ==
                        null) {
                        JSFUtils.addFacesErrorMessage("Please Select Contract Number");
                        pageRedirect = null;
                    } else {
                        if (applicationHrdVO.getCurrentRow().getAttribute("Trans_SupplierName") ==
                            null) {
                            JSFUtils.addFacesErrorMessage("Please Select SupplierName");
                            pageRedirect = null;
                        } else {
                            if (applicationHrdVO.getCurrentRow().getAttribute("Trans_SupplierSite") ==
                                null) {
                                JSFUtils.addFacesErrorMessage("Please Select Supplier Site Name");
                                pageRedirect = null;
                            } else {
                                if (applicationHrdVO.getCurrentRow().getAttribute("ApplPayTerm") ==
                                    null) {
                                    //if (Boolean.FALSE) {
                                    JSFUtils.addFacesErrorMessage("Please Select Application Pay Term");
                                    pageRedirect = null;
                                } else {
                                    if (applicationHrdVO.getCurrentRow().getAttribute("PaymentType") ==
                                        null) {
                                        JSFUtils.addFacesErrorMessage("Please Select Payment Type");
                                        pageRedirect = null;
                                    } else {
                                        if (applicationHrdVO.getCurrentRow().getAttribute("SupplierInvoiceDate") ==
                                            null) {
                                            JSFUtils.addFacesErrorMessage("Please Select Supplier Invoice Date");
                                            pageRedirect = null;
                                        } else {
                                            if (applicationHrdVO.getCurrentRow().getAttribute("SupplierInvoiceNum") ==
                                                null) {
                                                JSFUtils.addFacesErrorMessage("Please Select Supplier Invoice Number");
                                                pageRedirect = null;
                                            } else {
                                                onClickCalculateAmount();
                                                applicationHrdVO.getCurrentRow().setAttribute("ApplicationStatus",
                                                                                              "ACTIVE");
                                                //                                                applicationHrdVO.getCurrentRow().setAttribute("ApprovalStatus","APR");
                                                applicationHrdVO.getCurrentRow().setAttribute("FuncId",
                                                                                              "200003");
                                                applicationHrdVO.getCurrentRow().setAttribute("ApplicationNumber",
                                                                                              "App-" +
                                                                                              applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId"));
                                                //System.err.println("ccc-c--c>> " +curOthCharge.getValue());
                                                applicationHrdVO.getCurrentRow().setAttribute("CurOthCharge",
                                                                                              curOthCharge.getValue() ==
                                                                                              null ?
                                                                                              new BigDecimal(0) :
                                                                                              curOthCharge.getValue());
                                                applicationHrdVO.getCurrentRow().setAttribute("PrevOthCharge",
                                                                                              prevOthCharge.getValue() ==
                                                                                              null ?
                                                                                              new BigDecimal(0) :
                                                                                              prevOthCharge.getValue());
                                                applicationHrdVO.getCurrentRow().setAttribute("TotOthCharge",
                                                                                              curOthCharge.getValue() ==
                                                                                              null ?
                                                                                              new BigDecimal(0) :
                                                                                              curOthCharge.getValue());
                                                ADFUtils.findOperation("Commit").execute();
                                                pageRedirect = "save";
                                                JSFUtils.numberFaceMessage("Application",
                                                                           applicationHrdVO.getCurrentRow().getAttribute("ApplicationNumber"));
                                            }
                                        }
                                    }

                                }
                            }
                        }
                    }
                }
            } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
                if (applicationHrdVO.getCurrentRow().getAttribute("OrgId") ==
                    null) {
                    JSFUtils.addFacesErrorMessage("Please Select Business Unit");
                    pageRedirect = null;
                } else {
                    if (applicationHrdVO.getCurrentRow().getAttribute("Trans_ContractNumber") ==
                        null) {
                        JSFUtils.addFacesErrorMessage("Please Select Contract Number");
                        pageRedirect = null;
                    } else {
                        // if (applicationHrdVO.getCurrentRow().getAttribute("ApplPayTerm") ==null) {
                        if (Boolean.FALSE) {
                            JSFUtils.addFacesErrorMessage("Please Select Customer Name");
                            pageRedirect = null;
                        } else {
                            // if (applicationHrdVO.getCurrentRow().getAttribute("ApplPayTerm") ==null) {
                            if (Boolean.FALSE) {
                                JSFUtils.addFacesErrorMessage("Please Select Payment Type");
                                pageRedirect = null;
                            } else {
                                // if (applicationHrdVO.getCurrentRow().getAttribute("ApplPayTerm") ==null) {
                                if (Boolean.FALSE) {
                                    JSFUtils.addFacesErrorMessage("Please Select Application Pay Term");
                                    pageRedirect = null;
                                } else {
                                    onClickCalculateAmount();
                                    applicationHrdVO.getCurrentRow().setAttribute("ApplicationStatus",
                                                                                  "ACTIVE");
                                    //                                  applicationHrdVO.getCurrentRow().setAttribute("ApprovalStatus","APR");
                                    applicationHrdVO.getCurrentRow().setAttribute("FuncId",
                                                                                  "200004");
                                    applicationHrdVO.getCurrentRow().setAttribute("ApplicationNumber",
                                                                                  "App-" +
                                                                                  applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId"));
                                    ADFUtils.findOperation("Commit").execute();
                                    pageRedirect = "save";
                                    JSFUtils.numberFaceMessage("Application",
                                                               applicationHrdVO.getCurrentRow().getAttribute("ApplicationNumber"));
                                }
                            }
                        }

                    }
                }
            }

        }


        //          double contractAdvanAmount=applicationHrdVO.getCurrentRow().getAttribute("CurApplication")==null?0:Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurApplication").toString());
        //          applicationHrdVO.executeQuery();
        //          double ccc=applicationHrdVO.getCurrentRow().getAttribute("CurApplication")==null?0:Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurApplication").toString());
        //          applicationHrdVO.getCurrentRow().setAttribute("Version", 0);
        /*
            functionVO.setNamedWhereClauseParam("p_code", "SELL_PAY_APP");
            functionVO.executeQuery();
            //System.err.println("==functionVO COUNT==" +
                               functionVO.getEstimatedRowCount());

            if (functionVO.getEstimatedRowCount() == 1) {
                Object funid = functionVO.first().getAttribute("FuncId");
                applicationHrdVO.getCurrentRow().setAttribute("FuncId", funid);
                applicationHrdVO.getCurrentRow().setAttribute("ApplicationStatus",
                                                              "ACTIVE");
                applicationHrdVO.getCurrentRow().setAttribute("ApprovalStatus",
                                                              "APR");
                applicationHrdVO.getCurrentRow().setAttribute("ApplicationNumber",
                                                              "App- " +
                                                              applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId"));
                ADFUtils.findOperation("Commit").execute();
                ADFUtils.refreshTable("ApplicationNumber",
                                      searchApplicationVO);
                JSFUtils.numberFaceMessage("Application",
                                           applicationHrdVO.getCurrentRow().getAttribute("ApplicationNumber"));
            } else {
                applicationHrdVO.getCurrentRow().setAttribute("ApplicationStatus",
                                                              "ACTIVE");
                applicationHrdVO.getCurrentRow().setAttribute("ApprovalStatus",
                                                              "APR");
                applicationHrdVO.getCurrentRow().setAttribute("ApplicationNumber",
                                                              "App- " +
                                                              applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId"));
                ADFUtils.findOperation("Commit").execute();
                ADFUtils.refreshTable("ApplicationNumber",
                                      searchApplicationVO);
                JSFUtils.numberFaceMessage("Application",
                                           applicationHrdVO.getCurrentRow().getAttribute("ApplicationNumber"));
            }

        */
        return pageRedirect;
    }

    public void setAdvPer(RichPanelLabelAndMessage advPer) {
        this.advPer = advPer;
    }

    public RichPanelLabelAndMessage getAdvPer() {
        return advPer;
    }

    public void setContra_Charges(RichInputText contra_Charges) {
        this.contra_Charges = contra_Charges;
    }

    public RichInputText getContra_Charges() {
        return contra_Charges;
    }

    public void setPenality_charges(RichInputText penality_charges) {
        this.penality_charges = penality_charges;
    }

    public RichInputText getPenality_charges() {
        return penality_charges;
    }

    public void setCurAdvRecPer(RichInputText curAdvRecPer) {
        this.curAdvRecPer = curAdvRecPer;
    }

    public RichInputText getCurAdvRecPer() {
        return curAdvRecPer;
    }

    public void setCurMatAdvRecPer(RichInputText curMatAdvRecPer) {
        this.curMatAdvRecPer = curMatAdvRecPer;
    }

    public RichInputText getCurMatAdvRecPer() {
        return curMatAdvRecPer;
    }

    //**Approval Process
    String submitPkg = "xxfnd_util_pkg.submit_for_approval";
    String responsePkg = "xxfnd_util_pkg.update_response";
    String tableName = "XXSC_PAY_APPL_HEADERS";
    String app_status_column = "APPROVAL_STATUS";
    String pk_column = "APPL_HEADER_ID";
    String fwd_to = "0";
    //  String response="Approved";
    //  String status  ="A";
    String submitMailPkg = "xxfnd_util_pkg.submit_mail";

    public boolean getApprovalUser() {
        boolean flag = false;
        String flowWith =
            applicationHrdVO.getCurrentRow().getAttribute("FlowWith") == null ?
            "" :
            applicationHrdVO.getCurrentRow().getAttribute("FlowWith").toString();
        String LoginUser =
            ADFContext.getCurrent().getSessionScope().get("userName") == null ?
            "0" :
            ADFContext.getCurrent().getSessionScope().get("userName").toString();
        ViewObject userVO =
            ADFUtils.findIterator("XxscUserAccess1Iterator").getViewObject();
        userVO.setNamedWhereClauseParam("BV_USER_NAME", LoginUser);
        userVO.executeQuery();
        if (userVO.getEstimatedRowCount() != 0) {
            String loginID =
                userVO.first().getAttribute("UserId") == null ? "0" :
                userVO.first().getAttribute("UserId").toString();
            //System.err.println("flowWith-->>" + flowWith + "loginID-->" +
            //                               loginID);
            if (flowWith.equalsIgnoreCase(loginID)) {
                flag = true;
            } else {
                flag = false;
            }
        } else {
            flag = false;
        }
        //System.err.println("Flag" + flag);
        return flag;
    }

    public String onClickSubmit() throws SQLException, MalformedURLException,
                                         IOException {
        String pageRedirect = null;
        String page = onClickSaveApplication();
        ///* Approval Process
        if (page.equalsIgnoreCase("save")) {
            String func_id =
                applicationHrdVO.getCurrentRow().getAttribute("FuncId") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("FuncId").toString();
            String ref_id =
                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();
            String level_no =
                applicationHrdVO.getCurrentRow().getAttribute("FlowLevel") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("FlowLevel").toString();
            String OrgId =
                applicationHrdVO.getCurrentRow().getAttribute("OrgId") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("OrgId").toString();
            String ProjectId =
                applicationHrdVO.getCurrentRow().getAttribute("TransProjectId") ==
                null ? "0" :
                applicationHrdVO.getCurrentRow().getAttribute("TransProjectId").toString();
            String flag =
                ADFApproval.invokeSubmitPkg(submitPkg, func_id, ref_id,
                                            level_no, tableName,
                                            app_status_column, pk_column,
                                            OrgId, ProjectId, null);
            //                  String flag=ADFApproval.invokeSubmitPkg(submitPkg, func_id, ref_id, level_no, tableName, app_status_column, pk_column);
            if (flag.equalsIgnoreCase("Success")) {
                String flowWith =
                    ADFContext.getCurrent().getSessionScope().get("flow_with") ==
                    null ? "0" :
                    ADFContext.getCurrent().getSessionScope().get("flow_with").toString();
                ViewObject ApproveMailVO =
                    ADFUtils.findIterator("XxscHeadDetailROVO1Iterator").getViewObject();
                ApproveMailVO.setNamedWhereClauseParam("BV_USER_ID", flowWith);
                ApproveMailVO.executeQuery();
                //System.out.println("COUNT--" +
                //                                   ApproveMailVO.getEstimatedRowCount());
                if (ApproveMailVO.getEstimatedRowCount() != 0) {
                    String to =
                        ApproveMailVO.first().getAttribute("Email") == null ?
                        "naresco@eim.ae" :
                        ApproveMailVO.first().getAttribute("Email").toString();
                    String fromMail = "info@naresco.com";
                    String LoginUser =
                        ADFContext.getCurrent().getSessionScope().get("userName") ==
                        null ? "0" :
                        ADFContext.getCurrent().getSessionScope().get("userName").toString();
                    //                                    String htmlBody= MailTemplates.submit("Application", applicationHrdVO.getCurrentRow().getAttribute("ApplicationNumber").toString(), LoginUser);
                    //                                    String subject="Mail Notification";
                    //                                    MailServices.sendNotification("dineshkumar.p@4iapps.com", "dineshkumar.p@4iapps.com", "Hai", null, "Hai");
                    //                                    MailServices.sendNotification("dineshkumar.p@4iapps.com,arunachalam.t@4iapps.com,sundarrajan.v@4iapps.com,mahalingam.m@4iapps.com", fromMail, null, htmlBody, subject);
                    ADFApproval.submitMailPkg(fromMail, to, "Application",
                                              applicationHrdVO.getCurrentRow().getAttribute("ApplicationNumber").toString(),
                                              LoginUser);
                    if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
                        JSFUtils.addFacesInformationMessage("Buy Application Information Saved Successfully and Submitted For Approval" +
                                                            ProjectId +
                                                            func_id);
                        pageRedirect = "save";
                        cb9.setDisabled(Boolean.TRUE);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(cb9);
                    } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
                        JSFUtils.addFacesInformationMessage("Sell Application Information Saved Successfully and Submitted For Approval");
                        pageRedirect = "save";
                        cb9.setDisabled(Boolean.TRUE);
                        AdfFacesContext.getCurrentInstance().addPartialTarget(cb9);
                    }

                } else {
                    //                    JSFUtils.addFacesErrorMessage("Mail Notification Failed");
                }
            } else {
                JSFUtils.addFacesErrorMessage("Error in Submit For Approval. Error:" +
                                              flag);
                pageRedirect = null;
            }
        }
        //        */
        //        if (page.equalsIgnoreCase("save")) {
        //            applicationHrdVO.getCurrentRow().setAttribute("ApplicationStatus",
        //                                                          "ACTIVE");
        //            applicationHrdVO.getCurrentRow().setAttribute("ApprovalStatus",
        //                                                          "APR");
        //            ADFUtils.findOperation("Commit").execute();
        //            JSFUtils.addFacesInformationMessage("Buy Application Information Saved Successfully and Approved");
        //            pageRedirect = "save";
        //        }
        else {
            pageRedirect = null;
        }
        return pageRedirect;
    }

    public String onClickApprove() throws SQLException {
        String pageRedirect = null;
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy") ||
            ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {

            String approDesc =
                appValue.getValue() == null ? "Approved" : appValue.getValue().toString();
            String func_id =
                applicationHrdVO.getCurrentRow().getAttribute("FuncId") ==
                null ? "" :
                applicationHrdVO.getCurrentRow().getAttribute("FuncId").toString();
            String ref_id =
                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
                null ? "" :
                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();
            String level_no =
                applicationHrdVO.getCurrentRow().getAttribute("FlowLevel") ==
                null ? "" :
                applicationHrdVO.getCurrentRow().getAttribute("FlowLevel").toString();
            String appr_id =
                applicationHrdVO.getCurrentRow().getAttribute("FlowWith") ==
                null ? "" :
                applicationHrdVO.getCurrentRow().getAttribute("FlowWith").toString();
            String user_grp =
                applicationHrdVO.getCurrentRow().getAttribute("UserGrpId") ==
                null ? "" :
                applicationHrdVO.getCurrentRow().getAttribute("UserGrpId").toString();
            String flag =
                ADFApproval.invokeResponsePkg(responsePkg, func_id, user_grp,
                                              ref_id, level_no, appr_id,
                                              approDesc, "A", fwd_to,
                                              tableName, app_status_column,
                                              pk_column);
            if (flag.equalsIgnoreCase("Success")) {
                if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
                    mailidVO.setNamedWhereClauseParam("BV_COLUMN_NAME",
                                                      "FLOW_WITH");
                    mailidVO.setNamedWhereClauseParam("BV_TABLE_NAME",
                                                      "XXSC_PAY_APPL_HEADERS");
                    mailidVO.setNamedWhereClauseParam("BV_WHERE_CONDTION",
                                                      "APPL_HEADER_ID");
                    mailidVO.setNamedWhereClauseParam("BV_VALUE", ref_id);
                    mailidVO.executeQuery();
                    String to =
                        mailidVO.first().getAttribute("Mailid") == null ?
                        "null" :
                        mailidVO.first().getAttribute("Mailid").toString();
                    if (to != null || to != "-") {
                        String LoginUser =
                            ADFContext.getCurrent().getSessionScope().get("userName") ==
                            null ? "0" :
                            ADFContext.getCurrent().getSessionScope().get("userName").toString();
                        ADFApproval.submitMailPkg(LoginUser, to, "Application",
                                                  applicationHrdVO.getCurrentRow().getAttribute("ApplicationNumber").toString(),
                                                  LoginUser);
                        JSFUtils.addFacesInformationMessage("Buy Application Information Saved Successfully and Submitted For Approval");
                        pageRedirect = "save";
                    } else {
                        JSFUtils.addFacesInformationMessage("Buy Application Approved Successfully");
                        pageRedirect = "save";
                    }

                } else {
                    pageRedirect = null;
                }
            } else {
                JSFUtils.addFacesErrorMessage("Approval Process Failed. Error Message:" +
                                              flag);
                pageRedirect = null;
            }
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
            String approDesc =
                appValue.getValue() == null ? "Approved" : appValue.getValue().toString();
            String func_id =
                applicationHrdVO.getCurrentRow().getAttribute("FuncId") ==
                null ? "" :
                applicationHrdVO.getCurrentRow().getAttribute("FuncId").toString();
            String ref_id =
                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
                null ? "" :
                applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();
            String level_no =
                applicationHrdVO.getCurrentRow().getAttribute("FlowLevel") ==
                null ? "" :
                applicationHrdVO.getCurrentRow().getAttribute("FlowLevel").toString();
            String appr_id =
                applicationHrdVO.getCurrentRow().getAttribute("FlowWith") ==
                null ? "" :
                applicationHrdVO.getCurrentRow().getAttribute("FlowWith").toString();
            String user_grp =
                applicationHrdVO.getCurrentRow().getAttribute("UserGrpId") ==
                null ? "" :
                applicationHrdVO.getCurrentRow().getAttribute("UserGrpId").toString();

            String flag =
                ADFApproval.invokeResponsePkg(responsePkg, func_id, user_grp,
                                              ref_id, level_no, appr_id,
                                              approDesc, "A", fwd_to,
                                              tableName, app_status_column,
                                              pk_column);
            if (flag.equalsIgnoreCase("Success")) {
                if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
                    mailidVO.setNamedWhereClauseParam("BV_COLUMN_NAME",
                                                      "FLOW_WITH");
                    mailidVO.setNamedWhereClauseParam("BV_TABLE_NAME",
                                                      "XXSC_PAY_APPL_HEADERS");
                    mailidVO.setNamedWhereClauseParam("BV_WHERE_CONDTION",
                                                      "APPL_HEADER_ID");
                    mailidVO.setNamedWhereClauseParam("BV_VALUE", ref_id);
                    mailidVO.executeQuery();
                    String to =
                        mailidVO.first().getAttribute("Mailid") == null ?
                        "null" :
                        mailidVO.first().getAttribute("Mailid").toString();
                    if (to != "null" || to != "-") {
                        String LoginUser =
                            ADFContext.getCurrent().getSessionScope().get("userName") ==
                            null ? "0" :
                            ADFContext.getCurrent().getSessionScope().get("userName").toString();
                        ADFApproval.submitMailPkg(LoginUser, to, "Application",
                                                  applicationHrdVO.getCurrentRow().getAttribute("ApplicationNumber").toString(),
                                                  LoginUser);
                        JSFUtils.addFacesInformationMessage("Sell Application Information Saved Successfully and Submitted For Approval");
                        pageRedirect = "save";
                    } else {
                        JSFUtils.addFacesInformationMessage("Sell Application Approved Successfully");
                        pageRedirect = "save";
                    }
                } else {
                    pageRedirect = null;
                }
            } else {
                JSFUtils.addFacesErrorMessage("Approval Process Failed. Error Message:" +
                                              flag);
                pageRedirect = null;
            }
        }


        return pageRedirect;
    }

    public String onClickReject() throws SQLException {
        String pageRedirect = null;
        if (rejectValue.getValue() != null) {

            if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy") ||
                ADFContext.getCurrent().getSessionScope().get("page").equals("buy")) {
                String func_id =
                    applicationHrdVO.getCurrentRow().getAttribute("FuncId") ==
                    null ? "" :
                    applicationHrdVO.getCurrentRow().getAttribute("FuncId").toString();
                String ref_id =
                    applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
                    null ? "" :
                    applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();
                String level_no =
                    applicationHrdVO.getCurrentRow().getAttribute("FlowLevel") ==
                    null ? "" :
                    applicationHrdVO.getCurrentRow().getAttribute("FlowLevel").toString();
                String appr_id =
                    applicationHrdVO.getCurrentRow().getAttribute("FlowWith") ==
                    null ? "" :
                    applicationHrdVO.getCurrentRow().getAttribute("FlowWith").toString();
                String user_grp =
                    applicationHrdVO.getCurrentRow().getAttribute("UserGrpId") ==
                    null ? "" :
                    applicationHrdVO.getCurrentRow().getAttribute("UserGrpId").toString();
                String flag =
                    ADFApproval.invokeResponsePkg(responsePkg, func_id,
                                                  user_grp, ref_id, level_no,
                                                  appr_id,
                                                  rejectValue.getValue().toString(),
                                                  "R", fwd_to, tableName,
                                                  app_status_column,
                                                  pk_column);
                if (flag.equalsIgnoreCase("Success")) {
                    if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
                        JSFUtils.addFacesInformationMessage("Buy Contract Rejected");
                        pageRedirect = "save";
                    } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
                        JSFUtils.addFacesInformationMessage("Sell Contract Rejected");
                        pageRedirect = "save";
                    }
                } else {
                    JSFUtils.addFacesErrorMessage("Rejection Process Failed. Error:" +
                                                  flag);
                    pageRedirect = null;
                }
            } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
                String func_id =
                    applicationHrdVO.getCurrentRow().getAttribute("FuncId") ==
                    null ? "" :
                    applicationHrdVO.getCurrentRow().getAttribute("FuncId").toString();
                String ref_id =
                    applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
                    null ? "" :
                    applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();
                String level_no =
                    applicationHrdVO.getCurrentRow().getAttribute("FlowLevel") ==
                    null ? "" :
                    applicationHrdVO.getCurrentRow().getAttribute("FlowLevel").toString();
                String appr_id =
                    applicationHrdVO.getCurrentRow().getAttribute("FlowWith") ==
                    null ? "" :
                    applicationHrdVO.getCurrentRow().getAttribute("FlowWith").toString();
                String user_grp =
                    applicationHrdVO.getCurrentRow().getAttribute("UserGrpId") ==
                    null ? "" :
                    applicationHrdVO.getCurrentRow().getAttribute("UserGrpId").toString();
                String flag =
                    ADFApproval.invokeResponsePkg(responsePkg, func_id,
                                                  user_grp, ref_id, level_no,
                                                  appr_id,
                                                  rejectValue.getValue().toString(),
                                                  "R", fwd_to, tableName,
                                                  app_status_column,
                                                  pk_column);
                if (flag.equalsIgnoreCase("Success")) {
                    if (ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
                        JSFUtils.addFacesInformationMessage("Buy Contract Rejected");
                        pageRedirect = "save";
                    } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
                        JSFUtils.addFacesInformationMessage("Sell Contract Rejected");
                        pageRedirect = "save";
                    }
                } else {
                    JSFUtils.addFacesErrorMessage("Rejection Process Failed. Error:" +
                                                  flag);
                    pageRedirect = null;
                }
            }


        } else {
            JSFUtils.addFacesErrorMessage("Please Enter Reject Reason");
        }
        return pageRedirect;
    }


    public void setP3(RichPopup p3) {
        this.p3 = p3;
    }

    public RichPopup getP3() {
        return p3;
    }

    public void setRejectValue(RichInputText rejectValue) {
        this.rejectValue = rejectValue;
    }

    public RichInputText getRejectValue() {
        return rejectValue;
    }

    public void onRejectCancel(ActionEvent actionEvent) {
        this.getP3().cancel();
    }

    public void penalty_back_charges() {
        String Hid =
            applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
        String ver =
            applicationHrdVO.getCurrentRow().getAttribute("Version") == null ?
            "0" :
            applicationHrdVO.getCurrentRow().getAttribute("Version").toString();
        String apphdrid =
            applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
            null ? "" :
            applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();
        double Mat_onsite =
            applicationHrdVO.getCurrentRow().getAttribute("MatOnSite") ==
            null ? 0 :
            Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("MatOnSite").toString());
        double Mat_onsite_rec =
            applicationHrdVO.getCurrentRow().getAttribute("MatOnSiteRec") ==
            null ? 0 :
            Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("MatOnSiteRec").toString());
        double Cur_mat = Mat_onsite - Mat_onsite_rec;
        applicationHrdVO.getCurrentRow().setAttribute("CurMatOnSiteRec",
                                                      Cur_mat);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cur_mat_onsite);
        penaltybackchargesVO.setNamedWhereClauseParam("BV_CONT_HDR_ID", Hid);
        penaltybackchargesVO.setNamedWhereClauseParam("BV_PAY_TYPE",
                                                      "Interim");
        penaltybackchargesVO.setNamedWhereClauseParam("BV_APP_HDR_ID",
                                                      apphdrid);
        penaltybackchargesVO.setNamedWhereClauseParam("BV_VERSION", ver);
        penaltybackchargesVO.executeQuery();
        if (penaltybackchargesVO.getEstimatedRowCount() > 0) {
            applicationHrdVO.getCurrentRow().setAttribute("PrevContraCharges",
                                                          penaltybackchargesVO.first().getAttribute("BackCharges"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(prev_contra);
            applicationHrdVO.getCurrentRow().setAttribute("PrevPenaltyCharges",
                                                          penaltybackchargesVO.first().getAttribute("PenaltyCharges"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(prev_penalty);
            applicationHrdVO.getCurrentRow().setAttribute("PrevMaterialRec",
                                                          penaltybackchargesVO.first().getAttribute("MaterialRecovery"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(prev_Mat_rec);
        }
    }

    public void setPrev_contra(RichInputText prev_contra) {
        this.prev_contra = prev_contra;
    }

    public RichInputText getPrev_contra() {
        return prev_contra;
    }

    public void setPrev_penalty(RichInputText prev_penalty) {
        this.prev_penalty = prev_penalty;
    }

    public RichInputText getPrev_penalty() {
        return prev_penalty;
    }

    public void setPrev_Mat_rec(RichInputText prev_Mat_rec) {
        this.prev_Mat_rec = prev_Mat_rec;
    }

    public RichInputText getPrev_Mat_rec() {
        return prev_Mat_rec;
    }

    public void setCur_mat_onsite(RichInputText cur_mat_onsite) {
        this.cur_mat_onsite = cur_mat_onsite;
    }

    public RichInputText getCur_mat_onsite() {
        return cur_mat_onsite;
    }

    public void setP4(RichPopup p4) {
        this.p4 = p4;
    }

    public RichPopup getP4() {
        return p4;
    }

    public void setAppValue(RichInputText appValue) {
        this.appValue = appValue;
    }

    public RichInputText getAppValue() {
        return appValue;
    }

    public void onApprovCacel(ActionEvent actionEvent) {
        this.getP4().cancel();
    }

    public void setEcpTotAmt(RichInputText ecpTotAmt) {
        this.ecpTotAmt = ecpTotAmt;
    }

    public RichInputText getEcpTotAmt() {
        return ecpTotAmt;
    }

    public void onChangeEcpPer(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != null) {
            double totalAmt =
                applicationLineVO.getCurrentRow().getAttribute("Trans_Amount") ==
                null ? 0 :
                Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("Trans_Amount").toString());
            double ecpPer =
                valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
            double ecpAmt = (totalAmt * ecpPer / 100);
            applicationLineVO.getCurrentRow().setAttribute("EcpTotalAmount",
                                                           df.format(ecpAmt));
            AdfFacesContext.getCurrentInstance().addPartialTarget(ecpTotAmt);
        } else {
            double totalAmt =
                applicationLineVO.getCurrentRow().getAttribute("Trans_Amount") ==
                null ? 0 :
                Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("Trans_Amount").toString());
            double ecpPer = 0;
            double ecpAmt = (totalAmt * ecpPer / 100);
            applicationLineVO.getCurrentRow().setAttribute("EcpTotalAmount",
                                                           df.format(ecpAmt));
            AdfFacesContext.getCurrentInstance().addPartialTarget(ecpTotAmt);
        }
    }

    public void cleardata(ActionEvent actionEvent) {
        Row r = applicationLineVO.getCurrentRow();
        r.setAttribute("CumTotQty", null);
        r.setAttribute("CumPerc", null);
        r.setAttribute("CumAmount", null);
        AdfFacesContext.getCurrentInstance().addPartialTarget(t1);

    }

    public void setProId(RichOutputText proId) {
        this.proId = proId;
    }

    public RichOutputText getProId() {
        return proId;
    }

    public void setP2(RichPopup p2) {
        this.p2 = p2;
    }

    public RichPopup getP2() {
        return p2;
    }


    public void onClickFinalCancel(ActionEvent actionEvent) {
        this.getP2().cancel();
    }

    public void onClickFinal(ActionEvent actionEvent) throws SQLException {
        String appContID =
            applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
        String appVersion =
            applicationHrdVO.getCurrentRow().getAttribute("Version") == null ?
            "0" :
            applicationHrdVO.getCurrentRow().getAttribute("Version").toString();
        String apphdrid =
            applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();
        double advAmt =
            tans_Adv_rec.getValue() == null ? 0 : Double.parseDouble(tans_Adv_rec.getValue().toString());
        double matAdvAmt =
            material_Adv_amt.getValue() == null ? 0 : Double.parseDouble(material_Adv_amt.getValue().toString());
        double retAmt =
            trans_ret_amt.getValue() == null ? 0 : Double.parseDouble(trans_ret_amt.getValue().toString());
        //System.err.println("appContID==>" + appContID);
        //System.err.println("appVersion==>" + appVersion);
        //System.err.println("apphdrid==>" + apphdrid);
        //System.err.println("adv Amt==>" + advAmt);
        //System.err.println("matAdv Amt==>" + matAdvAmt);
        //System.err.println("ret Amt==>" + retAmt);
        // check Minimum 1 Interim
        ViewObject checkAppHrdVO =
            ADFUtils.findIterator("checkApplicationROVO1Iterator").getViewObject();
        checkAppHrdVO.setNamedWhereClauseParam("BV_HID", appContID);
        checkAppHrdVO.executeQuery();
        if (checkAppHrdVO.getEstimatedRowCount() > 0) {
            ViewObject getBalAppVO =
                ADFUtils.findIterator("FinalAppCalcROVO1Iterator").getViewObject();
            getBalAppVO.setNamedWhereClauseParam("BV_HID", appContID);
            getBalAppVO.setNamedWhereClauseParam("APP_HDR_ID", apphdrid);
            getBalAppVO.setNamedWhereClauseParam("VER", appVersion);
            getBalAppVO.executeQuery();
            double balAdvRecAmt =
                getBalAppVO.first().getAttribute("Finbaladvrec") == null ? 0 :
                Double.parseDouble(getBalAppVO.first().getAttribute("Finbaladvrec").toString());
            double balMatAdvRecAmt =
                getBalAppVO.first().getAttribute("Finbalmatadvrec") == null ?
                0 :
                Double.parseDouble(getBalAppVO.first().getAttribute("Finbalmatadvrec").toString());
            double balRetRecAmt =
                getBalAppVO.first().getAttribute("Finbalretrec") == null ? 0 :
                Double.parseDouble(getBalAppVO.first().getAttribute("Finbalretrec").toString());
            double balTotalAmt =
                getBalAppVO.first().getAttribute("Finbalamount") == null ? 0 :
                Double.parseDouble(getBalAppVO.first().getAttribute("Finbalamount").toString());
//            System.err.println("appContID balAdvRecAmt==>" + balAdvRecAmt);
//            System.err.println("appContID balMatAdvRecAmt==>" + balMatAdvRecAmt);
//            System.err.println("appContID balRetRecAmt==>" + balRetRecAmt);
            System.err.println("appContID balTotalAmt==>" + balTotalAmt);
            // get Recovery Percentage
//            double advRecPer =0;
//            double retRecPer=0;
//            if(balTotalAmt!=0)
//            {
                   double  advRecPer = (balAdvRecAmt / balTotalAmt * 100);
//                }
            
            
            double matadvRecPer = (balMatAdvRecAmt / balTotalAmt * 100);
            //System.err.println("matadvRecPer==>" + matadvRecPer);
//            if(balTotalAmt!=0)
//            {
                   double  retRecPer = (balRetRecAmt / balTotalAmt * 100);
//                }
            System.err.println("retRecPer==>" + retRecPer);
            // Setting Recovery Percentage
            applicationHrdVO.getCurrentRow().setAttribute("Curadvrecper",
                                                          advRecPer);
            applicationHrdVO.getCurrentRow().setAttribute("Curmatadvrecper",
                                                          matadvRecPer);
            applicationHrdVO.getCurrentRow().setAttribute("Curretper",
                                                          retRecPer);
            // Inserting  Application Line
            // Filtering contract line VO
            ViewCriteria contractLineVC = contractLineVO.createViewCriteria();
            ViewCriteriaRow contractLineVCRow =
                contractLineVC.createViewCriteriaRow();
            contractLineVCRow.setAttribute("ContHeaderId", appContID);
            contractLineVCRow.setAttribute("Version", appVersion);
            contractLineVC.addRow(contractLineVCRow);
            contractLineVO.applyViewCriteria(contractLineVC);
            contractLineVO.executeQuery();
            //System.err.println("==COUNT==" +
            //                               contractLineVO.getEstimatedRowCount());
            // Iteration on contract line
            RowSetIterator contractRs =
                contractLineVO.createRowSetIterator(null);
            while (contractRs.hasNext()) {
                Row contracrLineRow = contractRs.next();
                Object hid = contracrLineRow.getAttribute("ContHeaderId");
                Object lid = contracrLineRow.getAttribute("ContLineId");
                Object version = contracrLineRow.getAttribute("Version");
                Object taxCode = contracrLineRow.getAttribute("TaxCode");
                Object taxRate = contracrLineRow.getAttribute("TaxRate");
                Object taxAmt = contracrLineRow.getAttribute("TaxAmount");
                Object ecpPer = contracrLineRow.getAttribute("EcpPercentage");
                Object ecpAmt = contracrLineRow.getAttribute("EcpTotalAmount");

                // Advance and retention % column
                Object advLinePer = advRecPer;
                Object retLinePer = retRecPer;
                //Object advAmt          =contracrLineRow.getAttribute("ContAdvAmt");
                //Object advRecPer       =contracrLineRow.getAttribute("ContAdvRec");
                //Object advRecAmt       =contracrLineRow.getAttribute("ContAdvRecAmt");
                //Object retAmt          =contracrLineRow.getAttribute("ContRetAmt");
                //Object retRecPer       =contracrLineRow.getAttribute("ContRetRec");
                //Object retRecAmt       =contracrLineRow.getAttribute("ContRetRecAmt");


                // Filtering Application Line---check contract line=0 or not
                ViewCriteria appVO = applicationLineVO2.createViewCriteria();
                ViewCriteriaRow appVCR = appVO.createViewCriteriaRow();
                appVCR.setAttribute("ContLineId", lid);
                appVO.addRow(appVCR);
                applicationLineVO2.applyViewCriteria(appVO);
                applicationLineVO2.executeQuery();
                //System.err.println("Total applicationLine Count--" +
                //                                   applicationLineVO2.getEstimatedRowCount());
                long TotalRowAppCount =
                    applicationLineVO2.getEstimatedRowCount();
                //Equal to 0
                if (applicationLineVO2.getEstimatedRowCount() == 0) {
                    //Application line Row adding
                    Row appLineRow = applicationLineVO.createRow();
                    appLineRow.setAttribute("ContHeaderId", hid);
                    appLineRow.setAttribute("ContLineId", lid);
                    appLineRow.setAttribute("Version", version);
                    appLineRow.setAttribute("ApplHeaderId",
                                            applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId"));
                    appLineRow.setAttribute("OrgId",
                                            applicationHrdVO.getCurrentRow().getAttribute("OrgId"));
                    appLineRow.setAttribute("TaxCode", taxCode);
                    appLineRow.setAttribute("TaxRate", taxRate);
                    appLineRow.setAttribute("EcpPercentage", ecpPer);
                    appLineRow.setAttribute("EcpTotalAmount", ecpAmt);

                    appLineRow.setAttribute("AdvRecPer", advLinePer);
                    appLineRow.setAttribute("RetRecPer", retLinePer);
                    applicationLineVO.insertRow(appLineRow);

                } else {
                    double totalPer = 0;
                    double totalQty = 0;
                    double totalAmt = 0;
                    previousCalculationVO.setNamedWhereClauseParam("BV_CONT_HRDID",
                                                                   hid);
                    previousCalculationVO.setNamedWhereClauseParam("BV_VER",
                                                                   version);
                    previousCalculationVO.setNamedWhereClauseParam("BV_CONT_LNEID",
                                                                   lid);
                    previousCalculationVO.setNamedWhereClauseParam("APP_HRDID",
                                                                   applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId"));
                    previousCalculationVO.executeQuery();
                    //                        previousCalculationVO.getEstimatedRowCount();
                    //System.err.println("Pre Qty, % Amt===COUNT==" +
                    //                                       previousCalculationVO.getEstimatedRowCount());
                    if (previousCalculationVO.getEstimatedRowCount() == 0) {
                        totalPer = 0;
                        totalQty = 0;
                        totalAmt = 0;
                    } else {
                        totalQty =
                                previousCalculationVO.first().getAttribute("ApplPrevQty") ==
                                null ? 0 :
                                Double.parseDouble(previousCalculationVO.first().getAttribute("ApplPrevQty").toString());
                        totalPer =
                                previousCalculationVO.first().getAttribute("ApplPrevPerc") ==
                                null ? 0 :
                                Double.parseDouble(previousCalculationVO.first().getAttribute("ApplPrevPerc").toString());
                        totalAmt =
                                previousCalculationVO.first().getAttribute("ApplPrevAmount") ==
                                null ? 0 :
                                Double.parseDouble(previousCalculationVO.first().getAttribute("ApplPrevAmount").toString());
                        //System.out.println("totalQty---" + totalQty +
                        //                                           "totalPer-----" + totalPer +
                        //                                           "totalAmt---" + totalAmt);
                    }
                    //Application line Row adding
                    Row appLineRow = applicationLineVO.createRow();
                    appLineRow.setAttribute("ContHeaderId", hid);
                    appLineRow.setAttribute("ContLineId", lid);
                    appLineRow.setAttribute("Version", version);
                    appLineRow.setAttribute("EcpPercentage", ecpPer);
                    appLineRow.setAttribute("EcpTotalAmount", ecpAmt);
                    appLineRow.setAttribute("ApplHeaderId",
                                            applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId"));
                    appLineRow.setAttribute("TaxCode", taxCode);
                    appLineRow.setAttribute("TaxRate", taxRate);
                    //                        appLineRow.setAttribute("TaxAmount", taxAmt);
                    appLineRow.setAttribute("PrevPerc",
                                            new BigDecimal(df.format(totalPer)));
                    appLineRow.setAttribute("PrevTotQty",
                                            new BigDecimal(df.format(totalQty)));
                    appLineRow.setAttribute("PrevAmount",
                                            new BigDecimal(df.format(totalAmt)));
                    appLineRow.setAttribute("OrgId",
                                            applicationHrdVO.getCurrentRow().getAttribute("OrgId"));
                    appLineRow.setAttribute("AdvRecPer", advLinePer);
                    appLineRow.setAttribute("RetRecPer", retLinePer);
                    applicationLineVO.insertRow(appLineRow);
                }
            }
            applicationLineVO.executeQuery();
            //System.err.println("Application Line inserted-final");
            //System.err.println("final Line Count" +
            //                               applicationLineVO.getEstimatedRowCount());
            // Setting Cummulative 100
            RowSetIterator rs = applicationLineVO.createRowSetIterator(null);
            while (rs.hasNext()) {
                Row r = rs.next();
                double contractLneRate =
                    r.getAttribute("Trans_Rate") == null ? 0 :
                    Double.parseDouble(r.getAttribute("Trans_Rate").toString());
                double contractLneAmt =
                    r.getAttribute("Trans_Amount") == null ? 0 :
                    Double.parseDouble(r.getAttribute("Trans_Amount").toString());
                double taxRate =
                    r.getAttribute("TaxRate") == null ? 0 : Double.parseDouble(r.getAttribute("TaxRate").toString());
                double cummulativePer = 100;
                double cumPer =
                    r.getAttribute("CumPerc") == null ? 0 : Double.parseDouble(r.getAttribute("CumPerc").toString());
                if (cumPer != 100) {
                    // Set Per
                    r.setAttribute("CumPerc", 100);
                    // set Amount
                    double cummulativeAmt =
                        (cummulativePer * contractLneAmt) / 100;
                    r.setAttribute("CumAmount",
                                   new BigDecimal(df.format(cummulativeAmt)));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(cumuAmt);

                    // set Qty
                    double cummulativeQty = cummulativeAmt / contractLneRate;
                    r.setAttribute("CumTotQty",
                                   new BigDecimal(df.format(cummulativeQty)));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(cumuQty);

                    // setting Current
                    double previousQty =
                        r.getAttribute("PrevTotQty") == null ? 0 :
                        Double.parseDouble(r.getAttribute("PrevTotQty").toString());
                    double previousPer =
                        r.getAttribute("PrevPerc") == null ? 0 :
                        Double.parseDouble(r.getAttribute("PrevPerc").toString());
                    double previousAmt =
                        r.getAttribute("PrevAmount") == null ? 0 :
                        Double.parseDouble(r.getAttribute("PrevAmount").toString());

                    double currentQty = cummulativeQty - previousQty;
                    double currentPre = cummulativePer - previousPer;
                    double currentAmt = cummulativeAmt - previousAmt;
                    r.setAttribute("CurrTotQty",
                                   new BigDecimal(df.format(currentQty)));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(currQty);
                    r.setAttribute("CurrPerc",
                                   new BigDecimal(df.format(currentPre)));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(currPer);
                    r.setAttribute("CurrAmount",
                                   new BigDecimal(df.format(currentAmt)));
                    AdfFacesContext.getCurrentInstance().addPartialTarget(currAmt);

                    // Set Tax Amount
                    if (taxRate == 0) {
                        r.setAttribute("TaxAmount",
                                       new BigDecimal(df.format(0)));
                        AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                    } else {
                        double taxAmt = (currentAmt * taxRate) / 100;
                        r.setAttribute("TaxAmount",
                                       new BigDecimal(df.format(taxAmt)));
                        AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                    }
                }
            }
            AdfFacesContext.getCurrentInstance().addPartialTarget(t1);
            paymentType.setDisabled(Boolean.TRUE);
            AdfFacesContext.getCurrentInstance().addPartialTarget(paymentType);
            onClickCalculateAmount();
            this.getP2().hide();
        } else {
            JSFUtils.addFacesErrorMessage("Payment Type: Final can't be created for this Contract. Please create a Payment Type: Interim");
        }
    }


    public void setPrevOthCharge(RichOutputText prevOthCharge) {
        this.prevOthCharge = prevOthCharge;
    }

    public RichOutputText getPrevOthCharge() {
        return prevOthCharge;
    }

    public void setTotOthCharge(RichOutputText totOthCharge) {
        this.totOthCharge = totOthCharge;
    }

    public RichOutputText getTotOthCharge() {
        return totOthCharge;
    }


    public void setCurOthCharge(RichOutputText curOthCharge) {
        this.curOthCharge = curOthCharge;
    }

    public RichOutputText getCurOthCharge() {
        return curOthCharge;
    }

    public void onChangeAppDate(ValueChangeEvent valueChangeEvent) {
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
            if (valueChangeEvent.getNewValue() != null) {
                String contactPayTerm =
                    applicationHrdVO.getCurrentRow().getAttribute("ContactPayTerm") ==
                    null ? "0" :
                    applicationHrdVO.getCurrentRow().getAttribute("ContactPayTerm").toString();
                String num = contactPayTerm.replaceAll("[^0-9]", "");
                int number = Integer.parseInt(num);
                //System.err.println("number of Days: " + number);
                String n = Integer.toString(number);
                oracle.jbo.domain.Date str_date =
                    (oracle.jbo.domain.Date)valueChangeEvent.getNewValue();
                oracle.jbo.domain.Date paymentDate =
                    ADFDateUtils.addDayToOracleDate(str_date, number);
                //System.err.println("paymentDate-->" + paymentDate);
                applicationHrdVO.getCurrentRow().setAttribute("PaymentDueDate",
                                                              paymentDate);
                AdfFacesContext.getCurrentInstance().addPartialTarget(paymentDueDate);
            }
        }
    }

    public void calculateretrel() {
        double curretper =
            applicationHrdVO.getCurrentRow().getAttribute("CurRetRelPer") ==
            null ? 0 :
            Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("CurRetRelPer").toString());
        double totret =
            applicationHrdVO.getCurrentRow().getAttribute("totRet_TRNS") ==
            null ? 0 :
            Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("totRet_TRNS").toString());
        double prevret =
            applicationHrdVO.getCurrentRow().getAttribute("PerRetRel") ==
            null ? 0 :
            Double.parseDouble(applicationHrdVO.getCurrentRow().getAttribute("PerRetRel").toString());
        double retamount = 0;
        double diff = 0;
        //System.err.println("amount ==> " + curretper + " " + totret);
        retamount = (curretper * totret) / 100;
        //System.err.println("ret amount ==> " + retamount);
        //System.err.println("Preve ret ==>" + prevret + " " +
        //                           (prevret + retamount));
        diff = totret - (prevret + retamount);
        //System.err.println("difference ==> " + diff);
        if (diff < 0) {
            JSFUtils.addFacesInformationMessage("Please check the percentage");
        } else {
            applicationHrdVO.getCurrentRow().setAttribute("CurRetRel",
                                                          retamount);
        }
    }

    public void onChangeChargeType(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        //System.err.println("New update-->" + valueChangeEvent.getNewValue());
        if (valueChangeEvent.getNewValue().toString() != "0") {
            ViewObject otherChargVO =
                ADFUtils.findIterator("XxscPayApplOthChargesVO1Iterator").getViewObject();
            //System.err.println("/*/--" +
            //                               otherChargVO.getCurrentRow().getAttribute("ChargeType").toString());
            int result =
                checkType(otherChargVO.getCurrentRow().getAttribute("ChargeType").toString());
            //System.err.println("--===>" + result);
            if (result > 1) {
                JSFUtils.addFacesErrorMessage("Charge Type is already exits");
                otherChargVO.getCurrentRow().setAttribute("ChargeType", null);
                AdfFacesContext.getCurrentInstance().addPartialTarget(t7);
            }
        }
    }


    public int checkType(String Type) {
        String s2 = Type.toString();
        int count = 0;
        try {
            ViewObject otherChargVO =
                ADFUtils.findIterator("XxscPayApplOthChargesVO1Iterator").getViewObject();
            otherChargVO.executeQuery();
            if (otherChargVO.getEstimatedRowCount() > 1) {
                RowSetIterator rs = otherChargVO.createRowSetIterator(null);
                while (rs.hasNext()) {
                    Row r = rs.next();
                    //System.err.println(Type + "==COMP==" +
                    //                                       r.getAttribute("ChargeType").toString());
                    if (r.getAttribute("ChargeType") != null) {
                        //    //System.err.println("--charge type"+r.getAttribute("ChargeType").toString());
                        if (r.getAttribute("ChargeType").toString().equalsIgnoreCase(s2)) {
                            //  isDuplicate="Y";
                            count++;
                        }
                    }
                }
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public void setT7(RichTable t7) {
        this.t7 = t7;
    }

    public RichTable getT7() {
        return t7;
    }

    public void onClickAddAdvRec(ActionEvent actionEvent) {
        String ContHdrId =
            applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
            null ? "0" :
            applicationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
        ExtraAdvVO.setNamedWhereClauseParam("bv_hdr_id", ContHdrId);
        ExtraAdvVO.executeQuery();
        //System.err.println("Extra ADv==>" + ExtraAdvVO.getEstimatedRowCount());
        RowSetIterator rs = ExtraAdvVO.createRowSetIterator(null);
        while (rs.hasNext()) {
            Row r = rs.next();
            Row r1 = AdvancRecVO.createRow();
            //r1.setAttribute("ApplAdvId", r.getAttribute("ApplAdvId"));
            r1.setAttribute("AdvanceName", r.getAttribute("Name"));
            r1.setAttribute("AdvanceAmt", r.getAttribute("Amt"));
            r1.setAttribute("RecoveredAmt", r.getAttribute("PrevAmt"));
            AdvancRecVO.insertRow(r1);
        }

    }

    public void setBal_Adv_AMT(RichInputText bal_Adv_AMT) {
        this.bal_Adv_AMT = bal_Adv_AMT;
    }

    public RichInputText getBal_Adv_AMT() {
        return bal_Adv_AMT;
    }

    public void onClickBalCal(ValueChangeEvent valueChangeEvent) {
        double amount =
            Double.parseDouble(valueChangeEvent.getNewValue().toString());
        double totamt =
            AdvancRecVO.getCurrentRow().getAttribute("AdvanceAmt") == null ?
            0 :
            Double.parseDouble(AdvancRecVO.getCurrentRow().getAttribute("AdvanceAmt").toString());
        double prevamt =
            AdvancRecVO.getCurrentRow().getAttribute("RecoveredAmt") == null ?
            0 :
            Double.parseDouble(AdvancRecVO.getCurrentRow().getAttribute("RecoveredAmt").toString());
        double bal = 0;
        bal = totamt - (prevamt + amount);
        AdvancRecVO.getCurrentRow().setAttribute("BalanceAmt", bal);
    }

    public void setCb9(RichCommandButton cb9) {
        this.cb9 = cb9;
    }

    public RichCommandButton getCb9() {
        return cb9;
    }

    public void setApplPayTerm(RichSelectOneChoice applPayTerm) {
        this.applPayTerm = applPayTerm;
    }

    public RichSelectOneChoice getApplPayTerm() {
        return applPayTerm;
    }

    /**
     *curAdvRecPercentSetting
     * @param valueChangeEvent
     * @throws SQLException
     */

    public void curAdvRecPercentSetting(ValueChangeEvent valueChangeEvent) throws SQLException {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {
            double contLneAmt =
                currAmt.getValue() == null ? 0 : Double.parseDouble(currAmt.getValue().toString());
            double currentAmount =
                valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
            double currentPercen = (currentAmount / contLneAmt) * 100;
            //System.err.println("current percentage"+currentPercen);
            Number curAdvperc = new Number(currentPercen);
            //System.err.println("current percentage"+curAdvperc);
            applicationLineVO.getCurrentRow().setAttribute("AdvRecPer",
                                                           curAdvperc);
            AdfFacesContext.getCurrentInstance().addPartialTarget(advrecperc);
            //System.err.println("current percentage ended"+ applicationLineVO.getCurrentRow().getAttribute("AdvRecPer"));

        }
    }

    public void curentRetention() throws SQLException {
        RowSetIterator rs = applicationLineVO.createRowSetIterator(null);
        double sum = 0;
        while (rs.hasNext()) {
            Row r = rs.next();
            //            sum += Double.parseDouble( r.getAttribute("CurRetRecAmount").toString());
            sum +=
Double.parseDouble(r.getAttribute("CurRetRecAmount") != null ?
                   r.getAttribute("CurRetRecAmount").toString() : "0.0");
        }
        System.err.println("Inside curentRetention method"+sum);
        applicationHrdVO.getCurrentRow().setAttribute("CurRet", sum);
        double cur_app =
            CurApplication.getValue() == null ? 0 : Double.parseDouble(CurApplication.getValue().toString());

        double percentage = (sum / cur_app) * 100;
        //            Number curadvPerc=new Number(percentage);
        double curadvPerc = percentage;
        applicationHrdVO.getCurrentRow().setAttribute("Curretper", curadvPerc);
        //            applicationHrdVO.getCurrentRow().setAttribute("Curretper",new BigDecimal(df.format(curadvPerc)));
        AdfFacesContext.getCurrentInstance().addPartialTarget(CurRet);
    }

    public void setAdvrecperc(RichInputText advrecperc) {
        this.advrecperc = advrecperc;
    }

    public RichInputText getAdvrecperc() {
        return advrecperc;
    }

    public void setRet_rec_perc_new(RichInputText ret_rec_perc_new) {
        this.ret_rec_perc_new = ret_rec_perc_new;
    }

    public RichInputText getRet_rec_perc_new() {
        return ret_rec_perc_new;
    }

    /**
     *curRetRecPercenSet
     * @param valueChangeEvent
     */
    public void curRetRecPercenSet(ValueChangeEvent valueChangeEvent) throws SQLException {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        if (valueChangeEvent.getNewValue() != null) {
            double contLneAmt =
                currAmt.getValue() == null ? 0 : Double.parseDouble(currAmt.getValue().toString());
            double currentAmount =
                valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
            double currentPercen = (currentAmount / contLneAmt) * 100;
            //System.err.println("current percentage"+currentPercen);
            Number curRetperc = new Number(currentPercen);
            //System.err.println("current percentage"+curRetperc);
            applicationLineVO.getCurrentRow().setAttribute("RetRecPer",
                                                           curRetperc);
            AdfFacesContext.getCurrentInstance().addPartialTarget(ret_rec_perc_new);
            //System.err.println("current percentage ended"+ applicationLineVO.getCurrentRow().getAttribute("RetRecPer"));

        }
    }

    public void setCur_Adv_Rec_Perc(RichInputText cur_Adv_Rec_Perc) {
        this.cur_Adv_Rec_Perc = cur_Adv_Rec_Perc;
    }

    public RichInputText getCur_Adv_Rec_Perc() {
        return cur_Adv_Rec_Perc;
    }

    public void setCur_Ret_Percen(RichInputText cur_Ret_Percen) {
        this.cur_Ret_Percen = cur_Ret_Percen;
    }

    public RichInputText getCur_Ret_Percen() {
        return cur_Ret_Percen;
    }

    public void onClickManualApprove(ActionEvent actionEvent) {
        applicationHrdVO.getCurrentRow().setAttribute("ApprovalStatus", "APR");
    }

    public void doVldtSupInvNum(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        String supInvNo = "";
        if (valueChangeEvent.getNewValue() != null) {
            supInvNo =
                    valueChangeEvent.getNewValue() == null ? "" : valueChangeEvent.getNewValue().toString();
            ViewCriteria vc = appHdrRoVo.createViewCriteria();
            ViewCriteriaRow vcr = vc.createViewCriteriaRow();
            vcr.setAttribute("SupplierInvoiceNum", supInvNo);
            vc.addRow(vcr);
            appHdrRoVo.applyViewCriteria(vc);
            appHdrRoVo.executeQuery();
            if (appHdrRoVo.getEstimatedRowCount() > 0) {
                applicationHrdVO.getCurrentRow().setAttribute("SupplierInvoiceNum",
                                                              null);
                AdfFacesContext.getCurrentInstance().addPartialTarget(it11);
                JSFUtils.addFacesErrorMessage("Kindly check the supplier invoice number is duplicate !!!");
            }
        }
    }

    public void setIt11(RichInputText it11) {
        this.it11 = it11;
    }

    public RichInputText getIt11() {
        return it11;
    }

    public void onClickOfAdvRecAmt(ValueChangeEvent valueChangeEvent) {
        double old_value =
            valueChangeEvent.getOldValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getOldValue().toString());
        double new_value =
            valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
        if (old_value != new_value) {
            if (valueChangeEvent.getNewValue() != null) {
                valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        double currentAmt =
        applicationLineVO.getCurrentRow().getAttribute("CurrAmount") ==
        null ? 0 :
        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("CurrAmount").toString());
        double cur_adv_rec_amount =
        applicationLineVO.getCurrentRow().getAttribute("CurAdvRecAmount") ==
        null ? 0 :
        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("CurAdvRecAmount").toString());
        double cur_ret_rec_amount =
        applicationLineVO.getCurrentRow().getAttribute("CurRetRecAmount") ==
        null ? 0 :
        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("CurRetRecAmount").toString());
        double taxRate =
        applicationLineVO.getCurrentRow().getAttribute("TaxRate") ==
        null ? 0 :
        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("TaxRate").toString());
        /**
        * tax_amount 01-09-2023 added as requested by arun
        */
        double final_tax_amount =
        currentAmt - cur_adv_rec_amount - cur_ret_rec_amount;

        double taxAmt = (final_tax_amount * taxRate) / 100;
        applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                   new BigDecimal(df.format(taxAmt)));

//                System.err.println("currentAmt"+currentAmt);
//                System.err.println("cur_adv_rec_amount"+cur_adv_rec_amount);
//                System.err.println("CurRetRecAmount"+cur_ret_rec_amount);
//                System.err.println("taxRate"+taxRate);
//                System.err.println("taxAmt"+taxAmt);



        AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
            }
        }
        
    }

    public void onClickCurRetAmount(ValueChangeEvent valueChangeEvent) {
                double old_value =
                    valueChangeEvent.getOldValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getOldValue().toString());
                double new_value =
                    valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
                if (old_value != new_value) {
                    if (valueChangeEvent.getNewValue() != null) {
                        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        double currentAmt =
        applicationLineVO.getCurrentRow().getAttribute("CurrAmount") ==
        null ? 0 :
        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("CurrAmount").toString());
        double cur_adv_rec_amount =
        applicationLineVO.getCurrentRow().getAttribute("CurAdvRecAmount") ==
        null ? 0 :
        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("CurAdvRecAmount").toString());
        double cur_ret_rec_amount =
        applicationLineVO.getCurrentRow().getAttribute("CurRetRecAmount") ==
        null ? 0 :
        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("CurRetRecAmount").toString());
        double taxRate =
        applicationLineVO.getCurrentRow().getAttribute("TaxRate") ==
        null ? 0 :
        Double.parseDouble(applicationLineVO.getCurrentRow().getAttribute("TaxRate").toString());
        /**
        * tax_amount 01-09-2023 added as requested by arun
        */
        double final_tax_amount =
        currentAmt - cur_adv_rec_amount - cur_ret_rec_amount;

        double taxAmt = (final_tax_amount * taxRate) / 100;
        applicationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                   new BigDecimal(df.format(taxAmt)));


        AdfFacesContext.getCurrentInstance().addPartialTarget(currTaxAmt);
                    }
                }
            }

    public void onClickAmendment(ActionEvent actionEvent) {
        ViewObject certHdrvo =
        ADFUtils.findIterator("XxscCertificationHeadersVO1Iterator").getViewObject();
                    ViewCriteria vc = certHdrvo.createViewCriteria();
        ViewCriteriaRow vcr = vc.createViewCriteriaRow();
        vcr.setAttribute("ApplHeaderId", applicationHrdVO.getCurrentRow().getAttribute("ApplHeaderId"));
        vc.addRow(vcr);
        certHdrvo.applyViewCriteria(vc);
        certHdrvo.executeQuery();
        
        if (certHdrvo.getEstimatedRowCount() == 0) {
            applicationHrdVO.getCurrentRow().setAttribute("ApprovalStatus","TRNS_DRAFT");
            ADFUtils.findOperation("Commit").execute();
            JSFUtils.addFacesInformationMessage("Application amended successfully");
        } 
                    else
           {
                  String Cert_no=certHdrvo.first().getAttribute("CertificationNumber")==
                              null ? "0" :certHdrvo.first().getAttribute("CertificationNumber").toString();
                       JSFUtils.addFacesInformationMessage("Application cannot be amended as the "+Cert_no+ " is already generated.");
                       
              }
        
    }


    public void setCur_retrec_amount(RichInputText cur_retrec_amount) {
        this.cur_retrec_amount = cur_retrec_amount;
    }

    public RichInputText getCur_retrec_amount() {
        return cur_retrec_amount;
    }
}

package backing;

import Utils.ADFApproval;
import Utils.ADFUtils;

import Utils.DBUtils;
import Utils.JSFUtils;


import Utils.MailServices;
import Utils.MailTemplates;

import Utils.RTFUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.math.BigDecimal;

import java.math.RoundingMode;

import java.net.MalformedURLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.DateFormat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.servlet.ServletContext;

import javax.servlet.http.HttpServletResponse;

import javax.sql.DataSource;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;

import okhttp3.Request;
import okhttp3.RequestBody;

import okhttp3.Response;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandImageLink;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;

//import oracle.apps.xdo.template.FOProcessor;
//import oracle.apps.xdo.template.RTFProcessor;
import oracle.xdo.template.FOProcessor;
import oracle.xdo.template.RTFProcessor;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;

import oracle.jbo.domain.BlobDomain;

import oracle.jbo.domain.Number;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewObjectImpl;

import oracle.jdbc.OracleTypes;

import org.apache.commons.io.IOUtils;
import org.apache.myfaces.trinidad.model.UploadedFile;

import org.json.JSONObject;

import subcontract.view.backing.WEBINF.oracle.apps.uikit.Fragments.SubmitARInvoice;
import subcontract.view.backing.WEBINF.oracle.apps.uikit.Fragments.SubmitContractLines;
import subcontract.view.backing.WEBINF.oracle.apps.uikit.Fragments.SubmitForApproval;
import subcontract.view.backing.WEBINF.oracle.apps.uikit.Fragments.SubmitProjectBilling;
import subcontract.view.backing.WEBINF.oracle.apps.uikit.Fragments.SubmitUpdateContractLines;

public class CertificationInfo {
    private RichTable t2;
    private RichPopup certificationCancelPopUp;
    private RichInputText qty;
    private RichInputText rate;
    private RichInputText amt;
    private RichInputText uom;
    private RichInputText hdrContAmt;
    private RichInputListOfValues contractNumber;
    private RichInputText curCertification;
    private RichSelectOneChoice applHeaderNumber;
    private RichInputText prevApplication;
    private RichInputText curCert;
    private RichInputText prevPayAmount;
    private RichInputText curPayAmount;
    private RichInputText totalAmount;
    private RichInputText prevAdvRec;
    private RichInputText curAdvRev;
    private RichInputText balanceAdvRec;
    private RichInputText totalRet;
    private RichInputText prevRet;
    private RichInputText curRet;
    private RichInputText balanceRet;
    private RichSelectOneChoice paymentType;
    private RichInputText trans_adv_rec;
    private RichInputText trans_ret_amt;
    private RichInputText mat_Adv_amt;
    private RichInputText orgQty;
    private RichInputText orgRate;
    private RichInputText orgAmt;
    private RichInputText certPrevQty;
    private RichInputText certPrevPer;
    private RichInputText certPrevAmt;
    private RichInputText certCurrQty;
    private RichInputText certCurrPer;
    private RichInputText certCurrAmt;
    private RichInputText certCummQty;
    private RichInputText certCummPer;
    private RichInputText certCummAmt;
    private RichInputText appliPrevQty;
    private RichInputText appliPrevPer;
    private RichInputText appliPrevAmt;
    private RichInputText appliCurrQty;
    private RichInputText appliCurrPer;
    private RichInputText appliCurrAmt;
    private RichInputText appliCummQty;
    private RichInputText appliCummPer;
    private RichInputText appliCummAmt;
    private RichInputText ret_per;
    private RichInputText bal_cont_amt;
    private RichInputText tot_Cont_Amt;
    private RichInputText cum_Appl;
    private RichInputText cum_Adv_Rec;
    private RichInputText cum_Ret;
    private RichInputText bal_mat_rec;
    private RichInputText cur_mat_adv_amt;
    private RichInputText cum_mat_adv_amt;
    private RichInputText tot_mat_adv_amt;
    private RichInputText prev_mat_adv_rec;
    private RichInputText certCurrTaxAmt;
    private RichOutputText curPayTaxAmount;
    private RichOutputText curPayTaxAmount1;
    private RichOutputText taxRateApp;
    private RichInputText contra_Charge;
    private RichInputText penality_Charge;
    private RichPopup p3;
    private RichInputText rejectValue;
    private RichInputText cur_mat_on_site_rec;
    private RichPopup p4;
    private RichInputText approValue;
    private RichInputText ecpTotAmt;
    private RichInputFile if1;
    private RichTable t7;
    private RichOutputText proId;
    private RichTable t9;
    private RichOutputText curOth;
    private RichOutputText totOth;
    private RichOutputText prevOth;
    private RichOutputText curOtherCharge;
    private RichPopup invoiceP4;
    private RichInputText cur_Adv_Rec_Perc;
    private RichInputText curAdvRec;
    private RichInputText curReten;
    private RichSelectOneChoice aprstatus;
    private RichOutputText url;
    private RichCommandImageLink cil7;
    private RichPopup certificationDeletePopup;
    private RichInputText cur_retrec_amount;

    public CertificationInfo() {
    }


    ViewObject certificationHrdVO =
        ADFUtils.findIterator("XxscCertificationHeadersVO1Iterator").getViewObject();
    ViewObject certificationLineVO =
        ADFUtils.findIterator("XxscCertificationLinesVO1Iterator").getViewObject();
    ViewObject CertificationOthChargesVO =
        ADFUtils.findIterator("XxscCertificationOthChargesVO1Iterator").getViewObject();

    ViewObject lookupVO =
        ADFUtils.findIterator("Lookup_ROVO1Iterator").getViewObject();

    ViewObject contractLineVO =
        ADFUtils.findIterator("XxscContractLinesVO2Iterator").getViewObject();
    ViewObject searchCertificationVO =
        ADFUtils.findIterator("certificationSearchROVO1Iterator").getViewObject();
    ViewObject certificationLineVO2 =
        ADFUtils.findIterator("XxscCertificationLinesVO2Iterator").getViewObject();
    ViewObject certificationHrdVO2 =
        ADFUtils.findIterator("XxscCertificationHeadersVO2Iterator").getViewObject();
    ViewObject PaymentApplLinesVO1 =
        ADFUtils.findIterator("XxscPayApplLinesVO1Iterator").getViewObject();
    ViewObject PayApplOthChargesVO1 =
        ADFUtils.findIterator("XxscPayApplOthChargesVO1Iterator").getViewObject();
    ViewObject PrevAdvAndRetCal =
        ADFUtils.findIterator("PrevAdvAndRetCalcROVO1Iterator").getViewObject();
    ViewObject functionVO =
        ADFUtils.findIterator("FunctionROVO1Iterator").getViewObject();

    ViewObject attachVO =
        ADFUtils.findIterator("XxscAttachmentVO1Iterator").getViewObject();
    ViewObject attachPoVO =
        ADFUtils.findIterator("XxscAttachmentVO2Iterator").getViewObject();
    ViewObject AdvanceVO =
        ADFUtils.findIterator("XxscCertAdvanceDtlsVO1Iterator").getViewObject();
    ViewObject AdvanceRecVO =
        ADFUtils.findIterator("XxscCertAdvRecDtlsVO2Iterator").getViewObject();

    ViewObject invoiceVO =
        ADFUtils.findIterator("invoiceStatusROVO1Iterator").getViewObject();
    //    =====================================================================================
    //   =========================================================================================

    /*
    public void onClickSubmitForApproval(ActionEvent actionEvent) {
        try {
            if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy") ||
                ADFContext.getCurrent().getSessionScope().get("page").equals("certificationBuy")) {
                String url =
                    ADFUtils.getFunctionDetails("BUY_CUST_CERT", "WfProcessUrl");
                // "http://141.144.50.225/soa-infra/services/default/CertSellApproval/certsellapprovalprocess_client_ep?WSDL";
                SubmitForApproval app = new SubmitForApproval("", "", "");
                String payload = prepareApprovalPayload();
                String type = "Certification";
                app.getAndPushOrder(payload, url, type);
            } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell") ||
                       ADFContext.getCurrent().getSessionScope().get("page").equals("certificationSell")) {
                String url =
                    ADFUtils.getFunctionDetails("SELL_CUST_CERT", "WfProcessUrl");
                // "http://141.144.50.225/soa-infra/services/default/CertSellApproval/certsellapprovalprocess_client_ep?WSDL";
                SubmitForApproval app = new SubmitForApproval("", "", "");
                String payload = prepareApprovalPayload();
                String type = "Certification";
                app.getAndPushOrder(payload, url, type);
            }

        } catch (Exception e) {
            //System.err.println("====EXE===APP====" + e.toString());
        }
    }
*/

    public String prepareApprovalPayload() {
        String xml = "";
        ViewObject headerVO =
            ADFUtils.findIterator("XxscCertificationHeadersVO1Iterator").getViewObject();
        xml += "<soapenv:Body>\n" +
                "      <cer:certification>\n" +
                "         <cer:certHeader>\n" +
                "            <cer:functionid>" +
                headerVO.getCurrentRow().getAttribute("FuncId") +
                "</cer:functionid>\n" +
                "            <cer:cert_header_id>" +
                headerVO.getCurrentRow().getAttribute("CertHeaderId") +
                "</cer:cert_header_id>\n" +
                "         </cer:certHeader>\n" +
                "      </cer:certification>\n" +
                "   </soapenv:Body>";
        return xml;
    }

    /*
    public void onClickSubmitCertification(ActionEvent actionEvent) {
        try {
            //System.err.println("==ST==");
            ViewObject headerVO =
                ADFUtils.findIterator("XxscCertificationHeadersVO1Iterator").getViewObject();
            if (headerVO.getCurrentRow() != null) {
                //System.err.println("===PAy===" +
                                   headerVO.getCurrentRow().getAttribute("PaymentType"));
                ViewObject lineVO =
                    ADFUtils.findIterator("XxscCertificationLinesVO1Iterator").getViewObject();
                if (headerVO.getCurrentRow().getAttribute("PaymentType") !=
                    null &&
                    headerVO.getCurrentRow().getAttribute("PaymentType").toString().equalsIgnoreCase("Advance")) {
                    double advAmount =
                        Double.parseDouble(headerVO.getCurrentRow().getAttribute("CurAdvRec").toString());
                    if (advAmount > 0) {
                        submitARInvoice(advAmount);
                    }
                } else if (headerVO.getCurrentRow().getAttribute("PaymentType") !=
                           null &&
                           headerVO.getCurrentRow().getAttribute("PaymentType").toString().equalsIgnoreCase("Interim"))
                    if (lineVO.getEstimatedRowCount() > 0) {
                        submitProjectBilling();
                    }


            }
        } catch (Exception e) {
            //System.err.println("====EXE==" + e.toString());
        }

    }
*/

    public void submitARInvoice(double advAmount) {
        try {
            String response = null;
            SubmitARInvoice exp =
                new SubmitARInvoice("egpt-test", "prabu", "welcome123");
            String payload = prepareAdvanceARPayload(advAmount);
            // //System.err.println("prepareAdvanceARPayload====" + payload);
            String retrunXML = exp.getAndPushOrder(payload);
            //System.err.println("=====RET=====" + retrunXML);
            String sub = retrunXML.substring(0, 3);
            if (!(sub.equals("ERR"))) {
                JSFUtils.addFacesInformationMessage("Advance AR Invoiec Created Successfully.");
            } else {
                response = retrunXML.substring(3);
                //System.err.println("====ERROR=PAYLOAD==" + response);
            }
        } catch (Exception e) {
            //System.err.println("====EXE===MER====" + e.toString());
        }
    }

    public void submitProjectBilling() {
        try {
            String response = null;
            SubmitProjectBilling bill =
                new SubmitProjectBilling("egpt-test", "rahul", "welcome123");
            ViewObject lineVO =
                ADFUtils.findIterator("XxscCertificationLinesVO1Iterator").getViewObject();
            RowSetIterator rs = lineVO.createRowSetIterator("");
            while (rs.hasNext()) {
                Row r = rs.next();
                //System.err.println("====values===" +
                //                                   r.getAttribute("Trans_ConLine_Number") +
                //                                   r.getAttribute("Trans_ConLine_ProjectNum") +
                //                                   r.getAttribute("Trans_ConLine_TaskNum") +
                //                                   r.getAttribute("Trans_ConLine_ItemDesc") +
                //                                   r.getAttribute("CurrAmount"));
                String payload =
                    prepareProjectBillingPayload(r.getAttribute("Trans_ConLine_Number"),
                                                 r.getAttribute("Trans_ConLine_ProjectNum"),
                                                 r.getAttribute("Trans_ConLine_TaskNum"),
                                                 r.getAttribute("Trans_ConLine_ItemDesc"),
                                                 r.getAttribute("CurrAmount"));
                String retrunXML = bill.getAndPushOrder(payload);
                ////System.err.println("=====RET=====" + retrunXML);
                String sub = retrunXML.substring(0, 3);
                if (!(sub.equals("ERR"))) {
                    JSFUtils.addFacesInformationMessage("Project Billing Created Successfully.");
                } else {
                    response = retrunXML.substring(3);
                    //System.err.println("====ERROR=PAYLOAD==" + response);
                }
            }
        } catch (Exception e) {
            //System.err.println("====EXE===UP====" + e.toString());
        }
    }
    //header vo

    public String prepareAdvanceARPayload(double advAmount) {

        String xml = "";
        ViewObject headerVO =
            ADFUtils.findIterator("XxscCertificationHeadersVO1Iterator").getViewObject();
        if (headerVO.getCurrentRow() != null) {
            Row r = headerVO.getCurrentRow();
            Date date = new Date(); //
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            xml += "<soapenv:Body>\n" +
                    "      <typ:createSimpleInvoice>\n" +
                    "         <typ:invoiceHeaderInformation>\n" +
                    "            <inv:BusinessUnit>";
            xml +=
r.getAttribute("BusniessUnit") != null ? r.getAttribute("BusniessUnit") : "";
            xml += "</inv:BusinessUnit>\n" +
                    "            <inv:TransactionSource>Distributed Order Orchestration</inv:TransactionSource>\n" +
                    "            <inv:TransactionType>Invoice</inv:TransactionType>\n" +
                    "            <inv:TrxDate>" + dateFormat.format(date) +
                    "</inv:TrxDate>\n" +
                    "            <inv:GlDate>" + dateFormat.format(date) +
                    "</inv:GlDate>\n";

            xml += "            <inv:BillToCustomerName>";
            xml +=
r.getAttribute("Trans_customer_name") != null ? r.getAttribute("Trans_customer_name") :
"";
            xml += "</inv:BillToCustomerName>\n" +
                    "            <inv:BillToAccountNumber>";
            xml +=
r.getAttribute("Trans_customer_number") != null ? r.getAttribute("Trans_customer_number") :
"";
            xml += "</inv:BillToAccountNumber>\n" +
                    "            <inv:PaymentTermsName>IMMEDIATE</inv:PaymentTermsName>\n" +
                    "            <inv:InvoiceCurrencyCode>";
            xml +=
r.getAttribute("Trans_Currency") != null ? r.getAttribute("Trans_Currency") :
"";
            xml += "</inv:InvoiceCurrencyCode>\n" +
                    "            <inv:InvoiceLine>\n" +
                    "               <inv:LineNumber>1</inv:LineNumber>\n" +
                    "               <inv:Description>Advance Payment for ";
            xml +=
r.getAttribute("ContractNum") != null ? r.getAttribute("ContractNum") : "";
            xml += "</inv:Description>\n" +
                    "               <inv:Quantity unitCode=\"\">1</inv:Quantity>\n" +
                    "               <inv:UnitSellingPrice currencyCode=\"";
            xml +=
r.getAttribute("Trans_Currency") != null ? r.getAttribute("Trans_Currency") :
"";
            xml += "\">";
            xml += advAmount;
            xml += "</inv:UnitSellingPrice>\n" +
                    "            </inv:InvoiceLine>\n" +
                    "         </typ:invoiceHeaderInformation>\n" +
                    "      </typ:createSimpleInvoice>\n" +
                    "   </soapenv:Body>";
        }

        // //System.err.println("====XML DATA===" + xml);
        return xml;

    }
    //line vo

    public String prepareProjectBillingPayload(Object trans_ConLine_Number,
                                               Object trans_ConLine_ProjectNum,
                                               Object trans_ConLine_TaskNum,
                                               Object trans_ConLine_ItemDesc,
                                               Object currAmount) {
        String xmlPayload = "";
        ViewObject headerVO =
            ADFUtils.findIterator("XxscCertificationHeadersVO1Iterator").getViewObject();
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (headerVO.getCurrentRow() != null) {
            try {
                xmlPayload += "<soapenv:Body>\n" +
                        "      <typ:createProjectBillingEvent>\n" +
                        "         <typ:projectBillingEvent>\n" +
                        "            <bil:EventId>";
                xmlPayload += eventSequences();
                xmlPayload += "</bil:EventId>\n" +
                        "            <bil:ContractTypeName>Sell BoQ Lines</bil:ContractTypeName>\n" +
                        "            <bil:ContractNumber>";

                xmlPayload +=
                        headerVO.getCurrentRow().getAttribute("ContractNum") !=
                        null ?
                        headerVO.getCurrentRow().getAttribute("ContractNum") :
                        "";
                xmlPayload += "</bil:ContractNumber>\n" +
                        "            <bil:ContractLineNumber>";

                xmlPayload +=
                        trans_ConLine_Number != null ? trans_ConLine_Number :
                        "";
                xmlPayload += "</bil:ContractLineNumber>\n" +
                        "            <bil:OrganizationName>";
                xmlPayload +=
                        headerVO.getCurrentRow().getAttribute("BusniessUnit") !=
                        null ?
                        headerVO.getCurrentRow().getAttribute("BusniessUnit") :
                        "";
                xmlPayload += "</bil:OrganizationName>\n" +
                        "            <bil:EventTypeName>Invoice Progress</bil:EventTypeName>\n" +
                        "            <bil:EventDescription>";
                xmlPayload += trans_ConLine_ItemDesc;
                xmlPayload += "</bil:EventDescription>\n" +
                        "            <bil:CompletionDate>";
                //System.err.println("===completion date====" +
                //                                   headerVO.getCurrentRow().getAttribute("CertificationDate"));
                xmlPayload +=
                        headerVO.getCurrentRow().getAttribute("CertificationDate") !=
                        null ?
                        headerVO.getCurrentRow().getAttribute("CertificationDate") :
                        dateFormat.format(date);
                xmlPayload += "</bil:CompletionDate>\n" +
                        "            <bil:ProjectNumber>";
                xmlPayload += trans_ConLine_ProjectNum;
                xmlPayload += "</bil:ProjectNumber>\n" +
                        "            <bil:TaskNumber>";
                xmlPayload += trans_ConLine_TaskNum;
                xmlPayload += "</bil:TaskNumber>\n" +
                        "            <bil:BillTrnsAmount currencyCode=\"";
                xmlPayload +=
                        headerVO.getCurrentRow().getAttribute("Trans_Currency") !=
                        null ?
                        headerVO.getCurrentRow().getAttribute("Trans_Currency") :
                        "";
                xmlPayload += "\">";
                xmlPayload += currAmount;
                xmlPayload += "</bil:BillTrnsAmount>\n" +
                        "         </typ:projectBillingEvent>\n" +
                        "      </typ:createProjectBillingEvent>\n" +
                        "   </soapenv:Body>\n";
            } catch (Exception e) {

            }
            //System.err.println("====XML DATA===" + xmlPayload);

        }
        return xmlPayload;

    }

    //    =====================================================================================
    //   =========================================================================================
    /*
    public void onChangeContractNum(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        //System.err.println("--Page--"+ADFContext.getCurrent().getSessionScope().get("page"));
        if(ADFContext.getCurrent().getSessionScope().get("page").equals("certificationSell")){
            //System.err.println("---SELL--");
        //            int certContID=certificationHrdVO.getCurrentRow().getAttribute("ContHeaderId")==null?0:Integer.parseInt(certificationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString());
        //            int certVersion=certificationHrdVO.getCurrentRow().getAttribute("Version")==null?0:Integer.parseInt(certificationHrdVO.getCurrentRow().getAttribute("Version").toString());
        //            ADFContext.getCurrent().getSessionScope().put("HrdID", certContID);
        //            ADFContext.getCurrent().getSessionScope().put("VerID", certVersion);

        }else if(ADFContext.getCurrent().getSessionScope().get("page").equals("certificationBuy")){
            if(valueChangeEvent.getOldValue()!=null){
                   // Deleting old Records
                    RowSetIterator certificationRs=certificationLineVO.createRowSet(null);
                    while(certificationRs.hasNext()){
                        Row r=certificationRs.next();
                        r.remove();
                    }
                    paymentType.setValue("");
                    AdfFacesContext.getCurrentInstance().addPartialTarget(paymentType);
                    if(valueChangeEvent.getNewValue()!=null){
                    int certContID=certificationHrdVO.getCurrentRow().getAttribute("ContHeaderId")==null?0:Integer.parseInt(certificationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString());
                      int certVersion=certificationHrdVO.getCurrentRow().getAttribute("Version")==null?0:Integer.parseInt(certificationHrdVO.getCurrentRow().getAttribute("Version").toString());
                    //          certificationHrdVO.getCurrentRow().getAttribute("ContHeaderId");
                    //          certificationHrdVO.getCurrentRow().getAttribute("Version");
                      //System.err.println("--contID---"+certContID+"-Version--"+certVersion);
                      // Filtering contract line VO
                      ViewCriteria  contractLineVC= contractLineVO.createViewCriteria();
                      ViewCriteriaRow contractLineVCRow = contractLineVC.createViewCriteriaRow();
                      contractLineVCRow.setAttribute("ContHeaderId", certContID);
                      contractLineVCRow.setAttribute("Version", certVersion);
                      contractLineVC.addRow(contractLineVCRow);
                      contractLineVO.applyViewCriteria(contractLineVC);
                      contractLineVO.executeQuery();
                      //System.err.println("==COUNT==" +contractLineVO.getEstimatedRowCount());
                      // Filtering Contract Line
                      RowSetIterator rs = contractLineVO.createRowSetIterator(null);
                      while (rs.hasNext()) {
                          Row contracrLineRow = rs.next();
                          Object hid = contracrLineRow.getAttribute("ContHeaderId");
                          Object lid = contracrLineRow.getAttribute("ContLineId");
                          Object version = contracrLineRow.getAttribute("Version");
                          //System.err.println("HID==" + hid + "LID===" + lid+"==="+version);
                    // Filtering Certificatio Line---check contract line=0 or not
                          ViewCriteria certiVO=certificationLineVO2.createViewCriteria();
                          ViewCriteriaRow certiVCR=certiVO.createViewCriteriaRow();
                          certiVCR.setAttribute("ContLineId", lid);
                          //certiVCR.setAttribute("Version", version);
                          certiVO.addRow(certiVCR);
                          certificationLineVO2.applyViewCriteria(certiVO);
                          certificationLineVO2.executeQuery();
                          //System.err.println("Total Certification Count--"+certificationLineVO2.getEstimatedRowCount());
                          long TotalRowCertiCount=certificationLineVO2.getEstimatedRowCount();
                          //Equal to 0
                          if(certificationLineVO2.getEstimatedRowCount()==0){
                              //Certification line Row adding
                              Row certificaLineRow = certificationLineVO.createRow();
                              certificaLineRow.setAttribute("ContractHeaderId", hid);
                              certificaLineRow.setAttribute("ContLineId", lid);
                              certificaLineRow.setAttribute("Version", version);
                              certificaLineRow.setAttribute("CertHeaderId", certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId"));
                              certificaLineRow.setAttribute("OrgId", certificationHrdVO.getCurrentRow().getAttribute("OrgId"));
                              certificationLineVO.insertRow(certificaLineRow);
                              certificationLineVO.executeQuery();
                              AdfFacesContext.getCurrentInstance().addPartialTarget(t2);
                              //System.err.println("Certification Line inserted: certification Count=0");
                          }else{
                              RowSetIterator certRS=certificationLineVO2.createRowSet(null);
                              double curQty=0;
                              double curRte=0;
                              double curAmt=0;
                              double totalQty=0;
                              double totalRte=0;
                              double totalAmt=0;
                              long count=0;
                              while(certRS.hasNext()){
                                  Row certRow=certRS.next();
                                  if(certRow.getAttribute("PrevAmount")==null){
                                      curQty=certRow.getAttribute("CurrTotQty")==null?0:Double.parseDouble(certRow.getAttribute("CurrTotQty").toString());
                                      curRte=certRow.getAttribute("CurrPerc")==null?0:Double.parseDouble(certRow.getAttribute("CurrPerc").toString());
                                      curAmt=certRow.getAttribute("CurrAmount")==null?0:Double.parseDouble(certRow.getAttribute("CurrAmount").toString());
                                  }else{
                                      curQty=certRow.getAttribute("PrevTotQty")==null?0:Double.parseDouble(certRow.getAttribute("PrevTotQty").toString());
                                      curRte=certRow.getAttribute("PrevPerc")==null?0:Double.parseDouble(certRow.getAttribute("PrevPerc").toString());
                                      curAmt=certRow.getAttribute("PrevAmount")==null?0:Double.parseDouble(certRow.getAttribute("PrevAmount").toString());
                                  }

                                  //System.err.println(curQty+"---"+curRte+"---"+curAmt);
                                  totalQty+=curQty;
                                  totalRte+=curRte;
                                  totalAmt+=curAmt;
                                  //System.err.println(totalQty+"----"+totalRte+"----"+totalAmt);
                                  count++;
                                  if(TotalRowCertiCount==count){
                                      Row certificaLineRow = certificationLineVO.createRow();
                                      certificaLineRow.setAttribute("ContractHeaderId", hid);
                                      certificaLineRow.setAttribute("ContLineId", lid);
                                      certificaLineRow.setAttribute("Version", version);
                                      certificaLineRow.setAttribute("CertHeaderId", certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId"));
                                      certificaLineRow.setAttribute("OrgId", certificationHrdVO.getCurrentRow().getAttribute("OrgId"));
                                      certificaLineRow.setAttribute("PrevTotQty", totalQty);
                                      certificaLineRow.setAttribute("PrevPerc", totalRte);
                                      certificaLineRow.setAttribute("PrevAmount", totalAmt);
                                      certificationLineVO.insertRow(certificaLineRow);
                                      certificationLineVO.executeQuery();
                                      AdfFacesContext.getCurrentInstance().addPartialTarget(t2);
                                      //System.err.println("Certification Line inserted");

                                  }

                              }
                          }
                      }
                    }
               }else{
                    if(valueChangeEvent.getNewValue()!=null){
                    int certContID=certificationHrdVO.getCurrentRow().getAttribute("ContHeaderId")==null?0:Integer.parseInt(certificationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString());
                      int certVersion=certificationHrdVO.getCurrentRow().getAttribute("Version")==null?0:Integer.parseInt(certificationHrdVO.getCurrentRow().getAttribute("Version").toString());
                    //          certificationHrdVO.getCurrentRow().getAttribute("ContHeaderId");
                    //          certificationHrdVO.getCurrentRow().getAttribute("Version");
                      //System.err.println("--contID---"+certContID+"-Version--"+certVersion);
                      // Filtering contract line VO
                      ViewCriteria  contractLineVC= contractLineVO.createViewCriteria();
                      ViewCriteriaRow contractLineVCRow = contractLineVC.createViewCriteriaRow();
                      contractLineVCRow.setAttribute("ContHeaderId", certContID);
                      contractLineVCRow.setAttribute("Version", certVersion);
                      contractLineVC.addRow(contractLineVCRow);
                      contractLineVO.applyViewCriteria(contractLineVC);
                      contractLineVO.executeQuery();
                      //System.err.println("==COUNT==" +contractLineVO.getEstimatedRowCount());
                      // Filtering Contract Line
                      RowSetIterator rs = contractLineVO.createRowSetIterator(null);
                      while (rs.hasNext()) {
                          Row contracrLineRow = rs.next();
                          Object hid = contracrLineRow.getAttribute("ContHeaderId");
                          Object lid = contracrLineRow.getAttribute("ContLineId");
                          Object version = contracrLineRow.getAttribute("Version");
                          //System.err.println("HID==" + hid + "LID===" + lid+"==="+version);
                    // Filtering Certificatio Line---check contract line=0 or not
                          ViewCriteria certiVO=certificationLineVO2.createViewCriteria();
                          ViewCriteriaRow certiVCR=certiVO.createViewCriteriaRow();
                          certiVCR.setAttribute("ContLineId", lid);
                          //certiVCR.setAttribute("Version", version);
                          certiVO.addRow(certiVCR);
                          certificationLineVO2.applyViewCriteria(certiVO);
                          certificationLineVO2.executeQuery();
                          //System.err.println("Total Certification Count--"+certificationLineVO2.getEstimatedRowCount());
                          long TotalRowCertiCount=certificationLineVO2.getEstimatedRowCount();
                          //Equal to 0
                          if(certificationLineVO2.getEstimatedRowCount()==0){
                              //Certification line Row adding
                              Row certificaLineRow = certificationLineVO.createRow();
                              certificaLineRow.setAttribute("ContractHeaderId", hid);
                              certificaLineRow.setAttribute("ContLineId", lid);
                              certificaLineRow.setAttribute("Version", version);
                              certificaLineRow.setAttribute("CertHeaderId", certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId"));
                              certificaLineRow.setAttribute("OrgId", certificationHrdVO.getCurrentRow().getAttribute("OrgId"));
                              certificationLineVO.insertRow(certificaLineRow);
                              certificationLineVO.executeQuery();
                              AdfFacesContext.getCurrentInstance().addPartialTarget(t2);
                              //System.err.println("Certification Line inserted: certification Count=0");
                          }else{
                              RowSetIterator certRS=certificationLineVO2.createRowSet(null);
                              double curQty=0;
                              double curRte=0;
                              double curAmt=0;
                              double totalQty=0;
                              double totalRte=0;
                              double totalAmt=0;
                              long count=0;
                              while(certRS.hasNext()){
                                  Row certRow=certRS.next();
                                  if(certRow.getAttribute("PrevAmount")==null){
                                      curQty=certRow.getAttribute("CurrTotQty")==null?0:Double.parseDouble(certRow.getAttribute("CurrTotQty").toString());
                                      curRte=certRow.getAttribute("CurrPerc")==null?0:Double.parseDouble(certRow.getAttribute("CurrPerc").toString());
                                      curAmt=certRow.getAttribute("CurrAmount")==null?0:Double.parseDouble(certRow.getAttribute("CurrAmount").toString());
                                  }else{
                                      curQty=certRow.getAttribute("PrevTotQty")==null?0:Double.parseDouble(certRow.getAttribute("PrevTotQty").toString());
                                      curRte=certRow.getAttribute("PrevPerc")==null?0:Double.parseDouble(certRow.getAttribute("PrevPerc").toString());
                                      curAmt=certRow.getAttribute("PrevAmount")==null?0:Double.parseDouble(certRow.getAttribute("PrevAmount").toString());
                                  }

                                  //System.err.println(curQty+"---"+curRte+"---"+curAmt);
                                  totalQty+=curQty;
                                  totalRte+=curRte;
                                  totalAmt+=curAmt;
                                  //System.err.println(totalQty+"----"+totalRte+"----"+totalAmt);
                                  count++;
                                  if(TotalRowCertiCount==count){
                                      Row certificaLineRow = certificationLineVO.createRow();
                                      certificaLineRow.setAttribute("ContractHeaderId", hid);
                                      certificaLineRow.setAttribute("ContLineId", lid);
                                      certificaLineRow.setAttribute("Version", version);
                                      certificaLineRow.setAttribute("CertHeaderId", certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId"));
                                      certificaLineRow.setAttribute("OrgId", certificationHrdVO.getCurrentRow().getAttribute("OrgId"));
                                      certificaLineRow.setAttribute("PrevTotQty", totalQty);
                                      certificaLineRow.setAttribute("PrevPerc", totalRte);
                                      certificaLineRow.setAttribute("PrevAmount", totalAmt);
                                      certificationLineVO.insertRow(certificaLineRow);
                                      certificationLineVO.executeQuery();
                                      AdfFacesContext.getCurrentInstance().addPartialTarget(t2);
                                      //System.err.println("Certification Line inserted");

                                  }

                              }
                          }
                      }
                    }
                }

                }
    }
*/

    public void setT2(RichTable t2) {
        this.t2 = t2;
    }

    public RichTable getT2() {
        return t2;
    }


    public void setCertificationCancelPopUp(RichPopup certificationCancelPopUp) {
        this.certificationCancelPopUp = certificationCancelPopUp;
    }

    public RichPopup getCertificationCancelPopUp() {
        return certificationCancelPopUp;
    }

    public void onClickPopUpCancelClose(ActionEvent actionEvent) {
        certificationCancelPopUp.cancel();
    }

    //    public void origQtyVCL(ValueChangeEvent origVCL) {
    //        String uoma =
    //            uom.getValue()== null ? "null" : uom.getValue().toString();
    //        double qtya =
    //            qty.getValue() == null ? 0 : Double.parseDouble((String)qty.getValue());
    //        double ratea =
    //            rate.getValue() == null ? 0 : Double.parseDouble((String)rate.getValue());
    //        if (uoma.equalsIgnoreCase("LS")) {
    //
    //        } else {
    //            double origQtyF =
    //                origVCL.getNewValue() == null ? 0 : Double.parseDouble(origVCL.getNewValue().toString());
    //            double origAmtF = origQtyF * ratea;
    //            origRate.setValue(new BigDecimal(ratea));
    //            AdfFacesContext.getCurrentInstance().addPartialTarget(origRate);
    //            origAmt.setValue(new BigDecimal(origAmtF));
    //            AdfFacesContext.getCurrentInstance().addPartialTarget(origAmt);
    //            currRate.setValue(new BigDecimal(ratea));
    //            AdfFacesContext.getCurrentInstance().addPartialTarget(currRate);
    //        }
    //    }

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

    public void setUom(RichInputText uom) {
        this.uom = uom;
    }

    public RichInputText getUom() {
        return uom;
    }

    public void setContractNumber(RichInputListOfValues contractNumber) {
        this.contractNumber = contractNumber;
    }

    public RichInputListOfValues getContractNumber() {
        return contractNumber;
    }

    public void setCurCertification(RichInputText curCertification) {
        this.curCertification = curCertification;
    }

    public RichInputText getCurCertification() {
        return curCertification;
    }

    public void setApplHeaderNumber(RichSelectOneChoice applHeaderNumber) {
        this.applHeaderNumber = applHeaderNumber;
    }

    public RichSelectOneChoice getApplHeaderNumber() {
        return applHeaderNumber;
    }


    //    public void ClaimAmtVCL(ValueChangeEvent clmAmt) {
    //        String uoma = (String)uom.getValue();
    //        double contAmt =
    //            amt.getValue() == null ? 0 : Double.parseDouble((String)amt.getValue());
    //        double ratea =
    //            rate.getValue() == null ? 0 : Double.parseDouble((String)rate.getValue());
    //        if (uoma.equalsIgnoreCase("LS")) {
    //
    //            double origQtyF =
    //                clmAmt.getNewValue() == null ? 0 : Double.parseDouble(clmAmt.getNewValue().toString());
    //
    //            double origAmtF = origQtyF / contAmt;
    //
    //            origQty.setValue(new BigDecimal(origAmtF));
    //            AdfFacesContext.getCurrentInstance().addPartialTarget(origQty);
    //        }
    //    }

    public void setHdrContAmt(RichInputText hdrContAmt) {
        this.hdrContAmt = hdrContAmt;
    }

    public RichInputText getHdrContAmt() {
        return hdrContAmt;
    }


    //    public void onChangeCurQty(ValueChangeEvent currQtyVCL) {
    //        String uoma = (String)uom.getValue();
    //        double currentRate =
    //            origRate.getValue() == null ? 0 : Double.parseDouble(origRate.getValue().toString());
    //        if (uoma.equalsIgnoreCase("LS")) {
    //
    //        } else {
    //            double currentQty =
    //                currQtyVCL.getNewValue() == null ? 0 : Double.parseDouble(currQtyVCL.getNewValue().toString());
    //            double currentAmt = currentQty * currentRate;
    //            currAmt.setValue(new BigDecimal(currentAmt));
    //            AdfFacesContext.getCurrentInstance().addPartialTarget(currAmt);
    //
    //            double previousQty =
    //                prevQty.getValue() == null ? 0 : Double.parseDouble(prevQty.getValue().toString());
    //            double previousRate =
    //                prevRate.getValue() == null ? 0 : Double.parseDouble(prevRate.getValue().toString());
    //            double previousAmt =
    //                prevAmt.getValue() == null ? 0 : Double.parseDouble(prevAmt.getValue().toString());
    //            cumQty.setValue(previousQty + currentQty);
    //            AdfFacesContext.getCurrentInstance().addPartialTarget(cumQty);
    //            cumRate.setValue(previousRate + currentRate);
    //            AdfFacesContext.getCurrentInstance().addPartialTarget(cumRate);
    //            cumAmt.setValue(previousAmt + currentAmt);
    //            AdfFacesContext.getCurrentInstance().addPartialTarget(cumAmt);
    //
    //        }
    //    }

    //    public void onChangeCurrAmt(ValueChangeEvent currAmtVCL) {
    //        String uoma = (String)uom.getValue();
    //        double contLneAmt =
    //            amt.getValue() == null ? 0 : Double.parseDouble((String)amt.getValue());
    //        if (uoma.equalsIgnoreCase("LS")) {
    //            double currentAmt =
    //                currAmtVCL.getNewValue() == null ? 0 : Double.parseDouble(currAmtVCL.getNewValue().toString());
    //            double currentQty = currentAmt / contLneAmt;
    //            currQty.setValue(new BigDecimal(currentQty));
    //            AdfFacesContext.getCurrentInstance().addPartialTarget(currQty);
    //
    //            double previousQty =
    //                prevQty.getValue() == null ? 0 : Double.parseDouble(prevQty.getValue().toString());
    //            double previousRate =
    //                prevRate.getValue() == null ? 0 : Double.parseDouble(prevRate.getValue().toString());
    //            double previousAmt =
    //                prevAmt.getValue() == null ? 0 : Double.parseDouble(prevAmt.getValue().toString());
    //            cumQty.setValue(previousQty + currentQty);
    //            AdfFacesContext.getCurrentInstance().addPartialTarget(cumQty);
    //            cumRate.setValue(previousRate);
    //            AdfFacesContext.getCurrentInstance().addPartialTarget(cumRate);
    //            cumAmt.setValue(previousAmt + currentAmt);
    //            AdfFacesContext.getCurrentInstance().addPartialTarget(cumAmt);
    //        }
    //    }

    /*
    public ServletContext getContext() {
        return (ServletContext)getFacesContext().getExternalContext().getContext();
    }

    public HttpServletResponse getResponse() {
        return (HttpServletResponse)getFacesContext().getExternalContext().getResponse();
    }

    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    public String getXMLData(Number certId) throws Exception {
        String retStr = "";
        Context ctx;
        Connection con = null;
        ctx = new InitialContext();
        //       String dataSource = "apex";
        //       String dataSource = "contract";
        //       String dataSource = "apex";
        String dataSource = "apex";

        DataSource ds = (DataSource)ctx.lookup(dataSource);
        con = ds.getConnection();
        String selectSQL =
            "SELECT XXSC_REPORT_PKG.Payment_certificate('" + certId +
            "') xml FROM dual";
        PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
        //System.err.println("=====OUT XML==" + selectSQL);
        ResultSet rs1 = preparedStatement.executeQuery(selectSQL);
        while (rs1.next()) {
            retStr = rs1.getString("xml");
        }
        //System.err.println("=====OUT XML==" + retStr);
        return retStr;
    }

    public byte[] runReport(String templateFile, Number cert) {
        //  String  templateFile = ;
        byte[] dataBytes = null;

        try {
            ServletContext context = getContext();
            InputStream fs = context.getResourceAsStream(templateFile);
            //Process RTF template to convert to XSL-FO format
            //System.err.println("====1====");
            RTFProcessor rtfp = new RTFProcessor(fs);
            ByteArrayOutputStream xslOutStream = new ByteArrayOutputStream();
            rtfp.setOutput(xslOutStream);
            rtfp.process();
            //System.err.println("====2====");
            //Use XSL Template and Data from the VO to generate report and return the OutputStream of report
            ByteArrayInputStream xslInStream =
                new ByteArrayInputStream(xslOutStream.toByteArray());
            //            ViewObject vo =
            //                ADFUtils.findIterator("XxscCertificationHeadersVO1Iterator").getViewObject();
            //
            //            Number cert =
            //                (Number)vo.getCurrentRow().getAttribute("CertHeaderId");
            FOProcessor processor = new FOProcessor();
            ByteArrayInputStream dataStream =
                //new ByteArrayInputStream((byte[])ADFUtils.findOperation("getXMLData").execute());
                new ByteArrayInputStream((getXMLData(cert).getBytes()));
            processor.setData(dataStream);
            processor.setTemplate(xslInStream);

            ByteArrayOutputStream pdfOutStream = new ByteArrayOutputStream();
            processor.setOutput(pdfOutStream);
            byte outFileTypeByte = FOProcessor.FORMAT_PDF;
            processor.setOutputFormat(outFileTypeByte);
            processor.generate();

            dataBytes = pdfOutStream.toByteArray();

        } catch (IOException e) {
            //System.out.println("IOException when generating pdf===IO" +
                               e.toString());
        } catch (Exception e) {
            // e.printStackTrace();
            //System.out.println("IOException when generating pdf===EXE" +
                               e.toString());

        }
        return dataBytes;
    }
*/

    public void onClickReports(FacesContext facesContext,
                               OutputStream outputStream) throws IOException {
        try {
            //            ViewObject vo =
            //                ADFUtils.findIterator("Contract_ROVO1Iterator").getViewObject();
            //            vo.setNamedWhereClauseParam("p_type", "B");
            //            vo.executeQuery();

            Number cert =
                (Number)certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId");
            //System.err.println("cert===>" + cert);
            Object result = null;
            String cstatus =
                JSFUtils.resolveExpression("#{bindings.ApprovalStatus1.inputValue}").toString();
            if (certificationHrdVO.getCurrentRow().getAttribute("PaymentType").toString().equalsIgnoreCase("Interim") ||
                certificationHrdVO.getCurrentRow().getAttribute("PaymentType").toString().equalsIgnoreCase("Final")) {
                if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationBuy") ||
                    ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
                    //                    -----------new report add-------------

                    if (ADFContext.getCurrent().getSessionScope().get("interimtype").equals("External")) {

                        if (cstatus.equalsIgnoreCase("TRNS_DRAFT")) {
                            result =
                                    RTFUtils.runReport("//reports//Payment_Certificate_Interim_EXT_D.rtf",
                                                       cert,
                                                       "Payment_certificate");
                        } else {
                            result =
                                    RTFUtils.runReport("//reports//Payment_Certificate_Interim_EXT.rtf",
                                                       cert,
                                                       "Payment_certificate");
                        }


                    } else {
                        if (cstatus.equalsIgnoreCase("TRNS_DRAFT")) {
                            result =
                                    RTFUtils.runReport("//reports//Payment_Certificate_Interim_INT_D.rtf",
                                                       cert,
                                                       "Payment_certificate");
                        } else {
                            result =
                                    RTFUtils.runReport("//reports//Payment_Certificate_Interim_INT.rtf",
                                                       cert,
                                                       "Payment_certificate");
                        }


                    }


                    //                    result =
                    //                            RTFUtils.runReport("//reports//Payment_Certificate_Task_Interim_Buy.rtf",
                    //                                               cert, "Payment_certificate");

                    //                    ---------------------------------------
                } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationSell") ||
                           ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
                    result =
                            RTFUtils.runReport("//reports//Payment_Certificate_Task_Interim_Sell.rtf",
                                               cert, "Payment_certificate");
                }
            } else if (certificationHrdVO.getCurrentRow().getAttribute("PaymentType").toString().equalsIgnoreCase("Material Advance") ||
                       certificationHrdVO.getCurrentRow().getAttribute("PaymentType").toString().equalsIgnoreCase("Advance")) {
                if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationBuy") ||
                    ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
                    result =
                            RTFUtils.runReport("//reports//Payment_Certificate_Task_Advance_Buy.rtf",
                                               cert, "Payment_certificate");
                } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationSell") ||
                           ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
                    result =
                            RTFUtils.runReport("//reports//Payment_Certificate_Task_Advance_Sell.rtf",
                                               cert, "Payment_certificate");
                }
            }
            outputStream.write((byte[])result);
        } catch (IOException e) {
            //System.out.println("Exception " + e);
        }
    }

    public String getExtPdf() {
        String resultPdf = "";
        Number cert =
            (Number)certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId");
        //System.err.println("cert===>" + cert);
        Object result = null;
        String cstatus =
            JSFUtils.resolveExpression("#{bindings.ApprovalStatus1.inputValue}").toString();
        String intTyp =
            ADFContext.getCurrent().getSessionScope().get("interimtype") ==
            null ? "" :
            ADFContext.getCurrent().getSessionScope().get("interimtype").toString();
        String paymentTyp =
            certificationHrdVO.getCurrentRow().getAttribute("PaymentType") ==
            null ? "" :
            certificationHrdVO.getCurrentRow().getAttribute("PaymentType").toString();
        String page =
            ADFContext.getCurrent().getSessionScope().get("page") == null ?
            "" :
            ADFContext.getCurrent().getSessionScope().get("page").toString();
        System.out.println("cstatus%%" + cstatus + " intTyp%%" + intTyp +
                           " paymentTyp%%" + paymentTyp + " page%%" + page);
        //            JSFUtils.addFacesInformationMessage("cstatus%%"+cstatus+" intTyp%%"+intTyp+" paymentTyp%%"+paymentTyp+" page%%"+page);
        //test
        //                    resultPdf ="https://jcs.omniyat.com"+"/SubContractReportAlm/webresources/lease/cert/"+"?P_CERT_ID="+cert+"&P_INTERIM_TYPE=External&P_STATUS="+cstatus+"&P_FILE_TYPE=pdf";
        //            resultPdf ="https://jcs.omniyat.com"+"/SubContractReportAlm/webresources/lease/cert/"+"?P_CERT_ID="+cert+"&P_INTERIM_TYPE=External&P_STATUS="+cstatus+"&P_PAYMENT_TYPE="+paymentTyp+"&P_PAGE="+page+"&P_FILE_TYPE=pdf";
        //prod
        resultPdf =
                "https://omnijcsprod01.omniyat.com" + "/SubContractReportAlm/webresources/lease/cert/" +
                "?P_CERT_ID=" + cert + "&P_INTERIM_TYPE=External&P_STATUS=" +
                cstatus + "&P_FILE_TYPE=pdf";
        return resultPdf;
    }

    public String getIntPdf() {

        String resultPdf = "";
        Number cert =
            (Number)certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId");
        //System.err.println("cert===>" + cert);
        Object result = null;

        String cstatus =
            JSFUtils.resolveExpression("#{bindings.ApprovalStatus1.inputValue}").toString();
        String intTyp =
            ADFContext.getCurrent().getSessionScope().get("interimtype") ==
            null ? "" :
            ADFContext.getCurrent().getSessionScope().get("interimtype").toString();
        String paymentTyp =
            certificationHrdVO.getCurrentRow().getAttribute("PaymentType") ==
            null ? "" :
            certificationHrdVO.getCurrentRow().getAttribute("PaymentType").toString();
        String page =
            ADFContext.getCurrent().getSessionScope().get("page") == null ?
            "" :
            ADFContext.getCurrent().getSessionScope().get("page").toString();
        System.out.println("cert: " + cert + " cstatus%%" + cstatus +
                           " intTyp%%" + intTyp + " paymentTyp%%" +
                           paymentTyp + " page%%" + page);
        //test
        //                    resultPdf ="https://jcs.omniyat.com"+"/SubContractReportAlm/webresources/lease/cert/"+"?P_CERT_ID="+cert+"&P_INTERIM_TYPE=Internal&P_STATUS="+cstatus+"&P_FILE_TYPE=pdf";
        //            JSFUtils.addFacesInformationMessage("cstatus%%"+cstatus+" intTyp%%"+intTyp+" paymentTyp%%"+paymentTyp+" page%%"+page);
        //            resultPdf ="https://jcs.omniyat.com"+"/SubContractReportAlm/webresources/lease/cert/"+"?P_CERT_ID="+cert+"&P_INTERIM_TYPE=Internal&P_STATUS="+cstatus+"&P_PAYMENT_TYPE="+paymentTyp+"&P_PAGE="+page+"&P_FILE_TYPE=pdf";
        //prod
        resultPdf =
                "https://omnijcsprod01.omniyat.com" + "/SubContractReportAlm/webresources/lease/cert/" +
                "?P_CERT_ID=" + cert + "&P_INTERIM_TYPE=Internal&P_STATUS=" +
                cstatus + "&P_FILE_TYPE=pdf";
        return resultPdf;
    }
    //cert type pdf

    public String getCertTypePdf() {
        String resultPdf = "";
        String certType = "";
        try {
            Number cert =
                (Number)certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId");
            //System.err.println("cert===>" + cert);
            String cstatus =
                JSFUtils.resolveExpression("#{bindings.ApprovalStatus1.inputValue}").toString();
            String pTyp =
                certificationHrdVO.getCurrentRow().getAttribute("PaymentType").toString();
            String pag =
                ADFContext.getCurrent().getSessionScope().get("page").toString();
            System.err.println("cert: " + cert + " cstatus:" + cstatus +
                               " pTyp:" + pTyp + " pag:" + pag);
            if (certificationHrdVO.getCurrentRow().getAttribute("PaymentType").toString().equalsIgnoreCase("Interim") ||
                certificationHrdVO.getCurrentRow().getAttribute("PaymentType").toString().equalsIgnoreCase("Final")) {
                if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationBuy") ||
                    ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
                    //                    -----------new report add-------------
                    certType = "certType1";
                    System.out.println("certType1");
                    resultPdf =
                            "https://jcs.omniyat.com" + "/SubContractReportAlm/webresources/lease/certType/" +
                            "?P_CERT_ID=" + cert + "&P_CERT_TYPE=" + certType +
                            "&P_FILE_TYPE=pdf";
                } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationSell")) {
                    certType = "certType2";
                    System.out.println("certType2");
                    resultPdf =
                            "https://jcs.omniyat.com" + "/SubContractReportAlm/webresources/lease/certType/" +
                            "?P_CERT_ID=" + cert + "&P_CERT_TYPE=" + certType +
                            "&P_FILE_TYPE=pdf";
                }
            } else if (certificationHrdVO.getCurrentRow().getAttribute("PaymentType").toString().equalsIgnoreCase("Material Advance") ||
                       certificationHrdVO.getCurrentRow().getAttribute("PaymentType").toString().equalsIgnoreCase("Advance")) {
                if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationBuy") ||
                    ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
                    //                    -----------new report add-------------
                    certType = "certType3";
                    System.out.println("certType3");
                    resultPdf =
                            "https://jcs.omniyat.com" + "/SubContractReportAlm/webresources/lease/certType/" +
                            "?P_CERT_ID=" + cert + "&P_CERT_TYPE=" + certType +
                            "&P_FILE_TYPE=pdf";
                } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationSell") ||
                           ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
                    certType = "certType4";
                    System.out.println("certType4");
                    resultPdf =
                            "https://jcs.omniyat.com" + "/SubContractReportAlm/webresources/lease/certType/" +
                            "?P_CERT_ID=" + cert + "&P_CERT_TYPE=" + certType +
                            "&P_FILE_TYPE=pdf";
                } else {
                    certType = "noRtfCall";
                    System.out.println("noRtfCall");
                    resultPdf =
                            "https://jcs.omniyat.com" + "/SubContractReportAlm/webresources/lease/certType/" +
                            "?P_CERT_ID=" + cert + "&P_CERT_TYPE=" + certType +
                            "&P_FILE_TYPE=pdf";
                }
            }
        } catch (Exception e) {
            //System.out.println("Exception " + e);
            return null;
        }
        return resultPdf;
    }

    public String onClickSaveRe_Direct() throws SQLException {
        String page = null;
        String maxContVrsn = null;
        String contHdrId =
            certificationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
            null ? "0" :
            certificationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
        String appHdrId =
            certificationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
            null ? "0" :
            certificationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();
        String certVrsn =
            certificationHrdVO.getCurrentRow().getAttribute("Version") ==
            null ? "0" :
            certificationHrdVO.getCurrentRow().getAttribute("Version").toString();
        ViewObject getMaxContVrsnRoVo =
            ADFUtils.findIterator("Xxsc_AppHdrContHdrVersn_RoVo1Iterator").getViewObject();
        ViewCriteria vwc = getMaxContVrsnRoVo.createViewCriteria();
        ViewCriteriaRow vwcr = vwc.createViewCriteriaRow();
        vwcr.setAttribute("ContHeaderId", contHdrId);
        vwcr.setAttribute("ApplHeaderId", appHdrId);
        vwc.addRow(vwcr);
        getMaxContVrsnRoVo.applyViewCriteria(vwc);
        getMaxContVrsnRoVo.executeQuery();
        if (getMaxContVrsnRoVo.getEstimatedRowCount() > 0) {
            maxContVrsn =
                    getMaxContVrsnRoVo.first().getAttribute("MaxContVersion") ==
                    null ? "0" :
                    getMaxContVrsnRoVo.first().getAttribute("MaxContVersion").toString();
        }
        if (!certVrsn.equals(maxContVrsn)) {
            JSFUtils.addFacesErrorMessage("Kindly Check a new contract version is amended !!!");
        } else {
            //getFunctionId();
            page = onClickSave();
            //System.err.println("Redirect page" + page);
            refreshCertificationTable();
        }
        return page;
    }

    public String onClickSave() throws SQLException {
        String pageRedirect = null;
        //check Buy or sell
        onClickCalculateAmount();
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy") ||
            ADFContext.getCurrent().getSessionScope().get("page").equals("certificationBuy") ||
            ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
            // checking Add--Edit
            if (ADFContext.getCurrent().getSessionScope().get("addEditCert") !=
                null &&
                ADFContext.getCurrent().getSessionScope().get("addEditCert").toString().equals("edit")) {
                //System.err.println("ccc-c--c>> " + curOtherCharge.getValue());
                certificationHrdVO.getCurrentRow().setAttribute("CurOthCharge",
                                                                curOtherCharge.getValue() ==
                                                                null ?
                                                                new BigDecimal(0) :
                                                                curOtherCharge.getValue());
                certificationHrdVO.getCurrentRow().setAttribute("PrevOthCharge",
                                                                prevOth.getValue() ==
                                                                null ?
                                                                new BigDecimal(0) :
                                                                prevOth.getValue());
                certificationHrdVO.getCurrentRow().setAttribute("TotOthCharge",
                                                                totOth.getValue() ==
                                                                null ?
                                                                new BigDecimal(0) :
                                                                totOth.getValue());
                ADFUtils.findOperation("Commit").execute();
                refreshCertificationTable();
                JSFUtils.addFacesInformationMessage("Payment Certification Information Saved Successfully");
                pageRedirect = "save";
            } else {

                if (certificationHrdVO.getCurrentRow().getAttribute("OrgId") ==
                    null) {
                    JSFUtils.addFacesErrorMessage("Please Select Business Unit");
                    pageRedirect = "";
                } else {
                    if (certificationHrdVO.getCurrentRow().getAttribute("Trans_ContractNumber") ==
                        null) {
                        JSFUtils.addFacesErrorMessage("Please Select Contract Number");
                        pageRedirect = "";
                    } else {
                        if (certificationHrdVO.getCurrentRow().getAttribute("Trans_SupplierName") ==
                            null) {
                            JSFUtils.addFacesErrorMessage("Please Select Supplier Name");
                            pageRedirect = "";
                        } else {
                            if (certificationHrdVO.getCurrentRow().getAttribute("Trans_SupplierSite") ==
                                null) {
                                JSFUtils.addFacesErrorMessage("Please Select Supplier Site");
                                pageRedirect = "";
                            } else {
                                if (certificationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
                                    null) {
                                    JSFUtils.addFacesErrorMessage("Please Select Application Number");
                                    pageRedirect = "";
                                } else {
                                    if (certificationHrdVO.getCurrentRow().getAttribute("Supplier_Invoice_Date") ==
                                        null) {
                                        JSFUtils.addFacesErrorMessage("Please Select Supplier Invoice Date");
                                        pageRedirect = "";
                                    } else {
                                        if (certificationHrdVO.getCurrentRow().getAttribute("Supplier_Invoice_Num") ==
                                            null) {
                                            JSFUtils.addFacesErrorMessage("Please Select Supplier Invoice Number");
                                            pageRedirect = "";
                                        } else {
                                            onClickCalculateAmount();
                                            ViewObject certificationManInsVO =
                                                ADFUtils.findIterator("CertNumberManualInsertROVO1Iterator").getViewObject();
                                            //        certificationManInsVO.first().getAttribute("Num").toString();
 //                                           int certnum =
 //                                               Integer.parseInt(certificationManInsVO.first().getAttribute("Num").toString()) +
 //                                               1;
                                            certificationHrdVO.getCurrentRow().setAttribute("CertificationNumber",
                                                                                            "CERT-" +
                                                                                            certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId"));
                                            /**
 * To avoid sequence value for certification number
 */
                                            //                                            certificationHrdVO.getCurrentRow().setAttribute("CertificationNumber",
                                            //                                                                                            "CERT-" +certnum);

                                            certificationHrdVO.getCurrentRow().setAttribute("FuncId",
                                                                                            "200005");
                                            certificationHrdVO.getCurrentRow().setAttribute("CertificationStatus",
                                                                                            "ACTIVE");
                                            certificationHrdVO.getCurrentRow().setAttribute("Intent",
                                                                                            "B");
                                            //System.err.println("ccc-c--c>> " +curOtherCharge.getValue());
                                            certificationHrdVO.getCurrentRow().setAttribute("CurOthCharge",
                                                                                            curOtherCharge.getValue() ==
                                                                                            null ?
                                                                                            new BigDecimal(0) :
                                                                                            curOtherCharge.getValue());
                                            certificationHrdVO.getCurrentRow().setAttribute("PrevOthCharge",
                                                                                            prevOth.getValue() ==
                                                                                            null ?
                                                                                            new BigDecimal(0) :
                                                                                            prevOth.getValue());
                                            certificationHrdVO.getCurrentRow().setAttribute("TotOthCharge",
                                                                                            totOth.getValue() ==
                                                                                            null ?
                                                                                            new BigDecimal(0) :
                                                                                            totOth.getValue());

                                            if (certificationHrdVO.getCurrentRow().getAttribute("CreatedBy").toString() ==
                                                null &&
                                                certificationHrdVO.getCurrentRow().getAttribute("LastUpdatedBy").toString() ==
                                                null) {
                                                JSFUtils.addFacesInformationMessage("Session is expired");
                                            } else {


                                                ADFUtils.findOperation("Commit").execute();
                                                //refreshCertificationTable();
                                                JSFUtils.numberFaceMessage("Payment Certification",
                                                                           certificationHrdVO.getCurrentRow().getAttribute("CertificationNumber"));
                                                pageRedirect = "save";
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }


                /*
                if (contractNumber.getValue() == null) {
                    JSFUtils.addFacesErrorMessage("Please select Contract Number");
                    pageRedirect = "";
                } else {
                    if (curCertification.getValue() == null) {
                        JSFUtils.addFacesErrorMessage("Please provide Current Certification");
                        pageRedirect = "";
                    } else {
                        if (paymentType.getValue().toString().equals("Advance")) {
                            certificationHrdVO.getCurrentRow().setAttribute("CertificationNumber","CERT-" +certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId"));
                            certificationHrdVO.getCurrentRow().setAttribute("Intent","B");
                            //get fun id
                            //                            ViewObjectImpl funVOImpl = (ViewObjectImpl) functionVO.getViewObject();
                            //                            ViewCriteria insVc = funVOImpl.getViewCriteria("FunctionROVOCriteria");
                            functionVO.setNamedWhereClauseParam("p_code",
                                                                "SELL_CUST_CERT");
                            //                            functionVO.applyViewCriteria(insVc);
                            functionVO.executeQuery();
                            //System.err.println("==functionVO COUNT==" +
                                               functionVO.getEstimatedRowCount());
                            if (functionVO.getEstimatedRowCount() == 1) {
                                Object funid =
                                    functionVO.first().getAttribute("FuncId");
                                certificationHrdVO.getCurrentRow().setAttribute("FuncId",
                                                                                funid);
                                ADFUtils.findOperation("Commit").execute();
                                refreshCertificationTable();
                                JSFUtils.numberFaceMessage("Payment Certification",certificationHrdVO.getCurrentRow().getAttribute("CertificationNumber"));
                                pageRedirect = "save";
                            } else {
                                ADFUtils.findOperation("Commit").execute();
                                refreshCertificationTable();
                                JSFUtils.numberFaceMessage("Payment Certification",
                                                           certificationHrdVO.getCurrentRow().getAttribute("CertificationNumber"));
                                pageRedirect = "save";
                            }


                        } else {
                            //System.err.println("Certificaiton Line Count---" +
                                               certificationLineVO.getEstimatedRowCount());
                            int count = 0;
                            RowSetIterator rs =
                                certificationLineVO.createRowSetIterator(null);
                            while (rs.hasNext()) {
                                Row r = rs.next();
                                if (r.getAttribute("CumTotQty") == null) {
                                    JSFUtils.addFacesErrorMessage("Please provide Cummulative Quantity");
                                    pageRedirect = "";
                                } else {
                                    if (r.getAttribute("CumPerc") == null) {
                                        JSFUtils.addFacesErrorMessage("Please provide Cummulative Rate");
                                        pageRedirect = "";
                                    } else {
                                        count++;
                                        if (certificationLineVO.getEstimatedRowCount() ==
                                            count) {
                                            certificationHrdVO.getCurrentRow().setAttribute("CertificationNumber",
                                                                                            "CERT-" +
                                                                                            certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId"));
                                            certificationHrdVO.getCurrentRow().setAttribute("Intent",
                                                                                            "B");
                                            //get fun id
                                            //                                            ViewObjectImpl funVOImpl = (ViewObjectImpl) functionVO.getViewObject();
                                            //                                            ViewCriteria insVc = funVOImpl.getViewCriteria("FunctionROVOCriteria");
                                            functionVO.setNamedWhereClauseParam("p_code",
                                                                                "SELL_CUST_CERT");
                                            //                                            functionVO.applyViewCriteria(insVc);
                                            functionVO.executeQuery();
                                            //System.err.println("==functionVO COUNT==" +
                                                               functionVO.getEstimatedRowCount());
                                            if (functionVO.getEstimatedRowCount() ==
                                                1) {
                                                Object funid =
                                                    functionVO.first().getAttribute("FuncId");
                                                certificationHrdVO.getCurrentRow().setAttribute("FuncId",
                                                                                                funid);
                                                ADFUtils.findOperation("Commit").execute();
                                                refreshCertificationTable();
                                                JSFUtils.numberFaceMessage("Payment Certification",
                                                                           certificationHrdVO.getCurrentRow().getAttribute("CertificationNumber"));
                                                pageRedirect = "save";
                                            } else {
                                                ADFUtils.findOperation("Commit").execute();
                                                refreshCertificationTable();
                                                JSFUtils.numberFaceMessage("Payment Certification",
                                                                           certificationHrdVO.getCurrentRow().getAttribute("CertificationNumber"));
                                                pageRedirect = "save";

                                            }


                                        }
                                    }
                                }
                            }
                        }

                    }
                }
               */
            }
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell") ||
                   ADFContext.getCurrent().getSessionScope().get("page").equals("certificationSell") ||
                   ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
            // Check Sell Add Edit
            if (ADFContext.getCurrent().getSessionScope().get("addEditCert") !=
                null &&
                ADFContext.getCurrent().getSessionScope().get("addEditCert").toString().equals("edit")) {
                ADFUtils.findOperation("Commit").execute();
                refreshCertificationTable();
                JSFUtils.addFacesInformationMessage("Customer Certification Information Saved Successfully");
                pageRedirect = "save";
            } else {
                if (certificationHrdVO.getCurrentRow().getAttribute("OrgId") ==
                    null) {
                    JSFUtils.addFacesErrorMessage("Please Select Business Unit");
                    pageRedirect = "";
                } else {
                    if (certificationHrdVO.getCurrentRow().getAttribute("Trans_ContractNumber") ==
                        null) {
                        JSFUtils.addFacesErrorMessage("Please Select Contract Number");
                        pageRedirect = "";
                    } else {
                        // if (certificationHrdVO.getCurrentRow().getAttribute("Trans_ApplPayTerm") ==null) {
                        if (Boolean.FALSE) {
                            JSFUtils.addFacesErrorMessage("Please Select Customer Name");
                            pageRedirect = "";
                        } else {
                            // if (certificationHrdVO.getCurrentRow().getAttribute("Trans_ApplPayTerm") ==null) {
                            if (Boolean.FALSE) {
                                JSFUtils.addFacesErrorMessage("Please Select Application Pay Term");
                                pageRedirect = "";
                            } else {
                                if (certificationHrdVO.getCurrentRow().getAttribute("CurCertification") ==
                                    null) {
                                    JSFUtils.addFacesErrorMessage("Please Enter Current Certification Amount");
                                    pageRedirect = "";
                                } else {
                                    onClickCalculateAmount();
                                    certificationHrdVO.getCurrentRow().setAttribute("CertificationNumber",
                                                                                    "CERT-" +
                                                                                    certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId"));
                                    certificationHrdVO.getCurrentRow().setAttribute("FuncId",
                                                                                    "200006");
                                    //                                    certificationHrdVO.getCurrentRow().setAttribute("ApprovalStatus",
                                    //                                                                                    "APR");
                                    certificationHrdVO.getCurrentRow().setAttribute("CertificationStatus",
                                                                                    "ACTIVE");
                                    certificationHrdVO.getCurrentRow().setAttribute("Intent",
                                                                                    "S");

                                    String appType =
                                        certificationHrdVO.getCurrentRow().getAttribute("PaymentType") !=
                                        null ?
                                        certificationHrdVO.getCurrentRow().getAttribute("PaymentType").toString() :
                                        null;
                                    if (appType != null &&
                                        appType.toString().equalsIgnoreCase("Advance")) {
                                        certificationHrdVO.getCurrentRow().setAttribute("InvStatus",
                                                                                        "READY_TO_AR");
                                    } else {
                                        RowSetIterator rs =
                                            certificationLineVO.createRowSetIterator("");
                                        while (rs.hasNext()) {
                                            Row r = rs.next();
                                            r.setAttribute("InvStatus",
                                                           "READY_TO_PRO_BILL");
                                        }
                                    }

                                    ADFUtils.findOperation("Commit").execute();
                                    //refreshCertificationTable();
                                    JSFUtils.numberFaceMessage("Customer Certification",
                                                               certificationHrdVO.getCurrentRow().getAttribute("CertificationNumber"));
                                    pageRedirect = "save";
                                }

                            }
                        }
                    }
                }


                /*
                if (contractNumber.getValue() == null) {
                    JSFUtils.addFacesErrorMessage("Please select Contract Number");
                    pageRedirect = "";
                } else {
                    if (applHeaderNumber.getValue() == null) {
                        JSFUtils.addFacesErrorMessage("Please select Application Number");
                        pageRedirect = "";
                    } else {
                        if (curCertification.getValue() == null) {
                            JSFUtils.addFacesErrorMessage("Please provide Cummulative Quantity");
                            pageRedirect = "";
                        } else {
                            //System.err.println("Certfication Line" +
                                               certificationLineVO.getEstimatedRowCount());
                            int count = 0;
                            RowSetIterator rs =
                                certificationLineVO.createRowSetIterator(null);
                            while (rs.hasNext()) {
                                Row r = rs.next();
                                if (r.getAttribute("CumTotQty") == null) {
                                    JSFUtils.addFacesErrorMessage("Please provide Cummulative Quantity");
                                    pageRedirect = "";
                                } else {
                                    if (r.getAttribute("CumPerc") == null) {
                                        JSFUtils.addFacesErrorMessage("Please provide Cummulative Rate");
                                        pageRedirect = "";
                                    } else {
                                        count++;
                                        if (certificationLineVO.getEstimatedRowCount() ==
                                            count) {
                                            certificationHrdVO.getCurrentRow().setAttribute("CertificationNumber","CERT-" + certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId"));
                                            certificationHrdVO.getCurrentRow().setAttribute("Intent","B");
                                            ADFUtils.findOperation("Commit").execute();
                                            refreshCertificationTable();
                                            JSFUtils.numberFaceMessage("Customer Certification",certificationHrdVO.getCurrentRow().getAttribute("CertificationNumber"));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
             */
            }

        } else {
            //System.err.println("Error");
            pageRedirect = "";
        }
        return pageRedirect;
    }


    public void refreshCertificationTable() {
        ViewCriteria vc = searchCertificationVO.createViewCriteria();
        ViewCriteriaRow vcr = vc.createViewCriteriaRow();
        vcr.setAttribute("CertificationNumber", "");
        vc.addRow(vcr);
        searchCertificationVO.applyViewCriteria(vc);
        searchCertificationVO.executeQuery();
        //System.err.println("--Table Refresh from certificaton--");
    }

    public long eventSequences() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Date date = new Date();
        long l = Long.parseLong((dateFormat.format(date)).toString());
        return l;
    }

    public void onClickLinesUpdate(ValueChangeEvent valueChangeEvent) {
        //        int AppHeaderId = valueChangeEvent.getNewValue();
        if (certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId") !=
            null) {
            // Filtering Certification, where selected application already present or not
            ViewCriteria certHrdVC = certificationHrdVO2.createViewCriteria();
            ViewCriteriaRow certHrdVCR = certHrdVC.createViewCriteriaRow();
            certHrdVCR.setAttribute("ApplHeaderId",
                                    valueChangeEvent.getNewValue());
            certHrdVC.addRow(certHrdVCR);
            certificationHrdVO2.applyViewCriteria(certHrdVC);
            certificationHrdVO2.executeQuery();
            //System.err.println("COUNT App Hrd Id==>" +
            //                               certificationHrdVO2.getEstimatedRowCount());
            if (certificationHrdVO2.getEstimatedRowCount() != 0) {
                String CertNum =
                    certificationHrdVO2.first().getAttribute("CertificationNumber") ==
                    null ? "0" :
                    certificationHrdVO2.first().getAttribute("CertificationNumber").toString();
                applHeaderNumber.setValue(null);
                applHeaderNumber.setDisabled(Boolean.FALSE);
                AdfFacesContext.getCurrentInstance().addPartialTarget(applHeaderNumber);
                JSFUtils.addFacesErrorMessage("Please check selected Application Number already created, not yet Certified." +
                                              " Previous Certification Number: " +
                                              CertNum);

            } else {
                //Deductions
                //                certificationHrdVO.getCurrentRow().setAttribute("CurMatAdvRec",
                //                                              ApplicationLineRow.getAttribute("CurMatAdvRec"));
                //                certificationHrdVO.getCurrentRow().setAttribute("MatOnSiteDesc",
                //                                              ApplicationLineRow.getAttribute("MatOnSiteDesc"));
                //                certificationHrdVO.getCurrentRow().setAttribute("MatOnSite",
                //                                              ApplicationLineRow.getAttribute("MatOnSite"));
                //                certificationHrdVO.getCurrentRow().setAttribute("MatAdvRecDesc",
                //                                              ApplicationLineRow.getAttribute("MatAdvRecDesc"));
                //                //Additional Charges
                //                certificationHrdVO.getCurrentRow().setAttribute("ContraCharges",
                //                                              ApplicationLineRow.getAttribute("ContraCharges"));
                //                certificationHrdVO.getCurrentRow().setAttribute("ContraChargesDesc",
                //                                              ApplicationLineRow.getAttribute("ContraChargesDesc"));
                //                certificationHrdVO.getCurrentRow().setAttribute("PenaltyCharges",
                //                                              ApplicationLineRow.getAttribute("PenaltyCharges"));
                //                certificationHrdVO.getCurrentRow().setAttribute("PenaltyChargesDesc",
                //                                              ApplicationLineRow.getAttribute("PenaltyChargesDesc"));

                removeExistingRow();
                int certHdrID =
                    certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId") ==
                    null ? 0 :
                    Integer.parseInt(certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId").toString());
                //Filtering App Line
                ViewCriteria PaymentApplLinesVC =
                    PaymentApplLinesVO1.createViewCriteria();
                ViewCriteriaRow PaymentLineVCRow =
                    PaymentApplLinesVC.createViewCriteriaRow();
                PaymentLineVCRow.setAttribute("ApplHeaderId",
                                              valueChangeEvent.getNewValue());
                PaymentApplLinesVC.addRow(PaymentLineVCRow);
                PaymentApplLinesVO1.applyViewCriteria(PaymentApplLinesVC);
                PaymentApplLinesVO1.executeQuery();
                //System.err.println("==COUNT App header Id==" +
                //                                   PaymentApplLinesVO1.getEstimatedRowCount());
                //other charge lines
                ViewCriteria PaymentApplLinesVC1 =
                    PayApplOthChargesVO1.createViewCriteria();
                ViewCriteriaRow PaymentLineVC1Row =
                    PaymentApplLinesVC1.createViewCriteriaRow();
                PaymentLineVC1Row.setAttribute("ApplHeaderId",
                                               valueChangeEvent.getNewValue());
                PaymentApplLinesVC1.addRow(PaymentLineVC1Row);
                PayApplOthChargesVO1.applyViewCriteria(PaymentApplLinesVC1);
                PayApplOthChargesVO1.executeQuery();
                //System.err.println("==COUNT App header Id==" +
                //                                   PayApplOthChargesVO1.getEstimatedRowCount());
                //close other charge lines
                //        JSFUtils.addFacesInformationMessage("==COUNT=="+PaymentApplLinesVO1.getEstimatedRowCount());
                // App Line Insert
                RowSetIterator rs =
                    PaymentApplLinesVO1.createRowSetIterator(null);
                while (rs.hasNext()) {
                    Row ApplicationLineRow = rs.next();
                    Row certificaLineRow = certificationLineVO.createRow();
                    certificaLineRow.setAttribute("CertLineId",
                                                  eventSequences());
                    certificaLineRow.setAttribute("CertHeaderId", certHdrID);
                    certificaLineRow.setAttribute("ApplHeaderId",
                                                  ApplicationLineRow.getAttribute("ApplHeaderId"));
                    certificaLineRow.setAttribute("ApplLineId",
                                                  ApplicationLineRow.getAttribute("ApplLineId"));
                    certificaLineRow.setAttribute("DataSetId",
                                                  ApplicationLineRow.getAttribute("DataSetId"));
                    certificaLineRow.setAttribute("ContractHeaderId",
                                                  ApplicationLineRow.getAttribute("ContHeaderId"));
                    certificaLineRow.setAttribute("CurAdvRecAmount",
                                                  ApplicationLineRow.getAttribute("CurAdvRecAmount"));
                    certificaLineRow.setAttribute("CurRetRecAmount",
                                                  ApplicationLineRow.getAttribute("CurRetRecAmount"));


                    // EPC Amt
                    certificaLineRow.setAttribute("EcpPercentage",
                                                  ApplicationLineRow.getAttribute("EcpPercentage"));
                    certificaLineRow.setAttribute("EcpTotalAmount",
                                                  ApplicationLineRow.getAttribute("EcpTotalAmount"));

                    // Certification Previous
                    certificaLineRow.setAttribute("PrevPerc",
                                                  ApplicationLineRow.getAttribute("PrevPerc"));
                    certificaLineRow.setAttribute("PrevSupOnlyQty",
                                                  ApplicationLineRow.getAttribute("PrevSupOnlyQty"));
                    certificaLineRow.setAttribute("PrevTotQty",
                                                  ApplicationLineRow.getAttribute("PrevTotQty"));
                    certificaLineRow.setAttribute("PrevSupInsQty",
                                                  ApplicationLineRow.getAttribute("PrevSupInsQty"));
                    certificaLineRow.setAttribute("PrevAmount",
                                                  ApplicationLineRow.getAttribute("PrevAmount"));
                    // Certification Current
                    certificaLineRow.setAttribute("CurrPerc",
                                                  ApplicationLineRow.getAttribute("CurrPerc"));
                    certificaLineRow.setAttribute("CumSupOnlyQty",
                                                  ApplicationLineRow.getAttribute("CumSupOnlyQty"));
                    certificaLineRow.setAttribute("CurrSupInsQty",
                                                  ApplicationLineRow.getAttribute("CurrSupInsQty"));
                    certificaLineRow.setAttribute("CurrTotQty",
                                                  ApplicationLineRow.getAttribute("CurrTotQty"));
                    certificaLineRow.setAttribute("CurrAmount",
                                                  ApplicationLineRow.getAttribute("CurrAmount"));
                    // Certification Cummulative
                    certificaLineRow.setAttribute("CumPerc",
                                                  ApplicationLineRow.getAttribute("CumPerc"));
                    certificaLineRow.setAttribute("CumSupOnlyQty",
                                                  ApplicationLineRow.getAttribute("CumSupOnlyQty"));
                    certificaLineRow.setAttribute("CumSupInsQty",
                                                  ApplicationLineRow.getAttribute("CumSupInsQty"));
                    certificaLineRow.setAttribute("CumTotQty",
                                                  ApplicationLineRow.getAttribute("CumTotQty"));
                    certificaLineRow.setAttribute("CumAmount",
                                                  ApplicationLineRow.getAttribute("CumAmount"));
                    // Application Previous
                    certificaLineRow.setAttribute("PrevPerc_Trans",
                                                  ApplicationLineRow.getAttribute("PrevPerc"));
                    certificaLineRow.setAttribute("PrevSupOnlyQty_Trans",
                                                  ApplicationLineRow.getAttribute("PrevSupOnlyQty"));
                    certificaLineRow.setAttribute("PrevTotQty_Trans",
                                                  ApplicationLineRow.getAttribute("PrevTotQty"));
                    certificaLineRow.setAttribute("PrevSupInsQty_Trans",
                                                  ApplicationLineRow.getAttribute("PrevSupInsQty"));
                    certificaLineRow.setAttribute("PrevAmount_Trans",
                                                  ApplicationLineRow.getAttribute("PrevAmount"));
                    // Application Current
                    certificaLineRow.setAttribute("CurrPerc_Trans",
                                                  ApplicationLineRow.getAttribute("CurrPerc"));
                    certificaLineRow.setAttribute("CumSupOnlyQty_Trans",
                                                  ApplicationLineRow.getAttribute("CumSupOnlyQty"));
                    certificaLineRow.setAttribute("CurrSupInsQty_Trans",
                                                  ApplicationLineRow.getAttribute("CurrSupInsQty"));
                    certificaLineRow.setAttribute("CurrTotQty_Trans",
                                                  ApplicationLineRow.getAttribute("CurrTotQty"));
                    certificaLineRow.setAttribute("CurrAmount_Trans",
                                                  ApplicationLineRow.getAttribute("CurrAmount"));
                    certificaLineRow.setAttribute("CurrTaxAmount_Trans",
                                                  ApplicationLineRow.getAttribute("TaxAmount"));
                    // Application Cummulative
                    certificaLineRow.setAttribute("CumPerc_Trans",
                                                  ApplicationLineRow.getAttribute("CumPerc"));
                    certificaLineRow.setAttribute("CumSupOnlyQty_Trans",
                                                  ApplicationLineRow.getAttribute("CumSupOnlyQty"));
                    certificaLineRow.setAttribute("CumSupInsQty_Trans",
                                                  ApplicationLineRow.getAttribute("CumSupInsQty"));
                    certificaLineRow.setAttribute("CumTotQty_Trans",
                                                  ApplicationLineRow.getAttribute("CumTotQty"));
                    certificaLineRow.setAttribute("CumAmount_Trans",
                                                  ApplicationLineRow.getAttribute("CumAmount"));
                    // Others
                    certificaLineRow.setAttribute("Remarks",
                                                  ApplicationLineRow.getAttribute("Remarks"));
                    certificaLineRow.setAttribute("OrgId",
                                                  ApplicationLineRow.getAttribute("OrgId"));
                    certificaLineRow.setAttribute("ObjectVersionNumber",
                                                  ApplicationLineRow.getAttribute("ObjectVersionNumber"));
                    certificaLineRow.setAttribute("ContLineId",
                                                  ApplicationLineRow.getAttribute("ContLineId"));
                    certificaLineRow.setAttribute("Version",
                                                  ApplicationLineRow.getAttribute("Version"));
                    // tax
                    certificaLineRow.setAttribute("TaxCode",
                                                  ApplicationLineRow.getAttribute("TaxCode"));
                    certificaLineRow.setAttribute("TaxRate",
                                                  ApplicationLineRow.getAttribute("TaxRate"));
                    certificaLineRow.setAttribute("TaxAmount",
                                                  ApplicationLineRow.getAttribute("TaxAmount"));
                    // Advance/Retention %
                    certificaLineRow.setAttribute("AdvRecPer",
                                                  ApplicationLineRow.getAttribute("AdvRecPer"));
                    certificaLineRow.setAttribute("RetRecPer",
                                                  ApplicationLineRow.getAttribute("RetRecPer"));

                    certificationLineVO.insertRow(certificaLineRow);
                    //System.err.println("=================Certification lines inserted========");
                    //System.out.println("APP HEAD ID===>" +
                    //                                       ApplicationLineRow.getAttribute("ApplHeaderId") +
                    //                                       "LINE ID===>" +
                    //                                       ApplicationLineRow.getAttribute("ApplLineId"));
                    //System.err.println("CERT APP HEAD ID===" +
                    //                                       certificaLineRow.getAttribute("ApplHeaderId") +
                    //                                       "--CERT Line ID--" +
                    //                                       certificaLineRow.getAttribute("ApplLineId"));
                }
                certificationLineVO.executeQuery();
                AdfFacesContext.getCurrentInstance().addPartialTarget(t2);
                applHeaderNumber.setDisabled(Boolean.TRUE);
                AdfFacesContext.getCurrentInstance().addPartialTarget(applHeaderNumber);

                RowSetIterator othRS =
                    PayApplOthChargesVO1.createRowSetIterator(null);
                while (othRS.hasNext()) {
                    Row ApplicationLineOthChargeRow = othRS.next();
                    Row certificaLineOtherRow =
                        CertificationOthChargesVO.createRow();
                    certificaLineOtherRow.setAttribute("CertHeaderId",
                                                       certHdrID);
                    certificaLineOtherRow.setAttribute("ChargeType",
                                                       ApplicationLineOthChargeRow.getAttribute("ChargeType"));
                    certificaLineOtherRow.setAttribute("ChargeAmt",
                                                       ApplicationLineOthChargeRow.getAttribute("ChargeAmt"));
                    certificaLineOtherRow.setAttribute("ChargeAmt",
                                                       ApplicationLineOthChargeRow.getAttribute("ChargeAmt"));
                    certificaLineOtherRow.setAttribute("ChargeName",
                                                       ApplicationLineOthChargeRow.getAttribute("ChargeName"));
                    certificaLineOtherRow.setAttribute("Reason",
                                                       ApplicationLineOthChargeRow.getAttribute("Reason"));
                    CertificationOthChargesVO.insertRow(certificaLineOtherRow);
                    CertificationOthChargesVO.executeQuery();
                    AdfFacesContext.getCurrentInstance().addPartialTarget(t9);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(curOth);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(prevOth);
                    AdfFacesContext.getCurrentInstance().addPartialTarget(totOth);
                }
            }
        }
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell") ||
            ADFContext.getCurrent().getSessionScope().get("page").equals("certificationSell") ||
            ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
            insadvance(certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId"),
                       certificationHrdVO.getCurrentRow().getAttribute("ContHeaderId"),
                       valueChangeEvent.getNewValue(),
                       certificationHrdVO.getCurrentRow().getAttribute("PaymentType"));
            AdvanceVO.executeQuery();
            AdvanceRecVO.executeQuery();
            //System.err.println("Typeee cert------>" +
            //                               certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId"));
            //System.err.println("Typeee cont------>" +
            //                               certificationHrdVO.getCurrentRow().getAttribute("ContHeaderId"));
            //System.err.println("Typeee------>" +
            //                               certificationHrdVO.getCurrentRow().getAttribute("PaymentType"));
            //System.err.println("Typeee appid------>" +
            //                               valueChangeEvent.getNewValue());
        }
    }

    private void removeExistingRow() {
        if (certificationLineVO.getEstimatedRowCount() > 0) {
            RowSetIterator rs = certificationLineVO.createRowSetIterator(null);
            while (rs.hasNext()) {
                Row r = rs.next();
                r.remove();
            }
        }
        if (CertificationOthChargesVO.getEstimatedRowCount() > 0) {
            RowSetIterator rs =
                CertificationOthChargesVO.createRowSetIterator(null);
            while (rs.hasNext()) {
                Row r = rs.next();
                r.remove();
            }
        }
    }


    public void setPrevApplication(RichInputText prevApplication) {
        this.prevApplication = prevApplication;
    }

    public RichInputText getPrevApplication() {
        return prevApplication;
    }

    public void setCurCert(RichInputText curCert) {
        this.curCert = curCert;
    }

    public RichInputText getCurCert() {
        return curCert;
    }

    public void setPrevPayAmount(RichInputText prevPayAmount) {
        this.prevPayAmount = prevPayAmount;
    }

    public RichInputText getPrevPayAmount() {
        return prevPayAmount;
    }

    public void setCurPayAmount(RichInputText curPayAmount) {
        this.curPayAmount = curPayAmount;
    }

    public RichInputText getCurPayAmount() {
        return curPayAmount;
    }

    public void setTotalAmount(RichInputText totalAmount) {
        this.totalAmount = totalAmount;
    }

    public RichInputText getTotalAmount() {
        return totalAmount;
    }

    public void setPrevAdvRec(RichInputText prevAdvRec) {
        this.prevAdvRec = prevAdvRec;
    }

    public RichInputText getPrevAdvRec() {
        return prevAdvRec;
    }

    public void setCurAdvRev(RichInputText curAdvRev) {
        this.curAdvRev = curAdvRev;
    }

    public RichInputText getCurAdvRev() {
        return curAdvRev;
    }

    public void setBalanceAdvRec(RichInputText balanceAdvRec) {
        this.balanceAdvRec = balanceAdvRec;
    }

    public RichInputText getBalanceAdvRec() {
        return balanceAdvRec;
    }

    public void setTotalRet(RichInputText totalRet) {
        this.totalRet = totalRet;
    }

    public RichInputText getTotalRet() {
        return totalRet;
    }

    public void setPrevRet(RichInputText prevRet) {
        this.prevRet = prevRet;
    }

    public RichInputText getPrevRet() {
        return prevRet;
    }

    public void setCurRet(RichInputText curRet) {
        this.curRet = curRet;
    }

    public RichInputText getCurRet() {
        return curRet;
    }

    public void setBalanceRet(RichInputText balanceRet) {
        this.balanceRet = balanceRet;
    }

    public RichInputText getBalanceRet() {
        return balanceRet;
    }

    public String onClickCalculateAmount() throws SQLException {
        if (paymentType.getValue().toString().equals("Advance")) {
            // TotalAdvanceCalculation
            TotalAdvanceCalculation();
        } else if (paymentType.getValue().toString().equals("Material Advance")) {
            //            TotalMaterialAdvanceCalculation
            TotalMaterialAdvanceCalculation();
        } else if (paymentType.getValue().toString().equals("Interim")) {
            //            CalculateAmount1
            CalculateAmount1();
        } else if (paymentType.getValue().toString().equals("Final")) {
            // Final
            CalculateAmount1();
        }
        return null;
    }

    // Button : Advance Calculation

    public void TotalMaterialAdvanceCalculation() {
        //System.err.println("======Row count====" +
        //                           certificationHrdVO.getEstimatedRowCount());
        double Mat_Adv_amt = 0;
        double cur_amt = 0;
        double pre_amt = 0;
        double balance = 0;
        Mat_Adv_amt =
                mat_Adv_amt.getValue() == null ? 0 : Double.parseDouble(mat_Adv_amt.getValue().toString());

        //       cur_amt =curCertification.getValue() == null ? 0 : Double.parseDouble(curCertification.getValue().toString());
        cur_amt =
                curCert.getValue() == null ? 0 : Double.parseDouble(curCert.getValue().toString());

        pre_amt =
                prevApplication.getValue() == null ? 0 : Double.parseDouble(prevApplication.getValue().toString());
        balance = Mat_Adv_amt - (cur_amt + pre_amt);
        //System.err.println("===Advance Amount===" + Mat_Adv_amt);
        certificationHrdVO.getCurrentRow().setAttribute("TotalMatAdvAmount",
                                                        new BigDecimal(df.format(Mat_Adv_amt)));
        certificationHrdVO.getCurrentRow().setAttribute("BalContAmt",
                                                        new BigDecimal(df.format(balance)));
        certificationHrdVO.getCurrentRow().setAttribute("CurPayAmount",
                                                        new BigDecimal(df.format(cur_amt)));
        AdfFacesContext.getCurrentInstance().addPartialTarget(curPayAmount);
        AdfFacesContext.getCurrentInstance().addPartialTarget(bal_cont_amt);
        AdfFacesContext.getCurrentInstance().addPartialTarget(tot_mat_adv_amt);
        // Tax
        String txCode = "0";
        String hdrtaxrate = "0";
        String txAmt = "0";
        String txRate = "0";
        BigDecimal txAmtBD = new BigDecimal("0");
        BigDecimal totlTxAmtBD = new BigDecimal("0");
        RowSetIterator rsi = certificationLineVO.createRowSetIterator(null);
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
        //            certificationHrdVO.getCurrentRow().getAttribute("Taxrate") ==
        //            null ? 0 :
        //            Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("Taxrate").toString());
        certificationHrdVO.getCurrentRow().setAttribute("Taxrate", taxRate);
        AdfFacesContext.getCurrentInstance().addPartialTarget(taxRateApp);
        double tax_Amt = totlTxAmtBD.doubleValue();
        //        double tax_Amt = (taxRate * cur_amt) / 100;

        /**
                                    * * Including charges
                                    */
        double contra_charge =
            certificationHrdVO.getCurrentRow().getAttribute("ContraCharges") ==
            null ? 0 :
            Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("ContraCharges").toString());
        double penality_charge =
            certificationHrdVO.getCurrentRow().getAttribute("PenaltyCharges") ==
            null ? 0 :
            Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("PenaltyCharges").toString());
        double taxrate =
            Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("Taxrate").toString());
        double amount1 = ((contra_charge + penality_charge) * taxrate) / 100;
        double amountWithcharges = tax_Amt - amount1;

        //        certificationHrdVO.getCurrentRow().setAttribute("Curpaytaxamount",
        //                                                        new BigDecimal(df.format(tax_Amt)));
        certificationHrdVO.getCurrentRow().setAttribute("Curpaytaxamount",
                                                        new BigDecimal(df.format(amountWithcharges)));
        AdfFacesContext.getCurrentInstance().addPartialTarget(curPayTaxAmount1);
    }

    // Button : Advance Calculation

    public void TotalAdvanceCalculation() {
        //        #{sessionScope.page eq 'certificationBuy'|| sessionScope.page eq 'applicationBuy'}
        //        #{sessionScope.page eq 'certificationSell'||sessionScope.page eq 'application'}
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationBuy") ||
            ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
            //System.err.println("======Row count====" +
            //                               certificationHrdVO.getEstimatedRowCount());
            double Adv_amt = 0;
            double cur_amt = 0;
            double pre_amt = 0;
            double balance = 0;
            Adv_amt =
                    trans_adv_rec.getValue() == null ? 0 : Double.parseDouble(trans_adv_rec.getValue().toString());
            //        cur_amt =curCertification.getValue() == null ? 0 : Double.parseDouble(curCertification.getValue().toString());
            cur_amt =
                    curCert.getValue() == null ? 0 : Double.parseDouble(curCert.getValue().toString());
            pre_amt =
                    prevApplication.getValue() == null ? 0 : Double.parseDouble(prevApplication.getValue().toString());
            balance = Adv_amt - (cur_amt + pre_amt);
            //System.err.println("===Advance Amount===" + Adv_amt);
            certificationHrdVO.getCurrentRow().setAttribute("TotalAdvAmount",
                                                            new BigDecimal(df.format(Adv_amt)));
            certificationHrdVO.getCurrentRow().setAttribute("BalContAmt",
                                                            new BigDecimal(df.format(balance)));
            certificationHrdVO.getCurrentRow().setAttribute("CurPayAmount",
                                                            new BigDecimal(df.format(cur_amt)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(curPayAmount);
            AdfFacesContext.getCurrentInstance().addPartialTarget(bal_cont_amt);
            AdfFacesContext.getCurrentInstance().addPartialTarget(tot_Cont_Amt);
            // Tax
            //            ---------------
            String contLineVrsn = "0";
            String txCode = "0";
            String txAmt = "0";
            String txRate = "0";
            String contAdv = "0";
            BigDecimal txAmtBD = new BigDecimal("0");
            BigDecimal totlcontAdvBD = new BigDecimal("0");
            BigDecimal contAdvBD = new BigDecimal("0");
            BigDecimal fivePrcnt = new BigDecimal("0");
            String certHdrVrsn =
                certificationHrdVO.getCurrentRow().getAttribute("Version") ==
                null ? "0" :
                certificationHrdVO.getCurrentRow().getAttribute("Version").toString();
            String headerid =
                certificationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
                null ? "0" :
                certificationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
            ViewObject conlinevo =
                ADFUtils.findIterator("contractLineROVO1Iterator1").getViewObject();
            conlinevo.setNamedWhereClauseParam("BV_CONTID", headerid);
            conlinevo.executeQuery();
            String hdrtaxrate =
                conlinevo.first().getAttribute("TaxRate") == null ? "0" :
                conlinevo.first().getAttribute("TaxRate").toString();
            RowSetIterator rsi = conlinevo.createRowSetIterator(null);
            while (rsi.hasNext()) {
                Row rw = rsi.next();
                contLineVrsn =
                        rw.getAttribute("Version") == null ? "0" : rw.getAttribute("Version").toString();
                txCode =
                        rw.getAttribute("TaxCode") == null ? "0" : rw.getAttribute("TaxCode").toString();
                if (!txCode.equalsIgnoreCase("REVERSE CHARGE") &&
                    contLineVrsn.equals(certHdrVrsn)) {
                    //                txAmt = rw.getAttribute("TaxAmount")==null?"0":rw.getAttribute("TaxAmount").toString();
                    contAdv =
                            rw.getAttribute("ContAdv") == null ? "0" : rw.getAttribute("ContAdv").toString();
                    contAdvBD = new BigDecimal(contAdv);
                    totlcontAdvBD = totlcontAdvBD.add(contAdvBD);
                    txRate =
                            rw.getAttribute("TaxRate") == null ? "0" : rw.getAttribute("TaxRate").toString();
                    if (!txRate.equals("0")) {
                        hdrtaxrate = "5";
                        fivePrcnt = new BigDecimal("0.05");
                    }
                }
                if (txCode.equalsIgnoreCase("REVERSE CHARGE") &&
                    contLineVrsn.equals(certHdrVrsn)) {
                    hdrtaxrate = "0";
                }
            }
            rsi.closeRowSetIterator();

            //                 if(hdrtaxrate.equalsIgnoreCase("0"))
            //                 {
            //                     certificationHrdVO.getCurrentRow().setAttribute("Curpaytaxamount",
            //                                                                     new BigDecimal(df.format(0)));
            //                     AdfFacesContext.getCurrentInstance().addPartialTarget(curPayTaxAmount1);
            //                 }
            //                 else{
            double taxRate = Double.valueOf(hdrtaxrate);
            //                certificationHrdVO.getCurrentRow().getAttribute("Taxrate") ==
            //                null ? 0 :
            //                Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("Taxrate").toString());
            certificationHrdVO.getCurrentRow().setAttribute("Taxrate",
                                                            taxRate);
            AdfFacesContext.getCurrentInstance().addPartialTarget(taxRateApp);
            //            double tax_Amt = (taxRate * cur_amt) / 100;
            double tax_Amt = (totlcontAdvBD.multiply(fivePrcnt)).doubleValue();
            /**
                                      * * Including charges
                                      */
            double contra_charge =
                certificationHrdVO.getCurrentRow().getAttribute("ContraCharges") ==
                null ? 0 :
                Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("ContraCharges").toString());
            double penality_charge =
                certificationHrdVO.getCurrentRow().getAttribute("PenaltyCharges") ==
                null ? 0 :
                Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("PenaltyCharges").toString());
            double taxrate =
                Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("Taxrate").toString());
            double amount1 =
                ((contra_charge + penality_charge) * taxrate) / 100;
            double amountWithcharges = tax_Amt - amount1;
//            certificationHrdVO.getCurrentRow().setAttribute("Curpaytaxamount",
//                                                            new BigDecimal(df.format(tax_Amt)));
                        certificationHrdVO.getCurrentRow().setAttribute("Curpaytaxamount",
                                                            new BigDecimal(df.format(amountWithcharges)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(curPayTaxAmount1);
            //                 }
            //            --------------

        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationSell") ||
                   ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
            RowSetIterator rs = AdvanceVO.createRowSet(null);
            double sum = 0;
            while (rs.hasNext()) {
                Row r = rs.next();
                sum +=
Double.parseDouble(r.getAttribute("AdvanceAmt").toString());
            }
            //            String Hid =
            //                certificationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
            //                null ? "0" :
            //                certificationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
            //
            //            ViewObject vo =
            //                ADFUtils.findIterator("AdvPrevAmt_ROVO1Iterator").getViewObject();
            //            vo.setNamedWhereClauseParam("BV_cont_ID", Hid);
            //            vo.executeQuery();
            //            //System.err.println("row count==>" + vo.getEstimatedRowCount());
            //            double prevamt =
            //                vo.first().getAttribute("Amount") == null ? 0 : Double.parseDouble(vo.first().getAttribute("Amount").toString());

            certificationHrdVO.getCurrentRow().setAttribute("CurCertification",
                                                            new BigDecimal(df.format(sum)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(curCertification);
            certificationHrdVO.getCurrentRow().setAttribute("CurPayAmount",
                                                            new BigDecimal(df.format(sum)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(curPayAmount);
            //            certificationHrdVO.getCurrentRow().setAttribute("PrevApplication",
            //                                                            new BigDecimal(df.format(prevamt)));
            //            AdfFacesContext.getCurrentInstance().addPartialTarget(prevApplication);
            // Tax
            //        applicationHrdVO.getCurrentRow().setAttribute("Taxrate", 5);
            //        AdfFacesContext.getCurrentInstance().addPartialTarget(taxRateApp);
            //        double tax_Amt = (5 * cur_amt) / 100;
            //        applicationHrdVO.getCurrentRow().setAttribute("Curpaytaxamount",
            //                                                      new BigDecimal(df.format(tax_Amt)));
            //        AdfFacesContext.getCurrentInstance().addPartialTarget(curPayTaxAmount1);
        }
    }

    public void curentRetention() throws SQLException {
        RowSetIterator rs = certificationLineVO.createRowSetIterator(null);
        double sum = 0;
        while (rs.hasNext()) {
            Row r = rs.next();
            sum +=
Double.parseDouble(r.getAttribute("CurRetRecAmount") != null ?
                   r.getAttribute("CurRetRecAmount").toString() : "0.0");

        }
        //               -----------------------
        if (certificationHrdVO.getCurrentRow().getAttribute("PaymentType").toString().equalsIgnoreCase("Final")) {
            //                          double sum1 = 0;
            //            double TotalReten =
            //                totalRet.getValue() == null ? 0 : Double.parseDouble(totalRet.getValue().toString());
            //            double PrevRe =
            //                prevRet.getValue() == null ? 0 : Double.parseDouble(prevRet.getValue().toString());
            //            double CurRet =
            //                curRet.getValue() == null ? 0 : Double.parseDouble(curRet.getValue().toString());
            //            sum1 = TotalReten - PrevRe - CurRet;
            //                   certificationHrdVO.getCurrentRow().setAttribute("CurRet",
            //                                                                new BigDecimal(df.format(sum1)));
            //                                  AdfFacesContext.getCurrentInstance().addPartialTarget(curReten);
        } else {
            certificationHrdVO.getCurrentRow().setAttribute("CurRet",
                                                            new BigDecimal(df.format(sum)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(curReten);
        }
        //               ------------------------

        //               double cur_app =
        //                   CurApplication.getValue() == null ? 0 : Double.parseDouble(CurApplication.getValue().toString());
        //
        //               double percentage=(sum/cur_app)*100;
        //               Number curadvPerc=new Number(percentage);
        //               applicationHrdVO.getCurrentRow().setAttribute("Curretper",curadvPerc);
        //               AdfFacesContext.getCurrentInstance().addPartialTarget(CurRet);
    }

    // Button : Interim Calculation

    public void CalculateAmount1() throws SQLException {
        CumulativeAdvanceRecoveryRetention();
        CurrentApplicationAmount();
        // PreviousAppliedAmount();
        // Retention
        double ret_amt =
            trans_ret_amt.getValue() == null ? 0 : Double.parseDouble(trans_ret_amt.getValue().toString());
        certificationHrdVO.getCurrentRow().setAttribute("TotalRet",
                                                        new BigDecimal(df.format(ret_amt)));
        AdfFacesContext.getCurrentInstance().addPartialTarget(totalRet);
        //        double cur_cet =curCertification.getValue() == null ? 0 : Double.parseDouble(curCertification.getValue().toString());
        double cur_cet =
            curCert.getValue() == null ? 0 : Double.parseDouble(curCert.getValue().toString());

        //        double cur_cet =certificationHrdVO.getCurrentRow().getAttribute("CurCertification")==null?0:Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("CurCertification").toString());

        /**
 * old retention
 */
        //        double re_per =
        //            ret_per.getValue() == null ? 0 : Double.parseDouble(ret_per.getValue().toString());
        //        double cur_ret = (cur_cet * re_per) / 100;
        //        certificationHrdVO.getCurrentRow().setAttribute("CurRet",
        //                                                        new BigDecimal(df.format(cur_ret)));
        //        AdfFacesContext.getCurrentInstance().addPartialTarget(curRet);
        curentRetention();
        double Adv_amt = 0;
        Adv_amt =
                trans_adv_rec.getValue() == null ? 0 : Double.parseDouble(trans_adv_rec.getValue().toString());
        //System.err.println("===Advance Amount===" + Adv_amt);
        certificationHrdVO.getCurrentRow().setAttribute("TotalAdvAmount",
                                                        new BigDecimal(df.format(Adv_amt)));

        materialadvanceamount();
        CurrentAdvanceRecovery();
        CurrentMaterialAdvanceRecovery();
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy") ||
            ADFContext.getCurrent().getSessionScope().get("page").equals("certificationBuy") ||
            ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
            // Balance Calculation
            BalanceAdvanceRecovery();
            BalanceMaterialAdvanceRecovery();
            BalanceRetention();
            BalanceContractAmt();
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell") ||
                   ADFContext.getCurrent().getSessionScope().get("page").equals("certificationSell") ||
                   ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
            penalty_back_charges();
        }
        netpaymentamt();
        // penality charges
    }

    public void penalty_back_charges() {
        double Mat_onsite =
            certificationHrdVO.getCurrentRow().getAttribute("MatOnSite") ==
            null ? 0 :
            Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("MatOnSite").toString());
        double Mat_onsite_rec =
            certificationHrdVO.getCurrentRow().getAttribute("MatOnSiteRec") ==
            null ? 0 :
            Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("MatOnSiteRec").toString());
        double Cur_mat = Mat_onsite - Mat_onsite_rec;
        certificationHrdVO.getCurrentRow().setAttribute("CurMatOnSiteRec",
                                                        Cur_mat);
        AdfFacesContext.getCurrentInstance().addPartialTarget(cum_mat_adv_amt);
    }
    // Interim material advance amount

    public void materialadvanceamount() {
        double mat_adv_amount = 0;
        mat_adv_amount =
                mat_Adv_amt.getValue() == null ? 0 : Double.parseDouble(mat_Adv_amt.getValue().toString());
        //System.err.println("===mat Advance Amount===" + mat_adv_amount);
        certificationHrdVO.getCurrentRow().setAttribute("TotalMaterialAdvAmount",
                                                        new BigDecimal(df.format(mat_adv_amount)));
        AdfFacesContext.getCurrentInstance().addPartialTarget(tot_mat_adv_amt);

    }

    double cumAdv = 0;
    double cumret = 0;
    double cummatadv = 0;

    public void CumulativeAdvanceRecoveryRetention() {
        double cumAdv = 0;
        double cumret = 0;
        double cummatadv = 0;
        double prevAmount = 0;
        try {
            RowSetIterator Applines =
                certificationLineVO.createRowSetIterator(null);
            double sum = 0;
            double peradvrec =
                certificationHrdVO.getCurrentRow().getAttribute("PrevAdvRec") ==
                null ? 0 :
                Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("PrevAdvRec").toString());
            double curadvrec =
                certificationHrdVO.getCurrentRow().getAttribute("CurAdvRec") ==
                null ? 0 :
                Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("CurAdvRec").toString());
            double preret =
                certificationHrdVO.getCurrentRow().getAttribute("PrevRet") ==
                null ? 0 :
                Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("PrevRet").toString());
            double curret =
                certificationHrdVO.getCurrentRow().getAttribute("CurRet") ==
                null ? 0 :
                Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("CurRet").toString());
            double prematrec =
                certificationHrdVO.getCurrentRow().getAttribute("PrevMatAdvAmt") ==
                null ? 0 :
                Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("PrevMatAdvAmt").toString());
            double curmatrec =
                certificationHrdVO.getCurrentRow().getAttribute("CurMatAdvRec") ==
                null ? 0 :
                Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("CurMatAdvRec").toString());
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
            certificationHrdVO.getCurrentRow().setAttribute("CumApplication",
                                                            new BigDecimal(df.format(sum)));
            //            AdfFacesContext.getCurrentInstance().addPartialTarget(cum_Amt);
            certificationHrdVO.getCurrentRow().setAttribute("CumAdvRec",
                                                            new BigDecimal(df.format(cumAdv)));
            //            AdfFacesContext.getCurrentInstance().addPartialTarget(cum_adv_rec);
            certificationHrdVO.getCurrentRow().setAttribute("CumMatAdvRec",
                                                            new BigDecimal(df.format(cummatadv)));
            //            AdfFacesContext.getCurrentInstance().addPartialTarget(cum_mat_adv_rec);
            certificationHrdVO.getCurrentRow().setAttribute("CumRet",
                                                            new BigDecimal(df.format(cumret)));
            //            AdfFacesContext.getCurrentInstance().addPartialTarget(cum_ret);
        } catch (Exception e) {
            //System.err.println("====Error====" + e);
        }
        //        try {
        //            RowSetIterator Applines =
        //                certificationLineVO.createRowSetIterator(null);
        //            double sum = 0;
        //            while (Applines.hasNext()) {
        //                Row r = Applines.next();
        //                if (r.getAttribute("CumAmount") != null) {
        //                    sum =sum + Double.parseDouble(r.getAttribute("CumAmount").toString());
        //                    double advper =Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("cont_Adv_Recovery").toString());
        //                    double Retper =Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("cont_Ret_Recovery").toString());
        //                    double MatPer =Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("cont_Mat_Recovery").toString());
        //                    cumAdv +=(Double.parseDouble(r.getAttribute("CumAmount").toString()) *
        //                             advper) / 100;
        //                    cumret +=(Double.parseDouble(r.getAttribute("CumAmount").toString()) *
        //                             Retper) / 100;
        //                    cummatadv +=
        //                            (Double.parseDouble(r.getAttribute("CumAmount").toString()) *
        //                             MatPer) / 100;
        //                }
        //            }
        //            //System.err.println("=====cummulative Applied Amount=====" + sum);
        //            certificationHrdVO.getCurrentRow().setAttribute("CumApplication",
        //                                                            new BigDecimal(sum));
        //            AdfFacesContext.getCurrentInstance().addPartialTarget(cum_Appl);
        //            certificationHrdVO.getCurrentRow().setAttribute("CumAdvRec",
        //                                                            new BigDecimal(cumAdv));
        //            AdfFacesContext.getCurrentInstance().addPartialTarget(cum_Adv_Rec);
        //            certificationHrdVO.getCurrentRow().setAttribute("CumMatAdvRec",
        //                                                            new BigDecimal(cummatadv));
        //            AdfFacesContext.getCurrentInstance().addPartialTarget(cum_mat_adv_amt);
        //            certificationHrdVO.getCurrentRow().setAttribute("CumRet",
        //                                                            new BigDecimal(cumret));
        //            AdfFacesContext.getCurrentInstance().addPartialTarget(cum_Ret);
        //        } catch (Exception e) {
        //            //System.err.println("====Error====" + e);
        //        }
    }
    // Interim BalanceContractAmt

    public void BalanceContractAmt() {
        double balanceamt = 0;
        double tot_amt =
            tot_Cont_Amt.getValue() == null ? 0 : Double.parseDouble(tot_Cont_Amt.getValue().toString());
        double prev_amt =
            prevApplication.getValue() == null ? 0 : Double.parseDouble(prevApplication.getValue().toString());
        //        double cur_amt =curCertification.getValue() == null ? 0 : Double.parseDouble(curCertification.getValue().toString());
        double cur_amt =
            curCert.getValue() == null ? 0 : Double.parseDouble(curCert.getValue().toString());

        balanceamt = tot_amt - prev_amt - cur_amt;
        certificationHrdVO.getCurrentRow().setAttribute("BalContAmt",
                                                        new BigDecimal(df.format(balanceamt)));
        AdfFacesContext.getCurrentInstance().addPartialTarget(bal_cont_amt);

    }
    // Interim netpaymentamt

    public void netpaymentamt() {
        double netpayamt = 0;
        double netamount = 0;
        double amount = 0;
        double contrapenality = 0;
        double cur_mat_adv_ret = 0;
        double cur_cet =
            certificationHrdVO.getCurrentRow().getAttribute("CurCertification") ==
            null ? 0 :
            Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("CurCertification").toString());
        double cur_adv_rec =
            certificationHrdVO.getCurrentRow().getAttribute("CurAdvRec") ==
            null ? 0 :
            Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("CurAdvRec").toString());
        double cur_ret =
            certificationHrdVO.getCurrentRow().getAttribute("CurRet") == null ?
            0 :
            Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("CurRet").toString());
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy") ||
            ADFContext.getCurrent().getSessionScope().get("page").equals("certificationBuy") ||
            ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
            cur_mat_adv_ret =
                    certificationHrdVO.getCurrentRow().getAttribute("CurMatAdvRec") ==
                    null ? 0 :
                    Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("CurMatAdvRec").toString());
        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell") ||
                   ADFContext.getCurrent().getSessionScope().get("page").equals("certificationSell") ||
                   ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
            cur_mat_adv_ret =
                    certificationHrdVO.getCurrentRow().getAttribute("CurMatOnSiteRec") ==
                    null ? 0 :
                    Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("CurMatOnSiteRec").toString());
        }
        double contraCharge =
            certificationHrdVO.getCurrentRow().getAttribute("ContraCharges") ==
            null ? 0 :
            Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("ContraCharges").toString());
        double penaltyCharge =
            certificationHrdVO.getCurrentRow().getAttribute("PenaltyCharges") ==
            null ? 0 :
            Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("PenaltyCharges").toString());
        double totOthValue =
            certificationHrdVO.getCurrentRow().getAttribute("CurOthCharge") ==
            null ? 0 :
            Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("CurOthCharge").toString());
        //        double cur_cet =curCertification.getValue() == null ? 0 : Double.parseDouble(curCertification.getValue().toString());
        //        double cur_cet =
        //            curCert.getValue() == null ? 0 : Double.parseDouble(curCert.getValue().toString());
        //        double cur_adv_rec =
        //            curAdvRev.getValue() == null ? 0 : Double.parseDouble(curAdvRev.getValue().toString());
        //        double cur_ret =
        //            curRet.getValue() == null ? 0 : Double.parseDouble(curRet.getValue().toString());
        //        double cur_mat_adv_ret =
        //            cur_mat_on_site_rec.getValue() == null ? 0 : Double.parseDouble(cur_mat_on_site_rec.getValue().toString());
        //        double contraCharge =
        //            certificationHrdVO.getCurrentRow().getAttribute("ContraCharges") ==
        //            null ? 0 :
        //            Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("ContraCharges").toString());
        //        double penaltyCharge =
        //            certificationHrdVO.getCurrentRow().getAttribute("PenaltyCharges") ==
        //            null ? 0 :
        //            Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("PenaltyCharges").toString());
        //        //        double totalOtherCharg =certificationHrdVO.getCurrentRow().getAttribute("TotOthCharge") ==
        //        //                             null ? 0 :Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("TotOthCharge").toString());
        //        double totOthValue =
        //            curOtherCharge.getValue() == null ? 0 : Double.parseDouble(curOtherCharge.getValue().toString());
        //System.err.println("total oth charges - - > " + totOthValue);
        contrapenality = contraCharge + penaltyCharge;
        //System.err.println("contra==> " + contrapenality);
        amount = cur_adv_rec + cur_ret + cur_mat_adv_ret;
        //System.err.println("amount==>" + amount);
        netamount = cur_cet - amount;
        //System.err.println("netamount==>" + netamount);
        netpayamt = netamount - contrapenality + totOthValue;
        //System.err.println("net pay==>" + netpayamt);
        certificationHrdVO.getCurrentRow().setAttribute("CurPayAmount",
                                                        new BigDecimal(df.format(netpayamt)));
        AdfFacesContext.getCurrentInstance().addPartialTarget(curPayAmount);

        // Tax Amount
        //          RowSetIterator cerLnsRS=certificationLineVO.createRowSet(null);
        //          double totalTaxAmt=0;
        //          while(cerLnsRS.hasNext()){
        //            Row r=cerLnsRS.next();
        //            double taxAmt =r.getAttribute("TaxAmount") == null ? 0 : Double.parseDouble(r.getAttribute("TaxAmount").toString());
        //            totalTaxAmt=totalTaxAmt+taxAmt;
        //          }
        //tax
        String txCode = "0";
        String hdrtaxrate = "0";
        String txAmt = "0";
        String txRate = "0";
        BigDecimal vartaxamount = new BigDecimal("0");
        BigDecimal txAmtBD = new BigDecimal("0");
        BigDecimal totlTxAmtBD = new BigDecimal("0");
        BigDecimal percnt = new BigDecimal("100");
        RowSetIterator rsi = certificationLineVO.createRowSetIterator(null);
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
        //            certificationHrdVO.getCurrentRow().getAttribute("Taxrate") ==
        //            null ? 0 :
        //            Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("Taxrate").toString());
        double totalTaxAmt = totlTxAmtBD.doubleValue();
        //        double totalTaxAmt = (taxRate * netamount) / 100;
        //        certificationHrdVO.getCurrentRow().setAttribute("Curpaytaxamount",
        //                                                        new BigDecimal(df.format(totalTaxAmt)));
        //        certificationHrdVO.getCurrentRow().setAttribute("Curpaytaxamount",
        //                                                        (new BigDecimal(df.format(netpayamt))).multiply(new BigDecimal(df.format(taxRate))).divide(percnt));
        System.err.println("Curpaytaxamount in netpaymentamt method" +
                           totalTaxAmt);
        /**
                            * * Including charges
                            */
        double contra_charge =
            certificationHrdVO.getCurrentRow().getAttribute("ContraCharges") ==
            null ? 0 :
            Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("ContraCharges").toString());
        double penality_charge =
            certificationHrdVO.getCurrentRow().getAttribute("PenaltyCharges") ==
            null ? 0 :
            Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("PenaltyCharges").toString());
        double taxrate =certificationHrdVO.getCurrentRow().getAttribute("Taxrate")==null?0:
            Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("Taxrate").toString());
        double amount1 = ((contra_charge + penality_charge) * taxrate) / 100;
     /**
      * Arun changes 19-02-24
      */
        if( paymentType.getValue().toString().equals("Final"))
        {
         double finaltaxamount=(netpayamt* taxrate)/100;
                  certificationHrdVO.getCurrentRow().setAttribute("Curpaytaxamount",
                                                                new BigDecimal(df.format(finaltaxamount)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(curPayTaxAmount);
            AdfFacesContext.getCurrentInstance().addPartialTarget(curPayTaxAmount1);
        }
        else{
        double amountWithcharges = totalTaxAmt - amount1;
        //        certificationHrdVO.getCurrentRow().setAttribute("Curpaytaxamount",
        //                                                        new BigDecimal(df.format(totalTaxAmt)));
        certificationHrdVO.getCurrentRow().setAttribute("Curpaytaxamount",
                                                        new BigDecimal(df.format(amountWithcharges)));

        AdfFacesContext.getCurrentInstance().addPartialTarget(curPayTaxAmount);
        AdfFacesContext.getCurrentInstance().addPartialTarget(curPayTaxAmount1);
        
        }
    }


    public void TotalAdvanceAmount1() {
        //System.err.println("======Row count====" +
        //                           certificationHrdVO.getEstimatedRowCount());
        double Adv_amt = 0;
        Adv_amt =
                trans_adv_rec.getValue() == null ? 0 : Double.parseDouble(trans_adv_rec.getValue().toString());
        //System.err.println("===Advance Amount===" + Adv_amt);
        certificationHrdVO.getCurrentRow().setAttribute("TotalAdvAmount",
                                                        new BigDecimal(Adv_amt));
        certificationHrdVO.getCurrentRow().setAttribute("CurCertification",
                                                        Adv_amt);
        certificationHrdVO.getCurrentRow().setAttribute("CurPayAmount",
                                                        new BigDecimal(Adv_amt));
        AdfFacesContext.getCurrentInstance().addPartialTarget(curPayAmount);
        AdfFacesContext.getCurrentInstance().addPartialTarget(curCert);
        AdfFacesContext.getCurrentInstance().addPartialTarget(totalAmount);

    }

    public void TotalMaterialAdvAmount1() {
        //System.err.println("======Row count====" +
        //                           certificationHrdVO.getEstimatedRowCount());
        double mat_Adv_amount = 0;
        mat_Adv_amount =
                mat_Adv_amt.getValue() == null ? 0 : Double.parseDouble(mat_Adv_amt.getValue().toString());
        //System.err.println("===Advance Amount===" + mat_Adv_amount);
        certificationHrdVO.getCurrentRow().setAttribute("TotalMatAdvAmount",
                                                        new BigDecimal(mat_Adv_amount));
        certificationHrdVO.getCurrentRow().setAttribute("CurCertification",
                                                        mat_Adv_amount);
        certificationHrdVO.getCurrentRow().setAttribute("CurPayAmount",
                                                        new BigDecimal(mat_Adv_amount));
        AdfFacesContext.getCurrentInstance().addPartialTarget(curPayAmount);
        AdfFacesContext.getCurrentInstance().addPartialTarget(curCert);
        AdfFacesContext.getCurrentInstance().addPartialTarget(mat_Adv_amt);

    }

    public void onClickPopulateAmount(ActionEvent actionEvent) {
        CalculateAmount();
    }

    public void CalculateAmount() {
        try {

            CurrentApplicationAmount();
            PreviousAppliedAmount();
            TotalAdvanceAmount();
            TotalRetention();
            PrevAdvRecoveryRetention();
            BalanceAdvanceRecovery();
            BalanceRetention();
            if (paymentType.getValue().equals("Advance")) {
                double CurAdvrec =
                    trans_adv_rec.getValue() == null ? 0 : Double.parseDouble(trans_adv_rec.getValue().toString());
                certificationHrdVO.getCurrentRow().setAttribute("CurCertification",
                                                                new BigDecimal(CurAdvrec));
                certificationHrdVO.getCurrentRow().setAttribute("CurAdvRec",
                                                                new BigDecimal(0));
                certificationHrdVO.getCurrentRow().setAttribute("CurRet",
                                                                new BigDecimal(0));
                AdfFacesContext.getCurrentInstance().addPartialTarget(curRet);
                AdfFacesContext.getCurrentInstance().addPartialTarget(curAdvRev);
                AdfFacesContext.getCurrentInstance().addPartialTarget(curCert);
            } else if ((paymentType.getValue().equals("Interim"))) {
                PaymentAmtInt();
            }
            CurrentAdvanceRecovery();
            CurrentRetention();
            //  getFunctionId();
        } catch (Exception e) {
            //System.err.println("====Error====" + e);
        }
    }


    public void PaymentAmtInt() {
        try {
            double sum = 0;
            //            double CurAppl =curCertification.getValue() == null ? 0 : Double.parseDouble(curCertification.getValue().toString());
            double CurAppl =
                curCert.getValue() == null ? 0 : Double.parseDouble(curCert.getValue().toString());
            double CurAdvrec =
                curAdvRev.getValue() == null ? 0 : Double.parseDouble(curAdvRev.getValue().toString());
            double Curret =
                curRet.getValue() == null ? 0 : Double.parseDouble(curRet.getValue().toString());
            sum = CurAppl - CurAdvrec - Curret;
            //System.err.println("======Payment Amount Interim close======" +
            //                               sum);
            certificationHrdVO.getCurrentRow().setAttribute("CurPayAmount",
                                                            new BigDecimal(sum));
            AdfFacesContext.getCurrentInstance().addPartialTarget(curPayAmount);
        } catch (Exception e) {
            //System.err.println("====Error====" + e);
        }
    }
    // Interim Current Application Amount

    public void CurrentApplicationAmount() {
        try {
            RowSetIterator Applines =
                certificationLineVO.createRowSetIterator(null);
            double sum = 0;
            while (Applines.hasNext()) {
                Row r = Applines.next();
                if (r.getAttribute("CurrAmount") != null) {
                    sum =
sum + Double.parseDouble(r.getAttribute("CurrAmount").toString());
                }
            }
            //System.err.println("=====Current Application=====" + sum);
            certificationHrdVO.getCurrentRow().setAttribute("CurCertification",
                                                            new BigDecimal(df.format(sum)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(curCert);
        } catch (Exception e) {
            //System.err.println("====Error====" + e);
        }
    }

    // Interim Previous Applied Amount

    public void PreviousAppliedAmount() {
        double prevAdv = 0;
        double PrevRet = 0;
        double Prevmatadv = 0;
        double prevAmount = 0;
        try {
            double sum = 0;
            double advper =
                certificationHrdVO.getCurrentRow().getAttribute("cont_Adv_Recovery") ==
                null ? 0 :
                Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("cont_Adv_Recovery").toString());
            double Retper =
                certificationHrdVO.getCurrentRow().getAttribute("cont_Ret_Recovery") ==
                null ? 0 :
                Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("cont_Ret_Recovery").toString());
            double matper =
                certificationHrdVO.getCurrentRow().getAttribute("cont_Mat_Recovery") ==
                null ? 0 :
                Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("cont_Mat_Recovery").toString());
            RowSetIterator Applines =
                certificationLineVO.createRowSetIterator(null);
            while (Applines.hasNext()) {
                Row r = Applines.next();
                prevAmount =
                        r.getAttribute("PrevAmount") == null ? 0 : Double.parseDouble(r.getAttribute("PrevAmount").toString());
                sum = sum + prevAmount;
            }
            prevAdv = (sum * advper) / 100;
            PrevRet = (sum * Retper) / 100;
            Prevmatadv = (sum * matper) / 100;
            //System.err.println("=====Previous Applied Amount=====" + sum);
            certificationHrdVO.getCurrentRow().setAttribute("PrevApplication",
                                                            new BigDecimal(df.format(sum)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(prevApplication);
            certificationHrdVO.getCurrentRow().setAttribute("PrevAdvRec",
                                                            new BigDecimal(df.format(prevAdv)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(prevAdvRec);
            certificationHrdVO.getCurrentRow().setAttribute("PrevRet",
                                                            new BigDecimal(df.format(PrevRet)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(prevRet);
            certificationHrdVO.getCurrentRow().setAttribute("PrevMatAdvAmt",
                                                            new BigDecimal(df.format(Prevmatadv)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(prev_mat_adv_rec);
        } catch (Exception e) {
            //System.err.println("====Error====" + e);
        }
    }


    public void TotalAdvanceAmount() {
        Row r = certificationHrdVO.getCurrentRow();
        double sum = 0;
        if (r.getAttribute("Trans_Revis_Contr_Amo") != null &&
            r.getAttribute("Trans_Adva_Reco_Per") != null) {
            //System.err.println("====value====" +
            //                               Double.parseDouble(r.getAttribute("Trans_Revis_Contr_Amo").toString()));
            sum =
(Double.parseDouble(r.getAttribute("Trans_Revis_Contr_Amo").toString()) *
 Double.parseDouble(r.getAttribute("Trans_Adva_Reco_Per").toString())) / 100;
        }
        //System.err.println("======TotalAdvanceAmount======" + sum);
        certificationHrdVO.getCurrentRow().setAttribute("TotalAdvAmount",
                                                        new BigDecimal(sum));
        AdfFacesContext.getCurrentInstance().addPartialTarget(totalAmount);
    }

    public void TotalRetention() {
        Row r = certificationHrdVO.getCurrentRow();
        double sum = 0;
        if (r.getAttribute("Trans_Revis_Contr_Amo") != null &&
            r.getAttribute("cont_Ret_Recovery") != null) {
            //System.err.println("====value====" +
            //                               Double.parseDouble(r.getAttribute("Trans_Revis_Contr_Amo").toString()));
            sum =
(Double.parseDouble(r.getAttribute("Trans_Revis_Contr_Amo").toString()) *
 Double.parseDouble(r.getAttribute("cont_Ret_Recovery").toString())) / 100;
        }
        //System.err.println("======TotalRetention======" + sum);
        certificationHrdVO.getCurrentRow().setAttribute("TotalRet",
                                                        new BigDecimal(sum));
        AdfFacesContext.getCurrentInstance().addPartialTarget(totalRet);
    }
    // Interim Current Advance Recovery

    public void CurrentAdvanceRecovery() throws SQLException {
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy") ||
            ADFContext.getCurrent().getSessionScope().get("page").equals("certificationBuy") ||
            ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
            //            Row r = certificationHrdVO.getCurrentRow();
            //            double sum = 0;
            //            if (r.getAttribute("CurCertification") != null &&
            //                r.getAttribute("cont_Adv_Recovery") != null) {
            //                sum =
            //(Double.parseDouble(r.getAttribute("CurCertification").toString()) *
            // Double.parseDouble(r.getAttribute("cont_Adv_Recovery").toString())) / 100;
            //            }
            RowSetIterator rs = certificationLineVO.createRowSetIterator(null);
            double sum = 0;
            while (rs.hasNext()) {
                Row r = rs.next();
                sum +=
Double.parseDouble(r.getAttribute("CurAdvRecAmount") != null ?
                   r.getAttribute("CurAdvRecAmount").toString() : "0.0");

            }
            //            -------------------------
            if (certificationHrdVO.getCurrentRow().getAttribute("PaymentType").toString().equalsIgnoreCase("Final")) {
                //                double sum1 = 0;
                //                           double TotalAdvAmt =
                //                               totalAmount.getValue() == null ? 0 : Double.parseDouble(totalAmount.getValue().toString());
                //                           double PrevAdvAmt =
                //                               prevAdvRec.getValue() == null ? 0 : Double.parseDouble(prevAdvRec.getValue().toString());
                //                           double curAdvRe =
                //                               curAdvRev.getValue() == null ? 0 : Double.parseDouble(curAdvRev.getValue().toString());
                //                           sum1 = TotalAdvAmt - PrevAdvAmt - curAdvRe;
                //
                //                certificationHrdVO.getCurrentRow().setAttribute("CurAdvRec",
                //                                                              new BigDecimal(df.format(sum1)));
                //                AdfFacesContext.getCurrentInstance().addPartialTarget(cur_Adv_Rec_Perc);
                //                AdfFacesContext.getCurrentInstance().addPartialTarget(curAdvRev);


            }

            else {
                certificationHrdVO.getCurrentRow().setAttribute("CurAdvRec",
                                                                new BigDecimal(df.format(sum)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(cur_Adv_Rec_Perc);
                AdfFacesContext.getCurrentInstance().addPartialTarget(curAdvRev);
            }

            //            -----------------------
            //            double cur_app =
            //                curCertification.getValue() == null ? 0 : Double.parseDouble(curCertification.getValue().toString());
            //            double advPerc=(sum/cur_app)*100;
            //            Number curAdvRecPercen=new Number(advPerc);
            //            certificationHrdVO.getCurrentRow().setAttribute("Curadvrecper", curAdvRecPercen);
            //            AdfFacesContext.getCurrentInstance().addPartialTarget(CurAdvRec);

            //System.err.println("======CurrentAdvanceRecovery======" + sum);
            //            certificationHrdVO.getCurrentRow().setAttribute("CurAdvRec",
            //                                                            new BigDecimal(df.format(sum)));

        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell") ||
                   ADFContext.getCurrent().getSessionScope().get("page").equals("certificationSell") ||
                   ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
            ViewObject AdvancRecVO =
                ADFUtils.findIterator("XxscCertAdvRecDtlsVO2Iterator").getViewObject();
            RowSetIterator rs = AdvancRecVO.createRowSet(null);
            double sum1 = 0;
            while (rs.hasNext()) {
                Row r = rs.next();
                sum1 +=
                        Double.parseDouble(r.getAttribute("CurRecAmt").toString());
            }
            certificationHrdVO.getCurrentRow().setAttribute("CurAdvRec",
                                                            new BigDecimal(df.format(sum1)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(curAdvRev);
        }
        //        Row r = certificationHrdVO.getCurrentRow();
        //        double sum = 0;
        //        if (r.getAttribute("CurCertification") != null &&
        //            r.getAttribute("cont_Adv_Recovery") != null) {
        //            sum =
        //(Double.parseDouble(r.getAttribute("CurCertification").toString()) *
        // Double.parseDouble(r.getAttribute("cont_Adv_Recovery").toString())) / 100;
        //        }
        //        //System.err.println("======CurrentAdvanceRecovery======" + sum);
        //        certificationHrdVO.getCurrentRow().setAttribute("CurAdvRec",
        //                                                        new BigDecimal(df.format(sum)));
        //        AdfFacesContext.getCurrentInstance().addPartialTarget(curAdvRev);
    }
    // Interim  Current Material Advance Recovery

    public void CurrentMaterialAdvanceRecovery() {
        Row r = certificationHrdVO.getCurrentRow();
        double sum = 0;
        if (r.getAttribute("CurCertification") != null &&
            r.getAttribute("cont_Mat_Recovery") != null) {
            sum =
(Double.parseDouble(r.getAttribute("CurCertification").toString()) *
 Double.parseDouble(r.getAttribute("cont_Mat_Recovery").toString())) / 100;
        }
        //System.err.println("======CurrentMaterialAdvanceRecovery======" + sum);
        certificationHrdVO.getCurrentRow().setAttribute("CurMatAdvRec",
                                                        new BigDecimal(df.format(sum)));
        AdfFacesContext.getCurrentInstance().addPartialTarget(cur_mat_adv_amt);
    }

    public void CurrentRetention() {
        Row r = certificationHrdVO.getCurrentRow();
        double sum = 0;
        if (r.getAttribute("CurCertification") != null &&
            r.getAttribute("cont_Ret_Recovery") != null) {
            sum =
(Double.parseDouble(r.getAttribute("CurCertification").toString()) *
 Double.parseDouble(r.getAttribute("cont_Ret_Recovery").toString())) / 100;
        }
        //System.err.println("======Current Retention======" + sum);
        certificationHrdVO.getCurrentRow().setAttribute("CurRet",
                                                        new BigDecimal(sum));
        AdfFacesContext.getCurrentInstance().addPartialTarget(curRet);
    }
    // Interim BalanceAdvanceRecovery

    public void BalanceAdvanceRecovery() {
        try {
            double sum = 0;
            double TotalAdvAmt =
                totalAmount.getValue() == null ? 0 : Double.parseDouble(totalAmount.getValue().toString());
            double PrevAdvAmt =
                prevAdvRec.getValue() == null ? 0 : Double.parseDouble(prevAdvRec.getValue().toString());
            double curAdvRe =
                curAdvRev.getValue() == null ? 0 : Double.parseDouble(curAdvRev.getValue().toString());
            sum = TotalAdvAmt - PrevAdvAmt - curAdvRe;
            //System.err.println("======BalanceAdvanceRecovery======" + sum);
            //            ---------------------------------
            if (certificationHrdVO.getCurrentRow().getAttribute("PaymentType").toString().equalsIgnoreCase("Final")) {
                certificationHrdVO.getCurrentRow().setAttribute("BalanceAdvRec",
                                                                new BigDecimal(df.format(0)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(balanceAdvRec);
            } else {
                certificationHrdVO.getCurrentRow().setAttribute("BalanceAdvRec",
                                                                new BigDecimal(df.format(sum)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(balanceAdvRec);
            }
            //            ----------------
        } catch (Exception e) {
            //System.err.println("====Error====" + e);
        }
    }
    // Interim Balance Material Advance Recovery

    public void BalanceMaterialAdvanceRecovery() {
        try {
            double sum = 0;
            double TotalMatAdvAmt =
                tot_mat_adv_amt.getValue() == null ? 0 : Double.parseDouble(tot_mat_adv_amt.getValue().toString());
            double curmatadv =
                cur_mat_adv_amt.getValue() == null ? 0 : Double.parseDouble(cur_mat_adv_amt.getValue().toString());
            double prevmatamt =
                prev_mat_adv_rec.getValue() == null ? 0 : Double.parseDouble(prev_mat_adv_rec.getValue().toString());
            //            double curMatAdvRev =
            //                cur_mat_adv_rec.getValue() == null ? 0 : Double.parseDouble(cur_mat_adv_rec.getValue().toString());
            sum = TotalMatAdvAmt - prevmatamt - curmatadv;
            //System.err.println("======BalanceMaterialAdvanceRecovery======" +
            //                               sum);
            certificationHrdVO.getCurrentRow().setAttribute("BalMatAdvRec",
                                                            new BigDecimal(df.format(sum)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(bal_mat_rec);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }

    // Interim Balance Retention

    public void BalanceRetention() {
        try {
            double sum = 0;
            double TotalReten =
                totalRet.getValue() == null ? 0 : Double.parseDouble(totalRet.getValue().toString());
            double PrevRe =
                prevRet.getValue() == null ? 0 : Double.parseDouble(prevRet.getValue().toString());
            double CurRet =
                curRet.getValue() == null ? 0 : Double.parseDouble(curRet.getValue().toString());
            sum = TotalReten - PrevRe - CurRet;
            //System.err.println("======Balance Retention======" + sum);
            //            ------------------------------
            if (certificationHrdVO.getCurrentRow().getAttribute("PaymentType").toString().equalsIgnoreCase("Final")) {
                certificationHrdVO.getCurrentRow().setAttribute("BalanceRet",
                                                                new BigDecimal(df.format(0)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(balanceRet);
            } else {
                certificationHrdVO.getCurrentRow().setAttribute("BalanceRet",
                                                                new BigDecimal(df.format(sum)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(balanceRet);
            }
            //            ----------------------------
        } catch (Exception e) {
            //System.err.println("====Error====" + e);
        }
    }


    public void PrevAdvRecoveryRetention() {
        try {
            String AppHdrId =
                certificationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
                null ? "0" :
                certificationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();
            String ContHdrId =
                certificationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
                null ? "0" :
                certificationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
            String Version =
                certificationHrdVO.getCurrentRow().getAttribute("Version") ==
                null ? "0" :
                certificationHrdVO.getCurrentRow().getAttribute("Version").toString();
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
                certificationHrdVO.getCurrentRow().setAttribute("PrevAdvRec",
                                                                PrevAdvAndRetCal.first().getAttribute("PrevAdvRec"));
                AdfFacesContext.getCurrentInstance().addPartialTarget(prevAdvRec);
                //System.err.println("===============Previous Retention===============" +
                //                                   PrevAdvAndRetCal.first().getAttribute("PrevRet"));
                certificationHrdVO.getCurrentRow().setAttribute("PrevRet",
                                                                PrevAdvAndRetCal.first().getAttribute("PrevRet"));
                AdfFacesContext.getCurrentInstance().addPartialTarget(prevRet);
            } else {
                certificationHrdVO.getCurrentRow().setAttribute("PrevAdvRec",
                                                                "0");
                AdfFacesContext.getCurrentInstance().addPartialTarget(prevAdvRec);
                certificationHrdVO.getCurrentRow().setAttribute("PrevRet",
                                                                "0");
                AdfFacesContext.getCurrentInstance().addPartialTarget(prevRet);
            }
        } catch (Exception e) {
            //System.err.println("====Error====" + e);
        }
    }

    public void setPaymentType(RichSelectOneChoice paymentType) {
        this.paymentType = paymentType;
    }

    public RichSelectOneChoice getPaymentType() {
        return paymentType;
    }

    public void onChangePaymentType(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        //System.err.println("==NEW==" + valueChangeEvent.getNewValue());
        //System.err.println("==OLD==" + valueChangeEvent.getOldValue());
    }
    /*
    public void onClickSubmitd(ActionEvent actionEvent) {
        if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy") ||
            ADFContext.getCurrent().getSessionScope().get("page").equals("certificationBuy")) {
            if (ADFContext.getCurrent().getSessionScope().get("addEditCert").equals("edit")) {
                certificationHrdVO.getCurrentRow().setAttribute("CertificationStatus",
                                                                "ACTIVE");
                certificationHrdVO.getCurrentRow().setAttribute("ApprovalStatus",
                                                                "APR");
                certificationHrdVO.getCurrentRow().setAttribute("InvStatus",
                                                                "READY_TO_AP");
                ADFUtils.findOperation("Commit").execute();
                refreshCertificationTable();
                JSFUtils.addFacesInformationMessage("Payment Certification Information Saved Successfully");
            } else {
                certificationHrdVO.getCurrentRow().setAttribute("CertificationNumber",
                                                                "CERT-" +
                                                                certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId"));
                certificationHrdVO.getCurrentRow().setAttribute("Intent", "B");
                certificationHrdVO.getCurrentRow().setAttribute("CertificationStatus",
                                                                "ACTIVE");
                certificationHrdVO.getCurrentRow().setAttribute("ApprovalStatus",
                                                                "APR");
                certificationHrdVO.getCurrentRow().setAttribute("InvStatus",
                                                                "READY_TO_AP");
                ADFUtils.findOperation("Commit").execute();
                refreshCertificationTable();
                JSFUtils.numberFaceMessage("Payment Certification",
                                           certificationHrdVO.getCurrentRow().getAttribute("CertificationNumber"));
            }

        } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell") ||
                   ADFContext.getCurrent().getSessionScope().get("page").equals("certificationSell")) {
            //========================SOABHA===============================================================
            //            if (ADFContext.getCurrent().getSessionScope().get("addEditCert").equals("edit")) {
            //                certificationHrdVO.getCurrentRow().setAttribute("CertificationStatus",
            //                                                                "ACTIVE");
            //                certificationHrdVO.getCurrentRow().setAttribute("ApprovalStatus",
            //                                                                "APR");
            //                certificationHrdVO.getCurrentRow().setAttribute("InvStatus",
            //                                                                "READY_TO_AR");
            //                ADFUtils.findOperation("Commit").execute();
            //                refreshCertificationTable();
            //                JSFUtils.addFacesInformationMessage("Customer Certification Information Saved Successfully");
            //            } else {
            //                certificationHrdVO.getCurrentRow().setAttribute("CertificationNumber",
            //                                                                "CERT-" +
            //                                                                certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId"));
            //                certificationHrdVO.getCurrentRow().setAttribute("Intent", "S");
            //                certificationHrdVO.getCurrentRow().setAttribute("CertificationStatus",
            //                                                                "ACTIVE");
            //                certificationHrdVO.getCurrentRow().setAttribute("ApprovalStatus",
            //                                                                "APR");
            //                certificationHrdVO.getCurrentRow().setAttribute("InvStatus",
            //                                                                "READY_TO_AR");
            //                ADFUtils.findOperation("Commit").execute();
            //                refreshCertificationTable();
            //                JSFUtils.numberFaceMessage("Customer Certification",
            //                                           certificationHrdVO.getCurrentRow().getAttribute("CertificationNumber"));
            //            }
            //========================NSCC===============================================================
            //CURR_CERT_ADV//CURR_CERT_RET//ADVANCE//RETENTION_REL
            //PRO_CERT
            //PRO_ADV
            //PRO_RET
            if (certificationHrdVO.getCurrentRow().getAttribute("PaymentType") !=
                null) {
                if (certificationHrdVO.getCurrentRow().getAttribute("PaymentType").toString().equals("Advance")) {
                    submitJV(certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId"),
                             "ADVANCE",certificationHrdVO.getCurrentRow().getAttribute("CurCertification"));
                    submitProjectBill(certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId"),"Advance");
            }
                if (certificationHrdVO.getCurrentRow().getAttribute("PaymentType").toString().equals("Interim")) {
                    submitJV(certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId"),
                             "CURR_CERT_RET",certificationHrdVO.getCurrentRow().getAttribute("CurAdvRec"));
                    submitJV(certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId"),
                             "CURR_CERT_ADV",certificationHrdVO.getCurrentRow().getAttribute("CurRet"));
                      submitProjectBill(certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId"),"Interim");
                  }
            }


        }
    }

 */
    private Object[][] dobProcArgs = null;

    public void submitJV(Object cerHdrId, Object jvType, Object jvAmt) {
        String flag = "E";
        String errorMessage = null;
        try {
            oracle.jbo.domain.Number headerID =
                new oracle.jbo.domain.Number(cerHdrId.toString());
            oracle.jbo.domain.Number jvAm =
                new oracle.jbo.domain.Number(jvAmt.toString());
            ApplicationModuleImpl am =
                (ApplicationModuleImpl)ADFUtils.getApplicationModuleForDataControl(null);

            dobProcArgs =
                    new Object[][] { { "IN", headerID, OracleTypes.NUMBER },
                        //0
                        { "IN", jvType, OracleTypes.VARCHAR }, //1
                        { "IN", jvAm, OracleTypes.NUMBER }, //2
                        { "OUT", flag, OracleTypes.VARCHAR }, //3
                        { "OUT", errorMessage, OracleTypes.VARCHAR } }; //4
            DBUtils.callDBStoredProcedure(am.getDBTransaction(),
                                          "call xxsc_Cert_interface_pkg.journal_interface(?,?,?,?,?)",
                                          dobProcArgs);

        } catch (SQLException e) {
            //System.err.println("==exe==" + e.toString());
        }
        //        flag = (String)dobProcArgs[4][1];
        //        errorMessage = (String)dobProcArgs[5][1];
    }

    public void insadvance(Object cerHdrId, Object conthdrid, Object applhdrid,
                           Object type) {
        String flag = "E";
        String errorMessage = null;
        try {
            oracle.jbo.domain.Number headerID =
                new oracle.jbo.domain.Number(cerHdrId.toString());
            oracle.jbo.domain.Number contid =
                new oracle.jbo.domain.Number(conthdrid.toString());
            oracle.jbo.domain.Number appid =
                new oracle.jbo.domain.Number(applhdrid.toString());
            ApplicationModuleImpl am =
                (ApplicationModuleImpl)ADFUtils.getApplicationModuleForDataControl(null);

            dobProcArgs =
                    new Object[][] { { "IN", headerID, OracleTypes.NUMBER },
                        //0
                        { "IN", contid, OracleTypes.NUMBER }, //1
                        { "IN", appid, OracleTypes.NUMBER }, //2
                        { "IN", type, OracleTypes.VARCHAR } }; //4

            DBUtils.callDBStoredProcedure(am.getDBTransaction(),
                                          "call xxsc_advance_pkg.ins_advance(?,?,?,?)",
                                          dobProcArgs);

        } catch (SQLException e) {
            //System.err.println("==exe==" + e.toString());
        }
    }

    public void submitProjectBill(Object cerHdrId, String type) {
        String flag = "E";
        String errorMessage = null;
        try {
            oracle.jbo.domain.Number headerID =
                new oracle.jbo.domain.Number(cerHdrId.toString());
            ApplicationModuleImpl am =
                (ApplicationModuleImpl)ADFUtils.getApplicationModuleForDataControl(null);

            dobProcArgs =
                    new Object[][] { { "IN", headerID, OracleTypes.NUMBER },
                        //0
                        { "OUT", flag, OracleTypes.VARCHAR }, //1
                        { "OUT", errorMessage, OracleTypes.VARCHAR } }; //2
            DBUtils.callDBStoredProcedure(am.getDBTransaction(),
                                          "call xxsc_Cert_interface_pkg.project_billing_interface(?,?,?)",
                                          dobProcArgs);

        } catch (SQLException e) {
            //System.err.println("==exe==" + e.toString());
        }
        //        flag = (String)dobProcArgs[4][1];
        //        errorMessage = (String)dobProcArgs[5][1];
    }

    private BlobDomain createBlobDomain(UploadedFile file) {
        InputStream in = null;
        BlobDomain blobDomain = null;
        OutputStream out = null;
        try {
            in = file.getInputStream();
            blobDomain = new BlobDomain();
            out = blobDomain.getBinaryOutputStream();
            IOUtils.copy(in, out);
            //            byte[] buffer = new byte[8192];
            //            int bytesRead = 0;
            //            while ((bytesRead = in.read(buffer, 0, 8192)) != -1) {
            //                out.write(buffer, 0, bytesRead);
            //            }
            //
            //
            //            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.fillInStackTrace();
        }
        return blobDomain;
    }

    private DCBindingContainer getBindingsCont() {
        return (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String UploadFileActionToDB(UploadedFile file) {
        UploadedFile myfile = file;
        if (myfile != null) {
            DCIteratorBinding imageIter =
                (DCIteratorBinding)getBindingsCont().get("XxfndFuncAttachment_VO1Iterator");
            ViewObject vo = imageIter.getViewObject();
            Row curRow = vo.getCurrentRow();
            String filename = myfile.getFilename();
            String ContentType = myfile.getContentType();

            try {

                //System.err.println("this is the attachment file name----->" +
                //                                   filename);
                //System.err.println("this is the attachment file name----->" +
                //                                   ContentType);
                curRow.setAttribute("FileName", filename);
                curRow.setAttribute("FileType", ContentType);
                curRow.setAttribute("Attachment", createBlobDomain(myfile));
                //                                           curRow.setAttachment(createBlobDomain(myfile));
            } catch (Exception ex) {
                //System.out.println("Exception-" + ex);
            }
        }
        return null;
    }

    public void OnFileUpload(ValueChangeEvent vce) {
        //        vce.getComponent().processUpdates(FacesContext.getCurrentInstance());
        //System.err.println("------------inside the vce-----------");
        if (vce.getNewValue() != null) {
            //List<UploadedFile> lf = (List<UploadedFile>)vce.getNewValue();
            //for (UploadedFile fileVal : lf) {
            //
            UploadFileActionToDB((UploadedFile)vce.getNewValue());
            //                    ADFUtils
            //UploadFileActionToDB((UploadedFile)lf);
            //            ADFUtils.findOperation("Commit").execute();
            //            ADFUtils.invokeEL("#{bindings.Commit.execute}");
        }
        //        }
        //        ResetUtils.reset(vce.getComponent());
        // }
    }

    public void onFileDownload(FacesContext facesContext,
                               OutputStream outputStream) {
        // Add event code here...
        ViewObject vc =
            view.backing.ADFUtils.findIterator("XxfndFuncAttachment_VO1Iterator").getViewObject();
        //        DCIteratorBinding iteratorbinding =
        //            (DCIteratorBinding)getBindingsCont().get("XxfndFuncAttachmentView1Iterator");
        //DCIteratorBinding iteratorbinding =
        //           bindings.findIteratorBinding("DocumentsVO1Iterator");
        BlobDomain blob =
            (BlobDomain)vc.getCurrentRow().getAttribute("Attachment");
        try {
            IOUtils.copy(blob.getInputStream(), outputStream);
            blob.closeInputStream();
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setTrans_adv_rec(RichInputText trans_adv_rec) {
        this.trans_adv_rec = trans_adv_rec;
    }

    public RichInputText getTrans_adv_rec() {
        return trans_adv_rec;
    }

    public void setTrans_ret_amt(RichInputText trans_ret_amt) {
        this.trans_ret_amt = trans_ret_amt;
    }

    public RichInputText getTrans_ret_amt() {
        return trans_ret_amt;
    }

    public void setMat_Adv_amt(RichInputText mat_Adv_amt) {
        this.mat_Adv_amt = mat_Adv_amt;
    }

    public RichInputText getMat_Adv_amt() {
        return mat_Adv_amt;
    }

    public void setOrgQty(RichInputText orgQty) {
        this.orgQty = orgQty;
    }

    public RichInputText getOrgQty() {
        return orgQty;
    }

    public void setOrgRate(RichInputText orgRate) {
        this.orgRate = orgRate;
    }

    public RichInputText getOrgRate() {
        return orgRate;
    }

    public void setOrgAmt(RichInputText orgAmt) {
        this.orgAmt = orgAmt;
    }

    public RichInputText getOrgAmt() {
        return orgAmt;
    }

    public void setCertPrevQty(RichInputText certPrevQty) {
        this.certPrevQty = certPrevQty;
    }

    public RichInputText getCertPrevQty() {
        return certPrevQty;
    }

    public void setCertPrevPer(RichInputText certPrevPer) {
        this.certPrevPer = certPrevPer;
    }

    public RichInputText getCertPrevPer() {
        return certPrevPer;
    }

    public void setCertPrevAmt(RichInputText certPrevAmt) {
        this.certPrevAmt = certPrevAmt;
    }

    public RichInputText getCertPrevAmt() {
        return certPrevAmt;
    }

    public void setCertCurrQty(RichInputText certCurrQty) {
        this.certCurrQty = certCurrQty;
    }

    public RichInputText getCertCurrQty() {
        return certCurrQty;
    }

    public void setCertCurrPer(RichInputText certCurrPer) {
        this.certCurrPer = certCurrPer;
    }

    public RichInputText getCertCurrPer() {
        return certCurrPer;
    }

    public void setCertCurrAmt(RichInputText certCurrAmt) {
        this.certCurrAmt = certCurrAmt;
    }

    public RichInputText getCertCurrAmt() {
        return certCurrAmt;
    }

    public void setCertCummQty(RichInputText certCummQty) {
        this.certCummQty = certCummQty;
    }

    public RichInputText getCertCummQty() {
        return certCummQty;
    }

    public void setCertCummPer(RichInputText certCummPer) {
        this.certCummPer = certCummPer;
    }

    public RichInputText getCertCummPer() {
        return certCummPer;
    }

    public void setCertCummAmt(RichInputText certCummAmt) {
        this.certCummAmt = certCummAmt;
    }

    public RichInputText getCertCummAmt() {
        return certCummAmt;
    }

    public void setAppliPrevQty(RichInputText appliPrevQty) {
        this.appliPrevQty = appliPrevQty;
    }

    public RichInputText getAppliPrevQty() {
        return appliPrevQty;
    }

    public void setAppliPrevPer(RichInputText appliPrevPer) {
        this.appliPrevPer = appliPrevPer;
    }

    public RichInputText getAppliPrevPer() {
        return appliPrevPer;
    }

    public void setAppliPrevAmt(RichInputText appliPrevAmt) {
        this.appliPrevAmt = appliPrevAmt;
    }

    public RichInputText getAppliPrevAmt() {
        return appliPrevAmt;
    }

    public void setAppliCurrQty(RichInputText appliCurrQty) {
        this.appliCurrQty = appliCurrQty;
    }

    public RichInputText getAppliCurrQty() {
        return appliCurrQty;
    }

    public void setAppliCurrPer(RichInputText appliCurrPer) {
        this.appliCurrPer = appliCurrPer;
    }

    public RichInputText getAppliCurrPer() {
        return appliCurrPer;
    }

    public void setAppliCurrAmt(RichInputText appliCurrAmt) {
        this.appliCurrAmt = appliCurrAmt;
    }

    public RichInputText getAppliCurrAmt() {
        return appliCurrAmt;
    }

    public void setAppliCummQty(RichInputText appliCummQty) {
        this.appliCummQty = appliCummQty;
    }

    public RichInputText getAppliCummQty() {
        return appliCummQty;
    }

    public void setAppliCummPer(RichInputText appliCummPer) {
        this.appliCummPer = appliCummPer;
    }

    public RichInputText getAppliCummPer() {
        return appliCummPer;
    }

    public void setAppliCummAmt(RichInputText appliCummAmt) {
        this.appliCummAmt = appliCummAmt;
    }

    public RichInputText getAppliCummAmt() {
        return appliCummAmt;
    }

    DecimalFormat df = new DecimalFormat(".#################");

    public void onChangeCummQty(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != null) {

            valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
            double contractLneRate =
                certificationLineVO.getCurrentRow().getAttribute("Trans_ConLine_Rate") ==
                null ? 0 :
                Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("Trans_ConLine_Rate").toString());
            double contractLneAmt =
                certificationLineVO.getCurrentRow().getAttribute("Trans_ConLine_Amount") ==
                null ? 0 :
                Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("Trans_ConLine_Amount").toString());
            double cummulativeQty =
                valueChangeEvent.getNewValue() == null ? 0 :
                Double.parseDouble(valueChangeEvent.getNewValue().toString());
            double taxRate =
                certificationLineVO.getCurrentRow().getAttribute("TaxRate") ==
                null ? 0 :
                Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("TaxRate").toString());

            // Set Amount
            double cummulativeAmt = cummulativeQty * contractLneRate;
            certificationLineVO.getCurrentRow().setAttribute("CumAmount",
                                                             df.format(cummulativeAmt));
            AdfFacesContext.getCurrentInstance().addPartialTarget(certCummAmt);

            // set Percentage
            double cummulativePer = (100 * cummulativeAmt / contractLneAmt);
            certificationLineVO.getCurrentRow().setAttribute("CumPerc",
                                                             df.format(cummulativePer));
            AdfFacesContext.getCurrentInstance().addPartialTarget(certCummPer);

            // Setting Current Value
            double previousQty =
                certificationLineVO.getCurrentRow().getAttribute("PrevTotQty") ==
                null ? 0 :
                Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("PrevTotQty").toString());
            double previousPer =
                certificationLineVO.getCurrentRow().getAttribute("PrevPerc") ==
                null ? 0 :
                Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("PrevPerc").toString());
            double previousAmt =
                certificationLineVO.getCurrentRow().getAttribute("PrevAmount") ==
                null ? 0 :
                Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("PrevAmount").toString());

            double currentQty = cummulativeQty - previousQty;
            double currentPre = cummulativePer - previousPer;
            double currentAmt = cummulativeAmt - previousAmt;
            certificationLineVO.getCurrentRow().setAttribute("CurrTotQty",
                                                             new BigDecimal(df.format(currentQty)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(certCurrQty);
            certificationLineVO.getCurrentRow().setAttribute("CurrPerc",
                                                             new BigDecimal(df.format(currentPre)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(certCurrPer);
            certificationLineVO.getCurrentRow().setAttribute("CurrAmount",
                                                             new BigDecimal(df.format(currentAmt)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(certCurrAmt);

            // Set Tax Amount
            if (taxRate == 0) {
                certificationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                 new BigDecimal(df.format(0)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(certCurrTaxAmt);
            } else {
                double taxAmt = (currentAmt * taxRate) / 100;
                certificationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                 new BigDecimal(df.format(taxAmt)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(certCurrTaxAmt);
            }
        }
    }

    public void onChangeCummPer(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != null) {
            valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
            double contractLneRate =
                certificationLineVO.getCurrentRow().getAttribute("Trans_ConLine_Rate") ==
                null ? 0 :
                Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("Trans_ConLine_Rate").toString());
            double contractLneAmt =
                certificationLineVO.getCurrentRow().getAttribute("Trans_ConLine_Amount") ==
                null ? 0 :
                Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("Trans_ConLine_Amount").toString());
            double cummulativePer =
                valueChangeEvent.getNewValue() == null ? 0 :
                Double.parseDouble(valueChangeEvent.getNewValue().toString());

            double taxRate =
                certificationLineVO.getCurrentRow().getAttribute("TaxRate") ==
                null ? 0 :
                Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("TaxRate").toString());

            // Set Amount
            double cummulativeAmt = (cummulativePer * contractLneAmt) / 100;
            certificationLineVO.getCurrentRow().setAttribute("CumAmount",
                                                             df.format(cummulativeAmt));
            AdfFacesContext.getCurrentInstance().addPartialTarget(certCummAmt);

            // set Qty
            double cummulativeQty = cummulativeAmt / contractLneRate;
            certificationLineVO.getCurrentRow().setAttribute("CumTotQty",
                                                             df.format(cummulativeQty));
            AdfFacesContext.getCurrentInstance().addPartialTarget(certCummQty);

            // Setting Current Value
            double previousQty =
                certificationLineVO.getCurrentRow().getAttribute("PrevTotQty") ==
                null ? 0 :
                Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("PrevTotQty").toString());
            double previousPer =
                certificationLineVO.getCurrentRow().getAttribute("PrevPerc") ==
                null ? 0 :
                Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("PrevPerc").toString());
            double previousAmt =
                certificationLineVO.getCurrentRow().getAttribute("PrevAmount") ==
                null ? 0 :
                Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("PrevAmount").toString());

            double currentQty = cummulativeQty - previousQty;
            double currentPre = cummulativePer - previousPer;
            double currentAmt = cummulativeAmt - previousAmt;

            certificationLineVO.getCurrentRow().setAttribute("CurrTotQty",
                                                             new BigDecimal(df.format(currentQty)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(certCurrQty);
            certificationLineVO.getCurrentRow().setAttribute("CurrPerc",
                                                             new BigDecimal(df.format(currentPre)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(certCurrPer);
            certificationLineVO.getCurrentRow().setAttribute("CurrAmount",
                                                             new BigDecimal(df.format(currentAmt)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(certCurrAmt);

            // Set Tax Amount
            if (taxRate == 0) {
                certificationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                 new BigDecimal(df.format(0)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(certCurrTaxAmt);
            } else {
                //                double taxAmt = (currentAmt * taxRate) / 100;
                double cur_adv_rec_amount =
                    certificationLineVO.getCurrentRow().getAttribute("CurAdvRecAmount") ==
                    null ? 0 :
                    Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("CurAdvRecAmount").toString());
                double cur_ret_rec_amount =
                    certificationLineVO.getCurrentRow().getAttribute("CurRetRecAmount") ==
                    null ? 0 :
                    Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("CurRetRecAmount").toString());
                /**
           * tax_amount 01-09-2023 added as requested by arun
           */
                double final_tax_amount =
                    currentAmt - cur_adv_rec_amount - cur_ret_rec_amount;
                double taxAmt = (final_tax_amount * taxRate) / 100;
                certificationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                 new BigDecimal(df.format(taxAmt)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(certCurrTaxAmt);
            }

        }
    }

    public void onChangeCummAmt(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != null) {
            valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
            double contractLneRate =
                certificationLineVO.getCurrentRow().getAttribute("Trans_ConLine_Rate") ==
                null ? 0 :
                Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("Trans_ConLine_Rate").toString());
            double contractLneAmt =
                certificationLineVO.getCurrentRow().getAttribute("Trans_ConLine_Amount") ==
                null ? 0 :
                Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("Trans_ConLine_Amount").toString());
            double cummulativeAmt =
                valueChangeEvent.getNewValue() == null ? 0 :
                Double.parseDouble(valueChangeEvent.getNewValue().toString());
            double taxRate =
                certificationLineVO.getCurrentRow().getAttribute("TaxRate") ==
                null ? 0 :
                Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("TaxRate").toString());

            // Set Qty
            double cummulativeQty = cummulativeAmt / contractLneRate;
            certificationLineVO.getCurrentRow().setAttribute("CumTotQty",
                                                             df.format(cummulativeQty));
            AdfFacesContext.getCurrentInstance().addPartialTarget(certCummQty);

            // set Per
            double cummulativePer = (100 * cummulativeAmt / contractLneAmt);
            certificationLineVO.getCurrentRow().setAttribute("CumPerc",
                                                             df.format(cummulativePer));
            AdfFacesContext.getCurrentInstance().addPartialTarget(certCummPer);

            // Setting Current Value
            double previousQty =
                certificationLineVO.getCurrentRow().getAttribute("PrevTotQty") ==
                null ? 0 :
                Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("PrevTotQty").toString());
            double previousPer =
                certificationLineVO.getCurrentRow().getAttribute("PrevPerc") ==
                null ? 0 :
                Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("PrevPerc").toString());
            double previousAmt =
                certificationLineVO.getCurrentRow().getAttribute("PrevAmount") ==
                null ? 0 :
                Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("PrevAmount").toString());

            double currentQty = cummulativeQty - previousQty;
            double currentPre = cummulativePer - previousPer;
            double currentAmt = cummulativeAmt - previousAmt;

            certificationLineVO.getCurrentRow().setAttribute("CurrTotQty",
                                                             new BigDecimal(df.format(currentQty)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(certCurrQty);
            certificationLineVO.getCurrentRow().setAttribute("CurrPerc",
                                                             new BigDecimal(df.format(currentPre)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(certCurrPer);
            certificationLineVO.getCurrentRow().setAttribute("CurrAmount",
                                                             new BigDecimal(df.format(currentAmt)));
            AdfFacesContext.getCurrentInstance().addPartialTarget(certCurrAmt);
            //set retention recovery automatic calculation 26-02-2024
            //                System.out.println("CumCalculation Retention Recovery entered=>");
            //                System.out.println("CumCalculation Retention Recovery =>"+certificationHrdVO.getCurrentRow().getAttribute("Trans_Retension_Per"));

                            double cont_ret_perc=certificationHrdVO.getCurrentRow().getAttribute("Trans_Retension_Per")==null ?0:Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("Trans_Retension_Per").toString());
                            double ret_rec = (cont_ret_perc * currentAmt) / 100;
                            certificationLineVO.getCurrentRow().setAttribute("CurRetRecAmount",
                                                                           new BigDecimal(df.format(ret_rec)));
                            AdfFacesContext.getCurrentInstance().addPartialTarget(cur_retrec_amount);
            
            // Set Tax Amount
            if (taxRate == 0) {
                certificationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                 new BigDecimal(df.format(0)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(certCurrTaxAmt);
            } else {
                //                double taxAmt = (currentAmt * taxRate) / 100;
                double cur_adv_rec_amount =
                    certificationLineVO.getCurrentRow().getAttribute("CurAdvRecAmount") ==
                    null ? 0 :
                    Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("CurAdvRecAmount").toString());
                double cur_ret_rec_amount =
                    certificationLineVO.getCurrentRow().getAttribute("CurRetRecAmount") ==
                    null ? 0 :
                    Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("CurRetRecAmount").toString());
                /**
           * tax_amount 01-09-2023 added as requested by arun
           */
                double final_tax_amount =
                    currentAmt - cur_adv_rec_amount - cur_ret_rec_amount;
                double taxAmt = (final_tax_amount * taxRate) / 100;

                certificationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                 new BigDecimal(df.format(taxAmt)));
                AdfFacesContext.getCurrentInstance().addPartialTarget(certCurrTaxAmt);
            }

        }
    }

    public void setRet_per(RichInputText ret_per) {
        this.ret_per = ret_per;
    }

    public RichInputText getRet_per() {
        return ret_per;
    }

    public void onChangeContractNumber(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getOldValue() != null) {
            //            paymentType.setValue("");
            //            AdfFacesContext.getCurrentInstance().addPartialTarget(paymentType);
            // Delete certification line
            RowSetIterator rs = certificationLineVO.createRowSetIterator(null);
            while (rs.hasNext()) {
                Row r = rs.next();
                r.remove();
            }

        }
    }

    public void setBal_cont_amt(RichInputText bal_cont_amt) {
        this.bal_cont_amt = bal_cont_amt;
    }

    public RichInputText getBal_cont_amt() {
        return bal_cont_amt;
    }

    public void setTot_Cont_Amt(RichInputText tot_Cont_Amt) {
        this.tot_Cont_Amt = tot_Cont_Amt;
    }

    public RichInputText getTot_Cont_Amt() {
        return tot_Cont_Amt;
    }

    public void setCum_Appl(RichInputText cum_Appl) {
        this.cum_Appl = cum_Appl;
    }

    public RichInputText getCum_Appl() {
        return cum_Appl;
    }

    public void setCum_Adv_Rec(RichInputText cum_Adv_Rec) {
        this.cum_Adv_Rec = cum_Adv_Rec;
    }

    public RichInputText getCum_Adv_Rec() {
        return cum_Adv_Rec;
    }

    public void setCum_Ret(RichInputText cum_Ret) {
        this.cum_Ret = cum_Ret;
    }

    public RichInputText getCum_Ret() {
        return cum_Ret;
    }

    public void setBal_mat_rec(RichInputText bal_mat_rec) {
        this.bal_mat_rec = bal_mat_rec;
    }

    public RichInputText getBal_mat_rec() {
        return bal_mat_rec;
    }

    public void setCur_mat_adv_amt(RichInputText cur_mat_adv_amt) {
        this.cur_mat_adv_amt = cur_mat_adv_amt;
    }

    public RichInputText getCur_mat_adv_amt() {
        return cur_mat_adv_amt;
    }

    public void setCum_mat_adv_amt(RichInputText cum_mat_adv_amt) {
        this.cum_mat_adv_amt = cum_mat_adv_amt;
    }

    public RichInputText getCum_mat_adv_amt() {
        return cum_mat_adv_amt;
    }

    public void setTot_mat_adv_amt(RichInputText tot_mat_adv_amt) {
        this.tot_mat_adv_amt = tot_mat_adv_amt;
    }

    public RichInputText getTot_mat_adv_amt() {
        return tot_mat_adv_amt;
    }

    public void setPrev_mat_adv_rec(RichInputText prev_mat_adv_rec) {
        this.prev_mat_adv_rec = prev_mat_adv_rec;
    }

    public RichInputText getPrev_mat_adv_rec() {
        return prev_mat_adv_rec;
    }

    public void setCertCurrTaxAmt(RichInputText certCurrTaxAmt) {
        this.certCurrTaxAmt = certCurrTaxAmt;
    }

    public RichInputText getCertCurrTaxAmt() {
        return certCurrTaxAmt;
    }

    public void onChangeCurCertiAmt(ValueChangeEvent valueChangeEvent) {
        if (certificationHrdVO.getCurrentRow().getAttribute("PaymentType").toString().equalsIgnoreCase("Advance") ||
            certificationHrdVO.getCurrentRow().getAttribute("PaymentType").toString().equalsIgnoreCase("Material Advance")) {
            double appCurAmt =
                certificationHrdVO.getCurrentRow().getAttribute("CurApplicationTrans") ==
                null ? 0 :
                Double.parseDouble(certificationHrdVO.getCurrentRow().getAttribute("CurApplicationTrans").toString());
            double certCurAmt =
                Double.parseDouble(valueChangeEvent.getNewValue().toString());
            if (certCurAmt <= appCurAmt) {

            } else {
                JSFUtils.addFacesErrorMessage("Please check certification amount is greater than application amount");
                curCert.setValue(valueChangeEvent.getOldValue());
                AdfFacesContext.getCurrentInstance().addPartialTarget(curCert);

            }
        }
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

    public void setContra_Charge(RichInputText contra_Charge) {
        this.contra_Charge = contra_Charge;
    }

    public RichInputText getContra_Charge() {
        return contra_Charge;
    }

    public void setPenality_Charge(RichInputText penality_Charge) {
        this.penality_Charge = penality_Charge;
    }

    public RichInputText getPenality_Charge() {
        return penality_Charge;
    }


    //**Approval Process

    String submitPkg = "xxfnd_util_pkg.submit_for_approval";
    String responsePkg = "xxfnd_util_pkg.update_response";
    String tableName = "XXSC_CERTIFICATION_HEADERS";
    String app_status_column = "APPROVAL_STATUS";
    String pk_column = "CERT_HEADER_ID";
    String fwd_to = "0";
    //        String response="A";
    //        String status  ="Approved";
    //        String submitMailPkg="xxfnd_util_pkg.submit_mail";


    public boolean getApprovalUser() {
        boolean flag = false;
        String flowWith =
            certificationHrdVO.getCurrentRow().getAttribute("FlowWith") ==
            null ? "" :
            certificationHrdVO.getCurrentRow().getAttribute("FlowWith").toString();
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
        //
        String maxContVrsn = null;
        String contHdrId =
            certificationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
            null ? "0" :
            certificationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
        String appHdrId =
            certificationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
            null ? "0" :
            certificationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();
        String certVrsn =
            certificationHrdVO.getCurrentRow().getAttribute("Version") ==
            null ? "0" :
            certificationHrdVO.getCurrentRow().getAttribute("Version").toString();
        ViewObject getMaxContVrsnRoVo =
            ADFUtils.findIterator("Xxsc_AppHdrContHdrVersn_RoVo1Iterator").getViewObject();
        ViewCriteria vwc = getMaxContVrsnRoVo.createViewCriteria();
        ViewCriteriaRow vwcr = vwc.createViewCriteriaRow();
        vwcr.setAttribute("ContHeaderId", contHdrId);
        vwcr.setAttribute("ApplHeaderId", appHdrId);
        vwc.addRow(vwcr);
        getMaxContVrsnRoVo.applyViewCriteria(vwc);
        getMaxContVrsnRoVo.executeQuery();
        if (getMaxContVrsnRoVo.getEstimatedRowCount() > 0) {
            maxContVrsn =
                    getMaxContVrsnRoVo.first().getAttribute("MaxContVersion") ==
                    null ? "0" :
                    getMaxContVrsnRoVo.first().getAttribute("MaxContVersion").toString();
        }
        if (!certVrsn.equals(maxContVrsn)) {
            JSFUtils.addFacesErrorMessage("Kindly Check a new contract version is amended !!!");
        } else {
            String certHdrId =
                certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId") ==
                null ? "0" :
                certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId").toString();
            String paymtType =
                certificationHrdVO.getCurrentRow().getAttribute("PaymentType") ==
                null ? "0" :
                certificationHrdVO.getCurrentRow().getAttribute("PaymentType").toString();
            ViewObject attachVO =
                ADFUtils.findIterator("XxscAttachmentVO1Iterator").getViewObject();
            ViewCriteria vc = attachVO.createViewCriteria();
            ViewCriteriaRow vcr = vc.createViewCriteriaRow();
            vcr.setAttribute("Certrefid", certHdrId);
            vcr.setAttribute("Attribute1", null);
            vc.addRow(vcr);
            attachVO.applyViewCriteria(vc);
            attachVO.executeQuery();

            if (attachVO.getEstimatedRowCount() <= 0 &&
                !paymtType.equalsIgnoreCase("Advance")) {
                JSFUtils.addFacesErrorMessage("Please Select Attachment for the certificate,Attachment is mandatory");
            } else {
                //
                String page = onClickSave();
                if (page.equalsIgnoreCase("save")) {
                    if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy") ||
                        ADFContext.getCurrent().getSessionScope().get("page").equals("certificationBuy") ||
                        ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
                        // Field Info
                        String func_id =
                            certificationHrdVO.getCurrentRow().getAttribute("FuncId") ==
                            null ? "0" :
                            certificationHrdVO.getCurrentRow().getAttribute("FuncId").toString();
                        String ref_id =
                            certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId") ==
                            null ? "0" :
                            certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId").toString();
                        String level_no =
                            certificationHrdVO.getCurrentRow().getAttribute("FlowLevel") ==
                            null ? "0" :
                            certificationHrdVO.getCurrentRow().getAttribute("FlowLevel").toString();
                        String OrgId =
                            certificationHrdVO.getCurrentRow().getAttribute("OrgId") ==
                            null ? "0" :
                            certificationHrdVO.getCurrentRow().getAttribute("OrgId").toString();
                        String totalContAmt =
                            certificationHrdVO.getCurrentRow().getAttribute("Trans_ContractAmount") ==
                            null ? "0" :
                            certificationHrdVO.getCurrentRow().getAttribute("Trans_ContractAmount").toString();
                        String grossAmt =
                            certificationHrdVO.getCurrentRow().getAttribute("CurCertification") ==
                            null ? "0" :
                            certificationHrdVO.getCurrentRow().getAttribute("CurCertification").toString();
                        String netAmt =
                            certificationHrdVO.getCurrentRow().getAttribute("CurPayAmount") ==
                            null ? "0.0" :
                            certificationHrdVO.getCurrentRow().getAttribute("CurPayAmount").toString();
                        String highOrLow = "LOWER";
                        Double netAmtD = new Double(netAmt);
                        if (netAmtD > 1000000) {
                            highOrLow = "HIGHER";
                        } else {
                            highOrLow = "LOWER";
                        }
                        highOrLow =
                                null; //as in prod this Higher and Lower logic is not to deploy
                        String projectId =
                            proId.getValue() == null ? "0" : proId.getValue().toString();
                        // Approval Process
                        String approvalInfo =
                            ADFApproval.approvalInfo(lookupVO, "BUY_CERT");
                        if (approvalInfo.equalsIgnoreCase("AUTO")) {
                            pageRedirect = autoApproval(certificationHrdVO);
                        } else if (approvalInfo.equalsIgnoreCase("ADF")) {
                            pageRedirect =
                                    ADFApproval(certificationHrdVO, func_id,
                                                ref_id, level_no, OrgId,
                                                projectId, highOrLow);
                        } else if (approvalInfo.equalsIgnoreCase("PCS")) {
                            pageRedirect =
                                    ADFApprovalPCS(certificationHrdVO, func_id,
                                                   ref_id, level_no, OrgId,
                                                   projectId, highOrLow);
                        } else {
                            pageRedirect = null;
                            JSFUtils.addFacesErrorMessage("Error in Approval Process");
                        }

                    } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell") ||
                               ADFContext.getCurrent().getSessionScope().get("page").equals("certificationSell") ||
                               ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {

                        // Sell Approval process
                        //**************omniyat & omniyat*****************
                        //                pageRedirect = submitWithApproval();
                        //**************NSCC**************
                        //                pageRedirect = submitWithOutApproval();
                    }

                }
            }
        }
        return pageRedirect;

    }
    //

    public String autoApproval(ViewObject VO) {
        String pageRedirect = null;
        VO.getCurrentRow().setAttribute("ApprovalStatus", "APR");
        ADFUtils.findOperation("Commit").execute();
        pageRedirect = "save";
        JSFUtils.addFacesInformationMessage("Information Saved Successfully and Approval Successfully");
        return pageRedirect;
    }

    public String ADFApproval(ViewObject certificationHrdVO, String func_id,
                              String ref_id, String level_no, String OrgId,
                              String projectId,
                              String highOrLow) throws SQLException {
        String pageRedirect = null;
        String flag =
            ADFApproval.invokeSubmitPkg(submitPkg, func_id, ref_id, level_no,
                                        tableName, app_status_column,
                                        pk_column, OrgId, projectId,
                                        highOrLow);
        if (flag.equalsIgnoreCase("Success")) {
            String flowWith =
                ADFContext.getCurrent().getSessionScope().get("flow_with") ==
                null ? "0" :
                ADFContext.getCurrent().getSessionScope().get("flow_with").toString();
            ViewObject ApproveMailVO =
                ADFUtils.findIterator("XxscHeadDetailROVO1Iterator").getViewObject();
            ApproveMailVO.setNamedWhereClauseParam("BV_USER_ID", flowWith);
            ApproveMailVO.executeQuery();
            if (ApproveMailVO.getEstimatedRowCount() != 0) {
                String to =
                    ApproveMailVO.first().getAttribute("Email") == null ?
                    "dineshkumar.p@4iapps.com" :
                    ApproveMailVO.first().getAttribute("Email").toString();
                String LoginUser =
                    ADFContext.getCurrent().getSessionScope().get("userName") ==
                    null ? "0" :
                    ADFContext.getCurrent().getSessionScope().get("userName").toString();
                //                                String to1="fusion.support@omniyat.com";
                String to2 = "prasenjit.d@4iapps.com";
                ArrayList<String> ar = new ArrayList();
                ar.add(to);
                //                      ar.add(to1);
                ar.add(to2);
                //for new approval mail content on 20-nov-22
                //                      ViewObject getCertMailRoVo =ADFUtils.findIterator("CertContAppDtlsAprvMail_RoVo1Iterator").getViewObject();
                //                          ViewCriteria vwc = getCertMailRoVo.createViewCriteria();
                //                          ViewCriteriaRow vwcr = vwc.createViewCriteriaRow();
                //                          vwcr.setAttribute("CertHeaderId", ref_id);
                //                          vwc.addRow(vwcr);
                //                          getCertMailRoVo.applyViewCriteria(vwc);
                //                          getCertMailRoVo.executeQuery();
                //                          System.out.println("ref_id :"+ref_id+" count-1%%%"+getCertMailRoVo.getEstimatedRowCount());
                //                          if(getCertMailRoVo.getEstimatedRowCount()>0){
                //                              System.out.println("ContractNum-2%%%"+getCertMailRoVo.first().getAttribute("ContractNum"));
                //                              String contNum = getCertMailRoVo.first().getAttribute("ContractNum") == null ? "0" : getCertMailRoVo.first().getAttribute("ContractNum").toString();
                //                              String certNum = getCertMailRoVo.first().getAttribute("CertificationNumber") == null ? "0" : getCertMailRoVo.first().getAttribute("CertificationNumber").toString();
                //                              String certAmtWthOutVat = getCertMailRoVo.first().getAttribute("CurCertification") == null ? "0" : getCertMailRoVo.first().getAttribute("CurCertification").toString();
                //                              String TaxAmt = getCertMailRoVo.first().getAttribute("TaxAmt") == null ? "0" : getCertMailRoVo.first().getAttribute("TaxAmt").toString();
                //                              String certAmtWthVat = getCertMailRoVo.first().getAttribute("CurCertWithtax") == null ? "0" : getCertMailRoVo.first().getAttribute("CurCertWithtax").toString();
                //                              String supName = getCertMailRoVo.first().getAttribute("VendorName") == null ? "" : getCertMailRoVo.first().getAttribute("VendorName").toString();
                //                              String projNum = getCertMailRoVo.first().getAttribute("ProjectNumber") == null ? "" : getCertMailRoVo.first().getAttribute("ProjectNumber").toString();
                //                              String projName = getCertMailRoVo.first().getAttribute("ProjectName") == null ? "" : getCertMailRoVo.first().getAttribute("ProjectName").toString();
                //                              String totlContValue = getCertMailRoVo.first().getAttribute("TotalContractSum") == null ? "0" : getCertMailRoVo.first().getAttribute("TotalContractSum").toString();
                //                              String curncy = getCertMailRoVo.first().getAttribute("CurrencyCode") == null ? "" : getCertMailRoVo.first().getAttribute("CurrencyCode").toString();
                //                              String payDueDate = getCertMailRoVo.first().getAttribute("PaymentDueDate") == null ? "" : getCertMailRoVo.first().getAttribute("PaymentDueDate").toString();
                //                              String note = getCertMailRoVo.first().getAttribute("NoteToSupplier") == null ? "" : getCertMailRoVo.first().getAttribute("NoteToSupplier").toString();
                //                              String aprvr = getCertMailRoVo.first().getAttribute("Approver") == null ? "" : getCertMailRoVo.first().getAttribute("Approver").toString();
                //                              String buyer = getCertMailRoVo.first().getAttribute("Buyer") == null ? "" : getCertMailRoVo.first().getAttribute("Buyer").toString();
                //                              //cumulative
                //                              String c_cum = getCertMailRoVo.first().getAttribute("TotalContractSum") == null ? "0" : getCertMailRoVo.first().getAttribute("TotalContractSum").toString();
                //                              String r_cum = getCertMailRoVo.first().getAttribute("TotalRet") == null ? "0" : getCertMailRoVo.first().getAttribute("TotalRet").toString();
                //                              String a_cum = getCertMailRoVo.first().getAttribute("TotalAdvAmount") == null ? "0" : getCertMailRoVo.first().getAttribute("TotalAdvAmount").toString();
                //                              String m_cum = getCertMailRoVo.first().getAttribute("TotlMtrlAmt") == null ? "0" : getCertMailRoVo.first().getAttribute("TotlMtrlAmt").toString();
                //                              String n_cum = getCertMailRoVo.first().getAttribute("NetCummAmt") == null ? "0" : getCertMailRoVo.first().getAttribute("NetCummAmt").toString();
                //                              //previous
                //                              String c_prv = getCertMailRoVo.first().getAttribute("PrevApplication") == null ? "0" : getCertMailRoVo.first().getAttribute("PrevApplication").toString();
                //                              String r_prv = getCertMailRoVo.first().getAttribute("PrevRet") == null ? "0" : getCertMailRoVo.first().getAttribute("PrevRet").toString();
                //                              String a_prv = getCertMailRoVo.first().getAttribute("PrevAdvRec") == null ? "0" : getCertMailRoVo.first().getAttribute("PrevAdvRec").toString();
                //                              String m_prv = getCertMailRoVo.first().getAttribute("PrevMatAdvAmt") == null ? "0" : getCertMailRoVo.first().getAttribute("PrevMatAdvAmt").toString();
                //                              String n_prv = getCertMailRoVo.first().getAttribute("NetPrevAmt") == null ? "0" : getCertMailRoVo.first().getAttribute("NetPrevAmt").toString();
                //                              //current
                //                              String c_curnt = getCertMailRoVo.first().getAttribute("CurPayAmount") == null ? "0" : getCertMailRoVo.first().getAttribute("CurPayAmount").toString();
                //                              String r_curnt = getCertMailRoVo.first().getAttribute("CurRet") == null ? "0" : getCertMailRoVo.first().getAttribute("CurRet").toString();
                //                              String a_curnt = getCertMailRoVo.first().getAttribute("CurAdvRec") == null ? "0" : getCertMailRoVo.first().getAttribute("CurAdvRec").toString();
                //                              String m_curnt = getCertMailRoVo.first().getAttribute("CurMatAdvRec") == null ? "0" : getCertMailRoVo.first().getAttribute("CurMatAdvRec").toString();
                //                              String n_curnt = getCertMailRoVo.first().getAttribute("NetCurntAmt") == null ? "0" : getCertMailRoVo.first().getAttribute("NetCurntAmt").toString();
                //                              //balance
                ////                              String c_blnc = getCertMailRoVo.first().getAttribute("BalContAmt") == null ? "0" : getCertMailRoVo.first().getAttribute("BalContAmt").toString();
                ////                              String r_blnc = getCertMailRoVo.first().getAttribute("BalanceRet") == null ? "0" : getCertMailRoVo.first().getAttribute("BalanceRet").toString();
                ////                              String a_blnc = getCertMailRoVo.first().getAttribute("BalanceAdvRec") == null ? "0" : getCertMailRoVo.first().getAttribute("BalanceAdvRec").toString();
                ////                              String m_blnc = getCertMailRoVo.first().getAttribute("BlncMtrlAmt") == null ? "0" : getCertMailRoVo.first().getAttribute("BlncMtrlAmt").toString();
                ////                              String n_blnc = getCertMailRoVo.first().getAttribute("NetBlncAmt") == null ? "0" : getCertMailRoVo.first().getAttribute("NetBlncAmt").toString();
                //
                //                              String appNo = getCertMailRoVo.first().getAttribute("ApplicationNumber") == null ? "0" : getCertMailRoVo.first().getAttribute("ApplicationNumber").toString();
                //                              String certDate = getCertMailRoVo.first().getAttribute("CertificationDate") == null ? "" : getCertMailRoVo.first().getAttribute("CertificationDate").toString();
                //                              String supInvNo = getCertMailRoVo.first().getAttribute("InvoiceNum") == null ? "" : getCertMailRoVo.first().getAttribute("InvoiceNum").toString();
                //                              String supInvDate = getCertMailRoVo.first().getAttribute("InvoiceDate") == null ? "" : getCertMailRoVo.first().getAttribute("InvoiceDate").toString();
                //                              String payTyp = getCertMailRoVo.first().getAttribute("PaymentTypeDisp") == null ? "" : getCertMailRoVo.first().getAttribute("PaymentTypeDisp").toString();
                //                              String payTrm = getCertMailRoVo.first().getAttribute("PaymentTerm") == null ? "" : getCertMailRoVo.first().getAttribute("PaymentTerm").toString();
                //                              String cmnts = getCertMailRoVo.first().getAttribute("Comments") == null ? "" : getCertMailRoVo.first().getAttribute("Comments").toString();
                //                              String htmlBody= MailTemplates.updatedAprvlMail(contNum,certNum,certAmtWthOutVat,TaxAmt,certAmtWthVat,supName,projNum,projName,totlContValue,curncy,payDueDate,note,aprvr,buyer,
                //                                                   c_cum,r_cum,a_cum,m_cum,n_cum,
                //                                                   c_prv,r_prv,a_prv,m_prv,n_prv,
                //                                                   c_curnt,r_curnt,a_curnt,m_curnt,n_curnt,
                //                                                   appNo,certDate,supInvNo,supInvDate,payTyp,payTrm,cmnts);
                //                              String subject="Certification submitted for Approval";
                //                              MailServices.sendMail(htmlBody, subject, "fusionalerts@omniyat.com", ar, "0r@cl3alert", "smtp.office365.com", "N", null);
                //                          }
                //
                String htmlBody =
                    MailTemplates.submit("Certification", certificationHrdVO.getCurrentRow().getAttribute("CertificationNumber").toString(),
                                         LoginUser);
                String subject = "Certification submitted for Approval";
                //            MailServices.sendNotification("dineshkumar.p@4iapps.com,arunachalam.t@4iapps.com,sundarrajan.v@4iapps.com,mahalingam.m@4iapps.com", fromMail, null, htmlBody, subject);
                //ADFApproval.submitMailPkg(LoginUser, to,"Certification",certificationHrdVO.getCurrentRow().getAttribute("CertificationNumber").toString(),LoginUser);
                MailServices.sendMail(htmlBody, subject,
                                      "fusionalerts@omniyat.com", ar,
                                      "0r@cl3alert", "smtp.office365.com", "N",
                                      null);
                if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationBuy")) {
                    JSFUtils.addFacesInformationMessage("Information Saved Successfully and Submitted For Approval(Approver : " +
                                                        to + ")");
                    pageRedirect = "save";
                } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationSell")) {
                    JSFUtils.addFacesInformationMessage("Sell Certification Information Saved Successfully and Submit For Approval");
                    pageRedirect = "save";
                }

            } else {
                // JSFUtils.addFacesErrorMessage("Mail Notification Failed");
            }
        } else {
            JSFUtils.addFacesErrorMessage("Error in Submit For Approval. Error Message:" +
                                          flag);
            pageRedirect = null;
        }
        return pageRedirect;
    }

    //PCS approval submit process

    public String ADFApprovalPCS(ViewObject certificationHrdVO, String func_id,
                                 String ref_id, String level_no, String OrgId,
                                 String projectId,
                                 String highOrLow) throws IOException {
        String pageRedirect = null;
        ViewObject certificationAccessTokenROVO =
            ADFUtils.findIterator("certificationtokenaccessrovo1Iterator").getViewObject();
        String varProcessDefId =
            certificationAccessTokenROVO.first().getAttribute("Attribute1").toString();
        String certinterfacetoken =
            certificationAccessTokenROVO.first().getAttribute("AuthenticationToken").toString();


        try {
            String flag =
                ADFApproval.invokeSubmitPkg(submitPkg, func_id, ref_id,
                                            level_no, tableName,
                                            app_status_column, pk_column,
                                            OrgId, projectId, highOrLow);
            if (flag.equalsIgnoreCase("Success")) {
                JSONObject obj = new JSONObject();
                obj.put("action", "submit");
                obj.put("operation", "startEvent");
                obj.put("payload", "{\"transactionId\":\"" + ref_id + "\"}");
                //              obj.put("processDefId", "oracleinternalpcs~ContractProd!~CertProcess");//prod
                obj.put("processDefId", varProcessDefId); //test
                obj.put("serviceName", "CertProcess.service");

                //              JSFUtils.addFacesInformationMessage("Cert parameter id :" +obj.toString());
                OkHttpClient client = new OkHttpClient();
                MediaType mediaType = MediaType.parse("application/json");
                RequestBody body =
                    RequestBody.create(mediaType, obj.toString()); //---
                //              Request request = new Request.Builder().url("https://omniyataics-omniyat.integration.ocp.oraclecloud.com/bpm/api/4.0/processes").post(body).addHeader("Content-Type","application/json").addHeader("Authorization","Basic c2FpbmFkaC5kQDRpYXBwcy5jb206T21uaXlhdCMyMDIzIzA1").build();//Auth here is for 10-07-23-sainadh.d@4iapps.com
                Request request =
                    new Request.Builder().url("https://omniyataics-omniyat.integration.ocp.oraclecloud.com/bpm/api/4.0/processes").post(body).addHeader("Content-Type",
                                                                                                                                                        "application/json").addHeader("Authorization",
                                                                                                                                                                                      certinterfacetoken).build(); //Auth here is for 10-07-23-sainadh.d@4iapps.com

                //              Request request = new Request.Builder().url("https://omniyataics-omniyat.integration.ocp.oraclecloud.com/bpm/api/4.0/processes").post(body).addHeader("Content-Type","application/json").addHeader("Authorization","Basic UFJJU01Ab21uaXlhdC5jb206RHViYWlAMjAyMw==").build();//Auth here is for prism@omniyat.com

                Response response = client.newCall(request).execute();
                JSFUtils.addFacesInformationMessage("Response :" + response);

                if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationBuy")) {
                    JSFUtils.addFacesInformationMessage("Information Saved Successfully and Submitted For Approval !!!");
                    pageRedirect = "save";
                }
            } else {
                JSFUtils.addFacesErrorMessage("Error in Submit For Approval. Error Message:" +
                                              flag);
                pageRedirect = null;
            }

        } catch (Exception e) {
            JSFUtils.addFacesInformationMessage("Under catch Error in PCS" +
                                                e);
        }
        return pageRedirect;
    }


    // -- need to check

    public String submitWithApproval() throws SQLException,
                                              MalformedURLException,
                                              IOException {
        String pageRedirect = null;
        String func_id =
            certificationHrdVO.getCurrentRow().getAttribute("FuncId") == null ?
            "0" :
            certificationHrdVO.getCurrentRow().getAttribute("FuncId").toString();
        String ref_id =
            certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId") ==
            null ? "0" :
            certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId").toString();
        String level_no =
            certificationHrdVO.getCurrentRow().getAttribute("FlowLevel") ==
            null ? "0" :
            certificationHrdVO.getCurrentRow().getAttribute("FlowLevel").toString();
        String OrgId =
            certificationHrdVO.getCurrentRow().getAttribute("OrgId") == null ?
            "0" :
            certificationHrdVO.getCurrentRow().getAttribute("OrgId").toString();
        String projectId =
            proId.getValue() == null ? "0" : proId.getValue().toString();
        String flag =
            ADFApproval.invokeSubmitPkg(submitPkg, func_id, ref_id, level_no,
                                        tableName, app_status_column,
                                        pk_column, OrgId, projectId, null);

        if (flag.equalsIgnoreCase("Success")) {

            String flowWith =
                ADFContext.getCurrent().getSessionScope().get("flow_with") ==
                null ? "0" :
                ADFContext.getCurrent().getSessionScope().get("flow_with").toString();
            ViewObject ApproveMailVO =
                ADFUtils.findIterator("XxscHeadDetailROVO1Iterator").getViewObject();
            ApproveMailVO.setNamedWhereClauseParam("BV_USER_ID", flowWith);
            ApproveMailVO.executeQuery();
            if (ApproveMailVO.getEstimatedRowCount() != 0) {
                String to =
                    ApproveMailVO.first().getAttribute("UserName") == null ?
                    "sdl@omniyat.com" :
                    ApproveMailVO.first().getAttribute("UserName").toString();
                String LoginUser =
                    ADFContext.getCurrent().getSessionScope().get("userName") ==
                    null ? "0" :
                    ADFContext.getCurrent().getSessionScope().get("userName").toString();
                //                    String htmlBody= MailTemplates.submit("Certification", certificationHrdVO.getCurrentRow().getAttribute("CertificationNumber").toString(), LoginUser);
                //                    String subject="Mail Notification";
                //                    MailServices.sendNotification("dineshkumar.p@4iapps.com,arunachalam.t@4iapps.com,sundarrajan.v@4iapps.com,mahalingam.m@4iapps.com", fromMail, null, htmlBody, subject);
                ADFApproval.submitMailPkg(LoginUser, to, "Certification",
                                          certificationHrdVO.getCurrentRow().getAttribute("CertificationNumber").toString(),
                                          LoginUser);
                if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationBuy")) {
                    JSFUtils.addFacesInformationMessage("Buy Certification Information Saved Successfully and Submit For Approval");
                    pageRedirect = "save";
                } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationSell")) {
                    JSFUtils.addFacesInformationMessage("Sell Certification Information Saved Successfully and Submit For Approval");
                    pageRedirect = "save";
                }

            } else {

            }
        } else {
            JSFUtils.addFacesErrorMessage("Error in Submit For Approval. Error Message:" +
                                          flag);
            pageRedirect = null;
        }


        return pageRedirect;
    }

    public String submitWithOutApproval() {
        try {
            if (certificationHrdVO.getCurrentRow().getAttribute("PaymentType") !=
                null) {
                if (certificationHrdVO.getCurrentRow().getAttribute("PaymentType").toString().equals("Advance")) {
                    submitJV(certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId"),
                             "ADVANCE",
                             certificationHrdVO.getCurrentRow().getAttribute("CurCertification"));
                    submitProjectBill(certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId"),
                                      "Advance");
                }
                if (certificationHrdVO.getCurrentRow().getAttribute("PaymentType").toString().equals("Interim")) {
                    submitJV(certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId"),
                             "CURR_CERT_RET",
                             certificationHrdVO.getCurrentRow().getAttribute("CurAdvRec"));
                    submitJV(certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId"),
                             "CURR_CERT_ADV",
                             certificationHrdVO.getCurrentRow().getAttribute("CurRet"));
                    submitProjectBill(certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId"),
                                      "Interim");
                }
            }
        } catch (Exception e) {
            JSFUtils.addFacesErrorMessage("Error : " + e.toString());
        }
        return "save";
    }


    public String onClickApprove() throws SQLException {
        String pageRedirect = null;
        String apprDesc =
            approValue.getValue() == null ? "Approved" : approValue.getValue().toString();
        if (approValue.getValue() != null) {
            if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy") ||
                ADFContext.getCurrent().getSessionScope().get("page").equals("certificationBuy") ||
                ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
                // buy
                String func_id =
                    certificationHrdVO.getCurrentRow().getAttribute("FuncId") ==
                    null ? "" :
                    certificationHrdVO.getCurrentRow().getAttribute("FuncId").toString();
                String ref_id =
                    certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId") ==
                    null ? "" :
                    certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId").toString();
                String level_no =
                    certificationHrdVO.getCurrentRow().getAttribute("FlowLevel") ==
                    null ? "" :
                    certificationHrdVO.getCurrentRow().getAttribute("FlowLevel").toString();
                String appr_id =
                    certificationHrdVO.getCurrentRow().getAttribute("FlowWith") ==
                    null ? "" :
                    certificationHrdVO.getCurrentRow().getAttribute("FlowWith").toString();
                String user_grp =
                    certificationHrdVO.getCurrentRow().getAttribute("UserGrpId") ==
                    null ? "" :
                    certificationHrdVO.getCurrentRow().getAttribute("UserGrpId").toString();

                String flag =
                    ADFApproval.invokeResponsePkg(responsePkg, func_id,
                                                  user_grp, ref_id, level_no,
                                                  appr_id, apprDesc, "A",
                                                  fwd_to, tableName,
                                                  app_status_column,
                                                  pk_column);
                if (flag.equalsIgnoreCase("Success")) {
                    //
                    //                System.out.println("flag :::"+flag);
                    String flowWith = "";
                    String flowlvlNo = "";
                    String certAprvlStatus = "";
                    String projName = null;
                    ViewObject getCertRoVo =
                        ADFUtils.findIterator("GetCertDetailsRoVo1Iterator").getViewObject();
                    ViewCriteria vwc = getCertRoVo.createViewCriteria();
                    ViewCriteriaRow vwcr = vwc.createViewCriteriaRow();
                    vwcr.setAttribute("CertHeaderId", ref_id);
                    vwc.addRow(vwcr);
                    getCertRoVo.applyViewCriteria(vwc);
                    getCertRoVo.executeQuery();
                    //                    System.out.println("Out side getCertRoVo.getEstimatedRowCount() :::"+getCertRoVo.getEstimatedRowCount());
                    if (getCertRoVo.getEstimatedRowCount() != 0) {
                        //                        System.out.println("In side getCertRoVo.getEstimatedRowCount() :::"+getCertRoVo.getEstimatedRowCount());
                        flowWith =
                                getCertRoVo.first().getAttribute("FlowWith") ==
                                null ? "" :
                                getCertRoVo.first().getAttribute("FlowWith").toString();
                        flowlvlNo =
                                getCertRoVo.first().getAttribute("FlowLevel") ==
                                null ? "" :
                                getCertRoVo.first().getAttribute("FlowLevel").toString();
                        certAprvlStatus =
                                getCertRoVo.first().getAttribute("ApprovalStatusCert") ==
                                null ? "" :
                                getCertRoVo.first().getAttribute("ApprovalStatusCert").toString();
                        projName =
                                getCertRoVo.first().getAttribute("ProjectName") ==
                                null ? "" :
                                getCertRoVo.first().getAttribute("ProjectName").toString();
                        //                        JSFUtils.addFacesInformationMessage("After Flow With : "+flowWith+" flowlvlNo :"+flowlvlNo+" certAprvlStatus :"+certAprvlStatus+" projName :"+projName);
                    }
                    //ishan auto approval ishan user id=300000002698072
                    if (flowWith.equals("300000002698072")) {
                        level_no = flowlvlNo;
                        appr_id = flowWith;
                        apprDesc = "Auto Approved";
                        flag =
ADFApproval.invokeResponsePkg(responsePkg, func_id, user_grp, ref_id, level_no,
                              appr_id, apprDesc, "A", fwd_to, tableName,
                              app_status_column, pk_column);
                        if (flag.equalsIgnoreCase("Success")) {
                            getCertRoVo.resetExecuted();
                            ViewObject getCertRoVo1 =
                                ADFUtils.findIterator("GetCertDetailsRoVo1Iterator").getViewObject();
                            ViewCriteria vwc1 =
                                getCertRoVo1.createViewCriteria();
                            ViewCriteriaRow vwcr1 =
                                vwc1.createViewCriteriaRow();
                            vwcr1.setAttribute("CertHeaderId", ref_id);
                            vwc1.addRow(vwcr1);
                            getCertRoVo1.applyViewCriteria(vwc1);
                            getCertRoVo1.executeQuery();
                            //                         System.out.println("Out side getCertRoVo1.getEstimatedRowCount() :::"+getCertRoVo.getEstimatedRowCount());
                            if (getCertRoVo1.getEstimatedRowCount() == 1) {
                                flowWith =
                                        getCertRoVo1.first().getAttribute("FlowWith") ==
                                        null ? "" :
                                        getCertRoVo1.first().getAttribute("FlowWith").toString();
                                flowlvlNo =
                                        getCertRoVo1.first().getAttribute("FlowLevel") ==
                                        null ? "" :
                                        getCertRoVo1.first().getAttribute("FlowLevel").toString();
                                certAprvlStatus =
                                        getCertRoVo1.first().getAttribute("ApprovalStatusCert") ==
                                        null ? "" :
                                        getCertRoVo1.first().getAttribute("ApprovalStatusCert").toString();
                                projName =
                                        getCertRoVo1.first().getAttribute("ProjectName") ==
                                        null ? "" :
                                        getCertRoVo1.first().getAttribute("ProjectName").toString();
                                //                            JSFUtils.addFacesInformationMessage("After ishan Flow With : "+flowWith+" flowlvlNo :"+flowlvlNo+" certAprvlStatus :"+certAprvlStatus+" projName :"+projName);
                            }
                        }
                    }

                    ViewObject ApproveMailVO =
                        ADFUtils.findIterator("XxscHeadDetailROVO1Iterator").getViewObject();
                    ApproveMailVO.setNamedWhereClauseParam("BV_USER_ID",
                                                           flowWith);
                    ApproveMailVO.executeQuery();
                    if (ApproveMailVO.getEstimatedRowCount() != 0) {
                        String to =
                            ApproveMailVO.first().getAttribute("Email") ==
                            null ? "prasenjit.d@4iapps.com" :
                            ApproveMailVO.first().getAttribute("Email").toString();
                        String LoginUser =
                            ADFContext.getCurrent().getSessionScope().get("userName") ==
                            null ? "0" :
                            ADFContext.getCurrent().getSessionScope().get("userName").toString();
                        //                    String to1 = "fusion.support@omniyat.com";
                        String to2 = "prasenjit.d@4iapps.com";
                        ArrayList<String> ar = new ArrayList();
                        ar.add(to);
                        //                    ar.add(to1);
                        ar.add(to2);
                        //for new approval mail content on 20-nov-22
                        //                      ViewObject getCertMailRoVo =ADFUtils.findIterator("CertContAppDtlsAprvMail_RoVo1Iterator").getViewObject();
                        //                          ViewCriteria vwc1 = getCertMailRoVo.createViewCriteria();
                        //                          ViewCriteriaRow vwcr1 = vwc1.createViewCriteriaRow();
                        //                          vwcr1.setAttribute("CertHeaderId", ref_id);
                        //                          vwc1.addRow(vwcr1);
                        //                          getCertMailRoVo.applyViewCriteria(vwc1);
                        //                          getCertMailRoVo.executeQuery();
                        //                          if(getCertMailRoVo.getEstimatedRowCount()>0){
                        //                              String contNum = getCertMailRoVo.first().getAttribute("ContractNum") == null ? "0" : getCertMailRoVo.first().getAttribute("ContractNum").toString();
                        //                              String certNum = getCertMailRoVo.first().getAttribute("CertificationNumber") == null ? "0" : getCertMailRoVo.first().getAttribute("CertificationNumber").toString();
                        //                              String certAmtWthOutVat = getCertMailRoVo.first().getAttribute("CurCertification") == null ? "0" : getCertMailRoVo.first().getAttribute("CurCertification").toString();
                        //                              String TaxAmt = getCertMailRoVo.first().getAttribute("TaxAmt") == null ? "0" : getCertMailRoVo.first().getAttribute("TaxAmt").toString();
                        //                              String certAmtWthVat = getCertMailRoVo.first().getAttribute("CurCertWithtax") == null ? "0" : getCertMailRoVo.first().getAttribute("CurCertWithtax").toString();
                        //                              String supName = getCertMailRoVo.first().getAttribute("VendorName") == null ? "" : getCertMailRoVo.first().getAttribute("VendorName").toString();
                        //                              String projNum = getCertMailRoVo.first().getAttribute("ProjectNumber") == null ? "" : getCertMailRoVo.first().getAttribute("ProjectNumber").toString();
                        //                              projName = getCertMailRoVo.first().getAttribute("ProjectName") == null ? "" : getCertMailRoVo.first().getAttribute("ProjectName").toString();
                        //                              String totlContValue = getCertMailRoVo.first().getAttribute("TotalContractSum") == null ? "0" : getCertMailRoVo.first().getAttribute("TotalContractSum").toString();
                        //                              String curncy = getCertMailRoVo.first().getAttribute("CurrencyCode") == null ? "" : getCertMailRoVo.first().getAttribute("CurrencyCode").toString();
                        //                              String payDueDate = getCertMailRoVo.first().getAttribute("PaymentDueDate") == null ? "" : getCertMailRoVo.first().getAttribute("PaymentDueDate").toString();
                        //                              String note = getCertMailRoVo.first().getAttribute("NoteToSupplier") == null ? "" : getCertMailRoVo.first().getAttribute("NoteToSupplier").toString();
                        //                              String aprvr = getCertMailRoVo.first().getAttribute("Approver") == null ? "" : getCertMailRoVo.first().getAttribute("Approver").toString();
                        //                              String buyer = getCertMailRoVo.first().getAttribute("Buyer") == null ? "" : getCertMailRoVo.first().getAttribute("Buyer").toString();
                        //                              //cumulative
                        //                              String c_cum = getCertMailRoVo.first().getAttribute("TotalContractSum") == null ? "0" : getCertMailRoVo.first().getAttribute("TotalContractSum").toString();
                        //                              String r_cum = getCertMailRoVo.first().getAttribute("TotalRet") == null ? "0" : getCertMailRoVo.first().getAttribute("TotalRet").toString();
                        //                              String a_cum = getCertMailRoVo.first().getAttribute("TotalAdvAmount") == null ? "0" : getCertMailRoVo.first().getAttribute("TotalAdvAmount").toString();
                        //                              String m_cum = getCertMailRoVo.first().getAttribute("TotlMtrlAmt") == null ? "0" : getCertMailRoVo.first().getAttribute("TotlMtrlAmt").toString();
                        //                              String n_cum = getCertMailRoVo.first().getAttribute("NetCummAmt") == null ? "0" : getCertMailRoVo.first().getAttribute("NetCummAmt").toString();
                        //                              //previous
                        //                              String c_prv = getCertMailRoVo.first().getAttribute("PrevApplication") == null ? "0" : getCertMailRoVo.first().getAttribute("PrevApplication").toString();
                        //                              String r_prv = getCertMailRoVo.first().getAttribute("PrevRet") == null ? "0" : getCertMailRoVo.first().getAttribute("PrevRet").toString();
                        //                              String a_prv = getCertMailRoVo.first().getAttribute("PrevAdvRec") == null ? "0" : getCertMailRoVo.first().getAttribute("PrevAdvRec").toString();
                        //                              String m_prv = getCertMailRoVo.first().getAttribute("PrevMatAdvAmt") == null ? "0" : getCertMailRoVo.first().getAttribute("PrevMatAdvAmt").toString();
                        //                              String n_prv = getCertMailRoVo.first().getAttribute("NetPrevAmt") == null ? "0" : getCertMailRoVo.first().getAttribute("NetPrevAmt").toString();
                        //                              //current
                        //                              String c_curnt = getCertMailRoVo.first().getAttribute("CurPayAmount") == null ? "0" : getCertMailRoVo.first().getAttribute("CurPayAmount").toString();
                        //                              String r_curnt = getCertMailRoVo.first().getAttribute("CurRet") == null ? "0" : getCertMailRoVo.first().getAttribute("CurRet").toString();
                        //                              String a_curnt = getCertMailRoVo.first().getAttribute("CurAdvRec") == null ? "0" : getCertMailRoVo.first().getAttribute("CurAdvRec").toString();
                        //                              String m_curnt = getCertMailRoVo.first().getAttribute("CurMatAdvRec") == null ? "0" : getCertMailRoVo.first().getAttribute("CurMatAdvRec").toString();
                        //                              String n_curnt = getCertMailRoVo.first().getAttribute("NetCurntAmt") == null ? "0" : getCertMailRoVo.first().getAttribute("NetCurntAmt").toString();
                        //                              //balance
                        //                      //                              String c_blnc = getCertMailRoVo.first().getAttribute("BalContAmt") == null ? "0" : getCertMailRoVo.first().getAttribute("BalContAmt").toString();
                        //                      //                              String r_blnc = getCertMailRoVo.first().getAttribute("BalanceRet") == null ? "0" : getCertMailRoVo.first().getAttribute("BalanceRet").toString();
                        //                      //                              String a_blnc = getCertMailRoVo.first().getAttribute("BalanceAdvRec") == null ? "0" : getCertMailRoVo.first().getAttribute("BalanceAdvRec").toString();
                        //                      //                              String m_blnc = getCertMailRoVo.first().getAttribute("BlncMtrlAmt") == null ? "0" : getCertMailRoVo.first().getAttribute("BlncMtrlAmt").toString();
                        //                      //                              String n_blnc = getCertMailRoVo.first().getAttribute("NetBlncAmt") == null ? "0" : getCertMailRoVo.first().getAttribute("NetBlncAmt").toString();
                        //
                        //                              String appNo = getCertMailRoVo.first().getAttribute("ApplicationNumber") == null ? "0" : getCertMailRoVo.first().getAttribute("ApplicationNumber").toString();
                        //                              String certDate = getCertMailRoVo.first().getAttribute("CertificationDate") == null ? "" : getCertMailRoVo.first().getAttribute("CertificationDate").toString();
                        //                              String supInvNo = getCertMailRoVo.first().getAttribute("InvoiceNum") == null ? "" : getCertMailRoVo.first().getAttribute("InvoiceNum").toString();
                        //                              String supInvDate = getCertMailRoVo.first().getAttribute("InvoiceDate") == null ? "" : getCertMailRoVo.first().getAttribute("InvoiceDate").toString();
                        //                              String payTyp = getCertMailRoVo.first().getAttribute("PaymentTypeDisp") == null ? "" : getCertMailRoVo.first().getAttribute("PaymentTypeDisp").toString();
                        //                              String payTrm = getCertMailRoVo.first().getAttribute("PaymentTerm") == null ? "" : getCertMailRoVo.first().getAttribute("PaymentTerm").toString();
                        //                              String cmnts = getCertMailRoVo.first().getAttribute("Comments") == null ? "" : getCertMailRoVo.first().getAttribute("Comments").toString();
                        //                              //System.out.println("Mail Flow to approver : "+to);
                        //                              JSFUtils.addFacesInformationMessage("Mail Flow to approver : "+to);
                        //                              String htmlBody= MailTemplates.updatedAprvlMail(contNum,certNum,certAmtWthOutVat,TaxAmt,certAmtWthVat,supName,projNum,projName,totlContValue,curncy,payDueDate,note,aprvr,buyer,
                        //                                                   c_cum,r_cum,a_cum,m_cum,n_cum,
                        //                                                   c_prv,r_prv,a_prv,m_prv,n_prv,
                        //                                                   c_curnt,r_curnt,a_curnt,m_curnt,n_curnt,
                        //                                                   appNo,certDate,supInvNo,supInvDate,payTyp,payTrm,cmnts);
                        //                              String subject="Certification Approval Notification";
                        //                              MailServices.sendMail(htmlBody, subject, "fusionalerts@omniyat.com", ar, "0r@cl3alert", "smtp.office365.com", "N", null);
                        //                          }
                        //                      //
                        //                    System.out.println("Mail Flow to approver : "+to);
                        JSFUtils.addFacesInformationMessage("Mail Flow to approver : " +
                                                            to);
                        String htmlBody =
                            MailTemplates.approvalTemp("Certification",
                                                       certificationHrdVO.getCurrentRow().getAttribute("CertificationNumber").toString(),
                                                       LoginUser);
                        String subject = "Certification Approval Notification";
                        MailServices.sendMail(htmlBody, subject,
                                              "fusionalerts@omniyat.com", ar,
                                              "0r@cl3alert",
                                              "smtp.office365.com", "N", null);
                    }

                    //
                    if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationBuy")) {
                        JSFUtils.addFacesInformationMessage("Buy Certification Approved Successfully");
                        pageRedirect = "save";
                    } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationSell")) {
                        JSFUtils.addFacesInformationMessage("Sell Certification Approved Successfully");
                        pageRedirect = "save";
                    }
                } else {
                    JSFUtils.addFacesErrorMessage("Approval Process Failed. Error:" +
                                                  flag);
                    pageRedirect = null;
                }

            } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell") ||
                       ADFContext.getCurrent().getSessionScope().get("page").equals("certificationSell") ||
                       ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
                // sell
                String func_id =
                    certificationHrdVO.getCurrentRow().getAttribute("FuncId") ==
                    null ? "" :
                    certificationHrdVO.getCurrentRow().getAttribute("FuncId").toString();
                String ref_id =
                    certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId") ==
                    null ? "" :
                    certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId").toString();
                String level_no =
                    certificationHrdVO.getCurrentRow().getAttribute("FlowLevel") ==
                    null ? "" :
                    certificationHrdVO.getCurrentRow().getAttribute("FlowLevel").toString();
                String appr_id =
                    certificationHrdVO.getCurrentRow().getAttribute("FlowWith") ==
                    null ? "" :
                    certificationHrdVO.getCurrentRow().getAttribute("FlowWith").toString();
                String user_grp =
                    certificationHrdVO.getCurrentRow().getAttribute("UserGrpId") ==
                    null ? "" :
                    certificationHrdVO.getCurrentRow().getAttribute("UserGrpId").toString();

                String flag =
                    ADFApproval.invokeResponsePkg(responsePkg, func_id,
                                                  user_grp, ref_id, level_no,
                                                  appr_id, apprDesc, "A",
                                                  fwd_to, tableName,
                                                  app_status_column,
                                                  pk_column);
                if (flag.equalsIgnoreCase("Success")) {
                    //mail
                    String flowWith =
                        ADFContext.getCurrent().getSessionScope().get("flow_with") ==
                        null ? "0" :
                        ADFContext.getCurrent().getSessionScope().get("flow_with").toString();
                    ViewObject ApproveMailVO =
                        ADFUtils.findIterator("XxscHeadDetailROVO1Iterator").getViewObject();
                    ApproveMailVO.setNamedWhereClauseParam("BV_USER_ID",
                                                           flowWith);
                    ApproveMailVO.executeQuery();
                    if (ApproveMailVO.getEstimatedRowCount() != 0) {
                        String to =
                            ApproveMailVO.first().getAttribute("Email") ==
                            null ? "prasenjit.d@4iapps.com" :
                            ApproveMailVO.first().getAttribute("Email").toString();
                        String LoginUser =
                            ADFContext.getCurrent().getSessionScope().get("userName") ==
                            null ? "0" :
                            ADFContext.getCurrent().getSessionScope().get("userName").toString();
                        //                    String to1 = "manikandan.v@4iapps.com";
                        //                    String to2 = "prasenjit.d@4iapps.com";
                        ArrayList<String> ar = new ArrayList();
                        ar.add(to);
                        //                    ar.add(to1);
                        //                    ar.add(to2);

                        String htmlBody =
                            MailTemplates.submit("Certification", certificationHrdVO.getCurrentRow().getAttribute("CertificationNumber").toString(),
                                                 LoginUser);
                        String subject = "Certification Approval Notification";
                        MailServices.sendMail(htmlBody, subject,
                                              "prismalerts@omniyat.com", ar,
                                              "Or@cl3alert",
                                              "smtp.office365.com", "N", null);
                    }
                    //
                    if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationBuy")) {
                        JSFUtils.addFacesInformationMessage("Buy Certification Approved Successfully");
                        pageRedirect = "save";
                    } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationSell")) {
                        JSFUtils.addFacesInformationMessage("Sell Certification Approved Successfully");
                        pageRedirect = "save";
                    }
                } else {
                    JSFUtils.addFacesErrorMessage("Approval Process Failed. Error:" +
                                                  flag);
                    pageRedirect = null;
                }

            }

        } else {
            JSFUtils.addFacesErrorMessage("Please Enter Approve Reason");
            pageRedirect = null;
        }

        return pageRedirect;
    }

    public String onClickReject() throws SQLException {
        String pageRedirect = null;
        if (rejectValue.getValue() != null) {

            if (ADFContext.getCurrent().getSessionScope().get("page").equals("buy") ||
                ADFContext.getCurrent().getSessionScope().get("page").equals("certificationBuy") ||
                ADFContext.getCurrent().getSessionScope().get("page").equals("applicationBuy")) {
                String func_id =
                    certificationHrdVO.getCurrentRow().getAttribute("FuncId") ==
                    null ? "" :
                    certificationHrdVO.getCurrentRow().getAttribute("FuncId").toString();
                String ref_id =
                    certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId") ==
                    null ? "" :
                    certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId").toString();
                String level_no =
                    certificationHrdVO.getCurrentRow().getAttribute("FlowLevel") ==
                    null ? "" :
                    certificationHrdVO.getCurrentRow().getAttribute("FlowLevel").toString();
                String appr_id =
                    certificationHrdVO.getCurrentRow().getAttribute("FlowWith") ==
                    null ? "" :
                    certificationHrdVO.getCurrentRow().getAttribute("FlowWith").toString();
                String user_grp =
                    certificationHrdVO.getCurrentRow().getAttribute("UserGrpId") ==
                    null ? "" :
                    certificationHrdVO.getCurrentRow().getAttribute("UserGrpId").toString();
                String flag =
                    ADFApproval.invokeResponsePkg(responsePkg, func_id,
                                                  user_grp, ref_id, level_no,
                                                  appr_id,
                                                  rejectValue.getValue().toString(),
                                                  "R", fwd_to, tableName,
                                                  app_status_column,
                                                  pk_column);
                if (flag.equalsIgnoreCase("Success")) {
                    //
                    ArrayList<String> ar = new ArrayList();
                    ViewObject getMailIdRej =
                        ADFUtils.findIterator("getApprovalHsty_ROVO1Iterator1").getViewObject();
                    ViewCriteria vwc = getMailIdRej.createViewCriteria();
                    ViewCriteriaRow vwcr = vwc.createViewCriteriaRow();
                    vwcr.setAttribute("FuncId", func_id);
                    vwcr.setAttribute("FuncRefId", ref_id);
                    vwc.addRow(vwcr);
                    getMailIdRej.applyViewCriteria(vwc);
                    getMailIdRej.executeQuery();
                    if (getMailIdRej.getEstimatedRowCount() > 0) {
                        RowSetIterator rs =
                            getMailIdRej.createRowSetIterator(null);
                        while (rs.hasNext()) {
                            Row rw = rs.next();
                            String emailId =
                                rw.getAttribute("EmailId") == null ? "" :
                                rw.getAttribute("EmailId").toString();
                            if (!emailId.equals("")) {
                                ar.add(emailId);
                            }
                        }
                        getMailIdRej.closeRowSetIterator();
                        //                    String to="fusion.support@omniyat.com";
                        String to1 = "prasenjit.d@4iapps.com";
                        //                    ar.add(to);
                        ar.add(to1);
                        String LoginUser =
                            ADFContext.getCurrent().getSessionScope().get("userName") ==
                            null ? "0" :
                            ADFContext.getCurrent().getSessionScope().get("userName").toString();
                        String htmlBody =
                            MailTemplates.rejectionTemp("Certification",
                                                        certificationHrdVO.getCurrentRow().getAttribute("CertificationNumber").toString(),
                                                        LoginUser);
                        String subject =
                            "Certification Rejection Notification";
                        MailServices.sendMail(htmlBody, subject,
                                              "fusionalerts@omniyat.com", ar,
                                              "0r@cl3alert",
                                              "smtp.office365.com", "N", null);
                    }
                    //
                    if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationBuy")) {
                        JSFUtils.addFacesErrorMessage("Buy Certification Rejected");
                        pageRedirect = "save";
                    } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationSell")) {
                        JSFUtils.addFacesErrorMessage("Sell Certification Rejected");
                        pageRedirect = "save";
                    }
                } else {
                    JSFUtils.addFacesErrorMessage("Rejection Process Failed. Error:" +
                                                  flag);
                    pageRedirect = null;
                }
            } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("sell") ||
                       ADFContext.getCurrent().getSessionScope().get("page").equals("certificationSell") ||
                       ADFContext.getCurrent().getSessionScope().get("page").equals("application")) {
                // sell Approval process
                String func_id =
                    certificationHrdVO.getCurrentRow().getAttribute("FuncId") ==
                    null ? "" :
                    certificationHrdVO.getCurrentRow().getAttribute("FuncId").toString();
                String ref_id =
                    certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId") ==
                    null ? "" :
                    certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId").toString();
                String level_no =
                    certificationHrdVO.getCurrentRow().getAttribute("FlowLevel") ==
                    null ? "" :
                    certificationHrdVO.getCurrentRow().getAttribute("FlowLevel").toString();
                String appr_id =
                    certificationHrdVO.getCurrentRow().getAttribute("FlowWith") ==
                    null ? "" :
                    certificationHrdVO.getCurrentRow().getAttribute("FlowWith").toString();
                String user_grp =
                    certificationHrdVO.getCurrentRow().getAttribute("UserGrpId") ==
                    null ? "" :
                    certificationHrdVO.getCurrentRow().getAttribute("UserGrpId").toString();
                String flag =
                    ADFApproval.invokeResponsePkg(responsePkg, func_id,
                                                  user_grp, ref_id, level_no,
                                                  appr_id,
                                                  rejectValue.getValue().toString(),
                                                  "R", fwd_to, tableName,
                                                  app_status_column,
                                                  pk_column);
                if (flag.equalsIgnoreCase("Success")) {
                    if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationBuy")) {
                        JSFUtils.addFacesErrorMessage("Buy Certification Rejected");
                        pageRedirect = "save";
                    } else if (ADFContext.getCurrent().getSessionScope().get("page").equals("certificationSell")) {
                        JSFUtils.addFacesErrorMessage("Sell Certification Rejected");
                        pageRedirect = "save";
                    }
                } else {
                    JSFUtils.addFacesErrorMessage("Rejection Process Failed. Error:" +
                                                  flag);
                    pageRedirect = null;
                }
            }


        } else {
            JSFUtils.addFacesErrorMessage("Please Enter Rejection Reason");
            pageRedirect = null;
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

    public void rejectReasonCancel(ActionEvent actionEvent) {
        this.getP3().cancel();
    }

    public void setCur_mat_on_site_rec(RichInputText cur_mat_on_site_rec) {
        this.cur_mat_on_site_rec = cur_mat_on_site_rec;
    }

    public RichInputText getCur_mat_on_site_rec() {
        return cur_mat_on_site_rec;
    }

    public void setP4(RichPopup p4) {
        this.p4 = p4;
    }

    public RichPopup getP4() {
        return p4;
    }

    public void setApproValue(RichInputText approValue) {
        this.approValue = approValue;
    }

    public RichInputText getApproValue() {
        return approValue;
    }

    public void onApproCancel(ActionEvent actionEvent) {
        // Add event code here...
    }

    public void setEcpTotAmt(RichInputText ecpTotAmt) {
        this.ecpTotAmt = ecpTotAmt;
    }

    public RichInputText getEcpTotAmt() {
        return ecpTotAmt;
    }

    public void onchangeEcpPer(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != null) {
            double contAmt =
                certificationLineVO.getCurrentRow().getAttribute("Trans_ConLine_Amount") ==
                null ? 0 :
                Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("Trans_ConLine_Amount").toString());
            double ecpPer =
                valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
            double ecpAmt = (ecpPer * contAmt / 100);
            certificationLineVO.getCurrentRow().setAttribute("EcpTotalAmount",
                                                             df.format(ecpAmt));
            AdfFacesContext.getCurrentInstance().addPartialTarget(ecpTotAmt);
        } else {
            double contAmt =
                certificationLineVO.getCurrentRow().getAttribute("Trans_ConLine_Amount") ==
                null ? 0 :
                Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("Trans_ConLine_Amount").toString());
            double ecpPer = 0;
            double ecpAmt = (ecpPer * contAmt / 100);
            certificationLineVO.getCurrentRow().setAttribute("EcpTotalAmount",
                                                             df.format(ecpAmt));
            AdfFacesContext.getCurrentInstance().addPartialTarget(ecpTotAmt);
        }
    }

    public void onClickClearData(ActionEvent actionEvent) {
        Row r = certificationLineVO.getCurrentRow();
        r.setAttribute("CumTotQty", null);
        r.setAttribute("CumPerc", null);
        r.setAttribute("CumAmount", null);
        AdfFacesContext.getCurrentInstance().addPartialTarget(t2);
    }

    public void setIf1(RichInputFile if1) {
        this.if1 = if1;
    }

    public RichInputFile getIf1() {
        return if1;
    }

    public void onChangeAttach(ValueChangeEvent valueChangeEvent) {
        //        UploadedFile uploadedFile =
        //        (UploadedFile)valueChangeEvent.getNewValue();
        //        upf.setValue(uploadedFile);
        //        AdfFacesContext.getCurrentInstance().addPartialTarget(upf);
        if (valueChangeEvent.getNewValue() != null) {
            FileAttachment.TableFileToDB((UploadedFile)valueChangeEvent.getNewValue(),
                                         attachVO);
            //             if1.setValue("");
            //             AdfFacesContext.getCurrentInstance().addPartialTarget(if1);
            //             AdfFacesContext.getCurrentInstance().addPartialTarget(t7);
        }
    }

    public void setT7(RichTable t7) {
        this.t7 = t7;
    }

    public RichTable getT7() {
        return t7;
    }

    public void downloadAttachFile(FacesContext facesContext,
                                   OutputStream outputStream) {
        try {
            FileAttachment.downloadFileListener(facesContext, outputStream,
                                                attachVO);
        } catch (Exception e) {

        }
    }

    public void downloadPoAttachFile(FacesContext facesContext,
                                     OutputStream outputStream) {
        try {
            FileAttachment.downloadFileListener(facesContext, outputStream,
                                                attachPoVO);
        } catch (Exception e) {

        }
    }

    public void setProId(RichOutputText proId) {
        this.proId = proId;
    }

    public RichOutputText getProId() {
        return proId;
    }

    public void setT9(RichTable t9) {
        this.t9 = t9;
    }

    public RichTable getT9() {
        return t9;
    }

    public void setCurOth(RichOutputText curOth) {
        this.curOth = curOth;
    }

    public RichOutputText getCurOth() {
        return curOth;
    }

    public void setTotOth(RichOutputText totOth) {
        this.totOth = totOth;
    }

    public RichOutputText getTotOth() {
        return totOth;
    }

    public void setPrevOth(RichOutputText prevOth) {
        this.prevOth = prevOth;
    }

    public RichOutputText getPrevOth() {
        return prevOth;
    }

    public void setCurOtherCharge(RichOutputText curOtherCharge) {
        this.curOtherCharge = curOtherCharge;
    }

    public RichOutputText getCurOtherCharge() {
        return curOtherCharge;
    }

    public void onChangeChargeType(ValueChangeEvent valueChangeEvent) {
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        //System.err.println("New update-->" + valueChangeEvent.getNewValue());
        if (valueChangeEvent.getNewValue().toString() != "0") {
            ViewObject otherChargVO =
                ADFUtils.findIterator("XxscCertificationOthChargesVO1Iterator").getViewObject();
            //System.err.println("/*/--" +
            //                               otherChargVO.getCurrentRow().getAttribute("ChargeType").toString());
            int result =
                checkType(otherChargVO.getCurrentRow().getAttribute("ChargeType").toString());
            //System.err.println("--===>" + result);
            if (result > 1) {
                JSFUtils.addFacesErrorMessage("Charge Type is already exits");
                otherChargVO.getCurrentRow().setAttribute("ChargeType", null);
                AdfFacesContext.getCurrentInstance().addPartialTarget(t9);
            }
        }
    }

    public int checkType(String Type) {
        String s2 = Type.toString();
        int count = 0;
        try {
            ViewObject otherChargVO =
                ADFUtils.findIterator("XxscCertificationOthChargesVO1Iterator").getViewObject();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public void onClickInvoicePopUp(ActionEvent actionEvent) {
        RichPopup.PopupHints hint = new RichPopup.PopupHints();
        RichPopup pop = getInvoiceP4();
        pop.show(hint);
        String certID =
            certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId") ==
            null ? "0" :
            certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId").toString();
        invoiceVO.setNamedWhereClauseParam("BV_CERT_ID", certID);
        invoiceVO.executeQuery();
    }

    public void setInvoiceP4(RichPopup invoiceP4) {
        this.invoiceP4 = invoiceP4;
    }

    public RichPopup getInvoiceP4() {
        return invoiceP4;
    }

    public void setCur_Adv_Rec_Perc(RichInputText cur_Adv_Rec_Perc) {
        this.cur_Adv_Rec_Perc = cur_Adv_Rec_Perc;
    }

    public RichInputText getCur_Adv_Rec_Perc() {
        return cur_Adv_Rec_Perc;
    }

    public void setCurAdvRec(RichInputText curAdvRec) {
        this.curAdvRec = curAdvRec;
    }

    public RichInputText getCurAdvRec() {
        return curAdvRec;
    }

    public void setCurReten(RichInputText curReten) {
        this.curReten = curReten;
    }

    public RichInputText getCurReten() {
        return curReten;
    }

    public void onClickManualApprove(ActionEvent actionEvent) {
        ViewObject vo =
            ADFUtils.findIterator("XxscCertificationHeadersVO1Iterator").getViewObject();
        Row r = vo.getCurrentRow();
        r.setAttribute("ApprovalStatus", "APR");
        r.setAttribute("InvStatus", "READY_TO_AP");
        r.setAttribute("InvError", "");

        r.setAttribute("Attribute1", "Data Migration");
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.aprstatus);
        ADFUtils.findOperation("Commit").execute();
    }

    public void onClickManualApproveonly(ActionEvent actionEvent) {
        ViewObject vo =
            ADFUtils.findIterator("XxscCertificationHeadersVO1Iterator").getViewObject();
        ViewObject pavo =
            ADFUtils.findIterator("XxscPayApplHeadersVO1Iterator").getViewObject();
        Row r = vo.getCurrentRow();
        r.setAttribute("ApprovalStatus", "APR");
        r.setAttribute("Attribute1", "Data Migration");
        //        ApplHeaderId
        Row[] row =
            pavo.getFilteredRows("ApplHeaderId", r.getAttribute("ApplHeaderId"));
        if (row.length > 0) {
            row[0].setAttribute("AppStatus", "Y");
        }

        ADFUtils.findOperation("Commit").execute();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.aprstatus);

    }


    public void setAprstatus(RichSelectOneChoice aprstatus) {
        this.aprstatus = aprstatus;
    }

    public RichSelectOneChoice getAprstatus() {
        return aprstatus;
    }

    public void doAprvlMailTesting(ActionEvent actionEvent) {
        // Add event code here...
        String ref_id =
            certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId") ==
            null ? "0" :
            certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId").toString();
        ArrayList<String> ar = new ArrayList();
        ar.add("prasenjit.d@4iapps.com");
        ar.add("midhun.madhav@4iapps.com");
        ViewObject getCertMailRoVo =
            ADFUtils.findIterator("CertContAppDtlsAprvMail_RoVo1Iterator").getViewObject();
        ViewCriteria vwc = getCertMailRoVo.createViewCriteria();
        ViewCriteriaRow vwcr = vwc.createViewCriteriaRow();
        vwcr.setAttribute("CertHeaderId", ref_id);
        vwc.addRow(vwcr);
        getCertMailRoVo.applyViewCriteria(vwc);
        getCertMailRoVo.executeQuery();
        if (getCertMailRoVo.getEstimatedRowCount() > 0) {

            String contNum =
                getCertMailRoVo.first().getAttribute("ContractNum") == null ?
                "0" :
                getCertMailRoVo.first().getAttribute("ContractNum").toString();
            String certNum =
                getCertMailRoVo.first().getAttribute("CertificationNumber") ==
                null ? "0" :
                getCertMailRoVo.first().getAttribute("CertificationNumber").toString();
            String certAmtWthOutVat =
                getCertMailRoVo.first().getAttribute("CurCertification") ==
                null ? "0" :
                getCertMailRoVo.first().getAttribute("CurCertification").toString();
            String TaxAmt =
                getCertMailRoVo.first().getAttribute("TaxAmt") == null ? "0" :
                getCertMailRoVo.first().getAttribute("TaxAmt").toString();
            String certAmtWthVat =
                getCertMailRoVo.first().getAttribute("CurCertWithtax") ==
                null ? "0" :
                getCertMailRoVo.first().getAttribute("CurCertWithtax").toString();
            String supName =
                getCertMailRoVo.first().getAttribute("VendorName") == null ?
                "" :
                getCertMailRoVo.first().getAttribute("VendorName").toString();
            String projNum =
                getCertMailRoVo.first().getAttribute("ProjectNumber") == null ?
                "" :
                getCertMailRoVo.first().getAttribute("ProjectNumber").toString();
            String projName =
                getCertMailRoVo.first().getAttribute("ProjectName") == null ?
                "" :
                getCertMailRoVo.first().getAttribute("ProjectName").toString();
            String totlContValue =
                getCertMailRoVo.first().getAttribute("TotalContractSum") ==
                null ? "0" :
                getCertMailRoVo.first().getAttribute("TotalContractSum").toString();
            String curncy =
                getCertMailRoVo.first().getAttribute("CurrencyCode") == null ?
                "" :
                getCertMailRoVo.first().getAttribute("CurrencyCode").toString();
            String payDueDate =
                getCertMailRoVo.first().getAttribute("PaymentDueDate") ==
                null ? "" :
                getCertMailRoVo.first().getAttribute("PaymentDueDate").toString();
            String note =
                getCertMailRoVo.first().getAttribute("NoteToSupplier") ==
                null ? "" :
                getCertMailRoVo.first().getAttribute("NoteToSupplier").toString();
            String aprvr =
                getCertMailRoVo.first().getAttribute("Approver") == null ? "" :
                getCertMailRoVo.first().getAttribute("Approver").toString();
            String buyer =
                getCertMailRoVo.first().getAttribute("Buyer") == null ? "" :
                getCertMailRoVo.first().getAttribute("Buyer").toString();
            //cumulative
            String c_cum =
                getCertMailRoVo.first().getAttribute("TotalContractSum") ==
                null ? "0" :
                getCertMailRoVo.first().getAttribute("TotalContractSum").toString();
            String r_cum =
                getCertMailRoVo.first().getAttribute("TotalRet") == null ?
                "0" :
                getCertMailRoVo.first().getAttribute("TotalRet").toString();
            String a_cum =
                getCertMailRoVo.first().getAttribute("TotalAdvAmount") ==
                null ? "0" :
                getCertMailRoVo.first().getAttribute("TotalAdvAmount").toString();
            String m_cum =
                getCertMailRoVo.first().getAttribute("TotlMtrlAmt") == null ?
                "0" :
                getCertMailRoVo.first().getAttribute("TotlMtrlAmt").toString();
            String n_cum =
                getCertMailRoVo.first().getAttribute("NetCummAmt") == null ?
                "0" :
                getCertMailRoVo.first().getAttribute("NetCummAmt").toString();
            //previous
            String c_prv =
                getCertMailRoVo.first().getAttribute("PrevApplication") ==
                null ? "0" :
                getCertMailRoVo.first().getAttribute("PrevApplication").toString();
            String r_prv =
                getCertMailRoVo.first().getAttribute("PrevRet") == null ? "0" :
                getCertMailRoVo.first().getAttribute("PrevRet").toString();
            String a_prv =
                getCertMailRoVo.first().getAttribute("PrevAdvRec") == null ?
                "0" :
                getCertMailRoVo.first().getAttribute("PrevAdvRec").toString();
            String m_prv =
                getCertMailRoVo.first().getAttribute("PrevMatAdvAmt") == null ?
                "0" :
                getCertMailRoVo.first().getAttribute("PrevMatAdvAmt").toString();
            String n_prv =
                getCertMailRoVo.first().getAttribute("NetPrevAmt") == null ?
                "0" :
                getCertMailRoVo.first().getAttribute("NetPrevAmt").toString();
            //current
            String c_curnt =
                getCertMailRoVo.first().getAttribute("CurPayAmount") == null ?
                "0" :
                getCertMailRoVo.first().getAttribute("CurPayAmount").toString();
            String r_curnt =
                getCertMailRoVo.first().getAttribute("CurRet") == null ? "0" :
                getCertMailRoVo.first().getAttribute("CurRet").toString();
            String a_curnt =
                getCertMailRoVo.first().getAttribute("CurAdvRec") == null ?
                "0" :
                getCertMailRoVo.first().getAttribute("CurAdvRec").toString();
            String m_curnt =
                getCertMailRoVo.first().getAttribute("CurMatAdvRec") == null ?
                "0" :
                getCertMailRoVo.first().getAttribute("CurMatAdvRec").toString();
            String n_curnt =
                getCertMailRoVo.first().getAttribute("NetCurntAmt") == null ?
                "0" :
                getCertMailRoVo.first().getAttribute("NetCurntAmt").toString();
            //balance
            //                              String c_blnc = getCertMailRoVo.first().getAttribute("BalContAmt") == null ? "0" : getCertMailRoVo.first().getAttribute("BalContAmt").toString();
            //                              String r_blnc = getCertMailRoVo.first().getAttribute("BalanceRet") == null ? "0" : getCertMailRoVo.first().getAttribute("BalanceRet").toString();
            //                              String a_blnc = getCertMailRoVo.first().getAttribute("BalanceAdvRec") == null ? "0" : getCertMailRoVo.first().getAttribute("BalanceAdvRec").toString();
            //                              String m_blnc = getCertMailRoVo.first().getAttribute("BlncMtrlAmt") == null ? "0" : getCertMailRoVo.first().getAttribute("BlncMtrlAmt").toString();
            //                              String n_blnc = getCertMailRoVo.first().getAttribute("NetBlncAmt") == null ? "0" : getCertMailRoVo.first().getAttribute("NetBlncAmt").toString();

            String appNo =
                getCertMailRoVo.first().getAttribute("ApplicationNumber") ==
                null ? "0" :
                getCertMailRoVo.first().getAttribute("ApplicationNumber").toString();
            String certDate =
                getCertMailRoVo.first().getAttribute("CertificationDate") ==
                null ? "" :
                getCertMailRoVo.first().getAttribute("CertificationDate").toString();
            String supInvNo =
                getCertMailRoVo.first().getAttribute("InvoiceNum") == null ?
                "" :
                getCertMailRoVo.first().getAttribute("InvoiceNum").toString();
            String supInvDate =
                getCertMailRoVo.first().getAttribute("InvoiceDate") == null ?
                "" :
                getCertMailRoVo.first().getAttribute("InvoiceDate").toString();
            String payTyp =
                getCertMailRoVo.first().getAttribute("PaymentTypeDisp") ==
                null ? "" :
                getCertMailRoVo.first().getAttribute("PaymentTypeDisp").toString();
            String payTrm =
                getCertMailRoVo.first().getAttribute("PaymentTerm") == null ?
                "" :
                getCertMailRoVo.first().getAttribute("PaymentTerm").toString();
            String cmnts =
                getCertMailRoVo.first().getAttribute("Comments") == null ? "" :
                getCertMailRoVo.first().getAttribute("Comments").toString();
            String htmlBody =
                MailTemplates.updatedAprvlMail(contNum, certNum, certAmtWthOutVat,
                                               TaxAmt, certAmtWthVat, supName,
                                               projNum, projName,
                                               totlContValue, curncy,
                                               payDueDate, note, aprvr, buyer,
                                               c_cum, r_cum, a_cum, m_cum,
                                               n_cum, c_prv, r_prv, a_prv,
                                               m_prv, n_prv, c_curnt, r_curnt,
                                               a_curnt, m_curnt, n_curnt,
                                               appNo, certDate, supInvNo,
                                               supInvDate, payTyp, payTrm,
                                               cmnts);
            String subject = "Certification submitted for Approval";
            //            MailServices.sendNotification("dineshkumar.p@4iapps.com,arunachalam.t@4iapps.com,sundarrajan.v@4iapps.com,mahalingam.m@4iapps.com", fromMail, null, htmlBody, subject);
            //ADFApproval.submitMailPkg(LoginUser, to,"Certification",certificationHrdVO.getCurrentRow().getAttribute("CertificationNumber").toString(),LoginUser);
            MailServices.sendMail(htmlBody, subject,
                                  "fusionalerts@omniyat.com", ar,
                                  "0r@cl3alert", "smtp.office365.com", "N",
                                  null);
        }
    }

    public void doCallPcsAprv(ActionEvent actionEvent) {
        // Add event code here...
    }

    public void doCallPcsRjct(ActionEvent actionEvent) {
        // Add event code here...
    }
    //po attchment download link

    public String getPoSaasAtchPdf() {

        String resultPdf = "";
        String urlLink = null;
        ViewObject getPoSaasAtchRoVo =
            ADFUtils.findIterator("XxstgPoSaasAttach_RoVo1Iterator").getViewObject();
        String contHdrId =
            certificationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
            null ? "0" :
            certificationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
        String atchDocsId =
            getPoSaasAtchRoVo.getCurrentRow().getAttribute("AttachedDocumentId") ==
            null ? "0" :
            getPoSaasAtchRoVo.getCurrentRow().getAttribute("AttachedDocumentId").toString();

        ViewObject getPoSaasAtchRoVo1 =
            ADFUtils.findIterator("XxstgPoSaasAttach_RoVo1Iterator1").getViewObject();
        ViewCriteria vwc = getPoSaasAtchRoVo1.createViewCriteria();
        ViewCriteriaRow vwcr = vwc.createViewCriteriaRow();
        vwcr.setAttribute("ContHeaderId", contHdrId);
        vwcr.setAttribute("AttachedDocumentId", atchDocsId);
        vwc.addRow(vwcr);
        getPoSaasAtchRoVo1.applyViewCriteria(vwc);
        getPoSaasAtchRoVo1.executeQuery();
        if (getPoSaasAtchRoVo1.getEstimatedRowCount() > 0) {
            urlLink =
                    getPoSaasAtchRoVo1.first().getAttribute("Url") == null ? "0" :
                    getPoSaasAtchRoVo1.first().getAttribute("Url").toString();
            System.out.println("urlLink :" + urlLink);
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.url);
        resultPdf = urlLink;

        return resultPdf;
    }

    //po attchment dirct download link

    public String getPoSaasAtchDirctPdf() {

        String resultPdf = "";
        String urlLink = null;
        ViewObject getPoSaasAtchRoVo =
            ADFUtils.findIterator("XxstgPoSaasAttach_RoVo1Iterator").getViewObject();
        String contHdrId =
            certificationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
            null ? "0" :
            certificationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
        String atchDocsId =
            getPoSaasAtchRoVo.getCurrentRow().getAttribute("AttachedDocumentId") ==
            null ? "0" :
            getPoSaasAtchRoVo.getCurrentRow().getAttribute("AttachedDocumentId").toString();
        //
        try {
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("text/xml");
            Request request =
                new Request.Builder().url("https://jcs.omniyat.com/woServices/webresources/procurement/po?poHdrId=" +
                                          contHdrId + "&atchDocId=" +
                                          atchDocsId + "").build();
            Response response = client.newCall(request).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //
        ViewObject getPoSaasAtchRoVo1 =
            ADFUtils.findIterator("XxstgPoSaasAttach_RoVo1Iterator1").getViewObject();
        ViewCriteria vwc = getPoSaasAtchRoVo1.createViewCriteria();
        ViewCriteriaRow vwcr = vwc.createViewCriteriaRow();
        vwcr.setAttribute("ContHeaderId", contHdrId);
        vwcr.setAttribute("AttachedDocumentId", atchDocsId);
        vwc.addRow(vwcr);
        getPoSaasAtchRoVo1.applyViewCriteria(vwc);
        getPoSaasAtchRoVo1.executeQuery();
        System.out.println("Check count :" +
                           getPoSaasAtchRoVo1.getEstimatedRowCount());
        if (getPoSaasAtchRoVo1.getEstimatedRowCount() > 0) {
            urlLink =
                    getPoSaasAtchRoVo1.first().getAttribute("Url") == null ? "0" :
                    getPoSaasAtchRoVo1.first().getAttribute("Url").toString();
        }
        System.out.println("Line 1 : contHdrId : " + contHdrId +
                           " atchDocsId%%" + atchDocsId + " url :" + urlLink);


        resultPdf = urlLink;

        return resultPdf;
    }

    public void setUrl(RichOutputText url) {
        this.url = url;
    }

    public RichOutputText getUrl() {
        return url;
    }

    public void doExecuteDownld(ActionEvent actionEvent) {
        ViewObject getPoSaasAtchRoVo =
            ADFUtils.findIterator("XxstgPoSaasAttach_RoVo1Iterator").getViewObject();
        String contHdrId =
            certificationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
            null ? "0" :
            certificationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
        String atchDocsId =
            getPoSaasAtchRoVo.getCurrentRow().getAttribute("AttachedDocumentId") ==
            null ? "0" :
            getPoSaasAtchRoVo.getCurrentRow().getAttribute("AttachedDocumentId").toString();
        String u =
            "https://jcs.omniyat.com/woServices/webresources/procurement/po?poHdrId=" +
            contHdrId + "&atchDocId=" + atchDocsId + "";
        System.out.println("url check :" + u);
        //
        try {
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("text/xml");
            Request request =
                new Request.Builder().url("https://jcs.omniyat.com/woServices/webresources/procurement/po?poHdrId=" +
                                          contHdrId + "&atchDocId=" +
                                          atchDocsId + "").build();
            Response response = client.newCall(request).execute();
            JSFUtils.addFacesErrorMessage("Response :" + response);
        } catch (Exception e) {
            JSFUtils.addFacesErrorMessage("Under Catch :" + e);
            e.printStackTrace();
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.cil7);
    }

    public void setCil7(RichCommandImageLink cil7) {
        this.cil7 = cil7;
    }

    public RichCommandImageLink getCil7() {
        return cil7;
    }

    public void onClickSaveBtn(ActionEvent actionEvent) throws SQLException {
        String page = null;
        String maxContVrsn = null;
        String contHdrId =
            certificationHrdVO.getCurrentRow().getAttribute("ContHeaderId") ==
            null ? "0" :
            certificationHrdVO.getCurrentRow().getAttribute("ContHeaderId").toString();
        String appHdrId =
            certificationHrdVO.getCurrentRow().getAttribute("ApplHeaderId") ==
            null ? "0" :
            certificationHrdVO.getCurrentRow().getAttribute("ApplHeaderId").toString();
        String certVrsn =
            certificationHrdVO.getCurrentRow().getAttribute("Version") ==
            null ? "0" :
            certificationHrdVO.getCurrentRow().getAttribute("Version").toString();
        ViewObject getMaxContVrsnRoVo =
            ADFUtils.findIterator("Xxsc_AppHdrContHdrVersn_RoVo1Iterator").getViewObject();
        ViewCriteria vwc = getMaxContVrsnRoVo.createViewCriteria();
        ViewCriteriaRow vwcr = vwc.createViewCriteriaRow();
        vwcr.setAttribute("ContHeaderId", contHdrId);
        vwcr.setAttribute("ApplHeaderId", appHdrId);
        vwc.addRow(vwcr);
        getMaxContVrsnRoVo.applyViewCriteria(vwc);
        getMaxContVrsnRoVo.executeQuery();
        if (getMaxContVrsnRoVo.getEstimatedRowCount() > 0) {
            maxContVrsn =
                    getMaxContVrsnRoVo.first().getAttribute("MaxContVersion") ==
                    null ? "0" :
                    getMaxContVrsnRoVo.first().getAttribute("MaxContVersion").toString();
        }
        if (!certVrsn.equals(maxContVrsn)) {
            JSFUtils.addFacesErrorMessage("Kindly Check a new contract version is amended !!!");
        } else {
            //getFunctionId();
            page = onClickSave();
            //System.err.println("Redirect page" + page);
            refreshCertificationTable();
        }
    }

    public void gettingTokenValue(ActionEvent actionEvent) {
        // Add event code here...
        ViewObject certificationAccessTokenROVO =
            ADFUtils.findIterator("certificationtokenaccessrovo1Iterator").getViewObject();
        String username =
            certificationAccessTokenROVO.first().getAttribute("UserName").toString();
        // ==null?"test":certificationAccessTokenROVO.getCurrentRow().getAttribute("UserName").toString();
        String password =
            certificationAccessTokenROVO.first().getAttribute("PassWord").toString();
        String varProcessDefId =
            certificationAccessTokenROVO.first().getAttribute("Attribute1").toString();
        //==null?"test":certificationAccessTokenROVO.getCurrentRow().getAttribute("PassWord").toString();
        String certinterfacetoken =
            certificationAccessTokenROVO.first().getAttribute("AuthenticationToken").toString();
        //==null?"test":certificationAccessTokenROVO.getCurrentRow().getAttribute("AuthenticationToken").toString();
        System.err.println("user name" + username);
        System.err.println("Password" + password);
        System.err.println("token" + certinterfacetoken);
        System.err.println("varProcessDefId" + varProcessDefId);

        System.err.println("createdby" +
                           certificationHrdVO.getCurrentRow().getAttribute("CreatedBy").toString());

        System.err.println("lastUpdateby" +
                           certificationHrdVO.getCurrentRow().getAttribute("LastUpdatedBy").toString());

        ViewObject certificationManInsVO =
            ADFUtils.findIterator("CertNumberManualInsertROVO1Iterator").getViewObject();
        //        certificationManInsVO.first().getAttribute("Num").toString();
        int certnum =
            Integer.parseInt(certificationManInsVO.first().getAttribute("Num").toString()) +
            1;
        JSFUtils.addFacesErrorMessage("Num details" +
                                      certificationManInsVO.first().getAttribute("Num").toString());
        JSFUtils.addFacesErrorMessage("certnumNum details" + certnum);


        //        JSFUtils.addFacesErrorMessage("Username and password and token details"+certinterfacetoken+username+password);

    }

    public void onClickPCAmendment(ActionEvent actionEvent) {
        String flag = "E";
        String errorMessage = null;
        try {
            String headerID =
                certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId") ==
                null ? "0" :
                certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId").toString();
            ApplicationModuleImpl am =
                (ApplicationModuleImpl)ADFUtils.getApplicationModuleForDataControl(null);

            dobProcArgs =
                    new Object[][] { { "IN", headerID, OracleTypes.NUMBER },
                                     { "OUT",

                            flag, OracleTypes.VARCHAR }, //1
                        { "OUT", errorMessage, OracleTypes.VARCHAR } }; //2
            DBUtils.callDBStoredProcedure(am.getDBTransaction(),
                                          "call xxsc_Cert_interface_pkg.cert_amendment(?,?,?)",
                                          dobProcArgs);
            flag = (String)dobProcArgs[1][1];
            errorMessage = (String)dobProcArgs[2][1];
            JSFUtils.addFacesInformationMessage("Certificate amended successfully");

        } catch (SQLException e) {
            System.err.println("==exe==" + e.toString());
        }

    }


    public void onClickPCDelete(ActionEvent actionEvent) {
        String flag = "E";
        String errorMessage = null;
        try {
            oracle.jbo.domain.Number headerID =
                new oracle.jbo.domain.Number(certificationHrdVO.getCurrentRow().getAttribute("CertHeaderId").toString());
            ApplicationModuleImpl am =
                (ApplicationModuleImpl)ADFUtils.getApplicationModuleForDataControl(null);

            dobProcArgs =
                    new Object[][] { { "IN", headerID, OracleTypes.NUMBER },
                                     { "OUT",

                            flag, OracleTypes.VARCHAR }, //1
                        { "OUT", errorMessage, OracleTypes.VARCHAR } }; //2
            DBUtils.callDBStoredProcedure(am.getDBTransaction(),
                                          "call XXSC_CERT_INTERFACE_PKG.cert_draft_delete(?,?,?)",
                                          dobProcArgs);
            flag = (String)dobProcArgs[1][1];
            errorMessage = (String)dobProcArgs[2][1];
            //            System.err.println("==Flag==" + flag);
            //            System.err.println("==errorMessage==" + errorMessage);

            JSFUtils.addFacesInformationMessage("Certificate deleted successfully");


        } catch (SQLException e) {
            System.err.println("==exe==" + e.toString());
        }

    }


    public void onClickCurAdvRecAmount(ValueChangeEvent valueChangeEvent) {
        double old_value =
            valueChangeEvent.getOldValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getOldValue().toString());
        double new_value =
            valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
        if (old_value != new_value) {
            if (valueChangeEvent.getNewValue() != null) {
                valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
                double currentAmt =
                    certificationLineVO.getCurrentRow().getAttribute("CurrAmount") ==
                    null ? 0 :
                    Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("CurrAmount").toString());
                double cur_adv_rec_amount =
                    certificationLineVO.getCurrentRow().getAttribute("CurAdvRecAmount") ==
                    null ? 0 :
                    Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("CurAdvRecAmount").toString());
                double cur_ret_rec_amount =
                    certificationLineVO.getCurrentRow().getAttribute("CurRetRecAmount") ==
                    null ? 0 :
                    Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("CurRetRecAmount").toString());
                double taxRate =
                    certificationLineVO.getCurrentRow().getAttribute("TaxRate") ==
                    null ? 0 :
                    Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("TaxRate").toString());
                /**
                * tax_amount 01-09-2023 added as requested by arun
                */
                double final_tax_amount =
                    currentAmt - cur_adv_rec_amount - cur_ret_rec_amount;

                double taxAmt = (final_tax_amount * taxRate) / 100;
                certificationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                 new BigDecimal(df.format(taxAmt)));


                AdfFacesContext.getCurrentInstance().addPartialTarget(certCurrTaxAmt);
            }
        }
    }

    public void onClickRetRecAmount(ValueChangeEvent valueChangeEvent) {
        double old_value =
            valueChangeEvent.getOldValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getOldValue().toString());
        double new_value =
            valueChangeEvent.getNewValue() == null ? 0 : Double.parseDouble(valueChangeEvent.getNewValue().toString());
        if (old_value != new_value) {
            if (valueChangeEvent.getNewValue() != null) {
                valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
                double currentAmt =
                    certificationLineVO.getCurrentRow().getAttribute("CurrAmount") ==
                    null ? 0 :
                    Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("CurrAmount").toString());
                double cur_adv_rec_amount =
                    certificationLineVO.getCurrentRow().getAttribute("CurAdvRecAmount") ==
                    null ? 0 :
                    Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("CurAdvRecAmount").toString());
                double cur_ret_rec_amount =
                    certificationLineVO.getCurrentRow().getAttribute("CurRetRecAmount") ==
                    null ? 0 :
                    Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("CurRetRecAmount").toString());
                double taxRate =
                    certificationLineVO.getCurrentRow().getAttribute("TaxRate") ==
                    null ? 0 :
                    Double.parseDouble(certificationLineVO.getCurrentRow().getAttribute("TaxRate").toString());
                /**
                * tax_amount 01-09-2023 added as requested by arun
                */
                double final_tax_amount =
                    currentAmt - cur_adv_rec_amount - cur_ret_rec_amount;

                double taxAmt = (final_tax_amount * taxRate) / 100;
                certificationLineVO.getCurrentRow().setAttribute("TaxAmount",
                                                                 new BigDecimal(df.format(taxAmt)));


                AdfFacesContext.getCurrentInstance().addPartialTarget(certCurrTaxAmt);
            }
        }
    }

    public void onClickDeleteCancelPopup(ActionEvent actionEvent) {
        // Add event code here...
        certificationDeletePopup.cancel();
    }


    public void setCertificationDeletePopup(RichPopup certificationDeletePopup) {
        this.certificationDeletePopup = certificationDeletePopup;
    }

    public RichPopup getCertificationDeletePopup() {
        return certificationDeletePopup;
    }

    public void setCur_retrec_amount(RichInputText cur_retrec_amount) {
        this.cur_retrec_amount = cur_retrec_amount;
    }

    public RichInputText getCur_retrec_amount() {
        return cur_retrec_amount;
    }
}

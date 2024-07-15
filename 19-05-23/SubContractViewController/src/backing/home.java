package backing;


import Utils.JSFUtils;

import com.oschrenk.io.Base64;

import java.io.OutputStream;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.fragment.RichRegion;
import oracle.adf.view.rich.component.rich.layout.RichDecorativeBox;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichGridRow;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import javax.faces.event.ActionEvent;

import oracle.adf.controller.TaskFlowId;
import oracle.adf.share.ADFContext;

import oracle.jbo.ViewObject;


import java.io.ByteArrayOutputStream;

import java.io.OutputStream;

import java.net.HttpURLConnection;
import java.net.URL;

import java.net.URLConnection;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


import oracle.adf.view.rich.component.rich.output.RichOutputText;

import oracle.binding.OperationBinding;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.client.Configuration;

import org.json.JSONException;
import org.json.JSONObject;

public class home {
    private RichCommandButton cb1;
    private RichGridCell gc2;
    private RichGridCell gc1;
    private RichGridRow gr1;
    private RichPanelGridLayout pgl1;
    private RichPanelGroupLayout pgl2;
    private RichRegion r1;
    private RichDecorativeBox db1;
    private RichForm f1;
    private RichDocument d1;
    private RichPanelGroupLayout pgl3;
    private RichOutputText ot1;
    private RichOutputText outputText1;

    public home() {
    }

    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
    }

    public RichCommandButton getCb1() {
        return cb1;
    }

    public void setGc2(RichGridCell gc2) {
        this.gc2 = gc2;
    }

    public RichGridCell getGc2() {
        return gc2;
    }

    public void setGc1(RichGridCell gc1) {
        this.gc1 = gc1;
    }

    public RichGridCell getGc1() {
        return gc1;
    }

    public void setGr1(RichGridRow gr1) {
        this.gr1 = gr1;
    }

    public RichGridRow getGr1() {
        return gr1;
    }

    public void setPgl1(RichPanelGridLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGridLayout getPgl1() {
        return pgl1;
    }

    public void setPgl2(RichPanelGroupLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGroupLayout getPgl2() {
        return pgl2;
    }

    public void setR1(RichRegion r1) {
        this.r1 = r1;
    }

    public RichRegion getR1() {
        return r1;
    }

    public void setDb1(RichDecorativeBox db1) {
        this.db1 = db1;
    }

    public RichDecorativeBox getDb1() {
        return db1;
    }

    public void setF1(RichForm f1) {
        this.f1 = f1;
    }

    public RichForm getF1() {
        return f1;
    }

    public void setD1(RichDocument d1) {
        this.d1 = d1;
    }

    public RichDocument getD1() {
        return d1;
    }
    /********CRP 2******
     * Model-Date Sources need to change
     * Home.Java--Test User/Production User
     * Contract-Edit option only and auto approval
     * Application- Submit Button is off (Auto Approval)
     * 
    **/
    public String checkUser() throws JSONException {
        String outputString = "";
    //  For Test
//        ADFContext.getCurrent().getSessionScope().put("userName","peter.stephenson@omniyat.com");
//         ADFContext.getCurrent().getSessionScope().put("userName","Projects");
//        //code to be included here for data restriction.
//        outputString = "validUser";
//        ADFContext.getCurrent().getPageFlowScope().put("val","validUser");
        
    
        // ominiyat cloud test
        //String Id="300000001550311";
//        String Id="300000001550311";
//        ADFContext.getCurrent().getSessionScope().put("loginUserID",Id);
         
//*/
//For Prod
///**********
        
//        String jwt1="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsIng1dCI6IkM1YmxlNTJRU2Etd1htZjB0XzBXUkNxTHY1QSIsImtpZCI6InRydXN0c2VydmljZSJ9.eyJleHAiOjE2MzkxMTkyMDMsInN1YiI6IlBSSVNNQE9tbml5YXQuY29tIiwiaXNzIjoid3d3Lm9yYWNsZS5jb20iLCJwcm4iOiJQUklTTUBPbW5peWF0LmNvbSIsImlhdCI6MTYzOTEwNDgwM30.aujrUHgW1ij_pv-Pe3u4cudsusp2QmlnYfAta73M3GAvLUZ5og-Ljkixma5cJGY1_rPXejmskNLkbij6HTaRHaPsmTSjt49MRmtUganCnWow0iEDscSqV5vbYFfhi6zdQN5DJtI1wA-lRrJhax7beOL2CwEU6glod_xmaTDBE0siNHVxG5WbI2AOQMt_FWZCvJN6TrgW-mqJgxrVwvKnZQ3_-Sgx9d-eBd6jDhce-VOOO-73dredFMSEfIQbOsf8AqhK9Mqv9dtPKVqO1eVhTyD_pRZhOVwAngNuxm0rdGP3_lPTy5PIW7kp1cBh96OhkXT2ZpG-CZWg6gHoMEhsLA"; // paste the toekn in string  and run homeBTF ok ok
        //user - piyumantha.rathnayake@omniyat.com
//        String jwt1="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsIng1dCI6IkM1YmxlNTJRU2Etd1htZjB0XzBXUkNxTHY1QSIsImtpZCI6InRydXN0c2VydmljZSJ9.eyJleHAiOjE2Mzc2ODgyOTcsInN1YiI6IlByb2plY3RzIiwiaXNzIjoid3d3Lm9yYWNsZS5jb20iLCJwcm4iOiJQcm9qZWN0cyIsImlhdCI6MTYzNzY3Mzg5N30.NGyZnrBGUbp4IS2ddVwzvWGIm-FhkVHv0AyMRun3Ys1HnLdwQVAs10oPxIHSW-IfCH4G2NHFNLa9A_RCpamfTJ0gKOX-JWAOHvh-fL7W8v-uQhhHamhlxHHx71iC0qbEt-LwibV5RlEXmMMsFnRXoFyaAlfIZfnk_7Zr_iqSRGFCPfp1J24cd-K8gni32VUSyRaPdW1GtoI8gi9acfyoDeTajIVU8xkDzmYAeyGLtPiKSp38TzwIhktTUBWS8JihxAY74xEBRxGmnlNvsyOgiKJVlLrzxj2GOqf6OHj3E9x3EHhX0bUlYYufW6vAjBIYOh_6bdAIo1rgihBKwm_F7w"; // paste the toekn in string  and run homeBTF ok ok
       //Prism user
       String jwt1="eyJ4NXQiOiJDNWJsZTUyUVNhLXdYbWYwdF8wV1JDcUx2NUEiLCJraWQiOiJ0cnVzdHNlcnZpY2UiLCJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJQUklTTUBPbW5peWF0LmNvbSIsImlzcyI6Ind3dy5vcmFjbGUuY29tIiwiZXhwIjoxNzA2NzEwNDE5LCJwcm4iOiJQUklTTUBPbW5peWF0LmNvbSIsImlhdCI6MTcwNjY5NjAxOX0.LGP7YEPdjbb4JS0UOQSi9bp_mEiVj4v9fUec1q4HE0DyqxlxQRDO30SROr5oHpLO1ELQYi2o4rej8tEF5g5alI3-inHMsSnZWamhJ6rTXQ2S-KSibwlvuIN37Rym5oHajsUqc1HWj7JLFMQUvCSAD1FY5EY9NLz059Wvdz1UtNGhdvn66LuQw90XG8PyICieHRU5SxQBJak59W1V2lcLu7s0P5r6qBS1Keal-PoBw53JCYV1lW7SB8jYaeSueUy2nVFAdyzbBEeRe3HEtDj9DDBc_tmDnG9meqMjx79dI_EGJLnGzNTVdM4NWhh_md0_sLeHq5BXeoA42NmQsuO6sg";
        ADFContext.getCurrent().getPageFlowScope().put("tokens", jwt1);
        String inputEncodedText =ADFContext.getCurrent().getPageFlowScope().get("tokens").toString();
//         System.err.println("JWT tokens:=====>>> "+ADFContext.getCurrent().getPageFlowScope().get("tokens").toString());
          URL url;
          URLConnection connection;
          HttpURLConnection httpConn;
        
//          String jwt =
//              ADFContext.getCurrent().getPageFlowScope().get("tokens").toString();
//          System.err.println("JWT---- " + jwt);
      
          try {
         /* -- URL Issue
              // Sobha
//              String wsURL ="https://eexr.hcm.em3.oraclecloud.com/hcmPeopleRolesV2/UserDetailsService?WSDL";
             // Sobha Test
              String wsURL ="https://eexr-test.hcm.em3.oraclecloud.com/hcmPeopleRolesV2/UserDetailsService?WSDL";
//              String wsURL ="https://eexr-test.hcm.em3.oraclecloud.com/hcmPeopleRolesV2/UserDetailsService?WSDL";
             
             // NSCC 
//             String wsURL ="https://egpt-test.hcm.em3.oraclecloud.com/hcmPeopleRolesV2/UserDetailsService?WSDL";
             
              url = new URL(wsURL);
              connection = url.openConnection();
              httpConn = (HttpURLConnection)connection;
              ByteArrayOutputStream bout = new ByteArrayOutputStream();
              String xmlInput =
                  "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/types/\">\n" +
                  "   <soapenv:Header/>\n" +
                  "   <soapenv:Body>\n" +
                  "      <typ:findSelfUserDetails/>\n" +
                  "   </soapenv:Body>\n" +
                  "</soapenv:Envelope>";

              byte[] buffer = new byte[xmlInput.length()];
              buffer = xmlInput.getBytes();
              bout.write(buffer);
              byte[] b = bout.toByteArray();
              httpConn.setRequestProperty("Content-Type",
                                          "text/xml; charset=utf-8");
              httpConn.setRequestProperty("SOAPAction", "");
              httpConn.setRequestProperty("Authorization", "Bearer " + inputEncodedText);
              httpConn.setRequestMethod("POST");
              httpConn.setDoOutput(true);
              httpConn.setDoInput(true);
              httpConn.setAllowUserInteraction(true);
              OutputStream out = httpConn.getOutputStream();
              out.write(b);
              out.close();
              httpConn.connect();
              if (httpConn.getResponseCode() == 200) {
                  outputString = "validUser";
                  ADFContext.getCurrent().getPageFlowScope().put("val","validUser"); 
                  
              } else {
                  outputString = "Invalid";
                  ADFContext.getCurrent().getPageFlowScope().put("val","Invalid");
              }
              
              if (outputString.equalsIgnoreCase("validUser")) {
        
        -- URL Issue*/
                  
                  String[] xIn = inputEncodedText.split("\\.");
                  byte c[] = Base64.decode(xIn[1]);
                  String tempPass = new String(c);
                  int chkOccurance = tempPass.lastIndexOf("}");
                  if (chkOccurance < 1) {
                    tempPass += "}";
                  }
                  JSONObject jo = new JSONObject(tempPass);
          /*  -- URL Issue     
                  long millis = System.currentTimeMillis();
                  long iatVal = Long.parseLong(jo.get("iat").toString()) * 1000;
                  long expVal = Long.parseLong(jo.get("exp").toString()) * 1000;
                  if (millis >= iatVal && millis <= expVal) {
     -- URL Issue */
                    ADFContext.getCurrent().getSessionScope().put("userName", jo.getString("prn"));
                    JSFUtils.addFacesErrorMessage(jo.getString("prn").toString());
              System.err.println("=="+jo.getString("prn").toString());
                    //code to be included here for data restriction.
                    outputString = "validUser";
                    ADFContext.getCurrent().getPageFlowScope().put("val","validUser"); 
          /* -- URL Issue
                  }
                    else {
                       outputString = "Invalid";
                       ADFContext.getCurrent().getPageFlowScope().put("val","Invalid");
                       }
                }
                     else {
                                       outputString = "Invalid";
                                       ADFContext.getCurrent().getPageFlowScope().put("val","Invalid");
                                   }
        -- URL Issue */
                 }catch (Exception e) {
              e.printStackTrace();
          }
//*************/  
          return outputString;
     }
  
  
  /*    public String CheckUserName() {

      String retValu = "invalid";
      String valToken = validateToken();
      if (valToken.equalsIgnoreCase("valid")) {

        try {
          String inputEncodedText =
            ADFContext.getCurrent().getPageFlowScope().get("tokens").toString();
          String[] xIn = inputEncodedText.split("\\.");
          byte b[] = Base64.decode(xIn[1]);
          String tempPass = new String(b);
          int chkOccurance = tempPass.lastIndexOf("}");
          if (chkOccurance < 1) {
            tempPass += "}";
          }
          JSONObject jo = new JSONObject(tempPass);
          long millis = System.currentTimeMillis();
          long iatVal = Long.parseLong(jo.get("iat").toString()) * 1000;
          long expVal = Long.parseLong(jo.get("exp").toString()) * 1000;
          if (millis >= iatVal && millis <= expVal) {
            ADFContext.getCurrent().getSessionScope().put("userName",
                                                          jo.getString("prn"));
            ViewObject userVo = getViewObjectOfUser();
            ViewCriteria vc = userVo.createViewCriteria();
            ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
            vcRow.setAttribute("UserName",
                               jo.get("prn").toString().toUpperCase());
            vc.addRow(vcRow);
            userVo.applyViewCriteria(vc);
            userVo.executeQuery();
            if (userVo.getEstimatedRowCount() > 0) {
              String userRole =
                userVo.first().getAttribute("RoleCode").toString();
              ADFContext.getCurrent().getSessionScope().put("userRole",
                                                            userRole);
              ADFContext.getCurrent().getSessionScope().put("userRoleId",
                                                            userVo.first().getAttribute("UserRoleId").toString());
              ADFContext.getCurrent().getSessionScope().put("navigation",
                                                            "Dashboard");
              retValu = "validUser";
            } else {
              ADFContext.getCurrent().getSessionScope().put("navigation",
                                                            "InvalidUser");
              retValu = "invalid";
            }
          } else {
            ADFContext.getCurrent().getSessionScope().put("navigation",
                                                          "InvalidUser");
            retValu = "invalid";
          }

        } catch (Exception e) {
          e.printStackTrace();
        }
      } else {
        ADFContext.getCurrent().getSessionScope().put("navigation",
                                                      "InvalidUser");
        retValu = "invalid";
      }
      return "validUser";
    }
  public String validateToken() {

      URL url;
      URLConnection connection;
      HttpURLConnection httpConn;
      String outputString = "";
      String jwt =ADFContext.getCurrent().getPageFlowScope().get("tokens").toString();
      try {
        String wsURL ="https://efnt.hcm.us6.oraclecloud.com:443/hcmPeopleRolesV2/UserDetailsService";
        url = new URL(wsURL);
        connection = url.openConnection();
        httpConn = (HttpURLConnection)connection;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        String xmlInput =
          "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/hcm/people/roles/userDetailsServiceV2/types/\">\n" +
          "   <soapenv:Header/>\n" +
          "   <soapenv:Body>\n" +
          "      <typ:findSelfUserDetails/>\n" +
          "   </soapenv:Body>\n" +
          "</soapenv:Envelope>";

        byte[] buffer = new byte[xmlInput.length()];
        buffer = xmlInput.getBytes();
        bout.write(buffer);
        byte[] b = bout.toByteArray();
        httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        httpConn.setRequestProperty("SOAPAction", "");
        httpConn.setRequestProperty("Authorization", "Bearer " + jwt);
        httpConn.setRequestMethod("POST");
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);
        httpConn.setAllowUserInteraction(true);
        OutputStream out = httpConn.getOutputStream();
        out.write(b);
        out.close();
        httpConn.connect();
        if (httpConn.getResponseCode() == 200) {
          outputString = "Valid";
        } else {
          outputString = "Invalid";
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      return outputString;
    }*/
    
    
    
    
    
    
    
    
  public void refreshCertificationScreen(){
      ADFContext.getCurrent().getSessionScope().put("page", "certificationBuy");
      ADFContext.getCurrent().getSessionScope().put("intent", "B");
      ADFContext.getCurrent().getSessionScope().put("pageNavigation", "certification");

      ADFContext.getCurrent().getSessionScope().put("taskId", "/WEB-INF/oracle/apps/uikit/TaskFlow/contractSearchBTF.xml#contractSearchBTF");

  }


    public void setPgl3(RichPanelGroupLayout pgl3) {
        this.pgl3 = pgl3;
    }

    public RichPanelGroupLayout getPgl3() {
        return pgl3;
    }

    public void setOt1(RichOutputText ot1) {
        this.ot1 = ot1;
    }

    public RichOutputText getOt1() {
        return ot1;
    }

    public void setOutputText1(RichOutputText outputText1) {
        this.outputText1 = outputText1;
    }

    public RichOutputText getOutputText1() {
        return outputText1;
    }
}

package Utils;

public class MailTemplates {
    
   
    /**********************double quotes convert into single quotes*****************************************/

        public static String quotesReplace(String htmldata){
                String out=htmldata.replace( "\"",  "'");
                //StringBuilder builder = new StringBuilder("<html> <body>");
                //builder.append(out);
                //builder.append("</body> </html>");
                //System.err.println("----HTML BODY value---"+builder.toString());    
                //return builder.toString();
//                System.out.println("---Quotes Replace Output-----: "+out);
                return out;
                }
  
  /***************************************************************************************************/
   
    
    public static String requestMailContent(){
        
        String Msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" + 
        "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns=\"http://www.w3.org/1999/xhtml\">\n" + 
        "<head>\n" + 
        "	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" + 
        "	<meta name=\"viewport\" content=\"width=device-width\" />\n" + 
        "	\n" + 
        "<style>body {\n" + 
        "width: 100% !important; min-width: 100%; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; margin: 0; padding: 0;\n" + 
        "}\n" + 
        "img {\n" + 
        "outline: none; text-decoration: none; -ms-interpolation-mode: bicubic; width: auto; float: left; clear: both; display: block;\n" + 
        "}\n" + 
        "body {\n" + 
        "color: #222222; font-family: \"Helvetica\", \"Arial\", sans-serif; font-weight: normal; padding: 0; margin: 0; text-align: left; line-height: 1.3;\n" + 
        "}\n" + 
        "body {\n" + 
        "font-size: 14px; line-height: 19px;\n" + 
        "}\n" + 
        "a:hover {\n" + 
        "color: #2795b6 !important;\n" + 
        "}\n" + 
        "a:active {\n" + 
        "color: #2795b6 !important;\n" + 
        "}\n" + 
        "a:visited {\n" + 
        "color: #2ba6cb !important;\n" + 
        "}\n" + 
        "body {\n" + 
        "font-family: 'Open Sans', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: none;\n" + 
        "}\n" + 
        "a:hover {\n" + 
        "color: #ff8f2b !important;\n" + 
        "}\n" + 
        "a:active {\n" + 
        "color: #F2821E !important;\n" + 
        "}\n" + 
        "a:visited {\n" + 
        "color: #E67612 !important;\n" + 
        "}\n" + 
        ".better-button:hover a {\n" + 
        "color: #FFFFFF !important; background-color: #F2821E; border: 1px solid #F2821E;\n" + 
        "}\n" + 
        ".better-button:visited a {\n" + 
        "color: #FFFFFF !important;\n" + 
        "}\n" + 
        ".better-button:active a {\n" + 
        "color: #FFFFFF !important;\n" + 
        "}\n" + 
        ".better-button-alt:hover a {\n" + 
        "color: #ff8f2b !important; background-color: #DDDDDD; border: 1px solid #F2821E;\n" + 
        "}\n" + 
        ".better-button-alt:visited a {\n" + 
        "color: #ff8f2b !important;\n" + 
        "}\n" + 
        ".better-button-alt:active a {\n" + 
        "color: #ff8f2b !important;\n" + 
        "}\n" + 
        "body {\n" + 
        "height: 100% !important; width: 100% !important;\n" + 
        "}\n" + 
        "body .copy {\n" + 
        "-ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%;\n" + 
        "}\n" + 
        ".ExternalClass {\n" + 
        "width: 100%;\n" + 
        "}\n" + 
        ".ExternalClass {\n" + 
        "line-height: 100%;\n" + 
        "}\n" + 
        "img {\n" + 
        "-ms-interpolation-mode: bicubic;\n" + 
        "}\n" + 
        "img {\n" + 
        "border: 0 !important; outline: none !important; text-decoration: none !important;\n" + 
        "}\n" + 
        "a:hover {\n" + 
        "text-decoration: underline;\n" + 
        "}\n" + 
        "@media only screen and (max-width: 600px) {\n" + 
        "  table[class=\"body\"] center {\n" + 
        "    min-width: 0 !important;\n" + 
        "  }\n" + 
        "  table[class=\"body\"] .container {\n" + 
        "    width: 95% !important;\n" + 
        "  }\n" + 
        "  table[class=\"body\"] .row {\n" + 
        "    width: 100% !important; display: block !important;\n" + 
        "  }\n" + 
        "  table[class=\"body\"] .wrapper {\n" + 
        "    display: block !important; padding-right: 0 !important;\n" + 
        "  }\n" + 
        "  table[class=\"body\"] .columns {\n" + 
        "    table-layout: fixed !important; float: none !important; width: 100% !important; padding-right: 0px !important; padding-left: 0px !important; display: block !important;\n" + 
        "  }\n" + 
        "  table[class=\"body\"] table.columns td {\n" + 
        "    width: 100% !important;\n" + 
        "  }\n" + 
        "  table[class=\"body\"] .columns td.six {\n" + 
        "    width: 50% !important;\n" + 
        "  }\n" + 
        "  table[class=\"body\"] .columns td.twelve {\n" + 
        "    width: 100% !important;\n" + 
        "  }\n" + 
        "  table[class=\"body\"] table.columns td.expander {\n" + 
        "    width: 1px !important;\n" + 
        "  }\n" + 
        "  .logo {\n" + 
        "    margin-left: 10px;\n" + 
        "  }\n" + 
        "}\n" + 
        "@media (max-width: 600px) {\n" + 
        "  table[class=\"email-container\"] {\n" + 
        "    width: 95% !important;\n" + 
        "  }\n" + 
        "  img[class=\"fluid\"] {\n" + 
        "    width: 100% !important; max-width: 100% !important; height: auto !important; margin: auto !important;\n" + 
        "  }\n" + 
        "  img[class=\"fluid-centered\"] {\n" + 
        "    width: 100% !important; max-width: 100% !important; height: auto !important; margin: auto !important;\n" + 
        "  }\n" + 
        "  img[class=\"fluid-centered\"] {\n" + 
        "    margin: auto !important;\n" + 
        "  }\n" + 
        "  td[class=\"comms-content\"] {\n" + 
        "    padding: 20px !important;\n" + 
        "  }\n" + 
        "  td[class=\"stack-column\"] {\n" + 
        "    display: block !important; width: 100% !important; direction: ltr !important;\n" + 
        "  }\n" + 
        "  td[class=\"stack-column-center\"] {\n" + 
        "    display: block !important; width: 100% !important; direction: ltr !important;\n" + 
        "  }\n" + 
        "  td[class=\"stack-column-center\"] {\n" + 
        "    text-align: center !important;\n" + 
        "  }\n" + 
        "  td[class=\"copy\"] {\n" + 
        "    font-size: 14px !important; line-height: 24px !important; padding: 0 30px !important;\n" + 
        "  }\n" + 
        "  td[class=\"copy -center\"] {\n" + 
        "    font-size: 14px !important; line-height: 24px !important; padding: 0 30px !important;\n" + 
        "  }\n" + 
        "  td[class=\"copy -bold\"] {\n" + 
        "    font-size: 14px !important; line-height: 24px !important; padding: 0 30px !important;\n" + 
        "  }\n" + 
        "  td[class=\"small-text\"] {\n" + 
        "    font-size: 14px !important; line-height: 24px !important; padding: 0 30px !important;\n" + 
        "  }\n" + 
        "  td[class=\"mini-centered-text\"] {\n" + 
        "    font-size: 14px !important; line-height: 24px !important; padding: 15px 30px !important;\n" + 
        "  }\n" + 
        "  td[class=\"copy -padd\"] {\n" + 
        "    padding: 0 40px !important;\n" + 
        "  }\n" + 
        "  span[class=\"sep\"] {\n" + 
        "    display: none !important;\n" + 
        "  }\n" + 
        "  td[class=\"mb-hide\"] {\n" + 
        "    display: none !important; height: 0 !important;\n" + 
        "  }\n" + 
        "  td[class=\"spacer mb-shorten\"] {\n" + 
        "    height: 25px !important;\n" + 
        "  }\n" + 
        "  .two-up td {\n" + 
        "    width: 270px;\n" + 
        "  }\n" + 
        "}\n" + 
        "</style></head>\n" + 
        "<body leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\" class=\"main\" style=\"height: 100% !important; width: 100% !important; min-width: 100%; -webkit-text-size-adjust: none; -ms-text-size-adjust: 100%; color: #222222; font-family: 'Open Sans', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-weight: normal; text-align: left; line-height: 19px; font-size: 14px; -webkit-font-smoothing: antialiased; margin: 0 auto; padding: 0;\" bgcolor=\"#2e2e2e\">\n" + 
        "\n" + 
        "	<table class=\"body\" style=\"border-spacing: 0; border-collapse: collapse; vertical-align: top; text-align: left; height: 100%; width: 100%; color: #222222; font-family: 'Open Sans', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-weight: normal; line-height: 19px; font-size: 14px; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: none; margin: 0; padding: 0;\" bgcolor=\"#2e2e2e\">\n" + 
        "		<tr style=\"vertical-align: top; padding: 0;\" align=\"left\">\n" + 
        "			<td class=\"center\" align=\"center\" valign=\"top\" style=\"word-break: break-word; -webkit-hyphens: auto; -moz-hyphens: auto; hyphens: auto; border-collapse: collapse !important; color: #222222; font-family: 'Open Sans', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-weight: normal; line-height: 19px; font-size: 14px; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: none; margin: 0; padding: 0;\">\n" + 
        "        <center style=\"width: 100%; min-width: 580px;\">\n" + 
        "					<table class=\"row header\" style=\"border-spacing: 0; border-collapse: collapse; vertical-align: top; text-align: left; width: 100%; position: relative; margin-top: 25px; margin-bottom: 25px; padding: 0px;\">\n" + 
        "						<tr style=\"vertical-align: top; padding: 0;\" align=\"left\">\n" + 
        "						  <td class=\"center\" align=\"center\" style=\"word-break: break-word; -webkit-hyphens: auto; -moz-hyphens: auto; hyphens: auto; border-collapse: collapse !important; color: #222222; font-family: 'Open Sans', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-weight: normal; line-height: 19px; font-size: 14px; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: none; margin: 0; padding: 0;\" valign=\"top\">\n" + 
        "						    <center style=\"width: 100%; min-width: 580px;\">\n" + 
        "\n" + 
        "						      <table class=\"container\" style=\"border-spacing: 0; border-collapse: collapse; vertical-align: top; text-align: inherit; width: 580px; margin: 0 auto; padding: 0;\">\n" + 
        "						        <tr style=\"vertical-align: top; padding: 0;\" align=\"left\">\n" + 
        "						          <td class=\"wrapper last\" style=\"word-break: break-word; -webkit-hyphens: auto; -moz-hyphens: auto; hyphens: auto; border-collapse: collapse !important; position: relative; color: #222222; font-family: 'Open Sans', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-weight: normal; line-height: 19px; font-size: 14px; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: none; margin: 0; padding: 10px 0px 0px;\" align=\"left\" valign=\"top\">\n" + 
        "\n" + 
        "						            <table class=\"twelve columns\" style=\"border-spacing: 0; border-collapse: collapse; vertical-align: top; text-align: left; width: 580px; margin: 0 auto; padding: 0;\">\n" + 
        "						              <tr style=\"vertical-align: top; padding: 0;\" align=\"left\">\n" + 
        "						                <td class=\"twelve sub-columns center\" style=\"word-break: break-word; -webkit-hyphens: auto; -moz-hyphens: auto; hyphens: auto; border-collapse: collapse !important; min-width: 0px; width: 100%; color: #222222; font-family: 'Open Sans', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-weight: normal; line-height: 19px; font-size: 14px; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: none; margin: 0; padding: 0px 10px 10px 0px;\" align=\"center\" valign=\"top\">\n" + 
        "                              <img class=\"logo\" src=\"https://seeklogo.com/images/S/sobha-developers-logo-A13E8BA5BA-seeklogo.com.png\" style=\"width: 100px; padding: 0px 0px 0px 240px;\"/>\n" + 
        "                            </td>\n" + 
        "                            <td class=\"expander\" style=\"word-break: break-word; -webkit-hyphens: auto; -moz-hyphens: auto; hyphens: auto; border-collapse: collapse !important; visibility: hidden; width: 0px; color: #222222; font-family: 'Open Sans', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-weight: normal; line-height: 19px; font-size: 14px; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: none; margin: 0; padding: 0;\" align=\"left\" valign=\"top\"></td>\n" + 
        "                          </tr>\n" + 
        "						            </table>\n" + 
        "\n" + 
        "						          </td>\n" + 
        "						        </tr>\n" + 
        "						      </table>\n" + 
        "\n" + 
        "						    </center>\n" + 
        "						  </td>\n" + 
        "						</tr>\n" + 
        "					</table>\n" + 
        "					\n" + 
        "<!--Title-->\n" + 
        "\n" + 
        "<table class=\"container\" style=\"border-spacing: 0; border-collapse: collapse; vertical-align: top; text-align: inherit; width: 580px; margin: 0 auto; padding: 0;\" width=\"600\" bgcolor=\"#efefef\">\n" + 
        "						<tr style=\"vertical-align: top; padding: 0;\" align=\"left\">\n" + 
        "							<td height=\"2\" class=\"spacer mb-shorten\" style=\"font-size: 0; line-height: 0; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-image: linear-gradient(to right, #ffed00 0%, #f26529 75%); height: 2px !important; word-break: break-word; -webkit-hyphens: auto; -moz-hyphens: auto; hyphens: auto; border-collapse: collapse !important; color: #222222; font-family: 'Open Sans', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-weight: normal; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: none; margin: 0; padding: 0; border: 0;\" valign=\"top\" align=\"left\"> </td>\n" + 
        "						</tr>\n" + 
        "						<tr style=\"vertical-align: top; padding: 0;\" align=\"left\">\n" + 
        "							<td class=\"mini-centered-text\" style=\"color: #343b41; mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word; -webkit-hyphens: auto; -moz-hyphens: auto; hyphens: auto; border-collapse: collapse !important; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: none; margin: 0; padding: 25px 35px; font: 400 16px/27px 'Helvetica Neue', Helvetica, Arial, sans-serif;\" align=\"center\" valign=\"top\">\n" + 
        "								<span style=\"color:rgb(44,48,94); font-size:24px; line-height:28px\"><strong>Contract</strong></span>\n" + 
        "\n" + 
        "<!-----Message----------->\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" + 
        "<tbody>\n" + 
        "<tr style=\"vertical-align:top\">\n" + 
        "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:10px; padding-right:10px; padding-bottom:0px; padding-left:10px\">\n" + 
        "<div style=\"color: rgb(85, 85, 85); line-height: 120%; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont;\">\n" + 
        "<div style=\"font-size: 12px; line-height: 14px; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont; color: rgb(85, 85, 85); text-align: left;\">\n" + 
        "<p style=\"margin:0; font-size:14px; line-height:17px; text-align:justify\"><span style=\"font-size:24px; line-height:28px\"><strong><span style=\"line-height:28px; font-size:24px\"><span style=\"color:rgb(44,48,94); font-size:24px; line-height:28px\">Hey</span>,<span style=\"color:rgb(51,51,51); font-size:24px; line-height:28px\"><br/><br/><span style=\"font-size:20px; line-height:28px\">Contract Number 'CONT-001'&nbsp is Submitted for approval.</span></span></span></strong></span></p>\n" + 
        "</div>\n" + 
        "</div>\n" + 
        "</td>\n" + 
        "</tr>\n" + 
        "</tbody>\n" + 
        "</table>\n" + 
        "\n" + 
        "<!-----Dot Line----------->\n" + 
        "<table align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" + 
        "<tbody>\n" + 
        "<tr style=\"vertical-align:top\">\n" + 
        "<td align=\"center\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:10px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" + 
        "<div style=\"height:1px\">\n" + 
        "<table align=\"center\" border=\"0\" cellspacing=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; border-top:1px solid #bbbbbb; width:100%\">\n" + 
        "<tbody>\n" + 
        "<tr style=\"vertical-align:top\">\n" + 
        "<td align=\"center\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" + 
        "</td>\n" + 
        "</tr>\n" + 
        "</tbody>\n" + 
        "</table>\n" + 
        "</div>\n" + 
        "</td>\n" + 
        "</tr>\n" + 
        "</tbody>\n" + 
        "</table>\n" + 
        "\n" + 
        "\n" + 
        "\n" + 
        "<!-----Message Description----------->\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" + 
        "<tbody>\n" + 
        "<tr style=\"vertical-align:top\">\n" + 
        "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:10px\">\n" + 
        "<div style=\"color: rgb(119, 119, 119); line-height: 120%; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont;\">\n" + 
        "<div style=\"font-size: 12px; line-height: 14px; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont; color: rgb(119, 119, 119); text-align: left;\">\n" + 
        "<p style=\"margin:0; font-size:14px; line-height:17px; text-align:justify\"><span style=\"font-size:12px; line-height:14px; color:rgb(51,51,51)\"><span style=\"font-size:12px; line-height:14px\"><span style=\"font-size:14px; line-height:14px\"><strong style=\"color:rgb(255,102,0)\">'ABC SalesPerson' </strong> has placed an 'Contract' with Contract Number CONT-001 is Submitted for approval.<br>\n" + 
        "<br>\n" + 
        "Thank you!<br>\n" + 
        "<span class=\"x_m_-6366644067162443722contextualExtensionHighlight x_m_-6366644067162443722ms-font-color-themePrimary x_m_-6366644067162443722ms-border-color-themePrimary x_m_-6366644067162443722ident_999_1058\">Good day!</span></span></span></span></p>\n" + 
        "</div>\n" + 
        "</div>\n" + 
        "</td>\n" + 
        "</tr>\n" + 
        "</tbody>\n" + 
        "</table>\n" + 
        "\n" + 
        "\n" + 
        "\n" + 
        "<!-----Dot Line----------->\n" + 
        "\n" + 
        "<table align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" + 
        "<tbody>\n" + 
        "<tr style=\"vertical-align:top\">\n" + 
        "<td align=\"center\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:10px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" + 
        "<div style=\"height:1px\">\n" + 
        "<table align=\"center\" border=\"0\" cellspacing=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; border-top:1px solid #bbbbbb; width:100%\">\n" + 
        "<tbody>\n" + 
        "<tr style=\"vertical-align:top\">\n" + 
        "<td align=\"center\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" + 
        "</td>\n" + 
        "</tr>\n" + 
        "</tbody>\n" + 
        "</table>\n" + 
        "</div>\n" + 
        "</td>\n" + 
        "</tr>\n" + 
        "</tbody>\n" + 
        "</table>\n" + 
        "\n" + 
        "\n" + 
        "<!-----Details Information----------->\n" + 
        "\n" + 
        "\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" + 
        "<tbody>\n" + 
        "<tr style=\"vertical-align:top\">\n" + 
        "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:15px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" + 
        "<div style=\"line-height: 120%; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont;\">\n" + 
        "<div style=\"font-size: 12px; line-height: 14px; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont; text-align: left;\">\n" + 
        "<table style=\"border-collapse:collapse; border-spacing:0\">\n" + 
        "<tbody>\n" + 
        "<tr>\n" + 
        "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#666; overflow:hidden; word-break:normal; vertical-align:top\">\n" + 
        "<span class=\"x_m_-6366644067162443722contextualExtensionHighlight x_m_-6366644067162443722ms-font-color-themePrimary x_m_-6366644067162443722ms-border-color-themePrimary x_m_-6366644067162443722ident_999_1058\">'Contract'</span></td>\n" + 
        "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#ff6600; font-weight:bold; overflow:hidden; word-break:normal; vertical-align:top\">\n" + 
        "<span class=\"x_m_-6366644067162443722contextualExtensionHighlight x_m_-6366644067162443722ms-font-color-themePrimary x_m_-6366644067162443722ms-border-color-themePrimary x_m_-6366644067162443722ident_999_1058\">'CONT-001'</span></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#666; overflow:hidden; word-break:normal; vertical-align:top\">\n" + 
        "<span class=\"x_m_-6366644067162443722contextualExtensionHighlight x_m_-6366644067162443722ms-font-color-themePrimary x_m_-6366644067162443722ms-border-color-themePrimary x_m_-6366644067162443722ident_999_1058\">Status</span></td>\n" + 
        "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#ff6600; font-weight:bold; overflow:hidden; word-break:normal; vertical-align:top\">\n" + 
        "<span class=\"x_m_-6366644067162443722contextualExtensionHighlight x_m_-6366644067162443722ms-font-color-themePrimary x_m_-6366644067162443722ms-border-color-themePrimary x_m_-6366644067162443722ident_999_1058\">Submitted for Approval</span></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#666; overflow:hidden; word-break:normal; vertical-align:top\">\n" + 
        "<span class=\"x_m_-6366644067162443722contextualExtensionHighlight x_m_-6366644067162443722ms-font-color-themePrimary x_m_-6366644067162443722ms-border-color-themePrimary x_m_-6366644067162443722ident_999_1058\">Salesperson</span></td>\n" + 
        "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#ff6600; font-weight:bold; overflow:hidden; word-break:normal; vertical-align:top\">\n" + 
        "<span class=\"x_m_-6366644067162443722contextualExtensionHighlight x_m_-6366644067162443722ms-font-color-themePrimary x_m_-6366644067162443722ms-border-color-themePrimary x_m_-6366644067162443722ident_999_1058\">'ABC SalesPerson'</span></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "</tbody>\n" + 
        "</table>\n" + 
        "</div>\n" + 
        "</div>\n" + 
        "</td>\n" + 
        "</tr>\n" + 
        "</tbody>\n" + 
        "</table>\n" + 
        "\n" + 
        "\n" + 
        "\n" + 
        "\n" + 
        "\n" + 
        "<!-----Login Button----------->\n" + 
        "\n" + 
        "\n" + 
        "\n" + 
        "<table class=\"row\" style=\"border-spacing: 0; border-collapse: collapse; vertical-align: top; text-align: left; width: 100%; position: relative; display: block; padding: 0px;\">\n" + 
        "  <tr style=\"vertical-align: top; padding: 0;\" align=\"left\">\n" + 
        "    <td class=\"wrapper last\" style=\"word-break: break-word; -webkit-hyphens: auto; -moz-hyphens: auto; hyphens: auto; border-collapse: collapse !important; position: relative; color: #222222; font-family: 'Open Sans', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-weight: normal; line-height: 19px; font-size: 14px; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: none; margin: 0; padding: 10px 0px 0px;\" align=\"left\" valign=\"top\">\n" + 
        "      <table class=\"twelve columns\" style=\"border-spacing: 0; border-collapse: collapse; vertical-align: top; text-align: left; width: 580px; margin: 0 auto; padding: 0;\">\n" + 
        "        <tr style=\"vertical-align: top; padding: 0;\" align=\"left\">\n" + 
        "          <td class=\"center six\" style=\"word-break: break-word; -webkit-hyphens: auto; -moz-hyphens: auto; hyphens: auto; border-collapse: collapse !important; width: 50%; color: #222222; font-family: 'Open Sans', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-weight: normal; line-height: 19px; font-size: 14px; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: none; margin: 0; padding: 0px 0px 10px;\" align=\"center\" valign=\"top\">\n" + 
        "            <table class=\"better-button\" align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-spacing: 0; border-collapse: collapse; vertical-align: top; text-align: left; margin-top: 10px; margin-bottom: 20px; padding: 0;\">\n" + 
        "              <tr style=\"vertical-align: top; padding: 0;\" align=\"left\">\n" + 
        "                <td align=\"center\" class=\"better-button\" bgcolor=\"#ff8f2b\" style=\"word-break: break-word; -webkit-hyphens: auto; -moz-hyphens: auto; hyphens: auto; border-collapse: collapse !important; color: #222222; font-family: 'Open Sans', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-weight: normal; line-height: 19px; font-size: 14px; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: none; -webkit-border-radius: 2px; -moz-border-radius: 2px; border-radius: 2px; margin: 0; padding: 0px;\" valign=\"top\">\n" + 
        "                  <a href=\"{{.RuleUrl}}\" target=\"_blank\" style=\"color: #FFF; text-decoration: none; -webkit-border-radius: 2px; -moz-border-radius: 2px; border-radius: 2px; display: inline-block; padding: 12px 25px; border: 1px solid #ff8f2b;\">Login</a>\n" + 
        "                </td>\n" + 
        "              </tr>\n" + 
        "            </table>\n" + 
        "            </td>\n" + 
        "        </tr>\n" + 
        "      </table>\n" + 
        "    </td>\n" + 
        "  </tr>\n" + 
        "</table>\n" + 
        "</td>\n" + 
        "</tr>\n" + 
        "</table>\n" + 
        "\n" + 
        "<!-----End----------->			\n" + 
        "					<table class=\"footer center\" style=\"border-spacing: 0; border-collapse: collapse; vertical-align: top; text-align: center; color: #999999; margin-top: 20px; padding: 0;\" bgcolor=\"#2e2e2e\">\n" + 
        "						<tr style=\"vertical-align: top; padding: 0;\" align=\"left\">\n" + 
        "							<td class=\"wrapper last\" style=\"word-break: break-word; -webkit-hyphens: auto; -moz-hyphens: auto; hyphens: auto; border-collapse: collapse !important; position: relative; color: #222222; font-family: 'Open Sans', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-weight: normal; line-height: 19px; font-size: 14px; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: none; margin: 0; padding: 10px 20px 0px 0px;\" align=\"left\" valign=\"top\">\n" + 
        "								<table class=\"twelve columns center\" style=\"border-spacing: 0; border-collapse: collapse; vertical-align: top; text-align: center; width: 580px; margin: 0 auto; padding: 0;\">\n" + 
        "									<tr style=\"vertical-align: top; padding: 0;\" align=\"left\">\n" + 
        "										<td class=\"twelve\" align=\"center\" style=\"word-break: break-word; -webkit-hyphens: auto; -moz-hyphens: auto; hyphens: auto; border-collapse: collapse !important; width: 100%; color: #222222; font-family: 'Open Sans', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-weight: normal; line-height: 19px; font-size: 14px; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: none; margin: 0; padding: 0px 0px 10px;\" valign=\"top\">\n" + 
        "											<center style=\"width: 100%; min-width: 580px;\">\n" + 
        "												<p style=\"font-size: 12px; color: #999999; font-family: 'Open Sans', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-weight: normal; line-height: 19px; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: none; margin: 0 0 10px; padding: 0;\" align=\"center\">\n" + 
        "													Sent by <a href=\"{{.AppUrl}}\" style=\"color: #E67612; text-decoration: none;\">Grafana v{{.BuildVersion}}</a>\n" + 
        "													<br />© 2016 Grafana and raintank\n" + 
        "												</p>\n" + 
        "											</center>\n" + 
        "										</td>\n" + 
        "										<td class=\"expander\" style=\"word-break: break-word; -webkit-hyphens: auto; -moz-hyphens: auto; hyphens: auto; border-collapse: collapse !important; visibility: hidden; width: 0px; color: #222222; font-family: 'Open Sans', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-weight: normal; line-height: 19px; font-size: 14px; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: none; margin: 0; padding: 0;\" align=\"left\" valign=\"top\"></td>\n" + 
        "									</tr>\n" + 
        "								</table>\n" + 
        "							</td>\n" + 
        "						</tr>\n" + 
        "					</table>\n" + 
        "				</center>\n" + 
        "			</td>\n" + 
        "		</tr>\n" + 
        "	</table>\n" + 
        "</body>\n" + 
        "</html>";
        
        String Html_Msg=quotesReplace(Msg);
        return Html_Msg;
    }
    
   /***************************************************************************************************/
    
    // Mail Tem 
    public static String submit(String nameOfNofication, String NoficationNumber, String LoginUser){
        
        String Msg= "<html>\n" +
                           "<head>\n" +
                           "<title>Page Title</title>\n" +
                           "</head>\n" +
                           "<body>\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td width=\"100%\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:#444444\">\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" class=\"x_m_-6366644067162443722x_container\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; max-width:500px; margin:0 auto; text-align:inherit\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td width=\"100%\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" bgcolor=\"transparent\" class=\"x_m_-6366644067162443722x_block-grid\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; width:100%; max-width:500px; color:#333; background-color:transparent\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:transparent; text-align:center; font-size:0\">\n" +
                           "<div class=\"x_m_-6366644067162443722x_col x_m_-6366644067162443722x_num12\" style=\"display:inline-block; vertical-align:top; width:100%\">\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:transparent; padding-top:20px; padding-right:0px; padding-bottom:20px; padding-left:0px; border-top:0px solid transparent; border-right:0px solid transparent; border-bottom:0px solid transparent; border-left:0px solid transparent\">\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody><tr style=\"vertical-align:top\">\n" +
                           "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:10px; padding-right:10px; padding-bottom:0px; padding-left:10px\">\n" +
                           "<div style=\"color: rgb(85, 85, 85); line-height: 120%; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont;\">\n" +
                           "<div style=\"font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont; font-size: 12px; line-height: 14px; color: rgb(85, 85, 85); text-align: left;\">\n" +
                           "<p style=\"margin:0; font-size:18px; line-height:22px\"><span style=\"font-size:26px; line-height:31px; color:rgb(255,255,255)\"><strong><span style=\"line-height:31px; font-size:26px\">Omniyat</span></strong></span></p>\n" +
                           "</div>\n" +
                           "</div>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:5px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" +
                           "<div style=\"color: rgb(136, 136, 136); line-height: 120%; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont;\">\n" +
                           "<div style=\"font-size: 12px; line-height: 14px; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont; color: rgb(136, 136, 136); text-align: left;\">\n" +
                           "<p style=\"margin:0; font-size:12px; line-height:14px\"><span style=\"color:rgb(153,153,153); font-size:12px; line-height:14px\">Omniyat <span class=\"x_m_-6366644067162443722highlight\" id=\"x_m_-63666440671624437220.9182669872898304\" name=\"x_searchHitInReadingPane\">Notifications</span></span></p>\n" +
                           "</div>\n" +
                           "</div>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</div>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td width=\"100%\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:#e5e5e5\">\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" class=\"x_m_-6366644067162443722x_container\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; max-width:500px; margin:0 auto; text-align:inherit\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td width=\"100%\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" bgcolor=\"transparent\" class=\"x_m_-6366644067162443722x_block-grid\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; width:100%; max-width:500px; color:#333; background-color:transparent\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:transparent; text-align:center; font-size:0\">\n" +
                           "<div class=\"x_m_-6366644067162443722x_col x_m_-6366644067162443722x_num12\" style=\"display:inline-block; vertical-align:top; width:100%\">\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:transparent; padding-top:30px; padding-right:0px; padding-bottom:30px; padding-left:0px; border-top:0px solid transparent; border-right:0px solid transparent; border-bottom:0px solid transparent; border-left:0px solid transparent\">\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:10px; padding-right:10px; padding-bottom:0px; padding-left:10px\">\n" +
                           "<div style=\"color: rgb(85, 85, 85); line-height: 120%; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont;\">\n" +
                           "<div style=\"font-size: 12px; line-height: 14px; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont; color: rgb(85, 85, 85); text-align: left;\">\n" +
                           "<p style=\"margin:0; font-size:14px; line-height:17px; text-align:justify\"><span style=\"font-size:24px; line-height:28px\"><strong><span style=\"line-height:28px; font-size:24px\"><span style=\"color:rgb(44,48,94); font-size:24px; line-height:28px\">Hey</span>,<span style=\"color:rgb(51,51,51); font-size:24px; line-height:28px\"> <span style=\"font-size:24px; line-height:28px\">"+nameOfNofication+"&nbsp"+NoficationNumber+"&nbspis Submitted for approval.</span></span></span></strong></span></p>\n" +
                           "</div>\n" +
                           "</div>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "<table align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td align=\"center\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:10px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" +
                           "<div style=\"height:1px\">\n" +
                           "<table align=\"center\" border=\"0\" cellspacing=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; border-top:1px solid #bbbbbb; width:100%\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td align=\"center\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</div>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:10px\">\n" +
                           "<div style=\"color: rgb(119, 119, 119); line-height: 120%; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont;\">\n" +
                           "<div style=\"font-size: 12px; line-height: 14px; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont; color: rgb(119, 119, 119); text-align: left;\">\n" +
                           "<p style=\"margin:0; font-size:14px; line-height:17px; text-align:justify\"><span style=\"font-size:12px; line-height:14px; color:rgb(51,51,51)\"><span style=\"font-size:12px; line-height:14px\"><span style=\"font-size:12px; line-height:14px\"><strong style=\"color:rgb(255,102,0)\">"+LoginUser+"</strong> has placed an "+nameOfNofication+" with "+nameOfNofication+" number "+NoficationNumber+" is Submitted for approval.<br>\n" +
                           "<br>\n" +
                           "Thank you!<br>\n" +
                           "<span class=\"x_m_-6366644067162443722contextualExtensionHighlight x_m_-6366644067162443722ms-font-color-themePrimary x_m_-6366644067162443722ms-border-color-themePrimary x_m_-6366644067162443722ident_999_1058\">Good day!</span></span></span></span></p>\n" +
                           "</div>\n" +
                           "</div>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "<table align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td align=\"center\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:10px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" +
                           "<div style=\"height:1px\">\n" +
                           "<table align=\"center\" border=\"0\" cellspacing=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; border-top:1px solid #bbbbbb; width:100%\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td align=\"center\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</div>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:15px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" +
                           "<div style=\"line-height: 120%; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont;\">\n" +
                           "<div style=\"font-size: 12px; line-height: 14px; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont; text-align: left;\">\n" +
                           "<table style=\"border-collapse:collapse; border-spacing:0\">\n" +
                           "<tbody>\n" +
                           "<tr>\n" +
                           "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#666; overflow:hidden; word-break:normal; vertical-align:top\">\n" +
                           "<span class=\"x_m_-6366644067162443722contextualExtensionHighlight x_m_-6366644067162443722ms-font-color-themePrimary x_m_-6366644067162443722ms-border-color-themePrimary x_m_-6366644067162443722ident_999_1058\">"+nameOfNofication+"</span></td>\n" +
                           "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#ff6600; font-weight:bold; overflow:hidden; word-break:normal; vertical-align:top\">\n" +
                           "<span class=\"x_m_-6366644067162443722contextualExtensionHighlight x_m_-6366644067162443722ms-font-color-themePrimary x_m_-6366644067162443722ms-border-color-themePrimary x_m_-6366644067162443722ident_999_1058\">"+NoficationNumber+"</span></td>\n" +
                           "</tr>\n" +
                           "<tr>\n" +
                           "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#666; overflow:hidden; word-break:normal; vertical-align:top\">\n" +
                           "<span class=\"x_m_-6366644067162443722contextualExtensionHighlight x_m_-6366644067162443722ms-font-color-themePrimary x_m_-6366644067162443722ms-border-color-themePrimary x_m_-6366644067162443722ident_999_1058\">Status</span></td>\n" +
                           "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#ff6600; font-weight:bold; overflow:hidden; word-break:normal; vertical-align:top\">\n" +
                           "<span class=\"x_m_-6366644067162443722contextualExtensionHighlight x_m_-6366644067162443722ms-font-color-themePrimary x_m_-6366644067162443722ms-border-color-themePrimary x_m_-6366644067162443722ident_999_1058\">Submitted for Approval</span></td>\n" +
                           "</tr>\n" +
                           "<tr>\n" +
                           "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#666; overflow:hidden; word-break:normal; vertical-align:top\">\n" +
                           "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#ff6600; font-weight:bold; overflow:hidden; word-break:normal; vertical-align:top\">\n" +
                           "</tr>\n" +
                           "<tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</div>\n" +
                           "</div>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "<table align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td align=\"center\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:10px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" +
                           "<div style=\"height:1px\">\n" +
                           "<table align=\"center\" border=\"0\" cellspacing=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; border-top:1px solid #bbbbbb; width:100%\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td align=\"center\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</div>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td class=\"x_m_-6366644067162443722x_button-container\" align=\"left\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:15px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" +
                           "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td width=\"100%\" class=\"x_m_-6366644067162443722x_button\" align=\"left\" valign=\"middle\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" +
                           "<div align=\"left\" style=\"display:inline-block; border-radius:5px; max-width:25%; width:100%; border-top:0px solid transparent; border-right:0px solid transparent; border-bottom:0px solid transparent; border-left:0px solid transparent\">\n" +
                           "</div>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</div>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td width=\"100%\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:#444444\">\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" class=\"x_m_-6366644067162443722x_container\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; max-width:500px; margin:0 auto; text-align:inherit\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td width=\"100%\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" bgcolor=\"transparent\" class=\"x_m_-6366644067162443722x_block-grid\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; width:100%; max-width:500px; color:#333; background-color:transparent\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:transparent; text-align:center; font-size:0\">\n" +
                           "<div class=\"x_m_-6366644067162443722x_col x_m_-6366644067162443722x_num12\" style=\"display:inline-block; vertical-align:top; width:100%\">\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:transparent; padding-top:25px; padding-right:0px; padding-bottom:25px; padding-left:0px; border-top:0px solid transparent; border-right:0px solid transparent; border-bottom:0px solid transparent; border-left:0px solid transparent\">\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:10px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" +
                           "<div style=\"color: rgb(187, 187, 187); line-height: 120%; font-family: Helvetica Neue, Helvetica, Arial, sans-serif, serif, EmojiFont;\">\n" +
                           "<div style=\"font-size: 12px; line-height: 14px; color: rgb(187, 187, 187); font-family: Helvetica Neue, Helvetica, Arial, sans-serif, serif, EmojiFont; text-align: left;\">\n" +
                           "<p style=\"margin:0; font-size:12px; line-height:14px; text-align:center\">Omniyat <span class=\"x_m_-6366644067162443722highlight\" id=\"x_m_-63666440671624437220.6246102622735843\" name=\"x_searchHitInReadingPane\">Notifications</span></p>\n" +
                           "<p style=\"margin:0; font-size:12px; line-height:14px; text-align:center\">mailto:Omniyatnotifications@Omniyat-me.com <span class=\"x_m_-6366644067162443722highlight\" id=\"x_m_-63666440671624437220.6246102622735843\" name=\"x_searchHitInReadingPane\"></span></p>\n" +
                           "</div>\n" +
                           "</div>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</div>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</body>\n" +
                           "</html>";
        String Html_Msg=quotesReplace(Msg);
        return Html_Msg;
    }
    
    /***************************************************************************************************/
     
     // Mail Tem for approve/reject
     public static String approvalTemp(String nameOfNofication, String NoficationNumber, String LoginUser){
         
         String Msg= "<html>\n" +
                            "<head>\n" +
                            "<title>Page Title</title>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                            "<tbody>\n" +
                            "<tr style=\"vertical-align:top\">\n" +
                            "<td width=\"100%\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:#444444\">\n" +
                            "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" class=\"x_m_-6366644067162443722x_container\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; max-width:500px; margin:0 auto; text-align:inherit\">\n" +
                            "<tbody>\n" +
                            "<tr style=\"vertical-align:top\">\n" +
                            "<td width=\"100%\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" +
                            "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" bgcolor=\"transparent\" class=\"x_m_-6366644067162443722x_block-grid\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; width:100%; max-width:500px; color:#333; background-color:transparent\">\n" +
                            "<tbody>\n" +
                            "<tr style=\"vertical-align:top\">\n" +
                            "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:transparent; text-align:center; font-size:0\">\n" +
                            "<div class=\"x_m_-6366644067162443722x_col x_m_-6366644067162443722x_num12\" style=\"display:inline-block; vertical-align:top; width:100%\">\n" +
                            "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                            "<tbody>\n" +
                            "<tr style=\"vertical-align:top\">\n" +
                            "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:transparent; padding-top:20px; padding-right:0px; padding-bottom:20px; padding-left:0px; border-top:0px solid transparent; border-right:0px solid transparent; border-bottom:0px solid transparent; border-left:0px solid transparent\">\n" +
                            "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                            "<tbody><tr style=\"vertical-align:top\">\n" +
                            "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:10px; padding-right:10px; padding-bottom:0px; padding-left:10px\">\n" +
                            "<div style=\"color: rgb(85, 85, 85); line-height: 120%; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont;\">\n" +
                            "<div style=\"font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont; font-size: 12px; line-height: 14px; color: rgb(85, 85, 85); text-align: left;\">\n" +
                            "<p style=\"margin:0; font-size:18px; line-height:22px\"><span style=\"font-size:26px; line-height:31px; color:rgb(255,255,255)\"><strong><span style=\"line-height:31px; font-size:26px\">Omniyat</span></strong></span></p>\n" +
                            "</div>\n" +
                            "</div>\n" +
                            "</td>\n" +
                            "</tr>\n" +
                            "</tbody>\n" +
                            "</table>\n" +
                            "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                            "<tbody>\n" +
                            "<tr style=\"vertical-align:top\">\n" +
                            "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:5px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" +
                            "<div style=\"color: rgb(136, 136, 136); line-height: 120%; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont;\">\n" +
                            "<div style=\"font-size: 12px; line-height: 14px; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont; color: rgb(136, 136, 136); text-align: left;\">\n" +
                            "<p style=\"margin:0; font-size:12px; line-height:14px\"><span style=\"color:rgb(153,153,153); font-size:12px; line-height:14px\">Omniyat <span class=\"x_m_-6366644067162443722highlight\" id=\"x_m_-63666440671624437220.9182669872898304\" name=\"x_searchHitInReadingPane\">Notifications</span></span></p>\n" +
                            "</div>\n" +
                            "</div>\n" +
                            "</td>\n" +
                            "</tr>\n" +
                            "</tbody>\n" +
                            "</table>\n" +
                            "</td>\n" +
                            "</tr>\n" +
                            "</tbody>\n" +
                            "</table>\n" +
                            "</div>\n" +
                            "</td>\n" +
                            "</tr>\n" +
                            "</tbody>\n" +
                            "</table>\n" +
                            "</td>\n" +
                            "</tr>\n" +
                            "</tbody>\n" +
                            "</table>\n" +
                            "</td>\n" +
                            "</tr>\n" +
                            "</tbody>\n" +
                            "</table>\n" +
                            "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                            "<tbody>\n" +
                            "<tr style=\"vertical-align:top\">\n" +
                            "<td width=\"100%\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:#e5e5e5\">\n" +
                            "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" class=\"x_m_-6366644067162443722x_container\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; max-width:500px; margin:0 auto; text-align:inherit\">\n" +
                            "<tbody>\n" +
                            "<tr style=\"vertical-align:top\">\n" +
                            "<td width=\"100%\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" +
                            "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" bgcolor=\"transparent\" class=\"x_m_-6366644067162443722x_block-grid\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; width:100%; max-width:500px; color:#333; background-color:transparent\">\n" +
                            "<tbody>\n" +
                            "<tr style=\"vertical-align:top\">\n" +
                            "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:transparent; text-align:center; font-size:0\">\n" +
                            "<div class=\"x_m_-6366644067162443722x_col x_m_-6366644067162443722x_num12\" style=\"display:inline-block; vertical-align:top; width:100%\">\n" +
                            "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                            "<tbody>\n" +
                            "<tr style=\"vertical-align:top\">\n" +
                            "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:transparent; padding-top:30px; padding-right:0px; padding-bottom:30px; padding-left:0px; border-top:0px solid transparent; border-right:0px solid transparent; border-bottom:0px solid transparent; border-left:0px solid transparent\">\n" +
                            "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                            "<tbody>\n" +
                            "<tr style=\"vertical-align:top\">\n" +
                            "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:10px; padding-right:10px; padding-bottom:0px; padding-left:10px\">\n" +
                            "<div style=\"color: rgb(85, 85, 85); line-height: 120%; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont;\">\n" +
                            "<div style=\"font-size: 12px; line-height: 14px; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont; color: rgb(85, 85, 85); text-align: left;\">\n" +
                            "<p style=\"margin:0; font-size:14px; line-height:17px; text-align:justify\"><span style=\"font-size:24px; line-height:28px\"><strong><span style=\"line-height:28px; font-size:24px\"><span style=\"color:rgb(44,48,94); font-size:24px; line-height:28px\">Hey</span>,<span style=\"color:rgb(51,51,51); font-size:24px; line-height:28px\"> <span style=\"font-size:24px; line-height:28px\">"+nameOfNofication+"&nbsp"+NoficationNumber+"&nbspis Sent for approval.</span></span></span></strong></span></p>\n" +
                            "</div>\n" +
                            "</div>\n" +
                            "</td>\n" +
                            "</tr>\n" +
                            "</tbody>\n" +
                            "</table>\n" +
                            "<table align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                            "<tbody>\n" +
                            "<tr style=\"vertical-align:top\">\n" +
                            "<td align=\"center\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:10px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" +
                            "<div style=\"height:1px\">\n" +
                            "<table align=\"center\" border=\"0\" cellspacing=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; border-top:1px solid #bbbbbb; width:100%\">\n" +
                            "<tbody>\n" +
                            "<tr style=\"vertical-align:top\">\n" +
                            "<td align=\"center\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" +
                            "</td>\n" +
                            "</tr>\n" +
                            "</tbody>\n" +
                            "</table>\n" +
                            "</div>\n" +
                            "</td>\n" +
                            "</tr>\n" +
                            "</tbody>\n" +
                            "</table>\n" +
                            "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                            "<tbody>\n" +
                            "<tr style=\"vertical-align:top\">\n" +
                            "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:10px\">\n" +
                            "<div style=\"color: rgb(119, 119, 119); line-height: 120%; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont;\">\n" +
                            "<div style=\"font-size: 12px; line-height: 14px; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont; color: rgb(119, 119, 119); text-align: left;\">\n" +
                            "<p style=\"margin:0; font-size:14px; line-height:17px; text-align:justify\"><span style=\"font-size:12px; line-height:14px; color:rgb(51,51,51)\"><span style=\"font-size:12px; line-height:14px\"><span style=\"font-size:12px; line-height:14px\"><strong style=\"color:rgb(255,102,0)\">"+LoginUser+"</strong> has placed an "+nameOfNofication+" with "+nameOfNofication+" number "+NoficationNumber+" is Sent for approval.<br>\n" +
                            "<br>\n" +
                            "Thank you!<br>\n" +
                            "<span class=\"x_m_-6366644067162443722contextualExtensionHighlight x_m_-6366644067162443722ms-font-color-themePrimary x_m_-6366644067162443722ms-border-color-themePrimary x_m_-6366644067162443722ident_999_1058\">Good day!</span></span></span></span></p>\n" +
                            "</div>\n" +
                            "</div>\n" +
                            "</td>\n" +
                            "</tr>\n" +
                            "</tbody>\n" +
                            "</table>\n" +
                            "<table align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                            "<tbody>\n" +
                            "<tr style=\"vertical-align:top\">\n" +
                            "<td align=\"center\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:10px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" +
                            "<div style=\"height:1px\">\n" +
                            "<table align=\"center\" border=\"0\" cellspacing=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; border-top:1px solid #bbbbbb; width:100%\">\n" +
                            "<tbody>\n" +
                            "<tr style=\"vertical-align:top\">\n" +
                            "<td align=\"center\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" +
                            "</td>\n" +
                            "</tr>\n" +
                            "</tbody>\n" +
                            "</table>\n" +
                            "</div>\n" +
                            "</td>\n" +
                            "</tr>\n" +
                            "</tbody>\n" +
                            "</table>\n" +
                            "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                            "<tbody>\n" +
                            "<tr style=\"vertical-align:top\">\n" +
                            "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:15px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" +
                            "<div style=\"line-height: 120%; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont;\">\n" +
                            "<div style=\"font-size: 12px; line-height: 14px; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont; text-align: left;\">\n" +
                            "<table style=\"border-collapse:collapse; border-spacing:0\">\n" +
                            "<tbody>\n" +
                            "<tr>\n" +
                            "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#666; overflow:hidden; word-break:normal; vertical-align:top\">\n" +
                            "<span class=\"x_m_-6366644067162443722contextualExtensionHighlight x_m_-6366644067162443722ms-font-color-themePrimary x_m_-6366644067162443722ms-border-color-themePrimary x_m_-6366644067162443722ident_999_1058\">"+nameOfNofication+"</span></td>\n" +
                            "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#ff6600; font-weight:bold; overflow:hidden; word-break:normal; vertical-align:top\">\n" +
                            "<span class=\"x_m_-6366644067162443722contextualExtensionHighlight x_m_-6366644067162443722ms-font-color-themePrimary x_m_-6366644067162443722ms-border-color-themePrimary x_m_-6366644067162443722ident_999_1058\">"+NoficationNumber+"</span></td>\n" +
                            "</tr>\n" +
                            "<tr>\n" +
                            "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#666; overflow:hidden; word-break:normal; vertical-align:top\">\n" +
                            "<span class=\"x_m_-6366644067162443722contextualExtensionHighlight x_m_-6366644067162443722ms-font-color-themePrimary x_m_-6366644067162443722ms-border-color-themePrimary x_m_-6366644067162443722ident_999_1058\">Status</span></td>\n" +
                            "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#ff6600; font-weight:bold; overflow:hidden; word-break:normal; vertical-align:top\">\n" +
                            "<span class=\"x_m_-6366644067162443722contextualExtensionHighlight x_m_-6366644067162443722ms-font-color-themePrimary x_m_-6366644067162443722ms-border-color-themePrimary x_m_-6366644067162443722ident_999_1058\">Sent for Approval</span></td>\n" +
                            "</tr>\n" +
                            "<tr>\n" +
                            "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#666; overflow:hidden; word-break:normal; vertical-align:top\">\n" +
                            "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#ff6600; font-weight:bold; overflow:hidden; word-break:normal; vertical-align:top\">\n" +
                            "</tr>\n" +
                            "<tr>\n" +
                            "</tbody>\n" +
                            "</table>\n" +
                            "</div>\n" +
                            "</div>\n" +
                            "</td>\n" +
                            "</tr>\n" +
                            "</tbody>\n" +
                            "</table>\n" +
                            "<table align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                            "<tbody>\n" +
                            "<tr style=\"vertical-align:top\">\n" +
                            "<td align=\"center\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:10px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" +
                            "<div style=\"height:1px\">\n" +
                            "<table align=\"center\" border=\"0\" cellspacing=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; border-top:1px solid #bbbbbb; width:100%\">\n" +
                            "<tbody>\n" +
                            "<tr style=\"vertical-align:top\">\n" +
                            "<td align=\"center\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" +
                            "</td>\n" +
                            "</tr>\n" +
                            "</tbody>\n" +
                            "</table>\n" +
                            "</div>\n" +
                            "</td>\n" +
                            "</tr>\n" +
                            "</tbody>\n" +
                            "</table>\n" +
                            "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                            "<tbody>\n" +
                            "<tr style=\"vertical-align:top\">\n" +
                            "<td class=\"x_m_-6366644067162443722x_button-container\" align=\"left\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:15px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" +
                            "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                            "<tbody>\n" +
                            "<tr style=\"vertical-align:top\">\n" +
                            "<td width=\"100%\" class=\"x_m_-6366644067162443722x_button\" align=\"left\" valign=\"middle\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" +
                            "<div align=\"left\" style=\"display:inline-block; border-radius:5px; max-width:25%; width:100%; border-top:0px solid transparent; border-right:0px solid transparent; border-bottom:0px solid transparent; border-left:0px solid transparent\">\n" +
                            "</div>\n" +
                            "</td>\n" +
                            "</tr>\n" +
                            "</tbody>\n" +
                            "</table>\n" +
                            "</td>\n" +
                            "</tr>\n" +
                            "</tbody>\n" +
                            "</table>\n" +
                            "</td>\n" +
                            "</tr>\n" +
                            "</tbody>\n" +
                            "</table>\n" +
                            "</div>\n" +
                            "</td>\n" +
                            "</tr>\n" +
                            "</tbody>\n" +
                            "</table>\n" +
                            "</td>\n" +
                            "</tr>\n" +
                            "</tbody>\n" +
                            "</table>\n" +
                            "</td>\n" +
                            "</tr>\n" +
                            "</tbody>\n" +
                            "</table>\n" +
                            "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                            "<tbody>\n" +
                            "<tr style=\"vertical-align:top\">\n" +
                            "<td width=\"100%\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:#444444\">\n" +
                            "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" class=\"x_m_-6366644067162443722x_container\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; max-width:500px; margin:0 auto; text-align:inherit\">\n" +
                            "<tbody>\n" +
                            "<tr style=\"vertical-align:top\">\n" +
                            "<td width=\"100%\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" +
                            "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" bgcolor=\"transparent\" class=\"x_m_-6366644067162443722x_block-grid\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; width:100%; max-width:500px; color:#333; background-color:transparent\">\n" +
                            "<tbody>\n" +
                            "<tr style=\"vertical-align:top\">\n" +
                            "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:transparent; text-align:center; font-size:0\">\n" +
                            "<div class=\"x_m_-6366644067162443722x_col x_m_-6366644067162443722x_num12\" style=\"display:inline-block; vertical-align:top; width:100%\">\n" +
                            "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                            "<tbody>\n" +
                            "<tr style=\"vertical-align:top\">\n" +
                            "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:transparent; padding-top:25px; padding-right:0px; padding-bottom:25px; padding-left:0px; border-top:0px solid transparent; border-right:0px solid transparent; border-bottom:0px solid transparent; border-left:0px solid transparent\">\n" +
                            "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                            "<tbody>\n" +
                            "<tr style=\"vertical-align:top\">\n" +
                            "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:10px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" +
                            "<div style=\"color: rgb(187, 187, 187); line-height: 120%; font-family: Helvetica Neue, Helvetica, Arial, sans-serif, serif, EmojiFont;\">\n" +
                            "<div style=\"font-size: 12px; line-height: 14px; color: rgb(187, 187, 187); font-family: Helvetica Neue, Helvetica, Arial, sans-serif, serif, EmojiFont; text-align: left;\">\n" +
                            "<p style=\"margin:0; font-size:12px; line-height:14px; text-align:center\">Omniyat <span class=\"x_m_-6366644067162443722highlight\" id=\"x_m_-63666440671624437220.6246102622735843\" name=\"x_searchHitInReadingPane\">Notifications</span></p>\n" +
                            "<p style=\"margin:0; font-size:12px; line-height:14px; text-align:center\">mailto:Omniyatnotifications@Omniyat-me.com <span class=\"x_m_-6366644067162443722highlight\" id=\"x_m_-63666440671624437220.6246102622735843\" name=\"x_searchHitInReadingPane\"></span></p>\n" +
                            "</div>\n" +
                            "</div>\n" +
                            "</td>\n" +
                            "</tr>\n" +
                            "</tbody>\n" +
                            "</table>\n" +
                            "</td>\n" +
                            "</tr>\n" +
                            "</tbody>\n" +
                            "</table>\n" +
                            "</div>\n" +
                            "</td>\n" +
                            "</tr>\n" +
                            "</tbody>\n" +
                            "</table>\n" +
                            "</td>\n" +
                            "</tr>\n" +
                            "</tbody>\n" +
                            "</table>\n" +
                            "</td>\n" +
                            "</tr>\n" +
                            "</tbody>\n" +
                            "</table>\n" +
                            "</body>\n" +
                            "</html>";
         String Html_Msg=quotesReplace(Msg);
         return Html_Msg;
     }
    
    // Mail Tem for reject
    public static String rejectionTemp(String nameOfNofication, String NoficationNumber, String LoginUser){
        
        String Msg= "<html>\n" +
                           "<head>\n" +
                           "<title>Page Title</title>\n" +
                           "</head>\n" +
                           "<body>\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td width=\"100%\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:#444444\">\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" class=\"x_m_-6366644067162443722x_container\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; max-width:500px; margin:0 auto; text-align:inherit\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td width=\"100%\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" bgcolor=\"transparent\" class=\"x_m_-6366644067162443722x_block-grid\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; width:100%; max-width:500px; color:#333; background-color:transparent\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:transparent; text-align:center; font-size:0\">\n" +
                           "<div class=\"x_m_-6366644067162443722x_col x_m_-6366644067162443722x_num12\" style=\"display:inline-block; vertical-align:top; width:100%\">\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:transparent; padding-top:20px; padding-right:0px; padding-bottom:20px; padding-left:0px; border-top:0px solid transparent; border-right:0px solid transparent; border-bottom:0px solid transparent; border-left:0px solid transparent\">\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody><tr style=\"vertical-align:top\">\n" +
                           "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:10px; padding-right:10px; padding-bottom:0px; padding-left:10px\">\n" +
                           "<div style=\"color: rgb(85, 85, 85); line-height: 120%; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont;\">\n" +
                           "<div style=\"font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont; font-size: 12px; line-height: 14px; color: rgb(85, 85, 85); text-align: left;\">\n" +
                           "<p style=\"margin:0; font-size:18px; line-height:22px\"><span style=\"font-size:26px; line-height:31px; color:rgb(255,255,255)\"><strong><span style=\"line-height:31px; font-size:26px\">Omniyat</span></strong></span></p>\n" +
                           "</div>\n" +
                           "</div>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:5px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" +
                           "<div style=\"color: rgb(136, 136, 136); line-height: 120%; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont;\">\n" +
                           "<div style=\"font-size: 12px; line-height: 14px; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont; color: rgb(136, 136, 136); text-align: left;\">\n" +
                           "<p style=\"margin:0; font-size:12px; line-height:14px\"><span style=\"color:rgb(153,153,153); font-size:12px; line-height:14px\">Omniyat <span class=\"x_m_-6366644067162443722highlight\" id=\"x_m_-63666440671624437220.9182669872898304\" name=\"x_searchHitInReadingPane\">Notifications</span></span></p>\n" +
                           "</div>\n" +
                           "</div>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</div>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td width=\"100%\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:#e5e5e5\">\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" class=\"x_m_-6366644067162443722x_container\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; max-width:500px; margin:0 auto; text-align:inherit\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td width=\"100%\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" bgcolor=\"transparent\" class=\"x_m_-6366644067162443722x_block-grid\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; width:100%; max-width:500px; color:#333; background-color:transparent\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:transparent; text-align:center; font-size:0\">\n" +
                           "<div class=\"x_m_-6366644067162443722x_col x_m_-6366644067162443722x_num12\" style=\"display:inline-block; vertical-align:top; width:100%\">\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:transparent; padding-top:30px; padding-right:0px; padding-bottom:30px; padding-left:0px; border-top:0px solid transparent; border-right:0px solid transparent; border-bottom:0px solid transparent; border-left:0px solid transparent\">\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:10px; padding-right:10px; padding-bottom:0px; padding-left:10px\">\n" +
                           "<div style=\"color: rgb(85, 85, 85); line-height: 120%; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont;\">\n" +
                           "<div style=\"font-size: 12px; line-height: 14px; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont; color: rgb(85, 85, 85); text-align: left;\">\n" +
                           "<p style=\"margin:0; font-size:14px; line-height:17px; text-align:justify\"><span style=\"font-size:24px; line-height:28px\"><strong><span style=\"line-height:28px; font-size:24px\"><span style=\"color:rgb(44,48,94); font-size:24px; line-height:28px\">Hey</span>,<span style=\"color:rgb(51,51,51); font-size:24px; line-height:28px\"> <span style=\"font-size:24px; line-height:28px\">"+nameOfNofication+"&nbsp"+NoficationNumber+"&nbspis Rejected.</span></span></span></strong></span></p>\n" +
                           "</div>\n" +
                           "</div>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "<table align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td align=\"center\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:10px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" +
                           "<div style=\"height:1px\">\n" +
                           "<table align=\"center\" border=\"0\" cellspacing=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; border-top:1px solid #bbbbbb; width:100%\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td align=\"center\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</div>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:10px\">\n" +
                           "<div style=\"color: rgb(119, 119, 119); line-height: 120%; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont;\">\n" +
                           "<div style=\"font-size: 12px; line-height: 14px; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont; color: rgb(119, 119, 119); text-align: left;\">\n" +
                           "<p style=\"margin:0; font-size:14px; line-height:17px; text-align:justify\"><span style=\"font-size:12px; line-height:14px; color:rgb(51,51,51)\"><span style=\"font-size:12px; line-height:14px\"><span style=\"font-size:12px; line-height:14px\"><strong style=\"color:rgb(255,102,0)\">"+LoginUser+"</strong> has placed an "+nameOfNofication+" with "+nameOfNofication+" number "+NoficationNumber+" is Rejected.<br>\n" +
                           "<br>\n" +
                           "Thank you!<br>\n" +
                           "<span class=\"x_m_-6366644067162443722contextualExtensionHighlight x_m_-6366644067162443722ms-font-color-themePrimary x_m_-6366644067162443722ms-border-color-themePrimary x_m_-6366644067162443722ident_999_1058\">Good day!</span></span></span></span></p>\n" +
                           "</div>\n" +
                           "</div>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "<table align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td align=\"center\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:10px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" +
                           "<div style=\"height:1px\">\n" +
                           "<table align=\"center\" border=\"0\" cellspacing=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; border-top:1px solid #bbbbbb; width:100%\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td align=\"center\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</div>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:15px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" +
                           "<div style=\"line-height: 120%; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont;\">\n" +
                           "<div style=\"font-size: 12px; line-height: 14px; font-family: Roboto, Tahoma, Verdana, Segoe, sans-serif, serif, EmojiFont; text-align: left;\">\n" +
                           "<table style=\"border-collapse:collapse; border-spacing:0\">\n" +
                           "<tbody>\n" +
                           "<tr>\n" +
                           "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#666; overflow:hidden; word-break:normal; vertical-align:top\">\n" +
                           "<span class=\"x_m_-6366644067162443722contextualExtensionHighlight x_m_-6366644067162443722ms-font-color-themePrimary x_m_-6366644067162443722ms-border-color-themePrimary x_m_-6366644067162443722ident_999_1058\">"+nameOfNofication+"</span></td>\n" +
                           "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#ff6600; font-weight:bold; overflow:hidden; word-break:normal; vertical-align:top\">\n" +
                           "<span class=\"x_m_-6366644067162443722contextualExtensionHighlight x_m_-6366644067162443722ms-font-color-themePrimary x_m_-6366644067162443722ms-border-color-themePrimary x_m_-6366644067162443722ident_999_1058\">"+NoficationNumber+"</span></td>\n" +
                           "</tr>\n" +
                           "<tr>\n" +
                           "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#666; overflow:hidden; word-break:normal; vertical-align:top\">\n" +
                           "<span class=\"x_m_-6366644067162443722contextualExtensionHighlight x_m_-6366644067162443722ms-font-color-themePrimary x_m_-6366644067162443722ms-border-color-themePrimary x_m_-6366644067162443722ident_999_1058\">Status</span></td>\n" +
                           "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#ff6600; font-weight:bold; overflow:hidden; word-break:normal; vertical-align:top\">\n" +
                           "<span class=\"x_m_-6366644067162443722contextualExtensionHighlight x_m_-6366644067162443722ms-font-color-themePrimary x_m_-6366644067162443722ms-border-color-themePrimary x_m_-6366644067162443722ident_999_1058\">Rejected</span></td>\n" +
                           "</tr>\n" +
                           "<tr>\n" +
                           "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#666; overflow:hidden; word-break:normal; vertical-align:top\">\n" +
                           "<td style=\"font-size:12px; font-weight:normal; padding:10px 5px; border:none; color:#ff6600; font-weight:bold; overflow:hidden; word-break:normal; vertical-align:top\">\n" +
                           "</tr>\n" +
                           "<tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</div>\n" +
                           "</div>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "<table align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td align=\"center\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:10px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" +
                           "<div style=\"height:1px\">\n" +
                           "<table align=\"center\" border=\"0\" cellspacing=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; border-top:1px solid #bbbbbb; width:100%\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td align=\"center\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</div>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td class=\"x_m_-6366644067162443722x_button-container\" align=\"left\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:15px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" +
                           "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td width=\"100%\" class=\"x_m_-6366644067162443722x_button\" align=\"left\" valign=\"middle\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" +
                           "<div align=\"left\" style=\"display:inline-block; border-radius:5px; max-width:25%; width:100%; border-top:0px solid transparent; border-right:0px solid transparent; border-bottom:0px solid transparent; border-left:0px solid transparent\">\n" +
                           "</div>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</div>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td width=\"100%\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:#444444\">\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" class=\"x_m_-6366644067162443722x_container\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; max-width:500px; margin:0 auto; text-align:inherit\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td width=\"100%\" style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top\">\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" bgcolor=\"transparent\" class=\"x_m_-6366644067162443722x_block-grid\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top; width:100%; max-width:500px; color:#333; background-color:transparent\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:transparent; text-align:center; font-size:0\">\n" +
                           "<div class=\"x_m_-6366644067162443722x_col x_m_-6366644067162443722x_num12\" style=\"display:inline-block; vertical-align:top; width:100%\">\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" border=\"0\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; background-color:transparent; padding-top:25px; padding-right:0px; padding-bottom:25px; padding-left:0px; border-top:0px solid transparent; border-right:0px solid transparent; border-bottom:0px solid transparent; border-left:0px solid transparent\">\n" +
                           "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-spacing:0; border-collapse:collapse; vertical-align:top\">\n" +
                           "<tbody>\n" +
                           "<tr style=\"vertical-align:top\">\n" +
                           "<td style=\"word-break:break-word; border-collapse:collapse!important; vertical-align:top; padding-top:10px; padding-right:10px; padding-bottom:10px; padding-left:10px\">\n" +
                           "<div style=\"color: rgb(187, 187, 187); line-height: 120%; font-family: Helvetica Neue, Helvetica, Arial, sans-serif, serif, EmojiFont;\">\n" +
                           "<div style=\"font-size: 12px; line-height: 14px; color: rgb(187, 187, 187); font-family: Helvetica Neue, Helvetica, Arial, sans-serif, serif, EmojiFont; text-align: left;\">\n" +
                           "<p style=\"margin:0; font-size:12px; line-height:14px; text-align:center\">Omniyat <span class=\"x_m_-6366644067162443722highlight\" id=\"x_m_-63666440671624437220.6246102622735843\" name=\"x_searchHitInReadingPane\">Notifications</span></p>\n" +
                           "<p style=\"margin:0; font-size:12px; line-height:14px; text-align:center\">mailto:Omniyatnotifications@Omniyat-me.com <span class=\"x_m_-6366644067162443722highlight\" id=\"x_m_-63666440671624437220.6246102622735843\" name=\"x_searchHitInReadingPane\"></span></p>\n" +
                           "</div>\n" +
                           "</div>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</div>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</td>\n" +
                           "</tr>\n" +
                           "</tbody>\n" +
                           "</table>\n" +
                           "</body>\n" +
                           "</html>";
        String Html_Msg=quotesReplace(Msg);
        return Html_Msg;
    }
    
    // new approval Mail updatedAprvlMail 
    public static String updatedAprvlMail(
      String contNum,String certNum,String certAmtWthOutVat,String TaxAmt,String certAmtWthVat,String supName,String projNum,String projName,String totlContValue,String curncy,String payDueDate,String note,String aprvr,String buyer,
      String c_cum,String r_cum,String a_cum,String m_cum,String n_cum,
      String c_prv,String r_prv,String a_prv,String m_prv,String n_prv,
      String c_curnt,String r_curnt,String a_curnt,String m_curnt,String n_curnt,
      String appNo,String certDate,String supInvNo,String supInvDate,String payTyp,String payTrm,String cmnts){
        
        String Msg= "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" + 
        "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" style=\"font-family:arial, 'helvetica neue', helvetica, sans-serif\">\n" + 
        "<head>\n" + 
        "<meta charset=\"UTF-8\">\n" + 
        "<meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\n" + 
        "<meta name=\"x-apple-disable-message-reformatting\">\n" + 
        "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" + 
        "<meta content=\"telephone=no\" name=\"format-detection\">\n" + 
        "<title>New message</title><!--[if (mso 16)]>\n" + 
        "<style type=\"text/css\">\n" + 
        "a {text-decoration: none;}\n" + 
        "</style>\n" + 
        "<![endif]--><!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]--><!--[if gte mso 9]>\n" + 
        "<xml>\n" + 
        "<o:OfficeDocumentSettings>\n" + 
        "<o:AllowPNG></o:AllowPNG>\n" + 
        "<o:PixelsPerInch>96</o:PixelsPerInch>\n" + 
        "</o:OfficeDocumentSettings>\n" + 
        "</xml>\n" + 
        "<![endif]-->\n" + 
        "<style type=\"text/css\">\n" + 
        "#outlook a {\n" + 
        "padding:0;\n" + 
        "}\n" + 
        ".es-button {\n" + 
        "mso-style-priority:100!important;\n" + 
        "text-decoration:none!important;\n" + 
        "}\n" + 
        "a[x-apple-data-detectors] {\n" + 
        "color:inherit!important;\n" + 
        "text-decoration:none!important;\n" + 
        "font-size:inherit!important;\n" + 
        "font-family:inherit!important;\n" + 
        "font-weight:inherit!important;\n" + 
        "line-height:inherit!important;\n" + 
        "}\n" + 
        ".es-desk-hidden {\n" + 
        "display:none;\n" + 
        "float:left;\n" + 
        "overflow:hidden;\n" + 
        "width:0;\n" + 
        "max-height:0;\n" + 
        "line-height:0;\n" + 
        "mso-hide:all;\n" + 
        "}\n" + 
        "[data-ogsb] .es-button {\n" + 
        "border-width:0!important;\n" + 
        "padding:10px 20px 10px 20px!important;\n" + 
        "}\n" + 
        "@media only screen and (max-width:600px) {p, ul li, ol li, a { line-height:150%!important } h1, h2, h3, h1 a, h2 a, h3 a { line-height:120% } h1 { font-size:30px!important; text-align:left } h2 { font-size:24px!important; text-align:left } h3 { font-size:20px!important; text-align:left } .es-header-body h1 a, .es-content-body h1 a, .es-footer-body h1 a { font-size:30px!important; text-align:left } .es-header-body h2 a, .es-content-body h2 a, .es-footer-body h2 a { font-size:24px!important; text-align:left } .es-header-body h3 a, .es-content-body h3 a, .es-footer-body h3 a { font-size:20px!important; text-align:left } .es-menu td a { font-size:14px!important } .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a { font-size:14px!important } .es-content-body p, .es-content-body ul li, .es-content-body ol li, .es-content-body a { font-size:14px!important } .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a { font-size:14px!important } .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a { font-size:12px!important } *[class=\"gmail-fix\"] { display:none!important } .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 { text-align:center!important } .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 { text-align:right!important } .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 { text-align:left!important } .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img { display:inline!important } .es-button-border { display:inline-block!important } a.es-button, button.es-button { font-size:18px!important; display:inline-block!important } .es-adaptive table, .es-left, .es-right { width:100%!important } .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header { width:100%!important; max-width:600px!important } .es-adapt-td { display:block!important; width:100%!important } .adapt-img { width:100%!important; height:auto!important } .es-m-p0 { padding:0px!important } .es-m-p0r { padding-right:0px!important } .es-m-p0l { padding-left:0px!important } .es-m-p0t { padding-top:0px!important } .es-m-p0b { padding-bottom:0!important } .es-m-p20b { padding-bottom:20px!important } .es-mobile-hidden, .es-hidden { display:none!important } tr.es-desk-hidden, td.es-desk-hidden, table.es-desk-hidden { width:auto!important; overflow:visible!important; float:none!important; max-height:inherit!important; line-height:inherit!important } tr.es-desk-hidden { display:table-row!important } table.es-desk-hidden { display:table!important } td.es-desk-menu-hidden { display:table-cell!important } .es-menu td { width:1%!important } table.es-table-not-adapt, .esd-block-html table { width:auto!important } table.es-social { display:inline-block!important } table.es-social td { display:inline-block!important } .es-desk-hidden { display:table-row!important; width:auto!important; overflow:visible!important; max-height:inherit!important } }\n" + 
        "</style>\n" + 
        "</head>\n" + 
        "<body style=\"width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\">\n" + 
        "<div class=\"es-wrapper-color\" style=\"background-color:#F6F6F6\"><!--[if gte mso 9]>\n" + 
        "<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" + 
        "<v:fill type=\"tile\" color=\"#f6f6f6\"></v:fill>\n" + 
        "</v:background>\n" + 
        "<![endif]-->\n" + 
        "<table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top;background-color:#F6F6F6\">\n" + 
        "<tr>\n" + 
        "<td valign=\"top\" style=\"padding:0;Margin:0\">\n" + 
        "<table class=\"es-header\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\">\n" + 
        "<tr>\n" + 
        "<td align=\"center\" style=\"padding:0;Margin:0\">\n" + 
        "<table class=\"es-header-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px\"><!--[if mso]><table style=\"width:560px\" cellpadding=\"0\"\n" + 
        "cellspacing=\"0\"><tr><td style=\"width:180px\" valign=\"top\"><![endif]-->\n" + 
        "<table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" + 
        "<tr>\n" + 
        "<td class=\"es-m-p0r es-m-p20b\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:180px\">\n" + 
        "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><br></p></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "</table><!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:360px\" valign=\"top\"><![endif]-->\n" + 
        "<table class=\"es-right\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0;width:360px\">\n" + 
        "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#0b5394;font-size:14px\"><strong>Buy Certification Approval</strong></p></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "</table><!--[if mso]></td></tr></table><![endif]--></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "</table>\n" + 
        "<table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" + 
        "<tr>\n" + 
        "<td align=\"center\" style=\"padding:0;Margin:0\">\n" + 
        "<table class=\"es-content-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" bgcolor=\"#efefef\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px;background-color:#efefef\">\n" + 
        "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" + 
        "<tr>\n" + 
        "<td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\">\n" + 
        "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><strong>Contract Number&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; : </strong>"+contNum+"&nbsp;</p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><strong>Certification No&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; : "+certNum+"</strong>&nbsp;</p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><strong>Amount (Without VAT)&nbsp; &nbsp;: </strong>"+certAmtWthOutVat+" "+curncy+"&nbsp;</p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><strong>Amount (With VAT)&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;: </strong>"+certAmtWthVat+" ("+certAmtWthOutVat+" + "+TaxAmt+"(VAT))"+"&nbsp;</p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><strong>Supplier Name&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; : </strong>"+supName+"&nbsp;</p></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "</table>\n" + 
        "<table class=\"es-footer\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\">\n" + 
        "<tr>\n" + 
        "<td align=\"center\" style=\"padding:0;Margin:0\">\n" + 
        "<table class=\"es-footer-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" bgcolor=\"#efefef\" style=\"Margin:0;padding-top:20px;padding-bottom:20px;padding-left:20px;padding-right:20px;background-color:#efefef\"><!--[if mso]><table style=\"width:560px\" cellpadding=\"0\"\n" + 
        "cellspacing=\"0\"><tr><td style=\"width:270px\" valign=\"top\"><![endif]-->\n" + 
        "<table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" + 
        "<tr>\n" + 
        "<td class=\"es-m-p20b\" align=\"left\" style=\"padding:0;Margin:0;width:270px\">\n" + 
        "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><strong>Project Number&nbsp; &nbsp; &nbsp; &nbsp;</strong>&nbsp; &nbsp;<strong>: </strong>"+projNum+"</p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><strong>Project Name&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</strong>&nbsp; &nbsp;<strong>: </strong>"+projName+"</p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><b>Total Contract Value</b>&nbsp; &nbsp;<strong>: </strong>"+totlContValue+"</p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><b>Currency&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</b>&nbsp; &nbsp;<strong>: </strong>"+curncy+"</p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><strong>Payment Due Date&nbsp; &nbsp;</strong>&nbsp; &nbsp;<strong>: </strong>"+payDueDate+"</p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><b>Note</b>&nbsp; &nbsp;<strong>: </strong>"+note+"</p></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "</table><!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:270px\" valign=\"top\"><![endif]-->\n" + 
        "<table class=\"es-right\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0;width:270px\">\n" + 
        "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><br></p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><br></p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><b><b>Approver</b></b>&nbsp; &nbsp;<strong>: </strong>"+aprvr+"</p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><b>Buyer&nbsp; &nbsp; &nbsp;&nbsp;</b>&nbsp; &nbsp;<strong>: </strong>"+buyer+"</p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><strong>Submitted For Approval</strong></p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><br></p></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "</table><!--[if mso]></td></tr></table><![endif]--></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" bgcolor=\"#efefef\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px;background-color:#efefef\"><!--[if mso]><table style=\"width:560px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:145px\" valign=\"top\"><![endif]-->\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" class=\"es-left\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" + 
        "<tr>\n" + 
        "<td class=\"es-m-p0r es-m-p20b\" align=\"center\" style=\"padding:0;Margin:0;width:125px\">\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" bgcolor=\"#45818e\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#ffffff;font-size:14px\"><strong>&nbsp; TYPE</strong></p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><b>Certified</b></p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><b>Retention</b></p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><b>Advance</b></p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><b>Material</b></p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><b>Net</b></p></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "<td class=\"es-hidden\" style=\"padding:0;Margin:0;width:20px\"></td>\n" + 
        "</tr>\n" + 
        "</table><!--[if mso]></td><td style=\"width:145px\" valign=\"top\"><![endif]-->\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" class=\"es-left\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" + 
        "<tr>\n" + 
        "<td class=\"es-m-p20b\" align=\"center\" style=\"padding:0;Margin:0;width:125px\">\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" bgcolor=\"#45818e\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#ffffff;font-size:14px\"><strong>&nbsp; CUMULATIVE</strong></p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">"+c_cum+"</p></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "<td class=\"es-hidden\" style=\"padding:0;Margin:0;width:20px\"></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td class=\"es-m-p20b\" align=\"center\" style=\"padding:0;Margin:0;width:125px\">\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">"+r_cum+"</p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">"+a_cum+"</p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">"+m_cum+"</p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">"+n_cum+"</p></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "<td class=\"es-hidden\" style=\"padding:0;Margin:0;width:20px\"></td>\n" + 
        "</tr>\n" + 
        "</table><!--[if mso]></td><td style=\"width:125px\" valign=\"top\"><![endif]-->\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" class=\"es-left\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" + 
        "<tr>\n" + 
        "<td class=\"es-m-p20b\" align=\"center\" style=\"padding:0;Margin:0;width:125px\">\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" bgcolor=\"#45818e\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#ffffff;font-size:14px\"><strong>&nbsp;PREVIOUS</strong></p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">"+c_prv+"</p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">"+r_prv+"</p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">"+a_prv+"</p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">"+m_prv+"</p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">"+n_prv+"</p></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "</table><!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:125px\" valign=\"top\"><![endif]-->\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" class=\"es-right\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" + 
        "<tr>\n" + 
        "<td align=\"center\" style=\"padding:0;Margin:0;width:125px\">\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" bgcolor=\"#45818e\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#ffffff;font-size:14px\"><strong>&nbsp; CURRENT</strong></p></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"center\" style=\"padding:0;Margin:0;width:125px\">\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">"+c_curnt+"</p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">"+r_curnt+"</p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">"+a_curnt+"</p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">"+m_curnt+"</p></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">"+n_curnt+"</p></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "</table><!--[if mso]></td></tr></table><![endif]--></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px\">\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" + 
        "<tr>\n" + 
        "<td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\">\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#0b5394;font-size:14px\"><strong>Payment Certificate Details :</strong></p></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "</table>\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" + 
        "<tr>\n" + 
        "<td align=\"center\" style=\"padding:0;Margin:0\">\n" + 
        "<table bgcolor=\"#ffffff\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" bgcolor=\"#efefef\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px;background-color:#efefef\"><!--[if mso]><table style=\"width:560px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:180px\" valign=\"top\"><![endif]-->\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" class=\"es-left\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" + 
        "<tr>\n" + 
        "<td class=\"es-m-p0r es-m-p20b\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:180px\">\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><strong>Application Number</strong></p></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "</table><!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:360px\" valign=\"top\"><![endif]-->\n" + 
        "<table class=\"es-right\" cellpadding=\"0\" cellspacing=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0;width:360px\">\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><strong>: </strong>"+appNo+"</p></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "</table><!--[if mso]></td></tr></table><![endif]--></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px\"><!--[if mso]><table style=\"width:560px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:180px\" valign=\"top\"><![endif]-->\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" class=\"es-left\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" + 
        "<tr>\n" + 
        "<td class=\"es-m-p0r es-m-p20b\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:180px\">\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><strong>Certification Date</strong></p></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "</table><!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:360px\" valign=\"top\"><![endif]-->\n" + 
        "<table class=\"es-right\" cellpadding=\"0\" cellspacing=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0;width:360px\">\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><strong>: </strong>"+certDate+"</p></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "</table><!--[if mso]></td></tr></table><![endif]--></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" bgcolor=\"#efefef\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px;background-color:#efefef\"><!--[if mso]><table style=\"width:560px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:180px\" valign=\"top\"><![endif]-->\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" class=\"es-left\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" + 
        "<tr>\n" + 
        "<td class=\"es-m-p0r es-m-p20b\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:180px\">\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><strong>Supplier Invoice Number</strong></p></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "</table><!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:360px\" valign=\"top\"><![endif]-->\n" + 
        "<table class=\"es-right\" cellpadding=\"0\" cellspacing=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0;width:360px\">\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><strong>: </strong>"+supInvNo+"</p></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "</table><!--[if mso]></td></tr></table><![endif]--></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px\"><!--[if mso]><table style=\"width:560px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:180px\" valign=\"top\"><![endif]-->\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" class=\"es-left\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" + 
        "<tr>\n" + 
        "<td class=\"es-m-p0r es-m-p20b\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:180px\">\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><strong>Supplier Invoice Date</strong></p></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "</table><!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:360px\" valign=\"top\"><![endif]-->\n" + 
        "<table class=\"es-right\" cellpadding=\"0\" cellspacing=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0;width:360px\">\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><strong>: </strong>"+supInvDate+"</p></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "</table><!--[if mso]></td></tr></table><![endif]--></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" bgcolor=\"#efefef\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px;background-color:#efefef\"><!--[if mso]><table style=\"width:560px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:180px\" valign=\"top\"><![endif]-->\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" class=\"es-left\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" + 
        "<tr>\n" + 
        "<td class=\"es-m-p0r es-m-p20b\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:180px\">\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><strong>Payment Type</strong></p></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "</table><!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:360px\" valign=\"top\"><![endif]-->\n" + 
        "<table class=\"es-right\" cellpadding=\"0\" cellspacing=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0;width:360px\">\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><strong>: </strong>"+payTyp+"</p></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "</table><!--[if mso]></td></tr></table><![endif]--></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px\"><!--[if mso]><table style=\"width:560px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:180px\" valign=\"top\"><![endif]-->\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" class=\"es-left\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" + 
        "<tr>\n" + 
        "<td class=\"es-m-p0r es-m-p20b\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:180px\">\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><strong>Payment Term</strong></p></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "</table><!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:360px\" valign=\"top\"><![endif]-->\n" + 
        "<table class=\"es-right\" cellpadding=\"0\" cellspacing=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0;width:360px\">\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><strong>: </strong>"+payTrm+"</p></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "</table><!--[if mso]></td></tr></table><![endif]--></td>\n" + 
        "</tr>\n" + 
        "<tr>\n" + 
        "<td align=\"left\" bgcolor=\"#efefef\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px;background-color:#efefef\"><!--[if mso]><table style=\"width:560px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:180px\" valign=\"top\"><![endif]-->\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" class=\"es-left\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" + 
        "<tr>\n" + 
        "<td class=\"es-m-p0r es-m-p20b\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:180px\">\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><strong>Comments</strong></p></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "</table><!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:360px\" valign=\"top\"><![endif]-->\n" + 
        "<table class=\"es-right\" cellpadding=\"0\" cellspacing=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0;width:360px\">\n" + 
        "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" + 
        "<tr>\n" + 
        "<td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\"><strong>: </strong>"+cmnts+"</p></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "</table><!--[if mso]></td></tr></table><![endif]--></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "</table></td>\n" + 
        "</tr>\n" + 
        "</table>\n" + 
        "</div>\n" + 
        "</body>\n" + 
        "</html>";
        String Html_Msg=quotesReplace(Msg);
        return Html_Msg;
    }
}

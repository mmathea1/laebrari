
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object layout extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title : String )(body : Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.32*/("""
"""),format.raw/*2.1*/("""<!--<!DOCTYPE html>-->
<!--<html lang="en">-->
<head>
    <meta charset="UTF-8">
    <title>"""),_display_(/*6.13*/title),format.raw/*6.18*/("""</title>
    <link rel="stylesheet" href=""""),_display_(/*7.35*/routes/*7.41*/.Assets.versioned("css/bootstrap.min.css")),format.raw/*7.83*/("""">
    <link rel="stylesheet" href=""""),_display_(/*8.35*/routes/*8.41*/.Assets.versioned("css/bootstrap.theme.min.css")),format.raw/*8.89*/("""">
    <link rel="stylesheet" href=""""),_display_(/*9.35*/routes/*9.41*/.Assets.versioned("css/main.css")),format.raw/*9.74*/("""">

    <link rel="shortcut icon" type="image/png" href=""""),_display_(/*11.55*/routes/*11.61*/.Assets.versioned("images/favicon.png")),format.raw/*11.100*/("""">
</head>
<body>
<header>
 <div class="navbar navbar-default">
     <div class="container">
         <div class="navbar-header">
             <a href=""""),_display_(/*18.24*/routes/*18.30*/.HomeController.index()),format.raw/*18.53*/("""" class="navbar-brand">Laebrari</a>
         </div>
         <div class="navbar-collapse">
             <ul class="nav navbar-nav navbar-left">
                 <li><a href=""""),_display_(/*22.32*/routes/*22.38*/.BookController.index()),format.raw/*22.61*/("""">All Books</a> </li>
                 <li><a href=""""),_display_(/*23.32*/routes/*23.38*/.BookController.create()),format.raw/*23.62*/("""">New Book</a></li>
             </ul>
         </div>
     </div>
 </div>
</header>
<div class =" container">
    """),_display_(/*30.6*/body),format.raw/*30.10*/("""
"""),format.raw/*31.1*/("""</div>



<script src=""""),_display_(/*35.15*/routes/*35.21*/.Assets.versioned("js/jquery-3.2.1.min.js")),format.raw/*35.64*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*36.15*/routes/*36.21*/.Assets.versioned("js/bootstrap.min.js")),format.raw/*36.61*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*37.15*/routes/*37.21*/.Assets.versioned("js/main.js")),format.raw/*37.52*/("""" type="text/javascript"></script>

</body>
<!--</html>-->"""))
      }
    }
  }

  def render(title:String,body:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(body)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (body) => apply(title)(body)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Nov 08 11:46:51 EAT 2017
                  SOURCE: C:/Users/Mingina/Workspace/laebrari/lib-project/app/views/layout.scala.html
                  HASH: e2f0e8e6302f7a4e388fcafc545ba828c242b892
                  MATRIX: 954->1|1079->31|1107->33|1230->130|1255->135|1325->179|1339->185|1401->227|1465->265|1479->271|1547->319|1611->357|1625->363|1678->396|1765->456|1780->462|1841->501|2028->661|2043->667|2087->690|2293->869|2308->875|2352->898|2433->952|2448->958|2493->982|2642->1105|2667->1109|2696->1111|2751->1139|2766->1145|2830->1188|2907->1238|2922->1244|2983->1284|3060->1334|3075->1340|3127->1371
                  LINES: 28->1|33->1|34->2|38->6|38->6|39->7|39->7|39->7|40->8|40->8|40->8|41->9|41->9|41->9|43->11|43->11|43->11|50->18|50->18|50->18|54->22|54->22|54->22|55->23|55->23|55->23|62->30|62->30|63->31|67->35|67->35|67->35|68->36|68->36|68->36|69->37|69->37|69->37
                  -- GENERATED --
              */
          
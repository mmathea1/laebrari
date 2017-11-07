
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
"""),format.raw/*2.1*/("""<!DOCTYPE html>
<html lang="en">
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
"""),_display_(/*29.2*/body),format.raw/*29.6*/("""


"""),format.raw/*32.1*/("""<script src=""""),_display_(/*32.15*/routes/*32.21*/.Assets.versioned("js/jquery-3.2.1.min.js")),format.raw/*32.64*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*33.15*/routes/*33.21*/.Assets.versioned("js/bootstrap.min.js")),format.raw/*33.61*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*34.15*/routes/*34.21*/.Assets.versioned("js/main.js")),format.raw/*34.52*/("""" type="text/javascript"></script>

</body>
</html>"""))
      }
    }
  }

  def render(title:String,body:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(body)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (body) => apply(title)(body)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Nov 07 19:44:18 EAT 2017
                  SOURCE: C:/Users/Mingina/Workspace/laebrari/lib-project/app/views/layout.scala.html
                  HASH: d0648b419d33494c566484592a250f94b740fce3
                  MATRIX: 954->1|1079->31|1107->33|1216->116|1241->121|1311->165|1325->171|1387->213|1451->251|1465->257|1533->305|1597->343|1611->349|1664->382|1751->442|1766->448|1827->487|2014->647|2029->653|2073->676|2279->855|2294->861|2338->884|2419->938|2434->944|2479->968|2597->1060|2621->1064|2654->1070|2695->1084|2710->1090|2774->1133|2851->1183|2866->1189|2927->1229|3004->1279|3019->1285|3071->1316
                  LINES: 28->1|33->1|34->2|38->6|38->6|39->7|39->7|39->7|40->8|40->8|40->8|41->9|41->9|41->9|43->11|43->11|43->11|50->18|50->18|50->18|54->22|54->22|54->22|55->23|55->23|55->23|61->29|61->29|64->32|64->32|64->32|64->32|65->33|65->33|65->33|66->34|66->34|66->34
                  -- GENERATED --
              */
          
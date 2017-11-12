
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

    <title>"""),_display_(/*8.13*/title),format.raw/*8.18*/("""</title>
    <link rel="stylesheet" href='"""),_display_(/*9.35*/routes/*9.41*/.Assets.versioned("css/bootstrap.min.css")),format.raw/*9.83*/("""'>
    <link rel="stylesheet" href='"""),_display_(/*10.35*/routes/*10.41*/.Assets.versioned("css/bootstrap-theme.min.css")),format.raw/*10.89*/("""'>
    <link rel="stylesheet" href='"""),_display_(/*11.35*/routes/*11.41*/.Assets.versioned("css/main.css")),format.raw/*11.74*/("""'>

    <link rel="shortcut icon" type="image/png" href='"""),_display_(/*13.55*/routes/*13.61*/.Assets.versioned("images/favicon.png")),format.raw/*13.100*/("""'>
</head>
<body>
<header>
 <div class="navbar navbar-default">
     <div class="container">
         <div class="navbar-header">
             <a href=""""),_display_(/*20.24*/routes/*20.30*/.HomeController.index()),format.raw/*20.53*/("""" class="navbar-brand">
                 <i class="glyphicon glyphicon-home"></i> Laebrari</a>
         </div>
         <div class="navbar-collapse">
             <ul class="nav navbar-nav navbar-left">
                 <li><a href=""""),_display_(/*25.32*/routes/*25.38*/.BookController.index()),format.raw/*25.61*/("""">
                     <i class="glyphicon glyphicon-book"> </i> All Books</a> </li>
                 <li><a href=""""),_display_(/*27.32*/routes/*27.38*/.BookController.create()),format.raw/*27.62*/("""">
                     <i class="glyphicon glyphicon-plus"> </i> New Book</a></li>
             </ul>
         </div>
     </div>
 </div>
</header>
<div class =" container">
    """),_display_(/*35.6*/for(key <- Array("danger","success", "warning")) yield /*35.54*/{_display_(Seq[Any](format.raw/*35.55*/("""
        """),_display_(/*36.10*/if(flash.containsKey(key))/*36.36*/{_display_(Seq[Any](format.raw/*36.37*/("""
            """),format.raw/*37.13*/("""<div class="alert alert-"""),_display_(/*37.38*/key),format.raw/*37.41*/("""">
                """),_display_(/*38.18*/flash/*38.23*/.get(key)),format.raw/*38.32*/("""
                """),format.raw/*39.17*/("""<a href="#" class="close" data-dismiss="alert" aria-label="close"><i class="glyphicon glyphicon-remove"></i></a>
            </div>
        """)))}),format.raw/*41.10*/("""
    """)))}),format.raw/*42.6*/("""
    """),_display_(/*43.6*/body),format.raw/*43.10*/("""
"""),format.raw/*44.1*/("""</div>



<script type="text/javascript" src='"""),_display_(/*48.38*/routes/*48.44*/.Assets.versioned("js/jquery-3.2.1.min.js")),format.raw/*48.87*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*49.38*/routes/*49.44*/.Assets.versioned("js/bootstrap.min.js")),format.raw/*49.84*/("""'></script>
<script type="text/javascript" src='"""),_display_(/*50.38*/routes/*50.44*/.Assets.versioned("js/main.js")),format.raw/*50.75*/("""'></script>

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
                  DATE: Sat Nov 11 15:44:19 EAT 2017
                  SOURCE: C:/Users/Mingina/Workspace/laebrari/lib-project/app/views/layout.scala.html
                  HASH: 21e243ac2aef368a3e8d0af2ed41fb93c12ab52d
                  MATRIX: 954->1|1079->31|1107->33|1234->134|1259->139|1329->183|1343->189|1405->231|1470->269|1485->275|1554->323|1619->361|1634->367|1688->400|1775->460|1790->466|1851->505|2038->665|2053->671|2097->694|2363->933|2378->939|2422->962|2568->1081|2583->1087|2628->1111|2842->1299|2906->1347|2945->1348|2983->1359|3018->1385|3057->1386|3099->1400|3151->1425|3175->1428|3223->1449|3237->1454|3267->1463|3313->1481|3487->1624|3524->1631|3557->1638|3582->1642|3611->1644|3689->1695|3704->1701|3768->1744|3845->1794|3860->1800|3921->1840|3998->1890|4013->1896|4065->1927
                  LINES: 28->1|33->1|34->2|40->8|40->8|41->9|41->9|41->9|42->10|42->10|42->10|43->11|43->11|43->11|45->13|45->13|45->13|52->20|52->20|52->20|57->25|57->25|57->25|59->27|59->27|59->27|67->35|67->35|67->35|68->36|68->36|68->36|69->37|69->37|69->37|70->38|70->38|70->38|71->39|73->41|74->42|75->43|75->43|76->44|80->48|80->48|80->48|81->49|81->49|81->49|82->50|82->50|82->50
                  -- GENERATED --
              */
          
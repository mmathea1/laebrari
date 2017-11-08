
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
             <a href=""""),_display_(/*18.24*/routes/*18.30*/.HomeController.index()),format.raw/*18.53*/("""" class="navbar-brand">
                 <i class="glyphicon glyphicon-home"></i> Laebrari</a>
         </div>
         <div class="navbar-collapse">
             <ul class="nav navbar-nav navbar-left">
                 <li><a href=""""),_display_(/*23.32*/routes/*23.38*/.BookController.index()),format.raw/*23.61*/("""">
                     <i class="glyphicon glyphicon-book"> </i> All Books</a> </li>
                 <li><a href=""""),_display_(/*25.32*/routes/*25.38*/.BookController.create()),format.raw/*25.62*/("""">
                     <i class="glyphicon glyphicon-plus"> </i> New Book</a></li>
             </ul>
         </div>
     </div>
 </div>
</header>
<div class =" container">
    """),_display_(/*33.6*/body),format.raw/*33.10*/("""
"""),format.raw/*34.1*/("""</div>



<script src=""""),_display_(/*38.15*/routes/*38.21*/.Assets.versioned("js/jquery-3.2.1.min.js")),format.raw/*38.64*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*39.15*/routes/*39.21*/.Assets.versioned("js/bootstrap.min.js")),format.raw/*39.61*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*40.15*/routes/*40.21*/.Assets.versioned("js/main.js")),format.raw/*40.52*/("""" type="text/javascript"></script>

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
                  DATE: Wed Nov 08 14:25:32 EAT 2017
                  SOURCE: C:/Users/Mingina/Workspace/laebrari/lib-project/app/views/layout.scala.html
                  HASH: 8bb3155f7c781367ff258e1b282c28a16fb7359d
                  MATRIX: 954->1|1079->31|1107->33|1230->130|1255->135|1325->179|1339->185|1401->227|1465->265|1479->271|1547->319|1611->357|1625->363|1678->396|1765->456|1780->462|1841->501|2028->661|2043->667|2087->690|2353->929|2368->935|2412->958|2558->1077|2573->1083|2618->1107|2832->1295|2857->1299|2886->1301|2941->1329|2956->1335|3020->1378|3097->1428|3112->1434|3173->1474|3250->1524|3265->1530|3317->1561
                  LINES: 28->1|33->1|34->2|38->6|38->6|39->7|39->7|39->7|40->8|40->8|40->8|41->9|41->9|41->9|43->11|43->11|43->11|50->18|50->18|50->18|55->23|55->23|55->23|57->25|57->25|57->25|65->33|65->33|66->34|70->38|70->38|70->38|71->39|71->39|71->39|72->40|72->40|72->40
                  -- GENERATED --
              */
          
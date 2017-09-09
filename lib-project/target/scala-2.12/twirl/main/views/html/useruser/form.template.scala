
package views.html.useruser

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

object form extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Form[UseruserData],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(useruserForm: Form[UseruserData]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.36*/("""

"""),format.raw/*3.1*/("""<h1>Create a Laebrari account</h1>

"""),_display_(/*5.2*/flash/*5.7*/.getOrDefault("success", "")),format.raw/*5.35*/("""

"""),_display_(/*7.2*/helper/*7.8*/.form(action = routes.UseruserController.useruserPost())/*7.64*/ {_display_(Seq[Any](format.raw/*7.66*/("""
  """),_display_(/*8.4*/helper/*8.10*/.CSRF.formField),format.raw/*8.25*/("""
  """),_display_(/*9.4*/helper/*9.10*/.inputText(useruserForm("name"))),format.raw/*9.42*/("""
  """),_display_(/*10.4*/helper/*10.10*/.inputText(useruserForm("age"))),format.raw/*10.41*/("""
  """),format.raw/*11.3*/("""<input type="submit" value="submit"/>
<button type="button"><a href=""""),_display_(/*12.33*/routes/*12.39*/.HomeController.index),format.raw/*12.60*/(""""></a>Home</button>



""")))}),format.raw/*16.2*/("""
"""))
      }
    }
  }

  def render(useruserForm:Form[UseruserData]): play.twirl.api.HtmlFormat.Appendable = apply(useruserForm)

  def f:((Form[UseruserData]) => play.twirl.api.HtmlFormat.Appendable) = (useruserForm) => apply(useruserForm)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sun Sep 10 00:37:49 EAT 2017
                  SOURCE: C:/Users/Mingina/Workspace/laebrari/lib-project/app/views/useruser/form.scala.html
                  HASH: 1a0acfad5feecb8841214e0e2fe734ce2275413c
                  MATRIX: 968->1|1097->35|1127->39|1191->78|1203->83|1251->111|1281->116|1294->122|1358->178|1397->180|1427->185|1441->191|1476->206|1506->211|1520->217|1572->249|1603->254|1618->260|1670->291|1701->295|1799->366|1814->372|1856->393|1914->421
                  LINES: 28->1|33->1|35->3|37->5|37->5|37->5|39->7|39->7|39->7|39->7|40->8|40->8|40->8|41->9|41->9|41->9|42->10|42->10|42->10|43->11|44->12|44->12|44->12|48->16
                  -- GENERATED --
              */
          
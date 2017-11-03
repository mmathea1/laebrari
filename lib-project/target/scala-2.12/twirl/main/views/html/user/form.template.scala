
package views.html.user

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

object form extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Form[UserData],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userForm: Form[UserData]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.28*/("""

"""),format.raw/*3.1*/("""<h1>Create a Laebrari account</h1>

"""),_display_(/*5.2*/flash/*5.7*/.getOrDefault("success", "")),format.raw/*5.35*/("""


"""),_display_(/*8.2*/helper/*8.8*/.form(action = routes.UserController.userPost())/*8.56*/ {_display_(Seq[Any](format.raw/*8.58*/("""
  """),_display_(/*9.4*/helper/*9.10*/.CSRF.formField),format.raw/*9.25*/("""
  """),_display_(/*10.4*/helper/*10.10*/.inputText(userForm("Name"))),format.raw/*10.38*/("""
  """),_display_(/*11.4*/helper/*11.10*/.inputText(userForm("Age"))),format.raw/*11.37*/("""
  """),_display_(/*12.4*/helper/*12.10*/.inputText(userForm("Email"))),format.raw/*12.39*/("""
  """),_display_(/*13.4*/helper/*13.10*/.inputPassword(userForm("Password"))),format.raw/*13.46*/("""




  """),format.raw/*18.3*/("""<input type="submit" value="submit"/>
<button type="button"><a href=""""),_display_(/*19.33*/routes/*19.39*/.HomeController.index()),format.raw/*19.62*/(""""></a>Home</button>



""")))}),format.raw/*23.2*/("""
"""))
      }
    }
  }

  def render(userForm:Form[UserData]): play.twirl.api.HtmlFormat.Appendable = apply(userForm)

  def f:((Form[UserData]) => play.twirl.api.HtmlFormat.Appendable) = (userForm) => apply(userForm)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat Nov 04 01:02:24 EAT 2017
                  SOURCE: C:/Users/Mingina/Workspace/laebrari/lib-project/app/views/user/form.scala.html
                  HASH: 84e0b98733dec8825a98a2ab965cf0456e457a55
                  MATRIX: 960->1|1081->27|1111->31|1175->70|1187->75|1235->103|1267->110|1280->116|1336->164|1375->166|1405->171|1419->177|1454->192|1485->197|1500->203|1549->231|1580->236|1595->242|1643->269|1674->274|1689->280|1739->309|1770->314|1785->320|1842->356|1881->368|1979->439|1994->445|2038->468|2096->496
                  LINES: 28->1|33->1|35->3|37->5|37->5|37->5|40->8|40->8|40->8|40->8|41->9|41->9|41->9|42->10|42->10|42->10|43->11|43->11|43->11|44->12|44->12|44->12|45->13|45->13|45->13|50->18|51->19|51->19|51->19|55->23
                  -- GENERATED --
              */
          
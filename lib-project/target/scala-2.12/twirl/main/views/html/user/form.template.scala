
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

"""),_display_(/*7.2*/helper/*7.8*/.form(action = routes.UserController.userPost())/*7.56*/ {_display_(Seq[Any](format.raw/*7.58*/("""
  """),_display_(/*8.4*/helper/*8.10*/.CSRF.formField),format.raw/*8.25*/("""
  """),_display_(/*9.4*/helper/*9.10*/.inputText(userForm("name"))),format.raw/*9.38*/("""
  """),_display_(/*10.4*/helper/*10.10*/.inputText(userForm("age"))),format.raw/*10.37*/("""
  """),_display_(/*11.4*/helper/*11.10*/.inputRadioGroup(userForm("sex"), Seq("male" -> "male", "female" -> "female"))),format.raw/*11.88*/("""
  """),_display_(/*12.4*/helper/*12.10*/.inputText(userForm("email"))),format.raw/*12.39*/("""
  """),_display_(/*13.4*/helper/*13.10*/.inputPassword(userForm("password"))),format.raw/*13.46*/("""



  """),format.raw/*17.3*/("""<input type="submit" value="submit"/>
<button type="button"><a href=""""),_display_(/*18.33*/routes/*18.39*/.HomeController.index()),format.raw/*18.62*/(""""></a>Home</button>



""")))}),format.raw/*22.2*/("""
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
                  DATE: Mon Sep 11 16:30:15 EAT 2017
                  SOURCE: C:/Users/Mingina/Workspace/laebrari/lib-project/app/views/user/form.scala.html
                  HASH: 352c1e60255eec4404c29c1ce6b2a989d2ca6b11
                  MATRIX: 960->1|1081->27|1111->31|1175->70|1187->75|1235->103|1265->108|1278->114|1334->162|1373->164|1403->169|1417->175|1452->190|1482->195|1496->201|1544->229|1575->234|1590->240|1638->267|1669->272|1684->278|1783->356|1814->361|1829->367|1879->396|1910->401|1925->407|1982->443|2019->453|2117->524|2132->530|2176->553|2234->581
                  LINES: 28->1|33->1|35->3|37->5|37->5|37->5|39->7|39->7|39->7|39->7|40->8|40->8|40->8|41->9|41->9|41->9|42->10|42->10|42->10|43->11|43->11|43->11|44->12|44->12|44->12|45->13|45->13|45->13|49->17|50->18|50->18|50->18|54->22
                  -- GENERATED --
              */
          
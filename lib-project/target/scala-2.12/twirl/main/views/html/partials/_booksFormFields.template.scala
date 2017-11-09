
package views.html.partials

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

object _booksFormFields extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Form[BooksModel],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(bookForm : Form[BooksModel]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.31*/("""
"""),_display_(/*2.2*/helper/*2.8*/.CSRF.formField),format.raw/*2.23*/("""
"""),_display_(/*3.2*/helper/*3.8*/.inputText(bookForm("Id"), 'class -> "form-control")),format.raw/*3.60*/("""
"""),_display_(/*4.2*/helper/*4.8*/.inputText(bookForm("Title"), 'class -> "form-control")),format.raw/*4.63*/("""
"""),_display_(/*5.2*/helper/*5.8*/.inputText(bookForm("Price"), 'class -> "form-control")),format.raw/*5.63*/("""
"""),_display_(/*6.2*/helper/*6.8*/.inputText(bookForm("Author"), 'class -> "form-control")))
      }
    }
  }

  def render(bookForm:Form[BooksModel]): play.twirl.api.HtmlFormat.Appendable = apply(bookForm)

  def f:((Form[BooksModel]) => play.twirl.api.HtmlFormat.Appendable) = (bookForm) => apply(bookForm)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Nov 08 15:08:20 EAT 2017
                  SOURCE: C:/Users/Mingina/Workspace/laebrari/lib-project/app/views/partials/_booksFormFields.scala.html
                  HASH: 16cf8f46372e04081d9d0d76398112ea5159633e
                  MATRIX: 978->1|1102->30|1130->33|1143->39|1178->54|1206->57|1219->63|1291->115|1319->118|1332->124|1407->179|1435->182|1448->188|1523->243|1551->246|1564->252
                  LINES: 28->1|33->1|34->2|34->2|34->2|35->3|35->3|35->3|36->4|36->4|36->4|37->5|37->5|37->5|38->6|38->6
                  -- GENERATED --
              */
          
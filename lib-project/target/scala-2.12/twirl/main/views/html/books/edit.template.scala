
package views.html.books

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

object edit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Form[BooksModel],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(bookForm : Form[BooksModel]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.31*/("""
"""),_display_(/*2.2*/layout("Edit Books")/*2.22*/{_display_(Seq[Any](format.raw/*2.23*/("""
    """),format.raw/*3.5*/("""<h1> Edit Book</h1>
    """),_display_(/*4.6*/helper/*4.12*/.form(action = routes.BookController.update())/*4.58*/{_display_(Seq[Any](format.raw/*4.59*/("""
    """),_display_(/*5.6*/helper/*5.12*/.CSRF.formField),format.raw/*5.27*/("""
    """),_display_(/*6.6*/helper/*6.12*/.inputText(bookForm("Id"))),format.raw/*6.38*/("""
    """),_display_(/*7.6*/helper/*7.12*/.inputText(bookForm("Title"))),format.raw/*7.41*/("""
    """),_display_(/*8.6*/helper/*8.12*/.inputText(bookForm("Price"))),format.raw/*8.41*/("""
    """),_display_(/*9.6*/helper/*9.12*/.inputText(bookForm("Author"))),format.raw/*9.42*/("""
   """)))}),format.raw/*10.5*/("""
    """),format.raw/*11.5*/("""<input type="submit" value="Edit Book">
""")))}),format.raw/*12.2*/("""
"""))
      }
    }
  }

  def render(bookForm:Form[BooksModel]): play.twirl.api.HtmlFormat.Appendable = apply(bookForm)

  def f:((Form[BooksModel]) => play.twirl.api.HtmlFormat.Appendable) = (bookForm) => apply(bookForm)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat Nov 04 11:57:30 EAT 2017
                  SOURCE: C:/Users/Mingina/Workspace/laebrari/lib-project/app/views/books/edit.scala.html
                  HASH: 027a90e33350cbfc191ca80c9347aeaff7c88765
                  MATRIX: 963->1|1087->30|1115->33|1143->53|1181->54|1213->60|1264->86|1278->92|1332->138|1370->139|1402->146|1416->152|1451->167|1483->174|1497->180|1543->206|1575->213|1589->219|1638->248|1670->255|1684->261|1733->290|1765->297|1779->303|1829->333|1865->339|1898->345|1970->387
                  LINES: 28->1|33->1|34->2|34->2|34->2|35->3|36->4|36->4|36->4|36->4|37->5|37->5|37->5|38->6|38->6|38->6|39->7|39->7|39->7|40->8|40->8|40->8|41->9|41->9|41->9|42->10|43->11|44->12
                  -- GENERATED --
              */
          
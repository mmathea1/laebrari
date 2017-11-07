
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

object create extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Form[BooksModel],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(bookForm : Form[BooksModel]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.31*/("""
"""),_display_(/*2.2*/layout("Create Book")/*2.23*/{_display_(Seq[Any](format.raw/*2.24*/("""
"""),format.raw/*3.1*/("""<h1> Add Book to library</h1>
"""),_display_(/*4.2*/helper/*4.8*/.form(action = routes.BookController.save())/*4.52*/{_display_(Seq[Any](format.raw/*4.53*/("""
"""),_display_(/*5.2*/helper/*5.8*/.CSRF.formField),format.raw/*5.23*/("""
"""),_display_(/*6.2*/helper/*6.8*/.inputText(bookForm("Id"))),format.raw/*6.34*/("""
"""),_display_(/*7.2*/helper/*7.8*/.inputText(bookForm("Title"))),format.raw/*7.37*/("""
"""),_display_(/*8.2*/helper/*8.8*/.inputText(bookForm("Price"))),format.raw/*8.37*/("""
"""),_display_(/*9.2*/helper/*9.8*/.inputText(bookForm("Author"))),format.raw/*9.38*/("""


"""),format.raw/*12.1*/("""<input type="submit" value="Add to Library">
""")))}),format.raw/*13.2*/("""

""")))}),format.raw/*15.2*/("""
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
                  DATE: Tue Nov 07 21:27:37 EAT 2017
                  SOURCE: C:/Users/Mingina/Workspace/laebrari/lib-project/app/views/books/create.scala.html
                  HASH: a091b24e0754b738e09c225c316d1c74d6c1469d
                  MATRIX: 965->1|1089->30|1117->33|1146->54|1184->55|1212->57|1269->89|1282->95|1334->139|1372->140|1400->143|1413->149|1448->164|1476->167|1489->173|1535->199|1563->202|1576->208|1625->237|1653->240|1666->246|1715->275|1743->278|1756->284|1806->314|1839->320|1916->367|1951->372
                  LINES: 28->1|33->1|34->2|34->2|34->2|35->3|36->4|36->4|36->4|36->4|37->5|37->5|37->5|38->6|38->6|38->6|39->7|39->7|39->7|40->8|40->8|40->8|41->9|41->9|41->9|44->12|45->13|47->15
                  -- GENERATED --
              */
          
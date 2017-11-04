
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Set[BooksModel],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(books : Set[BooksModel]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.27*/("""
"""),_display_(/*3.2*/layout("All Books")/*3.21*/{_display_(Seq[Any](format.raw/*3.22*/("""
"""),format.raw/*4.1*/("""<h1> All Books</h1>
"""),_display_(/*5.2*/for(book <- books) yield /*5.20*/{_display_(Seq[Any](format.raw/*5.21*/("""
"""),format.raw/*6.1*/("""<a href=""""),_display_(/*6.11*/routes/*6.17*/.BookController.show(book.id)),format.raw/*6.46*/("""">"""),_display_(/*6.49*/book/*6.53*/.title),format.raw/*6.59*/("""</a>
<p> Price : """),_display_(/*7.14*/book/*7.18*/.price),format.raw/*7.24*/("""</p>
<p> Author: """),_display_(/*8.14*/book/*8.18*/.author),format.raw/*8.25*/("""</p>
""")))}),format.raw/*9.2*/("""
"""),format.raw/*10.1*/("""<button type="button"><a href=""""),_display_(/*10.33*/routes/*10.39*/.BookController.create()),format.raw/*10.63*/(""""> Add book to library</a></button>

""")))}),format.raw/*12.2*/("""
"""))
      }
    }
  }

  def render(books:Set[BooksModel]): play.twirl.api.HtmlFormat.Appendable = apply(books)

  def f:((Set[BooksModel]) => play.twirl.api.HtmlFormat.Appendable) = (books) => apply(books)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat Nov 04 11:57:30 EAT 2017
                  SOURCE: C:/Users/Mingina/Workspace/laebrari/lib-project/app/views/books/index.scala.html
                  HASH: 9b042d68192db10de6c85ff9173df00764f09e75
                  MATRIX: 963->3|1083->28|1111->31|1138->50|1176->51|1204->53|1251->75|1284->93|1322->94|1350->96|1386->106|1400->112|1449->141|1478->144|1490->148|1516->154|1561->173|1573->177|1599->183|1644->202|1656->206|1683->213|1719->220|1748->222|1807->254|1822->260|1867->284|1937->324
                  LINES: 28->2|33->2|34->3|34->3|34->3|35->4|36->5|36->5|36->5|37->6|37->6|37->6|37->6|37->6|37->6|37->6|38->7|38->7|38->7|39->8|39->8|39->8|40->9|41->10|41->10|41->10|41->10|43->12
                  -- GENERATED --
              */
          
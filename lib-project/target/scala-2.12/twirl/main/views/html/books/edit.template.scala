
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
/*2.2*/import views.html.partials._booksFormFields


Seq[Any](format.raw/*1.31*/("""
"""),_display_(/*3.2*/layout("Edit Books")/*3.22*/{_display_(Seq[Any](format.raw/*3.23*/("""
    """),format.raw/*4.5*/("""<h1> Edit Book</h1>
    """),_display_(/*5.6*/helper/*5.12*/.form(action = routes.BookController.update())/*5.58*/{_display_(Seq[Any](format.raw/*5.59*/("""
        """),_display_(/*6.10*/_booksFormFields(bookForm)),format.raw/*6.36*/("""


"""),format.raw/*9.1*/("""<button class="btn btn-success" type="submit"><i class="glyphicon glyphicon-floppy-saved"></i> Save</button>
   """)))}),format.raw/*10.5*/("""

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
                  DATE: Wed Nov 08 15:08:19 EAT 2017
                  SOURCE: C:/Users/Mingina/Workspace/laebrari/lib-project/app/views/books/edit.scala.html
                  HASH: d6b382884eb1fa895fe4eddf19f3d9bc3d94e0bf
                  MATRIX: 963->1|1065->33|1138->30|1166->79|1194->99|1232->100|1264->106|1315->132|1329->138|1383->184|1421->185|1458->196|1504->222|1536->228|1680->342|1715->347
                  LINES: 28->1|31->2|34->1|35->3|35->3|35->3|36->4|37->5|37->5|37->5|37->5|38->6|38->6|41->9|42->10|44->12
                  -- GENERATED --
              */
          
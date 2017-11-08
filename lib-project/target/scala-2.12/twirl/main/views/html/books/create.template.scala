
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
/*2.2*/import views.html.partials._booksFormFields


Seq[Any](format.raw/*1.31*/("""
"""),format.raw/*3.1*/("""
"""),_display_(/*4.2*/layout("Create Book")/*4.23*/{_display_(Seq[Any](format.raw/*4.24*/("""
"""),format.raw/*5.1*/("""<h1> Add Book to library</h1>
"""),_display_(/*6.2*/helper/*6.8*/.form(action = routes.BookController.save())/*6.52*/{_display_(Seq[Any](format.raw/*6.53*/("""

"""),_display_(/*8.2*/_booksFormFields(bookForm)),format.raw/*8.28*/("""

"""),format.raw/*10.1*/("""<button class="btn btn-primary" type="submit"><i class="glyphicon glyphicon-plus"> </i> Add to Library</button>

""")))}),format.raw/*12.2*/("""

""")))}),format.raw/*14.2*/("""
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
                  DATE: Wed Nov 08 15:12:40 EAT 2017
                  SOURCE: C:/Users/Mingina/Workspace/laebrari/lib-project/app/views/books/create.scala.html
                  HASH: 7b82a1b9372e4f6da0fa2a685e56729c0f34f362
                  MATRIX: 965->1|1067->33|1140->30|1168->78|1196->81|1225->102|1263->103|1291->105|1348->137|1361->143|1413->187|1451->188|1481->193|1527->219|1558->223|1704->339|1739->344
                  LINES: 28->1|31->2|34->1|35->3|36->4|36->4|36->4|37->5|38->6|38->6|38->6|38->6|40->8|40->8|42->10|44->12|46->14
                  -- GENERATED --
              */
          

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
    """),_display_(/*5.6*/helper/*5.12*/.form(action = routes.BookController.update(), 'id->"bookUpdateForm")/*5.81*/{_display_(Seq[Any](format.raw/*5.82*/("""
        """),_display_(/*6.10*/_booksFormFields(bookForm)),format.raw/*6.36*/("""
   """)))}),format.raw/*7.5*/("""
"""),format.raw/*8.1*/("""<button class="btn btn-success" onclick="sendPutRequest(
    'bookUpdateForm',
    '"""),_display_(/*10.7*/routes/*10.13*/.BookController.index()),format.raw/*10.36*/("""')"><i class="glyphicon glyphicon-floppy"></i> Save</button>

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
                  DATE: Sat Nov 11 16:01:20 EAT 2017
                  SOURCE: C:/Users/Mingina/Workspace/laebrari/lib-project/app/views/books/edit.scala.html
                  HASH: cbb66fdd7b47eb508cc690ed58ff8d855533b73a
                  MATRIX: 963->1|1065->33|1138->30|1166->79|1194->99|1232->100|1264->106|1315->132|1329->138|1406->207|1444->208|1481->219|1527->245|1562->251|1590->253|1703->340|1718->346|1762->369|1857->434
                  LINES: 28->1|31->2|34->1|35->3|35->3|35->3|36->4|37->5|37->5|37->5|37->5|38->6|38->6|39->7|40->8|42->10|42->10|42->10|44->12
                  -- GENERATED --
              */
          
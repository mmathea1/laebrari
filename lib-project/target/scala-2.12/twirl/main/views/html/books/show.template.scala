
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

object show extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[BooksModel,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(book: BooksModel):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.20*/("""
"""),_display_(/*3.2*/layout("Edit " + book.title)/*3.30*/{_display_(Seq[Any](format.raw/*3.31*/("""

"""),format.raw/*5.1*/("""<h1> """),_display_(/*5.7*/book/*5.11*/.title),format.raw/*5.17*/("""</h1>
<p> Price : """),_display_(/*6.14*/book/*6.18*/.price),format.raw/*6.24*/("""</p>
<p> Author: """),_display_(/*7.14*/book/*7.18*/.author),format.raw/*7.25*/("""</p>


<button type="button"><a href=""""),_display_(/*10.33*/routes/*10.39*/.BookController.edit(book.id)),format.raw/*10.68*/("""">Edit Book</a></button>
<button type="button"><a href=""""),_display_(/*11.33*/routes/*11.39*/.BookController.destroy(book.id)),format.raw/*11.71*/("""">Delete Book</a></button>
""")))}),format.raw/*12.2*/("""

"""))
      }
    }
  }

  def render(book:BooksModel): play.twirl.api.HtmlFormat.Appendable = apply(book)

  def f:((BooksModel) => play.twirl.api.HtmlFormat.Appendable) = (book) => apply(book)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Nov 06 15:33:36 EAT 2017
                  SOURCE: C:/Users/Mingina/Workspace/laebrari/lib-project/app/views/books/show.scala.html
                  HASH: 799d6885dc6125c9eac42872f0d1d812cc201c64
                  MATRIX: 957->3|1070->21|1098->24|1134->52|1172->53|1202->57|1233->63|1245->67|1271->73|1317->93|1329->97|1355->103|1400->122|1412->126|1439->133|1508->175|1523->181|1573->210|1658->268|1673->274|1726->306|1785->335
                  LINES: 28->2|33->2|34->3|34->3|34->3|36->5|36->5|36->5|36->5|37->6|37->6|37->6|38->7|38->7|38->7|41->10|41->10|41->10|42->11|42->11|42->11|43->12
                  -- GENERATED --
              */
          
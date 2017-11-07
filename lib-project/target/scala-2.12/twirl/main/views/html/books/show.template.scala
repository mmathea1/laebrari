
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


<a href=""""),_display_(/*10.11*/routes/*10.17*/.BookController.edit(book.id)),format.raw/*10.46*/("""">Edit Book</a>
<a href=""""),_display_(/*11.11*/routes/*11.17*/.BookController.destroy(book.id)),format.raw/*11.49*/("""">Delete Book</a>
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
                  DATE: Tue Nov 07 21:27:37 EAT 2017
                  SOURCE: C:/Users/Mingina/Workspace/laebrari/lib-project/app/views/books/show.scala.html
                  HASH: 3c081a2b338cd05fd1a688de1bcf1f862c93341d
                  MATRIX: 957->3|1070->21|1098->24|1134->52|1172->53|1202->57|1233->63|1245->67|1271->73|1317->93|1329->97|1355->103|1400->122|1412->126|1439->133|1486->153|1501->159|1551->188|1605->215|1620->221|1673->253|1723->273
                  LINES: 28->2|33->2|34->3|34->3|34->3|36->5|36->5|36->5|36->5|37->6|37->6|37->6|38->7|38->7|38->7|41->10|41->10|41->10|42->11|42->11|42->11|43->12
                  -- GENERATED --
              */
          
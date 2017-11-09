
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


<a class="btn btn-success" href=""""),_display_(/*10.35*/routes/*10.41*/.BookController.edit(book.id)),format.raw/*10.70*/(""""><i class="glyphicon glyphicon-pencil"></i> Edit Book</a>
<a class="btn btn-danger" href=""""),_display_(/*11.34*/routes/*11.40*/.BookController.destroy(book.id)),format.raw/*11.72*/(""""><i class="glyphicon glyphicon-trash"></i> Delete Book</a>
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
                  DATE: Wed Nov 08 14:53:25 EAT 2017
                  SOURCE: C:/Users/Mingina/Workspace/laebrari/lib-project/app/views/books/show.scala.html
                  HASH: 16dc43c23641a04ffc5e095fc44bb982a5fe5425
                  MATRIX: 957->3|1070->21|1098->24|1134->52|1172->53|1202->57|1233->63|1245->67|1271->73|1317->93|1329->97|1355->103|1400->122|1412->126|1439->133|1510->177|1525->183|1575->212|1695->305|1710->311|1763->343|1855->405
                  LINES: 28->2|33->2|34->3|34->3|34->3|36->5|36->5|36->5|36->5|37->6|37->6|37->6|38->7|38->7|38->7|41->10|41->10|41->10|42->11|42->11|42->11|43->12
                  -- GENERATED --
              */
          
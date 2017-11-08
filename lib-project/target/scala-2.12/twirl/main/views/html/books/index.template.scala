
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[BooksModel],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(books : List[BooksModel]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.28*/("""
"""),_display_(/*3.2*/layout("All Books")/*3.21*/{_display_(Seq[Any](format.raw/*3.22*/("""
"""),format.raw/*4.1*/("""<h1> All Books</h1>
"""),_display_(/*5.2*/for(book <- books) yield /*5.20*/{_display_(Seq[Any](format.raw/*5.21*/("""
"""),format.raw/*6.1*/("""<a href=""""),_display_(/*6.11*/routes/*6.17*/.BookController.show(book.id)),format.raw/*6.46*/("""">"""),_display_(/*6.49*/book/*6.53*/.title),format.raw/*6.59*/("""</a>
<p> Price : """),_display_(/*7.14*/book/*7.18*/.price),format.raw/*7.24*/("""</p>
<p> Author: """),_display_(/*8.14*/book/*8.18*/.author),format.raw/*8.25*/("""</p>
""")))}),format.raw/*9.2*/("""

""")))}),format.raw/*11.2*/("""
"""))
      }
    }
  }

  def render(books:List[BooksModel]): play.twirl.api.HtmlFormat.Appendable = apply(books)

  def f:((List[BooksModel]) => play.twirl.api.HtmlFormat.Appendable) = (books) => apply(books)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Nov 08 14:34:48 EAT 2017
                  SOURCE: C:/Users/Mingina/Workspace/laebrari/lib-project/app/views/books/index.scala.html
                  HASH: ca431324af6d48be89a1445f0925634b3f76f1a0
                  MATRIX: 964->3|1085->29|1113->32|1140->51|1178->52|1206->54|1253->76|1286->94|1324->95|1352->97|1388->107|1402->113|1451->142|1480->145|1492->149|1518->155|1563->174|1575->178|1601->184|1646->203|1658->207|1685->214|1721->221|1756->226
                  LINES: 28->2|33->2|34->3|34->3|34->3|35->4|36->5|36->5|36->5|37->6|37->6|37->6|37->6|37->6|37->6|37->6|38->7|38->7|38->7|39->8|39->8|39->8|40->9|42->11
                  -- GENERATED --
              */
          
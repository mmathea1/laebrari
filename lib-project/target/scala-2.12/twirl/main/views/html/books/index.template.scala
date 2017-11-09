
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
"""),format.raw/*4.1*/("""<div class="container">
<h1> All Books</h1>
    <div class="row">


"""),_display_(/*9.2*/for(book <- books) yield /*9.20*/{_display_(Seq[Any](format.raw/*9.21*/("""
 """),format.raw/*10.2*/("""<div class="col-md-6">
     <a href=""""),_display_(/*11.16*/routes/*11.22*/.BookController.show(book.id)),format.raw/*11.51*/("""">"""),_display_(/*11.54*/book/*11.58*/.title),format.raw/*11.64*/("""</a>
     <p> Price : """),_display_(/*12.19*/book/*12.23*/.price),format.raw/*12.29*/("""</p>
     <p> Author: """),_display_(/*13.19*/book/*13.23*/.author),format.raw/*13.30*/("""</p>
 </div>

""")))}),format.raw/*16.2*/("""
    """),format.raw/*17.5*/("""</div>
</div>
""")))}),format.raw/*19.2*/("""
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
                  DATE: Wed Nov 08 20:03:59 EAT 2017
                  SOURCE: C:/Users/Mingina/Workspace/laebrari/lib-project/app/views/books/index.scala.html
                  HASH: c4f2ba783dc0bca894fdc0999e771671c7ee54bf
                  MATRIX: 964->3|1085->29|1113->32|1140->51|1178->52|1206->54|1305->128|1338->146|1376->147|1406->150|1472->189|1487->195|1537->224|1567->227|1580->231|1607->237|1658->261|1671->265|1698->271|1749->295|1762->299|1790->306|1838->324|1871->330|1918->347
                  LINES: 28->2|33->2|34->3|34->3|34->3|35->4|40->9|40->9|40->9|41->10|42->11|42->11|42->11|42->11|42->11|42->11|43->12|43->12|43->12|44->13|44->13|44->13|47->16|48->17|50->19
                  -- GENERATED --
              */
          
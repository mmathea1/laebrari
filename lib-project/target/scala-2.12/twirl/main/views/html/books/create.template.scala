
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

"""),format.raw/*3.1*/("""<head>
    <meta charset="UTF-8">
    <title>Create Books</title>
</head>
<body>
<h1> Add Book to library</h1>
    """),_display_(/*9.6*/helper/*9.12*/.form(action = routes.BookController.create())/*9.58*/{_display_(Seq[Any](format.raw/*9.59*/("""
    """),_display_(/*10.6*/helper/*10.12*/.inputText(bookForm("Title"))),format.raw/*10.41*/("""
    """),_display_(/*11.6*/helper/*11.12*/.inputText(bookForm("Price"))),format.raw/*11.41*/("""
    """),_display_(/*12.6*/helper/*12.12*/.inputText(bookForm("Author"))),format.raw/*12.42*/("""

    """),format.raw/*14.5*/("""<input type="submit" value="Add to Library">

""")))}),format.raw/*16.2*/("""

"""),format.raw/*18.1*/("""</body>"""))
      }
    }
  }

  def render(bookForm:Form[BooksModel]): play.twirl.api.HtmlFormat.Appendable = apply(bookForm)

  def f:((Form[BooksModel]) => play.twirl.api.HtmlFormat.Appendable) = (bookForm) => apply(bookForm)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Nov 03 16:06:03 EAT 2017
                  SOURCE: C:/Users/Mingina/Workspace/laebrari/lib-project/app/views/books/create.scala.html
                  HASH: d9258638d14cd21f1a5b84b64df0f49b512f4964
                  MATRIX: 965->1|1089->30|1119->34|1266->156|1280->162|1334->208|1372->209|1405->216|1420->222|1470->251|1503->258|1518->264|1568->293|1601->300|1616->306|1667->336|1702->344|1781->393|1812->397
                  LINES: 28->1|33->1|35->3|41->9|41->9|41->9|41->9|42->10|42->10|42->10|43->11|43->11|43->11|44->12|44->12|44->12|46->14|48->16|50->18
                  -- GENERATED --
              */
          
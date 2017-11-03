
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
    """),_display_(/*9.6*/helper/*9.12*/.form(action = routes.BookController.save())/*9.56*/{_display_(Seq[Any](format.raw/*9.57*/("""
    """),_display_(/*10.6*/helper/*10.12*/.CSRF.formField),format.raw/*10.27*/("""
    """),_display_(/*11.6*/helper/*11.12*/.inputText(bookForm("Id"))),format.raw/*11.38*/("""
    """),_display_(/*12.6*/helper/*12.12*/.inputText(bookForm("Title"))),format.raw/*12.41*/("""
    """),_display_(/*13.6*/helper/*13.12*/.inputText(bookForm("Price"))),format.raw/*13.41*/("""
    """),_display_(/*14.6*/helper/*14.12*/.inputText(bookForm("Author"))),format.raw/*14.42*/("""

    """),format.raw/*16.5*/("""<input type="submit" value="Add to Library">

""")))}),format.raw/*18.2*/("""

"""),format.raw/*20.1*/("""</body>"""))
      }
    }
  }

  def render(bookForm:Form[BooksModel]): play.twirl.api.HtmlFormat.Appendable = apply(bookForm)

  def f:((Form[BooksModel]) => play.twirl.api.HtmlFormat.Appendable) = (bookForm) => apply(bookForm)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat Nov 04 01:30:25 EAT 2017
                  SOURCE: C:/Users/Mingina/Workspace/laebrari/lib-project/app/views/books/create.scala.html
                  HASH: 7b30de998b4be8abb0bc097ac0af705c0aa720e5
                  MATRIX: 965->1|1089->30|1119->34|1266->156|1280->162|1332->206|1370->207|1403->214|1418->220|1454->235|1487->242|1502->248|1549->274|1582->281|1597->287|1647->316|1680->323|1695->329|1745->358|1778->365|1793->371|1844->401|1879->409|1958->458|1989->462
                  LINES: 28->1|33->1|35->3|41->9|41->9|41->9|41->9|42->10|42->10|42->10|43->11|43->11|43->11|44->12|44->12|44->12|45->13|45->13|45->13|46->14|46->14|46->14|48->16|50->18|52->20
                  -- GENERATED --
              */
          

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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Set[BooksModel],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(books : Set[BooksModel]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.27*/("""
"""),format.raw/*3.1*/("""<head>
    <meta charset="UTF-8">
    <title>All Books</title>
</head>
<body>
<h1> All Books</h1>
"""),_display_(/*9.2*/for(book <- books) yield /*9.20*/{_display_(Seq[Any](format.raw/*9.21*/("""
"""),format.raw/*10.1*/("""<a href=""""),_display_(/*10.11*/routes/*10.17*/.BookController.show(book.id)),format.raw/*10.46*/("""">"""),_display_(/*10.49*/book/*10.53*/.title),format.raw/*10.59*/("""</a>
<p> Price : """),_display_(/*11.14*/book/*11.18*/.price),format.raw/*11.24*/("""</p>
<p> Author: """),_display_(/*12.14*/book/*12.18*/.author),format.raw/*12.25*/("""</p>
""")))}),format.raw/*13.2*/("""
"""),format.raw/*14.1*/("""<button type="button"><a href=""""),_display_(/*14.33*/routes/*14.39*/.BookController.create()),format.raw/*14.63*/(""""> Add book to library</a></button>

</body>

"""))
      }
    }
  }

  def render(books:Set[BooksModel]): play.twirl.api.HtmlFormat.Appendable = apply(books)

  def f:((Set[BooksModel]) => play.twirl.api.HtmlFormat.Appendable) = (books) => apply(books)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat Nov 04 11:01:44 EAT 2017
                  SOURCE: C:/Users/Mingina/Workspace/laebrari/lib-project/app/views/books/index.scala.html
                  HASH: ac6b7d392003fe9299e8b657f1f88017b2e9bd01
                  MATRIX: 963->3|1083->28|1111->30|1241->135|1274->153|1312->154|1341->156|1378->166|1393->172|1443->201|1473->204|1486->208|1513->214|1559->233|1572->237|1599->243|1645->262|1658->266|1686->273|1723->280|1752->282|1811->314|1826->320|1871->344
                  LINES: 28->2|33->2|34->3|40->9|40->9|40->9|41->10|41->10|41->10|41->10|41->10|41->10|41->10|42->11|42->11|42->11|43->12|43->12|43->12|44->13|45->14|45->14|45->14|45->14
                  -- GENERATED --
              */
          
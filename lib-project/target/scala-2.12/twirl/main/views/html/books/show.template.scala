
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
"""),format.raw/*3.1*/("""<head>
    <meta charset="UTF-8">
    <title>Edit """),_display_(/*5.18*/book/*5.22*/.title),format.raw/*5.28*/("""</title>
</head>
<body>
<h1> """),_display_(/*8.7*/book/*8.11*/.title),format.raw/*8.17*/("""</h1>
    <p> Price : """),_display_(/*9.18*/book/*9.22*/.price),format.raw/*9.28*/("""</p>
    <p> Author: """),_display_(/*10.18*/book/*10.22*/.author),format.raw/*10.29*/("""</p>
</body>

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
                  DATE: Sat Nov 04 02:44:18 EAT 2017
                  SOURCE: C:/Users/Mingina/Workspace/laebrari/lib-project/app/views/books/show.scala.html
                  HASH: 517d775ab31d1a6b9d9393725808f019e1655944
                  MATRIX: 957->3|1070->21|1098->23|1177->76|1189->80|1215->86|1273->119|1285->123|1311->129|1361->153|1373->157|1399->163|1449->186|1462->190|1490->197
                  LINES: 28->2|33->2|34->3|36->5|36->5|36->5|39->8|39->8|39->8|40->9|40->9|40->9|41->10|41->10|41->10
                  -- GENERATED --
              */
          
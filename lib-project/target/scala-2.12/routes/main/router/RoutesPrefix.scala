
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Mingina/Workspace/laebrari/lib-project/conf/routes
// @DATE:Sat Sep 09 23:50:25 EAT 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}

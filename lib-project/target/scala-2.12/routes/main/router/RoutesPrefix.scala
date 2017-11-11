
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Mingina/Workspace/laebrari/lib-project/conf/routes
// @DATE:Sat Nov 11 17:48:04 EAT 2017


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

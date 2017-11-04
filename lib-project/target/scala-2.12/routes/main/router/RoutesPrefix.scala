
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Mingina/Workspace/laebrari/lib-project/conf/routes
<<<<<<< HEAD
// @DATE:Sat Nov 04 01:02:00 EAT 2017
=======
// @DATE:Sat Nov 04 18:05:01 EAT 2017
>>>>>>> 2195fdf... update model and make CRUD operations


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

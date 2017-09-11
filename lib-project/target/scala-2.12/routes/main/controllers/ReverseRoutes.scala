
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Mingina/Workspace/laebrari/lib-project/conf/routes
// @DATE:Mon Sep 11 14:33:39 EAT 2017

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:11
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def versioned(file:Asset): Call = {
      implicit val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:7
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def userPost(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "user")
    }
  
    // @LINE:7
    def userGet(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "user")
    }
  
  }


}

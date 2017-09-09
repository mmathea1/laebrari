
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Mingina/Workspace/laebrari/lib-project/conf/routes
// @DATE:Sat Sep 09 23:50:25 EAT 2017

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseUseruserController UseruserController = new controllers.ReverseUseruserController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseUseruserController UseruserController = new controllers.javascript.ReverseUseruserController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}

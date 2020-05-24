/**
 * http://usejsdoc.org/
 */
 angular.module('myApp.services', []).factory('Loginservice',["$http",function($http){  
			   
		      Loginservice=function(UserData) {  			
				var url = "http://local:8080/api/v1/userinfo/" ;
								
				if(UserData.username=="bill" && UserData.Password=="gqrlt123")
					console.log("true");
				else
					console.log("false");
				console.log($http.get(url));
				
		   }
        
        }
		
		]);
          
   
  
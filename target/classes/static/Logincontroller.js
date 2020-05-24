/**
 * http://usejsdoc.org/
 */
var module = angular.module('myApp.controllers', []);
module.controller("Logincontroller", [ "$scope","$http","$window",
	function($scope,$http,$window){  
	var UserData = {  
            username: null,  
            Password: null
        };
	$scope.message = 'Login:';
	
    $scope.submit = function() {          
        console.log("the value of the variable.");
        console.log($scope.UserData.username);
        
		if($scope.UserData.username=="bgao" && $scope.UserData.Password=="gqrlt123")
			console.log("true");
		else
			console.log("false");
			
		
		var url = "/api/userinfo/username="+$scope.UserData.username;
		var promise = $http.get(url).then(function(response){
			$scope.result = response.data;
			var obj = response.data;
			var user = obj.username;
			var pwd = obj.password;
			if(user==$scope.UserData.username && pwd==$scope.UserData.Password){
				$scope.authentication = "welcome "+$scope.UserData.username;
				/*$window.location.href = '/processMatch.html';*/
				/*$location.path();
				console.log($location.path());	*/			
				$window.location.href = '/processMatch.html';
				
			}
			else{
				$scope.UserData.username=null;
				$scope.UserData.Password=null;
				$scope.authentication = "wrong username or password!";
			}
		});
        //promise.success(onSuccess);
        //promise.error(onError);
		console.log(promise);
		        
        //Loginservice(UserData);
        
    }  
  
}]);
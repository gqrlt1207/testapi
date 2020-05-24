/**
 * http://usejsdoc.org/
 */
angular.
  module('myApp',['myApp.controllers','myApp.services']).
  config(['$routeProvider',
    function config($routeProvider) {
      $routeProvider.
        when('/', {
          template: '/ticket.html'
        }).
        when('/processMatch', {
          template: 'processMatch.html'
        }).
        otherwise('/');
    }
  ]);
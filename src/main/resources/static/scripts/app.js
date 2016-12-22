/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


angular.module('aplikasiDataBarang',['ngRoute'])
        .config(function ($routeProvider){
            $routeProvider
                .when('/',{
                    'templateUrl': 'views/home.html',
                    'controller': 'barangController'
            });
});
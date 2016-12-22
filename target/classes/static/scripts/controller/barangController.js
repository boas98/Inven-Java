/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


angular.module('aplikasiDataBarang')
        .controller('barangController',function($scope,barangService){
            $scope.tampilkanData = function(){
                barangService.getBarangFromDb().success(function (data){
                  $scope.dataServer = data.content;  
                })
            };
            
            $scope.isDataEdit = false;
            $scope.currentBarang = {};
            $scope.simpanData = function(data){
                if ($scope.isDataEdit==true){
                    barangService.update(data.id,data).success(function(data){
                        alert("data berhasil dirubah");
                        $scope.clearData();
                    }).error(function(){
                        alert("terjadi kesalahan dalam edit data");
                    })
                }
                else{
                    barangService.save(data).success(function(data){
                        alert("data berhasil disimpan");
                        $scope.clearData();
                    }).error(function(){
                        alert("terjadi kesalahan dalam penyimpanan data");
                    })
                }
            }
            
            $scope.hapusData = function(id){
                barangService.delete(id).success(function(data){
                    alert("data berhasil dihapus");
                    $scope.clearData();
                }).error(function(){
                    alert("terjadi kesalahan dalam penghapusan data");
                    $scope.clearData();
                })
            }
            
            $scope.editData = function(data){
                $scope.isDataEdit = true;
                $scope.currentBarang = {};
                $scope.currentBarang.namaBarang = data.namaBarang;
                $scope.currentBarang.stokBarang = data.stokBarang;
                $scope.currentBarang.id = data.id;
            }
            
            $scope.clearData = function(){
                $scope.isDataEdit = false;
                $scope.currentBarang = {};
                $scope.reloadData();
            }
            
            $scope.reloadData = function(){
                barangService.getBarangFromDb().success(function(data){
                    $scope.dataServer = data.content;
                })
            }
});
// mainApp é uma variavel global no arquivo mainApp.js
mainApp.factory('LaunchService', [ '$http', function($http) {

	/**
	 * APP_NAME = é uma variavel global inicializada em mainApp.js
	 */
	var rootUrlBank = APP_NAME + '/api/launch';
	
	var _postLaunch = function( launch ){
		return $http.post( rootUrlBank, launch );
	}	
	
	var _findAll = function(){
		return $http.get( rootUrlBank );
	}
	
	var _deleteLaunch = function( id ){
		return $http.get( rootUrlBank + "/delete/" + id );
	}
	
	var _findLaunch = function( id ){
		return $http.get( rootUrlBank + "/" + id );
	}
	
	var _payLaunch = function( id ){
		return $http.get( rootUrlBank + "/pay/" + id );
	}
	
	return {
		postLaunch  : _postLaunch,
		findAll     : _findAll,
		deleteLaunch: _deleteLaunch,
		findLaunch  : _findLaunch,
		payLaunch   : _payLaunch
	};	

}]);
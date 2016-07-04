// mainApp é uma variavel global no arquivo mainApp.js
mainApp.factory('LaunchService', [ '$http', function($http) {

	/**
	 * APP_NAME = é uma variavel global inicializada em mainApp.js
	 */
	var rootUrlBank = APP_NAME + '/api/launch';
	
	var _postLaunch = function( launch ){
		return $http.post( rootUrlBank, launch );
	}	
	
	return {
		postLaunch  : _postLaunch
	};	

}]);
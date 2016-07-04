// mainApp é uma variavel global no arquivo mainApp.js
mainApp.controller('BankController', ['BankService', function(BankService){
	
	var self = this;
	self.init = function(){
		
	};
	
	self.listAll = [];
	
	self.populateBanks = function(){
		VeiculoService.findAll( ).then(function(response){
			self.listAll = response.data;
		});
	}
	
	self.init();
	
}]);
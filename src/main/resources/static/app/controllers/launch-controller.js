// mainApp é uma variavel global no arquivo mainApp.js
mainApp.controller('LaunchController', ['BankService', 'LaunchService', function(BankService, LaunchService){
	
	var self = this;
	self.init = function(){
		self.populateBanks();
	};
	
	self.listBanks = [];
	self.bankSelected = null;
	self.launch = {
			id: null, 
			description: '', 
			date: null,
			amount: 0,
			paid: false
	};
		
	self.populateBanks = function(){
		console.log( 'populateBanks()...' );
		BankService.findAll().then(function(response){
			self.listBanks = response.data;
			//self.bankSelected = self.listBanks[0];
		});
	}
	
	self.postLaunch = function(){
		console.log( 'postLaunch()...' );
		var launchResponse = LaunchService.postLaunch( self.launch ).success(function(launchSaved){
			self.launch = launchSaved;
			console.log( self.launch );
			sweetAlert("OK", "Lançamento salvo com sucesso!", "success");
		}).error(function(data, status) {
			console.log( status );
			console.log( data.message );
			sweetAlert("ERRO", data.message, "error");
        });
	}
	
	self.init();
	
}]);
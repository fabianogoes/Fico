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
	
	self.bank = {
			id: null, 
			code: '',
			name: '' 
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
	
	self.createBank = function(){
		console.log( 'createBank()...' );
		console.log( self.bank )
		var bankResponse = BankService.createBank( self.bank ).success(function(bankSaved){
			self.bankSelected = bankSaved;
			console.log( self.bankSelected );
			sweetAlert("OK", "Banco["+bankSaved.name+"] salvo com sucesso!", "success");
			return bankSaved;
		}).success(function(bankSaved){
			console.log( 'createBank() - encadeamento...' );
			console.log( bankSaved );
			self.populateBanks();
			self.bankSelected = bankSaved;
			$('#modalBank').modal('hide');
		}).error(function(data, status) {
			console.log( status );
			console.log( data.message );
			sweetAlert("ERRO", data.message, "error");
        });
	}	
	
	self.init();
	
}]);
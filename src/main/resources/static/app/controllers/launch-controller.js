// mainApp é uma variavel global no arquivo mainApp.js
mainApp.controller('LaunchController', ['BankService', 'LaunchService', function(BankService, LaunchService){
	
	var self = this;
	self.init = function(){
		self.resetLaunch();
		self.resetBank();
		self.listAllLaunch();
		self.populateBanks();
		self.bankSelected = self.listBanks[0];
	};
	
	self.listAll = [];
	self.listBanks = [];
	self.bankSelected = null;
	
	self.bank = {
			id: null, 
			code: '',
			name: '' 
	};
	
	self.launch = {
			id: null, 
			description: '', 
			date: null,
			amount: 0,
			paid: false,
			bank: self.bank 
	};
	
	self.resetLaunch = function(){
		self.launch.id = null;
		self.launch.description = '';
		self.launch.date = null;
		self.launch.amount = 0;
		self.launch.paid = false;
	}
	
	self.resetBank = function(){
		self.bank.id = null;
		self.bank.code = '';
		self.bank.name = ''; 
	}
	
	self.listAllLaunch = function(){
		console.log( 'listAllLaunch()...' );
		LaunchService.findAll().then(function(response){
			self.listAll = response.data;
		});
	}
		
	self.populateBanks = function(){
		console.log( 'populateBanks()...' );
		BankService.findAll().then(function(response){
			self.listBanks = response.data;
		});
	}
	
	self.postLaunch = function(){
		console.log( 'postLaunch( )...' );
		self.launch.bank = self.bankSelected;
		console.log( self.launch );
		var launchResponse = LaunchService.postLaunch( self.launch ).success(function(launchSaved){
			self.launch = launchSaved;
			console.log( self.launch );			
			$('#modalLaunch').modal('hide');
			sweetAlert("OK", "Lançamento salvo com sucesso!", "success");
			return launchSaved;
		}).success(function(bankSaved){
			console.log( 'postLaunch() - encadeamento...' );
			self.listAllLaunch();
			self.resetLaunch();
			self.populateBanks();
			self.bankSelected = self.listBanks[0];
		}).error(function(data, status) {
			console.log( status );
			console.log( data.message );
			sweetAlert("ERRO", data.message, "error");
        });
	}
	
	self.editLaunch = function( id ){
		console.log( 'editLaunch( '+id+' )...' );
		var launchResponse = LaunchService.findLaunch( id ).success(function(launchFind){
			console.log( launchFind );
			self.launch = launchFind;
			self.showLaunchFormModal();
		}).error(function(data, status) {
			console.log( status );
			console.log( data.message );
			sweetAlert("ERRO", data.message, "error");
        });		
	}
	
	self.deleteLaunch = function( id ){
		console.log( 'deleteLaunch( '+id+' )...' );
		var launchResponse = LaunchService.deleteLaunch( id ).success(function(response){
			console.log( response );			
			sweetAlert("OK", "Lançamento Deletado com sucesso!", "success");
			return response;
		}).success(function(bankSaved){
			console.log( 'deleteLaunch() - encadeamento...' );
			self.listAllLaunch();
			self.resetLaunch();
			self.populateBanks();
			self.bankSelected = self.listBanks[0];
		}).error(function(data, status) {
			console.log( status );
			console.log( data.message );
			sweetAlert("ERRO", data.message, "error");
        });
	}	
	
	self.payLaunch = function( id ){
		console.log( 'payLaunch( '+id+' )...' );
		var launchResponse = LaunchService.payLaunch( id ).success(function(response){
			console.log( response );			
			sweetAlert("OK", "Lançamento Pago com sucesso!", "success");
			return response;
		}).success(function(bankSaved){
			console.log( 'payLaunch() - encadeamento...' );
			self.listAllLaunch();
			self.resetLaunch();
			self.populateBanks();
			self.bankSelected = self.listBanks[0];
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
			self.resetBank();
			self.populateBanks();
			self.bankSelected = bankSaved;
			self.hideBankModal();
		}).error(function(data, status) {
			console.log( status );
			console.log( data.message );
			sweetAlert("ERRO", data.message, "error");
        });
	}	
	
	self.showLaunchFormModal = function(){
		$('#modalLaunch').modal('show');
		$('#modalBank').modal('hide');
	}
	
	self.hideLaunchFormModal = function(){
		$('#modalLaunch').modal('hide');
		$('#modalBank').modal('hide');
	}
	
	self.showBankModal = function(){
		$('#modalLaunch').modal('hide');
		$('#modalBank').modal('show');
	}
	
	self.hideBankModal = function(){
		$('#modalLaunch').modal('show');
		$('#modalBank').modal('hide');
	}
	
	self.init();
	
}]);
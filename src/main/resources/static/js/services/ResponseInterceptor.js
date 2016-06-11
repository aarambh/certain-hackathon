'use strict';

app.services
	.factory('httpInterceptor', function($q, $rootScope, toaster) { 
		return {
		    // optional method
		    'request': function(config) {
		      return config;
		    },

		    // optional method
		   'requestError': function(rejection) {
		      $q.reject(response);
		    },



		    // optional method
		    'response': function(response) {
		    	
		    	if (response.config.method.toUpperCase() != 'GET' && response.config.url != '/login') {

	                response.success = response.data.success === undefined ? true : response.data.success;

	                if(!response.success) { // handle error indicated by success:false
	                    // var message = response.data.message || i18nAdapter.translate('common.statusMessages.errors.unknown.default');
	                    // app.common.statusMessages.showError(message);
	                } else {
	                	toaster.pop({
	             		   type: 'success',
	                        title: 'Success!',
	                        body: 'Completed Successfully',
	                        timeout: 1500
	             	   });
	                }

	            }
		    	return response;
		    },

		    // optional method
		   'responseError': function(response) {
			   switch (response.status) {
               case 400:
            	   var message = '';
            	   if (response.data.errors !== undefined ) {
                   		message = response.data.errors.join("<br/>");
                   }
            	   toaster.pop({
            		   type: 'error',
                       title: 'Error!',
                       body: message,
                       timeout: 3000 
            	   });
            	   break;
               case 401:
            	   toaster.pop({
	        		   type: 'error',
	                   title: 'Error!',
	                   body: response.data.message
	        	   });
            	   break;
               case 403:
            	   toaster.pop({
            		   type: 'error',
                       title: 'Error!',
                       body: 'Access Denied',
                       timeout: 3000 
            	   });
                   break;
               default:
            	   var message = '';
	        	   if (response.data.errors !== undefined ) {
	               		message = response.data.errors.join("<br/>");
	               }
	        	   toaster.pop({
	        		   type: 'error',
	                   title: 'Error!',
	                   body: message,
	                   timeout: 4000 
	        	   });
	           }
	           return $q.reject(response);
		    }
		  };
	});
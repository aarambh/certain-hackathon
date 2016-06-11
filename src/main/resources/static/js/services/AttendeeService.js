'use strict';

app.services
	.factory('AttendeeService', function($resource) { 
		return $resource('/attendee/:id', { id: '@id' }, {
			
		});
	});
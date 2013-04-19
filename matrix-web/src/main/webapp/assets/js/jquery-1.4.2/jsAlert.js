(function() {
	// override window alert function
    window.alert = function(html) {
    	jAlert(html);
    };
})();
var update = (function() {
    var updateId = "1.0"
    var updateNeeded = false;
    var pollingController = (function() {
        return{
            //This requests data from the server until it gets an update. If it does, it alerts the user.
             startLongPolling: function(lang) {

                        var requestData = {
                        "Id" : updateId
                        };
                        requestData[_csrf_param_name] = _csrf_token; // Adds the token


                        $.ajax({
                            type: "POST",
                            cache: false,
                            url: "updateId",
                            data: requestData,
                            dataType: "html",
                            success: function(response) {
                                //alert("Success! response: " + response)
                                if(lang == 'et'){
                                    alert("Veebilehte on uuendatud! "); // + updateId + "!=" + response);
                                }
                                else{
                                    alert("The website has been updated! "); // + updateId + "!=" + response);
                                    //alert(lang)
                                }

                                updateId = response;
                                //if(response != null && response !="" && response !="null")
                                //    $("#success").html(response);
                            },
                            error: function(e) {
                                //console.log(e);
                                pollingController.startLongPolling(lang);
                                //alert('Error: ' + e);
                            },

                            complete: function(e) {
                                //console.log("Complete!");
                            }
                        });
                    }
        };

    })();

return{

    //This requests the UpdateID from UpdateController and sets it in the script.
    //Then the program will continuously check whether UpdateController also thinks it's still the same.
    updateId: function(lang){
            var requestData = {
            "Id" : updateId
            };
            requestData[_csrf_param_name] = _csrf_token; // Adds the token


            $.ajax({
                type: "POST",
                cache: false,
                url: "updateId",
                data: requestData,
                dataType: "html",
                success: function(response) {
                    updateId = response;
                    //alert("Success! Response: " + response);

                    //alert("updated id: " + updateId);


                    pollingController.startLongPolling(lang);
		            //update.askUpdate();

                    //if(response != null && response !="" && response !="null")
                    //    $("#success").html(response);
                },
                error: function(e) {
                    pollingController.startLongPolling(lang);
                    console.log(e);
                },

                complete: function(e) {
                    //console.log("Complete!");
                }
            });



    },


    //Checks if there is an update by long-polling

//    askUpdate: function(){
//        pollingController.startLongPolling();


    //alert(pollingController.startLongPolling());


    //return updateNeeded
    //}

}

})();
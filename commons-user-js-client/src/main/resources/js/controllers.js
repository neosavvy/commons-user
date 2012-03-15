function HelloWorldCtrl($xhr) {

    this.hello = "Hello Adam";

    var self = this;

    $xhr('GET', '/commons-user-webapp/users/users/',
        function(code, response) {
            self.response = response;
            self.code = code;
            self.message = "Success was awesome!";
        },
        function(code, response) {
            self.response = response;
            self.code = code;
            self.message = "Error occurred";
        }

    );

}
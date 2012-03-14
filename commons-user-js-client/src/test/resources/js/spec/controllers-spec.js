describe('HelloWorld controllers', function() {

    describe('HelloWorldCtrl', function() {

        it('should create "hello" model with value "Hello Adam"', function() {
            var ctrl = new HelloWorldCtrl();
            expect(ctrl.hello).toBe("Hello Adam");
        });

    });
});
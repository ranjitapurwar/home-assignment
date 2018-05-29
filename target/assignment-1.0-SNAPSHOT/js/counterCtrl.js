app.controller("counterController", function($scope, $log,  $http) {

    $scope.currentCount = 0;

    $scope.getNextCount = function(){
            $http({
                method: 'GET',
                url: 'rest/increment/' + $scope.currentCount
            }).then(function (response) {
                $log.info("Got next count: " + response.data);
                $scope.nextCount = response.data;
            }, function () {
                $log.error("Failed to get next count : Call to API failed");
            });
    }

    $scope.confirm = function(){
        $('.modal').modal('hide');
        $scope.currentCount = $scope.nextCount;
    }

});

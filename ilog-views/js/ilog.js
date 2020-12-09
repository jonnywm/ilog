var app = angular.module('ilog', []);


app.controller('formUser', function ($scope, $http) {

    $scope.addUser = function () {
        $scope.newUser = { nome: $scope.nome, endereco: $scope.endereco };
        $http.post('http://localhost:9999/users/create', $scope.newUser).
            then(function (data, status) {
                location.reload();
            });
    };
});


app.controller('getUsers', function ($scope, $http) {
    getUsers($scope, $http);
});



function getUsers($scope, $http) {
    $http.get('http://localhost:9999/users/').
        then(function (response) {
            $scope.users = response.data;
            console.log($scope.users);
        });
}
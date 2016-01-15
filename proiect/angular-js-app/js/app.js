var app = angular.module('blog', []);

app.controller('HomeController', ['$scope', '$http', function($scope, $http) {
  $scope.helloWorld = 'Aplicatii Web cu suport Java!';

  $scope.actors = [];
  $scope.keys = [];

  $scope.actor = {};
  $scope.editActor = {};




  $http.get('http://localhost:8080/actor').then(
    function successCallback(response) {

    $scope.actors = response;
    $scope.keys = Object.keys(response.data[0]);
  });


  $scope.addActor = function(actor) {
    $scope.actors.data.push(actor);
    $http.post('http://localhost:8080/actor', actor);
    $scope.actor = {};


  };


  $scope.openActor = function(actor) {
    alert("This is " + actor.name + "and he played in " + actor.movie );
  };


  $scope.setUpdateActor = function(actor) {
    $scope.editActor = actor;
  };

  $scope.updateActor = function() {
    $http.put('http://localhost:8080/actor/name/movie', $scope.editActor);
    $scope.editActor = {};
  };

  $scope.deleteActor = function(name) {
    $http.delete('http://localhost:8080/actor' + actor.name)
    .then(
      function successCallback(response) {
        /* code goes here */
      },
      function errorCallback(response) {
        angular.element('[data-id=' + name + ']').remove();
    });
  };

  $scope.myArray = ['Elem 1', 'Elem 2', 'Elem 3', 'Elem 4'];  
   }]);



//resursa2
  app.controller('PController', ['$scope', '$http', function($scope, $http) {
    $scope.parties = [];
    $scope.keys = [];

    $scope.party = {};
    $scope.editParty = {};



    $http.get('http://localhost:8080/party').then(
    function successCallback(response) {

    $scope.parties = response;
    $scope.keys = Object.keys(response.data[0]);
  });


  $scope.addParty = function(party) {
    $scope.parties.data.push(party);
    $http.post('http://localhost:8080/party', party);
    $scope.party= {};


  };


  $scope.openParty = function(party) {
    alert("This is the party with the theme " + party.theme );
  };


  $scope.setUpdateParty = function(party) {
    $scope.editParty = party;
  };

  $scope.updateParty = function() {
    $http.put('http://localhost:8080/party/id/nr_guests', $scope.editParty);
    $scope.editParty = {};
  };

  $scope.deleteParty = function(id) {
    $http.delete('http://localhost:8080/party' + party.id)
    .then(
      function successCallback(response) {
        /* code goes here */
      },
      function errorCallback(response) {
        angular.element('[data-id=' + id + ']').remove();
    });
  };

  $scope.myArray = ['Elem 1', 'Elem 2', 'Elem 3', 'Elem 4'];}
  ]);


//resursa3
app.controller('PPController', ['$scope', '$http', function($scope, $http) {
    $scope.products = [];
    $scope.keys = [];

    $scope.product = {};
    $scope.editProduct = {};



    $http.get('http://localhost:8080/product').then(
    function successCallback(response) {

    $scope.products = response;
    $scope.keys = Object.keys(response.data[0]);
  });


  $scope.addProduct = function(product) {
    $scope.products.data.push(product);
    $http.post('http://localhost:8080/party', product);
    $scope.product= {};


  };


  $scope.openProduct = function(product) {
    alert(product.name  + " " +  product.price + "RON");
  };


  $scope.setUpdateProduct = function(product) {
    $scope.editProduct = product;
  };

  $scope.updateProduct = function() {
    $http.put('http://localhost:8080/party/id/nr_guests', $scope.editProduct());
    $scope.editProduct= {};
  };

  $scope.deleteProduct = function(id) {
    $http.delete('http://localhost:8080/product' + product.id)
    .then(
      function successCallback(response) {
        /* code goes here */
      },
      function errorCallback(response) {
        angular.element('[data-id=' + id + ']').remove();
    });
  };

  $scope.myArray = ['Elem 1', 'Elem 2', 'Elem 3', 'Elem 4'];}
  ]);
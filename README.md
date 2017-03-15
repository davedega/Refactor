# Refactor

This app make use of the MVC patter applied to an app with Navigation Drawer 
this project has 3 packages


MODEL
  Bussines model
VIEWMODEL
  Interfaces works as intermediator between Fragments (View) and Activities (Controller)
CONTROLLER
  Activities who controls the data flow into model object and updates the view using the interfaces from viewmodel package
VIEW
  Fragments only UI

import markdown
import os
import shelve

# Import the framework
from flask import Flask, g
from flask_restful import Resource, Api, reqparse

# Create an instance of Flask
app = Flask(__name__)

# Create the API
api = Api(app)

class HelloWorld(Resource):
    def get(self):
        return {'message': 'Success', 'data': 'HelloPython !!!'}, 200

api.add_resource(HelloWorld, '/hello')        
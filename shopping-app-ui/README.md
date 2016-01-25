# Steps
## Install npm

You need to get ruby and compass installed in your operating system.. in Mac OSX:

    brew install ruby

    gem install compass

then:

    #to generate node_modules
    npm install
    npm install -g bower
    #to generate bower packages
    bower install
    npm install -g grunt-cli

## Running the application

Run:

    grunt serve


This project is generated with [yo angular generator](https://github.com/yeoman/generator-angular)
version 0.11.1.

## Build & development

Run `grunt` for building and `grunt serve` for preview.

## Testing

Running `grunt test` will run the unit tests with karma.

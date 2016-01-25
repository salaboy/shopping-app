# Steps

## Install npm

You need to get ruby and compass installed in your operating system.. in Mac OSX:

```
brew install ruby
sudo gem install compass
```

then:

```
#to generate node_modules
npm install
sudo npm install -g bower
  
#to generate bower packages
bower install
sudo npm install -g grunt-cli
```

## Troubleshooting the installation

### npm install fails because of permission-related errors

Apparently, this is [a known issue](http://stackoverflow.com/questions/16151018/npm-throws-error-without-sudo).

The solution is to run:

```
sudo chown -R $(whoami) ~/.npm
```

## Running the application

Run:

```
grunt serve
```

This project is generated with [yo angular generator](https://github.com/yeoman/generator-angular)
version 0.11.1.

## Build & development

Run `grunt` for building and `grunt serve` for preview.

## Testing

Running `grunt test` will run the unit tests with karma.

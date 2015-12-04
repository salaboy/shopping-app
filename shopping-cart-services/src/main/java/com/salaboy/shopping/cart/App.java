/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salaboy.shopping.cart;


import com.salaboy.shopping.cart.endpoint.api.ShoppingCartService;
import com.salaboy.shopping.cart.endpoint.config.AuthRESTResponseFilter;
import com.salaboy.shopping.cart.endpoint.exception.BusinessException;
import com.salaboy.shopping.cart.endpoint.exception.HttpStatusExceptionHandler;
import com.salaboy.shopping.cart.endpoint.impl.ShoppingCartServiceImpl;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.jaxrs.JAXRSArchive;
import org.wildfly.swarm.keycloak.Secured;

/**
 *
 * @author salaboy
 */
public class App {

    public static void main(String[] args) throws Exception {
        Container container = new Container();

        container.start();

        JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);
        deployment.setContextRoot("/api");
        deployment.as(Secured.class);
        deployment.addPackage("com.salaboy.shopping.cart.model");
        deployment.addPackages(true, "org.kie.api");
        deployment.addPackages(true, "org.drools");
        deployment.addResource(ShoppingCartService.class);
        deployment.addResource(ShoppingCartServiceImpl.class);
        deployment.addClass(HttpStatusExceptionHandler.class);
        deployment.addClass(BusinessException.class);
        deployment.addClass(AuthRESTResponseFilter.class);
        deployment.addAllDependencies();
        container.deploy(deployment);
    }
}

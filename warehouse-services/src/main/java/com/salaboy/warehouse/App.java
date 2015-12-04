/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salaboy.warehouse;





import com.salaboy.warehouse.endpoint.api.WarehouseItemsService;
import com.salaboy.warehouse.endpoint.config.AuthRESTResponseFilter;
import com.salaboy.warehouse.endpoint.exception.BusinessException;
import com.salaboy.warehouse.endpoint.exception.HttpStatusExceptionHandler;
import com.salaboy.warehouse.endpoint.impl.WarehouseItemsServiceImpl;
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
        deployment.as(Secured.class);
        deployment.setContextRoot("/api");
        deployment.addPackage("com.salaboy.warehouse.model");
        deployment.addResource(WarehouseItemsService.class);
        deployment.addResource(WarehouseItemsServiceImpl.class);
        deployment.addClass(HttpStatusExceptionHandler.class);
        deployment.addClass(BusinessException.class);
        deployment.addClass(AuthRESTResponseFilter.class);
        deployment.addAllDependencies();
        container.deploy(deployment);
    }
}

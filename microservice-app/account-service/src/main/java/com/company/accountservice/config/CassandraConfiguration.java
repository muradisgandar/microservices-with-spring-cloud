package com.company.accountservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    @Value("${spring.cloud.cassandra.username}")
    private String username;

    @Value("${spring.cloud.cassandra.contact.point}")
    private String contactPoint;

    @Value("${spring.cloud.cassandra.port}")
    private Integer port;

    @Value("${spring.cloud.cassandra.password}")
    private String password;

    @Value("${spring.cloud.cassandra.keyspace.name}")
    private String keySpaceName;

    @Override
    protected String getKeyspaceName() {
        return keySpaceName;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    protected String getContactPoints() {
        return contactPoint;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"com.company.accountservice"};
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean clusterFactoryBean = super.cluster();
        clusterFactoryBean.setUsername(username);
        clusterFactoryBean.setPassword(password);
        return clusterFactoryBean;
    }
}

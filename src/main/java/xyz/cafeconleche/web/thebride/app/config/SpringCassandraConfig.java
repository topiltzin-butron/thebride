package xyz.cafeconleche.web.thebride.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@PropertySource(value = "classpath:conf/cassandra/cassandra.properties")
@EnableCassandraRepositories(basePackages = { "xyz.cafeconleche.web.thebride.*" })
public class SpringCassandraConfig extends AbstractCassandraConfiguration {

	@Autowired
	private Environment environment;

	@Override
	protected String getKeyspaceName() {
		return environment.getProperty("cassandra.keyspace");
	}

}

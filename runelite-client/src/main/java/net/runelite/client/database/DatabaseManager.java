package net.runelite.client.database;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import static net.runelite.client.RuneLite.RUNELITE_DIR;
import org.h2.jdbcx.JdbcDataSource;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;

@Singleton
@Slf4j
public class DatabaseManager
{
	private static final String DB_URL = "jdbc:h2:" + RUNELITE_DIR + File.separator + "RunelitePlus;AUTO_SERVER=TRUE";

	//  Database credentials
	private static final String USER = "RLP";
	private static final String PASS = "";

	private Connection connection;

	DatabaseManager()
	{
		System.getProperties().setProperty("org.jooq.no-logo", "true");
	}

	private void connect()
	{
		if (connection != null)
		{
			return;
		}

		JdbcDataSource ds = new JdbcDataSource();
		ds.setURL(DatabaseManager.DB_URL);
		ds.setUser(DatabaseManager.USER);
		ds.setPassword(DatabaseManager.PASS);

		try
		{
			connection = ds.getConnection();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	Connection getConnection()
	{
		connect();

		return connection;
	}

	public DSLContext getDsl()
	{
		Settings settings = new Settings();
		settings.setExecuteLogging(false);

		return  DSL.using(connection, SQLDialect.H2, settings);
	}

	public boolean checkTableExists(String table)
	{
		boolean tableExists = false;

		connect();

		try
		{
			ResultSet rset = connection.getMetaData().getTables(null, null, table.toUpperCase(), null);
			if (rset.next())
			{
				tableExists = true;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return tableExists;
	}
}

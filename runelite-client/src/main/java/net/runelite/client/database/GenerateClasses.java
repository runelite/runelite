package net.runelite.client.database;

import java.sql.Connection;
import org.jooq.codegen.GenerationTool;
import org.jooq.meta.h2.H2Database;
import org.jooq.meta.jaxb.Configuration;
import org.jooq.meta.jaxb.Database;
import org.jooq.meta.jaxb.Generator;
import org.jooq.meta.jaxb.Target;

public class GenerateClasses
{
	public static void main(String... args)
	{
		DatabaseManager databaseManager = new DatabaseManager();

		try (Connection c = databaseManager.getConnection())
		{
			Configuration configuration = new Configuration()
				.withGenerator(new Generator()
					.withDatabase(new Database()
						.withName(H2Database.class.getCanonicalName())
						.withIncludes(".*")
						.withExcludes("")
						.withInputSchema("PUBLIC")
					)
					.withTarget(new Target()
						.withPackageName("net.runelite.client.database.data")
						.withDirectory("runelite-client/src/main/java/net/runelite/client/database/data")
					)
				);

			GenerationTool tool = new GenerationTool();
			tool.setConnection(c);
			tool.run(configuration);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

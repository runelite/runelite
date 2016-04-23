package net.runelite.client;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.maven.repository.internal.MavenRepositorySystemUtils;
import org.eclipse.aether.DefaultRepositorySystemSession;
import org.eclipse.aether.RepositorySystem;
import org.eclipse.aether.RepositorySystemSession;
import org.eclipse.aether.artifact.Artifact;
import org.eclipse.aether.collection.CollectRequest;
import org.eclipse.aether.connector.basic.BasicRepositoryConnectorFactory;
import org.eclipse.aether.graph.Dependency;
import org.eclipse.aether.graph.DependencyFilter;
import org.eclipse.aether.impl.DefaultServiceLocator;
import org.eclipse.aether.repository.LocalRepository;
import org.eclipse.aether.repository.RemoteRepository;
import org.eclipse.aether.repository.RepositoryPolicy;
import org.eclipse.aether.resolution.ArtifactResult;
import org.eclipse.aether.resolution.DependencyRequest;
import org.eclipse.aether.resolution.DependencyResolutionException;
import org.eclipse.aether.spi.connector.RepositoryConnectorFactory;
import org.eclipse.aether.spi.connector.transport.TransporterFactory;
import org.eclipse.aether.transport.http.HttpTransporterFactory;
import org.eclipse.aether.util.artifact.JavaScopes;
import org.eclipse.aether.util.filter.DependencyFilterUtils;

public class ArtifactResolver
{
	private final File repositoryCache;
	private final List<RemoteRepository> repositories = new ArrayList<>();

	public ArtifactResolver(File repositoryCache)
	{
		this.repositoryCache = repositoryCache;
	}

	public List<ArtifactResult> resolveArtifacts(Artifact artifact) throws DependencyResolutionException
	{
		RepositorySystem system = newRepositorySystem();

		RepositorySystemSession session = newRepositorySystemSession(system);

		DependencyFilter classpathFlter = DependencyFilterUtils.classpathFilter(JavaScopes.COMPILE);

		CollectRequest collectRequest = new CollectRequest();
		collectRequest.setRoot(new Dependency(artifact, JavaScopes.COMPILE));
		collectRequest.setRepositories(repositories);

		DependencyRequest dependencyRequest = new DependencyRequest(collectRequest, classpathFlter);

		List<ArtifactResult> results = system.resolveDependencies(session, dependencyRequest).getArtifactResults();
		validate(results);
		return results;
	}

	public DefaultRepositorySystemSession newRepositorySystemSession(RepositorySystem system)
	{
		DefaultRepositorySystemSession session = MavenRepositorySystemUtils.newSession();

		LocalRepository localRepo = new LocalRepository(repositoryCache.getAbsolutePath());
		session.setLocalRepositoryManager(system.newLocalRepositoryManager(session, localRepo));
		session.setUpdatePolicy(RepositoryPolicy.UPDATE_POLICY_ALWAYS); // this causes a refetch of maven-metadata.xml, but not any binaries

		//session.setTransferListener(new ConsoleTransferListener());
		//session.setRepositoryListener(new ConsoleRepositoryListener());
		
		return session;
	}

	public RepositorySystem newRepositorySystem()
	{
		DefaultServiceLocator locator = MavenRepositorySystemUtils.newServiceLocator();
		locator.addService(RepositoryConnectorFactory.class, BasicRepositoryConnectorFactory.class);
		locator.addService(TransporterFactory.class, HttpTransporterFactory.class);

		locator.setErrorHandler(new DefaultServiceLocator.ErrorHandler()
		{
			@Override
			public void serviceCreationFailed(Class<?> type, Class<?> impl, Throwable exception)
			{
				exception.printStackTrace();
			}
		});

		return locator.getService(RepositorySystem.class);
	}

	public void addRepositories()
	{
		repositories.add(this.newCentralRepository());
		repositories.add(this.newRuneliteRepository());
	}

	private RemoteRepository newCentralRepository()
	{
		return new RemoteRepository.Builder("central", "default", "http://central.maven.org/maven2/").build();
	}

	public RemoteRepository newRuneliteRepository()
	{
		return new RemoteRepository.Builder("runelite", "default", "http://repo.runelite.net/").build();
	}

	private void validate(List<ArtifactResult> artifacts)
	{
		for (ArtifactResult ar : artifacts)
		{
			Artifact a = ar.getArtifact();

			if (!a.getGroupId().startsWith("net.runelite"))
				continue;

			if (ar.getRepository() instanceof RemoteRepository && !ar.getRepository().equals(newRuneliteRepository()))
				throw new RuntimeException();
		}
	}
}

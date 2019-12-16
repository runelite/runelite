package net.runelite.mixins;

import com.google.common.hash.Hashing;
import com.google.common.io.ByteStreams;
import com.google.common.io.CharStreams;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.api.overlay.OverlayIndex;
import net.runelite.rs.api.RSAbstractArchive;
import net.runelite.rs.api.RSArchive;
import net.runelite.rs.api.RSClient;
import org.slf4j.Logger;

@Mixin(RSAbstractArchive.class)
public abstract class RSAbstractArchiveMixin implements RSAbstractArchive
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	private boolean overlayOutdated;

	@Inject
	@Override
	public boolean isOverlayOutdated()
	{
		return overlayOutdated;
	}

	@Copy("takeFile")
	abstract byte[] rs$getConfigData(int archiveId, int fileId);

	@Replace("takeFile")
	public byte[] rl$getConfigData(int groupId, int fileId)
	{
		final byte[] rsData = rs$getConfigData(groupId, fileId);
		final int archiveId = ((RSArchive) this).getIndex();

		if (!OverlayIndex.hasOverlay(archiveId, groupId))
		{
			return rsData;
		}

		final Logger log = client.getLogger();
		final String path = String.format("/runelite/%s/%s", archiveId, groupId);

		// rsData will be null if this script didn't exist at first
		if (rsData != null)
		{
			String overlayHash, originalHash;

			try (final InputStream hashIn = getClass().getResourceAsStream(path + ".hash"))
			{
				overlayHash = CharStreams.toString(new InputStreamReader(hashIn));
				originalHash = Hashing.sha256().hashBytes(rsData).toString();
			}
			catch (IOException e)
			{
				log.warn("Missing overlay hash for {}/{}", archiveId, groupId);
				return rsData;
			}

			// Check if hash is correct first, so we don't have to load the overlay file if it doesn't match
			if (!overlayHash.equalsIgnoreCase(originalHash))
			{
				log.warn("Mismatch in overlaid cache archive hash for {}/{}: {} != {}",
					archiveId, groupId, overlayHash, originalHash);
				overlayOutdated = true;
				return rsData;
			}
		}

		try (final InputStream ovlIn = getClass().getResourceAsStream(path))
		{
			return ByteStreams.toByteArray(ovlIn);
		}
		catch (IOException e)
		{
			log.warn("Missing overlay data for {}/{}", archiveId, groupId);
			return rsData;
		}
	}
}

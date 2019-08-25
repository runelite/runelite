package net.runelite.mixins;

import net.runelite.api.overlay.OverlayIndex;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.BaseEncoding;
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
import org.slf4j.Logger;
import net.runelite.rs.api.RSAbstractArchive;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSArchive;

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
	public byte[] rl$getConfigData(int archiveId, int fileId)
	{
		byte[] rsData = rs$getConfigData(archiveId, fileId);
		RSArchive indexData = (RSArchive) this;

		if (!OverlayIndex.hasOverlay(indexData.getIndex(), archiveId))
		{
			return rsData;
		}

		Logger log = client.getLogger();

		InputStream in = getClass().getResourceAsStream("/runelite/" + indexData.getIndex() + "/" + archiveId);
		if (in == null)
		{
			log.warn("Missing overlay data for {}/{}", indexData.getIndex(), archiveId);
			return rsData;
		}

		InputStream in2 = getClass().getResourceAsStream("/runelite/" + indexData.getIndex() + "/" + archiveId + ".hash");
		if (rsData == null)
		{
			if (in2 != null)
			{
				log.warn("Hash file for non existing archive {}/{}", indexData.getIndex(), archiveId);
				return null;
			}

			log.debug("Adding archive {}/{}", indexData.getIndex(), archiveId);

			try
			{
				return ByteStreams.toByteArray(in);
			}
			catch (IOException ex)
			{
				log.warn("error loading archive replacement", ex);
			}

			return null;
		}
		if (in2 == null)
		{
			log.warn("Missing hash file for {}/{}", indexData.getIndex(), archiveId);
			return rsData;
		}

		HashCode rsDataHash = Hashing.sha256().hashBytes(rsData);

		String rsHash = BaseEncoding.base16().encode(rsDataHash.asBytes());

		try
		{
			String replaceHash = CharStreams.toString(new InputStreamReader(in2));

			if (replaceHash.equals(rsHash))
			{
				log.debug("Replacing archive {}/{}",
					indexData.getIndex(), archiveId);
				return ByteStreams.toByteArray(in);
			}

			log.warn("Mismatch in overlaid cache archive hash for {}/{}: {} != {}",
				indexData.getIndex(), archiveId, replaceHash, rsHash);
			overlayOutdated = true;
		}
		catch (IOException ex)
		{
			log.warn("error checking hash", ex);
		}

		return rsData;
	}
}

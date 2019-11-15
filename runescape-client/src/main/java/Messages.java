import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("Messages")
public class Messages {
	@ObfuscatedName("a")
	@Export("Messages_channels")
	static final Map Messages_channels;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Llr;"
	)
	@Export("Messages_hashTable")
	static final IterableNodeHashTable Messages_hashTable;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Ljq;"
	)
	@Export("Messages_queue")
	static final IterableDualNodeQueue Messages_queue;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -34471415
	)
	@Export("Messages_count")
	static int Messages_count;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 93041405
	)
	@Export("graphicsTickTimeIdx")
	static int graphicsTickTimeIdx;

	static {
		Messages_channels = new HashMap();
		Messages_hashTable = new IterableNodeHashTable(1024);
		Messages_queue = new IterableDualNodeQueue();
		Messages_count = 0;
	}
}

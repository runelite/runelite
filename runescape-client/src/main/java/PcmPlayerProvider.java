import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("PcmPlayerProvider")
public interface PcmPlayerProvider {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)Lco;",
      garbageValue = "-49"
   )
   @Export("player")
   PcmPlayer player();
}

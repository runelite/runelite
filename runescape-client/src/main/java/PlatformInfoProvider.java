import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lm")
@Implements("PlatformInfoProvider")
public interface PlatformInfoProvider {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Llb;",
      garbageValue = "-843739713"
   )
   @Export("get")
   PlatformInfo get();
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iz")
@Implements("BuildType")
public class BuildType {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   @Export("RC")
   static final BuildType RC;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   @Export("WIP")
   static final BuildType WIP;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   @Export("LIVE")
   static final BuildType LIVE;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   @Export("BUILD_LIVE")
   static final BuildType BUILD_LIVE;
   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("indexMaps")
   static IndexData indexMaps;
   @ObfuscatedName("e")
   @Export("identifier")
   public final String identifier;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1658668017
   )
   final int field3348;

   static {
      RC = new BuildType("LIVE", 0);
      WIP = new BuildType("BUILDLIVE", 3);
      LIVE = new BuildType("RC", 1);
      BUILD_LIVE = new BuildType("WIP", 2);
   }

   BuildType(String var1, int var2) {
      this.identifier = var1;
      this.field3348 = var2;
   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iz")
@Implements("BuildType")
public class BuildType {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   @Export("RC")
   static final BuildType RC;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   @Export("WIP")
   static final BuildType WIP;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   @Export("LIVE")
   static final BuildType LIVE;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   @Export("BUILD_LIVE")
   static final BuildType BUILD_LIVE;
   @ObfuscatedName("h")
   @Export("identifier")
   public final String identifier;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1434698649
   )
   final int field3358;

   static {
      RC = new BuildType("LIVE", 0);
      WIP = new BuildType("BUILDLIVE", 3);
      LIVE = new BuildType("RC", 1);
      BUILD_LIVE = new BuildType("WIP", 2);
   }

   BuildType(String var1, int var2) {
      this.identifier = var1;
      this.field3358 = var2;
   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
@Implements("BuildType")
public class BuildType {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("RC")
   static final BuildType RC;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("WIP")
   static final BuildType WIP;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("LIVE")
   static final BuildType LIVE;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("BUILD_LIVE")
   static final BuildType BUILD_LIVE;
   @ObfuscatedName("x")
   @Export("identifier")
   public final String identifier;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2019445297
   )
   @Export("ordinal")
   final int ordinal;

   static {
      RC = new BuildType("LIVE", 0);
      WIP = new BuildType("BUILDLIVE", 3);
      LIVE = new BuildType("RC", 1);
      BUILD_LIVE = new BuildType("WIP", 2);
   }

   BuildType(String var1, int var2) {
      this.identifier = var1;
      this.ordinal = var2;
   }
}

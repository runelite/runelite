import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
@Implements("BuildType")
public class BuildType {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("RC")
   public static final BuildType RC;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("WIP")
   public static final BuildType WIP;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("LIVE")
   public static final BuildType LIVE;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("BUILD_LIVE")
   public static final BuildType BUILD_LIVE;
   @ObfuscatedName("n")
   @Export("identifier")
   public final String identifier;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 68129071
   )
   public final int field3349;

   static {
      RC = new BuildType("LIVE", 0);
      WIP = new BuildType("BUILDLIVE", 3);
      LIVE = new BuildType("RC", 1);
      BUILD_LIVE = new BuildType("WIP", 2);
   }

   BuildType(String var1, int var2) {
      this.identifier = var1;
      this.field3349 = var2;
   }
}

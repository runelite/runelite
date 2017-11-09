import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
@Implements("BuildType")
public class BuildType {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("RC")
   static final BuildType RC;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("WIP")
   static final BuildType WIP;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("LIVE")
   static final BuildType LIVE;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("BUILD_LIVE")
   static final BuildType BUILD_LIVE;
   @ObfuscatedName("e")
   static int[] field3245;
   @ObfuscatedName("el")
   @ObfuscatedSignature(
      signature = "Les;"
   )
   static class148 field3253;
   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "[Lko;"
   )
   @Export("mapscene")
   static IndexedSprite[] mapscene;
   @ObfuscatedName("v")
   @Export("identifier")
   public final String identifier;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1270254443
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

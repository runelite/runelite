import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
public class class141 {
   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   @Export("mapedge")
   static SpritePixels mapedge;
   @ObfuscatedName("fe")
   @Export("mapRegions")
   @Hook("mapRegionsChanged")
   static int[] mapRegions;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Z",
      garbageValue = "6"
   )
   public static boolean method2889(CharSequence var0) {
      return BaseVarType.method13(var0, 10, true);
   }
}

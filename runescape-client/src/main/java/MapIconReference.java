import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
@Implements("MapIconReference")
public class MapIconReference {
   @ObfuscatedName("h")
   @Export("colorsToFind")
   public static short[] colorsToFind;
   @ObfuscatedName("s")
   @Export("floorMultiplier")
   static int[] floorMultiplier;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -903251761
   )
   @Export("areaId")
   public int areaId;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   public Coordinates field308;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   public Coordinates field309;

   @ObfuscatedSignature(
      signature = "(ILhh;Lhh;)V"
   )
   public MapIconReference(int var1, Coordinates var2, Coordinates var3) {
      this.areaId = var1;
      this.field308 = var2;
      this.field309 = var3;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1097194852"
   )
   static String method687(int var0) {
      return "<img=" + var0 + ">";
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "124"
   )
   public static int method690(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Liv;Ljava/lang/String;Ljava/lang/String;I)[Llc;",
      garbageValue = "-773021704"
   )
   @Export("getSprites")
   public static SpritePixels[] getSprites(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return class69.method1804(var0, var3, var4);
   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1707847485"
   )
   static final void method688() {
      for(PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.getFront(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0.hitpoints == -1) {
            var0.delay = 0;
            class7.method85(var0);
         } else {
            var0.unlink();
         }
      }

   }
}

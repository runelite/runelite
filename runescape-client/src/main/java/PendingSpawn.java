import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
   @ObfuscatedName("l")
   @Export("osName")
   public static String osName;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1952625995
   )
   @Export("level")
   int level;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1753235967
   )
   int field1128;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1722746851
   )
   @Export("type")
   int type;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1827924751
   )
   @Export("x")
   int x;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 285848151
   )
   @Export("y")
   int y;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1664709599
   )
   int field1129;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 689417223
   )
   int field1135;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -390670559
   )
   @Export("id")
   int id;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -885639671
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -162355115
   )
   int field1125;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2074785401
   )
   @Export("delay")
   int delay;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 856103459
   )
   @Export("hitpoints")
   int hitpoints;

   PendingSpawn() {
      this.delay = 0;
      this.hitpoints = -1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1409216932"
   )
   @Export("currentTimeMs")
   public static synchronized long currentTimeMs() {
      long var0 = System.currentTimeMillis();
      if(var0 < class3.currentTimeMsLast) {
         class196.currentTimeMsOffset += class3.currentTimeMsLast - var0;
      }

      class3.currentTimeMsLast = var0;
      return var0 + class196.currentTimeMsOffset;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "-71"
   )
   public static final void method1624(int var0, int var1, int var2, int var3, int var4) {
      class7.boundingBoxes.addFirst(new BoundingBox2D(var0, var1, var2, var3, var4));
   }

   @ObfuscatedName("js")
   @ObfuscatedSignature(
      signature = "(IIIILly;Lik;B)V",
      garbageValue = "1"
   )
   @Export("drawDot")
   static final void drawDot(int var0, int var1, int var2, int var3, SpritePixels var4, class236 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = Graphics3D.SINE[var6];
            int var9 = Graphics3D.COSINE[var6];
            int var10 = var9 * var2 + var3 * var8 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method5937(var10 + var5.field2777 / 2 - var4.maxWidth / 2, var5.field2775 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2777, var5.field2775, var5.field2778, var5.field2779);
            } else {
               var4.drawAt(var0 + var10 + var5.field2777 / 2 - var4.maxWidth / 2, var5.field2775 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }
}

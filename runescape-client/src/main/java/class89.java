import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
public class class89 {
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = -1750108695
   )
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("kn")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   static Widget field1372;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 180469809
   )
   int field1373;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 433874517
   )
   int field1366;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1516077881
   )
   int field1367;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -543424955
   )
   int field1371;
   @ObfuscatedName("e")
   String field1369;

   @ObfuscatedName("js")
   @ObfuscatedSignature(
      signature = "(IIIILji;Lhr;I)V",
      garbageValue = "154813873"
   )
   static final void method1717(int var0, int var1, int var2, int var3, SpritePixels var4, class210 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle & 2047;
         int var8 = Graphics3D.SINE[var7];
         int var9 = Graphics3D.COSINE[var7];
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class134.mapedge.method5081(var0 + var14 + 4 + 94 - 10, var1 + 83 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class35.drawDot(var0, var1, var2, var3, var4, var5);
      }

   }
}

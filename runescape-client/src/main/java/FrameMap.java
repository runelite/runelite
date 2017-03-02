import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 994311845
   )
   int field1452;
   @ObfuscatedName("t")
   int[][] field1454;
   @ObfuscatedName("i")
   int[] field1456;
   @ObfuscatedName("p")
   static Font field1457;
   @ObfuscatedName("bb")
   static class184 field1458;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 283865187
   )
   int field1460;

   FrameMap(int var1, byte[] var2) {
      this.field1460 = var1;
      Buffer var3 = new Buffer(var2);
      this.field1452 = var3.readUnsignedByte();
      this.field1456 = new int[this.field1452];
      this.field1454 = new int[this.field1452][];

      int var4;
      for(var4 = 0; var4 < this.field1452; ++var4) {
         this.field1456[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.field1452; ++var4) {
         this.field1454[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.field1452; ++var4) {
         for(int var5 = 0; var5 < this.field1454[var4].length; ++var5) {
            this.field1454[var4][var5] = var3.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;I)V",
      garbageValue = "-578607787"
   )
   public static void method1753(class182 var0, class182 var1) {
      CombatInfo2.field2848 = var0;
      CombatInfo2.field2831 = var1;
   }

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass164;I)V",
      garbageValue = "-298748384"
   )
   static final void method1754(int var0, int var1, int var2, int var3, SpritePixels var4, class164 var5) {
      if(var4 != null) {
         int var6 = Client.mapScale + Client.mapAngle & 2047;
         int var7 = var2 * var2 + var3 * var3;
         if(var7 <= 6400) {
            int var8 = class84.field1435[var6];
            int var9 = class84.field1432[var6];
            var8 = 256 * var8 / (256 + Client.mapScaleDelta);
            var9 = 256 * var9 / (256 + Client.mapScaleDelta);
            int var10 = var3 * var8 + var2 * var9 >> 16;
            int var11 = var9 * var3 - var2 * var8 >> 16;
            if(var7 > 2500) {
               var4.method4261(var10 + var5.field2148 / 2 - var4.maxWidth / 2, var5.field2146 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2148, var5.field2146, var5.field2149, var5.field2145);
            } else {
               var4.method4284(var10 + var0 + var5.field2148 / 2 - var4.maxWidth / 2, var5.field2146 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }
}

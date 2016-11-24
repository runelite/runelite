import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public class class40 implements class165 {
   @ObfuscatedName("h")
   static final class40 field806 = new class40(3);
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = -720603979
   )
   static int field807;
   @ObfuscatedName("m")
   static final class40 field808 = new class40(2);
   @ObfuscatedName("he")
   @Export("localPlayer")
   static Player localPlayer;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 741779575
   )
   final int field810;
   @ObfuscatedName("d")
   static final class40 field811 = new class40(1);
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = 755078119
   )
   @Export("cameraPitch")
   static int cameraPitch;
   @ObfuscatedName("n")
   static final class40 field814 = new class40(0);

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class40(int var1) {
      this.field810 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1689281815"
   )
   public int vmethod4132() {
      return this.field810;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "208806619"
   )
   static final int method784(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass145;S)V",
      garbageValue = "-16814"
   )
   static final void method785(int var0, int var1, int var2, int var3, SpritePixels var4, class145 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle + Client.mapScale & 2047;
         int var7 = var2 * var2 + var3 * var3;
         if(var7 <= 6400) {
            int var8 = class84.field1444[var6];
            int var9 = class84.field1445[var6];
            var8 = var8 * 256 / (256 + Client.mapScaleDelta);
            var9 = 256 * var9 / (Client.mapScaleDelta + 256);
            int var10 = var8 * var3 + var9 * var2 >> 16;
            int var11 = var3 * var9 - var2 * var8 >> 16;
            if(var7 > 2500) {
               var4.method4202(var5.field2028 / 2 + var10 - var4.field3205 / 2, var5.field2020 / 2 - var11 - var4.field3203 / 2, var0, var1, var5.field2028, var5.field2020, var5.field2023, var5.field2022);
            } else {
               var4.method4192(var10 + var5.field2028 / 2 + var0 - var4.field3205 / 2, var1 + var5.field2020 / 2 - var11 - var4.field3203 / 2);
            }

         }
      }
   }
}

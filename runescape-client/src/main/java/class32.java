import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public class class32 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 117548695
   )
   int field732;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 67562511
   )
   int field733;
   @ObfuscatedName("n")
   String field735;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1325362175
   )
   int field736;
   @ObfuscatedName("ce")
   static class227 field737;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1696514591
   )
   int field739;

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "-1824698161"
   )
   static void method673(Widget var0) {
      if(Client.field451 == var0.field2900) {
         Client.field494[var0.boundsIndex] = true;
      }

   }

   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass178;S)V",
      garbageValue = "205"
   )
   static final void method674(int var0, int var1, int var2, int var3, SpritePixels var4, class178 var5) {
      int var6 = var2 * var2 + var3 * var3;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapScale + Client.mapAngle & 2047;
         int var8 = class94.field1623[var7];
         int var9 = class94.field1642[var7];
         var8 = 256 * var8 / (256 + Client.mapScaleDelta);
         var9 = var9 * 256 / (256 + Client.mapScaleDelta);
         int var10 = var9 * var2 + var8 * var3 >> 16;
         int var11 = var3 * var9 - var2 * var8 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class119.field2032.method1762(4 + var14 + 94 + var0 - 10, 83 + var1 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class18.method197(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "19"
   )
   static final int method675(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = var2 / 2 + (var0 / 4 << 10) + (var1 / 32 << 7);
      return var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;Ljava/lang/String;I)I",
      garbageValue = "-1778357418"
   )
   public static int method676(Buffer var0, String var1) {
      int var2 = var0.offset;
      byte[] var3 = Client.method528(var1);
      var0.method2542(var3.length);
      var0.offset += class225.field3236.method2467(var3, 0, var3.length, var0.payload, var0.offset);
      return var0.offset - var2;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1475260768"
   )
   public static void method677() {
      Sequence.field1015.reset();
      Sequence.field1013.reset();
   }
}

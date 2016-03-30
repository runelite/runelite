import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
public class class82 implements class112 {
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = 1457790063
   )
   static int field1429;
   @ObfuscatedName("p")
   static final class82 field1430 = new class82(3, 3);
   @ObfuscatedName("t")
   static final class82 field1431 = new class82(2, 2);
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 505780841
   )
   static int field1432;
   @ObfuscatedName("e")
   static final class82 field1433 = new class82(4, 4);
   @ObfuscatedName("w")
   public static final class82 field1434 = new class82(0, 0);
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -667421185
   )
   final int field1435;
   @ObfuscatedName("x")
   static final class82 field1436 = new class82(1, 1);
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = 1998610425
   )
   @Export("plane")
   static int field1437;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1855983451
   )
   public final int field1439;
   @ObfuscatedName("bx")
   static class168 field1440;

   class82(int var1, int var2) {
      this.field1439 = var1;
      this.field1435 = var2;
   }

   @ObfuscatedName("w")
   static int method1877(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ class119.field2007[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(IIIILclass78;Lclass175;I)V",
      garbageValue = "-367742246"
   )
   static final void method1880(int var0, int var1, int var2, int var3, class78 var4, class175 var5) {
      int var6 = var2 * var2 + var3 * var3;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = client.field388 + client.field365 & 2047;
         int var8 = class91.field1573[var7];
         int var9 = class91.field1595[var7];
         var8 = var8 * 256 / (client.field367 + 256);
         var9 = 256 * var9 / (256 + client.field367);
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class143.field2203.method1711(var0 + 94 + var14 + 4 - 10, 83 + var1 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class28.method660(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("w")
   public int vmethod3196() {
      return this.field1435;
   }

   @ObfuscatedName("bq")
   static String method1885(int var0) {
      return client.field441[var0].length() > 0?client.field440[var0] + " " + client.field441[var0]:client.field440[var0];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "-1508819449"
   )
   static final void method1886(class122 var0) {
      var0.method2748();
      int var1 = client.field416;
      class2 var2 = class167.field2692 = client.field415[var1] = new class2();
      var2.field60 = var1;
      int var3 = var0.method2777(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.field872[0] = var5 - class41.field990;
      var2.field849 = (var2.field872[0] << 7) + (var2.method15() << 6);
      var2.field873[0] = var6 - class2.field37;
      var2.field819 = (var2.field873[0] << 7) + (var2.method15() << 6);
      field1437 = var2.field62 = var4;
      if(null != class32.field749[var1]) {
         var2.method22(class32.field749[var1]);
      }

      if(class32.field750[var1] != null) {
         var2.field59 = class32.field750[var1];
      }

      class32.field751 = 0;
      class32.field757[++class32.field751 - 1] = var1;
      class32.field747[var1] = 0;
      class32.field753 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.method2777(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 255;
            int var11 = var8 & 255;
            class32.field764[var7] = (var9 << 28) + (var10 << 14) + var11;
            class32.field761[var7] = 0;
            class32.field755[var7] = -1;
            class32.field759[++class32.field753 - 1] = var7;
            class32.field747[var7] = 0;
         }
      }

      var0.method2752();
   }
}

import java.awt.Canvas;
import java.awt.Color;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("ItemLayer")
public final class class99 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -758590953
   )
   @Export("hash")
   int field1687;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 185816141
   )
   @Export("flags")
   int field1688;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 657808011
   )
   @Export("y")
   int field1689;
   @ObfuscatedName("z")
   @Export("middle")
   class85 field1690;
   @ObfuscatedName("r")
   @Export("top")
   class85 field1691;
   @ObfuscatedName("h")
   @Export("bottom")
   class85 field1692;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -65495261
   )
   @Export("height")
   int field1693;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1422044917
   )
   @Export("x")
   int field1694;

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "119441560"
   )
   static void method2154() {
      Canvas var0 = class59.field1221;
      var0.removeKeyListener(class137.field2137);
      var0.removeFocusListener(class137.field2137);
      class137.field2145 = -1;
      Canvas var1 = class59.field1221;
      var1.removeMouseListener(class140.field2186);
      var1.removeMouseMotionListener(class140.field2186);
      var1.removeFocusListener(class140.field2186);
      class140.field2175 = 0;
      if(null != class46.field1068) {
         class46.field1068.vmethod3075(class59.field1221);
      }

      client.field280.method2992();
      class59.field1221.setBackground(Color.black);
      class82.method1845(class59.field1221);
      class106.method2342(class59.field1221);
      if(null != class46.field1068) {
         class46.field1068.vmethod3072(class59.field1221);
      }

      if(client.field442 != -1) {
         class140.method2945(false);
      }

      class144.field2237 = true;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2128114298"
   )
   static int method2155(int var0, int var1) {
      class15 var2 = (class15)class15.field222.method3748((long)var0);
      return var2 == null?0:(var1 >= 0 && var1 < var2.field221.length?var2.field221[var1]:0);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IILclass107;Lclass108;S)Z",
      garbageValue = "21349"
   )
   static final boolean method2156(int var0, int var1, class107 var2, class108 var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class106.field1873[var6][var7] = 99;
      class106.field1877[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class106.field1881[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class106.field1876[var10001] = var1;
      int[][] var12 = var3.field1906;

      while(var18 != var11) {
         var4 = class106.field1881[var11];
         var5 = class106.field1876[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.field1907;
         int var14 = var5 - var3.field1903;
         if(var2.vmethod2345(2, var4, var5, var3)) {
            class10.field163 = var4;
            class106.field1875 = var5;
            return true;
         }

         int var15 = 1 + class106.field1877[var16][var17];
         if(var16 > 0 && class106.field1873[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136782) == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0) {
            class106.field1881[var18] = var4 - 1;
            class106.field1876[var18] = var5;
            var18 = 1 + var18 & 4095;
            class106.field1873[var16 - 1][var17] = 2;
            class106.field1877[var16 - 1][var17] = var15;
         }

         if(var16 < 126 && class106.field1873[1 + var16][var17] == 0 && (var12[2 + var13][var14] & 19136899) == 0 && (var12[var13 + 2][1 + var14] & 19136992) == 0) {
            class106.field1881[var18] = var4 + 1;
            class106.field1876[var18] = var5;
            var18 = 1 + var18 & 4095;
            class106.field1873[1 + var16][var17] = 8;
            class106.field1877[1 + var16][var17] = var15;
         }

         if(var17 > 0 && class106.field1873[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136782) == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0) {
            class106.field1881[var18] = var4;
            class106.field1876[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class106.field1873[var16][var17 - 1] = 1;
            class106.field1877[var16][var17 - 1] = var15;
         }

         if(var17 < 126 && class106.field1873[var16][var17 + 1] == 0 && (var12[var13][var14 + 2] & 19136824) == 0 && (var12[var13 + 1][var14 + 2] & 19136992) == 0) {
            class106.field1881[var18] = var4;
            class106.field1876[var18] = 1 + var5;
            var18 = 1 + var18 & 4095;
            class106.field1873[var16][1 + var17] = 4;
            class106.field1877[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class106.field1873[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
            class106.field1881[var18] = var4 - 1;
            class106.field1876[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class106.field1873[var16 - 1][var17 - 1] = 3;
            class106.field1877[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 126 && var17 > 0 && class106.field1873[1 + var16][var17 - 1] == 0 && (var12[1 + var13][var14 - 1] & 19136911) == 0 && (var12[var13 + 2][var14 - 1] & 19136899) == 0 && (var12[var13 + 2][var14] & 19136995) == 0) {
            class106.field1881[var18] = 1 + var4;
            class106.field1876[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class106.field1873[var16 + 1][var17 - 1] = 9;
            class106.field1877[1 + var16][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 126 && class106.field1873[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][1 + var14] & 19136830) == 0 && (var12[var13 - 1][2 + var14] & 19136824) == 0 && (var12[var13][var14 + 2] & 19137016) == 0) {
            class106.field1881[var18] = var4 - 1;
            class106.field1876[var18] = 1 + var5;
            var18 = var18 + 1 & 4095;
            class106.field1873[var16 - 1][1 + var17] = 6;
            class106.field1877[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 126 && var17 < 126 && class106.field1873[1 + var16][var17 + 1] == 0 && (var12[1 + var13][2 + var14] & 19137016) == 0 && (var12[var13 + 2][var14 + 2] & 19136992) == 0 && (var12[var13 + 2][var14 + 1] & 19136995) == 0) {
            class106.field1881[var18] = 1 + var4;
            class106.field1876[var18] = var5 + 1;
            var18 = 1 + var18 & 4095;
            class106.field1873[1 + var16][var17 + 1] = 12;
            class106.field1877[var16 + 1][1 + var17] = var15;
         }
      }

      class10.field163 = var4;
      class106.field1875 = var5;
      return false;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-923909029"
   )
   static final void method2157(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < client.field485; ++var4) {
         if(client.field535[var4] + client.field490[var4] > var0 && client.field490[var4] < var0 + var2 && client.field493[var4] + client.field436[var4] > var1 && client.field436[var4] < var3 + var1) {
            client.field488[var4] = true;
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "1050008557"
   )
   static char method2158(char var0) {
      return (char)(var0 == 198?'E':(var0 == 230?'e':(var0 == 223?'s':(var0 == 338?'E':(var0 == 339?'e':'\u0000')))));
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)[Lclass153;",
      garbageValue = "-852170862"
   )
   public static class153[] method2159() {
      return new class153[]{class153.field2305, class153.field2304, class153.field2308, class153.field2306};
   }
}

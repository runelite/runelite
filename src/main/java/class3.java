import java.awt.Canvas;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
@Implements("WidgetNode")
public class class3 extends class208 {
   @ObfuscatedName("m")
   boolean field63 = false;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1270493057
   )
   int field64;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1493008989
   )
   @Export("id")
   int field65;
   @ObfuscatedName("qu")
   public static Canvas field66;
   @ObfuscatedName("a")
   public static class59 field67;
   @ObfuscatedName("ak")
   static class80[] field68;
   @ObfuscatedName("ph")
   static class160 field70;

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Lclass2;III)V",
      garbageValue = "1859234191"
   )
   static void method30(class2 var0, int var1, int var2) {
      if(var1 == var0.field825 && var1 != -1) {
         int var3 = class161.method3153(var1).field985;
         if(var3 == 1) {
            var0.field826 = 0;
            var0.field827 = 0;
            var0.field849 = var2;
            var0.field829 = 0;
         }

         if(var3 == 2) {
            var0.field829 = 0;
         }
      } else if(-1 == var1 || var0.field825 == -1 || class161.method3153(var1).field984 >= class161.method3153(var0.field825).field984) {
         var0.field825 = var1;
         var0.field826 = 0;
         var0.field827 = 0;
         var0.field849 = var2;
         var0.field829 = 0;
         var0.field852 = var0.field820;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IILclass107;Lclass108;I)Z",
      garbageValue = "-422347083"
   )
   static final boolean method31(int var0, int var1, class107 var2, class108 var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class106.field1850[var6][var7] = 99;
      class106.field1855[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class106.field1853[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class106.field1849[var10001] = var1;
      int[][] var12 = var3.field1879;

      while(var18 != var11) {
         var4 = class106.field1853[var11];
         var5 = class106.field1849[var11];
         var11 = 1 + var11 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.field1880;
         int var14 = var5 - var3.field1876;
         if(var2.vmethod2375(2, var4, var5, var3)) {
            class33.field758 = var4;
            class103.field1756 = var5;
            return true;
         }

         int var15 = 1 + class106.field1855[var16][var17];
         if(var16 > 0 && class106.field1850[var16 - 1][var17] == 0 && 0 == (var12[var13 - 1][var14] & 19136782) && (var12[var13 - 1][1 + var14] & 19136824) == 0) {
            class106.field1853[var18] = var4 - 1;
            class106.field1849[var18] = var5;
            var18 = 1 + var18 & 4095;
            class106.field1850[var16 - 1][var17] = 2;
            class106.field1855[var16 - 1][var17] = var15;
         }

         if(var16 < 126 && class106.field1850[var16 + 1][var17] == 0 && (var12[2 + var13][var14] & 19136899) == 0 && 0 == (var12[var13 + 2][var14 + 1] & 19136992)) {
            class106.field1853[var18] = var4 + 1;
            class106.field1849[var18] = var5;
            var18 = var18 + 1 & 4095;
            class106.field1850[var16 + 1][var17] = 8;
            class106.field1855[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class106.field1850[var16][var17 - 1] == 0 && 0 == (var12[var13][var14 - 1] & 19136782) && (var12[1 + var13][var14 - 1] & 19136899) == 0) {
            class106.field1853[var18] = var4;
            class106.field1849[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class106.field1850[var16][var17 - 1] = 1;
            class106.field1855[var16][var17 - 1] = var15;
         }

         if(var17 < 126 && 0 == class106.field1850[var16][1 + var17] && (var12[var13][var14 + 2] & 19136824) == 0 && (var12[var13 + 1][var14 + 2] & 19136992) == 0) {
            class106.field1853[var18] = var4;
            class106.field1849[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class106.field1850[var16][var17 + 1] = 4;
            class106.field1855[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class106.field1850[var16 - 1][var17 - 1] == 0 && 0 == (var12[var13 - 1][var14] & 19136830) && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && 0 == (var12[var13][var14 - 1] & 19136911)) {
            class106.field1853[var18] = var4 - 1;
            class106.field1849[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class106.field1850[var16 - 1][var17 - 1] = 3;
            class106.field1855[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 126 && var17 > 0 && class106.field1850[1 + var16][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136911) == 0 && (var12[var13 + 2][var14 - 1] & 19136899) == 0 && (var12[var13 + 2][var14] & 19136995) == 0) {
            class106.field1853[var18] = 1 + var4;
            class106.field1849[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class106.field1850[1 + var16][var17 - 1] = 9;
            class106.field1855[1 + var16][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 126 && class106.field1850[var16 - 1][1 + var17] == 0 && 0 == (var12[var13 - 1][1 + var14] & 19136830) && (var12[var13 - 1][var14 + 2] & 19136824) == 0 && (var12[var13][2 + var14] & 19137016) == 0) {
            class106.field1853[var18] = var4 - 1;
            class106.field1849[var18] = 1 + var5;
            var18 = 1 + var18 & 4095;
            class106.field1850[var16 - 1][var17 + 1] = 6;
            class106.field1855[var16 - 1][1 + var17] = var15;
         }

         if(var16 < 126 && var17 < 126 && class106.field1850[var16 + 1][1 + var17] == 0 && 0 == (var12[var13 + 1][var14 + 2] & 19137016) && 0 == (var12[2 + var13][var14 + 2] & 19136992) && (var12[2 + var13][1 + var14] & 19136995) == 0) {
            class106.field1853[var18] = 1 + var4;
            class106.field1849[var18] = 1 + var5;
            var18 = 1 + var18 & 4095;
            class106.field1850[var16 + 1][1 + var17] = 12;
            class106.field1855[var16 + 1][1 + var17] = var15;
         }
      }

      class33.field758 = var4;
      class103.field1756 = var5;
      return false;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1963404079"
   )
   static final void method32(int var0, int var1, int var2, int var3) {
      if(1 == client.field386) {
         client.field555[client.field542 / 100].method1700(client.field383 - 8, client.field384 - 8);
      }

      if(2 == client.field386) {
         client.field555[4 + client.field542 / 100].method1700(client.field383 - 8, client.field384 - 8);
      }

      class159.method3141();
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(Lclass16;B)V",
      garbageValue = "21"
   )
   static final void method33(class16 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field222 == 0) {
         var1 = class35.field771.method2034(var0.field227, var0.field224, var0.field225);
      }

      if(var0.field222 == 1) {
         var1 = class35.field771.method1932(var0.field227, var0.field224, var0.field225);
      }

      if(var0.field222 == 2) {
         var1 = class35.field771.method1933(var0.field227, var0.field224, var0.field225);
      }

      if(3 == var0.field222) {
         var1 = class35.field771.method1934(var0.field227, var0.field224, var0.field225);
      }

      if(var1 != 0) {
         int var5 = class35.field771.method2072(var0.field227, var0.field224, var0.field225, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field236 = var2;
      var0.field228 = var3;
      var0.field234 = var4;
   }
}

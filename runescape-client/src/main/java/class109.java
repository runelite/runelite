import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
public abstract class class109 {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-489141503"
   )
   public abstract void vmethod2003();

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "1"
   )
   abstract int vmethod2004(int var1, int var2);

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-57"
   )
   public static void method2005() {
      Overlay.field3023.reset();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IILclass119;LCollisionData;I)Z",
      garbageValue = "-1600282383"
   )
   static final boolean method2011(int var0, int var1, class119 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class118.field1834[var6][var7] = 99;
      class118.field1826[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class118.field1828[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class118.field1829[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var11 != var18) {
         var4 = class118.field1828[var11];
         var5 = class118.field1829[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod2276(1, var4, var5, var3)) {
            class146.field2005 = var4;
            class118.field1827 = var5;
            return true;
         }

         int var15 = class118.field1826[var16][var17] + 1;
         if(var16 > 0 && class118.field1834[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136776) == 0) {
            class118.field1828[var18] = var4 - 1;
            class118.field1829[var18] = var5;
            var18 = 1 + var18 & 4095;
            class118.field1834[var16 - 1][var17] = 2;
            class118.field1826[var16 - 1][var17] = var15;
         }

         if(var16 < 127 && class118.field1834[var16 + 1][var17] == 0 && (var12[1 + var13][var14] & 19136896) == 0) {
            class118.field1828[var18] = 1 + var4;
            class118.field1829[var18] = var5;
            var18 = var18 + 1 & 4095;
            class118.field1834[1 + var16][var17] = 8;
            class118.field1826[1 + var16][var17] = var15;
         }

         if(var17 > 0 && class118.field1834[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class118.field1828[var18] = var4;
            class118.field1829[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class118.field1834[var16][var17 - 1] = 1;
            class118.field1826[var16][var17 - 1] = var15;
         }

         if(var17 < 127 && class118.field1834[var16][var17 + 1] == 0 && (var12[var13][1 + var14] & 19136800) == 0) {
            class118.field1828[var18] = var4;
            class118.field1829[var18] = 1 + var5;
            var18 = var18 + 1 & 4095;
            class118.field1834[var16][1 + var17] = 4;
            class118.field1826[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class118.field1834[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class118.field1828[var18] = var4 - 1;
            class118.field1829[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class118.field1834[var16 - 1][var17 - 1] = 3;
            class118.field1826[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 127 && var17 > 0 && class118.field1834[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0 && (var12[1 + var13][var14] & 19136896) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class118.field1828[var18] = var4 + 1;
            class118.field1829[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class118.field1834[var16 + 1][var17 - 1] = 9;
            class118.field1826[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 127 && class118.field1834[var16 - 1][1 + var17] == 0 && (var12[var13 - 1][1 + var14] & 19136824) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][1 + var14] & 19136800) == 0) {
            class118.field1828[var18] = var4 - 1;
            class118.field1829[var18] = 1 + var5;
            var18 = 1 + var18 & 4095;
            class118.field1834[var16 - 1][1 + var17] = 6;
            class118.field1826[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 127 && var17 < 127 && class118.field1834[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 1] & 19136992) == 0 && (var12[1 + var13][var14] & 19136896) == 0 && (var12[var13][1 + var14] & 19136800) == 0) {
            class118.field1828[var18] = var4 + 1;
            class118.field1829[var18] = 1 + var5;
            var18 = 1 + var18 & 4095;
            class118.field1834[1 + var16][1 + var17] = 12;
            class118.field1826[1 + var16][var17 + 1] = var15;
         }
      }

      class146.field2005 = var4;
      class118.field1827 = var5;
      return false;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-536319377"
   )
   static String method2012(int var0) {
      return "<img=" + var0 + ">";
   }
}

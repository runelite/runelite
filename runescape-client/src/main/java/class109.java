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
      int var13 = var10 + 1;
      class118.field1829[var10] = var1;
      int[][] var14 = var3.flags;

      while(var11 != var13) {
         var4 = class118.field1828[var11];
         var5 = class118.field1829[var11];
         var11 = var11 + 1 & 4095;
         int var15 = var4 - var8;
         int var16 = var5 - var9;
         int var17 = var4 - var3.x;
         int var18 = var5 - var3.y;
         if(var2.vmethod2276(1, var4, var5, var3)) {
            class146.field2005 = var4;
            class118.field1827 = var5;
            return true;
         }

         int var19 = class118.field1826[var15][var16] + 1;
         if(var15 > 0 && class118.field1834[var15 - 1][var16] == 0 && (var14[var17 - 1][var18] & 19136776) == 0) {
            class118.field1828[var13] = var4 - 1;
            class118.field1829[var13] = var5;
            var13 = 1 + var13 & 4095;
            class118.field1834[var15 - 1][var16] = 2;
            class118.field1826[var15 - 1][var16] = var19;
         }

         if(var15 < 127 && class118.field1834[var15 + 1][var16] == 0 && (var14[1 + var17][var18] & 19136896) == 0) {
            class118.field1828[var13] = 1 + var4;
            class118.field1829[var13] = var5;
            var13 = var13 + 1 & 4095;
            class118.field1834[1 + var15][var16] = 8;
            class118.field1826[1 + var15][var16] = var19;
         }

         if(var16 > 0 && class118.field1834[var15][var16 - 1] == 0 && (var14[var17][var18 - 1] & 19136770) == 0) {
            class118.field1828[var13] = var4;
            class118.field1829[var13] = var5 - 1;
            var13 = 1 + var13 & 4095;
            class118.field1834[var15][var16 - 1] = 1;
            class118.field1826[var15][var16 - 1] = var19;
         }

         if(var16 < 127 && class118.field1834[var15][var16 + 1] == 0 && (var14[var17][1 + var18] & 19136800) == 0) {
            class118.field1828[var13] = var4;
            class118.field1829[var13] = 1 + var5;
            var13 = var13 + 1 & 4095;
            class118.field1834[var15][1 + var16] = 4;
            class118.field1826[var15][var16 + 1] = var19;
         }

         if(var15 > 0 && var16 > 0 && class118.field1834[var15 - 1][var16 - 1] == 0 && (var14[var17 - 1][var18 - 1] & 19136782) == 0 && (var14[var17 - 1][var18] & 19136776) == 0 && (var14[var17][var18 - 1] & 19136770) == 0) {
            class118.field1828[var13] = var4 - 1;
            class118.field1829[var13] = var5 - 1;
            var13 = 1 + var13 & 4095;
            class118.field1834[var15 - 1][var16 - 1] = 3;
            class118.field1826[var15 - 1][var16 - 1] = var19;
         }

         if(var15 < 127 && var16 > 0 && class118.field1834[var15 + 1][var16 - 1] == 0 && (var14[var17 + 1][var18 - 1] & 19136899) == 0 && (var14[1 + var17][var18] & 19136896) == 0 && (var14[var17][var18 - 1] & 19136770) == 0) {
            class118.field1828[var13] = var4 + 1;
            class118.field1829[var13] = var5 - 1;
            var13 = var13 + 1 & 4095;
            class118.field1834[var15 + 1][var16 - 1] = 9;
            class118.field1826[var15 + 1][var16 - 1] = var19;
         }

         if(var15 > 0 && var16 < 127 && class118.field1834[var15 - 1][1 + var16] == 0 && (var14[var17 - 1][1 + var18] & 19136824) == 0 && (var14[var17 - 1][var18] & 19136776) == 0 && (var14[var17][1 + var18] & 19136800) == 0) {
            class118.field1828[var13] = var4 - 1;
            class118.field1829[var13] = 1 + var5;
            var13 = 1 + var13 & 4095;
            class118.field1834[var15 - 1][1 + var16] = 6;
            class118.field1826[var15 - 1][var16 + 1] = var19;
         }

         if(var15 < 127 && var16 < 127 && class118.field1834[var15 + 1][var16 + 1] == 0 && (var14[var17 + 1][var18 + 1] & 19136992) == 0 && (var14[1 + var17][var18] & 19136896) == 0 && (var14[var17][1 + var18] & 19136800) == 0) {
            class118.field1828[var13] = var4 + 1;
            class118.field1829[var13] = 1 + var5;
            var13 = 1 + var13 & 4095;
            class118.field1834[1 + var15][1 + var16] = 12;
            class118.field1826[1 + var15][var16 + 1] = var19;
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

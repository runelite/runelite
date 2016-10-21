import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hj")
final class class222 implements Comparator {
   @ObfuscatedName("p")
   static class13 field3213;
   @ObfuscatedName("n")
   static int[] field3214;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "-1160322711"
   )
   int method4053(class217 var1, class217 var2) {
      return var1.field3196 < var2.field3196?-1:(var2.field3196 == var1.field3196?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method4053((class217)var1, (class217)var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IILclass110;LCollisionData;I)Z",
      garbageValue = "-1592636135"
   )
   public static final boolean method4059(int var0, int var1, class110 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class109.field1927[var6][var7] = 99;
      class109.field1925[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class109.field1932[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class109.field1933[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var11 != var18) {
         var4 = class109.field1932[var11];
         var5 = class109.field1933[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod2401(2, var4, var5, var3)) {
            FileOnDisk.field3264 = var4;
            class109.field1929 = var5;
            return true;
         }

         int var15 = class109.field1925[var16][var17] + 1;
         if(var16 > 0 && class109.field1927[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136782) == 0 && (var12[var13 - 1][1 + var14] & 19136824) == 0) {
            class109.field1932[var18] = var4 - 1;
            class109.field1933[var18] = var5;
            var18 = var18 + 1 & 4095;
            class109.field1927[var16 - 1][var17] = 2;
            class109.field1925[var16 - 1][var17] = var15;
         }

         if(var16 < 126 && class109.field1927[var16 + 1][var17] == 0 && (var12[var13 + 2][var14] & 19136899) == 0 && (var12[2 + var13][var14 + 1] & 19136992) == 0) {
            class109.field1932[var18] = var4 + 1;
            class109.field1933[var18] = var5;
            var18 = 1 + var18 & 4095;
            class109.field1927[var16 + 1][var17] = 8;
            class109.field1925[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class109.field1927[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136782) == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0) {
            class109.field1932[var18] = var4;
            class109.field1933[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class109.field1927[var16][var17 - 1] = 1;
            class109.field1925[var16][var17 - 1] = var15;
         }

         if(var17 < 126 && class109.field1927[var16][1 + var17] == 0 && (var12[var13][var14 + 2] & 19136824) == 0 && (var12[1 + var13][var14 + 2] & 19136992) == 0) {
            class109.field1932[var18] = var4;
            class109.field1933[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class109.field1927[var16][1 + var17] = 4;
            class109.field1925[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class109.field1927[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
            class109.field1932[var18] = var4 - 1;
            class109.field1933[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class109.field1927[var16 - 1][var17 - 1] = 3;
            class109.field1925[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 126 && var17 > 0 && class109.field1927[1 + var16][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136911) == 0 && (var12[2 + var13][var14 - 1] & 19136899) == 0 && (var12[2 + var13][var14] & 19136995) == 0) {
            class109.field1932[var18] = 1 + var4;
            class109.field1933[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class109.field1927[1 + var16][var17 - 1] = 9;
            class109.field1925[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 126 && class109.field1927[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136830) == 0 && (var12[var13 - 1][var14 + 2] & 19136824) == 0 && (var12[var13][2 + var14] & 19137016) == 0) {
            class109.field1932[var18] = var4 - 1;
            class109.field1933[var18] = 1 + var5;
            var18 = var18 + 1 & 4095;
            class109.field1927[var16 - 1][1 + var17] = 6;
            class109.field1925[var16 - 1][1 + var17] = var15;
         }

         if(var16 < 126 && var17 < 126 && class109.field1927[var16 + 1][var17 + 1] == 0 && (var12[1 + var13][var14 + 2] & 19137016) == 0 && (var12[var13 + 2][2 + var14] & 19136992) == 0 && (var12[var13 + 2][1 + var14] & 19136995) == 0) {
            class109.field1932[var18] = 1 + var4;
            class109.field1933[var18] = 1 + var5;
            var18 = 1 + var18 & 4095;
            class109.field1927[var16 + 1][1 + var17] = 12;
            class109.field1925[var16 + 1][1 + var17] = var15;
         }
      }

      FileOnDisk.field3264 = var4;
      class109.field1929 = var5;
      return false;
   }
}

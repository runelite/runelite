import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
public class class187 extends CacheableNode {
   @ObfuscatedName("nm")
   static class65 field2769;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1111012195
   )
   public static int field2770;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -178185341
   )
   public int field2771 = 0;
   @ObfuscatedName("x")
   public static NodeCache field2772 = new NodeCache(64);
   @ObfuscatedName("p")
   public static class182 field2775;
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = 2093074097
   )
   protected static int field2776;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-115"
   )
   public void method3421(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3422(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1607806568"
   )
   void method3422(Buffer var1, int var2) {
      if(var2 == 5) {
         this.field2771 = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IILclass119;LCollisionData;I)Z",
      garbageValue = "1909330560"
   )
   public static final boolean method3427(int var0, int var1, class119 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class118.field1847[var6][var7] = 99;
      class118.field1848[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class118.field1849[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class118.field1850[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var11 != var18) {
         var4 = class118.field1849[var11];
         var5 = class118.field1850[var11];
         var11 = 1 + var11 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod2300(1, var4, var5, var3)) {
            class149.field2039 = var4;
            class20.field208 = var5;
            return true;
         }

         int var15 = class118.field1848[var16][var17] + 1;
         if(var16 > 0 && class118.field1847[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136776) == 0) {
            class118.field1849[var18] = var4 - 1;
            class118.field1850[var18] = var5;
            var18 = 1 + var18 & 4095;
            class118.field1847[var16 - 1][var17] = 2;
            class118.field1848[var16 - 1][var17] = var15;
         }

         if(var16 < 127 && class118.field1847[1 + var16][var17] == 0 && (var12[var13 + 1][var14] & 19136896) == 0) {
            class118.field1849[var18] = 1 + var4;
            class118.field1850[var18] = var5;
            var18 = var18 + 1 & 4095;
            class118.field1847[var16 + 1][var17] = 8;
            class118.field1848[1 + var16][var17] = var15;
         }

         if(var17 > 0 && class118.field1847[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class118.field1849[var18] = var4;
            class118.field1850[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class118.field1847[var16][var17 - 1] = 1;
            class118.field1848[var16][var17 - 1] = var15;
         }

         if(var17 < 127 && class118.field1847[var16][var17 + 1] == 0 && (var12[var13][1 + var14] & 19136800) == 0) {
            class118.field1849[var18] = var4;
            class118.field1850[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class118.field1847[var16][var17 + 1] = 4;
            class118.field1848[var16][1 + var17] = var15;
         }

         if(var16 > 0 && var17 > 0 && class118.field1847[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class118.field1849[var18] = var4 - 1;
            class118.field1850[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class118.field1847[var16 - 1][var17 - 1] = 3;
            class118.field1848[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 127 && var17 > 0 && class118.field1847[1 + var16][var17 - 1] == 0 && (var12[1 + var13][var14 - 1] & 19136899) == 0 && (var12[1 + var13][var14] & 19136896) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class118.field1849[var18] = 1 + var4;
            class118.field1850[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class118.field1847[1 + var16][var17 - 1] = 9;
            class118.field1848[1 + var16][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 127 && class118.field1847[var16 - 1][1 + var17] == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class118.field1849[var18] = var4 - 1;
            class118.field1850[var18] = 1 + var5;
            var18 = var18 + 1 & 4095;
            class118.field1847[var16 - 1][var17 + 1] = 6;
            class118.field1848[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 127 && var17 < 127 && class118.field1847[1 + var16][var17 + 1] == 0 && (var12[1 + var13][var14 + 1] & 19136992) == 0 && (var12[1 + var13][var14] & 19136896) == 0 && (var12[var13][1 + var14] & 19136800) == 0) {
            class118.field1849[var18] = 1 + var4;
            class118.field1850[var18] = 1 + var5;
            var18 = 1 + var18 & 4095;
            class118.field1847[var16 + 1][1 + var17] = 12;
            class118.field1848[1 + var16][1 + var17] = var15;
         }
      }

      class149.field2039 = var4;
      class20.field208 = var5;
      return false;
   }
}

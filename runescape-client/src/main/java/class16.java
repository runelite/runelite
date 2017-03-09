import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
public class class16 extends class131 {
   @ObfuscatedName("c")
   short field201;
   @ObfuscatedName("j")
   String field202;
   @ObfuscatedName("qx")
   protected static java.awt.Frame field206;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1344009747
   )
   int field207 = (int)(class99.method2005() / 1000L);
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      intValue = 622213691
   )
   protected static int field208;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "-10"
   )
   static int method202(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 4000) {
         class32.field752 -= 2;
         var3 = class32.field756[class32.field752];
         var4 = class32.field756[class32.field752 + 1];
         class32.field756[++class32.field752 - 1] = var3 + var4;
         return 1;
      } else if(var0 == 4001) {
         class32.field752 -= 2;
         var3 = class32.field756[class32.field752];
         var4 = class32.field756[1 + class32.field752];
         class32.field756[++class32.field752 - 1] = var3 - var4;
         return 1;
      } else if(var0 == 4002) {
         class32.field752 -= 2;
         var3 = class32.field756[class32.field752];
         var4 = class32.field756[class32.field752 + 1];
         class32.field756[++class32.field752 - 1] = var4 * var3;
         return 1;
      } else if(var0 == 4003) {
         class32.field752 -= 2;
         var3 = class32.field756[class32.field752];
         var4 = class32.field756[1 + class32.field752];
         class32.field756[++class32.field752 - 1] = var3 / var4;
         return 1;
      } else if(var0 == 4004) {
         var3 = class32.field756[--class32.field752];
         class32.field756[++class32.field752 - 1] = (int)(Math.random() * (double)var3);
         return 1;
      } else if(var0 == 4005) {
         var3 = class32.field756[--class32.field752];
         class32.field756[++class32.field752 - 1] = (int)(Math.random() * (double)(1 + var3));
         return 1;
      } else if(var0 == 4006) {
         class32.field752 -= 5;
         var3 = class32.field756[class32.field752];
         var4 = class32.field756[class32.field752 + 1];
         int var5 = class32.field756[2 + class32.field752];
         int var6 = class32.field756[3 + class32.field752];
         int var7 = class32.field756[class32.field752 + 4];
         class32.field756[++class32.field752 - 1] = var3 + (var7 - var5) * (var4 - var3) / (var6 - var5);
         return 1;
      } else if(var0 == 4007) {
         class32.field752 -= 2;
         var3 = class32.field756[class32.field752];
         var4 = class32.field756[1 + class32.field752];
         class32.field756[++class32.field752 - 1] = var4 * var3 / 100 + var3;
         return 1;
      } else if(var0 == 4008) {
         class32.field752 -= 2;
         var3 = class32.field756[class32.field752];
         var4 = class32.field756[class32.field752 + 1];
         class32.field756[++class32.field752 - 1] = var3 | 1 << var4;
         return 1;
      } else if(var0 == 4009) {
         class32.field752 -= 2;
         var3 = class32.field756[class32.field752];
         var4 = class32.field756[class32.field752 + 1];
         class32.field756[++class32.field752 - 1] = var3 & -1 - (1 << var4);
         return 1;
      } else if(var0 == 4010) {
         class32.field752 -= 2;
         var3 = class32.field756[class32.field752];
         var4 = class32.field756[1 + class32.field752];
         class32.field756[++class32.field752 - 1] = (var3 & 1 << var4) != 0?1:0;
         return 1;
      } else if(var0 == 4011) {
         class32.field752 -= 2;
         var3 = class32.field756[class32.field752];
         var4 = class32.field756[1 + class32.field752];
         class32.field756[++class32.field752 - 1] = var3 % var4;
         return 1;
      } else if(var0 == 4012) {
         class32.field752 -= 2;
         var3 = class32.field756[class32.field752];
         var4 = class32.field756[1 + class32.field752];
         if(var3 == 0) {
            class32.field756[++class32.field752 - 1] = 0;
         } else {
            class32.field756[++class32.field752 - 1] = (int)Math.pow((double)var3, (double)var4);
         }

         return 1;
      } else if(var0 == 4013) {
         class32.field752 -= 2;
         var3 = class32.field756[class32.field752];
         var4 = class32.field756[class32.field752 + 1];
         if(var3 == 0) {
            class32.field756[++class32.field752 - 1] = 0;
         } else if(var4 == 0) {
            class32.field756[++class32.field752 - 1] = Integer.MAX_VALUE;
         } else {
            class32.field756[++class32.field752 - 1] = (int)Math.pow((double)var3, 1.0D / (double)var4);
         }

         return 1;
      } else if(var0 == 4014) {
         class32.field752 -= 2;
         var3 = class32.field756[class32.field752];
         var4 = class32.field756[1 + class32.field752];
         class32.field756[++class32.field752 - 1] = var3 & var4;
         return 1;
      } else if(var0 == 4015) {
         class32.field752 -= 2;
         var3 = class32.field756[class32.field752];
         var4 = class32.field756[1 + class32.field752];
         class32.field756[++class32.field752 - 1] = var3 | var4;
         return 1;
      } else if(var0 == 4018) {
         class32.field752 -= 3;
         long var13 = (long)class32.field756[class32.field752];
         long var9 = (long)class32.field756[class32.field752 + 1];
         long var11 = (long)class32.field756[2 + class32.field752];
         class32.field756[++class32.field752 - 1] = (int)(var11 * var13 / var9);
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1965021424"
   )
   static final void method203() {
      if(Client.field365 > 0) {
         VertexNormal.method1692();
      } else {
         class187.setGameState(40);
         class8.field88 = class1.field15;
         class1.field15 = null;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IILclass119;LCollisionData;B)Z",
      garbageValue = "12"
   )
   static final boolean method204(int var0, int var1, class119 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class118.field1852[var6][var7] = 99;
      class118.field1849[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class118.field1846[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class118.field1853[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var18 != var11) {
         var4 = class118.field1846[var11];
         var5 = class118.field1853[var11];
         var11 = 1 + var11 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod2329(1, var4, var5, var3)) {
            class118.field1850 = var4;
            class180.field2689 = var5;
            return true;
         }

         int var15 = 1 + class118.field1849[var16][var17];
         if(var16 > 0 && class118.field1852[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136776) == 0) {
            class118.field1846[var18] = var4 - 1;
            class118.field1853[var18] = var5;
            var18 = var18 + 1 & 4095;
            class118.field1852[var16 - 1][var17] = 2;
            class118.field1849[var16 - 1][var17] = var15;
         }

         if(var16 < 127 && class118.field1852[1 + var16][var17] == 0 && (var12[var13 + 1][var14] & 19136896) == 0) {
            class118.field1846[var18] = var4 + 1;
            class118.field1853[var18] = var5;
            var18 = 1 + var18 & 4095;
            class118.field1852[1 + var16][var17] = 8;
            class118.field1849[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class118.field1852[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class118.field1846[var18] = var4;
            class118.field1853[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class118.field1852[var16][var17 - 1] = 1;
            class118.field1849[var16][var17 - 1] = var15;
         }

         if(var17 < 127 && class118.field1852[var16][var17 + 1] == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class118.field1846[var18] = var4;
            class118.field1853[var18] = 1 + var5;
            var18 = var18 + 1 & 4095;
            class118.field1852[var16][var17 + 1] = 4;
            class118.field1849[var16][1 + var17] = var15;
         }

         if(var16 > 0 && var17 > 0 && class118.field1852[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class118.field1846[var18] = var4 - 1;
            class118.field1853[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class118.field1852[var16 - 1][var17 - 1] = 3;
            class118.field1849[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 127 && var17 > 0 && class118.field1852[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class118.field1846[var18] = 1 + var4;
            class118.field1853[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class118.field1852[1 + var16][var17 - 1] = 9;
            class118.field1849[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 127 && class118.field1852[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][1 + var14] & 19136800) == 0) {
            class118.field1846[var18] = var4 - 1;
            class118.field1853[var18] = 1 + var5;
            var18 = var18 + 1 & 4095;
            class118.field1852[var16 - 1][1 + var17] = 6;
            class118.field1849[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 127 && var17 < 127 && class118.field1852[1 + var16][var17 + 1] == 0 && (var12[var13 + 1][1 + var14] & 19136992) == 0 && (var12[1 + var13][var14] & 19136896) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class118.field1846[var18] = 1 + var4;
            class118.field1853[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class118.field1852[1 + var16][1 + var17] = 12;
            class118.field1849[1 + var16][var17 + 1] = var15;
         }
      }

      class118.field1850 = var4;
      class180.field2689 = var5;
      return false;
   }

   class16(String var1, int var2) {
      this.field202 = var1;
      this.field201 = (short)var2;
   }
}

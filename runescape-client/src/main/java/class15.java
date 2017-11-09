import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
final class class15 implements Comparator {
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      longValue = 6147491338005599333L
   )
   static long field295;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lk;Lk;I)I",
      garbageValue = "-1584153363"
   )
   int method98(class14 var1, class14 var2) {
      return var1.field285.totalQuantity < var2.field285.totalQuantity?-1:(var2.field285.totalQuantity == var1.field285.totalQuantity?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method98((class14)var1, (class14)var2);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IILfm;Lfa;B)Z",
      garbageValue = "80"
   )
   static final boolean method111(int var0, int var1, class164 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class163.field2204[var6][var7] = 99;
      class163.field2207[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class163.field2211[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class163.field2212[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var11 != var18) {
         var4 = class163.field2211[var11];
         var5 = class163.field2212[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod3175(2, var4, var5, var3)) {
            class163.field2208 = var4;
            class163.field2209 = var5;
            return true;
         }

         int var15 = class163.field2207[var16][var17] + 1;
         if(var16 > 0 && class163.field2204[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136782) == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0) {
            class163.field2211[var18] = var4 - 1;
            class163.field2212[var18] = var5;
            var18 = var18 + 1 & 4095;
            class163.field2204[var16 - 1][var17] = 2;
            class163.field2207[var16 - 1][var17] = var15;
         }

         if(var16 < 126 && class163.field2204[var16 + 1][var17] == 0 && (var12[var13 + 2][var14] & 19136899) == 0 && (var12[var13 + 2][var14 + 1] & 19136992) == 0) {
            class163.field2211[var18] = var4 + 1;
            class163.field2212[var18] = var5;
            var18 = var18 + 1 & 4095;
            class163.field2204[var16 + 1][var17] = 8;
            class163.field2207[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class163.field2204[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136782) == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0) {
            class163.field2211[var18] = var4;
            class163.field2212[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class163.field2204[var16][var17 - 1] = 1;
            class163.field2207[var16][var17 - 1] = var15;
         }

         if(var17 < 126 && class163.field2204[var16][var17 + 1] == 0 && (var12[var13][var14 + 2] & 19136824) == 0 && (var12[var13 + 1][var14 + 2] & 19136992) == 0) {
            class163.field2211[var18] = var4;
            class163.field2212[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class163.field2204[var16][var17 + 1] = 4;
            class163.field2207[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class163.field2204[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
            class163.field2211[var18] = var4 - 1;
            class163.field2212[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class163.field2204[var16 - 1][var17 - 1] = 3;
            class163.field2207[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 126 && var17 > 0 && class163.field2204[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136911) == 0 && (var12[var13 + 2][var14 - 1] & 19136899) == 0 && (var12[var13 + 2][var14] & 19136995) == 0) {
            class163.field2211[var18] = var4 + 1;
            class163.field2212[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class163.field2204[var16 + 1][var17 - 1] = 9;
            class163.field2207[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 126 && class163.field2204[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136830) == 0 && (var12[var13 - 1][var14 + 2] & 19136824) == 0 && (var12[var13][var14 + 2] & 19137016) == 0) {
            class163.field2211[var18] = var4 - 1;
            class163.field2212[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class163.field2204[var16 - 1][var17 + 1] = 6;
            class163.field2207[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 126 && var17 < 126 && class163.field2204[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 2] & 19137016) == 0 && (var12[var13 + 2][var14 + 2] & 19136992) == 0 && (var12[var13 + 2][var14 + 1] & 19136995) == 0) {
            class163.field2211[var18] = var4 + 1;
            class163.field2212[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class163.field2204[var16 + 1][var17 + 1] = 12;
            class163.field2207[var16 + 1][var17 + 1] = var15;
         }
      }

      class163.field2208 = var4;
      class163.field2209 = var5;
      return false;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)[Lin;",
      garbageValue = "-1444008027"
   )
   public static Permission[] method112() {
      return new Permission[]{Permission.field3238, Permission.field3242, Permission.field3234, Permission.field3241, Permission.field3237, Permission.field3236};
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-10796"
   )
   public static final void method110() {
      while(true) {
         class9 var0 = (class9)class7.field228.method3756();
         if(var0 == null) {
            return;
         }

         var0.vmethod54();
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IZII)V",
      garbageValue = "2078666992"
   )
   public static final void method109(int var0, boolean var1, int var2) {
      if(var0 >= 8000 && var0 <= 48000) {
         AbstractSoundSystem.sampleRate = var0;
         AbstractSoundSystem.highMemory = var1;
         AbstractSoundSystem.priority = var2;
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "(Lhk;III)V",
      garbageValue = "-1759895"
   )
   static void method106(Widget var0, int var1, int var2) {
      if(var0.field2731 == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.field2731 == 1) {
         var0.relativeX = var0.originalX + (var1 - var0.width) / 2;
      } else if(var0.field2731 == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.field2731 == 3) {
         var0.relativeX = var0.originalX * var1 >> 14;
      } else if(var0.field2731 == 4) {
         var0.relativeX = (var1 - var0.width) / 2 + (var0.originalX * var1 >> 14);
      } else {
         var0.relativeX = var1 - var0.width - (var0.originalX * var1 >> 14);
      }

      if(var0.field2732 == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.field2732 == 1) {
         var0.relativeY = (var2 - var0.height) / 2 + var0.originalY;
      } else if(var0.field2732 == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.field2732 == 3) {
         var0.relativeY = var2 * var0.originalY >> 14;
      } else if(var0.field2732 == 4) {
         var0.relativeY = (var2 - var0.height) / 2 + (var2 * var0.originalY >> 14);
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.originalY >> 14);
      }

      if(Client.field1081 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.width + var0.relativeX > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.height + var0.relativeY > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }
}

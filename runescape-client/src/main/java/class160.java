import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
public class class160 {
   @ObfuscatedName("s")
   static boolean field2159;
   @ObfuscatedName("g")
   static File field2157;
   @ObfuscatedName("m")
   static Hashtable field2158;
   @ObfuscatedName("d")
   static byte[][][] field2156;
   @ObfuscatedName("ev")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   static class159 field2161;

   static {
      field2159 = false;
      field2158 = new Hashtable(16);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lin;",
      garbageValue = "903625241"
   )
   public static VarPlayerType method3258(int var0) {
      VarPlayerType var1 = (VarPlayerType)VarPlayerType.varplayers.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = TotalQuantityComparator.varplayer_ref.getConfigData(16, var0);
         var1 = new VarPlayerType();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         VarPlayerType.varplayers.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IILfj;Lfb;B)Z",
      garbageValue = "-17"
   )
   static final boolean method3260(int var0, int var1, class168 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class167.field2224[var6][var7] = 99;
      class167.field2222[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class167.field2219[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class167.field2225[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var11 != var18) {
         var4 = class167.field2219[var11];
         var5 = class167.field2225[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod3396(2, var4, var5, var3)) {
            VarPlayerType.field3371 = var4;
            class175.field2446 = var5;
            return true;
         }

         int var15 = class167.field2222[var16][var17] + 1;
         if(var16 > 0 && class167.field2224[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136782) == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0) {
            class167.field2219[var18] = var4 - 1;
            class167.field2225[var18] = var5;
            var18 = var18 + 1 & 4095;
            class167.field2224[var16 - 1][var17] = 2;
            class167.field2222[var16 - 1][var17] = var15;
         }

         if(var16 < 126 && class167.field2224[var16 + 1][var17] == 0 && (var12[var13 + 2][var14] & 19136899) == 0 && (var12[var13 + 2][var14 + 1] & 19136992) == 0) {
            class167.field2219[var18] = var4 + 1;
            class167.field2225[var18] = var5;
            var18 = var18 + 1 & 4095;
            class167.field2224[var16 + 1][var17] = 8;
            class167.field2222[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class167.field2224[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136782) == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0) {
            class167.field2219[var18] = var4;
            class167.field2225[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class167.field2224[var16][var17 - 1] = 1;
            class167.field2222[var16][var17 - 1] = var15;
         }

         if(var17 < 126 && class167.field2224[var16][var17 + 1] == 0 && (var12[var13][var14 + 2] & 19136824) == 0 && (var12[var13 + 1][var14 + 2] & 19136992) == 0) {
            class167.field2219[var18] = var4;
            class167.field2225[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class167.field2224[var16][var17 + 1] = 4;
            class167.field2222[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class167.field2224[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
            class167.field2219[var18] = var4 - 1;
            class167.field2225[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class167.field2224[var16 - 1][var17 - 1] = 3;
            class167.field2222[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 126 && var17 > 0 && class167.field2224[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136911) == 0 && (var12[var13 + 2][var14 - 1] & 19136899) == 0 && (var12[var13 + 2][var14] & 19136995) == 0) {
            class167.field2219[var18] = var4 + 1;
            class167.field2225[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class167.field2224[var16 + 1][var17 - 1] = 9;
            class167.field2222[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 126 && class167.field2224[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136830) == 0 && (var12[var13 - 1][var14 + 2] & 19136824) == 0 && (var12[var13][var14 + 2] & 19137016) == 0) {
            class167.field2219[var18] = var4 - 1;
            class167.field2225[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class167.field2224[var16 - 1][var17 + 1] = 6;
            class167.field2222[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 126 && var17 < 126 && class167.field2224[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 2] & 19137016) == 0 && (var12[var13 + 2][var14 + 2] & 19136992) == 0 && (var12[var13 + 2][var14 + 1] & 19136995) == 0) {
            class167.field2219[var18] = var4 + 1;
            class167.field2225[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class167.field2224[var16 + 1][var17 + 1] = 12;
            class167.field2222[var16 + 1][var17 + 1] = var15;
         }
      }

      VarPlayerType.field3371 = var4;
      class175.field2446 = var5;
      return false;
   }

   @ObfuscatedName("ky")
   @ObfuscatedSignature(
      signature = "(Lhs;I)Lhs;",
      garbageValue = "574348008"
   )
   static Widget method3261(Widget var0) {
      int var2 = WorldComparator.getWidgetConfig(var0);
      int var1 = var2 >> 17 & 7;
      int var3 = var1;
      if(var1 == 0) {
         return null;
      } else {
         for(int var4 = 0; var4 < var3; ++var4) {
            var0 = class216.getWidget(var0.parentId);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }
}

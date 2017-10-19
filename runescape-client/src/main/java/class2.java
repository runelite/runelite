import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
final class class2 implements class0 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   public static IndexDataBase field21;
   @ObfuscatedName("c")
   @Export("osName")
   public static String osName;
   @ObfuscatedName("fj")
   @Export("landRegionFielIds")
   static int[] landRegionFielIds;
   @ObfuscatedName("o")
   @Export("underlayIds")
   static byte[][][] underlayIds;
   @ObfuscatedName("nw")
   @ObfuscatedGetter(
      intValue = 144073137
   )
   @Export("clanChatCount")
   static int clanChatCount;

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "(Lhj;B)Z",
      garbageValue = "30"
   )
   static final boolean method2(Widget var0) {
      if(var0.tableActions == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.tableActions.length; ++var1) {
            int var2 = class9.method52(var0, var1);
            int var3 = var0.field2756[var1];
            if(var0.tableActions[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var2 != var3) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lip;I)V",
      garbageValue = "1414534990"
   )
   public static void method4(IndexDataBase var0) {
      class251.field3385 = var0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIIII[Lfw;B)V",
      garbageValue = "90"
   )
   static final void method3(byte[] var0, int var1, int var2, int var3, int var4, CollisionData[] var5) {
      int var7;
      int var8;
      for(int var6 = 0; var6 < 4; ++var6) {
         for(var7 = 0; var7 < 64; ++var7) {
            for(var8 = 0; var8 < 64; ++var8) {
               if(var7 + var1 > 0 && var7 + var1 < 103 && var8 + var2 > 0 && var8 + var2 < 103) {
                  var5[var6].flags[var7 + var1][var8 + var2] &= -16777217;
               }
            }
         }
      }

      Buffer var10 = new Buffer(var0);

      for(var7 = 0; var7 < 4; ++var7) {
         for(var8 = 0; var8 < 64; ++var8) {
            for(int var9 = 0; var9 < 64; ++var9) {
               ItemContainer.loadTerrain(var10, var7, var8 + var1, var9 + var2, var3, var4, 0);
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "599683087"
   )
   public static int method1(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }
}

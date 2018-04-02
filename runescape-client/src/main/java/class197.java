import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
public class class197 {
   @ObfuscatedName("r")
   static final int[] field2589;
   @ObfuscatedName("d")
   static final int[] field2590;

   static {
      field2589 = new int[2048];
      field2590 = new int[2048];
      double var0 = 0.0030679615757712823D;

      for(int var2 = 0; var2 < 2048; ++var2) {
         field2589[var2] = (int)(65536.0D * Math.sin((double)var2 * var0));
         field2590[var2] = (int)(65536.0D * Math.cos(var0 * (double)var2));
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljm;I)V",
      garbageValue = "1008043309"
   )
   public static void method3753(IndexDataBase var0) {
      InvType.field3438 = var0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1144178325"
   )
   static final void method3754(int var0) {
      short var1 = 256;
      class90.field1349 += var0 * 128;
      int var2;
      if(class90.field1349 > BaseVarType.field30.length) {
         class90.field1349 -= BaseVarType.field30.length;
         var2 = (int)(Math.random() * 12.0D);
         class20.method169(class90.runeSprites[var2]);
      }

      var2 = 0;
      int var3 = var0 * 128;
      int var4 = (var1 - var0) * 128;

      int var5;
      int var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = class90.field1362[var3 + var2] - var0 * BaseVarType.field30[var2 + class90.field1349 & BaseVarType.field30.length - 1] / 6;
         if(var6 < 0) {
            var6 = 0;
         }

         class90.field1362[var2++] = var6;
      }

      int var7;
      int var8;
      for(var5 = var1 - var0; var5 < var1; ++var5) {
         var6 = var5 * 128;

         for(var7 = 0; var7 < 128; ++var7) {
            var8 = (int)(Math.random() * 100.0D);
            if(var8 < 50 && var7 > 10 && var7 < 118) {
               class90.field1362[var6 + var7] = 255;
            } else {
               class90.field1362[var6 + var7] = 0;
            }
         }
      }

      if(class90.field1346 > 0) {
         class90.field1346 -= var0 * 4;
      }

      if(class90.field1357 > 0) {
         class90.field1357 -= var0 * 4;
      }

      if(class90.field1346 == 0 && class90.field1357 == 0) {
         var5 = (int)(Math.random() * (double)(2000 / var0));
         if(var5 == 0) {
            class90.field1346 = 1024;
         }

         if(var5 == 1) {
            class90.field1357 = 1024;
         }
      }

      for(var5 = 0; var5 < var1 - var0; ++var5) {
         class90.field1360[var5] = class90.field1360[var0 + var5];
      }

      for(var5 = var1 - var0; var5 < var1; ++var5) {
         class90.field1360[var5] = (int)(Math.sin((double)class90.field1352 / 14.0D) * 16.0D + Math.sin((double)class90.field1352 / 15.0D) * 14.0D + Math.sin((double)class90.field1352 / 16.0D) * 12.0D);
         ++class90.field1352;
      }

      class90.field1365 += var0;
      var5 = (var0 + (Client.gameCycle & 1)) / 2;
      if(var5 > 0) {
         for(var6 = 0; var6 < class90.field1365 * 100; ++var6) {
            var7 = (int)(Math.random() * 124.0D) + 2;
            var8 = (int)(Math.random() * 128.0D) + 128;
            class90.field1362[var7 + (var8 << 7)] = 192;
         }

         class90.field1365 = 0;

         int var9;
         for(var6 = 0; var6 < var1; ++var6) {
            var7 = 0;
            var8 = var6 * 128;

            for(var9 = -var5; var9 < 128; ++var9) {
               if(var5 + var9 < 128) {
                  var7 += class90.field1362[var8 + var9 + var5];
               }

               if(var9 - (var5 + 1) >= 0) {
                  var7 -= class90.field1362[var9 + var8 - (var5 + 1)];
               }

               if(var9 >= 0) {
                  RunException.field2181[var9 + var8] = var7 / (var5 * 2 + 1);
               }
            }
         }

         for(var6 = 0; var6 < 128; ++var6) {
            var7 = 0;

            for(var8 = -var5; var8 < var1; ++var8) {
               var9 = var8 * 128;
               if(var8 + var5 < var1) {
                  var7 += RunException.field2181[var6 + var9 + var5 * 128];
               }

               if(var8 - (var5 + 1) >= 0) {
                  var7 -= RunException.field2181[var9 + var6 - (var5 + 1) * 128];
               }

               if(var8 >= 0) {
                  class90.field1362[var6 + var9] = var7 / (var5 * 2 + 1);
               }
            }
         }
      }

   }
}

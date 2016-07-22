import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("ItemLayer")
public final class class102 {
   @ObfuscatedName("g")
   @Export("bottom")
   class88 field1742;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 821571587
   )
   @Export("x")
   int field1743;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -275431283
   )
   @Export("y")
   int field1744;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1950281917
   )
   @Export("hash")
   int field1745;
   @ObfuscatedName("l")
   @Export("top")
   class88 field1747;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1713367687
   )
   @Export("flags")
   int field1748;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1331298351
   )
   @Export("height")
   int field1749;
   @ObfuscatedName("m")
   @Export("middle")
   class88 field1754;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;I)V",
      garbageValue = "-1663987279"
   )
   public static void method2281(File var0) {
      class138.field2135 = var0;
      if(!class138.field2135.exists()) {
         throw new RuntimeException("");
      } else {
         class138.field2136 = true;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([Lclass27;II[I[IB)V",
      garbageValue = "18"
   )
   static void method2282(class27[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var1 + var2) / 2;
         class27 var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].field656;
                     var12 = var8.field656;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].field652;
                     var12 = var8.field652;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method614()?1:0;
                     var12 = var8.method614()?1:0;
                  } else {
                     var11 = var0[var6].field650;
                     var12 = var8.field650;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].field656;
                     var12 = var8.field656;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].field652;
                     var12 = var8.field652;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method614()?1:0;
                     var12 = var8.method614()?1:0;
                  } else {
                     var11 = var0[var5].field650;
                     var12 = var8.field650;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               class27 var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method2282(var0, var1, var6, var3, var4);
         method2282(var0, var6 + 1, var2, var3, var4);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Lclass156;",
      garbageValue = "-1771010477"
   )
   public static class156 method2283(int var0) {
      class156[] var1 = new class156[]{class156.field2331, class156.field2332, class156.field2335, class156.field2333};
      class156[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class156 var4 = var2[var3];
         if(var0 == var4.field2330) {
            return var4;
         }
      }

      return null;
   }
}

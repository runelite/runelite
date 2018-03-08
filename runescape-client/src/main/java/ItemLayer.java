import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1254525043
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 68132991
   )
   @Export("x")
   int x;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1274282831
   )
   @Export("y")
   int y;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   @Export("top")
   Renderable top;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2143649393
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -27647469
   )
   @Export("height")
   int height;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILiw;I)I",
      garbageValue = "-646919406"
   )
   public static int method2591(int var0, class245 var1) {
      return (var0 + 40000 << 8) + var1.field2961;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljc;Ljc;Ljc;Lhk;I)Z",
      garbageValue = "-2138447228"
   )
   public static boolean method2590(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2, class230 var3) {
      WorldComparator.field258 = var0;
      class243.field2953 = var1;
      class229.field2675 = var2;
      class229.field2673 = var3;
      return true;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([Lbd;II[I[II)V",
      garbageValue = "687808026"
   )
   static void method2592(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var2 + var1) / 2;
         World var8 = var0[var7];
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
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method1690()?1:0;
                     var12 = var8.method1690()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
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
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method1690()?1:0;
                     var12 = var8.method1690()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
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
               World var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method2592(var0, var1, var6, var3, var4);
         method2592(var0, var6 + 1, var2, var3, var4);
      }

   }
}

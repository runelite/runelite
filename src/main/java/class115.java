import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dt")
public class class115 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 8142247075773493457L
   )
   static long field1954;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 6641607952818558247L
   )
   static long field1955;
   @ObfuscatedName("bi")
   static class168 field1956;
   @ObfuscatedName("v")
   static int[] field1957;

   @ObfuscatedName("s")
   public static class78 method2466(class167 var0, int var1, int var2) {
      return !class23.method586(var0, var1, var2)?null:class41.method854();
   }

   @ObfuscatedName("as")
   static final void method2467() {
      if(1 == client.field390) {
         class90.field1544[client.field389 / 100].method1709(client.field421 - 8, client.field277 - 8);
      }

      if(client.field390 == 2) {
         class90.field1544[4 + client.field389 / 100].method1709(client.field421 - 8, client.field277 - 8);
      }

      client.field307 = 0;
      int var0 = class85.field1439 + (class20.field572.field804 >> 7);
      int var1 = (class20.field572.field814 >> 7) + class6.field128;
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         client.field307 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         client.field307 = 1;
      }

      if(client.field307 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         client.field307 = 0;
      }

   }

   @ObfuscatedName("co")
   static final int method2468(class173 var0, int var1) {
      if(var0.field2867 != null && var1 < var0.field2867.length) {
         try {
            int[] var2 = var0.field2867[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = client.field492[var2[var4++]];
               }

               if(2 == var6) {
                  var7 = client.field415[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = client.field552[var2[var4++]];
               }

               int var9;
               class173 var10;
               int var11;
               int var12;
               if(4 == var6) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class148.method3129(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class33.method711(var11).field1123 || client.field284)) {
                     for(var12 = 0; var12 < var10.field2759.length; ++var12) {
                        if(var10.field2759[var12] == var11 + 1) {
                           var7 += var10.field2873[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class176.field2903[var2[var4++]];
               }

               if(6 == var6) {
                  var7 = class155.field2284[client.field415[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class176.field2903[var2[var4++]] * 100 / '뜛';
               }

               if(8 == var6) {
                  var7 = class20.field572.field39;
               }

               if(9 == var6) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class155.field2282[var9]) {
                        var7 += client.field415[var9];
                     }
                  }
               }

               if(10 == var6) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class148.method3129(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class33.method711(var11).field1123 || client.field284)) {
                     for(var12 = 0; var12 < var10.field2759.length; ++var12) {
                        if(1 + var11 == var10.field2759[var12]) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = client.field443;
               }

               if(12 == var6) {
                  var7 = client.field365;
               }

               if(13 == var6) {
                  var9 = class176.field2903[var2[var4++]];
                  int var14 = var2[var4++];
                  var7 = 0 != (var9 & 1 << var14)?1:0;
               }

               if(14 == var6) {
                  var9 = var2[var4++];
                  var7 = class142.method2979(var9);
               }

               if(15 == var6) {
                  var8 = 1;
               }

               if(16 == var6) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = class85.field1439 + (class20.field572.field804 >> 7);
               }

               if(19 == var6) {
                  var7 = class6.field128 + (class20.field572.field814 >> 7);
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && 0 != var7) {
                     var3 /= var7;
                  }

                  if(3 == var5) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var13) {
            return -1;
         }
      } else {
         return -2;
      }
   }
}

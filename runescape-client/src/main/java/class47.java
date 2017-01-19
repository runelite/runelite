import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public class class47 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 839325103
   )
   static int field921 = 0;
   @ObfuscatedName("f")
   static final class136 field922 = new class136();
   @ObfuscatedName("s")
   @Export("chatLineMap")
   static final Map chatLineMap = new HashMap();
   @ObfuscatedName("bq")
   static class184 field924;
   @ObfuscatedName("c")
   static final class121 field927 = new class121(1024);
   @ObfuscatedName("nk")
   static class57 field929;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([LWorld;II[I[II)V",
      garbageValue = "-1960189380"
   )
   static void method833(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = 1 + var2;
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
                     var11 = var0[var6].method621()?1:0;
                     var12 = var8.method621()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
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
                     var11 = var0[var5].method621()?1:0;
                     var12 = var8.method621()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
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
               World var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method833(var0, var1, var6, var3, var4);
         method833(var0, var6 + 1, var2, var3, var4);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass159;II)V",
      garbageValue = "1634609534"
   )
   static final void method840(class159 var0, int var1) {
      int var2 = var0.offset;
      class45.field901 = 0;
      int var3 = 0;
      var0.method2982();

      int var4;
      int var5;
      int var6;
      for(var4 = 0; var4 < class45.field894; ++var4) {
         var5 = class45.field896[var4];
         if((class45.field891[var5] & 1) == 0) {
            if(var3 > 0) {
               --var3;
               class45.field891[var5] = (byte)(class45.field891[var5] | 2);
            } else {
               var6 = var0.method2973(1);
               if(var6 == 0) {
                  var3 = class18.method163(var0);
                  class45.field891[var5] = (byte)(class45.field891[var5] | 2);
               } else {
                  class8.method94(var0, var5);
               }
            }
         }
      }

      var0.method2967();
      if(var3 != 0) {
         throw new RuntimeException();
      } else {
         var0.method2982();

         for(var4 = 0; var4 < class45.field894; ++var4) {
            var5 = class45.field896[var4];
            if((class45.field891[var5] & 1) != 0) {
               if(var3 > 0) {
                  --var3;
                  class45.field891[var5] = (byte)(class45.field891[var5] | 2);
               } else {
                  var6 = var0.method2973(1);
                  if(var6 == 0) {
                     var3 = class18.method163(var0);
                     class45.field891[var5] = (byte)(class45.field891[var5] | 2);
                  } else {
                     class8.method94(var0, var5);
                  }
               }
            }
         }

         var0.method2967();
         if(var3 != 0) {
            throw new RuntimeException();
         } else {
            var0.method2982();

            for(var4 = 0; var4 < class45.field902; ++var4) {
               var5 = class45.field897[var4];
               if((class45.field891[var5] & 1) != 0) {
                  if(var3 > 0) {
                     --var3;
                     class45.field891[var5] = (byte)(class45.field891[var5] | 2);
                  } else {
                     var6 = var0.method2973(1);
                     if(var6 == 0) {
                        var3 = class18.method163(var0);
                        class45.field891[var5] = (byte)(class45.field891[var5] | 2);
                     } else if(class94.method1855(var0, var5)) {
                        class45.field891[var5] = (byte)(class45.field891[var5] | 2);
                     }
                  }
               }
            }

            var0.method2967();
            if(var3 != 0) {
               throw new RuntimeException();
            } else {
               var0.method2982();

               for(var4 = 0; var4 < class45.field902; ++var4) {
                  var5 = class45.field897[var4];
                  if((class45.field891[var5] & 1) == 0) {
                     if(var3 > 0) {
                        --var3;
                        class45.field891[var5] = (byte)(class45.field891[var5] | 2);
                     } else {
                        var6 = var0.method2973(1);
                        if(var6 == 0) {
                           var3 = class18.method163(var0);
                           class45.field891[var5] = (byte)(class45.field891[var5] | 2);
                        } else if(class94.method1855(var0, var5)) {
                           class45.field891[var5] = (byte)(class45.field891[var5] | 2);
                        }
                     }
                  }
               }

               var0.method2967();
               if(var3 != 0) {
                  throw new RuntimeException();
               } else {
                  class45.field894 = 0;
                  class45.field902 = 0;

                  for(var4 = 1; var4 < 2048; ++var4) {
                     class45.field891[var4] = (byte)(class45.field891[var4] >> 1);
                     Player var7 = Client.cachedPlayers[var4];
                     if(var7 != null) {
                        class45.field896[++class45.field894 - 1] = var4;
                     } else {
                        class45.field897[++class45.field902 - 1] = var4;
                     }
                  }

                  ObjectComposition.method3516(var0);
                  if(var1 != var0.offset - var2) {
                     throw new RuntimeException(var0.offset - var2 + " " + var1);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1318223743"
   )
   static void method841(int var0) {
      class2.field31 = new class38();
      class2.field31.field791 = Client.menuActionParams0[var0];
      class2.field31.field787 = Client.menuActionParams1[var0];
      class2.field31.field788 = Client.menuTypes[var0];
      class2.field31.field789 = Client.menuIdentifiers[var0];
      class2.field31.field790 = Client.menuOptions[var0];
   }
}

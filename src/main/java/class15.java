import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
@Implements("XItemContainer")
public class class15 extends class208 {
   @ObfuscatedName("x")
   @Export("itemIds")
   int[] field228 = new int[]{-1};
   @ObfuscatedName("t")
   @Export("stackSizes")
   int[] field229 = new int[]{0};
   @ObfuscatedName("qd")
   @ObfuscatedGetter(
      intValue = 91842841
   )
   protected static int field233;
   @ObfuscatedName("w")
   @Export("itemContainers")
   static class196 field234 = new class196(32);
   @ObfuscatedName("ql")
   @ObfuscatedGetter(
      intValue = 1967363409
   )
   public static int field235;

   @ObfuscatedName("ab")
   static void method171(int var0) {
      client.field507 = 0L;
      if(var0 >= 2) {
         client.field508 = true;
      } else {
         client.field508 = false;
      }

      class31.method698();
      if(client.field303 >= 25) {
         class56.method1241();
      }

      class144.field2223 = true;
   }

   @ObfuscatedName("c")
   public static boolean method175(char var0) {
      return var0 >= 48 && var0 <= 57;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([Lclass25;II[I[II)V",
      garbageValue = "1615780548"
   )
   static void method176(class25[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var1 + var2) / 2;
         class25 var8 = var0[var7];
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
                     var11 = var0[var6].field652;
                     var12 = var8.field652;
                  } else if(1 == var3[var10]) {
                     var11 = var0[var6].field638;
                     var12 = var8.field638;
                     if(var11 == -1 && 1 == var4[var10]) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method635()?1:0;
                     var12 = var8.method635()?1:0;
                  } else {
                     var11 = var0[var6].field650;
                     var12 = var8.field650;
                  }

                  if(var12 != var11) {
                     if((1 != var4[var10] || var11 <= var12) && (0 != var4[var10] || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(3 == var10) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].field652;
                     var12 = var8.field652;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].field638;
                     var12 = var8.field638;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(-1 == var12 && 1 == var4[var10]) {
                        var12 = 2001;
                     }
                  } else if(3 == var3[var10]) {
                     var11 = var0[var5].method635()?1:0;
                     var12 = var8.method635()?1:0;
                  } else {
                     var11 = var0[var5].field650;
                     var12 = var8.field650;
                  }

                  if(var12 != var11) {
                     if((1 != var4[var10] || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(3 == var10) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               class25 var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method176(var0, var1, var6, var3, var4);
         method176(var0, 1 + var6, var2, var3, var4);
      }

   }

   @ObfuscatedName("x")
   static int method178(int var0, int var1) {
      class15 var2 = (class15)field234.method3806((long)var0);
      if(null == var2) {
         return 0;
      } else if(-1 == var1) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.field229.length; ++var4) {
            if(var2.field228[var4] == var1) {
               var3 += var2.field229[var4];
            }
         }

         return var3;
      }
   }

   @ObfuscatedName("cn")
   static final int method179(class173 var0, int var1) {
      if(var0.field2879 != null && var1 < var0.field2879.length) {
         try {
            int[] var2 = var0.field2879[var1];
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

               if(1 == var6) {
                  var7 = client.field429[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = client.field537[var2[var4++]];
               }

               if(3 == var6) {
                  var7 = client.field464[var2[var4++]];
               }

               int var9;
               class173 var10;
               int var11;
               int var12;
               if(4 == var6) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class52.method1115(var9);
                  var11 = var2[var4++];
                  if(-1 != var11 && (!class50.method1055(var11).field1135 || client.field300)) {
                     for(var12 = 0; var12 < var10.field2885.length; ++var12) {
                        if(1 + var11 == var10.field2885[var12]) {
                           var7 += var10.field2886[var12];
                        }
                     }
                  }
               }

               if(5 == var6) {
                  var7 = class176.field2916[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class155.field2319[client.field537[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class176.field2916[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = class167.field2692.field50;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class155.field2320[var9]) {
                        var7 += client.field537[var9];
                     }
                  }
               }

               if(10 == var6) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class52.method1115(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class50.method1055(var11).field1135 || client.field300)) {
                     for(var12 = 0; var12 < var10.field2885.length; ++var12) {
                        if(var10.field2885[var12] == var11 + 1) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(11 == var6) {
                  var7 = client.field522;
               }

               if(var6 == 12) {
                  var7 = client.field460;
               }

               if(var6 == 13) {
                  var9 = class176.field2916[var2[var4++]];
                  int var14 = var2[var4++];
                  var7 = 0 != (var9 & 1 << var14)?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class152.method3179(var9);
               }

               if(15 == var6) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = (class167.field2692.field849 >> 7) + class41.field990;
               }

               if(19 == var6) {
                  var7 = class2.field37 + (class167.field2692.field819 >> 7);
               }

               if(20 == var6) {
                  var7 = var2[var4++];
               }

               if(0 == var8) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
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

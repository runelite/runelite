import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
public class class8 {
   @ObfuscatedName("g")
   boolean field138;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -907157305
   )
   static int field139 = 4;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2061921183
   )
   int field140 = 1;
   @ObfuscatedName("r")
   LinkedHashMap field141 = new LinkedHashMap();
   @ObfuscatedName("a")
   public static String[] field143;
   @ObfuscatedName("h")
   boolean field145;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;III)Lclass224;",
      garbageValue = "2124222121"
   )
   public static class224 method90(class167 var0, class167 var1, int var2, int var3) {
      return !class21.method551(var0, var2, var3)?null:class26.method616(var1.method3221(var2, var3));
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1"
   )
   void method92(boolean var1) {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Lclass119;",
      garbageValue = "-1553982331"
   )
   class119 method93() {
      class119 var1 = new class119(100);
      var1.method2453(field139);
      var1.method2453(this.field138?1:0);
      var1.method2453(this.field145?1:0);
      var1.method2453(this.field140);
      var1.method2453(this.field141.size());
      Iterator var2 = this.field141.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method2456(((Integer)var3.getKey()).intValue());
         var1.method2456(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1367402400"
   )
   static final int method97(int var0, int var1) {
      int var2 = class125.method2766(var0 - 1, var1 - 1) + class125.method2766(1 + var0, var1 - 1) + class125.method2766(var0 - 1, 1 + var1) + class125.method2766(1 + var0, var1 + 1);
      int var3 = class125.method2766(var0 - 1, var1) + class125.method2766(1 + var0, var1) + class125.method2766(var0, var1 - 1) + class125.method2766(var0, var1 + 1);
      int var4 = class125.method2766(var0, var1);
      return var4 / 4 + var3 / 8 + var2 / 16;
   }

   class8(class119 var1) {
      if(null != var1 && null != var1.field2001) {
         int var2 = var1.method2494();
         if(var2 >= 0 && var2 <= field139) {
            if(var1.method2494() == 1) {
               this.field138 = true;
            }

            if(var2 > 1) {
               this.field145 = var1.method2494() == 1;
            }

            if(var2 > 3) {
               this.field140 = var1.method2494();
            }

            if(var2 > 2) {
               int var3 = var1.method2494();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.method2505();
                  int var6 = var1.method2505();
                  this.field141.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method92(true);
         }
      } else {
         this.method92(true);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([Lclass25;II[I[IB)V",
      garbageValue = "28"
   )
   static void method103(class25[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var2 + var1) / 2;
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
                     var11 = var0[var6].field638;
                     var12 = var8.field638;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].field639;
                     var12 = var8.field639;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method579()?1:0;
                     var12 = var8.method579()?1:0;
                  } else {
                     var11 = var0[var6].field637;
                     var12 = var8.field637;
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
                     var11 = var0[var5].field638;
                     var12 = var8.field638;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].field639;
                     var12 = var8.field639;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method579()?1:0;
                     var12 = var8.method579()?1:0;
                  } else {
                     var11 = var0[var5].field637;
                     var12 = var8.field637;
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
               class25 var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method103(var0, var1, var6, var3, var4);
         method103(var0, 1 + var6, var2, var3, var4);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass168;II)V",
      garbageValue = "386079514"
   )
   static void method104(class168 var0, int var1) {
      if(null != class189.field3063) {
         class189.field3063.field2000 = var1 * 8 + 5;
         int var2 = class189.field3063.method2505();
         int var3 = class189.field3063.method2505();
         var0.method3308(var2, var3);
      } else {
         class124.method2749((class168)null, 255, 255, 0, (byte)0, true);
         class171.field2756[var1] = var0;
      }
   }

   class8() {
      this.method92(true);
   }
}

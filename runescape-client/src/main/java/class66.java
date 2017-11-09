import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
public class class66 extends class203 {
   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   public static BufferProvider field779;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -857809371
   )
   int field778;
   @ObfuscatedName("p")
   String field776;
   @ObfuscatedName("i")
   short field777;

   class66(String var1, int var2) {
      this.field778 = (int)(class268.currentTimeMs() / 1000L);
      this.field776 = var1;
      this.field777 = (short)var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIIB)V",
      garbageValue = "-79"
   )
   static void method1154(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method1154(var0, var1, var2, var5 - 1);
         method1154(var0, var1, var5 + 1, var3);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([Lcd;II[I[IB)V",
      garbageValue = "-37"
   )
   static void method1153(World[] var0, int var1, int var2, int[] var3, int[] var4) {
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
                     var11 = var0[var6].method1640()?1:0;
                     var12 = var8.method1640()?1:0;
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
                     var11 = var0[var5].method1640()?1:0;
                     var12 = var8.method1640()?1:0;
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

         method1153(var0, var1, var6, var3, var4);
         method1153(var0, var6 + 1, var2, var3, var4);
      }

   }

   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "1966275604"
   )
   @Export("drawStatusBox")
   static final void drawStatusBox(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = var2 + 6;
      int var5 = class48.font_p12full.method4956(var0, 250);
      int var6 = class48.font_p12full.method4929(var0, 250) * 13;
      Rasterizer2D.method5151(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 0);
      Rasterizer2D.drawRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6, 16777215);
      class48.font_p12full.method4935(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class22.method180(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var6 + var2);
      if(var1) {
         field779.vmethod5235(0, 0);
      } else {
         class182.method3521(var3, var4, var5, var6);
      }

   }
}

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
public class class143 extends class68 {
   @ObfuscatedName("nm")
   @ObfuscatedGetter(
      intValue = -861388979
   )
   static int field2006;
   @ObfuscatedName("nd")
   static class51 field2007;
   @ObfuscatedName("m")
   class51 field2008 = new class51();
   @ObfuscatedName("n")
   class139 field2009;
   @ObfuscatedName("d")
   Deque field2013 = new Deque();
   @ObfuscatedName("ao")
   static class184 field2015;

   @ObfuscatedName("r")
   protected class68 vmethod2748() {
      class140 var1 = (class140)this.field2013.method2466();
      return (class68)(var1 == null?null:(null != var1.field1971?var1.field1971:this.vmethod2750()));
   }

   @ObfuscatedName("c")
   protected class68 vmethod2750() {
      class140 var1;
      do {
         var1 = (class140)this.field2013.method2461();
         if(var1 == null) {
            return null;
         }
      } while(null == var1.field1971);

      return var1.field1971;
   }

   @ObfuscatedName("z")
   protected int vmethod2751() {
      return 0;
   }

   @ObfuscatedName("y")
   protected void vmethod2752(int var1) {
      this.field2008.vmethod2752(var1);

      for(class140 var3 = (class140)this.field2013.method2466(); null != var3; var3 = (class140)this.field2013.method2461()) {
         if(!this.field2009.method2602(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field1959) {
                  this.method2753(var3, var2);
                  var3.field1959 -= var2;
                  break;
               }

               this.method2753(var3, var3.field1959);
               var2 -= var3.field1959;
            } while(!this.field2009.method2613(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass140;II)V",
      garbageValue = "321445088"
   )
   void method2753(class140 var1, int var2) {
      if((this.field2009.field1932[var1.field1953] & 4) != 0 && var1.field1967 < 0) {
         int var3 = this.field2009.field1940[var1.field1953] / class57.field1031;
         int var4 = (1048575 + var3 - var1.field1974) / var3;
         var1.field1974 = var1.field1974 + var3 * var2 & 1048575;
         if(var4 <= var2) {
            if(this.field2009.field1938[var1.field1953] == 0) {
               var1.field1971 = class66.method1220(var1.field1955, var1.field1971.method1190(), var1.field1971.method1226(), var1.field1971.method1247());
            } else {
               var1.field1971 = class66.method1220(var1.field1955, var1.field1971.method1190(), 0, var1.field1971.method1247());
               this.field2009.method2562(var1, var1.field1976.field2004[var1.field1958] < 0);
            }

            if(var1.field1976.field2004[var1.field1958] < 0) {
               var1.field1971.method1192(-1);
            }

            var2 = var1.field1974 / var3;
         }
      }

      var1.field1971.vmethod2752(var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass140;[IIIII)V",
      garbageValue = "1361774454"
   )
   void method2754(class140 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2009.field1932[var1.field1953] & 4) != 0 && var1.field1967 < 0) {
         int var6 = this.field2009.field1940[var1.field1953] / class57.field1031;

         while(true) {
            int var7 = (1048575 + var6 - var1.field1974) / var6;
            if(var7 > var4) {
               var1.field1974 += var6 * var4;
               break;
            }

            var1.field1971.vmethod2764(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field1974 += var7 * var6 - 1048576;
            int var8 = class57.field1031 / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class66 var10 = var1.field1971;
            if(this.field2009.field1938[var1.field1953] == 0) {
               var1.field1971 = class66.method1220(var1.field1955, var10.method1190(), var10.method1226(), var10.method1247());
            } else {
               var1.field1971 = class66.method1220(var1.field1955, var10.method1190(), 0, var10.method1247());
               this.field2009.method2562(var1, var1.field1976.field2004[var1.field1958] < 0);
               var1.field1971.method1186(var8, var10.method1226());
            }

            if(var1.field1976.field2004[var1.field1958] < 0) {
               var1.field1971.method1192(-1);
            }

            var10.method1188(var8);
            var10.vmethod2764(var2, var3, var5 - var3);
            if(var10.method1246()) {
               this.field2008.method914(var10);
            }
         }
      }

      var1.field1971.vmethod2764(var2, var3, var4);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1827321240"
   )
   public static String method2755(int var0) {
      return (var0 >> 24 & 255) + "." + (var0 >> 16 & 255) + "." + (var0 >> 8 & 255) + "." + (var0 & 255);
   }

   @ObfuscatedName("q")
   protected void vmethod2764(int[] var1, int var2, int var3) {
      this.field2008.vmethod2764(var1, var2, var3);

      for(class140 var6 = (class140)this.field2013.method2466(); var6 != null; var6 = (class140)this.field2013.method2461()) {
         if(!this.field2009.method2602(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field1959) {
                  this.method2754(var6, var1, var4, var5, var5 + var4);
                  var6.field1959 -= var5;
                  break;
               }

               this.method2754(var6, var1, var4, var6.field1959, var5 + var4);
               var4 += var6.field1959;
               var5 -= var6.field1959;
            } while(!this.field2009.method2613(var6, var1, var4, var5));
         }
      }

   }

   class143(class139 var1) {
      this.field2009 = var1;
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "1758288509"
   )
   static final void method2773(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class157.region.method1766(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = class157.region.method1881(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = Projectile.field879.image;
         var11 = 4 * var1 + 24624 + (103 - var2) * 2048;
         var12 = var5 >> 14 & 32767;
         ObjectComposition var18 = class15.getObjectDefinition(var12);
         if(var18.field2920 != -1) {
            ModIcon var14 = Frames.field1563[var18.field2920];
            if(null != var14) {
               int var15 = (var18.field2903 * 4 - var14.originalWidth) / 2;
               int var16 = (var18.field2907 * 4 - var14.height) / 2;
               var14.method4146(var15 + 4 * var1 + 48, var16 + 48 + 4 * (104 - var2 - var18.field2907));
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[512 + var11] = var9;
                  var10[1024 + var11] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[3 + var11] = var9;
                  var10[512 + var11 + 3] = var9;
                  var10[1024 + var11 + 3] = var9;
                  var10[1536 + 3 + var11] = var9;
               } else if(var7 == 3) {
                  var10[1536 + var11] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[3 + 1536 + var11] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[1536 + var11] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[1536 + var11] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[3 + var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[3 + var11 + 512] = var9;
                  var10[1024 + var11 + 3] = var9;
                  var10[3 + var11 + 1536] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536] = var9;
                  var10[1 + 1536 + var11] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[3 + var11 + 1536] = var9;
               }
            }
         }
      }

      var5 = class157.region.method1768(var0, var1, var2);
      if(var5 != 0) {
         var6 = class157.region.method1881(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = class15.getObjectDefinition(var9);
         int var13;
         if(var23.field2920 != -1) {
            ModIcon var17 = Frames.field1563[var23.field2920];
            if(null != var17) {
               var12 = (var23.field2903 * 4 - var17.originalWidth) / 2;
               var13 = (var23.field2907 * 4 - var17.height) / 2;
               var17.method4146(var12 + 4 * var1 + 48, var13 + 48 + (104 - var2 - var23.field2907) * 4);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var19 = Projectile.field879.image;
            var13 = 4 * var1 + 24624 + 2048 * (103 - var2);
            if(var7 != 0 && var7 != 2) {
               var19[var13] = var11;
               var19[1 + 512 + var13] = var11;
               var19[var13 + 1024 + 2] = var11;
               var19[var13 + 1536 + 3] = var11;
            } else {
               var19[var13 + 1536] = var11;
               var19[1024 + var13 + 1] = var11;
               var19[512 + var13 + 2] = var11;
               var19[var13 + 3] = var11;
            }
         }
      }

      var5 = class157.region.method1744(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var20 = class15.getObjectDefinition(var6);
         if(var20.field2920 != -1) {
            ModIcon var21 = Frames.field1563[var20.field2920];
            if(var21 != null) {
               var9 = (var20.field2903 * 4 - var21.originalWidth) / 2;
               int var22 = (var20.field2907 * 4 - var21.height) / 2;
               var21.method4146(var9 + 48 + var1 * 4, 48 + (104 - var2 - var20.field2907) * 4 + var22);
            }
         }
      }

   }
}

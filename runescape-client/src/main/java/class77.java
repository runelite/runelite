import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
public class class77 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1005459651
   )
   int field1406;
   @ObfuscatedName("g")
   int[][] field1410;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1387811629
   )
   int field1411;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1246236208"
   )
   public static int method1600(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var2 + var0) / var1 - var2;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-2079551494"
   )
   byte[] method1601(byte[] var1) {
      if(this.field1410 != null) {
         int var2 = (int)((long)var1.length * (long)this.field1411 / (long)this.field1406) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1410[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var9 + var4] += var8[var9] * var7;
            }

            var5 += this.field1411;
            var9 = var5 / this.field1406;
            var4 += var9;
            var5 -= this.field1406 * var9;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            int var10 = var3[var6] + '耀' >> 16;
            if(var10 < -128) {
               var1[var6] = -128;
            } else if(var10 > 127) {
               var1[var6] = 127;
            } else {
               var1[var6] = (byte)var10;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "722128749"
   )
   int method1602(int var1) {
      if(null != this.field1410) {
         var1 = (int)((long)var1 * (long)this.field1411 / (long)this.field1406);
      }

      return var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-516197427"
   )
   int method1603(int var1) {
      if(null != this.field1410) {
         var1 = (int)((long)var1 * (long)this.field1411 / (long)this.field1406) + 6;
      }

      return var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)Lclass43;",
      garbageValue = "-1866054454"
   )
   public static class43 method1610(int var0) {
      class43 var1 = (class43)class43.field964.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = GameEngine.field2248.method3272(1, var0);
         var1 = new class43();
         if(null != var2) {
            var1.method860(new Buffer(var2), var0);
         }

         var1.method857();
         class43.field964.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1102301647"
   )
   static final void method1612(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var1 + var3; ++var4) {
         for(int var5 = var0; var5 <= var2 + var0; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class217.field3197[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class5.tileHeights[0][var5][var4] = class5.tileHeights[0][var5 - 1][var4];
               }

               if(var2 + var0 == var5 && var5 < 103) {
                  class5.tileHeights[0][var5][var4] = class5.tileHeights[0][1 + var5][var4];
               }

               if(var1 == var4 && var4 > 0) {
                  class5.tileHeights[0][var5][var4] = class5.tileHeights[0][var5][var4 - 1];
               }

               if(var1 + var3 == var4 && var4 < 103) {
                  class5.tileHeights[0][var5][var4] = class5.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILclass170;IIIZI)V",
      garbageValue = "-1905029642"
   )
   public static void method1614(int var0, class170 var1, int var2, int var3, int var4, boolean var5) {
      class186.field3002 = 1;
      XItemContainer.field200 = var1;
      class186.field3003 = var2;
      class186.field3004 = var3;
      class186.field3005 = var4;
      class186.field3006 = var5;
      class153.field2283 = var0;
   }

   public class77(int var1, int var2) {
      if(var2 != var1) {
         int var3 = GameObject.method2180(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.field1406 = var1;
         this.field1411 = var2;
         this.field1410 = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.field1410[var4];
            double var6 = 6.0D + (double)var4 / (double)var1;
            int var8 = (int)Math.floor(1.0D + (var6 - 7.0D));
            if(var8 < 0) {
               var8 = 0;
            }

            int var9 = (int)Math.ceil(var6 + 7.0D);
            if(var9 > 14) {
               var9 = 14;
            }

            for(double var10 = (double)var2 / (double)var1; var8 < var9; ++var8) {
               double var12 = 3.141592653589793D * ((double)var8 - var6);
               double var14 = var10;
               if(var12 < -1.0E-4D || var12 > 1.0E-4D) {
                  var14 = var10 * (Math.sin(var12) / var12);
               }

               var14 *= 0.54D + 0.46D * Math.cos(((double)var8 - var6) * 0.2243994752564138D);
               var5[var8] = (int)Math.floor(65536.0D * var14 + 0.5D);
            }
         }

      }
   }
}

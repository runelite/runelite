import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
public class class77 {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 613651929
   )
   int field1410;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 919214017
   )
   int field1411;
   @ObfuscatedName("b")
   int[][] field1413;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = -1490883099
   )
   @Export("cameraY")
   static int cameraY;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "0"
   )
   int method1646(int var1) {
      if(null != this.field1413) {
         var1 = 6 + (int)((long)var1 * (long)this.field1410 / (long)this.field1411);
      }

      return var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "-74"
   )
   byte[] method1647(byte[] var1) {
      if(null != this.field1413) {
         int var2 = 14 + (int)((long)this.field1410 * (long)var1.length / (long)this.field1411);
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1413[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var4 + var9] += var8[var9] * var7;
            }

            var5 += this.field1410;
            var9 = var5 / this.field1411;
            var4 += var9;
            var5 -= this.field1411 * var9;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            int var10 = '耀' + var3[var6] >> 16;
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "121"
   )
   int method1648(int var1) {
      if(this.field1413 != null) {
         var1 = (int)((long)this.field1410 * (long)var1 / (long)this.field1411);
      }

      return var1;
   }

   public class77(int var1, int var2) {
      if(var1 != var2) {
         int var3 = class49.method991(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.field1411 = var1;
         this.field1410 = var2;
         this.field1413 = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.field1413[var4];
            double var6 = 6.0D + (double)var4 / (double)var1;
            int var8 = (int)Math.floor(1.0D + (var6 - 7.0D));
            if(var8 < 0) {
               var8 = 0;
            }

            int var9 = (int)Math.ceil(7.0D + var6);
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
               var5[var8] = (int)Math.floor(0.5D + var14 * 65536.0D);
            }
         }

      }
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "463735595"
   )
   static final void method1657() {
      Client.field327.method2770();
      int var0 = Client.field327.method2771(8);
      int var1;
      if(var0 < Client.field321) {
         for(var1 = var0; var1 < Client.field321; ++var1) {
            Client.field406[++Client.field496 - 1] = Client.field405[var1];
         }
      }

      if(var0 > Client.field321) {
         throw new RuntimeException("");
      } else {
         Client.field321 = 0;

         for(var1 = 0; var1 < var0; ++var1) {
            int var2 = Client.field405[var1];
            NPC var3 = Client.cachedNPCs[var2];
            int var4 = Client.field327.method2771(1);
            if(var4 == 0) {
               Client.field405[++Client.field321 - 1] = var2;
               var3.field865 = Client.gameCycle;
            } else {
               int var5 = Client.field327.method2771(2);
               if(var5 == 0) {
                  Client.field405[++Client.field321 - 1] = var2;
                  var3.field865 = Client.gameCycle;
                  Client.field456[++Client.field323 - 1] = var2;
               } else {
                  int var6;
                  int var7;
                  if(var5 == 1) {
                     Client.field405[++Client.field321 - 1] = var2;
                     var3.field865 = Client.gameCycle;
                     var6 = Client.field327.method2771(3);
                     var3.method740(var6, (byte)1);
                     var7 = Client.field327.method2771(1);
                     if(var7 == 1) {
                        Client.field456[++Client.field323 - 1] = var2;
                     }
                  } else if(var5 == 2) {
                     Client.field405[++Client.field321 - 1] = var2;
                     var3.field865 = Client.gameCycle;
                     var6 = Client.field327.method2771(3);
                     var3.method740(var6, (byte)2);
                     var7 = Client.field327.method2771(3);
                     var3.method740(var7, (byte)2);
                     int var8 = Client.field327.method2771(1);
                     if(var8 == 1) {
                        Client.field456[++Client.field323 - 1] = var2;
                     }
                  } else if(var5 == 3) {
                     Client.field406[++Client.field496 - 1] = var2;
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-559364258"
   )
   static int method1658(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      return null != class5.field95 && class5.field95.hash == var2?class32.field707.offset * 99 / (class32.field707.payload.length - class5.field95.field2775) + 1:0;
   }
}

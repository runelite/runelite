import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
public class class74 {
   @ObfuscatedName("d")
   int[][] field1380;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2056029697
   )
   int field1381;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 684420715
   )
   int field1387;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "321371213"
   )
   static int method1648() {
      return ++class11.field180 - 1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "1419205845"
   )
   byte[] method1649(byte[] var1) {
      if(null != this.field1380) {
         int var2 = 14 + (int)((long)var1.length * (long)this.field1381 / (long)this.field1387);
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1380[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var4 + var9] += var8[var9] * var7;
            }

            var5 += this.field1381;
            var9 = var5 / this.field1387;
            var4 += var9;
            var5 -= this.field1387 * var9;
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1105697489"
   )
   int method1650(int var1) {
      if(this.field1380 != null) {
         var1 = 6 + (int)((long)var1 * (long)this.field1381 / (long)this.field1387);
      }

      return var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1479806685"
   )
   int method1651(int var1) {
      if(this.field1380 != null) {
         var1 = (int)((long)var1 * (long)this.field1381 / (long)this.field1387);
      }

      return var1;
   }

   public class74(int var1, int var2) {
      if(var1 != var2) {
         int var4 = var1;
         int var5 = var2;
         if(var2 > var1) {
            var4 = var2;
            var5 = var1;
         }

         while(var5 != 0) {
            int var6 = var4 % var5;
            var4 = var5;
            var5 = var6;
         }

         var1 /= var4;
         var2 /= var4;
         this.field1387 = var1;
         this.field1381 = var2;
         this.field1380 = new int[var1][14];

         for(int var7 = 0; var7 < var1; ++var7) {
            int[] var8 = this.field1380[var7];
            double var9 = 6.0D + (double)var7 / (double)var1;
            int var11 = (int)Math.floor(var9 - 7.0D + 1.0D);
            if(var11 < 0) {
               var11 = 0;
            }

            int var12 = (int)Math.ceil(var9 + 7.0D);
            if(var12 > 14) {
               var12 = 14;
            }

            for(double var13 = (double)var2 / (double)var1; var11 < var12; ++var11) {
               double var15 = ((double)var11 - var9) * 3.141592653589793D;
               double var17 = var13;
               if(var15 < -1.0E-4D || var15 > 1.0E-4D) {
                  var17 = var13 * (Math.sin(var15) / var15);
               }

               var17 *= 0.54D + 0.46D * Math.cos(((double)var11 - var9) * 0.2243994752564138D);
               var8[var11] = (int)Math.floor(var17 * 65536.0D + 0.5D);
            }
         }

      }
   }

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-1997499586"
   )
   static final void method1658(String var0, boolean var1) {
      if(var0 != null) {
         if((client.field559 < 100 || client.field412 == 1) && client.field559 < 400) {
            String var2 = class138.method2969(var0, client.field294);
            if(null != var2) {
               int var3;
               String var5;
               String var6;
               for(var3 = 0; var3 < client.field559; ++var3) {
                  class7 var4 = client.field560[var3];
                  var5 = class138.method2969(var4.field134, client.field294);
                  if(var5 != null && var5.equals(var2)) {
                     class52.method1147(31, "", var0 + " is already on your ignore list");
                     return;
                  }

                  if(null != var4.field137) {
                     var6 = class138.method2969(var4.field137, client.field294);
                     if(null != var6 && var6.equals(var2)) {
                        class52.method1147(31, "", var0 + " is already on your ignore list");
                        return;
                     }
                  }
               }

               for(var3 = 0; var3 < client.field555; ++var3) {
                  class17 var7 = client.field557[var3];
                  var5 = class138.method2969(var7.field254, client.field294);
                  if(null != var5 && var5.equals(var2)) {
                     class52.method1147(31, "", "Please remove " + var0 + " from your friend list first");
                     return;
                  }

                  if(null != var7.field248) {
                     var6 = class138.method2969(var7.field248, client.field294);
                     if(null != var6 && var6.equals(var2)) {
                        class52.method1147(31, "", "Please remove " + var0 + " from your friend list first");
                        return;
                     }
                  }
               }

               if(class138.method2969(class15.field225.field60, client.field294).equals(var2)) {
                  class52.method1147(31, "", "You can\'t add yourself to your own ignore list");
               } else {
                  client.field333.method2773(48);
                  client.field333.method2654(class23.method629(var0));
                  client.field333.method2545(var0);
               }
            }
         } else {
            class52.method1147(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1001838888"
   )
   static final int method1659(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class5.field82[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = var6 * class5.field99[var5][var3 + 1][var4] + (128 - var6) * class5.field99[var5][var3][var4] >> 7;
         int var9 = var6 * class5.field99[var5][1 + var3][1 + var4] + (128 - var6) * class5.field99[var5][var3][1 + var4] >> 7;
         return var8 * (128 - var7) + var7 * var9 >> 7;
      } else {
         return 0;
      }
   }
}

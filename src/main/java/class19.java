import java.io.EOFException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class19 {
   @ObfuscatedName("x")
   int[] field258;
   @ObfuscatedName("m")
   boolean[] field260;
   @ObfuscatedName("z")
   boolean[] field261;
   @ObfuscatedName("i")
   boolean field262 = false;
   @ObfuscatedName("e")
   String[] field264;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = -4857138206581714597L
   )
   long field265;
   @ObfuscatedName("q")
   public static String[] field268;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-431460331"
   )
   void method202(int var1, int var2) {
      this.field258[var1] = var2;
      if(this.field260[var1]) {
         this.field262 = true;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1546755218"
   )
   int method203(int var1) {
      return this.field258[var1];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)V",
      garbageValue = "-118"
   )
   void method204(int var1, String var2) {
      this.field264[var1] = var2;
      if(this.field261[var1]) {
         this.field262 = true;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ZI)Lclass227;",
      garbageValue = "1"
   )
   class227 method207(boolean var1) {
      return class106.method2367("2", class75.field1360.field2273, var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-122"
   )
   void method208() {
      class227 var1 = this.method207(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field258.length; ++var4) {
            if(this.field260[var4] && -1 != this.field258[var4]) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.field264.length; ++var5) {
            if(this.field261[var5] && null != this.field264[var5]) {
               var2 += 2 + class116.method2447(this.field264[var5]);
               ++var4;
            }
         }

         class119 var17 = new class119(var2);
         var17.method2503(1);
         var17.method2486(var3);

         int var6;
         for(var6 = 0; var6 < this.field258.length; ++var6) {
            if(this.field260[var6] && this.field258[var6] != -1) {
               var17.method2486(var6);
               var17.method2488(this.field258[var6]);
            }
         }

         var17.method2486(var4);

         for(var6 = 0; var6 < this.field264.length; ++var6) {
            if(this.field261[var6] && null != this.field264[var6]) {
               var17.method2486(var6);
               var17.method2491(this.field264[var6]);
            }
         }

         var1.method4097(var17.field1973, 0, var17.field1971);
      } catch (Exception var15) {
         ;
      } finally {
         try {
            var1.method4088();
         } catch (Exception var14) {
            ;
         }

      }

      this.field262 = false;
      this.field265 = class77.method1674();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-147900177"
   )
   void method210() {
      if(this.field262 && this.field265 < class77.method1674() - 60000L) {
         this.method208();
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "65280"
   )
   boolean method211() {
      return this.field262;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "1"
   )
   String method217(int var1) {
      return this.field264[var1];
   }

   class19() {
      this.field258 = new int[class0.field13.method3227(19)];
      this.field264 = new String[class0.field13.method3227(15)];
      this.field260 = new boolean[this.field258.length];

      int var1;
      for(var1 = 0; var1 < this.field258.length; ++var1) {
         class45 var2 = class29.method654(var1);
         this.field260[var1] = var2.field1024;
      }

      this.field261 = new boolean[this.field264.length];

      for(var1 = 0; var1 < this.field264.length; ++var1) {
         class49 var3 = class35.method725(var1);
         this.field261[var1] = var3.field1071;
      }

      for(var1 = 0; var1 < this.field258.length; ++var1) {
         this.field258[var1] = -1;
      }

      this.method244();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1481927833"
   )
   public static void method230() {
      class41.field958.method3707();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-344604319"
   )
   void method232() {
      int var1;
      for(var1 = 0; var1 < this.field258.length; ++var1) {
         if(!this.field260[var1]) {
            this.field258[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.field264.length; ++var1) {
         if(!this.field261[var1]) {
            this.field264[var1] = null;
         }
      }

   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1885619897"
   )
   static void method238(int var0, int var1) {
      client.field318.method2735(77);
      client.field318.method2533(var1);
      client.field318.method2540(var0);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Lclass43;",
      garbageValue = "-1791617406"
   )
   public static class43 method239(int var0) {
      class43 var1 = (class43)class43.field989.method3704((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class219.field3172.method3217(13, var0);
         var1 = new class43();
         var1.field999 = var0;
         if(null != var2) {
            var1.method886(new class119(var2));
         }

         class43.field989.method3706(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-34"
   )
   public static void method240() {
      class44.field1012.method3707();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IILclass107;Lclass108;I)Z",
      garbageValue = "37821"
   )
   static final boolean method241(int var0, int var1, class107 var2, class108 var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class106.field1850[var6][var7] = 99;
      class106.field1855[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class106.field1853[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class106.field1849[var10001] = var1;
      int[][] var12 = var3.field1879;

      while(var18 != var11) {
         var4 = class106.field1853[var11];
         var5 = class106.field1849[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.field1880;
         int var14 = var5 - var3.field1876;
         if(var2.vmethod2375(1, var4, var5, var3)) {
            class33.field758 = var4;
            class103.field1756 = var5;
            return true;
         }

         int var15 = 1 + class106.field1855[var16][var17];
         if(var16 > 0 && 0 == class106.field1850[var16 - 1][var17] && 0 == (var12[var13 - 1][var14] & 19136776)) {
            class106.field1853[var18] = var4 - 1;
            class106.field1849[var18] = var5;
            var18 = 1 + var18 & 4095;
            class106.field1850[var16 - 1][var17] = 2;
            class106.field1855[var16 - 1][var17] = var15;
         }

         if(var16 < 127 && class106.field1850[var16 + 1][var17] == 0 && (var12[var13 + 1][var14] & 19136896) == 0) {
            class106.field1853[var18] = var4 + 1;
            class106.field1849[var18] = var5;
            var18 = var18 + 1 & 4095;
            class106.field1850[1 + var16][var17] = 8;
            class106.field1855[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && 0 == class106.field1850[var16][var17 - 1] && (var12[var13][var14 - 1] & 19136770) == 0) {
            class106.field1853[var18] = var4;
            class106.field1849[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class106.field1850[var16][var17 - 1] = 1;
            class106.field1855[var16][var17 - 1] = var15;
         }

         if(var17 < 127 && 0 == class106.field1850[var16][1 + var17] && 0 == (var12[var13][var14 + 1] & 19136800)) {
            class106.field1853[var18] = var4;
            class106.field1849[var18] = var5 + 1;
            var18 = 1 + var18 & 4095;
            class106.field1850[var16][1 + var17] = 4;
            class106.field1855[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class106.field1850[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && 0 == (var12[var13 - 1][var14] & 19136776) && 0 == (var12[var13][var14 - 1] & 19136770)) {
            class106.field1853[var18] = var4 - 1;
            class106.field1849[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class106.field1850[var16 - 1][var17 - 1] = 3;
            class106.field1855[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 127 && var17 > 0 && class106.field1850[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && 0 == (var12[var13][var14 - 1] & 19136770)) {
            class106.field1853[var18] = 1 + var4;
            class106.field1849[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class106.field1850[1 + var16][var17 - 1] = 9;
            class106.field1855[1 + var16][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 127 && class106.field1850[var16 - 1][1 + var17] == 0 && 0 == (var12[var13 - 1][1 + var14] & 19136824) && 0 == (var12[var13 - 1][var14] & 19136776) && 0 == (var12[var13][var14 + 1] & 19136800)) {
            class106.field1853[var18] = var4 - 1;
            class106.field1849[var18] = var5 + 1;
            var18 = 1 + var18 & 4095;
            class106.field1850[var16 - 1][1 + var17] = 6;
            class106.field1855[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 127 && var17 < 127 && 0 == class106.field1850[1 + var16][var17 + 1] && 0 == (var12[1 + var13][var14 + 1] & 19136992) && 0 == (var12[var13 + 1][var14] & 19136896) && (var12[var13][var14 + 1] & 19136800) == 0) {
            class106.field1853[var18] = var4 + 1;
            class106.field1849[var18] = var5 + 1;
            var18 = 1 + var18 & 4095;
            class106.field1850[var16 + 1][1 + var17] = 12;
            class106.field1855[var16 + 1][var17 + 1] = var15;
         }
      }

      class33.field758 = var4;
      class103.field1756 = var5;
      return false;
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "1685202145"
   )
   static final void method242(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class16 var9 = null;

      for(class16 var10 = (class16)client.field407.method3784(); var10 != null; var10 = (class16)client.field407.method3777()) {
         if(var10.field227 == var0 && var1 == var10.field224 && var2 == var10.field225 && var3 == var10.field222) {
            var9 = var10;
            break;
         }
      }

      if(null == var9) {
         var9 = new class16();
         var9.field227 = var0;
         var9.field222 = var3;
         var9.field224 = var1;
         var9.field225 = var2;
         class3.method33(var9);
         client.field407.method3779(var9);
      }

      var9.field229 = var4;
      var9.field231 = var5;
      var9.field230 = var6;
      var9.field232 = var7;
      var9.field233 = var8;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIII)Z",
      garbageValue = "-828659863"
   )
   static final boolean method243(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      class119 var4 = new class119(var0);
      int var5 = -1;

      label84:
      while(true) {
         int var6 = var4.method2512();
         if(var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.method2512();
               if(var9 == 0) {
                  continue label84;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.method2500() >> 2;
               int var13 = var11 + var1;
               int var14 = var2 + var10;
               if(var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  class40 var15 = class85.method1903(var5);
                  if(22 != var12 || !client.field303 || var15.field917 != 0 || var15.field922 == 1 || var15.field915) {
                     if(!var15.method787()) {
                        ++client.field332;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.method2512();
            if(0 == var9) {
               break;
            }

            var4.method2500();
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-749037467"
   )
   void method244() {
      class227 var1 = this.method207(false);

      label191: {
         try {
            byte[] var2 = new byte[(int)var1.method4092()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.method4093(var2, var3, var2.length - var3);
               if(-1 == var4) {
                  throw new EOFException();
               }
            }

            class119 var23 = new class119(var2);
            if(var23.field1973.length - var23.field1971 >= 1) {
               int var5 = var23.method2500();
               if(var5 < 0 || var5 > 1) {
                  return;
               }

               int var6 = var23.method2502();

               int var7;
               int var8;
               int var9;
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var23.method2502();
                  var9 = var23.method2505();
                  if(this.field260[var8]) {
                     this.field258[var8] = var9;
                  }
               }

               var7 = var23.method2502();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label191;
                  }

                  var9 = var23.method2502();
                  String var10 = var23.method2508();
                  if(this.field261[var9]) {
                     this.field264[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var21) {
            break label191;
         } finally {
            try {
               var1.method4088();
            } catch (Exception var20) {
               ;
            }

         }

         return;
      }

      this.field262 = false;
   }
}

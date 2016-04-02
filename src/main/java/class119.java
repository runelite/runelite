import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
@Implements("Buffer")
public class class119 extends class208 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -143176743
   )
   @Export("offset")
   public int field1976;
   @ObfuscatedName("f")
   static int[] field1979 = new int[256];
   @ObfuscatedName("e")
   @Export("payload")
   public byte[] field1980;
   @ObfuscatedName("h")
   static class167 field1981;
   @ObfuscatedName("ak")
   static class78[] field1983;
   @ObfuscatedName("p")
   static long[] field1984;

   public class119(byte[] var1) {
      this.field1980 = var1;
      this.field1976 = 0;
   }

   @ObfuscatedName("s")
   public void method2510(int var1) {
      this.field1980[++this.field1976 - 1] = (byte)(var1 >> 16);
      this.field1980[++this.field1976 - 1] = (byte)(var1 >> 8);
      this.field1980[++this.field1976 - 1] = (byte)var1;
   }

   @ObfuscatedName("r")
   public void method2514(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.field1976 += class1.method5(var1, 0, var1.length(), this.field1980, this.field1976);
         this.field1980[++this.field1976 - 1] = 0;
      }
   }

   @ObfuscatedName("k")
   public void method2515(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.field1980[++this.field1976 - 1] = 0;
         this.field1976 += class1.method5(var1, 0, var1.length(), this.field1980, this.field1976);
         this.field1980[++this.field1976 - 1] = 0;
      }
   }

   @ObfuscatedName("m")
   public void method2516(CharSequence var1) {
      int var3 = var1.length();
      int var4 = 0;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var1.charAt(var5);
         if(var6 <= 127) {
            ++var4;
         } else if(var6 <= 2047) {
            var4 += 2;
         } else {
            var4 += 3;
         }
      }

      this.field1980[++this.field1976 - 1] = 0;
      this.method2522(var4);
      this.field1976 += class36.method740(this.field1980, this.field1976, var1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1372702223"
   )
   public void method2517(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         this.field1980[++this.field1976 - 1] = var1[var4];
      }

   }

   @ObfuscatedName("i")
   public void method2519(int var1) {
      this.field1980[this.field1976 - var1 - 2] = (byte)(var1 >> 8);
      this.field1980[this.field1976 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("l")
   public void method2521(int var1) {
      if(var1 >= 0 && var1 < 128) {
         this.method2565(var1);
      } else if(var1 >= 0 && var1 < '耀') {
         this.method2713('耀' + var1);
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1875370345"
   )
   public void method2522(int var1) {
      if((var1 & -128) != 0) {
         if(0 != (var1 & -16384)) {
            if(0 != (var1 & -2097152)) {
               if((var1 & -268435456) != 0) {
                  this.method2565(var1 >>> 28 | 128);
               }

               this.method2565(var1 >>> 21 | 128);
            }

            this.method2565(var1 >>> 14 | 128);
         }

         this.method2565(var1 >>> 7 | 128);
      }

      this.method2565(var1 & 127);
   }

   @ObfuscatedName("c")
   public int method2523() {
      return this.field1980[++this.field1976 - 1] & 255;
   }

   @ObfuscatedName("j")
   public void method2524(int var1) {
      this.field1980[this.field1976 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("q")
   public int method2526() {
      this.field1976 += 2;
      int var1 = ((this.field1980[this.field1976 - 2] & 255) << 8) + (this.field1980[this.field1976 - 1] & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("u")
   public int method2527() {
      this.field1976 += 3;
      return (this.field1980[this.field1976 - 1] & 255) + ((this.field1980[this.field1976 - 2] & 255) << 8) + ((this.field1980[this.field1976 - 3] & 255) << 16);
   }

   @ObfuscatedName("t")
   public int method2528() {
      this.field1976 += 4;
      return ((this.field1980[this.field1976 - 4] & 255) << 24) + ((this.field1980[this.field1976 - 3] & 255) << 16) + ((this.field1980[this.field1976 - 2] & 255) << 8) + (this.field1980[this.field1976 - 1] & 255);
   }

   @ObfuscatedName("d")
   public long method2529() {
      long var1 = (long)this.method2528() & 4294967295L;
      long var3 = (long)this.method2528() & 4294967295L;
      return (var1 << 32) + var3;
   }

   @ObfuscatedName("z")
   public String method2530() {
      if(0 == this.field1980[this.field1976]) {
         ++this.field1976;
         return null;
      } else {
         return this.method2531();
      }
   }

   @ObfuscatedName("v")
   public String method2531() {
      int var1 = this.field1976;

      while(this.field1980[++this.field1976 - 1] != 0) {
         ;
      }

      int var2 = this.field1976 - var1 - 1;
      return var2 == 0?"":class87.method2094(this.field1980, var1, var2);
   }

   @ObfuscatedName("aq")
   public String method2532() {
      byte var1 = this.field1980[++this.field1976 - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.field1976;

         while(this.field1980[++this.field1976 - 1] != 0) {
            ;
         }

         int var3 = this.field1976 - var2 - 1;
         return 0 == var3?"":class87.method2094(this.field1980, var2, var3);
      }
   }

   @ObfuscatedName("ay")
   public void method2534(int[] var1, int var2, int var3) {
      int var4 = this.field1976;
      this.field1976 = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2528();
         int var8 = this.method2528();
         int var9 = 0;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var8 += var7 + (var7 << 4 ^ var7 >>> 5) ^ var9 + var1[var9 >>> 11 & 3]) {
            var7 += (var8 << 4 ^ var8 >>> 5) + var8 ^ var1[var9 & 3] + var9;
            var9 += var10;
         }

         this.field1976 -= 8;
         this.method2617(var7);
         this.method2617(var8);
      }

      this.field1976 = var4;
   }

   @ObfuscatedName("ae")
   public int method2535() {
      int var1 = this.field1980[this.field1976] & 255;
      return var1 < 128?this.method2523() - 64:this.method2700() - '쀀';
   }

   @ObfuscatedName("az")
   public int method2536() {
      int var1 = this.field1980[this.field1976] & 255;
      return var1 < 128?this.method2523():this.method2700() - '耀';
   }

   @ObfuscatedName("ah")
   public int method2537() {
      return this.field1980[this.field1976] < 0?this.method2528() & Integer.MAX_VALUE:this.method2700();
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-322346797"
   )
   public void method2539(int[] var1) {
      int var2 = this.field1976 / 8;
      this.field1976 = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2528();
         int var5 = this.method2528();
         int var6 = 0;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var5 += (var4 << 4 ^ var4 >>> 5) + var4 ^ var6 + var1[var6 >>> 11 & 3]) {
            var4 += (var5 << 4 ^ var5 >>> 5) + var5 ^ var6 + var1[var6 & 3];
            var6 += var7;
         }

         this.field1976 -= 8;
         this.method2617(var4);
         this.method2617(var5);
      }

   }

   @ObfuscatedName("aj")
   public void method2540(int[] var1) {
      int var2 = this.field1976 / 8;
      this.field1976 = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2528();
         int var5 = this.method2528();
         int var6 = -957401312;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var4 -= (var5 << 4 ^ var5 >>> 5) + var5 ^ var1[var6 & 3] + var6) {
            var5 -= var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6;
            var6 -= var7;
         }

         this.field1976 -= 8;
         this.method2617(var4);
         this.method2617(var5);
      }

   }

   @ObfuscatedName("ag")
   public void method2542(int[] var1, int var2, int var3) {
      int var4 = this.field1976;
      this.field1976 = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2528();
         int var8 = this.method2528();
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= (var8 << 4 ^ var8 >>> 5) + var8 ^ var9 + var1[var9 & 3]) {
            var8 -= (var7 << 4 ^ var7 >>> 5) + var7 ^ var9 + var1[var9 >>> 11 & 3];
            var9 -= var10;
         }

         this.field1976 -= 8;
         this.method2617(var7);
         this.method2617(var8);
      }

      this.field1976 = var4;
   }

   @ObfuscatedName("br")
   public void method2543(int var1) {
      this.field1980[++this.field1976 - 1] = (byte)(var1 >> 16);
      this.field1980[++this.field1976 - 1] = (byte)var1;
      this.field1980[++this.field1976 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("am")
   public boolean method2545() {
      this.field1976 -= 4;
      byte[] var2 = this.field1980;
      int var3 = this.field1976;
      int var4 = -1;

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4 = var4 >>> 8 ^ field1979[(var4 ^ var2[var5]) & 255];
      }

      var4 = ~var4;
      var5 = this.method2528();
      return var5 == var4;
   }

   @ObfuscatedName("aw")
   public void method2546(int var1) {
      this.field1980[++this.field1976 - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "([Lclass173;IIIIIIIIB)V",
      garbageValue = "-60"
   )
   static final void method2547(class173[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class79.method1803(var2, var3, var4, var5);
      class91.method2104();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         class173 var10 = var0[var9];
         if(null != var10 && (var10.field2774 == var1 || var1 == -1412584499 && var10 == client.field451)) {
            int var11;
            if(-1 == var8) {
               client.field486[client.field465] = var6 + var10.field2880;
               client.field487[client.field465] = var10.field2769 + var7;
               client.field354[client.field465] = var10.field2770;
               client.field489[client.field465] = var10.field2834;
               var11 = ++client.field465 - 1;
            } else {
               var11 = var8;
            }

            var10.field2756 = var11;
            var10.field2861 = client.field289;
            if(!var10.field2809 || !class21.method579(var10)) {
               int var12;
               if(var10.field2833 > 0) {
                  var12 = var10.field2833;
                  if(324 == var12) {
                     if(-1 == client.field423) {
                        client.field423 = var10.field2858;
                        client.field553 = var10.field2791;
                     }

                     if(client.field551.field2921) {
                        var10.field2858 = client.field423;
                     } else {
                        var10.field2858 = client.field553;
                     }
                  } else if(325 == var12) {
                     if(client.field423 == -1) {
                        client.field423 = var10.field2858;
                        client.field553 = var10.field2791;
                     }

                     if(client.field551.field2921) {
                        var10.field2858 = client.field553;
                     } else {
                        var10.field2858 = client.field423;
                     }
                  } else if(var12 == 327) {
                     var10.field2765 = 150;
                     var10.field2807 = (int)(Math.sin((double)client.field289 / 40.0D) * 256.0D) & 2047;
                     var10.field2798 = 5;
                     var10.field2876 = 0;
                  } else if(var12 == 328) {
                     var10.field2765 = 150;
                     var10.field2807 = (int)(Math.sin((double)client.field289 / 40.0D) * 256.0D) & 2047;
                     var10.field2798 = 5;
                     var10.field2876 = 1;
                  }
               }

               var12 = var6 + var10.field2880;
               int var13 = var10.field2769 + var7;
               int var14 = var10.field2786;
               int var15;
               int var16;
               if(var10 == client.field451) {
                  if(-1412584499 != var1 && !var10.field2863) {
                     class13.field201 = var0;
                     class25.field612 = var6;
                     class59.field1193 = var7;
                     continue;
                  }

                  if(client.field462 && client.field509) {
                     var15 = class140.field2140;
                     var16 = class140.field2141;
                     var15 -= client.field453;
                     var16 -= client.field517;
                     if(var15 < client.field527) {
                        var15 = client.field527;
                     }

                     if(var10.field2770 + var15 > client.field527 + client.field452.field2770) {
                        var15 = client.field527 + client.field452.field2770 - var10.field2770;
                     }

                     if(var16 < client.field458) {
                        var16 = client.field458;
                     }

                     if(var10.field2834 + var16 > client.field458 + client.field452.field2834) {
                        var16 = client.field452.field2834 + client.field458 - var10.field2834;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2863) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var19;
               int var20;
               int var21;
               int var22;
               if(var10.field2757 == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.field2757 == 9) {
                  var19 = var12;
                  var20 = var13;
                  var21 = var12 + var10.field2770;
                  var22 = var13 + var10.field2834;
                  if(var21 < var12) {
                     var19 = var21;
                     var21 = var12;
                  }

                  if(var22 < var13) {
                     var20 = var22;
                     var22 = var13;
                  }

                  ++var21;
                  ++var22;
                  var15 = var19 > var2?var19:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var21 < var4?var21:var4;
                  var18 = var22 < var5?var22:var5;
               } else {
                  var19 = var10.field2770 + var12;
                  var20 = var13 + var10.field2834;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var19 < var4?var19:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.field2809 || var15 < var17 && var16 < var18) {
                  int var25;
                  int var26;
                  int var27;
                  int var28;
                  int var29;
                  int var30;
                  int var31;
                  int var32;
                  int var33;
                  int var34;
                  int var35;
                  int var46;
                  int var47;
                  if(0 != var10.field2833) {
                     if(1336 == var10.field2833) {
                        if(client.field295) {
                           var13 += 15;
                           class25.field628.method4020("Fps:" + class144.field2195, var10.field2770 + var12, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var56 = Runtime.getRuntime();
                           var20 = (int)((var56.totalMemory() - var56.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && client.field285) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !client.field285) {
                              var21 = 16711680;
                           }

                           class25.field628.method4020("Mem:" + var20 + "k", var10.field2770 + var12, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.field2833 == 1337) {
                        client.field511 = var12;
                        client.field428 = var13;
                        var21 = var10.field2770;
                        var22 = var10.field2834;
                        ++client.field384;
                        class96.method2209(class33.field745);
                        boolean var62 = false;
                        if(client.field409 >= 0) {
                           var47 = class32.field731;
                           int[] var69 = class32.field732;

                           for(var26 = 0; var26 < var47; ++var26) {
                              if(client.field409 == var69[var26]) {
                                 var62 = true;
                                 break;
                              }
                           }
                        }

                        if(var62) {
                           class96.method2209(class33.field749);
                        }

                        class154.method3164(true);
                        class96.method2209(var62?class33.field747:class33.field744);
                        class154.method3164(false);
                        class104.method2319();

                        for(class29 var70 = (class29)client.field413.method3825(); null != var70; var70 = (class29)client.field413.method3827()) {
                           if(class48.field1063 == var70.field678 && !var70.field672) {
                              if(client.field289 >= var70.field670) {
                                 var70.method662(client.field355);
                                 if(var70.field672) {
                                    var70.method3913();
                                 } else {
                                    class151.field2250.method1937(var70.field678, var70.field680, var70.field673, var70.field674, 60, var70, 0, -1, false);
                                 }
                              }
                           } else {
                              var70.method3913();
                           }
                        }

                        class141.method2976(var12, var13, var21, var22, true);
                        var19 = client.field540;
                        var20 = client.field541;
                        var21 = client.field371;
                        var22 = client.field543;
                        class79.method1803(var19, var20, var19 + var21, var22 + var20);
                        class91.method2104();
                        if(!client.field313) {
                           var47 = client.field449;
                           if(client.field372 / 256 > var47) {
                              var47 = client.field372 / 256;
                           }

                           if(client.field388[4] && client.field529[4] + 128 > var47) {
                              var47 = 128 + client.field529[4];
                           }

                           var25 = client.field368 + client.field525 & 2047;
                           var26 = class25.field629;
                           var27 = class59.method1263(class20.field572.field804, class20.field572.field814, class48.field1063) - client.field322;
                           var28 = class42.field981;
                           var29 = 600 + 3 * var47;
                           var30 = 2048 - var47 & 2047;
                           var31 = 2048 - var25 & 2047;
                           var32 = 0;
                           var33 = 0;
                           var34 = var29;
                           int var36;
                           int var37;
                           if(0 != var30) {
                              var35 = class91.field1568[var30];
                              var36 = class91.field1554[var30];
                              var37 = var36 * var33 - var35 * var29 >> 16;
                              var34 = var29 * var36 + var33 * var35 >> 16;
                              var33 = var37;
                           }

                           if(0 != var31) {
                              var35 = class91.field1568[var31];
                              var36 = class91.field1554[var31];
                              var37 = var32 * var36 + var35 * var34 >> 16;
                              var34 = var34 * var36 - var32 * var35 >> 16;
                              var32 = var37;
                           }

                           class19.field273 = var26 - var32;
                           class0.field12 = var27 - var33;
                           class5.field95 = var28 - var34;
                           class216.field3156 = var47;
                           class10.field167 = var25;
                        }

                        if(!client.field313) {
                           var47 = class125.method2800();
                        } else {
                           if(class39.field865.field146) {
                              var25 = class48.field1063;
                           } else {
                              var26 = class59.method1263(class19.field273, class5.field95, class48.field1063);
                              if(var26 - class0.field12 < 800 && 0 != (class5.field80[class48.field1063][class19.field273 >> 7][class5.field95 >> 7] & 4)) {
                                 var25 = class48.field1063;
                              } else {
                                 var25 = 3;
                              }
                           }

                           var47 = var25;
                        }

                        var25 = class19.field273;
                        var26 = class0.field12;
                        var27 = class5.field95;
                        var28 = class216.field3156;
                        var29 = class10.field167;

                        for(var30 = 0; var30 < 5; ++var30) {
                           if(client.field388[var30]) {
                              var31 = (int)(Math.random() * (double)(client.field528[var30] * 2 + 1) - (double)client.field528[var30] + Math.sin((double)client.field276[var30] / 100.0D * (double)client.field531[var30]) * (double)client.field529[var30]);
                              if(0 == var30) {
                                 class19.field273 += var31;
                              }

                              if(var30 == 1) {
                                 class0.field12 += var31;
                              }

                              if(2 == var30) {
                                 class5.field95 += var31;
                              }

                              if(var30 == 3) {
                                 class10.field167 = var31 + class10.field167 & 2047;
                              }

                              if(4 == var30) {
                                 class216.field3156 += var31;
                                 if(class216.field3156 < 128) {
                                    class216.field3156 = 128;
                                 }

                                 if(class216.field3156 > 383) {
                                    class216.field3156 = 383;
                                 }
                              }
                           }
                        }

                        var30 = class140.field2140;
                        var31 = class140.field2141;
                        if(class140.field2146 != 0) {
                           var30 = class140.field2135;
                           var31 = class140.field2148;
                        }

                        if(var30 >= var19 && var30 < var21 + var19 && var31 >= var20 && var31 < var22 + var20) {
                           class105.field1830 = true;
                           class105.field1833 = 0;
                           class105.field1834 = var30 - var19;
                           class105.field1832 = var31 - var20;
                        } else {
                           class105.field1830 = false;
                           class105.field1833 = 0;
                        }

                        class11.method155();
                        class79.method1809(var19, var20, var21, var22, 0);
                        class11.method155();
                        var32 = class91.field1555;
                        class91.field1555 = client.field544;
                        class151.field2250.method1964(class19.field273, class0.field12, class5.field95, class216.field3156, class10.field167, var47);
                        class91.field1555 = var32;
                        class11.method155();
                        class151.field2250.method2003();
                        class101.method2309(var19, var20, var21, var22);
                        class89.method2096(var19, var20);
                        ((class95)class91.field1569).method2196(client.field355);
                        class115.method2467();
                        class19.field273 = var25;
                        class0.field12 = var26;
                        class5.field95 = var27;
                        class216.field3156 = var28;
                        class10.field167 = var29;
                        if(client.field288) {
                           byte var71 = 0;
                           var34 = var71 + class171.field2718 + class171.field2730;
                           if(0 == var34) {
                              client.field288 = false;
                           }
                        }

                        if(client.field288) {
                           class79.method1809(var19, var20, var21, var22, 0);
                           class123.method2787("Loading - please wait.", false);
                        }

                        client.field483[var10.field2756] = true;
                        class79.method1803(var2, var3, var4, var5);
                        continue;
                     }

                     class175 var54;
                     if(var10.field2833 == 1338) {
                        class11.method155();
                        var54 = var10.method3381(false);
                        if(null != var54) {
                           class79.method1803(var12, var13, var12 + var54.field2899, var54.field2897 + var13);
                           if(2 != client.field514 && 5 != client.field514) {
                              var20 = client.field368 + client.field350 & 2047;
                              var21 = class20.field572.field804 / 32 + 48;
                              var22 = 464 - class20.field572.field814 / 32;
                              class141.field2160.method1723(var12, var13, var54.field2899, var54.field2897, var21, var22, var20, client.field352 + 256, var54.field2898, var54.field2896);

                              for(var46 = 0; var46 < client.field508; ++var46) {
                                 var47 = 2 + 4 * client.field499[var46] - class20.field572.field804 / 32;
                                 var25 = 2 + 4 * client.field418[var46] - class20.field572.field814 / 32;
                                 class150.method3148(var12, var13, var47, var25, client.field530[var46], var54);
                              }

                              var46 = 0;

                              while(true) {
                                 if(var46 >= 104) {
                                    for(var46 = 0; var46 < client.field317; ++var46) {
                                       class34 var64 = client.field316[client.field318[var46]];
                                       if(null != var64 && var64.vmethod744()) {
                                          class39 var58 = var64.field755;
                                          if(var58 != null && null != var58.field888) {
                                             var58 = var58.method762();
                                          }

                                          if(var58 != null && var58.field879 && var58.field891) {
                                             var26 = var64.field804 / 32 - class20.field572.field804 / 32;
                                             var27 = var64.field814 / 32 - class20.field572.field814 / 32;
                                             class150.method3148(var12, var13, var26, var27, client.field512[1], var54);
                                          }
                                       }
                                    }

                                    var46 = class32.field731;
                                    int[] var66 = class32.field732;

                                    for(var25 = 0; var25 < var46; ++var25) {
                                       class2 var52 = client.field387[var66[var25]];
                                       if(null != var52 && var52.vmethod744() && !var52.field54 && class20.field572 != var52) {
                                          var27 = var52.field804 / 32 - class20.field572.field804 / 32;
                                          var28 = var52.field814 / 32 - class20.field572.field814 / 32;
                                          boolean var68 = false;
                                          if(class9.method128(var52.field45, true)) {
                                             var68 = true;
                                          }

                                          boolean var59 = false;

                                          for(var31 = 0; var31 < class26.field644; ++var31) {
                                             if(var52.field45.equals(class90.field1542[var31].field609)) {
                                                var59 = true;
                                                break;
                                             }
                                          }

                                          boolean var65 = false;
                                          if(0 != class20.field572.field62 && var52.field62 != 0 && class20.field572.field62 == var52.field62) {
                                             var65 = true;
                                          }

                                          if(var68) {
                                             class150.method3148(var12, var13, var27, var28, client.field512[3], var54);
                                          } else if(var65) {
                                             class150.method3148(var12, var13, var27, var28, client.field512[4], var54);
                                          } else if(var59) {
                                             class150.method3148(var12, var13, var27, var28, client.field512[5], var54);
                                          } else {
                                             class150.method3148(var12, var13, var27, var28, client.field512[2], var54);
                                          }
                                       }
                                    }

                                    if(client.field297 != 0 && client.field289 % 20 < 10) {
                                       if(client.field297 == 1 && client.field298 >= 0 && client.field298 < client.field316.length) {
                                          class34 var63 = client.field316[client.field298];
                                          if(null != var63) {
                                             var26 = var63.field804 / 32 - class20.field572.field804 / 32;
                                             var27 = var63.field814 / 32 - class20.field572.field814 / 32;
                                             class102.method2310(var12, var13, var26, var27, class30.field688[1], var54);
                                          }
                                       }

                                       if(client.field297 == 2) {
                                          var25 = 2 + (client.field536 * 4 - class85.field1439 * 4) - class20.field572.field804 / 32;
                                          var26 = 2 + (client.field346 * 4 - class6.field128 * 4) - class20.field572.field814 / 32;
                                          class102.method2310(var12, var13, var25, var26, class30.field688[1], var54);
                                       }

                                       if(10 == client.field297 && client.field299 >= 0 && client.field299 < client.field387.length) {
                                          class2 var67 = client.field387[client.field299];
                                          if(var67 != null) {
                                             var26 = var67.field804 / 32 - class20.field572.field804 / 32;
                                             var27 = var67.field814 / 32 - class20.field572.field814 / 32;
                                             class102.method2310(var12, var13, var26, var27, class30.field688[1], var54);
                                          }
                                       }
                                    }

                                    if(0 != client.field432) {
                                       var25 = client.field432 * 4 + 2 - class20.field572.field804 / 32;
                                       var26 = client.field513 * 4 + 2 - class20.field572.field814 / 32;
                                       class150.method3148(var12, var13, var25, var26, class30.field688[0], var54);
                                    }

                                    if(!class20.field572.field54) {
                                       class79.method1809(var12 + var54.field2899 / 2 - 1, var54.field2897 / 2 + var13 - 1, 3, 3, 16777215);
                                    }
                                    break;
                                 }

                                 for(var47 = 0; var47 < 104; ++var47) {
                                    class199 var57 = client.field410[class48.field1063][var46][var47];
                                    if(var57 != null) {
                                       var26 = var46 * 4 + 2 - class20.field572.field804 / 32;
                                       var27 = 4 * var47 + 2 - class20.field572.field814 / 32;
                                       class150.method3148(var12, var13, var26, var27, client.field512[0], var54);
                                    }
                                 }

                                 ++var46;
                              }
                           } else {
                              class79.method1812(var12, var13, 0, var54.field2898, var54.field2896);
                           }

                           client.field484[var11] = true;
                        }

                        class79.method1803(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.field2833 == 1339) {
                        var54 = var10.method3381(false);
                        if(var54 != null) {
                           if(client.field514 < 3) {
                              class138.field2127.method1723(var12, var13, var54.field2899, var54.field2897, 25, 25, client.field368, 256, var54.field2898, var54.field2896);
                           } else {
                              class79.method1812(var12, var13, 0, var54.field2898, var54.field2896);
                           }
                        }

                        class79.method1803(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.field2757 == 0) {
                     if(!var10.field2809 && class21.method579(var10) && class7.field138 != var10) {
                        continue;
                     }

                     if(!var10.field2809) {
                        if(var10.field2815 > var10.field2779 - var10.field2834) {
                           var10.field2815 = var10.field2779 - var10.field2834;
                        }

                        if(var10.field2815 < 0) {
                           var10.field2815 = 0;
                        }
                     }

                     method2547(var0, var10.field2794, var15, var16, var17, var18, var12 - var10.field2776, var13 - var10.field2815, var11);
                     if(var10.field2879 != null) {
                        method2547(var10.field2879, var10.field2794, var15, var16, var17, var18, var12 - var10.field2776, var13 - var10.field2815, var11);
                     }

                     class3 var38 = (class3)client.field439.method3788((long)var10.field2794);
                     if(var38 != null) {
                        class17.method182(var38.field69, var15, var16, var17, var18, var12, var13, var11);
                     }

                     class79.method1803(var2, var3, var4, var5);
                     class91.method2104();
                  }

                  if(client.field398 || client.field414[var11] || -755309 * client.field490 > 1) {
                     if(0 == var10.field2757 && !var10.field2809 && var10.field2779 > var10.field2834) {
                        class134.method2861(var12 + var10.field2770, var13, var10.field2815, var10.field2834, var10.field2779);
                     }

                     if(1 != var10.field2757) {
                        if(var10.field2757 == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2767; ++var20) {
                              for(var21 = 0; var21 < var10.field2766; ++var21) {
                                 var22 = var12 + var21 * (var10.field2754 + 32);
                                 var46 = var20 * (32 + var10.field2799) + var13;
                                 if(var19 < 20) {
                                    var22 += var10.field2823[var19];
                                    var46 += var10.field2841[var19];
                                 }

                                 if(var10.field2759[var19] <= 0) {
                                    if(var10.field2825 != null && var19 < 20) {
                                       class78 var60 = var10.method3379(var19);
                                       if(var60 != null) {
                                          var60.method1709(var22, var46);
                                       } else if(class173.field2752) {
                                          class9.method133(var10);
                                       }
                                    }
                                 } else {
                                    boolean var55 = false;
                                    boolean var49 = false;
                                    var26 = var10.field2759[var19] - 1;
                                    if(32 + var22 > var2 && var22 < var4 && 32 + var46 > var3 && var46 < var5 || var10 == class142.field2170 && client.field393 == var19) {
                                       class78 var50;
                                       if(1 == client.field431 && var19 == class172.field2741 && class59.field1185 == var10.field2794) {
                                          var50 = class7.method105(var26, var10.field2873[var19], 2, 0, 2, false);
                                       } else {
                                          var50 = class7.method105(var26, var10.field2873[var19], 1, 3153952, 2, false);
                                       }

                                       if(var50 != null) {
                                          if(class142.field2170 == var10 && var19 == client.field393) {
                                             var47 = class140.field2140 - client.field394;
                                             var25 = class140.field2141 - client.field375;
                                             if(var47 < 5 && var47 > -5) {
                                                var47 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(client.field524 < 5) {
                                                var47 = 0;
                                                var25 = 0;
                                             }

                                             var50.method1718(var47 + var22, var25 + var46, 128);
                                             if(-1 != var1) {
                                                class173 var53 = var0[var1 & '\uffff'];
                                                if(var25 + var46 < class79.field1385 && var53.field2815 > 0) {
                                                   var29 = client.field355 * (class79.field1385 - var46 - var25) / 3;
                                                   if(var29 > client.field355 * 10) {
                                                      var29 = client.field355 * 10;
                                                   }

                                                   if(var29 > var53.field2815) {
                                                      var29 = var53.field2815;
                                                   }

                                                   var53.field2815 -= var29;
                                                   client.field375 += var29;
                                                   class9.method133(var53);
                                                }

                                                if(32 + var46 + var25 > class79.field1386 && var53.field2815 < var53.field2779 - var53.field2834) {
                                                   var29 = client.field355 * (32 + var46 + var25 - class79.field1386) / 3;
                                                   if(var29 > client.field355 * 10) {
                                                      var29 = client.field355 * 10;
                                                   }

                                                   if(var29 > var53.field2779 - var53.field2834 - var53.field2815) {
                                                      var29 = var53.field2779 - var53.field2834 - var53.field2815;
                                                   }

                                                   var53.field2815 += var29;
                                                   client.field375 -= var29;
                                                   class9.method133(var53);
                                                }
                                             }
                                          } else if(class216.field3158 == var10 && var19 == client.field359) {
                                             var50.method1718(var22, var46, 128);
                                          } else {
                                             var50.method1709(var22, var46);
                                          }
                                       } else {
                                          class9.method133(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.field2757 == 3) {
                           if(class102.method2313(var10)) {
                              var19 = var10.field2831;
                              if(var10 == class7.field138 && 0 != var10.field2783) {
                                 var19 = var10.field2783;
                              }
                           } else {
                              var19 = var10.field2780;
                              if(var10 == class7.field138 && var10.field2782 != 0) {
                                 var19 = var10.field2782;
                              }
                           }

                           if(var10.field2784) {
                              switch(var10.field2785.field1403) {
                              case 1:
                                 class79.method1810(var12, var13, var10.field2770, var10.field2834, var10.field2780, var10.field2831, 256 - (var10.field2786 & 255), 256 - (var10.field2787 & 255));
                                 break;
                              case 2:
                                 class79.method1827(var12, var13, var10.field2770, var10.field2834, var10.field2780, var10.field2831, 256 - (var10.field2786 & 255), 256 - (var10.field2787 & 255));
                                 break;
                              case 3:
                                 class79.method1858(var12, var13, var10.field2770, var10.field2834, var10.field2780, var10.field2831, 256 - (var10.field2786 & 255), 256 - (var10.field2787 & 255));
                                 break;
                              case 4:
                                 class79.method1813(var12, var13, var10.field2770, var10.field2834, var10.field2780, var10.field2831, 256 - (var10.field2786 & 255), 256 - (var10.field2787 & 255));
                                 break;
                              default:
                                 if(0 == var14) {
                                    class79.method1809(var12, var13, var10.field2770, var10.field2834, var19);
                                 } else {
                                    class79.method1808(var12, var13, var10.field2770, var10.field2834, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              class79.method1801(var12, var13, var10.field2770, var10.field2834, var19);
                           } else {
                              class79.method1816(var12, var13, var10.field2770, var10.field2834, var19, 256 - (var14 & 255));
                           }
                        } else {
                           class224 var39;
                           if(var10.field2757 == 4) {
                              var39 = var10.method3394();
                              if(var39 == null) {
                                 if(class173.field2752) {
                                    class9.method133(var10);
                                 }
                              } else {
                                 String var51 = var10.field2853;
                                 if(class102.method2313(var10)) {
                                    var20 = var10.field2831;
                                    if(var10 == class7.field138 && 0 != var10.field2783) {
                                       var20 = var10.field2783;
                                    }

                                    if(var10.field2878.length() > 0) {
                                       var51 = var10.field2878;
                                    }
                                 } else {
                                    var20 = var10.field2780;
                                    if(class7.field138 == var10 && var10.field2782 != 0) {
                                       var20 = var10.field2782;
                                    }
                                 }

                                 if(var10.field2809 && var10.field2822 != -1) {
                                    class51 var61 = class33.method711(var10.field2822);
                                    var51 = var61.field1091;
                                    if(null == var51) {
                                       var51 = "null";
                                    }

                                    if((1 == var61.field1102 || var10.field2866 != 1) && -1 != var10.field2866) {
                                       var51 = class39.method784(16748608) + var51 + "</col>" + " " + 'x' + class1.method13(var10.field2866);
                                    }
                                 }

                                 if(var10 == client.field442) {
                                    class157 var10000 = (class157)null;
                                    var51 = "Please wait...";
                                    var20 = var10.field2780;
                                 }

                                 if(!var10.field2809) {
                                    var51 = class142.method2980(var51, var10);
                                 }

                                 var39.method4022(var51, var12, var13, var10.field2770, var10.field2834, var20, var10.field2820?0:-1, var10.field2818, var10.field2819, var10.field2817);
                              }
                           } else if(5 == var10.field2757) {
                              class78 var43;
                              if(!var10.field2809) {
                                 var43 = var10.method3377(class102.method2313(var10));
                                 if(null != var43) {
                                    var43.method1709(var12, var13);
                                 } else if(class173.field2752) {
                                    class9.method133(var10);
                                 }
                              } else {
                                 if(-1 != var10.field2822) {
                                    var43 = class7.method105(var10.field2822, var10.field2866, var10.field2839, var10.field2795, var10.field2813, false);
                                 } else {
                                    var43 = var10.method3377(false);
                                 }

                                 if(var43 == null) {
                                    if(class173.field2752) {
                                       class9.method133(var10);
                                    }
                                 } else {
                                    var20 = var43.field1372;
                                    var21 = var43.field1376;
                                    if(!var10.field2793) {
                                       var22 = var10.field2770 * 4096 / var20;
                                       if(0 != var10.field2801) {
                                          var43.method1726(var10.field2770 / 2 + var12, var13 + var10.field2834 / 2, var10.field2801, var22);
                                       } else if(var14 != 0) {
                                          var43.method1720(var12, var13, var10.field2770, var10.field2834, 256 - (var14 & 255));
                                       } else if(var10.field2770 == var20 && var10.field2834 == var21) {
                                          var43.method1709(var12, var13);
                                       } else {
                                          var43.method1749(var12, var13, var10.field2770, var10.field2834);
                                       }
                                    } else {
                                       class79.method1804(var12, var13, var12 + var10.field2770, var13 + var10.field2834);
                                       var22 = (var10.field2770 + (var20 - 1)) / var20;
                                       var46 = (var10.field2834 + (var21 - 1)) / var21;

                                       for(var47 = 0; var47 < var22; ++var47) {
                                          for(var25 = 0; var25 < var46; ++var25) {
                                             if(var10.field2801 != 0) {
                                                var43.method1726(var20 / 2 + var20 * var47 + var12, var21 / 2 + var13 + var21 * var25, var10.field2801, 4096);
                                             } else if(0 != var14) {
                                                var43.method1718(var12 + var20 * var47, var13 + var21 * var25, 256 - (var14 & 255));
                                             } else {
                                                var43.method1709(var12 + var20 * var47, var13 + var21 * var25);
                                             }
                                          }
                                       }

                                       class79.method1803(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              class51 var23;
                              if(6 == var10.field2757) {
                                 boolean var41 = class102.method2313(var10);
                                 if(var41) {
                                    var20 = var10.field2877;
                                 } else {
                                    var20 = var10.field2845;
                                 }

                                 class105 var45 = null;
                                 var22 = 0;
                                 if(var10.field2822 != -1) {
                                    var23 = class33.method711(var10.field2822);
                                    if(null != var23) {
                                       var23 = var23.method1022(var10.field2866);
                                       var45 = var23.method1021(1);
                                       if(null != var45) {
                                          var45.method2341();
                                          var22 = var45.field1438 / 2;
                                       } else {
                                          class9.method133(var10);
                                       }
                                    }
                                 } else if(5 == var10.field2798) {
                                    if(var10.field2876 == 0) {
                                       var45 = client.field551.method3469((class42)null, -1, (class42)null, -1);
                                    } else {
                                       var45 = class20.field572.vmethod1921();
                                    }
                                 } else if(var20 == -1) {
                                    var45 = var10.method3380((class42)null, -1, var41, class20.field572.field35);
                                    if(var45 == null && class173.field2752) {
                                       class9.method133(var10);
                                    }
                                 } else {
                                    class42 var48 = class46.method974(var20);
                                    var45 = var10.method3380(var48, var10.field2749, var41, class20.field572.field35);
                                    if(var45 == null && class173.field2752) {
                                       class9.method133(var10);
                                    }
                                 }

                                 class91.method2107(var12 + var10.field2770 / 2, var10.field2834 / 2 + var13);
                                 var46 = class91.field1568[var10.field2765] * var10.field2802 >> 16;
                                 var47 = class91.field1554[var10.field2765] * var10.field2802 >> 16;
                                 if(null != var45) {
                                    if(!var10.field2809) {
                                       var45.method2380(0, var10.field2807, 0, var10.field2765, 0, var46, var47);
                                    } else {
                                       var45.method2341();
                                       if(var10.field2806) {
                                          var45.method2340(0, var10.field2807, var10.field2800, var10.field2765, var10.field2804, var22 + var46 + var10.field2805, var47 + var10.field2805, var10.field2802);
                                       } else {
                                          var45.method2380(0, var10.field2807, var10.field2800, var10.field2765, var10.field2804, var10.field2805 + var46 + var22, var10.field2805 + var47);
                                       }
                                    }
                                 }

                                 class91.method2106();
                              } else {
                                 if(var10.field2757 == 7) {
                                    var39 = var10.method3394();
                                    if(null == var39) {
                                       if(class173.field2752) {
                                          class9.method133(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2767; ++var21) {
                                       for(var22 = 0; var22 < var10.field2766; ++var22) {
                                          if(var10.field2759[var20] > 0) {
                                             var23 = class33.method711(var10.field2759[var20] - 1);
                                             String var24;
                                             if(var23.field1102 != 1 && var10.field2873[var20] == 1) {
                                                var24 = class39.method784(16748608) + var23.field1091 + "</col>";
                                             } else {
                                                var24 = class39.method784(16748608) + var23.field1091 + "</col>" + " " + 'x' + class1.method13(var10.field2873[var20]);
                                             }

                                             var25 = var12 + var22 * (115 + var10.field2754);
                                             var26 = (var10.field2799 + 12) * var21 + var13;
                                             if(var10.field2818 == 0) {
                                                var39.method4019(var24, var25, var26, var10.field2780, var10.field2820?0:-1);
                                             } else if(var10.field2818 == 1) {
                                                var39.method4010(var24, var10.field2770 / 2 + var25, var26, var10.field2780, var10.field2820?0:-1);
                                             } else {
                                                var39.method4020(var24, var10.field2770 + var25 - 1, var26, var10.field2780, var10.field2820?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.field2757 == 8 && class98.field1649 == var10 && client.field370 == client.field501) {
                                    var19 = 0;
                                    var20 = 0;
                                    class224 var40 = class25.field628;
                                    String var44 = var10.field2853;

                                    String var42;
                                    for(var44 = class142.method2980(var44, var10); var44.length() > 0; var20 += var40.field3188 + 1) {
                                       var47 = var44.indexOf("<br>");
                                       if(-1 != var47) {
                                          var42 = var44.substring(0, var47);
                                          var44 = var44.substring(4 + var47);
                                       } else {
                                          var42 = var44;
                                          var44 = "";
                                       }

                                       var25 = var40.method4074(var42);
                                       if(var25 > var19) {
                                          var19 = var25;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var47 = var12 + var10.field2770 - 5 - var19;
                                    var25 = 5 + var10.field2834 + var13;
                                    if(var47 < var12 + 5) {
                                       var47 = 5 + var12;
                                    }

                                    if(var47 + var19 > var4) {
                                       var47 = var4 - var19;
                                    }

                                    if(var20 + var25 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    class79.method1809(var47, var25, var19, var20, 16777120);
                                    class79.method1801(var47, var25, var19, var20, 0);
                                    var44 = var10.field2853;
                                    var26 = var25 + var40.field3188 + 2;

                                    for(var44 = class142.method2980(var44, var10); var44.length() > 0; var26 += 1 + var40.field3188) {
                                       var27 = var44.indexOf("<br>");
                                       if(-1 != var27) {
                                          var42 = var44.substring(0, var27);
                                          var44 = var44.substring(4 + var27);
                                       } else {
                                          var42 = var44;
                                          var44 = "";
                                       }

                                       var40.method4019(var42, 3 + var47, var26, 0, -1);
                                    }
                                 }

                                 if(var10.field2757 == 9) {
                                    if(var10.field2788 == 1) {
                                       if(var10.field2789) {
                                          var19 = var12;
                                          var20 = var10.field2834 + var13;
                                          var21 = var10.field2770 + var12;
                                          var22 = var13;
                                       } else {
                                          var19 = var12;
                                          var20 = var13;
                                          var21 = var12 + var10.field2770;
                                          var22 = var10.field2834 + var13;
                                       }

                                       class79.method1865(var19, var20, var21, var22, var10.field2780);
                                    } else {
                                       var19 = var10.field2770 >= 0?var10.field2770:-var10.field2770;
                                       var20 = var10.field2834 >= 0?var10.field2834:-var10.field2834;
                                       var21 = var19;
                                       if(var19 < var20) {
                                          var21 = var20;
                                       }

                                       if(0 != var21) {
                                          var22 = (var10.field2770 << 16) / var21;
                                          var46 = (var10.field2834 << 16) / var21;
                                          if(var46 <= var22) {
                                             var22 = -var22;
                                          } else {
                                             var46 = -var46;
                                          }

                                          var47 = var10.field2788 * var46 >> 17;
                                          var25 = var10.field2788 * var46 + 1 >> 17;
                                          var26 = var10.field2788 * var22 >> 17;
                                          var27 = 1 + var22 * var10.field2788 >> 17;
                                          var28 = var12 + var47;
                                          var29 = var12 - var25;
                                          var30 = var10.field2770 + var12 - var25;
                                          var31 = var47 + var10.field2770 + var12;
                                          var32 = var13 + var26;
                                          var33 = var13 - var27;
                                          var34 = var13 + var10.field2834 - var27;
                                          var35 = var26 + var10.field2834 + var13;
                                          class91.method2112(var28, var29, var30);
                                          class91.method2115(var32, var33, var34, var28, var29, var30, var10.field2780);
                                          class91.method2112(var28, var30, var31);
                                          class91.method2115(var32, var34, var35, var28, var30, var31, var10.field2780);
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("al")
   public void method2548(int var1) {
      this.field1980[++this.field1976 - 1] = (byte)(var1 >> 8);
      this.field1980[++this.field1976 - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("ac")
   public int method2549() {
      return this.field1980[++this.field1976 - 1] - 128 & 255;
   }

   @ObfuscatedName("an")
   public int method2550() {
      return 0 - this.field1980[++this.field1976 - 1] & 255;
   }

   @ObfuscatedName("ax")
   public int method2551() {
      return 128 - this.field1980[++this.field1976 - 1] & 255;
   }

   @ObfuscatedName("au")
   public byte method2552() {
      return (byte)(this.field1980[++this.field1976 - 1] - 128);
   }

   @ObfuscatedName("ao")
   public void method2554(int var1) {
      this.field1980[++this.field1976 - 1] = (byte)var1;
      this.field1980[++this.field1976 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("aa")
   public void method2555(int var1) {
      this.field1980[++this.field1976 - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("ak")
   public void method2556(int var1) {
      this.field1980[++this.field1976 - 1] = (byte)(128 + var1);
      this.field1980[++this.field1976 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("as")
   public int method2557() {
      this.field1976 += 2;
      return (this.field1980[this.field1976 - 2] & 255) + ((this.field1980[this.field1976 - 1] & 255) << 8);
   }

   @ObfuscatedName("bo")
   public int method2560() {
      this.field1976 += 2;
      int var1 = (this.field1980[this.field1976 - 2] - 128 & 255) + ((this.field1980[this.field1976 - 1] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bq")
   public int method2561() {
      this.field1976 += 2;
      return ((this.field1980[this.field1976 - 1] & 255) << 8) + (this.field1980[this.field1976 - 2] - 128 & 255);
   }

   @ObfuscatedName("bd")
   public void method2563(int var1) {
      this.field1980[++this.field1976 - 1] = (byte)(var1 >> 8);
      this.field1980[++this.field1976 - 1] = (byte)var1;
      this.field1980[++this.field1976 - 1] = (byte)(var1 >> 24);
      this.field1980[++this.field1976 - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("w")
   public void method2565(int var1) {
      this.field1980[++this.field1976 - 1] = (byte)var1;
   }

   @ObfuscatedName("bn")
   public int method2566() {
      this.field1976 += 4;
      return (this.field1980[this.field1976 - 3] & 255) + ((this.field1980[this.field1976 - 4] & 255) << 8) + ((this.field1980[this.field1976 - 2] & 255) << 24) + ((this.field1980[this.field1976 - 1] & 255) << 16);
   }

   @ObfuscatedName("by")
   public int method2567() {
      this.field1976 += 4;
      return ((this.field1980[this.field1976 - 1] & 255) << 8) + ((this.field1980[this.field1976 - 3] & 255) << 24) + ((this.field1980[this.field1976 - 4] & 255) << 16) + (this.field1980[this.field1976 - 2] & 255);
   }

   static {
      int var2;
      for(int var1 = 0; var1 < 256; ++var1) {
         int var0 = var1;

         for(var2 = 0; var2 < 8; ++var2) {
            if((var0 & 1) == 1) {
               var0 = var0 >>> 1 ^ -306674912;
            } else {
               var0 >>>= 1;
            }
         }

         field1979[var1] = var0;
      }

      field1984 = new long[256];

      for(var2 = 0; var2 < 256; ++var2) {
         long var4 = (long)var2;

         for(int var3 = 0; var3 < 8; ++var3) {
            if(1L == (var4 & 1L)) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         field1984[var2] = var4;
      }

   }

   @ObfuscatedName("g")
   public void method2580(long var1) {
      this.field1980[++this.field1976 - 1] = (byte)((int)(var1 >> 56));
      this.field1980[++this.field1976 - 1] = (byte)((int)(var1 >> 48));
      this.field1980[++this.field1976 - 1] = (byte)((int)(var1 >> 40));
      this.field1980[++this.field1976 - 1] = (byte)((int)(var1 >> 32));
      this.field1980[++this.field1976 - 1] = (byte)((int)(var1 >> 24));
      this.field1980[++this.field1976 - 1] = (byte)((int)(var1 >> 16));
      this.field1980[++this.field1976 - 1] = (byte)((int)(var1 >> 8));
      this.field1980[++this.field1976 - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("bj")
   public int method2587() {
      this.field1976 += 2;
      return ((this.field1980[this.field1976 - 2] & 255) << 8) + (this.field1980[this.field1976 - 1] - 128 & 255);
   }

   @ObfuscatedName("at")
   public byte method2588() {
      return (byte)(0 - this.field1980[++this.field1976 - 1]);
   }

   @ObfuscatedName("p")
   public void method2617(int var1) {
      this.field1980[++this.field1976 - 1] = (byte)(var1 >> 24);
      this.field1980[++this.field1976 - 1] = (byte)(var1 >> 16);
      this.field1980[++this.field1976 - 1] = (byte)(var1 >> 8);
      this.field1980[++this.field1976 - 1] = (byte)var1;
   }

   @ObfuscatedName("ap")
   public String method2624() {
      byte var1 = this.field1980[++this.field1976 - 1];
      if(0 != var1) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.method2679();
         if(this.field1976 + var2 > this.field1980.length) {
            throw new IllegalStateException("");
         } else {
            byte[] var4 = this.field1980;
            int var5 = this.field1976;
            char[] var6 = new char[var2];
            int var7 = 0;
            int var8 = var5;

            int var11;
            for(int var9 = var5 + var2; var8 < var9; var6[var7++] = (char)var11) {
               int var10 = var4[var8++] & 255;
               if(var10 < 128) {
                  if(var10 == 0) {
                     var11 = '�';
                  } else {
                     var11 = var10;
                  }
               } else if(var10 < 192) {
                  var11 = '�';
               } else if(var10 < 224) {
                  if(var8 < var9 && 128 == (var4[var8] & 192)) {
                     var11 = (var10 & 31) << 6 | var4[var8++] & 63;
                     if(var11 < 128) {
                        var11 = '�';
                     }
                  } else {
                     var11 = '�';
                  }
               } else if(var10 < 240) {
                  if(1 + var8 < var9 && (var4[var8] & 192) == 128 && 128 == (var4[var8 + 1] & 192)) {
                     var11 = (var10 & 15) << 12 | (var4[var8++] & 63) << 6 | var4[var8++] & 63;
                     if(var11 < 2048) {
                        var11 = '�';
                     }
                  } else {
                     var11 = '�';
                  }
               } else if(var10 < 248) {
                  if(2 + var8 < var9 && (var4[var8] & 192) == 128 && (var4[1 + var8] & 192) == 128 && 128 == (var4[var8 + 2] & 192)) {
                     var11 = (var10 & 7) << 18 | (var4[var8++] & 63) << 12 | (var4[var8++] & 63) << 6 | var4[var8++] & 63;
                     if(var11 >= 65536 && var11 <= 1114111) {
                        var11 = '�';
                     } else {
                        var11 = '�';
                     }
                  } else {
                     var11 = '�';
                  }
               } else {
                  var11 = '�';
               }
            }

            String var3 = new String(var6, 0, var7);
            this.field1976 += var2;
            return var3;
         }
      }
   }

   @ObfuscatedName("af")
   public int method2627(int var1) {
      byte[] var3 = this.field1980;
      int var4 = this.field1976;
      int var5 = -1;

      for(int var6 = var1; var6 < var4; ++var6) {
         var5 = var5 >>> 8 ^ field1979[(var5 ^ var3[var6]) & 255];
      }

      var5 = ~var5;
      this.method2617(var5);
      return var5;
   }

   @ObfuscatedName("x")
   public byte method2633() {
      return this.field1980[++this.field1976 - 1];
   }

   @ObfuscatedName("av")
   public void method2641(BigInteger var1, BigInteger var2) {
      int var3 = this.field1976;
      this.field1976 = 0;
      byte[] var4 = new byte[var3];
      this.method2709(var4, 0, var3);
      BigInteger var5 = new BigInteger(var4);
      BigInteger var6 = var5.modPow(var1, var2);
      byte[] var7 = var6.toByteArray();
      this.field1976 = 0;
      this.method2713(var7.length);
      this.method2517(var7, 0, var7.length);
   }

   @ObfuscatedName("h")
   public void method2646(long var1) {
      this.field1980[++this.field1976 - 1] = (byte)((int)(var1 >> 40));
      this.field1980[++this.field1976 - 1] = (byte)((int)(var1 >> 32));
      this.field1980[++this.field1976 - 1] = (byte)((int)(var1 >> 24));
      this.field1980[++this.field1976 - 1] = (byte)((int)(var1 >> 16));
      this.field1980[++this.field1976 - 1] = (byte)((int)(var1 >> 8));
      this.field1980[++this.field1976 - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("bw")
   public int method2663() {
      this.field1976 += 4;
      return ((this.field1980[this.field1976 - 2] & 255) << 16) + ((this.field1980[this.field1976 - 1] & 255) << 24) + ((this.field1980[this.field1976 - 3] & 255) << 8) + (this.field1980[this.field1976 - 4] & 255);
   }

   public class119(int var1) {
      this.field1980 = class121.method2751(var1);
      this.field1976 = 0;
   }

   @ObfuscatedName("ar")
   public int method2679() {
      byte var1 = this.field1980[++this.field1976 - 1];

      int var2;
      for(var2 = 0; var1 < 0; var1 = this.field1980[++this.field1976 - 1]) {
         var2 = (var2 | var1 & 127) << 7;
      }

      return var2 | var1;
   }

   @ObfuscatedName("bl")
   public void method2683(int var1) {
      this.field1980[++this.field1976 - 1] = (byte)var1;
      this.field1980[++this.field1976 - 1] = (byte)(var1 >> 8);
      this.field1980[++this.field1976 - 1] = (byte)(var1 >> 16);
      this.field1980[++this.field1976 - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("y")
   public void method2691(int var1) {
      this.field1980[this.field1976 - var1 - 4] = (byte)(var1 >> 24);
      this.field1980[this.field1976 - var1 - 3] = (byte)(var1 >> 16);
      this.field1980[this.field1976 - var1 - 2] = (byte)(var1 >> 8);
      this.field1980[this.field1976 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("b")
   public int method2700() {
      this.field1976 += 2;
      return ((this.field1980[this.field1976 - 2] & 255) << 8) + (this.field1980[this.field1976 - 1] & 255);
   }

   @ObfuscatedName("ad")
   public void method2708(int var1) {
      this.field1980[++this.field1976 - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1863330514"
   )
   public void method2709(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         var1[var4] = this.field1980[++this.field1976 - 1];
      }

   }

   @ObfuscatedName("bh")
   public void method2710(int var1) {
      this.field1980[++this.field1976 - 1] = (byte)(var1 >> 16);
      this.field1980[++this.field1976 - 1] = (byte)(var1 >> 24);
      this.field1980[++this.field1976 - 1] = (byte)var1;
      this.field1980[++this.field1976 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("f")
   public void method2713(int var1) {
      this.field1980[++this.field1976 - 1] = (byte)(var1 >> 8);
      this.field1980[++this.field1976 - 1] = (byte)var1;
   }
}

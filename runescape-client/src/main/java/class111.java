import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
@Implements("CollisionData")
public class class111 {
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -65013241
   )
   @Export("width")
   int field1948;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1996990729
   )
   @Export("x")
   int field1951 = 0;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -953832955
   )
   @Export("y")
   int field1952 = 0;
   @ObfuscatedName("af")
   @Export("flags")
   public int[][] field1954;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1983386095
   )
   @Export("height")
   int field1957;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1796101010"
   )
   public void method2451(int var1, int var2, int var3, int var4, boolean var5) {
      int var6 = 256;
      if(var5) {
         var6 += 131072;
      }

      var1 -= this.field1951;
      var2 -= this.field1952;

      for(int var7 = var1; var7 < var1 + var3; ++var7) {
         if(var7 >= 0 && var7 < this.field1948) {
            for(int var8 = var2; var8 < var2 + var4; ++var8) {
               if(var8 >= 0 && var8 < this.field1957) {
                  this.method2456(var7, var8, var6);
               }
            }
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "104"
   )
   public class111(int var1, int var2) {
      this.field1948 = var1;
      this.field1957 = var2;
      this.field1954 = new int[this.field1948][this.field1957];
      this.method2479();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1695687962"
   )
   public void method2452(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.field1951;
      var2 -= this.field1952;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2456(var1, var2, 128);
            this.method2456(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2456(var1, var2, 2);
            this.method2456(var1, 1 + var2, 32);
         }

         if(var4 == 2) {
            this.method2456(var1, var2, 8);
            this.method2456(var1 + 1, var2, 128);
         }

         if(var4 == 3) {
            this.method2456(var1, var2, 32);
            this.method2456(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2456(var1, var2, 1);
            this.method2456(var1 - 1, var2 + 1, 16);
         }

         if(var4 == 1) {
            this.method2456(var1, var2, 4);
            this.method2456(1 + var1, var2 + 1, 64);
         }

         if(var4 == 2) {
            this.method2456(var1, var2, 16);
            this.method2456(var1 + 1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2456(var1, var2, 64);
            this.method2456(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2456(var1, var2, 130);
            this.method2456(var1 - 1, var2, 8);
            this.method2456(var1, 1 + var2, 32);
         }

         if(var4 == 1) {
            this.method2456(var1, var2, 10);
            this.method2456(var1, var2 + 1, 32);
            this.method2456(1 + var1, var2, 128);
         }

         if(var4 == 2) {
            this.method2456(var1, var2, 40);
            this.method2456(var1 + 1, var2, 128);
            this.method2456(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2456(var1, var2, 160);
            this.method2456(var1, var2 - 1, 2);
            this.method2456(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2456(var1, var2, 65536);
               this.method2456(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2456(var1, var2, 1024);
               this.method2456(var1, 1 + var2, 16384);
            }

            if(var4 == 2) {
               this.method2456(var1, var2, 4096);
               this.method2456(1 + var1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2456(var1, var2, 16384);
               this.method2456(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2456(var1, var2, 512);
               this.method2456(var1 - 1, 1 + var2, 8192);
            }

            if(var4 == 1) {
               this.method2456(var1, var2, 2048);
               this.method2456(var1 + 1, var2 + 1, '耀');
            }

            if(var4 == 2) {
               this.method2456(var1, var2, 8192);
               this.method2456(var1 + 1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2456(var1, var2, '耀');
               this.method2456(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2456(var1, var2, 66560);
               this.method2456(var1 - 1, var2, 4096);
               this.method2456(var1, var2 + 1, 16384);
            }

            if(var4 == 1) {
               this.method2456(var1, var2, 5120);
               this.method2456(var1, var2 + 1, 16384);
               this.method2456(1 + var1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2456(var1, var2, 20480);
               this.method2456(1 + var1, var2, 65536);
               this.method2456(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2456(var1, var2, 81920);
               this.method2456(var1, var2 - 1, 1024);
               this.method2456(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2108894091"
   )
   public void method2454(int var1, int var2) {
      var1 -= this.field1951;
      var2 -= this.field1952;
      this.field1954[var1][var2] |= 2097152;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "56"
   )
   void method2456(int var1, int var2, int var3) {
      this.field1954[var1][var2] |= var3;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1165523238"
   )
   public void method2457(int var1, int var2, int var3, int var4, boolean var5) {
      var1 -= this.field1951;
      var2 -= this.field1952;
      if(var3 == 0) {
         if(var4 == 0) {
            this.method2460(var1, var2, 128);
            this.method2460(var1 - 1, var2, 8);
         }

         if(var4 == 1) {
            this.method2460(var1, var2, 2);
            this.method2460(var1, 1 + var2, 32);
         }

         if(var4 == 2) {
            this.method2460(var1, var2, 8);
            this.method2460(1 + var1, var2, 128);
         }

         if(var4 == 3) {
            this.method2460(var1, var2, 32);
            this.method2460(var1, var2 - 1, 2);
         }
      }

      if(var3 == 1 || var3 == 3) {
         if(var4 == 0) {
            this.method2460(var1, var2, 1);
            this.method2460(var1 - 1, 1 + var2, 16);
         }

         if(var4 == 1) {
            this.method2460(var1, var2, 4);
            this.method2460(1 + var1, 1 + var2, 64);
         }

         if(var4 == 2) {
            this.method2460(var1, var2, 16);
            this.method2460(1 + var1, var2 - 1, 1);
         }

         if(var4 == 3) {
            this.method2460(var1, var2, 64);
            this.method2460(var1 - 1, var2 - 1, 4);
         }
      }

      if(var3 == 2) {
         if(var4 == 0) {
            this.method2460(var1, var2, 130);
            this.method2460(var1 - 1, var2, 8);
            this.method2460(var1, 1 + var2, 32);
         }

         if(var4 == 1) {
            this.method2460(var1, var2, 10);
            this.method2460(var1, 1 + var2, 32);
            this.method2460(var1 + 1, var2, 128);
         }

         if(var4 == 2) {
            this.method2460(var1, var2, 40);
            this.method2460(var1 + 1, var2, 128);
            this.method2460(var1, var2 - 1, 2);
         }

         if(var4 == 3) {
            this.method2460(var1, var2, 160);
            this.method2460(var1, var2 - 1, 2);
            this.method2460(var1 - 1, var2, 8);
         }
      }

      if(var5) {
         if(var3 == 0) {
            if(var4 == 0) {
               this.method2460(var1, var2, 65536);
               this.method2460(var1 - 1, var2, 4096);
            }

            if(var4 == 1) {
               this.method2460(var1, var2, 1024);
               this.method2460(var1, var2 + 1, 16384);
            }

            if(var4 == 2) {
               this.method2460(var1, var2, 4096);
               this.method2460(var1 + 1, var2, 65536);
            }

            if(var4 == 3) {
               this.method2460(var1, var2, 16384);
               this.method2460(var1, var2 - 1, 1024);
            }
         }

         if(var3 == 1 || var3 == 3) {
            if(var4 == 0) {
               this.method2460(var1, var2, 512);
               this.method2460(var1 - 1, var2 + 1, 8192);
            }

            if(var4 == 1) {
               this.method2460(var1, var2, 2048);
               this.method2460(var1 + 1, 1 + var2, '耀');
            }

            if(var4 == 2) {
               this.method2460(var1, var2, 8192);
               this.method2460(1 + var1, var2 - 1, 512);
            }

            if(var4 == 3) {
               this.method2460(var1, var2, '耀');
               this.method2460(var1 - 1, var2 - 1, 2048);
            }
         }

         if(var3 == 2) {
            if(var4 == 0) {
               this.method2460(var1, var2, 66560);
               this.method2460(var1 - 1, var2, 4096);
               this.method2460(var1, 1 + var2, 16384);
            }

            if(var4 == 1) {
               this.method2460(var1, var2, 5120);
               this.method2460(var1, 1 + var2, 16384);
               this.method2460(1 + var1, var2, 65536);
            }

            if(var4 == 2) {
               this.method2460(var1, var2, 20480);
               this.method2460(var1 + 1, var2, 65536);
               this.method2460(var1, var2 - 1, 1024);
            }

            if(var4 == 3) {
               this.method2460(var1, var2, 81920);
               this.method2460(var1, var2 - 1, 1024);
               this.method2460(var1 - 1, var2, 4096);
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)V",
      garbageValue = "-46932771"
   )
   public void method2458(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      int var7 = 256;
      if(var6) {
         var7 += 131072;
      }

      var1 -= this.field1951;
      var2 -= this.field1952;
      int var8;
      if(var5 == 1 || var5 == 3) {
         var8 = var3;
         var3 = var4;
         var4 = var8;
      }

      for(var8 = var1; var8 < var3 + var1; ++var8) {
         if(var8 >= 0 && var8 < this.field1948) {
            for(int var9 = var2; var9 < var4 + var2; ++var9) {
               if(var9 >= 0 && var9 < this.field1957) {
                  this.method2460(var8, var9, var7);
               }
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-525525288"
   )
   void method2460(int var1, int var2, int var3) {
      this.field1954[var1][var2] &= ~var3;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-76"
   )
   static final int method2463(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class40.method790(var3, var5);
      int var8 = class40.method790(1 + var3, var5);
      int var9 = class40.method790(var3, var5 + 1);
      int var10 = class40.method790(var3 + 1, 1 + var5);
      int var11 = class27.method626(var7, var8, var4, var2);
      int var12 = class27.method626(var9, var10, var4, var2);
      int var14 = 65536 - class94.field1661[var6 * 1024 / var2] >> 1;
      int var13 = (var12 * var14 >> 16) + (var11 * (65536 - var14) >> 16);
      return var13;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "377313882"
   )
   public void method2471(int var1, int var2) {
      var1 -= this.field1951;
      var2 -= this.field1952;
      this.field1954[var1][var2] |= 262144;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "171725036"
   )
   public void method2474(int var1, int var2) {
      var1 -= this.field1951;
      var2 -= this.field1952;
      this.field1954[var1][var2] &= -262145;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "522741562"
   )
   public void method2479() {
      for(int var1 = 0; var1 < this.field1948; ++var1) {
         for(int var2 = 0; var2 < this.field1957; ++var2) {
            if(var1 != 0 && var2 != 0 && var1 < this.field1948 - 5 && var2 < this.field1957 - 5) {
               this.field1954[var1][var2] = 16777216;
            } else {
               this.field1954[var1][var2] = 16777215;
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-792063907"
   )
   public static int method2480(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class12.method153(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Lclass39;IIIIII)V",
      garbageValue = "-2017026668"
   )
   static final void method2481(class39 var0, int var1, int var2, int var3, int var4, int var5) {
      if(var0 != null && var0.vmethod786()) {
         if(var0 instanceof class36) {
            class41 var6 = ((class36)var0).field802;
            if(null != var6.field934) {
               var6 = var6.method797();
            }

            if(null == var6) {
               return;
            }
         }

         int var78 = class34.field777;
         int[] var7 = class34.field780;
         int var8 = 3;
         int var14;
         int var21;
         if(!var0.field855.method3924()) {
            class3.method37(var0, 15 + var0.field880);

            for(class26 var9 = (class26)var0.field855.method3921(); null != var9; var9 = (class26)var0.field855.method3936()) {
               class20 var10 = var9.method601(client.field282);
               if(var10 == null) {
                  if(var9.method602()) {
                     var9.method3990();
                  }
               } else {
                  class49 var11 = var9.field635;
                  class81 var12 = var11.method1023();
                  class81 var13 = var11.method1032();
                  if(var12 != null && null != var13) {
                     var14 = var13.field1476;
                  } else {
                     var14 = var11.field1102;
                  }

                  int var15 = 255;
                  boolean var16 = true;
                  int var76 = client.field282 - var10.field565;
                  int var18 = var14 * var10.field556 / var11.field1102;
                  int var20;
                  int var74;
                  int var88;
                  if(var10.field558 > var76) {
                     var74 = var11.field1101 == 0?0:var11.field1101 * (var76 / var11.field1101);
                     var20 = var10.field557 * var14 / var11.field1102;
                     var88 = (var18 - var20) * var74 / var10.field558 + var20;
                  } else {
                     var88 = var18;
                     var74 = var10.field558 + var11.field1095 - var76;
                     if(var11.field1100 >= 0) {
                        var15 = (var74 << 8) / (var11.field1095 - var11.field1100);
                     }
                  }

                  if(var10.field556 > 0 && var88 < 2) {
                     var88 = 2;
                  }

                  var74 = client.field378 + var2 - (var14 >> 1);
                  var20 = var3 + client.field397 - var8;
                  if(null != var12 && null != var13) {
                     var21 = var12.field1480;
                     var8 += var21;
                     if(var15 >= 0 && var15 < 255) {
                        var12.method1797(var74, var20, var15);
                        class82.method1876(var74, var20, var88 + var74, var21 + var20);
                        var13.method1797(var74, var20, var15);
                     } else {
                        var12.method1800(var74, var20);
                        class82.method1876(var74, var20, var88 + var74, var20 + var21);
                        var13.method1800(var74, var20);
                     }

                     class82.method1875(var2, var3, var4 + var2, var3 + var5);
                     var8 += 2;
                  } else {
                     if(client.field378 > -1) {
                        class82.method1880(var74, var20, var88, 5, '\uff00');
                        class82.method1880(var88 + var74, var20, var14 - var88, 5, 16711680);
                     }

                     var8 += 7;
                  }
               }
            }
         }

         if(var8 < 30) {
            var8 = 30;
         }

         if(var1 < var78) {
            class2 var85 = (class2)var0;
            if(var85.field56) {
               return;
            }

            if(var85.field38 != -1 || var85.field62 != -1) {
               class3.method37(var0, 15 + var0.field880);
               if(client.field378 > -1) {
                  if(var85.field38 != -1) {
                     class14.field187[var85.field38].method1800(var2 + client.field378 - 12, client.field397 + var3 - var8);
                     var8 += 25;
                  }

                  if(var85.field62 != -1) {
                     client.field348[var85.field62].method1800(var2 + client.field378 - 12, client.field397 + var3 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && client.field418 == 10 && client.field336 == var7[var1]) {
               class3.method37(var0, 15 + var0.field880);
               if(client.field378 > -1) {
                  class54.field1165[1].method1800(var2 + client.field378 - 12, client.field397 + var3 - var8);
               }
            }
         } else {
            class41 var86 = ((class36)var0).field802;
            if(var86.field934 != null) {
               var86 = var86.method797();
            }

            if(var86.field932 >= 0 && var86.field932 < client.field348.length) {
               class3.method37(var0, 15 + var0.field880);
               if(client.field378 > -1) {
                  client.field348[var86.field932].method1800(client.field378 + var2 - 12, var3 + client.field397 - 30);
               }
            }

            if(client.field418 == 1 && client.field291 == client.field310[var1 - var78] && client.field282 % 20 < 10) {
               class3.method37(var0, var0.field880 + 15);
               if(client.field378 > -1) {
                  class54.field1165[0].method1800(client.field378 + var2 - 12, client.field397 + var3 - 28);
               }
            }
         }

         if(null != var0.field843 && (var1 >= var78 || !var0.field830 && (client.field395 == 4 || !var0.field844 && (client.field395 == 0 || client.field395 == 3 || client.field395 == 1 && class166.method3234(((class2)var0).field43, false))))) {
            class3.method37(var0, var0.field880);
            if(client.field378 > -1 && client.field366 < client.field300) {
               client.field512[client.field366] = class1.field25.method4094(var0.field843) / 2;
               client.field370[client.field366] = class1.field25.field3237;
               client.field343[client.field366] = client.field378;
               client.field279[client.field366] = client.field397;
               client.field372[client.field366] = var0.field833;
               client.field373[client.field366] = var0.field889;
               client.field374[client.field366] = var0.field890;
               client.field375[client.field366] = var0.field843;
               ++client.field366;
            }
         }

         for(int var80 = 0; var80 < 4; ++var80) {
            int var79 = var0.field845[var80];
            int var82 = var0.field850[var80];
            class51 var87 = null;
            int var83 = 0;
            if(var82 >= 0) {
               if(var79 <= client.field282) {
                  continue;
               }

               var87 = class17.method185(var0.field850[var80]);
               var83 = var87.field1127;
            } else if(var79 < 0) {
               continue;
            }

            var14 = var0.field853[var80];
            class51 var75 = null;
            if(var14 >= 0) {
               var75 = class17.method185(var14);
            }

            if(var79 - var83 <= client.field282) {
               if(null == var87) {
                  var0.field845[var80] = -1;
               } else {
                  class3.method37(var0, var0.field880 / 2);
                  if(client.field378 > -1) {
                     if(var80 == 1) {
                        client.field397 -= 20;
                     }

                     if(var80 == 2) {
                        client.field378 -= 15;
                        client.field397 -= 10;
                     }

                     if(var80 == 3) {
                        client.field378 += 15;
                        client.field397 -= 10;
                     }

                     class81 var17 = null;
                     class81 var81 = null;
                     class81 var19 = null;
                     class81 var84 = null;
                     var21 = 0;
                     int var22 = 0;
                     int var23 = 0;
                     int var24 = 0;
                     int var25 = 0;
                     int var26 = 0;
                     int var27 = 0;
                     int var28 = 0;
                     class81 var29 = null;
                     class81 var30 = null;
                     class81 var31 = null;
                     class81 var32 = null;
                     int var33 = 0;
                     int var34 = 0;
                     int var35 = 0;
                     int var36 = 0;
                     int var37 = 0;
                     int var38 = 0;
                     int var39 = 0;
                     int var40 = 0;
                     int var41 = 0;
                     var17 = var87.method1063();
                     int var42;
                     if(var17 != null) {
                        var21 = var17.field1476;
                        var42 = var17.field1480;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var25 = var17.field1478;
                     }

                     var81 = var87.method1059();
                     if(var81 != null) {
                        var22 = var81.field1476;
                        var42 = var81.field1480;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var26 = var81.field1478;
                     }

                     var19 = var87.method1064();
                     if(null != var19) {
                        var23 = var19.field1476;
                        var42 = var19.field1480;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var27 = var19.field1478;
                     }

                     var84 = var87.method1065();
                     if(null != var84) {
                        var24 = var84.field1476;
                        var42 = var84.field1480;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var28 = var84.field1478;
                     }

                     if(null != var75) {
                        var29 = var75.method1063();
                        if(var29 != null) {
                           var33 = var29.field1476;
                           var42 = var29.field1480;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var37 = var29.field1478;
                        }

                        var30 = var75.method1059();
                        if(var30 != null) {
                           var34 = var30.field1476;
                           var42 = var30.field1480;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var38 = var30.field1478;
                        }

                        var31 = var75.method1064();
                        if(var31 != null) {
                           var35 = var31.field1476;
                           var42 = var31.field1480;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var39 = var31.field1478;
                        }

                        var32 = var75.method1065();
                        if(null != var32) {
                           var36 = var32.field1476;
                           var42 = var32.field1480;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var40 = var32.field1478;
                        }
                     }

                     class227 var77 = var87.method1090();
                     if(null == var77) {
                        var77 = class12.field171;
                     }

                     class227 var43;
                     if(var75 != null) {
                        var43 = var75.method1090();
                        if(var43 == null) {
                           var43 = class12.field171;
                        }
                     } else {
                        var43 = class12.field171;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var87.method1061(var0.field848[var80]);
                     int var89 = var77.method4094(var44);
                     if(null != var75) {
                        var45 = var75.method1061(var0.field854[var80]);
                        var47 = var43.method4094(var45);
                     }

                     int var48 = 0;
                     int var49 = 0;
                     if(var22 > 0) {
                        if(null == var19 && null == var84) {
                           var48 = 1;
                        } else {
                           var48 = var89 / var22 + 1;
                        }
                     }

                     if(var75 != null && var34 > 0) {
                        if(null == var31 && null == var32) {
                           var49 = 1;
                        } else {
                           var49 = 1 + var47 / var34;
                        }
                     }

                     int var50 = 0;
                     int var51 = var50;
                     if(var21 > 0) {
                        var50 += var21;
                     }

                     var50 += 2;
                     int var52 = var50;
                     if(var23 > 0) {
                        var50 += var23;
                     }

                     int var53 = var50;
                     int var54 = var50;
                     int var55;
                     if(var22 > 0) {
                        var55 = var22 * var48;
                        var50 += var55;
                        var54 += (var55 - var89) / 2;
                     } else {
                        var50 += var89;
                     }

                     var55 = var50;
                     if(var24 > 0) {
                        var50 += var24;
                     }

                     int var56 = 0;
                     int var57 = 0;
                     int var58 = 0;
                     int var59 = 0;
                     int var60 = 0;
                     int var61;
                     if(var75 != null) {
                        var50 += 2;
                        var56 = var50;
                        if(var33 > 0) {
                           var50 += var33;
                        }

                        var50 += 2;
                        var57 = var50;
                        if(var35 > 0) {
                           var50 += var35;
                        }

                        var58 = var50;
                        var60 = var50;
                        if(var34 > 0) {
                           var61 = var49 * var34;
                           var50 += var61;
                           var60 += (var61 - var47) / 2;
                        } else {
                           var50 += var47;
                        }

                        var59 = var50;
                        if(var36 > 0) {
                           var50 += var36;
                        }
                     }

                     var61 = var0.field845[var80] - client.field282;
                     int var62 = var87.field1133 - var61 * var87.field1133 / var87.field1127;
                     int var63 = var61 * var87.field1121 / var87.field1127 + -var87.field1121;
                     int var64 = var62 + (client.field378 + var2 - (var50 >> 1));
                     int var65 = client.field397 + var3 - 12 + var63;
                     int var66 = var65;
                     int var67 = var41 + var65;
                     int var68 = var87.field1130 + var65 + 15;
                     int var69 = var68 - var77.field3234;
                     int var70 = var68 + var77.field3240;
                     if(var69 < var65) {
                        var66 = var69;
                     }

                     if(var70 > var67) {
                        var67 = var70;
                     }

                     int var71 = 0;
                     int var72;
                     int var73;
                     if(var75 != null) {
                        var71 = var75.field1130 + var65 + 15;
                        var72 = var71 - var43.field3234;
                        var73 = var43.field3240 + var71;
                        if(var72 < var66) {
                           ;
                        }

                        if(var73 > var67) {
                           ;
                        }
                     }

                     var72 = 255;
                     if(var87.field1134 >= 0) {
                        var72 = (var61 << 8) / (var87.field1127 - var87.field1134);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(var17 != null) {
                           var17.method1797(var51 + var64 - var25, var65, var72);
                        }

                        if(var19 != null) {
                           var19.method1797(var52 + var64 - var27, var65, var72);
                        }

                        if(null != var81) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var81.method1797(var53 + var64 - var26 + var22 * var73, var65, var72);
                           }
                        }

                        if(null != var84) {
                           var84.method1797(var55 + var64 - var28, var65, var72);
                        }

                        var77.method4100(var44, var64 + var54, var68, var87.field1126, 0, var72);
                        if(var75 != null) {
                           if(null != var29) {
                              var29.method1797(var64 + var56 - var37, var65, var72);
                           }

                           if(null != var31) {
                              var31.method1797(var57 + var64 - var39, var65, var72);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method1797(var73 * var34 + (var58 + var64 - var38), var65, var72);
                              }
                           }

                           if(var32 != null) {
                              var32.method1797(var64 + var59 - var40, var65, var72);
                           }

                           var43.method4100(var45, var64 + var60, var71, var75.field1126, 0, var72);
                        }
                     } else {
                        if(var17 != null) {
                           var17.method1800(var64 + var51 - var25, var65);
                        }

                        if(var19 != null) {
                           var19.method1800(var64 + var52 - var27, var65);
                        }

                        if(null != var81) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var81.method1800(var53 + var64 - var26 + var22 * var73, var65);
                           }
                        }

                        if(null != var84) {
                           var84.method1800(var55 + var64 - var28, var65);
                        }

                        var77.method4099(var44, var64 + var54, var68, var87.field1126 | -16777216, 0);
                        if(var75 != null) {
                           if(null != var29) {
                              var29.method1800(var56 + var64 - var37, var65);
                           }

                           if(null != var31) {
                              var31.method1800(var57 + var64 - var39, var65);
                           }

                           if(null != var30) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method1800(var64 + var58 - var38 + var34 * var73, var65);
                              }
                           }

                           if(var32 != null) {
                              var32.method1800(var59 + var64 - var40, var65);
                           }

                           var43.method4099(var45, var60 + var64, var71, var75.field1126 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass125;I)V",
      garbageValue = "-1174220687"
   )
   public static void method2482(class125 var0) {
      class213 var1 = (class213)class214.field3180.method3921();
      if(var1 != null) {
         int var2 = var0.field2045;
         var0.method2560(var1.field3177);

         for(int var3 = 0; var3 < var1.field3173; ++var3) {
            if(var1.field3176[var3] != 0) {
               var0.method2557(var1.field3176[var3]);
            } else {
               try {
                  int var4 = var1.field3174[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.field3178[var3];
                     var6 = var5.getInt((Object)null);
                     var0.method2557(0);
                     var0.method2560(var6);
                  } else if(var4 == 1) {
                     var5 = var1.field3178[var3];
                     var5.setInt((Object)null, var1.field3179[var3]);
                     var0.method2557(0);
                  } else if(var4 == 2) {
                     var5 = var1.field3178[var3];
                     var6 = var5.getModifiers();
                     var0.method2557(0);
                     var0.method2560(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.field3172[var3];
                        var6 = var25.getModifiers();
                        var0.method2557(0);
                        var0.method2560(var6);
                     }
                  } else {
                     var25 = var1.field3172[var3];
                     byte[][] var10 = var1.field3175[var3];
                     Object[] var7 = new Object[var10.length];

                     for(int var8 = 0; var8 < var10.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var11 = var25.invoke((Object)null, var7);
                     if(var11 == null) {
                        var0.method2557(0);
                     } else if(var11 instanceof Number) {
                        var0.method2557(1);
                        var0.method2562(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.method2557(2);
                        var0.method2563((String)var11);
                     } else {
                        var0.method2557(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.method2557(-10);
               } catch (InvalidClassException var14) {
                  var0.method2557(-11);
               } catch (StreamCorruptedException var15) {
                  var0.method2557(-12);
               } catch (OptionalDataException var16) {
                  var0.method2557(-13);
               } catch (IllegalAccessException var17) {
                  var0.method2557(-14);
               } catch (IllegalArgumentException var18) {
                  var0.method2557(-15);
               } catch (InvocationTargetException var19) {
                  var0.method2557(-16);
               } catch (SecurityException var20) {
                  var0.method2557(-17);
               } catch (IOException var21) {
                  var0.method2557(-18);
               } catch (NullPointerException var22) {
                  var0.method2557(-19);
               } catch (Exception var23) {
                  var0.method2557(-20);
               } catch (Throwable var24) {
                  var0.method2557(-21);
               }
            }
         }

         var0.method2736(var2);
         var1.method3990();
      }
   }
}

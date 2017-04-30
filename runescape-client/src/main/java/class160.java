import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public class class160 extends class68 {
   @ObfuscatedName("v")
   int[] field2074;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -147102079
   )
   int field2075;
   @ObfuscatedName("ac")
   boolean field2076;
   @ObfuscatedName("q")
   int[] field2077;
   @ObfuscatedName("t")
   int[] field2078;
   @ObfuscatedName("p")
   int[] field2079;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 664819445
   )
   int field2080;
   @ObfuscatedName("z")
   int[] field2081;
   @ObfuscatedName("l")
   int[] field2082;
   @ObfuscatedName("u")
   int[] field2083;
   @ObfuscatedName("g")
   int[] field2084;
   @ObfuscatedName("r")
   int[] field2085;
   @ObfuscatedName("x")
   int[] field2086;
   @ObfuscatedName("d")
   XHashTable field2087;
   @ObfuscatedName("b")
   int[] field2088;
   @ObfuscatedName("f")
   int[] field2089;
   @ObfuscatedName("o")
   int[] field2090;
   @ObfuscatedName("m")
   int[] field2091;
   @ObfuscatedName("y")
   class161[][] field2092;
   @ObfuscatedName("am")
   class161[][] field2093;
   @ObfuscatedName("h")
   int[] field2094;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1325400723
   )
   int field2095;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      longValue = 4243518081566754383L
   )
   long field2096;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      longValue = 9031386082638417537L
   )
   long field2098;
   @ObfuscatedName("ax")
   class162 field2099;
   @ObfuscatedName("aj")
   class164 field2100;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 356453369
   )
   int field2101;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1238035242"
   )
   synchronized void method2911() {
      for(class163 var1 = (class163)this.field2087.method2776(); var1 != null; var1 = (class163)this.field2087.method2777()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LTrack1;ZI)V",
      garbageValue = "1485147262"
   )
   public synchronized void method2912(Track1 var1, boolean var2) {
      this.method2939();
      this.field2099.method3055(var1.field2162);
      this.field2076 = var2;
      this.field2096 = 0L;
      int var3 = this.field2099.method3031();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2099.method3033(var4);
         this.field2099.method3036(var4);
         this.field2099.method3034(var4);
      }

      this.field2101 = this.field2099.method3049();
      this.field2075 = this.field2099.field2136[this.field2101];
      this.field2098 = this.field2099.method3040(this.field2075);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1537884390"
   )
   public synchronized boolean method2913() {
      return this.field2099.method3051();
   }

   public class160() {
      this.field2095 = 256;
      this.field2080 = 1000000;
      this.field2077 = new int[16];
      this.field2078 = new int[16];
      this.field2079 = new int[16];
      this.field2083 = new int[16];
      this.field2081 = new int[16];
      this.field2082 = new int[16];
      this.field2074 = new int[16];
      this.field2084 = new int[16];
      this.field2085 = new int[16];
      this.field2086 = new int[16];
      this.field2094 = new int[16];
      this.field2088 = new int[16];
      this.field2089 = new int[16];
      this.field2090 = new int[16];
      this.field2091 = new int[16];
      this.field2092 = new class161[16][128];
      this.field2093 = new class161[16][128];
      this.field2099 = new class162();
      this.field2100 = new class164(this);
      this.field2087 = new XHashTable(128);
      this.method2926();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1303836202"
   )
   public synchronized void method2914(int var1, int var2) {
      this.method2915(var1, var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-851890487"
   )
   void method2915(int var1, int var2) {
      this.field2083[var1] = var2;
      this.field2082[var1] = var2 & -128;
      this.method2916(var1, var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1134669906"
   )
   void method2916(int var1, int var2) {
      if(this.field2081[var1] != var2) {
         this.field2081[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2093[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-946461810"
   )
   void method2917(int var1, int var2, int var3) {
      this.method2919(var1, var2, 64);
      if((this.field2086[var1] & 2) != 0) {
         for(class161 var4 = (class161)this.field2100.field2152.method2829(); var4 != null; var4 = (class161)this.field2100.field2152.method2831()) {
            if(var4.field2123 == var1 && var4.field2119 < 0) {
               this.field2092[var1][var4.field2110] = null;
               this.field2092[var1][var2] = var4;
               int var5 = var4.field2106 + (var4.field2114 * var4.field2105 >> 12);
               var4.field2106 += var2 - var4.field2110 << 8;
               var4.field2114 = var5 - var4.field2106;
               var4.field2105 = 4096;
               var4.field2110 = var2;
               return;
            }
         }
      }

      class163 var9 = (class163)this.field2087.method2773((long)this.field2081[var1]);
      if(var9 != null) {
         class55 var8 = var9.field2142[var2];
         if(var8 != null) {
            class161 var6 = new class161();
            var6.field2123 = var1;
            var6.field2109 = var9;
            var6.field2113 = var8;
            var6.field2108 = var9.field2143[var2];
            var6.field2122 = var9.field2146[var2];
            var6.field2110 = var2;
            var6.field2111 = var3 * var3 * var9.field2147 * var9.field2141[var2] + 1024 >> 11;
            var6.field2121 = var9.field2145[var2] & 255;
            var6.field2106 = (var2 << 8) - (var9.field2144[var2] & 32767);
            var6.field2116 = 0;
            var6.field2117 = 0;
            var6.field2118 = 0;
            var6.field2119 = -1;
            var6.field2120 = 0;
            if(this.field2089[var1] == 0) {
               var6.field2112 = class66.method1200(var8, this.method2931(var6), this.method2932(var6), this.method2933(var6));
            } else {
               var6.field2112 = class66.method1200(var8, this.method2931(var6), 0, this.method2933(var6));
               this.method2978(var6, var9.field2144[var2] < 0);
            }

            if(var9.field2144[var2] < 0) {
               var6.field2112.method1281(-1);
            }

            if(var6.field2122 >= 0) {
               class161 var7 = this.field2093[var1][var6.field2122];
               if(var7 != null && var7.field2119 < 0) {
                  this.field2092[var1][var7.field2110] = null;
                  var7.field2119 = 0;
               }

               this.field2093[var1][var6.field2122] = var6;
            }

            this.field2100.field2152.method2824(var6);
            this.field2092[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "289465514"
   )
   void method2919(int var1, int var2, int var3) {
      class161 var4 = this.field2092[var1][var2];
      if(var4 != null) {
         this.field2092[var1][var2] = null;
         if((this.field2086[var1] & 2) != 0) {
            for(class161 var5 = (class161)this.field2100.field2152.method2828(); var5 != null; var5 = (class161)this.field2100.field2152.method2830()) {
               if(var4.field2123 == var5.field2123 && var5.field2119 < 0 && var4 != var5) {
                  var4.field2119 = 0;
                  break;
               }
            }
         } else {
            var4.field2119 = 0;
         }

      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1116141296"
   )
   void method2920(int var1, int var2, int var3) {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "48"
   )
   void method2921(int var1, int var2) {
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "314"
   )
   void method2922(int var1, int var2) {
      this.field2074[var1] = var2;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-71"
   )
   void method2923(int var1) {
      for(class161 var2 = (class161)this.field2100.field2152.method2828(); var2 != null; var2 = (class161)this.field2100.field2152.method2830()) {
         if(var1 < 0 || var1 == var2.field2123) {
            if(var2.field2112 != null) {
               var2.field2112.method1213(class57.field1032 / 100);
               if(var2.field2112.method1259()) {
                  this.field2100.field2161.method935(var2.field2112);
               }

               var2.method3024();
            }

            if(var2.field2119 < 0) {
               this.field2092[var2.field2123][var2.field2110] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   void method2925(int var1) {
      for(class161 var2 = (class161)this.field2100.field2152.method2828(); var2 != null; var2 = (class161)this.field2100.field2152.method2830()) {
         if((var1 < 0 || var1 == var2.field2123) && var2.field2119 < 0) {
            this.field2092[var2.field2123][var2.field2110] = null;
            var2.field2119 = 0;
         }
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-342690141"
   )
   void method2926() {
      this.method2923(-1);
      this.method3012(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2081[var1] = this.field2083[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2082[var1] = this.field2083[var1] & -128;
      }

   }

   @ObfuscatedName("r")
   protected synchronized void vmethod3093(int[] var1, int var2, int var3) {
      if(this.field2099.method3051()) {
         int var4 = this.field2099.field2131 * this.field2080 / class57.field1032;

         do {
            long var5 = (long)var3 * (long)var4 + this.field2096;
            if(this.field2098 - var5 >= 0L) {
               this.field2096 = var5;
               break;
            }

            int var7 = (int)((this.field2098 - this.field2096 + (long)var4 - 1L) / (long)var4);
            this.field2096 += (long)var4 * (long)var7;
            this.field2100.vmethod3093(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method2984();
         } while(this.field2099.method3051());
      }

      this.field2100.vmethod3093(var1, var2, var3);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-13"
   )
   void method2928(int var1) {
      if((this.field2086[var1] & 4) != 0) {
         for(class161 var2 = (class161)this.field2100.field2152.method2828(); var2 != null; var2 = (class161)this.field2100.field2152.method2830()) {
            if(var1 == var2.field2123) {
               var2.field2125 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "11"
   )
   void method2929(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method2919(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method2917(var3, var4, var5);
         } else {
            this.method2919(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method2920(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2082[var3] = (var5 << 14) + (this.field2082[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2082[var3] = (var5 << 7) + (this.field2082[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2084[var3] = (var5 << 7) + (this.field2084[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2084[var3] = (this.field2084[var3] & -128) + var5;
         }

         if(var4 == 5) {
            this.field2085[var3] = (var5 << 7) + (this.field2085[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2085[var3] = (this.field2085[var3] & -128) + var5;
         }

         if(var4 == 7) {
            this.field2077[var3] = (this.field2077[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 39) {
            this.field2077[var3] = (this.field2077[var3] & -128) + var5;
         }

         if(var4 == 10) {
            this.field2078[var3] = (var5 << 7) + (this.field2078[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2078[var3] = var5 + (this.field2078[var3] & -128);
         }

         if(var4 == 11) {
            this.field2079[var3] = (var5 << 7) + (this.field2079[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2079[var3] = (this.field2079[var3] & -128) + var5;
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2086[var3] |= 1;
            } else {
               this.field2086[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2086[var3] |= 2;
            } else {
               this.method3018(var3);
               this.field2086[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2094[var3] = (this.field2094[var3] & 127) + (var5 << 7);
         }

         if(var4 == 98) {
            this.field2094[var3] = (this.field2094[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2094[var3] = (var5 << 7) + (this.field2094[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field2094[var3] = (this.field2094[var3] & 16256) + 16384 + var5;
         }

         if(var4 == 120) {
            this.method2923(var3);
         }

         if(var4 == 121) {
            this.method3012(var3);
         }

         if(var4 == 123) {
            this.method2925(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2094[var3];
            if(var6 == 16384) {
               this.field2088[var3] = (this.field2088[var3] & -16257) + (var5 << 7);
            }
         }

         if(var4 == 38) {
            var6 = this.field2094[var3];
            if(var6 == 16384) {
               this.field2088[var3] = var5 + (this.field2088[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2089[var3] = (var5 << 7) + (this.field2089[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2089[var3] = var5 + (this.field2089[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2086[var3] |= 4;
            } else {
               this.method2928(var3);
               this.field2086[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method2974(var3, (this.field2090[var3] & -16257) + (var5 << 7));
         }

         if(var4 == 49) {
            this.method2974(var3, var5 + (this.field2090[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method2916(var3, var4 + this.field2082[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method2921(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 9 & 16256) + (var1 >> 8 & 127);
         this.method2922(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method2926();
         }
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Lclass161;B)I",
      garbageValue = "2"
   )
   int method2931(class161 var1) {
      int var2 = var1.field2106 + (var1.field2114 * var1.field2105 >> 12);
      var2 += this.field2088[var1.field2123] * (this.field2074[var1.field2123] - 8192) >> 12;
      class158 var3 = var1.field2108;
      int var4;
      if(var3.field2059 > 0 && (var3.field2053 > 0 || this.field2084[var1.field2123] > 0)) {
         var4 = var3.field2053 << 2;
         int var5 = var3.field2060 << 1;
         if(var1.field2115 < var5) {
            var4 = var1.field2115 * var4 / var5;
         }

         var4 += this.field2084[var1.field2123] >> 7;
         double var6 = Math.sin((double)(var1.field2107 & 511) * 0.01227184630308513D);
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(var1.field2113.field1011 * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)class57.field1032 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Lclass161;I)I",
      garbageValue = "21850793"
   )
   int method2932(class161 var1) {
      class158 var2 = var1.field2108;
      int var3 = this.field2079[var1.field2123] * this.field2077[var1.field2123] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2111 + 16384 >> 15;
      var3 = var3 * this.field2095 + 128 >> 8;
      if(var2.field2054 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var1.field2116 * 1.953125E-5D * (double)var2.field2054) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2058 != null) {
         var4 = var1.field2117;
         var5 = var2.field2058[var1.field2118 + 1];
         if(var1.field2118 < var2.field2058.length - 2) {
            var6 = (var2.field2058[var1.field2118] & 255) << 8;
            var7 = (var2.field2058[var1.field2118 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2058[var1.field2118 + 3] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      if(var1.field2119 > 0 && var2.field2056 != null) {
         var4 = var1.field2119;
         var5 = var2.field2056[var1.field2120 + 1];
         if(var1.field2120 < var2.field2056.length - 2) {
            var6 = (var2.field2056[var1.field2120] & 255) << 8;
            var7 = (var2.field2056[var1.field2120 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2056[var1.field2120 + 3] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lclass161;I)I",
      garbageValue = "1383711146"
   )
   int method2933(class161 var1) {
      int var2 = this.field2078[var1.field2123];
      return var2 < 8192?var2 * var1.field2121 + 32 >> 6:16384 - ((128 - var1.field2121) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("p")
   protected synchronized class68 vmethod3102() {
      return this.field2100;
   }

   @ObfuscatedName("w")
   protected synchronized int vmethod3097() {
      return 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "124727684"
   )
   public synchronized void method2939() {
      this.field2099.method3069();
      this.method2926();
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(Lclass161;I)Z",
      garbageValue = "510320126"
   )
   boolean method2940(class161 var1) {
      if(var1.field2112 == null) {
         if(var1.field2119 >= 0) {
            var1.unlink();
            if(var1.field2122 > 0 && this.field2093[var1.field2123][var1.field2122] == var1) {
               this.field2093[var1.field2123][var1.field2122] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(Lclass161;[IIII)Z",
      garbageValue = "-1055785875"
   )
   boolean method2941(class161 var1, int[] var2, int var3, int var4) {
      var1.field2124 = class57.field1032 / 100;
      if(var1.field2119 < 0 || var1.field2112 != null && !var1.field2112.method1216()) {
         int var5 = var1.field2105;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field2085[var1.field2123] * 4.921259842519685E-4D) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2105 = var5;
         }

         var1.field2112.method1214(this.method2931(var1));
         class158 var6 = var1.field2108;
         boolean var7 = false;
         ++var1.field2115;
         var1.field2107 += var6.field2059;
         double var8 = (double)((var1.field2110 - 60 << 8) + (var1.field2114 * var1.field2105 >> 12)) * 5.086263020833333E-6D;
         if(var6.field2054 > 0) {
            if(var6.field2061 > 0) {
               var1.field2116 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2061 * var8) + 0.5D);
            } else {
               var1.field2116 += 128;
            }
         }

         if(var6.field2058 != null) {
            if(var6.field2055 > 0) {
               var1.field2117 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2055 * var8) + 0.5D);
            } else {
               var1.field2117 += 128;
            }

            while(var1.field2118 < var6.field2058.length - 2 && var1.field2117 > (var6.field2058[var1.field2118 + 2] & 255) << 8) {
               var1.field2118 += 2;
            }

            if(var1.field2118 == var6.field2058.length - 2 && var6.field2058[var1.field2118 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field2119 >= 0 && var6.field2056 != null && (this.field2086[var1.field2123] & 1) == 0 && (var1.field2122 < 0 || var1 != this.field2093[var1.field2123][var1.field2122])) {
            if(var6.field2062 > 0) {
               var1.field2119 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2062) + 0.5D);
            } else {
               var1.field2119 += 128;
            }

            while(var1.field2120 < var6.field2056.length - 2 && var1.field2119 > (var6.field2056[var1.field2120 + 2] & 255) << 8) {
               var1.field2120 += 2;
            }

            if(var6.field2056.length - 2 == var1.field2120) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2112.method1213(var1.field2124);
            if(var2 != null) {
               var1.field2112.vmethod3093(var2, var3, var4);
            } else {
               var1.field2112.vmethod3094(var4);
            }

            if(var1.field2112.method1259()) {
               this.field2100.field2161.method935(var1.field2112);
            }

            var1.method3024();
            if(var1.field2119 >= 0) {
               var1.unlink();
               if(var1.field2122 > 0 && var1 == this.field2093[var1.field2123][var1.field2122]) {
                  this.field2093[var1.field2123][var1.field2122] = null;
               }
            }

            return true;
         } else {
            var1.field2112.method1251(var1.field2124, this.method2932(var1), this.method2933(var1));
            return false;
         }
      } else {
         var1.method3024();
         var1.unlink();
         if(var1.field2122 > 0 && var1 == this.field2093[var1.field2123][var1.field2122]) {
            this.field2093[var1.field2123][var1.field2122] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("u")
   protected synchronized class68 vmethod3091() {
      return null;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-459187503"
   )
   int method2958() {
      return this.field2095;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1733062423"
   )
   void method2974(int var1, int var2) {
      this.field2090[var1] = var2;
      this.field2091[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "28907"
   )
   public synchronized void method2976() {
      for(class163 var1 = (class163)this.field2087.method2776(); var1 != null; var1 = (class163)this.field2087.method2777()) {
         var1.method3083();
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass161;ZI)V",
      garbageValue = "-836317208"
   )
   void method2978(class161 var1, boolean var2) {
      int var3 = var1.field2113.field1012.length;
      int var4;
      if(var2 && var1.field2113.field1015) {
         int var5 = var3 + var3 - var1.field2113.field1014;
         var4 = (int)((long)this.field2089[var1.field2123] * (long)var5 >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2112.method1209();
         }
      } else {
         var4 = (int)((long)this.field2089[var1.field2123] * (long)var3 >> 6);
      }

      var1.field2112.method1208(var4);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LTrack1;LIndexDataBase;Lclass61;II)Z",
      garbageValue = "1672961475"
   )
   public synchronized boolean method2983(Track1 var1, IndexDataBase var2, class61 var3, int var4) {
      var1.method3119();
      boolean var5 = true;
      Object var6 = null;
      int[] var10 = new int[]{var4};

      for(class155 var7 = (class155)var1.field2163.method2776(); var7 != null; var7 = (class155)var1.field2163.method2777()) {
         int var8 = (int)var7.hash;
         class163 var9 = (class163)this.field2087.method2773((long)var8);
         if(var9 == null) {
            var9 = XItemContainer.method164(var2, var8);
            if(var9 == null) {
               var5 = false;
               continue;
            }

            this.field2087.method2774(var9, (long)var8);
         }

         if(!var9.method3082(var3, var7.field2047, var10)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3120();
      }

      return var5;
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1372382405"
   )
   void method2984() {
      int var1 = this.field2101;
      int var2 = this.field2075;

      long var3;
      for(var3 = this.field2098; this.field2075 == var2; var3 = this.field2099.method3040(var2)) {
         while(this.field2099.field2136[var1] == var2) {
            this.field2099.method3033(var1);
            int var5 = this.field2099.method3037(var1);
            if(var5 == 1) {
               this.field2099.method3035();
               this.field2099.method3034(var1);
               if(this.field2099.method3064()) {
                  if(!this.field2076 || var2 == 0) {
                     this.method2926();
                     this.field2099.method3069();
                     return;
                  }

                  this.field2099.method3043(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method2929(var5);
            }

            this.field2099.method3036(var1);
            this.field2099.method3034(var1);
         }

         var1 = this.field2099.method3049();
         var2 = this.field2099.field2136[var1];
      }

      this.field2101 = var1;
      this.field2075 = var2;
      this.field2098 = var3;
   }

   @ObfuscatedName("k")
   protected synchronized void vmethod3094(int var1) {
      if(this.field2099.method3051()) {
         int var2 = this.field2080 * this.field2099.field2131 / class57.field1032;

         do {
            long var3 = (long)var2 * (long)var1 + this.field2096;
            if(this.field2098 - var3 >= 0L) {
               this.field2096 = var3;
               break;
            }

            int var5 = (int)(((long)var2 + (this.field2098 - this.field2096) - 1L) / (long)var2);
            this.field2096 += (long)var2 * (long)var5;
            this.field2100.vmethod3094(var5);
            var1 -= var5;
            this.method2984();
         } while(this.field2099.method3051());
      }

      this.field2100.vmethod3094(var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-1717"
   )
   public synchronized void method3002(int var1) {
      this.field2095 = var1;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2038245059"
   )
   void method3012(int var1) {
      if(var1 >= 0) {
         this.field2077[var1] = 12800;
         this.field2078[var1] = 8192;
         this.field2079[var1] = 16383;
         this.field2074[var1] = 8192;
         this.field2084[var1] = 0;
         this.field2085[var1] = 8192;
         this.method3018(var1);
         this.method2928(var1);
         this.field2086[var1] = 0;
         this.field2094[var1] = 32767;
         this.field2088[var1] = 256;
         this.field2089[var1] = 0;
         this.method2974(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3012(var1);
         }

      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "44"
   )
   void method3018(int var1) {
      if((this.field2086[var1] & 2) != 0) {
         for(class161 var2 = (class161)this.field2100.field2152.method2828(); var2 != null; var2 = (class161)this.field2100.field2152.method2830()) {
            if(var1 == var2.field2123 && this.field2092[var1][var2.field2110] == null && var2.field2119 < 0) {
               var2.field2119 = 0;
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;I)V",
      garbageValue = "558992378"
   )
   public static void method3021(IndexDataBase var0, IndexDataBase var1) {
      CombatInfo2.field2852 = var0;
      CombatInfo2.field2847 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1416111378"
   )
   static final int method3022(int var0, int var1) {
      int var2 = class65.method1193(var0 - 1, var1 - 1) + class65.method1193(var0 + 1, var1 - 1) + class65.method1193(var0 - 1, var1 + 1) + class65.method1193(var0 + 1, var1 + 1);
      int var3 = class65.method1193(var0 - 1, var1) + class65.method1193(var0 + 1, var1) + class65.method1193(var0, var1 - 1) + class65.method1193(var0, var1 + 1);
      int var4 = class65.method1193(var0, var1);
      return var3 / 8 + var2 / 16 + var4 / 4;
   }
}

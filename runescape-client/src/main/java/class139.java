import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
public class class139 extends class68 {
   @ObfuscatedName("q")
   int[] field1923 = new int[16];
   @ObfuscatedName("bn")
   static ModIcon[] field1924;
   @ObfuscatedName("av")
   class140[][] field1925 = new class140[16][128];
   @ObfuscatedName("ae")
   class143 field1926 = new class143(this);
   @ObfuscatedName("r")
   int[] field1927 = new int[16];
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1229752027
   )
   int field1928;
   @ObfuscatedName("p")
   int[] field1929 = new int[16];
   @ObfuscatedName("g")
   int[] field1930 = new int[16];
   @ObfuscatedName("z")
   int[] field1931 = new int[16];
   @ObfuscatedName("a")
   int[] field1932 = new int[16];
   @ObfuscatedName("c")
   int[] field1933 = new int[16];
   @ObfuscatedName("y")
   int[] field1934 = new int[16];
   @ObfuscatedName("ay")
   boolean field1935;
   @ObfuscatedName("b")
   int[] field1936 = new int[16];
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      longValue = 6646576559097079425L
   )
   long field1937;
   @ObfuscatedName("k")
   int[] field1938 = new int[16];
   @ObfuscatedName("v")
   int[] field1939 = new int[16];
   @ObfuscatedName("u")
   int[] field1940 = new int[16];
   @ObfuscatedName("t")
   class140[][] field1941 = new class140[16][128];
   @ObfuscatedName("h")
   int[] field1942 = new int[16];
   @ObfuscatedName("aw")
   class141 field1943 = new class141();
   @ObfuscatedName("l")
   int[] field1944 = new int[16];
   @ObfuscatedName("j")
   int[] field1945 = new int[16];
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -2096337845
   )
   int field1946;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      longValue = 1611206975598956891L
   )
   long field1947;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1815943187
   )
   int field1948 = 256;
   @ObfuscatedName("n")
   XHashTable field1949 = new XHashTable(128);
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 44649825
   )
   int field1950 = 1000000;
   @ObfuscatedName("ar")
   static class184 field1952;

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Lclass140;B)I",
      garbageValue = "14"
   )
   int method2549(class140 var1) {
      class137 var2 = var1.field1956;
      int var3 = this.field1942[var1.field1953] * this.field1933[var1.field1953] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = 16384 + var3 * var1.field1966 >> 15;
      var3 = 128 + var3 * this.field1948 >> 8;
      if(var2.field1898 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var1.field1964 * 1.953125E-5D * (double)var2.field1898) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(null != var2.field1907) {
         var4 = var1.field1965;
         var5 = var2.field1907[var1.field1963 + 1];
         if(var1.field1963 < var2.field1907.length - 2) {
            var6 = (var2.field1907[var1.field1963] & 255) << 8;
            var7 = (var2.field1907[2 + var1.field1963] & 255) << 8;
            var5 += (var4 - var6) * (var2.field1907[3 + var1.field1963] - var5) / (var7 - var6);
         }

         var3 = 32 + var3 * var5 >> 6;
      }

      if(var1.field1967 > 0 && null != var2.field1899) {
         var4 = var1.field1967;
         var5 = var2.field1899[var1.field1968 + 1];
         if(var1.field1968 < var2.field1899.length - 2) {
            var6 = (var2.field1899[var1.field1968] & 255) << 8;
            var7 = (var2.field1899[2 + var1.field1968] & 255) << 8;
            var5 += (var2.field1899[3 + var1.field1968] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = 32 + var3 * var5 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-338292019"
   )
   public synchronized void method2550(int var1) {
      this.field1948 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2136100077"
   )
   public int method2551() {
      return this.field1948;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass144;Lclass182;Lclass60;II)Z",
      garbageValue = "-1947084831"
   )
   synchronized boolean method2552(class144 var1, class182 var2, class60 var3, int var4) {
      var1.method2779();
      boolean var5 = true;
      Object var6 = null;
      int[] var12 = new int[]{var4};

      for(class134 var7 = (class134)var1.field2017.method2414(); null != var7; var7 = (class134)var1.field2017.method2409()) {
         int var8 = (int)var7.hash;
         class142 var9 = (class142)this.field1949.method2405((long)var8);
         if(null == var9) {
            byte[] var11 = var2.method3334(var8);
            class142 var10;
            if(null == var11) {
               var10 = null;
            } else {
               var10 = new class142(var11);
            }

            var9 = var10;
            if(null == var10) {
               var5 = false;
               continue;
            }

            this.field1949.method2406(var10, (long)var8);
         }

         if(!var9.method2739(var3, var7.field1893, var12)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method2778();
      }

      return var5;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   synchronized void method2553() {
      for(class142 var1 = (class142)this.field1949.method2414(); null != var1; var1 = (class142)this.field1949.method2409()) {
         var1.method2740();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-100"
   )
   public synchronized void method2556() {
      this.field1943.method2688();
      this.method2642();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "810949885"
   )
   public synchronized boolean method2557() {
      return this.field1943.method2689();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1428341224"
   )
   public synchronized void method2558(int var1, int var2) {
      this.method2594(var1, var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-638047065"
   )
   void method2561(int var1, int var2, int var3) {
      this.method2563(var1, var2, 64);
      if((this.field1932[var1] & 2) != 0) {
         for(class140 var4 = (class140)this.field1926.field2013.method2460(); var4 != null; var4 = (class140)this.field1926.field2013.method2462()) {
            if(var4.field1953 == var1 && var4.field1967 < 0) {
               this.field1941[var1][var4.field1958] = null;
               this.field1941[var1][var2] = var4;
               int var8 = (var4.field1962 * var4.field1973 >> 12) + var4.field1961;
               var4.field1961 += var2 - var4.field1958 << 8;
               var4.field1962 = var8 - var4.field1961;
               var4.field1973 = 4096;
               var4.field1958 = var2;
               return;
            }
         }
      }

      class142 var9 = (class142)this.field1949.method2405((long)this.field1930[var1]);
      if(null != var9) {
         class55 var5 = var9.field1993[var2];
         if(var5 != null) {
            class140 var6 = new class140();
            var6.field1953 = var1;
            var6.field1976 = var9;
            var6.field1955 = var5;
            var6.field1956 = var9.field1997[var2];
            var6.field1957 = var9.field1998[var2];
            var6.field1958 = var2;
            var6.field1966 = var9.field1994[var2] * var3 * var3 * var9.field1995 + 1024 >> 11;
            var6.field1960 = var9.field1996[var2] & 255;
            var6.field1961 = (var2 << 8) - (var9.field2004[var2] & 32767);
            var6.field1964 = 0;
            var6.field1965 = 0;
            var6.field1963 = 0;
            var6.field1967 = -1;
            var6.field1968 = 0;
            if(this.field1938[var1] == 0) {
               var6.field1971 = class66.method1220(var5, this.method2665(var6), this.method2549(var6), this.method2577(var6));
            } else {
               var6.field1971 = class66.method1220(var5, this.method2665(var6), 0, this.method2577(var6));
               this.method2562(var6, var9.field2004[var2] < 0);
            }

            if(var9.field2004[var2] < 0) {
               var6.field1971.method1192(-1);
            }

            if(var6.field1957 >= 0) {
               class140 var7 = this.field1925[var1][var6.field1957];
               if(null != var7 && var7.field1967 < 0) {
                  this.field1941[var1][var7.field1958] = null;
                  var7.field1967 = 0;
               }

               this.field1925[var1][var6.field1957] = var6;
            }

            this.field1926.field2013.method2454(var6);
            this.field1941[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass140;ZB)V",
      garbageValue = "-100"
   )
   void method2562(class140 var1, boolean var2) {
      int var3 = var1.field1955.field1014.length;
      int var4;
      if(var2 && var1.field1955.field1017) {
         int var5 = var3 + var3 - var1.field1955.field1013;
         var4 = (int)((long)var5 * (long)this.field1938[var1.field1953] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field1971.method1184();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field1938[var1.field1953] >> 6);
      }

      var1.field1971.method1183(var4);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-421934381"
   )
   void method2563(int var1, int var2, int var3) {
      class140 var4 = this.field1941[var1][var2];
      if(var4 != null) {
         this.field1941[var1][var2] = null;
         if((this.field1932[var1] & 2) != 0) {
            for(class140 var5 = (class140)this.field1926.field2013.method2466(); null != var5; var5 = (class140)this.field1926.field2013.method2461()) {
               if(var4.field1953 == var5.field1953 && var5.field1967 < 0 && var5 != var4) {
                  var4.field1967 = 0;
                  break;
               }
            }
         } else {
            var4.field1967 = 0;
         }

      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "105"
   )
   void method2564(int var1, int var2, int var3) {
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-2"
   )
   void method2565(int var1, int var2) {
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-64772419"
   )
   void method2567(int var1) {
      for(class140 var2 = (class140)this.field1926.field2013.method2466(); null != var2; var2 = (class140)this.field1926.field2013.method2461()) {
         if(var1 < 0 || var2.field1953 == var1) {
            if(null != var2.field1971) {
               var2.field1971.method1188(class57.field1031 / 100);
               if(var2.field1971.method1246()) {
                  this.field1926.field2008.method914(var2.field1971);
               }

               var2.method2681();
            }

            if(var2.field1967 < 0) {
               this.field1941[var2.field1953][var2.field1958] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2072492081"
   )
   void method2568(int var1) {
      if(var1 >= 0) {
         this.field1942[var1] = 12800;
         this.field1927[var1] = 8192;
         this.field1933[var1] = 16383;
         this.field1923[var1] = 8192;
         this.field1944[var1] = 0;
         this.field1934[var1] = 8192;
         this.method2571(var1);
         this.method2572(var1);
         this.field1932[var1] = 0;
         this.field1936[var1] = 32767;
         this.field1945[var1] = 256;
         this.field1938[var1] = 0;
         this.method2610(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method2568(var1);
         }

      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "314488470"
   )
   void method2569(int var1) {
      for(class140 var2 = (class140)this.field1926.field2013.method2466(); var2 != null; var2 = (class140)this.field1926.field2013.method2461()) {
         if((var1 < 0 || var1 == var2.field1953) && var2.field1967 < 0) {
            this.field1941[var2.field1953][var2.field1958] = null;
            var2.field1967 = 0;
         }
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "72"
   )
   void method2570(int var1, int var2) {
      this.field1923[var1] = var2;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   void method2571(int var1) {
      if((this.field1932[var1] & 2) != 0) {
         for(class140 var2 = (class140)this.field1926.field2013.method2466(); null != var2; var2 = (class140)this.field1926.field2013.method2461()) {
            if(var2.field1953 == var1 && this.field1941[var1][var2.field1958] == null && var2.field1967 < 0) {
               var2.field1967 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-705876773"
   )
   void method2572(int var1) {
      if((this.field1932[var1] & 4) != 0) {
         for(class140 var2 = (class140)this.field1926.field2013.method2466(); var2 != null; var2 = (class140)this.field1926.field2013.method2461()) {
            if(var2.field1953 == var1) {
               var2.field1974 = 0;
            }
         }
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "71"
   )
   void method2573(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method2563(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method2561(var3, var4, var5);
         } else {
            this.method2563(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method2564(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field1931[var3] = (this.field1931[var3] & -2080769) + (var5 << 14);
         }

         if(var4 == 32) {
            this.field1931[var3] = (var5 << 7) + (this.field1931[var3] & -16257);
         }

         if(var4 == 1) {
            this.field1944[var3] = (this.field1944[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 33) {
            this.field1944[var3] = var5 + (this.field1944[var3] & -128);
         }

         if(var4 == 5) {
            this.field1934[var3] = (this.field1934[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 37) {
            this.field1934[var3] = var5 + (this.field1934[var3] & -128);
         }

         if(var4 == 7) {
            this.field1942[var3] = (var5 << 7) + (this.field1942[var3] & -16257);
         }

         if(var4 == 39) {
            this.field1942[var3] = var5 + (this.field1942[var3] & -128);
         }

         if(var4 == 10) {
            this.field1927[var3] = (this.field1927[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 42) {
            this.field1927[var3] = (this.field1927[var3] & -128) + var5;
         }

         if(var4 == 11) {
            this.field1933[var3] = (this.field1933[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 43) {
            this.field1933[var3] = var5 + (this.field1933[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field1932[var3] |= 1;
            } else {
               this.field1932[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field1932[var3] |= 2;
            } else {
               this.method2571(var3);
               this.field1932[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field1936[var3] = (var5 << 7) + (this.field1936[var3] & 127);
         }

         if(var4 == 98) {
            this.field1936[var3] = (this.field1936[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field1936[var3] = (var5 << 7) + (this.field1936[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field1936[var3] = (this.field1936[var3] & 16256) + 16384 + var5;
         }

         if(var4 == 120) {
            this.method2567(var3);
         }

         if(var4 == 121) {
            this.method2568(var3);
         }

         if(var4 == 123) {
            this.method2569(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field1936[var3];
            if(var6 == 16384) {
               this.field1945[var3] = (this.field1945[var3] & -16257) + (var5 << 7);
            }
         }

         if(var4 == 38) {
            var6 = this.field1936[var3];
            if(var6 == 16384) {
               this.field1945[var3] = (this.field1945[var3] & -128) + var5;
            }
         }

         if(var4 == 16) {
            this.field1938[var3] = (this.field1938[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 48) {
            this.field1938[var3] = var5 + (this.field1938[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field1932[var3] |= 4;
            } else {
               this.method2572(var3);
               this.field1932[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method2610(var3, (this.field1939[var3] & -16257) + (var5 << 7));
         }

         if(var4 == 49) {
            this.method2610(var3, var5 + (this.field1939[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method2617(var3, var4 + this.field1931[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method2565(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 9 & 16256) + (var1 >> 8 & 127);
         this.method2570(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method2642();
         }
      }
   }

   @ObfuscatedName("q")
   protected synchronized void vmethod2764(int[] var1, int var2, int var3) {
      if(this.field1943.method2689()) {
         int var4 = this.field1950 * this.field1943.field1981 / class57.field1031;

         do {
            long var5 = this.field1947 + (long)var3 * (long)var4;
            if(this.field1937 - var5 >= 0L) {
               this.field1947 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field1937 - this.field1947) - 1L) / (long)var4);
            this.field1947 += (long)var4 * (long)var7;
            this.field1926.vmethod2764(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method2583();
         } while(this.field1943.method2689());
      }

      this.field1926.vmethod2764(var1, var2, var3);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lclass140;B)I",
      garbageValue = "-46"
   )
   int method2577(class140 var1) {
      int var2 = this.field1927[var1.field1953];
      return var2 < 8192?32 + var2 * var1.field1960 >> 6:16384 - (32 + (128 - var1.field1960) * (16384 - var2) >> 6);
   }

   @ObfuscatedName("r")
   protected synchronized class68 vmethod2748() {
      return this.field1926;
   }

   @ObfuscatedName("z")
   protected synchronized int vmethod2751() {
      return 0;
   }

   @ObfuscatedName("y")
   protected synchronized void vmethod2752(int var1) {
      if(this.field1943.method2689()) {
         int var2 = this.field1943.field1981 * this.field1950 / class57.field1031;

         do {
            long var3 = (long)var1 * (long)var2 + this.field1947;
            if(this.field1937 - var3 >= 0L) {
               this.field1947 = var3;
               break;
            }

            int var5 = (int)((this.field1937 - this.field1947 + (long)var2 - 1L) / (long)var2);
            this.field1947 += (long)var5 * (long)var2;
            this.field1926.vmethod2752(var5);
            var1 -= var5;
            this.method2583();
         } while(this.field1943.method2689());
      }

      this.field1926.vmethod2752(var1);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1084953917"
   )
   void method2583() {
      int var1 = this.field1928;
      int var2 = this.field1946;

      long var3;
      for(var3 = this.field1937; var2 == this.field1946; var3 = this.field1943.method2697(var2)) {
         while(var2 == this.field1943.field1982[var1]) {
            this.field1943.method2691(var1);
            int var5 = this.field1943.method2699(var1);
            if(var5 == 1) {
               this.field1943.method2686();
               this.field1943.method2692(var1);
               if(this.field1943.method2731()) {
                  if(!this.field1935 || var2 == 0) {
                     this.method2642();
                     this.field1943.method2688();
                     return;
                  }

                  this.field1943.method2700(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method2573(var5);
            }

            this.field1943.method2724(var1);
            this.field1943.method2692(var1);
         }

         var1 = this.field1943.method2698();
         var2 = this.field1943.field1982[var1];
      }

      this.field1928 = var1;
      this.field1946 = var2;
      this.field1937 = var3;
   }

   public class139() {
      this.method2642();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1713220498"
   )
   public synchronized void method2587() {
      for(class142 var1 = (class142)this.field1949.method2414(); null != var1; var1 = (class142)this.field1949.method2409()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2017674580"
   )
   void method2594(int var1, int var2) {
      this.field1929[var1] = var2;
      this.field1931[var1] = var2 & -128;
      this.method2617(var1, var2);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass144;ZI)V",
      garbageValue = "-1111578873"
   )
   synchronized void method2601(class144 var1, boolean var2) {
      this.method2556();
      this.field1943.method2687(var1.field2018);
      this.field1935 = var2;
      this.field1947 = 0L;
      int var3 = this.field1943.method2690();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field1943.method2691(var4);
         this.field1943.method2724(var4);
         this.field1943.method2692(var4);
      }

      this.field1928 = this.field1943.method2698();
      this.field1946 = this.field1943.field1982[this.field1928];
      this.field1937 = this.field1943.method2697(this.field1946);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Lclass140;S)Z",
      garbageValue = "500"
   )
   boolean method2602(class140 var1) {
      if(null == var1.field1971) {
         if(var1.field1967 >= 0) {
            var1.unlink();
            if(var1.field1957 > 0 && this.field1925[var1.field1953][var1.field1957] == var1) {
               this.field1925[var1.field1953][var1.field1957] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-63"
   )
   void method2610(int var1, int var2) {
      this.field1939[var1] = var2;
      this.field1940[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Lclass140;[IIII)Z",
      garbageValue = "859077809"
   )
   boolean method2613(class140 var1, int[] var2, int var3, int var4) {
      var1.field1959 = class57.field1031 / 100;
      if(var1.field1967 < 0 || var1.field1971 != null && !var1.field1971.method1235()) {
         int var5 = var1.field1973;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field1934[var1.field1953]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field1973 = var5;
         }

         var1.field1971.method1189(this.method2665(var1));
         class137 var6 = var1.field1956;
         boolean var7 = false;
         ++var1.field1969;
         var1.field1970 += var6.field1905;
         double var8 = 5.086263020833333E-6D * (double)((var1.field1973 * var1.field1962 >> 12) + (var1.field1958 - 60 << 8));
         if(var6.field1898 > 0) {
            if(var6.field1900 > 0) {
               var1.field1964 += (int)(128.0D * Math.pow(2.0D, (double)var6.field1900 * var8) + 0.5D);
            } else {
               var1.field1964 += 128;
            }
         }

         if(null != var6.field1907) {
            if(var6.field1901 > 0) {
               var1.field1965 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field1901) + 0.5D);
            } else {
               var1.field1965 += 128;
            }

            while(var1.field1963 < var6.field1907.length - 2 && var1.field1965 > (var6.field1907[var1.field1963 + 2] & 255) << 8) {
               var1.field1963 += 2;
            }

            if(var1.field1963 == var6.field1907.length - 2 && var6.field1907[1 + var1.field1963] == 0) {
               var7 = true;
            }
         }

         if(var1.field1967 >= 0 && var6.field1899 != null && (this.field1932[var1.field1953] & 1) == 0 && (var1.field1957 < 0 || var1 != this.field1925[var1.field1953][var1.field1957])) {
            if(var6.field1902 > 0) {
               var1.field1967 += (int)(128.0D * Math.pow(2.0D, (double)var6.field1902 * var8) + 0.5D);
            } else {
               var1.field1967 += 128;
            }

            while(var1.field1968 < var6.field1899.length - 2 && var1.field1967 > (var6.field1899[2 + var1.field1968] & 255) << 8) {
               var1.field1968 += 2;
            }

            if(var1.field1968 == var6.field1899.length - 2) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field1971.method1188(var1.field1959);
            if(null != var2) {
               var1.field1971.vmethod2764(var2, var3, var4);
            } else {
               var1.field1971.vmethod2752(var4);
            }

            if(var1.field1971.method1246()) {
               this.field1926.field2008.method914(var1.field1971);
            }

            var1.method2681();
            if(var1.field1967 >= 0) {
               var1.unlink();
               if(var1.field1957 > 0 && var1 == this.field1925[var1.field1953][var1.field1957]) {
                  this.field1925[var1.field1953][var1.field1957] = null;
               }
            }

            return true;
         } else {
            var1.field1971.method1187(var1.field1959, this.method2549(var1), this.method2577(var1));
            return false;
         }
      } else {
         var1.method2681();
         var1.unlink();
         if(var1.field1957 > 0 && var1 == this.field1925[var1.field1953][var1.field1957]) {
            this.field1925[var1.field1953][var1.field1957] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "14"
   )
   void method2617(int var1, int var2) {
      if(var2 != this.field1930[var1]) {
         this.field1930[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field1925[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-1735"
   )
   void method2642() {
      this.method2567(-1);
      this.method2568(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field1930[var1] = this.field1929[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field1931[var1] = this.field1929[var1] & -128;
      }

   }

   @ObfuscatedName("c")
   protected synchronized class68 vmethod2750() {
      return null;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)I",
      garbageValue = "-1387850724"
   )
   int method2665(class140 var1) {
      int var2 = (var1.field1973 * var1.field1962 >> 12) + var1.field1961;
      var2 += (this.field1923[var1.field1953] - 8192) * this.field1945[var1.field1953] >> 12;
      class137 var3 = var1.field1956;
      int var4;
      if(var3.field1905 > 0 && (var3.field1904 > 0 || this.field1944[var1.field1953] > 0)) {
         var4 = var3.field1904 << 2;
         int var5 = var3.field1906 << 1;
         if(var1.field1969 < var5) {
            var4 = var1.field1969 * var4 / var5;
         }

         var4 += this.field1944[var1.field1953] >> 7;
         double var6 = Math.sin((double)(var1.field1970 & 511) * 0.01227184630308513D);
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(256 * var1.field1955.field1015) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)class57.field1031 + 0.5D);
      return var4 < 1?1:var4;
   }
}

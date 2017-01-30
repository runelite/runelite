import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
public class class139 extends class68 {
   @ObfuscatedName("d")
   int[] field1927 = new int[16];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2102793481
   )
   int field1928 = 256;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1866219649
   )
   int field1929 = 1000000;
   @ObfuscatedName("q")
   int[] field1930 = new int[16];
   @ObfuscatedName("o")
   int[] field1931 = new int[16];
   @ObfuscatedName("k")
   int[] field1932 = new int[16];
   @ObfuscatedName("t")
   int[] field1933 = new int[16];
   @ObfuscatedName("s")
   int[] field1934 = new int[16];
   @ObfuscatedName("j")
   int[] field1935 = new int[16];
   @ObfuscatedName("dt")
   static byte[][] field1936;
   @ObfuscatedName("a")
   int[] field1937 = new int[16];
   @ObfuscatedName("m")
   int[] field1938 = new int[16];
   @ObfuscatedName("c")
   int[] field1939 = new int[16];
   @ObfuscatedName("y")
   int[] field1940 = new int[16];
   @ObfuscatedName("v")
   int[] field1941 = new int[16];
   @ObfuscatedName("p")
   XHashTable field1942 = new XHashTable(128);
   @ObfuscatedName("l")
   int[] field1943 = new int[16];
   @ObfuscatedName("f")
   int[] field1944 = new int[16];
   @ObfuscatedName("e")
   class140[][] field1946 = new class140[16][128];
   @ObfuscatedName("ai")
   class140[][] field1947 = new class140[16][128];
   @ObfuscatedName("am")
   class141 field1948 = new class141();
   @ObfuscatedName("ad")
   boolean field1949;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 416544483
   )
   int field1950;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1545984985
   )
   int field1951;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      longValue = 6784916574756693067L
   )
   long field1952;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      longValue = -5665659052765373391L
   )
   long field1953;
   @ObfuscatedName("ar")
   class143 field1954 = new class143(this);
   @ObfuscatedName("b")
   int[] field1955 = new int[16];

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1256463213"
   )
   public synchronized void method2507(int var1) {
      this.field1928 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "598736322"
   )
   void method2508(int var1, int var2) {
      this.field1937[var1] = var2;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "26"
   )
   void method2509() {
      this.method2532(-1);
      this.method2525(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field1934[var1] = this.field1935[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field1931[var1] = this.field1935[var1] & -128;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-11349"
   )
   public synchronized void method2511() {
      for(class142 var1 = (class142)this.field1942.method2361(); var1 != null; var1 = (class142)this.field1942.method2369()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass144;ZB)V",
      garbageValue = "94"
   )
   synchronized void method2512(class144 var1, boolean var2) {
      this.method2513();
      this.field1948.method2670(var1.field2013);
      this.field1949 = var2;
      this.field1952 = 0L;
      int var3 = this.field1948.method2646();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field1948.method2647(var4);
         this.field1948.method2650(var4);
         this.field1948.method2648(var4);
      }

      this.field1950 = this.field1948.method2655();
      this.field1951 = this.field1948.field1986[this.field1950];
      this.field1953 = this.field1948.method2654(this.field1951);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-770942537"
   )
   public synchronized void method2513() {
      this.field1948.method2644();
      this.method2509();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-90"
   )
   public synchronized void method2515(int var1, int var2) {
      this.method2516(var1, var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "89"
   )
   void method2516(int var1, int var2) {
      this.field1935[var1] = var2;
      this.field1931[var1] = var2 & -128;
      this.method2517(var1, var2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-756249737"
   )
   void method2517(int var1, int var2) {
      if(var2 != this.field1934[var1]) {
         this.field1934[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field1947[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-2098357986"
   )
   void method2518(int var1, int var2, int var3) {
      this.method2520(var1, var2, 64);
      if((this.field1940[var1] & 2) != 0) {
         for(class140 var4 = (class140)this.field1954.field2006.method2413(); var4 != null; var4 = (class140)this.field1954.field2006.method2415()) {
            if(var1 == var4.field1976 && var4.field1971 < 0) {
               this.field1946[var1][var4.field1969] = null;
               this.field1946[var1][var2] = var4;
               int var5 = (var4.field1964 * var4.field1960 >> 12) + var4.field1957;
               var4.field1957 += var2 - var4.field1969 << 8;
               var4.field1964 = var5 - var4.field1957;
               var4.field1960 = 4096;
               var4.field1969 = var2;
               return;
            }
         }
      }

      class142 var9 = (class142)this.field1942.method2374((long)this.field1934[var1]);
      if(var9 != null) {
         class55 var8 = var9.field1999[var2];
         if(var8 != null) {
            class140 var6 = new class140();
            var6.field1976 = var1;
            var6.field1965 = var9;
            var6.field1968 = var8;
            var6.field1959 = var9.field2001[var2];
            var6.field1961 = var9.field2002[var2];
            var6.field1969 = var2;
            var6.field1963 = 1024 + var9.field1997[var2] * var9.field2003 * var3 * var3 >> 11;
            var6.field1981 = var9.field1996[var2] & 255;
            var6.field1957 = (var2 << 8) - (var9.field1998[var2] & 32767);
            var6.field1967 = 0;
            var6.field1958 = 0;
            var6.field1970 = 0;
            var6.field1971 = -1;
            var6.field1972 = 0;
            if(this.field1943[var1] == 0) {
               var6.field1975 = class66.method1160(var8, this.method2606(var6), this.method2583(var6), this.method2534(var6));
            } else {
               var6.field1975 = class66.method1160(var8, this.method2606(var6), 0, this.method2534(var6));
               this.method2611(var6, var9.field1998[var2] < 0);
            }

            if(var9.field1998[var2] < 0) {
               var6.field1975.method1162(-1);
            }

            if(var6.field1961 >= 0) {
               class140 var7 = this.field1947[var1][var6.field1961];
               if(null != var7 && var7.field1971 < 0) {
                  this.field1946[var1][var7.field1969] = null;
                  var7.field1971 = 0;
               }

               this.field1947[var1][var6.field1961] = var6;
            }

            this.field1954.field2006.method2407(var6);
            this.field1946[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-94"
   )
   void method2520(int var1, int var2, int var3) {
      class140 var4 = this.field1946[var1][var2];
      if(null != var4) {
         this.field1946[var1][var2] = null;
         if((this.field1940[var1] & 2) != 0) {
            for(class140 var5 = (class140)this.field1954.field2006.method2412(); null != var5; var5 = (class140)this.field1954.field2006.method2426()) {
               if(var5.field1976 == var4.field1976 && var5.field1971 < 0 && var5 != var4) {
                  var4.field1971 = 0;
                  break;
               }
            }
         } else {
            var4.field1971 = 0;
         }

      }
   }

   @ObfuscatedName("o")
   protected synchronized void vmethod2704(int[] var1, int var2, int var3) {
      if(this.field1948.method2645()) {
         int var4 = this.field1929 * this.field1948.field1983 / class57.field1047;

         do {
            long var5 = this.field1952 + (long)var3 * (long)var4;
            if(this.field1953 - var5 >= 0L) {
               this.field1952 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field1953 - this.field1952) - 1L) / (long)var4);
            this.field1952 += (long)var4 * (long)var7;
            this.field1954.vmethod2704(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method2540();
         } while(this.field1948.method2645());
      }

      this.field1954.vmethod2704(var1, var2, var3);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-34"
   )
   void method2525(int var1) {
      if(var1 >= 0) {
         this.field1930[var1] = 12800;
         this.field1927[var1] = 8192;
         this.field1932[var1] = 16383;
         this.field1937[var1] = 8192;
         this.field1939[var1] = 0;
         this.field1938[var1] = 8192;
         this.method2528(var1);
         this.method2567(var1);
         this.field1940[var1] = 0;
         this.field1941[var1] = 32767;
         this.field1944[var1] = 256;
         this.field1943[var1] = 0;
         this.method2531(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method2525(var1);
         }

      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-517415260"
   )
   void method2526(int var1) {
      for(class140 var2 = (class140)this.field1954.field2006.method2412(); var2 != null; var2 = (class140)this.field1954.field2006.method2426()) {
         if((var1 < 0 || var2.field1976 == var1) && var2.field1971 < 0) {
            this.field1946[var2.field1976][var2.field1969] = null;
            var2.field1971 = 0;
         }
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "604600963"
   )
   void method2528(int var1) {
      if((this.field1940[var1] & 2) != 0) {
         for(class140 var2 = (class140)this.field1954.field2006.method2412(); var2 != null; var2 = (class140)this.field1954.field2006.method2426()) {
            if(var2.field1976 == var1 && this.field1946[var1][var2.field1969] == null && var2.field1971 < 0) {
               var2.field1971 = 0;
            }
         }
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1481156561"
   )
   void method2530(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method2520(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method2518(var3, var4, var5);
         } else {
            this.method2520(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method2537(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field1931[var3] = (this.field1931[var3] & -2080769) + (var5 << 14);
         }

         if(var4 == 32) {
            this.field1931[var3] = (this.field1931[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 1) {
            this.field1939[var3] = (this.field1939[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 33) {
            this.field1939[var3] = (this.field1939[var3] & -128) + var5;
         }

         if(var4 == 5) {
            this.field1938[var3] = (this.field1938[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 37) {
            this.field1938[var3] = var5 + (this.field1938[var3] & -128);
         }

         if(var4 == 7) {
            this.field1930[var3] = (this.field1930[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 39) {
            this.field1930[var3] = (this.field1930[var3] & -128) + var5;
         }

         if(var4 == 10) {
            this.field1927[var3] = (this.field1927[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 42) {
            this.field1927[var3] = (this.field1927[var3] & -128) + var5;
         }

         if(var4 == 11) {
            this.field1932[var3] = (this.field1932[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 43) {
            this.field1932[var3] = (this.field1932[var3] & -128) + var5;
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field1940[var3] |= 1;
            } else {
               this.field1940[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field1940[var3] |= 2;
            } else {
               this.method2528(var3);
               this.field1940[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field1941[var3] = (var5 << 7) + (this.field1941[var3] & 127);
         }

         if(var4 == 98) {
            this.field1941[var3] = var5 + (this.field1941[var3] & 16256);
         }

         if(var4 == 101) {
            this.field1941[var3] = (var5 << 7) + (this.field1941[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field1941[var3] = 16384 + (this.field1941[var3] & 16256) + var5;
         }

         if(var4 == 120) {
            this.method2532(var3);
         }

         if(var4 == 121) {
            this.method2525(var3);
         }

         if(var4 == 123) {
            this.method2526(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field1941[var3];
            if(var6 == 16384) {
               this.field1944[var3] = (this.field1944[var3] & -16257) + (var5 << 7);
            }
         }

         if(var4 == 38) {
            var6 = this.field1941[var3];
            if(var6 == 16384) {
               this.field1944[var3] = (this.field1944[var3] & -128) + var5;
            }
         }

         if(var4 == 16) {
            this.field1943[var3] = (var5 << 7) + (this.field1943[var3] & -16257);
         }

         if(var4 == 48) {
            this.field1943[var3] = (this.field1943[var3] & -128) + var5;
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field1940[var3] |= 4;
            } else {
               this.method2567(var3);
               this.field1940[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method2531(var3, (this.field1933[var3] & -16257) + (var5 << 7));
         }

         if(var4 == 49) {
            this.method2531(var3, var5 + (this.field1933[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method2517(var3, this.field1931[var3] + var4);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method2617(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method2508(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method2509();
         }
      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "79738612"
   )
   void method2531(int var1, int var2) {
      this.field1933[var1] = var2;
      this.field1955[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1968095398"
   )
   void method2532(int var1) {
      for(class140 var2 = (class140)this.field1954.field2006.method2412(); var2 != null; var2 = (class140)this.field1954.field2006.method2426()) {
         if(var1 < 0 || var2.field1976 == var1) {
            if(null != var2.field1975) {
               var2.field1975.method1173(class57.field1047 / 100);
               if(var2.field1975.method1177()) {
                  this.field1954.field2008.method898(var2.field1975);
               }

               var2.method2637();
            }

            if(var2.field1971 < 0) {
               this.field1946[var2.field1976][var2.field1969] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(Lclass140;B)I",
      garbageValue = "91"
   )
   int method2534(class140 var1) {
      int var2 = this.field1927[var1.field1976];
      return var2 < 8192?var1.field1981 * var2 + 32 >> 6:16384 - ((16384 - var2) * (128 - var1.field1981) + 32 >> 6);
   }

   @ObfuscatedName("k")
   protected synchronized class68 vmethod2701() {
      return this.field1954;
   }

   @ObfuscatedName("j")
   protected synchronized class68 vmethod2702() {
      return null;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1664540807"
   )
   void method2537(int var1, int var2, int var3) {
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-516108428"
   )
   void method2540() {
      int var1 = this.field1950;
      int var2 = this.field1951;

      long var3;
      for(var3 = this.field1953; this.field1951 == var2; var3 = this.field1948.method2654(var2)) {
         while(var2 == this.field1948.field1986[var1]) {
            this.field1948.method2647(var1);
            int var5 = this.field1948.method2651(var1);
            if(var5 == 1) {
               this.field1948.method2649();
               this.field1948.method2648(var1);
               if(this.field1948.method2683()) {
                  if(!this.field1949 || var2 == 0) {
                     this.method2509();
                     this.field1948.method2644();
                     return;
                  }

                  this.field1948.method2657(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method2530(var5);
            }

            this.field1948.method2650(var1);
            this.field1948.method2648(var1);
         }

         var1 = this.field1948.method2655();
         var2 = this.field1948.field1986[var1];
      }

      this.field1950 = var1;
      this.field1951 = var2;
      this.field1953 = var3;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)Z",
      garbageValue = "-1925424871"
   )
   boolean method2541(class140 var1) {
      if(var1.field1975 == null) {
         if(var1.field1971 >= 0) {
            var1.unlink();
            if(var1.field1961 > 0 && this.field1947[var1.field1976][var1.field1961] == var1) {
               this.field1947[var1.field1976][var1.field1961] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(Lclass140;[IIII)Z",
      garbageValue = "-459684664"
   )
   boolean method2542(class140 var1, int[] var2, int var3, int var4) {
      var1.field1966 = class57.field1047 / 100;
      if(var1.field1971 < 0 || var1.field1975 != null && !var1.field1975.method1176()) {
         int var5 = var1.field1960;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field1938[var1.field1976] * 4.921259842519685E-4D) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field1960 = var5;
         }

         var1.field1975.method1174(this.method2606(var1));
         class137 var6 = var1.field1959;
         boolean var7 = false;
         ++var1.field1973;
         var1.field1974 += var6.field1910;
         double var8 = 5.086263020833333E-6D * (double)((var1.field1960 * var1.field1964 >> 12) + (var1.field1969 - 60 << 8));
         if(var6.field1912 > 0) {
            if(var6.field1905 > 0) {
               var1.field1967 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field1905) + 0.5D);
            } else {
               var1.field1967 += 128;
            }
         }

         if(var6.field1908 != null) {
            if(var6.field1906 > 0) {
               var1.field1958 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field1906) + 0.5D);
            } else {
               var1.field1958 += 128;
            }

            while(var1.field1970 < var6.field1908.length - 2 && var1.field1958 > (var6.field1908[var1.field1970 + 2] & 255) << 8) {
               var1.field1970 += 2;
            }

            if(var1.field1970 == var6.field1908.length - 2 && var6.field1908[1 + var1.field1970] == 0) {
               var7 = true;
            }
         }

         if(var1.field1971 >= 0 && var6.field1904 != null && (this.field1940[var1.field1976] & 1) == 0 && (var1.field1961 < 0 || this.field1947[var1.field1976][var1.field1961] != var1)) {
            if(var6.field1907 > 0) {
               var1.field1971 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field1907) + 0.5D);
            } else {
               var1.field1971 += 128;
            }

            while(var1.field1972 < var6.field1904.length - 2 && var1.field1971 > (var6.field1904[2 + var1.field1972] & 255) << 8) {
               var1.field1972 += 2;
            }

            if(var1.field1972 == var6.field1904.length - 2) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field1975.method1173(var1.field1966);
            if(var2 != null) {
               var1.field1975.vmethod2704(var2, var3, var4);
            } else {
               var1.field1975.vmethod2705(var4);
            }

            if(var1.field1975.method1177()) {
               this.field1954.field2008.method898(var1.field1975);
            }

            var1.method2637();
            if(var1.field1971 >= 0) {
               var1.unlink();
               if(var1.field1961 > 0 && this.field1947[var1.field1976][var1.field1961] == var1) {
                  this.field1947[var1.field1976][var1.field1961] = null;
               }
            }

            return true;
         } else {
            var1.field1975.method1295(var1.field1966, this.method2583(var1), this.method2534(var1));
            return false;
         }
      } else {
         var1.method2637();
         var1.unlink();
         if(var1.field1961 > 0 && this.field1947[var1.field1976][var1.field1961] == var1) {
            this.field1947[var1.field1976][var1.field1961] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1782966212"
   )
   public int method2548() {
      return this.field1928;
   }

   @ObfuscatedName("c")
   protected synchronized void vmethod2705(int var1) {
      if(this.field1948.method2645()) {
         int var2 = this.field1948.field1983 * this.field1929 / class57.field1047;

         do {
            long var3 = (long)var1 * (long)var2 + this.field1952;
            if(this.field1953 - var3 >= 0L) {
               this.field1952 = var3;
               break;
            }

            int var5 = (int)((this.field1953 - this.field1952 + (long)var2 - 1L) / (long)var2);
            this.field1952 += (long)var2 * (long)var5;
            this.field1954.vmethod2705(var5);
            var1 -= var5;
            this.method2540();
         } while(this.field1948.method2645());
      }

      this.field1954.vmethod2705(var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)J",
      garbageValue = "2054704114"
   )
   static long method2565(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if(var5 >= 65 && var5 <= 90) {
            var1 += (long)(1 + var5 - 65);
         } else if(var5 >= 97 && var5 <= 122) {
            var1 += (long)(var5 + 1 - 97);
         } else if(var5 >= 48 && var5 <= 57) {
            var1 += (long)(var5 + 27 - 48);
         }

         if(var1 >= 177917621779460413L) {
            break;
         }
      }

      while(var1 % 37L == 0L && 0L != var1) {
         var1 /= 37L;
      }

      return var1;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-28"
   )
   void method2567(int var1) {
      if((this.field1940[var1] & 4) != 0) {
         for(class140 var2 = (class140)this.field1954.field2006.method2412(); null != var2; var2 = (class140)this.field1954.field2006.method2426()) {
            if(var2.field1976 == var1) {
               var2.field1977 = 0;
            }
         }
      }

   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)I",
      garbageValue = "-980890776"
   )
   int method2583(class140 var1) {
      class137 var2 = var1.field1959;
      int var3 = 4096 + this.field1930[var1.field1976] * this.field1932[var1.field1976] >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = 16384 + var3 * var1.field1963 >> 15;
      var3 = var3 * this.field1928 + 128 >> 8;
      if(var2.field1912 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field1912 * (double)var1.field1967 * 1.953125E-5D) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field1908 != null) {
         var4 = var1.field1958;
         var5 = var2.field1908[1 + var1.field1970];
         if(var1.field1970 < var2.field1908.length - 2) {
            var6 = (var2.field1908[var1.field1970] & 255) << 8;
            var7 = (var2.field1908[2 + var1.field1970] & 255) << 8;
            var5 += (var2.field1908[3 + var1.field1970] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = 32 + var5 * var3 >> 6;
      }

      if(var1.field1971 > 0 && null != var2.field1904) {
         var4 = var1.field1971;
         var5 = var2.field1904[1 + var1.field1972];
         if(var1.field1972 < var2.field1904.length - 2) {
            var6 = (var2.field1904[var1.field1972] & 255) << 8;
            var7 = (var2.field1904[2 + var1.field1972] & 255) << 8;
            var5 += (var2.field1904[var1.field1972 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass144;Lclass182;Lclass60;II)Z",
      garbageValue = "-1691366765"
   )
   synchronized boolean method2585(class144 var1, class182 var2, class60 var3, int var4) {
      var1.method2732();
      boolean var5 = true;
      Object var6 = null;
      int[] var10 = new int[]{var4};

      for(class134 var7 = (class134)var1.field2014.method2361(); var7 != null; var7 = (class134)var1.field2014.method2369()) {
         int var8 = (int)var7.hash;
         class142 var9 = (class142)this.field1942.method2374((long)var8);
         if(var9 == null) {
            var9 = PlayerComposition.method3144(var2, var8);
            if(null == var9) {
               var5 = false;
               continue;
            }

            this.field1942.method2364(var9, (long)var8);
         }

         if(!var9.method2691(var3, var7.field1898, var10)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method2733();
      }

      return var5;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-113"
   )
   public synchronized boolean method2589() {
      return this.field1948.method2645();
   }

   public class139() {
      this.method2509();
   }

   @ObfuscatedName("eh")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "1776418390"
   )
   static void method2597(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var8 = 0; var8 < ItemComposition.field2943; ++var8) {
         ItemComposition var9 = class36.getItemDefinition(var8);
         if((!var1 || var9.field2987) && var9.notedTemplate == -1 && var9.name.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               class118.field1854 = -1;
               class115.field1815 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[2 * var2.length];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var8;
         }
      }

      class115.field1815 = var2;
      class48.field945 = 0;
      class118.field1854 = var3;
      String[] var4 = new String[class118.field1854];

      for(int var5 = 0; var5 < class118.field1854; ++var5) {
         var4[var5] = class36.getItemDefinition(var2[var5]).name;
      }

      short[] var10 = class115.field1815;
      XGrandExchangeOffer.method46(var4, var10, 0, var4.length - 1);
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(Lclass140;S)I",
      garbageValue = "-1221"
   )
   int method2606(class140 var1) {
      int var2 = var1.field1957 + (var1.field1960 * var1.field1964 >> 12);
      var2 += this.field1944[var1.field1976] * (this.field1937[var1.field1976] - 8192) >> 12;
      class137 var3 = var1.field1959;
      int var4;
      if(var3.field1910 > 0 && (var3.field1911 > 0 || this.field1939[var1.field1976] > 0)) {
         var4 = var3.field1911 << 2;
         int var5 = var3.field1903 << 1;
         if(var1.field1973 < var5) {
            var4 = var1.field1973 * var4 / var5;
         }

         var4 += this.field1939[var1.field1976] >> 7;
         double var6 = Math.sin((double)(var1.field1974 & 511) * 0.01227184630308513D);
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(var1.field1968.field1025 * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)class57.field1047 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("s")
   protected synchronized int vmethod2703() {
      return 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "13"
   )
   synchronized void method2610() {
      for(class142 var1 = (class142)this.field1942.method2361(); var1 != null; var1 = (class142)this.field1942.method2369()) {
         var1.method2692();
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lclass140;ZI)V",
      garbageValue = "-2071829962"
   )
   void method2611(class140 var1, boolean var2) {
      int var3 = var1.field1968.field1024.length;
      int var4;
      if(var2 && var1.field1968.field1027) {
         int var5 = var3 + var3 - var1.field1968.field1023;
         var4 = (int)((long)this.field1943[var1.field1976] * (long)var5 >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field1975.method1169();
         }
      } else {
         var4 = (int)((long)this.field1943[var1.field1976] * (long)var3 >> 6);
      }

      var1.field1975.method1168(var4);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-913878638"
   )
   void method2617(int var1, int var2) {
   }

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass164;I)V",
      garbageValue = "636242067"
   )
   static final void method2634(int var0, int var1, int var2, int var3, SpritePixels var4, class164 var5) {
      int var6 = var2 * var2 + var3 * var3;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapScale + Client.mapAngle & 2047;
         int var8 = class84.field1438[var7];
         int var9 = class84.field1452[var7];
         var8 = var8 * 256 / (Client.mapScaleDelta + 256);
         var9 = var9 * 256 / (256 + Client.mapScaleDelta);
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var9 * var3 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class101.field1657.method4227(var14 + 94 + var0 + 4 - 10, var1 + 83 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class72.method1390(var0, var1, var2, var3, var4, var5);
      }

   }
}

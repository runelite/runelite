import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
public class class139 extends class68 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 95072765
   )
   int field1927 = 256;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1055738967
   )
   int field1928 = 1000000;
   @ObfuscatedName("o")
   class140[][] field1929 = new class140[16][128];
   @ObfuscatedName("h")
   int[] field1930 = new int[16];
   @ObfuscatedName("u")
   int[] field1931 = new int[16];
   @ObfuscatedName("k")
   int[] field1932 = new int[16];
   @ObfuscatedName("g")
   int[] field1933 = new int[16];
   @ObfuscatedName("aa")
   boolean field1934;
   @ObfuscatedName("e")
   int[] field1935 = new int[16];
   @ObfuscatedName("q")
   int[] field1936 = new int[16];
   @ObfuscatedName("z")
   int[] field1937 = new int[16];
   @ObfuscatedName("b")
   int[] field1938 = new int[16];
   @ObfuscatedName("n")
   int[] field1939 = new int[16];
   @ObfuscatedName("x")
   XHashTable field1940 = new XHashTable(128);
   @ObfuscatedName("p")
   int[] field1941 = new int[16];
   @ObfuscatedName("a")
   int[] field1943 = new int[16];
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      longValue = -7794410926646393259L
   )
   long field1944;
   @ObfuscatedName("an")
   class140[][] field1945 = new class140[16][128];
   @ObfuscatedName("ar")
   class141 field1946 = new class141();
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      longValue = -3897617817341327899L
   )
   long field1947;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -2035289659
   )
   int field1948;
   @ObfuscatedName("d")
   int[] field1949 = new int[16];
   @ObfuscatedName("v")
   int[] field1950 = new int[16];
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1997049055
   )
   int field1951;
   @ObfuscatedName("at")
   class143 field1952 = new class143(this);
   @ObfuscatedName("y")
   int[] field1953 = new int[16];
   @ObfuscatedName("t")
   int[] field1955 = new int[16];

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-336531676"
   )
   public int method2531() {
      return this.field1927;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "124"
   )
   void method2532(int var1, int var2, int var3) {
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "103"
   )
   synchronized void method2533() {
      for(class142 var1 = (class142)this.field1940.method2391(); var1 != null; var1 = (class142)this.field1940.method2392()) {
         var1.method2708();
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2143890117"
   )
   public synchronized void method2536() {
      this.field1946.method2663();
      this.method2549();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-79"
   )
   public synchronized boolean method2537() {
      return this.field1946.method2691();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1707208264"
   )
   public synchronized void method2538(int var1, int var2) {
      this.method2639(var1, var2);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)I",
      garbageValue = "1215986595"
   )
   int method2539(class140 var1) {
      int var2 = var1.field1964 + (var1.field1966 * var1.field1959 >> 12);
      var2 += this.field1937[var1.field1957] * (this.field1935[var1.field1957] - 8192) >> 12;
      class137 var3 = var1.field1963;
      int var4;
      if(var3.field1911 > 0 && (var3.field1909 > 0 || this.field1936[var1.field1957] > 0)) {
         var4 = var3.field1909 << 2;
         int var5 = var3.field1906 << 1;
         if(var1.field1972 < var5) {
            var4 = var4 * var1.field1972 / var5;
         }

         var4 += this.field1936[var1.field1957] >> 7;
         double var6 = Math.sin((double)(var1.field1956 & 511) * 0.01227184630308513D);
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(var1.field1958.field1037 * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)class148.field2033 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "817485094"
   )
   void method2540(int var1, int var2) {
      if(var2 != this.field1933[var1]) {
         this.field1933[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field1945[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1166376278"
   )
   void method2543(int var1, int var2, int var3) {
      class140 var4 = this.field1929[var1][var2];
      if(null != var4) {
         this.field1929[var1][var2] = null;
         if((this.field1938[var1] & 2) != 0) {
            for(class140 var5 = (class140)this.field1952.field2008.method2448(); var5 != null; var5 = (class140)this.field1952.field2008.method2445()) {
               if(var5.field1957 == var4.field1957 && var5.field1970 < 0 && var5 != var4) {
                  var4.field1970 = 0;
                  break;
               }
            }
         } else {
            var4.field1970 = 0;
         }

      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1886791384"
   )
   void method2545(int var1) {
      if((this.field1938[var1] & 4) != 0) {
         for(class140 var2 = (class140)this.field1952.field2008.method2448(); null != var2; var2 = (class140)this.field1952.field2008.method2445()) {
            if(var1 == var2.field1957) {
               var2.field1969 = 0;
            }
         }
      }

   }

   public class139() {
      this.method2549();
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "41821024"
   )
   void method2547(int var1) {
      if(var1 >= 0) {
         this.field1949[var1] = 12800;
         this.field1930[var1] = 8192;
         this.field1931[var1] = 16383;
         this.field1935[var1] = 8192;
         this.field1936[var1] = 0;
         this.field1950[var1] = 8192;
         this.method2601(var1);
         this.method2545(var1);
         this.field1938[var1] = 0;
         this.field1955[var1] = 32767;
         this.field1937[var1] = 256;
         this.field1941[var1] = 0;
         this.method2553(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method2547(var1);
         }

      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "765202959"
   )
   void method2548(int var1) {
      for(class140 var2 = (class140)this.field1952.field2008.method2448(); null != var2; var2 = (class140)this.field1952.field2008.method2445()) {
         if((var1 < 0 || var2.field1957 == var1) && var2.field1970 < 0) {
            this.field1929[var2.field1957][var2.field1961] = null;
            var2.field1970 = 0;
         }
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "174236672"
   )
   void method2549() {
      this.method2605(-1);
      this.method2547(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field1933[var1] = this.field1932[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field1953[var1] = this.field1932[var1] & -128;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lclass144;ZI)V",
      garbageValue = "1141283324"
   )
   synchronized void method2550(class144 var1, boolean var2) {
      this.method2536();
      this.field1946.method2662(var1.field2012);
      this.field1934 = var2;
      this.field1947 = 0L;
      int var3 = this.field1946.method2700();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field1946.method2666(var4);
         this.field1946.method2664(var4);
         this.field1946.method2667(var4);
      }

      this.field1948 = this.field1946.method2674();
      this.field1951 = this.field1946.field1986[this.field1948];
      this.field1944 = this.field1946.method2673(this.field1951);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "90"
   )
   void method2552(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method2543(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method2627(var3, var4, var5);
         } else {
            this.method2543(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method2532(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field1953[var3] = (var5 << 14) + (this.field1953[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field1953[var3] = (this.field1953[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 1) {
            this.field1936[var3] = (var5 << 7) + (this.field1936[var3] & -16257);
         }

         if(var4 == 33) {
            this.field1936[var3] = var5 + (this.field1936[var3] & -128);
         }

         if(var4 == 5) {
            this.field1950[var3] = (var5 << 7) + (this.field1950[var3] & -16257);
         }

         if(var4 == 37) {
            this.field1950[var3] = (this.field1950[var3] & -128) + var5;
         }

         if(var4 == 7) {
            this.field1949[var3] = (var5 << 7) + (this.field1949[var3] & -16257);
         }

         if(var4 == 39) {
            this.field1949[var3] = var5 + (this.field1949[var3] & -128);
         }

         if(var4 == 10) {
            this.field1930[var3] = (this.field1930[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 42) {
            this.field1930[var3] = (this.field1930[var3] & -128) + var5;
         }

         if(var4 == 11) {
            this.field1931[var3] = (this.field1931[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 43) {
            this.field1931[var3] = var5 + (this.field1931[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field1938[var3] |= 1;
            } else {
               this.field1938[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field1938[var3] |= 2;
            } else {
               this.method2601(var3);
               this.field1938[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field1955[var3] = (var5 << 7) + (this.field1955[var3] & 127);
         }

         if(var4 == 98) {
            this.field1955[var3] = (this.field1955[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field1955[var3] = (var5 << 7) + 16384 + (this.field1955[var3] & 127);
         }

         if(var4 == 100) {
            this.field1955[var3] = (this.field1955[var3] & 16256) + 16384 + var5;
         }

         if(var4 == 120) {
            this.method2605(var3);
         }

         if(var4 == 121) {
            this.method2547(var3);
         }

         if(var4 == 123) {
            this.method2548(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field1955[var3];
            if(var6 == 16384) {
               this.field1937[var3] = (this.field1937[var3] & -16257) + (var5 << 7);
            }
         }

         if(var4 == 38) {
            var6 = this.field1955[var3];
            if(var6 == 16384) {
               this.field1937[var3] = (this.field1937[var3] & -128) + var5;
            }
         }

         if(var4 == 16) {
            this.field1941[var3] = (var5 << 7) + (this.field1941[var3] & -16257);
         }

         if(var4 == 48) {
            this.field1941[var3] = var5 + (this.field1941[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field1938[var3] |= 4;
            } else {
               this.method2545(var3);
               this.field1938[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method2553(var3, (this.field1939[var3] & -16257) + (var5 << 7));
         }

         if(var4 == 49) {
            this.method2553(var3, (this.field1939[var3] & -128) + var5);
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method2540(var3, this.field1953[var3] + var4);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method2559(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 9 & 16256) + (var1 >> 8 & 127);
         this.method2653(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method2549();
         }
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-33"
   )
   void method2553(int var1, int var2) {
      this.field1939[var1] = var2;
      this.field1943[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)I",
      garbageValue = "1760766447"
   )
   int method2555(class140 var1) {
      class137 var2 = var1.field1963;
      int var3 = 4096 + this.field1949[var1.field1957] * this.field1931[var1.field1957] >> 13;
      var3 = 16384 + var3 * var3 >> 15;
      var3 = var1.field1962 * var3 + 16384 >> 15;
      var3 = 128 + var3 * this.field1927 >> 8;
      if(var2.field1905 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var1.field1967 * 1.953125E-5D * (double)var2.field1905) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field1910 != null) {
         var4 = var1.field1968;
         var5 = var2.field1910[1 + var1.field1976];
         if(var1.field1976 < var2.field1910.length - 2) {
            var6 = (var2.field1910[var1.field1976] & 255) << 8;
            var7 = (var2.field1910[var1.field1976 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field1910[3 + var1.field1976] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      if(var1.field1970 > 0 && null != var2.field1904) {
         var4 = var1.field1970;
         var5 = var2.field1904[var1.field1973 + 1];
         if(var1.field1973 < var2.field1904.length - 2) {
            var6 = (var2.field1904[var1.field1973] & 255) << 8;
            var7 = (var2.field1904[var1.field1973 + 2] & 255) << 8;
            var5 += (var2.field1904[var1.field1973 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = 32 + var5 * var3 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("e")
   protected synchronized int vmethod2725() {
      return 0;
   }

   @ObfuscatedName("u")
   protected synchronized class68 vmethod2723() {
      return this.field1952;
   }

   @ObfuscatedName("y")
   protected synchronized class68 vmethod2724() {
      return null;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "107"
   )
   void method2559(int var1, int var2) {
   }

   @ObfuscatedName("l")
   protected synchronized void vmethod2729(int var1) {
      if(this.field1946.method2691()) {
         int var2 = this.field1946.field1992 * this.field1928 / class148.field2033;

         do {
            long var3 = this.field1947 + (long)var2 * (long)var1;
            if(this.field1944 - var3 >= 0L) {
               this.field1947 = var3;
               break;
            }

            int var5 = (int)((this.field1944 - this.field1947 + (long)var2 - 1L) / (long)var2);
            this.field1947 += (long)var2 * (long)var5;
            this.field1952.vmethod2729(var5);
            var1 -= var5;
            this.method2562();
         } while(this.field1946.method2691());
      }

      this.field1952.vmethod2729(var1);
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-304758915"
   )
   void method2562() {
      int var1 = this.field1948;
      int var2 = this.field1951;

      long var3;
      for(var3 = this.field1944; this.field1951 == var2; var3 = this.field1946.method2673(var2)) {
         while(this.field1946.field1986[var1] == var2) {
            this.field1946.method2666(var1);
            int var5 = this.field1946.method2670(var1);
            if(var5 == 1) {
               this.field1946.method2678();
               this.field1946.method2667(var1);
               if(this.field1946.method2676()) {
                  if(!this.field1934 || var2 == 0) {
                     this.method2549();
                     this.field1946.method2663();
                     return;
                  }

                  this.field1946.method2696(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method2552(var5);
            }

            this.field1946.method2664(var1);
            this.field1946.method2667(var1);
         }

         var1 = this.field1946.method2674();
         var2 = this.field1946.field1986[var1];
      }

      this.field1948 = var1;
      this.field1951 = var2;
      this.field1944 = var3;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)Z",
      garbageValue = "1455587458"
   )
   boolean method2563(class140 var1) {
      if(var1.field1974 == null) {
         if(var1.field1970 >= 0) {
            var1.unlink();
            if(var1.field1960 > 0 && var1 == this.field1945[var1.field1957][var1.field1960]) {
               this.field1945[var1.field1957][var1.field1960] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2066273157"
   )
   public synchronized void method2566(int var1) {
      this.field1927 = var1;
   }

   @ObfuscatedName("q")
   protected synchronized void vmethod2726(int[] var1, int var2, int var3) {
      if(this.field1946.method2691()) {
         int var4 = this.field1946.field1992 * this.field1928 / class148.field2033;

         do {
            long var5 = this.field1947 + (long)var4 * (long)var3;
            if(this.field1944 - var5 >= 0L) {
               this.field1947 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field1944 - this.field1947) - 1L) / (long)var4);
            this.field1947 += (long)var7 * (long)var4;
            this.field1952.vmethod2726(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method2562();
         } while(this.field1946.method2691());
      }

      this.field1952.vmethod2726(var1, var2, var3);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass140;ZI)V",
      garbageValue = "-2020426018"
   )
   void method2592(class140 var1, boolean var2) {
      int var3 = var1.field1958.field1035.length;
      int var4;
      if(var2 && var1.field1958.field1034) {
         int var5 = var3 + var3 - var1.field1958.field1033;
         var4 = (int)((long)this.field1941[var1.field1957] * (long)var5 >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field1974.method1255();
         }
      } else {
         var4 = (int)((long)this.field1941[var1.field1957] * (long)var3 >> 6);
      }

      var1.field1974.method1260(var4);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-4969"
   )
   void method2601(int var1) {
      if((this.field1938[var1] & 2) != 0) {
         for(class140 var2 = (class140)this.field1952.field2008.method2448(); null != var2; var2 = (class140)this.field1952.field2008.method2445()) {
            if(var1 == var2.field1957 && null == this.field1929[var1][var2.field1961] && var2.field1970 < 0) {
               var2.field1970 = 0;
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass144;Lclass182;Lclass60;II)Z",
      garbageValue = "-593559981"
   )
   synchronized boolean method2604(class144 var1, class182 var2, class60 var3, int var4) {
      var1.method2749();
      boolean var5 = true;
      Object var6 = null;
      int[] var10 = new int[]{var4};

      for(class134 var7 = (class134)var1.field2011.method2391(); var7 != null; var7 = (class134)var1.field2011.method2392()) {
         int var8 = (int)var7.hash;
         class142 var9 = (class142)this.field1940.method2405((long)var8);
         if(var9 == null) {
            var9 = VertexNormal.method1691(var2, var8);
            if(var9 == null) {
               var5 = false;
               continue;
            }

            this.field1940.method2403(var9, (long)var8);
         }

         if(!var9.method2707(var3, var7.field1898, var10)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method2752();
      }

      return var5;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "578017595"
   )
   void method2605(int var1) {
      for(class140 var2 = (class140)this.field1952.field2008.method2448(); null != var2; var2 = (class140)this.field1952.field2008.method2445()) {
         if(var1 < 0 || var2.field1957 == var1) {
            if(null != var2.field1974) {
               var2.field1974.method1265(class148.field2033 / 100);
               if(var2.field1974.method1269()) {
                  this.field1952.field2007.method1001(var2.field1974);
               }

               var2.method2656();
            }

            if(var2.field1970 < 0) {
               this.field1929[var2.field1957][var2.field1961] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "933753155"
   )
   public synchronized void method2612() {
      for(class142 var1 = (class142)this.field1940.method2391(); null != var1; var1 = (class142)this.field1940.method2392()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "946662567"
   )
   void method2627(int var1, int var2, int var3) {
      this.method2543(var1, var2, 64);
      if((this.field1938[var1] & 2) != 0) {
         for(class140 var4 = (class140)this.field1952.field2008.method2449(); var4 != null; var4 = (class140)this.field1952.field2008.method2451()) {
            if(var4.field1957 == var1 && var4.field1970 < 0) {
               this.field1929[var1][var4.field1961] = null;
               this.field1929[var1][var2] = var4;
               int var8 = (var4.field1966 * var4.field1959 >> 12) + var4.field1964;
               var4.field1964 += var2 - var4.field1961 << 8;
               var4.field1959 = var8 - var4.field1964;
               var4.field1966 = 4096;
               var4.field1961 = var2;
               return;
            }
         }
      }

      class142 var9 = (class142)this.field1940.method2405((long)this.field1933[var1]);
      if(null != var9) {
         class55 var5 = var9.field2003[var2];
         if(var5 != null) {
            class140 var6 = new class140();
            var6.field1957 = var1;
            var6.field1971 = var9;
            var6.field1958 = var5;
            var6.field1963 = var9.field1997[var2];
            var6.field1960 = var9.field2002[var2];
            var6.field1961 = var2;
            var6.field1962 = var3 * var3 * var9.field2001 * var9.field2005[var2] + 1024 >> 11;
            var6.field1979 = var9.field2000[var2] & 255;
            var6.field1964 = (var2 << 8) - (var9.field1996[var2] & 32767);
            var6.field1967 = 0;
            var6.field1968 = 0;
            var6.field1976 = 0;
            var6.field1970 = -1;
            var6.field1973 = 0;
            if(this.field1941[var1] == 0) {
               var6.field1974 = class66.method1252(var5, this.method2539(var6), this.method2555(var6), this.method2633(var6));
            } else {
               var6.field1974 = class66.method1252(var5, this.method2539(var6), 0, this.method2633(var6));
               this.method2592(var6, var9.field1996[var2] < 0);
            }

            if(var9.field1996[var2] < 0) {
               var6.field1974.method1339(-1);
            }

            if(var6.field1960 >= 0) {
               class140 var7 = this.field1945[var1][var6.field1960];
               if(null != var7 && var7.field1970 < 0) {
                  this.field1929[var1][var7.field1961] = null;
                  var7.field1970 = 0;
               }

               this.field1945[var1][var6.field1960] = var6;
            }

            this.field1952.field2008.method2458(var6);
            this.field1929[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)I",
      garbageValue = "894165265"
   )
   int method2633(class140 var1) {
      int var2 = this.field1930[var1.field1957];
      return var2 < 8192?32 + var2 * var1.field1979 >> 6:16384 - ((16384 - var2) * (128 - var1.field1979) + 32 >> 6);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lclass140;[IIII)Z",
      garbageValue = "-342405155"
   )
   boolean method2637(class140 var1, int[] var2, int var3, int var4) {
      var1.field1975 = class148.field2033 / 100;
      if(var1.field1970 < 0 || null != var1.field1974 && !var1.field1974.method1346()) {
         int var5 = var1.field1966;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field1950[var1.field1957]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field1966 = var5;
         }

         var1.field1974.method1266(this.method2539(var1));
         class137 var6 = var1.field1963;
         boolean var7 = false;
         ++var1.field1972;
         var1.field1956 += var6.field1911;
         double var8 = 5.086263020833333E-6D * (double)((var1.field1961 - 60 << 8) + (var1.field1959 * var1.field1966 >> 12));
         if(var6.field1905 > 0) {
            if(var6.field1908 > 0) {
               var1.field1967 += (int)(128.0D * Math.pow(2.0D, (double)var6.field1908 * var8) + 0.5D);
            } else {
               var1.field1967 += 128;
            }
         }

         if(var6.field1910 != null) {
            if(var6.field1914 > 0) {
               var1.field1968 += (int)(128.0D * Math.pow(2.0D, (double)var6.field1914 * var8) + 0.5D);
            } else {
               var1.field1968 += 128;
            }

            while(var1.field1976 < var6.field1910.length - 2 && var1.field1968 > (var6.field1910[var1.field1976 + 2] & 255) << 8) {
               var1.field1976 += 2;
            }

            if(var6.field1910.length - 2 == var1.field1976 && var6.field1910[1 + var1.field1976] == 0) {
               var7 = true;
            }
         }

         if(var1.field1970 >= 0 && var6.field1904 != null && (this.field1938[var1.field1957] & 1) == 0 && (var1.field1960 < 0 || var1 != this.field1945[var1.field1957][var1.field1960])) {
            if(var6.field1907 > 0) {
               var1.field1970 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field1907) + 0.5D);
            } else {
               var1.field1970 += 128;
            }

            while(var1.field1973 < var6.field1904.length - 2 && var1.field1970 > (var6.field1904[var1.field1973 + 2] & 255) << 8) {
               var1.field1973 += 2;
            }

            if(var6.field1904.length - 2 == var1.field1973) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field1974.method1265(var1.field1975);
            if(null != var2) {
               var1.field1974.vmethod2726(var2, var3, var4);
            } else {
               var1.field1974.vmethod2729(var4);
            }

            if(var1.field1974.method1269()) {
               this.field1952.field2007.method1001(var1.field1974);
            }

            var1.method2656();
            if(var1.field1970 >= 0) {
               var1.unlink();
               if(var1.field1960 > 0 && var1 == this.field1945[var1.field1957][var1.field1960]) {
                  this.field1945[var1.field1957][var1.field1960] = null;
               }
            }

            return true;
         } else {
            var1.field1974.method1264(var1.field1975, this.method2555(var1), this.method2633(var1));
            return false;
         }
      } else {
         var1.method2656();
         var1.unlink();
         if(var1.field1960 > 0 && var1 == this.field1945[var1.field1957][var1.field1960]) {
            this.field1945[var1.field1957][var1.field1960] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1716579287"
   )
   void method2639(int var1, int var2) {
      this.field1932[var1] = var2;
      this.field1953[var1] = var2 & -128;
      this.method2540(var1, var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "84"
   )
   void method2653(int var1, int var2) {
      this.field1935[var1] = var2;
   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
public class class139 extends class68 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 977746019
   )
   int field1907 = 1000000;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1101388327
   )
   int field1908 = 256;
   @ObfuscatedName("b")
   class140[][] field1909 = new class140[16][128];
   @ObfuscatedName("z")
   int[] field1910 = new int[16];
   @ObfuscatedName("f")
   int[] field1911 = new int[16];
   @ObfuscatedName("c")
   int[] field1912 = new int[16];
   @ObfuscatedName("h")
   int[] field1913 = new int[16];
   @ObfuscatedName("ag")
   class141 field1914 = new class141();
   @ObfuscatedName("g")
   int[] field1915 = new int[16];
   @ObfuscatedName("l")
   int[] field1916 = new int[16];
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      longValue = -5583752063121677059L
   )
   long field1917;
   @ObfuscatedName("m")
   int[] field1918 = new int[16];
   @ObfuscatedName("y")
   int[] field1919 = new int[16];
   @ObfuscatedName("u")
   XHashTable field1920 = new XHashTable(128);
   @ObfuscatedName("s")
   int[] field1921 = new int[16];
   @ObfuscatedName("w")
   int[] field1922 = new int[16];
   @ObfuscatedName("n")
   int[] field1923 = new int[16];
   @ObfuscatedName("o")
   int[] field1924 = new int[16];
   @ObfuscatedName("d")
   int[] field1925 = new int[16];
   @ObfuscatedName("aj")
   class140[][] field1926 = new class140[16][128];
   @ObfuscatedName("t")
   int[] field1927 = new int[16];
   @ObfuscatedName("al")
   boolean field1928;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 379933199
   )
   int field1929;
   @ObfuscatedName("a")
   int[] field1930 = new int[16];
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      longValue = -8228776515715742905L
   )
   long field1931;
   @ObfuscatedName("ai")
   class143 field1933 = new class143(this);
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1412297841
   )
   int field1934;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "2"
   )
   void method2476(int var1, int var2, int var3) {
      this.method2490(var1, var2, 64);
      if((this.field1919[var1] & 2) != 0) {
         for(class140 var4 = (class140)this.field1933.field1992.method2392(); var4 != null; var4 = (class140)this.field1933.field1992.method2390()) {
            if(var1 == var4.field1957 && var4.field1949 < 0) {
               this.field1909[var1][var4.field1940] = null;
               this.field1909[var1][var2] = var4;
               int var5 = (var4.field1944 * var4.field1951 >> 12) + var4.field1935;
               var4.field1935 += var2 - var4.field1940 << 8;
               var4.field1944 = var5 - var4.field1935;
               var4.field1951 = 4096;
               var4.field1940 = var2;
               return;
            }
         }
      }

      class142 var8 = (class142)this.field1920.method2339((long)this.field1916[var1]);
      if(null != var8) {
         class55 var9 = var8.field1977[var2];
         if(null != var9) {
            class140 var6 = new class140();
            var6.field1957 = var1;
            var6.field1943 = var8;
            var6.field1937 = var9;
            var6.field1938 = var8.field1981[var2];
            var6.field1939 = var8.field1980[var2];
            var6.field1940 = var2;
            var6.field1941 = 1024 + var8.field1979[var2] * var3 * var3 * var8.field1986 >> 11;
            var6.field1942 = var8.field1978[var2] & 255;
            var6.field1935 = (var2 << 8) - (var8.field1982[var2] & 32767);
            var6.field1946 = 0;
            var6.field1947 = 0;
            var6.field1952 = 0;
            var6.field1949 = -1;
            var6.field1950 = 0;
            if(this.field1922[var1] == 0) {
               var6.field1953 = class66.method1131(var9, this.method2486(var6), this.method2503(var6), this.method2504(var6));
            } else {
               var6.field1953 = class66.method1131(var9, this.method2486(var6), 0, this.method2504(var6));
               this.method2592(var6, var8.field1982[var2] < 0);
            }

            if(var8.field1982[var2] < 0) {
               var6.field1953.method1133(-1);
            }

            if(var6.field1939 >= 0) {
               class140 var7 = this.field1926[var1][var6.field1939];
               if(null != var7 && var7.field1949 < 0) {
                  this.field1909[var1][var7.field1940] = null;
                  var7.field1949 = 0;
               }

               this.field1926[var1][var6.field1939] = var6;
            }

            this.field1933.field1992.method2394(var6);
            this.field1909[var1][var2] = var6;
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass144;Lclass182;Lclass60;II)Z",
      garbageValue = "1930197362"
   )
   public synchronized boolean method2479(class144 var1, class182 var2, class60 var3, int var4) {
      var1.method2700();
      boolean var5 = true;
      Object var6 = null;
      int[] var7 = new int[]{var4};

      for(class134 var8 = (class134)var1.field1994.method2344(); var8 != null; var8 = (class134)var1.field1994.method2343()) {
         int var9 = (int)var8.hash;
         class142 var10 = (class142)this.field1920.method2339((long)var9);
         if(null == var10) {
            var10 = class31.method676(var2, var9);
            if(var10 == null) {
               var5 = false;
               continue;
            }

            this.field1920.method2340(var10, (long)var9);
         }

         if(!var10.method2668(var3, var8.field1882, var7)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method2701();
      }

      return var5;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1124222710"
   )
   public synchronized void method2481() {
      for(class142 var1 = (class142)this.field1920.method2344(); null != var1; var1 = (class142)this.field1920.method2343()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass144;ZI)V",
      garbageValue = "401527178"
   )
   public synchronized void method2482(class144 var1, boolean var2) {
      this.method2570();
      this.field1914.method2610(var1.field1993);
      this.field1928 = var2;
      this.field1931 = 0L;
      int var3 = this.field1914.method2613();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field1914.method2614(var4);
         this.field1914.method2617(var4);
         this.field1914.method2615(var4);
      }

      this.field1929 = this.field1914.method2622();
      this.field1934 = this.field1914.field1966[this.field1929];
      this.field1917 = this.field1914.method2621(this.field1934);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1516727769"
   )
   public synchronized boolean method2484() {
      return this.field1914.method2612();
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)I",
      garbageValue = "543042093"
   )
   int method2486(class140 var1) {
      int var2 = (var1.field1951 * var1.field1944 >> 12) + var1.field1935;
      var2 += (this.field1910[var1.field1957] - 8192) * this.field1921[var1.field1957] >> 12;
      class137 var3 = var1.field1938;
      int var4;
      if(var3.field1893 > 0 && (var3.field1896 > 0 || this.field1927[var1.field1957] > 0)) {
         var4 = var3.field1896 << 2;
         int var5 = var3.field1895 << 1;
         if(var1.field1945 < var5) {
            var4 = var4 * var1.field1945 / var5;
         }

         var4 += this.field1927[var1.field1957] >> 7;
         double var6 = Math.sin((double)(var1.field1954 & 511) * 0.01227184630308513D);
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(256 * var1.field1937.field1017) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)class7.field65 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-857202030"
   )
   void method2487(int var1, int var2) {
      if(this.field1916[var1] != var2) {
         this.field1916[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field1926[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1115102422"
   )
   void method2490(int var1, int var2, int var3) {
      class140 var4 = this.field1909[var1][var2];
      if(null != var4) {
         this.field1909[var1][var2] = null;
         if((this.field1919[var1] & 2) != 0) {
            for(class140 var5 = (class140)this.field1933.field1992.method2391(); null != var5; var5 = (class140)this.field1933.field1992.method2393()) {
               if(var5.field1957 == var4.field1957 && var5.field1949 < 0 && var4 != var5) {
                  var4.field1949 = 0;
                  break;
               }
            }
         } else {
            var4.field1949 = 0;
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "52"
   )
   void method2491(int var1, int var2, int var3) {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2128938615"
   )
   public synchronized void method2492() {
      for(class142 var1 = (class142)this.field1920.method2344(); var1 != null; var1 = (class142)this.field1920.method2343()) {
         var1.method2662();
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "740325846"
   )
   void method2493(int var1, int var2) {
      this.field1910[var1] = var2;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2084153205"
   )
   void method2494(int var1) {
      for(class140 var2 = (class140)this.field1933.field1992.method2391(); var2 != null; var2 = (class140)this.field1933.field1992.method2393()) {
         if(var1 < 0 || var2.field1957 == var1) {
            if(null != var2.field1953) {
               var2.field1953.method1144(class7.field65 / 100);
               if(var2.field1953.method1148()) {
                  this.field1933.field1991.method889(var2.field1953);
               }

               var2.method2608();
            }

            if(var2.field1949 < 0) {
               this.field1909[var2.field1957][var2.field1940] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1325713381"
   )
   void method2496(int var1) {
      for(class140 var2 = (class140)this.field1933.field1992.method2391(); var2 != null; var2 = (class140)this.field1933.field1992.method2393()) {
         if((var1 < 0 || var1 == var2.field1957) && var2.field1949 < 0) {
            this.field1909[var2.field1957][var2.field1940] = null;
            var2.field1949 = 0;
         }
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-692468717"
   )
   void method2497() {
      this.method2494(-1);
      this.method2590(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field1916[var1] = this.field1925[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field1915[var1] = this.field1925[var1] & -128;
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "88256087"
   )
   void method2498(int var1) {
      if((this.field1919[var1] & 2) != 0) {
         for(class140 var2 = (class140)this.field1933.field1992.method2391(); var2 != null; var2 = (class140)this.field1933.field1992.method2393()) {
            if(var1 == var2.field1957 && null == this.field1909[var1][var2.field1940] && var2.field1949 < 0) {
               var2.field1949 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "73"
   )
   void method2499(int var1) {
      if((this.field1919[var1] & 4) != 0) {
         for(class140 var2 = (class140)this.field1933.field1992.method2391(); var2 != null; var2 = (class140)this.field1933.field1992.method2393()) {
            if(var1 == var2.field1957) {
               var2.field1955 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1562050125"
   )
   void method2500(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method2490(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method2476(var3, var4, var5);
         } else {
            this.method2490(var3, var4, 64);
         }
      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method2491(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field1915[var3] = (var5 << 14) + (this.field1915[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field1915[var3] = (this.field1915[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 1) {
            this.field1927[var3] = (var5 << 7) + (this.field1927[var3] & -16257);
         }

         if(var4 == 33) {
            this.field1927[var3] = (this.field1927[var3] & -128) + var5;
         }

         if(var4 == 5) {
            this.field1918[var3] = (this.field1918[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 37) {
            this.field1918[var3] = var5 + (this.field1918[var3] & -128);
         }

         if(var4 == 7) {
            this.field1930[var3] = (var5 << 7) + (this.field1930[var3] & -16257);
         }

         if(var4 == 39) {
            this.field1930[var3] = var5 + (this.field1930[var3] & -128);
         }

         if(var4 == 10) {
            this.field1911[var3] = (this.field1911[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 42) {
            this.field1911[var3] = (this.field1911[var3] & -128) + var5;
         }

         if(var4 == 11) {
            this.field1912[var3] = (var5 << 7) + (this.field1912[var3] & -16257);
         }

         if(var4 == 43) {
            this.field1912[var3] = var5 + (this.field1912[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field1919[var3] |= 1;
            } else {
               this.field1919[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field1919[var3] |= 2;
            } else {
               this.method2498(var3);
               this.field1919[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field1913[var3] = (this.field1913[var3] & 127) + (var5 << 7);
         }

         if(var4 == 98) {
            this.field1913[var3] = var5 + (this.field1913[var3] & 16256);
         }

         if(var4 == 101) {
            this.field1913[var3] = (var5 << 7) + (this.field1913[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field1913[var3] = (this.field1913[var3] & 16256) + 16384 + var5;
         }

         if(var4 == 120) {
            this.method2494(var3);
         }

         if(var4 == 121) {
            this.method2590(var3);
         }

         if(var4 == 123) {
            this.method2496(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field1913[var3];
            if(var6 == 16384) {
               this.field1921[var3] = (this.field1921[var3] & -16257) + (var5 << 7);
            }
         }

         if(var4 == 38) {
            var6 = this.field1913[var3];
            if(var6 == 16384) {
               this.field1921[var3] = var5 + (this.field1921[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field1922[var3] = (var5 << 7) + (this.field1922[var3] & -16257);
         }

         if(var4 == 48) {
            this.field1922[var3] = var5 + (this.field1922[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field1919[var3] |= 4;
            } else {
               this.method2499(var3);
               this.field1919[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method2501(var3, (this.field1923[var3] & -16257) + (var5 << 7));
         }

         if(var4 == 49) {
            this.method2501(var3, (this.field1923[var3] & -128) + var5);
         }
      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method2487(var3, this.field1915[var3] + var4);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method2518(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method2493(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method2497();
         }
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "817157316"
   )
   void method2501(int var1, int var2) {
      this.field1923[var1] = var2;
      this.field1924[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)I",
      garbageValue = "1227989958"
   )
   int method2503(class140 var1) {
      class137 var2 = var1.field1938;
      int var3 = this.field1930[var1.field1957] * this.field1912[var1.field1957] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = 16384 + var3 * var1.field1941 >> 15;
      var3 = this.field1908 * var3 + 128 >> 8;
      if(var2.field1889 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field1889 * (double)var1.field1946 * 1.953125E-5D) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field1887 != null) {
         var4 = var1.field1947;
         var5 = var2.field1887[1 + var1.field1952];
         if(var1.field1952 < var2.field1887.length - 2) {
            var6 = (var2.field1887[var1.field1952] & 255) << 8;
            var7 = (var2.field1887[2 + var1.field1952] & 255) << 8;
            var5 += (var2.field1887[var1.field1952 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      if(var1.field1949 > 0 && null != var2.field1894) {
         var4 = var1.field1949;
         var5 = var2.field1894[1 + var1.field1950];
         if(var1.field1950 < var2.field1894.length - 2) {
            var6 = (var2.field1894[var1.field1950] & 255) << 8;
            var7 = (var2.field1894[var1.field1950 + 2] & 255) << 8;
            var5 += (var2.field1894[var1.field1950 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Lclass140;B)I",
      garbageValue = "122"
   )
   int method2504(class140 var1) {
      int var2 = this.field1911[var1.field1957];
      return var2 < 8192?var1.field1942 * var2 + 32 >> 6:16384 - ((16384 - var2) * (128 - var1.field1942) + 32 >> 6);
   }

   @ObfuscatedName("g")
   protected synchronized class68 vmethod2671() {
      return this.field1933;
   }

   @ObfuscatedName("z")
   protected synchronized class68 vmethod2672() {
      return null;
   }

   @ObfuscatedName("t")
   protected synchronized int vmethod2673() {
      return 0;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-16777216"
   )
   void method2510() {
      int var1 = this.field1929;
      int var2 = this.field1934;

      long var3;
      for(var3 = this.field1917; var2 == this.field1934; var3 = this.field1914.method2621(var2)) {
         while(var2 == this.field1914.field1966[var1]) {
            this.field1914.method2614(var1);
            int var5 = this.field1914.method2650(var1);
            if(var5 == 1) {
               this.field1914.method2636();
               this.field1914.method2615(var1);
               if(this.field1914.method2641()) {
                  if(!this.field1928 || var2 == 0) {
                     this.method2497();
                     this.field1914.method2611();
                     return;
                  }

                  this.field1914.method2659(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method2500(var5);
            }

            this.field1914.method2617(var1);
            this.field1914.method2615(var1);
         }

         var1 = this.field1914.method2622();
         var2 = this.field1914.field1966[var1];
      }

      this.field1929 = var1;
      this.field1934 = var2;
      this.field1917 = var3;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(Lclass140;B)Z",
      garbageValue = "-7"
   )
   boolean method2511(class140 var1) {
      if(var1.field1953 == null) {
         if(var1.field1949 >= 0) {
            var1.unlink();
            if(var1.field1939 > 0 && this.field1926[var1.field1957][var1.field1939] == var1) {
               this.field1926[var1.field1957][var1.field1939] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(Lclass140;[IIII)Z",
      garbageValue = "-1627946484"
   )
   boolean method2512(class140 var1, int[] var2, int var3, int var4) {
      var1.field1959 = class7.field65 / 100;
      if(var1.field1949 < 0 || var1.field1953 != null && !var1.field1953.method1147()) {
         int var5 = var1.field1951;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field1918[var1.field1957]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field1951 = var5;
         }

         var1.field1953.method1145(this.method2486(var1));
         class137 var6 = var1.field1938;
         boolean var7 = false;
         ++var1.field1945;
         var1.field1954 += var6.field1893;
         double var8 = 5.086263020833333E-6D * (double)((var1.field1940 - 60 << 8) + (var1.field1944 * var1.field1951 >> 12));
         if(var6.field1889 > 0) {
            if(var6.field1892 > 0) {
               var1.field1946 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field1892) + 0.5D);
            } else {
               var1.field1946 += 128;
            }
         }

         if(var6.field1887 != null) {
            if(var6.field1890 > 0) {
               var1.field1947 += (int)(128.0D * Math.pow(2.0D, (double)var6.field1890 * var8) + 0.5D);
            } else {
               var1.field1947 += 128;
            }

            while(var1.field1952 < var6.field1887.length - 2 && var1.field1947 > (var6.field1887[var1.field1952 + 2] & 255) << 8) {
               var1.field1952 += 2;
            }

            if(var6.field1887.length - 2 == var1.field1952 && var6.field1887[var1.field1952 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field1949 >= 0 && null != var6.field1894 && (this.field1919[var1.field1957] & 1) == 0 && (var1.field1939 < 0 || var1 != this.field1926[var1.field1957][var1.field1939])) {
            if(var6.field1891 > 0) {
               var1.field1949 += (int)(128.0D * Math.pow(2.0D, (double)var6.field1891 * var8) + 0.5D);
            } else {
               var1.field1949 += 128;
            }

            while(var1.field1950 < var6.field1894.length - 2 && var1.field1949 > (var6.field1894[2 + var1.field1950] & 255) << 8) {
               var1.field1950 += 2;
            }

            if(var6.field1894.length - 2 == var1.field1950) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field1953.method1144(var1.field1959);
            if(null != var2) {
               var1.field1953.vmethod2674(var2, var3, var4);
            } else {
               var1.field1953.vmethod2675(var4);
            }

            if(var1.field1953.method1148()) {
               this.field1933.field1991.method889(var1.field1953);
            }

            var1.method2608();
            if(var1.field1949 >= 0) {
               var1.unlink();
               if(var1.field1939 > 0 && var1 == this.field1926[var1.field1957][var1.field1939]) {
                  this.field1926[var1.field1957][var1.field1939] = null;
               }
            }

            return true;
         } else {
            var1.field1953.method1221(var1.field1959, this.method2503(var1), this.method2504(var1));
            return false;
         }
      } else {
         var1.method2608();
         var1.unlink();
         if(var1.field1939 > 0 && this.field1926[var1.field1957][var1.field1939] == var1) {
            this.field1926[var1.field1957][var1.field1939] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "1"
   )
   void method2518(int var1, int var2) {
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "103"
   )
   void method2524(int var1, int var2) {
      this.field1925[var1] = var2;
      this.field1915[var1] = var2 & -128;
      this.method2487(var1, var2);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "993119839"
   )
   public synchronized void method2544(int var1) {
      this.field1908 = var1;
   }

   public class139() {
      this.method2497();
   }

   @ObfuscatedName("m")
   protected synchronized void vmethod2674(int[] var1, int var2, int var3) {
      if(this.field1914.method2612()) {
         int var4 = this.field1907 * this.field1914.field1963 / class7.field65;

         do {
            long var5 = this.field1931 + (long)var4 * (long)var3;
            if(this.field1917 - var5 >= 0L) {
               this.field1931 = var5;
               break;
            }

            int var7 = (int)((this.field1917 - this.field1931 + (long)var4 - 1L) / (long)var4);
            this.field1931 += (long)var4 * (long)var7;
            this.field1933.vmethod2674(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method2510();
         } while(this.field1914.method2612());
      }

      this.field1933.vmethod2674(var1, var2, var3);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "659465405"
   )
   public synchronized void method2570() {
      this.field1914.method2611();
      this.method2497();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "550399371"
   )
   public int method2577() {
      return this.field1908;
   }

   @ObfuscatedName("e")
   protected synchronized void vmethod2675(int var1) {
      if(this.field1914.method2612()) {
         int var2 = this.field1907 * this.field1914.field1963 / class7.field65;

         do {
            long var3 = this.field1931 + (long)var1 * (long)var2;
            if(this.field1917 - var3 >= 0L) {
               this.field1931 = var3;
               break;
            }

            int var5 = (int)((this.field1917 - this.field1931 + (long)var2 - 1L) / (long)var2);
            this.field1931 += (long)var5 * (long)var2;
            this.field1933.vmethod2675(var5);
            var1 -= var5;
            this.method2510();
         } while(this.field1914.method2612());
      }

      this.field1933.vmethod2675(var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-576872745"
   )
   public synchronized void method2580(int var1, int var2) {
      this.method2524(var1, var2);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1061634088"
   )
   void method2590(int var1) {
      if(var1 >= 0) {
         this.field1930[var1] = 12800;
         this.field1911[var1] = 8192;
         this.field1912[var1] = 16383;
         this.field1910[var1] = 8192;
         this.field1927[var1] = 0;
         this.field1918[var1] = 8192;
         this.method2498(var1);
         this.method2499(var1);
         this.field1919[var1] = 0;
         this.field1913[var1] = 32767;
         this.field1921[var1] = 256;
         this.field1922[var1] = 0;
         this.method2501(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method2590(var1);
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass140;ZI)V",
      garbageValue = "-675071455"
   )
   void method2592(class140 var1, boolean var2) {
      int var3 = var1.field1937.field1015.length;
      int var4;
      if(var2 && var1.field1937.field1018) {
         int var5 = var3 + var3 - var1.field1937.field1016;
         var4 = (int)((long)this.field1922[var1.field1957] * (long)var5 >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field1953.method1140();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field1922[var1.field1957] >> 6);
      }

      var1.field1953.method1139(var4);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LWorld;B)V",
      garbageValue = "-118"
   )
   @Export("selectWorld")
   static void selectWorld(World var0) {
      if(var0.method636() != Client.isMembers) {
         Client.isMembers = var0.method636();
         WidgetNode.method185(var0.method636());
      }

      class152.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      class107.field1719 = Client.field416 == 0?'ꩊ':'鱀' + var0.id;
      class9.field90 = Client.field416 == 0?443:'썐' + var0.id;
      Tile.field1351 = class107.field1719;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass228;B)Ljava/lang/String;",
      garbageValue = "-120"
   )
   public static String method2601(CharSequence var0, class228 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3 && class118.method2269(var0.charAt(var2)); ++var2) {
            ;
         }

         while(var3 > var2 && class118.method2269(var0.charAt(var3 - 1))) {
            --var3;
         }

         int var4 = var3 - var2;
         if(var4 >= 1) {
            byte var5;
            if(var1 == null) {
               var5 = 12;
            } else {
               switch(var1.field3239) {
               case 5:
                  var5 = 20;
                  break;
               default:
                  var5 = 12;
               }
            }

            if(var4 <= var5) {
               StringBuilder var6 = new StringBuilder(var4);

               for(int var7 = var2; var7 < var3; ++var7) {
                  char var8 = var0.charAt(var7);
                  boolean var9;
                  if(Character.isISOControl(var8)) {
                     var9 = false;
                  } else if(Frames.method1852(var8)) {
                     var9 = true;
                  } else {
                     label106: {
                        char[] var10 = class204.field3064;

                        int var11;
                        char var12;
                        for(var11 = 0; var11 < var10.length; ++var11) {
                           var12 = var10[var11];
                           if(var12 == var8) {
                              var9 = true;
                              break label106;
                           }
                        }

                        var10 = class204.field3065;
                        var11 = 0;

                        while(true) {
                           if(var11 >= var10.length) {
                              var9 = false;
                              break;
                           }

                           var12 = var10[var11];
                           if(var8 == var12) {
                              var9 = true;
                              break;
                           }

                           ++var11;
                        }
                     }
                  }

                  if(var9) {
                     char var13 = class176.method3244(var8);
                     if(var13 != 0) {
                        var6.append(var13);
                     }
                  }
               }

               if(var6.length() == 0) {
                  return null;
               }

               return var6.toString();
            }
         }

         return null;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Lclass195;",
      garbageValue = "-1924202499"
   )
   public static class195 method2602(int var0) {
      class195 var1 = (class195)class195.field2840.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class195.field2847.method3272(8, var0);
         var1 = new class195();
         if(null != var2) {
            var1.method3546(new Buffer(var2));
         }

         class195.field2840.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IILclass119;LCollisionData;I)Z",
      garbageValue = "986491670"
   )
   static final boolean method2603(int var0, int var1, class119 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class118.field1834[var6][var7] = 99;
      class118.field1826[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class118.field1828[var10] = var0;
      int var13 = var10 + 1;
      class118.field1829[var10] = var1;
      int[][] var14 = var3.flags;

      while(var13 != var11) {
         var4 = class118.field1828[var11];
         var5 = class118.field1829[var11];
         var11 = var11 + 1 & 4095;
         int var15 = var4 - var8;
         int var16 = var5 - var9;
         int var17 = var4 - var3.x;
         int var18 = var5 - var3.y;
         if(var2.vmethod2276(2, var4, var5, var3)) {
            class146.field2005 = var4;
            class118.field1827 = var5;
            return true;
         }

         int var19 = class118.field1826[var15][var16] + 1;
         if(var15 > 0 && class118.field1834[var15 - 1][var16] == 0 && (var14[var17 - 1][var18] & 19136782) == 0 && (var14[var17 - 1][1 + var18] & 19136824) == 0) {
            class118.field1828[var13] = var4 - 1;
            class118.field1829[var13] = var5;
            var13 = 1 + var13 & 4095;
            class118.field1834[var15 - 1][var16] = 2;
            class118.field1826[var15 - 1][var16] = var19;
         }

         if(var15 < 126 && class118.field1834[1 + var15][var16] == 0 && (var14[var17 + 2][var18] & 19136899) == 0 && (var14[var17 + 2][var18 + 1] & 19136992) == 0) {
            class118.field1828[var13] = var4 + 1;
            class118.field1829[var13] = var5;
            var13 = var13 + 1 & 4095;
            class118.field1834[var15 + 1][var16] = 8;
            class118.field1826[1 + var15][var16] = var19;
         }

         if(var16 > 0 && class118.field1834[var15][var16 - 1] == 0 && (var14[var17][var18 - 1] & 19136782) == 0 && (var14[1 + var17][var18 - 1] & 19136899) == 0) {
            class118.field1828[var13] = var4;
            class118.field1829[var13] = var5 - 1;
            var13 = var13 + 1 & 4095;
            class118.field1834[var15][var16 - 1] = 1;
            class118.field1826[var15][var16 - 1] = var19;
         }

         if(var16 < 126 && class118.field1834[var15][1 + var16] == 0 && (var14[var17][2 + var18] & 19136824) == 0 && (var14[1 + var17][var18 + 2] & 19136992) == 0) {
            class118.field1828[var13] = var4;
            class118.field1829[var13] = var5 + 1;
            var13 = 1 + var13 & 4095;
            class118.field1834[var15][var16 + 1] = 4;
            class118.field1826[var15][var16 + 1] = var19;
         }

         if(var15 > 0 && var16 > 0 && class118.field1834[var15 - 1][var16 - 1] == 0 && (var14[var17 - 1][var18] & 19136830) == 0 && (var14[var17 - 1][var18 - 1] & 19136782) == 0 && (var14[var17][var18 - 1] & 19136911) == 0) {
            class118.field1828[var13] = var4 - 1;
            class118.field1829[var13] = var5 - 1;
            var13 = var13 + 1 & 4095;
            class118.field1834[var15 - 1][var16 - 1] = 3;
            class118.field1826[var15 - 1][var16 - 1] = var19;
         }

         if(var15 < 126 && var16 > 0 && class118.field1834[var15 + 1][var16 - 1] == 0 && (var14[var17 + 1][var18 - 1] & 19136911) == 0 && (var14[var17 + 2][var18 - 1] & 19136899) == 0 && (var14[2 + var17][var18] & 19136995) == 0) {
            class118.field1828[var13] = 1 + var4;
            class118.field1829[var13] = var5 - 1;
            var13 = var13 + 1 & 4095;
            class118.field1834[var15 + 1][var16 - 1] = 9;
            class118.field1826[var15 + 1][var16 - 1] = var19;
         }

         if(var15 > 0 && var16 < 126 && class118.field1834[var15 - 1][1 + var16] == 0 && (var14[var17 - 1][var18 + 1] & 19136830) == 0 && (var14[var17 - 1][var18 + 2] & 19136824) == 0 && (var14[var17][var18 + 2] & 19137016) == 0) {
            class118.field1828[var13] = var4 - 1;
            class118.field1829[var13] = 1 + var5;
            var13 = var13 + 1 & 4095;
            class118.field1834[var15 - 1][1 + var16] = 6;
            class118.field1826[var15 - 1][var16 + 1] = var19;
         }

         if(var15 < 126 && var16 < 126 && class118.field1834[1 + var15][var16 + 1] == 0 && (var14[1 + var17][2 + var18] & 19137016) == 0 && (var14[var17 + 2][var18 + 2] & 19136992) == 0 && (var14[var17 + 2][var18 + 1] & 19136995) == 0) {
            class118.field1828[var13] = var4 + 1;
            class118.field1829[var13] = 1 + var5;
            var13 = 1 + var13 & 4095;
            class118.field1834[1 + var15][var16 + 1] = 12;
            class118.field1826[1 + var15][1 + var16] = var19;
         }
      }

      class146.field2005 = var4;
      class118.field1827 = var5;
      return false;
   }
}

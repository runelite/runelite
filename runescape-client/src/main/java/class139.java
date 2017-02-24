import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
public class class139 extends class68 {
   @ObfuscatedName("m")
   int[] field1923 = new int[16];
   @ObfuscatedName("q")
   XHashTable field1924 = new XHashTable(128);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1631781237
   )
   int field1925 = 1000000;
   @ObfuscatedName("p")
   int[] field1926 = new int[16];
   @ObfuscatedName("j")
   int[] field1927 = new int[16];
   @ObfuscatedName("n")
   int[] field1928 = new int[16];
   @ObfuscatedName("r")
   int[] field1929 = new int[16];
   @ObfuscatedName("c")
   int[] field1930 = new int[16];
   @ObfuscatedName("e")
   class140[][] field1931 = new class140[16][128];
   @ObfuscatedName("o")
   int[] field1932 = new int[16];
   @ObfuscatedName("i")
   int[] field1933 = new int[16];
   @ObfuscatedName("k")
   int[] field1934 = new int[16];
   @ObfuscatedName("g")
   int[] field1935 = new int[16];
   @ObfuscatedName("a")
   int[] field1936 = new int[16];
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1313760673
   )
   int field1937 = 256;
   @ObfuscatedName("l")
   int[] field1938 = new int[16];
   @ObfuscatedName("x")
   int[] field1939 = new int[16];
   @ObfuscatedName("s")
   int[] field1940 = new int[16];
   @ObfuscatedName("w")
   int[] field1941 = new int[16];
   @ObfuscatedName("ae")
   class140[][] field1942 = new class140[16][128];
   @ObfuscatedName("aq")
   class141 field1943 = new class141();
   @ObfuscatedName("at")
   boolean field1944;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -571897553
   )
   int field1945;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -795633313
   )
   int field1946;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      longValue = 388903160409010085L
   )
   long field1947;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      longValue = -5959980426562429667L
   )
   long field1948;
   @ObfuscatedName("ac")
   class143 field1949 = new class143(this);

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "619438434"
   )
   public synchronized void method2547(int var1) {
      this.field1937 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1546258071"
   )
   public int method2548() {
      return this.field1937;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-63016673"
   )
   void method2549(int var1, int var2) {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1084928079"
   )
   public synchronized void method2550() {
      for(class142 var1 = (class142)this.field1924.method2403(); var1 != null; var1 = (class142)this.field1924.method2411()) {
         var1.method2712();
      }

   }

   public class139() {
      this.method2640();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1025520128"
   )
   public synchronized void method2554(int var1, int var2) {
      this.method2633(var1, var2);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-91"
   )
   void method2556(int var1, int var2) {
      if(var2 != this.field1930[var1]) {
         this.field1930[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field1942[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass140;ZI)V",
      garbageValue = "1722235016"
   )
   void method2558(class140 var1, boolean var2) {
      int var3 = var1.field1953.field1044.length;
      int var4;
      if(var2 && var1.field1953.field1047) {
         int var5 = var3 + var3 - var1.field1953.field1046;
         var4 = (int)((long)var5 * (long)this.field1938[var1.field1967] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field1975.method1245();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field1938[var1.field1967] >> 6);
      }

      var1.field1975.method1244(var4);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIS)V",
      garbageValue = "10071"
   )
   void method2559(int var1, int var2, int var3) {
      class140 var4 = this.field1931[var1][var2];
      if(null != var4) {
         this.field1931[var1][var2] = null;
         if((this.field1941[var1] & 2) != 0) {
            for(class140 var5 = (class140)this.field1949.field2004.method2458(); null != var5; var5 = (class140)this.field1949.field2004.method2472()) {
               if(var4.field1967 == var5.field1967 && var5.field1965 < 0 && var4 != var5) {
                  var4.field1965 = 0;
                  break;
               }
            }
         } else {
            var4.field1965 = 0;
         }

      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-953494869"
   )
   void method2560(int var1, int var2, int var3) {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-68"
   )
   void method2562(int var1, int var2) {
      this.field1932[var1] = var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1360586050"
   )
   void method2563(int var1) {
      for(class140 var2 = (class140)this.field1949.field2004.method2458(); var2 != null; var2 = (class140)this.field1949.field2004.method2472()) {
         if(var1 < 0 || var2.field1967 == var1) {
            if(null != var2.field1975) {
               var2.field1975.method1316(class57.field1061 / 100);
               if(var2.field1975.method1253()) {
                  this.field1949.field2005.method985(var2.field1975);
               }

               var2.method2663();
            }

            if(var2.field1965 < 0) {
               this.field1931[var2.field1967][var2.field1955] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "37"
   )
   void method2564(int var1) {
      if(var1 >= 0) {
         this.field1926[var1] = 12800;
         this.field1927[var1] = 8192;
         this.field1928[var1] = 16383;
         this.field1932[var1] = 8192;
         this.field1923[var1] = 0;
         this.field1940[var1] = 8192;
         this.method2631(var1);
         this.method2568(var1);
         this.field1941[var1] = 0;
         this.field1936[var1] = 32767;
         this.field1934[var1] = 256;
         this.field1938[var1] = 0;
         this.method2578(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method2564(var1);
         }

      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "10"
   )
   void method2565(int var1) {
      for(class140 var2 = (class140)this.field1949.field2004.method2458(); var2 != null; var2 = (class140)this.field1949.field2004.method2472()) {
         if((var1 < 0 || var1 == var2.field1967) && var2.field1965 < 0) {
            this.field1931[var2.field1967][var2.field1955] = null;
            var2.field1965 = 0;
         }
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)Z",
      garbageValue = "1154738261"
   )
   boolean method2566(class140 var1) {
      if(null == var1.field1975) {
         if(var1.field1965 >= 0) {
            var1.unlink();
            if(var1.field1969 > 0 && var1 == this.field1942[var1.field1967][var1.field1969]) {
               this.field1942[var1.field1967][var1.field1969] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1053991070"
   )
   void method2568(int var1) {
      if((this.field1941[var1] & 4) != 0) {
         for(class140 var2 = (class140)this.field1949.field2004.method2458(); null != var2; var2 = (class140)this.field1949.field2004.method2472()) {
            if(var1 == var2.field1967) {
               var2.field1971 = 0;
            }
         }
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-76"
   )
   void method2569(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method2559(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method2641(var3, var4, var5);
         } else {
            this.method2559(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method2560(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field1933[var3] = (this.field1933[var3] & -2080769) + (var5 << 14);
         }

         if(var4 == 32) {
            this.field1933[var3] = (var5 << 7) + (this.field1933[var3] & -16257);
         }

         if(var4 == 1) {
            this.field1923[var3] = (var5 << 7) + (this.field1923[var3] & -16257);
         }

         if(var4 == 33) {
            this.field1923[var3] = var5 + (this.field1923[var3] & -128);
         }

         if(var4 == 5) {
            this.field1940[var3] = (this.field1940[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 37) {
            this.field1940[var3] = var5 + (this.field1940[var3] & -128);
         }

         if(var4 == 7) {
            this.field1926[var3] = (var5 << 7) + (this.field1926[var3] & -16257);
         }

         if(var4 == 39) {
            this.field1926[var3] = (this.field1926[var3] & -128) + var5;
         }

         if(var4 == 10) {
            this.field1927[var3] = (this.field1927[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 42) {
            this.field1927[var3] = var5 + (this.field1927[var3] & -128);
         }

         if(var4 == 11) {
            this.field1928[var3] = (var5 << 7) + (this.field1928[var3] & -16257);
         }

         if(var4 == 43) {
            this.field1928[var3] = var5 + (this.field1928[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field1941[var3] |= 1;
            } else {
               this.field1941[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field1941[var3] |= 2;
            } else {
               this.method2631(var3);
               this.field1941[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field1936[var3] = (this.field1936[var3] & 127) + (var5 << 7);
         }

         if(var4 == 98) {
            this.field1936[var3] = (this.field1936[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field1936[var3] = (var5 << 7) + (this.field1936[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field1936[var3] = var5 + 16384 + (this.field1936[var3] & 16256);
         }

         if(var4 == 120) {
            this.method2563(var3);
         }

         if(var4 == 121) {
            this.method2564(var3);
         }

         if(var4 == 123) {
            this.method2565(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field1936[var3];
            if(var6 == 16384) {
               this.field1934[var3] = (this.field1934[var3] & -16257) + (var5 << 7);
            }
         }

         if(var4 == 38) {
            var6 = this.field1936[var3];
            if(var6 == 16384) {
               this.field1934[var3] = var5 + (this.field1934[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field1938[var3] = (var5 << 7) + (this.field1938[var3] & -16257);
         }

         if(var4 == 48) {
            this.field1938[var3] = var5 + (this.field1938[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field1941[var3] |= 4;
            } else {
               this.method2568(var3);
               this.field1941[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method2578(var3, (this.field1939[var3] & -16257) + (var5 << 7));
         }

         if(var4 == 49) {
            this.method2578(var3, var5 + (this.field1939[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method2556(var3, this.field1933[var3] + var4);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method2549(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 9 & 16256) + (var1 >> 8 & 127);
         this.method2562(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method2640();
         }
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)I",
      garbageValue = "-163569531"
   )
   int method2572(class140 var1) {
      class137 var2 = var1.field1954;
      int var3 = this.field1926[var1.field1967] * this.field1928[var1.field1967] + 4096 >> 13;
      var3 = 16384 + var3 * var3 >> 15;
      var3 = var3 * var1.field1957 + 16384 >> 15;
      var3 = 128 + this.field1937 * var3 >> 8;
      if(var2.field1912 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, 1.953125E-5D * (double)var1.field1962 * (double)var2.field1912) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(null != var2.field1903) {
         var4 = var1.field1963;
         var5 = var2.field1903[var1.field1970 + 1];
         if(var1.field1970 < var2.field1903.length - 2) {
            var6 = (var2.field1903[var1.field1970] & 255) << 8;
            var7 = (var2.field1903[2 + var1.field1970] & 255) << 8;
            var5 += (var4 - var6) * (var2.field1903[var1.field1970 + 3] - var5) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      if(var1.field1965 > 0 && var2.field1902 != null) {
         var4 = var1.field1965;
         var5 = var2.field1902[1 + var1.field1966];
         if(var1.field1966 < var2.field1902.length - 2) {
            var6 = (var2.field1902[var1.field1966] & 255) << 8;
            var7 = (var2.field1902[var1.field1966 + 2] & 255) << 8;
            var5 += (var2.field1902[var1.field1966 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("n")
   protected synchronized class68 vmethod2734() {
      return this.field1949;
   }

   @ObfuscatedName("c")
   protected synchronized class68 vmethod2717() {
      return null;
   }

   @ObfuscatedName("o")
   protected synchronized int vmethod2716() {
      return 0;
   }

   @ObfuscatedName("s")
   protected synchronized void vmethod2718(int[] var1, int var2, int var3) {
      if(this.field1943.method2689()) {
         int var4 = this.field1925 * this.field1943.field1977 / class57.field1061;

         do {
            long var5 = (long)var3 * (long)var4 + this.field1947;
            if(this.field1948 - var5 >= 0L) {
               this.field1947 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field1948 - this.field1947) - 1L) / (long)var4);
            this.field1947 += (long)var4 * (long)var7;
            this.field1949.vmethod2718(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method2595();
         } while(this.field1943.method2689());
      }

      this.field1949.vmethod2718(var1, var2, var3);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "302809543"
   )
   void method2578(int var1, int var2) {
      this.field1939[var1] = var2;
      this.field1935[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Lclass140;[IIII)Z",
      garbageValue = "-885136795"
   )
   boolean method2581(class140 var1, int[] var2, int var3, int var4) {
      var1.field1952 = class57.field1061 / 100;
      if(var1.field1965 < 0 || var1.field1975 != null && !var1.field1975.method1329()) {
         int var5 = var1.field1961;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field1940[var1.field1967] * 4.921259842519685E-4D) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field1961 = var5;
         }

         var1.field1975.method1250(this.method2606(var1));
         class137 var6 = var1.field1954;
         boolean var7 = false;
         ++var1.field1964;
         var1.field1968 += var6.field1910;
         double var8 = 5.086263020833333E-6D * (double)((var1.field1955 - 60 << 8) + (var1.field1961 * var1.field1960 >> 12));
         if(var6.field1912 > 0) {
            if(var6.field1906 > 0) {
               var1.field1962 += (int)(128.0D * Math.pow(2.0D, (double)var6.field1906 * var8) + 0.5D);
            } else {
               var1.field1962 += 128;
            }
         }

         if(var6.field1903 != null) {
            if(var6.field1901 > 0) {
               var1.field1963 += (int)(128.0D * Math.pow(2.0D, (double)var6.field1901 * var8) + 0.5D);
            } else {
               var1.field1963 += 128;
            }

            while(var1.field1970 < var6.field1903.length - 2 && var1.field1963 > (var6.field1903[2 + var1.field1970] & 255) << 8) {
               var1.field1970 += 2;
            }

            if(var1.field1970 == var6.field1903.length - 2 && var6.field1903[1 + var1.field1970] == 0) {
               var7 = true;
            }
         }

         if(var1.field1965 >= 0 && var6.field1902 != null && (this.field1941[var1.field1967] & 1) == 0 && (var1.field1969 < 0 || var1 != this.field1942[var1.field1967][var1.field1969])) {
            if(var6.field1905 > 0) {
               var1.field1965 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field1905) + 0.5D);
            } else {
               var1.field1965 += 128;
            }

            while(var1.field1966 < var6.field1902.length - 2 && var1.field1965 > (var6.field1902[2 + var1.field1966] & 255) << 8) {
               var1.field1966 += 2;
            }

            if(var1.field1966 == var6.field1902.length - 2) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field1975.method1316(var1.field1952);
            if(var2 != null) {
               var1.field1975.vmethod2718(var2, var3, var4);
            } else {
               var1.field1975.vmethod2719(var4);
            }

            if(var1.field1975.method1253()) {
               this.field1949.field2005.method985(var1.field1975);
            }

            var1.method2663();
            if(var1.field1965 >= 0) {
               var1.unlink();
               if(var1.field1969 > 0 && this.field1942[var1.field1967][var1.field1969] == var1) {
                  this.field1942[var1.field1967][var1.field1969] = null;
               }
            }

            return true;
         } else {
            var1.field1975.method1248(var1.field1952, this.method2572(var1), this.method2598(var1));
            return false;
         }
      } else {
         var1.method2663();
         var1.unlink();
         if(var1.field1969 > 0 && var1 == this.field1942[var1.field1967][var1.field1969]) {
            this.field1942[var1.field1967][var1.field1969] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass144;ZI)V",
      garbageValue = "1192078495"
   )
   public synchronized void method2582(class144 var1, boolean var2) {
      this.method2620();
      this.field1943.method2670(var1.field2007);
      this.field1944 = var2;
      this.field1947 = 0L;
      int var3 = this.field1943.method2673();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field1943.method2674(var4);
         this.field1943.method2677(var4);
         this.field1943.method2675(var4);
      }

      this.field1945 = this.field1943.method2682();
      this.field1946 = this.field1943.field1980[this.field1945];
      this.field1948 = this.field1943.method2696(this.field1946);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1596738365"
   )
   void method2595() {
      int var1 = this.field1945;
      int var2 = this.field1946;

      long var3;
      for(var3 = this.field1948; var2 == this.field1946; var3 = this.field1943.method2696(var2)) {
         while(var2 == this.field1943.field1980[var1]) {
            this.field1943.method2674(var1);
            int var5 = this.field1943.method2695(var1);
            if(var5 == 1) {
               this.field1943.method2681();
               this.field1943.method2675(var1);
               if(this.field1943.method2669()) {
                  if(!this.field1944 || var2 == 0) {
                     this.method2640();
                     this.field1943.method2671();
                     return;
                  }

                  this.field1943.method2703(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method2569(var5);
            }

            this.field1943.method2677(var1);
            this.field1943.method2675(var1);
         }

         var1 = this.field1943.method2682();
         var2 = this.field1943.field1980[var1];
      }

      this.field1945 = var1;
      this.field1946 = var2;
      this.field1948 = var3;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Lclass140;B)I",
      garbageValue = "45"
   )
   int method2598(class140 var1) {
      int var2 = this.field1927[var1.field1967];
      return var2 < 8192?32 + var1.field1958 * var2 >> 6:16384 - ((128 - var1.field1958) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)I",
      garbageValue = "-1369515918"
   )
   int method2606(class140 var1) {
      int var2 = (var1.field1961 * var1.field1960 >> 12) + var1.field1959;
      var2 += this.field1934[var1.field1967] * (this.field1932[var1.field1967] - 8192) >> 12;
      class137 var3 = var1.field1954;
      int var4;
      if(var3.field1910 > 0 && (var3.field1907 > 0 || this.field1923[var1.field1967] > 0)) {
         var4 = var3.field1907 << 2;
         int var5 = var3.field1908 << 1;
         if(var1.field1964 < var5) {
            var4 = var4 * var1.field1964 / var5;
         }

         var4 += this.field1923[var1.field1967] >> 7;
         double var6 = Math.sin((double)(var1.field1968 & 511) * 0.01227184630308513D);
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(var1.field1953.field1045 * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)class57.field1061 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1514098865"
   )
   public synchronized boolean method2607() {
      return this.field1943.method2689();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-6"
   )
   public synchronized void method2620() {
      this.field1943.method2671();
      this.method2640();
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2055361386"
   )
   void method2631(int var1) {
      if((this.field1941[var1] & 2) != 0) {
         for(class140 var2 = (class140)this.field1949.field2004.method2458(); var2 != null; var2 = (class140)this.field1949.field2004.method2472()) {
            if(var2.field1967 == var1 && this.field1931[var1][var2.field1955] == null && var2.field1965 < 0) {
               var2.field1965 = 0;
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "81"
   )
   void method2633(int var1, int var2) {
      this.field1929[var1] = var2;
      this.field1933[var1] = var2 & -128;
      this.method2556(var1, var2);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1645868763"
   )
   void method2640() {
      this.method2563(-1);
      this.method2564(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field1930[var1] = this.field1929[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field1933[var1] = this.field1929[var1] & -128;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "99"
   )
   void method2641(int var1, int var2, int var3) {
      this.method2559(var1, var2, 64);
      if((this.field1941[var1] & 2) != 0) {
         for(class140 var4 = (class140)this.field1949.field2004.method2471(); null != var4; var4 = (class140)this.field1949.field2004.method2461()) {
            if(var4.field1967 == var1 && var4.field1965 < 0) {
               this.field1931[var1][var4.field1955] = null;
               this.field1931[var1][var2] = var4;
               int var8 = (var4.field1960 * var4.field1961 >> 12) + var4.field1959;
               var4.field1959 += var2 - var4.field1955 << 8;
               var4.field1960 = var8 - var4.field1959;
               var4.field1961 = 4096;
               var4.field1955 = var2;
               return;
            }
         }
      }

      class142 var9 = (class142)this.field1924.method2399((long)this.field1930[var1]);
      if(null != var9) {
         class55 var5 = var9.field1991[var2];
         if(null != var5) {
            class140 var6 = new class140();
            var6.field1967 = var1;
            var6.field1973 = var9;
            var6.field1953 = var5;
            var6.field1954 = var9.field1995[var2];
            var6.field1969 = var9.field1996[var2];
            var6.field1955 = var2;
            var6.field1957 = 1024 + var3 * var3 * var9.field2000 * var9.field1993[var2] >> 11;
            var6.field1958 = var9.field1994[var2] & 255;
            var6.field1959 = (var2 << 8) - (var9.field1992[var2] & 32767);
            var6.field1962 = 0;
            var6.field1963 = 0;
            var6.field1970 = 0;
            var6.field1965 = -1;
            var6.field1966 = 0;
            if(this.field1938[var1] == 0) {
               var6.field1975 = class66.method1236(var5, this.method2606(var6), this.method2572(var6), this.method2598(var6));
            } else {
               var6.field1975 = class66.method1236(var5, this.method2606(var6), 0, this.method2598(var6));
               this.method2558(var6, var9.field1992[var2] < 0);
            }

            if(var9.field1992[var2] < 0) {
               var6.field1975.method1243(-1);
            }

            if(var6.field1969 >= 0) {
               class140 var7 = this.field1942[var1][var6.field1969];
               if(null != var7 && var7.field1965 < 0) {
                  this.field1931[var1][var7.field1955] = null;
                  var7.field1965 = 0;
               }

               this.field1942[var1][var6.field1969] = var6;
            }

            this.field1949.field2004.method2453(var6);
            this.field1931[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1310995210"
   )
   public synchronized void method2643() {
      for(class142 var1 = (class142)this.field1924.method2403(); var1 != null; var1 = (class142)this.field1924.method2411()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass144;Lclass182;Lclass60;II)Z",
      garbageValue = "-1726459407"
   )
   public synchronized boolean method2644(class144 var1, class182 var2, class60 var3, int var4) {
      var1.method2741();
      boolean var5 = true;
      Object var6 = null;
      int[] var12 = new int[]{var4};

      for(class134 var7 = (class134)var1.field2008.method2403(); null != var7; var7 = (class134)var1.field2008.method2411()) {
         int var8 = (int)var7.hash;
         class142 var9 = (class142)this.field1924.method2399((long)var8);
         if(var9 == null) {
            byte[] var11 = var2.method3308(var8);
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

            this.field1924.method2400(var10, (long)var8);
         }

         if(!var9.method2711(var3, var7.field1896, var12)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method2742();
      }

      return var5;
   }

   @ObfuscatedName("b")
   protected synchronized void vmethod2719(int var1) {
      if(this.field1943.method2689()) {
         int var2 = this.field1925 * this.field1943.field1977 / class57.field1061;

         do {
            long var3 = (long)var1 * (long)var2 + this.field1947;
            if(this.field1948 - var3 >= 0L) {
               this.field1947 = var3;
               break;
            }

            int var5 = (int)((this.field1948 - this.field1947 + (long)var2 - 1L) / (long)var2);
            this.field1947 += (long)var2 * (long)var5;
            this.field1949.vmethod2719(var5);
            var1 -= var5;
            this.method2595();
         } while(this.field1943.method2689());
      }

      this.field1949.vmethod2719(var1);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1364593423"
   )
   static final boolean method2660(int var0, int var1) {
      ObjectComposition var2 = class187.getObjectDefinition(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method3620(var1);
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(III)Lclass119;",
      garbageValue = "1857227972"
   )
   static class119 method2661(int var0, int var1) {
      Client.field585.field1857 = var0;
      Client.field585.field1852 = var1;
      Client.field585.field1854 = 1;
      Client.field585.field1855 = 1;
      return Client.field585;
   }
}

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
public class class139 extends class68 {
   @ObfuscatedName("ap")
   class140[][] field1921 = new class140[16][128];
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      longValue = -6191644642559857877L
   )
   long field1922;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 934606671
   )
   int field1923 = 1000000;
   @ObfuscatedName("t")
   int[] field1924 = new int[16];
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      longValue = 1688260585327643513L
   )
   long field1925;
   @ObfuscatedName("h")
   int[] field1926 = new int[16];
   @ObfuscatedName("n")
   int[] field1927 = new int[16];
   @ObfuscatedName("f")
   int[] field1928 = new int[16];
   @ObfuscatedName("k")
   int[] field1929 = new int[16];
   @ObfuscatedName("r")
   int[] field1930 = new int[16];
   @ObfuscatedName("x")
   int[] field1931 = new int[16];
   @ObfuscatedName("z")
   int[] field1932 = new int[16];
   @ObfuscatedName("q")
   int[] field1933 = new int[16];
   @ObfuscatedName("c")
   int[] field1934 = new int[16];
   @ObfuscatedName("v")
   int[] field1935 = new int[16];
   @ObfuscatedName("e")
   int[] field1936 = new int[16];
   @ObfuscatedName("j")
   int[] field1937 = new int[16];
   @ObfuscatedName("d")
   int[] field1938 = new int[16];
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1255783941
   )
   int field1939;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1283031599
   )
   int field1940 = 256;
   @ObfuscatedName("aj")
   class141 field1941 = new class141();
   @ObfuscatedName("ab")
   boolean field1942;
   @ObfuscatedName("ae")
   class143 field1943 = new class143(this);
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1313677239
   )
   int field1944;
   @ObfuscatedName("g")
   class140[][] field1945 = new class140[16][128];
   @ObfuscatedName("b")
   XHashTable field1946 = new XHashTable(128);
   @ObfuscatedName("a")
   int[] field1947 = new int[16];

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1531616893"
   )
   public synchronized void method2558(int var1) {
      this.field1940 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass144;Lclass182;Lclass60;II)Z",
      garbageValue = "-1970569584"
   )
   public synchronized boolean method2560(class144 var1, class182 var2, class60 var3, int var4) {
      var1.method2765();
      boolean var5 = true;
      Object var6 = null;
      int[] var10 = new int[]{var4};

      for(class134 var7 = (class134)var1.field2005.method2423(); var7 != null; var7 = (class134)var1.field2005.method2424()) {
         int var8 = (int)var7.hash;
         class142 var9 = (class142)this.field1946.method2428((long)var8);
         if(null == var9) {
            var9 = class39.method812(var2, var8);
            if(null == var9) {
               var5 = false;
               continue;
            }

            this.field1946.method2425(var9, (long)var8);
         }

         if(!var9.method2733(var3, var7.field1892, var10)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method2766();
      }

      return var5;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "99"
   )
   int method2561() {
      return this.field1940;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "847290506"
   )
   public synchronized boolean method2565() {
      return this.field1941.method2688();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-1"
   )
   public synchronized void method2566(int var1, int var2) {
      this.method2602(var1, var2);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-28"
   )
   void method2569(int var1, int var2, int var3) {
      this.method2571(var1, var2, 64);
      if((this.field1933[var1] & 2) != 0) {
         for(class140 var4 = (class140)this.field1943.field1998.method2476(); null != var4; var4 = (class140)this.field1943.field1998.method2475()) {
            if(var4.field1966 == var1 && var4.field1963 < 0) {
               this.field1945[var1][var4.field1951] = null;
               this.field1945[var1][var2] = var4;
               int var8 = var4.field1953 + (var4.field1959 * var4.field1958 >> 12);
               var4.field1953 += var2 - var4.field1951 << 8;
               var4.field1958 = var8 - var4.field1953;
               var4.field1959 = 4096;
               var4.field1951 = var2;
               return;
            }
         }
      }

      class142 var9 = (class142)this.field1946.method2428((long)this.field1928[var1]);
      if(null != var9) {
         class55 var5 = var9.field1985[var2];
         if(null != var5) {
            class140 var6 = new class140();
            var6.field1966 = var1;
            var6.field1957 = var9;
            var6.field1954 = var5;
            var6.field1952 = var9.field1989[var2];
            var6.field1949 = var9.field1990[var2];
            var6.field1951 = var2;
            var6.field1950 = var9.field1987[var2] * var9.field1992 * var3 * var3 + 1024 >> 11;
            var6.field1956 = var9.field1988[var2] & 255;
            var6.field1953 = (var2 << 8) - (var9.field1991[var2] & 32767);
            var6.field1960 = 0;
            var6.field1961 = 0;
            var6.field1962 = 0;
            var6.field1963 = -1;
            var6.field1964 = 0;
            if(this.field1936[var1] == 0) {
               var6.field1955 = class66.method1237(var5, this.method2583(var6), this.method2624(var6), this.method2584(var6));
            } else {
               var6.field1955 = class66.method1237(var5, this.method2583(var6), 0, this.method2584(var6));
               this.method2570(var6, var9.field1991[var2] < 0);
            }

            if(var9.field1991[var2] < 0) {
               var6.field1955.method1239(-1);
            }

            if(var6.field1949 >= 0) {
               class140 var7 = this.field1921[var1][var6.field1949];
               if(var7 != null && var7.field1963 < 0) {
                  this.field1945[var1][var7.field1951] = null;
                  var7.field1963 = 0;
               }

               this.field1921[var1][var6.field1949] = var6;
            }

            this.field1943.field1998.method2468(var6);
            this.field1945[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass140;ZI)V",
      garbageValue = "-1527701400"
   )
   void method2570(class140 var1, boolean var2) {
      int var3 = var1.field1954.field1009.length;
      int var4;
      if(var2 && var1.field1954.field1012) {
         int var5 = var3 + var3 - var1.field1954.field1010;
         var4 = (int)((long)var5 * (long)this.field1936[var1.field1966] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field1955.method1246();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field1936[var1.field1966] >> 6);
      }

      var1.field1955.method1247(var4);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-14414363"
   )
   void method2571(int var1, int var2, int var3) {
      class140 var4 = this.field1945[var1][var2];
      if(null != var4) {
         this.field1945[var1][var2] = null;
         if((this.field1933[var1] & 2) != 0) {
            for(class140 var5 = (class140)this.field1943.field1998.method2472(); null != var5; var5 = (class140)this.field1943.field1998.method2479()) {
               if(var4.field1966 == var5.field1966 && var5.field1963 < 0 && var4 != var5) {
                  var4.field1963 = 0;
                  break;
               }
            }
         } else {
            var4.field1963 = 0;
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "24"
   )
   void method2572(int var1, int var2, int var3) {
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public synchronized void method2573() {
      for(class142 var1 = (class142)this.field1946.method2423(); var1 != null; var1 = (class142)this.field1946.method2424()) {
         var1.method2734();
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1202234668"
   )
   void method2574(int var1, int var2) {
      this.field1930[var1] = var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1517737134"
   )
   void method2575(int var1, int var2) {
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-83"
   )
   void method2577(int var1) {
      for(class140 var2 = (class140)this.field1943.field1998.method2472(); var2 != null; var2 = (class140)this.field1943.field1998.method2479()) {
         if((var1 < 0 || var1 == var2.field1966) && var2.field1963 < 0) {
            this.field1945[var2.field1966][var2.field1951] = null;
            var2.field1963 = 0;
         }
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1595485888"
   )
   void method2578() {
      this.method2665(-1);
      this.method2617(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field1928[var1] = this.field1927[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field1947[var1] = this.field1927[var1] & -128;
      }

   }

   @ObfuscatedName("z")
   protected synchronized class68 vmethod2746() {
      return null;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "395340055"
   )
   void method2580(int var1) {
      if((this.field1933[var1] & 4) != 0) {
         for(class140 var2 = (class140)this.field1943.field1998.method2472(); null != var2; var2 = (class140)this.field1943.field1998.method2479()) {
            if(var2.field1966 == var1) {
               var2.field1969 = 0;
            }
         }
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1135881238"
   )
   void method2581(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method2571(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method2569(var3, var4, var5);
         } else {
            this.method2571(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method2572(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field1947[var3] = (var5 << 14) + (this.field1947[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field1947[var3] = (this.field1947[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 1) {
            this.field1931[var3] = (this.field1931[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 33) {
            this.field1931[var3] = (this.field1931[var3] & -128) + var5;
         }

         if(var4 == 5) {
            this.field1932[var3] = (this.field1932[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 37) {
            this.field1932[var3] = (this.field1932[var3] & -128) + var5;
         }

         if(var4 == 7) {
            this.field1924[var3] = (this.field1924[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 39) {
            this.field1924[var3] = var5 + (this.field1924[var3] & -128);
         }

         if(var4 == 10) {
            this.field1929[var3] = (this.field1929[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 42) {
            this.field1929[var3] = (this.field1929[var3] & -128) + var5;
         }

         if(var4 == 11) {
            this.field1926[var3] = (var5 << 7) + (this.field1926[var3] & -16257);
         }

         if(var4 == 43) {
            this.field1926[var3] = var5 + (this.field1926[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field1933[var3] |= 1;
            } else {
               this.field1933[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field1933[var3] |= 2;
            } else {
               this.method2627(var3);
               this.field1933[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field1934[var3] = (var5 << 7) + (this.field1934[var3] & 127);
         }

         if(var4 == 98) {
            this.field1934[var3] = (this.field1934[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field1934[var3] = (var5 << 7) + 16384 + (this.field1934[var3] & 127);
         }

         if(var4 == 100) {
            this.field1934[var3] = 16384 + (this.field1934[var3] & 16256) + var5;
         }

         if(var4 == 120) {
            this.method2665(var3);
         }

         if(var4 == 121) {
            this.method2617(var3);
         }

         if(var4 == 123) {
            this.method2577(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field1934[var3];
            if(var6 == 16384) {
               this.field1935[var3] = (var5 << 7) + (this.field1935[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field1934[var3];
            if(var6 == 16384) {
               this.field1935[var3] = (this.field1935[var3] & -128) + var5;
            }
         }

         if(var4 == 16) {
            this.field1936[var3] = (var5 << 7) + (this.field1936[var3] & -16257);
         }

         if(var4 == 48) {
            this.field1936[var3] = var5 + (this.field1936[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field1933[var3] |= 4;
            } else {
               this.method2580(var3);
               this.field1933[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method2582(var3, (this.field1937[var3] & -16257) + (var5 << 7));
         }

         if(var4 == 49) {
            this.method2582(var3, var5 + (this.field1937[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method2666(var3, var4 + this.field1947[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method2575(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 9 & 16256) + (var1 >> 8 & 127);
         this.method2574(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method2578();
         }
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2089928300"
   )
   void method2582(int var1, int var2) {
      this.field1937[var1] = var2;
      this.field1938[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)I",
      garbageValue = "1902694207"
   )
   int method2583(class140 var1) {
      int var2 = (var1.field1958 * var1.field1959 >> 12) + var1.field1953;
      var2 += this.field1935[var1.field1966] * (this.field1930[var1.field1966] - 8192) >> 12;
      class137 var3 = var1.field1952;
      int var4;
      if(var3.field1904 > 0 && (var3.field1907 > 0 || this.field1931[var1.field1966] > 0)) {
         var4 = var3.field1907 << 2;
         int var5 = var3.field1905 << 1;
         if(var1.field1965 < var5) {
            var4 = var4 * var1.field1965 / var5;
         }

         var4 += this.field1931[var1.field1966] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field1967 & 511));
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(var1.field1954.field1011 * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)class202.field3079 + 0.5D);
      return var4 < 1?1:var4;
   }

   public class139() {
      this.method2578();
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)I",
      garbageValue = "-859751405"
   )
   int method2584(class140 var1) {
      int var2 = this.field1929[var1.field1966];
      return var2 < 8192?32 + var1.field1956 * var2 >> 6:16384 - (32 + (128 - var1.field1956) * (16384 - var2) >> 6);
   }

   @ObfuscatedName("x")
   protected synchronized class68 vmethod2744() {
      return this.field1943;
   }

   @ObfuscatedName("p")
   protected synchronized int vmethod2763() {
      return 0;
   }

   @ObfuscatedName("s")
   protected synchronized void vmethod2747(int[] var1, int var2, int var3) {
      if(this.field1941.method2688()) {
         int var4 = this.field1923 * this.field1941.field1974 / class202.field3079;

         do {
            long var5 = (long)var3 * (long)var4 + this.field1925;
            if(this.field1922 - var5 >= 0L) {
               this.field1925 = var5;
               break;
            }

            int var7 = (int)((this.field1922 - this.field1925 + (long)var4 - 1L) / (long)var4);
            this.field1925 += (long)var7 * (long)var4;
            this.field1943.vmethod2747(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method2661();
         } while(this.field1941.method2688());
      }

      this.field1943.vmethod2747(var1, var2, var3);
   }

   @ObfuscatedName("y")
   protected synchronized void vmethod2748(int var1) {
      if(this.field1941.method2688()) {
         int var2 = this.field1941.field1974 * this.field1923 / class202.field3079;

         do {
            long var3 = this.field1925 + (long)var2 * (long)var1;
            if(this.field1922 - var3 >= 0L) {
               this.field1925 = var3;
               break;
            }

            int var5 = (int)((this.field1922 - this.field1925 + (long)var2 - 1L) / (long)var2);
            this.field1925 += (long)var5 * (long)var2;
            this.field1943.vmethod2748(var5);
            var1 -= var5;
            this.method2661();
         } while(this.field1941.method2688());
      }

      this.field1943.vmethod2748(var1);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Lclass140;[IIII)Z",
      garbageValue = "238157166"
   )
   boolean method2592(class140 var1, int[] var2, int var3, int var4) {
      var1.field1968 = class202.field3079 / 100;
      if(var1.field1963 < 0 || null != var1.field1955 && !var1.field1955.method1253()) {
         int var5 = var1.field1959;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field1932[var1.field1966] * 4.921259842519685E-4D) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field1959 = var5;
         }

         var1.field1955.method1251(this.method2583(var1));
         class137 var6 = var1.field1952;
         boolean var7 = false;
         ++var1.field1965;
         var1.field1967 += var6.field1904;
         double var8 = 5.086263020833333E-6D * (double)((var1.field1958 * var1.field1959 >> 12) + (var1.field1951 - 60 << 8));
         if(var6.field1899 > 0) {
            if(var6.field1911 > 0) {
               var1.field1960 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field1911) + 0.5D);
            } else {
               var1.field1960 += 128;
            }
         }

         if(null != var6.field1902) {
            if(var6.field1900 > 0) {
               var1.field1961 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field1900) + 0.5D);
            } else {
               var1.field1961 += 128;
            }

            while(var1.field1962 < var6.field1902.length - 2 && var1.field1961 > (var6.field1902[2 + var1.field1962] & 255) << 8) {
               var1.field1962 += 2;
            }

            if(var6.field1902.length - 2 == var1.field1962 && var6.field1902[var1.field1962 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field1963 >= 0 && null != var6.field1898 && (this.field1933[var1.field1966] & 1) == 0 && (var1.field1949 < 0 || this.field1921[var1.field1966][var1.field1949] != var1)) {
            if(var6.field1901 > 0) {
               var1.field1963 += (int)(128.0D * Math.pow(2.0D, (double)var6.field1901 * var8) + 0.5D);
            } else {
               var1.field1963 += 128;
            }

            while(var1.field1964 < var6.field1898.length - 2 && var1.field1963 > (var6.field1898[var1.field1964 + 2] & 255) << 8) {
               var1.field1964 += 2;
            }

            if(var1.field1964 == var6.field1898.length - 2) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field1955.method1300(var1.field1968);
            if(null != var2) {
               var1.field1955.vmethod2747(var2, var3, var4);
            } else {
               var1.field1955.vmethod2748(var4);
            }

            if(var1.field1955.method1254()) {
               this.field1943.field1999.method993(var1.field1955);
            }

            var1.method2680();
            if(var1.field1963 >= 0) {
               var1.unlink();
               if(var1.field1949 > 0 && this.field1921[var1.field1966][var1.field1949] == var1) {
                  this.field1921[var1.field1966][var1.field1949] = null;
               }
            }

            return true;
         } else {
            var1.field1955.method1371(var1.field1968, this.method2624(var1), this.method2584(var1));
            return false;
         }
      } else {
         var1.method2680();
         var1.unlink();
         if(var1.field1949 > 0 && this.field1921[var1.field1966][var1.field1949] == var1) {
            this.field1921[var1.field1966][var1.field1949] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-642399998"
   )
   void method2602(int var1, int var2) {
      this.field1927[var1] = var2;
      this.field1947[var1] = var2 & -128;
      this.method2666(var1, var2);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)Z",
      garbageValue = "615042107"
   )
   boolean method2610(class140 var1) {
      if(null == var1.field1955) {
         if(var1.field1963 >= 0) {
            var1.unlink();
            if(var1.field1949 > 0 && var1 == this.field1921[var1.field1966][var1.field1949]) {
               this.field1921[var1.field1966][var1.field1949] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1715588880"
   )
   void method2617(int var1) {
      if(var1 >= 0) {
         this.field1924[var1] = 12800;
         this.field1929[var1] = 8192;
         this.field1926[var1] = 16383;
         this.field1930[var1] = 8192;
         this.field1931[var1] = 0;
         this.field1932[var1] = 8192;
         this.method2627(var1);
         this.method2580(var1);
         this.field1933[var1] = 0;
         this.field1934[var1] = 32767;
         this.field1935[var1] = 256;
         this.field1936[var1] = 0;
         this.method2582(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method2617(var1);
         }

      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass144;ZI)V",
      garbageValue = "-1863866937"
   )
   public synchronized void method2619(class144 var1, boolean var2) {
      this.method2668();
      this.field1941.method2715(var1.field2006);
      this.field1942 = var2;
      this.field1925 = 0L;
      int var3 = this.field1941.method2689();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field1941.method2690(var4);
         this.field1941.method2693(var4);
         this.field1941.method2705(var4);
      }

      this.field1939 = this.field1941.method2700();
      this.field1944 = this.field1941.field1970[this.field1939];
      this.field1922 = this.field1941.method2697(this.field1944);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)I",
      garbageValue = "-1018257179"
   )
   int method2624(class140 var1) {
      class137 var2 = var1.field1952;
      int var3 = 4096 + this.field1924[var1.field1966] * this.field1926[var1.field1966] >> 13;
      var3 = 16384 + var3 * var3 >> 15;
      var3 = 16384 + var3 * var1.field1950 >> 15;
      var3 = 128 + var3 * this.field1940 >> 8;
      if(var2.field1899 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, 1.953125E-5D * (double)var1.field1960 * (double)var2.field1899) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(null != var2.field1902) {
         var4 = var1.field1961;
         var5 = var2.field1902[1 + var1.field1962];
         if(var1.field1962 < var2.field1902.length - 2) {
            var6 = (var2.field1902[var1.field1962] & 255) << 8;
            var7 = (var2.field1902[2 + var1.field1962] & 255) << 8;
            var5 += (var4 - var6) * (var2.field1902[var1.field1962 + 3] - var5) / (var7 - var6);
         }

         var3 = 32 + var3 * var5 >> 6;
      }

      if(var1.field1963 > 0 && var2.field1898 != null) {
         var4 = var1.field1963;
         var5 = var2.field1898[1 + var1.field1964];
         if(var1.field1964 < var2.field1898.length - 2) {
            var6 = (var2.field1898[var1.field1964] & 255) << 8;
            var7 = (var2.field1898[var1.field1964 + 2] & 255) << 8;
            var5 += (var2.field1898[var1.field1964 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = 32 + var3 * var5 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "541190225"
   )
   void method2627(int var1) {
      if((this.field1933[var1] & 2) != 0) {
         for(class140 var2 = (class140)this.field1943.field1998.method2472(); null != var2; var2 = (class140)this.field1943.field1998.method2479()) {
            if(var1 == var2.field1966 && this.field1945[var1][var2.field1951] == null && var2.field1963 < 0) {
               var2.field1963 = 0;
            }
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-64"
   )
   synchronized void method2653() {
      for(class142 var1 = (class142)this.field1946.method2423(); var1 != null; var1 = (class142)this.field1946.method2424()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "996916822"
   )
   void method2661() {
      int var1 = this.field1939;
      int var2 = this.field1944;

      long var3;
      for(var3 = this.field1922; var2 == this.field1944; var3 = this.field1941.method2697(var2)) {
         while(this.field1941.field1970[var1] == var2) {
            this.field1941.method2690(var1);
            int var5 = this.field1941.method2694(var1);
            if(var5 == 1) {
               this.field1941.method2692();
               this.field1941.method2705(var1);
               if(this.field1941.method2699()) {
                  if(!this.field1942 || var2 == 0) {
                     this.method2578();
                     this.field1941.method2687();
                     return;
                  }

                  this.field1941.method2709(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method2581(var5);
            }

            this.field1941.method2693(var1);
            this.field1941.method2705(var1);
         }

         var1 = this.field1941.method2700();
         var2 = this.field1941.field1970[var1];
      }

      this.field1939 = var1;
      this.field1944 = var2;
      this.field1922 = var3;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "583059882"
   )
   void method2665(int var1) {
      for(class140 var2 = (class140)this.field1943.field1998.method2472(); var2 != null; var2 = (class140)this.field1943.field1998.method2479()) {
         if(var1 < 0 || var1 == var2.field1966) {
            if(null != var2.field1955) {
               var2.field1955.method1300(class202.field3079 / 100);
               if(var2.field1955.method1254()) {
                  this.field1943.field1999.method993(var2.field1955);
               }

               var2.method2680();
            }

            if(var2.field1963 < 0) {
               this.field1945[var2.field1966][var2.field1951] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "551790829"
   )
   void method2666(int var1, int var2) {
      if(this.field1928[var1] != var2) {
         this.field1928[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field1921[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "354607112"
   )
   public synchronized void method2668() {
      this.field1941.method2687();
      this.method2578();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILclass116;Lclass184;I)V",
      garbageValue = "283433876"
   )
   static void method2676(int var0, class116 var1, class184 var2) {
      byte[] var3 = null;
      Deque var4 = class183.field2730;
      synchronized(class183.field2730) {
         for(class180 var5 = (class180)class183.field2730.method2472(); null != var5; var5 = (class180)class183.field2730.method2479()) {
            if((long)var0 == var5.hash && var5.field2696 == var1 && var5.field2697 == 0) {
               var3 = var5.field2695;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.method3466(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method2312(var0);
         var2.method3466(var1, var0, var8, true);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;ZI)V",
      garbageValue = "862864770"
   )
   public static void method2677(class182 var0, class182 var1, boolean var2) {
      class227.field3245 = var0;
      ObjectComposition.field2901 = var1;
      ObjectComposition.field2898 = var2;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BB)Ljava/lang/String;",
      garbageValue = "-78"
   )
   public static String method2678(byte[] var0) {
      return class138.method2555(var0, 0, var0.length);
   }
}

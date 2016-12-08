import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
public class class139 extends class68 {
   @ObfuscatedName("v")
   int[] field1936 = new int[16];
   @ObfuscatedName("o")
   XHashTable field1937 = new XHashTable(128);
   @ObfuscatedName("k")
   int[] field1938 = new int[16];
   @ObfuscatedName("g")
   int[] field1939 = new int[16];
   @ObfuscatedName("ah")
   class143 field1940 = new class143(this);
   @ObfuscatedName("nu")
   @ObfuscatedGetter(
      intValue = -758114491
   )
   static int field1941;
   @ObfuscatedName("n")
   int[] field1942 = new int[16];
   @ObfuscatedName("c")
   int[] field1943 = new int[16];
   @ObfuscatedName("u")
   int[] field1944 = new int[16];
   @ObfuscatedName("e")
   class140[][] field1945 = new class140[16][128];
   @ObfuscatedName("z")
   int[] field1946 = new int[16];
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1947149499
   )
   int field1947;
   @ObfuscatedName("w")
   int[] field1950 = new int[16];
   @ObfuscatedName("q")
   int[] field1952 = new int[16];
   @ObfuscatedName("t")
   int[] field1953 = new int[16];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -351605875
   )
   int field1954 = 256;
   @ObfuscatedName("a")
   int[] field1955 = new int[16];
   @ObfuscatedName("r")
   int[] field1956 = new int[16];
   @ObfuscatedName("am")
   class140[][] field1957 = new class140[16][128];
   @ObfuscatedName("ag")
   class141 field1958 = new class141();
   @ObfuscatedName("au")
   boolean field1959;
   @ObfuscatedName("y")
   int[] field1960 = new int[16];
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1904022573
   )
   int field1961 = 1000000;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      longValue = -5506725675278443957L
   )
   long field1962;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      longValue = 42561854823439217L
   )
   long field1963;
   @ObfuscatedName("l")
   int[] field1964 = new int[16];
   @ObfuscatedName("h")
   int[] field1965 = new int[16];
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -816781801
   )
   int field1966;
   @ObfuscatedName("bt")
   @Export("host")
   static String host;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2119365507"
   )
   public synchronized void method2447(int var1) {
      this.field1954 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-37531761"
   )
   int method2448() {
      return this.field1954;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "593845910"
   )
   synchronized void method2451() {
      for(class142 var1 = (class142)this.field1937.method2296(); var1 != null; var1 = (class142)this.field1937.method2300()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1527860739"
   )
   public synchronized void method2453() {
      for(class142 var1 = (class142)this.field1937.method2296(); var1 != null; var1 = (class142)this.field1937.method2300()) {
         var1.method2618();
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "396981022"
   )
   synchronized boolean method2454() {
      return this.field1958.method2605();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass140;ZB)V",
      garbageValue = "14"
   )
   void method2455(class140 var1, boolean var2) {
      int var3 = var1.field1970.field1022.length;
      int var4;
      if(var2 && var1.field1970.field1023) {
         int var5 = var3 + var3 - var1.field1970.field1025;
         var4 = (int)((long)this.field1953[var1.field1984] * (long)var5 >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field1986.method1167();
         }
      } else {
         var4 = (int)((long)this.field1953[var1.field1984] * (long)var3 >> 6);
      }

      var1.field1986.method1177(var4);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "0"
   )
   void method2456(int var1, int var2) {
      this.field1964[var1] = var2;
      this.field1944[var1] = var2 & -128;
      this.method2457(var1, var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "415713213"
   )
   void method2457(int var1, int var2) {
      if(this.field1943[var1] != var2) {
         this.field1943[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field1957[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-135614077"
   )
   void method2458(int var1, int var2, int var3) {
      this.method2460(var1, var2, 64);
      if((this.field1950[var1] & 2) != 0) {
         for(class140 var4 = (class140)this.field1940.field2017.method2372(); null != var4; var4 = (class140)this.field1940.field2017.method2362()) {
            if(var4.field1984 == var1 && var4.field1978 < 0) {
               this.field1945[var1][var4.field1973] = null;
               this.field1945[var1][var2] = var4;
               int var5 = var4.field1976 + (var4.field1979 * var4.field1977 >> 12);
               var4.field1976 += var2 - var4.field1973 << 8;
               var4.field1977 = var5 - var4.field1976;
               var4.field1979 = 4096;
               var4.field1973 = var2;
               return;
            }
         }
      }

      class142 var9 = (class142)this.field1937.method2299((long)this.field1943[var1]);
      if(var9 != null) {
         class55 var8 = var9.field2007[var2];
         if(var8 != null) {
            class140 var6 = new class140();
            var6.field1984 = var1;
            var6.field1969 = var9;
            var6.field1970 = var8;
            var6.field1971 = var9.field2006[var2];
            var6.field1972 = var9.field2012[var2];
            var6.field1973 = var2;
            var6.field1985 = var3 * var3 * var9.field2011 * var9.field2008[var2] + 1024 >> 11;
            var6.field1974 = var9.field2010[var2] & 255;
            var6.field1976 = (var2 << 8) - (var9.field2013[var2] & 32767);
            var6.field1980 = 0;
            var6.field1990 = 0;
            var6.field1981 = 0;
            var6.field1978 = -1;
            var6.field1983 = 0;
            if(this.field1953[var1] == 0) {
               var6.field1986 = class66.method1294(var8, this.method2472(var6), this.method2473(var6), this.method2474(var6));
            } else {
               var6.field1986 = class66.method1294(var8, this.method2472(var6), 0, this.method2474(var6));
               this.method2455(var6, var9.field2013[var2] < 0);
            }

            if(var9.field2013[var2] < 0) {
               var6.field1986.method1268(-1);
            }

            if(var6.field1972 >= 0) {
               class140 var7 = this.field1957[var1][var6.field1972];
               if(null != var7 && var7.field1978 < 0) {
                  this.field1945[var1][var7.field1973] = null;
                  var7.field1978 = 0;
               }

               this.field1957[var1][var6.field1972] = var6;
            }

            this.field1940.field2017.method2361(var6);
            this.field1945[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("k")
   protected synchronized int vmethod2624() {
      return 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-286812002"
   )
   void method2460(int var1, int var2, int var3) {
      class140 var4 = this.field1945[var1][var2];
      if(null != var4) {
         this.field1945[var1][var2] = null;
         if((this.field1950[var1] & 2) != 0) {
            for(class140 var5 = (class140)this.field1940.field2017.method2349(); null != var5; var5 = (class140)this.field1940.field2017.method2351()) {
               if(var5.field1984 == var4.field1984 && var5.field1978 < 0 && var5 != var4) {
                  var4.field1978 = 0;
                  break;
               }
            }
         } else {
            var4.field1978 = 0;
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "4"
   )
   void method2462(int var1, int var2) {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1242813693"
   )
   void method2464(int var1) {
      for(class140 var2 = (class140)this.field1940.field2017.method2349(); null != var2; var2 = (class140)this.field1940.field2017.method2351()) {
         if(var1 < 0 || var1 == var2.field1984) {
            if(var2.field1986 != null) {
               var2.field1986.method1182(class57.field1042 / 100);
               if(var2.field1986.method1186()) {
                  this.field1940.field2018.method898(var2.field1986);
               }

               var2.method2566();
            }

            if(var2.field1978 < 0) {
               this.field1945[var2.field1984][var2.field1973] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2021243087"
   )
   void method2465(int var1) {
      if(var1 >= 0) {
         this.field1939[var1] = 12800;
         this.field1965[var1] = 8192;
         this.field1936[var1] = 16383;
         this.field1938[var1] = 8192;
         this.field1946[var1] = 0;
         this.field1960[var1] = 8192;
         this.method2468(var1);
         this.method2469(var1);
         this.field1950[var1] = 0;
         this.field1942[var1] = 32767;
         this.field1952[var1] = 256;
         this.field1953[var1] = 0;
         this.method2471(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method2465(var1);
         }

      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-632737585"
   )
   void method2466(int var1) {
      for(class140 var2 = (class140)this.field1940.field2017.method2349(); null != var2; var2 = (class140)this.field1940.field2017.method2351()) {
         if((var1 < 0 || var2.field1984 == var1) && var2.field1978 < 0) {
            this.field1945[var2.field1984][var2.field1973] = null;
            var2.field1978 = 0;
         }
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "571436681"
   )
   void method2468(int var1) {
      if((this.field1950[var1] & 2) != 0) {
         for(class140 var2 = (class140)this.field1940.field2017.method2349(); null != var2; var2 = (class140)this.field1940.field2017.method2351()) {
            if(var1 == var2.field1984 && null == this.field1945[var1][var2.field1973] && var2.field1978 < 0) {
               var2.field1978 = 0;
            }
         }
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1518173781"
   )
   void method2469(int var1) {
      if((this.field1950[var1] & 4) != 0) {
         for(class140 var2 = (class140)this.field1940.field2017.method2349(); null != var2; var2 = (class140)this.field1940.field2017.method2351()) {
            if(var1 == var2.field1984) {
               var2.field1989 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-112"
   )
   void method2471(int var1, int var2) {
      this.field1956[var1] = var2;
      this.field1955[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Lclass140;B)I",
      garbageValue = "-78"
   )
   int method2472(class140 var1) {
      int var2 = var1.field1976 + (var1.field1979 * var1.field1977 >> 12);
      var2 += this.field1952[var1.field1984] * (this.field1938[var1.field1984] - 8192) >> 12;
      class137 var3 = var1.field1971;
      int var4;
      if(var3.field1921 > 0 && (var3.field1920 > 0 || this.field1946[var1.field1984] > 0)) {
         var4 = var3.field1920 << 2;
         int var5 = var3.field1917 << 1;
         if(var1.field1982 < var5) {
            var4 = var1.field1982 * var4 / var5;
         }

         var4 += this.field1946[var1.field1984] >> 7;
         double var6 = Math.sin((double)(var1.field1968 & 511) * 0.01227184630308513D);
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(var1.field1970.field1021 * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)class57.field1042 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)I",
      garbageValue = "379743924"
   )
   int method2473(class140 var1) {
      class137 var2 = var1.field1971;
      int var3 = 4096 + this.field1936[var1.field1984] * this.field1939[var1.field1984] >> 13;
      var3 = 16384 + var3 * var3 >> 15;
      var3 = 16384 + var3 * var1.field1985 >> 15;
      var3 = 128 + var3 * this.field1954 >> 8;
      if(var2.field1916 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, 1.953125E-5D * (double)var1.field1980 * (double)var2.field1916) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field1922 != null) {
         var4 = var1.field1990;
         var5 = var2.field1922[var1.field1981 + 1];
         if(var1.field1981 < var2.field1922.length - 2) {
            var6 = (var2.field1922[var1.field1981] & 255) << 8;
            var7 = (var2.field1922[2 + var1.field1981] & 255) << 8;
            var5 += (var2.field1922[3 + var1.field1981] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      if(var1.field1978 > 0 && null != var2.field1915) {
         var4 = var1.field1978;
         var5 = var2.field1915[var1.field1983 + 1];
         if(var1.field1983 < var2.field1915.length - 2) {
            var6 = (var2.field1915[var1.field1983] & 255) << 8;
            var7 = (var2.field1915[var1.field1983 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field1915[var1.field1983 + 3] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)I",
      garbageValue = "1969215382"
   )
   int method2474(class140 var1) {
      int var2 = this.field1965[var1.field1984];
      return var2 < 8192?32 + var2 * var1.field1974 >> 6:16384 - ((16384 - var2) * (128 - var1.field1974) + 32 >> 6);
   }

   @ObfuscatedName("u")
   protected synchronized class68 vmethod2626() {
      return null;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1904932646"
   )
   void method2480() {
      int var1 = this.field1966;
      int var2 = this.field1947;

      long var3;
      for(var3 = this.field1963; var2 == this.field1947; var3 = this.field1958.method2598(var2)) {
         while(var2 == this.field1958.field1996[var1]) {
            this.field1958.method2575(var1);
            int var5 = this.field1958.method2578(var1);
            if(var5 == 1) {
               this.field1958.method2577();
               this.field1958.method2576(var1);
               if(this.field1958.method2592()) {
                  if(!this.field1959 || var2 == 0) {
                     this.method2504();
                     this.field1958.method2572();
                     return;
                  }

                  this.field1958.method2584(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method2491(var5);
            }

            this.field1958.method2571(var1);
            this.field1958.method2576(var1);
         }

         var1 = this.field1958.method2582();
         var2 = this.field1958.field1996[var1];
      }

      this.field1966 = var1;
      this.field1947 = var2;
      this.field1963 = var3;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)Z",
      garbageValue = "71784904"
   )
   boolean method2481(class140 var1) {
      if(null == var1.field1986) {
         if(var1.field1978 >= 0) {
            var1.unlink();
            if(var1.field1972 > 0 && var1 == this.field1957[var1.field1984][var1.field1972]) {
               this.field1957[var1.field1984][var1.field1972] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Lclass140;[IIIB)Z",
      garbageValue = "-20"
   )
   boolean method2482(class140 var1, int[] var2, int var3, int var4) {
      var1.field1987 = class57.field1042 / 100;
      if(var1.field1978 < 0 || var1.field1986 != null && !var1.field1986.method1185()) {
         int var5 = var1.field1979;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field1960[var1.field1984]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field1979 = var5;
         }

         var1.field1986.method1222(this.method2472(var1));
         class137 var6 = var1.field1971;
         boolean var7 = false;
         ++var1.field1982;
         var1.field1968 += var6.field1921;
         double var8 = (double)((var1.field1973 - 60 << 8) + (var1.field1979 * var1.field1977 >> 12)) * 5.086263020833333E-6D;
         if(var6.field1916 > 0) {
            if(var6.field1914 > 0) {
               var1.field1980 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field1914) + 0.5D);
            } else {
               var1.field1980 += 128;
            }
         }

         if(null != var6.field1922) {
            if(var6.field1919 > 0) {
               var1.field1990 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field1919) + 0.5D);
            } else {
               var1.field1990 += 128;
            }

            while(var1.field1981 < var6.field1922.length - 2 && var1.field1990 > (var6.field1922[var1.field1981 + 2] & 255) << 8) {
               var1.field1981 += 2;
            }

            if(var6.field1922.length - 2 == var1.field1981 && var6.field1922[var1.field1981 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field1978 >= 0 && null != var6.field1915 && (this.field1950[var1.field1984] & 1) == 0 && (var1.field1972 < 0 || var1 != this.field1957[var1.field1984][var1.field1972])) {
            if(var6.field1918 > 0) {
               var1.field1978 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field1918) + 0.5D);
            } else {
               var1.field1978 += 128;
            }

            while(var1.field1983 < var6.field1915.length - 2 && var1.field1978 > (var6.field1915[var1.field1983 + 2] & 255) << 8) {
               var1.field1983 += 2;
            }

            if(var1.field1983 == var6.field1915.length - 2) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field1986.method1182(var1.field1987);
            if(var2 != null) {
               var1.field1986.vmethod2628(var2, var3, var4);
            } else {
               var1.field1986.vmethod2629(var4);
            }

            if(var1.field1986.method1186()) {
               this.field1940.field2018.method898(var1.field1986);
            }

            var1.method2566();
            if(var1.field1978 >= 0) {
               var1.unlink();
               if(var1.field1972 > 0 && this.field1957[var1.field1984][var1.field1972] == var1) {
                  this.field1957[var1.field1984][var1.field1972] = null;
               }
            }

            return true;
         } else {
            var1.field1986.method1181(var1.field1987, this.method2473(var1), this.method2474(var1));
            return false;
         }
      } else {
         var1.method2566();
         var1.unlink();
         if(var1.field1972 > 0 && var1 == this.field1957[var1.field1984][var1.field1972]) {
            this.field1957[var1.field1984][var1.field1972] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-661383715"
   )
   public synchronized void method2488() {
      this.field1958.method2572();
      this.method2504();
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "8"
   )
   void method2491(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method2460(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method2458(var3, var4, var5);
         } else {
            this.method2460(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method2527(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field1944[var3] = (var5 << 14) + (this.field1944[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field1944[var3] = (var5 << 7) + (this.field1944[var3] & -16257);
         }

         if(var4 == 1) {
            this.field1946[var3] = (this.field1946[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 33) {
            this.field1946[var3] = var5 + (this.field1946[var3] & -128);
         }

         if(var4 == 5) {
            this.field1960[var3] = (var5 << 7) + (this.field1960[var3] & -16257);
         }

         if(var4 == 37) {
            this.field1960[var3] = var5 + (this.field1960[var3] & -128);
         }

         if(var4 == 7) {
            this.field1939[var3] = (this.field1939[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 39) {
            this.field1939[var3] = (this.field1939[var3] & -128) + var5;
         }

         if(var4 == 10) {
            this.field1965[var3] = (var5 << 7) + (this.field1965[var3] & -16257);
         }

         if(var4 == 42) {
            this.field1965[var3] = (this.field1965[var3] & -128) + var5;
         }

         if(var4 == 11) {
            this.field1936[var3] = (var5 << 7) + (this.field1936[var3] & -16257);
         }

         if(var4 == 43) {
            this.field1936[var3] = var5 + (this.field1936[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field1950[var3] |= 1;
            } else {
               this.field1950[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field1950[var3] |= 2;
            } else {
               this.method2468(var3);
               this.field1950[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field1942[var3] = (this.field1942[var3] & 127) + (var5 << 7);
         }

         if(var4 == 98) {
            this.field1942[var3] = var5 + (this.field1942[var3] & 16256);
         }

         if(var4 == 101) {
            this.field1942[var3] = (var5 << 7) + 16384 + (this.field1942[var3] & 127);
         }

         if(var4 == 100) {
            this.field1942[var3] = var5 + (this.field1942[var3] & 16256) + 16384;
         }

         if(var4 == 120) {
            this.method2464(var3);
         }

         if(var4 == 121) {
            this.method2465(var3);
         }

         if(var4 == 123) {
            this.method2466(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field1942[var3];
            if(var6 == 16384) {
               this.field1952[var3] = (var5 << 7) + (this.field1952[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field1942[var3];
            if(var6 == 16384) {
               this.field1952[var3] = (this.field1952[var3] & -128) + var5;
            }
         }

         if(var4 == 16) {
            this.field1953[var3] = (var5 << 7) + (this.field1953[var3] & -16257);
         }

         if(var4 == 48) {
            this.field1953[var3] = var5 + (this.field1953[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field1950[var3] |= 4;
            } else {
               this.method2469(var3);
               this.field1950[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method2471(var3, (var5 << 7) + (this.field1956[var3] & -16257));
         }

         if(var4 == 49) {
            this.method2471(var3, var5 + (this.field1956[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method2457(var3, var4 + this.field1944[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method2462(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 9 & 16256) + (var1 >> 8 & 127);
         this.method2558(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method2504();
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1933213604"
   )
   public synchronized void method2495(int var1, int var2) {
      this.method2456(var1, var2);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1498118118"
   )
   void method2504() {
      this.method2464(-1);
      this.method2465(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field1943[var1] = this.field1964[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field1944[var1] = this.field1964[var1] & -128;
      }

   }

   @ObfuscatedName("j")
   protected synchronized void vmethod2629(int var1) {
      if(this.field1958.method2605()) {
         int var2 = this.field1961 * this.field1958.field1993 / class57.field1042;

         do {
            long var3 = this.field1962 + (long)var2 * (long)var1;
            if(this.field1963 - var3 >= 0L) {
               this.field1962 = var3;
               break;
            }

            int var5 = (int)((this.field1963 - this.field1962 + (long)var2 - 1L) / (long)var2);
            this.field1962 += (long)var2 * (long)var5;
            this.field1940.vmethod2629(var5);
            var1 -= var5;
            this.method2480();
         } while(this.field1958.method2605());
      }

      this.field1940.vmethod2629(var1);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass144;Lclass182;Lclass60;II)Z",
      garbageValue = "-488647091"
   )
   public synchronized boolean method2519(class144 var1, class182 var2, class60 var3, int var4) {
      var1.method2652();
      boolean var5 = true;
      Object var6 = null;
      int[] var12 = new int[]{var4};

      for(class134 var7 = (class134)var1.field2023.method2296(); var7 != null; var7 = (class134)var1.field2023.method2300()) {
         int var8 = (int)var7.hash;
         class142 var9 = (class142)this.field1937.method2299((long)var8);
         if(null == var9) {
            byte[] var11 = var2.method3208(var8);
            class142 var10;
            if(null == var11) {
               var10 = null;
            } else {
               var10 = new class142(var11);
            }

            var9 = var10;
            if(var10 == null) {
               var5 = false;
               continue;
            }

            this.field1937.method2291(var10, (long)var8);
         }

         if(!var9.method2617(var3, var7.field1909, var12)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method2653();
      }

      return var5;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass144;ZB)V",
      garbageValue = "117"
   )
   public synchronized void method2521(class144 var1, boolean var2) {
      this.method2488();
      this.field1958.method2581(var1.field2022);
      this.field1959 = var2;
      this.field1962 = 0L;
      int var3 = this.field1958.method2574();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field1958.method2575(var4);
         this.field1958.method2571(var4);
         this.field1958.method2576(var4);
      }

      this.field1966 = this.field1958.method2582();
      this.field1947 = this.field1958.field1996[this.field1966];
      this.field1963 = this.field1958.method2598(this.field1947);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-2085172652"
   )
   void method2527(int var1, int var2, int var3) {
   }

   public class139() {
      this.method2504();
   }

   @ObfuscatedName("c")
   protected synchronized class68 vmethod2625() {
      return this.field1940;
   }

   @ObfuscatedName("z")
   protected synchronized void vmethod2628(int[] var1, int var2, int var3) {
      if(this.field1958.method2605()) {
         int var4 = this.field1958.field1993 * this.field1961 / class57.field1042;

         do {
            long var5 = (long)var3 * (long)var4 + this.field1962;
            if(this.field1963 - var5 >= 0L) {
               this.field1962 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field1963 - this.field1962) - 1L) / (long)var4);
            this.field1962 += (long)var4 * (long)var7;
            this.field1940.vmethod2628(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method2480();
         } while(this.field1958.method2605());
      }

      this.field1940.vmethod2628(var1, var2, var3);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1561881093"
   )
   void method2558(int var1, int var2) {
      this.field1938[var1] = var2;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass182;I)V",
      garbageValue = "1619227530"
   )
   public static void method2564(class182 var0) {
      class189.field2791 = var0;
   }
}

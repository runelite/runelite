import java.awt.Component;
import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
public class class139 extends class68 {
   @ObfuscatedName("a")
   int[] field1934 = new int[16];
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -939560761
   )
   int field1935 = 256;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 665040707
   )
   int field1936 = 1000000;
   @ObfuscatedName("h")
   int[] field1937 = new int[16];
   @ObfuscatedName("e")
   int[] field1938 = new int[16];
   @ObfuscatedName("g")
   int[] field1939 = new int[16];
   @ObfuscatedName("u")
   int[] field1940 = new int[16];
   @ObfuscatedName("r")
   int[] field1941 = new int[16];
   @ObfuscatedName("b")
   int[] field1942 = new int[16];
   @ObfuscatedName("x")
   int[] field1944 = new int[16];
   @ObfuscatedName("n")
   int[] field1945 = new int[16];
   @ObfuscatedName("l")
   int[] field1946 = new int[16];
   @ObfuscatedName("s")
   XHashTable field1947 = new XHashTable(128);
   @ObfuscatedName("pz")
   static GarbageCollectorMXBean field1948;
   @ObfuscatedName("q")
   int[] field1949 = new int[16];
   @ObfuscatedName("y")
   int[] field1950 = new int[16];
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      longValue = -8838134685319630765L
   )
   long field1951;
   @ObfuscatedName("v")
   class140[][] field1952 = new class140[16][128];
   @ObfuscatedName("az")
   class140[][] field1953 = new class140[16][128];
   @ObfuscatedName("ai")
   class141 field1954 = new class141();
   @ObfuscatedName("k")
   int[] field1955 = new int[16];
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -866642149
   )
   int field1956;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -371209263
   )
   int field1957;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      longValue = 1813009047774288021L
   )
   long field1958;
   @ObfuscatedName("ad")
   boolean field1959;
   @ObfuscatedName("al")
   class143 field1960 = new class143(this);
   @ObfuscatedName("t")
   int[] field1961 = new int[16];
   @ObfuscatedName("d")
   int[] field1963 = new int[16];

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1543675909"
   )
   void method2413(int var1, int var2) {
      this.field1950[var1] = var2;
      this.field1946[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1472716611"
   )
   public int method2415() {
      return this.field1935;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass144;Lclass182;Lclass60;IS)Z",
      garbageValue = "-16489"
   )
   public synchronized boolean method2416(class144 var1, class182 var2, class60 var3, int var4) {
      var1.method2635();
      boolean var5 = true;
      Object var6 = null;
      int[] var12 = new int[]{var4};

      for(class134 var7 = (class134)var1.field2014.method2283(); var7 != null; var7 = (class134)var1.field2014.method2277()) {
         int var8 = (int)var7.hash;
         class142 var9 = (class142)this.field1947.method2274((long)var8);
         if(null == var9) {
            byte[] var11 = var2.method3187(var8);
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

            this.field1947.method2282(var10, (long)var8);
         }

         if(!var9.method2604(var3, var7.field1902, var12)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method2641();
      }

      return var5;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1112430559"
   )
   public synchronized void method2418() {
      for(class142 var1 = (class142)this.field1947.method2283(); null != var1; var1 = (class142)this.field1947.method2277()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass144;ZI)V",
      garbageValue = "680403982"
   )
   public synchronized void method2419(class144 var1, boolean var2) {
      this.method2503();
      this.field1954.method2599(var1.field2015);
      this.field1959 = var2;
      this.field1958 = 0L;
      int var3 = this.field1954.method2557();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field1954.method2559(var4);
         this.field1954.method2562(var4);
         this.field1954.method2560(var4);
      }

      this.field1956 = this.field1954.method2566();
      this.field1957 = this.field1954.field1997[this.field1956];
      this.field1951 = this.field1954.method2565(this.field1957);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1887460939"
   )
   public synchronized boolean method2421() {
      return this.field1954.method2561();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "855833660"
   )
   void method2423(int var1, int var2) {
      this.field1955[var1] = var2;
      this.field1942[var1] = var2 & -128;
      this.method2424(var1, var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "87"
   )
   void method2424(int var1, int var2) {
      if(var2 != this.field1940[var1]) {
         this.field1940[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field1953[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIS)V",
      garbageValue = "-21889"
   )
   void method2425(int var1, int var2, int var3) {
      this.method2483(var1, var2, 64);
      if((this.field1938[var1] & 2) != 0) {
         for(class140 var4 = (class140)this.field1960.field2012.method2331(); var4 != null; var4 = (class140)this.field1960.field2012.method2335()) {
            if(var1 == var4.field1979 && var4.field1978 < 0) {
               this.field1952[var1][var4.field1969] = null;
               this.field1952[var1][var2] = var4;
               int var5 = var4.field1972 + (var4.field1973 * var4.field1967 >> 12);
               var4.field1972 += var2 - var4.field1969 << 8;
               var4.field1973 = var5 - var4.field1972;
               var4.field1967 = 4096;
               var4.field1969 = var2;
               return;
            }
         }
      }

      class142 var9 = (class142)this.field1947.method2274((long)this.field1940[var1]);
      if(var9 != null) {
         class55 var8 = var9.field2001[var2];
         if(null != var8) {
            class140 var6 = new class140();
            var6.field1979 = var1;
            var6.field1965 = var9;
            var6.field1968 = var8;
            var6.field1974 = var9.field2005[var2];
            var6.field1982 = var9.field2000[var2];
            var6.field1969 = var2;
            var6.field1970 = 1024 + var9.field2003[var2] * var3 * var3 * var9.field2004 >> 11;
            var6.field1971 = var9.field2006[var2] & 255;
            var6.field1972 = (var2 << 8) - (var9.field2002[var2] & 32767);
            var6.field1975 = 0;
            var6.field1976 = 0;
            var6.field1977 = 0;
            var6.field1978 = -1;
            var6.field1985 = 0;
            if(this.field1949[var1] == 0) {
               var6.field1966 = class66.method1127(var8, this.method2439(var6), this.method2443(var6), this.method2441(var6));
            } else {
               var6.field1966 = class66.method1127(var8, this.method2439(var6), 0, this.method2441(var6));
               this.method2458(var6, var9.field2002[var2] < 0);
            }

            if(var9.field2002[var2] < 0) {
               var6.field1966.method1165(-1);
            }

            if(var6.field1982 >= 0) {
               class140 var7 = this.field1953[var1][var6.field1982];
               if(var7 != null && var7.field1978 < 0) {
                  this.field1952[var1][var7.field1969] = null;
                  var7.field1978 = 0;
               }

               this.field1953[var1][var6.field1982] = var6;
            }

            this.field1960.field2012.method2333(var6);
            this.field1952[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1864940514"
   )
   void method2428(int var1, int var2, int var3) {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "747645290"
   )
   void method2429(int var1, int var2) {
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-508119795"
   )
   void method2431(int var1) {
      for(class140 var2 = (class140)this.field1960.field2012.method2330(); var2 != null; var2 = (class140)this.field1960.field2012.method2346()) {
         if(var1 < 0 || var2.field1979 == var1) {
            if(var2.field1966 != null) {
               var2.field1966.method1139(class57.field1057 / 100);
               if(var2.field1966.method1143()) {
                  this.field1960.field2010.method868(var2.field1966);
               }

               var2.method2546();
            }

            if(var2.field1978 < 0) {
               this.field1952[var2.field1979][var2.field1969] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-377832814"
   )
   void method2432(int var1) {
      if(var1 >= 0) {
         this.field1937[var1] = 12800;
         this.field1934[var1] = 8192;
         this.field1939[var1] = 16383;
         this.field1944[var1] = 8192;
         this.field1941[var1] = 0;
         this.field1945[var1] = 8192;
         this.method2435(var1);
         this.method2512(var1);
         this.field1938[var1] = 0;
         this.field1963[var1] = 32767;
         this.field1961[var1] = 256;
         this.field1949[var1] = 0;
         this.method2413(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method2432(var1);
         }

      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "115"
   )
   void method2433(int var1) {
      for(class140 var2 = (class140)this.field1960.field2012.method2330(); null != var2; var2 = (class140)this.field1960.field2012.method2346()) {
         if((var1 < 0 || var1 == var2.field1979) && var2.field1978 < 0) {
            this.field1952[var2.field1979][var2.field1969] = null;
            var2.field1978 = 0;
         }
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1924081016"
   )
   void method2434() {
      this.method2431(-1);
      this.method2432(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field1940[var1] = this.field1955[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field1942[var1] = this.field1955[var1] & -128;
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-2"
   )
   void method2435(int var1) {
      if((this.field1938[var1] & 2) != 0) {
         for(class140 var2 = (class140)this.field1960.field2012.method2330(); null != var2; var2 = (class140)this.field1960.field2012.method2346()) {
            if(var1 == var2.field1979 && null == this.field1952[var1][var2.field1969] && var2.field1978 < 0) {
               var2.field1978 = 0;
            }
         }
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)Z",
      garbageValue = "299038846"
   )
   boolean method2437(class140 var1) {
      if(var1.field1966 == null) {
         if(var1.field1978 >= 0) {
            var1.unlink();
            if(var1.field1982 > 0 && var1 == this.field1953[var1.field1979][var1.field1982]) {
               this.field1953[var1.field1979][var1.field1982] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)I",
      garbageValue = "500137215"
   )
   int method2439(class140 var1) {
      int var2 = (var1.field1967 * var1.field1973 >> 12) + var1.field1972;
      var2 += (this.field1944[var1.field1979] - 8192) * this.field1961[var1.field1979] >> 12;
      class137 var3 = var1.field1974;
      int var4;
      if(var3.field1914 > 0 && (var3.field1913 > 0 || this.field1941[var1.field1979] > 0)) {
         var4 = var3.field1913 << 2;
         int var5 = var3.field1911 << 1;
         if(var1.field1980 < var5) {
            var4 = var1.field1980 * var4 / var5;
         }

         var4 += this.field1941[var1.field1979] >> 7;
         double var6 = Math.sin((double)(var1.field1981 & 511) * 0.01227184630308513D);
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(var1.field1968.field1021 * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)class57.field1057 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)I",
      garbageValue = "-1307174817"
   )
   int method2441(class140 var1) {
      int var2 = this.field1934[var1.field1979];
      return var2 < 8192?32 + var2 * var1.field1971 >> 6:16384 - (32 + (16384 - var2) * (128 - var1.field1971) >> 6);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Lclass140;B)I",
      garbageValue = "85"
   )
   int method2443(class140 var1) {
      class137 var2 = var1.field1974;
      int var3 = this.field1939[var1.field1979] * this.field1937[var1.field1979] + 4096 >> 13;
      var3 = 16384 + var3 * var3 >> 15;
      var3 = 16384 + var1.field1970 * var3 >> 15;
      var3 = this.field1935 * var3 + 128 >> 8;
      if(var2.field1917 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field1917 * 1.953125E-5D * (double)var1.field1975) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(null != var2.field1916) {
         var4 = var1.field1976;
         var5 = var2.field1916[1 + var1.field1977];
         if(var1.field1977 < var2.field1916.length - 2) {
            var6 = (var2.field1916[var1.field1977] & 255) << 8;
            var7 = (var2.field1916[var1.field1977 + 2] & 255) << 8;
            var5 += (var2.field1916[3 + var1.field1977] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      if(var1.field1978 > 0 && null != var2.field1908) {
         var4 = var1.field1978;
         var5 = var2.field1908[var1.field1985 + 1];
         if(var1.field1985 < var2.field1908.length - 2) {
            var6 = (var2.field1908[var1.field1985] & 255) << 8;
            var7 = (var2.field1908[var1.field1985 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field1908[var1.field1985 + 3] - var5) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("x")
   protected synchronized int vmethod2632() {
      return 0;
   }

   @ObfuscatedName("r")
   protected synchronized void vmethod2614(int[] var1, int var2, int var3) {
      if(this.field1954.method2561()) {
         int var4 = this.field1936 * this.field1954.field1987 / class57.field1057;

         do {
            long var5 = (long)var4 * (long)var3 + this.field1958;
            if(this.field1951 - var5 >= 0L) {
               this.field1958 = var5;
               break;
            }

            int var7 = (int)((this.field1951 - this.field1958 + (long)var4 - 1L) / (long)var4);
            this.field1958 += (long)var7 * (long)var4;
            this.field1960.vmethod2614(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method2447();
         } while(this.field1954.method2561());
      }

      this.field1960.vmethod2614(var1, var2, var3);
   }

   @ObfuscatedName("m")
   protected synchronized void vmethod2615(int var1) {
      if(this.field1954.method2561()) {
         int var2 = this.field1954.field1987 * this.field1936 / class57.field1057;

         do {
            long var3 = this.field1958 + (long)var1 * (long)var2;
            if(this.field1951 - var3 >= 0L) {
               this.field1958 = var3;
               break;
            }

            int var5 = (int)(((long)var2 + (this.field1951 - this.field1958) - 1L) / (long)var2);
            this.field1958 += (long)var5 * (long)var2;
            this.field1960.vmethod2615(var5);
            var1 -= var5;
            this.method2447();
         } while(this.field1954.method2561());
      }

      this.field1960.vmethod2615(var1);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1355597233"
   )
   void method2447() {
      int var1 = this.field1956;
      int var2 = this.field1957;

      long var3;
      for(var3 = this.field1951; var2 == this.field1957; var3 = this.field1954.method2565(var2)) {
         while(this.field1954.field1997[var1] == var2) {
            this.field1954.method2559(var1);
            int var5 = this.field1954.method2555(var1);
            if(var5 == 1) {
               this.field1954.method2579();
               this.field1954.method2560(var1);
               if(this.field1954.method2567()) {
                  if(!this.field1959 || var2 == 0) {
                     this.method2434();
                     this.field1954.method2556();
                     return;
                  }

                  this.field1954.method2568(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method2480(var5);
            }

            this.field1954.method2562(var1);
            this.field1954.method2560(var1);
         }

         var1 = this.field1954.method2566();
         var2 = this.field1954.field1997[var1];
      }

      this.field1956 = var1;
      this.field1957 = var2;
      this.field1951 = var3;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Lclass140;[IIII)Z",
      garbageValue = "56672250"
   )
   boolean method2449(class140 var1, int[] var2, int var3, int var4) {
      var1.field1964 = class57.field1057 / 100;
      if(var1.field1978 < 0 || var1.field1966 != null && !var1.field1966.method1169()) {
         int var5 = var1.field1967;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field1945[var1.field1979]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field1967 = var5;
         }

         var1.field1966.method1155(this.method2439(var1));
         class137 var6 = var1.field1974;
         boolean var7 = false;
         ++var1.field1980;
         var1.field1981 += var6.field1914;
         double var8 = (double)((var1.field1967 * var1.field1973 >> 12) + (var1.field1969 - 60 << 8)) * 5.086263020833333E-6D;
         if(var6.field1917 > 0) {
            if(var6.field1912 > 0) {
               var1.field1975 += (int)(128.0D * Math.pow(2.0D, (double)var6.field1912 * var8) + 0.5D);
            } else {
               var1.field1975 += 128;
            }
         }

         if(null != var6.field1916) {
            if(var6.field1915 > 0) {
               var1.field1976 += (int)(128.0D * Math.pow(2.0D, (double)var6.field1915 * var8) + 0.5D);
            } else {
               var1.field1976 += 128;
            }

            while(var1.field1977 < var6.field1916.length - 2 && var1.field1976 > (var6.field1916[2 + var1.field1977] & 255) << 8) {
               var1.field1977 += 2;
            }

            if(var1.field1977 == var6.field1916.length - 2 && var6.field1916[1 + var1.field1977] == 0) {
               var7 = true;
            }
         }

         if(var1.field1978 >= 0 && var6.field1908 != null && (this.field1938[var1.field1979] & 1) == 0 && (var1.field1982 < 0 || this.field1953[var1.field1979][var1.field1982] != var1)) {
            if(var6.field1910 > 0) {
               var1.field1978 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field1910) + 0.5D);
            } else {
               var1.field1978 += 128;
            }

            while(var1.field1985 < var6.field1908.length - 2 && var1.field1978 > (var6.field1908[2 + var1.field1985] & 255) << 8) {
               var1.field1985 += 2;
            }

            if(var6.field1908.length - 2 == var1.field1985) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field1966.method1139(var1.field1964);
            if(null != var2) {
               var1.field1966.vmethod2614(var2, var3, var4);
            } else {
               var1.field1966.vmethod2615(var4);
            }

            if(var1.field1966.method1143()) {
               this.field1960.field2010.method868(var1.field1966);
            }

            var1.method2546();
            if(var1.field1978 >= 0) {
               var1.unlink();
               if(var1.field1982 > 0 && var1 == this.field1953[var1.field1979][var1.field1982]) {
                  this.field1953[var1.field1979][var1.field1982] = null;
               }
            }

            return true;
         } else {
            var1.field1966.method1131(var1.field1964, this.method2443(var1), this.method2441(var1));
            return false;
         }
      } else {
         var1.method2546();
         var1.unlink();
         if(var1.field1982 > 0 && this.field1953[var1.field1979][var1.field1982] == var1) {
            this.field1953[var1.field1979][var1.field1982] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "887092282"
   )
   public synchronized void method2456() {
      for(class142 var1 = (class142)this.field1947.method2283(); var1 != null; var1 = (class142)this.field1947.method2277()) {
         var1.method2605();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass140;ZI)V",
      garbageValue = "2137249912"
   )
   void method2458(class140 var1, boolean var2) {
      int var3 = var1.field1968.field1020.length;
      int var4;
      if(var2 && var1.field1968.field1023) {
         int var5 = var3 + var3 - var1.field1968.field1019;
         var4 = (int)((long)this.field1949[var1.field1979] * (long)var5 >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field1966.method1136();
         }
      } else {
         var4 = (int)((long)this.field1949[var1.field1979] * (long)var3 >> 6);
      }

      var1.field1966.method1158(var4);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-716514597"
   )
   void method2480(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method2483(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method2425(var3, var4, var5);
         } else {
            this.method2483(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method2428(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field1942[var3] = (var5 << 14) + (this.field1942[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field1942[var3] = (this.field1942[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 1) {
            this.field1941[var3] = (this.field1941[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 33) {
            this.field1941[var3] = (this.field1941[var3] & -128) + var5;
         }

         if(var4 == 5) {
            this.field1945[var3] = (var5 << 7) + (this.field1945[var3] & -16257);
         }

         if(var4 == 37) {
            this.field1945[var3] = var5 + (this.field1945[var3] & -128);
         }

         if(var4 == 7) {
            this.field1937[var3] = (this.field1937[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 39) {
            this.field1937[var3] = (this.field1937[var3] & -128) + var5;
         }

         if(var4 == 10) {
            this.field1934[var3] = (var5 << 7) + (this.field1934[var3] & -16257);
         }

         if(var4 == 42) {
            this.field1934[var3] = (this.field1934[var3] & -128) + var5;
         }

         if(var4 == 11) {
            this.field1939[var3] = (var5 << 7) + (this.field1939[var3] & -16257);
         }

         if(var4 == 43) {
            this.field1939[var3] = var5 + (this.field1939[var3] & -128);
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
               this.method2435(var3);
               this.field1938[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field1963[var3] = (this.field1963[var3] & 127) + (var5 << 7);
         }

         if(var4 == 98) {
            this.field1963[var3] = (this.field1963[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field1963[var3] = (this.field1963[var3] & 127) + 16384 + (var5 << 7);
         }

         if(var4 == 100) {
            this.field1963[var3] = 16384 + (this.field1963[var3] & 16256) + var5;
         }

         if(var4 == 120) {
            this.method2431(var3);
         }

         if(var4 == 121) {
            this.method2432(var3);
         }

         if(var4 == 123) {
            this.method2433(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field1963[var3];
            if(var6 == 16384) {
               this.field1961[var3] = (var5 << 7) + (this.field1961[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field1963[var3];
            if(var6 == 16384) {
               this.field1961[var3] = var5 + (this.field1961[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field1949[var3] = (var5 << 7) + (this.field1949[var3] & -16257);
         }

         if(var4 == 48) {
            this.field1949[var3] = var5 + (this.field1949[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field1938[var3] |= 4;
            } else {
               this.method2512(var3);
               this.field1938[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method2413(var3, (this.field1950[var3] & -16257) + (var5 << 7));
         }

         if(var4 == 49) {
            this.method2413(var3, var5 + (this.field1950[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method2424(var3, var4 + this.field1942[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method2429(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method2522(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method2434();
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-2029112863"
   )
   void method2483(int var1, int var2, int var3) {
      class140 var4 = this.field1952[var1][var2];
      if(var4 != null) {
         this.field1952[var1][var2] = null;
         if((this.field1938[var1] & 2) != 0) {
            for(class140 var5 = (class140)this.field1960.field2012.method2330(); null != var5; var5 = (class140)this.field1960.field2012.method2346()) {
               if(var5.field1979 == var4.field1979 && var5.field1978 < 0 && var5 != var4) {
                  var4.field1978 = 0;
                  break;
               }
            }
         } else {
            var4.field1978 = 0;
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-41"
   )
   public synchronized void method2503() {
      this.field1954.method2556();
      this.method2434();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-296543217"
   )
   public synchronized void method2507(int var1, int var2) {
      this.method2423(var1, var2);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1504276039"
   )
   void method2512(int var1) {
      if((this.field1938[var1] & 4) != 0) {
         for(class140 var2 = (class140)this.field1960.field2012.method2330(); var2 != null; var2 = (class140)this.field1960.field2012.method2346()) {
            if(var1 == var2.field1979) {
               var2.field1984 = 0;
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "255"
   )
   void method2522(int var1, int var2) {
      this.field1944[var1] = var2;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "118"
   )
   public synchronized void method2531(int var1) {
      this.field1935 = var1;
   }

   public class139() {
      this.method2434();
   }

   @ObfuscatedName("b")
   protected synchronized class68 vmethod2612() {
      return null;
   }

   @ObfuscatedName("u")
   protected synchronized class68 vmethod2611() {
      return this.field1960;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1657524499"
   )
   public static void method2544(Component var0) {
      var0.addMouseListener(class115.mouse);
      var0.addMouseMotionListener(class115.mouse);
      var0.addFocusListener(class115.mouse);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1999841613"
   )
   static void method2545(int var0) {
      if(var0 != -1) {
         if(class109.method1999(var0)) {
            Widget[] var1 = Widget.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2290 != null) {
                  class18 var4 = new class18();
                  var4.field204 = var3;
                  var4.field205 = var3.field2290;
                  class112.method2046(var4, 2000000);
               }
            }

         }
      }
   }
}

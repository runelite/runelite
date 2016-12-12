import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
public class class139 extends class68 {
   @ObfuscatedName("s")
   int[] field1923 = new int[16];
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 644462955
   )
   int field1924 = 256;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2084719497
   )
   int field1925 = 1000000;
   @ObfuscatedName("k")
   int[] field1926 = new int[16];
   @ObfuscatedName("g")
   int[] field1927 = new int[16];
   @ObfuscatedName("n")
   int[] field1928 = new int[16];
   @ObfuscatedName("aw")
   class143 field1929 = new class143(this);
   @ObfuscatedName("v")
   int[] field1930 = new int[16];
   @ObfuscatedName("ai")
   class141 field1931 = new class141();
   @ObfuscatedName("h")
   int[] field1932 = new int[16];
   @ObfuscatedName("l")
   int[] field1934 = new int[16];
   @ObfuscatedName("d")
   int[] field1935 = new int[16];
   @ObfuscatedName("i")
   XHashTable field1936 = new XHashTable(128);
   @ObfuscatedName("y")
   int[] field1937 = new int[16];
   @ObfuscatedName("t")
   int[] field1938 = new int[16];
   @ObfuscatedName("z")
   int[] field1939 = new int[16];
   @ObfuscatedName("b")
   int[] field1940 = new int[16];
   @ObfuscatedName("ak")
   class140[][] field1941 = new class140[16][128];
   @ObfuscatedName("q")
   int[] field1942 = new int[16];
   @ObfuscatedName("o")
   class140[][] field1943 = new class140[16][128];
   @ObfuscatedName("aq")
   boolean field1944;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1970055775
   )
   int field1945;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -846186235
   )
   int field1946;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      longValue = -8325140674620520993L
   )
   long field1947;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      longValue = 2007230318757514469L
   )
   long field1948;
   @ObfuscatedName("a")
   int[] field1949 = new int[16];
   @ObfuscatedName("p")
   int[] field1951 = new int[16];

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "178206371"
   )
   synchronized boolean method2460() {
      return this.field1931.method2615();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass144;Lclass182;Lclass60;II)Z",
      garbageValue = "65536"
   )
   public synchronized boolean method2462(class144 var1, class182 var2, class60 var3, int var4) {
      var1.method2676();
      boolean var5 = true;
      Object var6 = null;
      int[] var12 = new int[]{var4};

      for(class134 var7 = (class134)var1.field2010.method2313(); null != var7; var7 = (class134)var1.field2010.method2321()) {
         int var8 = (int)var7.hash;
         class142 var9 = (class142)this.field1936.method2311((long)var8);
         if(var9 == null) {
            byte[] var11 = var2.method3216(var8);
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

            this.field1936.method2312(var10, (long)var8);
         }

         if(!var9.method2641(var3, var7.field1892, var12)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method2677();
      }

      return var5;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "128"
   )
   void method2463(int var1) {
      for(class140 var2 = (class140)this.field1929.field2005.method2359(); var2 != null; var2 = (class140)this.field1929.field2005.method2361()) {
         if(var1 < 0 || var1 == var2.field1963) {
            if(null != var2.field1962) {
               var2.field1962.method1173(class57.field1053 / 100);
               if(var2.field1962.method1276()) {
                  this.field1929.field2004.method882(var2.field1962);
               }

               var2.method2592();
            }

            if(var2.field1966 < 0) {
               this.field1943[var2.field1963][var2.field1957] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "75"
   )
   synchronized void method2464() {
      for(class142 var1 = (class142)this.field1936.method2313(); var1 != null; var1 = (class142)this.field1936.method2321()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1783708104"
   )
   public synchronized void method2466() {
      this.field1931.method2599();
      this.method2574();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public synchronized void method2468() {
      for(class142 var1 = (class142)this.field1936.method2313(); null != var1; var1 = (class142)this.field1936.method2321()) {
         var1.method2640();
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-519303943"
   )
   void method2469(int var1, int var2) {
      this.field1949[var1] = var2;
      this.field1930[var1] = var2 & -128;
      this.method2542(var1, var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-589116626"
   )
   public synchronized void method2470(int var1) {
      this.field1924 = var1;
   }

   @ObfuscatedName("h")
   protected synchronized void vmethod2665(int[] var1, int var2, int var3) {
      if(this.field1931.method2615()) {
         int var4 = this.field1925 * this.field1931.field1977 / class57.field1053;

         do {
            long var5 = this.field1947 + (long)var4 * (long)var3;
            if(this.field1948 - var5 >= 0L) {
               this.field1947 = var5;
               break;
            }

            int var7 = (int)((this.field1948 - this.field1947 + (long)var4 - 1L) / (long)var4);
            this.field1947 += (long)var4 * (long)var7;
            this.field1929.vmethod2665(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method2493();
         } while(this.field1931.method2615());
      }

      this.field1929.vmethod2665(var1, var2, var3);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass140;ZB)V",
      garbageValue = "1"
   )
   void method2472(class140 var1, boolean var2) {
      int var3 = var1.field1968.field1022.length;
      int var4;
      if(var2 && var1.field1968.field1024) {
         int var5 = var3 + var3 - var1.field1968.field1023;
         var4 = (int)((long)var5 * (long)this.field1938[var1.field1963] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field1962.method1282();
         }
      } else {
         var4 = (int)((long)this.field1938[var1.field1963] * (long)var3 >> 6);
      }

      var1.field1962.method1168(var4);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "247918993"
   )
   void method2473(int var1, int var2, int var3) {
      class140 var4 = this.field1943[var1][var2];
      if(var4 != null) {
         this.field1943[var1][var2] = null;
         if((this.field1935[var1] & 2) != 0) {
            for(class140 var5 = (class140)this.field1929.field2005.method2359(); null != var5; var5 = (class140)this.field1929.field2005.method2361()) {
               if(var5.field1963 == var4.field1963 && var5.field1966 < 0 && var4 != var5) {
                  var4.field1966 = 0;
                  break;
               }
            }
         } else {
            var4.field1966 = 0;
         }

      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-550861509"
   )
   void method2474(int var1, int var2, int var3) {
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "236793618"
   )
   void method2475(int var1, int var2) {
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-4"
   )
   void method2478(int var1) {
      if(var1 >= 0) {
         this.field1926[var1] = 12800;
         this.field1927[var1] = 8192;
         this.field1928[var1] = 16383;
         this.field1932[var1] = 8192;
         this.field1951[var1] = 0;
         this.field1934[var1] = 8192;
         this.method2481(var1);
         this.method2482(var1);
         this.field1935[var1] = 0;
         this.field1937[var1] = 32767;
         this.field1923[var1] = 256;
         this.field1938[var1] = 0;
         this.method2484(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method2478(var1);
         }

      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1244866549"
   )
   void method2481(int var1) {
      if((this.field1935[var1] & 2) != 0) {
         for(class140 var2 = (class140)this.field1929.field2005.method2359(); var2 != null; var2 = (class140)this.field1929.field2005.method2361()) {
            if(var1 == var2.field1963 && null == this.field1943[var1][var2.field1957] && var2.field1966 < 0) {
               var2.field1966 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "750276795"
   )
   void method2482(int var1) {
      if((this.field1935[var1] & 4) != 0) {
         for(class140 var2 = (class140)this.field1929.field2005.method2359(); null != var2; var2 = (class140)this.field1929.field2005.method2361()) {
            if(var2.field1963 == var1) {
               var2.field1972 = 0;
            }
         }
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1698891756"
   )
   void method2483(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method2473(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method2563(var3, var4, var5);
         } else {
            this.method2473(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method2474(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field1930[var3] = (this.field1930[var3] & -2080769) + (var5 << 14);
         }

         if(var4 == 32) {
            this.field1930[var3] = (this.field1930[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 1) {
            this.field1951[var3] = (var5 << 7) + (this.field1951[var3] & -16257);
         }

         if(var4 == 33) {
            this.field1951[var3] = (this.field1951[var3] & -128) + var5;
         }

         if(var4 == 5) {
            this.field1934[var3] = (var5 << 7) + (this.field1934[var3] & -16257);
         }

         if(var4 == 37) {
            this.field1934[var3] = var5 + (this.field1934[var3] & -128);
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
            this.field1927[var3] = (this.field1927[var3] & -128) + var5;
         }

         if(var4 == 11) {
            this.field1928[var3] = (this.field1928[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 43) {
            this.field1928[var3] = var5 + (this.field1928[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field1935[var3] |= 1;
            } else {
               this.field1935[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field1935[var3] |= 2;
            } else {
               this.method2481(var3);
               this.field1935[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field1937[var3] = (this.field1937[var3] & 127) + (var5 << 7);
         }

         if(var4 == 98) {
            this.field1937[var3] = (this.field1937[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field1937[var3] = (var5 << 7) + (this.field1937[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field1937[var3] = 16384 + (this.field1937[var3] & 16256) + var5;
         }

         if(var4 == 120) {
            this.method2463(var3);
         }

         if(var4 == 121) {
            this.method2478(var3);
         }

         if(var4 == 123) {
            this.method2540(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field1937[var3];
            if(var6 == 16384) {
               this.field1923[var3] = (this.field1923[var3] & -16257) + (var5 << 7);
            }
         }

         if(var4 == 38) {
            var6 = this.field1937[var3];
            if(var6 == 16384) {
               this.field1923[var3] = var5 + (this.field1923[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field1938[var3] = (this.field1938[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 48) {
            this.field1938[var3] = (this.field1938[var3] & -128) + var5;
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field1935[var3] |= 4;
            } else {
               this.method2482(var3);
               this.field1935[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method2484(var3, (this.field1939[var3] & -16257) + (var5 << 7));
         }

         if(var4 == 49) {
            this.method2484(var3, var5 + (this.field1939[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method2542(var3, var4 + this.field1930[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method2475(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method2568(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method2574();
         }
      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1556981993"
   )
   void method2484(int var1, int var2) {
      this.field1939[var1] = var2;
      this.field1940[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)I",
      garbageValue = "1948387847"
   )
   int method2486(class140 var1) {
      class137 var2 = var1.field1955;
      int var3 = 4096 + this.field1928[var1.field1963] * this.field1926[var1.field1963] >> 13;
      var3 = 16384 + var3 * var3 >> 15;
      var3 = var3 * var1.field1975 + 16384 >> 15;
      var3 = 128 + this.field1924 * var3 >> 8;
      if(var2.field1899 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field1899 * (double)var1.field1970 * 1.953125E-5D) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(null != var2.field1901) {
         var4 = var1.field1964;
         var5 = var2.field1901[var1.field1965 + 1];
         if(var1.field1965 < var2.field1901.length - 2) {
            var6 = (var2.field1901[var1.field1965] & 255) << 8;
            var7 = (var2.field1901[2 + var1.field1965] & 255) << 8;
            var5 += (var2.field1901[3 + var1.field1965] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = 32 + var5 * var3 >> 6;
      }

      if(var1.field1966 > 0 && var2.field1898 != null) {
         var4 = var1.field1966;
         var5 = var2.field1898[1 + var1.field1973];
         if(var1.field1973 < var2.field1898.length - 2) {
            var6 = (var2.field1898[var1.field1973] & 255) << 8;
            var7 = (var2.field1898[var1.field1973 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field1898[3 + var1.field1973] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Lclass140;B)I",
      garbageValue = "20"
   )
   int method2487(class140 var1) {
      int var2 = this.field1927[var1.field1963];
      return var2 < 8192?var2 * var1.field1952 + 32 >> 6:16384 - (32 + (128 - var1.field1952) * (16384 - var2) >> 6);
   }

   @ObfuscatedName("q")
   protected synchronized class68 vmethod2666() {
      return this.field1929;
   }

   @ObfuscatedName("v")
   protected synchronized int vmethod2649() {
      return 0;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "652719509"
   )
   void method2493() {
      int var1 = this.field1945;
      int var2 = this.field1946;

      long var3;
      for(var3 = this.field1948; this.field1946 == var2; var3 = this.field1931.method2632(var2)) {
         while(this.field1931.field1980[var1] == var2) {
            this.field1931.method2602(var1);
            int var5 = this.field1931.method2605(var1);
            if(var5 == 1) {
               this.field1931.method2597();
               this.field1931.method2603(var1);
               if(this.field1931.method2610()) {
                  if(!this.field1944 || var2 == 0) {
                     this.method2574();
                     this.field1931.method2599();
                     return;
                  }

                  this.field1931.method2611(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method2483(var5);
            }

            this.field1931.method2631(var1);
            this.field1931.method2603(var1);
         }

         var1 = this.field1931.method2609();
         var2 = this.field1931.field1980[var1];
      }

      this.field1945 = var1;
      this.field1946 = var2;
      this.field1948 = var3;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lclass140;S)Z",
      garbageValue = "32767"
   )
   boolean method2494(class140 var1) {
      if(null == var1.field1962) {
         if(var1.field1966 >= 0) {
            var1.unlink();
            if(var1.field1956 > 0 && var1 == this.field1941[var1.field1963][var1.field1956]) {
               this.field1941[var1.field1963][var1.field1956] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Lclass140;[IIII)Z",
      garbageValue = "-188009261"
   )
   boolean method2495(class140 var1, int[] var2, int var3, int var4) {
      var1.field1971 = class57.field1053 / 100;
      if(var1.field1966 < 0 || null != var1.field1962 && !var1.field1962.method1176()) {
         int var5 = var1.field1954;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field1934[var1.field1963]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field1954 = var5;
         }

         var1.field1962.method1174(this.method2562(var1));
         class137 var6 = var1.field1955;
         boolean var7 = false;
         ++var1.field1959;
         var1.field1969 += var6.field1909;
         double var8 = (double)((var1.field1957 - 60 << 8) + (var1.field1961 * var1.field1954 >> 12)) * 5.086263020833333E-6D;
         if(var6.field1899 > 0) {
            if(var6.field1902 > 0) {
               var1.field1970 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field1902) + 0.5D);
            } else {
               var1.field1970 += 128;
            }
         }

         if(null != var6.field1901) {
            if(var6.field1900 > 0) {
               var1.field1964 += (int)(128.0D * Math.pow(2.0D, (double)var6.field1900 * var8) + 0.5D);
            } else {
               var1.field1964 += 128;
            }

            while(var1.field1965 < var6.field1901.length - 2 && var1.field1964 > (var6.field1901[var1.field1965 + 2] & 255) << 8) {
               var1.field1965 += 2;
            }

            if(var6.field1901.length - 2 == var1.field1965 && var6.field1901[var1.field1965 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field1966 >= 0 && null != var6.field1898 && (this.field1935[var1.field1963] & 1) == 0 && (var1.field1956 < 0 || var1 != this.field1941[var1.field1963][var1.field1956])) {
            if(var6.field1907 > 0) {
               var1.field1966 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field1907) + 0.5D);
            } else {
               var1.field1966 += 128;
            }

            while(var1.field1973 < var6.field1898.length - 2 && var1.field1966 > (var6.field1898[var1.field1973 + 2] & 255) << 8) {
               var1.field1973 += 2;
            }

            if(var6.field1898.length - 2 == var1.field1973) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field1962.method1173(var1.field1971);
            if(null != var2) {
               var1.field1962.vmethod2665(var2, var3, var4);
            } else {
               var1.field1962.vmethod2651(var4);
            }

            if(var1.field1962.method1276()) {
               this.field1929.field2004.method882(var1.field1962);
            }

            var1.method2592();
            if(var1.field1966 >= 0) {
               var1.unlink();
               if(var1.field1956 > 0 && var1 == this.field1941[var1.field1963][var1.field1956]) {
                  this.field1941[var1.field1963][var1.field1956] = null;
               }
            }

            return true;
         } else {
            var1.field1962.method1172(var1.field1971, this.method2486(var1), this.method2487(var1));
            return false;
         }
      } else {
         var1.method2592();
         var1.unlink();
         if(var1.field1956 > 0 && var1 == this.field1941[var1.field1963][var1.field1956]) {
            this.field1941[var1.field1963][var1.field1956] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass144;ZI)V",
      garbageValue = "629359815"
   )
   public synchronized void method2497(class144 var1, boolean var2) {
      this.method2466();
      this.field1931.method2598(var1.field2009);
      this.field1944 = var2;
      this.field1947 = 0L;
      int var3 = this.field1931.method2601();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field1931.method2602(var4);
         this.field1931.method2631(var4);
         this.field1931.method2603(var4);
      }

      this.field1945 = this.field1931.method2609();
      this.field1946 = this.field1931.field1980[this.field1945];
      this.field1948 = this.field1931.method2632(this.field1946);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1414449872"
   )
   public synchronized void method2498(int var1, int var2) {
      this.method2469(var1, var2);
   }

   public class139() {
      this.method2574();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "1196906403"
   )
   public static String method2528(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class203.field3073[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("l")
   protected synchronized void vmethod2651(int var1) {
      if(this.field1931.method2615()) {
         int var2 = this.field1925 * this.field1931.field1977 / class57.field1053;

         do {
            long var3 = this.field1947 + (long)var2 * (long)var1;
            if(this.field1948 - var3 >= 0L) {
               this.field1947 = var3;
               break;
            }

            int var5 = (int)((this.field1948 - this.field1947 + (long)var2 - 1L) / (long)var2);
            this.field1947 += (long)var5 * (long)var2;
            this.field1929.vmethod2651(var5);
            var1 -= var5;
            this.method2493();
         } while(this.field1931.method2615());
      }

      this.field1929.vmethod2651(var1);
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "207587742"
   )
   void method2540(int var1) {
      for(class140 var2 = (class140)this.field1929.field2005.method2359(); var2 != null; var2 = (class140)this.field1929.field2005.method2361()) {
         if((var1 < 0 || var2.field1963 == var1) && var2.field1966 < 0) {
            this.field1943[var2.field1963][var2.field1957] = null;
            var2.field1966 = 0;
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1765857266"
   )
   void method2542(int var1, int var2) {
      if(var2 != this.field1942[var1]) {
         this.field1942[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field1941[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)I",
      garbageValue = "-1989236665"
   )
   int method2562(class140 var1) {
      int var2 = var1.field1960 + (var1.field1954 * var1.field1961 >> 12);
      var2 += this.field1923[var1.field1963] * (this.field1932[var1.field1963] - 8192) >> 12;
      class137 var3 = var1.field1955;
      int var4;
      if(var3.field1909 > 0 && (var3.field1903 > 0 || this.field1951[var1.field1963] > 0)) {
         var4 = var3.field1903 << 2;
         int var5 = var3.field1905 << 1;
         if(var1.field1959 < var5) {
            var4 = var1.field1959 * var4 / var5;
         }

         var4 += this.field1951[var1.field1963] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field1969 & 511));
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(var1.field1968.field1026 * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)class57.field1053 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-327479695"
   )
   void method2563(int var1, int var2, int var3) {
      this.method2473(var1, var2, 64);
      if((this.field1935[var1] & 2) != 0) {
         for(class140 var4 = (class140)this.field1929.field2005.method2360(); null != var4; var4 = (class140)this.field1929.field2005.method2362()) {
            if(var4.field1963 == var1 && var4.field1966 < 0) {
               this.field1943[var1][var4.field1957] = null;
               this.field1943[var1][var2] = var4;
               int var5 = (var4.field1961 * var4.field1954 >> 12) + var4.field1960;
               var4.field1960 += var2 - var4.field1957 << 8;
               var4.field1961 = var5 - var4.field1960;
               var4.field1954 = 4096;
               var4.field1957 = var2;
               return;
            }
         }
      }

      class142 var9 = (class142)this.field1936.method2311((long)this.field1942[var1]);
      if(null != var9) {
         class55 var8 = var9.field1997[var2];
         if(var8 != null) {
            class140 var6 = new class140();
            var6.field1963 = var1;
            var6.field1953 = var9;
            var6.field1968 = var8;
            var6.field1955 = var9.field1999[var2];
            var6.field1956 = var9.field1995[var2];
            var6.field1957 = var2;
            var6.field1975 = 1024 + var9.field1993[var2] * var9.field1998 * var3 * var3 >> 11;
            var6.field1952 = var9.field1994[var2] & 255;
            var6.field1960 = (var2 << 8) - (var9.field1991[var2] & 32767);
            var6.field1970 = 0;
            var6.field1964 = 0;
            var6.field1965 = 0;
            var6.field1966 = -1;
            var6.field1973 = 0;
            if(this.field1938[var1] == 0) {
               var6.field1962 = class66.method1160(var8, this.method2562(var6), this.method2486(var6), this.method2487(var6));
            } else {
               var6.field1962 = class66.method1160(var8, this.method2562(var6), 0, this.method2487(var6));
               this.method2472(var6, var9.field1991[var2] < 0);
            }

            if(var9.field1991[var2] < 0) {
               var6.field1962.method1162(-1);
            }

            if(var6.field1956 >= 0) {
               class140 var7 = this.field1941[var1][var6.field1956];
               if(var7 != null && var7.field1966 < 0) {
                  this.field1943[var1][var7.field1957] = null;
                  var7.field1966 = 0;
               }

               this.field1941[var1][var6.field1956] = var6;
            }

            this.field1929.field2005.method2376(var6);
            this.field1943[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("w")
   protected synchronized class68 vmethod2658() {
      return null;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "107514938"
   )
   void method2568(int var1, int var2) {
      this.field1932[var1] = var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-119"
   )
   int method2571() {
      return this.field1924;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "365272964"
   )
   void method2574() {
      this.method2463(-1);
      this.method2478(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field1942[var1] = this.field1949[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field1930[var1] = this.field1949[var1] & -128;
      }

   }

   @ObfuscatedName("e")
   static final void method2588(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2007900265"
   )
   static final void method2589() {
      short var0 = 256;
      int var1;
      if(class41.field836 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class41.field836 > 768) {
               class41.field833[var1] = class162.method3013(WidgetNode.field181[var1], class41.field834[var1], 1024 - class41.field836);
            } else if(class41.field836 > 256) {
               class41.field833[var1] = class41.field834[var1];
            } else {
               class41.field833[var1] = class162.method3013(class41.field834[var1], WidgetNode.field181[var1], 256 - class41.field836);
            }
         }
      } else if(class41.field837 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class41.field837 > 768) {
               class41.field833[var1] = class162.method3013(WidgetNode.field181[var1], class41.field853[var1], 1024 - class41.field837);
            } else if(class41.field837 > 256) {
               class41.field833[var1] = class41.field853[var1];
            } else {
               class41.field833[var1] = class162.method3013(class41.field853[var1], WidgetNode.field181[var1], 256 - class41.field837);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            class41.field833[var1] = WidgetNode.field181[var1];
         }
      }

      class219.method3889(class41.field824, 9, 128 + class41.field824, var0 + 7);
      class16.field172.method4071(class41.field824, 0);
      class219.method3888();
      var1 = 0;
      int var2 = ChatMessages.bufferProvider.width * 9 + class41.field824;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = (var0 - var3) * class41.field832[var3] / var0;
         var5 = 22 + var4;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = GameObject.field1613[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class41.field833[var7];
               var10 = ChatMessages.bufferProvider.pixels[var2];
               ChatMessages.bufferProvider.pixels[var2++] = (var8 * (var7 & 16711935) + (var10 & 16711935) * var9 & -16711936) + ((var10 & '\uff00') * var9 + var8 * (var7 & '\uff00') & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += ChatMessages.bufferProvider.width + var5 - 128;
      }

      class219.method3889(class41.field824 + 765 - 128, 9, class41.field824 + 765, 7 + var0);
      class41.field861.method4071(class41.field824 + 382, 0);
      class219.method3888();
      var1 = 0;
      var2 = class41.field824 + ChatMessages.bufferProvider.width * 9 + 24 + 637;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = (var0 - var3) * class41.field832[var3] / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = GameObject.field1613[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class41.field833[var7];
               var10 = ChatMessages.bufferProvider.pixels[var2];
               ChatMessages.bufferProvider.pixels[var2++] = ((var7 & 16711935) * var8 + (var10 & 16711935) * var9 & -16711936) + ((var7 & '\uff00') * var8 + (var10 & '\uff00') * var9 & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += ChatMessages.bufferProvider.width - var5 - var4;
      }

   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "1059056866"
   )
   static final String[] method2591(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(null != var0 && null != var0[var2]) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }
}

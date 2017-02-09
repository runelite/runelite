import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public class class139 extends class68 {
   @ObfuscatedName("z")
   int[] field1917 = new int[16];
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1447374943
   )
   int field1918 = 256;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2112737925
   )
   int field1919 = 1000000;
   @ObfuscatedName("r")
   int[] field1920 = new int[16];
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      longValue = -2535974235719228425L
   )
   long field1921;
   @ObfuscatedName("af")
   class143 field1922 = new class143(this);
   @ObfuscatedName("d")
   int[] field1923 = new int[16];
   @ObfuscatedName("n")
   int[] field1924 = new int[16];
   @ObfuscatedName("c")
   int[] field1925 = new int[16];
   @ObfuscatedName("s")
   int[] field1926 = new int[16];
   @ObfuscatedName("g")
   int[] field1927 = new int[16];
   @ObfuscatedName("ap")
   class140[][] field1928 = new class140[16][128];
   @ObfuscatedName("b")
   int[] field1929 = new int[16];
   @ObfuscatedName("u")
   int[] field1930 = new int[16];
   @ObfuscatedName("e")
   int[] field1931 = new int[16];
   @ObfuscatedName("m")
   int[] field1932 = new int[16];
   @ObfuscatedName("aw")
   boolean field1933;
   @ObfuscatedName("l")
   int[] field1934 = new int[16];
   @ObfuscatedName("x")
   class140[][] field1935 = new class140[16][128];
   @ObfuscatedName("q")
   int[] field1936 = new int[16];
   @ObfuscatedName("aq")
   class141 field1937 = new class141();
   @ObfuscatedName("k")
   XHashTable field1938 = new XHashTable(128);
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1368675463
   )
   int field1940;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 358981171
   )
   int field1941;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      longValue = -4316282415453609191L
   )
   long field1942;
   @ObfuscatedName("i")
   int[] field1943 = new int[16];
   @ObfuscatedName("nu")
   static class57 field1944;
   @ObfuscatedName("j")
   int[] field1945 = new int[16];
   @ObfuscatedName("pz")
   @ObfuscatedGetter(
      longValue = -6274383736236443811L
   )
   static long field1946;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1000615327"
   )
   public synchronized void method2468(int var1) {
      this.field1918 = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2120181946"
   )
   void method2469(int var1, int var2) {
      this.field1923[var1] = var2;
      this.field1925[var1] = var2 & -128;
      this.method2478(var1, var2);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass140;ZB)V",
      garbageValue = "0"
   )
   void method2471(class140 var1, boolean var2) {
      int var3 = var1.field1961.field1023.length;
      int var4;
      if(var2 && var1.field1961.field1027) {
         int var5 = var3 + var3 - var1.field1961.field1025;
         var4 = (int)((long)var5 * (long)this.field1932[var1.field1959] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field1970.method1296();
         }
      } else {
         var4 = (int)((long)this.field1932[var1.field1959] * (long)var3 >> 6);
      }

      var1.field1970.method1201(var4);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "50249370"
   )
   public synchronized void method2472() {
      for(class142 var1 = (class142)this.field1938.method2334(); null != var1; var1 = (class142)this.field1938.method2335()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lclass144;ZB)V",
      garbageValue = "1"
   )
   public synchronized void method2473(class144 var1, boolean var2) {
      this.method2474();
      this.field1937.method2615(var1.field2002);
      this.field1933 = var2;
      this.field1921 = 0L;
      int var3 = this.field1937.method2618();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field1937.method2619(var4);
         this.field1937.method2635(var4);
         this.field1937.method2620(var4);
      }

      this.field1941 = this.field1937.method2659();
      this.field1940 = this.field1937.field1974[this.field1941];
      this.field1942 = this.field1937.method2626(this.field1940);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1732409434"
   )
   public synchronized void method2474() {
      this.field1937.method2616();
      this.method2488();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "410844093"
   )
   public synchronized boolean method2475() {
      return this.field1937.method2617();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "5116"
   )
   void method2478(int var1, int var2) {
      if(var2 != this.field1924[var1]) {
         this.field1924[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field1928[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1723618133"
   )
   void method2479(int var1, int var2, int var3) {
      this.method2514(var1, var2, 64);
      if((this.field1917[var1] & 2) != 0) {
         for(class140 var4 = (class140)this.field1922.field2000.method2386(); var4 != null; var4 = (class140)this.field1922.field2000.method2409()) {
            if(var1 == var4.field1959 && var4.field1962 < 0) {
               this.field1935[var1][var4.field1953] = null;
               this.field1935[var1][var2] = var4;
               int var5 = (var4.field1957 * var4.field1958 >> 12) + var4.field1964;
               var4.field1964 += var2 - var4.field1953 << 8;
               var4.field1957 = var5 - var4.field1964;
               var4.field1958 = 4096;
               var4.field1953 = var2;
               return;
            }
         }
      }

      class142 var9 = (class142)this.field1938.method2331((long)this.field1924[var1]);
      if(null != var9) {
         class55 var8 = var9.field1985[var2];
         if(null != var8) {
            class140 var6 = new class140();
            var6.field1959 = var1;
            var6.field1949 = var9;
            var6.field1961 = var8;
            var6.field1951 = var9.field1990[var2];
            var6.field1966 = var9.field1992[var2];
            var6.field1953 = var2;
            var6.field1954 = 1024 + var9.field1988 * var3 * var3 * var9.field1986[var2] >> 11;
            var6.field1955 = var9.field1989[var2] & 255;
            var6.field1964 = (var2 << 8) - (var9.field1987[var2] & 32767);
            var6.field1952 = 0;
            var6.field1960 = 0;
            var6.field1963 = 0;
            var6.field1962 = -1;
            var6.field1956 = 0;
            if(this.field1932[var1] == 0) {
               var6.field1970 = class66.method1266(var8, this.method2493(var6), this.method2583(var6), this.method2535(var6));
            } else {
               var6.field1970 = class66.method1266(var8, this.method2493(var6), 0, this.method2535(var6));
               this.method2471(var6, var9.field1987[var2] < 0);
            }

            if(var9.field1987[var2] < 0) {
               var6.field1970.method1196(-1);
            }

            if(var6.field1966 >= 0) {
               class140 var7 = this.field1928[var1][var6.field1966];
               if(null != var7 && var7.field1962 < 0) {
                  this.field1935[var1][var7.field1953] = null;
                  var7.field1962 = 0;
               }

               this.field1928[var1][var6.field1966] = var6;
            }

            this.field1922.field2000.method2380(var6);
            this.field1935[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "598606261"
   )
   void method2482(int var1, int var2, int var3) {
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-417830621"
   )
   void method2483(int var1, int var2) {
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1634340529"
   )
   void method2485(int var1) {
      for(class140 var2 = (class140)this.field1922.field2000.method2403(); null != var2; var2 = (class140)this.field1922.field2000.method2398()) {
         if(var1 < 0 || var1 == var2.field1959) {
            if(null != var2.field1970) {
               var2.field1970.method1206(class57.field1045 / 100);
               if(var2.field1970.method1189()) {
                  this.field1922.field1997.method918(var2.field1970);
               }

               var2.method2612();
            }

            if(var2.field1962 < 0) {
               this.field1935[var2.field1959][var2.field1953] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1745778492"
   )
   void method2487(int var1) {
      for(class140 var2 = (class140)this.field1922.field2000.method2403(); var2 != null; var2 = (class140)this.field1922.field2000.method2398()) {
         if((var1 < 0 || var1 == var2.field1959) && var2.field1962 < 0) {
            this.field1935[var2.field1959][var2.field1953] = null;
            var2.field1962 = 0;
         }
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "52"
   )
   void method2488() {
      this.method2485(-1);
      this.method2593(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field1924[var1] = this.field1923[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field1925[var1] = this.field1923[var1] & -128;
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-666142559"
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
         this.method2514(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method2479(var3, var4, var5);
         } else {
            this.method2514(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method2482(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field1925[var3] = (var5 << 14) + (this.field1925[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field1925[var3] = (this.field1925[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 1) {
            this.field1927[var3] = (this.field1927[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 33) {
            this.field1927[var3] = var5 + (this.field1927[var3] & -128);
         }

         if(var4 == 5) {
            this.field1943[var3] = (this.field1943[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 37) {
            this.field1943[var3] = (this.field1943[var3] & -128) + var5;
         }

         if(var4 == 7) {
            this.field1920[var3] = (this.field1920[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 39) {
            this.field1920[var3] = var5 + (this.field1920[var3] & -128);
         }

         if(var4 == 10) {
            this.field1945[var3] = (var5 << 7) + (this.field1945[var3] & -16257);
         }

         if(var4 == 42) {
            this.field1945[var3] = var5 + (this.field1945[var3] & -128);
         }

         if(var4 == 11) {
            this.field1936[var3] = (this.field1936[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 43) {
            this.field1936[var3] = var5 + (this.field1936[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field1917[var3] |= 1;
            } else {
               this.field1917[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field1917[var3] |= 2;
            } else {
               this.method2526(var3);
               this.field1917[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field1930[var3] = (this.field1930[var3] & 127) + (var5 << 7);
         }

         if(var4 == 98) {
            this.field1930[var3] = (this.field1930[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field1930[var3] = (var5 << 7) + (this.field1930[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field1930[var3] = (this.field1930[var3] & 16256) + 16384 + var5;
         }

         if(var4 == 120) {
            this.method2485(var3);
         }

         if(var4 == 121) {
            this.method2593(var3);
         }

         if(var4 == 123) {
            this.method2487(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field1930[var3];
            if(var6 == 16384) {
               this.field1929[var3] = (var5 << 7) + (this.field1929[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field1930[var3];
            if(var6 == 16384) {
               this.field1929[var3] = (this.field1929[var3] & -128) + var5;
            }
         }

         if(var4 == 16) {
            this.field1932[var3] = (var5 << 7) + (this.field1932[var3] & -16257);
         }

         if(var4 == 48) {
            this.field1932[var3] = var5 + (this.field1932[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field1917[var3] |= 4;
            } else {
               this.method2592(var3);
               this.field1917[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method2492(var3, (var5 << 7) + (this.field1931[var3] & -16257));
         }

         if(var4 == 49) {
            this.method2492(var3, (this.field1931[var3] & -128) + var5);
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method2478(var3, var4 + this.field1925[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method2483(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 9 & 16256) + (var1 >> 8 & 127);
         this.method2582(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method2488();
         }
      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1704327491"
   )
   void method2492(int var1, int var2) {
      this.field1931[var1] = var2;
      this.field1934[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)I",
      garbageValue = "146299347"
   )
   int method2493(class140 var1) {
      int var2 = (var1.field1958 * var1.field1957 >> 12) + var1.field1964;
      var2 += (this.field1926[var1.field1959] - 8192) * this.field1929[var1.field1959] >> 12;
      class137 var3 = var1.field1951;
      int var4;
      if(var3.field1900 > 0 && (var3.field1895 > 0 || this.field1927[var1.field1959] > 0)) {
         var4 = var3.field1895 << 2;
         int var5 = var3.field1899 << 1;
         if(var1.field1950 < var5) {
            var4 = var1.field1950 * var4 / var5;
         }

         var4 += this.field1927[var1.field1959] >> 7;
         double var6 = Math.sin((double)(var1.field1965 & 511) * 0.01227184630308513D);
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(256 * var1.field1961.field1024) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)class57.field1045 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("j")
   protected synchronized class68 vmethod2708() {
      return this.field1922;
   }

   @ObfuscatedName("c")
   protected synchronized class68 vmethod2687() {
      return null;
   }

   @ObfuscatedName("g")
   protected synchronized int vmethod2688() {
      return 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass144;Lclass182;Lclass60;IB)Z",
      garbageValue = "10"
   )
   public synchronized boolean method2500(class144 var1, class182 var2, class60 var3, int var4) {
      var1.method2711();
      boolean var5 = true;
      Object var6 = null;
      int[] var10 = new int[]{var4};

      for(class134 var7 = (class134)var1.field2001.method2334(); null != var7; var7 = (class134)var1.field2001.method2335()) {
         int var8 = (int)var7.hash;
         class142 var9 = (class142)this.field1938.method2331((long)var8);
         if(var9 == null) {
            var9 = CombatInfo1.method645(var2, var8);
            if(var9 == null) {
               var5 = false;
               continue;
            }

            this.field1938.method2333(var9, (long)var8);
         }

         if(!var9.method2683(var3, var7.field1888, var10)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method2712();
      }

      return var5;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-12"
   )
   void method2501() {
      int var1 = this.field1941;
      int var2 = this.field1940;

      long var3;
      for(var3 = this.field1942; var2 == this.field1940; var3 = this.field1937.method2626(var2)) {
         while(this.field1937.field1974[var1] == var2) {
            this.field1937.method2619(var1);
            int var5 = this.field1937.method2645(var1);
            if(var5 == 1) {
               this.field1937.method2621();
               this.field1937.method2620(var1);
               if(this.field1937.method2628()) {
                  if(!this.field1933 || var2 == 0) {
                     this.method2488();
                     this.field1937.method2616();
                     return;
                  }

                  this.field1937.method2642(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method2491(var5);
            }

            this.field1937.method2635(var1);
            this.field1937.method2620(var1);
         }

         var1 = this.field1937.method2659();
         var2 = this.field1937.field1974[var1];
      }

      this.field1941 = var1;
      this.field1940 = var2;
      this.field1942 = var3;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)Z",
      garbageValue = "1125844257"
   )
   boolean method2502(class140 var1) {
      if(null == var1.field1970) {
         if(var1.field1962 >= 0) {
            var1.unlink();
            if(var1.field1966 > 0 && var1 == this.field1928[var1.field1959][var1.field1966]) {
               this.field1928[var1.field1959][var1.field1966] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public class139() {
      this.method2488();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1725314066"
   )
   void method2514(int var1, int var2, int var3) {
      class140 var4 = this.field1935[var1][var2];
      if(null != var4) {
         this.field1935[var1][var2] = null;
         if((this.field1917[var1] & 2) != 0) {
            for(class140 var5 = (class140)this.field1922.field2000.method2403(); null != var5; var5 = (class140)this.field1922.field2000.method2398()) {
               if(var5.field1959 == var4.field1959 && var5.field1962 < 0 && var5 != var4) {
                  var4.field1962 = 0;
                  break;
               }
            }
         } else {
            var4.field1962 = 0;
         }

      }
   }

   @ObfuscatedName("a")
   protected synchronized void vmethod2690(int var1) {
      if(this.field1937.method2617()) {
         int var2 = this.field1937.field1978 * this.field1919 / class57.field1045;

         do {
            long var3 = (long)var2 * (long)var1 + this.field1921;
            if(this.field1942 - var3 >= 0L) {
               this.field1921 = var3;
               break;
            }

            int var5 = (int)((this.field1942 - this.field1921 + (long)var2 - 1L) / (long)var2);
            this.field1921 += (long)var5 * (long)var2;
            this.field1922.vmethod2690(var5);
            var1 -= var5;
            this.method2501();
         } while(this.field1937.method2617());
      }

      this.field1922.vmethod2690(var1);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1220347155"
   )
   void method2526(int var1) {
      if((this.field1917[var1] & 2) != 0) {
         for(class140 var2 = (class140)this.field1922.field2000.method2403(); var2 != null; var2 = (class140)this.field1922.field2000.method2398()) {
            if(var2.field1959 == var1 && null == this.field1935[var1][var2.field1953] && var2.field1962 < 0) {
               var2.field1962 = 0;
            }
         }
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)I",
      garbageValue = "-2132860608"
   )
   int method2535(class140 var1) {
      int var2 = this.field1945[var1.field1959];
      return var2 < 8192?32 + var2 * var1.field1955 >> 6:16384 - (32 + (128 - var1.field1955) * (16384 - var2) >> 6);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2074716416"
   )
   public synchronized void method2552(int var1, int var2) {
      this.method2469(var1, var2);
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(Lclass140;[IIII)Z",
      garbageValue = "207769057"
   )
   boolean method2563(class140 var1, int[] var2, int var3, int var4) {
      var1.field1967 = class57.field1045 / 100;
      if(var1.field1962 < 0 || null != var1.field1970 && !var1.field1970.method1291()) {
         int var5 = var1.field1958;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field1943[var1.field1959]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field1958 = var5;
         }

         var1.field1970.method1207(this.method2493(var1));
         class137 var6 = var1.field1951;
         boolean var7 = false;
         ++var1.field1950;
         var1.field1965 += var6.field1900;
         double var8 = 5.086263020833333E-6D * (double)((var1.field1953 - 60 << 8) + (var1.field1958 * var1.field1957 >> 12));
         if(var6.field1898 > 0) {
            if(var6.field1903 > 0) {
               var1.field1952 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field1903) + 0.5D);
            } else {
               var1.field1952 += 128;
            }
         }

         if(null != var6.field1901) {
            if(var6.field1896 > 0) {
               var1.field1960 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field1896) + 0.5D);
            } else {
               var1.field1960 += 128;
            }

            while(var1.field1963 < var6.field1901.length - 2 && var1.field1960 > (var6.field1901[var1.field1963 + 2] & 255) << 8) {
               var1.field1963 += 2;
            }

            if(var1.field1963 == var6.field1901.length - 2 && var6.field1901[1 + var1.field1963] == 0) {
               var7 = true;
            }
         }

         if(var1.field1962 >= 0 && null != var6.field1894 && (this.field1917[var1.field1959] & 1) == 0 && (var1.field1966 < 0 || this.field1928[var1.field1959][var1.field1966] != var1)) {
            if(var6.field1897 > 0) {
               var1.field1962 += (int)(128.0D * Math.pow(2.0D, (double)var6.field1897 * var8) + 0.5D);
            } else {
               var1.field1962 += 128;
            }

            while(var1.field1956 < var6.field1894.length - 2 && var1.field1962 > (var6.field1894[var1.field1956 + 2] & 255) << 8) {
               var1.field1956 += 2;
            }

            if(var6.field1894.length - 2 == var1.field1956) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field1970.method1206(var1.field1967);
            if(var2 != null) {
               var1.field1970.vmethod2689(var2, var3, var4);
            } else {
               var1.field1970.vmethod2690(var4);
            }

            if(var1.field1970.method1189()) {
               this.field1922.field1997.method918(var1.field1970);
            }

            var1.method2612();
            if(var1.field1962 >= 0) {
               var1.unlink();
               if(var1.field1966 > 0 && this.field1928[var1.field1959][var1.field1966] == var1) {
                  this.field1928[var1.field1959][var1.field1966] = null;
               }
            }

            return true;
         } else {
            var1.field1970.method1205(var1.field1967, this.method2583(var1), this.method2535(var1));
            return false;
         }
      } else {
         var1.method2612();
         var1.unlink();
         if(var1.field1966 > 0 && this.field1928[var1.field1959][var1.field1966] == var1) {
            this.field1928[var1.field1959][var1.field1966] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("i")
   protected synchronized void vmethod2689(int[] var1, int var2, int var3) {
      if(this.field1937.method2617()) {
         int var4 = this.field1919 * this.field1937.field1978 / class57.field1045;

         do {
            long var5 = this.field1921 + (long)var3 * (long)var4;
            if(this.field1942 - var5 >= 0L) {
               this.field1921 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field1942 - this.field1921) - 1L) / (long)var4);
            this.field1921 += (long)var7 * (long)var4;
            this.field1922.vmethod2689(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method2501();
         } while(this.field1937.method2617());
      }

      this.field1922.vmethod2689(var1, var2, var3);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-745176466"
   )
   void method2582(int var1, int var2) {
      this.field1926[var1] = var2;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)I",
      garbageValue = "1797434861"
   )
   int method2583(class140 var1) {
      class137 var2 = var1.field1951;
      int var3 = this.field1920[var1.field1959] * this.field1936[var1.field1959] + 4096 >> 13;
      var3 = 16384 + var3 * var3 >> 15;
      var3 = var3 * var1.field1954 + 16384 >> 15;
      var3 = var3 * this.field1918 + 128 >> 8;
      if(var2.field1898 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field1898 * 1.953125E-5D * (double)var1.field1952) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(null != var2.field1901) {
         var4 = var1.field1960;
         var5 = var2.field1901[var1.field1963 + 1];
         if(var1.field1963 < var2.field1901.length - 2) {
            var6 = (var2.field1901[var1.field1963] & 255) << 8;
            var7 = (var2.field1901[2 + var1.field1963] & 255) << 8;
            var5 += (var2.field1901[3 + var1.field1963] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      if(var1.field1962 > 0 && var2.field1894 != null) {
         var4 = var1.field1962;
         var5 = var2.field1894[var1.field1956 + 1];
         if(var1.field1956 < var2.field1894.length - 2) {
            var6 = (var2.field1894[var1.field1956] & 255) << 8;
            var7 = (var2.field1894[2 + var1.field1956] & 255) << 8;
            var5 += (var2.field1894[3 + var1.field1956] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1491379662"
   )
   void method2592(int var1) {
      if((this.field1917[var1] & 4) != 0) {
         for(class140 var2 = (class140)this.field1922.field2000.method2403(); null != var2; var2 = (class140)this.field1922.field2000.method2398()) {
            if(var2.field1959 == var1) {
               var2.field1968 = 0;
            }
         }
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-70"
   )
   void method2593(int var1) {
      if(var1 >= 0) {
         this.field1920[var1] = 12800;
         this.field1945[var1] = 8192;
         this.field1936[var1] = 16383;
         this.field1926[var1] = 8192;
         this.field1927[var1] = 0;
         this.field1943[var1] = 8192;
         this.method2526(var1);
         this.method2592(var1);
         this.field1917[var1] = 0;
         this.field1930[var1] = 32767;
         this.field1929[var1] = 256;
         this.field1932[var1] = 0;
         this.method2492(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method2593(var1);
         }

      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-549483859"
   )
   public int method2598() {
      return this.field1918;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1631629227"
   )
   public synchronized void method2606() {
      for(class142 var1 = (class142)this.field1938.method2334(); null != var1; var1 = (class142)this.field1938.method2335()) {
         var1.method2671();
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Lclass182;Lclass139;I)Z",
      garbageValue = "-36446506"
   )
   public static boolean method2607(class182 var0, class182 var1, class182 var2, class139 var3) {
      class138.field1909 = var0;
      class138.field1911 = var1;
      class138.field1908 = var2;
      class138.field1906 = var3;
      return true;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "469731255"
   )
   public static int method2608(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0:(var2 == 2?7 - var1:var0));
   }
}

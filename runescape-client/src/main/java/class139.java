import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
public class class139 extends class68 {
   @ObfuscatedName("s")
   int[] field1926 = new int[16];
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1146237165
   )
   int field1927 = 256;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 252239593
   )
   int field1928 = 1000000;
   @ObfuscatedName("v")
   int[] field1929 = new int[16];
   @ObfuscatedName("x")
   XHashTable field1930 = new XHashTable(128);
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 2121434151
   )
   int field1931;
   @ObfuscatedName("j")
   int[] field1932 = new int[16];
   @ObfuscatedName("m")
   int[] field1933 = new int[16];
   @ObfuscatedName("aa")
   class143 field1934 = new class143(this);
   @ObfuscatedName("i")
   int[] field1935 = new int[16];
   @ObfuscatedName("y")
   int[] field1936 = new int[16];
   @ObfuscatedName("ac")
   class141 field1937 = new class141();
   @ObfuscatedName("r")
   int[] field1939 = new int[16];
   @ObfuscatedName("k")
   int[] field1941 = new int[16];
   @ObfuscatedName("e")
   int[] field1942 = new int[16];
   @ObfuscatedName("h")
   int[] field1943 = new int[16];
   @ObfuscatedName("d")
   int[] field1944 = new int[16];
   @ObfuscatedName("u")
   int[] field1945 = new int[16];
   @ObfuscatedName("t")
   class140[][] field1946 = new class140[16][128];
   @ObfuscatedName("ab")
   class140[][] field1947 = new class140[16][128];
   @ObfuscatedName("p")
   int[] field1948 = new int[16];
   @ObfuscatedName("au")
   boolean field1949;
   @ObfuscatedName("z")
   int[] field1950 = new int[16];
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 595007819
   )
   int field1951;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      longValue = 7431176806781404191L
   )
   long field1952;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      longValue = -8350979519009984559L
   )
   long field1953;
   @ObfuscatedName("a")
   int[] field1954 = new int[16];
   @ObfuscatedName("bf")
   static ModIcon[] field1955;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-128"
   )
   public synchronized void method2575(int var1) {
      this.field1927 = var1;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Lclass140;B)I",
      garbageValue = "81"
   )
   int method2576(class140 var1) {
      class137 var2 = var1.field1959;
      int var3 = this.field1929[var1.field1968] * this.field1948[var1.field1968] + 4096 >> 13;
      var3 = 16384 + var3 * var3 >> 15;
      var3 = var3 * var1.field1962 + 16384 >> 15;
      var3 = var3 * this.field1927 + 128 >> 8;
      if(var2.field1914 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var1.field1956 * 1.953125E-5D * (double)var2.field1914) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field1908 != null) {
         var4 = var1.field1972;
         var5 = var2.field1908[1 + var1.field1973];
         if(var1.field1973 < var2.field1908.length - 2) {
            var6 = (var2.field1908[var1.field1973] & 255) << 8;
            var7 = (var2.field1908[var1.field1973 + 2] & 255) << 8;
            var5 += (var2.field1908[3 + var1.field1973] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      if(var1.field1970 > 0 && null != var2.field1904) {
         var4 = var1.field1970;
         var5 = var2.field1904[1 + var1.field1969];
         if(var1.field1969 < var2.field1904.length - 2) {
            var6 = (var2.field1904[var1.field1969] & 255) << 8;
            var7 = (var2.field1904[var1.field1969 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field1904[3 + var1.field1969] - var5) / (var7 - var6);
         }

         var3 = 32 + var5 * var3 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-76206713"
   )
   static final void method2577(int var0) {
      class146.method2815();
      TextureProvider.method1507();
      int var1 = class142.method2762(var0).field2777;
      if(var1 != 0) {
         int var2 = class165.widgetSettings[var0];
         if(var1 == 1) {
            if(var2 == 1) {
               class84.method1728(0.9D);
               ((TextureProvider)class84.field1457).method1543(0.9D);
            }

            if(var2 == 2) {
               class84.method1728(0.8D);
               ((TextureProvider)class84.field1457).method1543(0.8D);
            }

            if(var2 == 3) {
               class84.method1728(0.7D);
               ((TextureProvider)class84.field1457).method1543(0.7D);
            }

            if(var2 == 4) {
               class84.method1728(0.6D);
               ((TextureProvider)class84.field1457).method1543(0.6D);
            }

            ItemComposition.itemSpriteCache.reset();
         }

         if(var1 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(Client.field544 != var3) {
               if(Client.field544 == 0 && Client.field528 != -1) {
                  class44.method892(Client.field306, Client.field528, 0, var3, false);
                  Client.field439 = false;
               } else if(var3 == 0) {
                  class138.field1919.method2672();
                  class138.field1921 = 1;
                  class138.field1924 = null;
                  Client.field439 = false;
               } else if(class138.field1921 != 0) {
                  class101.field1661 = var3;
               } else {
                  class138.field1919.method2575(var3);
               }

               Client.field544 = var3;
            }
         }

         if(var1 == 4) {
            if(var2 == 0) {
               Client.field530 = 127;
            }

            if(var2 == 1) {
               Client.field530 = 96;
            }

            if(var2 == 2) {
               Client.field530 = 64;
            }

            if(var2 == 3) {
               Client.field530 = 32;
            }

            if(var2 == 4) {
               Client.field530 = 0;
            }
         }

         if(var1 == 5) {
            Client.field360 = var2;
         }

         if(var1 == 6) {
            Client.field451 = var2;
         }

         if(var1 == 9) {
            Client.field452 = var2;
         }

         if(var1 == 10) {
            if(var2 == 0) {
               Client.field397 = 127;
            }

            if(var2 == 1) {
               Client.field397 = 96;
            }

            if(var2 == 2) {
               Client.field397 = 64;
            }

            if(var2 == 3) {
               Client.field397 = 32;
            }

            if(var2 == 4) {
               Client.field397 = 0;
            }
         }

         if(var1 == 17) {
            Client.field457 = var2 & '\uffff';
         }

         if(var1 == 18) {
            Client.field313 = (class40)Ignore.method207(Client.method296(), var2);
            if(null == Client.field313) {
               Client.field313 = class40.field816;
            }
         }

         if(var1 == 19) {
            if(var2 == -1) {
               Client.field418 = -1;
            } else {
               Client.field418 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            Client.field314 = (class40)Ignore.method207(Client.method296(), var2);
            if(Client.field314 == null) {
               Client.field314 = class40.field816;
            }
         }

      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   synchronized void method2578() {
      for(class142 var1 = (class142)this.field1930.method2440(); null != var1; var1 = (class142)this.field1930.method2441()) {
         var1.method2757();
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1808437211"
   )
   synchronized void method2579() {
      for(class142 var1 = (class142)this.field1930.method2440(); var1 != null; var1 = (class142)this.field1930.method2441()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass144;ZI)V",
      garbageValue = "-2029274752"
   )
   synchronized void method2580(class144 var1, boolean var2) {
      this.method2672();
      this.field1937.method2716(var1.field2008);
      this.field1949 = var2;
      this.field1952 = 0L;
      int var3 = this.field1937.method2710();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field1937.method2737(var4);
         this.field1937.method2714(var4);
         this.field1937.method2712(var4);
      }

      this.field1931 = this.field1937.method2719();
      this.field1951 = this.field1937.field1986[this.field1931];
      this.field1953 = this.field1937.method2729(this.field1951);
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-82366830"
   )
   void method2581(int var1, int var2) {
      this.field1944[var1] = var2;
      this.field1950[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "12"
   )
   public synchronized boolean method2582() {
      return this.field1937.method2711();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "25328"
   )
   public synchronized void method2583(int var1, int var2) {
      this.method2584(var1, var2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "8105"
   )
   void method2584(int var1, int var2) {
      this.field1932[var1] = var2;
      this.field1954[var1] = var2 & -128;
      this.method2585(var1, var2);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1870336657"
   )
   void method2585(int var1, int var2) {
      if(this.field1933[var1] != var2) {
         this.field1933[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field1947[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1346736109"
   )
   void method2586(int var1, int var2, int var3) {
      this.method2588(var1, var2, 64);
      if((this.field1939[var1] & 2) != 0) {
         for(class140 var4 = (class140)this.field1934.field2003.method2493(); null != var4; var4 = (class140)this.field1934.field2003.method2490()) {
            if(var1 == var4.field1968 && var4.field1970 < 0) {
               this.field1946[var1][var4.field1961] = null;
               this.field1946[var1][var2] = var4;
               int var5 = var4.field1964 + (var4.field1965 * var4.field1966 >> 12);
               var4.field1964 += var2 - var4.field1961 << 8;
               var4.field1965 = var5 - var4.field1964;
               var4.field1966 = 4096;
               var4.field1961 = var2;
               return;
            }
         }
      }

      class142 var9 = (class142)this.field1930.method2437((long)this.field1933[var1]);
      if(null != var9) {
         class55 var8 = var9.field1993[var2];
         if(null != var8) {
            class140 var6 = new class140();
            var6.field1968 = var1;
            var6.field1957 = var9;
            var6.field1958 = var8;
            var6.field1959 = var9.field1998[var2];
            var6.field1960 = var9.field1997[var2];
            var6.field1961 = var2;
            var6.field1962 = 1024 + var3 * var3 * var9.field1995 * var9.field2001[var2] >> 11;
            var6.field1963 = var9.field1996[var2] & 255;
            var6.field1964 = (var2 << 8) - (var9.field1992[var2] & 32767);
            var6.field1956 = 0;
            var6.field1972 = 0;
            var6.field1973 = 0;
            var6.field1970 = -1;
            var6.field1969 = 0;
            if(this.field1943[var1] == 0) {
               var6.field1974 = class66.method1257(var8, this.method2600(var6), this.method2576(var6), this.method2602(var6));
            } else {
               var6.field1974 = class66.method1257(var8, this.method2600(var6), 0, this.method2602(var6));
               this.method2587(var6, var9.field1992[var2] < 0);
            }

            if(var9.field1992[var2] < 0) {
               var6.field1974.method1259(-1);
            }

            if(var6.field1960 >= 0) {
               class140 var7 = this.field1947[var1][var6.field1960];
               if(var7 != null && var7.field1970 < 0) {
                  this.field1946[var1][var7.field1961] = null;
                  var7.field1970 = 0;
               }

               this.field1947[var1][var6.field1960] = var6;
            }

            this.field1934.field2003.method2511(var6);
            this.field1946[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass140;ZI)V",
      garbageValue = "1251236023"
   )
   void method2587(class140 var1, boolean var2) {
      int var3 = var1.field1958.field1034.length;
      int var4;
      if(var2 && var1.field1958.field1037) {
         int var5 = var3 + var3 - var1.field1958.field1036;
         var4 = (int)((long)var5 * (long)this.field1943[var1.field1968] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field1974.method1265();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field1943[var1.field1968] >> 6);
      }

      var1.field1974.method1333(var4);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1826133354"
   )
   void method2588(int var1, int var2, int var3) {
      class140 var4 = this.field1946[var1][var2];
      if(null != var4) {
         this.field1946[var1][var2] = null;
         if((this.field1939[var1] & 2) != 0) {
            for(class140 var5 = (class140)this.field1934.field2003.method2503(); var5 != null; var5 = (class140)this.field1934.field2003.method2492()) {
               if(var5.field1968 == var4.field1968 && var5.field1970 < 0 && var5 != var4) {
                  var4.field1970 = 0;
                  break;
               }
            }
         } else {
            var4.field1970 = 0;
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1347077678"
   )
   void method2589(int var1, int var2, int var3) {
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-41451588"
   )
   void method2591(int var1, int var2) {
      this.field1935[var1] = var2;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-84"
   )
   void method2592(int var1) {
      for(class140 var2 = (class140)this.field1934.field2003.method2503(); null != var2; var2 = (class140)this.field1934.field2003.method2492()) {
         if(var1 < 0 || var2.field1968 == var1) {
            if(var2.field1974 != null) {
               var2.field1974.method1269(class57.field1053 / 100);
               if(var2.field1974.method1273()) {
                  this.field1934.field2004.method1024(var2.field1974);
               }

               var2.method2700();
            }

            if(var2.field1970 < 0) {
               this.field1946[var2.field1968][var2.field1961] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1558713825"
   )
   void method2593(int var1) {
      if(var1 >= 0) {
         this.field1929[var1] = 12800;
         this.field1936[var1] = 8192;
         this.field1948[var1] = 16383;
         this.field1935[var1] = 8192;
         this.field1926[var1] = 0;
         this.field1941[var1] = 8192;
         this.method2596(var1);
         this.method2695(var1);
         this.field1939[var1] = 0;
         this.field1945[var1] = 32767;
         this.field1942[var1] = 256;
         this.field1943[var1] = 0;
         this.method2581(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method2593(var1);
         }

      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1621343071"
   )
   void method2594(int var1) {
      for(class140 var2 = (class140)this.field1934.field2003.method2503(); null != var2; var2 = (class140)this.field1934.field2003.method2492()) {
         if((var1 < 0 || var2.field1968 == var1) && var2.field1970 < 0) {
            this.field1946[var2.field1968][var2.field1961] = null;
            var2.field1970 = 0;
         }
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2029188341"
   )
   void method2595() {
      this.method2592(-1);
      this.method2593(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field1933[var1] = this.field1932[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field1954[var1] = this.field1932[var1] & -128;
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "948708978"
   )
   void method2596(int var1) {
      if((this.field1939[var1] & 2) != 0) {
         for(class140 var2 = (class140)this.field1934.field2003.method2503(); var2 != null; var2 = (class140)this.field1934.field2003.method2492()) {
            if(var2.field1968 == var1 && this.field1946[var1][var2.field1961] == null && var2.field1970 < 0) {
               var2.field1970 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Lclass140;B)I",
      garbageValue = "1"
   )
   int method2600(class140 var1) {
      int var2 = var1.field1964 + (var1.field1965 * var1.field1966 >> 12);
      var2 += (this.field1935[var1.field1968] - 8192) * this.field1942[var1.field1968] >> 12;
      class137 var3 = var1.field1959;
      int var4;
      if(var3.field1911 > 0 && (var3.field1910 > 0 || this.field1926[var1.field1968] > 0)) {
         var4 = var3.field1910 << 2;
         int var5 = var3.field1912 << 1;
         if(var1.field1975 < var5) {
            var4 = var4 * var1.field1975 / var5;
         }

         var4 += this.field1926[var1.field1968] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field1967 & 511));
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(256 * var1.field1958.field1035) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)class57.field1053 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)I",
      garbageValue = "2037222512"
   )
   int method2602(class140 var1) {
      int var2 = this.field1936[var1.field1968];
      return var2 < 8192?var2 * var1.field1963 + 32 >> 6:16384 - ((128 - var1.field1963) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("p")
   protected synchronized class68 vmethod2765() {
      return this.field1934;
   }

   @ObfuscatedName("s")
   protected synchronized int vmethod2767() {
      return 0;
   }

   @ObfuscatedName("k")
   protected synchronized void vmethod2780(int[] var1, int var2, int var3) {
      if(this.field1937.method2711()) {
         int var4 = this.field1928 * this.field1937.field1987 / class57.field1053;

         do {
            long var5 = this.field1952 + (long)var3 * (long)var4;
            if(this.field1953 - var5 >= 0L) {
               this.field1952 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field1953 - this.field1952) - 1L) / (long)var4);
            this.field1952 += (long)var7 * (long)var4;
            this.field1934.vmethod2780(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method2608();
         } while(this.field1937.method2711());
      }

      this.field1934.vmethod2780(var1, var2, var3);
   }

   @ObfuscatedName("o")
   protected synchronized void vmethod2769(int var1) {
      if(this.field1937.method2711()) {
         int var2 = this.field1937.field1987 * this.field1928 / class57.field1053;

         do {
            long var3 = this.field1952 + (long)var2 * (long)var1;
            if(this.field1953 - var3 >= 0L) {
               this.field1952 = var3;
               break;
            }

            int var5 = (int)((this.field1953 - this.field1952 + (long)var2 - 1L) / (long)var2);
            this.field1952 += (long)var5 * (long)var2;
            this.field1934.vmethod2769(var5);
            var1 -= var5;
            this.method2608();
         } while(this.field1937.method2711());
      }

      this.field1934.vmethod2769(var1);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1856475183"
   )
   void method2608() {
      int var1 = this.field1931;
      int var2 = this.field1951;

      long var3;
      for(var3 = this.field1953; var2 == this.field1951; var3 = this.field1937.method2729(var2)) {
         while(this.field1937.field1986[var1] == var2) {
            this.field1937.method2737(var1);
            int var5 = this.field1937.method2745(var1);
            if(var5 == 1) {
               this.field1937.method2713();
               this.field1937.method2712(var1);
               if(this.field1937.method2720()) {
                  if(!this.field1949 || var2 == 0) {
                     this.method2595();
                     this.field1937.method2708();
                     return;
                  }

                  this.field1937.method2734(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method2676(var5);
            }

            this.field1937.method2714(var1);
            this.field1937.method2712(var1);
         }

         var1 = this.field1937.method2719();
         var2 = this.field1937.field1986[var1];
      }

      this.field1931 = var1;
      this.field1951 = var2;
      this.field1953 = var3;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)Z",
      garbageValue = "905462643"
   )
   boolean method2609(class140 var1) {
      if(null == var1.field1974) {
         if(var1.field1970 >= 0) {
            var1.unlink();
            if(var1.field1960 > 0 && var1 == this.field1947[var1.field1968][var1.field1960]) {
               this.field1947[var1.field1968][var1.field1960] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public class139() {
      this.method2595();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass144;Lclass182;Lclass60;II)Z",
      garbageValue = "-1669439965"
   )
   synchronized boolean method2648(class144 var1, class182 var2, class60 var3, int var4) {
      var1.method2792();
      boolean var5 = true;
      Object var6 = null;
      int[] var12 = new int[]{var4};

      for(class134 var7 = (class134)var1.field2007.method2440(); var7 != null; var7 = (class134)var1.field2007.method2441()) {
         int var8 = (int)var7.hash;
         class142 var9 = (class142)this.field1930.method2437((long)var8);
         if(var9 == null) {
            byte[] var11 = var2.method3360(var8);
            class142 var10;
            if(var11 == null) {
               var10 = null;
            } else {
               var10 = new class142(var11);
            }

            var9 = var10;
            if(var10 == null) {
               var5 = false;
               continue;
            }

            this.field1930.method2438(var10, (long)var8);
         }

         if(!var9.method2759(var3, var7.field1899, var12)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method2797();
      }

      return var5;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "251477488"
   )
   public synchronized void method2672() {
      this.field1937.method2708();
      this.method2595();
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "14"
   )
   void method2676(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method2588(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method2586(var3, var4, var5);
         } else {
            this.method2588(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method2589(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field1954[var3] = (var5 << 14) + (this.field1954[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field1954[var3] = (var5 << 7) + (this.field1954[var3] & -16257);
         }

         if(var4 == 1) {
            this.field1926[var3] = (var5 << 7) + (this.field1926[var3] & -16257);
         }

         if(var4 == 33) {
            this.field1926[var3] = (this.field1926[var3] & -128) + var5;
         }

         if(var4 == 5) {
            this.field1941[var3] = (var5 << 7) + (this.field1941[var3] & -16257);
         }

         if(var4 == 37) {
            this.field1941[var3] = (this.field1941[var3] & -128) + var5;
         }

         if(var4 == 7) {
            this.field1929[var3] = (var5 << 7) + (this.field1929[var3] & -16257);
         }

         if(var4 == 39) {
            this.field1929[var3] = (this.field1929[var3] & -128) + var5;
         }

         if(var4 == 10) {
            this.field1936[var3] = (this.field1936[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 42) {
            this.field1936[var3] = var5 + (this.field1936[var3] & -128);
         }

         if(var4 == 11) {
            this.field1948[var3] = (var5 << 7) + (this.field1948[var3] & -16257);
         }

         if(var4 == 43) {
            this.field1948[var3] = (this.field1948[var3] & -128) + var5;
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field1939[var3] |= 1;
            } else {
               this.field1939[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field1939[var3] |= 2;
            } else {
               this.method2596(var3);
               this.field1939[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field1945[var3] = (this.field1945[var3] & 127) + (var5 << 7);
         }

         if(var4 == 98) {
            this.field1945[var3] = var5 + (this.field1945[var3] & 16256);
         }

         if(var4 == 101) {
            this.field1945[var3] = (var5 << 7) + 16384 + (this.field1945[var3] & 127);
         }

         if(var4 == 100) {
            this.field1945[var3] = var5 + 16384 + (this.field1945[var3] & 16256);
         }

         if(var4 == 120) {
            this.method2592(var3);
         }

         if(var4 == 121) {
            this.method2593(var3);
         }

         if(var4 == 123) {
            this.method2594(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field1945[var3];
            if(var6 == 16384) {
               this.field1942[var3] = (var5 << 7) + (this.field1942[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field1945[var3];
            if(var6 == 16384) {
               this.field1942[var3] = var5 + (this.field1942[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field1943[var3] = (var5 << 7) + (this.field1943[var3] & -16257);
         }

         if(var4 == 48) {
            this.field1943[var3] = var5 + (this.field1943[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field1939[var3] |= 4;
            } else {
               this.method2695(var3);
               this.field1939[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method2581(var3, (this.field1944[var3] & -16257) + (var5 << 7));
         }

         if(var4 == 49) {
            this.method2581(var3, var5 + (this.field1944[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method2585(var3, var4 + this.field1954[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method2694(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method2591(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method2595();
         }
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Lclass140;[IIII)Z",
      garbageValue = "-1793382126"
   )
   boolean method2686(class140 var1, int[] var2, int var3, int var4) {
      var1.field1971 = class57.field1053 / 100;
      if(var1.field1970 < 0 || var1.field1974 != null && !var1.field1974.method1272()) {
         int var5 = var1.field1966;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field1941[var1.field1968]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field1966 = var5;
         }

         var1.field1974.method1270(this.method2600(var1));
         class137 var6 = var1.field1959;
         boolean var7 = false;
         ++var1.field1975;
         var1.field1967 += var6.field1911;
         double var8 = (double)((var1.field1965 * var1.field1966 >> 12) + (var1.field1961 - 60 << 8)) * 5.086263020833333E-6D;
         if(var6.field1914 > 0) {
            if(var6.field1905 > 0) {
               var1.field1956 += (int)(128.0D * Math.pow(2.0D, (double)var6.field1905 * var8) + 0.5D);
            } else {
               var1.field1956 += 128;
            }
         }

         if(var6.field1908 != null) {
            if(var6.field1907 > 0) {
               var1.field1972 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field1907) + 0.5D);
            } else {
               var1.field1972 += 128;
            }

            while(var1.field1973 < var6.field1908.length - 2 && var1.field1972 > (var6.field1908[var1.field1973 + 2] & 255) << 8) {
               var1.field1973 += 2;
            }

            if(var6.field1908.length - 2 == var1.field1973 && var6.field1908[1 + var1.field1973] == 0) {
               var7 = true;
            }
         }

         if(var1.field1970 >= 0 && null != var6.field1904 && (this.field1939[var1.field1968] & 1) == 0 && (var1.field1960 < 0 || this.field1947[var1.field1968][var1.field1960] != var1)) {
            if(var6.field1906 > 0) {
               var1.field1970 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field1906) + 0.5D);
            } else {
               var1.field1970 += 128;
            }

            while(var1.field1969 < var6.field1904.length - 2 && var1.field1970 > (var6.field1904[2 + var1.field1969] & 255) << 8) {
               var1.field1969 += 2;
            }

            if(var6.field1904.length - 2 == var1.field1969) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field1974.method1269(var1.field1971);
            if(null != var2) {
               var1.field1974.vmethod2780(var2, var3, var4);
            } else {
               var1.field1974.vmethod2769(var4);
            }

            if(var1.field1974.method1273()) {
               this.field1934.field2004.method1024(var1.field1974);
            }

            var1.method2700();
            if(var1.field1970 >= 0) {
               var1.unlink();
               if(var1.field1960 > 0 && this.field1947[var1.field1968][var1.field1960] == var1) {
                  this.field1947[var1.field1968][var1.field1960] = null;
               }
            }

            return true;
         } else {
            var1.field1974.method1268(var1.field1971, this.method2576(var1), this.method2602(var1));
            return false;
         }
      } else {
         var1.method2700();
         var1.unlink();
         if(var1.field1960 > 0 && this.field1947[var1.field1968][var1.field1960] == var1) {
            this.field1947[var1.field1968][var1.field1960] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-1"
   )
   void method2694(int var1, int var2) {
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "385405136"
   )
   void method2695(int var1) {
      if((this.field1939[var1] & 4) != 0) {
         for(class140 var2 = (class140)this.field1934.field2003.method2503(); var2 != null; var2 = (class140)this.field1934.field2003.method2492()) {
            if(var1 == var2.field1968) {
               var2.field1976 = 0;
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1213656482"
   )
   int method2696() {
      return this.field1927;
   }

   @ObfuscatedName("j")
   protected synchronized class68 vmethod2775() {
      return null;
   }
}

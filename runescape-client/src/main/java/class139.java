import java.awt.Container;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
public class class139 extends class68 {
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      longValue = -4370484675493018263L
   )
   long field1946;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -778826367
   )
   int field1947 = 256;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2060523157
   )
   int field1948 = 1000000;
   @ObfuscatedName("h")
   int[] field1949 = new int[16];
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1611886343
   )
   int field1950;
   @ObfuscatedName("j")
   int[] field1951 = new int[16];
   @ObfuscatedName("o")
   int[] field1952 = new int[16];
   @ObfuscatedName("n")
   int[] field1953 = new int[16];
   @ObfuscatedName("m")
   int[] field1954 = new int[16];
   @ObfuscatedName("l")
   int[] field1955 = new int[16];
   @ObfuscatedName("s")
   int[] field1956 = new int[16];
   @ObfuscatedName("b")
   int[] field1957 = new int[16];
   @ObfuscatedName("x")
   int[] field1958 = new int[16];
   @ObfuscatedName("g")
   int[] field1959 = new int[16];
   @ObfuscatedName("r")
   int[] field1960 = new int[16];
   @ObfuscatedName("q")
   int[] field1961 = new int[16];
   @ObfuscatedName("t")
   int[] field1962 = new int[16];
   @ObfuscatedName("c")
   int[] field1963 = new int[16];
   @ObfuscatedName("e")
   class140[][] field1964 = new class140[16][128];
   @ObfuscatedName("am")
   class140[][] field1965 = new class140[16][128];
   @ObfuscatedName("an")
   class141 field1966 = new class141();
   @ObfuscatedName("aq")
   boolean field1967;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1622743633
   )
   int field1968;
   @ObfuscatedName("k")
   int[] field1969 = new int[16];
   @ObfuscatedName("f")
   XHashTable field1970 = new XHashTable(128);
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      longValue = -392417170947753811L
   )
   long field1971;
   @ObfuscatedName("ax")
   class143 field1972 = new class143(this);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1804411553"
   )
   public int method2554() {
      return this.field1947;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1897914548"
   )
   public synchronized boolean method2555() {
      return this.field1966.method2689();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1705592708"
   )
   synchronized void method2556() {
      for(class142 var1 = (class142)this.field1970.method2420(); var1 != null; var1 = (class142)this.field1970.method2422()) {
         var1.method2737();
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2121023221"
   )
   public synchronized void method2557() {
      for(class142 var1 = (class142)this.field1970.method2420(); var1 != null; var1 = (class142)this.field1970.method2422()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass144;ZB)V",
      garbageValue = "27"
   )
   synchronized void method2558(Track1 var1, boolean var2) {
      this.method2591();
      this.field1966.method2687(var1.field2028);
      this.field1967 = var2;
      this.field1946 = 0L;
      int var3 = this.field1966.method2725();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field1966.method2728(var4);
         this.field1966.method2694(var4);
         this.field1966.method2692(var4);
      }

      this.field1968 = this.field1966.method2699();
      this.field1950 = this.field1966.field1997[this.field1968];
      this.field1971 = this.field1966.method2698(this.field1950);
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   void method2561(int var1) {
      if((this.field1958[var1] & 2) != 0) {
         for(class140 var2 = (class140)this.field1972.field2024.method2464(); var2 != null; var2 = (class140)this.field1972.field2024.method2472()) {
            if(var1 == var2.field1990 && this.field1964[var1][var2.field1980] == null && var2.field1983 < 0) {
               var2.field1983 = 0;
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "17432792"
   )
   public synchronized void method2564(int var1) {
      this.field1947 = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1618916942"
   )
   void method2566(int var1, int var2, int var3) {
      class140 var4 = this.field1964[var1][var2];
      if(var4 != null) {
         this.field1964[var1][var2] = null;
         if((this.field1958[var1] & 2) != 0) {
            for(class140 var5 = (class140)this.field1972.field2024.method2464(); var5 != null; var5 = (class140)this.field1972.field2024.method2472()) {
               if(var4.field1990 == var5.field1990 && var5.field1983 < 0 && var4 != var5) {
                  var4.field1983 = 0;
                  break;
               }
            }
         } else {
            var4.field1983 = 0;
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1196757923"
   )
   void method2567(int var1, int var2, int var3) {
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "68"
   )
   void method2568(int var1, int var2) {
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1604619223"
   )
   void method2569(int var1, int var2) {
      this.field1951[var1] = var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "340904662"
   )
   void method2571(int var1) {
      if(var1 >= 0) {
         this.field1949[var1] = 12800;
         this.field1960[var1] = 8192;
         this.field1952[var1] = 16383;
         this.field1951[var1] = 8192;
         this.field1956[var1] = 0;
         this.field1961[var1] = 8192;
         this.method2561(var1);
         this.method2575(var1);
         this.field1958[var1] = 0;
         this.field1959[var1] = 32767;
         this.field1957[var1] = 256;
         this.field1969[var1] = 0;
         this.method2616(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method2571(var1);
         }
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "47"
   )
   void method2572(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method2566(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method2603(var3, var4, var5);
         } else {
            this.method2566(var3, var4, 64);
         }
      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method2567(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field1954[var3] = (this.field1954[var3] & -2080769) + (var5 << 14);
         }

         if(var4 == 32) {
            this.field1954[var3] = (var5 << 7) + (this.field1954[var3] & -16257);
         }

         if(var4 == 1) {
            this.field1956[var3] = (var5 << 7) + (this.field1956[var3] & -16257);
         }

         if(var4 == 33) {
            this.field1956[var3] = (this.field1956[var3] & -128) + var5;
         }

         if(var4 == 5) {
            this.field1961[var3] = (this.field1961[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 37) {
            this.field1961[var3] = (this.field1961[var3] & -128) + var5;
         }

         if(var4 == 7) {
            this.field1949[var3] = (var5 << 7) + (this.field1949[var3] & -16257);
         }

         if(var4 == 39) {
            this.field1949[var3] = (this.field1949[var3] & -128) + var5;
         }

         if(var4 == 10) {
            this.field1960[var3] = (var5 << 7) + (this.field1960[var3] & -16257);
         }

         if(var4 == 42) {
            this.field1960[var3] = (this.field1960[var3] & -128) + var5;
         }

         if(var4 == 11) {
            this.field1952[var3] = (this.field1952[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 43) {
            this.field1952[var3] = var5 + (this.field1952[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field1958[var3] |= 1;
            } else {
               this.field1958[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field1958[var3] |= 2;
            } else {
               this.method2561(var3);
               this.field1958[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field1959[var3] = (this.field1959[var3] & 127) + (var5 << 7);
         }

         if(var4 == 98) {
            this.field1959[var3] = (this.field1959[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field1959[var3] = (var5 << 7) + 16384 + (this.field1959[var3] & 127);
         }

         if(var4 == 100) {
            this.field1959[var3] = var5 + 16384 + (this.field1959[var3] & 16256);
         }

         if(var4 == 120) {
            this.method2576(var3);
         }

         if(var4 == 121) {
            this.method2571(var3);
         }

         if(var4 == 123) {
            this.method2642(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field1959[var3];
            if(var6 == 16384) {
               this.field1957[var3] = (var5 << 7) + (this.field1957[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field1959[var3];
            if(var6 == 16384) {
               this.field1957[var3] = (this.field1957[var3] & -128) + var5;
            }
         }

         if(var4 == 16) {
            this.field1969[var3] = (this.field1969[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 48) {
            this.field1969[var3] = (this.field1969[var3] & -128) + var5;
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field1958[var3] |= 4;
            } else {
               this.method2575(var3);
               this.field1958[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method2616(var3, (var5 << 7) + (this.field1962[var3] & -16257));
         }

         if(var4 == 49) {
            this.method2616(var3, var5 + (this.field1962[var3] & -128));
         }
      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method2658(var3, var4 + this.field1954[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method2568(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 9 & 16256) + (var1 >> 8 & 127);
         this.method2569(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method2573();
         }
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   void method2573() {
      this.method2576(-1);
      this.method2571(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field1953[var1] = this.field1955[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field1954[var1] = this.field1955[var1] & -128;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass140;ZB)V",
      garbageValue = "2"
   )
   void method2574(class140 var1, boolean var2) {
      int var3 = var1.field1986.field1044.length;
      int var4;
      if(var2 && var1.field1986.field1048) {
         int var5 = var3 + var3 - var1.field1986.field1045;
         var4 = (int)((long)var5 * (long)this.field1969[var1.field1990] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field1993.method1221();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field1969[var1.field1990] >> 6);
      }

      var1.field1993.method1220(var4);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1365307049"
   )
   void method2575(int var1) {
      if((this.field1958[var1] & 4) != 0) {
         for(class140 var2 = (class140)this.field1972.field2024.method2464(); var2 != null; var2 = (class140)this.field1972.field2024.method2472()) {
            if(var1 == var2.field1990) {
               var2.field1996 = 0;
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1769492505"
   )
   void method2576(int var1) {
      for(class140 var2 = (class140)this.field1972.field2024.method2464(); var2 != null; var2 = (class140)this.field1972.field2024.method2472()) {
         if(var1 < 0 || var1 == var2.field1990) {
            if(var2.field1993 != null) {
               var2.field1993.method1246(class57.field1077 / 100);
               if(var2.field1993.method1227()) {
                  this.field1972.field2023.method942(var2.field1993);
               }

               var2.method2682();
            }

            if(var2.field1983 < 0) {
               this.field1964[var2.field1990][var2.field1980] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1978540958"
   )
   public synchronized void method2577(int var1, int var2) {
      this.method2586(var1, var2);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)I",
      garbageValue = "-1858271523"
   )
   int method2578(class140 var1) {
      int var2 = (var1.field1985 * var1.field1984 >> 12) + var1.field1981;
      var2 += this.field1957[var1.field1990] * (this.field1951[var1.field1990] - 8192) >> 12;
      class137 var3 = var1.field1995;
      int var4;
      if(var3.field1931 > 0 && (var3.field1934 > 0 || this.field1956[var1.field1990] > 0)) {
         var4 = var3.field1934 << 2;
         int var5 = var3.field1932 << 1;
         if(var1.field1991 < var5) {
            var4 = var1.field1991 * var4 / var5;
         }

         var4 += this.field1956[var1.field1990] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field1992 & 511));
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(var1.field1986.field1047 * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)class57.field1077 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)I",
      garbageValue = "-1969969123"
   )
   int method2579(class140 var1) {
      class137 var2 = var1.field1995;
      int var3 = this.field1952[var1.field1990] * this.field1949[var1.field1990] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var1.field1977 * var3 + 16384 >> 15;
      var3 = var3 * this.field1947 + 128 >> 8;
      if(var2.field1926 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field1926 * 1.953125E-5D * (double)var1.field1975) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field1924 != null) {
         var4 = var1.field1987;
         var5 = var2.field1924[var1.field1988 + 1];
         if(var1.field1988 < var2.field1924.length - 2) {
            var6 = (var2.field1924[var1.field1988] & 255) << 8;
            var7 = (var2.field1924[var1.field1988 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field1924[var1.field1988 + 3] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      if(var1.field1983 > 0 && var2.field1925 != null) {
         var4 = var1.field1983;
         var5 = var2.field1925[var1.field1989 + 1];
         if(var1.field1989 < var2.field1925.length - 2) {
            var6 = (var2.field1925[var1.field1989] & 255) << 8;
            var7 = (var2.field1925[var1.field1989 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field1925[var1.field1989 + 3] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)I",
      garbageValue = "977486015"
   )
   int method2580(class140 var1) {
      int var2 = this.field1960[var1.field1990];
      return var2 < 8192?var1.field1978 * var2 + 32 >> 6:16384 - ((16384 - var2) * (128 - var1.field1978) + 32 >> 6);
   }

   @ObfuscatedName("l")
   protected synchronized class68 vmethod2768() {
      return this.field1972;
   }

   @ObfuscatedName("n")
   protected synchronized class68 vmethod2753() {
      return null;
   }

   @ObfuscatedName("m")
   protected synchronized int vmethod2766() {
      return 0;
   }

   @ObfuscatedName("w")
   protected synchronized void vmethod2755(int[] var1, int var2, int var3) {
      if(this.field1966.method2689()) {
         int var4 = this.field1948 * this.field1966.field1998 / class57.field1077;

         do {
            long var5 = this.field1946 + (long)var3 * (long)var4;
            if(this.field1971 - var5 >= 0L) {
               this.field1946 = var5;
               break;
            }

            int var7 = (int)((this.field1971 - this.field1946 + (long)var4 - 1L) / (long)var4);
            this.field1946 += (long)var4 * (long)var7;
            this.field1972.vmethod2755(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method2622();
         } while(this.field1966.method2689());
      }

      this.field1972.vmethod2755(var1, var2, var3);
   }

   @ObfuscatedName("s")
   protected synchronized void vmethod2756(int var1) {
      if(this.field1966.method2689()) {
         int var2 = this.field1948 * this.field1966.field1998 / class57.field1077;

         do {
            long var3 = this.field1946 + (long)var1 * (long)var2;
            if(this.field1971 - var3 >= 0L) {
               this.field1946 = var3;
               break;
            }

            int var5 = (int)((this.field1971 - this.field1946 + (long)var2 - 1L) / (long)var2);
            this.field1946 += (long)var2 * (long)var5;
            this.field1972.vmethod2756(var5);
            var1 -= var5;
            this.method2622();
         } while(this.field1966.method2689());
      }

      this.field1972.vmethod2756(var1);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "52"
   )
   void method2586(int var1, int var2) {
      this.field1955[var1] = var2;
      this.field1954[var1] = var2 & -128;
      this.method2658(var1, var2);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Lclass140;I)Z",
      garbageValue = "2019243094"
   )
   boolean method2587(class140 var1) {
      if(var1.field1993 == null) {
         if(var1.field1983 >= 0) {
            var1.unlink();
            if(var1.field1979 > 0 && this.field1965[var1.field1990][var1.field1979] == var1) {
               this.field1965[var1.field1990][var1.field1979] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Lclass140;[IIII)Z",
      garbageValue = "-2076578155"
   )
   boolean method2588(class140 var1, int[] var2, int var3, int var4) {
      var1.field1994 = class57.field1077 / 100;
      if(var1.field1983 < 0 || var1.field1993 != null && !var1.field1993.method1320()) {
         int var5 = var1.field1985;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field1961[var1.field1990] * 4.921259842519685E-4D) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field1985 = var5;
         }

         var1.field1993.method1286(this.method2578(var1));
         class137 var6 = var1.field1995;
         boolean var7 = false;
         ++var1.field1991;
         var1.field1992 += var6.field1931;
         double var8 = (double)((var1.field1980 - 60 << 8) + (var1.field1985 * var1.field1984 >> 12)) * 5.086263020833333E-6D;
         if(var6.field1926 > 0) {
            if(var6.field1929 > 0) {
               var1.field1975 += (int)(128.0D * Math.pow(2.0D, (double)var6.field1929 * var8) + 0.5D);
            } else {
               var1.field1975 += 128;
            }
         }

         if(var6.field1924 != null) {
            if(var6.field1930 > 0) {
               var1.field1987 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field1930) + 0.5D);
            } else {
               var1.field1987 += 128;
            }

            while(var1.field1988 < var6.field1924.length - 2 && var1.field1987 > (var6.field1924[var1.field1988 + 2] & 255) << 8) {
               var1.field1988 += 2;
            }

            if(var6.field1924.length - 2 == var1.field1988 && var6.field1924[var1.field1988 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field1983 >= 0 && var6.field1925 != null && (this.field1958[var1.field1990] & 1) == 0 && (var1.field1979 < 0 || var1 != this.field1965[var1.field1990][var1.field1979])) {
            if(var6.field1928 > 0) {
               var1.field1983 += (int)(128.0D * Math.pow(2.0D, (double)var6.field1928 * var8) + 0.5D);
            } else {
               var1.field1983 += 128;
            }

            while(var1.field1989 < var6.field1925.length - 2 && var1.field1983 > (var6.field1925[var1.field1989 + 2] & 255) << 8) {
               var1.field1989 += 2;
            }

            if(var6.field1925.length - 2 == var1.field1989) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field1993.method1246(var1.field1994);
            if(var2 != null) {
               var1.field1993.vmethod2755(var2, var3, var4);
            } else {
               var1.field1993.vmethod2756(var4);
            }

            if(var1.field1993.method1227()) {
               this.field1972.field2023.method942(var1.field1993);
            }

            var1.method2682();
            if(var1.field1983 >= 0) {
               var1.unlink();
               if(var1.field1979 > 0 && var1 == this.field1965[var1.field1990][var1.field1979]) {
                  this.field1965[var1.field1990][var1.field1979] = null;
               }
            }

            return true;
         } else {
            var1.field1993.method1224(var1.field1994, this.method2579(var1), this.method2580(var1));
            return false;
         }
      } else {
         var1.method2682();
         var1.unlink();
         if(var1.field1979 > 0 && var1 == this.field1965[var1.field1990][var1.field1979]) {
            this.field1965[var1.field1990][var1.field1979] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-11318"
   )
   public synchronized void method2591() {
      this.field1966.method2714();
      this.method2573();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1557258578"
   )
   void method2603(int var1, int var2, int var3) {
      this.method2566(var1, var2, 64);
      if((this.field1958[var1] & 2) != 0) {
         for(class140 var4 = (class140)this.field1972.field2024.method2469(); var4 != null; var4 = (class140)this.field1972.field2024.method2467()) {
            if(var1 == var4.field1990 && var4.field1983 < 0) {
               this.field1964[var1][var4.field1980] = null;
               this.field1964[var1][var2] = var4;
               int var5 = var4.field1981 + (var4.field1984 * var4.field1985 >> 12);
               var4.field1981 += var2 - var4.field1980 << 8;
               var4.field1984 = var5 - var4.field1981;
               var4.field1985 = 4096;
               var4.field1980 = var2;
               return;
            }
         }
      }

      class142 var8 = (class142)this.field1970.method2417((long)this.field1953[var1]);
      if(var8 != null) {
         class55 var9 = var8.field2019[var2];
         if(var9 != null) {
            class140 var6 = new class140();
            var6.field1990 = var1;
            var6.field1976 = var8;
            var6.field1986 = var9;
            var6.field1995 = var8.field2017[var2];
            var6.field1979 = var8.field2012[var2];
            var6.field1980 = var2;
            var6.field1977 = var8.field2014[var2] * var3 * var3 * var8.field2016 + 1024 >> 11;
            var6.field1978 = var8.field2015[var2] & 255;
            var6.field1981 = (var2 << 8) - (var8.field2013[var2] & 32767);
            var6.field1975 = 0;
            var6.field1987 = 0;
            var6.field1988 = 0;
            var6.field1983 = -1;
            var6.field1989 = 0;
            if(this.field1969[var1] == 0) {
               var6.field1993 = class66.method1266(var9, this.method2578(var6), this.method2579(var6), this.method2580(var6));
            } else {
               var6.field1993 = class66.method1266(var9, this.method2578(var6), 0, this.method2580(var6));
               this.method2574(var6, var8.field2013[var2] < 0);
            }

            if(var8.field2013[var2] < 0) {
               var6.field1993.method1217(-1);
            }

            if(var6.field1979 >= 0) {
               class140 var7 = this.field1965[var1][var6.field1979];
               if(var7 != null && var7.field1983 < 0) {
                  this.field1964[var1][var7.field1980] = null;
                  var7.field1983 = 0;
               }

               this.field1965[var1][var6.field1979] = var6;
            }

            this.field1972.field2024.method2459(var6);
            this.field1964[var1][var2] = var6;
         }
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-23"
   )
   void method2616(int var1, int var2) {
      this.field1962[var1] = var2;
      this.field1963[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "11"
   )
   void method2622() {
      int var1 = this.field1968;
      int var2 = this.field1950;

      long var3;
      for(var3 = this.field1971; var2 == this.field1950; var3 = this.field1966.method2698(var2)) {
         while(var2 == this.field1966.field1997[var1]) {
            this.field1966.method2728(var1);
            int var5 = this.field1966.method2695(var1);
            if(var5 == 1) {
               this.field1966.method2721();
               this.field1966.method2692(var1);
               if(this.field1966.method2704()) {
                  if(!this.field1967 || var2 == 0) {
                     this.method2573();
                     this.field1966.method2714();
                     return;
                  }

                  this.field1966.method2701(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method2572(var5);
            }

            this.field1966.method2694(var1);
            this.field1966.method2692(var1);
         }

         var1 = this.field1966.method2699();
         var2 = this.field1966.field1997[var1];
      }

      this.field1968 = var1;
      this.field1950 = var2;
      this.field1971 = var3;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass144;Lclass182;Lclass60;II)Z",
      garbageValue = "381584175"
   )
   synchronized boolean method2638(Track1 var1, IndexDataBase var2, class60 var3, int var4) {
      var1.method2785();
      boolean var5 = true;
      Object var6 = null;
      int[] var7 = new int[]{var4};

      for(class134 var8 = (class134)var1.field2029.method2420(); var8 != null; var8 = (class134)var1.field2029.method2422()) {
         int var9 = (int)var8.hash;
         class142 var10 = (class142)this.field1970.method2417((long)var9);
         if(var10 == null) {
            byte[] var11 = var2.method3389(var9);
            class142 var12;
            if(var11 == null) {
               var12 = null;
            } else {
               var12 = new class142(var11);
            }

            var10 = var12;
            if(var12 == null) {
               var5 = false;
               continue;
            }

            this.field1970.method2418(var12, (long)var9);
         }

         if(!var10.method2741(var3, var8.field1919, var7)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method2789();
      }

      return var5;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "841068511"
   )
   void method2642(int var1) {
      for(class140 var2 = (class140)this.field1972.field2024.method2464(); var2 != null; var2 = (class140)this.field1972.field2024.method2472()) {
         if((var1 < 0 || var1 == var2.field1990) && var2.field1983 < 0) {
            this.field1964[var2.field1990][var2.field1980] = null;
            var2.field1983 = 0;
         }
      }

   }

   public class139() {
      this.method2573();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "113"
   )
   void method2658(int var1, int var2) {
      if(var2 != this.field1953[var1]) {
         this.field1953[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field1965[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Throwable;I)Ljava/lang/String;",
      garbageValue = "277780136"
   )
   static String method2678(Throwable var0) throws IOException {
      String var1;
      if(var0 instanceof class101) {
         class101 var2 = (class101)var0;
         var1 = var2.field1677 + " | ";
         var0 = var2.field1674;
      } else {
         var1 = "";
      }

      StringWriter var12 = new StringWriter();
      PrintWriter var3 = new PrintWriter(var12);
      var0.printStackTrace(var3);
      var3.close();
      String var4 = var12.toString();
      BufferedReader var5 = new BufferedReader(new StringReader(var4));
      String var6 = var5.readLine();

      while(true) {
         while(true) {
            String var7 = var5.readLine();
            if(null == var7) {
               var1 = var1 + "| " + var6;
               return var1;
            }

            int var8 = var7.indexOf(40);
            int var9 = var7.indexOf(41, var8 + 1);
            if(var8 >= 0 && var9 >= 0) {
               String var10 = var7.substring(1 + var8, var9);
               int var11 = var10.indexOf(".java:");
               if(var11 >= 0) {
                  var10 = var10.substring(0, var11) + var10.substring(5 + var11);
                  var1 = var1 + var10 + ' ';
                  continue;
               }

               var7 = var7.substring(0, var8);
            }

            var7 = var7.trim();
            var7 = var7.substring(var7.lastIndexOf(32) + 1);
            var7 = var7.substring(var7.lastIndexOf(9) + 1);
            var1 = var1 + var7 + ' ';
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIIB)Ljava/lang/String;",
      garbageValue = "3"
   )
   public static String method2679(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var1 + var5] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class203.field3083[var6 - 128];
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

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-18"
   )
   static void method2680() {
      Client var0 = Client.field433;
      Client var1 = Client.field433;
      Client var2 = Client.field433;
      synchronized(Client.field433) {
         Container var3 = Client.field433.method2163();
         if(var3 != null) {
            CombatInfo1.field682 = Math.max(var3.getSize().width, class40.field831);
            class33.field758 = Math.max(var3.getSize().height, GameEngine.field1802);
            if(CollisionData.field1860 == var3) {
               Insets var4 = CollisionData.field1860.getInsets();
               CombatInfo1.field682 -= var4.right + var4.left;
               class33.field758 -= var4.top + var4.bottom;
            }

            if(CombatInfo1.field682 <= 0) {
               CombatInfo1.field682 = 1;
            }

            if(class33.field758 <= 0) {
               class33.field758 = 1;
            }

            int var10 = Client.isResized?2:1;
            if(var10 == 1) {
               class32.field755 = Client.field362;
               class168.field2207 = Client.field549 * 503;
            } else {
               class32.field755 = Math.min(CombatInfo1.field682, 7680);
               class168.field2207 = Math.min(class33.field758, 2160);
            }

            GameEngine.field1792 = (CombatInfo1.field682 - class32.field755) / 2;
            GameEngine.field1782 = 0;
            Projectile.canvas.setSize(class32.field755, class168.field2207);
            class115.bufferProvider = class5.method69(class32.field755, class168.field2207, Projectile.canvas);
            if(var3 == CollisionData.field1860) {
               Insets var5 = CollisionData.field1860.getInsets();
               Projectile.canvas.setLocation(GameEngine.field1792 + var5.left, GameEngine.field1782 + var5.top);
            } else {
               Projectile.canvas.setLocation(GameEngine.field1792, GameEngine.field1782);
            }

            class39.method768();
            if(Client.widgetRoot != -1) {
               int var11 = Client.widgetRoot;
               int var6 = class32.field755;
               int var7 = class168.field2207;
               if(Ignore.method178(var11)) {
                  class65.method1205(Widget.widgets[var11], -1, var6, var7, true);
               }
            }

            class72.method1441();
         }

      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BII)I",
      garbageValue = "-64339739"
   )
   public static int method2681(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if((var7 <= 0 || var7 >= 128) && (var7 < 160 || var7 > 255)) {
            if(var7 == 8364) {
               var3[var4 + var6] = -128;
            } else if(var7 == 8218) {
               var3[var4 + var6] = -126;
            } else if(var7 == 402) {
               var3[var6 + var4] = -125;
            } else if(var7 == 8222) {
               var3[var4 + var6] = -124;
            } else if(var7 == 8230) {
               var3[var4 + var6] = -123;
            } else if(var7 == 8224) {
               var3[var6 + var4] = -122;
            } else if(var7 == 8225) {
               var3[var4 + var6] = -121;
            } else if(var7 == 710) {
               var3[var4 + var6] = -120;
            } else if(var7 == 8240) {
               var3[var6 + var4] = -119;
            } else if(var7 == 352) {
               var3[var6 + var4] = -118;
            } else if(var7 == 8249) {
               var3[var6 + var4] = -117;
            } else if(var7 == 338) {
               var3[var6 + var4] = -116;
            } else if(var7 == 381) {
               var3[var4 + var6] = -114;
            } else if(var7 == 8216) {
               var3[var6 + var4] = -111;
            } else if(var7 == 8217) {
               var3[var4 + var6] = -110;
            } else if(var7 == 8220) {
               var3[var4 + var6] = -109;
            } else if(var7 == 8221) {
               var3[var6 + var4] = -108;
            } else if(var7 == 8226) {
               var3[var6 + var4] = -107;
            } else if(var7 == 8211) {
               var3[var4 + var6] = -106;
            } else if(var7 == 8212) {
               var3[var4 + var6] = -105;
            } else if(var7 == 732) {
               var3[var6 + var4] = -104;
            } else if(var7 == 8482) {
               var3[var6 + var4] = -103;
            } else if(var7 == 353) {
               var3[var4 + var6] = -102;
            } else if(var7 == 8250) {
               var3[var4 + var6] = -101;
            } else if(var7 == 339) {
               var3[var6 + var4] = -100;
            } else if(var7 == 382) {
               var3[var4 + var6] = -98;
            } else if(var7 == 376) {
               var3[var6 + var4] = -97;
            } else {
               var3[var6 + var4] = 63;
            }
         } else {
            var3[var6 + var4] = (byte)var7;
         }
      }

      return var5;
   }
}

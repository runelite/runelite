import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
@Implements("ObjectComposition")
public class class42 extends class207 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1652065071
   )
   public int field944 = -1;
   @ObfuscatedName("g")
   public static class170 field945;
   @ObfuscatedName("o")
   short[] field946;
   @ObfuscatedName("e")
   public static class196 field947 = new class196(64);
   @ObfuscatedName("h")
   public static class196 field948 = new class196(500);
   @ObfuscatedName("u")
   static class103[] field949 = new class103[4];
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1595151265
   )
   public int field950 = -1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2119445067
   )
   public int field952;
   @ObfuscatedName("y")
   public boolean field953 = false;
   @ObfuscatedName("m")
   int[] field954;
   @ObfuscatedName("q")
   @Export("name")
   public String field955 = "null";
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -840728267
   )
   int field956 = 0;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 412184643
   )
   public int field957 = -1;
   @ObfuscatedName("l")
   public static boolean field958 = false;
   @ObfuscatedName("d")
   short[] field959;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1821950973
   )
   public int field960 = 1;
   @ObfuscatedName("v")
   public boolean field961 = true;
   @ObfuscatedName("b")
   int[] field962;
   @ObfuscatedName("s")
   public static class196 field963 = new class196(30);
   @ObfuscatedName("bu")
   static class171 field964;
   @ObfuscatedName("w")
   short[] field965;
   @ObfuscatedName("t")
   boolean field966 = false;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1594291783
   )
   public int field967 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2071733525
   )
   public int field968 = -1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 623284145
   )
   public int field969 = 16;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 992672747
   )
   public int field970 = 1;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1222058109
   )
   int field971 = 0;
   @ObfuscatedName("ac")
   @Export("actions")
   public String[] field972 = new String[5];
   @ObfuscatedName("p")
   short[] field973;
   @ObfuscatedName("aq")
   boolean field974 = false;
   @ObfuscatedName("k")
   public static class196 field975 = new class196(30);
   @ObfuscatedName("az")
   public boolean field976 = true;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1297741231
   )
   int field977 = 128;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 805108405
   )
   int field978 = 128;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -110173529
   )
   int field979 = 128;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1827156681
   )
   int field980 = 0;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1214615643
   )
   int field981 = 0;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -541451019
   )
   int field982 = 0;
   @ObfuscatedName("ay")
   public boolean field983 = false;
   @ObfuscatedName("ai")
   boolean field984 = false;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 545216561
   )
   public int field985 = -1;
   @ObfuscatedName("ae")
   @Export("impostorIds")
   public int[] field986;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 148094071
   )
   int field987 = -1;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 567429573
   )
   int field988 = -1;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 176454147
   )
   public int field989 = -1;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1423152161
   )
   public int field990 = 0;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 104229439
   )
   public int field992 = 0;
   @ObfuscatedName("al")
   public int[] field993;
   @ObfuscatedName("gv")
   static class176 field994;
   @ObfuscatedName("r")
   public static class170 field995;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 134044289
   )
   int field996 = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 298837713
   )
   public int field998 = 2;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1660722868"
   )
   void method845() {
      if(this.field944 == -1) {
         this.field944 = 0;
         if(this.field962 != null && (this.field954 == null || this.field954[0] == 10)) {
            this.field944 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(null != this.field972[var1]) {
               this.field944 = 1;
            }
         }
      }

      if(this.field985 == -1) {
         this.field985 = this.field998 != 0?1:0;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Lclass42;",
      garbageValue = "-2012922836"
   )
   @Export("getImpostor")
   public final class42 method847() {
      int var1 = -1;
      if(this.field987 != -1) {
         var1 = class54.method1164(this.field987);
      } else if(this.field988 != -1) {
         var1 = class179.field2958[this.field988];
      }

      return var1 >= 0 && var1 < this.field986.length && this.field986[var1] != -1?class160.method3312(this.field986[var1]):null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass122;IB)V",
      garbageValue = "22"
   )
   void method848(class122 var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2633();
         if(var3 > 0) {
            if(null != this.field962 && !field958) {
               var1.field2050 += var3 * 3;
            } else {
               this.field954 = new int[var3];
               this.field962 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field962[var4] = var1.method2635();
                  this.field954[var4] = var1.method2633();
               }
            }
         }
      } else if(var2 == 2) {
         this.field955 = var1.method2663();
      } else if(var2 == 5) {
         var3 = var1.method2633();
         if(var3 > 0) {
            if(null != this.field962 && !field958) {
               var1.field2050 += 2 * var3;
            } else {
               this.field954 = null;
               this.field962 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field962[var4] = var1.method2635();
               }
            }
         }
      } else if(var2 == 14) {
         this.field960 = var1.method2633();
      } else if(var2 == 15) {
         this.field970 = var1.method2633();
      } else if(var2 == 17) {
         this.field998 = 0;
         this.field961 = false;
      } else if(var2 == 18) {
         this.field961 = false;
      } else if(var2 == 19) {
         this.field944 = var1.method2633();
      } else if(var2 == 21) {
         this.field996 = 0;
      } else if(var2 == 22) {
         this.field966 = true;
      } else if(var2 == 23) {
         this.field953 = true;
      } else if(var2 == 24) {
         this.field968 = var1.method2635();
         if(this.field968 == '\uffff') {
            this.field968 = -1;
         }
      } else if(var2 == 27) {
         this.field998 = 1;
      } else if(var2 == 28) {
         this.field969 = var1.method2633();
      } else if(var2 == 29) {
         this.field956 = var1.method2634();
      } else if(var2 == 39) {
         this.field971 = var1.method2634() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.field972[var2 - 30] = var1.method2663();
         if(this.field972[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.field972[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2633();
         this.field973 = new short[var3];
         this.field965 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field973[var4] = (short)var1.method2635();
            this.field965[var4] = (short)var1.method2635();
         }
      } else if(var2 == 41) {
         var3 = var1.method2633();
         this.field946 = new short[var3];
         this.field959 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field946[var4] = (short)var1.method2635();
            this.field959[var4] = (short)var1.method2635();
         }
      } else if(var2 == 60) {
         this.field957 = var1.method2635();
      } else if(var2 == 62) {
         this.field974 = true;
      } else if(var2 == 64) {
         this.field976 = false;
      } else if(var2 == 65) {
         this.field977 = var1.method2635();
      } else if(var2 == 66) {
         this.field978 = var1.method2635();
      } else if(var2 == 67) {
         this.field979 = var1.method2635();
      } else if(var2 == 68) {
         this.field950 = var1.method2635();
      } else if(var2 == 69) {
         var1.method2633();
      } else if(var2 == 70) {
         this.field980 = var1.method2636();
      } else if(var2 == 71) {
         this.field981 = var1.method2636();
      } else if(var2 == 72) {
         this.field982 = var1.method2636();
      } else if(var2 == 73) {
         this.field983 = true;
      } else if(var2 == 74) {
         this.field984 = true;
      } else if(var2 == 75) {
         this.field985 = var1.method2633();
      } else if(var2 == 77) {
         this.field987 = var1.method2635();
         if(this.field987 == '\uffff') {
            this.field987 = -1;
         }

         this.field988 = var1.method2635();
         if(this.field988 == '\uffff') {
            this.field988 = -1;
         }

         var3 = var1.method2633();
         this.field986 = new int[1 + var3];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field986[var4] = var1.method2635();
            if(this.field986[var4] == '\uffff') {
               this.field986[var4] = -1;
            }
         }
      } else if(var2 == 78) {
         this.field989 = var1.method2635();
         this.field990 = var1.method2633();
      } else if(var2 == 79) {
         this.field967 = var1.method2635();
         this.field992 = var1.method2635();
         this.field990 = var1.method2633();
         var3 = var1.method2633();
         this.field993 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field993[var4] = var1.method2635();
         }
      } else if(var2 == 81) {
         this.field996 = var1.method2633() * 256;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1691589598"
   )
   public final boolean method849(int var1) {
      if(this.field954 != null) {
         for(int var4 = 0; var4 < this.field954.length; ++var4) {
            if(this.field954[var4] == var1) {
               return field995.method3453(this.field962[var4] & '\uffff', 0);
            }
         }

         return true;
      } else if(this.field962 == null) {
         return true;
      } else if(var1 != 10) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.field962.length; ++var3) {
            var2 &= field995.method3453(this.field962[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Lclass88;",
      garbageValue = "-1251799623"
   )
   public final class88 method851(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.field954 == null) {
         var7 = (long)((this.field952 << 10) + var2);
      } else {
         var7 = (long)(var2 + (this.field952 << 10) + (var1 << 3));
      }

      Object var9 = (class88)field963.method3905(var7);
      if(null == var9) {
         class103 var10 = this.method854(var1, var2);
         if(var10 == null) {
            return null;
         }

         if(!this.field966) {
            var9 = var10.method2321(this.field956 + 64, this.field971 + 768, -50, -10, -50);
         } else {
            var10.field1795 = (short)(this.field956 + 64);
            var10.field1777 = (short)(this.field971 + 768);
            var10.method2322();
            var9 = var10;
         }

         field963.method3907((class207)var9, var7);
      }

      if(this.field966) {
         var9 = ((class103)var9).method2299();
      }

      if(this.field996 >= 0) {
         if(var9 instanceof class108) {
            var9 = ((class108)var9).method2398(var3, var4, var5, var6, true, this.field996);
         } else if(var9 instanceof class103) {
            var9 = ((class103)var9).method2300(var3, var4, var5, var6, true, this.field996);
         }
      }

      return (class88)var9;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Lclass108;",
      garbageValue = "-1264721722"
   )
   public final class108 method852(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(null == this.field954) {
         var7 = (long)(var2 + (this.field952 << 10));
      } else {
         var7 = (long)((this.field952 << 10) + (var1 << 3) + var2);
      }

      class108 var9 = (class108)field975.method3905(var7);
      if(var9 == null) {
         class103 var10 = this.method854(var1, var2);
         if(null == var10) {
            return null;
         }

         var9 = var10.method2321(64 + this.field956, 768 + this.field971, -50, -10, -50);
         field975.method3907(var9, var7);
      }

      if(this.field996 >= 0) {
         var9 = var9.method2398(var3, var4, var5, var6, true, this.field996);
      }

      return var9;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)Lclass103;",
      garbageValue = "2053736548"
   )
   final class103 method854(int var1, int var2) {
      class103 var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(null == this.field954) {
         if(var1 != 10) {
            return null;
         }

         if(this.field962 == null) {
            return null;
         }

         var4 = this.field974;
         if(var1 == 2 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.field962.length;

         for(int var8 = 0; var8 < var5; ++var8) {
            var7 = this.field962[var8];
            if(var4) {
               var7 += 65536;
            }

            var3 = (class103)field948.method3905((long)var7);
            if(null == var3) {
               var3 = class103.method2369(field995, var7 & '\uffff', 0);
               if(null == var3) {
                  return null;
               }

               if(var4) {
                  var3.method2294();
               }

               field948.method3907(var3, (long)var7);
            }

            if(var5 > 1) {
               field949[var8] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new class103(field949, var5);
         }
      } else {
         int var9 = -1;

         for(var5 = 0; var5 < this.field954.length; ++var5) {
            if(var1 == this.field954[var5]) {
               var9 = var5;
               break;
            }
         }

         if(var9 == -1) {
            return null;
         }

         var5 = this.field962[var9];
         boolean var11 = this.field974 ^ var2 > 3;
         if(var11) {
            var5 += 65536;
         }

         var3 = (class103)field948.method3905((long)var5);
         if(null == var3) {
            var3 = class103.method2369(field995, var5 & '\uffff', 0);
            if(var3 == null) {
               return null;
            }

            if(var11) {
               var3.method2294();
            }

            field948.method3907(var3, (long)var5);
         }
      }

      if(this.field977 == 128 && this.field978 == 128 && this.field979 == 128) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var10;
      if(this.field980 == 0 && this.field981 == 0 && this.field982 == 0) {
         var10 = false;
      } else {
         var10 = true;
      }

      class103 var6 = new class103(var3, var2 == 0 && !var4 && !var10, this.field973 == null, null == this.field946, true);
      if(var1 == 4 && var2 > 3) {
         var6.method2348(256);
         var6.method2304(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var6.method2301();
      } else if(var2 == 2) {
         var6.method2302();
      } else if(var2 == 3) {
         var6.method2371();
      }

      if(this.field973 != null) {
         for(var7 = 0; var7 < this.field973.length; ++var7) {
            var6.method2305(this.field973[var7], this.field965[var7]);
         }
      }

      if(null != this.field946) {
         for(var7 = 0; var7 < this.field946.length; ++var7) {
            var6.method2306(this.field946[var7], this.field959[var7]);
         }
      }

      if(var4) {
         var6.method2375(this.field977, this.field978, this.field979);
      }

      if(var10) {
         var6.method2304(this.field980, this.field981, this.field982);
      }

      return var6;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-37"
   )
   public final boolean method857() {
      if(this.field962 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field962.length; ++var2) {
            var1 &= field995.method3453(this.field962[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-102"
   )
   public boolean method860() {
      if(this.field986 == null) {
         return this.field989 != -1 || null != this.field993;
      } else {
         for(int var1 = 0; var1 < this.field986.length; ++var1) {
            if(this.field986[var1] != -1) {
               class42 var2 = class160.method3312(this.field986[var1]);
               if(var2.field989 != -1 || var2.field993 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II[[IIIILclass44;IB)Lclass108;",
      garbageValue = "-37"
   )
   public final class108 method870(int var1, int var2, int[][] var3, int var4, int var5, int var6, class44 var7, int var8) {
      long var9;
      if(this.field954 == null) {
         var9 = (long)(var2 + (this.field952 << 10));
      } else {
         var9 = (long)(var2 + (this.field952 << 10) + (var1 << 3));
      }

      class108 var11 = (class108)field975.method3905(var9);
      if(null == var11) {
         class103 var12 = this.method854(var1, var2);
         if(null == var12) {
            return null;
         }

         var11 = var12.method2321(64 + this.field956, this.field971 + 768, -50, -10, -50);
         field975.method3907(var11, var9);
      }

      if(var7 == null && this.field996 == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method912(var11, var8, var2);
         } else {
            var11 = var11.method2399(true);
         }

         if(this.field996 >= 0) {
            var11 = var11.method2398(var3, var4, var5, var6, false, this.field996);
         }

         return var11;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass170;I)V",
      garbageValue = "1869295282"
   )
   public static void method876(class170 var0) {
      class50.field1125 = var0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "869658248"
   )
   void method880(class122 var1) {
      while(true) {
         int var2 = var1.method2633();
         if(var2 == 0) {
            return;
         }

         this.method848(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BII)I",
      garbageValue = "-1845658135"
   )
   public static int method885(byte[] var0, int var1) {
      return class37.method784(var0, 0, var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-72"
   )
   static void method886() {
      class230 var0 = null;

      try {
         var0 = class114.method2540("", client.field298.field2346, true);
         class122 var1 = class136.field2123.method116();
         var0.method4275(var1.field2051, 0, var1.field2050);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method4283();
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "([Lclass176;IIIIIIIIB)V",
      garbageValue = "-63"
   )
   @Export("gameDraw")
   static final void method887(class176[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class82.method1908(var2, var3, var4, var5);
      class94.method2183();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         class176 var10 = var0[var9];
         if(var10 != null && (var1 == var10.field2826 || var1 == -1412584499 && var10 == client.field466)) {
            int var11;
            if(var8 == -1) {
               client.field501[client.field496] = var10.field2820 + var6;
               client.field502[client.field496] = var10.field2821 + var7;
               client.field503[client.field496] = var10.field2822;
               client.field504[client.field496] = var10.field2823;
               var11 = ++client.field496 - 1;
            } else {
               var11 = var8;
            }

            var10.field2938 = var11;
            var10.field2829 = client.field305;
            if(!var10.field2855 || !class9.method132(var10)) {
               if(var10.field2811 > 0) {
                  class167.method3372(var10);
               }

               int var12 = var10.field2820 + var6;
               int var13 = var7 + var10.field2821;
               int var14 = var10.field2886;
               int var15;
               int var16;
               if(client.field466 == var10) {
                  if(var1 != -1412584499 && !var10.field2885) {
                     class10.field169 = var0;
                     class9.field160 = var6;
                     class31.field726 = var7;
                     continue;
                  }

                  if(client.field390 && client.field346) {
                     var15 = class143.field2206;
                     var16 = class143.field2209;
                     var15 -= client.field387;
                     var16 -= client.field472;
                     if(var15 < client.field543) {
                        var15 = client.field543;
                     }

                     if(var10.field2822 + var15 > client.field397.field2822 + client.field543) {
                        var15 = client.field543 + client.field397.field2822 - var10.field2822;
                     }

                     if(var16 < client.field295) {
                        var16 = client.field295;
                     }

                     if(var16 + var10.field2823 > client.field397.field2823 + client.field295) {
                        var16 = client.field295 + client.field397.field2823 - var10.field2823;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2885) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var20;
               int var21;
               int var36;
               int var38;
               if(var10.field2910 == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.field2910 == 9) {
                  var36 = var12;
                  var20 = var13;
                  var21 = var12 + var10.field2822;
                  var38 = var13 + var10.field2823;
                  if(var21 < var12) {
                     var36 = var21;
                     var21 = var12;
                  }

                  if(var38 < var13) {
                     var20 = var38;
                     var38 = var13;
                  }

                  ++var21;
                  ++var38;
                  var15 = var36 > var2?var36:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var21 < var4?var21:var4;
                  var18 = var38 < var5?var38:var5;
               } else {
                  var36 = var10.field2822 + var12;
                  var20 = var13 + var10.field2823;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var36 < var4?var36:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.field2855 || var15 < var17 && var16 < var18) {
                  if(var10.field2811 != 0) {
                     if(var10.field2811 == 1336) {
                        if(client.field433) {
                           var13 += 15;
                           class8.field144.method4172("Fps:" + class147.field2264, var10.field2822 + var12, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var46 = Runtime.getRuntime();
                           var20 = (int)((var46.totalMemory() - var46.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && client.field301) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !client.field301) {
                              var21 = 16711680;
                           }

                           class8.field144.method4172("Mem:" + var20 + "k", var10.field2822 + var12, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.field2811 == 1337) {
                        client.field442 = var12;
                        client.field443 = var13;
                        class19.method246(var12, var13, var10.field2822, var10.field2823);
                        client.field498[var10.field2938] = true;
                        class82.method1908(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.field2811 == 1338) {
                        class172.method3512(var10, var12, var13, var11);
                        class82.method1908(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.field2811 == 1339) {
                        class178 var45 = var10.method3557(false);
                        if(null != var45) {
                           if(client.field530 < 3) {
                              class171.field2754.method1801(var12, var13, var45.field2953, var45.field2950, 25, 25, client.field399, 256, var45.field2954, var45.field2951);
                           } else {
                              class82.method1899(var12, var13, 0, var45.field2954, var45.field2951);
                           }
                        }

                        class82.method1908(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.field2910 == 0) {
                     if(!var10.field2855 && class9.method132(var10) && var10 != class11.field177) {
                        continue;
                     }

                     if(!var10.field2855) {
                        if(var10.field2850 > var10.field2831 - var10.field2823) {
                           var10.field2850 = var10.field2831 - var10.field2823;
                        }

                        if(var10.field2850 < 0) {
                           var10.field2850 = 0;
                        }
                     }

                     method887(var0, var10.field2807, var15, var16, var17, var18, var12 - var10.field2864, var13 - var10.field2850, var11);
                     if(var10.field2931 != null) {
                        method887(var10.field2931, var10.field2807, var15, var16, var17, var18, var12 - var10.field2864, var13 - var10.field2850, var11);
                     }

                     class3 var19 = (class3)client.field475.method3936((long)var10.field2807);
                     if(null != var19) {
                        class111.method2500(var19.field70, var15, var16, var17, var18, var12, var13, var11);
                     }

                     class82.method1908(var2, var3, var4, var5);
                     class94.method2183();
                  }

                  if(client.field507 || client.field500[var11] || client.field357 > 1) {
                     int var24;
                     int var37;
                     if(var10.field2910 == 0 && !var10.field2855 && var10.field2831 > var10.field2823) {
                        var36 = var10.field2822 + var12;
                        var20 = var10.field2850;
                        var21 = var10.field2823;
                        var38 = var10.field2831;
                        class110.field1947[0].method1954(var36, var13);
                        class110.field1947[1].method1954(var36, var21 + var13 - 16);
                        class82.method1907(var36, var13 + 16, 16, var21 - 32, client.field373);
                        var37 = var21 * (var21 - 32) / var38;
                        if(var37 < 8) {
                           var37 = 8;
                        }

                        var24 = var20 * (var21 - 32 - var37) / (var38 - var21);
                        class82.method1907(var36, 16 + var13 + var24, 16, var37, client.field374);
                        class82.method1949(var36, var24 + 16 + var13, var37, client.field554);
                        class82.method1949(var36 + 1, var13 + 16 + var24, var37, client.field554);
                        class82.method1945(var36, var24 + var13 + 16, 16, client.field554);
                        class82.method1945(var36, 17 + var13 + var24, 16, client.field554);
                        class82.method1949(15 + var36, var13 + 16 + var24, var37, client.field329);
                        class82.method1949(var36 + 14, 17 + var13 + var24, var37 - 1, client.field329);
                        class82.method1945(var36, var37 + var24 + 15 + var13, 16, client.field329);
                        class82.method1945(1 + var36, 14 + var13 + var24 + var37, 15, client.field329);
                     }

                     if(var10.field2910 != 1) {
                        int var25;
                        int var26;
                        int var29;
                        if(var10.field2910 == 2) {
                           var36 = 0;

                           for(var20 = 0; var20 < var10.field2819; ++var20) {
                              for(var21 = 0; var21 < var10.field2818; ++var21) {
                                 var38 = var12 + var21 * (32 + var10.field2873);
                                 var37 = var13 + var20 * (32 + var10.field2874);
                                 if(var36 < 20) {
                                    var38 += var10.field2875[var36];
                                    var37 += var10.field2876[var36];
                                 }

                                 if(var10.field2905[var36] <= 0) {
                                    if(var10.field2877 != null && var36 < 20) {
                                       class81 var55 = var10.method3553(var36);
                                       if(var55 != null) {
                                          var55.method1824(var38, var37);
                                       } else if(class176.field2796) {
                                          class79.method1777(var10);
                                       }
                                    }
                                 } else {
                                    boolean var50 = false;
                                    boolean var51 = false;
                                    var26 = var10.field2905[var36] - 1;
                                    if(var38 + 32 > var2 && var38 < var4 && var37 + 32 > var3 && var37 < var5 || class23.field614 == var10 && client.field409 == var36) {
                                       class81 var41;
                                       if(client.field439 == 1 && class23.field618 == var36 && class97.field1688 == var10.field2807) {
                                          var41 = class28.method667(var26, var10.field2926[var36], 2, 0, 2, false);
                                       } else {
                                          var41 = class28.method667(var26, var10.field2926[var36], 1, 3153952, 2, false);
                                       }

                                       if(var41 != null) {
                                          if(class23.field614 == var10 && var36 == client.field409) {
                                             var24 = class143.field2206 - client.field410;
                                             var25 = class143.field2209 - client.field322;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(client.field414 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var41.method1812(var38 + var24, var37 + var25, 128);
                                             if(var1 != -1) {
                                                class176 var28 = var0[var1 & '\uffff'];
                                                if(var25 + var37 < class82.field1492 && var28.field2850 > 0) {
                                                   var29 = (class82.field1492 - var37 - var25) * client.field370 / 3;
                                                   if(var29 > client.field370 * 10) {
                                                      var29 = client.field370 * 10;
                                                   }

                                                   if(var29 > var28.field2850) {
                                                      var29 = var28.field2850;
                                                   }

                                                   var28.field2850 -= var29;
                                                   client.field322 += var29;
                                                   class79.method1777(var28);
                                                }

                                                if(var37 + var25 + 32 > class82.field1489 && var28.field2850 < var28.field2831 - var28.field2823) {
                                                   var29 = (var37 + var25 + 32 - class82.field1489) * client.field370 / 3;
                                                   if(var29 > client.field370 * 10) {
                                                      var29 = client.field370 * 10;
                                                   }

                                                   if(var29 > var28.field2831 - var28.field2823 - var28.field2850) {
                                                      var29 = var28.field2831 - var28.field2823 - var28.field2850;
                                                   }

                                                   var28.field2850 += var29;
                                                   client.field322 -= var29;
                                                   class79.method1777(var28);
                                                }
                                             }
                                          } else if(var10 == field994 && var36 == client.field509) {
                                             var41.method1812(var38, var37, 128);
                                          } else {
                                             var41.method1824(var38, var37);
                                          }
                                       } else {
                                          class79.method1777(var10);
                                       }
                                    }
                                 }

                                 ++var36;
                              }
                           }
                        } else if(var10.field2910 == 3) {
                           if(class53.method1149(var10)) {
                              var36 = var10.field2924;
                              if(class11.field177 == var10 && var10.field2909 != 0) {
                                 var36 = var10.field2909;
                              }
                           } else {
                              var36 = var10.field2832;
                              if(var10 == class11.field177 && var10.field2834 != 0) {
                                 var36 = var10.field2834;
                              }
                           }

                           if(var10.field2825) {
                              switch(var10.field2837.field1510) {
                              case 1:
                                 class82.method1888(var12, var13, var10.field2822, var10.field2823, var10.field2832, var10.field2924, 256 - (var10.field2886 & 255), 256 - (var10.field2839 & 255));
                                 break;
                              case 2:
                                 class82.method1889(var12, var13, var10.field2822, var10.field2823, var10.field2832, var10.field2924, 256 - (var10.field2886 & 255), 256 - (var10.field2839 & 255));
                                 break;
                              case 3:
                                 class82.method1890(var12, var13, var10.field2822, var10.field2823, var10.field2832, var10.field2924, 256 - (var10.field2886 & 255), 256 - (var10.field2839 & 255));
                                 break;
                              case 4:
                                 class82.method1891(var12, var13, var10.field2822, var10.field2823, var10.field2832, var10.field2924, 256 - (var10.field2886 & 255), 256 - (var10.field2839 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    class82.method1907(var12, var13, var10.field2822, var10.field2823, var36);
                                 } else {
                                    class82.method1894(var12, var13, var10.field2822, var10.field2823, var36, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              class82.method1893(var12, var13, var10.field2822, var10.field2823, var36);
                           } else {
                              class82.method1912(var12, var13, var10.field2822, var10.field2823, var36, 256 - (var14 & 255));
                           }
                        } else {
                           class227 var43;
                           if(var10.field2910 == 4) {
                              var43 = var10.method3588();
                              if(var43 == null) {
                                 if(class176.field2796) {
                                    class79.method1777(var10);
                                 }
                              } else {
                                 String var54 = var10.field2867;
                                 if(class53.method1149(var10)) {
                                    var20 = var10.field2924;
                                    if(var10 == class11.field177 && var10.field2909 != 0) {
                                       var20 = var10.field2909;
                                    }

                                    if(var10.field2868.length() > 0) {
                                       var54 = var10.field2868;
                                    }
                                 } else {
                                    var20 = var10.field2832;
                                    if(class11.field177 == var10 && var10.field2834 != 0) {
                                       var20 = var10.field2834;
                                    }
                                 }

                                 if(var10.field2855 && var10.field2879 != -1) {
                                    class55 var48 = class1.method14(var10.field2879);
                                    var54 = var48.field1183;
                                    if(null == var54) {
                                       var54 = "null";
                                    }

                                    if((var48.field1197 == 1 || var10.field2808 != 1) && var10.field2808 != -1) {
                                       var54 = class16.method205(16748608) + var54 + "</col>" + " " + 'x' + class151.method3270(var10.field2808);
                                    }
                                 }

                                 if(client.field376 == var10) {
                                    Object var10000 = null;
                                    var54 = "Please wait...";
                                    var20 = var10.field2832;
                                 }

                                 if(!var10.field2855) {
                                    var54 = class9.method136(var54, var10);
                                 }

                                 var43.method4174(var54, var12, var13, var10.field2822, var10.field2823, var20, var10.field2827?0:-1, var10.field2814, var10.field2883, var10.field2869);
                              }
                           } else if(var10.field2910 == 5) {
                              class81 var44;
                              if(!var10.field2855) {
                                 var44 = var10.method3563(class53.method1149(var10));
                                 if(var44 != null) {
                                    var44.method1824(var12, var13);
                                 } else if(class176.field2796) {
                                    class79.method1777(var10);
                                 }
                              } else {
                                 if(var10.field2879 != -1) {
                                    var44 = class28.method667(var10.field2879, var10.field2808, var10.field2892, var10.field2847, var10.field2865, false);
                                 } else {
                                    var44 = var10.method3563(false);
                                 }

                                 if(null == var44) {
                                    if(class176.field2796) {
                                       class79.method1777(var10);
                                    }
                                 } else {
                                    var20 = var44.field1484;
                                    var21 = var44.field1483;
                                    if(!var10.field2845) {
                                       var38 = var10.field2822 * 4096 / var20;
                                       if(var10.field2844 != 0) {
                                          var44.method1819(var10.field2822 / 2 + var12, var13 + var10.field2823 / 2, var10.field2844, var38);
                                       } else if(var14 != 0) {
                                          var44.method1814(var12, var13, var10.field2822, var10.field2823, 256 - (var14 & 255));
                                       } else if(var10.field2822 == var20 && var10.field2823 == var21) {
                                          var44.method1824(var12, var13);
                                       } else {
                                          var44.method1843(var12, var13, var10.field2822, var10.field2823);
                                       }
                                    } else {
                                       class82.method1941(var12, var13, var10.field2822 + var12, var10.field2823 + var13);
                                       var38 = (var10.field2822 + (var20 - 1)) / var20;
                                       var37 = (var21 - 1 + var10.field2823) / var21;

                                       for(var24 = 0; var24 < var38; ++var24) {
                                          for(var25 = 0; var25 < var37; ++var25) {
                                             if(var10.field2844 != 0) {
                                                var44.method1819(var20 / 2 + var12 + var20 * var24, var21 * var25 + var13 + var21 / 2, var10.field2844, 4096);
                                             } else if(var14 != 0) {
                                                var44.method1812(var20 * var24 + var12, var13 + var21 * var25, 256 - (var14 & 255));
                                             } else {
                                                var44.method1824(var12 + var24 * var20, var13 + var21 * var25);
                                             }
                                          }
                                       }

                                       class82.method1908(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              class55 var23;
                              if(var10.field2910 == 6) {
                                 boolean var53 = class53.method1149(var10);
                                 if(var53) {
                                    var20 = var10.field2923;
                                 } else {
                                    var20 = var10.field2854;
                                 }

                                 class108 var52 = null;
                                 var38 = 0;
                                 if(var10.field2879 != -1) {
                                    var23 = class1.method14(var10.field2879);
                                    if(null != var23) {
                                       var23 = var23.method1185(var10.field2808);
                                       var52 = var23.method1178(1);
                                       if(null != var52) {
                                          var52.method2402();
                                          var38 = var52.field1538 / 2;
                                       } else {
                                          class79.method1777(var10);
                                       }
                                    }
                                 } else if(var10.field2800 == 5) {
                                    if(var10.field2851 == 0) {
                                       var52 = client.field567.method3667((class44)null, -1, (class44)null, -1);
                                    } else {
                                       var52 = class3.field65.vmethod1990();
                                    }
                                 } else if(var20 == -1) {
                                    var52 = var10.method3556((class44)null, -1, var53, class3.field65.field31);
                                    if(null == var52 && class176.field2796) {
                                       class79.method1777(var10);
                                    }
                                 } else {
                                    class44 var49 = class22.method585(var20);
                                    var52 = var10.method3556(var49, var10.field2929, var53, class3.field65.field31);
                                    if(null == var52 && class176.field2796) {
                                       class79.method1777(var10);
                                    }
                                 }

                                 class94.method2187(var12 + var10.field2822 / 2, var13 + var10.field2823 / 2);
                                 var37 = class94.field1661[var10.field2927] * var10.field2933 >> 16;
                                 var24 = var10.field2933 * class94.field1662[var10.field2927] >> 16;
                                 if(null != var52) {
                                    if(!var10.field2855) {
                                       var52.method2414(0, var10.field2859, 0, var10.field2927, 0, var37, var24);
                                    } else {
                                       var52.method2402();
                                       if(var10.field2908) {
                                          var52.method2415(0, var10.field2859, var10.field2860, var10.field2927, var10.field2856, var37 + var38 + var10.field2857, var10.field2857 + var24, var10.field2933);
                                       } else {
                                          var52.method2414(0, var10.field2859, var10.field2860, var10.field2927, var10.field2856, var38 + var37 + var10.field2857, var24 + var10.field2857);
                                       }
                                    }
                                 }

                                 class94.method2167();
                              } else {
                                 if(var10.field2910 == 7) {
                                    var43 = var10.method3588();
                                    if(var43 == null) {
                                       if(class176.field2796) {
                                          class79.method1777(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2819; ++var21) {
                                       for(var38 = 0; var38 < var10.field2818; ++var38) {
                                          if(var10.field2905[var20] > 0) {
                                             var23 = class1.method14(var10.field2905[var20] - 1);
                                             String var40;
                                             if(var23.field1197 != 1 && var10.field2926[var20] == 1) {
                                                var40 = class16.method205(16748608) + var23.field1183 + "</col>";
                                             } else {
                                                var40 = class16.method205(16748608) + var23.field1183 + "</col>" + " " + 'x' + class151.method3270(var10.field2926[var20]);
                                             }

                                             var25 = var12 + var38 * (115 + var10.field2873);
                                             var26 = var13 + var21 * (12 + var10.field2874);
                                             if(var10.field2814 == 0) {
                                                var43.method4170(var40, var25, var26, var10.field2832, var10.field2827?0:-1);
                                             } else if(var10.field2814 == 1) {
                                                var43.method4173(var40, var25 + var10.field2822 / 2, var26, var10.field2832, var10.field2827?0:-1);
                                             } else {
                                                var43.method4172(var40, var10.field2822 + var25 - 1, var26, var10.field2832, var10.field2827?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 int var27;
                                 if(var10.field2910 == 8 && var10 == class19.field278 && client.field444 == client.field445) {
                                    var36 = 0;
                                    var20 = 0;
                                    class227 var39 = class8.field144;
                                    String var22 = var10.field2867;

                                    String var47;
                                    for(var22 = class9.method136(var22, var10); var22.length() > 0; var20 += var39.field3235 + 1) {
                                       var24 = var22.indexOf("<br>");
                                       if(var24 != -1) {
                                          var47 = var22.substring(0, var24);
                                          var22 = var22.substring(var24 + 4);
                                       } else {
                                          var47 = var22;
                                          var22 = "";
                                       }

                                       var25 = var39.method4165(var47);
                                       if(var25 > var36) {
                                          var36 = var25;
                                       }
                                    }

                                    var36 += 6;
                                    var20 += 7;
                                    var24 = var12 + var10.field2822 - 5 - var36;
                                    var25 = 5 + var10.field2823 + var13;
                                    if(var24 < var12 + 5) {
                                       var24 = var12 + 5;
                                    }

                                    if(var24 + var36 > var4) {
                                       var24 = var4 - var36;
                                    }

                                    if(var20 + var25 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    class82.method1907(var24, var25, var36, var20, 16777120);
                                    class82.method1893(var24, var25, var36, var20, 0);
                                    var22 = var10.field2867;
                                    var26 = var25 + var39.field3235 + 2;

                                    for(var22 = class9.method136(var22, var10); var22.length() > 0; var26 += var39.field3235 + 1) {
                                       var27 = var22.indexOf("<br>");
                                       if(var27 != -1) {
                                          var47 = var22.substring(0, var27);
                                          var22 = var22.substring(var27 + 4);
                                       } else {
                                          var47 = var22;
                                          var22 = "";
                                       }

                                       var39.method4170(var47, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.field2910 == 9) {
                                    if(var10.field2840 == 1) {
                                       if(var10.field2841) {
                                          var36 = var12;
                                          var20 = var13 + var10.field2823;
                                          var21 = var10.field2822 + var12;
                                          var38 = var13;
                                       } else {
                                          var36 = var12;
                                          var20 = var13;
                                          var21 = var10.field2822 + var12;
                                          var38 = var13 + var10.field2823;
                                       }

                                       class82.method1898(var36, var20, var21, var38, var10.field2832);
                                    } else {
                                       var36 = var10.field2822 >= 0?var10.field2822:-var10.field2822;
                                       var20 = var10.field2823 >= 0?var10.field2823:-var10.field2823;
                                       var21 = var36;
                                       if(var36 < var20) {
                                          var21 = var20;
                                       }

                                       if(var21 != 0) {
                                          var38 = (var10.field2822 << 16) / var21;
                                          var37 = (var10.field2823 << 16) / var21;
                                          if(var37 <= var38) {
                                             var38 = -var38;
                                          } else {
                                             var37 = -var37;
                                          }

                                          var24 = var10.field2840 * var37 >> 17;
                                          var25 = var37 * var10.field2840 + 1 >> 17;
                                          var26 = var10.field2840 * var38 >> 17;
                                          var27 = 1 + var38 * var10.field2840 >> 17;
                                          int var42 = var24 + var12;
                                          var29 = var12 - var25;
                                          int var30 = var12 + var10.field2822 - var25;
                                          int var31 = var10.field2822 + var12 + var24;
                                          int var32 = var26 + var13;
                                          int var33 = var13 - var27;
                                          int var34 = var10.field2823 + var13 - var27;
                                          int var35 = var26 + var13 + var10.field2823;
                                          class94.method2176(var42, var29, var30);
                                          class94.method2220(var32, var33, var34, var42, var29, var30, var10.field2832);
                                          class94.method2176(var42, var30, var31);
                                          class94.method2220(var32, var34, var35, var42, var30, var31, var10.field2832);
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }
}

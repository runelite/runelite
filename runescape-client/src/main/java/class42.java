import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
@Implements("ObjectComposition")
public class class42 extends class207 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1276060783
   )
   public int field959 = 1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2100775647
   )
   public int field960 = 16;
   @ObfuscatedName("h")
   public static class196 field961 = new class196(64);
   @ObfuscatedName("as")
   @Export("actions")
   public String[] field962 = new String[5];
   @ObfuscatedName("a")
   public static class196 field963 = new class196(30);
   @ObfuscatedName("q")
   @Export("name")
   public String field964 = "null";
   @ObfuscatedName("u")
   static class103[] field965 = new class103[4];
   @ObfuscatedName("av")
   boolean field966 = false;
   @ObfuscatedName("p")
   int[] field967;
   @ObfuscatedName("i")
   int[] field968;
   @ObfuscatedName("ax")
   @Export("impostorIds")
   public int[] field969;
   @ObfuscatedName("g")
   short[] field970;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -245459581
   )
   public int field971 = -1;
   @ObfuscatedName("w")
   short[] field972;
   @ObfuscatedName("x")
   short[] field973;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -956375615
   )
   public int field974;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1896879901
   )
   public int field975 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1022013199
   )
   public int field976 = 2;
   @ObfuscatedName("y")
   public boolean field977 = true;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 382129101
   )
   int field978 = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 790812801
   )
   int field979 = -1;
   @ObfuscatedName("k")
   boolean field980 = false;
   @ObfuscatedName("n")
   public boolean field981 = false;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1730552565
   )
   public int field982 = -1;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -232540125
   )
   int field983 = 128;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -28110571
   )
   int field984 = 0;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1915915819
   )
   int field985 = 0;
   @ObfuscatedName("b")
   public static class196 field986 = new class196(30);
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1139708199
   )
   public int field987 = -1;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -938776355
   )
   public int field988 = -1;
   @ObfuscatedName("e")
   static boolean field989 = false;
   @ObfuscatedName("aq")
   boolean field990 = false;
   @ObfuscatedName("j")
   short[] field991;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1486925555
   )
   int field992 = 128;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1745240169
   )
   int field993 = 128;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 46426101
   )
   int field994 = 0;
   @ObfuscatedName("al")
   public boolean field995 = true;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 2016248257
   )
   int field996 = 0;
   @ObfuscatedName("ag")
   public boolean field997 = false;
   @ObfuscatedName("c")
   static class170 field998;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -890457471
   )
   public int field999 = -1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 583793135
   )
   public int field1000 = 1;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1125101913
   )
   int field1001 = -1;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 82342071
   )
   int field1002 = -1;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -786419879
   )
   public int field1003 = -1;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1983835767
   )
   public int field1004 = 0;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 174799739
   )
   public int field1005 = 0;
   @ObfuscatedName("r")
   public static class196 field1006 = new class196(500);
   @ObfuscatedName("az")
   public int[] field1007;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "-2106452490"
   )
   void method839(class122 var1) {
      while(true) {
         int var2 = var1.method2610();
         if(var2 == 0) {
            return;
         }

         this.method840(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass122;IB)V",
      garbageValue = "-38"
   )
   void method840(class122 var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2610();
         if(var3 > 0) {
            if(null != this.field967 && !field989) {
               var1.field2061 += 3 * var3;
            } else {
               this.field968 = new int[var3];
               this.field967 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field967[var4] = var1.method2612();
                  this.field968[var4] = var1.method2610();
               }
            }
         }
      } else if(var2 == 2) {
         this.field964 = var1.method2617();
      } else if(var2 == 5) {
         var3 = var1.method2610();
         if(var3 > 0) {
            if(this.field967 != null && !field989) {
               var1.field2061 += 2 * var3;
            } else {
               this.field968 = null;
               this.field967 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field967[var4] = var1.method2612();
               }
            }
         }
      } else if(var2 == 14) {
         this.field959 = var1.method2610();
      } else if(var2 == 15) {
         this.field1000 = var1.method2610();
      } else if(var2 == 17) {
         this.field976 = 0;
         this.field977 = false;
      } else if(var2 == 18) {
         this.field977 = false;
      } else if(var2 == 19) {
         this.field971 = var1.method2610();
      } else if(var2 == 21) {
         this.field979 = 0;
      } else if(var2 == 22) {
         this.field980 = true;
      } else if(var2 == 23) {
         this.field981 = true;
      } else if(var2 == 24) {
         this.field982 = var1.method2612();
         if(this.field982 == '\uffff') {
            this.field982 = -1;
         }
      } else if(var2 == 27) {
         this.field976 = 1;
      } else if(var2 == 28) {
         this.field960 = var1.method2610();
      } else if(var2 == 29) {
         this.field984 = var1.method2611();
      } else if(var2 == 39) {
         this.field985 = var1.method2611() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.field962[var2 - 30] = var1.method2617();
         if(this.field962[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.field962[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2610();
         this.field970 = new short[var3];
         this.field991 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field970[var4] = (short)var1.method2612();
            this.field991[var4] = (short)var1.method2612();
         }
      } else if(var2 == 41) {
         var3 = var1.method2610();
         this.field972 = new short[var3];
         this.field973 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field972[var4] = (short)var1.method2612();
            this.field973[var4] = (short)var1.method2612();
         }
      } else if(var2 == 60) {
         this.field987 = var1.method2612();
      } else if(var2 == 62) {
         this.field966 = true;
      } else if(var2 == 64) {
         this.field995 = false;
      } else if(var2 == 65) {
         this.field983 = var1.method2612();
      } else if(var2 == 66) {
         this.field992 = var1.method2612();
      } else if(var2 == 67) {
         this.field993 = var1.method2612();
      } else if(var2 == 68) {
         this.field988 = var1.method2612();
      } else if(var2 == 69) {
         var1.method2610();
      } else if(var2 == 70) {
         this.field994 = var1.method2613();
      } else if(var2 == 71) {
         this.field978 = var1.method2613();
      } else if(var2 == 72) {
         this.field996 = var1.method2613();
      } else if(var2 == 73) {
         this.field997 = true;
      } else if(var2 == 74) {
         this.field990 = true;
      } else if(var2 == 75) {
         this.field999 = var1.method2610();
      } else if(var2 == 77) {
         this.field1001 = var1.method2612();
         if(this.field1001 == '\uffff') {
            this.field1001 = -1;
         }

         this.field1002 = var1.method2612();
         if(this.field1002 == '\uffff') {
            this.field1002 = -1;
         }

         var3 = var1.method2610();
         this.field969 = new int[1 + var3];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field969[var4] = var1.method2612();
            if(this.field969[var4] == '\uffff') {
               this.field969[var4] = -1;
            }
         }
      } else if(var2 == 78) {
         this.field1003 = var1.method2612();
         this.field1004 = var1.method2610();
      } else if(var2 == 79) {
         this.field1005 = var1.method2612();
         this.field975 = var1.method2612();
         this.field1004 = var1.method2610();
         var3 = var1.method2610();
         this.field1007 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1007[var4] = var1.method2612();
         }
      } else if(var2 == 81) {
         this.field979 = var1.method2610() * 256;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1847519792"
   )
   public final boolean method841(int var1) {
      if(this.field968 != null) {
         for(int var4 = 0; var4 < this.field968.length; ++var4) {
            if(var1 == this.field968[var4]) {
               return field998.method3344(this.field967[var4] & '\uffff', 0);
            }
         }

         return true;
      } else if(null == this.field967) {
         return true;
      } else if(var1 != 10) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.field967.length; ++var3) {
            var2 &= field998.method3344(this.field967[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1087715616"
   )
   public final boolean method842() {
      if(this.field967 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field967.length; ++var2) {
            var1 &= field998.method3344(this.field967[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Lclass88;",
      garbageValue = "1362459941"
   )
   public final class88 method843(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.field968 == null) {
         var7 = (long)((this.field974 << 10) + var2);
      } else {
         var7 = (long)((this.field974 << 10) + (var1 << 3) + var2);
      }

      Object var9 = (class88)field963.method3834(var7);
      if(null == var9) {
         class103 var10 = this.method846(var1, var2);
         if(var10 == null) {
            return null;
         }

         if(!this.field980) {
            var9 = var10.method2308(64 + this.field984, this.field985 + 768, -50, -10, -50);
         } else {
            var10.field1780 = (short)(64 + this.field984);
            var10.field1774 = (short)(this.field985 + 768);
            var10.method2304();
            var9 = var10;
         }

         field963.method3836((class207)var9, var7);
      }

      if(this.field980) {
         var9 = ((class103)var9).method2292();
      }

      if(this.field979 >= 0) {
         if(var9 instanceof class108) {
            var9 = ((class108)var9).method2377(var3, var4, var5, var6, true, this.field979);
         } else if(var9 instanceof class103) {
            var9 = ((class103)var9).method2293(var3, var4, var5, var6, true, this.field979);
         }
      }

      return (class88)var9;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Lclass108;",
      garbageValue = "1085712843"
   )
   public final class108 method844(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.field968 == null) {
         var7 = (long)((this.field974 << 10) + var2);
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.field974 << 10));
      }

      class108 var9 = (class108)field986.method3834(var7);
      if(null == var9) {
         class103 var10 = this.method846(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.method2308(64 + this.field984, this.field985 + 768, -50, -10, -50);
         field986.method3836(var9, var7);
      }

      if(this.field979 >= 0) {
         var9 = var9.method2377(var3, var4, var5, var6, true, this.field979);
      }

      return var9;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II[[IIIILclass44;II)Lclass108;",
      garbageValue = "-160992459"
   )
   public final class108 method845(int var1, int var2, int[][] var3, int var4, int var5, int var6, class44 var7, int var8) {
      long var9;
      if(null == this.field968) {
         var9 = (long)(var2 + (this.field974 << 10));
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.field974 << 10));
      }

      class108 var11 = (class108)field986.method3834(var9);
      if(null == var11) {
         class103 var12 = this.method846(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.method2308(64 + this.field984, 768 + this.field985, -50, -10, -50);
         field986.method3836(var11, var9);
      }

      if(var7 == null && this.field979 == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method940(var11, var8, var2);
         } else {
            var11 = var11.method2452(true);
         }

         if(this.field979 >= 0) {
            var11 = var11.method2377(var3, var4, var5, var6, false, this.field979);
         }

         return var11;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)Lclass103;",
      garbageValue = "39"
   )
   final class103 method846(int var1, int var2) {
      class103 var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(this.field968 == null) {
         if(var1 != 10) {
            return null;
         }

         if(null == this.field967) {
            return null;
         }

         var4 = this.field966;
         if(var1 == 2 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.field967.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            var7 = this.field967[var6];
            if(var4) {
               var7 += 65536;
            }

            var3 = (class103)field1006.method3834((long)var7);
            if(var3 == null) {
               var3 = class103.method2311(field998, var7 & '\uffff', 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2340();
               }

               field1006.method3836(var3, (long)var7);
            }

            if(var5 > 1) {
               field965[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new class103(field965, var5);
         }
      } else {
         int var9 = -1;

         for(var5 = 0; var5 < this.field968.length; ++var5) {
            if(this.field968[var5] == var1) {
               var9 = var5;
               break;
            }
         }

         if(var9 == -1) {
            return null;
         }

         var5 = this.field967[var9];
         boolean var10 = this.field966 ^ var2 > 3;
         if(var10) {
            var5 += 65536;
         }

         var3 = (class103)field1006.method3834((long)var5);
         if(var3 == null) {
            var3 = class103.method2311(field998, var5 & '\uffff', 0);
            if(null == var3) {
               return null;
            }

            if(var10) {
               var3.method2340();
            }

            field1006.method3836(var3, (long)var5);
         }
      }

      if(this.field983 == 128 && this.field992 == 128 && this.field993 == 128) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var11;
      if(this.field994 == 0 && this.field978 == 0 && this.field996 == 0) {
         var11 = false;
      } else {
         var11 = true;
      }

      class103 var8 = new class103(var3, var2 == 0 && !var4 && !var11, this.field970 == null, this.field972 == null, true);
      if(var1 == 4 && var2 > 3) {
         var8.method2298(256);
         var8.method2302(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method2314();
      } else if(var2 == 2) {
         var8.method2287();
      } else if(var2 == 3) {
         var8.method2297();
      }

      if(this.field970 != null) {
         for(var7 = 0; var7 < this.field970.length; ++var7) {
            var8.method2350(this.field970[var7], this.field991[var7]);
         }
      }

      if(null != this.field972) {
         for(var7 = 0; var7 < this.field972.length; ++var7) {
            var8.method2301(this.field972[var7], this.field973[var7]);
         }
      }

      if(var4) {
         var8.method2303(this.field983, this.field992, this.field993);
      }

      if(var11) {
         var8.method2302(this.field994, this.field978, this.field996);
      }

      return var8;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)Lclass42;",
      garbageValue = "48"
   )
   @Export("getImpostor")
   public final class42 method847() {
      int var1 = -1;
      if(this.field1001 != -1) {
         var1 = class174.method3475(this.field1001);
      } else if(this.field1002 != -1) {
         var1 = class179.field2944[this.field1002];
      }

      return var1 >= 0 && var1 < this.field969.length && this.field969[var1] != -1?class146.method3102(this.field969[var1]):null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "331239288"
   )
   public boolean method848() {
      if(null == this.field969) {
         return this.field1003 != -1 || this.field1007 != null;
      } else {
         for(int var1 = 0; var1 < this.field969.length; ++var1) {
            if(this.field969[var1] != -1) {
               class42 var2 = class146.method3102(this.field969[var1]);
               if(var2.field1003 != -1 || null != var2.field1007) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-329313774"
   )
   static final void method854(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var1 + var3; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class5.field83[0][var5][var4] = 127;
               if(var5 == var0 && var5 > 0) {
                  class5.field78[0][var5][var4] = class5.field78[0][var5 - 1][var4];
               }

               if(var5 == var0 + var2 && var5 < 103) {
                  class5.field78[0][var5][var4] = class5.field78[0][var5 + 1][var4];
               }

               if(var1 == var4 && var4 > 0) {
                  class5.field78[0][var5][var4] = class5.field78[0][var5][var4 - 1];
               }

               if(var3 + var1 == var4 && var4 < 103) {
                  class5.field78[0][var5][var4] = class5.field78[0][var5][var4 + 1];
               }
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "449498111"
   )
   void method866() {
      if(this.field971 == -1) {
         this.field971 = 0;
         if(null != this.field967 && (null == this.field968 || this.field968[0] == 10)) {
            this.field971 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.field962[var1] != null) {
               this.field971 = 1;
            }
         }
      }

      if(this.field999 == -1) {
         this.field999 = this.field976 != 0?1:0;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass170;IIB)Z",
      garbageValue = "43"
   )
   static boolean method884(class170 var0, int var1, int var2) {
      byte[] var3 = var0.method3340(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         class49.method1075(var3);
         return true;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   static void method885(int var0) {
      class15 var1 = (class15)class15.field227.method3864((long)var0);
      if(var1 != null) {
         for(int var2 = 0; var2 < var1.field226.length; ++var2) {
            var1.field226[var2] = -1;
            var1.field228[var2] = 0;
         }

      }
   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lclass176;I)Ljava/lang/String;",
      garbageValue = "-805621633"
   )
   static String method886(String var0, class176 var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         String var4;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               var4 = var0.substring(0, var3);
               int var6 = class62.method1364(var1, var2 - 1);
               String var8;
               if(var6 < 999999999) {
                  var8 = Integer.toString(var6);
               } else {
                  var8 = "*";
               }

               var0 = var4 + var8 + var0.substring(2 + var3);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var7 = "";
            if(null != class52.field1154) {
               int var5 = class52.field1154.field2266;
               var4 = (var5 >> 24 & 255) + "." + (var5 >> 16 & 255) + "." + (var5 >> 8 & 255) + "." + (var5 & 255);
               var7 = var4;
               if(class52.field1154.field2260 != null) {
                  var7 = (String)class52.field1154.field2260;
               }
            }

            var0 = var0.substring(0, var2) + var7 + var0.substring(4 + var2);
         }
      }

      return var0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BZB)Ljava/lang/Object;",
      garbageValue = "105"
   )
   public static Object method888(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !class128.field2092) {
            try {
               class121 var2 = new class121();
               var2.vmethod2905(var0);
               return var2;
            } catch (Throwable var3) {
               class128.field2092 = true;
            }
         }

         return var0;
      }
   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
@Implements("ObjectComposition")
public class class42 extends class207 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 804391499
   )
   public int field942 = -1;
   @ObfuscatedName("e")
   static class170 field943;
   @ObfuscatedName("o")
   public static class196 field944 = new class196(64);
   @ObfuscatedName("g")
   public static class196 field945 = new class196(500);
   @ObfuscatedName("l")
   public static class196 field946 = new class196(30);
   @ObfuscatedName("j")
   public static class196 field947 = new class196(30);
   @ObfuscatedName("r")
   static class103[] field948 = new class103[4];
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1935092321
   )
   public int field949;
   @ObfuscatedName("k")
   int[] field950;
   @ObfuscatedName("v")
   int[] field951;
   @ObfuscatedName("h")
   @Export("name")
   public String field952 = "null";
   @ObfuscatedName("u")
   short[] field953;
   @ObfuscatedName("y")
   short[] field954;
   @ObfuscatedName("p")
   short[] field955;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1575019953
   )
   int field956 = 0;
   @ObfuscatedName("ay")
   boolean field957 = false;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1245938975
   )
   public int field958 = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 678707981
   )
   public int field959 = 2;
   @ObfuscatedName("t")
   public boolean field960 = true;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -838506017
   )
   public int field961 = -1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1909114879
   )
   int field962 = -1;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1058060189
   )
   int field963 = 128;
   @ObfuscatedName("q")
   public boolean field964 = false;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1016298241
   )
   public int field965 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2111396295
   )
   public int field966 = 16;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1999866161
   )
   int field967 = 0;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 769318113
   )
   int field968 = 0;
   @ObfuscatedName("s")
   short[] field969;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1737496969
   )
   int field970 = 0;
   @ObfuscatedName("aw")
   public boolean field971 = false;
   @ObfuscatedName("ai")
   boolean field972 = false;
   @ObfuscatedName("ap")
   @Export("actions")
   public String[] field973 = new String[5];
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1366590451
   )
   public int field974 = -1;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -939197643
   )
   int field975 = 128;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1586879861
   )
   public int field976 = 1;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 2067747883
   )
   int field977 = -1;
   @ObfuscatedName("m")
   static boolean field978 = false;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1432360227
   )
   int field979 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 862246013
   )
   public int field980 = 1;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -356487915
   )
   int field981 = 128;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1031653369
   )
   public int field982 = -1;
   @ObfuscatedName("al")
   @Export("impostorIds")
   public int[] field983;
   @ObfuscatedName("aa")
   public boolean field984 = true;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1228410729
   )
   int field985 = -1;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 872969663
   )
   public int field986 = -1;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -646800715
   )
   public int field987 = 0;
   @ObfuscatedName("n")
   boolean field988 = false;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 2135427407
   )
   public int field989 = 0;
   @ObfuscatedName("az")
   public int[] field990;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 1184735505
   )
   static int field991;
   @ObfuscatedName("bh")
   static class171 field993;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass122;B)V",
      garbageValue = "-1"
   )
   void method831(class122 var1) {
      while(true) {
         int var2 = var1.method2556();
         if(var2 == 0) {
            return;
         }

         this.method832(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass122;IB)V",
      garbageValue = "-65"
   )
   void method832(class122 var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2556();
         if(var3 > 0) {
            if(this.field950 != null && !field978) {
               var1.field2045 += var3 * 3;
            } else {
               this.field951 = new int[var3];
               this.field950 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field950[var4] = var1.method2706();
                  this.field951[var4] = var1.method2556();
               }
            }
         }
      } else if(var2 == 2) {
         this.field952 = var1.method2580();
      } else if(var2 == 5) {
         var3 = var1.method2556();
         if(var3 > 0) {
            if(this.field950 != null && !field978) {
               var1.field2045 += var3 * 2;
            } else {
               this.field951 = null;
               this.field950 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field950[var4] = var1.method2706();
               }
            }
         }
      } else if(var2 == 14) {
         this.field976 = var1.method2556();
      } else if(var2 == 15) {
         this.field980 = var1.method2556();
      } else if(var2 == 17) {
         this.field959 = 0;
         this.field960 = false;
      } else if(var2 == 18) {
         this.field960 = false;
      } else if(var2 == 19) {
         this.field974 = var1.method2556();
      } else if(var2 == 21) {
         this.field962 = 0;
      } else if(var2 == 22) {
         this.field988 = true;
      } else if(var2 == 23) {
         this.field964 = true;
      } else if(var2 == 24) {
         this.field942 = var1.method2706();
         if(this.field942 == '\uffff') {
            this.field942 = -1;
         }
      } else if(var2 == 27) {
         this.field959 = 1;
      } else if(var2 == 28) {
         this.field966 = var1.method2556();
      } else if(var2 == 29) {
         this.field967 = var1.method2573();
      } else if(var2 == 39) {
         this.field968 = var1.method2573() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.field973[var2 - 30] = var1.method2580();
         if(this.field973[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.field973[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2556();
         this.field953 = new short[var3];
         this.field954 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field953[var4] = (short)var1.method2706();
            this.field954[var4] = (short)var1.method2706();
         }
      } else if(var2 == 41) {
         var3 = var1.method2556();
         this.field955 = new short[var3];
         this.field969 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field955[var4] = (short)var1.method2706();
            this.field969[var4] = (short)var1.method2706();
         }
      } else if(var2 == 60) {
         this.field958 = var1.method2706();
      } else if(var2 == 62) {
         this.field972 = true;
      } else if(var2 == 64) {
         this.field984 = false;
      } else if(var2 == 65) {
         this.field981 = var1.method2706();
      } else if(var2 == 66) {
         this.field975 = var1.method2706();
      } else if(var2 == 67) {
         this.field963 = var1.method2706();
      } else if(var2 == 68) {
         this.field961 = var1.method2706();
      } else if(var2 == 69) {
         var1.method2556();
      } else if(var2 == 70) {
         this.field970 = var1.method2575();
      } else if(var2 == 71) {
         this.field956 = var1.method2575();
      } else if(var2 == 72) {
         this.field979 = var1.method2575();
      } else if(var2 == 73) {
         this.field971 = true;
      } else if(var2 == 74) {
         this.field957 = true;
      } else if(var2 == 75) {
         this.field982 = var1.method2556();
      } else if(var2 == 77) {
         this.field977 = var1.method2706();
         if(this.field977 == '\uffff') {
            this.field977 = -1;
         }

         this.field985 = var1.method2706();
         if(this.field985 == '\uffff') {
            this.field985 = -1;
         }

         var3 = var1.method2556();
         this.field983 = new int[var3 + 1];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field983[var4] = var1.method2706();
            if(this.field983[var4] == '\uffff') {
               this.field983[var4] = -1;
            }
         }
      } else if(var2 == 78) {
         this.field986 = var1.method2706();
         this.field987 = var1.method2556();
      } else if(var2 == 79) {
         this.field965 = var1.method2706();
         this.field989 = var1.method2706();
         this.field987 = var1.method2556();
         var3 = var1.method2556();
         this.field990 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field990[var4] = var1.method2706();
         }
      } else if(var2 == 81) {
         this.field962 = var1.method2556() * 256;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "622020175"
   )
   public final boolean method833(int var1) {
      if(this.field951 != null) {
         for(int var4 = 0; var4 < this.field951.length; ++var4) {
            if(this.field951[var4] == var1) {
               return field943.method3359(this.field950[var4] & '\uffff', 0);
            }
         }

         return true;
      } else if(this.field950 == null) {
         return true;
      } else if(var1 != 10) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.field950.length; ++var3) {
            var2 &= field943.method3359(this.field950[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "45"
   )
   public final boolean method834() {
      if(this.field950 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field950.length; ++var2) {
            var1 &= field943.method3359(this.field950[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II[[IIIIB)Lclass88;",
      garbageValue = "15"
   )
   public final class88 method835(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(null == this.field951) {
         var7 = (long)((this.field949 << 10) + var2);
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.field949 << 10));
      }

      Object var9 = (class88)field946.method3817(var7);
      if(var9 == null) {
         class103 var10 = this.method873(var1, var2);
         if(var10 == null) {
            return null;
         }

         if(!this.field988) {
            var9 = var10.method2305(64 + this.field967, 768 + this.field968, -50, -10, -50);
         } else {
            var10.field1790 = (short)(this.field967 + 64);
            var10.field1791 = (short)(768 + this.field968);
            var10.method2301();
            var9 = var10;
         }

         field946.method3823((class207)var9, var7);
      }

      if(this.field988) {
         var9 = ((class103)var9).method2290();
      }

      if(this.field962 >= 0) {
         if(var9 instanceof class108) {
            var9 = ((class108)var9).method2367(var3, var4, var5, var6, true, this.field962);
         } else if(var9 instanceof class103) {
            var9 = ((class103)var9).method2354(var3, var4, var5, var6, true, this.field962);
         }
      }

      return (class88)var9;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1622648551"
   )
   void method837() {
      if(this.field974 == -1) {
         this.field974 = 0;
         if(null != this.field950 && (null == this.field951 || this.field951[0] == 10)) {
            this.field974 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.field973[var1] != null) {
               this.field974 = 1;
            }
         }
      }

      if(this.field982 == -1) {
         this.field982 = this.field959 != 0?1:0;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "923524685"
   )
   public boolean method840() {
      if(null == this.field983) {
         return this.field986 != -1 || null != this.field990;
      } else {
         for(int var1 = 0; var1 < this.field983.length; ++var1) {
            if(this.field983[var1] != -1) {
               class42 var2 = class7.method100(this.field983[var1]);
               if(var2.field986 != -1 || null != var2.field990) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)Lclass42;",
      garbageValue = "-116"
   )
   @Export("getImpostor")
   public final class42 method851() {
      int var1 = -1;
      if(this.field977 != -1) {
         var1 = class12.method154(this.field977);
      } else if(this.field985 != -1) {
         var1 = class179.field2949[this.field985];
      }

      return var1 >= 0 && var1 < this.field983.length && this.field983[var1] != -1?class7.method100(this.field983[var1]):null;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II[[IIIILclass44;II)Lclass108;",
      garbageValue = "-1310671765"
   )
   public final class108 method859(int var1, int var2, int[][] var3, int var4, int var5, int var6, class44 var7, int var8) {
      long var9;
      if(this.field951 == null) {
         var9 = (long)((this.field949 << 10) + var2);
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.field949 << 10));
      }

      class108 var11 = (class108)field947.method3817(var9);
      if(var11 == null) {
         class103 var12 = this.method873(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.method2305(64 + this.field967, 768 + this.field968, -50, -10, -50);
         field947.method3823(var11, var9);
      }

      if(var7 == null && this.field962 == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method911(var11, var8, var2);
         } else {
            var11 = var11.method2368(true);
         }

         if(this.field962 >= 0) {
            var11 = var11.method2367(var3, var4, var5, var6, false, this.field962);
         }

         return var11;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Lclass108;",
      garbageValue = "1085456157"
   )
   public final class108 method864(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.field951 == null) {
         var7 = (long)(var2 + (this.field949 << 10));
      } else {
         var7 = (long)((var1 << 3) + (this.field949 << 10) + var2);
      }

      class108 var9 = (class108)field947.method3817(var7);
      if(null == var9) {
         class103 var10 = this.method873(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.method2305(this.field967 + 64, this.field968 + 768, -50, -10, -50);
         field947.method3823(var9, var7);
      }

      if(this.field962 >= 0) {
         var9 = var9.method2367(var3, var4, var5, var6, true, this.field962);
      }

      return var9;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIS)Lclass103;",
      garbageValue = "18787"
   )
   final class103 method873(int var1, int var2) {
      class103 var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(null == this.field951) {
         if(var1 != 10) {
            return null;
         }

         if(null == this.field950) {
            return null;
         }

         var4 = this.field972;
         if(var1 == 2 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.field950.length;

         for(int var8 = 0; var8 < var5; ++var8) {
            var7 = this.field950[var8];
            if(var4) {
               var7 += 65536;
            }

            var3 = (class103)field945.method3817((long)var7);
            if(var3 == null) {
               var3 = class103.method2323(field943, var7 & '\uffff', 0);
               if(null == var3) {
                  return null;
               }

               if(var4) {
                  var3.method2299();
               }

               field945.method3823(var3, (long)var7);
            }

            if(var5 > 1) {
               field948[var8] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new class103(field948, var5);
         }
      } else {
         int var9 = -1;

         for(var5 = 0; var5 < this.field951.length; ++var5) {
            if(this.field951[var5] == var1) {
               var9 = var5;
               break;
            }
         }

         if(var9 == -1) {
            return null;
         }

         var5 = this.field950[var9];
         boolean var11 = this.field972 ^ var2 > 3;
         if(var11) {
            var5 += 65536;
         }

         var3 = (class103)field945.method3817((long)var5);
         if(null == var3) {
            var3 = class103.method2323(field943, var5 & '\uffff', 0);
            if(var3 == null) {
               return null;
            }

            if(var11) {
               var3.method2299();
            }

            field945.method3823(var3, (long)var5);
         }
      }

      if(this.field981 == 128 && this.field975 == 128 && this.field963 == 128) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var10;
      if(this.field970 == 0 && this.field956 == 0 && this.field979 == 0) {
         var10 = false;
      } else {
         var10 = true;
      }

      class103 var6 = new class103(var3, var2 == 0 && !var4 && !var10, this.field953 == null, null == this.field955, true);
      if(var1 == 4 && var2 > 3) {
         var6.method2296(256);
         var6.method2314(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var6.method2286();
      } else if(var2 == 2) {
         var6.method2294();
      } else if(var2 == 3) {
         var6.method2287();
      }

      if(this.field953 != null) {
         for(var7 = 0; var7 < this.field953.length; ++var7) {
            var6.method2317(this.field953[var7], this.field954[var7]);
         }
      }

      if(null != this.field955) {
         for(var7 = 0; var7 < this.field955.length; ++var7) {
            var6.method2298(this.field955[var7], this.field969[var7]);
         }
      }

      if(var4) {
         var6.method2348(this.field981, this.field975, this.field963);
      }

      if(var10) {
         var6.method2314(this.field970, this.field956, this.field979);
      }

      return var6;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass170;III)Lclass83;",
      garbageValue = "802665185"
   )
   static class83 method879(class170 var0, int var1, int var2) {
      return !class33.method708(var0, var1, var2)?null:class77.method1682();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass125;II)Z",
      garbageValue = "-2135971188"
   )
   static boolean method880(class125 var0, int var1) {
      int var2 = var0.method2813(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method2813(1) != 0) {
            method880(var0, var1);
         }

         var3 = var0.method2813(6);
         var4 = var0.method2813(6);
         boolean var12 = var0.method2813(1) == 1;
         if(var12) {
            class34.field783[++class34.field782 - 1] = var1;
         }

         if(null != client.field393[var1]) {
            throw new RuntimeException();
         } else {
            class2 var6 = client.field393[var1] = new class2();
            var6.field46 = var1;
            if(class34.field775[var1] != null) {
               var6.method12(class34.field775[var1]);
            }

            var6.field881 = class34.field778[var1];
            var6.field856 = class34.field781[var1];
            var7 = class34.field779[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.field887[0] = class34.field773[var1];
            var6.field57 = (byte)var8;
            var6.method17(var3 + (var9 << 6) - class39.field838, (var10 << 6) + var4 - class13.field184);
            var6.field59 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method2813(2);
         var4 = class34.field779[var1];
         class34.field779[var1] = (var4 & 268435455) + (((var4 >> 28) + var3 & 3) << 28);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.method2813(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class34.field779[var1];
            var7 = (var11 >> 28) + var4 & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class34.field779[var1] = (var8 << 14) + (var7 << 28) + var9;
            return false;
         } else {
            var3 = var0.method2813(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class34.field779[var1];
            var8 = var4 + (var7 >> 28) & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var11 + var7 & 255;
            class34.field779[var1] = var10 + (var8 << 28) + (var9 << 14);
            return false;
         }
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Lclass35;I)V",
      garbageValue = "-536036867"
   )
   static final void method881(class35 var0) {
      if(class114.field2010.field864 >> 7 == client.field504 && client.field464 == class114.field2010.field831 >> 7) {
         client.field504 = 0;
      }

      int var1 = class34.field777;
      int[] var2 = class34.field780;
      int var3 = var1;
      if(var0 == class35.field793 || var0 == class35.field789) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         class2 var5;
         int var6;
         if(var0 == class35.field793) {
            var5 = class114.field2010;
            var6 = class114.field2010.field46 << 14;
         } else if(class35.field789 == var0) {
            var5 = client.field393[client.field344];
            var6 = client.field344 << 14;
         } else {
            var5 = client.field393[var2[var4]];
            var6 = var2[var4] << 14;
            if(class35.field792 == var0 && var2[var4] == client.field344) {
               continue;
            }
         }

         if(var5 != null && var5.vmethod786() && !var5.field56) {
            var5.field54 = false;
            if((client.field277 && var1 > 50 || var1 > 200) && var0 != class35.field793 && var5.field859 == var5.field847) {
               var5.field54 = true;
            }

            int var7 = var5.field864 >> 7;
            int var8 = var5.field831 >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(null != var5.field49 && client.field282 >= var5.field44 && client.field282 < var5.field36) {
                  var5.field54 = false;
                  var5.field45 = class15.method163(var5.field864, var5.field831, class51.field1119);
                  class5.field91.method2011(class51.field1119, var5.field864, var5.field831, var5.field45, 60, var5, var5.field832, var6, var5.field37, var5.field51, var5.field52, var5.field53);
               } else {
                  if((var5.field864 & 127) == 64 && (var5.field831 & 127) == 64) {
                     if(client.field376[var7][var8] == client.field377) {
                        continue;
                     }

                     client.field376[var7][var8] = client.field377;
                  }

                  var5.field45 = class15.method163(var5.field864, var5.field831, class51.field1119);
                  class5.field91.method2010(class51.field1119, var5.field864, var5.field831, var5.field45, 60, var5, var5.field832, var6, var5.field891);
               }
            }
         }
      }

   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-71"
   )
   static final boolean method882(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = client.field415[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
@Implements("ObjectComposition")
public class class40 extends class204 {
   @ObfuscatedName("r")
   static class193 field924 = new class193(30);
   @ObfuscatedName("am")
   public int[] field925;
   @ObfuscatedName("y")
   public static class193 field926 = new class193(500);
   @ObfuscatedName("k")
   static class193 field927 = new class193(30);
   @ObfuscatedName("z")
   short[] field928;
   @ObfuscatedName("p")
   static class100[] field929 = new class100[4];
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 836795051
   )
   public int field930;
   @ObfuscatedName("iw")
   @ObfuscatedGetter(
      intValue = -739765793
   )
   static int field931;
   @ObfuscatedName("e")
   int[] field932;
   @ObfuscatedName("x")
   @Export("name")
   public String field933 = "null";
   @ObfuscatedName("a")
   static boolean field934 = false;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1027916529
   )
   int field935 = -1;
   @ObfuscatedName("t")
   short[] field936;
   @ObfuscatedName("ae")
   boolean field937 = false;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -797066149
   )
   public int field938 = 1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2076671027
   )
   public int field939 = 1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1092265621
   )
   public int field940 = 2;
   @ObfuscatedName("h")
   public boolean field941 = true;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 592654481
   )
   public int field942 = -1;
   @ObfuscatedName("m")
   int[] field943;
   @ObfuscatedName("b")
   boolean field944 = false;
   @ObfuscatedName("l")
   public boolean field945 = false;
   @ObfuscatedName("n")
   short[] field946;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1531981683
   )
   public int field947 = 16;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -503958603
   )
   public int field948 = 0;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1364274649
   )
   int field949 = 0;
   @ObfuscatedName("ah")
   @Export("actions")
   public String[] field950 = new String[5];
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1796263375
   )
   public int field951 = -1;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -615535615
   )
   public int field952 = -1;
   @ObfuscatedName("al")
   boolean field953 = false;
   @ObfuscatedName("ai")
   public boolean field954 = true;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1088082433
   )
   int field956 = 128;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1476017245
   )
   int field957 = 128;
   @ObfuscatedName("c")
   static class193 field958 = new class193(64);
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1241787175
   )
   public int field959 = -1;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -163899617
   )
   int field960 = 0;
   @ObfuscatedName("ab")
   public boolean field961 = false;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -582108773
   )
   public int field962 = 0;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1440204831
   )
   public int field963 = -1;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1591099167
   )
   int field964 = 0;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -757861955
   )
   int field965 = 0;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1043613593
   )
   int field966 = 0;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1503834889
   )
   public int field967 = -1;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 916560505
   )
   public int field968 = 0;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -2128018807
   )
   int field970 = -1;
   @ObfuscatedName("aa")
   public int[] field971;
   @ObfuscatedName("i")
   short[] field972;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 174772811
   )
   public static int field973;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1367677257
   )
   int field974 = -1;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -363897889
   )
   int field976 = 128;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "53"
   )
   void method890() {
      if(-1 == this.field942) {
         this.field942 = 0;
         if(null != this.field943 && (null == this.field932 || 10 == this.field932[0])) {
            this.field942 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(null != this.field950[var1]) {
               this.field942 = 1;
            }
         }
      }

      if(this.field963 == -1) {
         this.field963 = this.field940 != 0?1:0;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "-2125254264"
   )
   void method891(class119 var1) {
      while(true) {
         int var2 = var1.method2613();
         if(0 == var2) {
            return;
         }

         this.method892(var1, var2);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "26500433"
   )
   void method892(class119 var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2613();
         if(var3 > 0) {
            if(null != this.field943 && !field934) {
               var1.field1992 += 3 * var3;
            } else {
               this.field932 = new int[var3];
               this.field943 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field943[var4] = var1.method2615();
                  this.field932[var4] = var1.method2613();
               }
            }
         }
      } else if(var2 == 2) {
         this.field933 = var1.method2621();
      } else if(var2 == 5) {
         var3 = var1.method2613();
         if(var3 > 0) {
            if(this.field943 != null && !field934) {
               var1.field1992 += 2 * var3;
            } else {
               this.field932 = null;
               this.field943 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field943[var4] = var1.method2615();
               }
            }
         }
      } else if(14 == var2) {
         this.field938 = var1.method2613();
      } else if(15 == var2) {
         this.field939 = var1.method2613();
      } else if(var2 == 17) {
         this.field940 = 0;
         this.field941 = false;
      } else if(18 == var2) {
         this.field941 = false;
      } else if(var2 == 19) {
         this.field942 = var1.method2613();
      } else if(var2 == 21) {
         this.field935 = 0;
      } else if(22 == var2) {
         this.field944 = true;
      } else if(var2 == 23) {
         this.field945 = true;
      } else if(var2 == 24) {
         this.field959 = var1.method2615();
         if('\uffff' == this.field959) {
            this.field959 = -1;
         }
      } else if(27 == var2) {
         this.field940 = 1;
      } else if(var2 == 28) {
         this.field947 = var1.method2613();
      } else if(var2 == 29) {
         this.field964 = var1.method2699();
      } else if(39 == var2) {
         this.field949 = var1.method2699() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.field950[var2 - 30] = var1.method2621();
         if(this.field950[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.field950[var2 - 30] = null;
         }
      } else if(40 == var2) {
         var3 = var1.method2613();
         this.field928 = new short[var3];
         this.field972 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field928[var4] = (short)var1.method2615();
            this.field972[var4] = (short)var1.method2615();
         }
      } else if(41 == var2) {
         var3 = var1.method2613();
         this.field936 = new short[var3];
         this.field946 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field936[var4] = (short)var1.method2615();
            this.field946[var4] = (short)var1.method2615();
         }
      } else if(60 == var2) {
         this.field951 = var1.method2615();
      } else if(var2 == 62) {
         this.field953 = true;
      } else if(64 == var2) {
         this.field954 = false;
      } else if(var2 == 65) {
         this.field976 = var1.method2615();
      } else if(var2 == 66) {
         this.field956 = var1.method2615();
      } else if(var2 == 67) {
         this.field957 = var1.method2615();
      } else if(var2 == 68) {
         this.field952 = var1.method2615();
      } else if(var2 == 69) {
         var1.method2613();
      } else if(var2 == 70) {
         this.field966 = var1.method2664();
      } else if(71 == var2) {
         this.field965 = var1.method2664();
      } else if(72 == var2) {
         this.field960 = var1.method2664();
      } else if(73 == var2) {
         this.field961 = true;
      } else if(74 == var2) {
         this.field937 = true;
      } else if(75 == var2) {
         this.field963 = var1.method2613();
      } else if(77 == var2) {
         this.field974 = var1.method2615();
         if('\uffff' == this.field974) {
            this.field974 = -1;
         }

         this.field970 = var1.method2615();
         if('\uffff' == this.field970) {
            this.field970 = -1;
         }

         var3 = var1.method2613();
         this.field925 = new int[1 + var3];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field925[var4] = var1.method2615();
            if('\uffff' == this.field925[var4]) {
               this.field925[var4] = -1;
            }
         }
      } else if(78 == var2) {
         this.field967 = var1.method2615();
         this.field968 = var1.method2613();
      } else if(79 == var2) {
         this.field962 = var1.method2615();
         this.field948 = var1.method2615();
         this.field968 = var1.method2613();
         var3 = var1.method2613();
         this.field971 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field971[var4] = var1.method2615();
         }
      } else if(81 == var2) {
         this.field935 = var1.method2613() * 256;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "692867927"
   )
   public final boolean method893(int var1) {
      if(null != this.field932) {
         for(int var4 = 0; var4 < this.field932.length; ++var4) {
            if(this.field932[var4] == var1) {
               return class222.field3182.method3429(this.field943[var4] & '\uffff', 0);
            }
         }

         return true;
      } else if(this.field943 == null) {
         return true;
      } else if(10 != var1) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.field943.length; ++var3) {
            var2 &= class222.field3182.method3429(this.field943[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Lclass40;",
      garbageValue = "1990811549"
   )
   public final class40 method894() {
      int var1 = -1;
      if(this.field974 != -1) {
         var1 = class93.method2248(this.field974);
      } else if(this.field970 != -1) {
         var1 = class176.field2905[this.field970];
      }

      return var1 >= 0 && var1 < this.field925.length && -1 != this.field925[var1]?class133.method2969(this.field925[var1]):null;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Lclass85;",
      garbageValue = "281318099"
   )
   public final class85 method895(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(null == this.field932) {
         var7 = (long)((this.field930 << 10) + var2);
      } else {
         var7 = (long)(var2 + (this.field930 << 10) + (var1 << 3));
      }

      Object var9 = (class85)field927.method3840(var7);
      if(null == var9) {
         class100 var10 = this.method898(var1, var2);
         if(null == var10) {
            return null;
         }

         if(!this.field944) {
            var9 = var10.method2368(64 + this.field964, 768 + this.field949, -50, -10, -50);
         } else {
            var10.field1721 = (short)(64 + this.field964);
            var10.field1722 = (short)(this.field949 + 768);
            var10.method2311();
            var9 = var10;
         }

         field927.method3842((class204)var9, var7);
      }

      if(this.field944) {
         var9 = ((class100)var9).method2295();
      }

      if(this.field935 >= 0) {
         if(var9 instanceof class105) {
            var9 = ((class105)var9).method2453(var3, var4, var5, var6, true, this.field935);
         } else if(var9 instanceof class100) {
            var9 = ((class100)var9).method2296(var3, var4, var5, var6, true, this.field935);
         }
      }

      return (class85)var9;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II[[IIIIB)Lclass105;",
      garbageValue = "71"
   )
   public final class105 method896(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.field932 == null) {
         var7 = (long)(var2 + (this.field930 << 10));
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.field930 << 10));
      }

      class105 var9 = (class105)field924.method3840(var7);
      if(null == var9) {
         class100 var10 = this.method898(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.method2368(64 + this.field964, this.field949 + 768, -50, -10, -50);
         field924.method3842(var9, var7);
      }

      if(this.field935 >= 0) {
         var9 = var9.method2453(var3, var4, var5, var6, true, this.field935);
      }

      return var9;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)Lclass100;",
      garbageValue = "-946796628"
   )
   final class100 method898(int var1, int var2) {
      class100 var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(this.field932 == null) {
         if(10 != var1) {
            return null;
         }

         if(this.field943 == null) {
            return null;
         }

         var4 = this.field953;
         if(var1 == 2 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.field943.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            var7 = this.field943[var6];
            if(var4) {
               var7 += 65536;
            }

            var3 = (class100)field926.method3840((long)var7);
            if(var3 == null) {
               var3 = class100.method2307(class222.field3182, var7 & '\uffff', 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2290();
               }

               field926.method3842(var3, (long)var7);
            }

            if(var5 > 1) {
               field929[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new class100(field929, var5);
         }
      } else {
         int var8 = -1;

         for(var5 = 0; var5 < this.field932.length; ++var5) {
            if(var1 == this.field932[var5]) {
               var8 = var5;
               break;
            }
         }

         if(var8 == -1) {
            return null;
         }

         var5 = this.field943[var8];
         boolean var9 = this.field953 ^ var2 > 3;
         if(var9) {
            var5 += 65536;
         }

         var3 = (class100)field926.method3840((long)var5);
         if(null == var3) {
            var3 = class100.method2307(class222.field3182, var5 & '\uffff', 0);
            if(var3 == null) {
               return null;
            }

            if(var9) {
               var3.method2290();
            }

            field926.method3842(var3, (long)var5);
         }
      }

      if(128 == this.field976 && 128 == this.field956 && 128 == this.field957) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var10;
      if(this.field966 == 0 && this.field965 == 0 && this.field960 == 0) {
         var10 = false;
      } else {
         var10 = true;
      }

      class100 var11 = new class100(var3, var2 == 0 && !var4 && !var10, null == this.field928, this.field936 == null, true);
      if(var1 == 4 && var2 > 3) {
         var11.method2340(256);
         var11.method2329(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var11.method2298();
      } else if(var2 == 2) {
         var11.method2299();
      } else if(3 == var2) {
         var11.method2300();
      }

      if(null != this.field928) {
         for(var7 = 0; var7 < this.field928.length; ++var7) {
            var11.method2303(this.field928[var7], this.field972[var7]);
         }
      }

      if(this.field936 != null) {
         for(var7 = 0; var7 < this.field936.length; ++var7) {
            var11.method2304(this.field936[var7], this.field946[var7]);
         }
      }

      if(var4) {
         var11.method2306(this.field976, this.field956, this.field957);
      }

      if(var10) {
         var11.method2329(this.field966, this.field965, this.field960);
      }

      return var11;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-703985804"
   )
   static void method899(int var0, String var1, String var2, String var3) {
      class27 var4 = (class27)class11.field183.get(Integer.valueOf(var0));
      if(null == var4) {
         var4 = new class27();
         class11.field183.put(Integer.valueOf(var0), var4);
      }

      class35 var5 = var4.method721(var0, var1, var2, var3);
      class11.field181.method3890(var5, (long)var5.field797);
      class11.field182.method3937(var5);
      client.field303 = client.field477;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-14"
   )
   public boolean method900() {
      if(null == this.field925) {
         return this.field967 != -1 || this.field971 != null;
      } else {
         for(int var1 = 0; var1 < this.field925.length; ++var1) {
            if(this.field925[var1] != -1) {
               class40 var2 = class133.method2969(this.field925[var1]);
               if(-1 != var2.field967 || null != var2.field971) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "97"
   )
   static void method902(int var0, int var1, int var2, int var3) {
      for(class23 var4 = (class23)class23.field627.method3926(); null != var4; var4 = (class23)class23.field627.method3902()) {
         if(-1 != var4.field620 || null != var4.field621) {
            int var5 = 0;
            if(var1 > var4.field614) {
               var5 += var1 - var4.field614;
            } else if(var1 < var4.field618) {
               var5 += var4.field618 - var1;
            }

            if(var2 > var4.field619) {
               var5 += var2 - var4.field619;
            } else if(var2 < var4.field613) {
               var5 += var4.field613 - var2;
            }

            if(var5 - 64 <= var4.field616 && 0 != client.field514 && var0 == var4.field624) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = (var4.field616 - var5) * client.field514 / var4.field616;
               if(null == var4.field615) {
                  if(var4.field620 >= 0) {
                     class58 var7 = class58.method1341(class114.field1967, var4.field620, 0);
                     if(null != var7) {
                        class62 var8 = var7.method1330().method1370(class82.field1439);
                        class64 var9 = class64.method1396(var8, 100, var6);
                        var9.method1399(-1);
                        class10.field178.method1253(var9);
                        var4.field615 = var9;
                     }
                  }
               } else {
                  var4.field615.method1400(var6);
               }

               if(null == var4.field623) {
                  if(null != var4.field621 && (var4.field622 -= var3) <= 0) {
                     int var11 = (int)(Math.random() * (double)var4.field621.length);
                     class58 var12 = class58.method1341(class114.field1967, var4.field621[var11], 0);
                     if(null != var12) {
                        class62 var13 = var12.method1330().method1370(class82.field1439);
                        class64 var10 = class64.method1396(var13, 100, var6);
                        var10.method1399(0);
                        class10.field178.method1253(var10);
                        var4.field623 = var10;
                        var4.field622 = var4.field610 + (int)(Math.random() * (double)(var4.field617 - var4.field610));
                     }
                  }
               } else {
                  var4.field623.method1400(var6);
                  if(!var4.field623.method4003()) {
                     var4.field623 = null;
                  }
               }
            } else {
               if(null != var4.field615) {
                  class10.field178.method1235(var4.field615);
                  var4.field615 = null;
               }

               if(var4.field623 != null) {
                  class10.field178.method1235(var4.field623);
                  var4.field623 = null;
               }
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1878927440"
   )
   public final boolean method913() {
      if(this.field943 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field943.length; ++var2) {
            var1 &= class222.field3182.method3429(this.field943[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Lclass37;II)V",
      garbageValue = "-1585885382"
   )
   static final void method932(class37 var0, int var1) {
      if(var0.field862 > client.field306) {
         class108.method2519(var0);
      } else {
         int var2;
         int var3;
         int var4;
         int var5;
         int var7;
         if(var0.field866 >= client.field306) {
            if(client.field306 == var0.field866 || var0.field848 == -1 || 0 != var0.field851 || var0.field872 + 1 > class96.method2279(var0.field848).field995[var0.field849]) {
               var2 = var0.field866 - var0.field862;
               var3 = client.field306 - var0.field862;
               var4 = var0.field858 * 128 + var0.field841 * 64;
               var5 = var0.field841 * 64 + var0.field860 * 128;
               int var6 = var0.field859 * 128 + var0.field841 * 64;
               var7 = var0.field833 * 128 + var0.field841 * 64;
               var0.field844 = (var4 * (var2 - var3) + var6 * var3) / var2;
               var0.field819 = ((var2 - var3) * var5 + var7 * var3) / var2;
            }

            var0.field874 = 0;
            var0.field853 = var0.field864;
            var0.field863 = var0.field853;
         } else {
            var0.field845 = var0.field822;
            if(0 == var0.field821) {
               var0.field874 = 0;
            } else {
               label325: {
                  if(-1 != var0.field848 && 0 == var0.field851) {
                     class42 var11 = class96.method2279(var0.field848);
                     if(var0.field875 > 0 && var11.field1003 == 0) {
                        ++var0.field874;
                        break label325;
                     }

                     if(var0.field875 <= 0 && 0 == var11.field1004) {
                        ++var0.field874;
                        break label325;
                     }
                  }

                  var2 = var0.field844;
                  var3 = var0.field819;
                  var4 = var0.field871[var0.field821 - 1] * 128 + var0.field841 * 64;
                  var5 = var0.field841 * 64 + var0.field835[var0.field821 - 1] * 128;
                  if(var2 < var4) {
                     if(var3 < var5) {
                        var0.field853 = 1280;
                     } else if(var3 > var5) {
                        var0.field853 = 1792;
                     } else {
                        var0.field853 = 1536;
                     }
                  } else if(var2 > var4) {
                     if(var3 < var5) {
                        var0.field853 = 768;
                     } else if(var3 > var5) {
                        var0.field853 = 256;
                     } else {
                        var0.field853 = 512;
                     }
                  } else if(var3 < var5) {
                     var0.field853 = 1024;
                  } else if(var3 > var5) {
                     var0.field853 = 0;
                  }

                  byte var12 = var0.field826[var0.field821 - 1];
                  if(var4 - var2 <= 256 && var4 - var2 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
                     var7 = var0.field853 - var0.field863 & 2047;
                     if(var7 > 1024) {
                        var7 -= 2048;
                     }

                     int var8 = var0.field839;
                     if(var7 >= -256 && var7 <= 256) {
                        var8 = var0.field825;
                     } else if(var7 >= 256 && var7 < 768) {
                        var8 = var0.field828;
                     } else if(var7 >= -768 && var7 <= -256) {
                        var8 = var0.field836;
                     }

                     if(var8 == -1) {
                        var8 = var0.field825;
                     }

                     var0.field845 = var8;
                     int var9 = 4;
                     boolean var10 = true;
                     if(var0 instanceof class34) {
                        var10 = ((class34)var0).field784.field920;
                     }

                     if(var10) {
                        if(var0.field853 != var0.field863 && var0.field842 == -1 && var0.field869 != 0) {
                           var9 = 2;
                        }

                        if(var0.field821 > 2) {
                           var9 = 6;
                        }

                        if(var0.field821 > 3) {
                           var9 = 8;
                        }

                        if(var0.field874 > 0 && var0.field821 > 1) {
                           var9 = 8;
                           --var0.field874;
                        }
                     } else {
                        if(var0.field821 > 1) {
                           var9 = 6;
                        }

                        if(var0.field821 > 2) {
                           var9 = 8;
                        }

                        if(var0.field874 > 0 && var0.field821 > 1) {
                           var9 = 8;
                           --var0.field874;
                        }
                     }

                     if(var12 == 2) {
                        var9 <<= 1;
                     }

                     if(var9 >= 8 && var0.field825 == var0.field845 && -1 != var0.field829) {
                        var0.field845 = var0.field829;
                     }

                     if(var2 != var4 || var5 != var3) {
                        if(var2 < var4) {
                           var0.field844 += var9;
                           if(var0.field844 > var4) {
                              var0.field844 = var4;
                           }
                        } else if(var2 > var4) {
                           var0.field844 -= var9;
                           if(var0.field844 < var4) {
                              var0.field844 = var4;
                           }
                        }

                        if(var3 < var5) {
                           var0.field819 += var9;
                           if(var0.field819 > var5) {
                              var0.field819 = var5;
                           }
                        } else if(var3 > var5) {
                           var0.field819 -= var9;
                           if(var0.field819 < var5) {
                              var0.field819 = var5;
                           }
                        }
                     }

                     if(var4 == var0.field844 && var0.field819 == var5) {
                        --var0.field821;
                        if(var0.field875 > 0) {
                           --var0.field875;
                        }
                     }
                  } else {
                     var0.field844 = var4;
                     var0.field819 = var5;
                     --var0.field821;
                     if(var0.field875 > 0) {
                        --var0.field875;
                     }
                  }
               }
            }
         }
      }

      if(var0.field844 < 128 || var0.field819 < 128 || var0.field844 >= 13184 || var0.field819 >= 13184) {
         var0.field848 = -1;
         var0.field865 = -1;
         var0.field862 = 0;
         var0.field866 = 0;
         var0.field844 = 128 * var0.field871[0] + var0.field841 * 64;
         var0.field819 = var0.field841 * 64 + var0.field835[0] * 128;
         var0.method838();
      }

      if(class5.field93 == var0 && (var0.field844 < 1536 || var0.field819 < 1536 || var0.field844 >= 11776 || var0.field819 >= 11776)) {
         var0.field848 = -1;
         var0.field865 = -1;
         var0.field862 = 0;
         var0.field866 = 0;
         var0.field844 = var0.field841 * 64 + var0.field871[0] * 128;
         var0.field819 = var0.field841 * 64 + var0.field835[0] * 128;
         var0.method838();
      }

      class15.method206(var0);
      class171.method3469(var0);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II[[IIIILclass42;IB)Lclass105;",
      garbageValue = "80"
   )
   public final class105 method933(int var1, int var2, int[][] var3, int var4, int var5, int var6, class42 var7, int var8) {
      long var9;
      if(this.field932 == null) {
         var9 = (long)(var2 + (this.field930 << 10));
      } else {
         var9 = (long)(var2 + (this.field930 << 10) + (var1 << 3));
      }

      class105 var11 = (class105)field924.method3840(var9);
      if(null == var11) {
         class100 var12 = this.method898(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.method2368(64 + this.field964, 768 + this.field949, -50, -10, -50);
         field924.method3842(var11, var9);
      }

      if(null == var7 && this.field935 == -1) {
         return var11;
      } else {
         if(null != var7) {
            var11 = var7.method955(var11, var8, var2);
         } else {
            var11 = var11.method2471(true);
         }

         if(this.field935 >= 0) {
            var11 = var11.method2453(var3, var4, var5, var6, false, this.field935);
         }

         return var11;
      }
   }
}

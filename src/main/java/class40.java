import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
@Implements("ObjectComposition")
public class class40 extends class204 {
   @ObfuscatedName("x")
   public static class167 field926;
   @ObfuscatedName("t")
   public static class167 field927;
   @ObfuscatedName("p")
   static class193 field928 = new class193(64);
   @ObfuscatedName("e")
   public static class193 field929 = new class193(500);
   @ObfuscatedName("y")
   static class193 field930 = new class193(30);
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 552809533
   )
   public int field931 = 2;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -695041273
   )
   int field932 = -1;
   @ObfuscatedName("ab")
   boolean field933 = false;
   @ObfuscatedName("l")
   int[] field934;
   @ObfuscatedName("z")
   int[] field935;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1506646237
   )
   public int field936;
   @ObfuscatedName("j")
   short[] field937;
   @ObfuscatedName("n")
   public boolean field938 = false;
   @ObfuscatedName("m")
   static class193 field939 = new class193(30);
   @ObfuscatedName("d")
   short[] field940;
   @ObfuscatedName("ag")
   public boolean field941 = false;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 577299093
   )
   public int field942 = 1;
   @ObfuscatedName("ao")
   public int[] field943;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 810329103
   )
   int field945 = 128;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -990219611
   )
   int field946 = -1;
   @ObfuscatedName("r")
   boolean field947 = false;
   @ObfuscatedName("c")
   static class100[] field948 = new class100[4];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1463129087
   )
   public int field949 = -1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1234337713
   )
   public int field950 = 16;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 110893253
   )
   int field951 = 0;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1766270737
   )
   int field952 = 0;
   @ObfuscatedName("ar")
   @Export("actions")
   public String[] field953 = new String[5];
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -268230523
   )
   public int field954 = -1;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1997417115
   )
   public int field955 = -1;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 2084049323
   )
   int field956 = 0;
   @ObfuscatedName("av")
   public boolean field957 = true;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 411884263
   )
   int field958 = 128;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1339169037
   )
   int field959 = 128;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1528850393
   )
   public int field960 = 0;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -995831269
   )
   int field961 = 0;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 237061533
   )
   int field962 = 0;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 398835755
   )
   public int field963 = -1;
   @ObfuscatedName("w")
   public static boolean field964 = false;
   @ObfuscatedName("ad")
   boolean field965 = false;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1897743645
   )
   public int field966 = -1;
   @ObfuscatedName("q")
   short[] field967;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1314991405
   )
   int field969 = -1;
   @ObfuscatedName("s")
   @Export("name")
   public String field970 = "null";
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -482106139
   )
   public int field971 = 0;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1804369075
   )
   public int field972 = 0;
   @ObfuscatedName("a")
   short[] field973;
   @ObfuscatedName("an")
   public int[] field974;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1441725805
   )
   public int field975 = -1;
   @ObfuscatedName("h")
   public boolean field977 = true;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2081154915
   )
   public int field979 = 1;

   @ObfuscatedName("y")
   public final boolean method821() {
      if(null == this.field934) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field934.length; ++var2) {
            var1 &= field927.method3290(this.field934[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1680105470"
   )
   void method822() {
      if(this.field975 == -1) {
         this.field975 = 0;
         if(null != this.field934 && (null == this.field935 || 10 == this.field935[0])) {
            this.field975 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(null != this.field953[var1]) {
               this.field975 = 1;
            }
         }
      }

      if(-1 == this.field966) {
         this.field966 = 0 != this.field931?1:0;
      }

   }

   @ObfuscatedName("t")
   void method823(class119 var1) {
      while(true) {
         int var2 = var1.method2506();
         if(0 == var2) {
            return;
         }

         this.method824(var1, var2);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "29"
   )
   void method824(class119 var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2506();
         if(var3 > 0) {
            if(null != this.field934 && !field964) {
               var1.field2011 += var3 * 3;
            } else {
               this.field935 = new int[var3];
               this.field934 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field934[var4] = var1.method2508();
                  this.field935[var4] = var1.method2506();
               }
            }
         }
      } else if(var2 == 2) {
         this.field970 = var1.method2683();
      } else if(5 == var2) {
         var3 = var1.method2506();
         if(var3 > 0) {
            if(null != this.field934 && !field964) {
               var1.field2011 += var3 * 2;
            } else {
               this.field935 = null;
               this.field934 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field934[var4] = var1.method2508();
               }
            }
         }
      } else if(var2 == 14) {
         this.field979 = var1.method2506();
      } else if(var2 == 15) {
         this.field942 = var1.method2506();
      } else if(17 == var2) {
         this.field931 = 0;
         this.field977 = false;
      } else if(18 == var2) {
         this.field977 = false;
      } else if(var2 == 19) {
         this.field975 = var1.method2506();
      } else if(21 == var2) {
         this.field946 = 0;
      } else if(var2 == 22) {
         this.field947 = true;
      } else if(23 == var2) {
         this.field938 = true;
      } else if(24 == var2) {
         this.field949 = var1.method2508();
         if(this.field949 == '\uffff') {
            this.field949 = -1;
         }
      } else if(var2 == 27) {
         this.field931 = 1;
      } else if(28 == var2) {
         this.field950 = var1.method2506();
      } else if(var2 == 29) {
         this.field951 = var1.method2524();
      } else if(39 == var2) {
         this.field952 = var1.method2524() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.field953[var2 - 30] = var1.method2683();
         if(this.field953[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.field953[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2506();
         this.field937 = new short[var3];
         this.field967 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field937[var4] = (short)var1.method2508();
            this.field967[var4] = (short)var1.method2508();
         }
      } else if(var2 == 41) {
         var3 = var1.method2506();
         this.field973 = new short[var3];
         this.field940 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field973[var4] = (short)var1.method2508();
            this.field940[var4] = (short)var1.method2508();
         }
      } else if(var2 == 60) {
         this.field954 = var1.method2508();
      } else if(62 == var2) {
         this.field933 = true;
      } else if(var2 == 64) {
         this.field957 = false;
      } else if(65 == var2) {
         this.field958 = var1.method2508();
      } else if(66 == var2) {
         this.field959 = var1.method2508();
      } else if(67 == var2) {
         this.field945 = var1.method2508();
      } else if(68 == var2) {
         this.field955 = var1.method2508();
      } else if(var2 == 69) {
         var1.method2506();
      } else if(var2 == 70) {
         this.field961 = var1.method2509();
      } else if(var2 == 71) {
         this.field962 = var1.method2509();
      } else if(72 == var2) {
         this.field956 = var1.method2509();
      } else if(73 == var2) {
         this.field941 = true;
      } else if(var2 == 74) {
         this.field965 = true;
      } else if(75 == var2) {
         this.field966 = var1.method2506();
      } else if(var2 == 77) {
         this.field932 = var1.method2508();
         if(this.field932 == '\uffff') {
            this.field932 = -1;
         }

         this.field969 = var1.method2508();
         if(this.field969 == '\uffff') {
            this.field969 = -1;
         }

         var3 = var1.method2506();
         this.field943 = new int[var3 + 1];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field943[var4] = var1.method2508();
            if(this.field943[var4] == '\uffff') {
               this.field943[var4] = -1;
            }
         }
      } else if(78 == var2) {
         this.field963 = var1.method2508();
         this.field971 = var1.method2506();
      } else if(79 == var2) {
         this.field972 = var1.method2508();
         this.field960 = var1.method2508();
         this.field971 = var1.method2506();
         var3 = var1.method2506();
         this.field974 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field974[var4] = var1.method2508();
         }
      } else if(81 == var2) {
         this.field946 = var1.method2506() * 256;
      }

   }

   @ObfuscatedName("e")
   public final boolean method825(int var1) {
      if(this.field935 != null) {
         for(int var4 = 0; var4 < this.field935.length; ++var4) {
            if(this.field935[var4] == var1) {
               return field927.method3290(this.field934[var4] & '\uffff', 0);
            }
         }

         return true;
      } else if(null == this.field934) {
         return true;
      } else if(10 != var1) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.field934.length; ++var3) {
            var2 &= field927.method3290(this.field934[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("m")
   public final class85 method827(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(null == this.field935) {
         var7 = (long)((this.field936 << 10) + var2);
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.field936 << 10));
      }

      Object var9 = (class85)field930.method3771(var7);
      if(null == var9) {
         class100 var10 = this.method874(var1, var2);
         if(null == var10) {
            return null;
         }

         if(!this.field947) {
            var9 = var10.method2212(this.field951 + 64, 768 + this.field952, -50, -10, -50);
         } else {
            var10.field1734 = (short)(this.field951 + 64);
            var10.field1735 = (short)(768 + this.field952);
            var10.method2262();
            var9 = var10;
         }

         field930.method3773((class204)var9, var7);
      }

      if(this.field947) {
         var9 = ((class100)var9).method2248();
      }

      if(this.field946 >= 0) {
         if(var9 instanceof class105) {
            var9 = ((class105)var9).method2300(var3, var4, var5, var6, true, this.field946);
         } else if(var9 instanceof class100) {
            var9 = ((class100)var9).method2225(var3, var4, var5, var6, this.field946);
         }
      }

      return (class85)var9;
   }

   @ObfuscatedName("v")
   public final class105 method829(int var1, int var2, int[][] var3, int var4, int var5, int var6, class42 var7, int var8) {
      long var9;
      if(this.field935 == null) {
         var9 = (long)((this.field936 << 10) + var2);
      } else {
         var9 = (long)((this.field936 << 10) + (var1 << 3) + var2);
      }

      class105 var11 = (class105)field939.method3771(var9);
      if(null == var11) {
         class100 var12 = this.method874(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.method2212(64 + this.field951, 768 + this.field952, -50, -10, -50);
         field939.method3773(var11, var9);
      }

      if(var7 == null && -1 == this.field946) {
         return var11;
      } else {
         if(null != var7) {
            var11 = var7.method919(var11, var8, var2);
         } else {
            var11 = var11.method2311(true);
         }

         if(this.field946 >= 0) {
            var11 = var11.method2300(var3, var4, var5, var6, false, this.field946);
         }

         return var11;
      }
   }

   @ObfuscatedName("j")
   public boolean method832() {
      if(this.field943 == null) {
         return -1 != this.field963 || this.field974 != null;
      } else {
         for(int var1 = 0; var1 < this.field943.length; ++var1) {
            if(-1 != this.field943[var1]) {
               class40 var2 = class22.method592(this.field943[var1]);
               if(var2.field963 != -1 || null != var2.field974) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("z")
   public final class40 method842() {
      int var1 = -1;
      if(-1 != this.field932) {
         var1 = class152.method3179(this.field932);
      } else if(this.field969 != -1) {
         var1 = class176.field2916[this.field969];
      }

      return var1 >= 0 && var1 < this.field943.length && -1 != this.field943[var1]?class22.method592(this.field943[var1]):null;
   }

   @ObfuscatedName("z")
   public static String method852(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }

   @ObfuscatedName("w")
   public static void method858(class113 var0) {
      class222.field3185 = var0;
   }

   @ObfuscatedName("d")
   public static void method864(boolean var0) {
      if(class51.field1115 != var0) {
         class51.field1117.method3776();
         class51.field1118.method3776();
         class51.field1119.method3776();
         class51.field1115 = var0;
      }

   }

   @ObfuscatedName("c")
   public final class105 method870(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(null == this.field935) {
         var7 = (long)((this.field936 << 10) + var2);
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.field936 << 10));
      }

      class105 var9 = (class105)field939.method3771(var7);
      if(var9 == null) {
         class100 var10 = this.method874(var1, var2);
         if(null == var10) {
            return null;
         }

         var9 = var10.method2212(64 + this.field951, 768 + this.field952, -50, -10, -50);
         field939.method3773(var9, var7);
      }

      if(this.field946 >= 0) {
         var9 = var9.method2300(var3, var4, var5, var6, true, this.field946);
      }

      return var9;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass80;B)V",
      garbageValue = "25"
   )
   static final void method871(class80 var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class4.field87.length; ++var2) {
         class4.field87[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class4.field87[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class31.field737[var5] = (class4.field87[128 + var5] + class4.field87[var5 - 128] + class4.field87[1 + var5] + class4.field87[var5 - 1]) / 4;
            }
         }

         int[] var8 = class4.field87;
         class4.field87 = class31.field737;
         class31.field737 = var8;
      }

      if(null != var0) {
         var2 = 0;

         for(var3 = 0; var3 < var0.field1423; ++var3) {
            for(var4 = 0; var4 < var0.field1425; ++var4) {
               if(var0.field1427[var2++] != 0) {
                  var5 = 16 + var4 + var0.field1424;
                  int var6 = 16 + var3 + var0.field1420;
                  int var7 = var5 + (var6 << 7);
                  class4.field87[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Lclass37;II)V",
      garbageValue = "-1130487120"
   )
   static final void method873(class37 var0) {
      int var1;
      int var2;
      int var3;
      class42 var10;
      if(var0.field863 > client.field305) {
         var1 = var0.field863 - client.field305;
         var2 = var0.field822 * 64 + var0.field859 * 128;
         var3 = var0.field822 * 64 + var0.field830 * 128;
         var0.field849 += (var2 - var0.field849) / var1;
         var0.field819 += (var3 - var0.field819) / var1;
         var0.field845 = 0;
         var0.field847 = var0.field836;
      } else {
         int var4;
         int var6;
         if(var0.field855 >= client.field305) {
            if(var0.field855 == client.field305 || var0.field821 == -1 || 0 != var0.field852 || 1 + var0.field861 > class96.method2187(var0.field821).field997[var0.field850]) {
               var1 = var0.field855 - var0.field863;
               var2 = client.field305 - var0.field863;
               var3 = var0.field822 * 64 + var0.field859 * 128;
               var4 = var0.field830 * 128 + var0.field822 * 64;
               int var5 = var0.field822 * 64 + var0.field860 * 128;
               var6 = var0.field862 * 128 + var0.field822 * 64;
               var0.field849 = (var2 * var5 + (var1 - var2) * var3) / var1;
               var0.field819 = (var2 * var6 + (var1 - var2) * var4) / var1;
            }

            var0.field845 = 0;
            var0.field847 = var0.field836;
            var0.field820 = var0.field847;
         } else {
            var0.field846 = var0.field823;
            if(0 == var0.field818) {
               var0.field845 = 0;
            } else {
               label476: {
                  if(var0.field821 != -1 && var0.field852 == 0) {
                     var10 = class96.method2187(var0.field821);
                     if(var0.field875 > 0 && 0 == var10.field1011) {
                        ++var0.field845;
                        break label476;
                     }

                     if(var0.field875 <= 0 && 0 == var10.field1004) {
                        ++var0.field845;
                        break label476;
                     }
                  }

                  var1 = var0.field849;
                  var2 = var0.field819;
                  var3 = var0.field822 * 64 + 128 * var0.field872[var0.field818 - 1];
                  var4 = var0.field822 * 64 + var0.field873[var0.field818 - 1] * 128;
                  if(var1 < var3) {
                     if(var2 < var4) {
                        var0.field847 = 1280;
                     } else if(var2 > var4) {
                        var0.field847 = 1792;
                     } else {
                        var0.field847 = 1536;
                     }
                  } else if(var1 > var3) {
                     if(var2 < var4) {
                        var0.field847 = 768;
                     } else if(var2 > var4) {
                        var0.field847 = 256;
                     } else {
                        var0.field847 = 512;
                     }
                  } else if(var2 < var4) {
                     var0.field847 = 1024;
                  } else if(var2 > var4) {
                     var0.field847 = 0;
                  }

                  byte var12 = var0.field874[var0.field818 - 1];
                  if(var3 - var1 <= 256 && var3 - var1 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
                     var6 = var0.field847 - var0.field820 & 2047;
                     if(var6 > 1024) {
                        var6 -= 2048;
                     }

                     int var7 = var0.field827;
                     if(var6 >= -256 && var6 <= 256) {
                        var7 = var0.field826;
                     } else if(var6 >= 256 && var6 < 768) {
                        var7 = var0.field829;
                     } else if(var6 >= -768 && var6 <= -256) {
                        var7 = var0.field828;
                     }

                     if(var7 == -1) {
                        var7 = var0.field826;
                     }

                     var0.field846 = var7;
                     int var8 = 4;
                     boolean var9 = true;
                     if(var0 instanceof class34) {
                        var9 = ((class34)var0).field781.field919;
                     }

                     if(var9) {
                        if(var0.field847 != var0.field820 && -1 == var0.field851 && 0 != var0.field842) {
                           var8 = 2;
                        }

                        if(var0.field818 > 2) {
                           var8 = 6;
                        }

                        if(var0.field818 > 3) {
                           var8 = 8;
                        }

                        if(var0.field845 > 0 && var0.field818 > 1) {
                           var8 = 8;
                           --var0.field845;
                        }
                     } else {
                        if(var0.field818 > 1) {
                           var8 = 6;
                        }

                        if(var0.field818 > 2) {
                           var8 = 8;
                        }

                        if(var0.field845 > 0 && var0.field818 > 1) {
                           var8 = 8;
                           --var0.field845;
                        }
                     }

                     if(var12 == 2) {
                        var8 <<= 1;
                     }

                     if(var8 >= 8 && var0.field826 == var0.field846 && var0.field868 != -1) {
                        var0.field846 = var0.field868;
                     }

                     if(var3 != var1 || var4 != var2) {
                        if(var1 < var3) {
                           var0.field849 += var8;
                           if(var0.field849 > var3) {
                              var0.field849 = var3;
                           }
                        } else if(var1 > var3) {
                           var0.field849 -= var8;
                           if(var0.field849 < var3) {
                              var0.field849 = var3;
                           }
                        }

                        if(var2 < var4) {
                           var0.field819 += var8;
                           if(var0.field819 > var4) {
                              var0.field819 = var4;
                           }
                        } else if(var2 > var4) {
                           var0.field819 -= var8;
                           if(var0.field819 < var4) {
                              var0.field819 = var4;
                           }
                        }
                     }

                     if(var3 == var0.field849 && var4 == var0.field819) {
                        --var0.field818;
                        if(var0.field875 > 0) {
                           --var0.field875;
                        }
                     }
                  } else {
                     var0.field849 = var3;
                     var0.field819 = var4;
                     --var0.field818;
                     if(var0.field875 > 0) {
                        --var0.field875;
                     }
                  }
               }
            }
         }
      }

      if(var0.field849 < 128 || var0.field819 < 128 || var0.field849 >= 13184 || var0.field819 >= 13184) {
         var0.field821 = -1;
         var0.field854 = -1;
         var0.field863 = 0;
         var0.field855 = 0;
         var0.field849 = var0.field872[0] * 128 + var0.field822 * 64;
         var0.field819 = var0.field873[0] * 128 + var0.field822 * 64;
         var0.method768();
      }

      if(class167.field2692 == var0 && (var0.field849 < 1536 || var0.field819 < 1536 || var0.field849 >= 11776 || var0.field819 >= 11776)) {
         var0.field821 = -1;
         var0.field854 = -1;
         var0.field863 = 0;
         var0.field855 = 0;
         var0.field849 = 128 * var0.field872[0] + var0.field822 * 64;
         var0.field819 = var0.field873[0] * 128 + var0.field822 * 64;
         var0.method768();
      }

      class153.method3181(var0);
      var0.field870 = false;
      if(-1 != var0.field846) {
         var10 = class96.method2187(var0.field846);
         if(null != var10 && null != var10.field995) {
            ++var0.field843;
            if(var0.field837 < var10.field995.length && var0.field843 > var10.field997[var0.field837]) {
               var0.field843 = 1;
               ++var0.field837;
               class10.method133(var10, var0.field837, var0.field849, var0.field819);
            }

            if(var0.field837 >= var10.field995.length) {
               var0.field843 = 0;
               var0.field837 = 0;
               class10.method133(var10, var0.field837, var0.field849, var0.field819);
            }
         } else {
            var0.field846 = -1;
         }
      }

      if(-1 != var0.field854 && client.field305 >= var0.field857) {
         if(var0.field869 < 0) {
            var0.field869 = 0;
         }

         var1 = class29.method669(var0.field854).field1018;
         if(-1 != var1) {
            class42 var11 = class96.method2187(var1);
            if(null != var11 && null != var11.field995) {
               ++var0.field856;
               if(var0.field869 < var11.field995.length && var0.field856 > var11.field997[var0.field869]) {
                  var0.field856 = 1;
                  ++var0.field869;
                  class10.method133(var11, var0.field869, var0.field849, var0.field819);
               }

               if(var0.field869 >= var11.field995.length && (var0.field869 < 0 || var0.field869 >= var11.field995.length)) {
                  var0.field854 = -1;
               }
            } else {
               var0.field854 = -1;
            }
         } else {
            var0.field854 = -1;
         }
      }

      if(var0.field821 != -1 && var0.field852 <= 1) {
         var10 = class96.method2187(var0.field821);
         if(1 == var10.field1011 && var0.field875 > 0 && var0.field863 <= client.field305 && var0.field855 < client.field305) {
            var0.field852 = 1;
            return;
         }
      }

      if(var0.field821 != -1 && 0 == var0.field852) {
         var10 = class96.method2187(var0.field821);
         if(var10 != null && null != var10.field995) {
            ++var0.field861;
            if(var0.field850 < var10.field995.length && var0.field861 > var10.field997[var0.field850]) {
               var0.field861 = 1;
               ++var0.field850;
               class10.method133(var10, var0.field850, var0.field849, var0.field819);
            }

            if(var0.field850 >= var10.field995.length) {
               var0.field850 -= var10.field999;
               ++var0.field853;
               if(var0.field853 >= var10.field1005) {
                  var0.field821 = -1;
               } else if(var0.field850 >= 0 && var0.field850 < var10.field995.length) {
                  class10.method133(var10, var0.field850, var0.field849, var0.field819);
               } else {
                  var0.field821 = -1;
               }
            }

            var0.field870 = var10.field1001;
         } else {
            var0.field821 = -1;
         }
      }

      if(var0.field852 > 0) {
         --var0.field852;
      }

   }

   @ObfuscatedName("l")
   final class100 method874(int var1, int var2) {
      class100 var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(null == this.field935) {
         if(var1 != 10) {
            return null;
         }

         if(null == this.field934) {
            return null;
         }

         var4 = this.field933;
         if(var1 == 2 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.field934.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            var7 = this.field934[var6];
            if(var4) {
               var7 += 65536;
            }

            var3 = (class100)field929.method3771((long)var7);
            if(var3 == null) {
               var3 = class100.method2214(field927, var7 & '\uffff', 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2206();
               }

               field929.method3773(var3, (long)var7);
            }

            if(var5 > 1) {
               field948[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new class100(field948, var5);
         }
      } else {
         int var8 = -1;

         for(var5 = 0; var5 < this.field935.length; ++var5) {
            if(this.field935[var5] == var1) {
               var8 = var5;
               break;
            }
         }

         if(-1 == var8) {
            return null;
         }

         var5 = this.field934[var8];
         boolean var9 = this.field933 ^ var2 > 3;
         if(var9) {
            var5 += 65536;
         }

         var3 = (class100)field929.method3771((long)var5);
         if(null == var3) {
            var3 = class100.method2214(field927, var5 & '\uffff', 0);
            if(var3 == null) {
               return null;
            }

            if(var9) {
               var3.method2206();
            }

            field929.method3773(var3, (long)var5);
         }
      }

      if(this.field958 == 128 && 128 == this.field959 && 128 == this.field945) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var10;
      if(this.field961 == 0 && this.field962 == 0 && this.field956 == 0) {
         var10 = false;
      } else {
         var10 = true;
      }

      class100 var11 = new class100(var3, var2 == 0 && !var4 && !var10, this.field937 == null, this.field973 == null, true);
      if(var1 == 4 && var2 > 3) {
         var11.method2202(256);
         var11.method2203(45, 0, -45);
      }

      var2 &= 3;
      if(1 == var2) {
         var11.method2194();
      } else if(var2 == 2) {
         var11.method2200();
      } else if(3 == var2) {
         var11.method2201();
      }

      if(null != this.field937) {
         for(var7 = 0; var7 < this.field937.length; ++var7) {
            var11.method2238(this.field937[var7], this.field967[var7]);
         }
      }

      if(null != this.field973) {
         for(var7 = 0; var7 < this.field973.length; ++var7) {
            var11.method2205(this.field973[var7], this.field940[var7]);
         }
      }

      if(var4) {
         var11.method2207(this.field958, this.field959, this.field945);
      }

      if(var10) {
         var11.method2203(this.field961, this.field962, this.field956);
      }

      return var11;
   }
}

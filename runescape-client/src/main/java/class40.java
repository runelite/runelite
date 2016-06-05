import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
@Implements("ObjectComposition")
public class class40 extends class204 {
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -205297363
   )
   int field914 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2067789225
   )
   int field915 = -1;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1741229131
   )
   int field916 = 0;
   @ObfuscatedName("z")
   public static class193 field917 = new class193(500);
   @ObfuscatedName("r")
   public static class193 field918 = new class193(30);
   @ObfuscatedName("f")
   public static class193 field919 = new class193(30);
   @ObfuscatedName("s")
   static class100[] field920 = new class100[4];
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 192121487
   )
   public int field921;
   @ObfuscatedName("l")
   int[] field922;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 682906339
   )
   public int field923 = 1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1029028309
   )
   public int field924 = -1;
   @ObfuscatedName("k")
   short[] field925;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1516250323
   )
   int field926 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 999799073
   )
   public int field927 = -1;
   @ObfuscatedName("j")
   short[] field928;
   @ObfuscatedName("o")
   short[] field929;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1461591053
   )
   int field930 = 128;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -619005041
   )
   public int field931 = 2;
   @ObfuscatedName("h")
   public static class193 field932 = new class193(64);
   @ObfuscatedName("t")
   static boolean field933 = false;
   @ObfuscatedName("g")
   static class167 field934;
   @ObfuscatedName("v")
   boolean field935 = false;
   @ObfuscatedName("m")
   public boolean field936 = false;
   @ObfuscatedName("n")
   public boolean field937 = true;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1835887115
   )
   public int field938 = 16;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 34206025
   )
   public int field939 = -1;
   @ObfuscatedName("y")
   int[] field940;
   @ObfuscatedName("ag")
   @Export("actions")
   public String[] field941 = new String[5];
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1467430465
   )
   public int field942 = -1;
   @ObfuscatedName("b")
   short[] field943;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 469099363
   )
   public int field944 = -1;
   @ObfuscatedName("ay")
   public boolean field945 = true;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 853373497
   )
   int field947 = 128;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 384123591
   )
   int field948 = 128;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1962455931
   )
   int field949 = 0;
   @ObfuscatedName("ar")
   boolean field950 = false;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 2134803421
   )
   int field951 = 0;
   @ObfuscatedName("ac")
   public boolean field952 = false;
   @ObfuscatedName("ao")
   boolean field953 = false;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1464724975
   )
   public int field954 = 1;
   @ObfuscatedName("ah")
   @Export("impostorIds")
   public int[] field955;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1618559903
   )
   int field956 = -1;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1703466941
   )
   int field957 = -1;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1178284755
   )
   public int field958 = -1;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 531046865
   )
   public int field959 = 0;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1657393113
   )
   public int field960 = 0;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1904218201
   )
   public int field961 = 0;
   @ObfuscatedName("az")
   public int[] field962;
   @ObfuscatedName("p")
   @Export("name")
   public String field963 = "null";
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      intValue = 1012343145
   )
   static int field964;
   @ObfuscatedName("ha")
   @ObfuscatedGetter(
      intValue = -70197513
   )
   @Export("menuX")
   static int field965;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II[[IIIIB)Lclass85;",
      garbageValue = "-69"
   )
   public final class85 method788(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(null == this.field940) {
         var7 = (long)(var2 + (this.field921 << 10));
      } else {
         var7 = (long)((this.field921 << 10) + (var1 << 3) + var2);
      }

      Object var9 = (class85)field918.method3716(var7);
      if(var9 == null) {
         class100 var10 = this.method804(var1, var2);
         if(null == var10) {
            return null;
         }

         if(!this.field935) {
            var9 = var10.method2181(64 + this.field926, 768 + this.field914, -50, -10, -50);
         } else {
            var10.field1724 = (short)(this.field926 + 64);
            var10.field1719 = (short)(this.field914 + 768);
            var10.method2178();
            var9 = var10;
         }

         field918.method3724((class204)var9, var7);
      }

      if(this.field935) {
         var9 = ((class100)var9).method2166();
      }

      if(this.field915 >= 0) {
         if(var9 instanceof class105) {
            var9 = ((class105)var9).method2254(var3, var4, var5, var6, true, this.field915);
         } else if(var9 instanceof class100) {
            var9 = ((class100)var9).method2161(var3, var4, var5, var6, true, this.field915);
         }
      }

      return (class85)var9;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "4"
   )
   void method789() {
      if(this.field924 == -1) {
         this.field924 = 0;
         if(null != this.field922 && (this.field940 == null || this.field940[0] == 10)) {
            this.field924 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.field941[var1] != null) {
               this.field924 = 1;
            }
         }
      }

      if(this.field944 == -1) {
         this.field944 = this.field931 != 0?1:0;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "8"
   )
   void method790(class119 var1) {
      while(true) {
         int var2 = var1.method2494();
         if(var2 == 0) {
            return;
         }

         this.method797(var1, var2);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "976375412"
   )
   public boolean method791() {
      if(this.field955 == null) {
         return this.field958 != -1 || this.field962 != null;
      } else {
         for(int var1 = 0; var1 < this.field955.length; ++var1) {
            if(this.field955[var1] != -1) {
               class40 var2 = class49.method980(this.field955[var1]);
               if(var2.field958 != -1 || null != var2.field962) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-707955367"
   )
   public final boolean method792(int var1) {
      if(this.field940 != null) {
         for(int var4 = 0; var4 < this.field940.length; ++var4) {
            if(this.field940[var4] == var1) {
               return field934.method3259(this.field922[var4] & '\uffff', 0);
            }
         }

         return true;
      } else if(this.field922 == null) {
         return true;
      } else if(var1 != 10) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.field922.length; ++var3) {
            var2 &= field934.method3259(this.field922[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1441158054"
   )
   public final boolean method793() {
      if(null == this.field922) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field922.length; ++var2) {
            var1 &= field934.method3259(this.field922[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)Lclass105;",
      garbageValue = "1719202848"
   )
   public final class105 method795(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.field940 == null) {
         var7 = (long)(var2 + (this.field921 << 10));
      } else {
         var7 = (long)(var2 + (this.field921 << 10) + (var1 << 3));
      }

      class105 var9 = (class105)field919.method3716(var7);
      if(null == var9) {
         class100 var10 = this.method804(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.method2181(this.field926 + 64, 768 + this.field914, -50, -10, -50);
         field919.method3724(var9, var7);
      }

      if(this.field915 >= 0) {
         var9 = var9.method2254(var3, var4, var5, var6, true, this.field915);
      }

      return var9;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II[[IIIILclass42;II)Lclass105;",
      garbageValue = "1169801535"
   )
   public final class105 method796(int var1, int var2, int[][] var3, int var4, int var5, int var6, class42 var7, int var8) {
      long var9;
      if(this.field940 == null) {
         var9 = (long)((this.field921 << 10) + var2);
      } else {
         var9 = (long)((this.field921 << 10) + (var1 << 3) + var2);
      }

      class105 var11 = (class105)field919.method3716(var9);
      if(null == var11) {
         class100 var12 = this.method804(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.method2181(this.field926 + 64, this.field914 + 768, -50, -10, -50);
         field919.method3724(var11, var9);
      }

      if(var7 == null && this.field915 == -1) {
         return var11;
      } else {
         if(null != var7) {
            var11 = var7.method859(var11, var8, var2);
         } else {
            var11 = var11.method2255(true);
         }

         if(this.field915 >= 0) {
            var11 = var11.method2254(var3, var4, var5, var6, false, this.field915);
         }

         return var11;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-258044234"
   )
   void method797(class119 var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2494();
         if(var3 > 0) {
            if(null != this.field922 && !field933) {
               var1.field2000 += 3 * var3;
            } else {
               this.field940 = new int[var3];
               this.field922 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field922[var4] = var1.method2470();
                  this.field940[var4] = var1.method2494();
               }
            }
         }
      } else if(var2 == 2) {
         this.field963 = var1.method2476();
      } else if(var2 == 5) {
         var3 = var1.method2494();
         if(var3 > 0) {
            if(null != this.field922 && !field933) {
               var1.field2000 += var3 * 2;
            } else {
               this.field940 = null;
               this.field922 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field922[var4] = var1.method2470();
               }
            }
         }
      } else if(var2 == 14) {
         this.field954 = var1.method2494();
      } else if(var2 == 15) {
         this.field923 = var1.method2494();
      } else if(var2 == 17) {
         this.field931 = 0;
         this.field937 = false;
      } else if(var2 == 18) {
         this.field937 = false;
      } else if(var2 == 19) {
         this.field924 = var1.method2494();
      } else if(var2 == 21) {
         this.field915 = 0;
      } else if(var2 == 22) {
         this.field935 = true;
      } else if(var2 == 23) {
         this.field936 = true;
      } else if(var2 == 24) {
         this.field927 = var1.method2470();
         if(this.field927 == '\uffff') {
            this.field927 = -1;
         }
      } else if(var2 == 27) {
         this.field931 = 1;
      } else if(var2 == 28) {
         this.field938 = var1.method2494();
      } else if(var2 == 29) {
         this.field926 = var1.method2469();
      } else if(var2 == 39) {
         this.field914 = var1.method2469() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.field941[var2 - 30] = var1.method2476();
         if(this.field941[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.field941[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2494();
         this.field925 = new short[var3];
         this.field929 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field925[var4] = (short)var1.method2470();
            this.field929[var4] = (short)var1.method2470();
         }
      } else if(var2 == 41) {
         var3 = var1.method2494();
         this.field943 = new short[var3];
         this.field928 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field943[var4] = (short)var1.method2470();
            this.field928[var4] = (short)var1.method2470();
         }
      } else if(var2 == 60) {
         this.field942 = var1.method2470();
      } else if(var2 == 62) {
         this.field950 = true;
      } else if(var2 == 64) {
         this.field945 = false;
      } else if(var2 == 65) {
         this.field930 = var1.method2470();
      } else if(var2 == 66) {
         this.field947 = var1.method2470();
      } else if(var2 == 67) {
         this.field948 = var1.method2470();
      } else if(var2 == 68) {
         this.field939 = var1.method2470();
      } else if(var2 == 69) {
         var1.method2494();
      } else if(var2 == 70) {
         this.field949 = var1.method2638();
      } else if(var2 == 71) {
         this.field916 = var1.method2638();
      } else if(var2 == 72) {
         this.field951 = var1.method2638();
      } else if(var2 == 73) {
         this.field952 = true;
      } else if(var2 == 74) {
         this.field953 = true;
      } else if(var2 == 75) {
         this.field944 = var1.method2494();
      } else if(var2 == 77) {
         this.field956 = var1.method2470();
         if(this.field956 == '\uffff') {
            this.field956 = -1;
         }

         this.field957 = var1.method2470();
         if(this.field957 == '\uffff') {
            this.field957 = -1;
         }

         var3 = var1.method2494();
         this.field955 = new int[var3 + 1];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field955[var4] = var1.method2470();
            if(this.field955[var4] == '\uffff') {
               this.field955[var4] = -1;
            }
         }
      } else if(var2 == 78) {
         this.field958 = var1.method2470();
         this.field959 = var1.method2494();
      } else if(var2 == 79) {
         this.field960 = var1.method2470();
         this.field961 = var1.method2470();
         this.field959 = var1.method2494();
         var3 = var1.method2494();
         this.field962 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field962[var4] = var1.method2470();
         }
      } else if(var2 == 81) {
         this.field915 = var1.method2494() * 256;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Lclass40;",
      garbageValue = "-321458374"
   )
   @Export("getImpostor")
   public final class40 method798() {
      int var1 = -1;
      if(this.field956 != -1) {
         var1 = class13.method144(this.field956);
      } else if(this.field957 != -1) {
         var1 = class176.field2923[this.field957];
      }

      return var1 >= 0 && var1 < this.field955.length && this.field955[var1] != -1?class49.method980(this.field955[var1]):null;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIB)Lclass100;",
      garbageValue = "-1"
   )
   final class100 method804(int var1, int var2) {
      class100 var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(null == this.field940) {
         if(var1 != 10) {
            return null;
         }

         if(null == this.field922) {
            return null;
         }

         var4 = this.field950;
         if(var1 == 2 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.field922.length;

         for(int var8 = 0; var8 < var5; ++var8) {
            var7 = this.field922[var8];
            if(var4) {
               var7 += 65536;
            }

            var3 = (class100)field917.method3716((long)var7);
            if(null == var3) {
               var3 = class100.method2172(field934, var7 & '\uffff', 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2176();
               }

               field917.method3724(var3, (long)var7);
            }

            if(var5 > 1) {
               field920[var8] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new class100(field920, var5);
         }
      } else {
         int var9 = -1;

         for(var5 = 0; var5 < this.field940.length; ++var5) {
            if(this.field940[var5] == var1) {
               var9 = var5;
               break;
            }
         }

         if(var9 == -1) {
            return null;
         }

         var5 = this.field922[var9];
         boolean var11 = this.field950 ^ var2 > 3;
         if(var11) {
            var5 += 65536;
         }

         var3 = (class100)field917.method3716((long)var5);
         if(null == var3) {
            var3 = class100.method2172(field934, var5 & '\uffff', 0);
            if(null == var3) {
               return null;
            }

            if(var11) {
               var3.method2176();
            }

            field917.method3724(var3, (long)var5);
         }
      }

      if(this.field930 == 128 && this.field947 == 128 && this.field948 == 128) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var10;
      if(this.field949 == 0 && this.field916 == 0 && this.field951 == 0) {
         var10 = false;
      } else {
         var10 = true;
      }

      class100 var6 = new class100(var3, var2 == 0 && !var4 && !var10, this.field925 == null, this.field943 == null, true);
      if(var1 == 4 && var2 > 3) {
         var6.method2167(256);
         var6.method2173(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var6.method2196();
      } else if(var2 == 2) {
         var6.method2170();
      } else if(var2 == 3) {
         var6.method2171();
      }

      if(null != this.field925) {
         for(var7 = 0; var7 < this.field925.length; ++var7) {
            var6.method2201(this.field925[var7], this.field929[var7]);
         }
      }

      if(null != this.field943) {
         for(var7 = 0; var7 < this.field943.length; ++var7) {
            var6.method2189(this.field943[var7], this.field928[var7]);
         }
      }

      if(var4) {
         var6.method2177(this.field930, this.field947, this.field948);
      }

      if(var10) {
         var6.method2173(this.field949, this.field916, this.field951);
      }

      return var6;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass167;B)V",
      garbageValue = "101"
   )
   public static void method821(class167 var0) {
      class46.field1053 = var0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "256"
   )
   static void method827(int var0) {
      if(var0 == -1 && !client.field521) {
         class172.method3364();
      } else if(var0 != -1 && client.field520 != var0 && client.field519 != 0 && !client.field521) {
         class157.method3140(2, class103.field1783, var0, 0, client.field519, false);
      }

      client.field520 = var0;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "613632923"
   )
   static final void method828(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class214.field3161.method1990(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = class214.field3161.method1994(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class101.field1767.field1409;
         var11 = (103 - var2) * 2048 + 4 * var1 + 24624;
         var12 = var5 >> 14 & 32767;
         class40 var13 = class49.method980(var12);
         if(var13.field939 != -1) {
            class80 var14 = class35.field781[var13.field939];
            if(null != var14) {
               int var15 = (var13.field954 * 4 - var14.field1424) / 2;
               int var16 = (var13.field923 * 4 - var14.field1425) / 2;
               var14.method1822(var15 + 4 * var1 + 48, var16 + 48 + (104 - var2 - var13.field923) * 4);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[512 + var11] = var9;
                  var10[var11 + 1024] = var9;
                  var10[1536 + var11] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[1 + var11] = var9;
                  var10[2 + var11] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[3 + var11 + 512] = var9;
                  var10[1024 + 3 + var11] = var9;
                  var10[1536 + var11 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[1536 + var11 + 1] = var9;
                  var10[2 + 1536 + var11] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[1536 + 3 + var11] = var9;
               } else if(var7 == 3) {
                  var10[1536 + var11] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[512 + var11] = var9;
                  var10[1024 + var11] = var9;
                  var10[1536 + var11] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[512 + 3 + var11] = var9;
                  var10[1024 + var11 + 3] = var9;
                  var10[var11 + 3 + 1536] = var9;
               } else if(var7 == 2) {
                  var10[1536 + var11] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = class214.field3161.method1914(var0, var1, var2);
      if(var5 != 0) {
         var6 = class214.field3161.method1994(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         class40 var23 = class49.method980(var9);
         int var21;
         if(var23.field939 != -1) {
            class80 var22 = class35.field781[var23.field939];
            if(var22 != null) {
               var12 = (var23.field954 * 4 - var22.field1424) / 2;
               var21 = (var23.field923 * 4 - var22.field1425) / 2;
               var22.method1822(var12 + var1 * 4 + 48, var21 + (104 - var2 - var23.field923) * 4 + 48);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var20 = class101.field1767.field1409;
            var21 = var1 * 4 + 24624 + (103 - var2) * 2048;
            if(var7 != 0 && var7 != 2) {
               var20[var21] = var11;
               var20[1 + var21 + 512] = var11;
               var20[1024 + var21 + 2] = var11;
               var20[1536 + var21 + 3] = var11;
            } else {
               var20[var21 + 1536] = var11;
               var20[1 + var21 + 1024] = var11;
               var20[512 + var21 + 2] = var11;
               var20[3 + var21] = var11;
            }
         }
      }

      var5 = class214.field3161.method1899(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         class40 var17 = class49.method980(var6);
         if(var17.field939 != -1) {
            class80 var18 = class35.field781[var17.field939];
            if(var18 != null) {
               var9 = (var17.field954 * 4 - var18.field1424) / 2;
               int var19 = (var17.field923 * 4 - var18.field1425) / 2;
               var18.method1822(var9 + var1 * 4 + 48, var19 + 4 * (104 - var2 - var17.field923) + 48);
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "252312937"
   )
   public static int method829(String var0) {
      return var0.length() + 2;
   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ao")
@Implements("NPCComposition")
public class class39 extends class203 {
   @ObfuscatedName("a")
   static class192 field879 = new class192(64);
   @ObfuscatedName("l")
   static class166 field880;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 962757685
   )
   int field881 = 128;
   @ObfuscatedName("i")
   static class192 field882 = new class192(50);
   @ObfuscatedName("ai")
   public boolean field883 = true;
   @ObfuscatedName("m")
   @Export("name")
   public String field884 = "null";
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1684876277
   )
   public int field885 = 1;
   @ObfuscatedName("h")
   @Export("models")
   int[] field886;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -253815059
   )
   public int field887 = 1;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1476239615
   )
   public int field888 = 1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1598103315
   )
   public int field889 = 1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -602945683
   )
   public int field890 = 1;
   @ObfuscatedName("ar")
   @Export("isClickable")
   public boolean field891 = true;
   @ObfuscatedName("d")
   short[] field892;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1084271773
   )
   public int field893 = 1;
   @ObfuscatedName("n")
   int[] field894;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1163309685
   )
   int field895 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -843801049
   )
   @Export("id")
   public int field896;
   @ObfuscatedName("z")
   short[] field897;
   @ObfuscatedName("p")
   short[] field898;
   @ObfuscatedName("w")
   @Export("actions")
   public String[] field899 = new String[5];
   @ObfuscatedName("t")
   @Export("isMinimapVisible")
   public boolean field900 = true;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2120085835
   )
   @Export("combatLevel")
   public int field901 = -1;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1514545987
   )
   int field902 = 128;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1549685613
   )
   public int field903 = -1;
   @ObfuscatedName("v")
   @Export("isVisible")
   public boolean field904 = false;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 700136605
   )
   int field905 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -679220149
   )
   public int field906 = 1;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -521800885
   )
   public int field907 = 1;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 2037142499
   )
   public int field908 = 32;
   @ObfuscatedName("az")
   public int[] field909;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 406806725
   )
   int field910 = -1;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -185846183
   )
   int field911 = -1;
   @ObfuscatedName("s")
   short[] field912;
   @ObfuscatedName("j")
   static class166 field913;
   @ObfuscatedName("aa")
   public boolean field914 = false;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1808843869
   )
   public int field915 = 30;

   @ObfuscatedName("a")
   void method766() {
   }

   @ObfuscatedName("m")
   public final class104 method769(class42 var1, int var2, class42 var3, int var4) {
      if(null != this.field909) {
         class39 var11 = this.method789();
         return var11 == null?null:var11.method769(var1, var2, var3, var4);
      } else {
         class104 var5 = (class104)field882.method3711((long)this.field896);
         if(null == var5) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.field886.length; ++var7) {
               if(!field880.method3216(this.field886[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            class99[] var8 = new class99[this.field886.length];

            int var9;
            for(var9 = 0; var9 < this.field886.length; ++var9) {
               var8[var9] = class99.method2237(field880, this.field886[var9], 0);
            }

            class99 var12;
            if(1 == var8.length) {
               var12 = var8[0];
            } else {
               var12 = new class99(var8, var8.length);
            }

            if(null != this.field912) {
               for(var9 = 0; var9 < this.field912.length; ++var9) {
                  var12.method2189(this.field912[var9], this.field892[var9]);
               }
            }

            if(null != this.field897) {
               for(var9 = 0; var9 < this.field897.length; ++var9) {
                  var12.method2183(this.field897[var9], this.field898[var9]);
               }
            }

            var5 = var12.method2169(this.field895 + 64, this.field905 + 850, -30, -50, -30);
            field882.method3713(var5, (long)this.field896);
         }

         class104 var10;
         if(null != var1 && var3 != null) {
            var10 = var1.method870(var5, var2, var3, var4);
         } else if(null != var1) {
            var10 = var1.method866(var5, var2);
         } else if(null != var3) {
            var10 = var3.method866(var5, var4);
         } else {
            var10 = var5.method2313(true);
         }

         if(128 != this.field902 || this.field881 != 128) {
            var10.method2310(this.field902, this.field881, this.field902);
         }

         return var10;
      }
   }

   @ObfuscatedName("o")
   public final class99 method770() {
      if(this.field909 != null) {
         class39 var5 = this.method789();
         return null == var5?null:var5.method770();
      } else if(this.field894 == null) {
         return null;
      } else {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.field894.length; ++var2) {
            if(!field880.method3216(this.field894[var2], 0)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            class99[] var6 = new class99[this.field894.length];

            for(int var3 = 0; var3 < this.field894.length; ++var3) {
               var6[var3] = class99.method2237(field880, this.field894[var3], 0);
            }

            class99 var7;
            if(1 == var6.length) {
               var7 = var6[0];
            } else {
               var7 = new class99(var6, var6.length);
            }

            int var4;
            if(null != this.field912) {
               for(var4 = 0; var4 < this.field912.length; ++var4) {
                  var7.method2189(this.field912[var4], this.field892[var4]);
               }
            }

            if(null != this.field897) {
               for(var4 = 0; var4 < this.field897.length; ++var4) {
                  var7.method2183(this.field897[var4], this.field898[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("n")
   public boolean method772() {
      if(null == this.field909) {
         return true;
      } else {
         int var1 = -1;
         if(-1 != this.field910) {
            var1 = class109.method2380(this.field910);
         } else if(-1 != this.field911) {
            var1 = class175.field2906[this.field911];
         }

         return var1 >= 0 && var1 < this.field909.length && this.field909[var1] != -1;
      }
   }

   @ObfuscatedName("i")
   void method774(class118 var1) {
      while(true) {
         int var2 = var1.method2453();
         if(0 == var2) {
            return;
         }

         this.method795(var1, var2);
      }
   }

   @ObfuscatedName("h")
   public final class39 method789() {
      int var1 = -1;
      if(this.field910 != -1) {
         var1 = class109.method2380(this.field910);
      } else if(-1 != this.field911) {
         var1 = class175.field2906[this.field911];
      }

      return var1 >= 0 && var1 < this.field909.length && this.field909[var1] != -1?class14.method162(this.field909[var1]):null;
   }

   @ObfuscatedName("f")
   void method795(class118 var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2453();
         this.field886 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field886[var4] = var1.method2455();
         }
      } else if(var2 == 2) {
         this.field884 = var1.method2461();
      } else if(var2 == 12) {
         this.field885 = var1.method2453();
      } else if(var2 == 13) {
         this.field888 = var1.method2455() * -1;
      } else if(14 == var2) {
         this.field906 = var1.method2455() * -1;
      } else if(var2 == 15) {
         this.field889 = var1.method2455() * -1;
      } else if(16 == var2) {
         this.field890 = var1.method2455() * -1;
      } else if(17 == var2) {
         this.field906 = var1.method2455() * -1;
         this.field887 = var1.method2455() * -1;
         this.field893 = var1.method2455() * -1;
         this.field907 = var1.method2455() * -1;
      } else if(var2 >= 30 && var2 < 35) {
         this.field899[var2 - 30] = var1.method2461();
         if(this.field899[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.field899[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2453();
         this.field912 = new short[var3];
         this.field892 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field912[var4] = (short)var1.method2455();
            this.field892[var4] = (short)var1.method2455();
         }
      } else if(var2 == 41) {
         var3 = var1.method2453();
         this.field897 = new short[var3];
         this.field898 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field897[var4] = (short)var1.method2455();
            this.field898[var4] = (short)var1.method2455();
         }
      } else if(var2 == 60) {
         var3 = var1.method2453();
         this.field894 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field894[var4] = var1.method2455();
         }
      } else if(93 == var2) {
         this.field900 = false;
      } else if(95 == var2) {
         this.field901 = var1.method2455();
      } else if(var2 == 97) {
         this.field902 = var1.method2455();
      } else if(98 == var2) {
         this.field881 = var1.method2455();
      } else if(var2 == 99) {
         this.field904 = true;
      } else if(100 == var2) {
         this.field895 = var1.method2454();
      } else if(var2 == 101) {
         this.field905 = var1.method2454() * 5;
      } else if(var2 == 102) {
         this.field903 = var1.method2455();
      } else if(103 == var2) {
         this.field908 = var1.method2455();
      } else if(var2 == 106) {
         this.field910 = var1.method2455();
         if(this.field910 == '\uffff') {
            this.field910 = -1;
         }

         this.field911 = var1.method2455();
         if(this.field911 == '\uffff') {
            this.field911 = -1;
         }

         var3 = var1.method2453();
         this.field909 = new int[var3 + 1];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.field909[var4] = var1.method2455();
            if('\uffff' == this.field909[var4]) {
               this.field909[var4] = -1;
            }
         }
      } else if(var2 == 107) {
         this.field883 = false;
      } else if(109 == var2) {
         this.field891 = false;
      } else if(var2 == 111) {
         this.field914 = true;
      } else if(112 == var2) {
         this.field915 = var1.method2453();
      }

   }

   @ObfuscatedName("j")
   public static class47 method796(int var0) {
      class47 var1 = (class47)class47.field1066.method3711((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class47.field1073.method3214(14, var0);
         var1 = new class47();
         if(null != var2) {
            var1.method968(new class118(var2));
         }

         class47.field1066.method3713(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("r")
   static final int method797(int var0, int var1) {
      int var2 = var0 + var1 * 57;
      var2 ^= var2 << 13;
      int var3 = 1376312589 + (var2 * var2 * 15731 + 789221) * var2 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }
}

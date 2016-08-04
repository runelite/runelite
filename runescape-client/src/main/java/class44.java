import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
@Implements("Sequence")
public class class44 extends class207 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -395559637
   )
   @Export("maxLoops")
   public int field1011 = 99;
   @ObfuscatedName("g")
   public static class170 field1012;
   @ObfuscatedName("l")
   public static class170 field1013;
   @ObfuscatedName("e")
   static class196 field1014 = new class196(64);
   @ObfuscatedName("h")
   static class196 field1015 = new class196(100);
   @ObfuscatedName("n")
   public int[] field1016;
   @ObfuscatedName("k")
   int[] field1017;
   @ObfuscatedName("u")
   public int[] field1018;
   @ObfuscatedName("r")
   public static class170 field1019;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1124883963
   )
   public int field1020 = -1;
   @ObfuscatedName("m")
   @Export("interleaveLeave")
   int[] field1021;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2116157831
   )
   public int field1023 = 5;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1228008619
   )
   public int field1024 = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1842907093
   )
   public int field1025 = -1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1066578077
   )
   @Export("precedenceAnimating")
   public int field1027 = -1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1339525359
   )
   public int field1028 = -1;
   @ObfuscatedName("s")
   public int[] field1030;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1220466189
   )
   @Export("replyMode")
   public int field1031 = 2;
   @ObfuscatedName("q")
   @Export("stretches")
   public boolean field1032 = false;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass108;II)Lclass108;",
      garbageValue = "-1615718597"
   )
   class108 method907(class108 var1, int var2) {
      var2 = this.field1030[var2];
      class106 var3 = class181.method3632(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method2400(true);
      } else {
         class108 var4 = var1.method2400(!var3.method2386(var2));
         var4.method2405(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "1377792797"
   )
   void method908(class122 var1) {
      while(true) {
         int var2 = var1.method2633();
         if(var2 == 0) {
            return;
         }

         this.method944(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1707681230"
   )
   void method910() {
      if(this.field1027 == -1) {
         if(this.field1021 != null) {
            this.field1027 = 2;
         } else {
            this.field1027 = 0;
         }
      }

      if(this.field1028 == -1) {
         if(null != this.field1021) {
            this.field1028 = 2;
         } else {
            this.field1028 = 0;
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "22636293"
   )
   static void method911(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var1 + var0) / 2;
         int var7 = var0;
         class27 var8 = class27.field662[var6];
         class27.field662[var6] = class27.field662[var1];
         class27.field662[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            if(class126.method2926(class27.field662[var9], var8, var2, var3, var4, var5) <= 0) {
               class27 var10 = class27.field662[var9];
               class27.field662[var9] = class27.field662[var7];
               class27.field662[var7++] = var10;
            }
         }

         class27.field662[var1] = class27.field662[var7];
         class27.field662[var7] = var8;
         method911(var0, var7 - 1, var2, var3, var4, var5);
         method911(var7 + 1, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass108;IIB)Lclass108;",
      garbageValue = "-72"
   )
   class108 method912(class108 var1, int var2, int var3) {
      var2 = this.field1030[var2];
      class106 var4 = class181.method3632(var2 >> 16);
      var2 &= '\uffff';
      if(var4 == null) {
         return var1.method2399(true);
      } else {
         class108 var5 = var1.method2399(!var4.method2386(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2410();
         } else if(var3 == 2) {
            var5.method2421();
         } else if(var3 == 3) {
            var5.method2455();
         }

         var5.method2405(var4, var2);
         if(var3 == 1) {
            var5.method2455();
         } else if(var3 == 2) {
            var5.method2421();
         } else if(var3 == 3) {
            var5.method2410();
         }

         return var5;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass108;ILclass44;II)Lclass108;",
      garbageValue = "1100905760"
   )
   public class108 method914(class108 var1, int var2, class44 var3, int var4) {
      var2 = this.field1030[var2];
      class106 var5 = class181.method3632(var2 >> 16);
      var2 &= '\uffff';
      if(var5 == null) {
         return var3.method943(var1, var4);
      } else {
         var4 = var3.field1030[var4];
         class106 var6 = class181.method3632(var4 >> 16);
         var4 &= '\uffff';
         class108 var7;
         if(null == var6) {
            var7 = var1.method2399(!var5.method2386(var2));
            var7.method2405(var5, var2);
            return var7;
         } else {
            var7 = var1.method2399(!var5.method2386(var2) & !var6.method2386(var4));
            var7.method2408(var5, var2, var6, var4, this.field1021);
            return var7;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass108;II)Lclass108;",
      garbageValue = "968977419"
   )
   public class108 method915(class108 var1, int var2) {
      int var3 = this.field1030[var2];
      class106 var4 = class181.method3632(var3 >> 16);
      var3 &= '\uffff';
      if(var4 == null) {
         return var1.method2399(true);
      } else {
         class106 var5 = null;
         int var6 = 0;
         if(null != this.field1017 && var2 < this.field1017.length) {
            var6 = this.field1017[var2];
            var5 = class181.method3632(var6 >> 16);
            var6 &= '\uffff';
         }

         class108 var7;
         if(var5 != null && var6 != '\uffff') {
            var7 = var1.method2399(!var4.method2386(var3) & !var5.method2386(var6));
            var7.method2405(var4, var3);
            var7.method2405(var5, var6);
            return var7;
         } else {
            var7 = var1.method2399(!var4.method2386(var3));
            var7.method2405(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass170;I)V",
      garbageValue = "751298916"
   )
   public static void method918(class170 var0) {
      class53.field1164 = var0;
   }

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(Lclass176;B)Lclass176;",
      garbageValue = "-27"
   )
   static class176 method935(class176 var0) {
      int var1 = class157.method3307(class2.method39(var0));
      if(var1 == 0) {
         return null;
      } else {
         for(int var2 = 0; var2 < var1; ++var2) {
            var0 = class134.method2983(var0.field2826);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)Lclass37;",
      garbageValue = "1019416752"
   )
   static class37 method939(int var0, int var1) {
      class29 var2 = (class29)class11.field182.get(Integer.valueOf(var0));
      return var2.method670(var1);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass108;II)Lclass108;",
      garbageValue = "377837586"
   )
   public class108 method943(class108 var1, int var2) {
      var2 = this.field1030[var2];
      class106 var3 = class181.method3632(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method2399(true);
      } else {
         class108 var4 = var1.method2399(!var3.method2386(var2));
         var4.method2405(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass122;IB)V",
      garbageValue = "70"
   )
   void method944(class122 var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2635();
         this.field1018 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1018[var4] = var1.method2635();
         }

         this.field1030 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1030[var4] = var1.method2635();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1030[var4] += var1.method2635() << 16;
         }
      } else if(var2 == 2) {
         this.field1020 = var1.method2635();
      } else if(var2 == 3) {
         var3 = var1.method2633();
         this.field1021 = new int[var3 + 1];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1021[var4] = var1.method2633();
         }

         this.field1021[var3] = 9999999;
      } else if(var2 == 4) {
         this.field1032 = true;
      } else if(var2 == 5) {
         this.field1023 = var1.method2633();
      } else if(var2 == 6) {
         this.field1024 = var1.method2635();
      } else if(var2 == 7) {
         this.field1025 = var1.method2635();
      } else if(var2 == 8) {
         this.field1011 = var1.method2633();
      } else if(var2 == 9) {
         this.field1027 = var1.method2633();
      } else if(var2 == 10) {
         this.field1028 = var1.method2633();
      } else if(var2 == 11) {
         this.field1031 = var1.method2633();
      } else if(var2 == 12) {
         var3 = var1.method2633();
         this.field1017 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1017[var4] = var1.method2635();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1017[var4] += var1.method2635() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.method2633();
         this.field1016 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1016[var4] = var1.method2637();
         }
      }

   }

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "(IIIILclass81;Lclass178;I)V",
      garbageValue = "-1681601976"
   )
   static final void method945(int var0, int var1, int var2, int var3, class81 var4, class178 var5) {
      int var6 = var2 * var2 + var3 * var3;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = client.field399 + client.field365 & 2047;
         int var8 = class94.field1661[var7];
         int var9 = class94.field1662[var7];
         var8 = 256 * var8 / (256 + client.field367);
         var9 = 256 * var9 / (client.field367 + 256);
         int var10 = var8 * var3 + var2 * var9 >> 16;
         int var11 = var9 * var3 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class32.field735.method1818(4 + var14 + 94 + var0 - 10, var1 + 83 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class0.method1(var0, var1, var2, var3, var4, var5);
      }

   }
}

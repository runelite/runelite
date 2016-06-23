import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
@Implements("Sequence")
public class class42 extends class204 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -675309337
   )
   public int field997 = -1;
   @ObfuscatedName("u")
   public static class167 field998;
   @ObfuscatedName("d")
   public int[] field999;
   @ObfuscatedName("x")
   public static class167 field1000;
   @ObfuscatedName("l")
   public static class193 field1001 = new class193(100);
   @ObfuscatedName("io")
   static class173 field1002;
   @ObfuscatedName("n")
   int[] field1003;
   @ObfuscatedName("m")
   public int[] field1004;
   @ObfuscatedName("g")
   public int[] field1005;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 104550707
   )
   public int field1006 = -1;
   @ObfuscatedName("r")
   @Export("interleaveLeave")
   int[] field1007;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 312130139
   )
   @Export("precedenceAnimating")
   public int field1008 = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 323536307
   )
   public int field1009 = 5;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1284592393
   )
   public int field1010 = -1;
   @ObfuscatedName("f")
   public static class167 field1011;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -568547053
   )
   @Export("maxLoops")
   public int field1012 = 99;
   @ObfuscatedName("b")
   public static class193 field1013 = new class193(64);
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1630625663
   )
   public int field1014 = -1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1760175847
   )
   @Export("replyMode")
   public int field1015 = 2;
   @ObfuscatedName("ii")
   @ObfuscatedGetter(
      intValue = 1856518919
   )
   static int field1016;
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = 1133733241
   )
   @Export("cameraYaw")
   static int field1018;
   @ObfuscatedName("k")
   @Export("stretches")
   public boolean field1019 = false;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "111"
   )
   void method900(class119 var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2556();
         this.field1004 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1004[var4] = var1.method2556();
         }

         this.field999 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field999[var4] = var1.method2556();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field999[var4] += var1.method2556() << 16;
         }
      } else if(var2 == 2) {
         this.field1014 = var1.method2556();
      } else if(var2 == 3) {
         var3 = var1.method2554();
         this.field1007 = new int[1 + var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1007[var4] = var1.method2554();
         }

         this.field1007[var3] = 9999999;
      } else if(var2 == 4) {
         this.field1019 = true;
      } else if(var2 == 5) {
         this.field1009 = var1.method2554();
      } else if(var2 == 6) {
         this.field1010 = var1.method2556();
      } else if(var2 == 7) {
         this.field1006 = var1.method2556();
      } else if(var2 == 8) {
         this.field1012 = var1.method2554();
      } else if(var2 == 9) {
         this.field1008 = var1.method2554();
      } else if(var2 == 10) {
         this.field997 = var1.method2554();
      } else if(var2 == 11) {
         this.field1015 = var1.method2554();
      } else if(var2 == 12) {
         var3 = var1.method2554();
         this.field1003 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1003[var4] = var1.method2556();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1003[var4] += var1.method2556() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.method2554();
         this.field1005 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1005[var4] = var1.method2558();
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1561045356"
   )
   void method901() {
      if(this.field1008 == -1) {
         if(null != this.field1007) {
            this.field1008 = 2;
         } else {
            this.field1008 = 0;
         }
      }

      if(this.field997 == -1) {
         if(null != this.field1007) {
            this.field997 = 2;
         } else {
            this.field997 = 0;
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass105;IIB)Lclass105;",
      garbageValue = "-7"
   )
   class105 method903(class105 var1, int var2, int var3) {
      var2 = this.field999[var2];
      class103 var4 = class106.method2421(var2 >> 16);
      var2 &= '\uffff';
      if(var4 == null) {
         return var1.method2354(true);
      } else {
         class105 var5 = var1.method2354(!var4.method2347(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2363();
         } else if(var3 == 2) {
            var5.method2417();
         } else if(var3 == 3) {
            var5.method2383();
         }

         var5.method2373(var4, var2);
         if(var3 == 1) {
            var5.method2383();
         } else if(var3 == 2) {
            var5.method2417();
         } else if(var3 == 3) {
            var5.method2363();
         }

         return var5;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass105;ILclass42;IB)Lclass105;",
      garbageValue = "1"
   )
   public class105 method905(class105 var1, int var2, class42 var3, int var4) {
      var2 = this.field999[var2];
      class103 var5 = class106.method2421(var2 >> 16);
      var2 &= '\uffff';
      if(var5 == null) {
         return var3.method928(var1, var4);
      } else {
         var4 = var3.field999[var4];
         class103 var6 = class106.method2421(var4 >> 16);
         var4 &= '\uffff';
         class105 var7;
         if(var6 == null) {
            var7 = var1.method2354(!var5.method2347(var2));
            var7.method2373(var5, var2);
            return var7;
         } else {
            var7 = var1.method2354(!var5.method2347(var2) & !var6.method2347(var4));
            var7.method2361(var5, var2, var6, var4, this.field1007);
            return var7;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass105;IB)Lclass105;",
      garbageValue = "-93"
   )
   public class105 method920(class105 var1, int var2) {
      int var3 = this.field999[var2];
      class103 var4 = class106.method2421(var3 >> 16);
      var3 &= '\uffff';
      if(null == var4) {
         return var1.method2354(true);
      } else {
         class103 var5 = null;
         int var6 = 0;
         if(this.field1003 != null && var2 < this.field1003.length) {
            var6 = this.field1003[var2];
            var5 = class106.method2421(var6 >> 16);
            var6 &= '\uffff';
         }

         class105 var7;
         if(null != var5 && var6 != '\uffff') {
            var7 = var1.method2354(!var4.method2347(var3) & !var5.method2347(var6));
            var7.method2373(var4, var3);
            var7.method2373(var5, var6);
            return var7;
         } else {
            var7 = var1.method2354(!var4.method2347(var3));
            var7.method2373(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass105;II)Lclass105;",
      garbageValue = "541894425"
   )
   class105 method927(class105 var1, int var2) {
      var2 = this.field999[var2];
      class103 var3 = class106.method2421(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method2355(true);
      } else {
         class105 var4 = var1.method2355(!var3.method2347(var2));
         var4.method2373(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass105;II)Lclass105;",
      garbageValue = "2124312491"
   )
   public class105 method928(class105 var1, int var2) {
      var2 = this.field999[var2];
      class103 var3 = class106.method2421(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method2354(true);
      } else {
         class105 var4 = var1.method2354(!var3.method2347(var2));
         var4.method2373(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass119;S)V",
      garbageValue = "-3311"
   )
   void method929(class119 var1) {
      while(true) {
         int var2 = var1.method2554();
         if(var2 == 0) {
            return;
         }

         this.method900(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-46"
   )
   public static void method937() {
      class51.field1116.method3796();
      class51.field1147.method3796();
      class51.field1118.method3796();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1151454494"
   )
   static void method938() {
      for(class23 var0 = (class23)class23.field608.method3852(); null != var0; var0 = (class23)class23.field608.method3857()) {
         if(null != var0.field611) {
            class121.field2014.method1200(var0.field611);
            var0.field611 = null;
         }

         if(null != var0.field607) {
            class121.field2014.method1200(var0.field607);
            var0.field607 = null;
         }
      }

      class23.field608.method3849();
   }
}

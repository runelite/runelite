import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
@Implements("Sequence")
public class class42 extends class204 {
   @ObfuscatedName("d")
   static class193 field982 = new class193(100);
   @ObfuscatedName("p")
   static class167 field983;
   @ObfuscatedName("x")
   static class193 field984 = new class193(64);
   @ObfuscatedName("s")
   static class167 field985;
   @ObfuscatedName("u")
   public int[] field986;
   @ObfuscatedName("o")
   int[] field987;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1520897247
   )
   @Export("replyMode")
   public int field988 = 2;
   @ObfuscatedName("k")
   public int[] field989;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1751228925
   )
   public int field991 = -1;
   @ObfuscatedName("t")
   @Export("stretches")
   public boolean field992 = false;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1417625259
   )
   public int field993 = 5;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1531613477
   )
   public int field994 = -1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 701224011
   )
   public int field995 = -1;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1317748485
   )
   @Export("maxLoops")
   public int field996 = 99;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1448156441
   )
   @Export("precedenceAnimating")
   public int field997 = -1;
   @ObfuscatedName("l")
   @Export("interleaveLeave")
   int[] field998;
   @ObfuscatedName("b")
   public int[] field999;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1194860889
   )
   public int field1001 = -1;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "752483045"
   )
   void method838(class119 var1) {
      while(true) {
         int var2 = var1.method2492();
         if(var2 == 0) {
            return;
         }

         this.method839(var1, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "1753490525"
   )
   void method839(class119 var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2584();
         this.field999 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field999[var4] = var1.method2584();
         }

         this.field986 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field986[var4] = var1.method2584();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field986[var4] += var1.method2584() << 16;
         }
      } else if(2 == var2) {
         this.field991 = var1.method2584();
      } else if(3 == var2) {
         var3 = var1.method2492();
         this.field998 = new int[1 + var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field998[var4] = var1.method2492();
         }

         this.field998[var3] = 9999999;
      } else if(4 == var2) {
         this.field992 = true;
      } else if(var2 == 5) {
         this.field993 = var1.method2492();
      } else if(6 == var2) {
         this.field994 = var1.method2584();
      } else if(7 == var2) {
         this.field995 = var1.method2584();
      } else if(8 == var2) {
         this.field996 = var1.method2492();
      } else if(var2 == 9) {
         this.field997 = var1.method2492();
      } else if(var2 == 10) {
         this.field1001 = var1.method2492();
      } else if(11 == var2) {
         this.field988 = var1.method2492();
      } else if(12 == var2) {
         var3 = var1.method2492();
         this.field987 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field987[var4] = var1.method2584();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field987[var4] += var1.method2584() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.method2492();
         this.field989 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field989[var4] = var1.method2513();
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass105;IS)Lclass105;",
      garbageValue = "242"
   )
   public class105 method841(class105 var1, int var2) {
      var2 = this.field986[var2];
      class103 var3 = class124.method2777(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2284(true);
      } else {
         class105 var4 = var1.method2284(!var3.method2278(var2));
         var4.method2290(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass105;II)Lclass105;",
      garbageValue = "-1934285210"
   )
   public class105 method842(class105 var1, int var2) {
      int var3 = this.field986[var2];
      class103 var4 = class124.method2777(var3 >> 16);
      var3 &= '\uffff';
      if(var4 == null) {
         return var1.method2284(true);
      } else {
         class103 var5 = null;
         int var6 = 0;
         if(this.field987 != null && var2 < this.field987.length) {
            var6 = this.field987[var2];
            var5 = class124.method2777(var6 >> 16);
            var6 &= '\uffff';
         }

         class105 var7;
         if(null != var5 && '\uffff' != var6) {
            var7 = var1.method2284(!var4.method2278(var3) & !var5.method2278(var6));
            var7.method2290(var4, var3);
            var7.method2290(var5, var6);
            return var7;
         } else {
            var7 = var1.method2284(!var4.method2278(var3));
            var7.method2290(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass105;II)Lclass105;",
      garbageValue = "-1297832117"
   )
   class105 method843(class105 var1, int var2) {
      var2 = this.field986[var2];
      class103 var3 = class124.method2777(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method2285(true);
      } else {
         class105 var4 = var1.method2285(!var3.method2278(var2));
         var4.method2290(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass105;ILclass42;II)Lclass105;",
      garbageValue = "1038490009"
   )
   public class105 method844(class105 var1, int var2, class42 var3, int var4) {
      var2 = this.field986[var2];
      class103 var5 = class124.method2777(var2 >> 16);
      var2 &= '\uffff';
      if(var5 == null) {
         return var3.method841(var1, var4);
      } else {
         var4 = var3.field986[var4];
         class103 var6 = class124.method2777(var4 >> 16);
         var4 &= '\uffff';
         class105 var7;
         if(null == var6) {
            var7 = var1.method2284(!var5.method2278(var2));
            var7.method2290(var5, var2);
            return var7;
         } else {
            var7 = var1.method2284(!var5.method2278(var2) & !var6.method2278(var4));
            var7.method2305(var5, var2, var6, var4, this.field998);
            return var7;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass105;III)Lclass105;",
      garbageValue = "889987370"
   )
   class105 method845(class105 var1, int var2, int var3) {
      var2 = this.field986[var2];
      class103 var4 = class124.method2777(var2 >> 16);
      var2 &= '\uffff';
      if(var4 == null) {
         return var1.method2284(true);
      } else {
         class105 var5 = var1.method2284(!var4.method2278(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2295();
         } else if(var3 == 2) {
            var5.method2339();
         } else if(3 == var3) {
            var5.method2293();
         }

         var5.method2290(var4, var2);
         if(var3 == 1) {
            var5.method2293();
         } else if(var3 == 2) {
            var5.method2339();
         } else if(3 == var3) {
            var5.method2295();
         }

         return var5;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1050053921"
   )
   void method868() {
      if(-1 == this.field997) {
         if(null != this.field998) {
            this.field997 = 2;
         } else {
            this.field997 = 0;
         }
      }

      if(this.field1001 == -1) {
         if(null != this.field998) {
            this.field1001 = 2;
         } else {
            this.field1001 = 0;
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IZI)Ljava/lang/String;",
      garbageValue = "1"
   )
   public static String method874(int var0, boolean var1) {
      return var0 < 0?Integer.toString(var0):class26.method617(var0, 10, var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "4"
   )
   static final int method875(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class19.method242(var3, var5);
      int var8 = class19.method242(var3 + 1, var5);
      int var9 = class19.method242(var3, var5 + 1);
      int var10 = class19.method242(var3 + 1, 1 + var5);
      int var11 = class191.method3736(var7, var8, var4, var2);
      int var12 = class191.method3736(var9, var10, var4, var2);
      return class191.method3736(var11, var12, var6, var2);
   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
@Implements("Sequence")
public class class42 extends class204 {
   @ObfuscatedName("k")
   public int[] field989;
   @ObfuscatedName("c")
   public static class193 field990 = new class193(64);
   @ObfuscatedName("y")
   public static class193 field991 = new class193(100);
   @ObfuscatedName("q")
   public int[] field992;
   @ObfuscatedName("r")
   int[] field993;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1772390431
   )
   public int field994 = -1;
   @ObfuscatedName("p")
   public int[] field995;
   @ObfuscatedName("hf")
   @ObfuscatedGetter(
      intValue = -670763319
   )
   static int field996;
   @ObfuscatedName("e")
   @Export("interleaveLeave")
   int[] field997;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1357656705
   )
   public int field998 = -1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 918000041
   )
   public int field999 = 5;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -1759605389
   )
   static int field1000;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1965468135
   )
   public int field1001 = -1;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = 3404341
   )
   @Export("plane")
   static int field1002;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -688623597
   )
   @Export("precedenceAnimating")
   public int field1003 = -1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -973650755
   )
   public int field1004 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1205750285
   )
   @Export("replyMode")
   public int field1005 = 2;
   @ObfuscatedName("w")
   public static class167 field1008;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1644021
   )
   @Export("maxLoops")
   public int field1011 = 99;
   @ObfuscatedName("x")
   @Export("stretches")
   public boolean field1012 = false;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "462242920"
   )
   void method951(class119 var1) {
      while(true) {
         int var2 = var1.method2613();
         if(var2 == 0) {
            return;
         }

         this.method952(var1, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-25628554"
   )
   void method952(class119 var1, int var2) {
      int var3;
      int var4;
      if(1 == var2) {
         var3 = var1.method2615();
         this.field995 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field995[var4] = var1.method2615();
         }

         this.field989 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field989[var4] = var1.method2615();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field989[var4] += var1.method2615() << 16;
         }
      } else if(var2 == 2) {
         this.field998 = var1.method2615();
      } else if(3 == var2) {
         var3 = var1.method2613();
         this.field997 = new int[var3 + 1];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field997[var4] = var1.method2613();
         }

         this.field997[var3] = 9999999;
      } else if(var2 == 4) {
         this.field1012 = true;
      } else if(5 == var2) {
         this.field999 = var1.method2613();
      } else if(var2 == 6) {
         this.field994 = var1.method2615();
      } else if(7 == var2) {
         this.field1001 = var1.method2615();
      } else if(var2 == 8) {
         this.field1011 = var1.method2613();
      } else if(9 == var2) {
         this.field1003 = var1.method2613();
      } else if(10 == var2) {
         this.field1004 = var1.method2613();
      } else if(11 == var2) {
         this.field1005 = var1.method2613();
      } else if(12 == var2) {
         var3 = var1.method2613();
         this.field993 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field993[var4] = var1.method2615();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field993[var4] += var1.method2615() << 16;
         }
      } else if(13 == var2) {
         var3 = var1.method2613();
         this.field992 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field992[var4] = var1.method2617();
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method953() {
      if(-1 == this.field1003) {
         if(this.field997 != null) {
            this.field1003 = 2;
         } else {
            this.field1003 = 0;
         }
      }

      if(-1 == this.field1004) {
         if(this.field997 != null) {
            this.field1004 = 2;
         } else {
            this.field1004 = 0;
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass105;II)Lclass105;",
      garbageValue = "-1181519086"
   )
   public class105 method954(class105 var1, int var2) {
      var2 = this.field989[var2];
      class103 var3 = class108.method2520(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2471(true);
      } else {
         class105 var4 = var1.method2471(!var3.method2382(var2));
         var4.method2461(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass105;III)Lclass105;",
      garbageValue = "867085626"
   )
   class105 method955(class105 var1, int var2, int var3) {
      var2 = this.field989[var2];
      class103 var4 = class108.method2520(var2 >> 16);
      var2 &= '\uffff';
      if(null == var4) {
         return var1.method2471(true);
      } else {
         class105 var5 = var1.method2471(!var4.method2382(var2));
         var3 &= 3;
         if(1 == var3) {
            var5.method2400();
         } else if(2 == var3) {
            var5.method2399();
         } else if(var3 == 3) {
            var5.method2398();
         }

         var5.method2461(var4, var2);
         if(1 == var3) {
            var5.method2398();
         } else if(2 == var3) {
            var5.method2399();
         } else if(var3 == 3) {
            var5.method2400();
         }

         return var5;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass105;II)Lclass105;",
      garbageValue = "2063452323"
   )
   class105 method956(class105 var1, int var2) {
      var2 = this.field989[var2];
      class103 var3 = class108.method2520(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method2390(true);
      } else {
         class105 var4 = var1.method2390(!var3.method2382(var2));
         var4.method2461(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass105;ILclass42;II)Lclass105;",
      garbageValue = "1070380973"
   )
   public class105 method957(class105 var1, int var2, class42 var3, int var4) {
      var2 = this.field989[var2];
      class103 var5 = class108.method2520(var2 >> 16);
      var2 &= '\uffff';
      if(var5 == null) {
         return var3.method954(var1, var4);
      } else {
         var4 = var3.field989[var4];
         class103 var6 = class108.method2520(var4 >> 16);
         var4 &= '\uffff';
         class105 var7;
         if(var6 == null) {
            var7 = var1.method2471(!var5.method2382(var2));
            var7.method2461(var5, var2);
            return var7;
         } else {
            var7 = var1.method2471(!var5.method2382(var2) & !var6.method2382(var4));
            var7.method2396(var5, var2, var6, var4, this.field997);
            return var7;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass105;IB)Lclass105;",
      garbageValue = "0"
   )
   public class105 method958(class105 var1, int var2) {
      int var3 = this.field989[var2];
      class103 var4 = class108.method2520(var3 >> 16);
      var3 &= '\uffff';
      if(var4 == null) {
         return var1.method2471(true);
      } else {
         class103 var5 = null;
         int var6 = 0;
         if(null != this.field993 && var2 < this.field993.length) {
            var6 = this.field993[var2];
            var5 = class108.method2520(var6 >> 16);
            var6 &= '\uffff';
         }

         class105 var7;
         if(null != var5 && var6 != '\uffff') {
            var7 = var1.method2471(!var4.method2382(var3) & !var5.method2382(var6));
            var7.method2461(var4, var3);
            var7.method2461(var5, var6);
            return var7;
         } else {
            var7 = var1.method2471(!var4.method2382(var3));
            var7.method2461(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "-60"
   )
   public static int method987(CharSequence var0) {
      return class158.method3265(var0, 10, true);
   }
}

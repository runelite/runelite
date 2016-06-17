import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
@Implements("Sequence")
public class class42 extends class204 {
   @ObfuscatedName("x")
   public static class193 field961 = new class193(100);
   @ObfuscatedName("g")
   public static class167 field962;
   @ObfuscatedName("j")
   public static class167 field963;
   @ObfuscatedName("n")
   @Export("stretches")
   public boolean field964 = false;
   @ObfuscatedName("y")
   public int[] field965;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2021708355
   )
   public int field966 = -1;
   @ObfuscatedName("r")
   int[] field967;
   @ObfuscatedName("jc")
   static class173[] field968;
   @ObfuscatedName("b")
   public static class167 field969;
   @ObfuscatedName("l")
   public int[] field970;
   @ObfuscatedName("p")
   @Export("interleaveLeave")
   int[] field971;
   @ObfuscatedName("d")
   public static class193 field972 = new class193(64);
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 827440191
   )
   public int field973 = 5;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -127231955
   )
   public int field974 = -1;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1171728697
   )
   public int field975 = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1778796463
   )
   @Export("maxLoops")
   public int field976 = 99;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 423043539
   )
   @Export("precedenceAnimating")
   public int field977 = -1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1018477599
   )
   public int field978 = -1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 261888247
   )
   @Export("replyMode")
   public int field979 = 2;
   @ObfuscatedName("c")
   public int[] field983;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass105;III)Lclass105;",
      garbageValue = "-963392057"
   )
   class105 method867(class105 var1, int var2, int var3) {
      var2 = this.field965[var2];
      class103 var4 = class31.method706(var2 >> 16);
      var2 &= '\uffff';
      if(null == var4) {
         return var1.method2296(true);
      } else {
         class105 var5 = var1.method2296(!var4.method2290(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2360();
         } else if(var3 == 2) {
            var5.method2306();
         } else if(var3 == 3) {
            var5.method2305();
         }

         var5.method2302(var4, var2);
         if(var3 == 1) {
            var5.method2305();
         } else if(var3 == 2) {
            var5.method2306();
         } else if(var3 == 3) {
            var5.method2360();
         }

         return var5;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1644645699"
   )
   void method868() {
      if(this.field977 == -1) {
         if(null != this.field971) {
            this.field977 = 2;
         } else {
            this.field977 = 0;
         }
      }

      if(this.field978 == -1) {
         if(null != this.field971) {
            this.field978 = 2;
         } else {
            this.field978 = 0;
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "37"
   )
   void method870(class119 var1) {
      while(true) {
         int var2 = var1.method2514();
         if(var2 == 0) {
            return;
         }

         this.method903(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass105;IB)Lclass105;",
      garbageValue = "1"
   )
   class105 method871(class105 var1, int var2) {
      var2 = this.field965[var2];
      class103 var3 = class31.method706(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2297(true);
      } else {
         class105 var4 = var1.method2297(!var3.method2290(var2));
         var4.method2302(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass105;ILclass42;IB)Lclass105;",
      garbageValue = "-103"
   )
   public class105 method872(class105 var1, int var2, class42 var3, int var4) {
      var2 = this.field965[var2];
      class103 var5 = class31.method706(var2 >> 16);
      var2 &= '\uffff';
      if(null == var5) {
         return var3.method894(var1, var4);
      } else {
         var4 = var3.field965[var4];
         class103 var6 = class31.method706(var4 >> 16);
         var4 &= '\uffff';
         class105 var7;
         if(null == var6) {
            var7 = var1.method2296(!var5.method2290(var2));
            var7.method2302(var5, var2);
            return var7;
         } else {
            var7 = var1.method2296(!var5.method2290(var2) & !var6.method2290(var4));
            var7.method2327(var5, var2, var6, var4, this.field971);
            return var7;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass105;IB)Lclass105;",
      garbageValue = "8"
   )
   public class105 method873(class105 var1, int var2) {
      int var3 = this.field965[var2];
      class103 var4 = class31.method706(var3 >> 16);
      var3 &= '\uffff';
      if(var4 == null) {
         return var1.method2296(true);
      } else {
         class103 var5 = null;
         int var6 = 0;
         if(this.field967 != null && var2 < this.field967.length) {
            var6 = this.field967[var2];
            var5 = class31.method706(var6 >> 16);
            var6 &= '\uffff';
         }

         class105 var7;
         if(var5 != null && var6 != '\uffff') {
            var7 = var1.method2296(!var4.method2290(var3) & !var5.method2290(var6));
            var7.method2302(var4, var3);
            var7.method2302(var5, var6);
            return var7;
         } else {
            var7 = var1.method2296(!var4.method2290(var3));
            var7.method2302(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass105;IB)Lclass105;",
      garbageValue = "7"
   )
   public class105 method894(class105 var1, int var2) {
      var2 = this.field965[var2];
      class103 var3 = class31.method706(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2296(true);
      } else {
         class105 var4 = var1.method2296(!var3.method2290(var2));
         var4.method2302(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "848943568"
   )
   void method903(class119 var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2516();
         this.field983 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field983[var4] = var1.method2516();
         }

         this.field965 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field965[var4] = var1.method2516();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field965[var4] += var1.method2516() << 16;
         }
      } else if(var2 == 2) {
         this.field966 = var1.method2516();
      } else if(var2 == 3) {
         var3 = var1.method2514();
         this.field971 = new int[var3 + 1];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field971[var4] = var1.method2514();
         }

         this.field971[var3] = 9999999;
      } else if(var2 == 4) {
         this.field964 = true;
      } else if(var2 == 5) {
         this.field973 = var1.method2514();
      } else if(var2 == 6) {
         this.field974 = var1.method2516();
      } else if(var2 == 7) {
         this.field975 = var1.method2516();
      } else if(var2 == 8) {
         this.field976 = var1.method2514();
      } else if(var2 == 9) {
         this.field977 = var1.method2514();
      } else if(var2 == 10) {
         this.field978 = var1.method2514();
      } else if(var2 == 11) {
         this.field979 = var1.method2514();
      } else if(var2 == 12) {
         var3 = var1.method2514();
         this.field967 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field967[var4] = var1.method2516();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field967[var4] += var1.method2516() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.method2514();
         this.field970 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field970[var4] = var1.method2518();
         }
      }

   }
}

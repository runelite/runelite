import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
@Implements("Sequence")
public class class42 extends class204 {
   @ObfuscatedName("f")
   static class167 field961;
   @ObfuscatedName("w")
   static class167 field962;
   @ObfuscatedName("p")
   public static class193 field963 = new class193(100);
   @ObfuscatedName("s")
   public static class193 field964 = new class193(64);
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1504645835
   )
   public int field965 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -725311015
   )
   public int field966 = -1;
   @ObfuscatedName("g")
   int[] field967;
   @ObfuscatedName("a")
   public int[] field968;
   @ObfuscatedName("r")
   public int[] field969;
   @ObfuscatedName("e")
   static class167 field970;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -295045995
   )
   @Export("replyMode")
   public int field971 = 2;
   @ObfuscatedName("m")
   @Export("interleaveLeave")
   int[] field972;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 929577391
   )
   public int field973 = 5;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 597365921
   )
   public int field974 = -1;
   @ObfuscatedName("h")
   public int[] field975;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1600302969
   )
   @Export("maxLoops")
   public int field976 = 99;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -411964287
   )
   @Export("precedenceAnimating")
   public int field977 = -1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1705399009
   )
   public int field978 = -1;
   @ObfuscatedName("n")
   @Export("stretches")
   public boolean field979 = false;
   @ObfuscatedName("dz")
   static byte[][] field980;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = 1359404991
   )
   static int field981;

   @ObfuscatedName("k")
   public class105 method856(class105 var1, int var2) {
      int var3 = this.field975[var2];
      class103 var4 = class41.method855(var3 >> 16);
      var3 &= '\uffff';
      if(var4 == null) {
         return var1.method2324(true);
      } else {
         class103 var5 = null;
         int var6 = 0;
         if(null != this.field967 && var2 < this.field967.length) {
            var6 = this.field967[var2];
            var5 = class41.method855(var6 >> 16);
            var6 &= '\uffff';
         }

         class105 var7;
         if(null != var5 && '\uffff' != var6) {
            var7 = var1.method2324(!var4.method2315(var3) & !var5.method2315(var6));
            var7.method2330(var4, var3);
            var7.method2330(var5, var6);
            return var7;
         } else {
            var7 = var1.method2324(!var4.method2315(var3));
            var7.method2330(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "-708428993"
   )
   void method857(class119 var1) {
      while(true) {
         int var2 = var1.method2523();
         if(0 == var2) {
            return;
         }

         this.method858(var1, var2);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-228093908"
   )
   void method858(class119 var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2700();
         this.field968 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field968[var4] = var1.method2700();
         }

         this.field975 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field975[var4] = var1.method2700();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field975[var4] += var1.method2700() << 16;
         }
      } else if(var2 == 2) {
         this.field965 = var1.method2700();
      } else if(var2 == 3) {
         var3 = var1.method2523();
         this.field972 = new int[1 + var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field972[var4] = var1.method2523();
         }

         this.field972[var3] = 9999999;
      } else if(4 == var2) {
         this.field979 = true;
      } else if(var2 == 5) {
         this.field973 = var1.method2523();
      } else if(var2 == 6) {
         this.field974 = var1.method2700();
      } else if(var2 == 7) {
         this.field966 = var1.method2700();
      } else if(var2 == 8) {
         this.field976 = var1.method2523();
      } else if(var2 == 9) {
         this.field977 = var1.method2523();
      } else if(10 == var2) {
         this.field978 = var1.method2523();
      } else if(var2 == 11) {
         this.field971 = var1.method2523();
      } else if(12 == var2) {
         var3 = var1.method2523();
         this.field967 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field967[var4] = var1.method2700();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field967[var4] += var1.method2700() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.method2523();
         this.field969 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field969[var4] = var1.method2527();
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-325692272"
   )
   void method859() {
      if(this.field977 == -1) {
         if(this.field972 != null) {
            this.field977 = 2;
         } else {
            this.field977 = 0;
         }
      }

      if(-1 == this.field978) {
         if(this.field972 != null) {
            this.field978 = 2;
         } else {
            this.field978 = 0;
         }
      }

   }

   @ObfuscatedName("g")
   class105 method861(class105 var1, int var2, int var3) {
      var2 = this.field975[var2];
      class103 var4 = class41.method855(var2 >> 16);
      var2 &= '\uffff';
      if(var4 == null) {
         return var1.method2324(true);
      } else {
         class105 var5 = var1.method2324(!var4.method2315(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2335();
         } else if(2 == var3) {
            var5.method2334();
         } else if(3 == var3) {
            var5.method2381();
         }

         var5.method2330(var4, var2);
         if(1 == var3) {
            var5.method2381();
         } else if(var3 == 2) {
            var5.method2334();
         } else if(3 == var3) {
            var5.method2335();
         }

         return var5;
      }
   }

   @ObfuscatedName("a")
   class105 method862(class105 var1, int var2) {
      var2 = this.field975[var2];
      class103 var3 = class41.method855(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2366(true);
      } else {
         class105 var4 = var1.method2366(!var3.method2315(var2));
         var4.method2330(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("r")
   public class105 method868(class105 var1, int var2, class42 var3, int var4) {
      var2 = this.field975[var2];
      class103 var5 = class41.method855(var2 >> 16);
      var2 &= '\uffff';
      if(null == var5) {
         return var3.method897(var1, var4);
      } else {
         var4 = var3.field975[var4];
         class103 var6 = class41.method855(var4 >> 16);
         var4 &= '\uffff';
         class105 var7;
         if(null == var6) {
            var7 = var1.method2324(!var5.method2315(var2));
            var7.method2330(var5, var2);
            return var7;
         } else {
            var7 = var1.method2324(!var5.method2315(var2) & !var6.method2315(var4));
            var7.method2333(var5, var2, var6, var4, this.field972);
            return var7;
         }
      }
   }

   @ObfuscatedName("s")
   static final void method881() {
      class86.field1461 = false;
      client.field285 = false;
   }

   @ObfuscatedName("h")
   public class105 method897(class105 var1, int var2) {
      var2 = this.field975[var2];
      class103 var3 = class41.method855(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method2324(true);
      } else {
         class105 var4 = var1.method2324(!var3.method2315(var2));
         var4.method2330(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("f")
   static boolean method898(String var0, int var1) {
      return class94.method2185(var0, var1, "openjs");
   }
}

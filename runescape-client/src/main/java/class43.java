import java.awt.Frame;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public class class43 extends class204 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1207844833
   )
   int field1004 = 0;
   @ObfuscatedName("g")
   public static class193 field1005 = new class193(64);
   @ObfuscatedName("h")
   public static class193 field1006 = new class193(30);
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1182185363
   )
   int field1007;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 960575569
   )
   int field1008;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1050382977
   )
   int field1009 = 0;
   @ObfuscatedName("s")
   short[] field1010;
   @ObfuscatedName("d")
   short[] field1011;
   @ObfuscatedName("l")
   short[] field1012;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1613986131
   )
   public int field1014 = -1;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1633527453
   )
   int field1015 = 128;
   @ObfuscatedName("qr")
   @ObfuscatedGetter(
      intValue = -986325693
   )
   protected static int field1016;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1224516079
   )
   int field1017 = 0;
   @ObfuscatedName("i")
   static class167 field1018;
   @ObfuscatedName("y")
   short[] field1020;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1098841045
   )
   int field1021 = 128;
   @ObfuscatedName("qm")
   protected static Frame field1022;
   @ObfuscatedName("t")
   public static class143 field1023;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "-22"
   )
   void method882(class119 var1, int var2) {
      if(var2 == 1) {
         this.field1008 = var1.method2470();
      } else if(var2 == 2) {
         this.field1014 = var1.method2470();
      } else if(var2 == 4) {
         this.field1021 = var1.method2470();
      } else if(var2 == 5) {
         this.field1015 = var1.method2470();
      } else if(var2 == 6) {
         this.field1004 = var1.method2470();
      } else if(var2 == 7) {
         this.field1017 = var1.method2494();
      } else if(var2 == 8) {
         this.field1009 = var1.method2494();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.method2494();
            this.field1010 = new short[var3];
            this.field1011 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1010[var4] = (short)var1.method2470();
               this.field1011[var4] = (short)var1.method2470();
            }
         } else if(var2 == 41) {
            var3 = var1.method2494();
            this.field1012 = new short[var3];
            this.field1020 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1012[var4] = (short)var1.method2470();
               this.field1020[var4] = (short)var1.method2470();
            }
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)Lclass105;",
      garbageValue = "-443579545"
   )
   public final class105 method883(int var1) {
      class105 var2 = (class105)field1006.method3716((long)this.field1007);
      if(var2 == null) {
         class100 var3 = class100.method2172(field1018, this.field1008, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field1010 != null) {
            for(var4 = 0; var4 < this.field1010.length; ++var4) {
               var3.method2201(this.field1010[var4], this.field1011[var4]);
            }
         }

         if(this.field1012 != null) {
            for(var4 = 0; var4 < this.field1012.length; ++var4) {
               var3.method2189(this.field1012[var4], this.field1020[var4]);
            }
         }

         var2 = var3.method2181(64 + this.field1017, this.field1009 + 850, -30, -50, -30);
         field1006.method3724(var2, (long)this.field1007);
      }

      class105 var5;
      if(this.field1014 != -1 && var1 != -1) {
         var5 = class18.method177(this.field1014).method854(var2, var1);
      } else {
         var5 = var2.method2296(true);
      }

      if(this.field1021 != 128 || this.field1015 != 128) {
         var5.method2316(this.field1021, this.field1015, this.field1021);
      }

      if(this.field1004 != 0) {
         if(this.field1004 == 90) {
            var5.method2264();
         }

         if(this.field1004 == 180) {
            var5.method2264();
            var5.method2264();
         }

         if(this.field1004 == 270) {
            var5.method2264();
            var5.method2264();
            var5.method2264();
         }
      }

      return var5;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "14"
   )
   void method886(class119 var1) {
      while(true) {
         int var2 = var1.method2494();
         if(var2 == 0) {
            return;
         }

         this.method882(var1, var2);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-113"
   )
   public static void method889() {
      class51.field1133.method3717();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1797758939"
   )
   static void method892() {
      class11.field175.clear();
      class11.field180.method3764();
      class11.field174.method3806();
      class11.field172 = 0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "417612005"
   )
   public static boolean method893(char var0) {
      return var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
@Implements("Sequence")
public class class44 extends class207 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1028614753
   )
   public int field1005 = 5;
   @ObfuscatedName("e")
   static class170 field1006;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2000633507
   )
   @Export("maxLoops")
   public int field1007 = 99;
   @ObfuscatedName("nr")
   @ObfuscatedGetter(
      intValue = 1505076079
   )
   static int field1008;
   @ObfuscatedName("l")
   public int[] field1009;
   @ObfuscatedName("x")
   public int[] field1010;
   @ObfuscatedName("r")
   public int[] field1011;
   @ObfuscatedName("g")
   static class196 field1012 = new class196(100);
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 427861943
   )
   public int field1013 = -1;
   @ObfuscatedName("v")
   @Export("interleaveLeave")
   int[] field1014;
   @ObfuscatedName("h")
   @Export("stretches")
   public boolean field1015 = false;
   @ObfuscatedName("j")
   int[] field1016;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -342578739
   )
   public int field1017 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 274306115
   )
   public int field1018 = -1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1523272261
   )
   @Export("precedenceAnimating")
   public int field1019 = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 997055959
   )
   public int field1020 = -1;
   @ObfuscatedName("ao")
   static class146 field1021;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1618686943
   )
   @Export("replyMode")
   public int field1022 = 2;
   @ObfuscatedName("w")
   static class170 field1023;
   @ObfuscatedName("o")
   static class196 field1024 = new class196(64);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass108;ILclass44;IB)Lclass108;",
      garbageValue = "-57"
   )
   public class108 method906(class108 var1, int var2, class44 var3, int var4) {
      var2 = this.field1009[var2];
      class106 var5 = class142.method2997(var2 >> 16);
      var2 &= '\uffff';
      if(null == var5) {
         return var3.method910(var1, var4);
      } else {
         var4 = var3.field1009[var4];
         class106 var6 = class142.method2997(var4 >> 16);
         var4 &= '\uffff';
         class108 var7;
         if(null == var6) {
            var7 = var1.method2368(!var5.method2360(var2));
            var7.method2392(var5, var2);
            return var7;
         } else {
            var7 = var1.method2368(!var5.method2360(var2) & !var6.method2360(var4));
            var7.method2417(var5, var2, var6, var4, this.field1014);
            return var7;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "652496912"
   )
   void method907(class122 var1) {
      while(true) {
         int var2 = var1.method2556();
         if(var2 == 0) {
            return;
         }

         this.method917(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2021764445"
   )
   void method909() {
      if(this.field1019 == -1) {
         if(this.field1014 != null) {
            this.field1019 = 2;
         } else {
            this.field1019 = 0;
         }
      }

      if(this.field1020 == -1) {
         if(this.field1014 != null) {
            this.field1020 = 2;
         } else {
            this.field1020 = 0;
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass108;II)Lclass108;",
      garbageValue = "2141797811"
   )
   public class108 method910(class108 var1, int var2) {
      var2 = this.field1009[var2];
      class106 var3 = class142.method2997(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method2368(true);
      } else {
         class108 var4 = var1.method2368(!var3.method2360(var2));
         var4.method2392(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass108;IIB)Lclass108;",
      garbageValue = "-61"
   )
   class108 method911(class108 var1, int var2, int var3) {
      var2 = this.field1009[var2];
      class106 var4 = class142.method2997(var2 >> 16);
      var2 &= '\uffff';
      if(null == var4) {
         return var1.method2368(true);
      } else {
         class108 var5 = var1.method2368(!var4.method2360(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2378();
         } else if(var3 == 2) {
            var5.method2377();
         } else if(var3 == 3) {
            var5.method2376();
         }

         var5.method2392(var4, var2);
         if(var3 == 1) {
            var5.method2376();
         } else if(var3 == 2) {
            var5.method2377();
         } else if(var3 == 3) {
            var5.method2378();
         }

         return var5;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass108;IB)Lclass108;",
      garbageValue = "-69"
   )
   class108 method912(class108 var1, int var2) {
      var2 = this.field1009[var2];
      class106 var3 = class142.method2997(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2369(true);
      } else {
         class108 var4 = var1.method2369(!var3.method2360(var2));
         var4.method2392(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "5"
   )
   public static boolean method914() {
      class213 var0 = (class213)class214.field3180.method3921();
      return null != var0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "-1022862263"
   )
   void method917(class122 var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2706();
         this.field1011 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1011[var4] = var1.method2706();
         }

         this.field1009 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1009[var4] = var1.method2706();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1009[var4] += var1.method2706() << 16;
         }
      } else if(var2 == 2) {
         this.field1013 = var1.method2706();
      } else if(var2 == 3) {
         var3 = var1.method2556();
         this.field1014 = new int[var3 + 1];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1014[var4] = var1.method2556();
         }

         this.field1014[var3] = 9999999;
      } else if(var2 == 4) {
         this.field1015 = true;
      } else if(var2 == 5) {
         this.field1005 = var1.method2556();
      } else if(var2 == 6) {
         this.field1017 = var1.method2706();
      } else if(var2 == 7) {
         this.field1018 = var1.method2706();
      } else if(var2 == 8) {
         this.field1007 = var1.method2556();
      } else if(var2 == 9) {
         this.field1019 = var1.method2556();
      } else if(var2 == 10) {
         this.field1020 = var1.method2556();
      } else if(var2 == 11) {
         this.field1022 = var1.method2556();
      } else if(var2 == 12) {
         var3 = var1.method2556();
         this.field1016 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1016[var4] = var1.method2706();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1016[var4] += var1.method2706() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.method2556();
         this.field1010 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field1010[var4] = var1.method2576();
         }
      }

   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(Lclass16;I)V",
      garbageValue = "-515316198"
   )
   static final void method922(class16 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field208 == 0) {
         var1 = class5.field91.method2025(var0.field213, var0.field209, var0.field210);
      }

      if(var0.field208 == 1) {
         var1 = class5.field91.method2007(var0.field213, var0.field209, var0.field210);
      }

      if(var0.field208 == 2) {
         var1 = class5.field91.method2137(var0.field213, var0.field209, var0.field210);
      }

      if(var0.field208 == 3) {
         var1 = class5.field91.method2027(var0.field213, var0.field209, var0.field210);
      }

      if(var1 != 0) {
         int var5 = class5.field91.method2028(var0.field213, var0.field209, var0.field210, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field214 = var2;
      var0.field211 = var3;
      var0.field212 = var4;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass108;II)Lclass108;",
      garbageValue = "-185191328"
   )
   public class108 method937(class108 var1, int var2) {
      int var3 = this.field1009[var2];
      class106 var4 = class142.method2997(var3 >> 16);
      var3 &= '\uffff';
      if(var4 == null) {
         return var1.method2368(true);
      } else {
         class106 var5 = null;
         int var6 = 0;
         if(null != this.field1016 && var2 < this.field1016.length) {
            var6 = this.field1016[var2];
            var5 = class142.method2997(var6 >> 16);
            var6 &= '\uffff';
         }

         class108 var7;
         if(var5 != null && var6 != '\uffff') {
            var7 = var1.method2368(!var4.method2360(var3) & !var5.method2360(var6));
            var7.method2392(var4, var3);
            var7.method2392(var5, var6);
            return var7;
         } else {
            var7 = var1.method2368(!var4.method2360(var3));
            var7.method2392(var4, var3);
            return var7;
         }
      }
   }
}

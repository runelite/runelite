package net.runelite.rs.client;
import java.io.EOFException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("p")
public class class19 {
   @ObfuscatedName("i")
   boolean[] field270;
   @ObfuscatedName("f")
   int[] field271;
   @ObfuscatedName("m")
   String[] field272;
   @ObfuscatedName("a")
   boolean[] field274;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = 3596488678564000329L
   )
   long field278;
   @ObfuscatedName("kx")
   @ObfuscatedGetter(
      intValue = -939991725
   )
   static int field279;
   @ObfuscatedName("o")
   boolean field281 = false;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = 1669176611
   )
   static int field282;

   @ObfuscatedName("j")
   void method200(int var1, int var2) {
      this.field271[var1] = var2;
      if(this.field274[var1]) {
         this.field281 = true;
      }

   }

   @ObfuscatedName("a")
   void method202(int var1, String var2) {
      this.field272[var1] = var2;
      if(this.field270[var1]) {
         this.field281 = true;
      }

   }

   @ObfuscatedName("i")
   String method203(int var1) {
      return this.field272[var1];
   }

   @ObfuscatedName("h")
   void method204() {
      class226 var1 = this.method205(false);

      try {
         byte[] var2 = new byte[(int)var1.method4067()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var1.method4068(var2, var3, var2.length - var3);
            if(-1 == var4) {
               throw new EOFException();
            }
         }

         class118 var23 = new class118(var2);
         if(var23.field1995.length - var23.field1998 < 1) {
            return;
         }

         int var5 = var23.method2453();
         if(var5 < 0 || var5 > 1) {
            return;
         }

         int var6 = var23.method2455();

         int var7;
         int var8;
         int var9;
         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var23.method2455();
            var9 = var23.method2458();
            if(this.field274[var8]) {
               this.field271[var8] = var9;
            }
         }

         var7 = var23.method2455();

         for(var8 = 0; var8 < var7; ++var8) {
            var9 = var23.method2455();
            String var10 = var23.method2461();
            if(this.field270[var9]) {
               this.field272[var9] = var10;
            }
         }
      } catch (Exception var21) {
         ;
      } finally {
         try {
            var1.method4069();
         } catch (Exception var20) {
            ;
         }

      }

      this.field281 = false;
   }

   @ObfuscatedName("m")
   class226 method205(boolean var1) {
      return class0.method1("2", client.field350.field2295, var1);
   }

   @ObfuscatedName("f")
   void method208() {
      int var1;
      for(var1 = 0; var1 < this.field271.length; ++var1) {
         if(!this.field274[var1]) {
            this.field271[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.field272.length; ++var1) {
         if(!this.field270[var1]) {
            this.field272[var1] = null;
         }
      }

   }

   @ObfuscatedName("k")
   boolean method209() {
      return this.field281;
   }

   @ObfuscatedName("bb")
   static final void method212(int var0, int var1) {
      int var2 = class1.field28.method3962("Choose Option");

      int var3;
      int var4;
      for(var3 = 0; var3 < client.field430; ++var3) {
         var4 = class1.field28.method3962(class38.method762(var3));
         if(var4 > var2) {
            var2 = var4;
         }
      }

      var2 += 8;
      var3 = client.field430 * 15 + 22;
      var4 = var0 - var2 / 2;
      if(var2 + var4 > class142.field2190) {
         var4 = class142.field2190 - var2;
      }

      if(var4 < 0) {
         var4 = 0;
      }

      int var5 = var1;
      if(var3 + var1 > class89.field1566) {
         var5 = class89.field1566 - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      client.field308 = true;
      class136.field2114 = var4;
      class75.field1387 = var5;
      class74.field1373 = var2;
      client.field429 = 22 + client.field430 * 15;
   }

   @ObfuscatedName("o")
   void method213() {
      class226 var1 = this.method205(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field271.length; ++var4) {
            if(this.field274[var4] && this.field271[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.field272.length; ++var5) {
            if(this.field270[var5] && this.field272[var5] != null) {
               var2 += 2 + class36.method742(this.field272[var5]);
               ++var4;
            }
         }

         class118 var17 = new class118(var2);
         var17.method2438(1);
         var17.method2541(var3);

         int var6;
         for(var6 = 0; var6 < this.field271.length; ++var6) {
            if(this.field274[var6] && -1 != this.field271[var6]) {
               var17.method2541(var6);
               var17.method2441(this.field271[var6]);
            }
         }

         var17.method2541(var4);

         for(var6 = 0; var6 < this.field272.length; ++var6) {
            if(this.field270[var6] && null != this.field272[var6]) {
               var17.method2541(var6);
               var17.method2444(this.field272[var6]);
            }
         }

         var1.method4061(var17.field1995, 0, var17.field1998);
      } catch (Exception var15) {
         ;
      } finally {
         try {
            var1.method4069();
         } catch (Exception var14) {
            ;
         }

      }

      this.field281 = false;
      this.field278 = class109.method2381();
   }

   @ObfuscatedName("l")
   int method216(int var1) {
      return this.field271[var1];
   }

   class19() {
      this.field271 = new int[class115.field1978.method3224(19)];
      this.field272 = new String[class115.field1978.method3224(15)];
      this.field274 = new boolean[this.field271.length];

      int var1;
      for(var1 = 0; var1 < this.field271.length; ++var1) {
         class45 var2 = client.method463(var1);
         this.field274[var1] = var2.field1040;
      }

      this.field270 = new boolean[this.field272.length];

      for(var1 = 0; var1 < this.field272.length; ++var1) {
         class49 var3 = class76.method1653(var1);
         this.field270[var1] = var3.field1090;
      }

      for(var1 = 0; var1 < this.field271.length; ++var1) {
         this.field271[var1] = -1;
      }

      this.method204();
   }

   @ObfuscatedName("n")
   void method222() {
      if(this.field281 && this.field278 < class109.method2381() - 60000L) {
         this.method213();
      }

   }

   @ObfuscatedName("bi")
   static final void method230(int var0, int var1) {
      if(client.field430 >= 2 || client.field301 != 0 || client.field408) {
         String var2;
         if(1 == client.field301 && client.field430 < 2) {
            var2 = "Use" + " " + client.field442 + " " + "->";
         } else if(client.field408 && client.field430 < 2) {
            var2 = client.field446 + " " + client.field447 + " " + "->";
         } else {
            var2 = class38.method762(client.field430 - 1);
         }

         if(client.field430 > 2) {
            var2 = var2 + class24.method592(16777215) + " " + '/' + " " + (client.field430 - 2) + " more options";
         }

         class1.field28.method4006(var2, 4 + var0, 15 + var1, 16777215, 0, client.field394 / 1000);
      }
   }

   @ObfuscatedName("u")
   static void method232() {
      if(class86.method2051()) {
         class31.field721 = true;
      }

   }

   @ObfuscatedName("l")
   public static int method233(int var0) {
      var0 = (var0 >>> 1 & 1431655765) + (var0 & 1431655765);
      var0 = (var0 & 858993459) + (var0 >>> 2 & 858993459);
      var0 = var0 + (var0 >>> 4) & 252645135;
      var0 += var0 >>> 8;
      var0 += var0 >>> 16;
      return var0 & 255;
   }
}

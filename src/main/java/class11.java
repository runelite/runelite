import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
public class class11 {
   @ObfuscatedName("t")
   static final class200 field185 = new class200();
   @ObfuscatedName("x")
   static final class198 field186 = new class198(1024);
   @ObfuscatedName("w")
   static final Map field188 = new HashMap();
   @ObfuscatedName("mj")
   @ObfuscatedGetter(
      intValue = 440962287
   )
   static int field189;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 25363127
   )
   static int field192 = 0;

   @ObfuscatedName("w")
   public static void method137(class167 var0) {
      class45.field1056 = var0;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1405422426"
   )
   static final void method141(int var0, int var1) {
      if(var0 != class23.field625 || class82.field1429 != var1) {
         class23.field625 = var0;
         class82.field1429 = var1;
         class138.method2937(25);
         class19.method228("Loading - please wait.", true);
         int var2 = class41.field990;
         int var3 = class2.field37;
         class41.field990 = (var0 - 6) * 8;
         class2.field37 = (var1 - 6) * 8;
         int var4 = class41.field990 - var2;
         int var5 = class2.field37 - var3;
         var2 = class41.field990;
         var3 = class2.field37;

         int var6;
         int var8;
         for(var6 = 0; var6 < '耀'; ++var6) {
            class34 var7 = client.field331[var6];
            if(null != var7) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var7.field872[var8] -= var4;
                  var7.field873[var8] -= var5;
               }

               var7.field849 -= 128 * var4;
               var7.field819 -= var5 * 128;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            class2 var18 = client.field415[var6];
            if(var18 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var18.field872[var8] -= var4;
                  var18.field873[var8] -= var5;
               }

               var18.field849 -= var4 * 128;
               var18.field819 -= 128 * var5;
            }
         }

         byte var17 = 0;
         byte var19 = 104;
         byte var20 = 1;
         if(var4 < 0) {
            var17 = 103;
            var19 = -1;
            var20 = -1;
         }

         byte var9 = 0;
         byte var10 = 104;
         byte var11 = 1;
         if(var5 < 0) {
            var9 = 103;
            var10 = -1;
            var11 = -1;
         }

         int var13;
         for(int var12 = var17; var19 != var12; var12 += var20) {
            for(var13 = var9; var13 != var10; var13 += var11) {
               int var14 = var4 + var12;
               int var15 = var5 + var13;

               for(int var16 = 0; var16 < 4; ++var16) {
                  if(var14 >= 0 && var15 >= 0 && var14 < 104 && var15 < 104) {
                     client.field425[var16][var12][var13] = client.field425[var16][var14][var15];
                  } else {
                     client.field425[var16][var12][var13] = null;
                  }
               }
            }
         }

         for(class16 var21 = (class16)client.field482.method3836(); var21 != null; var21 = (class16)client.field482.method3841()) {
            var21.field238 -= var4;
            var21.field239 -= var5;
            if(var21.field238 < 0 || var21.field239 < 0 || var21.field238 >= 104 || var21.field239 >= 104) {
               var21.method3935();
            }
         }

         if(client.field533 != 0) {
            client.field533 -= var4;
            client.field529 -= var5;
         }

         client.field536 = 0;
         client.field542 = false;
         client.field523 = -1;
         client.field478.method3833();
         client.field427.method3833();

         for(var13 = 0; var13 < 4; ++var13) {
            client.field372[var13].method2394();
         }

      }
   }

   @ObfuscatedName("t")
   static void method152() {
      class227 var0 = null;

      try {
         var0 = class104.method2295("", class18.field270.field2311, true);
         class119 var1 = class41.field989.method104();
         var0.method4143(var1.field2012, 0, var1.field2011);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method4130();
         }
      } catch (Exception var2) {
         ;
      }

   }
}

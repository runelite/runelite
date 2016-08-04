import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
public final class class92 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2134031093
   )
   int field1626;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1140542389
   )
   int field1627;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -187436831
   )
   int field1628;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -377942455
   )
   int field1629;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -141799917
   )
   int field1630;
   @ObfuscatedName("s")
   boolean field1631 = true;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1170981507
   )
   int field1632;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;Lclass170;Lclass170;B)V",
      garbageValue = "9"
   )
   public static void method2160(class170 var0, class170 var1, class170 var2, class170 var3) {
      class176.field2798 = var0;
      class176.field2799 = var1;
      class176.field2846 = var2;
      class49.field1113 = var3;
      class176.field2836 = new class176[class176.field2798.method3406()][];
      class176.field2797 = new boolean[class176.field2798.method3406()];
   }

   @ObfuscatedSignature(
      signature = "(IIIIIIZ)V",
      garbageValue = "0"
   )
   class92(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field1629 = var1;
      this.field1628 = var2;
      this.field1627 = var3;
      this.field1626 = var4;
      this.field1630 = var5;
      this.field1632 = var6;
      this.field1631 = var7;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2137452360"
   )
   static final void method2161(int var0, int var1) {
      if(var0 != class48.field1092 || var1 != class16.field242) {
         class48.field1092 = var0;
         class16.field242 = var1;
         class138.method3024(25);
         class9.method131("Loading - please wait.", true);
         int var2 = class0.field11;
         int var3 = class21.field592;
         class0.field11 = (var0 - 6) * 8;
         class21.field592 = (var1 - 6) * 8;
         int var4 = class0.field11 - var2;
         int var5 = class21.field592 - var3;
         var2 = class0.field11;
         var3 = class21.field592;

         int var6;
         int var8;
         for(var6 = 0; var6 < '耀'; ++var6) {
            class36 var17 = client.field332[var6];
            if(var17 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var17.field886[var8] -= var4;
                  var17.field887[var8] -= var5;
               }

               var17.field875 -= 128 * var4;
               var17.field832 -= 128 * var5;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            class2 var21 = client.field302[var6];
            if(var21 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var21.field886[var8] -= var4;
                  var21.field887[var8] -= var5;
               }

               var21.field875 -= 128 * var4;
               var21.field832 -= 128 * var5;
            }
         }

         byte var19 = 0;
         byte var7 = 104;
         byte var20 = 1;
         if(var4 < 0) {
            var19 = 103;
            var7 = -1;
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
         for(int var18 = var19; var7 != var18; var18 += var20) {
            for(var13 = var9; var13 != var10; var13 += var11) {
               int var14 = var18 + var4;
               int var15 = var13 + var5;

               for(int var16 = 0; var16 < 4; ++var16) {
                  if(var14 >= 0 && var15 >= 0 && var14 < 104 && var15 < 104) {
                     client.field426[var16][var18][var13] = client.field426[var16][var14][var15];
                  } else {
                     client.field426[var16][var18][var13] = null;
                  }
               }
            }
         }

         for(class16 var12 = (class16)client.field427.method3980(); null != var12; var12 = (class16)client.field427.method3970()) {
            var12.field238 -= var4;
            var12.field231 -= var5;
            if(var12.field238 < 0 || var12.field231 < 0 || var12.field238 >= 104 || var12.field231 >= 104) {
               var12.method4067();
            }
         }

         if(client.field371 != 0) {
            client.field371 -= var4;
            client.field529 -= var5;
         }

         client.field536 = 0;
         client.field542 = false;
         client.field523 = -1;
         client.field429.method3996();
         client.field428.method3996();

         for(var13 = 0; var13 < 4; ++var13) {
            client.field354[var13].method2493();
         }

      }
   }
}

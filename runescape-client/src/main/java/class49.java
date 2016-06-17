import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public class class49 extends class204 {
   @ObfuscatedName("g")
   public static class193 field1061 = new class193(64);
   @ObfuscatedName("j")
   public boolean field1062 = false;
   @ObfuscatedName("b")
   public static class167 field1066;
   @ObfuscatedName("r")
   static byte[][][] field1067;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "-1966459629"
   )
   public void method997(class119 var1) {
      while(true) {
         int var2 = var1.method2514();
         if(var2 == 0) {
            return;
         }

         this.method998(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-1795732625"
   )
   void method998(class119 var1, int var2) {
      if(var2 == 2) {
         this.field1062 = true;
      }

   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "475830183"
   )
   static final void method1006(int var0, int var1) {
      if(var0 != class153.field2265 || client.field371 != var1) {
         class153.field2265 = var0;
         client.field371 = var1;
         class43.method919(25);
         class47.method972("Loading - please wait.", true);
         int var2 = class4.field62;
         int var3 = class85.field1434;
         class4.field62 = (var0 - 6) * 8;
         class85.field1434 = (var1 - 6) * 8;
         int var4 = class4.field62 - var2;
         int var5 = class85.field1434 - var3;
         var2 = class4.field62;
         var3 = class85.field1434;

         int var6;
         int var8;
         for(var6 = 0; var6 < '耀'; ++var6) {
            class34 var7 = client.field326[var6];
            if(null != var7) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var7.field844[var8] -= var4;
                  var7.field831[var8] -= var5;
               }

               var7.field813 -= var4 * 128;
               var7.field791 -= 128 * var5;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            class2 var20 = client.field410[var6];
            if(null != var20) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var20.field844[var8] -= var4;
                  var20.field831[var8] -= var5;
               }

               var20.field813 -= 128 * var4;
               var20.field791 -= 128 * var5;
            }
         }

         byte var19 = 0;
         byte var18 = 104;
         byte var21 = 1;
         if(var4 < 0) {
            var19 = 103;
            var18 = -1;
            var21 = -1;
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
         for(int var17 = var19; var18 != var17; var17 += var21) {
            for(var13 = var9; var10 != var13; var13 += var11) {
               int var14 = var17 + var4;
               int var15 = var5 + var13;

               for(int var16 = 0; var16 < 4; ++var16) {
                  if(var14 >= 0 && var15 >= 0 && var14 < 104 && var15 < 104) {
                     client.field420[var16][var17][var13] = client.field420[var16][var14][var15];
                  } else {
                     client.field420[var16][var17][var13] = null;
                  }
               }
            }
         }

         for(class16 var12 = (class16)client.field421.method3844(); null != var12; var12 = (class16)client.field421.method3834()) {
            var12.field225 -= var4;
            var12.field223 -= var5;
            if(var12.field225 < 0 || var12.field223 < 0 || var12.field225 >= 104 || var12.field223 >= 104) {
               var12.method3916();
            }
         }

         if(client.field521 != 0) {
            client.field521 -= var4;
            client.field522 -= var5;
         }

         client.field504 = 0;
         client.field535 = false;
         client.field303 = -1;
         client.field423.method3823();
         client.field422.method3823();

         for(var13 = 0; var13 < 4; ++var13) {
            client.field291[var13].method2419();
         }

      }
   }
}

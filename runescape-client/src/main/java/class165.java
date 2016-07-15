import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public final class class165 {
   @ObfuscatedName("e")
   public static final char[] field2687 = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass125;I)V",
      garbageValue = "-1775204667"
   )
   static final void method3279(class125 var0) {
      var0.method2878();
      int var1 = client.field417;
      class2 var2 = class118.field2035 = client.field467[var1] = new class2();
      var2.field39 = var1;
      int var3 = var0.method2859(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.field885[0] = var5 - class19.field286;
      var2.field896 = (var2.field885[0] << 7) + (var2.method7() << 6);
      var2.field906[0] = var6 - class6.field128;
      var2.field879 = (var2.field906[0] << 7) + (var2.method7() << 6);
      var2.field57 = var4 * -739681195;
      class50.field1119 = var4;
      if(class34.field798[var1] != null) {
         var2.method22(class34.field798[var1]);
      }

      class34.field804 = 0;
      class34.field807[++class34.field804 - 1] = var1;
      class34.field801[var1] = 0;
      class34.field802 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var7 != var1) {
            int var8 = var0.method2859(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 255;
            int var11 = var8 & 255;
            class34.field803[var7] = (var9 << 28) + (var10 << 14) + var11;
            class34.field800[var7] = 0;
            class34.field805[var7] = -1;
            class34.field810[++class34.field802 - 1] = var7;
            class34.field801[var7] = 0;
         }
      }

      var0.method2860();
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1543002142"
   )
   static final void method3280(int var0, int var1) {
      if(var0 != class13.field215 || var1 != class32.field751) {
         class13.field215 = var0;
         class32.field751 = var1;
         class92.method2179(25);
         class96.method2260("Loading - please wait.", true);
         int var2 = class19.field286;
         int var3 = class6.field128;
         class19.field286 = (var0 - 6) * 8;
         class6.field128 = (var1 - 6) * 8;
         int var4 = class19.field286 - var2;
         int var5 = class6.field128 - var3;
         var2 = class19.field286;
         var3 = class6.field128;

         int var6;
         int var8;
         for(var6 = 0; var6 < '耀'; ++var6) {
            class36 var7 = client.field331[var6];
            if(null != var7) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var7.field885[var8] -= var4;
                  var7.field906[var8] -= var5;
               }

               var7.field896 -= var4 * 128;
               var7.field879 -= 128 * var5;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            class2 var20 = client.field467[var6];
            if(null != var20) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var20.field885[var8] -= var4;
                  var20.field906[var8] -= var5;
               }

               var20.field896 -= var4 * 128;
               var20.field879 -= var5 * 128;
            }
         }

         byte var19 = 0;
         byte var17 = 104;
         byte var21 = 1;
         if(var4 < 0) {
            var19 = 103;
            var17 = -1;
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
         for(int var12 = var19; var17 != var12; var12 += var21) {
            for(var13 = var9; var13 != var10; var13 += var11) {
               int var14 = var4 + var12;
               int var15 = var13 + var5;

               for(int var16 = 0; var16 < 4; ++var16) {
                  if(var14 >= 0 && var15 >= 0 && var14 < 104 && var15 < 104) {
                     client.field426[var16][var12][var13] = client.field426[var16][var14][var15];
                  } else {
                     client.field426[var16][var12][var13] = null;
                  }
               }
            }
         }

         for(class16 var18 = (class16)client.field427.method3899(); var18 != null; var18 = (class16)client.field427.method3918()) {
            var18.field232 -= var4;
            var18.field242 -= var5;
            if(var18.field232 < 0 || var18.field242 < 0 || var18.field232 >= 104 || var18.field242 >= 104) {
               var18.method4000();
            }
         }

         if(client.field529 != 0) {
            client.field529 -= var4;
            client.field530 -= var5;
         }

         client.field535 = 0;
         client.field543 = false;
         client.field554 = -1;
         client.field429.method3917();
         client.field428.method3917();

         for(var13 = 0; var13 < 4; ++var13) {
            client.field407[var13].method2486();
         }

      }
   }
}

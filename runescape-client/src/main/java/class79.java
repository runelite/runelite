import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
public class class79 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1884839595
   )
   public static int field1419;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1877983423
   )
   static int field1420;
   @ObfuscatedName("z")
   public static int[] field1421;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 286699841
   )
   public static int field1422;
   @ObfuscatedName("i")
   public static int[] field1423;
   @ObfuscatedName("l")
   public static int[] field1424;
   @ObfuscatedName("m")
   public static int[] field1425;

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-105"
   )
   static final void method1708() {
      class75.method1606(Client.field494);
      ++class14.field211;
      if(Client.field460 && Client.field457) {
         int var0 = class143.field2204;
         int var1 = class143.field2210;
         var0 -= Client.field454;
         var1 -= Client.field455;
         if(var0 < Client.field310) {
            var0 = Client.field310;
         }

         if(Client.field494.width + var0 > Client.field310 + Client.field453.width) {
            var0 = Client.field310 + Client.field453.width - Client.field494.width;
         }

         if(var1 < Client.field459) {
            var1 = Client.field459;
         }

         if(var1 + Client.field494.height > Client.field459 + Client.field453.height) {
            var1 = Client.field459 + Client.field453.height - Client.field494.height;
         }

         int var2 = var0 - Client.field298;
         int var3 = var1 - Client.field462;
         int var4 = Client.field494.field2928;
         if(class14.field211 > Client.field494.field2887 && (var2 > var4 || var2 < -var4 || var3 > var4 || var3 < -var4)) {
            Client.field548 = true;
         }

         int var5 = Client.field453.itemId + (var0 - Client.field310);
         int var6 = Client.field453.scrollY + (var1 - Client.field459);
         class0 var7;
         if(Client.field494.field2899 != null && Client.field548) {
            var7 = new class0();
            var7.field7 = Client.field494;
            var7.field3 = var5;
            var7.field4 = var6;
            var7.field8 = Client.field494.field2899;
            class158.method3201(var7, 200000);
         }

         if(class143.field2203 == 0) {
            if(Client.field548) {
               if(Client.field494.field2868 != null) {
                  var7 = new class0();
                  var7.field7 = Client.field494;
                  var7.field3 = var5;
                  var7.field4 = var6;
                  var7.field6 = Client.field456;
                  var7.field8 = Client.field494.field2868;
                  class158.method3201(var7, 200000);
               }

               if(Client.field456 != null) {
                  Widget var14 = Client.field494;
                  int var10 = class132.method2880(var14);
                  int var15 = var10 >> 17 & 7;
                  int var11 = var15;
                  if(var15 == 0) {
                     var7 = null;
                  } else {
                     int var12 = 0;

                     while(true) {
                        if(var12 >= var11) {
                           break;
                        }

                        var14 = World.method628(var14.parentId);
                        if(var14 == null) {
                           var7 = null;
                           break;
                        }

                        ++var12;
                     }
                  }
               }
            } else if((Client.field508 == 1 || class38.method738(Client.menuOptionCount - 1)) && Client.menuOptionCount > 2) {
               BufferProvider.method1725(Client.field298 + Client.field454, Client.field455 + Client.field462);
            } else if(Client.menuOptionCount > 0) {
               int var13 = Client.field298 + Client.field454;
               int var8 = Client.field462 + Client.field455;
               class32 var9 = class59.field1242;
               class143.menuAction(var9.field715, var9.field713, var9.field714, var9.field717, var9.field716, var9.field716, var13, var8);
               class59.field1242 = null;
            }

            Client.field494 = null;
         }

      } else {
         if(class14.field211 > 1) {
            Client.field494 = null;
         }

      }
   }
}

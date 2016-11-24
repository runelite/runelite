import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
public class class108 {
   @ObfuscatedName("cs")
   static class102 field1736;
   @ObfuscatedName("z")
   static class228 field1740;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "304974020"
   )
   static int method2087(int var0, int var1) {
      long var2 = (long)(var1 + (var0 << 16));
      return null != class162.field2308 && class162.field2308.hash == var2?PlayerComposition.field2046.offset * 99 / (PlayerComposition.field2046.payload.length - class162.field2308.field2705) + 1:0;
   }

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "(LWidget;IIB)V",
      garbageValue = "-55"
   )
   static final void method2088(Widget var0, int var1, int var2) {
      if(Client.field383 == null && !Client.isMenuOpen) {
         if(null != var0) {
            Widget var5 = var0;
            int var8 = class193.method3586(class185.method3463(var0));
            Widget var4;
            int var7;
            if(var8 == 0) {
               var4 = null;
            } else {
               var7 = 0;

               while(true) {
                  if(var7 >= var8) {
                     var4 = var5;
                     break;
                  }

                  var5 = class5.method79(var5.parentId);
                  if(var5 == null) {
                     var4 = null;
                     break;
                  }

                  ++var7;
               }
            }

            Widget var6 = var4;
            if(null == var4) {
               var6 = var0.parent;
            }

            if(var6 != null) {
               Client.field383 = var0;
               var5 = var0;
               var8 = class193.method3586(class185.method3463(var0));
               if(var8 == 0) {
                  var4 = null;
               } else {
                  var7 = 0;

                  while(true) {
                     if(var7 >= var8) {
                        var4 = var5;
                        break;
                     }

                     var5 = class5.method79(var5.parentId);
                     if(var5 == null) {
                        var4 = null;
                        break;
                     }

                     ++var7;
                  }
               }

               var6 = var4;
               if(null == var4) {
                  var6 = var0.parent;
               }

               Client.field340 = var6;
               Client.field507 = var1;
               Client.field461 = var2;
               GroundObject.field1289 = 0;
               Client.field469 = false;
               if(Client.menuOptionCount > 0) {
                  int var9 = Client.menuOptionCount - 1;
                  class2.field19 = new class38();
                  class2.field19.field798 = Client.menuActionParams0[var9];
                  class2.field19.field791 = Client.menuActionParams1[var9];
                  class2.field19.field792 = Client.menuTypes[var9];
                  class2.field19.field793 = Client.menuIdentifiers[var9];
                  class2.field19.field790 = Client.menuOptions[var9];
               }

               return;
            }
         }

      }
   }
}

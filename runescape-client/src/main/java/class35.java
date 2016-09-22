import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class35 {
   @ObfuscatedName("d")
   static final class35 field795 = new class35();
   @ObfuscatedName("bg")
   static class171 field796;
   @ObfuscatedName("v")
   static final class35 field797 = new class35();
   @ObfuscatedName("r")
   static final class35 field798 = new class35();
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2070907595
   )
   public static int field800;
   @ObfuscatedName("gr")
   static Widget field801;
   @ObfuscatedName("a")
   static final class35 field802 = new class35();
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = 1724157801
   )
   static int field807;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1010391625"
   )
   public static void method747() {
      class79.field1462 = null;
      class79.field1458 = null;
      class59.field1268 = null;
      class79.field1461 = null;
      class132.field2126 = null;
      class8.field139 = null;
   }

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   static final void method748(int var0) {
      SecondaryBufferProvider.method1683();

      for(class24 var1 = (class24)class24.field629.method3854(); var1 != null; var1 = (class24)class24.field629.method3869()) {
         if(var1.field623 != null) {
            var1.method596();
         }
      }

      int var4 = PlayerComposition.method3517(var0).field1236;
      if(var4 != 0) {
         int var2 = class179.widgetSettings[var0];
         if(var4 == 1) {
            if(var2 == 1) {
               class94.method2162(0.9D);
               ((TextureProvider)class94.field1672).method2221(0.9D);
            }

            if(var2 == 2) {
               class94.method2162(0.8D);
               ((TextureProvider)class94.field1672).method2221(0.8D);
            }

            if(var2 == 3) {
               class94.method2162(0.7D);
               ((TextureProvider)class94.field1672).method2221(0.7D);
            }

            if(var2 == 4) {
               class94.method2162(0.6D);
               ((TextureProvider)class94.field1672).method2221(0.6D);
            }

            ItemComposition.itemSpriteCache.reset();
         }

         if(var4 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(Client.field517 != var3) {
               if(Client.field517 == 0 && Client.field496 != -1) {
                  class50.method1046(class8.field140, Client.field496, 0, var3, false);
                  Client.field426 = false;
               } else if(var3 == 0) {
                  class186.field3015.method3671();
                  class186.field3016 = 1;
                  class186.field3017 = null;
                  Client.field426 = false;
               } else if(class186.field3016 != 0) {
                  class177.field2951 = var3;
               } else {
                  class186.field3015.method3642(var3);
               }

               Client.field517 = var3;
            }
         }

         if(var4 == 4) {
            if(var2 == 0) {
               Client.field520 = 127;
            }

            if(var2 == 1) {
               Client.field520 = 96;
            }

            if(var2 == 2) {
               Client.field520 = 64;
            }

            if(var2 == 3) {
               Client.field520 = 32;
            }

            if(var2 == 4) {
               Client.field520 = 0;
            }
         }

         if(var4 == 5) {
            Client.field341 = var2;
         }

         if(var4 == 6) {
            Client.field536 = var2;
         }

         if(var4 == 9) {
            Client.field400 = var2;
         }

         if(var4 == 10) {
            if(var2 == 0) {
               Client.field414 = 127;
            }

            if(var2 == 1) {
               Client.field414 = 96;
            }

            if(var2 == 2) {
               Client.field414 = 64;
            }

            if(var2 == 3) {
               Client.field414 = 32;
            }

            if(var2 == 4) {
               Client.field414 = 0;
            }
         }

         if(var4 == 17) {
            Client.field418 = var2 & '\uffff';
         }

         if(var4 == 18) {
            Client.field306 = (class21)class54.method1117(WallObject.method2110(), var2);
            if(null == Client.field306) {
               Client.field306 = class21.field587;
            }
         }

         if(var4 == 19) {
            if(var2 == -1) {
               Client.field555 = -1;
            } else {
               Client.field555 = var2 & 2047;
            }
         }

         if(var4 == 22) {
            Client.field307 = (class21)class54.method1117(WallObject.method2110(), var2);
            if(null == Client.field307) {
               Client.field307 = class21.field587;
            }
         }

      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "1313786796"
   )
   public static String method749(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && var4 != 46 && var4 != 45 && var4 != 42 && var4 != 95) {
            if(var4 == 32) {
               var2.append('+');
            } else {
               byte var5 = ItemComposition.method1174(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }
}

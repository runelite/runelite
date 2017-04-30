import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class167 {
   @ObfuscatedName("c")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("n")
   @Export("widgetSettings")
   public static int[] widgetSettings;
   @ObfuscatedName("d")
   static int[] field2175;

   static {
      field2175 = new int[32];
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2175[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }

   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1683600458"
   )
   static final void method3139(int var0) {
      class130.method2606();

      for(class31 var1 = (class31)class31.field709.method2828(); var1 != null; var1 = (class31)class31.field709.method2830()) {
         if(var1.field711 != null) {
            var1.method653();
         }
      }

      int var4 = RSSocket.method2096(var0).field2785;
      if(var4 != 0) {
         int var2 = widgetSettings[var0];
         if(var4 == 1) {
            if(var2 == 1) {
               class84.method1651(0.9D);
               ((TextureProvider)class84.field1437).method1446(0.9D);
            }

            if(var2 == 2) {
               class84.method1651(0.8D);
               ((TextureProvider)class84.field1437).method1446(0.8D);
            }

            if(var2 == 3) {
               class84.method1651(0.7D);
               ((TextureProvider)class84.field1437).method1446(0.7D);
            }

            if(var2 == 4) {
               class84.method1651(0.6D);
               ((TextureProvider)class84.field1437).method1446(0.6D);
            }

            MessageNode.method222();
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

            if(var3 != Client.field501) {
               if(Client.field501 == 0 && Client.field524 != -1) {
                  Script.method911(class18.indexTrack1, Client.field524, 0, var3, false);
                  Client.field525 = false;
               } else if(var3 == 0) {
                  MessageNode.method218();
                  Client.field525 = false;
               } else {
                  FloorUnderlayDefinition.method3492(var3);
               }

               Client.field501 = var3;
            }
         }

         if(var4 == 4) {
            if(var2 == 0) {
               Client.field551 = 127;
            }

            if(var2 == 1) {
               Client.field551 = 96;
            }

            if(var2 == 2) {
               Client.field551 = 64;
            }

            if(var2 == 3) {
               Client.field551 = 32;
            }

            if(var2 == 4) {
               Client.field551 = 0;
            }
         }

         if(var4 == 5) {
            Client.field421 = var2;
         }

         if(var4 == 6) {
            Client.field447 = var2;
         }

         if(var4 == 9) {
            Client.field448 = var2;
         }

         if(var4 == 10) {
            if(var2 == 0) {
               Client.field527 = 127;
            }

            if(var2 == 1) {
               Client.field527 = 96;
            }

            if(var2 == 2) {
               Client.field527 = 64;
            }

            if(var2 == 3) {
               Client.field527 = 32;
            }

            if(var2 == 4) {
               Client.field527 = 0;
            }
         }

         if(var4 == 17) {
            Client.field310 = var2 & '\uffff';
         }

         class40[] var5;
         if(var4 == 18) {
            var5 = new class40[]{class40.field809, class40.field807, class40.field805, class40.field806};
            Client.field306 = (class40)class32.method708(var5, var2);
            if(Client.field306 == null) {
               Client.field306 = class40.field809;
            }
         }

         if(var4 == 19) {
            if(var2 == -1) {
               Client.field472 = -1;
            } else {
               Client.field472 = var2 & 2047;
            }
         }

         if(var4 == 22) {
            var5 = new class40[]{class40.field809, class40.field807, class40.field805, class40.field806};
            Client.field307 = (class40)class32.method708(var5, var2);
            if(Client.field307 == null) {
               Client.field307 = class40.field809;
            }
         }

      }
   }

   class167() throws Throwable {
      throw new Error();
   }
}

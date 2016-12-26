import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class47 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -727879805
   )
   static int field939 = 0;
   @ObfuscatedName("f")
   static final class136 field940 = new class136();
   @ObfuscatedName("i")
   @Export("chatLineMap")
   static final Map chatLineMap = new HashMap();
   @ObfuscatedName("e")
   static final class121 field944 = new class121(1024);
   @ObfuscatedName("bq")
   static class184 field947;

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1701554592"
   )
   static final void method835(int var0) {
      class156.method2961();

      for(class31 var4 = (class31)class31.field706.method2359(); var4 != null; var4 = (class31)class31.field706.method2361()) {
         if(var4.field712 != null) {
            var4.method637();
         }
      }

      int var1 = class41.method751(var0).field2778;
      if(var1 != 0) {
         int var2 = class165.widgetSettings[var0];
         if(var1 == 1) {
            if(var2 == 1) {
               class84.method1667(0.9D);
               ((TextureProvider)class84.field1450).method1414(0.9D);
            }

            if(var2 == 2) {
               class84.method1667(0.8D);
               ((TextureProvider)class84.field1450).method1414(0.8D);
            }

            if(var2 == 3) {
               class84.method1667(0.7D);
               ((TextureProvider)class84.field1450).method1414(0.7D);
            }

            if(var2 == 4) {
               class84.method1667(0.6D);
               ((TextureProvider)class84.field1450).method1414(0.6D);
            }

            ItemComposition.itemSpriteCache.reset();
         }

         if(var1 == 3) {
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

            if(var3 != Client.field373) {
               if(Client.field373 == 0 && Client.field414 != -1) {
                  class116.method2199(class204.field3079, Client.field414, 0, var3, false);
                  Client.field525 = false;
               } else if(var3 == 0) {
                  class172.method3180();
                  Client.field525 = false;
               } else {
                  class165.method3060(var3);
               }

               Client.field373 = var3;
            }
         }

         if(var1 == 4) {
            if(var2 == 0) {
               Client.field482 = 127;
            }

            if(var2 == 1) {
               Client.field482 = 96;
            }

            if(var2 == 2) {
               Client.field482 = 64;
            }

            if(var2 == 3) {
               Client.field482 = 32;
            }

            if(var2 == 4) {
               Client.field482 = 0;
            }
         }

         if(var1 == 5) {
            Client.field426 = var2;
         }

         if(var1 == 6) {
            Client.field448 = var2;
         }

         if(var1 == 9) {
            Client.field449 = var2;
         }

         if(var1 == 10) {
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

         if(var1 == 17) {
            Client.field454 = var2 & '\uffff';
         }

         if(var1 == 18) {
            Client.field309 = (class40)XItemContainer.method161(Overlay.method3675(), var2);
            if(null == Client.field309) {
               Client.field309 = class40.field817;
            }
         }

         if(var1 == 19) {
            if(var2 == -1) {
               Client.field418 = -1;
            } else {
               Client.field418 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            Client.field310 = (class40)XItemContainer.method161(Overlay.method3675(), var2);
            if(Client.field310 == null) {
               Client.field310 = class40.field817;
            }
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LWorld;I)V",
      garbageValue = "-2039460992"
   )
   @Export("selectWorld")
   static void selectWorld(World var0) {
      if(var0.method591() != Client.isMembers) {
         Client.isMembers = var0.method591();
         boolean var1 = var0.method591();
         if(CombatInfoListHolder.isMembersWorld != var1) {
            ItemComposition.field2949.reset();
            ItemComposition.itemModelCache.reset();
            ItemComposition.itemSpriteCache.reset();
            CombatInfoListHolder.isMembersWorld = var1;
         }
      }

      class5.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      class9.field87 = Client.field287 == 0?'ꩊ':'鱀' + var0.id;
      class7.field66 = Client.field287 == 0?443:'썐' + var0.id;
      class167.field2189 = class9.field87;
   }
}

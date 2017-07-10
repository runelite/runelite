import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public class class20 {
   @ObfuscatedName("z")
   public static class112 field335;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1506651483
   )
   static int field338;
   @ObfuscatedName("cl")
   static class153 field339;

   @ObfuscatedName("je")
   @ObfuscatedSignature(
      signature = "(LWidget;II)Ljava/lang/String;",
      garbageValue = "677622988"
   )
   static String method140(Widget var0, int var1) {
      int var3 = WorldMapType3.method199(var0);
      boolean var2 = (var3 >> var1 + 1 & 1) != 0;
      return !var2 && var0.field2754 == null?null:(var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0?var0.actions[var1]:null);
   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "-1622749885"
   )
   static final void method141(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.hasScript || !class39.method555(var3))) {
            int var5;
            if(var3.type == 0) {
               if(!var3.hasScript && class39.method555(var3) && var3 != KitDefinition.field3371) {
                  continue;
               }

               method141(var0, var3.id);
               if(var3.children != null) {
                  method141(var3.children, var3.id);
               }

               WidgetNode var7 = (WidgetNode)Client.componentTable.method3530((long)var3.id);
               if(var7 != null) {
                  var5 = var7.id;
                  if(class66.method1121(var5)) {
                     method141(class46.widgets[var5], -1);
                  }
               }
            }

            if(var3.type == 6) {
               if(var3.field2717 != -1 || var3.field2702 != -1) {
                  boolean var4 = WorldMapData.method272(var3);
                  if(var4) {
                     var5 = var3.field2702;
                  } else {
                     var5 = var3.field2717;
                  }

                  if(var5 != -1) {
                     Sequence var6 = class224.getAnimation(var5);

                     for(var3.field2777 += Client.field1002; var3.field2777 > var6.frameLenghts[var3.field2788]; class88.method1714(var3)) {
                        var3.field2777 -= var6.frameLenghts[var3.field2788];
                        ++var3.field2788;
                        if(var3.field2788 >= var6.frameIDs.length) {
                           var3.field2788 -= var6.frameStep;
                           if(var3.field2788 < 0 || var3.field2788 >= var6.frameIDs.length) {
                              var3.field2788 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2710 != 0 && !var3.hasScript) {
                  int var8 = var3.field2710 >> 16;
                  var5 = var3.field2710 << 16 >> 16;
                  var8 *= Client.field1002;
                  var5 *= Client.field1002;
                  var3.rotationX = var3.rotationX + var8 & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  class88.method1714(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "59779852"
   )
   static void method142() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         if(class54.method815(Client.menuTypes[var0])) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var1 = var0; var1 < Client.menuOptionCount - 1; ++var1) {
                  Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
                  Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
                  Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
                  Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
                  Client.menuActionParams0[var1] = Client.menuActionParams0[var1 + 1];
                  Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "-1827777944"
   )
   static final void method143(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 324) {
         if(Client.field1038 == -1) {
            Client.field1038 = var0.spriteId;
            Client.field1200 = var0.field2690;
         }

         if(Client.field1198.isFemale) {
            var0.spriteId = Client.field1038;
         } else {
            var0.spriteId = Client.field1200;
         }

      } else if(var1 == 325) {
         if(Client.field1038 == -1) {
            Client.field1038 = var0.spriteId;
            Client.field1200 = var0.field2690;
         }

         if(Client.field1198.isFemale) {
            var0.spriteId = Client.field1200;
         } else {
            var0.spriteId = Client.field1038;
         }

      } else if(var1 == 327) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 0;
      } else if(var1 == 328) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 1;
      }
   }
}

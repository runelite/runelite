import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
public class class53 extends CacheableNode {
   @ObfuscatedName("z")
   static NodeCache field1119 = new NodeCache(64);
   @ObfuscatedName("t")
   public boolean field1121 = false;
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      intValue = 875291655
   )
   static int field1122;
   @ObfuscatedName("s")
   public static class170 field1125;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-1379391661"
   )
   public static final boolean method1045(String var0, String var1, String var2, String var3) {
      return null != var0 && null != var2?(!var0.startsWith("#") && !var2.startsWith("#")?var1.equals(var3):var0.equals(var2)):false;
   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(LWidget;IIB)V",
      garbageValue = "24"
   )
   static void method1050(Widget var0, int var1, int var2) {
      if(var0.field2803 == 0) {
         var0.relativeX = var0.field2807;
      } else if(var0.field2803 == 1) {
         var0.relativeX = var0.field2807 + (var1 - var0.width) / 2;
      } else if(var0.field2803 == 2) {
         var0.relativeX = var1 - var0.width - var0.field2807;
      } else if(var0.field2803 == 3) {
         var0.relativeX = var0.field2807 * var1 >> 14;
      } else if(var0.field2803 == 4) {
         var0.relativeX = (var1 * var0.field2807 >> 14) + (var1 - var0.width) / 2;
      } else {
         var0.relativeX = var1 - var0.width - (var1 * var0.field2807 >> 14);
      }

      if(var0.field2804 == 0) {
         var0.relativeY = var0.field2808;
      } else if(var0.field2804 == 1) {
         var0.relativeY = var0.field2808 + (var2 - var0.height) / 2;
      } else if(var0.field2804 == 2) {
         var0.relativeY = var2 - var0.height - var0.field2808;
      } else if(var0.field2804 == 3) {
         var0.relativeY = var2 * var0.field2808 >> 14;
      } else if(var0.field2804 == 4) {
         var0.relativeY = (var2 - var0.height) / 2 + (var0.field2808 * var2 >> 14);
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.field2808 >> 14);
      }

      if(Client.field438 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.width + var0.relativeX > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.height + var0.relativeY > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1384481164"
   )
   void method1053(Buffer var1) {
      while(true) {
         int var2 = var1.method2481();
         if(var2 == 0) {
            return;
         }

         this.method1062(var1, var2);
      }
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "18"
   )
   static final void method1059(int var0, int var1) {
      if(Client.menuOptionCount >= 2 || Client.field421 != 0 || Client.field270) {
         String var2;
         if(Client.field421 == 1 && Client.menuOptionCount < 2) {
            var2 = "Use" + " " + Client.field416 + " " + "->";
         } else if(Client.field270 && Client.menuOptionCount < 2) {
            var2 = Client.field333 + " " + Client.field497 + " " + "->";
         } else {
            int var4 = Client.menuOptionCount - 1;
            String var3;
            if(Client.menuTargets[var4].length() > 0) {
               var3 = Client.menuOptions[var4] + " " + Client.menuTargets[var4];
            } else {
               var3 = Client.menuOptions[var4];
            }

            var2 = var3;
         }

         if(Client.menuOptionCount > 2) {
            var2 = var2 + class188.method3706(16777215) + " " + '/' + " " + (Client.menuOptionCount - 2) + " more options";
         }

         class117.field2001.method4059(var2, var0 + 4, var1 + 15, 16777215, 0, Client.gameCycle / 1000);
      }
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(LWidget;B)V",
      garbageValue = "58"
   )
   static void method1060(Widget var0) {
      Widget var1 = var0.parentId == -1?null:class92.method2078(var0.parentId);
      int var2;
      int var3;
      if(null == var1) {
         var2 = class50.field1069;
         var3 = class139.field2143;
      } else {
         var2 = var1.width;
         var3 = var1.height;
      }

      class1.method6(var0, var2, var3, false);
      method1050(var0, var2, var3);
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "35307486"
   )
   static final void method1061() {
      class26.method600();
      if(null == SecondaryBufferProvider.field1414) {
         if(Client.field441 == null) {
            int var0 = class143.field2198;
            int var1;
            int var2;
            int var3;
            int var4;
            int var5;
            int var6;
            if(Client.isMenuOpen) {
               if(var0 != 1 && (class18.field245 || var0 != 4)) {
                  var1 = class143.field2192;
                  var2 = class143.field2189;
                  if(var1 < Client.menuX - 10 || var1 > 10 + class129.menuWidth + Client.menuX || var2 < class54.menuY - 10 || var2 > 10 + class54.menuY + class192.menuHeight) {
                     Client.isMenuOpen = false;
                     class124.method2745(Client.menuX, class54.menuY, class129.menuWidth, class192.menuHeight);
                  }
               }

               if(var0 == 1 || !class18.field245 && var0 == 4) {
                  var1 = Client.menuX;
                  var2 = class54.menuY;
                  var3 = class129.menuWidth;
                  var4 = class143.field2188;
                  var5 = class143.field2196;
                  var6 = -1;

                  int var7;
                  int var8;
                  for(var7 = 0; var7 < Client.menuOptionCount; ++var7) {
                     var8 = 31 + var2 + 15 * (Client.menuOptionCount - 1 - var7);
                     if(var4 > var1 && var4 < var1 + var3 && var5 > var8 - 13 && var5 < var8 + 3) {
                        var6 = var7;
                     }
                  }

                  if(var6 != -1 && var6 >= 0) {
                     var7 = Client.menuActionParams0[var6];
                     var8 = Client.menuActionParams1[var6];
                     int var9 = Client.menuTypes[var6];
                     int var10 = Client.menuIdentifiers[var6];
                     String var11 = Client.menuOptions[var6];
                     String var12 = Client.menuTargets[var6];
                     class43.menuAction(var7, var8, var9, var10, var11, var12, class143.field2188, class143.field2196);
                  }

                  Client.isMenuOpen = false;
                  class124.method2745(Client.menuX, class54.menuY, class129.menuWidth, class192.menuHeight);
               }
            } else {
               if((var0 == 1 || !class18.field245 && var0 == 4) && Client.menuOptionCount > 0) {
                  var1 = Client.menuTypes[Client.menuOptionCount - 1];
                  if(var1 == 39 || var1 == 40 || var1 == 41 || var1 == 42 || var1 == 43 || var1 == 33 || var1 == 34 || var1 == 35 || var1 == 36 || var1 == 37 || var1 == 38 || var1 == 1005) {
                     var2 = Client.menuActionParams0[Client.menuOptionCount - 1];
                     var3 = Client.menuActionParams1[Client.menuOptionCount - 1];
                     Widget var14 = class92.method2078(var3);
                     if(class175.method3396(class11.method138(var14)) || class20.method532(class11.method138(var14))) {
                        if(null != SecondaryBufferProvider.field1414 && !Client.field356 && Client.field407 != 1 && !class75.method1584(Client.menuOptionCount - 1) && Client.menuOptionCount > 0) {
                           var5 = Client.field384;
                           var6 = Client.field385;
                           class32 var16 = class47.field1022;
                           class43.menuAction(var16.field699, var16.field691, var16.field692, var16.field693, var16.field694, var16.field694, var5, var6);
                           class47.field1022 = null;
                        }

                        Client.field356 = false;
                        Client.field388 = 0;
                        if(null != SecondaryBufferProvider.field1414) {
                           class32.method685(SecondaryBufferProvider.field1414);
                        }

                        SecondaryBufferProvider.field1414 = class92.method2078(var3);
                        Client.field383 = var2;
                        Client.field384 = class143.field2188;
                        Client.field385 = class143.field2196;
                        if(Client.menuOptionCount > 0) {
                           class179.method3455(Client.menuOptionCount - 1);
                        }

                        class32.method685(SecondaryBufferProvider.field1414);
                        return;
                     }
                  }
               }

               if((var0 == 1 || !class18.field245 && var0 == 4) && (Client.field407 == 1 && Client.menuOptionCount > 2 || class75.method1584(Client.menuOptionCount - 1))) {
                  var0 = 2;
               }

               if((var0 == 1 || !class18.field245 && var0 == 4) && Client.menuOptionCount > 0) {
                  var1 = Client.menuOptionCount - 1;
                  if(var1 >= 0) {
                     var2 = Client.menuActionParams0[var1];
                     var3 = Client.menuActionParams1[var1];
                     var4 = Client.menuTypes[var1];
                     var5 = Client.menuIdentifiers[var1];
                     String var15 = Client.menuOptions[var1];
                     String var13 = Client.menuTargets[var1];
                     class43.menuAction(var2, var3, var4, var5, var15, var13, class143.field2188, class143.field2196);
                  }
               }

               if(var0 == 2 && Client.menuOptionCount > 0) {
                  World.method654(class143.field2188, class143.field2196);
               }
            }

         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1470784615"
   )
   void method1062(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field1121 = true;
      }

   }
}

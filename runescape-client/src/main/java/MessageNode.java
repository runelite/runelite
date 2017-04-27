import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1777594287
   )
   @Export("type")
   int type;
   @ObfuscatedName("p")
   @Export("value")
   String value;
   @ObfuscatedName("q")
   @Export("name")
   String name;
   @ObfuscatedName("t")
   @Export("sender")
   String sender;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -563088781
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = 121758141
   )
   @Export("menuWidth")
   static int menuWidth;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1814730153
   )
   @Export("id")
   int id = class122.method2318();

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1431825250"
   )
   void method216(int var1, String var2, String var3, String var4) {
      int var5 = ++class47.field926 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-714669595"
   )
   public static void method218() {
      class159.field2066.method2939();
      class159.field2063 = 1;
      class159.field2067 = null;
   }

   MessageNode(int var1, String var2, String var3, String var4) {
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "25304003"
   )
   static final void method219() {
      Player.method230();
      if(class97.field1627 == null) {
         if(Client.field458 == null) {
            int var0 = class115.field1811;
            int var1;
            int var2;
            int var3;
            int var4;
            int var7;
            int var8;
            int var11;
            if(Client.isMenuOpen) {
               if(var0 != 1 && (CombatInfo1.field662 || var0 != 4)) {
                  var1 = class115.field1805;
                  var2 = class115.field1806;
                  if(var1 < Player.menuX - 10 || var1 > Player.menuX + menuWidth + 10 || var2 < class1.menuY - 10 || var2 > class201.menuHeight + class1.menuY + 10) {
                     Client.isMenuOpen = false;
                     class5.method75(Player.menuX, class1.menuY, menuWidth, class201.menuHeight);
                  }
               }

               if(var0 == 1 || !CombatInfo1.field662 && var0 == 4) {
                  var1 = Player.menuX;
                  var2 = class1.menuY;
                  var3 = menuWidth;
                  var4 = class115.field1802;
                  int var5 = class115.field1813;
                  var11 = -1;

                  for(var7 = 0; var7 < Client.menuOptionCount; ++var7) {
                     var8 = (Client.menuOptionCount - 1 - var7) * 15 + var2 + 31;
                     if(var4 > var1 && var4 < var3 + var1 && var5 > var8 - 13 && var5 < var8 + 3) {
                        var11 = var7;
                     }
                  }

                  if(var11 != -1) {
                     class188.method3431(var11);
                  }

                  Client.isMenuOpen = false;
                  class5.method75(Player.menuX, class1.menuY, menuWidth, class201.menuHeight);
               }
            } else {
               var1 = class114.method2212();
               if((var0 == 1 || !CombatInfo1.field662 && var0 == 4) && var1 >= 0) {
                  var2 = Client.menuTypes[var1];
                  if(var2 == 39 || var2 == 40 || var2 == 41 || var2 == 42 || var2 == 43 || var2 == 33 || var2 == 34 || var2 == 35 || var2 == 36 || var2 == 37 || var2 == 38 || var2 == 1005) {
                     label325: {
                        var3 = Client.menuActionParams0[var1];
                        var4 = Client.menuActionParams1[var1];
                        Widget var9 = class128.method2364(var4);
                        if(!FileOnDisk.method1443(class103.method1988(var9))) {
                           var7 = class103.method1988(var9);
                           boolean var6 = (var7 >> 29 & 1) != 0;
                           if(!var6) {
                              break label325;
                           }
                        }

                        if(class97.field1627 != null && !Client.field400) {
                           var11 = class114.method2212();
                           if(Client.field421 != 1) {
                              boolean var12;
                              if(var11 < 0) {
                                 var12 = false;
                              } else {
                                 var8 = Client.menuTypes[var11];
                                 if(var8 >= 2000) {
                                    var8 -= 2000;
                                 }

                                 if(var8 == 1007) {
                                    var12 = true;
                                 } else {
                                    var12 = false;
                                 }
                              }

                              if(!var12 && Client.menuOptionCount > 0) {
                                 class85.method1716(Client.field540, Client.field398);
                              }
                           }
                        }

                        Client.field400 = false;
                        Client.field404 = 0;
                        if(class97.field1627 != null) {
                           class124.method2350(class97.field1627);
                        }

                        class97.field1627 = class128.method2364(var4);
                        Client.field488 = var3;
                        Client.field540 = class115.field1802;
                        Client.field398 = class115.field1813;
                        if(var1 >= 0) {
                           class109.method2065(var1);
                        }

                        class124.method2350(class97.field1627);
                        return;
                     }
                  }
               }

               if(var0 == 1 || !CombatInfo1.field662 && var0 == 4) {
                  label327: {
                     label311: {
                        boolean var10;
                        if(Client.field421 == 1 && Client.menuOptionCount > 2) {
                           if(Client.menuOptionCount <= 0) {
                              var10 = false;
                           } else if(Client.field432 && class105.field1695[81] && Client.field431 != -1) {
                              var10 = true;
                           } else {
                              var10 = false;
                           }

                           if(!var10) {
                              break label311;
                           }
                        }

                        if(var1 < 0) {
                           var10 = false;
                        } else {
                           var3 = Client.menuTypes[var1];
                           if(var3 >= 2000) {
                              var3 -= 2000;
                           }

                           if(var3 == 1007) {
                              var10 = true;
                           } else {
                              var10 = false;
                           }
                        }

                        if(!var10) {
                           break label327;
                        }
                     }

                     var0 = 2;
                  }
               }

               if((var0 == 1 || !CombatInfo1.field662 && var0 == 4) && Client.menuOptionCount > 0) {
                  class188.method3431(var1);
               }

               if(var0 == 2 && Client.menuOptionCount > 0) {
                  Item.method824(class115.field1802, class115.field1813);
               }
            }

         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "262034889"
   )
   static int method220() {
      return 9;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "36"
   )
   public static void method222() {
      ItemComposition.itemSpriteCache.reset();
   }
}

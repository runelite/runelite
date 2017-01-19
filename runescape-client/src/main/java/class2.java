import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
public class class2 {
   @ObfuscatedName("f")
   public final XGrandExchangeOffer field23;
   @ObfuscatedName("h")
   String field24;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 4488302642263419195L
   )
   public final long field25;
   @ObfuscatedName("iv")
   static class38 field31;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 426398043
   )
   public final int field32;
   @ObfuscatedName("a")
   String field33;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)Ljava/lang/String;",
      garbageValue = "128"
   )
   public String method16() {
      return this.field33;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1139224501"
   )
   public String method17() {
      return this.field24;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass182;B)V",
      garbageValue = "31"
   )
   public static void method23(class182 var0) {
      Varbit.field2857 = var0;
   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIII)V",
      garbageValue = "-65575894"
   )
   static final void method24(Player var0, int var1, int var2, int var3) {
      if(XItemContainer.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            if(var0.field262 == 0) {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + class109.method2000(var0.combatLevel, XItemContainer.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.field262 + ")" + var0.actions[2];
            }

            int var5;
            if(Client.field412 == 1) {
               class214.addMenuEntry("Use", Client.field322 + " " + "->" + " " + Actor.method574(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.field446) {
               if((NPC.field760 & 8) == 8) {
                  class214.addMenuEntry(Client.field449, Client.field450 + " " + "->" + " " + Actor.method574(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(Client.playerOptions[var5] != null) {
                     short var6 = 0;
                     if(Client.playerOptions[var5].equalsIgnoreCase("Attack")) {
                        if(Client.field319 == class40.field806) {
                           continue;
                        }

                        if(class40.field803 == Client.field319 || class40.field805 == Client.field319 && var0.combatLevel > XItemContainer.localPlayer.combatLevel) {
                           var6 = 2000;
                        }

                        if(XItemContainer.localPlayer.team != 0 && var0.team != 0) {
                           if(XItemContainer.localPlayer.team == var0.team) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(Client.playerOptionsPriority[var5]) {
                        var6 = 2000;
                     }

                     boolean var7 = false;
                     int var8 = Client.field418[var5] + var6;
                     class214.addMenuEntry(Client.playerOptions[var5], Actor.method574(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
               if(Client.menuTypes[var5] == 23) {
                  Client.menuTargets[var5] = Actor.method574(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lclass184;",
      garbageValue = "897635369"
   )
   static class184 method25(int var0, boolean var1, boolean var2, boolean var3) {
      class116 var4 = null;
      if(null != class104.field1688) {
         var4 = new class116(var0, class104.field1688, FaceNormal.field1560[var0], 1000000);
      }

      return new class184(var4, class110.field1755, var0, var1, var2, var3);
   }

   class2(Buffer var1, byte var2, int var3) {
      this.field24 = var1.method2911();
      this.field33 = var1.method2911();
      this.field32 = var1.readUnsignedShort();
      this.field25 = var1.method2728();
      int var4 = var1.method2727();
      int var5 = var1.method2727();
      this.field23 = new XGrandExchangeOffer();
      this.field23.method44(2);
      this.field23.method46(var2);
      this.field23.price = var4;
      this.field23.totalQuantity = var5;
      this.field23.quantitySold = 0;
      this.field23.spent = 0;
      this.field23.itemId = var3;
   }

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "5"
   )
   static final void method26(int var0) {
      NPCComposition.method3583();

      for(class31 var1 = (class31)class31.field703.method2330(); null != var1; var1 = (class31)class31.field703.method2346()) {
         if(null != var1.field717) {
            var1.method653();
         }
      }

      class187 var2 = (class187)class187.field2780.get((long)var0);
      class187 var8;
      if(var2 != null) {
         var8 = var2;
      } else {
         byte[] var3 = class187.field2777.method3182(16, var0);
         var2 = new class187();
         if(null != var3) {
            var2.method3334(new Buffer(var3));
         }

         class187.field2780.put(var2, (long)var0);
         var8 = var2;
      }

      int var6 = var8.field2778;
      if(var6 != 0) {
         int var5 = class165.widgetSettings[var0];
         if(var6 == 1) {
            if(var5 == 1) {
               class84.method1603(0.9D);
               ((TextureProvider)class84.field1438).method1400(0.9D);
            }

            if(var5 == 2) {
               class84.method1603(0.8D);
               ((TextureProvider)class84.field1438).method1400(0.8D);
            }

            if(var5 == 3) {
               class84.method1603(0.7D);
               ((TextureProvider)class84.field1438).method1400(0.7D);
            }

            if(var5 == 4) {
               class84.method1603(0.6D);
               ((TextureProvider)class84.field1438).method1400(0.6D);
            }

            ItemComposition.itemSpriteCache.reset();
         }

         if(var6 == 3) {
            short var4 = 0;
            if(var5 == 0) {
               var4 = 255;
            }

            if(var5 == 1) {
               var4 = 192;
            }

            if(var5 == 2) {
               var4 = 128;
            }

            if(var5 == 3) {
               var4 = 64;
            }

            if(var5 == 4) {
               var4 = 0;
            }

            if(var4 != Client.field529) {
               if(Client.field529 == 0 && Client.field530 != -1) {
                  WallObject.method1833(class164.field2170, Client.field530, 0, var4, false);
                  Client.field531 = false;
               } else if(var4 == 0) {
                  class211.method3825();
                  Client.field531 = false;
               } else if(class138.field1933 != 0) {
                  class138.field1921 = var4;
               } else {
                  class138.field1923.method2531(var4);
               }

               Client.field529 = var4;
            }
         }

         if(var6 == 4) {
            if(var5 == 0) {
               Client.field532 = 127;
            }

            if(var5 == 1) {
               Client.field532 = 96;
            }

            if(var5 == 2) {
               Client.field532 = 64;
            }

            if(var5 == 3) {
               Client.field532 = 32;
            }

            if(var5 == 4) {
               Client.field532 = 0;
            }
         }

         if(var6 == 5) {
            Client.field430 = var5;
         }

         if(var6 == 6) {
            Client.field493 = var5;
         }

         if(var6 == 9) {
            Client.field454 = var5;
         }

         if(var6 == 10) {
            if(var5 == 0) {
               Client.field551 = 127;
            }

            if(var5 == 1) {
               Client.field551 = 96;
            }

            if(var5 == 2) {
               Client.field551 = 64;
            }

            if(var5 == 3) {
               Client.field551 = 32;
            }

            if(var5 == 4) {
               Client.field551 = 0;
            }
         }

         if(var6 == 17) {
            Client.field459 = var5 & '\uffff';
         }

         class40[] var7;
         if(var6 == 18) {
            var7 = new class40[]{class40.field805, class40.field803, class40.field806, class40.field809};
            Client.field319 = (class40)class72.method1368(var7, var5);
            if(null == Client.field319) {
               Client.field319 = class40.field805;
            }
         }

         if(var6 == 19) {
            if(var5 == -1) {
               Client.field292 = -1;
            } else {
               Client.field292 = var5 & 2047;
            }
         }

         if(var6 == 22) {
            var7 = new class40[]{class40.field805, class40.field803, class40.field806, class40.field809};
            Client.field320 = (class40)class72.method1368(var7, var5);
            if(Client.field320 == null) {
               Client.field320 = class40.field805;
            }
         }

      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(S)J",
      garbageValue = "-9859"
   )
   public static synchronized long method27() {
      long var0 = System.currentTimeMillis();
      if(var0 < class155.field2123) {
         class6.field64 += class155.field2123 - var0;
      }

      class155.field2123 = var0;
      return var0 + class6.field64;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "62"
   )
   static final void method29(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = XClanMember.method223(var0, var1, class118.plane) - var2;
         var0 -= XItemContainer.cameraX;
         var3 -= class11.cameraZ;
         var1 -= class20.cameraY;
         int var4 = class84.field1444[class13.cameraPitch];
         int var5 = class84.field1453[class13.cameraPitch];
         int var6 = class84.field1444[class105.cameraYaw];
         int var7 = class84.field1453[class105.cameraYaw];
         int var8 = var1 * var6 + var0 * var7 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var4 * var1 >> 16;
         var1 = var5 * var1 + var3 * var4 >> 16;
         if(var1 >= 50) {
            Client.field398 = Client.camera2 / 2 + var0 * Client.scale / var1;
            Client.field399 = var8 * Client.scale / var1 + Client.camera3 / 2;
         } else {
            Client.field398 = -1;
            Client.field399 = -1;
         }

      } else {
         Client.field398 = -1;
         Client.field399 = -1;
      }
   }
}

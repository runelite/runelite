import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public class class13 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-5302191"
   )
   static int method193(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class32.field756[--class32.field752];
         var4 = World.method670(var3);
      } else {
         var4 = var2?class26.field624:class32.field754;
      }

      if(var0 == 1000) {
         class32.field752 -= 4;
         var4.originalX = class32.field756[class32.field752];
         var4.originalY = class32.field756[class32.field752 + 1];
         var4.field2191 = class32.field756[class32.field752 + 2];
         var4.field2192 = class32.field756[3 + class32.field752];
         class2.method36(var4);
         class26.method605(var4);
         if(var3 != -1 && var4.type == 0) {
            class107.method2100(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         class32.field752 -= 4;
         var4.originalWidth = class32.field756[class32.field752];
         var4.field2198 = class32.field756[class32.field752 + 1];
         var4.field2185 = class32.field756[2 + class32.field752];
         var4.field2207 = class32.field756[3 + class32.field752];
         class2.method36(var4);
         class26.method605(var4);
         if(var3 != -1 && var4.type == 0) {
            class107.method2100(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class32.field756[--class32.field752] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            class2.method36(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.field2287 = class32.field756[--class32.field752] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.field2230 = class32.field756[--class32.field752] == 1;
         return 1;
      } else {
         return 2;
      }
   }

   class13() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIILObjectComposition;IB)V",
      garbageValue = "-125"
   )
   static void method194(int var0, int var1, int var2, ObjectComposition var3, int var4) {
      class31 var5 = new class31();
      var5.field729 = var0;
      var5.field731 = var1 * 128;
      var5.field730 = var2 * 128;
      int var6 = var3.sizeX;
      int var7 = var3.sizeY;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.sizeY;
         var7 = var3.sizeX;
      }

      var5.field742 = (var6 + var1) * 128;
      var5.field732 = (var7 + var2) * 128;
      var5.field734 = var3.ambientSoundId;
      var5.field733 = var3.field2939 * 128;
      var5.field736 = var3.field2923;
      var5.field737 = var3.field2941;
      var5.field738 = var3.field2902;
      if(null != var3.impostorIds) {
         var5.field745 = var3;
         var5.method690();
      }

      class31.field741.method2458(var5);
      if(var5.field738 != null) {
         var5.field739 = var5.field736 + (int)(Math.random() * (double)(var5.field737 - var5.field736));
      }

   }

   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "(LWidget;B)Z",
      garbageValue = "18"
   )
   static boolean method195(Widget var0) {
      if(Client.field562) {
         if(class174.method3271(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "23562"
   )
   static int method196() {
      return Client.isResized?2:1;
   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "14"
   )
   static final void method197(int var0, int var1, int var2, int var3) {
      if(Client.field466 == 0 && !Client.field468) {
         class22.addMenuEntry("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < Model.field1422; ++var6) {
         var7 = Model.field1423[var6];
         int var8 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var5 != var7) {
            var5 = var7;
            if(var10 == 2 && Friend.region.method1783(class31.plane, var8, var9, var7) >= 0) {
               ObjectComposition var12 = class195.getObjectDefinition(var11);
               if(null != var12.impostorIds) {
                  var12 = var12.getImpostor();
               }

               if(var12 == null) {
                  continue;
               }

               if(Client.field466 == 1) {
                  class22.addMenuEntry("Use", Client.field496 + " " + "->" + " " + class116.method2288('\uffff') + var12.name, 1, var7, var8, var9);
               } else if(Client.field468) {
                  if((class7.field73 & 4) == 4) {
                     class22.addMenuEntry(Client.field489, Client.field472 + " " + "->" + " " + class116.method2288('\uffff') + var12.name, 2, var7, var8, var9);
                  }
               } else {
                  String[] var13 = var12.actions;
                  if(Client.field484) {
                     var13 = Item.method875(var13);
                  }

                  if(null != var13) {
                     for(int var14 = 4; var14 >= 0; --var14) {
                        if(null != var13[var14]) {
                           short var15 = 0;
                           if(var14 == 0) {
                              var15 = 3;
                           }

                           if(var14 == 1) {
                              var15 = 4;
                           }

                           if(var14 == 2) {
                              var15 = 5;
                           }

                           if(var14 == 3) {
                              var15 = 6;
                           }

                           if(var14 == 4) {
                              var15 = 1001;
                           }

                           class22.addMenuEntry(var13[var14], class116.method2288('\uffff') + var12.name, var15, var7, var8, var9);
                        }
                     }
                  }

                  class22.addMenuEntry("Examine", class116.method2288('\uffff') + var12.name, 1002, var12.field2901 << 14, var8, var9);
               }
            }

            Player var16;
            NPC var19;
            int var20;
            int var27;
            int[] var28;
            if(var10 == 1) {
               NPC var23 = Client.cachedNPCs[var11];
               if(null == var23) {
                  continue;
               }

               if(var23.composition.field3008 == 1 && (var23.x & 127) == 64 && (var23.y & 127) == 64) {
                  for(var20 = 0; var20 < Client.field351; ++var20) {
                     var19 = Client.cachedNPCs[Client.field570[var20]];
                     if(var19 != null && var19 != var23 && var19.composition.field3008 == 1 && var23.x == var19.x && var23.y == var19.y) {
                        class207.method3862(var19.composition, Client.field570[var20], var8, var9);
                     }
                  }

                  var20 = class45.field934;
                  var28 = class45.field925;

                  for(var27 = 0; var27 < var20; ++var27) {
                     var16 = Client.cachedPlayers[var28[var27]];
                     if(var16 != null && var16.x == var23.x && var16.y == var23.y) {
                        class7.method101(var16, var28[var27], var8, var9);
                     }
                  }
               }

               class207.method3862(var23.composition, var11, var8, var9);
            }

            if(var10 == 0) {
               Player var24 = Client.cachedPlayers[var11];
               if(var24 == null) {
                  continue;
               }

               if((var24.x & 127) == 64 && (var24.y & 127) == 64) {
                  for(var20 = 0; var20 < Client.field351; ++var20) {
                     var19 = Client.cachedNPCs[Client.field570[var20]];
                     if(var19 != null && var19.composition.field3008 == 1 && var19.x == var24.x && var24.y == var19.y) {
                        class207.method3862(var19.composition, Client.field570[var20], var8, var9);
                     }
                  }

                  var20 = class45.field934;
                  var28 = class45.field925;

                  for(var27 = 0; var27 < var20; ++var27) {
                     var16 = Client.cachedPlayers[var28[var27]];
                     if(var16 != null && var16 != var24 && var16.x == var24.x && var16.y == var24.y) {
                        class7.method101(var16, var28[var27], var8, var9);
                     }
                  }
               }

               if(Client.field407 != var11) {
                  class7.method101(var24, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               Deque var25 = Client.groundItemDeque[class31.plane][var8][var9];
               if(var25 != null) {
                  for(Item var26 = (Item)var25.method2449(); null != var26; var26 = (Item)var25.method2451()) {
                     ItemComposition var29 = class154.getItemDefinition(var26.id);
                     if(Client.field466 == 1) {
                        class22.addMenuEntry("Use", Client.field496 + " " + "->" + " " + class116.method2288(16748608) + var29.name, 16, var26.id, var8, var9);
                     } else if(Client.field468) {
                        if((class7.field73 & 1) == 1) {
                           class22.addMenuEntry(Client.field489, Client.field472 + " " + "->" + " " + class116.method2288(16748608) + var29.name, 17, var26.id, var8, var9);
                        }
                     } else {
                        String[] var21 = var29.groundActions;
                        if(Client.field484) {
                           var21 = Item.method875(var21);
                        }

                        for(int var18 = 4; var18 >= 0; --var18) {
                           if(null != var21 && null != var21[var18]) {
                              byte var17 = 0;
                              if(var18 == 0) {
                                 var17 = 18;
                              }

                              if(var18 == 1) {
                                 var17 = 19;
                              }

                              if(var18 == 2) {
                                 var17 = 20;
                              }

                              if(var18 == 3) {
                                 var17 = 21;
                              }

                              if(var18 == 4) {
                                 var17 = 22;
                              }

                              class22.addMenuEntry(var21[var18], class116.method2288(16748608) + var29.name, var17, var26.id, var8, var9);
                           } else if(var18 == 2) {
                              class22.addMenuEntry("Take", class116.method2288(16748608) + var29.name, 20, var26.id, var8, var9);
                           }
                        }

                        class22.addMenuEntry("Examine", class116.method2288(16748608) + var29.name, 1004, var26.id, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         Player var22 = Client.cachedPlayers[Client.field407];
         class7.method101(var22, Client.field407, var6, var7);
      }

   }

   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "370143145"
   )
   static void method198() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method2391(); var0 != null; var0 = (WidgetNode)Client.componentTable.method2392()) {
         int var1 = var0.id;
         if(class44.method892(var1)) {
            boolean var2 = true;
            Widget[] var3 = Widget.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = World.method670(var4);
               if(var5 != null) {
                  class2.method36(var5);
               }
            }
         }
      }

   }
}

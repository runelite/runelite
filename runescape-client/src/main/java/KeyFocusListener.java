import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
@Implements("KeyFocusListener")
public final class KeyFocusListener implements KeyListener, FocusListener {
   @ObfuscatedName("a")
   @Export("keyboard")
   public static KeyFocusListener keyboard;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 1355829169
   )
   static int field625;
   @ObfuscatedName("cr")
   static int[] field643;
   @ObfuscatedName("bt")
   static class71 field641;
   @ObfuscatedName("ch")
   public static boolean[] field626;
   @ObfuscatedName("cf")
   static int[] field639;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = -1854914293
   )
   static int field629;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = 1681272927
   )
   static int field620;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = 1995072791
   )
   static int field635;
   @ObfuscatedName("ci")
   static int[] field628;
   @ObfuscatedName("cb")
   static char[] field631;
   @ObfuscatedName("co")
   public static int[] field633;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = -2033169017
   )
   public static int field634;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -198217911
   )
   static int field637;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = -487008387
   )
   @Export("keyboardIdleTicks")
   public static volatile int keyboardIdleTicks;
   @ObfuscatedName("pp")
   @Export("soundSystem1")
   static AbstractSoundSystem soundSystem1;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 1457940985
   )
   public static int field627;

   static {
      keyboard = new KeyFocusListener();
      field626 = new boolean[112];
      field639 = new int[128];
      field629 = 0;
      field625 = 0;
      field631 = new char[128];
      field628 = new int[128];
      field633 = new int[128];
      field634 = 0;
      field635 = 0;
      field620 = 0;
      field637 = 0;
      keyboardIdleTicks = 0;
      field643 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field643.length) {
            var2 = field643[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field625 >= 0 && var2 >= 0) {
            field639[field625] = ~var2;
            field625 = field625 + 1 & 127;
            if(field629 == field625) {
               field625 = -1;
            }
         }
      }

      var1.consume();
   }

   public final synchronized void keyPressed(KeyEvent var1) {
      if(keyboard != null) {
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field643.length) {
            var2 = field643[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field625 >= 0 && var2 >= 0) {
            field639[field625] = var2;
            field625 = field625 + 1 & 127;
            if(field625 == field629) {
               field625 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field620 + 1 & 127;
            if(var3 != field635) {
               field628[field620] = var2;
               field631[field620] = 0;
               field620 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(keyboard != null) {
         field625 = -1;
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final void keyTyped(KeyEvent var1) {
      if(keyboard != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff') {
            boolean var3;
            if(var2 > 0 && var2 < 128 || var2 >= 160 && var2 <= 255) {
               var3 = true;
            } else {
               label58: {
                  if(var2 != 0) {
                     char[] var7 = class266.field3663;

                     for(int var5 = 0; var5 < var7.length; ++var5) {
                        char var6 = var7[var5];
                        if(var2 == var6) {
                           var3 = true;
                           break label58;
                        }
                     }
                  }

                  var3 = false;
               }
            }

            if(var3) {
               int var4 = field620 + 1 & 127;
               if(var4 != field635) {
                  field628[field620] = -1;
                  field631[field620] = var2;
                  field620 = var4;
               }
            }
         }
      }

      var1.consume();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1891195197"
   )
   public static int method764(int var0) {
      var0 = (var0 >>> 1 & 1431655765) + (var0 & 1431655765);
      var0 = (var0 & 858993459) + (var0 >>> 2 & 858993459);
      var0 = var0 + (var0 >>> 4) & 252645135;
      var0 += var0 >>> 8;
      var0 += var0 >>> 16;
      return var0 & 255;
   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-2140695240"
   )
   static final void method780(int var0, int var1, int var2, int var3) {
      if(Client.itemSelectionState == 0 && !Client.spellSelected) {
         class37.addMenuEntry("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < class134.field1995; ++var6) {
         var7 = class134.field1988[var6];
         int var8 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var5 != var7) {
            var5 = var7;
            if(var10 == 2 && class29.region.method2743(class45.plane, var8, var9, var7) >= 0) {
               ObjectComposition var12 = PlayerComposition.getObjectDefinition(var11);
               if(var12.impostorIds != null) {
                  var12 = var12.getImpostor();
               }

               if(var12 == null) {
                  continue;
               }

               if(Client.itemSelectionState == 1) {
                  class37.addMenuEntry("Use", Client.selectedItemName + " " + "->" + " " + class46.getColTags('\uffff') + var12.name, 1, var7, var8, var9);
               } else if(Client.spellSelected) {
                  if((class116.field1676 & 4) == 4) {
                     class37.addMenuEntry(Client.field1064, Client.field1019 + " " + "->" + " " + class46.getColTags('\uffff') + var12.name, 2, var7, var8, var9);
                  }
               } else {
                  String[] var13 = var12.actions;
                  if(Client.field1026) {
                     var13 = class34.method481(var13);
                  }

                  if(var13 != null) {
                     for(int var14 = 4; var14 >= 0; --var14) {
                        if(var13[var14] != null) {
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

                           class37.addMenuEntry(var13[var14], class46.getColTags('\uffff') + var12.name, var15, var7, var8, var9);
                        }
                     }
                  }

                  class37.addMenuEntry("Examine", class46.getColTags('\uffff') + var12.name, 1002, var12.id << 14, var8, var9);
               }
            }

            Player var16;
            int var19;
            NPC var20;
            int var27;
            int[] var28;
            if(var10 == 1) {
               NPC var23 = Client.cachedNPCs[var11];
               if(var23 == null) {
                  continue;
               }

               if(var23.composition.field3557 == 1 && (var23.x & 127) == 64 && (var23.y & 127) == 64) {
                  for(var19 = 0; var19 < Client.field944; ++var19) {
                     var20 = Client.cachedNPCs[Client.npcIndices[var19]];
                     if(var20 != null && var23 != var20 && var20.composition.field3557 == 1 && var20.x == var23.x && var23.y == var20.y) {
                        class12.method65(var20.composition, Client.npcIndices[var19], var8, var9);
                     }
                  }

                  var19 = class96.field1499;
                  var28 = class96.field1492;

                  for(var27 = 0; var27 < var19; ++var27) {
                     var16 = Client.cachedPlayers[var28[var27]];
                     if(var16 != null && var16.x == var23.x && var23.y == var16.y) {
                        GraphicsObject.method1644(var16, var28[var27], var8, var9);
                     }
                  }
               }

               class12.method65(var23.composition, var11, var8, var9);
            }

            if(var10 == 0) {
               Player var24 = Client.cachedPlayers[var11];
               if(var24 == null) {
                  continue;
               }

               if((var24.x & 127) == 64 && (var24.y & 127) == 64) {
                  for(var19 = 0; var19 < Client.field944; ++var19) {
                     var20 = Client.cachedNPCs[Client.npcIndices[var19]];
                     if(var20 != null && var20.composition.field3557 == 1 && var24.x == var20.x && var20.y == var24.y) {
                        class12.method65(var20.composition, Client.npcIndices[var19], var8, var9);
                     }
                  }

                  var19 = class96.field1499;
                  var28 = class96.field1492;

                  for(var27 = 0; var27 < var19; ++var27) {
                     var16 = Client.cachedPlayers[var28[var27]];
                     if(var16 != null && var16 != var24 && var24.x == var16.x && var16.y == var24.y) {
                        GraphicsObject.method1644(var16, var28[var27], var8, var9);
                     }
                  }
               }

               if(var11 != Client.field925) {
                  GraphicsObject.method1644(var24, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               Deque var25 = Client.groundItemDeque[class45.plane][var8][var9];
               if(var25 != null) {
                  for(Item var26 = (Item)var25.getTail(); var26 != null; var26 = (Item)var25.getPrevious()) {
                     ItemComposition var29 = class83.getItemDefinition(var26.id);
                     if(Client.itemSelectionState == 1) {
                        class37.addMenuEntry("Use", Client.selectedItemName + " " + "->" + " " + class46.getColTags(16748608) + var29.name, 16, var26.id, var8, var9);
                     } else if(Client.spellSelected) {
                        if((class116.field1676 & 1) == 1) {
                           class37.addMenuEntry(Client.field1064, Client.field1019 + " " + "->" + " " + class46.getColTags(16748608) + var29.name, 17, var26.id, var8, var9);
                        }
                     } else {
                        String[] var21 = var29.groundActions;
                        if(Client.field1026) {
                           var21 = class34.method481(var21);
                        }

                        for(int var22 = 4; var22 >= 0; --var22) {
                           if(var21 != null && var21[var22] != null) {
                              byte var17 = 0;
                              if(var22 == 0) {
                                 var17 = 18;
                              }

                              if(var22 == 1) {
                                 var17 = 19;
                              }

                              if(var22 == 2) {
                                 var17 = 20;
                              }

                              if(var22 == 3) {
                                 var17 = 21;
                              }

                              if(var22 == 4) {
                                 var17 = 22;
                              }

                              class37.addMenuEntry(var21[var22], class46.getColTags(16748608) + var29.name, var17, var26.id, var8, var9);
                           } else if(var22 == 2) {
                              class37.addMenuEntry("Take", class46.getColTags(16748608) + var29.name, 20, var26.id, var8, var9);
                           }
                        }

                        class37.addMenuEntry("Examine", class46.getColTags(16748608) + var29.name, 1004, var26.id, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         Player var18 = Client.cachedPlayers[Client.field925];
         GraphicsObject.method1644(var18, Client.field925, var6, var7);
      }

   }
}

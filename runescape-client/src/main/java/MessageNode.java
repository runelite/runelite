import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -933918249
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1895673231
   )
   @Export("id")
   int id = class175.method3275();
   @ObfuscatedName("d")
   @Export("name")
   String name;
   @ObfuscatedName("h")
   @Export("value")
   String value;
   @ObfuscatedName("w")
   @Export("sender")
   String sender;
   @ObfuscatedName("dh")
   @ObfuscatedGetter(
      intValue = 2006001359
   )
   static int field261;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1816169507
   )
   @Export("type")
   int type;

   MessageNode(int var1, String var2, String var3, String var4) {
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1752021270"
   )
   void method224(int var1, String var2, String var3, String var4) {
      this.id = class175.method3275();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "562823178"
   )
   static boolean method228(String var0, boolean var1) {
      if(null == var0) {
         return false;
      } else {
         String var2 = GroundObject.method1598(var0, class165.field2155);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(GroundObject.method1598(Client.friends[var3].name, class165.field2155)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(GroundObject.method1598(class22.localPlayer.name, class165.field2155))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "1872534008"
   )
   static int method229(int var0, Script var1, boolean var2) {
      if(var0 < 1000) {
         return class155.method3043(var0, var1, var2);
      } else if(var0 < 1100) {
         return class13.method193(var0, var1, var2);
      } else if(var0 < 1200) {
         return class2.method29(var0, var1, var2);
      } else if(var0 < 1300) {
         return class8.method106(var0, var1, var2);
      } else if(var0 < 1400) {
         return class25.method597(var0, var1, var2);
      } else if(var0 < 1500) {
         return WidgetNode.method206(var0, var1, var2);
      } else if(var0 < 1600) {
         return class22.method240(var0, var1, var2);
      } else if(var0 < 1700) {
         return Player.method261(var0, var1, var2);
      } else if(var0 < 1800) {
         return class39.method816(var0, var1, var2);
      } else {
         byte var3;
         int var6;
         int var23;
         int var29;
         int var34;
         int[] var39;
         Widget var45;
         if(var0 < 1900) {
            var45 = var2?class26.field624:class32.field754;
            if(var0 == 1800) {
               var39 = class32.field756;
               var6 = ++class32.field752 - 1;
               var29 = class174.method3271(var45);
               var34 = var29 >> 11 & 63;
               var39[var6] = var34;
               var3 = 1;
            } else if(var0 == 1801) {
               var23 = class32.field756[--class32.field752];
               --var23;
               if(var45.actions != null && var23 < var45.actions.length && var45.actions[var23] != null) {
                  class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var45.actions[var23];
               } else {
                  class32.scriptStringStack[++class9.scriptStringStackSize - 1] = "";
               }

               var3 = 1;
            } else if(var0 == 1802) {
               if(null == var45.name) {
                  class32.scriptStringStack[++class9.scriptStringStackSize - 1] = "";
               } else {
                  class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var45.name;
               }

               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else if(var0 < 2000) {
            return class10.method115(var0, var1, var2);
         } else if(var0 < 2100) {
            return class13.method193(var0, var1, var2);
         } else if(var0 < 2200) {
            return class2.method29(var0, var1, var2);
         } else if(var0 < 2300) {
            return class8.method106(var0, var1, var2);
         } else if(var0 < 2400) {
            return class25.method597(var0, var1, var2);
         } else if(var0 < 2500) {
            return WidgetNode.method206(var0, var1, var2);
         } else if(var0 < 2600) {
            var45 = World.method670(class32.field756[--class32.field752]);
            if(var0 == 2500) {
               class32.field756[++class32.field752 - 1] = var45.relativeX;
               var3 = 1;
            } else if(var0 == 2501) {
               class32.field756[++class32.field752 - 1] = var45.relativeY;
               var3 = 1;
            } else if(var0 == 2502) {
               class32.field756[++class32.field752 - 1] = var45.width;
               var3 = 1;
            } else if(var0 == 2503) {
               class32.field756[++class32.field752 - 1] = var45.height;
               var3 = 1;
            } else if(var0 == 2504) {
               class32.field756[++class32.field752 - 1] = var45.isHidden?1:0;
               var3 = 1;
            } else if(var0 == 2505) {
               class32.field756[++class32.field752 - 1] = var45.parentId;
               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else if(var0 < 2700) {
            return class8.method104(var0, var1, var2);
         } else {
            int var15;
            if(var0 < 2800) {
               if(var0 == 2700) {
                  var45 = World.method670(class32.field756[--class32.field752]);
                  class32.field756[++class32.field752 - 1] = var45.item;
                  var3 = 1;
               } else if(var0 == 2701) {
                  var45 = World.method670(class32.field756[--class32.field752]);
                  if(var45.item != -1) {
                     class32.field756[++class32.field752 - 1] = var45.stackSize;
                  } else {
                     class32.field756[++class32.field752 - 1] = 0;
                  }

                  var3 = 1;
               } else if(var0 == 2702) {
                  var15 = class32.field756[--class32.field752];
                  WidgetNode var46 = (WidgetNode)Client.componentTable.method2405((long)var15);
                  if(var46 != null) {
                     class32.field756[++class32.field752 - 1] = 1;
                  } else {
                     class32.field756[++class32.field752 - 1] = 0;
                  }

                  var3 = 1;
               } else if(var0 == 2706) {
                  class32.field756[++class32.field752 - 1] = Client.widgetRoot;
                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else if(var0 < 2900) {
               var45 = World.method670(class32.field756[--class32.field752]);
               if(var0 == 2800) {
                  var39 = class32.field756;
                  var6 = ++class32.field752 - 1;
                  var29 = class174.method3271(var45);
                  var34 = var29 >> 11 & 63;
                  var39[var6] = var34;
                  var3 = 1;
               } else if(var0 == 2801) {
                  var23 = class32.field756[--class32.field752];
                  --var23;
                  if(var45.actions != null && var23 < var45.actions.length && null != var45.actions[var23]) {
                     class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var45.actions[var23];
                  } else {
                     class32.scriptStringStack[++class9.scriptStringStackSize - 1] = "";
                  }

                  var3 = 1;
               } else if(var0 == 2802) {
                  if(var45.name == null) {
                     class32.scriptStringStack[++class9.scriptStringStackSize - 1] = "";
                  } else {
                     class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var45.name;
                  }

                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else if(var0 < 3000) {
               return class10.method115(var0, var1, var2);
            } else {
               boolean var5;
               String var22;
               String var31;
               String var38;
               if(var0 < 3200) {
                  if(var0 == 3100) {
                     var22 = class32.scriptStringStack[--class9.scriptStringStackSize];
                     class30.sendGameMessage(0, "", var22);
                     var3 = 1;
                  } else if(var0 == 3101) {
                     class32.field752 -= 2;
                     class94.method1979(class22.localPlayer, class32.field756[class32.field752], class32.field756[class32.field752 + 1]);
                     var3 = 1;
                  } else if(var0 == 3103) {
                     class108.method2104();
                     var3 = 1;
                  } else if(var0 == 3104) {
                     var22 = class32.scriptStringStack[--class9.scriptStringStackSize];
                     var23 = 0;
                     if(Buffer.method2946(var22)) {
                        var23 = class196.method3599(var22);
                     }

                     Client.field309.method3076(189);
                     Client.field309.method2819(var23);
                     var3 = 1;
                  } else if(var0 == 3105) {
                     var22 = class32.scriptStringStack[--class9.scriptStringStackSize];
                     Client.field309.method3076(37);
                     Client.field309.method2843(var22.length() + 1);
                     Client.field309.method2822(var22);
                     var3 = 1;
                  } else if(var0 == 3106) {
                     var22 = class32.scriptStringStack[--class9.scriptStringStackSize];
                     Client.field309.method3076(128);
                     Client.field309.method2843(var22.length() + 1);
                     Client.field309.method2822(var22);
                     var3 = 1;
                  } else if(var0 == 3107) {
                     var15 = class32.field756[--class32.field752];
                     var38 = class32.scriptStringStack[--class9.scriptStringStackSize];
                     XItemContainer.method174(var15, var38);
                     var3 = 1;
                  } else if(var0 == 3108) {
                     class32.field752 -= 3;
                     var15 = class32.field756[class32.field752];
                     var23 = class32.field756[class32.field752 + 1];
                     var6 = class32.field756[2 + class32.field752];
                     Widget var42 = World.method670(var6);
                     class7.method95(var42, var15, var23);
                     var3 = 1;
                  } else if(var0 == 3109) {
                     class32.field752 -= 2;
                     var15 = class32.field756[class32.field752];
                     var23 = class32.field756[1 + class32.field752];
                     Widget var35 = var2?class26.field624:class32.field754;
                     class7.method95(var35, var15, var23);
                     var3 = 1;
                  } else if(var0 == 3110) {
                     class202.field3076 = class32.field756[--class32.field752] == 1;
                     var3 = 1;
                  } else if(var0 == 3111) {
                     class32.field756[++class32.field752 - 1] = class8.field84.field717?1:0;
                     var3 = 1;
                  } else if(var0 == 3112) {
                     class8.field84.field717 = class32.field756[--class32.field752] == 1;
                     class0.method10();
                     var3 = 1;
                  } else if(var0 == 3113) {
                     var22 = class32.scriptStringStack[--class9.scriptStringStackSize];
                     var5 = class32.field756[--class32.field752] == 1;
                     RSCanvas.method2137(var22, var5, false);
                     var3 = 1;
                  } else if(var0 == 3115) {
                     var15 = class32.field756[--class32.field752];
                     Client.field309.method3076(92);
                     Client.field309.method2817(var15);
                     var3 = 1;
                  } else if(var0 == 3116) {
                     var15 = class32.field756[--class32.field752];
                     class9.scriptStringStackSize -= 2;
                     var38 = class32.scriptStringStack[class9.scriptStringStackSize];
                     var31 = class32.scriptStringStack[1 + class9.scriptStringStackSize];
                     if(var38.length() > 500) {
                        var3 = 1;
                     } else if(var31.length() > 500) {
                        var3 = 1;
                     } else {
                        Client.field309.method3076(136);
                        Client.field309.method2817(1 + class164.method3157(var38) + class164.method3157(var31));
                        Client.field309.method2822(var31);
                        Client.field309.method2855(var15);
                        Client.field309.method2822(var38);
                        var3 = 1;
                     }
                  } else if(var0 == 3117) {
                     Client.field561 = class32.field756[--class32.field752] == 1;
                     var3 = 1;
                  } else {
                     var3 = 2;
                  }

                  return var3;
               } else if(var0 < 3300) {
                  return class0.method9(var0, var1, var2);
               } else if(var0 < 3400) {
                  return class37.method809(var0, var1, var2);
               } else {
                  int var19;
                  if(var0 < 3500) {
                     if(var0 == 3400) {
                        class32.field752 -= 2;
                        var15 = class32.field756[class32.field752];
                        var23 = class32.field756[1 + class32.field752];
                        class195 var36 = (class195)class195.field2849.get((long)var15);
                        class195 var33;
                        if(null != var36) {
                           var33 = var36;
                        } else {
                           byte[] var43 = class195.field2850.getConfigData(8, var15);
                           var36 = new class195();
                           if(null != var43) {
                              var36.method3580(new Buffer(var43));
                           }

                           class195.field2849.put(var36, (long)var15);
                           var33 = var36;
                        }

                        var36 = var33;
                        if(var33.field2852 != 115) {
                           ;
                        }

                        for(var29 = 0; var29 < var36.field2861; ++var29) {
                           if(var23 == var36.field2856[var29]) {
                              class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var36.field2858[var29];
                              var36 = null;
                              break;
                           }
                        }

                        if(null != var36) {
                           class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var36.field2853;
                        }

                        var3 = 1;
                     } else if(var0 == 3408) {
                        class32.field752 -= 4;
                        var15 = class32.field756[class32.field752];
                        var23 = class32.field756[class32.field752 + 1];
                        var6 = class32.field756[class32.field752 + 2];
                        var34 = class32.field756[class32.field752 + 3];
                        class195 var25 = (class195)class195.field2849.get((long)var6);
                        class195 var44;
                        if(var25 != null) {
                           var44 = var25;
                        } else {
                           byte[] var27 = class195.field2850.getConfigData(8, var6);
                           var25 = new class195();
                           if(null != var27) {
                              var25.method3580(new Buffer(var27));
                           }

                           class195.field2849.put(var25, (long)var6);
                           var44 = var25;
                        }

                        var25 = var44;
                        if(var44.field2851 == var15 && var23 == var44.field2852) {
                           for(var19 = 0; var19 < var25.field2861; ++var19) {
                              if(var25.field2856[var19] == var34) {
                                 if(var23 == 115) {
                                    class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var25.field2858[var19];
                                 } else {
                                    class32.field756[++class32.field752 - 1] = var25.field2857[var19];
                                 }

                                 var25 = null;
                                 break;
                              }
                           }

                           if(var25 != null) {
                              if(var23 == 115) {
                                 class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var25.field2853;
                              } else {
                                 class32.field756[++class32.field752 - 1] = var25.field2854;
                              }
                           }

                           var3 = 1;
                        } else {
                           if(var23 == 115) {
                              class32.scriptStringStack[++class9.scriptStringStackSize - 1] = "null";
                           } else {
                              class32.field756[++class32.field752 - 1] = 0;
                           }

                           var3 = 1;
                        }
                     } else {
                        var3 = 2;
                     }

                     return var3;
                  } else if(var0 < 3700) {
                     return class150.method2801(var0, var1, var2);
                  } else if(var0 < 4000) {
                     return class39.method818(var0, var1, var2);
                  } else if(var0 < 4100) {
                     return class16.method202(var0, var1, var2);
                  } else if(var0 < 4200) {
                     return class161.method3119(var0, var1, var2);
                  } else {
                     boolean var7;
                     int var20;
                     int var21;
                     if(var0 < 4300) {
                        if(var0 == 4200) {
                           var15 = class32.field756[--class32.field752];
                           class32.scriptStringStack[++class9.scriptStringStackSize - 1] = class154.getItemDefinition(var15).name;
                           var3 = 1;
                        } else {
                           ItemComposition var32;
                           if(var0 == 4201) {
                              class32.field752 -= 2;
                              var15 = class32.field756[class32.field752];
                              var23 = class32.field756[1 + class32.field752];
                              var32 = class154.getItemDefinition(var15);
                              if(var23 >= 1 && var23 <= 5 && null != var32.groundActions[var23 - 1]) {
                                 class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var32.groundActions[var23 - 1];
                              } else {
                                 class32.scriptStringStack[++class9.scriptStringStackSize - 1] = "";
                              }

                              var3 = 1;
                           } else if(var0 == 4202) {
                              class32.field752 -= 2;
                              var15 = class32.field756[class32.field752];
                              var23 = class32.field756[1 + class32.field752];
                              var32 = class154.getItemDefinition(var15);
                              if(var23 >= 1 && var23 <= 5 && var32.inventoryActions[var23 - 1] != null) {
                                 class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var32.inventoryActions[var23 - 1];
                              } else {
                                 class32.scriptStringStack[++class9.scriptStringStackSize - 1] = "";
                              }

                              var3 = 1;
                           } else if(var0 == 4203) {
                              var15 = class32.field756[--class32.field752];
                              class32.field756[++class32.field752 - 1] = class154.getItemDefinition(var15).price;
                              var3 = 1;
                           } else if(var0 == 4204) {
                              var15 = class32.field756[--class32.field752];
                              class32.field756[++class32.field752 - 1] = class154.getItemDefinition(var15).isStackable == 1?1:0;
                              var3 = 1;
                           } else {
                              ItemComposition var40;
                              if(var0 == 4205) {
                                 var15 = class32.field756[--class32.field752];
                                 var40 = class154.getItemDefinition(var15);
                                 if(var40.notedTemplate == -1 && var40.note >= 0) {
                                    class32.field756[++class32.field752 - 1] = var40.note;
                                 } else {
                                    class32.field756[++class32.field752 - 1] = var15;
                                 }

                                 var3 = 1;
                              } else if(var0 == 4206) {
                                 var15 = class32.field756[--class32.field752];
                                 var40 = class154.getItemDefinition(var15);
                                 if(var40.notedTemplate >= 0 && var40.note >= 0) {
                                    class32.field756[++class32.field752 - 1] = var40.note;
                                 } else {
                                    class32.field756[++class32.field752 - 1] = var15;
                                 }

                                 var3 = 1;
                              } else if(var0 == 4207) {
                                 var15 = class32.field756[--class32.field752];
                                 class32.field756[++class32.field752 - 1] = class154.getItemDefinition(var15).isMembers?1:0;
                                 var3 = 1;
                              } else if(var0 == 4208) {
                                 var15 = class32.field756[--class32.field752];
                                 var40 = class154.getItemDefinition(var15);
                                 if(var40.field3000 == -1 && var40.field2973 >= 0) {
                                    class32.field756[++class32.field752 - 1] = var40.field2973;
                                 } else {
                                    class32.field756[++class32.field752 - 1] = var15;
                                 }

                                 var3 = 1;
                              } else if(var0 == 4209) {
                                 var15 = class32.field756[--class32.field752];
                                 var40 = class154.getItemDefinition(var15);
                                 if(var40.field3000 >= 0 && var40.field2973 >= 0) {
                                    class32.field756[++class32.field752 - 1] = var40.field2973;
                                 } else {
                                    class32.field756[++class32.field752 - 1] = var15;
                                 }

                                 var3 = 1;
                              } else if(var0 == 4210) {
                                 var22 = class32.scriptStringStack[--class9.scriptStringStackSize];
                                 var23 = class32.field756[--class32.field752];
                                 var7 = var23 == 1;
                                 var31 = var22.toLowerCase();
                                 short[] var41 = new short[16];
                                 var20 = 0;
                                 var19 = 0;

                                 while(true) {
                                    if(var19 >= class105.field1737) {
                                       class40.field844 = var41;
                                       class36.field805 = 0;
                                       class10.field126 = var20;
                                       String[] var26 = new String[class10.field126];

                                       for(var21 = 0; var21 < class10.field126; ++var21) {
                                          var26[var21] = class154.getItemDefinition(var41[var21]).name;
                                       }

                                       short[] var28 = class40.field844;
                                       ItemLayer.method1520(var26, var28, 0, var26.length - 1);
                                       break;
                                    }

                                    ItemComposition var11 = class154.getItemDefinition(var19);
                                    if((!var7 || var11.field2996) && var11.notedTemplate == -1 && var11.name.toLowerCase().indexOf(var31) != -1) {
                                       if(var20 >= 250) {
                                          class10.field126 = -1;
                                          class40.field844 = null;
                                          break;
                                       }

                                       if(var20 >= var41.length) {
                                          short[] var30 = new short[2 * var41.length];

                                          for(int var13 = 0; var13 < var20; ++var13) {
                                             var30[var13] = var41[var13];
                                          }

                                          var41 = var30;
                                       }

                                       var41[var20++] = (short)var19;
                                    }

                                    ++var19;
                                 }

                                 class32.field756[++class32.field752 - 1] = class10.field126;
                                 var3 = 1;
                              } else if(var0 == 4211) {
                                 if(class40.field844 != null && class36.field805 < class10.field126) {
                                    class32.field756[++class32.field752 - 1] = class40.field844[++class36.field805 - 1] & '\uffff';
                                 } else {
                                    class32.field756[++class32.field752 - 1] = -1;
                                 }

                                 var3 = 1;
                              } else if(var0 == 4212) {
                                 class36.field805 = 0;
                                 var3 = 1;
                              } else {
                                 var3 = 2;
                              }
                           }
                        }

                        return var3;
                     } else if(var0 < 5100) {
                        if(var0 == 5000) {
                           class32.field756[++class32.field752 - 1] = Client.field307;
                           var3 = 1;
                        } else if(var0 == 5001) {
                           class32.field752 -= 3;
                           Client.field307 = class32.field756[class32.field752];
                           class107.field1740 = class15.method200(class32.field756[class32.field752 + 1]);
                           if(class107.field1740 == null) {
                              class107.field1740 = class216.field3178;
                           }

                           Client.field532 = class32.field756[2 + class32.field752];
                           Client.field309.method3076(2);
                           Client.field309.method2843(Client.field307);
                           Client.field309.method2843(class107.field1740.field3180);
                           Client.field309.method2843(Client.field532);
                           var3 = 1;
                        } else if(var0 == 5002) {
                           var22 = class32.scriptStringStack[--class9.scriptStringStackSize];
                           class32.field752 -= 2;
                           var23 = class32.field756[class32.field752];
                           var6 = class32.field756[class32.field752 + 1];
                           Client.field309.method3076(195);
                           Client.field309.method2843(class164.method3157(var22) + 2);
                           Client.field309.method2822(var22);
                           Client.field309.method2843(var23 - 1);
                           Client.field309.method2843(var6);
                           var3 = 1;
                        } else if(var0 == 5003) {
                           class32.field752 -= 2;
                           var15 = class32.field756[class32.field752];
                           var23 = class32.field756[class32.field752 + 1];
                           MessageNode var14 = class211.method3982(var15, var23);
                           if(var14 != null) {
                              class32.field756[++class32.field752 - 1] = var14.id;
                              class32.field756[++class32.field752 - 1] = var14.tick;
                              class32.scriptStringStack[++class9.scriptStringStackSize - 1] = null != var14.name?var14.name:"";
                              class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var14.sender != null?var14.sender:"";
                              class32.scriptStringStack[++class9.scriptStringStackSize - 1] = null != var14.value?var14.value:"";
                           } else {
                              class32.field756[++class32.field752 - 1] = -1;
                              class32.field756[++class32.field752 - 1] = 0;
                              class32.scriptStringStack[++class9.scriptStringStackSize - 1] = "";
                              class32.scriptStringStack[++class9.scriptStringStackSize - 1] = "";
                              class32.scriptStringStack[++class9.scriptStringStackSize - 1] = "";
                           }

                           var3 = 1;
                        } else if(var0 == 5004) {
                           var15 = class32.field756[--class32.field752];
                           MessageNode var37 = class104.method2055(var15);
                           if(var37 != null) {
                              class32.field756[++class32.field752 - 1] = var37.type;
                              class32.field756[++class32.field752 - 1] = var37.tick;
                              class32.scriptStringStack[++class9.scriptStringStackSize - 1] = null != var37.name?var37.name:"";
                              class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var37.sender != null?var37.sender:"";
                              class32.scriptStringStack[++class9.scriptStringStackSize - 1] = null != var37.value?var37.value:"";
                           } else {
                              class32.field756[++class32.field752 - 1] = -1;
                              class32.field756[++class32.field752 - 1] = 0;
                              class32.scriptStringStack[++class9.scriptStringStackSize - 1] = "";
                              class32.scriptStringStack[++class9.scriptStringStackSize - 1] = "";
                              class32.scriptStringStack[++class9.scriptStringStackSize - 1] = "";
                           }

                           var3 = 1;
                        } else if(var0 == 5005) {
                           if(null == class107.field1740) {
                              class32.field756[++class32.field752 - 1] = -1;
                           } else {
                              class32.field756[++class32.field752 - 1] = class107.field1740.field3180;
                           }

                           var3 = 1;
                        } else if(var0 == 5008) {
                           var22 = class32.scriptStringStack[--class9.scriptStringStackSize];
                           var23 = class32.field756[--class32.field752];
                           var31 = var22.toLowerCase();
                           byte var24 = 0;
                           if(var31.startsWith("yellow:")) {
                              var24 = 0;
                              var22 = var22.substring("yellow:".length());
                           } else if(var31.startsWith("red:")) {
                              var24 = 1;
                              var22 = var22.substring("red:".length());
                           } else if(var31.startsWith("green:")) {
                              var24 = 2;
                              var22 = var22.substring("green:".length());
                           } else if(var31.startsWith("cyan:")) {
                              var24 = 3;
                              var22 = var22.substring("cyan:".length());
                           } else if(var31.startsWith("purple:")) {
                              var24 = 4;
                              var22 = var22.substring("purple:".length());
                           } else if(var31.startsWith("white:")) {
                              var24 = 5;
                              var22 = var22.substring("white:".length());
                           } else if(var31.startsWith("flash1:")) {
                              var24 = 6;
                              var22 = var22.substring("flash1:".length());
                           } else if(var31.startsWith("flash2:")) {
                              var24 = 7;
                              var22 = var22.substring("flash2:".length());
                           } else if(var31.startsWith("flash3:")) {
                              var24 = 8;
                              var22 = var22.substring("flash3:".length());
                           } else if(var31.startsWith("glow1:")) {
                              var24 = 9;
                              var22 = var22.substring("glow1:".length());
                           } else if(var31.startsWith("glow2:")) {
                              var24 = 10;
                              var22 = var22.substring("glow2:".length());
                           } else if(var31.startsWith("glow3:")) {
                              var24 = 11;
                              var22 = var22.substring("glow3:".length());
                           } else if(Client.field409 != 0) {
                              if(var31.startsWith("yellow:")) {
                                 var24 = 0;
                                 var22 = var22.substring("yellow:".length());
                              } else if(var31.startsWith("red:")) {
                                 var24 = 1;
                                 var22 = var22.substring("red:".length());
                              } else if(var31.startsWith("green:")) {
                                 var24 = 2;
                                 var22 = var22.substring("green:".length());
                              } else if(var31.startsWith("cyan:")) {
                                 var24 = 3;
                                 var22 = var22.substring("cyan:".length());
                              } else if(var31.startsWith("purple:")) {
                                 var24 = 4;
                                 var22 = var22.substring("purple:".length());
                              } else if(var31.startsWith("white:")) {
                                 var24 = 5;
                                 var22 = var22.substring("white:".length());
                              } else if(var31.startsWith("flash1:")) {
                                 var24 = 6;
                                 var22 = var22.substring("flash1:".length());
                              } else if(var31.startsWith("flash2:")) {
                                 var24 = 7;
                                 var22 = var22.substring("flash2:".length());
                              } else if(var31.startsWith("flash3:")) {
                                 var24 = 8;
                                 var22 = var22.substring("flash3:".length());
                              } else if(var31.startsWith("glow1:")) {
                                 var24 = 9;
                                 var22 = var22.substring("glow1:".length());
                              } else if(var31.startsWith("glow2:")) {
                                 var24 = 10;
                                 var22 = var22.substring("glow2:".length());
                              } else if(var31.startsWith("glow3:")) {
                                 var24 = 11;
                                 var22 = var22.substring("glow3:".length());
                              }
                           }

                           var31 = var22.toLowerCase();
                           byte var8 = 0;
                           if(var31.startsWith("wave:")) {
                              var8 = 1;
                              var22 = var22.substring("wave:".length());
                           } else if(var31.startsWith("wave2:")) {
                              var8 = 2;
                              var22 = var22.substring("wave2:".length());
                           } else if(var31.startsWith("shake:")) {
                              var8 = 3;
                              var22 = var22.substring("shake:".length());
                           } else if(var31.startsWith("scroll:")) {
                              var8 = 4;
                              var22 = var22.substring("scroll:".length());
                           } else if(var31.startsWith("slide:")) {
                              var8 = 5;
                              var22 = var22.substring("slide:".length());
                           } else if(Client.field409 != 0) {
                              if(var31.startsWith("wave:")) {
                                 var8 = 1;
                                 var22 = var22.substring("wave:".length());
                              } else if(var31.startsWith("wave2:")) {
                                 var8 = 2;
                                 var22 = var22.substring("wave2:".length());
                              } else if(var31.startsWith("shake:")) {
                                 var8 = 3;
                                 var22 = var22.substring("shake:".length());
                              } else if(var31.startsWith("scroll:")) {
                                 var8 = 4;
                                 var22 = var22.substring("scroll:".length());
                              } else if(var31.startsWith("slide:")) {
                                 var8 = 5;
                                 var22 = var22.substring("slide:".length());
                              }
                           }

                           Client.field309.method3076(79);
                           Client.field309.method2843(0);
                           var20 = Client.field309.offset;
                           Client.field309.method2843(var23);
                           Client.field309.method2843(var24);
                           Client.field309.method2843(var8);
                           class159 var10 = Client.field309;
                           var21 = var10.offset;
                           byte[] var12 = class22.method241(var22);
                           var10.method2829(var12.length);
                           var10.offset += class210.field3130.method2759(var12, 0, var12.length, var10.payload, var10.offset);
                           Client.field309.method2828(Client.field309.offset - var20);
                           var3 = 1;
                        } else if(var0 == 5009) {
                           class9.scriptStringStackSize -= 2;
                           var22 = class32.scriptStringStack[class9.scriptStringStackSize];
                           var38 = class32.scriptStringStack[class9.scriptStringStackSize + 1];
                           Client.field309.method3076(169);
                           Client.field309.method2817(0);
                           var6 = Client.field309.offset;
                           Client.field309.method2822(var22);
                           class159 var17 = Client.field309;
                           var29 = var17.offset;
                           byte[] var9 = class22.method241(var38);
                           var17.method2829(var9.length);
                           var17.offset += class210.field3130.method2759(var9, 0, var9.length, var17.payload, var17.offset);
                           Client.field309.method2945(Client.field309.offset - var6);
                           var3 = 1;
                        } else if(var0 == 5015) {
                           if(class22.localPlayer != null && null != class22.localPlayer.name) {
                              var22 = class22.localPlayer.name;
                           } else {
                              var22 = "";
                           }

                           class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var22;
                           var3 = 1;
                        } else if(var0 == 5016) {
                           class32.field756[++class32.field752 - 1] = Client.field532;
                           var3 = 1;
                        } else if(var0 == 5017) {
                           var15 = class32.field756[--class32.field752];
                           class32.field756[++class32.field752 - 1] = class8.method108(var15);
                           var3 = 1;
                        } else {
                           MessageNode var18;
                           if(var0 == 5018) {
                              var15 = class32.field756[--class32.field752];
                              var39 = class32.field756;
                              var6 = ++class32.field752 - 1;
                              var18 = (MessageNode)class47.field951.method2361((long)var15);
                              if(var18 == null) {
                                 var34 = -1;
                              } else if(var18.previous == class47.field952.field1902) {
                                 var34 = -1;
                              } else {
                                 var34 = ((MessageNode)var18.previous).id;
                              }

                              var39[var6] = var34;
                              var3 = 1;
                           } else if(var0 == 5019) {
                              var15 = class32.field756[--class32.field752];
                              var39 = class32.field756;
                              var6 = ++class32.field752 - 1;
                              var18 = (MessageNode)class47.field951.method2361((long)var15);
                              if(var18 == null) {
                                 var34 = -1;
                              } else if(class47.field952.field1902 == var18.next) {
                                 var34 = -1;
                              } else {
                                 var34 = ((MessageNode)var18.next).id;
                              }

                              var39[var6] = var34;
                              var3 = 1;
                           } else if(var0 == 5020) {
                              var22 = class32.scriptStringStack[--class9.scriptStringStackSize];
                              RSCanvas.method2139(var22);
                              var3 = 1;
                           } else if(var0 == 5021) {
                              Client.field533 = class32.scriptStringStack[--class9.scriptStringStackSize].toLowerCase().trim();
                              var3 = 1;
                           } else if(var0 == 5022) {
                              class32.scriptStringStack[++class9.scriptStringStackSize - 1] = Client.field533;
                              var3 = 1;
                           } else {
                              var3 = 2;
                           }
                        }

                        return var3;
                     } else if(var0 < 5400) {
                        if(var0 == 5306) {
                           class32.field756[++class32.field752 - 1] = class13.method196();
                           var3 = 1;
                        } else if(var0 == 5307) {
                           var15 = class32.field756[--class32.field752];
                           if(var15 == 1 || var15 == 2) {
                              Client.field342 = 0L;
                              if(var15 >= 2) {
                                 Client.isResized = true;
                              } else {
                                 Client.isResized = false;
                              }

                              class22.method235();
                              if(Client.gameState >= 25) {
                                 class45.method910();
                              }

                              GameEngine.field1787 = true;
                           }

                           var3 = 1;
                        } else if(var0 == 5308) {
                           class32.field756[++class32.field752 - 1] = class8.field84.field715;
                           var3 = 1;
                        } else if(var0 == 5309) {
                           var15 = class32.field756[--class32.field752];
                           if(var15 == 1 || var15 == 2) {
                              class8.field84.field715 = var15;
                              class0.method10();
                           }

                           var3 = 1;
                        } else {
                           var3 = 2;
                        }

                        return var3;
                     } else if(var0 < 5600) {
                        return ItemLayer.method1519(var0, var1, var2);
                     } else if(var0 < 5700) {
                        if(var0 == 5630) {
                           Client.field365 = 250;
                           var3 = 1;
                        } else {
                           var3 = 2;
                        }

                        return var3;
                     } else if(var0 < 6300) {
                        return class176.method3278(var0, var1, var2);
                     } else if(var0 >= 6600) {
                        return 2;
                     } else {
                        if(var0 == 6500) {
                           class32.field756[++class32.field752 - 1] = class108.loadWorlds()?1:0;
                           var3 = 1;
                        } else {
                           World var4;
                           if(var0 == 6501) {
                              var4 = class167.method3198();
                              if(null != var4) {
                                 class32.field756[++class32.field752 - 1] = var4.id;
                                 class32.field756[++class32.field752 - 1] = var4.mask;
                                 class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var4.activity;
                                 class32.field756[++class32.field752 - 1] = var4.location;
                                 class32.field756[++class32.field752 - 1] = var4.playerCount;
                                 class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var4.address;
                              } else {
                                 class32.field756[++class32.field752 - 1] = -1;
                                 class32.field756[++class32.field752 - 1] = 0;
                                 class32.scriptStringStack[++class9.scriptStringStackSize - 1] = "";
                                 class32.field756[++class32.field752 - 1] = 0;
                                 class32.field756[++class32.field752 - 1] = 0;
                                 class32.scriptStringStack[++class9.scriptStringStackSize - 1] = "";
                              }

                              var3 = 1;
                           } else if(var0 == 6502) {
                              var4 = CollisionData.method2318();
                              if(null != var4) {
                                 class32.field756[++class32.field752 - 1] = var4.id;
                                 class32.field756[++class32.field752 - 1] = var4.mask;
                                 class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var4.activity;
                                 class32.field756[++class32.field752 - 1] = var4.location;
                                 class32.field756[++class32.field752 - 1] = var4.playerCount;
                                 class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var4.address;
                              } else {
                                 class32.field756[++class32.field752 - 1] = -1;
                                 class32.field756[++class32.field752 - 1] = 0;
                                 class32.scriptStringStack[++class9.scriptStringStackSize - 1] = "";
                                 class32.field756[++class32.field752 - 1] = 0;
                                 class32.field756[++class32.field752 - 1] = 0;
                                 class32.scriptStringStack[++class9.scriptStringStackSize - 1] = "";
                              }

                              var3 = 1;
                           } else {
                              World var16;
                              if(var0 == 6506) {
                                 var15 = class32.field756[--class32.field752];
                                 var16 = null;

                                 for(var6 = 0; var6 < World.field697; ++var6) {
                                    if(World.worldList[var6].id == var15) {
                                       var16 = World.worldList[var6];
                                       break;
                                    }
                                 }

                                 if(var16 != null) {
                                    class32.field756[++class32.field752 - 1] = var16.id;
                                    class32.field756[++class32.field752 - 1] = var16.mask;
                                    class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var16.activity;
                                    class32.field756[++class32.field752 - 1] = var16.location;
                                    class32.field756[++class32.field752 - 1] = var16.playerCount;
                                    class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var16.address;
                                 } else {
                                    class32.field756[++class32.field752 - 1] = -1;
                                    class32.field756[++class32.field752 - 1] = 0;
                                    class32.scriptStringStack[++class9.scriptStringStackSize - 1] = "";
                                    class32.field756[++class32.field752 - 1] = 0;
                                    class32.field756[++class32.field752 - 1] = 0;
                                    class32.scriptStringStack[++class9.scriptStringStackSize - 1] = "";
                                 }

                                 var3 = 1;
                              } else if(var0 == 6507) {
                                 class32.field752 -= 4;
                                 var15 = class32.field756[class32.field752];
                                 var5 = class32.field756[class32.field752 + 1] == 1;
                                 var6 = class32.field756[2 + class32.field752];
                                 var7 = class32.field756[class32.field752 + 3] == 1;
                                 if(null != World.worldList) {
                                    Ignore.method218(0, World.worldList.length - 1, var15, var5, var6, var7);
                                 }

                                 var3 = 1;
                              } else if(var0 == 6511) {
                                 var15 = class32.field756[--class32.field752];
                                 if(var15 >= 0 && var15 < World.field697) {
                                    var16 = World.worldList[var15];
                                    class32.field756[++class32.field752 - 1] = var16.id;
                                    class32.field756[++class32.field752 - 1] = var16.mask;
                                    class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var16.activity;
                                    class32.field756[++class32.field752 - 1] = var16.location;
                                    class32.field756[++class32.field752 - 1] = var16.playerCount;
                                    class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var16.address;
                                 } else {
                                    class32.field756[++class32.field752 - 1] = -1;
                                    class32.field756[++class32.field752 - 1] = 0;
                                    class32.scriptStringStack[++class9.scriptStringStackSize - 1] = "";
                                    class32.field756[++class32.field752 - 1] = 0;
                                    class32.field756[++class32.field752 - 1] = 0;
                                    class32.scriptStringStack[++class9.scriptStringStackSize - 1] = "";
                                 }

                                 var3 = 1;
                              } else if(var0 == 6512) {
                                 Client.field346 = class32.field756[--class32.field752] == 1;
                                 var3 = 1;
                              } else {
                                 var3 = 2;
                              }
                           }
                        }

                        return var3;
                     }
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "71"
   )
   public static void method230() {
      NPCComposition.field3013.reset();
      NPCComposition.npcModelCache.reset();
   }
}

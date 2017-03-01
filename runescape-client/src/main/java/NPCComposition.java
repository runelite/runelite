import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("l")
   short[] field3006;
   @ObfuscatedName("n")
   static class182 field3007;
   @ObfuscatedName("g")
   public static NodeCache field3008 = new NodeCache(64);
   @ObfuscatedName("af")
   @Export("isClickable")
   public boolean isClickable = true;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1861802265
   )
   @Export("id")
   public int id;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2013284643
   )
   public int field3011 = -1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 60422143
   )
   int field3012 = 128;
   @ObfuscatedName("m")
   @Export("models")
   int[] models;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1281763227
   )
   int field3014 = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -476685063
   )
   public int field3015 = -1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2041280971
   )
   public int field3016 = -1;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 445075217
   )
   public int field3017 = -1;
   @ObfuscatedName("ae")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1648271799
   )
   public int field3019 = -1;
   @ObfuscatedName("p")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1023479991
   )
   public int field3021 = -1;
   @ObfuscatedName("b")
   short[] field3022;
   @ObfuscatedName("w")
   short[] field3023;
   @ObfuscatedName("r")
   short[] field3024;
   @ObfuscatedName("u")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("a")
   int[] field3026;
   @ObfuscatedName("e")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible = true;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 99508859
   )
   @Export("combatLevel")
   public int combatLevel = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -593457691
   )
   public int field3029 = -1;
   @ObfuscatedName("v")
   @Export("npcModelCache")
   public static NodeCache npcModelCache = new NodeCache(50);
   @ObfuscatedName("t")
   @Export("isVisible")
   public boolean isVisible = false;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 262820701
   )
   int field3032 = 0;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1091657679
   )
   int field3033 = 0;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 708678697
   )
   public int field3034 = -1;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 445840459
   )
   public int field3035 = 32;
   @ObfuscatedName("x")
   static class182 field3036;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 386099379
   )
   int field3037 = 128;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -597235587
   )
   int field3038 = -1;
   @ObfuscatedName("aa")
   public boolean field3039 = true;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1115989085
   )
   public int field3040 = 1;
   @ObfuscatedName("as")
   public boolean field3041 = false;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1640344947"
   )
   void method3776(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         this.models = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.models[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 2) {
         this.name = var1.readString();
      } else if(var2 == 12) {
         this.field3040 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3015 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3011 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3016 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3017 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3011 = var1.readUnsignedShort();
         this.field3019 = var1.readUnsignedShort();
         this.field3029 = var1.readUnsignedShort();
         this.field3021 = var1.readUnsignedShort();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.readString();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.field3022 = new short[var3];
         this.field3023 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3022[var4] = (short)var1.readUnsignedShort();
            this.field3023[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.field3006 = new short[var3];
         this.field3024 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3006[var4] = (short)var1.readUnsignedShort();
            this.field3024[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3026 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3026[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.field3037 = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.field3012 = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field3032 = var1.readByte();
      } else if(var2 == 101) {
         this.field3033 = var1.readByte() * 5;
      } else if(var2 == 102) {
         this.field3034 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3035 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3039 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3041 = true;
         }
      } else {
         this.field3014 = var1.readUnsignedShort();
         if(this.field3014 == '\uffff') {
            this.field3014 = -1;
         }

         this.field3038 = var1.readUnsignedShort();
         if(this.field3038 == '\uffff') {
            this.field3038 = -1;
         }

         var3 = -1;
         if(var2 == 118) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         var4 = var1.readUnsignedByte();
         this.configs = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.configs[var5] = var1.readUnsignedShort();
            if(this.configs[var5] == '\uffff') {
               this.configs[var5] = -1;
            }
         }

         this.configs[1 + var4] = var3;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "2052919030"
   )
   public final Model method3777(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.configs != null) {
         NPCComposition var12 = this.method3779();
         return null == var12?null:var12.method3777(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(null == var5) {
            boolean var10 = false;

            for(int var7 = 0; var7 < this.models.length; ++var7) {
               if(!field3007.method3356(this.models[var7], 0)) {
                  var10 = true;
               }
            }

            if(var10) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method1547(field3007, this.models[var9], 0);
            }

            ModelData var11;
            if(var8.length == 1) {
               var11 = var8[0];
            } else {
               var11 = new ModelData(var8, var8.length);
            }

            if(null != this.field3022) {
               for(var9 = 0; var9 < this.field3022.length; ++var9) {
                  var11.method1617(this.field3022[var9], this.field3023[var9]);
               }
            }

            if(null != this.field3006) {
               for(var9 = 0; var9 < this.field3006.length; ++var9) {
                  var11.method1612(this.field3006[var9], this.field3024[var9]);
               }
            }

            var5 = var11.method1624(64 + this.field3032, this.field3033 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var6;
         if(null != var1 && var3 != null) {
            var6 = var1.method3831(var5, var2, var3, var4);
         } else if(var1 != null) {
            var6 = var1.method3818(var5, var2);
         } else if(var3 != null) {
            var6 = var3.method3818(var5, var4);
         } else {
            var6 = var5.method1697(true);
         }

         if(this.field3037 != 128 || this.field3012 != 128) {
            var6.method1660(this.field3037, this.field3012, this.field3037);
         }

         return var6;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2135211157"
   )
   void method3778() {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)LNPCComposition;",
      garbageValue = "1720923597"
   )
   public final NPCComposition method3779() {
      int var1 = -1;
      if(this.field3014 != -1) {
         var1 = class18.method202(this.field3014);
      } else if(this.field3038 != -1) {
         var1 = class165.widgetSettings[this.field3038];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?class159.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIII)V",
      garbageValue = "603351555"
   )
   static final void method3780(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2221 || MessageNode.method220(var9) != 0 || Client.field463 == var9 || var9.contentType == 1338) && var1 == var9.parentId && (!var9.hasScript || !class9.method114(var9))) {
            int var10 = var9.relativeX + var6;
            int var11 = var7 + var9.relativeY;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            if(var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.type == 9) {
               var16 = var10;
               var17 = var11;
               var18 = var10 + var9.width;
               var19 = var9.height + var11;
               if(var18 < var10) {
                  var16 = var18;
                  var18 = var10;
               }

               if(var19 < var11) {
                  var17 = var19;
                  var19 = var11;
               }

               ++var18;
               ++var19;
               var12 = var16 > var2?var16:var2;
               var13 = var17 > var3?var17:var3;
               var14 = var18 < var4?var18:var4;
               var15 = var19 < var5?var19:var5;
            } else {
               var16 = var9.width + var10;
               var17 = var9.height + var11;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(Client.field462 == var9) {
               Client.field413 = true;
               Client.field471 = var10;
               Client.field344 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = class115.field1805;
               var17 = class115.field1806;
               if(class115.field1811 != 0) {
                  var16 = class115.field1812;
                  var17 = class115.field1813;
               }

               if(var9.contentType == 1337) {
                  if(!Client.field294 && !Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     class37.method808(var16, var17, var12, var13);
                  }
               } else if(var9.contentType == 1338) {
                  class38.method820(var9, var10, var11);
               } else {
                  int var20;
                  int var22;
                  int var23;
                  int var24;
                  int var33;
                  boolean var42;
                  if(!Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     var18 = var16 - var10;
                     var19 = var17 - var11;
                     if(var9.field2209 == 1) {
                        class6.addMenuEntry(var9.tooltip, "", 24, 0, 0, var9.id);
                     }

                     String var34;
                     if(var9.field2209 == 2 && !Client.field444) {
                        var22 = MessageNode.method220(var9);
                        var33 = var22 >> 11 & 63;
                        if(var33 == 0) {
                           var34 = null;
                        } else if(var9.field2251 != null && var9.field2251.trim().length() != 0) {
                           var34 = var9.field2251;
                        } else {
                           var34 = null;
                        }

                        if(null != var34) {
                           class6.addMenuEntry(var34, class37.method813('\uff00') + var9.field2258, 25, 0, -1, var9.id);
                        }
                     }

                     if(var9.field2209 == 3) {
                        class6.addMenuEntry("Close", "", 26, 0, 0, var9.id);
                     }

                     if(var9.field2209 == 4) {
                        class6.addMenuEntry(var9.tooltip, "", 28, 0, 0, var9.id);
                     }

                     if(var9.field2209 == 5) {
                        class6.addMenuEntry(var9.tooltip, "", 29, 0, 0, var9.id);
                     }

                     if(var9.field2209 == 6 && null == Client.field543) {
                        class6.addMenuEntry(var9.tooltip, "", 30, 0, -1, var9.id);
                     }

                     if(var9.type == 2) {
                        var20 = 0;

                        for(var33 = 0; var33 < var9.height; ++var33) {
                           for(var22 = 0; var22 < var9.width; ++var22) {
                              var23 = var22 * (var9.field2272 + 32);
                              var24 = var33 * (var9.field2273 + 32);
                              if(var20 < 20) {
                                 var23 += var9.field2316[var20];
                                 var24 += var9.field2275[var20];
                              }

                              if(var18 >= var23 && var19 >= var24 && var18 < 32 + var23 && var19 < var24 + 32) {
                                 Client.field405 = var20;
                                 class22.field237 = var9;
                                 if(var9.itemIds[var20] > 0) {
                                    ItemComposition var25 = ChatLineBuffer.getItemDefinition(var9.itemIds[var20] - 1);
                                    if(Client.field416 == 1 && class109.method2136(MessageNode.method220(var9))) {
                                       if(class33.field750 != var9.id || var20 != class6.field41) {
                                          class6.addMenuEntry("Use", Client.field443 + " " + "->" + " " + class37.method813(16748608) + var25.name, 31, var25.id, var20, var9.id);
                                       }
                                    } else if(Client.field444 && class109.method2136(MessageNode.method220(var9))) {
                                       if((CombatInfoListHolder.field759 & 16) == 16) {
                                          class6.addMenuEntry(Client.field353, Client.field448 + " " + "->" + " " + class37.method813(16748608) + var25.name, 32, var25.id, var20, var9.id);
                                       }
                                    } else {
                                       String[] var26 = var25.inventoryActions;
                                       if(Client.field460) {
                                          var26 = class145.method2800(var26);
                                       }

                                       int var27 = var25.method3754();
                                       if(class109.method2136(MessageNode.method220(var9))) {
                                          for(int var28 = 4; var28 >= 3; --var28) {
                                             boolean var29 = var28 == var27;
                                             if(var26 != null && null != var26[var28]) {
                                                byte var30;
                                                if(var28 == 3) {
                                                   var30 = 36;
                                                } else {
                                                   var30 = 37;
                                                }

                                                class188.method3520(var26[var28], class37.method813(16748608) + var25.name, var30, var25.id, var20, var9.id, var29);
                                             } else if(var28 == 4) {
                                                class188.method3520("Drop", class37.method813(16748608) + var25.name, 37, var25.id, var20, var9.id, var29);
                                             }
                                          }
                                       }

                                       int var47 = MessageNode.method220(var9);
                                       boolean var46 = (var47 >> 31 & 1) != 0;
                                       if(var46) {
                                          class6.addMenuEntry("Use", class37.method813(16748608) + var25.name, 38, var25.id, var20, var9.id);
                                       }

                                       Object var10000 = null;
                                       int var48;
                                       if(class109.method2136(MessageNode.method220(var9)) && null != var26) {
                                          for(var48 = 2; var48 >= 0; --var48) {
                                             boolean var31 = var27 == var48;
                                             if(var26[var48] != null) {
                                                byte var32 = 0;
                                                if(var48 == 0) {
                                                   var32 = 33;
                                                }

                                                if(var48 == 1) {
                                                   var32 = 34;
                                                }

                                                if(var48 == 2) {
                                                   var32 = 35;
                                                }

                                                class188.method3520(var26[var48], class37.method813(16748608) + var25.name, var32, var25.id, var20, var9.id, var31);
                                             }
                                          }
                                       }

                                       var26 = var9.field2277;
                                       if(Client.field460) {
                                          var26 = class145.method2800(var26);
                                       }

                                       if(var26 != null) {
                                          for(var48 = 4; var48 >= 0; --var48) {
                                             if(var26[var48] != null) {
                                                byte var49 = 0;
                                                if(var48 == 0) {
                                                   var49 = 39;
                                                }

                                                if(var48 == 1) {
                                                   var49 = 40;
                                                }

                                                if(var48 == 2) {
                                                   var49 = 41;
                                                }

                                                if(var48 == 3) {
                                                   var49 = 42;
                                                }

                                                if(var48 == 4) {
                                                   var49 = 43;
                                                }

                                                class6.addMenuEntry(var26[var48], class37.method813(16748608) + var25.name, var49, var25.id, var20, var9.id);
                                             }
                                          }
                                       }

                                       class6.addMenuEntry("Examine", class37.method813(16748608) + var25.name, 1005, var25.id, var20, var9.id);
                                    }
                                 }
                              }

                              ++var20;
                           }
                        }
                     }

                     if(var9.hasScript) {
                        if(Client.field444) {
                           var33 = MessageNode.method220(var9);
                           var42 = (var33 >> 21 & 1) != 0;
                           if(var42 && (CombatInfoListHolder.field759 & 32) == 32) {
                              class6.addMenuEntry(Client.field353, Client.field448 + " " + "->" + " " + var9.name, 58, 0, var9.index, var9.id);
                           }
                        } else {
                           for(var20 = 9; var20 >= 5; --var20) {
                              String var21 = Friend.method191(var9, var20);
                              if(null != var21) {
                                 class6.addMenuEntry(var21, var9.name, 1007, 1 + var20, var9.index, var9.id);
                              }
                           }

                           var22 = MessageNode.method220(var9);
                           var33 = var22 >> 11 & 63;
                           if(var33 == 0) {
                              var34 = null;
                           } else if(var9.field2251 != null && var9.field2251.trim().length() != 0) {
                              var34 = var9.field2251;
                           } else {
                              var34 = null;
                           }

                           if(var34 != null) {
                              class6.addMenuEntry(var34, var9.name, 25, 0, var9.index, var9.id);
                           }

                           for(var22 = 4; var22 >= 0; --var22) {
                              String var38 = Friend.method191(var9, var22);
                              if(null != var38) {
                                 class6.addMenuEntry(var38, var9.name, 57, 1 + var22, var9.index, var9.id);
                              }
                           }

                           var23 = MessageNode.method220(var9);
                           boolean var45 = (var23 & 1) != 0;
                           if(var45) {
                              class6.addMenuEntry("Continue", "", 30, 0, var9.index, var9.id);
                           }
                        }
                     }
                  }

                  if(var9.type == 0) {
                     if(!var9.hasScript && class9.method114(var9) && var9 != class45.field924) {
                        continue;
                     }

                     method3780(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method3780(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetNode var35 = (WidgetNode)Client.componentTable.method2437((long)var9.id);
                     if(null != var35) {
                        if(var35.field176 == 0 && class115.field1805 >= var12 && class115.field1806 >= var13 && class115.field1805 < var14 && class115.field1806 < var15 && !Client.isMenuOpen && !Client.field470) {
                           for(class18 var36 = (class18)Client.field488.method2503(); null != var36; var36 = (class18)Client.field488.method2492()) {
                              if(var36.field201) {
                                 var36.unlink();
                                 var36.field188.field2300 = false;
                              }
                           }

                           if(class40.field815 == 0) {
                              Client.field462 = null;
                              Client.field463 = null;
                           }

                           if(!Client.isMenuOpen) {
                              class108.method2131();
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.menuOptionCount = 1;
                           }
                        }

                        var19 = var35.id;
                        if(Projectile.method874(var19)) {
                           method3780(class231.widgets[var19], -1, var12, var13, var14, var15, var10, var11);
                        }
                     }
                  }

                  if(var9.hasScript) {
                     class18 var51;
                     if(!var9.field2235) {
                        if(var9.field2340 && class115.field1805 >= var12 && class115.field1806 >= var13 && class115.field1805 < var14 && class115.field1806 < var15) {
                           for(var51 = (class18)Client.field488.method2503(); null != var51; var51 = (class18)Client.field488.method2492()) {
                              if(var51.field201 && var51.field196 == var51.field188.field2307) {
                                 var51.unlink();
                              }
                           }
                        }
                     } else if(class115.field1805 >= var12 && class115.field1806 >= var13 && class115.field1805 < var14 && class115.field1806 < var15) {
                        for(var51 = (class18)Client.field488.method2503(); null != var51; var51 = (class18)Client.field488.method2492()) {
                           if(var51.field201) {
                              var51.unlink();
                              var51.field188.field2300 = false;
                           }
                        }

                        if(class40.field815 == 0) {
                           Client.field462 = null;
                           Client.field463 = null;
                        }

                        if(!Client.isMenuOpen) {
                           Client.menuOptions[0] = "Cancel";
                           Client.menuTargets[0] = "";
                           Client.menuTypes[0] = 1006;
                           Client.menuOptionCount = 1;
                        }
                     }

                     boolean var41;
                     if(class115.field1805 >= var12 && class115.field1806 >= var13 && class115.field1805 < var14 && class115.field1806 < var15) {
                        var41 = true;
                     } else {
                        var41 = false;
                     }

                     boolean var43 = false;
                     if((class115.field1802 == 1 || !Client.field291 && class115.field1802 == 4) && var41) {
                        var43 = true;
                     }

                     var42 = false;
                     if((class115.field1811 == 1 || !Client.field291 && class115.field1811 == 4) && class115.field1812 >= var12 && class115.field1813 >= var13 && class115.field1812 < var14 && class115.field1813 < var15) {
                        var42 = true;
                     }

                     if(var42) {
                        class99.method2038(var9, class115.field1812 - var10, class115.field1813 - var11);
                     }

                     if(null != Client.field462 && var9 != Client.field462 && var41) {
                        var22 = MessageNode.method220(var9);
                        boolean var50 = (var22 >> 20 & 1) != 0;
                        if(var50) {
                           Client.field563 = var9;
                        }
                     }

                     if(var9 == Client.field463) {
                        Client.field467 = true;
                        Client.field523 = var10;
                        Client.field307 = var11;
                     }

                     if(var9.field2221) {
                        class18 var44;
                        if(var41 && Client.field487 != 0 && null != var9.field2307) {
                           var44 = new class18();
                           var44.field201 = true;
                           var44.field188 = var9;
                           var44.field190 = Client.field487;
                           var44.field196 = var9.field2307;
                           Client.field488.method2511(var44);
                        }

                        if(Client.field462 != null || class15.field159 != null || Client.isMenuOpen) {
                           var42 = false;
                           var43 = false;
                           var41 = false;
                        }

                        if(!var9.field2332 && var42) {
                           var9.field2332 = true;
                           if(null != var9.field2288) {
                              var44 = new class18();
                              var44.field201 = true;
                              var44.field188 = var9;
                              var44.field189 = class115.field1812 - var10;
                              var44.field190 = class115.field1813 - var11;
                              var44.field196 = var9.field2288;
                              Client.field488.method2511(var44);
                           }
                        }

                        if(var9.field2332 && var43 && null != var9.field2207) {
                           var44 = new class18();
                           var44.field201 = true;
                           var44.field188 = var9;
                           var44.field189 = class115.field1805 - var10;
                           var44.field190 = class115.field1806 - var11;
                           var44.field196 = var9.field2207;
                           Client.field488.method2511(var44);
                        }

                        if(var9.field2332 && !var43) {
                           var9.field2332 = false;
                           if(null != var9.field2274) {
                              var44 = new class18();
                              var44.field201 = true;
                              var44.field188 = var9;
                              var44.field189 = class115.field1805 - var10;
                              var44.field190 = class115.field1806 - var11;
                              var44.field196 = var9.field2274;
                              Client.field359.method2511(var44);
                           }
                        }

                        if(var43 && null != var9.field2203) {
                           var44 = new class18();
                           var44.field201 = true;
                           var44.field188 = var9;
                           var44.field189 = class115.field1805 - var10;
                           var44.field190 = class115.field1806 - var11;
                           var44.field196 = var9.field2203;
                           Client.field488.method2511(var44);
                        }

                        if(!var9.field2300 && var41) {
                           var9.field2300 = true;
                           if(null != var9.field2292) {
                              var44 = new class18();
                              var44.field201 = true;
                              var44.field188 = var9;
                              var44.field189 = class115.field1805 - var10;
                              var44.field190 = class115.field1806 - var11;
                              var44.field196 = var9.field2292;
                              Client.field488.method2511(var44);
                           }
                        }

                        if(var9.field2300 && var41 && null != var9.field2293) {
                           var44 = new class18();
                           var44.field201 = true;
                           var44.field188 = var9;
                           var44.field189 = class115.field1805 - var10;
                           var44.field190 = class115.field1806 - var11;
                           var44.field196 = var9.field2293;
                           Client.field488.method2511(var44);
                        }

                        if(var9.field2300 && !var41) {
                           var9.field2300 = false;
                           if(var9.field2294 != null) {
                              var44 = new class18();
                              var44.field201 = true;
                              var44.field188 = var9;
                              var44.field189 = class115.field1805 - var10;
                              var44.field190 = class115.field1806 - var11;
                              var44.field196 = var9.field2294;
                              Client.field359.method2511(var44);
                           }
                        }

                        if(null != var9.field2305) {
                           var44 = new class18();
                           var44.field188 = var9;
                           var44.field196 = var9.field2305;
                           Client.field531.method2511(var44);
                        }

                        class18 var37;
                        if(var9.field2299 != null && Client.field476 > var9.field2334) {
                           if(null != var9.field2253 && Client.field476 - var9.field2334 <= 32) {
                              label1131:
                              for(var33 = var9.field2334; var33 < Client.field476; ++var33) {
                                 var22 = Client.field496[var33 & 31];

                                 for(var23 = 0; var23 < var9.field2253.length; ++var23) {
                                    if(var9.field2253[var23] == var22) {
                                       var37 = new class18();
                                       var37.field188 = var9;
                                       var37.field196 = var9.field2299;
                                       Client.field488.method2511(var37);
                                       break label1131;
                                    }
                                 }
                              }
                           } else {
                              var44 = new class18();
                              var44.field188 = var9;
                              var44.field196 = var9.field2299;
                              Client.field488.method2511(var44);
                           }

                           var9.field2334 = Client.field476;
                        }

                        if(var9.field2301 != null && Client.field478 > var9.field2335) {
                           if(null != var9.field2302 && Client.field478 - var9.field2335 <= 32) {
                              label1107:
                              for(var33 = var9.field2335; var33 < Client.field478; ++var33) {
                                 var22 = Client.interfaceItemTriggers[var33 & 31];

                                 for(var23 = 0; var23 < var9.field2302.length; ++var23) {
                                    if(var9.field2302[var23] == var22) {
                                       var37 = new class18();
                                       var37.field188 = var9;
                                       var37.field196 = var9.field2301;
                                       Client.field488.method2511(var37);
                                       break label1107;
                                    }
                                 }
                              }
                           } else {
                              var44 = new class18();
                              var44.field188 = var9;
                              var44.field196 = var9.field2301;
                              Client.field488.method2511(var44);
                           }

                           var9.field2335 = Client.field478;
                        }

                        if(null != var9.field2303 && Client.field480 > var9.field2336) {
                           if(var9.field2304 != null && Client.field480 - var9.field2336 <= 32) {
                              label1083:
                              for(var33 = var9.field2336; var33 < Client.field480; ++var33) {
                                 var22 = Client.field479[var33 & 31];

                                 for(var23 = 0; var23 < var9.field2304.length; ++var23) {
                                    if(var9.field2304[var23] == var22) {
                                       var37 = new class18();
                                       var37.field188 = var9;
                                       var37.field196 = var9.field2303;
                                       Client.field488.method2511(var37);
                                       break label1083;
                                    }
                                 }
                              }
                           } else {
                              var44 = new class18();
                              var44.field188 = var9;
                              var44.field196 = var9.field2303;
                              Client.field488.method2511(var44);
                           }

                           var9.field2336 = Client.field480;
                        }

                        if(Client.field481 > var9.field2238 && var9.field2308 != null) {
                           var44 = new class18();
                           var44.field188 = var9;
                           var44.field196 = var9.field2308;
                           Client.field488.method2511(var44);
                        }

                        if(Client.field482 > var9.field2238 && null != var9.field2286) {
                           var44 = new class18();
                           var44.field188 = var9;
                           var44.field196 = var9.field2286;
                           Client.field488.method2511(var44);
                        }

                        if(Client.field483 > var9.field2238 && var9.field2322 != null) {
                           var44 = new class18();
                           var44.field188 = var9;
                           var44.field196 = var9.field2322;
                           Client.field488.method2511(var44);
                        }

                        if(Client.field288 > var9.field2238 && null != var9.field2276) {
                           var44 = new class18();
                           var44.field188 = var9;
                           var44.field196 = var9.field2276;
                           Client.field488.method2511(var44);
                        }

                        if(Client.field485 > var9.field2238 && var9.field2317 != null) {
                           var44 = new class18();
                           var44.field188 = var9;
                           var44.field196 = var9.field2317;
                           Client.field488.method2511(var44);
                        }

                        if(Client.field486 > var9.field2238 && var9.field2312 != null) {
                           var44 = new class18();
                           var44.field188 = var9;
                           var44.field196 = var9.field2312;
                           Client.field488.method2511(var44);
                        }

                        var9.field2238 = Client.field505;
                        if(null != var9.field2309) {
                           for(var33 = 0; var33 < Client.field420; ++var33) {
                              class18 var39 = new class18();
                              var39.field188 = var9;
                              var39.field193 = Client.field521[var33];
                              var39.field194 = Client.field298[var33];
                              var39.field196 = var9.field2309;
                              Client.field488.method2511(var39);
                           }
                        }
                     }
                  }

                  if(!var9.hasScript && Client.field462 == null && class15.field159 == null && !Client.isMenuOpen) {
                     if((var9.field2321 >= 0 || var9.field2285 != 0) && class115.field1805 >= var12 && class115.field1806 >= var13 && class115.field1805 < var14 && class115.field1806 < var15) {
                        if(var9.field2321 >= 0) {
                           class45.field924 = var0[var9.field2321];
                        } else {
                           class45.field924 = var9;
                        }
                     }

                     if(var9.type == 8 && class115.field1805 >= var12 && class115.field1806 >= var13 && class115.field1805 < var14 && class115.field1806 < var15) {
                        class5.field40 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        var18 = var9.width + var10;
                        var19 = var9.height;
                        var20 = var9.scrollHeight;
                        var33 = class115.field1805;
                        var22 = class115.field1806;
                        if(Client.field370) {
                           Client.field371 = 32;
                        } else {
                           Client.field371 = 0;
                        }

                        Client.field370 = false;
                        if(class115.field1802 == 1 || !Client.field291 && class115.field1802 == 4) {
                           if(var33 >= var18 && var33 < 16 + var18 && var22 >= var11 && var22 < 16 + var11) {
                              var9.scrollY -= 4;
                              ChatLineBuffer.method996(var9);
                           } else if(var33 >= var18 && var33 < 16 + var18 && var22 >= var19 + var11 - 16 && var22 < var11 + var19) {
                              var9.scrollY += 4;
                              ChatLineBuffer.method996(var9);
                           } else if(var33 >= var18 - Client.field371 && var33 < 16 + var18 + Client.field371 && var22 >= 16 + var11 && var22 < var19 + var11 - 16) {
                              var23 = (var19 - 32) * var19 / var20;
                              if(var23 < 8) {
                                 var23 = 8;
                              }

                              var24 = var22 - var11 - 16 - var23 / 2;
                              int var40 = var19 - 32 - var23;
                              var9.scrollY = (var20 - var19) * var24 / var40;
                              ChatLineBuffer.method996(var9);
                              Client.field370 = true;
                           }
                        }

                        if(Client.field487 != 0) {
                           var23 = var9.width;
                           if(var33 >= var18 - var23 && var22 >= var11 && var33 < var18 + 16 && var22 <= var11 + var19) {
                              var9.scrollY += Client.field487 * 45;
                              ChatLineBuffer.method996(var9);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-8"
   )
   public boolean method3784() {
      if(null == this.configs) {
         return true;
      } else {
         int var1 = -1;
         if(this.field3014 != -1) {
            var1 = class18.method202(this.field3014);
         } else if(this.field3038 != -1) {
            var1 = class165.widgetSettings[this.field3038];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "-1055371428"
   )
   public final ModelData method3795() {
      if(null != this.configs) {
         NPCComposition var1 = this.method3779();
         return null == var1?null:var1.method3795();
      } else if(this.field3026 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field3026.length; ++var2) {
            if(!field3007.method3356(this.field3026[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.field3026.length];

            for(int var3 = 0; var3 < this.field3026.length; ++var3) {
               var6[var3] = ModelData.method1547(field3007, this.field3026[var3], 0);
            }

            ModelData var7;
            if(var6.length == 1) {
               var7 = var6[0];
            } else {
               var7 = new ModelData(var6, var6.length);
            }

            int var4;
            if(this.field3022 != null) {
               for(var4 = 0; var4 < this.field3022.length; ++var4) {
                  var7.method1617(this.field3022[var4], this.field3023[var4]);
               }
            }

            if(this.field3006 != null) {
               for(var4 = 0; var4 < this.field3006.length; ++var4) {
                  var7.method1612(this.field3006[var4], this.field3024[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "25"
   )
   public static void method3798() {
      if(class105.keyboard != null) {
         class105 var0 = class105.keyboard;
         synchronized(class105.keyboard) {
            class105.keyboard = null;
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;S)V",
      garbageValue = "256"
   )
   void method3799(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3776(var1, var2);
      }
   }
}

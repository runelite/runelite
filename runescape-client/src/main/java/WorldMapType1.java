import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
@Implements("WorldMapType1")
public class WorldMapType1 implements WorldMapSectionBase {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1884927939
   )
   int field418;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1595905047
   )
   int field407;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1225402635
   )
   int field411;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1441900163
   )
   int field410;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1119999725
   )
   int field417;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1103272513
   )
   int field412;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 452967215
   )
   int field413;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 566717889
   )
   int field414;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1169431855
   )
   int field415;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1745588751
   )
   int field416;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Laz;I)V",
      garbageValue = "1596430382"
   )
   public void vmethod695(WorldMapData var1) {
      if(var1.field437 > this.field413) {
         var1.field437 = this.field413;
      }

      if(var1.field434 < this.field415) {
         var1.field434 = this.field415;
      }

      if(var1.field436 > this.field414) {
         var1.field436 = this.field414;
      }

      if(var1.field440 < this.field416) {
         var1.field440 = this.field416;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-76"
   )
   public boolean vmethod696(int var1, int var2, int var3) {
      return var1 >= this.field418 && var1 < this.field418 + this.field407?var2 >> 6 >= this.field411 && var2 >> 6 <= this.field417 && var3 >> 6 >= this.field410 && var3 >> 6 <= this.field412:false;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-870088204"
   )
   public boolean vmethod697(int var1, int var2) {
      return var1 >> 6 >= this.field413 && var1 >> 6 <= this.field415 && var2 >> 6 >= this.field414 && var2 >> 6 <= this.field416;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "438384537"
   )
   public int[] vmethod716(int var1, int var2, int var3) {
      if(!this.vmethod696(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field413 * 64 - this.field411 * 64 + var2, var3 + (this.field414 * 64 - this.field410 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)Lht;",
      garbageValue = "1662378690"
   )
   public Coordinates vmethod694(int var1, int var2) {
      if(!this.vmethod697(var1, var2)) {
         return null;
      } else {
         int var3 = this.field411 * 64 - this.field413 * 64 + var1;
         int var4 = this.field410 * 64 - this.field414 * 64 + var2;
         return new Coordinates(this.field418, var3, var4);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgv;I)V",
      garbageValue = "1961822977"
   )
   public void vmethod700(Buffer var1) {
      this.field418 = var1.readUnsignedByte();
      this.field407 = var1.readUnsignedByte();
      this.field411 = var1.readUnsignedShort();
      this.field410 = var1.readUnsignedShort();
      this.field417 = var1.readUnsignedShort();
      this.field412 = var1.readUnsignedShort();
      this.field413 = var1.readUnsignedShort();
      this.field414 = var1.readUnsignedShort();
      this.field415 = var1.readUnsignedShort();
      this.field416 = var1.readUnsignedShort();
      this.method245();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1988218036"
   )
   void method245() {
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(BI)C",
      garbageValue = "2075194105"
   )
   public static char method267(byte var0) {
      int var1 = var0 & 255;
      if(var1 == 0) {
         throw new IllegalArgumentException("");
      } else {
         if(var1 >= 128 && var1 < 160) {
            char var2 = class277.cp1252AsciiExtension[var1 - 128];
            if(var2 == 0) {
               var2 = '?';
            }

            var1 = var2;
         }

         return (char)var1;
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "614524952"
   )
   protected static int method264() {
      int var0 = 0;
      if(FileOnDisk.field1675 == null || !FileOnDisk.field1675.isValid()) {
         try {
            Iterator var1 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

            while(var1.hasNext()) {
               GarbageCollectorMXBean var2 = (GarbageCollectorMXBean)var1.next();
               if(var2.isValid()) {
                  FileOnDisk.field1675 = var2;
                  GameEngine.garbageCollectorLastCheckTimeMs = -1L;
                  GameEngine.garbageCollectorLastCollectionTime = -1L;
               }
            }
         } catch (Throwable var11) {
            ;
         }
      }

      if(FileOnDisk.field1675 != null) {
         long var9 = class60.currentTimeMs();
         long var3 = FileOnDisk.field1675.getCollectionTime();
         if(-1L != GameEngine.garbageCollectorLastCollectionTime) {
            long var5 = var3 - GameEngine.garbageCollectorLastCollectionTime;
            long var7 = var9 - GameEngine.garbageCollectorLastCheckTimeMs;
            if(var7 != 0L) {
               var0 = (int)(var5 * 100L / var7);
            }
         }

         GameEngine.garbageCollectorLastCollectionTime = var3;
         GameEngine.garbageCollectorLastCheckTimeMs = var9;
      }

      return var0;
   }

   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "3915"
   )
   static final void method254() {
      int var0 = class94.playerIndexesCount;
      int[] var1 = class94.playerIndices;

      for(int var2 = 0; var2 < var0; ++var2) {
         Player var3 = Client.cachedPlayers[var1[var2]];
         if(var3 != null) {
            class215.method4018(var3, 1);
         }
      }

   }

   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1582221925"
   )
   static final void method265(int var0, int var1) {
      if(Client.menuOptionCount >= 2 || Client.itemSelectionState != 0 || Client.spellSelected) {
         int var2 = class240.method4281();
         String var3;
         if(Client.itemSelectionState == 1 && Client.menuOptionCount < 2) {
            var3 = "Use" + " " + Client.lastSelectedItemName + " " + "->";
         } else if(Client.spellSelected && Client.menuOptionCount < 2) {
            var3 = Client.field1013 + " " + Client.field1014 + " " + "->";
         } else {
            var3 = class22.method162(var2);
         }

         if(Client.menuOptionCount > 2) {
            var3 = var3 + class54.getColTags(16777215) + " " + '/' + " " + (Client.menuOptionCount - 2) + " more options";
         }

         class36.fontBold12.drawRandomizedMouseoverText(var3, var0 + 4, var1 + 15, 16777215, 0, Client.gameCycle / 1000);
      }
   }

   @ObfuscatedName("ji")
   @ObfuscatedSignature(
      signature = "([Lhq;IIIIIIIB)V",
      garbageValue = "-32"
   )
   static final void method238(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2890 || GraphicsObject.getWidgetConfig(var9) != 0 || var9 == Client.field1029 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.hasScript || !class20.method150(var9))) {
            int var10 = var9.relativeX + var6;
            int var11 = var7 + var9.relativeY;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var19;
            if(var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.type == 9) {
               var16 = var10;
               var17 = var11;
               int var18 = var10 + var9.width;
               var19 = var11 + var9.height;
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
               var16 = var10 + var9.width;
               var17 = var11 + var9.height;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(var9 == Client.field1028) {
               Client.field1036 = true;
               Client.field1095 = var10;
               Client.field1038 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = MouseInput.mouseLastX;
               var17 = MouseInput.mouseLastY;
               if(MouseInput.mouseLastButton != 0) {
                  var16 = MouseInput.mouseLastPressedX;
                  var17 = MouseInput.mouseLastPressedY;
               }

               boolean var32 = var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15;
               if(var9.contentType == 1337) {
                  if(!Client.field881 && !Client.isMenuOpen && var32) {
                     class40.method539(var16, var17, var12, var13);
                  }
               } else if(var9.contentType == 1338) {
                  Renderable.method2929(var9, var10, var11);
               } else {
                  if(var9.contentType == 1400) {
                     TextureProvider.renderOverview.method5426(MouseInput.mouseLastX, MouseInput.mouseLastY, var32, var10, var11, var9.width, var9.height);
                  }

                  if(!Client.isMenuOpen && var32) {
                     if(var9.contentType == 1400) {
                        TextureProvider.renderOverview.method5506(var10, var11, var9.width, var9.height, var16, var17);
                     } else {
                        class228.method4255(var9, var16 - var10, var17 - var11);
                     }
                  }

                  if(var9.type == 0) {
                     if(!var9.hasScript && class20.method150(var9) && var9 != BoundingBox.field239) {
                        continue;
                     }

                     method238(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if(var9.children != null) {
                        method238(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetNode var27 = (WidgetNode)Client.componentTable.get((long)var9.id);
                     if(var27 != null) {
                        if(var27.owner == 0 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15 && !Client.isMenuOpen && !Client.field911) {
                           for(ScriptEvent var28 = (ScriptEvent)Client.field1054.getFront(); var28 != null; var28 = (ScriptEvent)Client.field1054.getNext()) {
                              if(var28.boolean1) {
                                 var28.unlink();
                                 var28.widget.field2887 = false;
                              }
                           }

                           if(class44.field555 == 0) {
                              Client.field1028 = null;
                              Client.field1029 = null;
                           }

                           if(!Client.isMenuOpen) {
                              NPCComposition.method4864();
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.menuBooleanArray[0] = false;
                              Client.menuOptionCount = 1;
                           }
                        }

                        class39.method534(var27.id, var12, var13, var14, var15, var10, var11);
                     }
                  }

                  int var22;
                  int var23;
                  int var29;
                  if(var9.hasScript) {
                     ScriptEvent var35;
                     if(!var9.noClickThrough) {
                        if(var9.field2803 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                           for(var35 = (ScriptEvent)Client.field1054.getFront(); var35 != null; var35 = (ScriptEvent)Client.field1054.getNext()) {
                              if(var35.boolean1 && var35.widget.scrollListener == var35.objs) {
                                 var35.unlink();
                              }
                           }
                        }
                     } else if(MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                        for(var35 = (ScriptEvent)Client.field1054.getFront(); var35 != null; var35 = (ScriptEvent)Client.field1054.getNext()) {
                           if(var35.boolean1) {
                              var35.unlink();
                              var35.widget.field2887 = false;
                           }
                        }

                        if(class44.field555 == 0) {
                           Client.field1028 = null;
                           Client.field1029 = null;
                        }

                        if(!Client.isMenuOpen) {
                           NPCComposition.method4864();
                           Client.menuOptions[0] = "Cancel";
                           Client.menuTargets[0] = "";
                           Client.menuTypes[0] = 1006;
                           Client.menuBooleanArray[0] = false;
                           Client.menuOptionCount = 1;
                        }
                     }

                     if(MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                        var32 = true;
                     } else {
                        var32 = false;
                     }

                     boolean var33 = false;
                     if((MouseInput.mouseCurrentButton == 1 || !class45.middleMouseMovesCamera && MouseInput.mouseCurrentButton == 4) && var32) {
                        var33 = true;
                     }

                     boolean var20 = false;
                     if((MouseInput.mouseLastButton == 1 || !class45.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) && MouseInput.mouseLastPressedX >= var12 && MouseInput.mouseLastPressedY >= var13 && MouseInput.mouseLastPressedX < var14 && MouseInput.mouseLastPressedY < var15) {
                        var20 = true;
                     }

                     if(var20) {
                        Occluder.method2959(var9, MouseInput.mouseLastPressedX - var10, MouseInput.mouseLastPressedY - var11);
                     }

                     if(var9.contentType == 1400) {
                        TextureProvider.renderOverview.method5575(MouseInput.mouseLastX, MouseInput.mouseLastY, var32 & var33, var32 & var20);
                     }

                     if(Client.field1028 != null && var9 != Client.field1028 && var32 && class234.method4268(GraphicsObject.getWidgetConfig(var9))) {
                        Client.field1032 = var9;
                     }

                     if(var9 == Client.field1029) {
                        Client.field1033 = true;
                        Client.field1034 = var10;
                        Client.field1035 = var11;
                     }

                     if(var9.field2890) {
                        ScriptEvent var21;
                        if(var32 && Client.mouseWheelRotation != 0 && var9.scrollListener != null) {
                           var21 = new ScriptEvent();
                           var21.boolean1 = true;
                           var21.widget = var9;
                           var21.field793 = Client.mouseWheelRotation;
                           var21.objs = var9.scrollListener;
                           Client.field1054.addFront(var21);
                        }

                        if(Client.field1028 != null || Frames.field2040 != null || Client.isMenuOpen) {
                           var20 = false;
                           var33 = false;
                           var32 = false;
                        }

                        if(!var9.field2851 && var20) {
                           var9.field2851 = true;
                           if(var9.field2844 != null) {
                              var21 = new ScriptEvent();
                              var21.boolean1 = true;
                              var21.widget = var9;
                              var21.field795 = MouseInput.mouseLastPressedX - var10;
                              var21.field793 = MouseInput.mouseLastPressedY - var11;
                              var21.objs = var9.field2844;
                              Client.field1054.addFront(var21);
                           }
                        }

                        if(var9.field2851 && var33 && var9.field2845 != null) {
                           var21 = new ScriptEvent();
                           var21.boolean1 = true;
                           var21.widget = var9;
                           var21.field795 = MouseInput.mouseLastX - var10;
                           var21.field793 = MouseInput.mouseLastY - var11;
                           var21.objs = var9.field2845;
                           Client.field1054.addFront(var21);
                        }

                        if(var9.field2851 && !var33) {
                           var9.field2851 = false;
                           if(var9.field2854 != null) {
                              var21 = new ScriptEvent();
                              var21.boolean1 = true;
                              var21.widget = var9;
                              var21.field795 = MouseInput.mouseLastX - var10;
                              var21.field793 = MouseInput.mouseLastY - var11;
                              var21.objs = var9.field2854;
                              Client.field1056.addFront(var21);
                           }
                        }

                        if(var33 && var9.field2847 != null) {
                           var21 = new ScriptEvent();
                           var21.boolean1 = true;
                           var21.widget = var9;
                           var21.field795 = MouseInput.mouseLastX - var10;
                           var21.field793 = MouseInput.mouseLastY - var11;
                           var21.objs = var9.field2847;
                           Client.field1054.addFront(var21);
                        }

                        if(!var9.field2887 && var32) {
                           var9.field2887 = true;
                           if(var9.mouseEnterListener != null) {
                              var21 = new ScriptEvent();
                              var21.boolean1 = true;
                              var21.widget = var9;
                              var21.field795 = MouseInput.mouseLastX - var10;
                              var21.field793 = MouseInput.mouseLastY - var11;
                              var21.objs = var9.mouseEnterListener;
                              Client.field1054.addFront(var21);
                           }
                        }

                        if(var9.field2887 && var32 && var9.mouseHoverListener != null) {
                           var21 = new ScriptEvent();
                           var21.boolean1 = true;
                           var21.widget = var9;
                           var21.field795 = MouseInput.mouseLastX - var10;
                           var21.field793 = MouseInput.mouseLastY - var11;
                           var21.objs = var9.mouseHoverListener;
                           Client.field1054.addFront(var21);
                        }

                        if(var9.field2887 && !var32) {
                           var9.field2887 = false;
                           if(var9.mouseExitListener != null) {
                              var21 = new ScriptEvent();
                              var21.boolean1 = true;
                              var21.widget = var9;
                              var21.field795 = MouseInput.mouseLastX - var10;
                              var21.field793 = MouseInput.mouseLastY - var11;
                              var21.objs = var9.mouseExitListener;
                              Client.field1056.addFront(var21);
                           }
                        }

                        if(var9.renderListener != null) {
                           var21 = new ScriptEvent();
                           var21.widget = var9;
                           var21.objs = var9.renderListener;
                           Client.field1055.addFront(var21);
                        }

                        ScriptEvent var24;
                        if(var9.configListenerArgs != null && Client.field1042 > var9.field2840) {
                           if(var9.configTriggers != null && Client.field1042 - var9.field2840 <= 32) {
                              label814:
                              for(var29 = var9.field2840; var29 < Client.field1042; ++var29) {
                                 var22 = Client.field984[var29 & 31];

                                 for(var23 = 0; var23 < var9.configTriggers.length; ++var23) {
                                    if(var22 == var9.configTriggers[var23]) {
                                       var24 = new ScriptEvent();
                                       var24.widget = var9;
                                       var24.objs = var9.configListenerArgs;
                                       Client.field1054.addFront(var24);
                                       break label814;
                                    }
                                 }
                              }
                           } else {
                              var21 = new ScriptEvent();
                              var21.widget = var9;
                              var21.objs = var9.configListenerArgs;
                              Client.field1054.addFront(var21);
                           }

                           var9.field2840 = Client.field1042;
                        }

                        if(var9.tableListenerArgs != null && Client.field1044 > var9.field2891) {
                           if(var9.tableModTriggers != null && Client.field1044 - var9.field2891 <= 32) {
                              label790:
                              for(var29 = var9.field2891; var29 < Client.field1044; ++var29) {
                                 var22 = Client.interfaceItemTriggers[var29 & 31];

                                 for(var23 = 0; var23 < var9.tableModTriggers.length; ++var23) {
                                    if(var22 == var9.tableModTriggers[var23]) {
                                       var24 = new ScriptEvent();
                                       var24.widget = var9;
                                       var24.objs = var9.tableListenerArgs;
                                       Client.field1054.addFront(var24);
                                       break label790;
                                    }
                                 }
                              }
                           } else {
                              var21 = new ScriptEvent();
                              var21.widget = var9;
                              var21.objs = var9.tableListenerArgs;
                              Client.field1054.addFront(var21);
                           }

                           var9.field2891 = Client.field1044;
                        }

                        if(var9.skillListenerArgs != null && Client.field1045 > var9.field2831) {
                           if(var9.skillTriggers != null && Client.field1045 - var9.field2831 <= 32) {
                              label766:
                              for(var29 = var9.field2831; var29 < Client.field1045; ++var29) {
                                 var22 = Client.field1093[var29 & 31];

                                 for(var23 = 0; var23 < var9.skillTriggers.length; ++var23) {
                                    if(var22 == var9.skillTriggers[var23]) {
                                       var24 = new ScriptEvent();
                                       var24.widget = var9;
                                       var24.objs = var9.skillListenerArgs;
                                       Client.field1054.addFront(var24);
                                       break label766;
                                    }
                                 }
                              }
                           } else {
                              var21 = new ScriptEvent();
                              var21.widget = var9;
                              var21.objs = var9.skillListenerArgs;
                              Client.field1054.addFront(var21);
                           }

                           var9.field2831 = Client.field1045;
                        }

                        if(Client.chatCycle > var9.field2889 && var9.field2876 != null) {
                           var21 = new ScriptEvent();
                           var21.widget = var9;
                           var21.objs = var9.field2876;
                           Client.field1054.addFront(var21);
                        }

                        if(Client.field880 > var9.field2889 && var9.field2755 != null) {
                           var21 = new ScriptEvent();
                           var21.widget = var9;
                           var21.objs = var9.field2755;
                           Client.field1054.addFront(var21);
                        }

                        if(Client.field1049 > var9.field2889 && var9.field2834 != null) {
                           var21 = new ScriptEvent();
                           var21.widget = var9;
                           var21.objs = var9.field2834;
                           Client.field1054.addFront(var21);
                        }

                        if(Client.field1050 > var9.field2889 && var9.field2872 != null) {
                           var21 = new ScriptEvent();
                           var21.widget = var9;
                           var21.objs = var9.field2872;
                           Client.field1054.addFront(var21);
                        }

                        if(Client.field1051 > var9.field2889 && var9.field2873 != null) {
                           var21 = new ScriptEvent();
                           var21.widget = var9;
                           var21.objs = var9.field2873;
                           Client.field1054.addFront(var21);
                        }

                        if(Client.field951 > var9.field2889 && var9.field2859 != null) {
                           var21 = new ScriptEvent();
                           var21.widget = var9;
                           var21.objs = var9.field2859;
                           Client.field1054.addFront(var21);
                        }

                        var9.field2889 = Client.cycleCntr;
                        if(var9.field2865 != null) {
                           for(var29 = 0; var29 < Client.field1076; ++var29) {
                              ScriptEvent var30 = new ScriptEvent();
                              var30.widget = var9;
                              var30.field800 = Client.field1078[var29];
                              var30.field801 = Client.field876[var29];
                              var30.objs = var9.field2865;
                              Client.field1054.addFront(var30);
                           }
                        }
                     }
                  }

                  if(!var9.hasScript && Client.field1028 == null && Frames.field2040 == null && !Client.isMenuOpen) {
                     if((var9.field2849 >= 0 || var9.field2809 != 0) && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                        if(var9.field2849 >= 0) {
                           BoundingBox.field239 = var0[var9.field2849];
                        } else {
                           BoundingBox.field239 = var9;
                        }
                     }

                     if(var9.type == 8 && MouseInput.mouseLastX >= var12 && MouseInput.mouseLastY >= var13 && MouseInput.mouseLastX < var14 && MouseInput.mouseLastY < var15) {
                        CacheFile.field1665 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        var19 = var10 + var9.width;
                        int var34 = var9.height;
                        var29 = var9.scrollHeight;
                        var22 = MouseInput.mouseLastX;
                        var23 = MouseInput.mouseLastY;
                        if(Client.field936) {
                           Client.field937 = 32;
                        } else {
                           Client.field937 = 0;
                        }

                        Client.field936 = false;
                        int var31;
                        if(MouseInput.mouseCurrentButton == 1 || !class45.middleMouseMovesCamera && MouseInput.mouseCurrentButton == 4) {
                           if(var22 >= var19 && var22 < var19 + 16 && var23 >= var11 && var23 < var11 + 16) {
                              var9.scrollY -= 4;
                              class28.method220(var9);
                           } else if(var22 >= var19 && var22 < var19 + 16 && var23 >= var34 + var11 - 16 && var23 < var34 + var11) {
                              var9.scrollY += 4;
                              class28.method220(var9);
                           } else if(var22 >= var19 - Client.field937 && var22 < var19 + Client.field937 + 16 && var23 >= var11 + 16 && var23 < var34 + var11 - 16) {
                              var31 = var34 * (var34 - 32) / var29;
                              if(var31 < 8) {
                                 var31 = 8;
                              }

                              int var25 = var23 - var11 - 16 - var31 / 2;
                              int var26 = var34 - 32 - var31;
                              var9.scrollY = var25 * (var29 - var34) / var26;
                              class28.method220(var9);
                              Client.field936 = true;
                           }
                        }

                        if(Client.mouseWheelRotation != 0) {
                           var31 = var9.width;
                           if(var22 >= var19 - var31 && var23 >= var11 && var22 < var19 + 16 && var23 <= var34 + var11) {
                              var9.scrollY += Client.mouseWheelRotation * 45;
                              class28.method220(var9);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }
}

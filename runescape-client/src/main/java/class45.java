import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public class class45 extends class28 {
   @ObfuscatedName("is")
   @ObfuscatedGetter(
      intValue = 1895562447
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("li")
   @ObfuscatedGetter(
      intValue = -350944101
   )
   static int field579;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -670722103
   )
   int field573;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 353399663
   )
   int field577;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1198247593
   )
   int field575;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 192822769
   )
   int field576;

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1403496055"
   )
   int method647() {
      return this.field575;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1499817593"
   )
   boolean method644(int var1, int var2) {
      return var1 < this.field575 * 8?false:(var2 < this.field576 * 8?false:(var1 >= this.field575 * 8 + 8?false:var2 < this.field576 * 8 + 8));
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-663722400"
   )
   int method664() {
      return this.field576;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;LBuffer;I)V",
      garbageValue = "246644215"
   )
   void method660(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field488.field490) {
         throw new IllegalStateException("");
      } else {
         super.field407 = var2.readUnsignedByte();
         super.field404 = var2.readUnsignedByte();
         super.field403 = var2.readUnsignedShort();
         super.field400 = var2.readUnsignedShort();
         this.field577 = var2.readUnsignedByte();
         this.field573 = var2.readUnsignedByte();
         super.field401 = var2.readUnsignedShort();
         super.field399 = var2.readUnsignedShort();
         this.field575 = var2.readUnsignedByte();
         this.field576 = var2.readUnsignedByte();
         super.field404 = Math.min(super.field404, 4);
         super.field405 = new short[1][64][64];
         super.field410 = new short[super.field404][64][64];
         super.field406 = new byte[super.field404][64][64];
         super.field408 = new byte[super.field404][64][64];
         super.field409 = new class31[super.field404][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field481.field480) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            int var6 = var1.readUnsignedByte();
            int var7 = var1.readUnsignedByte();
            if(var4 == super.field401 && var5 == super.field399 && var6 == this.field575 && var7 == this.field576) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  for(int var9 = 0; var9 < 8; ++var9) {
                     this.method219(this.field575 * 8 + var8, this.field576 * 8 + var9, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1991196726"
   )
   int method645() {
      return this.field577;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "128"
   )
   int method648() {
      return this.field573;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class45)) {
         return false;
      } else {
         class45 var2 = (class45)var1;
         return super.field401 == var2.field401 && super.field399 == var2.field399?this.field575 == var2.field575 && var2.field576 == this.field576:false;
      }
   }

   public int hashCode() {
      return super.field401 | super.field399 << 8 | this.field575 << 16 | this.field576 << 24;
   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "(IIIIIIIS)V",
      garbageValue = "255"
   )
   static final void method667(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(class33.loadWidget(var0)) {
         method662(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIII)V",
      garbageValue = "1116699053"
   )
   static final void method662(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2733 || class46.getWidgetConfig(var9) != 0 || var9 == Client.field920 || var9.contentType == 1338) && var9.parentId == var1 && (!var9.hasScript || !class90.method1690(var9))) {
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

            if(var9 == Client.field1079) {
               Client.field1087 = true;
               Client.field1046 = var10;
               Client.field1089 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = MouseInput.field722;
               var17 = MouseInput.field723;
               if(MouseInput.field728 != 0) {
                  var16 = MouseInput.field735;
                  var17 = MouseInput.field730;
               }

               boolean var34 = var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15;
               if(var9.contentType == 1337) {
                  if(!Client.field987 && !Client.isMenuOpen && var34) {
                     KeyFocusListener.method780(var16, var17, var12, var13);
                  }
               } else {
                  int var21;
                  int var22;
                  int var23;
                  int var24;
                  int var25;
                  int var26;
                  int var36;
                  if(var9.contentType == 1338) {
                     if((Client.field1140 == 0 || Client.field1140 == 3) && (MouseInput.field728 == 1 || !class33.field461 && MouseInput.field728 == 4)) {
                        class210 var38 = var9.method3980(true);
                        if(var38 != null) {
                           var36 = MouseInput.field735 - var10;
                           var21 = MouseInput.field730 - var11;
                           if(var38.method3908(var36, var21)) {
                              var36 -= var38.field2600 / 2;
                              var21 -= var38.field2599 / 2;
                              var22 = Client.mapScale + Client.mapAngle & 2047;
                              var23 = Graphics3D.SINE[var22];
                              var24 = Graphics3D.COSINE[var22];
                              var23 = (Client.mapScaleDelta + 256) * var23 >> 8;
                              var24 = var24 * (256 + Client.mapScaleDelta) >> 8;
                              var25 = var36 * var24 + var23 * var21 >> 11;
                              var26 = var24 * var21 - var23 * var36 >> 11;
                              int var27 = var25 + Script.localPlayer.x >> 7;
                              int var28 = Script.localPlayer.y - var26 >> 7;
                              Client.secretPacketBuffer1.putOpcode(79);
                              Client.secretPacketBuffer1.putByte(18);
                              Client.secretPacketBuffer1.putShortLE(KeyFocusListener.field626[82]?(KeyFocusListener.field626[81]?2:1):0);
                              Client.secretPacketBuffer1.putLEShortA(var27 + class163.baseX);
                              Client.secretPacketBuffer1.putShortOb2(var28 + class10.baseY);
                              Client.secretPacketBuffer1.putByte(var36);
                              Client.secretPacketBuffer1.putByte(var21);
                              Client.secretPacketBuffer1.putShort(Client.mapAngle);
                              Client.secretPacketBuffer1.putByte(57);
                              Client.secretPacketBuffer1.putByte(Client.mapScale);
                              Client.secretPacketBuffer1.putByte(Client.mapScaleDelta);
                              Client.secretPacketBuffer1.putByte(89);
                              Client.secretPacketBuffer1.putShort(Script.localPlayer.x);
                              Client.secretPacketBuffer1.putShort(Script.localPlayer.y);
                              Client.secretPacketBuffer1.putByte(63);
                              Client.destinationX = var27;
                              Client.destinationY = var28;
                           }
                        }
                     }
                  } else {
                     if(var9.contentType == 1400) {
                        class11.renderOverview.method5184(MouseInput.field722, MouseInput.field723, var34, var10, var11, var9.width, var9.height);
                     }

                     if(!Client.isMenuOpen && var34) {
                        if(var9.contentType == 1400) {
                           class11.renderOverview.method5248(var10, var11, var9.width, var9.height, var16, var17);
                        } else {
                           class37.method500(var9, var16 - var10, var17 - var11);
                        }
                     }

                     if(var9.type == 0) {
                        if(!var9.hasScript && class90.method1690(var9) && var9 != XGrandExchangeOffer.field308) {
                           continue;
                        }

                        method662(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                        if(var9.children != null) {
                           method662(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                        }

                        WidgetNode var29 = (WidgetNode)Client.componentTable.get((long)var9.id);
                        if(var29 != null) {
                           if(var29.owner == 0 && MouseInput.field722 >= var12 && MouseInput.field723 >= var13 && MouseInput.field722 < var14 && MouseInput.field723 < var15 && !Client.isMenuOpen && !Client.field1076) {
                              for(ScriptEvent var33 = (ScriptEvent)Client.field1105.getFront(); var33 != null; var33 = (ScriptEvent)Client.field1105.getNext()) {
                                 if(var33.field829) {
                                    var33.unlink();
                                    var33.widget.field2778 = false;
                                 }
                              }

                              if(class33.field454 == 0) {
                                 Client.field1079 = null;
                                 Client.field920 = null;
                              }

                              if(!Client.isMenuOpen) {
                                 Client.menuOptionCount = 0;
                                 Client.field940 = -1;
                                 Client.isMenuOpen = false;
                                 Client.menuOptions[0] = "Cancel";
                                 Client.menuTargets[0] = "";
                                 Client.menuTypes[0] = 1006;
                                 Client.menuOptionCount = 1;
                              }
                           }

                           method667(var29.id, var12, var13, var14, var15, var10, var11);
                        }
                     }

                     if(var9.hasScript) {
                        ScriptEvent var37;
                        if(!var9.field2786) {
                           if(var9.field2787 && MouseInput.field722 >= var12 && MouseInput.field723 >= var13 && MouseInput.field722 < var14 && MouseInput.field723 < var15) {
                              for(var37 = (ScriptEvent)Client.field1105.getFront(); var37 != null; var37 = (ScriptEvent)Client.field1105.getNext()) {
                                 if(var37.field829 && var37.widget.scrollListener == var37.field839) {
                                    var37.unlink();
                                 }
                              }
                           }
                        } else if(MouseInput.field722 >= var12 && MouseInput.field723 >= var13 && MouseInput.field722 < var14 && MouseInput.field723 < var15) {
                           for(var37 = (ScriptEvent)Client.field1105.getFront(); var37 != null; var37 = (ScriptEvent)Client.field1105.getNext()) {
                              if(var37.field829) {
                                 var37.unlink();
                                 var37.widget.field2778 = false;
                              }
                           }

                           if(class33.field454 == 0) {
                              Client.field1079 = null;
                              Client.field920 = null;
                           }

                           if(!Client.isMenuOpen) {
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.menuOptionCount = 1;
                           }
                        }

                        if(MouseInput.field722 >= var12 && MouseInput.field723 >= var13 && MouseInput.field722 < var14 && MouseInput.field723 < var15) {
                           var34 = true;
                        } else {
                           var34 = false;
                        }

                        boolean var35 = false;
                        if((MouseInput.field721 == 1 || !class33.field461 && MouseInput.field721 == 4) && var34) {
                           var35 = true;
                        }

                        boolean var20 = false;
                        if((MouseInput.field728 == 1 || !class33.field461 && MouseInput.field728 == 4) && MouseInput.field735 >= var12 && MouseInput.field730 >= var13 && MouseInput.field735 < var14 && MouseInput.field730 < var15) {
                           var20 = true;
                        }

                        if(var20) {
                           class91.method1699(var9, MouseInput.field735 - var10, MouseInput.field730 - var11);
                        }

                        if(var9.contentType == 1400) {
                           class11.renderOverview.method5271(MouseInput.field722, MouseInput.field723, var34 & var35);
                        }

                        if(Client.field1079 != null && var9 != Client.field1079 && var34 && class64.method1081(class46.getWidgetConfig(var9))) {
                           Client.field1083 = var9;
                        }

                        if(var9 == Client.field920) {
                           Client.field1084 = true;
                           Client.field1085 = var10;
                           Client.field1137 = var11;
                        }

                        if(var9.field2733) {
                           ScriptEvent var30;
                           if(var34 && Client.field1104 != 0 && var9.scrollListener != null) {
                              var30 = new ScriptEvent();
                              var30.field829 = true;
                              var30.widget = var9;
                              var30.field828 = Client.field1104;
                              var30.field839 = var9.scrollListener;
                              Client.field1105.addFront(var30);
                           }

                           if(Client.field1079 != null || Ignore.field841 != null || Client.isMenuOpen) {
                              var20 = false;
                              var35 = false;
                              var34 = false;
                           }

                           if(!var9.field2779 && var20) {
                              var9.field2779 = true;
                              if(var9.field2667 != null) {
                                 var30 = new ScriptEvent();
                                 var30.field829 = true;
                                 var30.widget = var9;
                                 var30.field831 = MouseInput.field735 - var10;
                                 var30.field828 = MouseInput.field730 - var11;
                                 var30.field839 = var9.field2667;
                                 Client.field1105.addFront(var30);
                              }
                           }

                           if(var9.field2779 && var35 && var9.field2675 != null) {
                              var30 = new ScriptEvent();
                              var30.field829 = true;
                              var30.widget = var9;
                              var30.field831 = MouseInput.field722 - var10;
                              var30.field828 = MouseInput.field723 - var11;
                              var30.field839 = var9.field2675;
                              Client.field1105.addFront(var30);
                           }

                           if(var9.field2779 && !var35) {
                              var9.field2779 = false;
                              if(var9.field2737 != null) {
                                 var30 = new ScriptEvent();
                                 var30.field829 = true;
                                 var30.widget = var9;
                                 var30.field831 = MouseInput.field722 - var10;
                                 var30.field828 = MouseInput.field723 - var11;
                                 var30.field839 = var9.field2737;
                                 Client.field1115.addFront(var30);
                              }
                           }

                           if(var35 && var9.field2738 != null) {
                              var30 = new ScriptEvent();
                              var30.field829 = true;
                              var30.widget = var9;
                              var30.field831 = MouseInput.field722 - var10;
                              var30.field828 = MouseInput.field723 - var11;
                              var30.field839 = var9.field2738;
                              Client.field1105.addFront(var30);
                           }

                           if(!var9.field2778 && var34) {
                              var9.field2778 = true;
                              if(var9.mouseEnterListener != null) {
                                 var30 = new ScriptEvent();
                                 var30.field829 = true;
                                 var30.widget = var9;
                                 var30.field831 = MouseInput.field722 - var10;
                                 var30.field828 = MouseInput.field723 - var11;
                                 var30.field839 = var9.mouseEnterListener;
                                 Client.field1105.addFront(var30);
                              }
                           }

                           if(var9.field2778 && var34 && var9.mouseHoverListener != null) {
                              var30 = new ScriptEvent();
                              var30.field829 = true;
                              var30.widget = var9;
                              var30.field831 = MouseInput.field722 - var10;
                              var30.field828 = MouseInput.field723 - var11;
                              var30.field839 = var9.mouseHoverListener;
                              Client.field1105.addFront(var30);
                           }

                           if(var9.field2778 && !var34) {
                              var9.field2778 = false;
                              if(var9.mouseExitListener != null) {
                                 var30 = new ScriptEvent();
                                 var30.field829 = true;
                                 var30.widget = var9;
                                 var30.field831 = MouseInput.field722 - var10;
                                 var30.field828 = MouseInput.field723 - var11;
                                 var30.field839 = var9.mouseExitListener;
                                 Client.field1115.addFront(var30);
                              }
                           }

                           if(var9.renderListener != null) {
                              var30 = new ScriptEvent();
                              var30.widget = var9;
                              var30.field839 = var9.renderListener;
                              Client.field1106.addFront(var30);
                           }

                           ScriptEvent var31;
                           if(var9.configListenerArgs != null && Client.field1093 > var9.field2781) {
                              if(var9.configTriggers != null && Client.field1093 - var9.field2781 <= 32) {
                                 label877:
                                 for(var21 = var9.field2781; var21 < Client.field1093; ++var21) {
                                    var22 = Client.field1092[var21 & 31];

                                    for(var23 = 0; var23 < var9.configTriggers.length; ++var23) {
                                       if(var22 == var9.configTriggers[var23]) {
                                          var31 = new ScriptEvent();
                                          var31.widget = var9;
                                          var31.field839 = var9.configListenerArgs;
                                          Client.field1105.addFront(var31);
                                          break label877;
                                       }
                                    }
                                 }
                              } else {
                                 var30 = new ScriptEvent();
                                 var30.widget = var9;
                                 var30.field839 = var9.configListenerArgs;
                                 Client.field1105.addFront(var30);
                              }

                              var9.field2781 = Client.field1093;
                           }

                           if(var9.tableListenerArgs != null && Client.field1095 > var9.field2782) {
                              if(var9.tableModTriggers != null && Client.field1095 - var9.field2782 <= 32) {
                                 label853:
                                 for(var21 = var9.field2782; var21 < Client.field1095; ++var21) {
                                    var22 = Client.interfaceItemTriggers[var21 & 31];

                                    for(var23 = 0; var23 < var9.tableModTriggers.length; ++var23) {
                                       if(var22 == var9.tableModTriggers[var23]) {
                                          var31 = new ScriptEvent();
                                          var31.widget = var9;
                                          var31.field839 = var9.tableListenerArgs;
                                          Client.field1105.addFront(var31);
                                          break label853;
                                       }
                                    }
                                 }
                              } else {
                                 var30 = new ScriptEvent();
                                 var30.widget = var9;
                                 var30.field839 = var9.tableListenerArgs;
                                 Client.field1105.addFront(var30);
                              }

                              var9.field2782 = Client.field1095;
                           }

                           if(var9.skillListenerArgs != null && Client.field1097 > var9.field2735) {
                              if(var9.skillTriggers != null && Client.field1097 - var9.field2735 <= 32) {
                                 label829:
                                 for(var21 = var9.field2735; var21 < Client.field1097; ++var21) {
                                    var22 = Client.field1096[var21 & 31];

                                    for(var23 = 0; var23 < var9.skillTriggers.length; ++var23) {
                                       if(var22 == var9.skillTriggers[var23]) {
                                          var31 = new ScriptEvent();
                                          var31.widget = var9;
                                          var31.field839 = var9.skillListenerArgs;
                                          Client.field1105.addFront(var31);
                                          break label829;
                                       }
                                    }
                                 }
                              } else {
                                 var30 = new ScriptEvent();
                                 var30.widget = var9;
                                 var30.field839 = var9.skillListenerArgs;
                                 Client.field1105.addFront(var30);
                              }

                              var9.field2735 = Client.field1097;
                           }

                           if(Client.field910 > var9.field2780 && var9.field2755 != null) {
                              var30 = new ScriptEvent();
                              var30.widget = var9;
                              var30.field839 = var9.field2755;
                              Client.field1105.addFront(var30);
                           }

                           if(Client.field1099 > var9.field2780 && var9.field2757 != null) {
                              var30 = new ScriptEvent();
                              var30.widget = var9;
                              var30.field839 = var9.field2757;
                              Client.field1105.addFront(var30);
                           }

                           if(Client.field1100 > var9.field2780 && var9.field2758 != null) {
                              var30 = new ScriptEvent();
                              var30.widget = var9;
                              var30.field839 = var9.field2758;
                              Client.field1105.addFront(var30);
                           }

                           if(Client.field1101 > var9.field2780 && var9.field2763 != null) {
                              var30 = new ScriptEvent();
                              var30.widget = var9;
                              var30.field839 = var9.field2763;
                              Client.field1105.addFront(var30);
                           }

                           if(Client.field1102 > var9.field2780 && var9.field2764 != null) {
                              var30 = new ScriptEvent();
                              var30.widget = var9;
                              var30.field839 = var9.field2764;
                              Client.field1105.addFront(var30);
                           }

                           if(Client.field1103 > var9.field2780 && var9.field2669 != null) {
                              var30 = new ScriptEvent();
                              var30.widget = var9;
                              var30.field839 = var9.field2669;
                              Client.field1105.addFront(var30);
                           }

                           var9.field2780 = Client.field1045;
                           if(var9.field2756 != null) {
                              for(var21 = 0; var21 < Client.field906; ++var21) {
                                 ScriptEvent var32 = new ScriptEvent();
                                 var32.widget = var9;
                                 var32.field838 = Client.field1169[var21];
                                 var32.field836 = Client.field1001[var21];
                                 var32.field839 = var9.field2756;
                                 Client.field1105.addFront(var32);
                              }
                           }
                        }
                     }

                     if(!var9.hasScript && Client.field1079 == null && Ignore.field841 == null && !Client.isMenuOpen) {
                        if((var9.field2768 >= 0 || var9.field2680 != 0) && MouseInput.field722 >= var12 && MouseInput.field723 >= var13 && MouseInput.field722 < var14 && MouseInput.field723 < var15) {
                           if(var9.field2768 >= 0) {
                              XGrandExchangeOffer.field308 = var0[var9.field2768];
                           } else {
                              XGrandExchangeOffer.field308 = var9;
                           }
                        }

                        if(var9.type == 8 && MouseInput.field722 >= var12 && MouseInput.field723 >= var13 && MouseInput.field722 < var14 && MouseInput.field723 < var15) {
                           class35.field483 = var9;
                        }

                        if(var9.scrollHeight > var9.height) {
                           var19 = var10 + var9.width;
                           var36 = var9.height;
                           var21 = var9.scrollHeight;
                           var22 = MouseInput.field722;
                           var23 = MouseInput.field723;
                           if(Client.field1121) {
                              Client.field988 = 32;
                           } else {
                              Client.field988 = 0;
                           }

                           Client.field1121 = false;
                           if(MouseInput.field721 == 1 || !class33.field461 && MouseInput.field721 == 4) {
                              if(var22 >= var19 && var22 < var19 + 16 && var23 >= var11 && var23 < var11 + 16) {
                                 var9.scrollY -= 4;
                                 class48.method749(var9);
                              } else if(var22 >= var19 && var22 < var19 + 16 && var23 >= var11 + var36 - 16 && var23 < var36 + var11) {
                                 var9.scrollY += 4;
                                 class48.method749(var9);
                              } else if(var22 >= var19 - Client.field988 && var22 < 16 + var19 + Client.field988 && var23 >= var11 + 16 && var23 < var36 + var11 - 16) {
                                 var24 = var36 * (var36 - 32) / var21;
                                 if(var24 < 8) {
                                    var24 = 8;
                                 }

                                 var25 = var23 - var11 - 16 - var24 / 2;
                                 var26 = var36 - 32 - var24;
                                 var9.scrollY = var25 * (var21 - var36) / var26;
                                 class48.method749(var9);
                                 Client.field1121 = true;
                              }
                           }

                           if(Client.field1104 != 0) {
                              var24 = var9.width;
                              if(var22 >= var19 - var24 && var23 >= var11 && var22 < var19 + 16 && var23 <= var36 + var11) {
                                 var9.scrollY += Client.field1104 * 45;
                                 class48.method749(var9);
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

   @ObfuscatedName("jd")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1438439278"
   )
   static final void method656(String var0) {
      if(var0 != null) {
         String var1 = class202.method3682(var0, class164.field2317);
         if(var1 != null) {
            for(int var2 = 0; var2 < Client.friendCount; ++var2) {
               Friend var3 = Client.friends[var2];
               String var4 = var3.name;
               String var5 = class202.method3682(var4, class164.field2317);
               if(class46.method713(var0, var1, var4, var5)) {
                  --Client.friendCount;

                  for(int var6 = var2; var6 < Client.friendCount; ++var6) {
                     Client.friends[var6] = Client.friends[var6 + 1];
                  }

                  Client.field1099 = Client.field1045;
                  Client.secretPacketBuffer1.putOpcode(154);
                  Client.secretPacketBuffer1.putByte(DecorativeObject.getLength(var0));
                  Client.secretPacketBuffer1.putString(var0);
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)[B",
      garbageValue = "917763452"
   )
   public static byte[] method668(CharSequence var0) {
      int var1 = var0.length();
      byte[] var2 = new byte[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 <= 0 || var4 >= 128) && (var4 < 160 || var4 > 255)) {
            if(var4 == 8364) {
               var2[var3] = -128;
            } else if(var4 == 8218) {
               var2[var3] = -126;
            } else if(var4 == 402) {
               var2[var3] = -125;
            } else if(var4 == 8222) {
               var2[var3] = -124;
            } else if(var4 == 8230) {
               var2[var3] = -123;
            } else if(var4 == 8224) {
               var2[var3] = -122;
            } else if(var4 == 8225) {
               var2[var3] = -121;
            } else if(var4 == 710) {
               var2[var3] = -120;
            } else if(var4 == 8240) {
               var2[var3] = -119;
            } else if(var4 == 352) {
               var2[var3] = -118;
            } else if(var4 == 8249) {
               var2[var3] = -117;
            } else if(var4 == 338) {
               var2[var3] = -116;
            } else if(var4 == 381) {
               var2[var3] = -114;
            } else if(var4 == 8216) {
               var2[var3] = -111;
            } else if(var4 == 8217) {
               var2[var3] = -110;
            } else if(var4 == 8220) {
               var2[var3] = -109;
            } else if(var4 == 8221) {
               var2[var3] = -108;
            } else if(var4 == 8226) {
               var2[var3] = -107;
            } else if(var4 == 8211) {
               var2[var3] = -106;
            } else if(var4 == 8212) {
               var2[var3] = -105;
            } else if(var4 == 732) {
               var2[var3] = -104;
            } else if(var4 == 8482) {
               var2[var3] = -103;
            } else if(var4 == 353) {
               var2[var3] = -102;
            } else if(var4 == 8250) {
               var2[var3] = -101;
            } else if(var4 == 339) {
               var2[var3] = -100;
            } else if(var4 == 382) {
               var2[var3] = -98;
            } else if(var4 == 376) {
               var2[var3] = -97;
            } else {
               var2[var3] = 63;
            }
         } else {
            var2[var3] = (byte)var4;
         }
      }

      return var2;
   }
}

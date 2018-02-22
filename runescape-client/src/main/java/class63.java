import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("bu")
public class class63 {
   @ObfuscatedName("qf")
   @ObfuscatedSignature(
      signature = "Lli;"
   )
   @Export("platformInfo")
   static MachineInfo platformInfo;
   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("indexTextures")
   static IndexData indexTextures;
   @ObfuscatedName("en")
   @ObfuscatedSignature(
      signature = "Lkx;"
   )
   @Export("fonts")
   static Fonts fonts;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   final IndexData field712;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -889736477
   )
   final int field711;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1971315979
   )
   int field710;

   @ObfuscatedSignature(
      signature = "(Lia;Ljava/lang/String;)V"
   )
   class63(IndexData var1, String var2) {
      this.field710 = 0;
      this.field712 = var1;
      this.field711 = var1.size();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1040687688"
   )
   boolean method1106() {
      this.field710 = 0;

      for(int var1 = 0; var1 < this.field711; ++var1) {
         if(!this.field712.method4655(var1) || this.field712.method4687(var1)) {
            ++this.field710;
         }
      }

      return this.field710 >= this.field711;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgu;I)V",
      garbageValue = "1550286150"
   )
   @Export("encodeClassVerifier")
   public static void encodeClassVerifier(PacketBuffer var0) {
      ClassInfo var1 = (ClassInfo)class317.classInfos.last();
      if(var1 != null) {
         int var2 = var0.offset;
         var0.putInt(var1.field3865);

         for(int var3 = 0; var3 < var1.count; ++var3) {
            if(var1.errorIdentifiers[var3] != 0) {
               var0.putByte(var1.errorIdentifiers[var3]);
            } else {
               try {
                  int var4 = var1.type[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.fields[var3];
                     var6 = Reflection.getInt(var5, (Object)null);
                     var0.putByte(0);
                     var0.putInt(var6);
                  } else if(var4 == 1) {
                     var5 = var1.fields[var3];
                     Reflection.setInt(var5, (Object)null, var1.field3870[var3]);
                     var0.putByte(0);
                  } else if(var4 == 2) {
                     var5 = var1.fields[var3];
                     var6 = var5.getModifiers();
                     var0.putByte(0);
                     var0.putInt(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.methods[var3];
                        var6 = var25.getModifiers();
                        var0.putByte(0);
                        var0.putInt(var6);
                     }
                  } else {
                     var25 = var1.methods[var3];
                     byte[][] var10 = var1.args[var3];
                     Object[] var7 = new Object[var10.length];

                     for(int var8 = 0; var8 < var10.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var11 = Reflection.invoke(var25, (Object)null, var7);
                     if(var11 == null) {
                        var0.putByte(0);
                     } else if(var11 instanceof Number) {
                        var0.putByte(1);
                        var0.putLong(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.putByte(2);
                        var0.putString((String)var11);
                     } else {
                        var0.putByte(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.putByte(-10);
               } catch (InvalidClassException var14) {
                  var0.putByte(-11);
               } catch (StreamCorruptedException var15) {
                  var0.putByte(-12);
               } catch (OptionalDataException var16) {
                  var0.putByte(-13);
               } catch (IllegalAccessException var17) {
                  var0.putByte(-14);
               } catch (IllegalArgumentException var18) {
                  var0.putByte(-15);
               } catch (InvocationTargetException var19) {
                  var0.putByte(-16);
               } catch (SecurityException var20) {
                  var0.putByte(-17);
               } catch (IOException var21) {
                  var0.putByte(-18);
               } catch (NullPointerException var22) {
                  var0.putByte(-19);
               } catch (Exception var23) {
                  var0.putByte(-20);
               } catch (Throwable var24) {
                  var0.putByte(-21);
               }
            }
         }

         var0.putCrc(var2);
         var1.unlink();
      }
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(Lim;IIS)V",
      garbageValue = "1560"
   )
   static final void method1105(Widget var0, int var1, int var2) {
      if(var0.field2799 == 1) {
         class21.addMenuEntry(var0.tooltip, "", 24, 0, 0, var0.id);
      }

      String var3;
      if(var0.field2799 == 2 && !Client.spellSelected) {
         if(class89.method1879(class230.getWidgetConfig(var0)) == 0) {
            var3 = null;
         } else if(var0.selectedAction != null && var0.selectedAction.trim().length() != 0) {
            var3 = var0.selectedAction;
         } else {
            var3 = null;
         }

         if(var3 != null) {
            class21.addMenuEntry(var3, BoundingBox3D.getColTags(65280) + var0.spellName, 25, 0, -1, var0.id);
         }
      }

      if(var0.field2799 == 3) {
         class21.addMenuEntry("Close", "", 26, 0, 0, var0.id);
      }

      if(var0.field2799 == 4) {
         class21.addMenuEntry(var0.tooltip, "", 28, 0, 0, var0.id);
      }

      if(var0.field2799 == 5) {
         class21.addMenuEntry(var0.tooltip, "", 29, 0, 0, var0.id);
      }

      if(var0.field2799 == 6 && Client.field930 == null) {
         class21.addMenuEntry(var0.tooltip, "", 30, 0, -1, var0.id);
      }

      int var5;
      int var6;
      int var19;
      if(var0.type == 2) {
         var19 = 0;

         for(int var20 = 0; var20 < var0.height; ++var20) {
            for(var5 = 0; var5 < var0.width; ++var5) {
               var6 = (var0.paddingX + 32) * var5;
               int var7 = (var0.paddingY + 32) * var20;
               if(var19 < 20) {
                  var6 += var0.xSprites[var19];
                  var7 += var0.field2825[var19];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < var6 + 32 && var2 < var7 + 32) {
                  Client.field918 = var19;
                  class109.field1552 = var0;
                  if(var0.itemIds[var19] > 0) {
                     label365: {
                        ItemComposition var8 = ContextMenuRow.getItemDefinition(var0.itemIds[var19] - 1);
                        boolean var9;
                        int var10;
                        if(Client.itemSelectionState == 1) {
                           var10 = class230.getWidgetConfig(var0);
                           var9 = (var10 >> 30 & 1) != 0;
                           if(var9) {
                              if(var0.id != MouseInput.field670 || var19 != GameObject.selectedItemIndex) {
                                 class21.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + BoundingBox3D.getColTags(16748608) + var8.name, 31, var8.id, var19, var0.id);
                              }
                              break label365;
                           }
                        }

                        if(Client.spellSelected) {
                           var10 = class230.getWidgetConfig(var0);
                           var9 = (var10 >> 30 & 1) != 0;
                           if(var9) {
                              if((Size.field340 & 16) == 16) {
                                 class21.addMenuEntry(Client.field961, Client.field962 + " " + "->" + " " + BoundingBox3D.getColTags(16748608) + var8.name, 32, var8.id, var19, var0.id);
                              }
                              break label365;
                           }
                        }

                        String[] var22 = var8.inventoryActions;
                        if(Client.numberMenuOptions) {
                           var22 = Item.prependIndices(var22);
                        }

                        var10 = -1;
                        if(Client.field951 && KeyFocusListener.keyPressed[81]) {
                           var10 = var8.method5014();
                        }

                        int var12 = class230.getWidgetConfig(var0);
                        boolean var11 = (var12 >> 30 & 1) != 0;
                        if(var11) {
                           for(int var13 = 4; var13 >= 3; --var13) {
                              if(var10 != var13) {
                                 Overlay.method5124(var0, var8, var19, var13, false);
                              }
                           }
                        }

                        int var14 = class230.getWidgetConfig(var0);
                        boolean var24 = (var14 >> 31 & 1) != 0;
                        if(var24) {
                           class21.addMenuEntry("Use", BoundingBox3D.getColTags(16748608) + var8.name, 38, var8.id, var19, var0.id);
                        }

                        int var16 = class230.getWidgetConfig(var0);
                        boolean var15 = (var16 >> 30 & 1) != 0;
                        int var17;
                        if(var15) {
                           for(var17 = 2; var17 >= 0; --var17) {
                              if(var17 != var10) {
                                 Overlay.method5124(var0, var8, var19, var17, false);
                              }
                           }

                           if(var10 >= 0) {
                              Overlay.method5124(var0, var8, var19, var10, true);
                           }
                        }

                        var22 = var0.configActions;
                        if(Client.numberMenuOptions) {
                           var22 = Item.prependIndices(var22);
                        }

                        if(var22 != null) {
                           for(var17 = 4; var17 >= 0; --var17) {
                              if(var22[var17] != null) {
                                 byte var18 = 0;
                                 if(var17 == 0) {
                                    var18 = 39;
                                 }

                                 if(var17 == 1) {
                                    var18 = 40;
                                 }

                                 if(var17 == 2) {
                                    var18 = 41;
                                 }

                                 if(var17 == 3) {
                                    var18 = 42;
                                 }

                                 if(var17 == 4) {
                                    var18 = 43;
                                 }

                                 class21.addMenuEntry(var22[var17], BoundingBox3D.getColTags(16748608) + var8.name, var18, var8.id, var19, var0.id);
                              }
                           }
                        }

                        class21.addMenuEntry("Examine", BoundingBox3D.getColTags(16748608) + var8.name, 1005, var8.id, var19, var0.id);
                     }
                  }
               }

               ++var19;
            }
         }
      }

      if(var0.hasScript) {
         if(Client.spellSelected) {
            if(Occluder.method3070(class230.getWidgetConfig(var0)) && (Size.field340 & 32) == 32) {
               class21.addMenuEntry(Client.field961, Client.field962 + " " + "->" + " " + var0.name, 58, 0, var0.index, var0.id);
            }
         } else {
            for(var19 = 9; var19 >= 5; --var19) {
               String var4 = class172.method3320(var0, var19);
               if(var4 != null) {
                  class21.addMenuEntry(var4, var0.name, 1007, var19 + 1, var0.index, var0.id);
               }
            }

            if(class89.method1879(class230.getWidgetConfig(var0)) == 0) {
               var3 = null;
            } else if(var0.selectedAction != null && var0.selectedAction.trim().length() != 0) {
               var3 = var0.selectedAction;
            } else {
               var3 = null;
            }

            if(var3 != null) {
               class21.addMenuEntry(var3, var0.name, 25, 0, var0.index, var0.id);
            }

            for(var5 = 4; var5 >= 0; --var5) {
               String var21 = class172.method3320(var0, var5);
               if(var21 != null) {
                  class21.addMenuEntry(var21, var0.name, 57, var5 + 1, var0.index, var0.id);
               }
            }

            var6 = class230.getWidgetConfig(var0);
            boolean var23 = (var6 & 1) != 0;
            if(var23) {
               class21.addMenuEntry("Continue", "", 30, 0, var0.index, var0.id);
            }
         }
      }

   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class36 {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Laz;"
   )
   static final class36 field494;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Laz;"
   )
   static final class36 field493;
   @ObfuscatedName("w")
   @Export("floorMultiplier")
   static int[] floorMultiplier;
   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "Lin;"
   )
   static Widget field492;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1507186641
   )
   final int field496;

   static {
      field494 = new class36(0);
      field493 = new class36(1);
   }

   class36(int var1) {
      this.field496 = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "127"
   )
   public static int method538(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILcr;ZI)I",
      garbageValue = "-2062006624"
   )
   static int method539(int var0, Script var1, boolean var2) {
      byte var3;
      int var4;
      int var5;
      int var6;
      Widget var28;
      Widget var51;
      if(var0 < 1000) {
         if(var0 == 100) {
            WorldComparator.intStackSize -= 3;
            var4 = class81.intStack[WorldComparator.intStackSize];
            var5 = class81.intStack[WorldComparator.intStackSize + 1];
            var6 = class81.intStack[WorldComparator.intStackSize + 2];
            if(var5 == 0) {
               throw new RuntimeException();
            }

            var28 = class44.getWidget(var4);
            if(var28.children == null) {
               var28.children = new Widget[var6 + 1];
            }

            if(var28.children.length <= var6) {
               Widget[] var29 = new Widget[var6 + 1];

               for(int var9 = 0; var9 < var28.children.length; ++var9) {
                  var29[var9] = var28.children[var9];
               }

               var28.children = var29;
            }

            if(var6 > 0 && var28.children[var6 - 1] == null) {
               throw new RuntimeException("" + (var6 - 1));
            }

            Widget var30 = new Widget();
            var30.type = var5;
            var30.parentId = var30.id = var28.id;
            var30.index = var6;
            var30.hasScript = true;
            var28.children[var6] = var30;
            if(var2) {
               class81.field1285 = var30;
            } else {
               Signlink.field2218 = var30;
            }

            FontName.method5490(var28);
            var3 = 1;
         } else if(var0 == 101) {
            var51 = var2?class81.field1285:Signlink.field2218;
            Widget var44 = class44.getWidget(var51.id);
            var44.children[var51.index] = null;
            FontName.method5490(var44);
            var3 = 1;
         } else if(var0 == 102) {
            var51 = class44.getWidget(class81.intStack[--WorldComparator.intStackSize]);
            var51.children = null;
            FontName.method5490(var51);
            var3 = 1;
         } else if(var0 == 200) {
            WorldComparator.intStackSize -= 2;
            var4 = class81.intStack[WorldComparator.intStackSize];
            var5 = class81.intStack[WorldComparator.intStackSize + 1];
            Widget var47 = FontName.getWidgetChild(var4, var5);
            if(var47 != null && var5 != -1) {
               class81.intStack[++WorldComparator.intStackSize - 1] = 1;
               if(var2) {
                  class81.field1285 = var47;
               } else {
                  Signlink.field2218 = var47;
               }
            } else {
               class81.intStack[++WorldComparator.intStackSize - 1] = 0;
            }

            var3 = 1;
         } else if(var0 == 201) {
            var51 = class44.getWidget(class81.intStack[--WorldComparator.intStackSize]);
            if(var51 != null) {
               class81.intStack[++WorldComparator.intStackSize - 1] = 1;
               if(var2) {
                  class81.field1285 = var51;
               } else {
                  Signlink.field2218 = var51;
               }
            } else {
               class81.intStack[++WorldComparator.intStackSize - 1] = 0;
            }

            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 1100) {
         return MessageNode.method1177(var0, var1, var2);
      } else if(var0 < 1200) {
         return PacketBuffer.method3806(var0, var1, var2);
      } else if(var0 < 1300) {
         return class132.method2776(var0, var1, var2);
      } else if(var0 < 1400) {
         return FileRequest.method4524(var0, var1, var2);
      } else if(var0 < 1500) {
         return Varbit.method4898(var0, var1, var2);
      } else if(var0 < 1600) {
         var28 = var2?class81.field1285:Signlink.field2218;
         if(var0 == 1500) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var28.relativeX;
            var3 = 1;
         } else if(var0 == 1501) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var28.relativeY;
            var3 = 1;
         } else if(var0 == 1502) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var28.width;
            var3 = 1;
         } else if(var0 == 1503) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var28.height;
            var3 = 1;
         } else if(var0 == 1504) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var28.isHidden?1:0;
            var3 = 1;
         } else if(var0 == 1505) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var28.parentId;
            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 1700) {
         var51 = var2?class81.field1285:Signlink.field2218;
         if(var0 == 1600) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var51.scrollX;
            var3 = 1;
         } else if(var0 == 1601) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var51.scrollY;
            var3 = 1;
         } else if(var0 == 1602) {
            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var51.text;
            var3 = 1;
         } else if(var0 == 1603) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var51.scrollWidth;
            var3 = 1;
         } else if(var0 == 1604) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var51.scrollHeight;
            var3 = 1;
         } else if(var0 == 1605) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var51.modelZoom;
            var3 = 1;
         } else if(var0 == 1606) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var51.rotationX;
            var3 = 1;
         } else if(var0 == 1607) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var51.rotationY;
            var3 = 1;
         } else if(var0 == 1608) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var51.rotationZ;
            var3 = 1;
         } else if(var0 == 1609) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var51.opacity;
            var3 = 1;
         } else if(var0 == 1610) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var51.field2854;
            var3 = 1;
         } else if(var0 == 1611) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var51.textColor;
            var3 = 1;
         } else if(var0 == 1612) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var51.field2841;
            var3 = 1;
         } else if(var0 == 1613) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var51.field2909.rsOrdinal();
            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 1800) {
         var28 = var2?class81.field1285:Signlink.field2218;
         if(var0 == 1700) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var28.itemId;
            var3 = 1;
         } else if(var0 == 1701) {
            if(var28.itemId != -1) {
               class81.intStack[++WorldComparator.intStackSize - 1] = var28.itemQuantity;
            } else {
               class81.intStack[++WorldComparator.intStackSize - 1] = 0;
            }

            var3 = 1;
         } else if(var0 == 1702) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var28.index;
            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 1900) {
         return PlayerComposition.method4409(var0, var1, var2);
      } else if(var0 < 2000) {
         return ClientPacket.method3434(var0, var1, var2);
      } else if(var0 < 2100) {
         return MessageNode.method1177(var0, var1, var2);
      } else if(var0 < 2200) {
         return PacketBuffer.method3806(var0, var1, var2);
      } else if(var0 < 2300) {
         return class132.method2776(var0, var1, var2);
      } else if(var0 < 2400) {
         return FileRequest.method4524(var0, var1, var2);
      } else if(var0 < 2500) {
         return Varbit.method4898(var0, var1, var2);
      } else if(var0 < 2600) {
         return class28.method273(var0, var1, var2);
      } else if(var0 < 2700) {
         var51 = class44.getWidget(class81.intStack[--WorldComparator.intStackSize]);
         if(var0 == 2600) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var51.scrollX;
            var3 = 1;
         } else if(var0 == 2601) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var51.scrollY;
            var3 = 1;
         } else if(var0 == 2602) {
            class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var51.text;
            var3 = 1;
         } else if(var0 == 2603) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var51.scrollWidth;
            var3 = 1;
         } else if(var0 == 2604) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var51.scrollHeight;
            var3 = 1;
         } else if(var0 == 2605) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var51.modelZoom;
            var3 = 1;
         } else if(var0 == 2606) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var51.rotationX;
            var3 = 1;
         } else if(var0 == 2607) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var51.rotationY;
            var3 = 1;
         } else if(var0 == 2608) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var51.rotationZ;
            var3 = 1;
         } else if(var0 == 2609) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var51.opacity;
            var3 = 1;
         } else if(var0 == 2610) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var51.field2854;
            var3 = 1;
         } else if(var0 == 2611) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var51.textColor;
            var3 = 1;
         } else if(var0 == 2612) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var51.field2841;
            var3 = 1;
         } else if(var0 == 2613) {
            class81.intStack[++WorldComparator.intStackSize - 1] = var51.field2909.rsOrdinal();
            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 2800) {
         if(var0 == 2700) {
            var51 = class44.getWidget(class81.intStack[--WorldComparator.intStackSize]);
            class81.intStack[++WorldComparator.intStackSize - 1] = var51.itemId;
            var3 = 1;
         } else if(var0 == 2701) {
            var51 = class44.getWidget(class81.intStack[--WorldComparator.intStackSize]);
            if(var51.itemId != -1) {
               class81.intStack[++WorldComparator.intStackSize - 1] = var51.itemQuantity;
            } else {
               class81.intStack[++WorldComparator.intStackSize - 1] = 0;
            }

            var3 = 1;
         } else if(var0 == 2702) {
            var4 = class81.intStack[--WorldComparator.intStackSize];
            WidgetNode var42 = (WidgetNode)Client.componentTable.get((long)var4);
            if(var42 != null) {
               class81.intStack[++WorldComparator.intStackSize - 1] = 1;
            } else {
               class81.intStack[++WorldComparator.intStackSize - 1] = 0;
            }

            var3 = 1;
         } else if(var0 == 2706) {
            class81.intStack[++WorldComparator.intStackSize - 1] = Client.widgetRoot;
            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 2900) {
         var51 = class44.getWidget(class81.intStack[--WorldComparator.intStackSize]);
         if(var0 == 2800) {
            class81.intStack[++WorldComparator.intStackSize - 1] = class250.method4502(GroundObject.getWidgetClickMask(var51));
            var3 = 1;
         } else if(var0 == 2801) {
            var5 = class81.intStack[--WorldComparator.intStackSize];
            --var5;
            if(var51.actions != null && var5 < var51.actions.length && var51.actions[var5] != null) {
               class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var51.actions[var5];
            } else {
               class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
            }

            var3 = 1;
         } else if(var0 == 2802) {
            if(var51.opBase == null) {
               class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
            } else {
               class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var51.opBase;
            }

            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 3000) {
         return ClientPacket.method3434(var0, var1, var2);
      } else if(var0 < 3200) {
         return WorldMapManager.method610(var0, var1, var2);
      } else if(var0 < 3300) {
         return class23.method188(var0, var1, var2);
      } else {
         int var10;
         int var16;
         int[] var33;
         int var49;
         if(var0 < 3400) {
            if(var0 == 3300) {
               class81.intStack[++WorldComparator.intStackSize - 1] = Client.gameCycle;
               var3 = 1;
            } else if(var0 == 3301) {
               WorldComparator.intStackSize -= 2;
               var4 = class81.intStack[WorldComparator.intStackSize];
               var5 = class81.intStack[WorldComparator.intStackSize + 1];
               class81.intStack[++WorldComparator.intStackSize - 1] = class61.method1072(var4, var5);
               var3 = 1;
            } else if(var0 == 3302) {
               WorldComparator.intStackSize -= 2;
               var4 = class81.intStack[WorldComparator.intStackSize];
               var5 = class81.intStack[WorldComparator.intStackSize + 1];
               class81.intStack[++WorldComparator.intStackSize - 1] = BoundingBox.method41(var4, var5);
               var3 = 1;
            } else {
               int var11;
               int[] var46;
               ItemContainer var48;
               if(var0 == 3303) {
                  WorldComparator.intStackSize -= 2;
                  var4 = class81.intStack[WorldComparator.intStackSize];
                  var5 = class81.intStack[WorldComparator.intStackSize + 1];
                  var46 = class81.intStack;
                  var16 = ++WorldComparator.intStackSize - 1;
                  var48 = (ItemContainer)ItemContainer.itemContainers.get((long)var4);
                  if(var48 == null) {
                     var49 = 0;
                  } else if(var5 == -1) {
                     var49 = 0;
                  } else {
                     var10 = 0;

                     for(var11 = 0; var11 < var48.stackSizes.length; ++var11) {
                        if(var5 == var48.itemIds[var11]) {
                           var10 += var48.stackSizes[var11];
                        }
                     }

                     var49 = var10;
                  }

                  var46[var16] = var49;
                  var3 = 1;
               } else if(var0 == 3304) {
                  var4 = class81.intStack[--WorldComparator.intStackSize];
                  var33 = class81.intStack;
                  var6 = ++WorldComparator.intStackSize - 1;
                  InvType var27 = (InvType)InvType.inventoryCache.get((long)var4);
                  InvType var26;
                  if(var27 != null) {
                     var26 = var27;
                  } else {
                     byte[] var50 = InvType.field3449.getConfigData(5, var4);
                     var27 = new InvType();
                     if(var50 != null) {
                        var27.decode(new Buffer(var50));
                     }

                     InvType.inventoryCache.put(var27, (long)var4);
                     var26 = var27;
                  }

                  var33[var6] = var26.size;
                  var3 = 1;
               } else if(var0 == 3305) {
                  var4 = class81.intStack[--WorldComparator.intStackSize];
                  class81.intStack[++WorldComparator.intStackSize - 1] = Client.boostedSkillLevels[var4];
                  var3 = 1;
               } else if(var0 == 3306) {
                  var4 = class81.intStack[--WorldComparator.intStackSize];
                  class81.intStack[++WorldComparator.intStackSize - 1] = Client.realSkillLevels[var4];
                  var3 = 1;
               } else if(var0 == 3307) {
                  var4 = class81.intStack[--WorldComparator.intStackSize];
                  class81.intStack[++WorldComparator.intStackSize - 1] = Client.skillExperiences[var4];
                  var3 = 1;
               } else if(var0 == 3308) {
                  var4 = BoundingBox3DDrawMode.plane;
                  var5 = (SoundTaskDataProvider.localPlayer.x >> 7) + class138.baseX;
                  var6 = (SoundTaskDataProvider.localPlayer.y >> 7) + class23.baseY;
                  class81.intStack[++WorldComparator.intStackSize - 1] = (var5 << 14) + var6 + (var4 << 28);
                  var3 = 1;
               } else if(var0 == 3309) {
                  var4 = class81.intStack[--WorldComparator.intStackSize];
                  class81.intStack[++WorldComparator.intStackSize - 1] = var4 >> 14 & 16383;
                  var3 = 1;
               } else if(var0 == 3310) {
                  var4 = class81.intStack[--WorldComparator.intStackSize];
                  class81.intStack[++WorldComparator.intStackSize - 1] = var4 >> 28;
                  var3 = 1;
               } else if(var0 == 3311) {
                  var4 = class81.intStack[--WorldComparator.intStackSize];
                  class81.intStack[++WorldComparator.intStackSize - 1] = var4 & 16383;
                  var3 = 1;
               } else if(var0 == 3312) {
                  class81.intStack[++WorldComparator.intStackSize - 1] = Client.isMembers?1:0;
                  var3 = 1;
               } else if(var0 == 3313) {
                  WorldComparator.intStackSize -= 2;
                  var4 = class81.intStack[WorldComparator.intStackSize] + 32768;
                  var5 = class81.intStack[WorldComparator.intStackSize + 1];
                  class81.intStack[++WorldComparator.intStackSize - 1] = class61.method1072(var4, var5);
                  var3 = 1;
               } else if(var0 == 3314) {
                  WorldComparator.intStackSize -= 2;
                  var4 = class81.intStack[WorldComparator.intStackSize] + 32768;
                  var5 = class81.intStack[WorldComparator.intStackSize + 1];
                  class81.intStack[++WorldComparator.intStackSize - 1] = BoundingBox.method41(var4, var5);
                  var3 = 1;
               } else if(var0 == 3315) {
                  WorldComparator.intStackSize -= 2;
                  var4 = class81.intStack[WorldComparator.intStackSize] + 32768;
                  var5 = class81.intStack[WorldComparator.intStackSize + 1];
                  var46 = class81.intStack;
                  var16 = ++WorldComparator.intStackSize - 1;
                  var48 = (ItemContainer)ItemContainer.itemContainers.get((long)var4);
                  if(var48 == null) {
                     var49 = 0;
                  } else if(var5 == -1) {
                     var49 = 0;
                  } else {
                     var10 = 0;

                     for(var11 = 0; var11 < var48.stackSizes.length; ++var11) {
                        if(var5 == var48.itemIds[var11]) {
                           var10 += var48.stackSizes[var11];
                        }
                     }

                     var49 = var10;
                  }

                  var46[var16] = var49;
                  var3 = 1;
               } else if(var0 == 3316) {
                  if(Client.rights >= 2) {
                     class81.intStack[++WorldComparator.intStackSize - 1] = Client.rights;
                  } else {
                     class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                  }

                  var3 = 1;
               } else if(var0 == 3317) {
                  class81.intStack[++WorldComparator.intStackSize - 1] = Client.field888;
                  var3 = 1;
               } else if(var0 == 3318) {
                  class81.intStack[++WorldComparator.intStackSize - 1] = Client.world;
                  var3 = 1;
               } else if(var0 == 3321) {
                  class81.intStack[++WorldComparator.intStackSize - 1] = Client.energy;
                  var3 = 1;
               } else if(var0 == 3322) {
                  class81.intStack[++WorldComparator.intStackSize - 1] = Client.weight;
                  var3 = 1;
               } else if(var0 == 3323) {
                  if(Client.field1020) {
                     class81.intStack[++WorldComparator.intStackSize - 1] = 1;
                  } else {
                     class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                  }

                  var3 = 1;
               } else if(var0 == 3324) {
                  class81.intStack[++WorldComparator.intStackSize - 1] = Client.flags;
                  var3 = 1;
               } else if(var0 == 3325) {
                  WorldComparator.intStackSize -= 4;
                  var4 = class81.intStack[WorldComparator.intStackSize];
                  var5 = class81.intStack[WorldComparator.intStackSize + 1];
                  var6 = class81.intStack[WorldComparator.intStackSize + 2];
                  var16 = class81.intStack[WorldComparator.intStackSize + 3];
                  var4 += var5 << 14;
                  var4 += var6 << 28;
                  var4 += var16;
                  class81.intStack[++WorldComparator.intStackSize - 1] = var4;
                  var3 = 1;
               } else {
                  var3 = 2;
               }
            }

            return var3;
         } else if(var0 < 3500) {
            Enum var41;
            if(var0 == 3400) {
               WorldComparator.intStackSize -= 2;
               var4 = class81.intStack[WorldComparator.intStackSize];
               var5 = class81.intStack[WorldComparator.intStackSize + 1];
               Enum var20 = (Enum)Enum.EnumDefinition_cached.get((long)var4);
               if(var20 != null) {
                  var41 = var20;
               } else {
                  byte[] var22 = Enum.EnumDefinition_indexCache.getConfigData(8, var4);
                  var20 = new Enum();
                  if(var22 != null) {
                     var20.decode(new Buffer(var22));
                  }

                  Enum.EnumDefinition_cached.put(var20, (long)var4);
                  var41 = var20;
               }

               var20 = var41;
               if(var41.valType != 's') {
                  ;
               }

               for(var49 = 0; var49 < var20.size; ++var49) {
                  if(var5 == var20.keys[var49]) {
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var20.stringVals[var49];
                     var20 = null;
                     break;
                  }
               }

               if(var20 != null) {
                  class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var20.defaultString;
               }

               var3 = 1;
            } else if(var0 == 3408) {
               WorldComparator.intStackSize -= 4;
               var4 = class81.intStack[WorldComparator.intStackSize];
               var5 = class81.intStack[WorldComparator.intStackSize + 1];
               var6 = class81.intStack[WorldComparator.intStackSize + 2];
               var16 = class81.intStack[WorldComparator.intStackSize + 3];
               Enum var45 = (Enum)Enum.EnumDefinition_cached.get((long)var6);
               Enum var24;
               if(var45 != null) {
                  var24 = var45;
               } else {
                  byte[] var18 = Enum.EnumDefinition_indexCache.getConfigData(8, var6);
                  var45 = new Enum();
                  if(var18 != null) {
                     var45.decode(new Buffer(var18));
                  }

                  Enum.EnumDefinition_cached.put(var45, (long)var6);
                  var24 = var45;
               }

               var45 = var24;
               if(var4 == var24.keyType && var5 == var24.valType) {
                  for(var10 = 0; var10 < var45.size; ++var10) {
                     if(var16 == var45.keys[var10]) {
                        if(var5 == 115) {
                           class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var45.stringVals[var10];
                        } else {
                           class81.intStack[++WorldComparator.intStackSize - 1] = var45.intVals[var10];
                        }

                        var45 = null;
                        break;
                     }
                  }

                  if(var45 != null) {
                     if(var5 == 115) {
                        class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var45.defaultString;
                     } else {
                        class81.intStack[++WorldComparator.intStackSize - 1] = var45.defaultInt;
                     }
                  }

                  var3 = 1;
               } else {
                  if(var5 == 115) {
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "null";
                  } else {
                     class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                  }

                  var3 = 1;
               }
            } else if(var0 == 3411) {
               var4 = class81.intStack[--WorldComparator.intStackSize];
               var41 = (Enum)Enum.EnumDefinition_cached.get((long)var4);
               Enum var40;
               if(var41 != null) {
                  var40 = var41;
               } else {
                  byte[] var25 = Enum.EnumDefinition_indexCache.getConfigData(8, var4);
                  var41 = new Enum();
                  if(var25 != null) {
                     var41.decode(new Buffer(var25));
                  }

                  Enum.EnumDefinition_cached.put(var41, (long)var4);
                  var40 = var41;
               }

               class81.intStack[++WorldComparator.intStackSize - 1] = var40.method4957();
               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else {
            String var31;
            PacketNode var35;
            if(var0 < 3700) {
               if(var0 == 3600) {
                  if(WorldMapRectangle.friendManager.field1253 == 0) {
                     class81.intStack[++WorldComparator.intStackSize - 1] = -2;
                  } else if(WorldMapRectangle.friendManager.field1253 == 1) {
                     class81.intStack[++WorldComparator.intStackSize - 1] = -1;
                  } else {
                     class81.intStack[++WorldComparator.intStackSize - 1] = WorldMapRectangle.friendManager.field1256.getCount();
                  }

                  var3 = 1;
               } else if(var0 == 3601) {
                  var4 = class81.intStack[--WorldComparator.intStackSize];
                  if(WorldMapRectangle.friendManager.method1732() && var4 >= 0 && var4 < WorldMapRectangle.friendManager.field1256.getCount()) {
                     Friend var34 = (Friend)WorldMapRectangle.friendManager.field1256.get(var4);
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var34.method5267();
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var34.method5263();
                  } else {
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                  }

                  var3 = 1;
               } else if(var0 == 3602) {
                  var4 = class81.intStack[--WorldComparator.intStackSize];
                  if(WorldMapRectangle.friendManager.method1732() && var4 >= 0 && var4 < WorldMapRectangle.friendManager.field1256.getCount()) {
                     class81.intStack[++WorldComparator.intStackSize - 1] = ((ChatPlayer)WorldMapRectangle.friendManager.field1256.get(var4)).world;
                  } else {
                     class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                  }

                  var3 = 1;
               } else if(var0 == 3603) {
                  var4 = class81.intStack[--WorldComparator.intStackSize];
                  if(WorldMapRectangle.friendManager.method1732() && var4 >= 0 && var4 < WorldMapRectangle.friendManager.field1256.getCount()) {
                     class81.intStack[++WorldComparator.intStackSize - 1] = ((ChatPlayer)WorldMapRectangle.friendManager.field1256.get(var4)).rank;
                  } else {
                     class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                  }

                  var3 = 1;
               } else if(var0 == 3604) {
                  var31 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                  var5 = class81.intStack[--WorldComparator.intStackSize];
                  var35 = WorldMapRectangle.method280(ClientPacket.field2462, Client.field957.field1484);
                  var35.packetBuffer.putByte(WorldMapRegion.getLength(var31) + 1);
                  var35.packetBuffer.method3541(var5);
                  var35.packetBuffer.putString(var31);
                  Client.field957.method2052(var35);
                  var3 = 1;
               } else if(var0 == 3605) {
                  var31 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                  WorldMapRectangle.friendManager.addToFriendsList(var31);
                  var3 = 1;
               } else if(var0 == 3606) {
                  var31 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                  WorldMapRectangle.friendManager.method1742(var31);
                  var3 = 1;
               } else if(var0 == 3607) {
                  var31 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                  WorldMapRectangle.friendManager.addToIgnoreList(var31);
                  var3 = 1;
               } else if(var0 == 3608) {
                  var31 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                  WorldMapRectangle.friendManager.method1743(var31);
                  var3 = 1;
               } else if(var0 == 3609) {
                  var31 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                  var31 = FontName.method5489(var31);
                  class81.intStack[++WorldComparator.intStackSize - 1] = WorldMapRectangle.friendManager.isFriended(new Name(var31, GZipDecompressor.loginType), false)?1:0;
                  var3 = 1;
               } else if(var0 == 3611) {
                  if(GameEngine.clanMemberManager != null) {
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = GameEngine.clanMemberManager.field3870;
                  } else {
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                  }

                  var3 = 1;
               } else if(var0 == 3612) {
                  if(GameEngine.clanMemberManager != null) {
                     class81.intStack[++WorldComparator.intStackSize - 1] = GameEngine.clanMemberManager.getCount();
                  } else {
                     class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                  }

                  var3 = 1;
               } else if(var0 == 3613) {
                  var4 = class81.intStack[--WorldComparator.intStackSize];
                  if(GameEngine.clanMemberManager != null && var4 < GameEngine.clanMemberManager.getCount()) {
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = GameEngine.clanMemberManager.get(var4).method5271().getName();
                  } else {
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                  }

                  var3 = 1;
               } else if(var0 == 3614) {
                  var4 = class81.intStack[--WorldComparator.intStackSize];
                  if(GameEngine.clanMemberManager != null && var4 < GameEngine.clanMemberManager.getCount()) {
                     class81.intStack[++WorldComparator.intStackSize - 1] = ((ChatPlayer)GameEngine.clanMemberManager.get(var4)).method5390();
                  } else {
                     class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                  }

                  var3 = 1;
               } else if(var0 == 3615) {
                  var4 = class81.intStack[--WorldComparator.intStackSize];
                  if(GameEngine.clanMemberManager != null && var4 < GameEngine.clanMemberManager.getCount()) {
                     class81.intStack[++WorldComparator.intStackSize - 1] = ((ChatPlayer)GameEngine.clanMemberManager.get(var4)).rank;
                  } else {
                     class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                  }

                  var3 = 1;
               } else if(var0 == 3616) {
                  class81.intStack[++WorldComparator.intStackSize - 1] = GameEngine.clanMemberManager != null?GameEngine.clanMemberManager.field3865:0;
                  var3 = 1;
               } else if(var0 == 3617) {
                  var31 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                  GrandExchangeEvent.method80(var31);
                  var3 = 1;
               } else if(var0 == 3618) {
                  class81.intStack[++WorldComparator.intStackSize - 1] = GameEngine.clanMemberManager != null?GameEngine.clanMemberManager.field3871:0;
                  var3 = 1;
               } else if(var0 == 3619) {
                  var31 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                  if(!var31.equals("")) {
                     PacketNode var37 = WorldMapRectangle.method280(ClientPacket.field2398, Client.field957.field1484);
                     var37.packetBuffer.putByte(WorldMapRegion.getLength(var31));
                     var37.packetBuffer.putString(var31);
                     Client.field957.method2052(var37);
                  }

                  var3 = 1;
               } else if(var0 == 3620) {
                  GroundObject.method2671();
                  var3 = 1;
               } else if(var0 == 3621) {
                  if(!WorldMapRectangle.friendManager.method1732()) {
                     class81.intStack[++WorldComparator.intStackSize - 1] = -1;
                  } else {
                     class81.intStack[++WorldComparator.intStackSize - 1] = WorldMapRectangle.friendManager.field1254.getCount();
                  }

                  var3 = 1;
               } else if(var0 == 3622) {
                  var4 = class81.intStack[--WorldComparator.intStackSize];
                  if(WorldMapRectangle.friendManager.method1732() && var4 >= 0 && var4 < WorldMapRectangle.friendManager.field1254.getCount()) {
                     Ignore var39 = (Ignore)WorldMapRectangle.friendManager.field1254.get(var4);
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var39.method5267();
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var39.method5263();
                  } else {
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                  }

                  var3 = 1;
               } else if(var0 == 3623) {
                  var31 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                  var31 = FontName.method5489(var31);
                  class81.intStack[++WorldComparator.intStackSize - 1] = WorldMapRectangle.friendManager.isIgnored(new Name(var31, GZipDecompressor.loginType))?1:0;
                  var3 = 1;
               } else if(var0 == 3624) {
                  var4 = class81.intStack[--WorldComparator.intStackSize];
                  if(GameEngine.clanMemberManager != null && var4 < GameEngine.clanMemberManager.getCount() && GameEngine.clanMemberManager.get(var4).method5271().equals(SoundTaskDataProvider.localPlayer.name)) {
                     class81.intStack[++WorldComparator.intStackSize - 1] = 1;
                  } else {
                     class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                  }

                  var3 = 1;
               } else if(var0 == 3625) {
                  if(GameEngine.clanMemberManager != null && GameEngine.clanMemberManager.field3869 != null) {
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = GameEngine.clanMemberManager.field3869;
                  } else {
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                  }

                  var3 = 1;
               } else if(var0 == 3626) {
                  var4 = class81.intStack[--WorldComparator.intStackSize];
                  if(GameEngine.clanMemberManager != null && var4 < GameEngine.clanMemberManager.getCount() && ((ClanMember)GameEngine.clanMemberManager.get(var4)).method5242()) {
                     class81.intStack[++WorldComparator.intStackSize - 1] = 1;
                  } else {
                     class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                  }

                  var3 = 1;
               } else if(var0 == 3627) {
                  var4 = class81.intStack[--WorldComparator.intStackSize];
                  if(GameEngine.clanMemberManager != null && var4 < GameEngine.clanMemberManager.getCount() && ((ClanMember)GameEngine.clanMemberManager.get(var4)).method5260()) {
                     class81.intStack[++WorldComparator.intStackSize - 1] = 1;
                  } else {
                     class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                  }

                  var3 = 1;
               } else if(var0 == 3628) {
                  WorldMapRectangle.friendManager.field1256.method5323();
                  var3 = 1;
               } else {
                  boolean var23;
                  if(var0 == 3629) {
                     var23 = class81.intStack[--WorldComparator.intStackSize] == 1;
                     WorldMapRectangle.friendManager.field1256.method5324(new class321(var23));
                     var3 = 1;
                  } else if(var0 == 3630) {
                     var23 = class81.intStack[--WorldComparator.intStackSize] == 1;
                     WorldMapRectangle.friendManager.field1256.method5324(new class322(var23));
                     var3 = 1;
                  } else if(var0 == 3631) {
                     var23 = class81.intStack[--WorldComparator.intStackSize] == 1;
                     WorldMapRectangle.friendManager.field1256.method5324(new class155(var23));
                     var3 = 1;
                  } else if(var0 == 3632) {
                     var23 = class81.intStack[--WorldComparator.intStackSize] == 1;
                     WorldMapRectangle.friendManager.field1256.method5324(new class149(var23));
                     var3 = 1;
                  } else if(var0 == 3633) {
                     var23 = class81.intStack[--WorldComparator.intStackSize] == 1;
                     WorldMapRectangle.friendManager.field1256.method5324(new class154(var23));
                     var3 = 1;
                  } else if(var0 == 3634) {
                     var23 = class81.intStack[--WorldComparator.intStackSize] == 1;
                     WorldMapRectangle.friendManager.field1256.method5324(new class157(var23));
                     var3 = 1;
                  } else if(var0 == 3635) {
                     var23 = class81.intStack[--WorldComparator.intStackSize] == 1;
                     WorldMapRectangle.friendManager.field1256.method5324(new class153(var23));
                     var3 = 1;
                  } else if(var0 == 3636) {
                     var23 = class81.intStack[--WorldComparator.intStackSize] == 1;
                     WorldMapRectangle.friendManager.field1256.method5324(new class151(var23));
                     var3 = 1;
                  } else if(var0 == 3637) {
                     var23 = class81.intStack[--WorldComparator.intStackSize] == 1;
                     WorldMapRectangle.friendManager.field1256.method5324(new class150(var23));
                     var3 = 1;
                  } else if(var0 == 3638) {
                     var23 = class81.intStack[--WorldComparator.intStackSize] == 1;
                     WorldMapRectangle.friendManager.field1256.method5324(new class152(var23));
                     var3 = 1;
                  } else if(var0 == 3639) {
                     WorldMapRectangle.friendManager.field1256.method5331();
                     var3 = 1;
                  } else if(var0 == 3640) {
                     WorldMapRectangle.friendManager.field1254.method5323();
                     var3 = 1;
                  } else if(var0 == 3641) {
                     var23 = class81.intStack[--WorldComparator.intStackSize] == 1;
                     WorldMapRectangle.friendManager.field1254.method5324(new class321(var23));
                     var3 = 1;
                  } else if(var0 == 3642) {
                     var23 = class81.intStack[--WorldComparator.intStackSize] == 1;
                     WorldMapRectangle.friendManager.field1254.method5324(new class322(var23));
                     var3 = 1;
                  } else if(var0 == 3643) {
                     WorldMapRectangle.friendManager.field1254.method5331();
                     var3 = 1;
                  } else if(var0 == 3644) {
                     if(GameEngine.clanMemberManager != null) {
                        GameEngine.clanMemberManager.method5323();
                     }

                     var3 = 1;
                  } else if(var0 == 3645) {
                     var23 = class81.intStack[--WorldComparator.intStackSize] == 1;
                     if(GameEngine.clanMemberManager != null) {
                        GameEngine.clanMemberManager.method5324(new class321(var23));
                     }

                     var3 = 1;
                  } else if(var0 == 3646) {
                     var23 = class81.intStack[--WorldComparator.intStackSize] == 1;
                     if(GameEngine.clanMemberManager != null) {
                        GameEngine.clanMemberManager.method5324(new class322(var23));
                     }

                     var3 = 1;
                  } else if(var0 == 3647) {
                     var23 = class81.intStack[--WorldComparator.intStackSize] == 1;
                     if(GameEngine.clanMemberManager != null) {
                        GameEngine.clanMemberManager.method5324(new class155(var23));
                     }

                     var3 = 1;
                  } else if(var0 == 3648) {
                     var23 = class81.intStack[--WorldComparator.intStackSize] == 1;
                     if(GameEngine.clanMemberManager != null) {
                        GameEngine.clanMemberManager.method5324(new class149(var23));
                     }

                     var3 = 1;
                  } else if(var0 == 3649) {
                     var23 = class81.intStack[--WorldComparator.intStackSize] == 1;
                     if(GameEngine.clanMemberManager != null) {
                        GameEngine.clanMemberManager.method5324(new class154(var23));
                     }

                     var3 = 1;
                  } else if(var0 == 3650) {
                     var23 = class81.intStack[--WorldComparator.intStackSize] == 1;
                     if(GameEngine.clanMemberManager != null) {
                        GameEngine.clanMemberManager.method5324(new class157(var23));
                     }

                     var3 = 1;
                  } else if(var0 == 3651) {
                     var23 = class81.intStack[--WorldComparator.intStackSize] == 1;
                     if(GameEngine.clanMemberManager != null) {
                        GameEngine.clanMemberManager.method5324(new class153(var23));
                     }

                     var3 = 1;
                  } else if(var0 == 3652) {
                     var23 = class81.intStack[--WorldComparator.intStackSize] == 1;
                     if(GameEngine.clanMemberManager != null) {
                        GameEngine.clanMemberManager.method5324(new class151(var23));
                     }

                     var3 = 1;
                  } else if(var0 == 3653) {
                     var23 = class81.intStack[--WorldComparator.intStackSize] == 1;
                     if(GameEngine.clanMemberManager != null) {
                        GameEngine.clanMemberManager.method5324(new class150(var23));
                     }

                     var3 = 1;
                  } else if(var0 == 3654) {
                     var23 = class81.intStack[--WorldComparator.intStackSize] == 1;
                     if(GameEngine.clanMemberManager != null) {
                        GameEngine.clanMemberManager.method5324(new class152(var23));
                     }

                     var3 = 1;
                  } else if(var0 == 3655) {
                     if(GameEngine.clanMemberManager != null) {
                        GameEngine.clanMemberManager.method5331();
                     }

                     var3 = 1;
                  } else if(var0 == 3656) {
                     var23 = class81.intStack[--WorldComparator.intStackSize] == 1;
                     WorldMapRectangle.friendManager.field1256.method5324(new class156(var23));
                     var3 = 1;
                  } else if(var0 == 3657) {
                     var23 = class81.intStack[--WorldComparator.intStackSize] == 1;
                     if(GameEngine.clanMemberManager != null) {
                        GameEngine.clanMemberManager.method5324(new class156(var23));
                     }

                     var3 = 1;
                  } else {
                     var3 = 2;
                  }
               }

               return var3;
            } else if(var0 < 4000) {
               return World.method1695(var0, var1, var2);
            } else if(var0 < 4100) {
               return WorldComparator.method57(var0, var1, var2);
            } else if(var0 < 4200) {
               return class47.method747(var0, var1, var2);
            } else if(var0 < 4300) {
               return ScriptVarType.method16(var0, var1, var2);
            } else if(var0 >= 5100) {
               if(var0 < 5400) {
                  return GrandExchangeOffer.method110(var0, var1, var2);
               } else if(var0 < 5600) {
                  return GroundObject.method2672(var0, var1, var2);
               } else if(var0 < 5700) {
                  return OwnWorldComparator.method1235(var0, var1, var2);
               } else if(var0 < 6300) {
                  if(var0 == 6200) {
                     WorldComparator.intStackSize -= 2;
                     Client.field1120 = (short)class81.intStack[WorldComparator.intStackSize];
                     if(Client.field1120 <= 0) {
                        Client.field1120 = 256;
                     }

                     Client.field1118 = (short)class81.intStack[WorldComparator.intStackSize + 1];
                     if(Client.field1118 <= 0) {
                        Client.field1118 = 205;
                     }

                     var3 = 1;
                  } else if(var0 == 6201) {
                     WorldComparator.intStackSize -= 2;
                     Client.field1018 = (short)class81.intStack[WorldComparator.intStackSize];
                     if(Client.field1018 <= 0) {
                        Client.field1018 = 256;
                     }

                     Client.field1104 = (short)class81.intStack[WorldComparator.intStackSize + 1];
                     if(Client.field1104 <= 0) {
                        Client.field1104 = 320;
                     }

                     var3 = 1;
                  } else if(var0 == 6202) {
                     WorldComparator.intStackSize -= 4;
                     Client.field1121 = (short)class81.intStack[WorldComparator.intStackSize];
                     if(Client.field1121 <= 0) {
                        Client.field1121 = 1;
                     }

                     Client.field1122 = (short)class81.intStack[WorldComparator.intStackSize + 1];
                     if(Client.field1122 <= 0) {
                        Client.field1122 = 32767;
                     } else if(Client.field1122 < Client.field1121) {
                        Client.field1122 = Client.field1121;
                     }

                     Client.field1123 = (short)class81.intStack[WorldComparator.intStackSize + 2];
                     if(Client.field1123 <= 0) {
                        Client.field1123 = 1;
                     }

                     Client.field911 = (short)class81.intStack[WorldComparator.intStackSize + 3];
                     if(Client.field911 <= 0) {
                        Client.field911 = 32767;
                     } else if(Client.field911 < Client.field1123) {
                        Client.field911 = Client.field1123;
                     }

                     var3 = 1;
                  } else if(var0 == 6203) {
                     if(Client.field1039 != null) {
                        WorldMapRegion.method535(0, 0, Client.field1039.width, Client.field1039.height, false);
                        class81.intStack[++WorldComparator.intStackSize - 1] = Client.viewportWidth;
                        class81.intStack[++WorldComparator.intStackSize - 1] = Client.viewportHeight;
                     } else {
                        class81.intStack[++WorldComparator.intStackSize - 1] = -1;
                        class81.intStack[++WorldComparator.intStackSize - 1] = -1;
                     }

                     var3 = 1;
                  } else if(var0 == 6204) {
                     class81.intStack[++WorldComparator.intStackSize - 1] = Client.field1018;
                     class81.intStack[++WorldComparator.intStackSize - 1] = Client.field1104;
                     var3 = 1;
                  } else if(var0 == 6205) {
                     class81.intStack[++WorldComparator.intStackSize - 1] = Client.field1120;
                     class81.intStack[++WorldComparator.intStackSize - 1] = Client.field1118;
                     var3 = 1;
                  } else {
                     var3 = 2;
                  }

                  return var3;
               } else {
                  return var0 < 6600?class22.method173(var0, var1, var2):(var0 < 6700?class1.method0(var0, var1, var2):2);
               }
            } else {
               if(var0 == 5000) {
                  class81.intStack[++WorldComparator.intStackSize - 1] = Client.publicChatMode;
                  var3 = 1;
               } else if(var0 == 5001) {
                  WorldComparator.intStackSize -= 3;
                  Client.publicChatMode = class81.intStack[WorldComparator.intStackSize];
                  var5 = class81.intStack[WorldComparator.intStackSize + 1];
                  class320[] var14 = Ignore.method5386();
                  var16 = 0;

                  class320 var12;
                  while(true) {
                     if(var16 >= var14.length) {
                        var12 = null;
                        break;
                     }

                     class320 var8 = var14[var16];
                     if(var5 == var8.field3932) {
                        var12 = var8;
                        break;
                     }

                     ++var16;
                  }

                  class46.field579 = var12;
                  if(class46.field579 == null) {
                     class46.field579 = class320.field3933;
                  }

                  Client.field1084 = class81.intStack[WorldComparator.intStackSize + 2];
                  var35 = WorldMapRectangle.method280(ClientPacket.field2386, Client.field957.field1484);
                  var35.packetBuffer.putByte(Client.publicChatMode);
                  var35.packetBuffer.putByte(class46.field579.field3932);
                  var35.packetBuffer.putByte(Client.field1084);
                  Client.field957.method2052(var35);
                  var3 = 1;
               } else if(var0 == 5002) {
                  var31 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                  WorldComparator.intStackSize -= 2;
                  var5 = class81.intStack[WorldComparator.intStackSize];
                  var6 = class81.intStack[WorldComparator.intStackSize + 1];
                  PacketNode var7 = WorldMapRectangle.method280(ClientPacket.field2459, Client.field957.field1484);
                  var7.packetBuffer.putByte(WorldMapRegion.getLength(var31) + 2);
                  var7.packetBuffer.putString(var31);
                  var7.packetBuffer.putByte(var5 - 1);
                  var7.packetBuffer.putByte(var6);
                  Client.field957.method2052(var7);
                  var3 = 1;
               } else if(var0 == 5003) {
                  WorldComparator.intStackSize -= 2;
                  var4 = class81.intStack[WorldComparator.intStackSize];
                  var5 = class81.intStack[WorldComparator.intStackSize + 1];
                  ChatLineBuffer var19 = (ChatLineBuffer)class95.chatLineMap.get(Integer.valueOf(var4));
                  MessageNode var36 = var19.getMessage(var5);
                  if(var36 != null) {
                     class81.intStack[++WorldComparator.intStackSize - 1] = var36.id;
                     class81.intStack[++WorldComparator.intStackSize - 1] = var36.tick;
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var36.name != null?var36.name:"";
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var36.sender != null?var36.sender:"";
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var36.value != null?var36.value:"";
                     class81.intStack[++WorldComparator.intStackSize - 1] = var36.method1149()?1:(var36.method1152()?2:0);
                  } else {
                     class81.intStack[++WorldComparator.intStackSize - 1] = -1;
                     class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                     class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                  }

                  var3 = 1;
               } else if(var0 == 5004) {
                  var4 = class81.intStack[--WorldComparator.intStackSize];
                  MessageNode var13 = (MessageNode)class95.messages.get((long)var4);
                  if(var13 != null) {
                     class81.intStack[++WorldComparator.intStackSize - 1] = var13.type;
                     class81.intStack[++WorldComparator.intStackSize - 1] = var13.tick;
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var13.name != null?var13.name:"";
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var13.sender != null?var13.sender:"";
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var13.value != null?var13.value:"";
                     class81.intStack[++WorldComparator.intStackSize - 1] = var13.method1149()?1:(var13.method1152()?2:0);
                  } else {
                     class81.intStack[++WorldComparator.intStackSize - 1] = -1;
                     class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
                     class81.intStack[++WorldComparator.intStackSize - 1] = 0;
                  }

                  var3 = 1;
               } else if(var0 == 5005) {
                  if(class46.field579 == null) {
                     class81.intStack[++WorldComparator.intStackSize - 1] = -1;
                  } else {
                     class81.intStack[++WorldComparator.intStackSize - 1] = class46.field579.field3932;
                  }

                  var3 = 1;
               } else if(var0 == 5008) {
                  var31 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                  var5 = class81.intStack[--WorldComparator.intStackSize];
                  String var38 = var31.toLowerCase();
                  byte var43 = 0;
                  if(var38.startsWith("yellow:")) {
                     var43 = 0;
                     var31 = var31.substring("yellow:".length());
                  } else if(var38.startsWith("red:")) {
                     var43 = 1;
                     var31 = var31.substring("red:".length());
                  } else if(var38.startsWith("green:")) {
                     var43 = 2;
                     var31 = var31.substring("green:".length());
                  } else if(var38.startsWith("cyan:")) {
                     var43 = 3;
                     var31 = var31.substring("cyan:".length());
                  } else if(var38.startsWith("purple:")) {
                     var43 = 4;
                     var31 = var31.substring("purple:".length());
                  } else if(var38.startsWith("white:")) {
                     var43 = 5;
                     var31 = var31.substring("white:".length());
                  } else if(var38.startsWith("flash1:")) {
                     var43 = 6;
                     var31 = var31.substring("flash1:".length());
                  } else if(var38.startsWith("flash2:")) {
                     var43 = 7;
                     var31 = var31.substring("flash2:".length());
                  } else if(var38.startsWith("flash3:")) {
                     var43 = 8;
                     var31 = var31.substring("flash3:".length());
                  } else if(var38.startsWith("glow1:")) {
                     var43 = 9;
                     var31 = var31.substring("glow1:".length());
                  } else if(var38.startsWith("glow2:")) {
                     var43 = 10;
                     var31 = var31.substring("glow2:".length());
                  } else if(var38.startsWith("glow3:")) {
                     var43 = 11;
                     var31 = var31.substring("glow3:".length());
                  } else if(Client.languageId != 0) {
                     if(var38.startsWith("yellow:")) {
                        var43 = 0;
                        var31 = var31.substring("yellow:".length());
                     } else if(var38.startsWith("red:")) {
                        var43 = 1;
                        var31 = var31.substring("red:".length());
                     } else if(var38.startsWith("green:")) {
                        var43 = 2;
                        var31 = var31.substring("green:".length());
                     } else if(var38.startsWith("cyan:")) {
                        var43 = 3;
                        var31 = var31.substring("cyan:".length());
                     } else if(var38.startsWith("purple:")) {
                        var43 = 4;
                        var31 = var31.substring("purple:".length());
                     } else if(var38.startsWith("white:")) {
                        var43 = 5;
                        var31 = var31.substring("white:".length());
                     } else if(var38.startsWith("flash1:")) {
                        var43 = 6;
                        var31 = var31.substring("flash1:".length());
                     } else if(var38.startsWith("flash2:")) {
                        var43 = 7;
                        var31 = var31.substring("flash2:".length());
                     } else if(var38.startsWith("flash3:")) {
                        var43 = 8;
                        var31 = var31.substring("flash3:".length());
                     } else if(var38.startsWith("glow1:")) {
                        var43 = 9;
                        var31 = var31.substring("glow1:".length());
                     } else if(var38.startsWith("glow2:")) {
                        var43 = 10;
                        var31 = var31.substring("glow2:".length());
                     } else if(var38.startsWith("glow3:")) {
                        var43 = 11;
                        var31 = var31.substring("glow3:".length());
                     }
                  }

                  var38 = var31.toLowerCase();
                  byte var15 = 0;
                  if(var38.startsWith("wave:")) {
                     var15 = 1;
                     var31 = var31.substring("wave:".length());
                  } else if(var38.startsWith("wave2:")) {
                     var15 = 2;
                     var31 = var31.substring("wave2:".length());
                  } else if(var38.startsWith("shake:")) {
                     var15 = 3;
                     var31 = var31.substring("shake:".length());
                  } else if(var38.startsWith("scroll:")) {
                     var15 = 4;
                     var31 = var31.substring("scroll:".length());
                  } else if(var38.startsWith("slide:")) {
                     var15 = 5;
                     var31 = var31.substring("slide:".length());
                  } else if(Client.languageId != 0) {
                     if(var38.startsWith("wave:")) {
                        var15 = 1;
                        var31 = var31.substring("wave:".length());
                     } else if(var38.startsWith("wave2:")) {
                        var15 = 2;
                        var31 = var31.substring("wave2:".length());
                     } else if(var38.startsWith("shake:")) {
                        var15 = 3;
                        var31 = var31.substring("shake:".length());
                     } else if(var38.startsWith("scroll:")) {
                        var15 = 4;
                        var31 = var31.substring("scroll:".length());
                     } else if(var38.startsWith("slide:")) {
                        var15 = 5;
                        var31 = var31.substring("slide:".length());
                     }
                  }

                  PacketNode var17 = WorldMapRectangle.method280(ClientPacket.field2413, Client.field957.field1484);
                  var17.packetBuffer.putByte(0);
                  var10 = var17.packetBuffer.offset;
                  var17.packetBuffer.putByte(var5);
                  var17.packetBuffer.putByte(var43);
                  var17.packetBuffer.putByte(var15);
                  Nameable.method5280(var17.packetBuffer, var31);
                  var17.packetBuffer.method3514(var17.packetBuffer.offset - var10);
                  Client.field957.method2052(var17);
                  var3 = 1;
               } else if(var0 == 5009) {
                  KeyFocusListener.scriptStringStackSize -= 2;
                  var31 = class81.scriptStringStack[KeyFocusListener.scriptStringStackSize];
                  String var32 = class81.scriptStringStack[KeyFocusListener.scriptStringStackSize + 1];
                  var35 = WorldMapRectangle.method280(ClientPacket.field2390, Client.field957.field1484);
                  var35.packetBuffer.putShort(0);
                  var16 = var35.packetBuffer.offset;
                  var35.packetBuffer.putString(var31);
                  Nameable.method5280(var35.packetBuffer, var32);
                  var35.packetBuffer.method3513(var35.packetBuffer.offset - var16);
                  Client.field957.method2052(var35);
                  var3 = 1;
               } else if(var0 == 5015) {
                  if(SoundTaskDataProvider.localPlayer != null && SoundTaskDataProvider.localPlayer.name != null) {
                     var31 = SoundTaskDataProvider.localPlayer.name.getName();
                  } else {
                     var31 = "";
                  }

                  class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var31;
                  var3 = 1;
               } else if(var0 == 5016) {
                  class81.intStack[++WorldComparator.intStackSize - 1] = Client.field1084;
                  var3 = 1;
               } else if(var0 == 5017) {
                  var4 = class81.intStack[--WorldComparator.intStackSize];
                  class81.intStack[++WorldComparator.intStackSize - 1] = ScriptVarType.method10(var4);
                  var3 = 1;
               } else {
                  MessageNode var21;
                  if(var0 == 5018) {
                     var4 = class81.intStack[--WorldComparator.intStackSize];
                     var33 = class81.intStack;
                     var6 = ++WorldComparator.intStackSize - 1;
                     var21 = (MessageNode)class95.messages.get((long)var4);
                     if(var21 == null) {
                        var16 = -1;
                     } else if(var21.previous == class95.field1453.sentinel) {
                        var16 = -1;
                     } else {
                        var16 = ((MessageNode)var21.previous).id;
                     }

                     var33[var6] = var16;
                     var3 = 1;
                  } else if(var0 == 5019) {
                     var4 = class81.intStack[--WorldComparator.intStackSize];
                     var33 = class81.intStack;
                     var6 = ++WorldComparator.intStackSize - 1;
                     var21 = (MessageNode)class95.messages.get((long)var4);
                     if(var21 == null) {
                        var16 = -1;
                     } else if(var21.next == class95.field1453.sentinel) {
                        var16 = -1;
                     } else {
                        var16 = ((MessageNode)var21.next).id;
                     }

                     var33[var6] = var16;
                     var3 = 1;
                  } else if(var0 == 5020) {
                     var31 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
                     Player.method1231(var31);
                     var3 = 1;
                  } else if(var0 == 5021) {
                     Client.field1085 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize].toLowerCase().trim();
                     var3 = 1;
                  } else if(var0 == 5022) {
                     class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = Client.field1085;
                     var3 = 1;
                  } else {
                     var3 = 2;
                  }
               }

               return var3;
            }
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1728668739"
   )
   static void method541() {
      class332.indexedSpriteOffsetXs = null;
      FileSystem.indexedSpriteOffsetYs = null;
      WorldMapDecoration.indexSpriteWidths = null;
      class332.indexedSpriteHeights = null;
      class332.indexedSpritePalette = null;
      class332.spritePixels = null;
   }

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "535227014"
   )
   static boolean method540() {
      return (Client.playerNameMask & 8) != 0;
   }
}

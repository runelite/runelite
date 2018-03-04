import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
@Implements("GrandExchangeEvent")
public class GrandExchangeEvent {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1306282245
   )
   @Export("world")
   public final int world;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = 5790042201690313503L
   )
   public final long field289;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   @Export("grandExchangeOffer")
   public final GrandExchangeOffer grandExchangeOffer;
   @ObfuscatedName("r")
   @Export("string1")
   String string1;
   @ObfuscatedName("e")
   @Export("string2")
   String string2;

   @ObfuscatedSignature(
      signature = "(Lgy;BI)V"
   )
   GrandExchangeEvent(Buffer var1, byte var2, int var3) {
      this.string1 = var1.readString();
      this.string2 = var1.readString();
      this.world = var1.readUnsignedShort();
      this.field289 = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.grandExchangeOffer = new GrandExchangeOffer();
      this.grandExchangeOffer.method116(2);
      this.grandExchangeOffer.method104(var2);
      this.grandExchangeOffer.price = var4;
      this.grandExchangeOffer.totalQuantity = var5;
      this.grandExchangeOffer.quantitySold = 0;
      this.grandExchangeOffer.spent = 0;
      this.grandExchangeOffer.itemId = var3;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "8"
   )
   public String method85() {
      return this.string1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-829775646"
   )
   public String method84() {
      return this.string2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-581753514"
   )
   static final void method91(String var0) {
      PacketNode var1 = class31.method285(ClientPacket.field2380, Client.field899.field1470);
      var1.packetBuffer.putByte(class29.getLength(var0));
      var1.packetBuffer.putString(var0);
      Client.field899.method2082(var1);
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(Liw;III)V",
      garbageValue = "-493167164"
   )
   static final void method89(Widget var0, int var1, int var2) {
      if(var0.field2887 == 1) {
         TextureProvider.addMenuEntry(var0.tooltip, "", 24, 0, 0, var0.id);
      }

      String var3;
      if(var0.field2887 == 2 && !Client.spellSelected) {
         var3 = class170.method3340(var0);
         if(var3 != null) {
            TextureProvider.addMenuEntry(var3, IndexFile.getColTags(65280) + var0.spellName, 25, 0, -1, var0.id);
         }
      }

      if(var0.field2887 == 3) {
         TextureProvider.addMenuEntry("Close", "", 26, 0, 0, var0.id);
      }

      if(var0.field2887 == 4) {
         TextureProvider.addMenuEntry(var0.tooltip, "", 28, 0, 0, var0.id);
      }

      if(var0.field2887 == 5) {
         TextureProvider.addMenuEntry(var0.tooltip, "", 29, 0, 0, var0.id);
      }

      if(var0.field2887 == 6 && Client.field1014 == null) {
         TextureProvider.addMenuEntry(var0.tooltip, "", 30, 0, -1, var0.id);
      }

      int var4;
      int var6;
      int var7;
      int var15;
      if(var0.type == 2) {
         var15 = 0;

         for(var4 = 0; var4 < var0.height; ++var4) {
            for(int var5 = 0; var5 < var0.width; ++var5) {
               var6 = (var0.paddingX + 32) * var5;
               var7 = (var0.paddingY + 32) * var4;
               if(var15 < 20) {
                  var6 += var0.xSprites[var15];
                  var7 += var0.field2894[var15];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < var6 + 32 && var2 < var7 + 32) {
                  Client.field918 = var15;
                  class149.field2114 = var0;
                  if(var0.itemIds[var15] > 0) {
                     ItemComposition var8 = class251.getItemDefinition(var0.itemIds[var15] - 1);
                     if(Client.itemSelectionState == 1 && CombatInfoListHolder.method1849(class85.getWidgetConfig(var0))) {
                        if(var0.id != class71.field820 || var15 != MapIcon.selectedItemIndex) {
                           TextureProvider.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + IndexFile.getColTags(16748608) + var8.name, 31, var8.id, var15, var0.id);
                        }
                     } else if(Client.spellSelected && CombatInfoListHolder.method1849(class85.getWidgetConfig(var0))) {
                        if((class243.field2960 & 16) == 16) {
                           TextureProvider.addMenuEntry(Client.field1097, Client.field941 + " " + "->" + " " + IndexFile.getColTags(16748608) + var8.name, 32, var8.id, var15, var0.id);
                        }
                     } else {
                        String[] var9 = var8.inventoryActions;
                        int var10 = -1;
                        if(Client.field996 && Player.method1142()) {
                           var10 = var8.method5222();
                        }

                        if(CombatInfoListHolder.method1849(class85.getWidgetConfig(var0))) {
                           for(int var11 = 4; var11 >= 3; --var11) {
                              if(var10 != var11) {
                                 Size.method175(var0, var8, var15, var11, false);
                              }
                           }
                        }

                        int var12 = class85.getWidgetConfig(var0);
                        boolean var21 = (var12 >> 31 & 1) != 0;
                        if(var21) {
                           TextureProvider.addMenuEntry("Use", IndexFile.getColTags(16748608) + var8.name, 38, var8.id, var15, var0.id);
                        }

                        Object var10000 = null;
                        int var13;
                        if(CombatInfoListHolder.method1849(class85.getWidgetConfig(var0))) {
                           for(var13 = 2; var13 >= 0; --var13) {
                              if(var10 != var13) {
                                 Size.method175(var0, var8, var15, var13, false);
                              }
                           }

                           if(var10 >= 0) {
                              Size.method175(var0, var8, var15, var10, true);
                           }
                        }

                        var9 = var0.configActions;
                        if(var9 != null) {
                           for(var13 = 4; var13 >= 0; --var13) {
                              if(var9[var13] != null) {
                                 byte var14 = 0;
                                 if(var13 == 0) {
                                    var14 = 39;
                                 }

                                 if(var13 == 1) {
                                    var14 = 40;
                                 }

                                 if(var13 == 2) {
                                    var14 = 41;
                                 }

                                 if(var13 == 3) {
                                    var14 = 42;
                                 }

                                 if(var13 == 4) {
                                    var14 = 43;
                                 }

                                 TextureProvider.addMenuEntry(var9[var13], IndexFile.getColTags(16748608) + var8.name, var14, var8.id, var15, var0.id);
                              }
                           }
                        }

                        TextureProvider.addMenuEntry("Examine", IndexFile.getColTags(16748608) + var8.name, 1005, var8.id, var15, var0.id);
                     }
                  }
               }

               ++var15;
            }
         }
      }

      if(var0.hasScript) {
         if(Client.spellSelected) {
            if(BoundingBox3D.method60(class85.getWidgetConfig(var0)) && (class243.field2960 & 32) == 32) {
               TextureProvider.addMenuEntry(Client.field1097, Client.field941 + " " + "->" + " " + var0.name, 58, 0, var0.index, var0.id);
            }
         } else {
            for(var15 = 9; var15 >= 5; --var15) {
               var6 = class85.getWidgetConfig(var0);
               boolean var19 = (var6 >> var15 + 1 & 1) != 0;
               String var16;
               if(!var19 && var0.field2925 == null) {
                  var16 = null;
               } else if(var0.actions != null && var0.actions.length > var15 && var0.actions[var15] != null && var0.actions[var15].trim().length() != 0) {
                  var16 = var0.actions[var15];
               } else {
                  var16 = null;
               }

               if(var16 != null) {
                  TextureProvider.addMenuEntry(var16, var0.name, 1007, var15 + 1, var0.index, var0.id);
               }
            }

            var3 = class170.method3340(var0);
            if(var3 != null) {
               TextureProvider.addMenuEntry(var3, var0.name, 25, 0, var0.index, var0.id);
            }

            for(var4 = 4; var4 >= 0; --var4) {
               var7 = class85.getWidgetConfig(var0);
               boolean var20 = (var7 >> var4 + 1 & 1) != 0;
               String var17;
               if(!var20 && var0.field2925 == null) {
                  var17 = null;
               } else if(var0.actions != null && var0.actions.length > var4 && var0.actions[var4] != null && var0.actions[var4].trim().length() != 0) {
                  var17 = var0.actions[var4];
               } else {
                  var17 = null;
               }

               if(var17 != null) {
                  TextureProvider.addMenuEntry(var17, var0.name, 57, var4 + 1, var0.index, var0.id);
               }
            }

            if(BoundingBox2D.method45(class85.getWidgetConfig(var0))) {
               TextureProvider.addMenuEntry("Continue", "", 30, 0, var0.index, var0.id);
            }
         }
      }

   }

   @ObfuscatedName("jo")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-206163183"
   )
   static final void method86(String var0) {
      if(WidgetNode.clanMemberManager != null) {
         PacketNode var1 = class31.method285(ClientPacket.field2389, Client.field899.field1470);
         var1.packetBuffer.putByte(class29.getLength(var0));
         var1.packetBuffer.putString(var0);
         Client.field899.method2082(var1);
      }
   }
}

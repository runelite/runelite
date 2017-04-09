import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1669115529
   )
   @Export("quantity")
   int quantity;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -789244747
   )
   @Export("id")
   int id;
   @ObfuscatedName("h")
   static class63 field907;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "1"
   )
   protected final Model getModel() {
      return class196.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "(LWidgetNode;ZI)V",
      garbageValue = "1152177582"
   )
   static final void method828(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1) {
         ISAACCipher.method3132(var2);
      }

      for(class133 var4 = (class133)Client.widgetFlags.method2420(); var4 != null; var4 = (class133)Client.widgetFlags.method2422()) {
         if((var4.hash >> 48 & 65535L) == (long)var2) {
            var4.unlink();
         }
      }

      Widget var5 = FaceNormal.method1932(var3);
      if(var5 != null) {
         class22.method197(var5);
      }

      class22.method202();
      if(Client.widgetRoot != -1) {
         class33.method718(Client.widgetRoot, 1);
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BIII)Z",
      garbageValue = "-1844826566"
   )
   static final boolean method831(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      Buffer var4 = new Buffer(var0);
      int var5 = -1;

      label56:
      while(true) {
         int var6 = var4.method2880();
         if(var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var13;
            while(!var8) {
               var13 = var4.method2880();
               if(var13 == 0) {
                  continue label56;
               }

               var7 += var13 - 1;
               int var14 = var7 & 63;
               int var15 = var7 >> 6 & 63;
               int var9 = var4.readUnsignedByte() >> 2;
               int var11 = var15 + var1;
               int var12 = var2 + var14;
               if(var11 > 0 && var12 > 0 && var11 < 103 && var12 < 103) {
                  ObjectComposition var10 = class140.getObjectDefinition(var5);
                  if(var9 != 22 || !Client.field306 || var10.field2916 != 0 || var10.field2914 == 1 || var10.field2945) {
                     if(!var10.method3642()) {
                        ++Client.field359;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var13 = var4.method2880();
            if(var13 == 0) {
               break;
            }

            var4.readUnsignedByte();
         }
      }
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "454040044"
   )
   @Export("menuAction")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      Player var8;
      if(var2 == 50) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field557 = var6;
            Client.field410 = var7;
            Client.field412 = 2;
            Client.field312 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretCipherBuffer1.putOpcode(45);
            Client.secretCipherBuffer1.method2973(var3);
            Client.secretCipherBuffer1.method2892(class105.field1734[82]?1:0);
         }
      }

      NPC var9;
      if(var2 == 9) {
         var9 = Client.cachedNPCs[var3];
         if(var9 != null) {
            Client.field557 = var6;
            Client.field410 = var7;
            Client.field412 = 2;
            Client.field312 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretCipherBuffer1.putOpcode(203);
            Client.secretCipherBuffer1.method2973(var3);
            Client.secretCipherBuffer1.method2891(class105.field1734[82]?1:0);
         }
      }

      if(var2 == 23) {
         if(Client.isMenuOpen) {
            CombatInfo1.region.method1806();
         } else {
            CombatInfo1.region.method1773(Sequence.plane, var0, var1, true);
         }
      }

      if(var2 == 12) {
         var9 = Client.cachedNPCs[var3];
         if(var9 != null) {
            Client.field557 = var6;
            Client.field410 = var7;
            Client.field412 = 2;
            Client.field312 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretCipherBuffer1.putOpcode(94);
            Client.secretCipherBuffer1.method2895(var3);
            Client.secretCipherBuffer1.putByte(class105.field1734[82]?1:0);
         }
      }

      if(var2 == 22) {
         Client.field557 = var6;
         Client.field410 = var7;
         Client.field412 = 2;
         Client.field312 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.secretCipherBuffer1.putOpcode(235);
         Client.secretCipherBuffer1.method2895(var0 + class119.baseX);
         Client.secretCipherBuffer1.method2895(var3);
         Client.secretCipherBuffer1.method2892(class105.field1734[82]?1:0);
         Client.secretCipherBuffer1.putShort(class187.baseY + var1);
      }

      if(var2 == 49) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field557 = var6;
            Client.field410 = var7;
            Client.field412 = 2;
            Client.field312 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretCipherBuffer1.putOpcode(172);
            Client.secretCipherBuffer1.method2895(var3);
            Client.secretCipherBuffer1.putByte(class105.field1734[82]?1:0);
         }
      }

      int var10;
      Widget var11;
      if(var2 == 28) {
         Client.secretCipherBuffer1.putOpcode(143);
         Client.secretCipherBuffer1.putInt(var1);
         var11 = FaceNormal.method1932(var1);
         if(var11.dynamicValues != null && var11.dynamicValues[0][0] == 5) {
            var10 = var11.dynamicValues[0][1];
            class165.widgetSettings[var10] = 1 - class165.widgetSettings[var10];
            Client.method550(var10);
         }
      }

      if(var2 == 1003) {
         Client.field557 = var6;
         Client.field410 = var7;
         Client.field412 = 2;
         Client.field312 = 0;
         var9 = Client.cachedNPCs[var3];
         if(var9 != null) {
            NPCComposition var12 = var9.composition;
            if(var12.configs != null) {
               var12 = var12.method3741();
            }

            if(var12 != null) {
               Client.secretCipherBuffer1.putOpcode(125);
               Client.secretCipherBuffer1.method2900(var12.id);
            }
         }
      }

      if(var2 == 35) {
         Client.secretCipherBuffer1.putOpcode(187);
         Client.secretCipherBuffer1.method2950(var1);
         Client.secretCipherBuffer1.method2900(var0);
         Client.secretCipherBuffer1.method2900(var3);
         Client.field351 = 0;
         XGrandExchangeOffer.field42 = FaceNormal.method1932(var1);
         Client.field452 = var0;
      }

      if(var2 == 29) {
         Client.secretCipherBuffer1.putOpcode(143);
         Client.secretCipherBuffer1.putInt(var1);
         var11 = FaceNormal.method1932(var1);
         if(var11.dynamicValues != null && var11.dynamicValues[0][0] == 5) {
            var10 = var11.dynamicValues[0][1];
            if(var11.field2333[0] != class165.widgetSettings[var10]) {
               class165.widgetSettings[var10] = var11.field2333[0];
               Client.method550(var10);
            }
         }
      }

      if(var2 == 2) {
         Client.field557 = var6;
         Client.field410 = var7;
         Client.field412 = 2;
         Client.field312 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.secretCipherBuffer1.putOpcode(230);
         Client.secretCipherBuffer1.method2900(class119.baseX + var0);
         Client.secretCipherBuffer1.method2900(Client.field414);
         Client.secretCipherBuffer1.method2895(var1 + class187.baseY);
         Client.secretCipherBuffer1.putInt(XClanMember.field284);
         Client.secretCipherBuffer1.putShort(var3 >> 14 & 32767);
         Client.secretCipherBuffer1.putByte(class105.field1734[82]?1:0);
      }

      if(var2 == 37) {
         Client.secretCipherBuffer1.putOpcode(245);
         Client.secretCipherBuffer1.method2895(var0);
         Client.secretCipherBuffer1.method2973(var3);
         Client.secretCipherBuffer1.method2950(var1);
         Client.field351 = 0;
         XGrandExchangeOffer.field42 = FaceNormal.method1932(var1);
         Client.field452 = var0;
      }

      if(var2 == 36) {
         Client.secretCipherBuffer1.putOpcode(109);
         Client.secretCipherBuffer1.method2973(var0);
         Client.secretCipherBuffer1.putInt(var1);
         Client.secretCipherBuffer1.method2973(var3);
         Client.field351 = 0;
         XGrandExchangeOffer.field42 = FaceNormal.method1932(var1);
         Client.field452 = var0;
      }

      if(var2 == 40) {
         Client.secretCipherBuffer1.putOpcode(76);
         Client.secretCipherBuffer1.method2900(var0);
         Client.secretCipherBuffer1.putShort(var3);
         Client.secretCipherBuffer1.method2909(var1);
         Client.field351 = 0;
         XGrandExchangeOffer.field42 = FaceNormal.method1932(var1);
         Client.field452 = var0;
      }

      if(var2 == 58) {
         var11 = class118.method2354(var1, var0);
         if(var11 != null) {
            Client.secretCipherBuffer1.putOpcode(171);
            Client.secretCipherBuffer1.method2908(var1);
            Client.secretCipherBuffer1.putShort(var11.item);
            Client.secretCipherBuffer1.method2973(var0);
            Client.secretCipherBuffer1.putInt(XClanMember.field284);
            Client.secretCipherBuffer1.putShort(Client.field460);
            Client.secretCipherBuffer1.method2900(Client.field414);
         }
      }

      if(var2 == 18) {
         Client.field557 = var6;
         Client.field410 = var7;
         Client.field412 = 2;
         Client.field312 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.secretCipherBuffer1.putOpcode(93);
         Client.secretCipherBuffer1.method2895(class119.baseX + var0);
         Client.secretCipherBuffer1.method2973(var1 + class187.baseY);
         Client.secretCipherBuffer1.method2973(var3);
         Client.secretCipherBuffer1.method2893(class105.field1734[82]?1:0);
      }

      if(var2 == 3) {
         Client.field557 = var6;
         Client.field410 = var7;
         Client.field412 = 2;
         Client.field312 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.secretCipherBuffer1.putOpcode(185);
         Client.secretCipherBuffer1.putShort(var3 >> 14 & 32767);
         Client.secretCipherBuffer1.method2973(var0 + class119.baseX);
         Client.secretCipherBuffer1.method2973(var1 + class187.baseY);
         Client.secretCipherBuffer1.method2891(class105.field1734[82]?1:0);
      }

      if(var2 == 41) {
         Client.secretCipherBuffer1.putOpcode(83);
         Client.secretCipherBuffer1.method2900(var0);
         Client.secretCipherBuffer1.putInt(var1);
         Client.secretCipherBuffer1.method2895(var3);
         Client.field351 = 0;
         XGrandExchangeOffer.field42 = FaceNormal.method1932(var1);
         Client.field452 = var0;
      }

      if(var2 == 1004) {
         Client.field557 = var6;
         Client.field410 = var7;
         Client.field412 = 2;
         Client.field312 = 0;
         Client.secretCipherBuffer1.putOpcode(63);
         Client.secretCipherBuffer1.method2900(var3);
      }

      if(var2 == 20) {
         Client.field557 = var6;
         Client.field410 = var7;
         Client.field412 = 2;
         Client.field312 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.secretCipherBuffer1.putOpcode(211);
         Client.secretCipherBuffer1.method2973(class187.baseY + var1);
         Client.secretCipherBuffer1.method2895(class119.baseX + var0);
         Client.secretCipherBuffer1.method2893(class105.field1734[82]?1:0);
         Client.secretCipherBuffer1.method2973(var3);
      }

      if(var2 == 4) {
         Client.field557 = var6;
         Client.field410 = var7;
         Client.field412 = 2;
         Client.field312 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.secretCipherBuffer1.putOpcode(47);
         Client.secretCipherBuffer1.method2895(var3 >> 14 & 32767);
         Client.secretCipherBuffer1.method2895(var1 + class187.baseY);
         Client.secretCipherBuffer1.method2891(class105.field1734[82]?1:0);
         Client.secretCipherBuffer1.putShort(var0 + class119.baseX);
      }

      if(var2 == 25) {
         var11 = class118.method2354(var1, var0);
         if(var11 != null) {
            class6.method77();
            int var18 = FloorUnderlayDefinition.method3533(var11);
            var10 = var18 >> 11 & 63;
            int var13 = var11.item;
            Widget var14 = class118.method2354(var1, var0);
            if(var14 != null && var14.field2350 != null) {
               class18 var15 = new class18();
               var15.field207 = var14;
               var15.field199 = var14.field2350;
               class26.method565(var15);
            }

            Client.field460 = var13;
            Client.field458 = true;
            XClanMember.field284 = var1;
            Client.field414 = var0;
            ItemComposition.field3004 = var10;
            class22.method197(var14);
            Client.field455 = 0;
            int var23 = FloorUnderlayDefinition.method3533(var11);
            int var16 = var23 >> 11 & 63;
            String var17;
            if(var16 == 0) {
               var17 = null;
            } else if(var11.field2328 != null && var11.field2328.trim().length() != 0) {
               var17 = var11.field2328;
            } else {
               var17 = null;
            }

            Client.field326 = var17;
            if(Client.field326 == null) {
               Client.field326 = "Null";
            }

            if(var11.hasScript) {
               Client.field527 = var11.name + XItemContainer.method153(16777215);
            } else {
               Client.field527 = XItemContainer.method153('\uff00') + var11.field2335 + XItemContainer.method153(16777215);
            }
         }
      } else {
         if(var2 == 1001) {
            Client.field557 = var6;
            Client.field410 = var7;
            Client.field412 = 2;
            Client.field312 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretCipherBuffer1.putOpcode(67);
            Client.secretCipherBuffer1.method2892(class105.field1734[82]?1:0);
            Client.secretCipherBuffer1.method2900(var3 >> 14 & 32767);
            Client.secretCipherBuffer1.method2900(var0 + class119.baseX);
            Client.secretCipherBuffer1.putShort(var1 + class187.baseY);
         }

         if(var2 == 51) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field557 = var6;
               Client.field410 = var7;
               Client.field412 = 2;
               Client.field312 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretCipherBuffer1.putOpcode(150);
               Client.secretCipherBuffer1.method2895(var3);
               Client.secretCipherBuffer1.method2893(class105.field1734[82]?1:0);
            }
         }

         if(var2 == 57 || var2 == 1007) {
            var11 = class118.method2354(var1, var0);
            if(var11 != null) {
               var10 = var11.item;
               Widget var19 = class118.method2354(var1, var0);
               if(var19 != null) {
                  if(var19.field2319 != null) {
                     class18 var20 = new class18();
                     var20.field207 = var19;
                     var20.field202 = var3;
                     var20.field200 = var5;
                     var20.field199 = var19.field2319;
                     class26.method565(var20);
                  }

                  boolean var21 = true;
                  if(var19.contentType > 0) {
                     var21 = GroundObject.method1568(var19);
                  }

                  if(var21 && class152.method2849(FloorUnderlayDefinition.method3533(var19), var3 - 1)) {
                     if(var3 == 1) {
                        Client.secretCipherBuffer1.putOpcode(74);
                        Client.secretCipherBuffer1.putInt(var1);
                        Client.secretCipherBuffer1.putShort(var0);
                        Client.secretCipherBuffer1.putShort(var10);
                     }

                     if(var3 == 2) {
                        Client.secretCipherBuffer1.putOpcode(155);
                        Client.secretCipherBuffer1.putInt(var1);
                        Client.secretCipherBuffer1.putShort(var0);
                        Client.secretCipherBuffer1.putShort(var10);
                     }

                     if(var3 == 3) {
                        Client.secretCipherBuffer1.putOpcode(70);
                        Client.secretCipherBuffer1.putInt(var1);
                        Client.secretCipherBuffer1.putShort(var0);
                        Client.secretCipherBuffer1.putShort(var10);
                     }

                     if(var3 == 4) {
                        Client.secretCipherBuffer1.putOpcode(190);
                        Client.secretCipherBuffer1.putInt(var1);
                        Client.secretCipherBuffer1.putShort(var0);
                        Client.secretCipherBuffer1.putShort(var10);
                     }

                     if(var3 == 5) {
                        Client.secretCipherBuffer1.putOpcode(179);
                        Client.secretCipherBuffer1.putInt(var1);
                        Client.secretCipherBuffer1.putShort(var0);
                        Client.secretCipherBuffer1.putShort(var10);
                     }

                     if(var3 == 6) {
                        Client.secretCipherBuffer1.putOpcode(219);
                        Client.secretCipherBuffer1.putInt(var1);
                        Client.secretCipherBuffer1.putShort(var0);
                        Client.secretCipherBuffer1.putShort(var10);
                     }

                     if(var3 == 7) {
                        Client.secretCipherBuffer1.putOpcode(142);
                        Client.secretCipherBuffer1.putInt(var1);
                        Client.secretCipherBuffer1.putShort(var0);
                        Client.secretCipherBuffer1.putShort(var10);
                     }

                     if(var3 == 8) {
                        Client.secretCipherBuffer1.putOpcode(8);
                        Client.secretCipherBuffer1.putInt(var1);
                        Client.secretCipherBuffer1.putShort(var0);
                        Client.secretCipherBuffer1.putShort(var10);
                     }

                     if(var3 == 9) {
                        Client.secretCipherBuffer1.putOpcode(115);
                        Client.secretCipherBuffer1.putInt(var1);
                        Client.secretCipherBuffer1.putShort(var0);
                        Client.secretCipherBuffer1.putShort(var10);
                     }

                     if(var3 == 10) {
                        Client.secretCipherBuffer1.putOpcode(194);
                        Client.secretCipherBuffer1.putInt(var1);
                        Client.secretCipherBuffer1.putShort(var0);
                        Client.secretCipherBuffer1.putShort(var10);
                     }
                  }
               }
            }
         }

         if(var2 == 47) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field557 = var6;
               Client.field410 = var7;
               Client.field412 = 2;
               Client.field312 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretCipherBuffer1.putOpcode(135);
               Client.secretCipherBuffer1.method2895(var3);
               Client.secretCipherBuffer1.method2892(class105.field1734[82]?1:0);
            }
         }

         if(var2 == 46) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field557 = var6;
               Client.field410 = var7;
               Client.field412 = 2;
               Client.field312 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretCipherBuffer1.putOpcode(44);
               Client.secretCipherBuffer1.method2891(class105.field1734[82]?1:0);
               Client.secretCipherBuffer1.method2973(var3);
            }
         }

         if(var2 == 15) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field557 = var6;
               Client.field410 = var7;
               Client.field412 = 2;
               Client.field312 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretCipherBuffer1.putOpcode(178);
               Client.secretCipherBuffer1.method2892(class105.field1734[82]?1:0);
               Client.secretCipherBuffer1.method2909(XClanMember.field284);
               Client.secretCipherBuffer1.method2973(Client.field414);
               Client.secretCipherBuffer1.putShort(var3);
            }
         }

         if(var2 == 48) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field557 = var6;
               Client.field410 = var7;
               Client.field412 = 2;
               Client.field312 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretCipherBuffer1.putOpcode(112);
               Client.secretCipherBuffer1.method2893(class105.field1734[82]?1:0);
               Client.secretCipherBuffer1.method2900(var3);
            }
         }

         if(var2 == 1) {
            Client.field557 = var6;
            Client.field410 = var7;
            Client.field412 = 2;
            Client.field312 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretCipherBuffer1.putOpcode(68);
            Client.secretCipherBuffer1.putShort(class119.baseX + var0);
            Client.secretCipherBuffer1.method2973(var3 >> 14 & 32767);
            Client.secretCipherBuffer1.method2895(class47.field957);
            Client.secretCipherBuffer1.method2973(class187.baseY + var1);
            Client.secretCipherBuffer1.method2900(Client.field456);
            Client.secretCipherBuffer1.putByte(class105.field1734[82]?1:0);
            Client.secretCipherBuffer1.method2950(class177.field2689);
         }

         if(var2 == 7) {
            var9 = Client.cachedNPCs[var3];
            if(var9 != null) {
               Client.field557 = var6;
               Client.field410 = var7;
               Client.field412 = 2;
               Client.field312 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretCipherBuffer1.putOpcode(243);
               Client.secretCipherBuffer1.method2950(class177.field2689);
               Client.secretCipherBuffer1.method2900(Client.field456);
               Client.secretCipherBuffer1.method2973(class47.field957);
               Client.secretCipherBuffer1.method2895(var3);
               Client.secretCipherBuffer1.method2891(class105.field1734[82]?1:0);
            }
         }

         if(var2 == 16) {
            Client.field557 = var6;
            Client.field410 = var7;
            Client.field412 = 2;
            Client.field312 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretCipherBuffer1.putOpcode(234);
            Client.secretCipherBuffer1.method2900(Client.field456);
            Client.secretCipherBuffer1.method2900(class47.field957);
            Client.secretCipherBuffer1.method2895(class187.baseY + var1);
            Client.secretCipherBuffer1.method2973(var3);
            Client.secretCipherBuffer1.method2900(var0 + class119.baseX);
            Client.secretCipherBuffer1.method2891(class105.field1734[82]?1:0);
            Client.secretCipherBuffer1.method2909(class177.field2689);
         }

         if(var2 == 19) {
            Client.field557 = var6;
            Client.field410 = var7;
            Client.field412 = 2;
            Client.field312 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretCipherBuffer1.putOpcode(4);
            Client.secretCipherBuffer1.method2973(var1 + class187.baseY);
            Client.secretCipherBuffer1.putByte(class105.field1734[82]?1:0);
            Client.secretCipherBuffer1.method2895(var0 + class119.baseX);
            Client.secretCipherBuffer1.method2900(var3);
         }

         if(var2 == 42) {
            Client.secretCipherBuffer1.putOpcode(139);
            Client.secretCipherBuffer1.method2973(var0);
            Client.secretCipherBuffer1.putShort(var3);
            Client.secretCipherBuffer1.method2908(var1);
            Client.field351 = 0;
            XGrandExchangeOffer.field42 = FaceNormal.method1932(var1);
            Client.field452 = var0;
         }

         if(var2 == 34) {
            Client.secretCipherBuffer1.putOpcode(20);
            Client.secretCipherBuffer1.putShort(var3);
            Client.secretCipherBuffer1.method2909(var1);
            Client.secretCipherBuffer1.method2973(var0);
            Client.field351 = 0;
            XGrandExchangeOffer.field42 = FaceNormal.method1932(var1);
            Client.field452 = var0;
         }

         if(var2 == 17) {
            Client.field557 = var6;
            Client.field410 = var7;
            Client.field412 = 2;
            Client.field312 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretCipherBuffer1.putOpcode(71);
            Client.secretCipherBuffer1.method2895(var3);
            Client.secretCipherBuffer1.putShort(var0 + class119.baseX);
            Client.secretCipherBuffer1.method2900(var1 + class187.baseY);
            Client.secretCipherBuffer1.method2900(Client.field414);
            Client.secretCipherBuffer1.method2891(class105.field1734[82]?1:0);
            Client.secretCipherBuffer1.method2908(XClanMember.field284);
         }

         if(var2 == 43) {
            Client.secretCipherBuffer1.putOpcode(39);
            Client.secretCipherBuffer1.method2973(var0);
            Client.secretCipherBuffer1.putShort(var3);
            Client.secretCipherBuffer1.method2908(var1);
            Client.field351 = 0;
            XGrandExchangeOffer.field42 = FaceNormal.method1932(var1);
            Client.field452 = var0;
         }

         if(var2 == 13) {
            var9 = Client.cachedNPCs[var3];
            if(var9 != null) {
               Client.field557 = var6;
               Client.field410 = var7;
               Client.field412 = 2;
               Client.field312 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretCipherBuffer1.putOpcode(147);
               Client.secretCipherBuffer1.method2893(class105.field1734[82]?1:0);
               Client.secretCipherBuffer1.method2895(var3);
            }
         }

         if(var2 == 32) {
            Client.secretCipherBuffer1.putOpcode(157);
            Client.secretCipherBuffer1.method2895(var0);
            Client.secretCipherBuffer1.putShort(Client.field414);
            Client.secretCipherBuffer1.method2950(var1);
            Client.secretCipherBuffer1.method2909(XClanMember.field284);
            Client.secretCipherBuffer1.method2973(var3);
            Client.field351 = 0;
            XGrandExchangeOffer.field42 = FaceNormal.method1932(var1);
            Client.field452 = var0;
         }

         if(var2 == 31) {
            Client.secretCipherBuffer1.putOpcode(113);
            Client.secretCipherBuffer1.putInt(var1);
            Client.secretCipherBuffer1.method2909(class177.field2689);
            Client.secretCipherBuffer1.method2973(Client.field456);
            Client.secretCipherBuffer1.putShort(var3);
            Client.secretCipherBuffer1.putShort(var0);
            Client.secretCipherBuffer1.method2895(class47.field957);
            Client.field351 = 0;
            XGrandExchangeOffer.field42 = FaceNormal.method1932(var1);
            Client.field452 = var0;
         }

         if(var2 == 44) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field557 = var6;
               Client.field410 = var7;
               Client.field412 = 2;
               Client.field312 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretCipherBuffer1.putOpcode(28);
               Client.secretCipherBuffer1.putByte(class105.field1734[82]?1:0);
               Client.secretCipherBuffer1.method2895(var3);
            }
         }

         if(var2 == 6) {
            Client.field557 = var6;
            Client.field410 = var7;
            Client.field412 = 2;
            Client.field312 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretCipherBuffer1.putOpcode(174);
            Client.secretCipherBuffer1.putShort(class187.baseY + var1);
            Client.secretCipherBuffer1.method2900(var3 >> 14 & 32767);
            Client.secretCipherBuffer1.putShort(var0 + class119.baseX);
            Client.secretCipherBuffer1.method2892(class105.field1734[82]?1:0);
         }

         if(var2 == 8) {
            var9 = Client.cachedNPCs[var3];
            if(var9 != null) {
               Client.field557 = var6;
               Client.field410 = var7;
               Client.field412 = 2;
               Client.field312 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretCipherBuffer1.putOpcode(110);
               Client.secretCipherBuffer1.method2891(class105.field1734[82]?1:0);
               Client.secretCipherBuffer1.putShort(var3);
               Client.secretCipherBuffer1.putInt(XClanMember.field284);
               Client.secretCipherBuffer1.method2973(Client.field414);
            }
         }

         if(var2 == 30 && Client.field467 == null) {
            Client.secretCipherBuffer1.putOpcode(153);
            Client.secretCipherBuffer1.method2900(var0);
            Client.secretCipherBuffer1.method2908(var1);
            Client.field467 = class118.method2354(var1, var0);
            class22.method197(Client.field467);
         }

         if(var2 == 10) {
            var9 = Client.cachedNPCs[var3];
            if(var9 != null) {
               Client.field557 = var6;
               Client.field410 = var7;
               Client.field412 = 2;
               Client.field312 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretCipherBuffer1.putOpcode(56);
               Client.secretCipherBuffer1.putShort(var3);
               Client.secretCipherBuffer1.method2892(class105.field1734[82]?1:0);
            }
         }

         if(var2 == 14) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field557 = var6;
               Client.field410 = var7;
               Client.field412 = 2;
               Client.field312 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretCipherBuffer1.putOpcode(75);
               Client.secretCipherBuffer1.putShort(Client.field456);
               Client.secretCipherBuffer1.method2950(class177.field2689);
               Client.secretCipherBuffer1.method2893(class105.field1734[82]?1:0);
               Client.secretCipherBuffer1.method2895(var3);
               Client.secretCipherBuffer1.method2973(class47.field957);
            }
         }

         if(var2 == 45) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field557 = var6;
               Client.field410 = var7;
               Client.field412 = 2;
               Client.field312 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretCipherBuffer1.putOpcode(34);
               Client.secretCipherBuffer1.method2900(var3);
               Client.secretCipherBuffer1.method2891(class105.field1734[82]?1:0);
            }
         }

         if(var2 == 39) {
            Client.secretCipherBuffer1.putOpcode(146);
            Client.secretCipherBuffer1.putShort(var3);
            Client.secretCipherBuffer1.method2973(var0);
            Client.secretCipherBuffer1.method2950(var1);
            Client.field351 = 0;
            XGrandExchangeOffer.field42 = FaceNormal.method1932(var1);
            Client.field452 = var0;
         }

         if(var2 == 38) {
            class6.method77();
            var11 = FaceNormal.method1932(var1);
            Client.field455 = 1;
            class47.field957 = var0;
            class177.field2689 = var1;
            Client.field456 = var3;
            class22.method197(var11);
            Client.field457 = XItemContainer.method153(16748608) + class196.getItemDefinition(var3).name + XItemContainer.method153(16777215);
            if(Client.field457 == null) {
               Client.field457 = "null";
            }
         } else {
            if(var2 == 26) {
               class183.method3413();
            }

            if(var2 == 1002) {
               Client.field557 = var6;
               Client.field410 = var7;
               Client.field412 = 2;
               Client.field312 = 0;
               Client.secretCipherBuffer1.putOpcode(248);
               Client.secretCipherBuffer1.method2900(var3 >> 14 & 32767);
            }

            if(var2 == 1005) {
               var11 = FaceNormal.method1932(var1);
               if(var11 != null && var11.itemQuantities[var0] >= 100000) {
                  Player.sendGameMessage(27, "", var11.itemQuantities[var0] + " x " + class196.getItemDefinition(var3).name);
               } else {
                  Client.secretCipherBuffer1.putOpcode(63);
                  Client.secretCipherBuffer1.method2900(var3);
               }

               Client.field351 = 0;
               XGrandExchangeOffer.field42 = FaceNormal.method1932(var1);
               Client.field452 = var0;
            }

            if(var2 == 5) {
               Client.field557 = var6;
               Client.field410 = var7;
               Client.field412 = 2;
               Client.field312 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretCipherBuffer1.putOpcode(198);
               Client.secretCipherBuffer1.method2891(class105.field1734[82]?1:0);
               Client.secretCipherBuffer1.method2973(var3 >> 14 & 32767);
               Client.secretCipherBuffer1.method2900(var1 + class187.baseY);
               Client.secretCipherBuffer1.method2900(var0 + class119.baseX);
            }

            if(var2 == 11) {
               var9 = Client.cachedNPCs[var3];
               if(var9 != null) {
                  Client.field557 = var6;
                  Client.field410 = var7;
                  Client.field412 = 2;
                  Client.field312 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretCipherBuffer1.putOpcode(220);
                  Client.secretCipherBuffer1.putByte(class105.field1734[82]?1:0);
                  Client.secretCipherBuffer1.method2973(var3);
               }
            }

            if(var2 == 33) {
               Client.secretCipherBuffer1.putOpcode(123);
               Client.secretCipherBuffer1.putInt(var1);
               Client.secretCipherBuffer1.method2900(var0);
               Client.secretCipherBuffer1.method2973(var3);
               Client.field351 = 0;
               XGrandExchangeOffer.field42 = FaceNormal.method1932(var1);
               Client.field452 = var0;
            }

            if(var2 == 21) {
               Client.field557 = var6;
               Client.field410 = var7;
               Client.field412 = 2;
               Client.field312 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretCipherBuffer1.putOpcode(159);
               Client.secretCipherBuffer1.putShort(var1 + class187.baseY);
               Client.secretCipherBuffer1.method2895(var3);
               Client.secretCipherBuffer1.method2892(class105.field1734[82]?1:0);
               Client.secretCipherBuffer1.method2973(class119.baseX + var0);
            }

            if(var2 == 24) {
               var11 = FaceNormal.method1932(var1);
               boolean var22 = true;
               if(var11.contentType > 0) {
                  var22 = GroundObject.method1568(var11);
               }

               if(var22) {
                  Client.secretCipherBuffer1.putOpcode(143);
                  Client.secretCipherBuffer1.putInt(var1);
               }
            }

            if(Client.field455 != 0) {
               Client.field455 = 0;
               class22.method197(FaceNormal.method1932(class177.field2689));
            }

            if(Client.field458) {
               class6.method77();
            }

            if(XGrandExchangeOffer.field42 != null && Client.field351 == 0) {
               class22.method197(XGrandExchangeOffer.field42);
            }
         }
      }

   }
}

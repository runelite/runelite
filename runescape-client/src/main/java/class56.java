import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
public class class56 {
   @ObfuscatedName("a")
   static Applet field674;
   @ObfuscatedName("j")
   static String field667;
   @ObfuscatedName("dm")
   static IndexData field675;

   static {
      field674 = null;
      field667 = null;
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "99"
   )
   static final String method830(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class46.getColTags('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class46.getColTags(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class46.getColTags(16776960) + var1 + "</col>");
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;II)V",
      garbageValue = "1920903424"
   )
   @Export("decodeMovement")
   static void decodeMovement(PacketBuffer var0, int var1) {
      boolean var2 = var0.getBits(1) == 1;
      if(var2) {
         class96.field1493[++class96.field1498 - 1] = var1;
      }

      int var3 = var0.getBits(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field891 = false;
         } else if(Client.localInteractingIndex == var1) {
            throw new RuntimeException();
         } else {
            class96.field1495[var1] = (var4.field889 << 28) + (var4.pathX[0] + class163.baseX >> 13 << 14) + (var4.pathY[0] + class10.baseY >> 13);
            if(var4.field1242 != -1) {
               class96.field1496[var1] = var4.field1242;
            } else {
               class96.field1496[var1] = var4.orientation;
            }

            class96.field1497[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.getBits(1) != 0) {
               class157.decodeRegionHash(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.getBits(3);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method1116(var6, var7);
               var4.field891 = false;
            } else if(var2) {
               var4.field891 = true;
               var4.field892 = var6;
               var4.field893 = var7;
            } else {
               var4.field891 = false;
               var4.method1115(var6, var7, class96.field1487[var1]);
            }

         } else if(var3 == 2) {
            var5 = var0.getBits(4);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method1116(var6, var7);
               var4.field891 = false;
            } else if(var2) {
               var4.field891 = true;
               var4.field892 = var6;
               var4.field893 = var7;
            } else {
               var4.field891 = false;
               var4.method1115(var6, var7, class96.field1487[var1]);
            }

         } else {
            var5 = var0.getBits(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.getBits(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var8 + var4.pathX[0];
               var11 = var9 + var4.pathY[0];
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field891 = true;
                     var4.field892 = var10;
                     var4.field893 = var11;
                  } else {
                     var4.field891 = false;
                     var4.method1115(var10, var11, class96.field1487[var1]);
                  }
               } else {
                  var4.method1116(var10, var11);
                  var4.field891 = false;
               }

               var4.field889 = (byte)(var7 + var4.field889 & 3);
               if(Client.localInteractingIndex == var1) {
                  class45.plane = var4.field889;
               }

            } else {
               var6 = var0.getBits(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + var4.pathX[0] + class163.baseX & 16383) - class163.baseX;
               var11 = (var9 + var4.pathY[0] + class10.baseY & 16383) - class10.baseY;
               if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method1116(var10, var11);
                  var4.field891 = false;
               } else if(var2) {
                  var4.field891 = true;
                  var4.field892 = var10;
                  var4.field893 = var11;
               } else {
                  var4.field891 = false;
                  var4.method1115(var10, var11, class96.field1487[var1]);
               }

               var4.field889 = (byte)(var7 + var4.field889 & 3);
               if(Client.localInteractingIndex == var1) {
                  class45.plane = var4.field889;
               }

            }
         }
      }
   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "122580462"
   )
   static final void method833(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method833(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  class31.method275(var4.id, var1);
               }
            }

            ScriptEvent var5;
            if(var1 == 0 && var3.field2760 != null) {
               var5 = new ScriptEvent();
               var5.widget = var3;
               var5.field839 = var3.field2760;
               class89.method1689(var5);
            }

            if(var1 == 1 && var3.field2761 != null) {
               if(var3.index >= 0) {
                  Widget var6 = class61.method1038(var3.id);
                  if(var6 == null || var6.children == null || var3.index >= var6.children.length || var3 != var6.children[var3.index]) {
                     continue;
                  }
               }

               var5 = new ScriptEvent();
               var5.widget = var3;
               var5.field839 = var3.field2761;
               class89.method1689(var5);
            }
         }
      }

   }

   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1763978991"
   )
   static final void method829() {
      int var0 = Client.field970 + Script.localPlayer.x;
      int var1 = Client.field1050 + Script.localPlayer.y;
      if(class54.field659 - var0 < -500 || class54.field659 - var0 > 500 || class48.field605 - var1 < -500 || class48.field605 - var1 > 500) {
         class54.field659 = var0;
         class48.field605 = var1;
      }

      if(var0 != class54.field659) {
         class54.field659 += (var0 - class54.field659) / 16;
      }

      if(var1 != class48.field605) {
         class48.field605 += (var1 - class48.field605) / 16;
      }

      int var2;
      int var3;
      if(MouseInput.field721 == 4 && class33.field461) {
         var2 = MouseInput.field723 - Client.field994;
         Client.field992 = var2 * 2;
         Client.field994 = var2 != -1 && var2 != 1?(MouseInput.field723 + Client.field994) / 2:MouseInput.field723;
         var3 = Client.field1065 - MouseInput.field722;
         Client.field991 = var3 * 2;
         Client.field1065 = var3 != -1 && var3 != 1?(MouseInput.field722 + Client.field1065) / 2:MouseInput.field722;
      } else {
         if(KeyFocusListener.field626[96]) {
            Client.field991 += (-24 - Client.field991) / 2;
         } else if(KeyFocusListener.field626[97]) {
            Client.field991 += (24 - Client.field991) / 2;
         } else {
            Client.field991 /= 2;
         }

         if(KeyFocusListener.field626[98]) {
            Client.field992 += (12 - Client.field992) / 2;
         } else if(KeyFocusListener.field626[99]) {
            Client.field992 += (-12 - Client.field992) / 2;
         } else {
            Client.field992 /= 2;
         }

         Client.field994 = MouseInput.field723;
         Client.field1065 = MouseInput.field722;
      }

      Client.mapAngle = Client.field991 / 2 + Client.mapAngle & 2047;
      Client.field989 += Client.field992 / 2;
      if(Client.field989 < 128) {
         Client.field989 = 128;
      }

      if(Client.field989 > 383) {
         Client.field989 = 383;
      }

      var2 = class54.field659 >> 7;
      var3 = class48.field605 >> 7;
      int var4 = Actor.getTileHeight(class54.field659, class48.field605, class45.plane);
      int var5 = 0;
      int var6;
      if(var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
         for(var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
            for(int var7 = var3 - 4; var7 <= var3 + 4; ++var7) {
               int var8 = class45.plane;
               if(var8 < 3 && (class61.tileSettings[1][var6][var7] & 2) == 2) {
                  ++var8;
               }

               int var9 = var4 - class61.tileHeights[var8][var6][var7];
               if(var9 > var5) {
                  var5 = var9;
               }
            }
         }
      }

      var6 = var5 * 192;
      if(var6 > 98048) {
         var6 = 98048;
      }

      if(var6 < '耀') {
         var6 = '耀';
      }

      if(var6 > Client.field998) {
         Client.field998 += (var6 - Client.field998) / 24;
      } else if(var6 < Client.field998) {
         Client.field998 += (var6 - Client.field998) / 80;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "22"
   )
   static int method827(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 4200) {
         var3 = class83.intStack[--WorldMapType2.intStackSize];
         class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = class83.getItemDefinition(var3).name;
         return 1;
      } else {
         int var4;
         ItemComposition var17;
         if(var0 == 4201) {
            WorldMapType2.intStackSize -= 2;
            var3 = class83.intStack[WorldMapType2.intStackSize];
            var4 = class83.intStack[WorldMapType2.intStackSize + 1];
            var17 = class83.getItemDefinition(var3);
            if(var4 >= 1 && var4 <= 5 && var17.groundActions[var4 - 1] != null) {
               class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var17.groundActions[var4 - 1];
            } else {
               class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 4202) {
            WorldMapType2.intStackSize -= 2;
            var3 = class83.intStack[WorldMapType2.intStackSize];
            var4 = class83.intStack[WorldMapType2.intStackSize + 1];
            var17 = class83.getItemDefinition(var3);
            if(var4 >= 1 && var4 <= 5 && var17.inventoryActions[var4 - 1] != null) {
               class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var17.inventoryActions[var4 - 1];
            } else {
               class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 4203) {
            var3 = class83.intStack[--WorldMapType2.intStackSize];
            class83.intStack[++WorldMapType2.intStackSize - 1] = class83.getItemDefinition(var3).price;
            return 1;
         } else if(var0 == 4204) {
            var3 = class83.intStack[--WorldMapType2.intStackSize];
            class83.intStack[++WorldMapType2.intStackSize - 1] = class83.getItemDefinition(var3).isStackable == 1?1:0;
            return 1;
         } else {
            ItemComposition var13;
            if(var0 == 4205) {
               var3 = class83.intStack[--WorldMapType2.intStackSize];
               var13 = class83.getItemDefinition(var3);
               if(var13.notedTemplate == -1 && var13.note >= 0) {
                  class83.intStack[++WorldMapType2.intStackSize - 1] = var13.note;
               } else {
                  class83.intStack[++WorldMapType2.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4206) {
               var3 = class83.intStack[--WorldMapType2.intStackSize];
               var13 = class83.getItemDefinition(var3);
               if(var13.notedTemplate >= 0 && var13.note >= 0) {
                  class83.intStack[++WorldMapType2.intStackSize - 1] = var13.note;
               } else {
                  class83.intStack[++WorldMapType2.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4207) {
               var3 = class83.intStack[--WorldMapType2.intStackSize];
               class83.intStack[++WorldMapType2.intStackSize - 1] = class83.getItemDefinition(var3).isMembers?1:0;
               return 1;
            } else if(var0 == 4208) {
               var3 = class83.intStack[--WorldMapType2.intStackSize];
               var13 = class83.getItemDefinition(var3);
               if(var13.field3542 == -1 && var13.field3492 >= 0) {
                  class83.intStack[++WorldMapType2.intStackSize - 1] = var13.field3492;
               } else {
                  class83.intStack[++WorldMapType2.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4209) {
               var3 = class83.intStack[--WorldMapType2.intStackSize];
               var13 = class83.getItemDefinition(var3);
               if(var13.field3542 >= 0 && var13.field3492 >= 0) {
                  class83.intStack[++WorldMapType2.intStackSize - 1] = var13.field3492;
               } else {
                  class83.intStack[++WorldMapType2.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4210) {
               String var14 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
               var4 = class83.intStack[--WorldMapType2.intStackSize];
               boolean var6 = var4 == 1;
               String var5 = var14.toLowerCase();
               short[] var7 = new short[16];
               int var8 = 0;
               int var9 = 0;

               while(true) {
                  if(var9 >= ItemComposition.field3491) {
                     Client.field1181 = var7;
                     RSSocket.field2260 = 0;
                     class87.field1373 = var8;
                     String[] var15 = new String[class87.field1373];

                     for(int var16 = 0; var16 < class87.field1373; ++var16) {
                        var15[var16] = class83.getItemDefinition(var7[var16]).name;
                     }

                     short[] var18 = Client.field1181;
                     ChatLineBuffer.method1851(var15, var18, 0, var15.length - 1);
                     break;
                  }

                  ItemComposition var10 = class83.getItemDefinition(var9);
                  if((!var6 || var10.field3538) && var10.notedTemplate == -1 && var10.name.toLowerCase().indexOf(var5) != -1) {
                     if(var8 >= 250) {
                        class87.field1373 = -1;
                        Client.field1181 = null;
                        break;
                     }

                     if(var8 >= var7.length) {
                        short[] var11 = new short[var7.length * 2];

                        for(int var12 = 0; var12 < var8; ++var12) {
                           var11[var12] = var7[var12];
                        }

                        var7 = var11;
                     }

                     var7[var8++] = (short)var9;
                  }

                  ++var9;
               }

               class83.intStack[++WorldMapType2.intStackSize - 1] = class87.field1373;
               return 1;
            } else if(var0 != 4211) {
               if(var0 == 4212) {
                  RSSocket.field2260 = 0;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               if(Client.field1181 != null && RSSocket.field2260 < class87.field1373) {
                  class83.intStack[++WorldMapType2.intStackSize - 1] = Client.field1181[++RSSocket.field2260 - 1] & '\uffff';
               } else {
                  class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
               }

               return 1;
            }
         }
      }
   }
}

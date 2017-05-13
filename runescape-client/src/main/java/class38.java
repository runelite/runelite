import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class38 {
   @ObfuscatedName("t")
   String field784;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1690526801
   )
   int field785;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 916843457
   )
   int field786;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1558197437
   )
   int field787;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1939247965
   )
   int field788;

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass166;I)V",
      garbageValue = "-717999214"
   )
   static final void method765(int var0, int var1, int var2, int var3, SpritePixels var4, class166 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle + Client.mapScale & 2047;
         int var8 = class84.SINE[var7];
         int var9 = class84.COSINE[var7];
         var8 = var8 * 256 / (Client.mapScaleDelta + 256);
         var9 = var9 * 256 / (Client.mapScaleDelta + 256);
         int var10 = var8 * var3 + var2 * var9 >> 16;
         int var11 = var9 * var3 - var2 * var8 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         Client.field359.method4242(var14 + var0 + 94 + 4 - 10, var1 + 83 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class39.method772(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;II)V",
      garbageValue = "-156080913"
   )
   static final void method766(PacketBuffer var0, int var1) {
      int var2 = var0.offset;
      class45.field902 = 0;
      class126.method2358(var0);

      for(int var3 = 0; var3 < class45.field902; ++var3) {
         int var4 = class45.field899[var3];
         Player var5 = Client.cachedPlayers[var4];
         int var6 = var0.readUnsignedByte();
         if((var6 & 16) != 0) {
            var6 += var0.readUnsignedByte() << 8;
         }

         byte var7 = -1;
         int var8;
         if((var6 & 32) != 0) {
            var8 = var0.readUnsignedByte();
            byte[] var9 = new byte[var8];
            Buffer var10 = new Buffer(var9);
            var0.readBytes(var9, 0, var8);
            class45.field890[var4] = var10;
            var5.method227(var10);
         }

         int var20;
         if((var6 & 8) != 0) {
            var8 = var0.readUnsignedShort();
            if(var8 == '\uffff') {
               var8 = -1;
            }

            var20 = var0.readUnsignedByte();
            Player.method250(var5, var8, var20);
         }

         if((var6 & 4) != 0) {
            var5.interacting = var0.readUnsignedShort();
            if(var5.interacting == '\uffff') {
               var5.interacting = -1;
            }
         }

         if((var6 & 1) != 0) {
            var5.overhead = var0.readString();
            if(var5.overhead.charAt(0) == 126) {
               var5.overhead = var5.overhead.substring(1);
               WidgetNode.sendGameMessage(2, var5.name, var5.overhead);
            } else if(var5 == class22.localPlayer) {
               WidgetNode.sendGameMessage(2, var5.name, var5.overhead);
            }

            var5.field613 = false;
            var5.field616 = 0;
            var5.field617 = 0;
            var5.field615 = 150;
         }

         int var11;
         int var12;
         if((var6 & 2) != 0) {
            var8 = var0.readUnsignedByte();
            int var13;
            int var14;
            int var21;
            if(var8 > 0) {
               for(var20 = 0; var20 < var8; ++var20) {
                  var11 = -1;
                  var12 = -1;
                  var13 = -1;
                  var21 = var0.method2395();
                  if(var21 == 32767) {
                     var21 = var0.method2395();
                     var12 = var0.method2395();
                     var11 = var0.method2395();
                     var13 = var0.method2395();
                  } else if(var21 != 32766) {
                     var12 = var0.method2395();
                  } else {
                     var21 = -1;
                  }

                  var14 = var0.method2395();
                  var5.method583(var21, var12, var11, var13, Client.gameCycle, var14);
               }
            }

            var20 = var0.readUnsignedByte();
            if(var20 > 0) {
               for(var21 = 0; var21 < var20; ++var21) {
                  var11 = var0.method2395();
                  var12 = var0.method2395();
                  if(var12 != 32767) {
                     var13 = var0.method2395();
                     var14 = var0.readUnsignedByte();
                     int var15 = var12 > 0?var0.readUnsignedByte():var14;
                     var5.method580(var11, Client.gameCycle, var12, var13, var14, var15);
                  } else {
                     var5.method587(var11);
                  }
               }
            }
         }

         if((var6 & 64) != 0) {
            var5.field627 = var0.readUnsignedShort();
            if(var5.field653 == 0) {
               var5.field650 = var5.field627;
               var5.field627 = -1;
            }
         }

         if((var6 & 128) != 0) {
            var8 = var0.readUnsignedShort();
            class179 var26 = (class179)class32.method708(ItemLayer.method1475(), var0.readUnsignedByte());
            boolean var29 = var0.readUnsignedByte() == 1;
            var11 = var0.readUnsignedByte();
            var12 = var0.offset;
            if(var5.name != null && var5.composition != null) {
               boolean var28 = false;
               if(var26.field2670 && class2.method27(var5.name)) {
                  var28 = true;
               }

               if(!var28 && Client.field402 == 0 && !var5.field263) {
                  class45.field904.offset = 0;
                  var0.readBytes(class45.field904.payload, 0, var11);
                  class45.field904.offset = 0;
                  Buffer var22 = class45.field904;

                  String var16;
                  int var17;
                  try {
                     var17 = var22.method2395();
                     if(var17 > 32767) {
                        var17 = 32767;
                     }

                     byte[] var18 = new byte[var17];
                     var22.offset += class209.field3127.method2310(var22.payload, var22.offset, var18, 0, var17);
                     String var19 = class109.method2067(var18, 0, var17);
                     var16 = var19;
                  } catch (Exception var25) {
                     var16 = "Cabbage";
                  }

                  var16 = FontTypeFace.method3913(class37.method764(var16));
                  var5.overhead = var16.trim();
                  var5.field616 = var8 >> 8;
                  var5.field617 = var8 & 255;
                  var5.field615 = 150;
                  var5.field613 = var29;
                  var5.inSequence = class22.localPlayer != var5 && var26.field2670 && "" != Client.field460 && var16.toLowerCase().indexOf(Client.field460) == -1;
                  if(var26.field2669) {
                     var17 = var29?91:1;
                  } else {
                     var17 = var29?90:2;
                  }

                  if(var26.field2661 != -1) {
                     WidgetNode.sendGameMessage(var17, TextureProvider.method1472(var26.field2661) + var5.name, var16);
                  } else {
                     WidgetNode.sendGameMessage(var17, var5.name, var16);
                  }
               }
            }

            var0.offset = var11 + var12;
         }

         if((var6 & 512) != 0) {
            var5.graphic = var0.readUnsignedShort();
            var8 = var0.readInt();
            var5.field622 = var8 >> 16;
            var5.field639 = (var8 & '\uffff') + Client.gameCycle;
            var5.field637 = 0;
            var5.field631 = 0;
            if(var5.field639 > Client.gameCycle) {
               var5.field637 = -1;
            }

            if(var5.graphic == '\uffff') {
               var5.graphic = -1;
            }
         }

         if((var6 & 4096) != 0) {
            var5.field660 = var0.readByte();
            var5.field643 = var0.readByte();
            var5.field642 = var0.readByte();
            var5.field644 = var0.readByte();
            var5.field638 = var0.readUnsignedShort() + Client.gameCycle;
            var5.field646 = var0.readUnsignedShort() + Client.gameCycle;
            var5.field647 = var0.readUnsignedShort();
            if(var5.field255) {
               var5.field660 += var5.field246;
               var5.field643 += var5.field260;
               var5.field642 += var5.field246;
               var5.field644 += var5.field260;
               var5.field653 = 0;
            } else {
               var5.field660 += var5.pathX[0];
               var5.field643 += var5.pathY[0];
               var5.field642 += var5.pathX[0];
               var5.field644 += var5.pathY[0];
               var5.field653 = 1;
            }

            var5.field658 = 0;
         }

         if((var6 & 256) != 0) {
            class45.field889[var4] = var0.readByte();
         }

         if((var6 & 2048) != 0) {
            var7 = var0.readByte();
         }

         if((var6 & 1024) != 0) {
            for(var8 = 0; var8 < 3; ++var8) {
               var5.actions[var8] = var0.readString();
            }
         }

         if(var5.field255) {
            if(var7 == 127) {
               var5.method236(var5.field246, var5.field260);
            } else {
               byte var27;
               if(var7 != -1) {
                  var27 = var7;
               } else {
                  var27 = class45.field889[var4];
               }

               var5.method252(var5.field246, var5.field260, var27);
            }
         }
      }

      if(var0.offset - var2 != var1) {
         throw new RuntimeException(var0.offset - var2 + " " + var1);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;Ljava/lang/String;I)I",
      garbageValue = "2121990068"
   )
   public static int method767(Buffer var0, String var1) {
      int var2 = var0.offset;
      int var4 = var1.length();
      byte[] var5 = new byte[var4];

      for(int var6 = 0; var6 < var4; ++var6) {
         char var7 = var1.charAt(var6);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var5[var6] = (byte)var7;
         } else if(var7 == 8364) {
            var5[var6] = -128;
         } else if(var7 == 8218) {
            var5[var6] = -126;
         } else if(var7 == 402) {
            var5[var6] = -125;
         } else if(var7 == 8222) {
            var5[var6] = -124;
         } else if(var7 == 8230) {
            var5[var6] = -123;
         } else if(var7 == 8224) {
            var5[var6] = -122;
         } else if(var7 == 8225) {
            var5[var6] = -121;
         } else if(var7 == 710) {
            var5[var6] = -120;
         } else if(var7 == 8240) {
            var5[var6] = -119;
         } else if(var7 == 352) {
            var5[var6] = -118;
         } else if(var7 == 8249) {
            var5[var6] = -117;
         } else if(var7 == 338) {
            var5[var6] = -116;
         } else if(var7 == 381) {
            var5[var6] = -114;
         } else if(var7 == 8216) {
            var5[var6] = -111;
         } else if(var7 == 8217) {
            var5[var6] = -110;
         } else if(var7 == 8220) {
            var5[var6] = -109;
         } else if(var7 == 8221) {
            var5[var6] = -108;
         } else if(var7 == 8226) {
            var5[var6] = -107;
         } else if(var7 == 8211) {
            var5[var6] = -106;
         } else if(var7 == 8212) {
            var5[var6] = -105;
         } else if(var7 == 732) {
            var5[var6] = -104;
         } else if(var7 == 8482) {
            var5[var6] = -103;
         } else if(var7 == 353) {
            var5[var6] = -102;
         } else if(var7 == 8250) {
            var5[var6] = -101;
         } else if(var7 == 339) {
            var5[var6] = -100;
         } else if(var7 == 382) {
            var5[var6] = -98;
         } else if(var7 == 376) {
            var5[var6] = -97;
         } else {
            var5[var6] = 63;
         }
      }

      var0.method2381(var5.length);
      var0.offset += class209.field3127.method2311(var5, 0, var5.length, var0.payload, var0.offset);
      return var0.offset - var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "-1306009144"
   )
   public static int method768(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)V",
      garbageValue = "6"
   )
   static final void method769(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = var2 + 6;
      int var5 = WallObject.field1542.method3964(var0, 250);
      int var6 = WallObject.field1542.method3912(var0, 250) * 13;
      Rasterizer2D.method4089(var3 - var2, var4 - var2, var5 + var2 + var2, var6 + var2 + var2, 0);
      Rasterizer2D.method4095(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 16777215);
      WallObject.field1542.method3905(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class5.method75(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6);
      if(var1) {
         try {
            Graphics var7 = class65.canvas.getGraphics();
            class88.bufferProvider.draw(var7, 0, 0);
         } catch (Exception var13) {
            class65.canvas.repaint();
         }
      } else {
         int var12 = var3;
         int var8 = var4;
         int var9 = var5;
         int var10 = var6;

         for(int var11 = 0; var11 < Client.field490; ++var11) {
            if(Client.widgetBoundsWidth[var11] + Client.widgetPositionX[var11] > var12 && Client.widgetPositionX[var11] < var9 + var12 && Client.widgetPositionY[var11] + Client.widgetBoundsHeight[var11] > var8 && Client.widgetPositionY[var11] < var8 + var10) {
               Client.field491[var11] = true;
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;I)V",
      garbageValue = "-1618539418"
   )
   public static void method770(IndexDataBase var0) {
      Varbit.field2866 = var0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "263365144"
   )
   public static void method771() {
      if(class103.field1659.toLowerCase().indexOf("microsoft") != -1) {
         class105.field1698[186] = 57;
         class105.field1698[187] = 27;
         class105.field1698[188] = 71;
         class105.field1698[189] = 26;
         class105.field1698[190] = 72;
         class105.field1698[191] = 73;
         class105.field1698[192] = 58;
         class105.field1698[219] = 42;
         class105.field1698[220] = 74;
         class105.field1698[221] = 43;
         class105.field1698[222] = 59;
         class105.field1698[223] = 28;
      } else {
         class105.field1698[44] = 71;
         class105.field1698[45] = 26;
         class105.field1698[46] = 72;
         class105.field1698[47] = 73;
         class105.field1698[59] = 57;
         class105.field1698[61] = 27;
         class105.field1698[91] = 42;
         class105.field1698[92] = 74;
         class105.field1698[93] = 43;
         class105.field1698[192] = 28;
         class105.field1698[222] = 58;
         class105.field1698[520] = 59;
      }

   }
}

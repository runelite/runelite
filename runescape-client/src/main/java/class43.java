import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public class class43 {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1515976135
   )
   @Export("scriptStringStackSize")
   static int scriptStringStackSize;
   @ObfuscatedName("fl")
   @Export("landMapFileIds")
   static int[] landMapFileIds;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -431797209
   )
   int field533;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2094612221
   )
   int field525;
   @ObfuscatedName("o")
   int[][] field529;
   @ObfuscatedName("p")
   int[][] field527;
   @ObfuscatedName("a")
   int[][] field528;
   @ObfuscatedName("h")
   int[][] field526;

   class43(int var1, int var2) {
      this.field533 = var1;
      this.field525 = var2;
      this.field529 = new int[var1][var2];
      this.field527 = new int[var1][var2];
      this.field528 = new int[var1][var2];
      this.field526 = new int[var1][var2];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIILjp;I)V",
      garbageValue = "-739526759"
   )
   void method636(int var1, int var2, int var3, FloorUnderlayDefinition var4) {
      if(var4 != null) {
         if(var3 + var1 >= 0 && var3 + var2 >= 0) {
            if(var1 - var3 <= this.field533 && var2 - var3 <= this.field525) {
               int var5 = Math.max(0, var1 - var3);
               int var6 = Math.min(this.field533, var3 + var1);
               int var7 = Math.max(0, var2 - var3);
               int var8 = Math.min(this.field525, var3 + var2);

               for(int var9 = var5; var9 < var6; ++var9) {
                  for(int var10 = var7; var10 < var8; ++var10) {
                     this.field529[var9][var10] += var4.hue * 256 / var4.hueMultiplier;
                     this.field527[var9][var10] += var4.saturation;
                     this.field528[var9][var10] += var4.lightness;
                     ++this.field526[var9][var10];
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "340418951"
   )
   int method635(int var1, int var2) {
      if(var1 >= 0 && var2 >= 0 && var1 < this.field533 && var2 < this.field525) {
         if(this.field528[var1][var2] == 0) {
            return 0;
         } else {
            int var3 = this.field529[var1][var2] / this.field526[var1][var2];
            int var4 = this.field527[var1][var2] / this.field526[var1][var2];
            int var5 = this.field528[var1][var2] / this.field526[var1][var2];
            double var7 = (double)var3 / 256.0D;
            double var9 = (double)var4 / 256.0D;
            double var11 = (double)var5 / 256.0D;
            double var13 = var11;
            double var15 = var11;
            double var17 = var11;
            if(var9 != 0.0D) {
               double var19;
               if(var11 < 0.5D) {
                  var19 = var11 * (var9 + 1.0D);
               } else {
                  var19 = var11 + var9 - var9 * var11;
               }

               double var21 = 2.0D * var11 - var19;
               double var23 = 0.3333333333333333D + var7;
               if(var23 > 1.0D) {
                  --var23;
               }

               double var27 = var7 - 0.3333333333333333D;
               if(var27 < 0.0D) {
                  ++var27;
               }

               if(6.0D * var23 < 1.0D) {
                  var13 = 6.0D * (var19 - var21) * var23 + var21;
               } else if(2.0D * var23 < 1.0D) {
                  var13 = var19;
               } else if(var23 * 3.0D < 2.0D) {
                  var13 = var21 + (0.6666666666666666D - var23) * (var19 - var21) * 6.0D;
               } else {
                  var13 = var21;
               }

               if(6.0D * var7 < 1.0D) {
                  var15 = (var19 - var21) * 6.0D * var7 + var21;
               } else if(var7 * 2.0D < 1.0D) {
                  var15 = var19;
               } else if(3.0D * var7 < 2.0D) {
                  var15 = var21 + (0.6666666666666666D - var7) * (var19 - var21) * 6.0D;
               } else {
                  var15 = var21;
               }

               if(var27 * 6.0D < 1.0D) {
                  var17 = var21 + 6.0D * (var19 - var21) * var27;
               } else if(var27 * 2.0D < 1.0D) {
                  var17 = var19;
               } else if(3.0D * var27 < 2.0D) {
                  var17 = 6.0D * (var19 - var21) * (0.6666666666666666D - var27) + var21;
               } else {
                  var17 = var21;
               }
            }

            int var29 = (int)(256.0D * var13);
            int var20 = (int)(256.0D * var15);
            int var30 = (int)(256.0D * var17);
            int var22 = var30 + (var20 << 8) + (var29 << 16);
            return var22;
         }
      } else {
         return 0;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lie;B)V",
      garbageValue = "-46"
   )
   public static void method644(IndexDataBase var0) {
      VarPlayerType.varplayer_ref = var0;
      class197.field2566 = VarPlayerType.varplayer_ref.fileCount(16);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public static void method642() {
      if(class258.NetCache_socket != null) {
         class258.NetCache_socket.vmethod3317();
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-1602866002"
   )
   @Export("getLength")
   public static int getLength(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(ILca;ZB)I",
      garbageValue = "-98"
   )
   static int method643(int var0, Script var1, boolean var2) {
      if(var0 == 5000) {
         class80.intStack[++class80.intStackSize - 1] = Client.publicChatMode;
         return 1;
      } else {
         int var4;
         PacketNode var5;
         int var6;
         if(var0 == 5001) {
            class80.intStackSize -= 3;
            Client.publicChatMode = class80.intStack[class80.intStackSize];
            var4 = class80.intStack[class80.intStackSize + 1];
            class312[] var30 = Player.method1210();
            var6 = 0;

            class312 var35;
            while(true) {
               if(var6 >= var30.length) {
                  var35 = null;
                  break;
               }

               class312 var32 = var30[var6];
               if(var4 == var32.field3853) {
                  var35 = var32;
                  break;
               }

               ++var6;
            }

            class70.field779 = var35;
            if(class70.field779 == null) {
               class70.field779 = class312.field3854;
            }

            Client.field1021 = class80.intStack[class80.intStackSize + 2];
            var5 = class61.method1076(ClientPacket.field2348, Client.field863.field1434);
            var5.packetBuffer.putByte(Client.publicChatMode);
            var5.packetBuffer.putByte(class70.field779.field3853);
            var5.packetBuffer.putByte(Client.field1021);
            Client.field863.method2039(var5);
            return 1;
         } else {
            String var3;
            int var17;
            if(var0 == 5002) {
               var3 = class80.scriptStringStack[--scriptStringStackSize];
               class80.intStackSize -= 2;
               var4 = class80.intStack[class80.intStackSize];
               var17 = class80.intStack[class80.intStackSize + 1];
               PacketNode var18 = class61.method1076(ClientPacket.field2363, Client.field863.field1434);
               var18.packetBuffer.putByte(getLength(var3) + 2);
               var18.packetBuffer.putString(var3);
               var18.packetBuffer.putByte(var4 - 1);
               var18.packetBuffer.putByte(var17);
               Client.field863.method2039(var18);
               return 1;
            } else {
               int var19;
               if(var0 == 5003) {
                  class80.intStackSize -= 2;
                  var19 = class80.intStack[class80.intStackSize];
                  var4 = class80.intStack[class80.intStackSize + 1];
                  MessageNode var29 = BaseVarType.method10(var19, var4);
                  if(var29 != null) {
                     class80.intStack[++class80.intStackSize - 1] = var29.id;
                     class80.intStack[++class80.intStackSize - 1] = var29.tick;
                     class80.scriptStringStack[++scriptStringStackSize - 1] = var29.name != null?var29.name:"";
                     class80.scriptStringStack[++scriptStringStackSize - 1] = var29.sender != null?var29.sender:"";
                     class80.scriptStringStack[++scriptStringStackSize - 1] = var29.value != null?var29.value:"";
                     class80.intStack[++class80.intStackSize - 1] = var29.method1154()?1:(var29.method1172()?2:0);
                  } else {
                     class80.intStack[++class80.intStackSize - 1] = -1;
                     class80.intStack[++class80.intStackSize - 1] = 0;
                     class80.scriptStringStack[++scriptStringStackSize - 1] = "";
                     class80.scriptStringStack[++scriptStringStackSize - 1] = "";
                     class80.scriptStringStack[++scriptStringStackSize - 1] = "";
                     class80.intStack[++class80.intStackSize - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 5004) {
                  var19 = class80.intStack[--class80.intStackSize];
                  MessageNode var37 = (MessageNode)class94.messages.get((long)var19);
                  if(var37 != null) {
                     class80.intStack[++class80.intStackSize - 1] = var37.type;
                     class80.intStack[++class80.intStackSize - 1] = var37.tick;
                     class80.scriptStringStack[++scriptStringStackSize - 1] = var37.name != null?var37.name:"";
                     class80.scriptStringStack[++scriptStringStackSize - 1] = var37.sender != null?var37.sender:"";
                     class80.scriptStringStack[++scriptStringStackSize - 1] = var37.value != null?var37.value:"";
                     class80.intStack[++class80.intStackSize - 1] = var37.method1154()?1:(var37.method1172()?2:0);
                  } else {
                     class80.intStack[++class80.intStackSize - 1] = -1;
                     class80.intStack[++class80.intStackSize - 1] = 0;
                     class80.scriptStringStack[++scriptStringStackSize - 1] = "";
                     class80.scriptStringStack[++scriptStringStackSize - 1] = "";
                     class80.scriptStringStack[++scriptStringStackSize - 1] = "";
                     class80.intStack[++class80.intStackSize - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 5005) {
                  if(class70.field779 == null) {
                     class80.intStack[++class80.intStackSize - 1] = -1;
                  } else {
                     class80.intStack[++class80.intStackSize - 1] = class70.field779.field3853;
                  }

                  return 1;
               } else if(var0 == 5008) {
                  var3 = class80.scriptStringStack[--scriptStringStackSize];
                  var4 = class80.intStack[--class80.intStackSize];
                  String var28 = var3.toLowerCase();
                  byte var33 = 0;
                  if(var28.startsWith("yellow:")) {
                     var33 = 0;
                     var3 = var3.substring("yellow:".length());
                  } else if(var28.startsWith("red:")) {
                     var33 = 1;
                     var3 = var3.substring("red:".length());
                  } else if(var28.startsWith("green:")) {
                     var33 = 2;
                     var3 = var3.substring("green:".length());
                  } else if(var28.startsWith("cyan:")) {
                     var33 = 3;
                     var3 = var3.substring("cyan:".length());
                  } else if(var28.startsWith("purple:")) {
                     var33 = 4;
                     var3 = var3.substring("purple:".length());
                  } else if(var28.startsWith("white:")) {
                     var33 = 5;
                     var3 = var3.substring("white:".length());
                  } else if(var28.startsWith("flash1:")) {
                     var33 = 6;
                     var3 = var3.substring("flash1:".length());
                  } else if(var28.startsWith("flash2:")) {
                     var33 = 7;
                     var3 = var3.substring("flash2:".length());
                  } else if(var28.startsWith("flash3:")) {
                     var33 = 8;
                     var3 = var3.substring("flash3:".length());
                  } else if(var28.startsWith("glow1:")) {
                     var33 = 9;
                     var3 = var3.substring("glow1:".length());
                  } else if(var28.startsWith("glow2:")) {
                     var33 = 10;
                     var3 = var3.substring("glow2:".length());
                  } else if(var28.startsWith("glow3:")) {
                     var33 = 11;
                     var3 = var3.substring("glow3:".length());
                  } else if(Client.languageId != 0) {
                     if(var28.startsWith("yellow:")) {
                        var33 = 0;
                        var3 = var3.substring("yellow:".length());
                     } else if(var28.startsWith("red:")) {
                        var33 = 1;
                        var3 = var3.substring("red:".length());
                     } else if(var28.startsWith("green:")) {
                        var33 = 2;
                        var3 = var3.substring("green:".length());
                     } else if(var28.startsWith("cyan:")) {
                        var33 = 3;
                        var3 = var3.substring("cyan:".length());
                     } else if(var28.startsWith("purple:")) {
                        var33 = 4;
                        var3 = var3.substring("purple:".length());
                     } else if(var28.startsWith("white:")) {
                        var33 = 5;
                        var3 = var3.substring("white:".length());
                     } else if(var28.startsWith("flash1:")) {
                        var33 = 6;
                        var3 = var3.substring("flash1:".length());
                     } else if(var28.startsWith("flash2:")) {
                        var33 = 7;
                        var3 = var3.substring("flash2:".length());
                     } else if(var28.startsWith("flash3:")) {
                        var33 = 8;
                        var3 = var3.substring("flash3:".length());
                     } else if(var28.startsWith("glow1:")) {
                        var33 = 9;
                        var3 = var3.substring("glow1:".length());
                     } else if(var28.startsWith("glow2:")) {
                        var33 = 10;
                        var3 = var3.substring("glow2:".length());
                     } else if(var28.startsWith("glow3:")) {
                        var33 = 11;
                        var3 = var3.substring("glow3:".length());
                     }
                  }

                  var28 = var3.toLowerCase();
                  byte var21 = 0;
                  if(var28.startsWith("wave:")) {
                     var21 = 1;
                     var3 = var3.substring("wave:".length());
                  } else if(var28.startsWith("wave2:")) {
                     var21 = 2;
                     var3 = var3.substring("wave2:".length());
                  } else if(var28.startsWith("shake:")) {
                     var21 = 3;
                     var3 = var3.substring("shake:".length());
                  } else if(var28.startsWith("scroll:")) {
                     var21 = 4;
                     var3 = var3.substring("scroll:".length());
                  } else if(var28.startsWith("slide:")) {
                     var21 = 5;
                     var3 = var3.substring("slide:".length());
                  } else if(Client.languageId != 0) {
                     if(var28.startsWith("wave:")) {
                        var21 = 1;
                        var3 = var3.substring("wave:".length());
                     } else if(var28.startsWith("wave2:")) {
                        var21 = 2;
                        var3 = var3.substring("wave2:".length());
                     } else if(var28.startsWith("shake:")) {
                        var21 = 3;
                        var3 = var3.substring("shake:".length());
                     } else if(var28.startsWith("scroll:")) {
                        var21 = 4;
                        var3 = var3.substring("scroll:".length());
                     } else if(var28.startsWith("slide:")) {
                        var21 = 5;
                        var3 = var3.substring("slide:".length());
                     }
                  }

                  PacketNode var8 = class61.method1076(ClientPacket.field2426, Client.field863.field1434);
                  var8.packetBuffer.putByte(0);
                  int var9 = var8.packetBuffer.offset;
                  var8.packetBuffer.putByte(var4);
                  var8.packetBuffer.putByte(var33);
                  var8.packetBuffer.putByte(var21);
                  PacketBuffer var10 = var8.packetBuffer;
                  int var11 = var10.offset;
                  int var34 = var3.length();
                  byte[] var14 = new byte[var34];

                  for(int var15 = 0; var15 < var34; ++var15) {
                     char var16 = var3.charAt(var15);
                     if((var16 <= 0 || var16 >= 128) && (var16 < 160 || var16 > 255)) {
                        if(var16 == 8364) {
                           var14[var15] = -128;
                        } else if(var16 == 8218) {
                           var14[var15] = -126;
                        } else if(var16 == 402) {
                           var14[var15] = -125;
                        } else if(var16 == 8222) {
                           var14[var15] = -124;
                        } else if(var16 == 8230) {
                           var14[var15] = -123;
                        } else if(var16 == 8224) {
                           var14[var15] = -122;
                        } else if(var16 == 8225) {
                           var14[var15] = -121;
                        } else if(var16 == 710) {
                           var14[var15] = -120;
                        } else if(var16 == 8240) {
                           var14[var15] = -119;
                        } else if(var16 == 352) {
                           var14[var15] = -118;
                        } else if(var16 == 8249) {
                           var14[var15] = -117;
                        } else if(var16 == 338) {
                           var14[var15] = -116;
                        } else if(var16 == 381) {
                           var14[var15] = -114;
                        } else if(var16 == 8216) {
                           var14[var15] = -111;
                        } else if(var16 == 8217) {
                           var14[var15] = -110;
                        } else if(var16 == 8220) {
                           var14[var15] = -109;
                        } else if(var16 == 8221) {
                           var14[var15] = -108;
                        } else if(var16 == 8226) {
                           var14[var15] = -107;
                        } else if(var16 == 8211) {
                           var14[var15] = -106;
                        } else if(var16 == 8212) {
                           var14[var15] = -105;
                        } else if(var16 == 732) {
                           var14[var15] = -104;
                        } else if(var16 == 8482) {
                           var14[var15] = -103;
                        } else if(var16 == 353) {
                           var14[var15] = -102;
                        } else if(var16 == 8250) {
                           var14[var15] = -101;
                        } else if(var16 == 339) {
                           var14[var15] = -100;
                        } else if(var16 == 382) {
                           var14[var15] = -98;
                        } else if(var16 == 376) {
                           var14[var15] = -97;
                        } else {
                           var14[var15] = 63;
                        }
                     } else {
                        var14[var15] = (byte)var16;
                     }
                  }

                  var10.putShortSmart(var14.length);
                  var10.offset += class299.huffman.compress(var14, 0, var14.length, var10.payload, var10.offset);
                  var8.packetBuffer.method3545(var8.packetBuffer.offset - var9);
                  Client.field863.method2039(var8);
                  return 1;
               } else if(var0 == 5009) {
                  scriptStringStackSize -= 2;
                  var3 = class80.scriptStringStack[scriptStringStackSize];
                  String var36 = class80.scriptStringStack[scriptStringStackSize + 1];
                  var5 = class61.method1076(ClientPacket.field2364, Client.field863.field1434);
                  var5.packetBuffer.putShort(0);
                  var6 = var5.packetBuffer.offset;
                  var5.packetBuffer.putString(var3);
                  PacketBuffer var31 = var5.packetBuffer;
                  int var22 = var31.offset;
                  int var23 = var36.length();
                  byte[] var24 = new byte[var23];

                  for(int var12 = 0; var12 < var23; ++var12) {
                     char var13 = var36.charAt(var12);
                     if(var13 > 0 && var13 < 128 || var13 >= 160 && var13 <= 255) {
                        var24[var12] = (byte)var13;
                     } else if(var13 == 8364) {
                        var24[var12] = -128;
                     } else if(var13 == 8218) {
                        var24[var12] = -126;
                     } else if(var13 == 402) {
                        var24[var12] = -125;
                     } else if(var13 == 8222) {
                        var24[var12] = -124;
                     } else if(var13 == 8230) {
                        var24[var12] = -123;
                     } else if(var13 == 8224) {
                        var24[var12] = -122;
                     } else if(var13 == 8225) {
                        var24[var12] = -121;
                     } else if(var13 == 710) {
                        var24[var12] = -120;
                     } else if(var13 == 8240) {
                        var24[var12] = -119;
                     } else if(var13 == 352) {
                        var24[var12] = -118;
                     } else if(var13 == 8249) {
                        var24[var12] = -117;
                     } else if(var13 == 338) {
                        var24[var12] = -116;
                     } else if(var13 == 381) {
                        var24[var12] = -114;
                     } else if(var13 == 8216) {
                        var24[var12] = -111;
                     } else if(var13 == 8217) {
                        var24[var12] = -110;
                     } else if(var13 == 8220) {
                        var24[var12] = -109;
                     } else if(var13 == 8221) {
                        var24[var12] = -108;
                     } else if(var13 == 8226) {
                        var24[var12] = -107;
                     } else if(var13 == 8211) {
                        var24[var12] = -106;
                     } else if(var13 == 8212) {
                        var24[var12] = -105;
                     } else if(var13 == 732) {
                        var24[var12] = -104;
                     } else if(var13 == 8482) {
                        var24[var12] = -103;
                     } else if(var13 == 353) {
                        var24[var12] = -102;
                     } else if(var13 == 8250) {
                        var24[var12] = -101;
                     } else if(var13 == 339) {
                        var24[var12] = -100;
                     } else if(var13 == 382) {
                        var24[var12] = -98;
                     } else if(var13 == 376) {
                        var24[var12] = -97;
                     } else {
                        var24[var12] = 63;
                     }
                  }

                  var31.putShortSmart(var24.length);
                  var31.offset += class299.huffman.compress(var24, 0, var24.length, var31.payload, var31.offset);
                  var5.packetBuffer.method3655(var5.packetBuffer.offset - var6);
                  Client.field863.method2039(var5);
                  return 1;
               } else if(var0 != 5015) {
                  if(var0 == 5016) {
                     class80.intStack[++class80.intStackSize - 1] = Client.field1021;
                     return 1;
                  } else if(var0 == 5017) {
                     var19 = class80.intStack[--class80.intStackSize];
                     class80.intStack[++class80.intStackSize - 1] = class137.method3042(var19);
                     return 1;
                  } else {
                     MessageNode var7;
                     int[] var20;
                     if(var0 == 5018) {
                        var19 = class80.intStack[--class80.intStackSize];
                        var20 = class80.intStack;
                        var17 = ++class80.intStackSize - 1;
                        var7 = (MessageNode)class94.messages.get((long)var19);
                        if(var7 == null) {
                           var6 = -1;
                        } else if(var7.previous == class94.field1397.sentinel) {
                           var6 = -1;
                        } else {
                           var6 = ((MessageNode)var7.previous).id;
                        }

                        var20[var17] = var6;
                        return 1;
                     } else if(var0 == 5019) {
                        var19 = class80.intStack[--class80.intStackSize];
                        var20 = class80.intStack;
                        var17 = ++class80.intStackSize - 1;
                        var7 = (MessageNode)class94.messages.get((long)var19);
                        if(var7 == null) {
                           var6 = -1;
                        } else if(var7.next == class94.field1397.sentinel) {
                           var6 = -1;
                        } else {
                           var6 = ((MessageNode)var7.next).id;
                        }

                        var20[var17] = var6;
                        return 1;
                     } else if(var0 == 5020) {
                        var3 = class80.scriptStringStack[--scriptStringStackSize];
                        ContextMenuRow.method1859(var3);
                        return 1;
                     } else if(var0 == 5021) {
                        Client.field1022 = class80.scriptStringStack[--scriptStringStackSize].toLowerCase().trim();
                        return 1;
                     } else if(var0 == 5022) {
                        class80.scriptStringStack[++scriptStringStackSize - 1] = Client.field1022;
                        return 1;
                     } else {
                        return 2;
                     }
                  }
               } else {
                  if(OwnWorldComparator.localPlayer != null && OwnWorldComparator.localPlayer.name != null) {
                     var3 = OwnWorldComparator.localPlayer.name.getName();
                  } else {
                     var3 = "";
                  }

                  class80.scriptStringStack[++scriptStringStackSize - 1] = var3;
                  return 1;
               }
            }
         }
      }
   }
}

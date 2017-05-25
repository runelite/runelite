import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public final class class29 {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1321304079
   )
   int field414;
   // $FF: synthetic field
   final class41 this$0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 423656599
   )
   int field415;
   @ObfuscatedName("lx")
   static Widget[] field416;
   @ObfuscatedName("oj")
   static byte field418;
   @ObfuscatedName("g")
   static ModIcon[] field419;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1154409853
   )
   int field420;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1027288737
   )
   int field422;

   class29(class41 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "555831651"
   )
   static int method239(int var0, Script var1, boolean var2) {
      if(var0 == 5000) {
         class83.intStack[++class83.intStackSize - 1] = Client.field1099;
         return 1;
      } else {
         int var4;
         int var7;
         if(var0 == 5001) {
            class83.intStackSize -= 3;
            Client.field1099 = class83.intStack[class83.intStackSize];
            var4 = class83.intStack[class83.intStackSize + 1];
            class276[] var27 = new class276[]{class276.field3724, class276.field3725, class276.field3726};
            class276[] var31 = var27;
            var7 = 0;

            class276 var32;
            while(true) {
               if(var7 >= var31.length) {
                  var32 = null;
                  break;
               }

               class276 var8 = var31[var7];
               if(var4 == var8.field3727) {
                  var32 = var8;
                  break;
               }

               ++var7;
            }

            MessageNode.field844 = var32;
            if(MessageNode.field844 == null) {
               MessageNode.field844 = class276.field3725;
            }

            Client.field1092 = class83.intStack[class83.intStackSize + 2];
            Client.secretPacketBuffer1.putOpcode(200);
            Client.secretPacketBuffer1.putByte(Client.field1099);
            Client.secretPacketBuffer1.putByte(MessageNode.field844.field3727);
            Client.secretPacketBuffer1.putByte(Client.field1092);
            return 1;
         } else {
            String var3;
            int var20;
            if(var0 == 5002) {
               var3 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
               class83.intStackSize -= 2;
               var4 = class83.intStack[class83.intStackSize];
               var20 = class83.intStack[class83.intStackSize + 1];
               Client.secretPacketBuffer1.putOpcode(85);
               Client.secretPacketBuffer1.putByte(class46.method711(var3) + 2);
               Client.secretPacketBuffer1.method3191(var3);
               Client.secretPacketBuffer1.putByte(var4 - 1);
               Client.secretPacketBuffer1.putByte(var20);
               return 1;
            } else {
               int var18;
               if(var0 == 5003) {
                  class83.intStackSize -= 2;
                  var18 = class83.intStack[class83.intStackSize];
                  var4 = class83.intStack[class83.intStackSize + 1];
                  MessageNode var26 = class67.method1102(var18, var4);
                  if(var26 != null) {
                     class83.intStack[++class83.intStackSize - 1] = var26.id;
                     class83.intStack[++class83.intStackSize - 1] = var26.tick;
                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var26.name != null?var26.name:"";
                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var26.sender != null?var26.sender:"";
                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var26.value != null?var26.value:"";
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = -1;
                     class83.intStack[++class83.intStackSize - 1] = 0;
                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = "";
                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = "";
                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 5004) {
                  var18 = class83.intStack[--class83.intStackSize];
                  MessageNode var34 = class151.method2960(var18);
                  if(var34 != null) {
                     class83.intStack[++class83.intStackSize - 1] = var34.type;
                     class83.intStack[++class83.intStackSize - 1] = var34.tick;
                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var34.name != null?var34.name:"";
                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var34.sender != null?var34.sender:"";
                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var34.value != null?var34.value:"";
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = -1;
                     class83.intStack[++class83.intStackSize - 1] = 0;
                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = "";
                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = "";
                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 5005) {
                  if(MessageNode.field844 == null) {
                     class83.intStack[++class83.intStackSize - 1] = -1;
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = MessageNode.field844.field3727;
                  }

                  return 1;
               } else if(var0 == 5008) {
                  var3 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
                  var4 = class83.intStack[--class83.intStackSize];
                  String var5 = var3.toLowerCase();
                  byte var29 = 0;
                  if(var5.startsWith("yellow:")) {
                     var29 = 0;
                     var3 = var3.substring("yellow:".length());
                  } else if(var5.startsWith("red:")) {
                     var29 = 1;
                     var3 = var3.substring("red:".length());
                  } else if(var5.startsWith("green:")) {
                     var29 = 2;
                     var3 = var3.substring("green:".length());
                  } else if(var5.startsWith("cyan:")) {
                     var29 = 3;
                     var3 = var3.substring("cyan:".length());
                  } else if(var5.startsWith("purple:")) {
                     var29 = 4;
                     var3 = var3.substring("purple:".length());
                  } else if(var5.startsWith("white:")) {
                     var29 = 5;
                     var3 = var3.substring("white:".length());
                  } else if(var5.startsWith("flash1:")) {
                     var29 = 6;
                     var3 = var3.substring("flash1:".length());
                  } else if(var5.startsWith("flash2:")) {
                     var29 = 7;
                     var3 = var3.substring("flash2:".length());
                  } else if(var5.startsWith("flash3:")) {
                     var29 = 8;
                     var3 = var3.substring("flash3:".length());
                  } else if(var5.startsWith("glow1:")) {
                     var29 = 9;
                     var3 = var3.substring("glow1:".length());
                  } else if(var5.startsWith("glow2:")) {
                     var29 = 10;
                     var3 = var3.substring("glow2:".length());
                  } else if(var5.startsWith("glow3:")) {
                     var29 = 11;
                     var3 = var3.substring("glow3:".length());
                  } else if(Client.field896 != 0) {
                     if(var5.startsWith("yellow:")) {
                        var29 = 0;
                        var3 = var3.substring("yellow:".length());
                     } else if(var5.startsWith("red:")) {
                        var29 = 1;
                        var3 = var3.substring("red:".length());
                     } else if(var5.startsWith("green:")) {
                        var29 = 2;
                        var3 = var3.substring("green:".length());
                     } else if(var5.startsWith("cyan:")) {
                        var29 = 3;
                        var3 = var3.substring("cyan:".length());
                     } else if(var5.startsWith("purple:")) {
                        var29 = 4;
                        var3 = var3.substring("purple:".length());
                     } else if(var5.startsWith("white:")) {
                        var29 = 5;
                        var3 = var3.substring("white:".length());
                     } else if(var5.startsWith("flash1:")) {
                        var29 = 6;
                        var3 = var3.substring("flash1:".length());
                     } else if(var5.startsWith("flash2:")) {
                        var29 = 7;
                        var3 = var3.substring("flash2:".length());
                     } else if(var5.startsWith("flash3:")) {
                        var29 = 8;
                        var3 = var3.substring("flash3:".length());
                     } else if(var5.startsWith("glow1:")) {
                        var29 = 9;
                        var3 = var3.substring("glow1:".length());
                     } else if(var5.startsWith("glow2:")) {
                        var29 = 10;
                        var3 = var3.substring("glow2:".length());
                     } else if(var5.startsWith("glow3:")) {
                        var29 = 11;
                        var3 = var3.substring("glow3:".length());
                     }
                  }

                  var5 = var3.toLowerCase();
                  byte var28 = 0;
                  if(var5.startsWith("wave:")) {
                     var28 = 1;
                     var3 = var3.substring("wave:".length());
                  } else if(var5.startsWith("wave2:")) {
                     var28 = 2;
                     var3 = var3.substring("wave2:".length());
                  } else if(var5.startsWith("shake:")) {
                     var28 = 3;
                     var3 = var3.substring("shake:".length());
                  } else if(var5.startsWith("scroll:")) {
                     var28 = 4;
                     var3 = var3.substring("scroll:".length());
                  } else if(var5.startsWith("slide:")) {
                     var28 = 5;
                     var3 = var3.substring("slide:".length());
                  } else if(Client.field896 != 0) {
                     if(var5.startsWith("wave:")) {
                        var28 = 1;
                        var3 = var3.substring("wave:".length());
                     } else if(var5.startsWith("wave2:")) {
                        var28 = 2;
                        var3 = var3.substring("wave2:".length());
                     } else if(var5.startsWith("shake:")) {
                        var28 = 3;
                        var3 = var3.substring("shake:".length());
                     } else if(var5.startsWith("scroll:")) {
                        var28 = 4;
                        var3 = var3.substring("scroll:".length());
                     } else if(var5.startsWith("slide:")) {
                        var28 = 5;
                        var3 = var3.substring("slide:".length());
                     }
                  }

                  Client.secretPacketBuffer1.putOpcode(90);
                  Client.secretPacketBuffer1.putByte(0);
                  int var21 = Client.secretPacketBuffer1.offset;
                  Client.secretPacketBuffer1.putByte(var4);
                  Client.secretPacketBuffer1.putByte(var29);
                  Client.secretPacketBuffer1.putByte(var28);
                  PacketBuffer var9 = Client.secretPacketBuffer1;
                  int var25 = var9.offset;
                  int var30 = var3.length();
                  byte[] var13 = new byte[var30];

                  for(int var14 = 0; var14 < var30; ++var14) {
                     char var15 = var3.charAt(var14);
                     if((var15 <= 0 || var15 >= 128) && (var15 < 160 || var15 > 255)) {
                        if(var15 == 8364) {
                           var13[var14] = -128;
                        } else if(var15 == 8218) {
                           var13[var14] = -126;
                        } else if(var15 == 402) {
                           var13[var14] = -125;
                        } else if(var15 == 8222) {
                           var13[var14] = -124;
                        } else if(var15 == 8230) {
                           var13[var14] = -123;
                        } else if(var15 == 8224) {
                           var13[var14] = -122;
                        } else if(var15 == 8225) {
                           var13[var14] = -121;
                        } else if(var15 == 710) {
                           var13[var14] = -120;
                        } else if(var15 == 8240) {
                           var13[var14] = -119;
                        } else if(var15 == 352) {
                           var13[var14] = -118;
                        } else if(var15 == 8249) {
                           var13[var14] = -117;
                        } else if(var15 == 338) {
                           var13[var14] = -116;
                        } else if(var15 == 381) {
                           var13[var14] = -114;
                        } else if(var15 == 8216) {
                           var13[var14] = -111;
                        } else if(var15 == 8217) {
                           var13[var14] = -110;
                        } else if(var15 == 8220) {
                           var13[var14] = -109;
                        } else if(var15 == 8221) {
                           var13[var14] = -108;
                        } else if(var15 == 8226) {
                           var13[var14] = -107;
                        } else if(var15 == 8211) {
                           var13[var14] = -106;
                        } else if(var15 == 8212) {
                           var13[var14] = -105;
                        } else if(var15 == 732) {
                           var13[var14] = -104;
                        } else if(var15 == 8482) {
                           var13[var14] = -103;
                        } else if(var15 == 353) {
                           var13[var14] = -102;
                        } else if(var15 == 8250) {
                           var13[var14] = -101;
                        } else if(var15 == 339) {
                           var13[var14] = -100;
                        } else if(var15 == 382) {
                           var13[var14] = -98;
                        } else if(var15 == 376) {
                           var13[var14] = -97;
                        } else {
                           var13[var14] = 63;
                        }
                     } else {
                        var13[var14] = (byte)var15;
                     }
                  }

                  var9.method3197(var13.length);
                  var9.offset += class265.field3655.method3124(var13, 0, var13.length, var9.payload, var9.offset);
                  Client.secretPacketBuffer1.method3364(Client.secretPacketBuffer1.offset - var21);
                  return 1;
               } else if(var0 == 5009) {
                  ChatMessages.scriptStringStackSize -= 2;
                  var3 = class83.scriptStringStack[ChatMessages.scriptStringStackSize];
                  String var33 = class83.scriptStringStack[ChatMessages.scriptStringStackSize + 1];
                  Client.secretPacketBuffer1.putOpcode(143);
                  Client.secretPacketBuffer1.putShort(0);
                  var20 = Client.secretPacketBuffer1.offset;
                  Client.secretPacketBuffer1.method3191(var3);
                  PacketBuffer var16 = Client.secretPacketBuffer1;
                  var7 = var16.offset;
                  int var24 = var33.length();
                  byte[] var10 = new byte[var24];

                  for(int var11 = 0; var11 < var24; ++var11) {
                     char var12 = var33.charAt(var11);
                     if((var12 <= 0 || var12 >= 128) && (var12 < 160 || var12 > 255)) {
                        if(var12 == 8364) {
                           var10[var11] = -128;
                        } else if(var12 == 8218) {
                           var10[var11] = -126;
                        } else if(var12 == 402) {
                           var10[var11] = -125;
                        } else if(var12 == 8222) {
                           var10[var11] = -124;
                        } else if(var12 == 8230) {
                           var10[var11] = -123;
                        } else if(var12 == 8224) {
                           var10[var11] = -122;
                        } else if(var12 == 8225) {
                           var10[var11] = -121;
                        } else if(var12 == 710) {
                           var10[var11] = -120;
                        } else if(var12 == 8240) {
                           var10[var11] = -119;
                        } else if(var12 == 352) {
                           var10[var11] = -118;
                        } else if(var12 == 8249) {
                           var10[var11] = -117;
                        } else if(var12 == 338) {
                           var10[var11] = -116;
                        } else if(var12 == 381) {
                           var10[var11] = -114;
                        } else if(var12 == 8216) {
                           var10[var11] = -111;
                        } else if(var12 == 8217) {
                           var10[var11] = -110;
                        } else if(var12 == 8220) {
                           var10[var11] = -109;
                        } else if(var12 == 8221) {
                           var10[var11] = -108;
                        } else if(var12 == 8226) {
                           var10[var11] = -107;
                        } else if(var12 == 8211) {
                           var10[var11] = -106;
                        } else if(var12 == 8212) {
                           var10[var11] = -105;
                        } else if(var12 == 732) {
                           var10[var11] = -104;
                        } else if(var12 == 8482) {
                           var10[var11] = -103;
                        } else if(var12 == 353) {
                           var10[var11] = -102;
                        } else if(var12 == 8250) {
                           var10[var11] = -101;
                        } else if(var12 == 339) {
                           var10[var11] = -100;
                        } else if(var12 == 382) {
                           var10[var11] = -98;
                        } else if(var12 == 376) {
                           var10[var11] = -97;
                        } else {
                           var10[var11] = 63;
                        }
                     } else {
                        var10[var11] = (byte)var12;
                     }
                  }

                  var16.method3197(var10.length);
                  var16.offset += class265.field3655.method3124(var10, 0, var10.length, var16.payload, var16.offset);
                  Client.secretPacketBuffer1.method3195(Client.secretPacketBuffer1.offset - var20);
                  return 1;
               } else if(var0 != 5015) {
                  if(var0 == 5016) {
                     class83.intStack[++class83.intStackSize - 1] = Client.field1092;
                     return 1;
                  } else if(var0 == 5017) {
                     var18 = class83.intStack[--class83.intStackSize];
                     class83.intStack[++class83.intStackSize - 1] = class208.method3947(var18);
                     return 1;
                  } else {
                     int var6;
                     MessageNode var17;
                     int[] var19;
                     if(var0 == 5018) {
                        var18 = class83.intStack[--class83.intStackSize];
                        var19 = class83.intStack;
                        var20 = ++class83.intStackSize - 1;
                        var17 = (MessageNode)class98.field1519.method3559((long)var18);
                        if(var17 == null) {
                           var6 = -1;
                        } else if(class98.field1518.field2485 == var17.previous) {
                           var6 = -1;
                        } else {
                           var6 = ((MessageNode)var17.previous).id;
                        }

                        var19[var20] = var6;
                        return 1;
                     } else if(var0 == 5019) {
                        var18 = class83.intStack[--class83.intStackSize];
                        var19 = class83.intStack;
                        var20 = ++class83.intStackSize - 1;
                        var17 = (MessageNode)class98.field1519.method3559((long)var18);
                        if(var17 == null) {
                           var6 = -1;
                        } else if(class98.field1518.field2485 == var17.next) {
                           var6 = -1;
                        } else {
                           var6 = ((MessageNode)var17.next).id;
                        }

                        var19[var20] = var6;
                        return 1;
                     } else if(var0 == 5020) {
                        var3 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
                        class17.method126(var3);
                        return 1;
                     } else if(var0 == 5021) {
                        Client.field1108 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize].toLowerCase().trim();
                        return 1;
                     } else if(var0 == 5022) {
                        class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = Client.field1108;
                        return 1;
                     } else {
                        return 2;
                     }
                  }
               } else {
                  if(XGrandExchangeOffer.localPlayer != null && XGrandExchangeOffer.localPlayer.name != null) {
                     var3 = XGrandExchangeOffer.localPlayer.name;
                  } else {
                     var3 = "";
                  }

                  class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = var3;
                  return 1;
               }
            }
         }
      }
   }
}

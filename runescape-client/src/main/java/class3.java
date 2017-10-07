import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("p")
final class class3 implements class0 {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "[Lie;"
   )
   public static Area[] field24;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "236384688"
   )
   static int method10(int var0, Script var1, boolean var2) {
      if(var0 == 5000) {
         class81.intStack[++class81.intStackSize - 1] = Client.field1129;
         return 1;
      } else if(var0 == 5001) {
         class81.intStackSize -= 3;
         Client.field1129 = class81.intStack[class81.intStackSize];
         class39.field551 = class236.method4309(class81.intStack[class81.intStackSize + 1]);
         if(class39.field551 == null) {
            class39.field551 = class277.field3751;
         }

         Client.field1018 = class81.intStack[class81.intStackSize + 2];
         Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_CHATFILTER_UPDATE);
         if(Client.RUNELITE_PACKET) {
            Client.secretPacketBuffer1.runeliteWriteInt(Client.field1129);
            Client.secretPacketBuffer1.runeliteWriteInt(class39.field551.field3749);
            Client.secretPacketBuffer1.runeliteWriteInt(Client.field1018);
         } else {
            Client.secretPacketBuffer1.putByte(Client.field1129);
            Client.secretPacketBuffer1.putByte(class39.field551.field3749);
            Client.secretPacketBuffer1.putByte(Client.field1018);
         }

         return 1;
      } else {
         String var3;
         int var4;
         int var5;
         if(var0 == 5002) {
            var3 = class81.scriptStringStack[--class81.scriptStringStackSize];
            class81.intStackSize -= 2;
            var4 = class81.intStack[class81.intStackSize];
            var5 = class81.intStack[class81.intStackSize + 1];
            Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_REPORTED_PLAYER);
            Client.secretPacketBuffer1.putByte(class162.getLength(var3) + 2);
            Client.secretPacketBuffer1.putString(var3);
            Client.secretPacketBuffer1.putByte(var4 - 1);
            Client.secretPacketBuffer1.putByte(var5);
            return 1;
         } else {
            int var12;
            if(var0 == 5003) {
               class81.intStackSize -= 2;
               var12 = class81.intStack[class81.intStackSize];
               var4 = class81.intStack[class81.intStackSize + 1];
               ChatLineBuffer var18 = (ChatLineBuffer)class96.chatLineMap.get(Integer.valueOf(var12));
               MessageNode var20 = var18.method1940(var4);
               if(var20 != null) {
                  class81.intStack[++class81.intStackSize - 1] = var20.id;
                  class81.intStack[++class81.intStackSize - 1] = var20.tick;
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var20.name != null?var20.name:"";
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var20.sender != null?var20.sender:"";
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var20.value != null?var20.value:"";
               } else {
                  class81.intStack[++class81.intStackSize - 1] = -1;
                  class81.intStack[++class81.intStackSize - 1] = 0;
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 5004) {
               var12 = class81.intStack[--class81.intStackSize];
               MessageNode var22 = (MessageNode)class96.field1508.get((long)var12);
               if(var22 != null) {
                  class81.intStack[++class81.intStackSize - 1] = var22.type;
                  class81.intStack[++class81.intStackSize - 1] = var22.tick;
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var22.name != null?var22.name:"";
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var22.sender != null?var22.sender:"";
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var22.value != null?var22.value:"";
               } else {
                  class81.intStack[++class81.intStackSize - 1] = -1;
                  class81.intStack[++class81.intStackSize - 1] = 0;
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 5005) {
               if(class39.field551 == null) {
                  class81.intStack[++class81.intStackSize - 1] = -1;
               } else {
                  class81.intStack[++class81.intStackSize - 1] = class39.field551.field3749;
               }

               return 1;
            } else if(var0 == 5008) {
               var3 = class81.scriptStringStack[--class81.scriptStringStackSize];
               var4 = class81.intStack[--class81.intStackSize];
               String var13 = var3.toLowerCase();
               byte var23 = 0;
               if(var13.startsWith("yellow:")) {
                  var23 = 0;
                  var3 = var3.substring("yellow:".length());
               } else if(var13.startsWith("red:")) {
                  var23 = 1;
                  var3 = var3.substring("red:".length());
               } else if(var13.startsWith("green:")) {
                  var23 = 2;
                  var3 = var3.substring("green:".length());
               } else if(var13.startsWith("cyan:")) {
                  var23 = 3;
                  var3 = var3.substring("cyan:".length());
               } else if(var13.startsWith("purple:")) {
                  var23 = 4;
                  var3 = var3.substring("purple:".length());
               } else if(var13.startsWith("white:")) {
                  var23 = 5;
                  var3 = var3.substring("white:".length());
               } else if(var13.startsWith("flash1:")) {
                  var23 = 6;
                  var3 = var3.substring("flash1:".length());
               } else if(var13.startsWith("flash2:")) {
                  var23 = 7;
                  var3 = var3.substring("flash2:".length());
               } else if(var13.startsWith("flash3:")) {
                  var23 = 8;
                  var3 = var3.substring("flash3:".length());
               } else if(var13.startsWith("glow1:")) {
                  var23 = 9;
                  var3 = var3.substring("glow1:".length());
               } else if(var13.startsWith("glow2:")) {
                  var23 = 10;
                  var3 = var3.substring("glow2:".length());
               } else if(var13.startsWith("glow3:")) {
                  var23 = 11;
                  var3 = var3.substring("glow3:".length());
               } else if(Client.languageId != 0) {
                  if(var13.startsWith("yellow:")) {
                     var23 = 0;
                     var3 = var3.substring("yellow:".length());
                  } else if(var13.startsWith("red:")) {
                     var23 = 1;
                     var3 = var3.substring("red:".length());
                  } else if(var13.startsWith("green:")) {
                     var23 = 2;
                     var3 = var3.substring("green:".length());
                  } else if(var13.startsWith("cyan:")) {
                     var23 = 3;
                     var3 = var3.substring("cyan:".length());
                  } else if(var13.startsWith("purple:")) {
                     var23 = 4;
                     var3 = var3.substring("purple:".length());
                  } else if(var13.startsWith("white:")) {
                     var23 = 5;
                     var3 = var3.substring("white:".length());
                  } else if(var13.startsWith("flash1:")) {
                     var23 = 6;
                     var3 = var3.substring("flash1:".length());
                  } else if(var13.startsWith("flash2:")) {
                     var23 = 7;
                     var3 = var3.substring("flash2:".length());
                  } else if(var13.startsWith("flash3:")) {
                     var23 = 8;
                     var3 = var3.substring("flash3:".length());
                  } else if(var13.startsWith("glow1:")) {
                     var23 = 9;
                     var3 = var3.substring("glow1:".length());
                  } else if(var13.startsWith("glow2:")) {
                     var23 = 10;
                     var3 = var3.substring("glow2:".length());
                  } else if(var13.startsWith("glow3:")) {
                     var23 = 11;
                     var3 = var3.substring("glow3:".length());
                  }
               }

               var13 = var3.toLowerCase();
               byte var19 = 0;
               if(var13.startsWith("wave:")) {
                  var19 = 1;
                  var3 = var3.substring("wave:".length());
               } else if(var13.startsWith("wave2:")) {
                  var19 = 2;
                  var3 = var3.substring("wave2:".length());
               } else if(var13.startsWith("shake:")) {
                  var19 = 3;
                  var3 = var3.substring("shake:".length());
               } else if(var13.startsWith("scroll:")) {
                  var19 = 4;
                  var3 = var3.substring("scroll:".length());
               } else if(var13.startsWith("slide:")) {
                  var19 = 5;
                  var3 = var3.substring("slide:".length());
               } else if(Client.languageId != 0) {
                  if(var13.startsWith("wave:")) {
                     var19 = 1;
                     var3 = var3.substring("wave:".length());
                  } else if(var13.startsWith("wave2:")) {
                     var19 = 2;
                     var3 = var3.substring("wave2:".length());
                  } else if(var13.startsWith("shake:")) {
                     var19 = 3;
                     var3 = var3.substring("shake:".length());
                  } else if(var13.startsWith("scroll:")) {
                     var19 = 4;
                     var3 = var3.substring("scroll:".length());
                  } else if(var13.startsWith("slide:")) {
                     var19 = 5;
                     var3 = var3.substring("slide:".length());
                  }
               }

               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_CHATBOX_INPUT);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(0);
               } else {
                  Client.secretPacketBuffer1.putByte(0);
               }

               int var8 = Client.secretPacketBuffer1.offset;
               Client.secretPacketBuffer1.putByte(var4);
               Client.secretPacketBuffer1.putByte(var23);
               Client.secretPacketBuffer1.putByte(var19);
               PacketBuffer var9 = Client.secretPacketBuffer1;
               int var10 = var9.offset;
               byte[] var11 = MouseInput.method1060(var3);
               var9.putShortSmart(var11.length);
               var9.offset += class265.field3664.compress(var11, 0, var11.length, var9.payload, var9.offset);
               Client.secretPacketBuffer1.putLength(Client.secretPacketBuffer1.offset - var8);
               return 1;
            } else if(var0 == 5009) {
               class81.scriptStringStackSize -= 2;
               var3 = class81.scriptStringStack[class81.scriptStringStackSize];
               String var21 = class81.scriptStringStack[class81.scriptStringStackSize + 1];
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_PRIVMSG);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(0);
               } else {
                  Client.secretPacketBuffer1.putShort(0);
               }

               var5 = Client.secretPacketBuffer1.offset;
               Client.secretPacketBuffer1.putString(var3);
               PacketBuffer var6 = Client.secretPacketBuffer1;
               int var7 = var6.offset;
               byte[] var16 = MouseInput.method1060(var21);
               var6.putShortSmart(var16.length);
               var6.offset += class265.field3664.compress(var16, 0, var16.length, var6.payload, var6.offset);
               Client.secretPacketBuffer1.putShortLength(Client.secretPacketBuffer1.offset - var5);
               return 1;
            } else if(var0 != 5015) {
               if(var0 == 5016) {
                  class81.intStack[++class81.intStackSize - 1] = Client.field1018;
                  return 1;
               } else {
                  int[] var14;
                  int var15;
                  if(var0 == 5017) {
                     var12 = class81.intStack[--class81.intStackSize];
                     var14 = class81.intStack;
                     var5 = ++class81.intStackSize - 1;
                     ChatLineBuffer var24 = (ChatLineBuffer)class96.chatLineMap.get(Integer.valueOf(var12));
                     if(var24 == null) {
                        var15 = 0;
                     } else {
                        var15 = var24.method1938();
                     }

                     var14[var5] = var15;
                     return 1;
                  } else if(var0 == 5018) {
                     var12 = class81.intStack[--class81.intStackSize];
                     var14 = class81.intStack;
                     var5 = ++class81.intStackSize - 1;
                     MessageNode var17 = (MessageNode)class96.field1508.get((long)var12);
                     if(var17 == null) {
                        var15 = -1;
                     } else if(var17.previous == class96.field1509.field2504) {
                        var15 = -1;
                     } else {
                        var15 = ((MessageNode)var17.previous).id;
                     }

                     var14[var5] = var15;
                     return 1;
                  } else if(var0 == 5019) {
                     var12 = class81.intStack[--class81.intStackSize];
                     class81.intStack[++class81.intStackSize - 1] = BaseVarType.method14(var12);
                     return 1;
                  } else if(var0 == 5020) {
                     var3 = class81.scriptStringStack[--class81.scriptStringStackSize];
                     class211.method4049(var3);
                     return 1;
                  } else if(var0 == 5021) {
                     Client.field1131 = class81.scriptStringStack[--class81.scriptStringStackSize].toLowerCase().trim();
                     return 1;
                  } else if(var0 == 5022) {
                     class81.scriptStringStack[++class81.scriptStringStackSize - 1] = Client.field1131;
                     return 1;
                  } else {
                     return 2;
                  }
               }
            } else {
               if(AbstractByteBuffer.localPlayer != null && AbstractByteBuffer.localPlayer.name != null) {
                  var3 = AbstractByteBuffer.localPlayer.name;
               } else {
                  var3 = "";
               }

               class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var3;
               return 1;
            }
         }
      }
   }
}

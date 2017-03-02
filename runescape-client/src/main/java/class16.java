import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class16 extends class131 {
   @ObfuscatedName("i")
   short field166;
   @ObfuscatedName("l")
   String field167;
   @ObfuscatedName("ne")
   static class51 field168;
   @ObfuscatedName("cx")
   static Font field170;
   @ObfuscatedName("ec")
   static SpritePixels field171;
   @ObfuscatedName("aq")
   static ModIcon[] field172;
   @ObfuscatedName("s")
   static int[] field175;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 188313643
   )
   int field176 = (int)(ChatMessages.method935() / 1000L);
   @ObfuscatedName("eq")
   static SpritePixels[] field177;

   @ObfuscatedName("ev")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "-659837974"
   )
   static final void method194(String var0, int var1) {
      Client.field327.method3124(203);
      Client.field327.method3010(class25.method615(var0) + 1);
      Client.field327.method2893(var0);
      Client.field327.method2880(var1);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILScript;ZS)I",
      garbageValue = "255"
   )
   static int method195(int var0, Script var1, boolean var2) {
      if(var0 == 5000) {
         class32.field729[++class101.field1648 - 1] = Client.field452;
         return 1;
      } else {
         int var4;
         if(var0 == 5001) {
            class101.field1648 -= 3;
            Client.field452 = class32.field729[class101.field1648];
            var4 = class32.field729[1 + class101.field1648];
            class216[] var23 = class99.method2001();
            int var24 = 0;

            class216 var25;
            while(true) {
               if(var24 >= var23.length) {
                  var25 = null;
                  break;
               }

               class216 var7 = var23[var24];
               if(var4 == var7.field3177) {
                  var25 = var7;
                  break;
               }

               ++var24;
            }

            class13.field141 = var25;
            if(null == class13.field141) {
               class13.field141 = class216.field3176;
            }

            Client.field381 = class32.field729[class101.field1648 + 2];
            Client.field327.method3124(151);
            Client.field327.method3010(Client.field452);
            Client.field327.method3010(class13.field141.field3177);
            Client.field327.method3010(Client.field381);
            return 1;
         } else {
            String var3;
            int var17;
            if(var0 == 5002) {
               var3 = class32.scriptStringStack[--World.scriptStringStackSize];
               class101.field1648 -= 2;
               var4 = class32.field729[class101.field1648];
               var17 = class32.field729[class101.field1648 + 1];
               Client.field327.method3124(95);
               Client.field327.method3010(class25.method615(var3) + 2);
               Client.field327.method2893(var3);
               Client.field327.method3010(var4 - 1);
               Client.field327.method3010(var17);
               return 1;
            } else {
               int var18;
               if(var0 == 5003) {
                  class101.field1648 -= 2;
                  var18 = class32.field729[class101.field1648];
                  var4 = class32.field729[class101.field1648 + 1];
                  ChatLineBuffer var16 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var18));
                  MessageNode var22 = var16.method975(var4);
                  if(var22 != null) {
                     class32.field729[++class101.field1648 - 1] = var22.id;
                     class32.field729[++class101.field1648 - 1] = var22.tick;
                     class32.scriptStringStack[++World.scriptStringStackSize - 1] = var22.name != null?var22.name:"";
                     class32.scriptStringStack[++World.scriptStringStackSize - 1] = var22.sender != null?var22.sender:"";
                     class32.scriptStringStack[++World.scriptStringStackSize - 1] = var22.value != null?var22.value:"";
                  } else {
                     class32.field729[++class101.field1648 - 1] = -1;
                     class32.field729[++class101.field1648 - 1] = 0;
                     class32.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                     class32.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                     class32.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 5004) {
                  var18 = class32.field729[--class101.field1648];
                  MessageNode var26 = (MessageNode)class47.field924.method2386((long)var18);
                  if(null != var26) {
                     class32.field729[++class101.field1648 - 1] = var26.type;
                     class32.field729[++class101.field1648 - 1] = var26.tick;
                     class32.scriptStringStack[++World.scriptStringStackSize - 1] = null != var26.name?var26.name:"";
                     class32.scriptStringStack[++World.scriptStringStackSize - 1] = var26.sender != null?var26.sender:"";
                     class32.scriptStringStack[++World.scriptStringStackSize - 1] = var26.value != null?var26.value:"";
                  } else {
                     class32.field729[++class101.field1648 - 1] = -1;
                     class32.field729[++class101.field1648 - 1] = 0;
                     class32.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                     class32.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                     class32.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 5005) {
                  if(class13.field141 == null) {
                     class32.field729[++class101.field1648 - 1] = -1;
                  } else {
                     class32.field729[++class101.field1648 - 1] = class13.field141.field3177;
                  }

                  return 1;
               } else if(var0 == 5008) {
                  var3 = class32.scriptStringStack[--World.scriptStringStackSize];
                  var4 = class32.field729[--class101.field1648];
                  String var5 = var3.toLowerCase();
                  byte var6 = 0;
                  if(var5.startsWith("yellow:")) {
                     var6 = 0;
                     var3 = var3.substring("yellow:".length());
                  } else if(var5.startsWith("red:")) {
                     var6 = 1;
                     var3 = var3.substring("red:".length());
                  } else if(var5.startsWith("green:")) {
                     var6 = 2;
                     var3 = var3.substring("green:".length());
                  } else if(var5.startsWith("cyan:")) {
                     var6 = 3;
                     var3 = var3.substring("cyan:".length());
                  } else if(var5.startsWith("purple:")) {
                     var6 = 4;
                     var3 = var3.substring("purple:".length());
                  } else if(var5.startsWith("white:")) {
                     var6 = 5;
                     var3 = var3.substring("white:".length());
                  } else if(var5.startsWith("flash1:")) {
                     var6 = 6;
                     var3 = var3.substring("flash1:".length());
                  } else if(var5.startsWith("flash2:")) {
                     var6 = 7;
                     var3 = var3.substring("flash2:".length());
                  } else if(var5.startsWith("flash3:")) {
                     var6 = 8;
                     var3 = var3.substring("flash3:".length());
                  } else if(var5.startsWith("glow1:")) {
                     var6 = 9;
                     var3 = var3.substring("glow1:".length());
                  } else if(var5.startsWith("glow2:")) {
                     var6 = 10;
                     var3 = var3.substring("glow2:".length());
                  } else if(var5.startsWith("glow3:")) {
                     var6 = 11;
                     var3 = var3.substring("glow3:".length());
                  } else if(Client.field289 != 0) {
                     if(var5.startsWith("yellow:")) {
                        var6 = 0;
                        var3 = var3.substring("yellow:".length());
                     } else if(var5.startsWith("red:")) {
                        var6 = 1;
                        var3 = var3.substring("red:".length());
                     } else if(var5.startsWith("green:")) {
                        var6 = 2;
                        var3 = var3.substring("green:".length());
                     } else if(var5.startsWith("cyan:")) {
                        var6 = 3;
                        var3 = var3.substring("cyan:".length());
                     } else if(var5.startsWith("purple:")) {
                        var6 = 4;
                        var3 = var3.substring("purple:".length());
                     } else if(var5.startsWith("white:")) {
                        var6 = 5;
                        var3 = var3.substring("white:".length());
                     } else if(var5.startsWith("flash1:")) {
                        var6 = 6;
                        var3 = var3.substring("flash1:".length());
                     } else if(var5.startsWith("flash2:")) {
                        var6 = 7;
                        var3 = var3.substring("flash2:".length());
                     } else if(var5.startsWith("flash3:")) {
                        var6 = 8;
                        var3 = var3.substring("flash3:".length());
                     } else if(var5.startsWith("glow1:")) {
                        var6 = 9;
                        var3 = var3.substring("glow1:".length());
                     } else if(var5.startsWith("glow2:")) {
                        var6 = 10;
                        var3 = var3.substring("glow2:".length());
                     } else if(var5.startsWith("glow3:")) {
                        var6 = 11;
                        var3 = var3.substring("glow3:".length());
                     }
                  }

                  var5 = var3.toLowerCase();
                  byte var20 = 0;
                  if(var5.startsWith("wave:")) {
                     var20 = 1;
                     var3 = var3.substring("wave:".length());
                  } else if(var5.startsWith("wave2:")) {
                     var20 = 2;
                     var3 = var3.substring("wave2:".length());
                  } else if(var5.startsWith("shake:")) {
                     var20 = 3;
                     var3 = var3.substring("shake:".length());
                  } else if(var5.startsWith("scroll:")) {
                     var20 = 4;
                     var3 = var3.substring("scroll:".length());
                  } else if(var5.startsWith("slide:")) {
                     var20 = 5;
                     var3 = var3.substring("slide:".length());
                  } else if(Client.field289 != 0) {
                     if(var5.startsWith("wave:")) {
                        var20 = 1;
                        var3 = var3.substring("wave:".length());
                     } else if(var5.startsWith("wave2:")) {
                        var20 = 2;
                        var3 = var3.substring("wave2:".length());
                     } else if(var5.startsWith("shake:")) {
                        var20 = 3;
                        var3 = var3.substring("shake:".length());
                     } else if(var5.startsWith("scroll:")) {
                        var20 = 4;
                        var3 = var3.substring("scroll:".length());
                     } else if(var5.startsWith("slide:")) {
                        var20 = 5;
                        var3 = var3.substring("slide:".length());
                     }
                  }

                  Client.field327.method3124(82);
                  Client.field327.method3010(0);
                  int var8 = Client.field327.offset;
                  Client.field327.method3010(var4);
                  Client.field327.method3010(var6);
                  Client.field327.method3010(var20);
                  class159 var9 = Client.field327;
                  int var10 = var9.offset;
                  int var21 = var3.length();
                  byte[] var13 = new byte[var21];

                  for(int var14 = 0; var14 < var21; ++var14) {
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

                  var9.method2854(var13.length);
                  var9.offset += class210.field3120.method2775(var13, 0, var13.length, var9.payload, var9.offset);
                  Client.field327.method2853(Client.field327.offset - var8);
                  return 1;
               } else if(var0 == 5009) {
                  World.scriptStringStackSize -= 2;
                  var3 = class32.scriptStringStack[World.scriptStringStackSize];
                  String var19 = class32.scriptStringStack[World.scriptStringStackSize + 1];
                  Client.field327.method3124(88);
                  Client.field327.method2842(0);
                  var17 = Client.field327.offset;
                  Client.field327.method2893(var3);
                  class150.method2832(Client.field327, var19);
                  Client.field327.method2852(Client.field327.offset - var17);
                  return 1;
               } else if(var0 != 5015) {
                  if(var0 == 5016) {
                     class32.field729[++class101.field1648 - 1] = Client.field381;
                     return 1;
                  } else if(var0 == 5017) {
                     var18 = class32.field729[--class101.field1648];
                     class32.field729[++class101.field1648 - 1] = method196(var18);
                     return 1;
                  } else if(var0 == 5018) {
                     var18 = class32.field729[--class101.field1648];
                     class32.field729[++class101.field1648 - 1] = class41.method851(var18);
                     return 1;
                  } else if(var0 == 5019) {
                     var18 = class32.field729[--class101.field1648];
                     class32.field729[++class101.field1648 - 1] = RSCanvas.method2142(var18);
                     return 1;
                  } else if(var0 == 5020) {
                     var3 = class32.scriptStringStack[--World.scriptStringStackSize];
                     class5.method85(var3);
                     return 1;
                  } else if(var0 == 5021) {
                     Client.field502 = class32.scriptStringStack[--World.scriptStringStackSize].toLowerCase().trim();
                     return 1;
                  } else if(var0 == 5022) {
                     class32.scriptStringStack[++World.scriptStringStackSize - 1] = Client.field502;
                     return 1;
                  } else {
                     return 2;
                  }
               } else {
                  if(class9.localPlayer != null && null != class9.localPlayer.name) {
                     var3 = class9.localPlayer.name;
                  } else {
                     var3 = "";
                  }

                  class32.scriptStringStack[++World.scriptStringStackSize - 1] = var3;
                  return 1;
               }
            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "0"
   )
   static int method196(int var0) {
      ChatLineBuffer var1 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var0));
      return var1 == null?0:var1.method976();
   }

   class16(String var1, int var2) {
      this.field167 = var1;
      this.field166 = (short)var2;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-802625152"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(null == class60.worldServersDownload) {
            class60.worldServersDownload = new class26(class25.field579, new URL(Frames.field1567));
         } else {
            byte[] var0 = class60.worldServersDownload.method618();
            if(null != var0) {
               Buffer var1 = new Buffer(var0);
               World.field676 = var1.readUnsignedShort();
               World.worldList = new World[World.field676];

               World var3;
               for(int var2 = 0; var2 < World.field676; var3.index = var2++) {
                  var3 = World.worldList[var2] = new World();
                  var3.id = var1.readUnsignedShort();
                  var3.mask = var1.readInt();
                  var3.address = var1.readString();
                  var3.activity = var1.readString();
                  var3.location = var1.readUnsignedByte();
                  var3.playerCount = var1.readShort();
               }

               class0.method11(World.worldList, 0, World.worldList.length - 1, World.field677, World.field678);
               class60.worldServersDownload = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class60.worldServersDownload = null;
      }

      return false;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1785399147"
   )
   public static void method198() {
      KitDefinition.field2825.reset();
   }
}

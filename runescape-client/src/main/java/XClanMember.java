import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
@Implements("XClanMember")
public class XClanMember extends Node {
   @ObfuscatedName("n")
   String field912;
   @ObfuscatedName("e")
   @Export("username")
   String username;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 207816013
   )
   @Export("world")
   int world;
   @ObfuscatedName("y")
   @Export("rank")
   byte rank;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)[Lhm;",
      garbageValue = "-155368743"
   )
   public static class233[] method1176() {
      return new class233[]{class233.field3182, class233.field3173, class233.field3174, class233.field3180, class233.field3176, class233.field3177};
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILcc;ZI)I",
      garbageValue = "53098980"
   )
   static int method1175(int var0, Script var1, boolean var2) {
      if(var0 == 5000) {
         class84.intStack[++class84.intStackSize - 1] = Client.field1119;
         return 1;
      } else if(var0 == 5001) {
         class84.intStackSize -= 3;
         Client.field1119 = class84.intStack[class84.intStackSize];
         class54.field653 = class171.method3153(class84.intStack[class84.intStackSize + 1]);
         if(class54.field653 == null) {
            class54.field653 = class277.field3713;
         }

         Client.field1127 = class84.intStack[class84.intStackSize + 2];
         Client.secretPacketBuffer1.putOpcode(97);
         Client.secretPacketBuffer1.putByte(Client.field1119);
         Client.secretPacketBuffer1.putByte(class54.field653.field3714);
         Client.secretPacketBuffer1.putByte(Client.field1127);
         return 1;
      } else {
         String var3;
         int var4;
         int var5;
         if(var0 == 5002) {
            var3 = class84.scriptStringStack[--class84.scriptStringStackSize];
            class84.intStackSize -= 2;
            var4 = class84.intStack[class84.intStackSize];
            var5 = class84.intStack[class84.intStackSize + 1];
            Client.secretPacketBuffer1.putOpcode(6);
            Client.secretPacketBuffer1.putByte(class45.getLength(var3) + 2);
            Client.secretPacketBuffer1.putString(var3);
            Client.secretPacketBuffer1.putByte(var4 - 1);
            Client.secretPacketBuffer1.putByte(var5);
            return 1;
         } else {
            int var16;
            if(var0 == 5003) {
               class84.intStackSize -= 2;
               var16 = class84.intStack[class84.intStackSize];
               var4 = class84.intStack[class84.intStackSize + 1];
               MessageNode var29 = class23.method173(var16, var4);
               if(var29 != null) {
                  class84.intStack[++class84.intStackSize - 1] = var29.id;
                  class84.intStack[++class84.intStackSize - 1] = var29.tick;
                  class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var29.name != null?var29.name:"";
                  class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var29.sender != null?var29.sender:"";
                  class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var29.value != null?var29.value:"";
               } else {
                  class84.intStack[++class84.intStackSize - 1] = -1;
                  class84.intStack[++class84.intStackSize - 1] = 0;
                  class84.scriptStringStack[++class84.scriptStringStackSize - 1] = "";
                  class84.scriptStringStack[++class84.scriptStringStackSize - 1] = "";
                  class84.scriptStringStack[++class84.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 5004) {
               var16 = class84.intStack[--class84.intStackSize];
               MessageNode var31 = WallObject.method2908(var16);
               if(var31 != null) {
                  class84.intStack[++class84.intStackSize - 1] = var31.type;
                  class84.intStack[++class84.intStackSize - 1] = var31.tick;
                  class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var31.name != null?var31.name:"";
                  class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var31.sender != null?var31.sender:"";
                  class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var31.value != null?var31.value:"";
               } else {
                  class84.intStack[++class84.intStackSize - 1] = -1;
                  class84.intStack[++class84.intStackSize - 1] = 0;
                  class84.scriptStringStack[++class84.scriptStringStackSize - 1] = "";
                  class84.scriptStringStack[++class84.scriptStringStackSize - 1] = "";
                  class84.scriptStringStack[++class84.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 5005) {
               if(class54.field653 == null) {
                  class84.intStack[++class84.intStackSize - 1] = -1;
               } else {
                  class84.intStack[++class84.intStackSize - 1] = class54.field653.field3714;
               }

               return 1;
            } else if(var0 == 5008) {
               var3 = class84.scriptStringStack[--class84.scriptStringStackSize];
               var4 = class84.intStack[--class84.intStackSize];
               String var17 = var3.toLowerCase();
               byte var27 = 0;
               if(var17.startsWith("yellow:")) {
                  var27 = 0;
                  var3 = var3.substring("yellow:".length());
               } else if(var17.startsWith("red:")) {
                  var27 = 1;
                  var3 = var3.substring("red:".length());
               } else if(var17.startsWith("green:")) {
                  var27 = 2;
                  var3 = var3.substring("green:".length());
               } else if(var17.startsWith("cyan:")) {
                  var27 = 3;
                  var3 = var3.substring("cyan:".length());
               } else if(var17.startsWith("purple:")) {
                  var27 = 4;
                  var3 = var3.substring("purple:".length());
               } else if(var17.startsWith("white:")) {
                  var27 = 5;
                  var3 = var3.substring("white:".length());
               } else if(var17.startsWith("flash1:")) {
                  var27 = 6;
                  var3 = var3.substring("flash1:".length());
               } else if(var17.startsWith("flash2:")) {
                  var27 = 7;
                  var3 = var3.substring("flash2:".length());
               } else if(var17.startsWith("flash3:")) {
                  var27 = 8;
                  var3 = var3.substring("flash3:".length());
               } else if(var17.startsWith("glow1:")) {
                  var27 = 9;
                  var3 = var3.substring("glow1:".length());
               } else if(var17.startsWith("glow2:")) {
                  var27 = 10;
                  var3 = var3.substring("glow2:".length());
               } else if(var17.startsWith("glow3:")) {
                  var27 = 11;
                  var3 = var3.substring("glow3:".length());
               } else if(Client.languageId != 0) {
                  if(var17.startsWith("yellow:")) {
                     var27 = 0;
                     var3 = var3.substring("yellow:".length());
                  } else if(var17.startsWith("red:")) {
                     var27 = 1;
                     var3 = var3.substring("red:".length());
                  } else if(var17.startsWith("green:")) {
                     var27 = 2;
                     var3 = var3.substring("green:".length());
                  } else if(var17.startsWith("cyan:")) {
                     var27 = 3;
                     var3 = var3.substring("cyan:".length());
                  } else if(var17.startsWith("purple:")) {
                     var27 = 4;
                     var3 = var3.substring("purple:".length());
                  } else if(var17.startsWith("white:")) {
                     var27 = 5;
                     var3 = var3.substring("white:".length());
                  } else if(var17.startsWith("flash1:")) {
                     var27 = 6;
                     var3 = var3.substring("flash1:".length());
                  } else if(var17.startsWith("flash2:")) {
                     var27 = 7;
                     var3 = var3.substring("flash2:".length());
                  } else if(var17.startsWith("flash3:")) {
                     var27 = 8;
                     var3 = var3.substring("flash3:".length());
                  } else if(var17.startsWith("glow1:")) {
                     var27 = 9;
                     var3 = var3.substring("glow1:".length());
                  } else if(var17.startsWith("glow2:")) {
                     var27 = 10;
                     var3 = var3.substring("glow2:".length());
                  } else if(var17.startsWith("glow3:")) {
                     var27 = 11;
                     var3 = var3.substring("glow3:".length());
                  }
               }

               var17 = var3.toLowerCase();
               byte var26 = 0;
               if(var17.startsWith("wave:")) {
                  var26 = 1;
                  var3 = var3.substring("wave:".length());
               } else if(var17.startsWith("wave2:")) {
                  var26 = 2;
                  var3 = var3.substring("wave2:".length());
               } else if(var17.startsWith("shake:")) {
                  var26 = 3;
                  var3 = var3.substring("shake:".length());
               } else if(var17.startsWith("scroll:")) {
                  var26 = 4;
                  var3 = var3.substring("scroll:".length());
               } else if(var17.startsWith("slide:")) {
                  var26 = 5;
                  var3 = var3.substring("slide:".length());
               } else if(Client.languageId != 0) {
                  if(var17.startsWith("wave:")) {
                     var26 = 1;
                     var3 = var3.substring("wave:".length());
                  } else if(var17.startsWith("wave2:")) {
                     var26 = 2;
                     var3 = var3.substring("wave2:".length());
                  } else if(var17.startsWith("shake:")) {
                     var26 = 3;
                     var3 = var3.substring("shake:".length());
                  } else if(var17.startsWith("scroll:")) {
                     var26 = 4;
                     var3 = var3.substring("scroll:".length());
                  } else if(var17.startsWith("slide:")) {
                     var26 = 5;
                     var3 = var3.substring("slide:".length());
                  }
               }

               Client.secretPacketBuffer1.putOpcode(54);
               Client.secretPacketBuffer1.putByte(0);
               int var8 = Client.secretPacketBuffer1.offset;
               Client.secretPacketBuffer1.putByte(var4);
               Client.secretPacketBuffer1.putByte(var27);
               Client.secretPacketBuffer1.putByte(var26);
               PacketBuffer var9 = Client.secretPacketBuffer1;
               int var10 = var9.offset;
               int var28 = var3.length();
               byte[] var13 = new byte[var28];

               for(int var14 = 0; var14 < var28; ++var14) {
                  char var15 = var3.charAt(var14);
                  if(var15 > 0 && var15 < 128 || var15 >= 160 && var15 <= 255) {
                     var13[var14] = (byte)var15;
                  } else if(var15 == 8364) {
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
               }

               var9.putShortSmart(var13.length);
               var9.offset += class12.field274.compress(var13, 0, var13.length, var9.payload, var9.offset);
               Client.secretPacketBuffer1.putLength(Client.secretPacketBuffer1.offset - var8);
               return 1;
            } else if(var0 == 5009) {
               class84.scriptStringStackSize -= 2;
               var3 = class84.scriptStringStack[class84.scriptStringStackSize];
               String var30 = class84.scriptStringStack[class84.scriptStringStackSize + 1];
               Client.secretPacketBuffer1.putOpcode(50);
               Client.secretPacketBuffer1.putShort(0);
               var5 = Client.secretPacketBuffer1.offset;
               Client.secretPacketBuffer1.putString(var3);
               PacketBuffer var19 = Client.secretPacketBuffer1;
               int var7 = var19.offset;
               int var20 = var30.length();
               byte[] var21 = new byte[var20];

               for(int var11 = 0; var11 < var20; ++var11) {
                  char var12 = var30.charAt(var11);
                  if((var12 <= 0 || var12 >= 128) && (var12 < 160 || var12 > 255)) {
                     if(var12 == 8364) {
                        var21[var11] = -128;
                     } else if(var12 == 8218) {
                        var21[var11] = -126;
                     } else if(var12 == 402) {
                        var21[var11] = -125;
                     } else if(var12 == 8222) {
                        var21[var11] = -124;
                     } else if(var12 == 8230) {
                        var21[var11] = -123;
                     } else if(var12 == 8224) {
                        var21[var11] = -122;
                     } else if(var12 == 8225) {
                        var21[var11] = -121;
                     } else if(var12 == 710) {
                        var21[var11] = -120;
                     } else if(var12 == 8240) {
                        var21[var11] = -119;
                     } else if(var12 == 352) {
                        var21[var11] = -118;
                     } else if(var12 == 8249) {
                        var21[var11] = -117;
                     } else if(var12 == 338) {
                        var21[var11] = -116;
                     } else if(var12 == 381) {
                        var21[var11] = -114;
                     } else if(var12 == 8216) {
                        var21[var11] = -111;
                     } else if(var12 == 8217) {
                        var21[var11] = -110;
                     } else if(var12 == 8220) {
                        var21[var11] = -109;
                     } else if(var12 == 8221) {
                        var21[var11] = -108;
                     } else if(var12 == 8226) {
                        var21[var11] = -107;
                     } else if(var12 == 8211) {
                        var21[var11] = -106;
                     } else if(var12 == 8212) {
                        var21[var11] = -105;
                     } else if(var12 == 732) {
                        var21[var11] = -104;
                     } else if(var12 == 8482) {
                        var21[var11] = -103;
                     } else if(var12 == 353) {
                        var21[var11] = -102;
                     } else if(var12 == 8250) {
                        var21[var11] = -101;
                     } else if(var12 == 339) {
                        var21[var11] = -100;
                     } else if(var12 == 382) {
                        var21[var11] = -98;
                     } else if(var12 == 376) {
                        var21[var11] = -97;
                     } else {
                        var21[var11] = 63;
                     }
                  } else {
                     var21[var11] = (byte)var12;
                  }
               }

               var19.putShortSmart(var21.length);
               var19.offset += class12.field274.compress(var21, 0, var21.length, var19.payload, var19.offset);
               Client.secretPacketBuffer1.putShortLength(Client.secretPacketBuffer1.offset - var5);
               return 1;
            } else if(var0 != 5015) {
               if(var0 == 5016) {
                  class84.intStack[++class84.intStackSize - 1] = Client.field1127;
                  return 1;
               } else if(var0 == 5017) {
                  var16 = class84.intStack[--class84.intStackSize];
                  class84.intStack[++class84.intStackSize - 1] = class83.method1621(var16);
                  return 1;
               } else {
                  int var6;
                  int[] var18;
                  MessageNode var25;
                  if(var0 == 5018) {
                     var16 = class84.intStack[--class84.intStackSize];
                     var18 = class84.intStack;
                     var5 = ++class84.intStackSize - 1;
                     var25 = (MessageNode)class99.field1516.get((long)var16);
                     if(var25 == null) {
                        var6 = -1;
                     } else if(var25.previous == class99.field1520.field2470) {
                        var6 = -1;
                     } else {
                        var6 = ((MessageNode)var25.previous).id;
                     }

                     var18[var5] = var6;
                     return 1;
                  } else if(var0 == 5019) {
                     var16 = class84.intStack[--class84.intStackSize];
                     var18 = class84.intStack;
                     var5 = ++class84.intStackSize - 1;
                     var25 = (MessageNode)class99.field1516.get((long)var16);
                     if(var25 == null) {
                        var6 = -1;
                     } else if(var25.next == class99.field1520.field2470) {
                        var6 = -1;
                     } else {
                        var6 = ((MessageNode)var25.next).id;
                     }

                     var18[var5] = var6;
                     return 1;
                  } else if(var0 == 5020) {
                     var3 = class84.scriptStringStack[--class84.scriptStringStackSize];
                     class64.method1085(var3);
                     return 1;
                  } else if(var0 == 5021) {
                     Client.field1121 = class84.scriptStringStack[--class84.scriptStringStackSize].toLowerCase().trim();
                     return 1;
                  } else if(var0 == 5022) {
                     class84.scriptStringStack[++class84.scriptStringStackSize - 1] = Client.field1121;
                     return 1;
                  } else {
                     return 2;
                  }
               }
            } else {
               if(class54.localPlayer != null && class54.localPlayer.name != null) {
                  var3 = class54.localPlayer.name;
               } else {
                  var3 = "";
               }

               class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var3;
               return 1;
            }
         }
      }
   }
}

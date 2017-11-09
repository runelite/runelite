import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
public final class class8 extends class9 {
   @ObfuscatedName("py")
   @ObfuscatedGetter(
      intValue = 545455805
   )
   static int field238;
   @ObfuscatedName("e")
   @Export("validInterfaces")
   public static boolean[] validInterfaces;
   @ObfuscatedName("fk")
   @ObfuscatedSignature(
      signature = "[Lkd;"
   )
   @Export("mapDots")
   static SpritePixels[] mapDots;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -705238501
   )
   final int field245;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1699017125
   )
   final int field236;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 122143773
   )
   final int field237;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1528766365
   )
   final int field235;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1672810113
   )
   final int field239;

   class8(int var1, int var2, int var3, int var4, int var5) {
      this.field245 = var1;
      this.field236 = var2;
      this.field237 = var3;
      this.field235 = var4;
      this.field239 = var5;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2102608092"
   )
   final void vmethod54() {
      Rasterizer2D.drawRectangle(this.field245 + Rasterizer2D.draw_region_x, this.field236 + Rasterizer2D.drawingAreaTop, this.field237 - this.field245, this.field235 - this.field236, this.field239);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-935319032"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(class72.listFetcher == null) {
            class72.listFetcher = BuildType.field3253.method3006(new URL(class72.field824));
         } else if(class72.listFetcher.method3015()) {
            byte[] var0 = class72.listFetcher.method3016();
            Buffer var1 = new Buffer(var0);
            var1.readInt();
            World.worldCount = var1.readUnsignedShort();
            Coordinates.worldList = new World[World.worldCount];

            World var3;
            for(int var2 = 0; var2 < World.worldCount; var3.index = var2++) {
               var3 = Coordinates.worldList[var2] = new World();
               var3.id = var1.readUnsignedShort();
               var3.mask = var1.readInt();
               var3.address = var1.readString();
               var3.activity = var1.readString();
               var3.location = var1.readUnsignedByte();
               var3.playerCount = var1.readShort();
            }

            class66.method1153(Coordinates.worldList, 0, Coordinates.worldList.length - 1, World.field1213, World.field1219);
            class72.listFetcher = null;
            return true;
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class72.listFetcher = null;
      }

      return false;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "66"
   )
   static void method43(String var0, String var1, String var2) {
      class91.loginMessage1 = var0;
      class91.loginMessage2 = var1;
      class91.loginMessage3 = var2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILcw;ZI)I",
      garbageValue = "-1804095889"
   )
   static int method44(int var0, Script var1, boolean var2) {
      if(var0 == 5000) {
         class82.intStack[++class56.intStackSize - 1] = Client.field1057;
         return 1;
      } else if(var0 == 5001) {
         class56.intStackSize -= 3;
         Client.field1057 = class82.intStack[class56.intStackSize];
         Huffman.field2432 = VarPlayerType.method4465(class82.intStack[class56.intStackSize + 1]);
         if(Huffman.field2432 == null) {
            Huffman.field2432 = class285.field3793;
         }

         Client.field905 = class82.intStack[class56.intStackSize + 2];
         PacketNode var30 = Actor.method1628(ClientPacket.field2342, Client.field952.field1478);
         var30.packetBuffer.putByte(Client.field1057);
         var30.packetBuffer.putByte(Huffman.field2432.field3785);
         var30.packetBuffer.putByte(Client.field905);
         Client.field952.method1951(var30);
         return 1;
      } else {
         String var3;
         int var4;
         int var5;
         if(var0 == 5002) {
            var3 = class82.scriptStringStack[--class24.scriptStringStackSize];
            class56.intStackSize -= 2;
            var4 = class82.intStack[class56.intStackSize];
            var5 = class82.intStack[class56.intStackSize + 1];
            PacketNode var28 = Actor.method1628(ClientPacket.field2388, Client.field952.field1478);
            var28.packetBuffer.putByte(Projectile.getLength(var3) + 2);
            var28.packetBuffer.putString(var3);
            var28.packetBuffer.putByte(var4 - 1);
            var28.packetBuffer.putByte(var5);
            Client.field952.method1951(var28);
            return 1;
         } else {
            int var17;
            if(var0 == 5003) {
               class56.intStackSize -= 2;
               var17 = class82.intStack[class56.intStackSize];
               var4 = class82.intStack[class56.intStackSize + 1];
               ChatLineBuffer var6 = (ChatLineBuffer)class96.chatLineMap.get(Integer.valueOf(var17));
               MessageNode var32 = var6.method1940(var4);
               if(var32 != null) {
                  class82.intStack[++class56.intStackSize - 1] = var32.id;
                  class82.intStack[++class56.intStackSize - 1] = var32.tick;
                  class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var32.name != null?var32.name:"";
                  class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var32.sender != null?var32.sender:"";
                  class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var32.value != null?var32.value:"";
               } else {
                  class82.intStack[++class56.intStackSize - 1] = -1;
                  class82.intStack[++class56.intStackSize - 1] = 0;
                  class82.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                  class82.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                  class82.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 5004) {
               var17 = class82.intStack[--class56.intStackSize];
               MessageNode var34 = (MessageNode)class96.field1433.get((long)var17);
               if(var34 != null) {
                  class82.intStack[++class56.intStackSize - 1] = var34.type;
                  class82.intStack[++class56.intStackSize - 1] = var34.tick;
                  class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var34.name != null?var34.name:"";
                  class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var34.sender != null?var34.sender:"";
                  class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var34.value != null?var34.value:"";
               } else {
                  class82.intStack[++class56.intStackSize - 1] = -1;
                  class82.intStack[++class56.intStackSize - 1] = 0;
                  class82.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                  class82.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
                  class82.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 5005) {
               if(Huffman.field2432 == null) {
                  class82.intStack[++class56.intStackSize - 1] = -1;
               } else {
                  class82.intStack[++class56.intStackSize - 1] = Huffman.field2432.field3785;
               }

               return 1;
            } else if(var0 == 5008) {
               var3 = class82.scriptStringStack[--class24.scriptStringStackSize];
               var4 = class82.intStack[--class56.intStackSize];
               String var31 = var3.toLowerCase();
               byte var35 = 0;
               if(var31.startsWith("yellow:")) {
                  var35 = 0;
                  var3 = var3.substring("yellow:".length());
               } else if(var31.startsWith("red:")) {
                  var35 = 1;
                  var3 = var3.substring("red:".length());
               } else if(var31.startsWith("green:")) {
                  var35 = 2;
                  var3 = var3.substring("green:".length());
               } else if(var31.startsWith("cyan:")) {
                  var35 = 3;
                  var3 = var3.substring("cyan:".length());
               } else if(var31.startsWith("purple:")) {
                  var35 = 4;
                  var3 = var3.substring("purple:".length());
               } else if(var31.startsWith("white:")) {
                  var35 = 5;
                  var3 = var3.substring("white:".length());
               } else if(var31.startsWith("flash1:")) {
                  var35 = 6;
                  var3 = var3.substring("flash1:".length());
               } else if(var31.startsWith("flash2:")) {
                  var35 = 7;
                  var3 = var3.substring("flash2:".length());
               } else if(var31.startsWith("flash3:")) {
                  var35 = 8;
                  var3 = var3.substring("flash3:".length());
               } else if(var31.startsWith("glow1:")) {
                  var35 = 9;
                  var3 = var3.substring("glow1:".length());
               } else if(var31.startsWith("glow2:")) {
                  var35 = 10;
                  var3 = var3.substring("glow2:".length());
               } else if(var31.startsWith("glow3:")) {
                  var35 = 11;
                  var3 = var3.substring("glow3:".length());
               } else if(Client.languageId != 0) {
                  if(var31.startsWith("yellow:")) {
                     var35 = 0;
                     var3 = var3.substring("yellow:".length());
                  } else if(var31.startsWith("red:")) {
                     var35 = 1;
                     var3 = var3.substring("red:".length());
                  } else if(var31.startsWith("green:")) {
                     var35 = 2;
                     var3 = var3.substring("green:".length());
                  } else if(var31.startsWith("cyan:")) {
                     var35 = 3;
                     var3 = var3.substring("cyan:".length());
                  } else if(var31.startsWith("purple:")) {
                     var35 = 4;
                     var3 = var3.substring("purple:".length());
                  } else if(var31.startsWith("white:")) {
                     var35 = 5;
                     var3 = var3.substring("white:".length());
                  } else if(var31.startsWith("flash1:")) {
                     var35 = 6;
                     var3 = var3.substring("flash1:".length());
                  } else if(var31.startsWith("flash2:")) {
                     var35 = 7;
                     var3 = var3.substring("flash2:".length());
                  } else if(var31.startsWith("flash3:")) {
                     var35 = 8;
                     var3 = var3.substring("flash3:".length());
                  } else if(var31.startsWith("glow1:")) {
                     var35 = 9;
                     var3 = var3.substring("glow1:".length());
                  } else if(var31.startsWith("glow2:")) {
                     var35 = 10;
                     var3 = var3.substring("glow2:".length());
                  } else if(var31.startsWith("glow3:")) {
                     var35 = 11;
                     var3 = var3.substring("glow3:".length());
                  }
               }

               var31 = var3.toLowerCase();
               byte var7 = 0;
               if(var31.startsWith("wave:")) {
                  var7 = 1;
                  var3 = var3.substring("wave:".length());
               } else if(var31.startsWith("wave2:")) {
                  var7 = 2;
                  var3 = var3.substring("wave2:".length());
               } else if(var31.startsWith("shake:")) {
                  var7 = 3;
                  var3 = var3.substring("shake:".length());
               } else if(var31.startsWith("scroll:")) {
                  var7 = 4;
                  var3 = var3.substring("scroll:".length());
               } else if(var31.startsWith("slide:")) {
                  var7 = 5;
                  var3 = var3.substring("slide:".length());
               } else if(Client.languageId != 0) {
                  if(var31.startsWith("wave:")) {
                     var7 = 1;
                     var3 = var3.substring("wave:".length());
                  } else if(var31.startsWith("wave2:")) {
                     var7 = 2;
                     var3 = var3.substring("wave2:".length());
                  } else if(var31.startsWith("shake:")) {
                     var7 = 3;
                     var3 = var3.substring("shake:".length());
                  } else if(var31.startsWith("scroll:")) {
                     var7 = 4;
                     var3 = var3.substring("scroll:".length());
                  } else if(var31.startsWith("slide:")) {
                     var7 = 5;
                     var3 = var3.substring("slide:".length());
                  }
               }

               PacketNode var8 = Actor.method1628(ClientPacket.field2399, Client.field952.field1478);
               var8.packetBuffer.putByte(0);
               int var9 = var8.packetBuffer.offset;
               var8.packetBuffer.putByte(var4);
               var8.packetBuffer.putByte(var35);
               var8.packetBuffer.putByte(var7);
               PacketBuffer var10 = var8.packetBuffer;
               int var11 = var10.offset;
               int var29 = var3.length();
               byte[] var14 = new byte[var29];

               for(int var15 = 0; var15 < var29; ++var15) {
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
               var10.offset += class272.field3717.compress(var14, 0, var14.length, var10.payload, var10.offset);
               var8.packetBuffer.method3287(var8.packetBuffer.offset - var9);
               Client.field952.method1951(var8);
               return 1;
            } else {
               int var20;
               if(var0 == 5009) {
                  class24.scriptStringStackSize -= 2;
                  var3 = class82.scriptStringStack[class24.scriptStringStackSize];
                  String var33 = class82.scriptStringStack[class24.scriptStringStackSize + 1];
                  PacketNode var18 = Actor.method1628(ClientPacket.field2336, Client.field952.field1478);
                  var18.packetBuffer.putShort(0);
                  var20 = var18.packetBuffer.offset;
                  var18.packetBuffer.putString(var3);
                  PacketBuffer var36 = var18.packetBuffer;
                  int var23 = var36.offset;
                  int var24 = var33.length();
                  byte[] var25 = new byte[var24];

                  for(int var26 = 0; var26 < var24; ++var26) {
                     char var13 = var33.charAt(var26);
                     if((var13 <= 0 || var13 >= 128) && (var13 < 160 || var13 > 255)) {
                        if(var13 == 8364) {
                           var25[var26] = -128;
                        } else if(var13 == 8218) {
                           var25[var26] = -126;
                        } else if(var13 == 402) {
                           var25[var26] = -125;
                        } else if(var13 == 8222) {
                           var25[var26] = -124;
                        } else if(var13 == 8230) {
                           var25[var26] = -123;
                        } else if(var13 == 8224) {
                           var25[var26] = -122;
                        } else if(var13 == 8225) {
                           var25[var26] = -121;
                        } else if(var13 == 710) {
                           var25[var26] = -120;
                        } else if(var13 == 8240) {
                           var25[var26] = -119;
                        } else if(var13 == 352) {
                           var25[var26] = -118;
                        } else if(var13 == 8249) {
                           var25[var26] = -117;
                        } else if(var13 == 338) {
                           var25[var26] = -116;
                        } else if(var13 == 381) {
                           var25[var26] = -114;
                        } else if(var13 == 8216) {
                           var25[var26] = -111;
                        } else if(var13 == 8217) {
                           var25[var26] = -110;
                        } else if(var13 == 8220) {
                           var25[var26] = -109;
                        } else if(var13 == 8221) {
                           var25[var26] = -108;
                        } else if(var13 == 8226) {
                           var25[var26] = -107;
                        } else if(var13 == 8211) {
                           var25[var26] = -106;
                        } else if(var13 == 8212) {
                           var25[var26] = -105;
                        } else if(var13 == 732) {
                           var25[var26] = -104;
                        } else if(var13 == 8482) {
                           var25[var26] = -103;
                        } else if(var13 == 353) {
                           var25[var26] = -102;
                        } else if(var13 == 8250) {
                           var25[var26] = -101;
                        } else if(var13 == 339) {
                           var25[var26] = -100;
                        } else if(var13 == 382) {
                           var25[var26] = -98;
                        } else if(var13 == 376) {
                           var25[var26] = -97;
                        } else {
                           var25[var26] = 63;
                        }
                     } else {
                        var25[var26] = (byte)var13;
                     }
                  }

                  var36.putShortSmart(var25.length);
                  var36.offset += class272.field3717.compress(var25, 0, var25.length, var36.payload, var36.offset);
                  var18.packetBuffer.method3410(var18.packetBuffer.offset - var20);
                  Client.field952.method1951(var18);
                  return 1;
               } else if(var0 != 5015) {
                  if(var0 == 5016) {
                     class82.intStack[++class56.intStackSize - 1] = Client.field905;
                     return 1;
                  } else if(var0 == 5017) {
                     var17 = class82.intStack[--class56.intStackSize];
                     class82.intStack[++class56.intStackSize - 1] = DecorativeObject.method2999(var17);
                     return 1;
                  } else if(var0 == 5018) {
                     var17 = class82.intStack[--class56.intStackSize];
                     int[] var19 = class82.intStack;
                     var5 = ++class56.intStackSize - 1;
                     MessageNode var22 = (MessageNode)class96.field1433.get((long)var17);
                     if(var22 == null) {
                        var20 = -1;
                     } else if(var22.previous == class96.field1427.field2581) {
                        var20 = -1;
                     } else {
                        var20 = ((MessageNode)var22.previous).id;
                     }

                     var19[var5] = var20;
                     return 1;
                  } else if(var0 == 5019) {
                     var17 = class82.intStack[--class56.intStackSize];
                     class82.intStack[++class56.intStackSize - 1] = WorldMapType3.method232(var17);
                     return 1;
                  } else if(var0 == 5020) {
                     var3 = class82.scriptStringStack[--class24.scriptStringStackSize];
                     class268.method4913(var3);
                     return 1;
                  } else if(var0 == 5021) {
                     Client.field1014 = class82.scriptStringStack[--class24.scriptStringStackSize].toLowerCase().trim();
                     return 1;
                  } else if(var0 == 5022) {
                     class82.scriptStringStack[++class24.scriptStringStackSize - 1] = Client.field1014;
                     return 1;
                  } else {
                     return 2;
                  }
               } else {
                  if(class48.localPlayer != null && class48.localPlayer.name != null) {
                     var3 = class48.localPlayer.name;
                  } else {
                     var3 = "";
                  }

                  class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var3;
                  return 1;
               }
            }
         }
      }
   }

   @ObfuscatedName("jp")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1845492258"
   )
   static final void method45(String var0) {
      if(DynamicObject.clanMembers != null) {
         PacketNode var1 = Actor.method1628(ClientPacket.field2381, Client.field952.field1478);
         var1.packetBuffer.putByte(Projectile.getLength(var0));
         var1.packetBuffer.putString(var0);
         Client.field952.method1951(var1);
      }
   }
}

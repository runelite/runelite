import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      intValue = -2052069541
   )
   static int field798;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -74238219
   )
   @Export("id")
   int id;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1120766489
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 48740783
   )
   @Export("type")
   int type;
   @ObfuscatedName("h")
   @Export("name")
   String name;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   Name field795;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ljy;"
   )
   class278 field804;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljy;"
   )
   class278 field801;
   @ObfuscatedName("d")
   @Export("sender")
   String sender;
   @ObfuscatedName("z")
   @Export("value")
   String value;

   @Hook(
      value = "setMessage",
      end = true
   )
   MessageNode(int var1, String var2, String var3, String var4) {
      this.field804 = class278.field3716;
      this.field801 = class278.field3716;
      this.id = class150.method3167();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.method1103();
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1611349399"
   )
   @Export("setMessage")
   @Hook(
      value = "setMessage",
      end = true
   )
   void setMessage(int var1, String var2, String var3, String var4) {
      this.id = class150.method3167();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.method1103();
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1650496358"
   )
   void method1081() {
      this.field804 = class278.field3716;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2123613851"
   )
   final boolean method1088() {
      if(this.field804 == class278.field3716) {
         this.method1083();
      }

      return this.field804 == class278.field3718;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1608030973"
   )
   void method1083() {
      this.field804 = class35.friendManager.field1211.isMember(this.field795)?class278.field3718:class278.field3717;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "997025748"
   )
   void method1082() {
      this.field801 = class278.field3716;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1966572829"
   )
   final boolean method1085() {
      if(this.field801 == class278.field3716) {
         this.method1086();
      }

      return this.field801 == class278.field3718;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "38"
   )
   void method1086() {
      this.field801 = class35.friendManager.field1212.isMember(this.field795)?class278.field3718:class278.field3717;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-20"
   )
   final void method1103() {
      if(this.name != null) {
         this.field795 = new Name(AttackOption.method1886(this.name), class226.loginType);
      } else {
         this.field795 = null;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1957310805"
   )
   static final void method1109() {
      BoundingBox3D.method49("Your ignore list is full. Max of 100 for free users, and 400 for members");
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(ILcf;ZB)I",
      garbageValue = "1"
   )
   static int method1112(int var0, Script var1, boolean var2) {
      if(var0 == 5000) {
         class80.intStack[++class80.intStackSize - 1] = Client.publicChatMode;
         return 1;
      } else {
         int var4;
         PacketNode var5;
         if(var0 == 5001) {
            class80.intStackSize -= 3;
            Client.publicChatMode = class80.intStack[class80.intStackSize];
            var4 = class80.intStack[class80.intStackSize + 1];
            class301[] var30 = new class301[]{class301.field3853, class301.field3854, class301.field3855};
            class301[] var31 = var30;
            int var33 = 0;

            class301 var35;
            while(true) {
               if(var33 >= var31.length) {
                  var35 = null;
                  break;
               }

               class301 var32 = var31[var33];
               if(var4 == var32.field3856) {
                  var35 = var32;
                  break;
               }

               ++var33;
            }

            IndexFile.field2185 = var35;
            if(IndexFile.field2185 == null) {
               IndexFile.field2185 = class301.field3854;
            }

            Client.field1041 = class80.intStack[class80.intStackSize + 2];
            var5 = Script.method2025(ClientPacket.field2373, Client.field937.field1454);
            var5.packetBuffer.putByte(Client.publicChatMode);
            var5.packetBuffer.putByte(IndexFile.field2185.field3856);
            var5.packetBuffer.putByte(Client.field1041);
            Client.field937.method2044(var5);
            return 1;
         } else {
            String var3;
            int var17;
            if(var0 == 5002) {
               var3 = class80.scriptStringStack[--class294.scriptStringStackSize];
               class80.intStackSize -= 2;
               var4 = class80.intStack[class80.intStackSize];
               var17 = class80.intStack[class80.intStackSize + 1];
               PacketNode var6 = Script.method2025(ClientPacket.field2331, Client.field937.field1454);
               var6.packetBuffer.putByte(FrameMap.getLength(var3) + 2);
               var6.packetBuffer.putString(var3);
               var6.packetBuffer.putByte(var4 - 1);
               var6.packetBuffer.putByte(var17);
               Client.field937.method2044(var6);
               return 1;
            } else {
               int var18;
               if(var0 == 5003) {
                  class80.intStackSize -= 2;
                  var18 = class80.intStack[class80.intStackSize];
                  var4 = class80.intStack[class80.intStackSize + 1];
                  MessageNode var29 = class29.method244(var18, var4);
                  if(var29 != null) {
                     class80.intStack[++class80.intStackSize - 1] = var29.id;
                     class80.intStack[++class80.intStackSize - 1] = var29.tick;
                     class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var29.name != null?var29.name:"";
                     class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var29.sender != null?var29.sender:"";
                     class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var29.value != null?var29.value:"";
                     class80.intStack[++class80.intStackSize - 1] = var29.method1088()?1:(var29.method1085()?2:0);
                  } else {
                     class80.intStack[++class80.intStackSize - 1] = -1;
                     class80.intStack[++class80.intStackSize - 1] = 0;
                     class80.scriptStringStack[++class294.scriptStringStackSize - 1] = "";
                     class80.scriptStringStack[++class294.scriptStringStackSize - 1] = "";
                     class80.scriptStringStack[++class294.scriptStringStackSize - 1] = "";
                     class80.intStack[++class80.intStackSize - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 5004) {
                  var18 = class80.intStack[--class80.intStackSize];
                  MessageNode var37 = (MessageNode)class94.messages.get((long)var18);
                  if(var37 != null) {
                     class80.intStack[++class80.intStackSize - 1] = var37.type;
                     class80.intStack[++class80.intStackSize - 1] = var37.tick;
                     class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var37.name != null?var37.name:"";
                     class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var37.sender != null?var37.sender:"";
                     class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var37.value != null?var37.value:"";
                     class80.intStack[++class80.intStackSize - 1] = var37.method1088()?1:(var37.method1085()?2:0);
                  } else {
                     class80.intStack[++class80.intStackSize - 1] = -1;
                     class80.intStack[++class80.intStackSize - 1] = 0;
                     class80.scriptStringStack[++class294.scriptStringStackSize - 1] = "";
                     class80.scriptStringStack[++class294.scriptStringStackSize - 1] = "";
                     class80.scriptStringStack[++class294.scriptStringStackSize - 1] = "";
                     class80.intStack[++class80.intStackSize - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 5005) {
                  if(IndexFile.field2185 == null) {
                     class80.intStack[++class80.intStackSize - 1] = -1;
                  } else {
                     class80.intStack[++class80.intStackSize - 1] = IndexFile.field2185.field3856;
                  }

                  return 1;
               } else if(var0 == 5008) {
                  var3 = class80.scriptStringStack[--class294.scriptStringStackSize];
                  var4 = class80.intStack[--class80.intStackSize];
                  String var28 = var3.toLowerCase();
                  byte var39 = 0;
                  if(var28.startsWith("yellow:")) {
                     var39 = 0;
                     var3 = var3.substring("yellow:".length());
                  } else if(var28.startsWith("red:")) {
                     var39 = 1;
                     var3 = var3.substring("red:".length());
                  } else if(var28.startsWith("green:")) {
                     var39 = 2;
                     var3 = var3.substring("green:".length());
                  } else if(var28.startsWith("cyan:")) {
                     var39 = 3;
                     var3 = var3.substring("cyan:".length());
                  } else if(var28.startsWith("purple:")) {
                     var39 = 4;
                     var3 = var3.substring("purple:".length());
                  } else if(var28.startsWith("white:")) {
                     var39 = 5;
                     var3 = var3.substring("white:".length());
                  } else if(var28.startsWith("flash1:")) {
                     var39 = 6;
                     var3 = var3.substring("flash1:".length());
                  } else if(var28.startsWith("flash2:")) {
                     var39 = 7;
                     var3 = var3.substring("flash2:".length());
                  } else if(var28.startsWith("flash3:")) {
                     var39 = 8;
                     var3 = var3.substring("flash3:".length());
                  } else if(var28.startsWith("glow1:")) {
                     var39 = 9;
                     var3 = var3.substring("glow1:".length());
                  } else if(var28.startsWith("glow2:")) {
                     var39 = 10;
                     var3 = var3.substring("glow2:".length());
                  } else if(var28.startsWith("glow3:")) {
                     var39 = 11;
                     var3 = var3.substring("glow3:".length());
                  } else if(Client.languageId != 0) {
                     if(var28.startsWith("yellow:")) {
                        var39 = 0;
                        var3 = var3.substring("yellow:".length());
                     } else if(var28.startsWith("red:")) {
                        var39 = 1;
                        var3 = var3.substring("red:".length());
                     } else if(var28.startsWith("green:")) {
                        var39 = 2;
                        var3 = var3.substring("green:".length());
                     } else if(var28.startsWith("cyan:")) {
                        var39 = 3;
                        var3 = var3.substring("cyan:".length());
                     } else if(var28.startsWith("purple:")) {
                        var39 = 4;
                        var3 = var3.substring("purple:".length());
                     } else if(var28.startsWith("white:")) {
                        var39 = 5;
                        var3 = var3.substring("white:".length());
                     } else if(var28.startsWith("flash1:")) {
                        var39 = 6;
                        var3 = var3.substring("flash1:".length());
                     } else if(var28.startsWith("flash2:")) {
                        var39 = 7;
                        var3 = var3.substring("flash2:".length());
                     } else if(var28.startsWith("flash3:")) {
                        var39 = 8;
                        var3 = var3.substring("flash3:".length());
                     } else if(var28.startsWith("glow1:")) {
                        var39 = 9;
                        var3 = var3.substring("glow1:".length());
                     } else if(var28.startsWith("glow2:")) {
                        var39 = 10;
                        var3 = var3.substring("glow2:".length());
                     } else if(var28.startsWith("glow3:")) {
                        var39 = 11;
                        var3 = var3.substring("glow3:".length());
                     }
                  }

                  var28 = var3.toLowerCase();
                  byte var7 = 0;
                  if(var28.startsWith("wave:")) {
                     var7 = 1;
                     var3 = var3.substring("wave:".length());
                  } else if(var28.startsWith("wave2:")) {
                     var7 = 2;
                     var3 = var3.substring("wave2:".length());
                  } else if(var28.startsWith("shake:")) {
                     var7 = 3;
                     var3 = var3.substring("shake:".length());
                  } else if(var28.startsWith("scroll:")) {
                     var7 = 4;
                     var3 = var3.substring("scroll:".length());
                  } else if(var28.startsWith("slide:")) {
                     var7 = 5;
                     var3 = var3.substring("slide:".length());
                  } else if(Client.languageId != 0) {
                     if(var28.startsWith("wave:")) {
                        var7 = 1;
                        var3 = var3.substring("wave:".length());
                     } else if(var28.startsWith("wave2:")) {
                        var7 = 2;
                        var3 = var3.substring("wave2:".length());
                     } else if(var28.startsWith("shake:")) {
                        var7 = 3;
                        var3 = var3.substring("shake:".length());
                     } else if(var28.startsWith("scroll:")) {
                        var7 = 4;
                        var3 = var3.substring("scroll:".length());
                     } else if(var28.startsWith("slide:")) {
                        var7 = 5;
                        var3 = var3.substring("slide:".length());
                     }
                  }

                  PacketNode var8 = Script.method2025(ClientPacket.field2333, Client.field937.field1454);
                  var8.packetBuffer.putByte(0);
                  int var9 = var8.packetBuffer.offset;
                  var8.packetBuffer.putByte(var4);
                  var8.packetBuffer.putByte(var39);
                  var8.packetBuffer.putByte(var7);
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
                  var10.offset += class288.huffman.compress(var14, 0, var14.length, var10.payload, var10.offset);
                  var8.packetBuffer.method3505(var8.packetBuffer.offset - var9);
                  Client.field937.method2044(var8);
                  return 1;
               } else {
                  int var20;
                  if(var0 == 5009) {
                     class294.scriptStringStackSize -= 2;
                     var3 = class80.scriptStringStack[class294.scriptStringStackSize];
                     String var36 = class80.scriptStringStack[class294.scriptStringStackSize + 1];
                     var5 = Script.method2025(ClientPacket.field2393, Client.field937.field1454);
                     var5.packetBuffer.putShort(0);
                     var20 = var5.packetBuffer.offset;
                     var5.packetBuffer.putString(var3);
                     PacketBuffer var38 = var5.packetBuffer;
                     int var23 = var38.offset;
                     int var24 = var36.length();
                     byte[] var25 = new byte[var24];

                     for(int var26 = 0; var26 < var24; ++var26) {
                        char var13 = var36.charAt(var26);
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

                     var38.putShortSmart(var25.length);
                     var38.offset += class288.huffman.compress(var25, 0, var25.length, var38.payload, var38.offset);
                     var5.packetBuffer.method3504(var5.packetBuffer.offset - var20);
                     Client.field937.method2044(var5);
                     return 1;
                  } else if(var0 != 5015) {
                     if(var0 == 5016) {
                        class80.intStack[++class80.intStackSize - 1] = Client.field1041;
                        return 1;
                     } else if(var0 == 5017) {
                        var18 = class80.intStack[--class80.intStackSize];
                        class80.intStack[++class80.intStackSize - 1] = class214.method4131(var18);
                        return 1;
                     } else {
                        int[] var19;
                        MessageNode var22;
                        if(var0 == 5018) {
                           var18 = class80.intStack[--class80.intStackSize];
                           var19 = class80.intStack;
                           var17 = ++class80.intStackSize - 1;
                           var22 = (MessageNode)class94.messages.get((long)var18);
                           if(var22 == null) {
                              var20 = -1;
                           } else if(var22.previous == class94.field1413.sentinel) {
                              var20 = -1;
                           } else {
                              var20 = ((MessageNode)var22.previous).id;
                           }

                           var19[var17] = var20;
                           return 1;
                        } else if(var0 == 5019) {
                           var18 = class80.intStack[--class80.intStackSize];
                           var19 = class80.intStack;
                           var17 = ++class80.intStackSize - 1;
                           var22 = (MessageNode)class94.messages.get((long)var18);
                           if(var22 == null) {
                              var20 = -1;
                           } else if(var22.next == class94.field1413.sentinel) {
                              var20 = -1;
                           } else {
                              var20 = ((MessageNode)var22.next).id;
                           }

                           var19[var17] = var20;
                           return 1;
                        } else if(var0 == 5020) {
                           var3 = class80.scriptStringStack[--class294.scriptStringStackSize];
                           World.method1662(var3);
                           return 1;
                        } else if(var0 == 5021) {
                           Client.field1042 = class80.scriptStringStack[--class294.scriptStringStackSize].toLowerCase().trim();
                           return 1;
                        } else if(var0 == 5022) {
                           class80.scriptStringStack[++class294.scriptStringStackSize - 1] = Client.field1042;
                           return 1;
                        } else {
                           return 2;
                        }
                     }
                  } else {
                     if(GroundObject.localPlayer != null && GroundObject.localPlayer.name != null) {
                        var3 = GroundObject.localPlayer.name.getName();
                     } else {
                        var3 = "";
                     }

                     class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var3;
                     return 1;
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "356746800"
   )
   static void method1111() {
      if(Client.field953 >= 0 && Client.cachedPlayers[Client.field953] != null) {
         class214.method4127(Client.cachedPlayers[Client.field953], false);
      }

   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1194947039"
   )
   static final void method1100(int var0, int var1) {
      if(Client.hintArrowTargetType == 2) {
         class111.worldToScreen((Client.hintArrowX - ClanMemberManager.baseX << 7) + Client.hintArrowOffsetX, (Client.hintArrowY - WorldMapData.baseY << 7) + Client.hintArrowOffsetY, Client.hintArrowType * 2);
         if(Client.screenX > -1 && Client.gameCycle % 20 < 10) {
            class111.headIconsHint[0].drawAt(var0 + Client.screenX - 12, Client.screenY + var1 - 28);
         }

      }
   }

   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "115"
   )
   @Export("getTileHeight")
   static final int getTileHeight(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class62.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = (128 - var6) * class62.tileHeights[var5][var3][var4] + class62.tileHeights[var5][var3 + 1][var4] * var6 >> 7;
         int var9 = var6 * class62.tileHeights[var5][var3 + 1][var4 + 1] + class62.tileHeights[var5][var3][var4 + 1] * (128 - var6) >> 7;
         return var7 * var9 + var8 * (128 - var7) >> 7;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("jd")
   @ObfuscatedSignature(
      signature = "(IIIILki;Lhg;I)V",
      garbageValue = "2057901195"
   )
   @Export("worldToMinimap")
   static final void worldToMinimap(int var0, int var1, int var2, int var3, SpritePixels var4, class221 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle & 2047;
         int var8 = Graphics3D.SINE[var7];
         int var9 = Graphics3D.COSINE[var7];
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = var5.field2708 / 2 - 25;
         int var15 = (int)(Math.sin(var12) * (double)var14);
         int var16 = (int)(Math.cos(var12) * (double)var14);
         byte var17 = 20;
         class27.mapedge.method5678(var15 + (var0 + var5.field2708 / 2 - var17 / 2), var5.field2703 / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
      } else {
         WorldMapType2.drawDot(var0, var1, var2, var3, var4, var5);
      }

   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
@Implements("PacketBuffer")
public final class PacketBuffer extends Buffer {
   @ObfuscatedName("x")
   static final int[] field2602;
   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   @Export("indexTrack1")
   static IndexData indexTrack1;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("cipher")
   ISAACCipher cipher;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1880035895
   )
   @Export("bitPosition")
   int bitPosition;

   static {
      field2602 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }

   public PacketBuffer(int var1) {
      super(var1);
   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "2103552332"
   )
   @Export("seed")
   public void seed(int[] var1) {
      this.cipher = new ISAACCipher(var1);
   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "(Lgx;I)V",
      garbageValue = "-2032050418"
   )
   @Export("setIsaacCipher")
   public void setIsaacCipher(ISAACCipher var1) {
      this.cipher = var1;
   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-167498009"
   )
   @Export("putOpcode")
   public void putOpcode(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.cipher.nextInt());
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-389958961"
   )
   @Export("readOpcode")
   public int readOpcode() {
      return super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "100"
   )
   public boolean method3780() {
      int var1 = super.payload[super.offset] - this.cipher.method3813() & 255;
      return var1 >= 128;
   }

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1434838342"
   )
   public int method3783() {
      int var1 = super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
      return var1 < 128?var1:(var1 - 128 << 8) + (super.payload[++super.offset - 1] - this.cipher.nextInt() & 255);
   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1326744811"
   )
   @Export("bitAccess")
   public void bitAccess() {
      this.bitPosition = super.offset * 8;
   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "740978969"
   )
   @Export("getBits")
   public int getBits(int var1) {
      int var2 = this.bitPosition >> 3;
      int var3 = 8 - (this.bitPosition & 7);
      int var4 = 0;

      for(this.bitPosition += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2602[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2602[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2602[var1];
      }

      return var4;
   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1348619132"
   )
   @Export("byteAccess")
   public void byteAccess() {
      super.offset = (this.bitPosition + 7) / 8;
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "-2320"
   )
   @Export("bitsAvail")
   public int bitsAvail(int var1) {
      return var1 * 8 - this.bitPosition;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILcr;ZI)I",
      garbageValue = "1319314475"
   )
   static int method3806(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class81.intStack[--WorldComparator.intStackSize];
         var3 = class44.getWidget(var4);
      } else {
         var3 = var2?class81.field1285:Signlink.field2218;
      }

      if(var0 == 1100) {
         WorldComparator.intStackSize -= 2;
         var3.scrollX = class81.intStack[WorldComparator.intStackSize];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class81.intStack[WorldComparator.intStackSize + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         FontName.method5490(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class81.intStack[--WorldComparator.intStackSize];
         FontName.method5490(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.filled = class81.intStack[--WorldComparator.intStackSize] == 1;
         FontName.method5490(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class81.intStack[--WorldComparator.intStackSize];
         FontName.method5490(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.lineWidth = class81.intStack[--WorldComparator.intStackSize];
         FontName.method5490(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.spriteId = class81.intStack[--WorldComparator.intStackSize];
         FontName.method5490(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.textureId = class81.intStack[--WorldComparator.intStackSize];
         FontName.method5490(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.spriteTiling = class81.intStack[--WorldComparator.intStackSize] == 1;
         FontName.method5490(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class81.intStack[--WorldComparator.intStackSize];
         FontName.method5490(var3);
         return 1;
      } else if(var0 == 1109) {
         WorldComparator.intStackSize -= 6;
         var3.offsetX2d = class81.intStack[WorldComparator.intStackSize];
         var3.offsetY2d = class81.intStack[WorldComparator.intStackSize + 1];
         var3.rotationX = class81.intStack[WorldComparator.intStackSize + 2];
         var3.rotationZ = class81.intStack[WorldComparator.intStackSize + 3];
         var3.rotationY = class81.intStack[WorldComparator.intStackSize + 4];
         var3.modelZoom = class81.intStack[WorldComparator.intStackSize + 5];
         FontName.method5490(var3);
         return 1;
      } else {
         int var9;
         if(var0 == 1110) {
            var9 = class81.intStack[--WorldComparator.intStackSize];
            if(var9 != var3.field2869) {
               var3.field2869 = var9;
               var3.field2935 = 0;
               var3.field2945 = 0;
               FontName.method5490(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2879 = class81.intStack[--WorldComparator.intStackSize] == 1;
            FontName.method5490(var3);
            return 1;
         } else if(var0 == 1112) {
            String var8 = class81.scriptStringStack[--KeyFocusListener.scriptStringStackSize];
            if(!var8.equals(var3.text)) {
               var3.text = var8;
               FontName.method5490(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class81.intStack[--WorldComparator.intStackSize];
            FontName.method5490(var3);
            return 1;
         } else if(var0 == 1114) {
            WorldComparator.intStackSize -= 3;
            var3.field2885 = class81.intStack[WorldComparator.intStackSize];
            var3.field2833 = class81.intStack[WorldComparator.intStackSize + 1];
            var3.field2884 = class81.intStack[WorldComparator.intStackSize + 2];
            FontName.method5490(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.textShadowed = class81.intStack[--WorldComparator.intStackSize] == 1;
            FontName.method5490(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class81.intStack[--WorldComparator.intStackSize];
            FontName.method5490(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class81.intStack[--WorldComparator.intStackSize];
            FontName.method5490(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class81.intStack[--WorldComparator.intStackSize] == 1;
            FontName.method5490(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class81.intStack[--WorldComparator.intStackSize] == 1;
            FontName.method5490(var3);
            return 1;
         } else if(var0 == 1120) {
            WorldComparator.intStackSize -= 2;
            var3.scrollWidth = class81.intStack[WorldComparator.intStackSize];
            var3.scrollHeight = class81.intStack[WorldComparator.intStackSize + 1];
            FontName.method5490(var3);
            if(var4 != -1 && var3.type == 0) {
               class86.method1889(MouseRecorder.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            TotalQuantityComparator.method98(var3.id, var3.index);
            Client.field1033 = var3;
            FontName.method5490(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2858 = class81.intStack[--WorldComparator.intStackSize];
            FontName.method5490(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2841 = class81.intStack[--WorldComparator.intStackSize];
            FontName.method5490(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2854 = class81.intStack[--WorldComparator.intStackSize];
            FontName.method5490(var3);
            return 1;
         } else if(var0 == 1125) {
            var9 = class81.intStack[--WorldComparator.intStackSize];
            class329[] var6 = new class329[]{class329.field3966, class329.field3965, class329.field3968, class329.field3969, class329.field3967};
            class329 var7 = (class329)Permission.forOrdinal(var6, var9);
            if(var7 != null) {
               var3.field2909 = var7;
               FontName.method5490(var3);
            }

            return 1;
         } else if(var0 == 1126) {
            boolean var5 = class81.intStack[--WorldComparator.intStackSize] == 1;
            var3.field2903 = var5;
            return 1;
         } else {
            return 2;
         }
      }
   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;IIB)V",
      garbageValue = "-1"
   )
   @Export("menuAction")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      PacketNode var8;
      if(var2 == 1) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field972 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = WorldMapRectangle.method280(ClientPacket.field2393, Client.field957.field1484);
         var8.packetBuffer.method3550(class2.field16);
         var8.packetBuffer.method3528(var3 >> 14 & 32767);
         var8.packetBuffer.method3528(UrlRequester.selectedItemIndex);
         var8.packetBuffer.method3551(var0 + class138.baseX);
         var8.packetBuffer.method3559(BoundingBox.field251);
         var8.packetBuffer.method3541(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.method3528(class23.baseY + var1);
         Client.field957.method2052(var8);
      } else if(var2 == 2) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field972 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = WorldMapRectangle.method280(ClientPacket.field2461, Client.field957.field1484);
         var8.packetBuffer.method3541(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.method3561(class234.field2768);
         var8.packetBuffer.method3528(Client.field1025);
         var8.packetBuffer.putShort(class23.baseY + var1);
         var8.packetBuffer.method3528(var3 >> 14 & 32767);
         var8.packetBuffer.method3528(var0 + class138.baseX);
         Client.field957.method2052(var8);
      } else if(var2 == 3) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field972 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = WorldMapRectangle.method280(ClientPacket.field2394, Client.field957.field1484);
         var8.packetBuffer.putShort(class23.baseY + var1);
         var8.packetBuffer.method3550(var0 + class138.baseX);
         var8.packetBuffer.method3543(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.putShort(var3 >> 14 & 32767);
         Client.field957.method2052(var8);
      } else if(var2 == 4) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field972 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = WorldMapRectangle.method280(ClientPacket.field2466, Client.field957.field1484);
         var8.packetBuffer.putShort(var0 + class138.baseX);
         var8.packetBuffer.putShort(class23.baseY + var1);
         var8.packetBuffer.method3541(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.method3528(var3 >> 14 & 32767);
         Client.field957.method2052(var8);
      } else if(var2 == 5) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field972 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = WorldMapRectangle.method280(ClientPacket.field2469, Client.field957.field1484);
         var8.packetBuffer.method3551(var3 >> 14 & 32767);
         var8.packetBuffer.method3542(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.method3551(class23.baseY + var1);
         var8.packetBuffer.putShort(var0 + class138.baseX);
         Client.field957.method2052(var8);
      } else if(var2 == 6) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field972 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = WorldMapRectangle.method280(ClientPacket.field2451, Client.field957.field1484);
         var8.packetBuffer.method3543(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.putShort(var3 >> 14 & 32767);
         var8.packetBuffer.method3528(var0 + class138.baseX);
         var8.packetBuffer.method3550(class23.baseY + var1);
         Client.field957.method2052(var8);
      } else {
         PacketNode var9;
         NPC var16;
         if(var2 == 7) {
            var16 = Client.cachedNPCs[var3];
            if(var16 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field972 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = WorldMapRectangle.method280(ClientPacket.field2427, Client.field957.field1484);
               var9.packetBuffer.method3561(BoundingBox.field251);
               var9.packetBuffer.method3543(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3550(var3);
               var9.packetBuffer.method3550(class2.field16);
               var9.packetBuffer.putShort(UrlRequester.selectedItemIndex);
               Client.field957.method2052(var9);
            }
         } else if(var2 == 8) {
            var16 = Client.cachedNPCs[var3];
            if(var16 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field972 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = WorldMapRectangle.method280(ClientPacket.field2406, Client.field957.field1484);
               var9.packetBuffer.method3528(Client.field1025);
               var9.packetBuffer.method3543(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3550(var3);
               var9.packetBuffer.putInt(class234.field2768);
               Client.field957.method2052(var9);
            }
         } else if(var2 == 9) {
            var16 = Client.cachedNPCs[var3];
            if(var16 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field972 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = WorldMapRectangle.method280(ClientPacket.field2420, Client.field957.field1484);
               var9.packetBuffer.method3543(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3550(var3);
               Client.field957.method2052(var9);
            }
         } else if(var2 == 10) {
            var16 = Client.cachedNPCs[var3];
            if(var16 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field972 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = WorldMapRectangle.method280(ClientPacket.field2474, Client.field957.field1484);
               var9.packetBuffer.method3528(var3);
               var9.packetBuffer.method3541(KeyFocusListener.keyPressed[82]?1:0);
               Client.field957.method2052(var9);
            }
         } else if(var2 == 11) {
            var16 = Client.cachedNPCs[var3];
            if(var16 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field972 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = WorldMapRectangle.method280(ClientPacket.field2458, Client.field957.field1484);
               var9.packetBuffer.method3541(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3550(var3);
               Client.field957.method2052(var9);
            }
         } else if(var2 == 12) {
            var16 = Client.cachedNPCs[var3];
            if(var16 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field972 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = WorldMapRectangle.method280(ClientPacket.field2473, Client.field957.field1484);
               var9.packetBuffer.method3543(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.putShort(var3);
               Client.field957.method2052(var9);
            }
         } else if(var2 == 13) {
            var16 = Client.cachedNPCs[var3];
            if(var16 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field972 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = WorldMapRectangle.method280(ClientPacket.field2454, Client.field957.field1484);
               var9.packetBuffer.method3528(var3);
               var9.packetBuffer.method3542(KeyFocusListener.keyPressed[82]?1:0);
               Client.field957.method2052(var9);
            }
         } else {
            Player var18;
            if(var2 == 14) {
               var18 = Client.cachedPlayers[var3];
               if(var18 != null) {
                  Client.lastLeftClickX = var6;
                  Client.lastLeftClickY = var7;
                  Client.cursorState = 2;
                  Client.field972 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var9 = WorldMapRectangle.method280(ClientPacket.field2441, Client.field957.field1484);
                  var9.packetBuffer.putInt(BoundingBox.field251);
                  var9.packetBuffer.method3542(KeyFocusListener.keyPressed[82]?1:0);
                  var9.packetBuffer.putShort(class2.field16);
                  var9.packetBuffer.method3528(UrlRequester.selectedItemIndex);
                  var9.packetBuffer.method3551(var3);
                  Client.field957.method2052(var9);
               }
            } else if(var2 == 15) {
               var18 = Client.cachedPlayers[var3];
               if(var18 != null) {
                  Client.lastLeftClickX = var6;
                  Client.lastLeftClickY = var7;
                  Client.cursorState = 2;
                  Client.field972 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var9 = WorldMapRectangle.method280(ClientPacket.field2442, Client.field957.field1484);
                  var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                  var9.packetBuffer.method3528(Client.field1025);
                  var9.packetBuffer.putInt(class234.field2768);
                  var9.packetBuffer.method3551(var3);
                  Client.field957.method2052(var9);
               }
            } else if(var2 == 16) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field972 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = WorldMapRectangle.method280(ClientPacket.field2419, Client.field957.field1484);
               var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3528(var0 + class138.baseX);
               var8.packetBuffer.method3551(var3);
               var8.packetBuffer.method3551(UrlRequester.selectedItemIndex);
               var8.packetBuffer.putShort(class2.field16);
               var8.packetBuffer.method3559(BoundingBox.field251);
               var8.packetBuffer.method3528(class23.baseY + var1);
               Client.field957.method2052(var8);
            } else if(var2 == 17) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field972 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = WorldMapRectangle.method280(ClientPacket.field2388, Client.field957.field1484);
               var8.packetBuffer.method3559(class234.field2768);
               var8.packetBuffer.putShort(class23.baseY + var1);
               var8.packetBuffer.putShort(Client.field1025);
               var8.packetBuffer.method3541(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3550(var0 + class138.baseX);
               var8.packetBuffer.method3551(var3);
               Client.field957.method2052(var8);
            } else if(var2 == 18) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field972 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = WorldMapRectangle.method280(ClientPacket.field2453, Client.field957.field1484);
               var8.packetBuffer.method3528(class23.baseY + var1);
               var8.packetBuffer.method3550(var0 + class138.baseX);
               var8.packetBuffer.method3541(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3550(var3);
               Client.field957.method2052(var8);
            } else if(var2 == 19) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field972 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = WorldMapRectangle.method280(ClientPacket.field2437, Client.field957.field1484);
               var8.packetBuffer.method3551(var0 + class138.baseX);
               var8.packetBuffer.method3550(var3);
               var8.packetBuffer.putShort(class23.baseY + var1);
               var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               Client.field957.method2052(var8);
            } else if(var2 == 20) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field972 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = WorldMapRectangle.method280(ClientPacket.field2399, Client.field957.field1484);
               var8.packetBuffer.method3550(var0 + class138.baseX);
               var8.packetBuffer.method3528(var3);
               var8.packetBuffer.method3551(class23.baseY + var1);
               var8.packetBuffer.method3541(KeyFocusListener.keyPressed[82]?1:0);
               Client.field957.method2052(var8);
            } else if(var2 == 21) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field972 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = WorldMapRectangle.method280(ClientPacket.field2416, Client.field957.field1484);
               var8.packetBuffer.method3528(var0 + class138.baseX);
               var8.packetBuffer.method3551(class23.baseY + var1);
               var8.packetBuffer.putShort(var3);
               var8.packetBuffer.method3542(KeyFocusListener.keyPressed[82]?1:0);
               Client.field957.method2052(var8);
            } else if(var2 == 22) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field972 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = WorldMapRectangle.method280(ClientPacket.field2467, Client.field957.field1484);
               var8.packetBuffer.method3551(class23.baseY + var1);
               var8.packetBuffer.putShort(var3);
               var8.packetBuffer.method3543(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3551(var0 + class138.baseX);
               Client.field957.method2052(var8);
            } else if(var2 == 23) {
               if(Client.isMenuOpen) {
                  class255.region.method2997();
               } else {
                  class255.region.method2889(BoundingBox3DDrawMode.plane, var0, var1, true);
               }
            } else {
               PacketNode var14;
               Widget var22;
               if(var2 == 24) {
                  var22 = class44.getWidget(var1);
                  boolean var13 = true;
                  if(var22.contentType > 0) {
                     var13 = GZipDecompressor.method3461(var22);
                  }

                  if(var13) {
                     var14 = WorldMapRectangle.method280(ClientPacket.field2460, Client.field957.field1484);
                     var14.packetBuffer.putInt(var1);
                     Client.field957.method2052(var14);
                  }
               } else {
                  if(var2 == 25) {
                     var22 = FontName.getWidgetChild(var1, var0);
                     if(var22 != null) {
                        class154.method3156();
                        class55.method834(var1, var0, class250.method4502(GroundObject.getWidgetClickMask(var22)), var22.itemId);
                        Client.itemSelectionState = 0;
                        String var24;
                        if(class250.method4502(GroundObject.getWidgetClickMask(var22)) == 0) {
                           var24 = null;
                        } else if(var22.targetVerb != null && var22.targetVerb.trim().length() != 0) {
                           var24 = var22.targetVerb;
                        } else {
                           var24 = null;
                        }

                        Client.field1092 = var24;
                        if(Client.field1092 == null) {
                           Client.field1092 = "Null";
                        }

                        if(var22.hasScript) {
                           Client.field1028 = var22.opBase + class45.getColTags(16777215);
                        } else {
                           Client.field1028 = class45.getColTags(65280) + var22.spellName + class45.getColTags(16777215);
                        }
                     }

                     return;
                  }

                  if(var2 == 26) {
                     var8 = WorldMapRectangle.method280(ClientPacket.field2428, Client.field957.field1484);
                     Client.field957.method2052(var8);

                     for(WidgetNode var17 = (WidgetNode)Client.componentTable.first(); var17 != null; var17 = (WidgetNode)Client.componentTable.next()) {
                        if(var17.owner == 0 || var17.owner == 3) {
                           class57.closeWidget(var17, true);
                        }
                     }

                     if(Client.field1033 != null) {
                        FontName.method5490(Client.field1033);
                        Client.field1033 = null;
                     }
                  } else {
                     int var10;
                     Widget var19;
                     if(var2 == 28) {
                        var8 = WorldMapRectangle.method280(ClientPacket.field2460, Client.field957.field1484);
                        var8.packetBuffer.putInt(var1);
                        Client.field957.method2052(var8);
                        var19 = class44.getWidget(var1);
                        if(var19.dynamicValues != null && var19.dynamicValues[0][0] == 5) {
                           var10 = var19.dynamicValues[0][1];
                           class237.clientVarps[var10] = 1 - class237.clientVarps[var10];
                           class18.method142(var10);
                        }
                     } else if(var2 == 29) {
                        var8 = WorldMapRectangle.method280(ClientPacket.field2460, Client.field957.field1484);
                        var8.packetBuffer.putInt(var1);
                        Client.field957.method2052(var8);
                        var19 = class44.getWidget(var1);
                        if(var19.dynamicValues != null && var19.dynamicValues[0][0] == 5) {
                           var10 = var19.dynamicValues[0][1];
                           if(class237.clientVarps[var10] != var19.field2936[0]) {
                              class237.clientVarps[var10] = var19.field2936[0];
                              class18.method142(var10);
                           }
                        }
                     } else if(var2 == 30) {
                        if(Client.field1033 == null) {
                           TotalQuantityComparator.method98(var1, var0);
                           Client.field1033 = FontName.getWidgetChild(var1, var0);
                           FontName.method5490(Client.field1033);
                        }
                     } else if(var2 == 31) {
                        var8 = WorldMapRectangle.method280(ClientPacket.field2444, Client.field957.field1484);
                        var8.packetBuffer.method3559(BoundingBox.field251);
                        var8.packetBuffer.method3561(var1);
                        var8.packetBuffer.method3550(class2.field16);
                        var8.packetBuffer.method3528(UrlRequester.selectedItemIndex);
                        var8.packetBuffer.method3551(var3);
                        var8.packetBuffer.method3528(var0);
                        Client.field957.method2052(var8);
                        Client.mouseCrosshair = 0;
                        class2.field17 = class44.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 32) {
                        var8 = WorldMapRectangle.method280(ClientPacket.field2456, Client.field957.field1484);
                        var8.packetBuffer.method3559(class234.field2768);
                        var8.packetBuffer.method3559(var1);
                        var8.packetBuffer.method3551(var0);
                        var8.packetBuffer.method3550(Client.field1025);
                        var8.packetBuffer.putShort(var3);
                        Client.field957.method2052(var8);
                        Client.mouseCrosshair = 0;
                        class2.field17 = class44.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 33) {
                        var8 = WorldMapRectangle.method280(ClientPacket.field2418, Client.field957.field1484);
                        var8.packetBuffer.method3561(var1);
                        var8.packetBuffer.method3551(var3);
                        var8.packetBuffer.putShort(var0);
                        Client.field957.method2052(var8);
                        Client.mouseCrosshair = 0;
                        class2.field17 = class44.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 34) {
                        var8 = WorldMapRectangle.method280(ClientPacket.field2440, Client.field957.field1484);
                        var8.packetBuffer.method3550(var0);
                        var8.packetBuffer.method3561(var1);
                        var8.packetBuffer.method3551(var3);
                        Client.field957.method2052(var8);
                        Client.mouseCrosshair = 0;
                        class2.field17 = class44.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 35) {
                        var8 = WorldMapRectangle.method280(ClientPacket.field2448, Client.field957.field1484);
                        var8.packetBuffer.method3561(var1);
                        var8.packetBuffer.method3550(var0);
                        var8.packetBuffer.putShort(var3);
                        Client.field957.method2052(var8);
                        Client.mouseCrosshair = 0;
                        class2.field17 = class44.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 36) {
                        var8 = WorldMapRectangle.method280(ClientPacket.field2383, Client.field957.field1484);
                        var8.packetBuffer.method3551(var3);
                        var8.packetBuffer.method3559(var1);
                        var8.packetBuffer.putShort(var0);
                        Client.field957.method2052(var8);
                        Client.mouseCrosshair = 0;
                        class2.field17 = class44.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 37) {
                        var8 = WorldMapRectangle.method280(ClientPacket.field2436, Client.field957.field1484);
                        var8.packetBuffer.method3528(var3);
                        var8.packetBuffer.method3561(var1);
                        var8.packetBuffer.putShort(var0);
                        Client.field957.method2052(var8);
                        Client.mouseCrosshair = 0;
                        class2.field17 = class44.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else {
                        if(var2 == 38) {
                           class154.method3156();
                           var22 = class44.getWidget(var1);
                           Client.itemSelectionState = 1;
                           UrlRequester.selectedItemIndex = var0;
                           BoundingBox.field251 = var1;
                           class2.field16 = var3;
                           FontName.method5490(var22);
                           Client.lastSelectedItemName = class45.getColTags(16748608) + class47.getItemDefinition(var3).name + class45.getColTags(16777215);
                           if(Client.lastSelectedItemName == null) {
                              Client.lastSelectedItemName = "null";
                           }

                           return;
                        }

                        if(var2 == 39) {
                           var8 = WorldMapRectangle.method280(ClientPacket.field2463, Client.field957.field1484);
                           var8.packetBuffer.putShort(var3);
                           var8.packetBuffer.method3559(var1);
                           var8.packetBuffer.method3528(var0);
                           Client.field957.method2052(var8);
                           Client.mouseCrosshair = 0;
                           class2.field17 = class44.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 40) {
                           var8 = WorldMapRectangle.method280(ClientPacket.field2446, Client.field957.field1484);
                           var8.packetBuffer.method3559(var1);
                           var8.packetBuffer.method3551(var3);
                           var8.packetBuffer.method3528(var0);
                           Client.field957.method2052(var8);
                           Client.mouseCrosshair = 0;
                           class2.field17 = class44.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 41) {
                           var8 = WorldMapRectangle.method280(ClientPacket.field2439, Client.field957.field1484);
                           var8.packetBuffer.method3550(var3);
                           var8.packetBuffer.method3559(var1);
                           var8.packetBuffer.method3528(var0);
                           Client.field957.method2052(var8);
                           Client.mouseCrosshair = 0;
                           class2.field17 = class44.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 42) {
                           var8 = WorldMapRectangle.method280(ClientPacket.field2426, Client.field957.field1484);
                           var8.packetBuffer.method3528(var3);
                           var8.packetBuffer.method3528(var0);
                           var8.packetBuffer.putInt(var1);
                           Client.field957.method2052(var8);
                           Client.mouseCrosshair = 0;
                           class2.field17 = class44.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 43) {
                           var8 = WorldMapRectangle.method280(ClientPacket.field2449, Client.field957.field1484);
                           var8.packetBuffer.method3561(var1);
                           var8.packetBuffer.method3551(var3);
                           var8.packetBuffer.method3528(var0);
                           Client.field957.method2052(var8);
                           Client.mouseCrosshair = 0;
                           class2.field17 = class44.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 44) {
                           var18 = Client.cachedPlayers[var3];
                           if(var18 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field972 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = WorldMapRectangle.method280(ClientPacket.field2401, Client.field957.field1484);
                              var9.packetBuffer.method3542(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.method3551(var3);
                              Client.field957.method2052(var9);
                           }
                        } else if(var2 == 45) {
                           var18 = Client.cachedPlayers[var3];
                           if(var18 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field972 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = WorldMapRectangle.method280(ClientPacket.field2424, Client.field957.field1484);
                              var9.packetBuffer.putShort(var3);
                              var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field957.method2052(var9);
                           }
                        } else if(var2 == 46) {
                           var18 = Client.cachedPlayers[var3];
                           if(var18 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field972 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = WorldMapRectangle.method280(ClientPacket.field2407, Client.field957.field1484);
                              var9.packetBuffer.method3541(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.method3528(var3);
                              Client.field957.method2052(var9);
                           }
                        } else if(var2 == 47) {
                           var18 = Client.cachedPlayers[var3];
                           if(var18 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field972 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = WorldMapRectangle.method280(ClientPacket.field2431, Client.field957.field1484);
                              var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.putShort(var3);
                              Client.field957.method2052(var9);
                           }
                        } else if(var2 == 48) {
                           var18 = Client.cachedPlayers[var3];
                           if(var18 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field972 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = WorldMapRectangle.method280(ClientPacket.field2425, Client.field957.field1484);
                              var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.method3551(var3);
                              Client.field957.method2052(var9);
                           }
                        } else if(var2 == 49) {
                           var18 = Client.cachedPlayers[var3];
                           if(var18 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field972 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = WorldMapRectangle.method280(ClientPacket.field2472, Client.field957.field1484);
                              var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.method3551(var3);
                              Client.field957.method2052(var9);
                           }
                        } else if(var2 == 50) {
                           var18 = Client.cachedPlayers[var3];
                           if(var18 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field972 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = WorldMapRectangle.method280(ClientPacket.field2391, Client.field957.field1484);
                              var9.packetBuffer.putShort(var3);
                              var9.packetBuffer.method3542(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field957.method2052(var9);
                           }
                        } else if(var2 == 51) {
                           var18 = Client.cachedPlayers[var3];
                           if(var18 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field972 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = WorldMapRectangle.method280(ClientPacket.field2387, Client.field957.field1484);
                              var9.packetBuffer.method3551(var3);
                              var9.packetBuffer.method3541(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field957.method2052(var9);
                           }
                        } else {
                           label925: {
                              if(var2 != 57) {
                                 if(var2 == 58) {
                                    var22 = FontName.getWidgetChild(var1, var0);
                                    if(var22 != null) {
                                       var9 = WorldMapRectangle.method280(ClientPacket.field2400, Client.field957.field1484);
                                       var9.packetBuffer.method3552(var1);
                                       var9.packetBuffer.method3561(class234.field2768);
                                       var9.packetBuffer.method3528(Client.field893);
                                       var9.packetBuffer.putShort(var22.itemId);
                                       var9.packetBuffer.method3528(var0);
                                       var9.packetBuffer.method3550(Client.field1025);
                                       Client.field957.method2052(var9);
                                    }
                                    break label925;
                                 }

                                 if(var2 == 1001) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field972 = 0;
                                    Client.destinationX = var0;
                                    Client.destinationY = var1;
                                    var8 = WorldMapRectangle.method280(ClientPacket.field2443, Client.field957.field1484);
                                    var8.packetBuffer.method3528(class23.baseY + var1);
                                    var8.packetBuffer.method3528(var3 >> 14 & 32767);
                                    var8.packetBuffer.method3543(KeyFocusListener.keyPressed[82]?1:0);
                                    var8.packetBuffer.method3528(var0 + class138.baseX);
                                    Client.field957.method2052(var8);
                                    break label925;
                                 }

                                 if(var2 == 1002) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field972 = 0;
                                    var8 = WorldMapRectangle.method280(ClientPacket.field2412, Client.field957.field1484);
                                    var8.packetBuffer.method3550(var3 >> 14 & 32767);
                                    Client.field957.method2052(var8);
                                    break label925;
                                 }

                                 if(var2 == 1003) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field972 = 0;
                                    var16 = Client.cachedNPCs[var3];
                                    if(var16 != null) {
                                       NPCComposition var23 = var16.composition;
                                       if(var23.configs != null) {
                                          var23 = var23.transform();
                                       }

                                       if(var23 != null) {
                                          var14 = WorldMapRectangle.method280(ClientPacket.field2455, Client.field957.field1484);
                                          var14.packetBuffer.method3550(var23.id);
                                          Client.field957.method2052(var14);
                                       }
                                    }
                                    break label925;
                                 }

                                 if(var2 == 1004) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field972 = 0;
                                    var8 = WorldMapRectangle.method280(ClientPacket.field2438, Client.field957.field1484);
                                    var8.packetBuffer.method3528(var3);
                                    Client.field957.method2052(var8);
                                    break label925;
                                 }

                                 if(var2 == 1005) {
                                    var22 = class44.getWidget(var1);
                                    if(var22 != null && var22.itemQuantities[var0] >= 100000) {
                                       class57.sendGameMessage(27, "", var22.itemQuantities[var0] + " x " + class47.getItemDefinition(var3).name);
                                    } else {
                                       var9 = WorldMapRectangle.method280(ClientPacket.field2438, Client.field957.field1484);
                                       var9.packetBuffer.method3528(var3);
                                       Client.field957.method2052(var9);
                                    }

                                    Client.mouseCrosshair = 0;
                                    class2.field17 = class44.getWidget(var1);
                                    Client.pressedItemIndex = var0;
                                    break label925;
                                 }

                                 if(var2 != 1007) {
                                    if(var2 == 1011 || var2 == 1009 || var2 == 1008 || var2 == 1010 || var2 == 1012) {
                                       Preferences.renderOverview.onMapClicked(var2, var3, new Coordinates(var0), new Coordinates(var1));
                                    }
                                    break label925;
                                 }
                              }

                              var22 = FontName.getWidgetChild(var1, var0);
                              if(var22 != null) {
                                 int var20 = var22.itemId;
                                 Widget var21 = FontName.getWidgetChild(var1, var0);
                                 if(var21 != null) {
                                    if(var21.onOpListener != null) {
                                       ScriptEvent var11 = new ScriptEvent();
                                       var11.widget = var21;
                                       var11.field801 = var3;
                                       var11.string = var5;
                                       var11.objs = var21.onOpListener;
                                       AbstractSoundSystem.method2256(var11);
                                    }

                                    boolean var15 = true;
                                    if(var21.contentType > 0) {
                                       var15 = GZipDecompressor.method3461(var21);
                                    }

                                    if(var15 && DynamicObject.method2021(GroundObject.getWidgetClickMask(var21), var3 - 1)) {
                                       PacketNode var12;
                                       if(var3 == 1) {
                                          var12 = WorldMapRectangle.method280(ClientPacket.field2468, Client.field957.field1484);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field957.method2052(var12);
                                       }

                                       if(var3 == 2) {
                                          var12 = WorldMapRectangle.method280(ClientPacket.field2421, Client.field957.field1484);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field957.method2052(var12);
                                       }

                                       if(var3 == 3) {
                                          var12 = WorldMapRectangle.method280(ClientPacket.field2417, Client.field957.field1484);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field957.method2052(var12);
                                       }

                                       if(var3 == 4) {
                                          var12 = WorldMapRectangle.method280(ClientPacket.field2445, Client.field957.field1484);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field957.method2052(var12);
                                       }

                                       if(var3 == 5) {
                                          var12 = WorldMapRectangle.method280(ClientPacket.field2422, Client.field957.field1484);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field957.method2052(var12);
                                       }

                                       if(var3 == 6) {
                                          var12 = WorldMapRectangle.method280(ClientPacket.field2478, Client.field957.field1484);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field957.method2052(var12);
                                       }

                                       if(var3 == 7) {
                                          var12 = WorldMapRectangle.method280(ClientPacket.field2430, Client.field957.field1484);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field957.method2052(var12);
                                       }

                                       if(var3 == 8) {
                                          var12 = WorldMapRectangle.method280(ClientPacket.field2479, Client.field957.field1484);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field957.method2052(var12);
                                       }

                                       if(var3 == 9) {
                                          var12 = WorldMapRectangle.method280(ClientPacket.field2403, Client.field957.field1484);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field957.method2052(var12);
                                       }

                                       if(var3 == 10) {
                                          var12 = WorldMapRectangle.method280(ClientPacket.field2429, Client.field957.field1484);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field957.method2052(var12);
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      if(Client.itemSelectionState != 0) {
         Client.itemSelectionState = 0;
         FontName.method5490(class44.getWidget(BoundingBox.field251));
      }

      if(Client.spellSelected) {
         class154.method3156();
      }

      if(class2.field17 != null && Client.mouseCrosshair == 0) {
         FontName.method5490(class2.field17);
      }

   }
}

import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("NetWriter")
public class NetWriter {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lft;"
   )
   @Export("rssocket")
   class157 rssocket;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   @Export("packetBufferNodes")
   CombatInfoList packetBufferNodes;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 327763393
   )
   int field1242;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   @Export("buffer")
   Buffer buffer;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   public ISAACCipher field1250;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   @Export("packetBuffer")
   PacketBuffer packetBuffer;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lfk;"
   )
   @Export("serverPacket")
   ServerPacket serverPacket;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -937288539
   )
   @Export("packetLength")
   int packetLength;
   @ObfuscatedName("j")
   boolean field1248;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1639779673
   )
   int field1249;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 443275095
   )
   int field1252;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lfk;"
   )
   ServerPacket field1251;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lfk;"
   )
   ServerPacket field1245;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lfk;"
   )
   ServerPacket field1253;

   NetWriter() {
      this.packetBufferNodes = new CombatInfoList();
      this.field1242 = 0;
      this.buffer = new Buffer(5000);
      this.packetBuffer = new PacketBuffer(40000);
      this.serverPacket = null;
      this.packetLength = 0;
      this.field1248 = true;
      this.field1249 = 0;
      this.field1252 = 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-40"
   )
   final void method2020() {
      this.packetBufferNodes.method4080();
      this.field1242 = 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   final void method2034() throws IOException {
      if(this.rssocket != null && this.field1242 > 0) {
         this.buffer.offset = 0;

         while(true) {
            PacketNode var1 = (PacketNode)this.packetBufferNodes.last();
            if(var1 == null || var1.field2280 > this.buffer.payload.length - this.buffer.offset) {
               this.rssocket.vmethod3385(this.buffer.payload, 0, this.buffer.offset);
               this.field1252 = 0;
               break;
            }

            this.buffer.putBytes(var1.packetBuffer.payload, 0, var1.field2280);
            this.field1242 -= var1.field2280;
            var1.unlink();
            var1.packetBuffer.method3551();
            var1.method3479();
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfe;I)V",
      garbageValue = "-1030123495"
   )
   public final void method2019(PacketNode var1) {
      this.packetBufferNodes.addFirst(var1);
      var1.field2280 = var1.packetBuffer.offset;
      var1.packetBuffer.offset = 0;
      this.field1242 += var1.field2280;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lft;I)V",
      garbageValue = "-512597648"
   )
   @Export("setSocket")
   void setSocket(class157 var1) {
      this.rssocket = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-892206329"
   )
   @Export("close")
   void close() {
      if(this.rssocket != null) {
         this.rssocket.vmethod3368();
         this.rssocket = null;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "52"
   )
   void method2024() {
      this.rssocket = null;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)Lft;",
      garbageValue = "-67"
   )
   @Export("getSocket")
   class157 getSocket() {
      return this.rssocket;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILcs;ZI)I",
      garbageValue = "-1694030093"
   )
   static int method2047(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class69.intStack[--class45.intStackSize];
         var4 = OwnWorldComparator.getWidget(var3);
      } else {
         var4 = var2?class184.field2379:FriendManager.field996;
      }

      if(var0 == 1000) {
         class45.intStackSize -= 4;
         var4.originalX = class69.intStack[class45.intStackSize];
         var4.originalY = class69.intStack[class45.intStackSize + 1];
         var4.dynamicX = class69.intStack[class45.intStackSize + 2];
         var4.dynamicY = class69.intStack[class45.intStackSize + 3];
         DState.method3548(var4);
         class37.clientInstance.widgetMethod0(var4);
         if(var3 != -1 && var4.type == 0) {
            class45.method818(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         class45.intStackSize -= 4;
         var4.originalWidth = class69.intStack[class45.intStackSize];
         var4.originalHeight = class69.intStack[class45.intStackSize + 1];
         var4.dynamicWidth = class69.intStack[class45.intStackSize + 2];
         var4.buttonType = class69.intStack[class45.intStackSize + 3];
         DState.method3548(var4);
         class37.clientInstance.widgetMethod0(var4);
         if(var3 != -1 && var4.type == 0) {
            class45.method818(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class69.intStack[--class45.intStackSize] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            DState.method3548(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.noClickThrough = class69.intStack[--class45.intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.noScrollThrough = class69.intStack[--class45.intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "571124311"
   )
   static final void method2030() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      if(Client.field678 == 0) {
         var0 = MilliTimer.localPlayer.x;
         var1 = MilliTimer.localPlayer.y;
         if(Signlink.field1979 - var0 < -500 || Signlink.field1979 - var0 > 500 || ItemContainer.field481 - var1 < -500 || ItemContainer.field481 - var1 > 500) {
            Signlink.field1979 = var0;
            ItemContainer.field481 = var1;
         }

         if(var0 != Signlink.field1979) {
            Signlink.field1979 += (var0 - Signlink.field1979) / 16;
         }

         if(var1 != ItemContainer.field481) {
            ItemContainer.field481 += (var1 - ItemContainer.field481) / 16;
         }

         var2 = Signlink.field1979 >> 7;
         var3 = ItemContainer.field481 >> 7;
         var4 = class264.getTileHeight(Signlink.field1979, ItemContainer.field481, class192.plane);
         var5 = 0;
         int var6;
         if(var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
            for(var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
               for(int var7 = var3 - 4; var7 <= var3 + 4; ++var7) {
                  int var8 = class192.plane;
                  if(var8 < 3 && (class50.tileSettings[1][var6][var7] & 2) == 2) {
                     ++var8;
                  }

                  int var9 = var4 - class50.tileHeights[var8][var6][var7];
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

         if(var6 < 32768) {
            var6 = 32768;
         }

         if(var6 > Client.field723) {
            Client.field723 += (var6 - Client.field723) / 24;
         } else if(var6 < Client.field723) {
            Client.field723 += (var6 - Client.field723) / 80;
         }

         Client.field857 = class264.getTileHeight(MilliTimer.localPlayer.x, MilliTimer.localPlayer.y, class192.plane) - Client.field668;
      } else if(Client.field678 == 1) {
         ScriptState.method1061();
         short var10 = -1;
         if(KeyFocusListener.keyPressed[33]) {
            var10 = 0;
         } else if(KeyFocusListener.keyPressed[49]) {
            var10 = 1024;
         }

         if(KeyFocusListener.keyPressed[48]) {
            if(var10 == 0) {
               var10 = 1792;
            } else if(var10 == 1024) {
               var10 = 1280;
            } else {
               var10 = 1536;
            }
         } else if(KeyFocusListener.keyPressed[50]) {
            if(var10 == 0) {
               var10 = 256;
            } else if(var10 == 1024) {
               var10 = 768;
            } else {
               var10 = 512;
            }
         }

         byte var11 = 0;
         if(KeyFocusListener.keyPressed[35]) {
            var11 = -1;
         } else if(KeyFocusListener.keyPressed[51]) {
            var11 = 1;
         }

         var2 = 0;
         if(var10 >= 0 || var11 != 0) {
            var2 = KeyFocusListener.keyPressed[81]?Client.field673:Client.field672;
            var2 *= 16;
            Client.field804 = var10;
            Client.field671 = var11;
         }

         if(Client.field602 < var2) {
            Client.field602 += var2 / 8;
            if(Client.field602 > var2) {
               Client.field602 = var2;
            }
         } else if(Client.field602 > var2) {
            Client.field602 = Client.field602 * 9 / 10;
         }

         if(Client.field602 > 0) {
            var3 = Client.field602 / 16;
            if(Client.field804 >= 0) {
               var0 = Client.field804 - WidgetNode.cameraYaw & 2047;
               var4 = Graphics3D.SINE[var0];
               var5 = Graphics3D.COSINE[var0];
               Signlink.field1979 += var4 * var3 / 65536;
               ItemContainer.field481 += var3 * var5 / 65536;
            }

            if(Client.field671 != 0) {
               Client.field857 += var3 * Client.field671;
               if(Client.field857 > 0) {
                  Client.field857 = 0;
               }
            }
         } else {
            Client.field804 = -1;
            Client.field671 = -1;
         }

         if(KeyFocusListener.keyPressed[13]) {
            Client.field739.method2019(DecorativeObject.method3115(ClientPacket.field2183, Client.field739.field1250));
            Client.field678 = 0;
         }
      }

      if(MouseInput.mouseCurrentButton == 4 && class8.middleMouseMovesCamera) {
         var0 = MouseInput.mouseLastY - Client.field627;
         Client.field767 = var0 * 2;
         Client.field627 = var0 != -1 && var0 != 1?(MouseInput.mouseLastY + Client.field627) / 2:MouseInput.mouseLastY;
         var1 = Client.field717 - MouseInput.mouseLastX;
         Client.field663 = var1 * 2;
         Client.field717 = var1 != -1 && var1 != 1?(MouseInput.mouseLastX + Client.field717) / 2:MouseInput.mouseLastX;
      } else {
         if(KeyFocusListener.keyPressed[96]) {
            Client.field663 += (-24 - Client.field663) / 2;
         } else if(KeyFocusListener.keyPressed[97]) {
            Client.field663 += (24 - Client.field663) / 2;
         } else {
            Client.field663 /= 2;
         }

         if(KeyFocusListener.keyPressed[98]) {
            Client.field767 += (12 - Client.field767) / 2;
         } else if(KeyFocusListener.keyPressed[99]) {
            Client.field767 += (-12 - Client.field767) / 2;
         } else {
            Client.field767 /= 2;
         }

         Client.field627 = MouseInput.mouseLastY;
         Client.field717 = MouseInput.mouseLastX;
      }

      Client.mapAngle = Client.field663 / 2 + Client.mapAngle & 2047;
      Client.cameraPitchTarget += Client.field767 / 2;
      if(Client.cameraPitchTarget < 128) {
         Client.cameraPitchTarget = 128;
      }

      if(Client.cameraPitchTarget > 383) {
         Client.cameraPitchTarget = 383;
      }

   }
}

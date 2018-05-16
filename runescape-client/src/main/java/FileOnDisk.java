import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.SyncFailedException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("ac")
   static java.awt.Font field1455;
   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   @Export("indexCache4")
   static IndexData indexCache4;
   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "[Llc;"
   )
   @Export("crossSprites")
   static SpritePixels[] crossSprites;
   @ObfuscatedName("w")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 7551439930244237273L
   )
   @Export("length")
   long length;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = -2482160206388848509L
   )
   @Export("position")
   long position;

   public FileOnDisk(File var1, String var2, long var3) throws IOException {
      if(-1L == var3) {
         var3 = Long.MAX_VALUE;
      }

      if(var1.length() >= var3) {
         var1.delete();
      }

      this.file = new RandomAccessFile(var1, var2);
      this.length = var3;
      this.position = 0L;
      int var5 = this.file.read();
      if(var5 != -1 && !var2.equals("r")) {
         this.file.seek(0L);
         this.file.write(var5);
      }

      this.file.seek(0L);
   }

   @ObfuscatedName("w")
   @Export("seek")
   final void seek(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1908424664"
   )
   @Export("write")
   public final void write(byte[] var1, int var2, int var3) throws IOException {
      if((long)var3 + this.position > this.length) {
         this.file.seek(this.length + 1L);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += (long)var3;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-911450874"
   )
   @Export("close")
   public final void close() throws IOException {
      this.closeSync(false);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1927514146"
   )
   @Export("closeSync")
   public final void closeSync(boolean var1) throws IOException {
      if(this.file != null) {
         if(var1) {
            try {
               this.file.getFD().sync();
            } catch (SyncFailedException var3) {
               ;
            }
         }

         this.file.close();
         this.file = null;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1612176979"
   )
   @Export("length")
   public final long length() throws IOException {
      return this.file.length();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-788517916"
   )
   @Export("read")
   public final int read(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   protected void finalize() throws Throwable {
      if(this.file != null) {
         System.out.println("");
         this.close();
      }

   }

   @ObfuscatedName("w")
   static double method2581(double var0) {
      return Math.exp(-var0 * var0 / 2.0D) / Math.sqrt(6.283185307179586D);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ZZI)I",
      garbageValue = "-1606352773"
   )
   public static int method2580(boolean var0, boolean var1) {
      byte var2 = 0;
      int var3 = var2 + class250.NetCache_pendingPriorityResponsesCount + class250.NetCache_pendingPriorityWritesCount;
      return var3;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-86"
   )
   protected static final void method2579() {
      GameEngine.timer.vmethod3346();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field390[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field397[var0] = 0L;
      }

      Ignore.field3645 = 0;
   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "1839884179"
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
         Client.field843 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = DecorativeObject.method3115(ClientPacket.field2202, Client.field739.field1250);
         var8.packetBuffer.method3707(var0 + class178.baseX);
         var8.packetBuffer.method3605(class59.selectedItemIndex);
         var8.packetBuffer.method3595(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.method3725(CombatInfoListHolder.baseY + var1);
         var8.packetBuffer.putShort(class24.field220);
         var8.packetBuffer.method3725(var3);
         var8.packetBuffer.method3641(Huffman.field2296);
         Client.field739.method2019(var8);
      } else if(var2 == 2) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field843 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = DecorativeObject.method3115(ClientPacket.field2222, Client.field739.field1250);
         var8.packetBuffer.method3595(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.method3725(var0 + class178.baseX);
         var8.packetBuffer.method3605(var3);
         var8.packetBuffer.putShort(Client.field748);
         var8.packetBuffer.putInt(class142.field1911);
         var8.packetBuffer.method3605(CombatInfoListHolder.baseY + var1);
         Client.field739.method2019(var8);
      } else if(var2 == 3) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field843 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = DecorativeObject.method3115(ClientPacket.field2191, Client.field739.field1250);
         var8.packetBuffer.method3725(var3);
         var8.packetBuffer.method3605(CombatInfoListHolder.baseY + var1);
         var8.packetBuffer.method3605(var0 + class178.baseX);
         var8.packetBuffer.method3596(KeyFocusListener.keyPressed[82]?1:0);
         Client.field739.method2019(var8);
      } else if(var2 == 4) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field843 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = DecorativeObject.method3115(ClientPacket.field2168, Client.field739.field1250);
         var8.packetBuffer.method3707(var0 + class178.baseX);
         var8.packetBuffer.method3595(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.putShort(CombatInfoListHolder.baseY + var1);
         var8.packetBuffer.method3605(var3);
         Client.field739.method2019(var8);
      } else if(var2 == 5) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field843 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = DecorativeObject.method3115(ClientPacket.field2170, Client.field739.field1250);
         var8.packetBuffer.method3605(CombatInfoListHolder.baseY + var1);
         var8.packetBuffer.putShort(var3);
         var8.packetBuffer.method3595(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.putShort(var0 + class178.baseX);
         Client.field739.method2019(var8);
      } else if(var2 == 6) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field843 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = DecorativeObject.method3115(ClientPacket.field2188, Client.field739.field1250);
         var8.packetBuffer.method3596(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.method3707(var0 + class178.baseX);
         var8.packetBuffer.putShort(var3);
         var8.packetBuffer.method3725(CombatInfoListHolder.baseY + var1);
         Client.field739.method2019(var8);
      } else {
         PacketNode var9;
         NPC var19;
         if(var2 == 7) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field843 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = DecorativeObject.method3115(ClientPacket.field2181, Client.field739.field1250);
               var9.packetBuffer.method3594(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3670(Huffman.field2296);
               var9.packetBuffer.method3707(class59.selectedItemIndex);
               var9.packetBuffer.method3605(class24.field220);
               var9.packetBuffer.putShort(var3);
               Client.field739.method2019(var9);
            }
         } else if(var2 == 8) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field843 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = DecorativeObject.method3115(ClientPacket.field2212, Client.field739.field1250);
               var9.packetBuffer.method3641(class142.field1911);
               var9.packetBuffer.putShort(var3);
               var9.packetBuffer.method3596(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3725(Client.field748);
               Client.field739.method2019(var9);
            }
         } else if(var2 == 9) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field843 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = DecorativeObject.method3115(ClientPacket.field2179, Client.field739.field1250);
               var9.packetBuffer.method3725(var3);
               var9.packetBuffer.method3596(KeyFocusListener.keyPressed[82]?1:0);
               Client.field739.method2019(var9);
            }
         } else if(var2 == 10) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field843 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = DecorativeObject.method3115(ClientPacket.field2235, Client.field739.field1250);
               var9.packetBuffer.putShort(var3);
               var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               Client.field739.method2019(var9);
            }
         } else if(var2 == 11) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field843 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = DecorativeObject.method3115(ClientPacket.field2185, Client.field739.field1250);
               var9.packetBuffer.method3595(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3707(var3);
               Client.field739.method2019(var9);
            }
         } else if(var2 == 12) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field843 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = DecorativeObject.method3115(ClientPacket.field2192, Client.field739.field1250);
               var9.packetBuffer.method3594(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.method3605(var3);
               Client.field739.method2019(var9);
            }
         } else if(var2 == 13) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field843 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = DecorativeObject.method3115(ClientPacket.field2189, Client.field739.field1250);
               var9.packetBuffer.method3707(var3);
               var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               Client.field739.method2019(var9);
            }
         } else {
            Player var22;
            if(var2 == 14) {
               var22 = Client.cachedPlayers[var3];
               if(var22 != null) {
                  Client.lastLeftClickX = var6;
                  Client.lastLeftClickY = var7;
                  Client.cursorState = 2;
                  Client.field843 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var9 = DecorativeObject.method3115(ClientPacket.field2223, Client.field739.field1250);
                  var9.packetBuffer.method3670(Huffman.field2296);
                  var9.packetBuffer.putShort(class59.selectedItemIndex);
                  var9.packetBuffer.method3605(var3);
                  var9.packetBuffer.method3605(class24.field220);
                  var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                  Client.field739.method2019(var9);
               }
            } else if(var2 == 15) {
               var22 = Client.cachedPlayers[var3];
               if(var22 != null) {
                  Client.lastLeftClickX = var6;
                  Client.lastLeftClickY = var7;
                  Client.cursorState = 2;
                  Client.field843 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var9 = DecorativeObject.method3115(ClientPacket.field2234, Client.field739.field1250);
                  var9.packetBuffer.method3725(Client.field748);
                  var9.packetBuffer.method3641(class142.field1911);
                  var9.packetBuffer.method3594(KeyFocusListener.keyPressed[82]?1:0);
                  var9.packetBuffer.method3707(var3);
                  Client.field739.method2019(var9);
               }
            } else if(var2 == 16) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field843 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = DecorativeObject.method3115(ClientPacket.field2242, Client.field739.field1250);
               var8.packetBuffer.method3605(var3);
               var8.packetBuffer.method3605(var0 + class178.baseX);
               var8.packetBuffer.method3641(Huffman.field2296);
               var8.packetBuffer.method3594(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.putShort(class59.selectedItemIndex);
               var8.packetBuffer.method3725(CombatInfoListHolder.baseY + var1);
               var8.packetBuffer.putShort(class24.field220);
               Client.field739.method2019(var8);
            } else if(var2 == 17) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field843 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = DecorativeObject.method3115(ClientPacket.field2254, Client.field739.field1250);
               var8.packetBuffer.method3707(CombatInfoListHolder.baseY + var1);
               var8.packetBuffer.method3605(Client.field748);
               var8.packetBuffer.method3725(var0 + class178.baseX);
               var8.packetBuffer.method3596(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3641(class142.field1911);
               var8.packetBuffer.method3605(var3);
               Client.field739.method2019(var8);
            } else if(var2 == 18) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field843 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = DecorativeObject.method3115(ClientPacket.field2232, Client.field739.field1250);
               var8.packetBuffer.putShort(var3);
               var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.putShort(CombatInfoListHolder.baseY + var1);
               var8.packetBuffer.method3707(var0 + class178.baseX);
               Client.field739.method2019(var8);
            } else if(var2 == 19) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field843 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = DecorativeObject.method3115(ClientPacket.field2257, Client.field739.field1250);
               var8.packetBuffer.method3707(var0 + class178.baseX);
               var8.packetBuffer.putShort(CombatInfoListHolder.baseY + var1);
               var8.packetBuffer.method3707(var3);
               var8.packetBuffer.method3595(KeyFocusListener.keyPressed[82]?1:0);
               Client.field739.method2019(var8);
            } else if(var2 == 20) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field843 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = DecorativeObject.method3115(ClientPacket.field2211, Client.field739.field1250);
               var8.packetBuffer.putShort(var3);
               var8.packetBuffer.method3594(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3725(var0 + class178.baseX);
               var8.packetBuffer.method3725(CombatInfoListHolder.baseY + var1);
               Client.field739.method2019(var8);
            } else if(var2 == 21) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field843 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = DecorativeObject.method3115(ClientPacket.field2173, Client.field739.field1250);
               var8.packetBuffer.method3707(var3);
               var8.packetBuffer.method3605(var0 + class178.baseX);
               var8.packetBuffer.method3594(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3605(CombatInfoListHolder.baseY + var1);
               Client.field739.method2019(var8);
            } else if(var2 == 22) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field843 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = DecorativeObject.method3115(ClientPacket.field2195, Client.field739.field1250);
               var8.packetBuffer.method3725(CombatInfoListHolder.baseY + var1);
               var8.packetBuffer.method3605(var3);
               var8.packetBuffer.method3594(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.method3605(var0 + class178.baseX);
               Client.field739.method2019(var8);
            } else if(var2 == 23) {
               if(Client.isMenuOpen) {
                  ScriptEvent.region.method2939();
               } else {
                  ScriptEvent.region.method2938(class192.plane, var0, var1, true);
               }
            } else {
               PacketNode var10;
               Widget var23;
               if(var2 == 24) {
                  var23 = OwnWorldComparator.getWidget(var1);
                  boolean var15 = true;
                  if(var23.contentType > 0) {
                     var15 = class15.method163(var23);
                  }

                  if(var15) {
                     var10 = DecorativeObject.method3115(ClientPacket.field2231, Client.field739.field1250);
                     var10.packetBuffer.putInt(var1);
                     Client.field739.method2019(var10);
                  }
               } else {
                  int var17;
                  int var25;
                  if(var2 == 25) {
                     var23 = class21.getWidgetChild(var1, var0);
                     if(var23 != null) {
                        WorldMapRegion.method456();
                        var17 = AbstractSoundSystem.getWidgetClickMask(var23);
                        var25 = var17 >> 11 & 63;
                        int var18 = var23.itemId;
                        Widget var13 = class21.getWidgetChild(var1, var0);
                        if(var13 != null && var13.onTargetEnterListener != null) {
                           ScriptEvent var14 = new ScriptEvent();
                           var14.source = var13;
                           var14.params = var13.onTargetEnterListener;
                           FriendManager.method1728(var14);
                        }

                        Client.field749 = var18;
                        Client.spellSelected = true;
                        class142.field1911 = var1;
                        Client.field748 = var0;
                        class45.field373 = var25;
                        DState.method3548(var13);
                        Client.itemSelectionState = 0;
                        Client.field750 = class11.method111(var23);
                        if(Client.field750 == null) {
                           Client.field750 = "Null";
                        }

                        if(var23.hasScript) {
                           Client.field751 = var23.opBase + class50.getColTags(16777215);
                        } else {
                           Client.field751 = class50.getColTags(65280) + var23.spellName + class50.getColTags(16777215);
                        }
                     }

                     return;
                  }

                  if(var2 == 26) {
                     class9.method99();
                  } else {
                     Widget var21;
                     if(var2 == 28) {
                        var8 = DecorativeObject.method3115(ClientPacket.field2231, Client.field739.field1250);
                        var8.packetBuffer.putInt(var1);
                        Client.field739.method2019(var8);
                        var21 = OwnWorldComparator.getWidget(var1);
                        if(var21.dynamicValues != null && var21.dynamicValues[0][0] == 5) {
                           var17 = var21.dynamicValues[0][1];
                           class225.clientVarps[var17] = 1 - class225.clientVarps[var17];
                           Widget.method4537(var17);
                        }
                     } else if(var2 == 29) {
                        var8 = DecorativeObject.method3115(ClientPacket.field2231, Client.field739.field1250);
                        var8.packetBuffer.putInt(var1);
                        Client.field739.method2019(var8);
                        var21 = OwnWorldComparator.getWidget(var1);
                        if(var21.dynamicValues != null && var21.dynamicValues[0][0] == 5) {
                           var17 = var21.dynamicValues[0][1];
                           if(class225.clientVarps[var17] != var21.field2738[0]) {
                              class225.clientVarps[var17] = var21.field2738[0];
                              Widget.method4537(var17);
                           }
                        }
                     } else if(var2 == 30) {
                        if(Client.field756 == null) {
                           var8 = DecorativeObject.method3115(ClientPacket.field2225, Client.field739.field1250);
                           var8.packetBuffer.method3670(var1);
                           var8.packetBuffer.method3605(var0);
                           Client.field739.method2019(var8);
                           Client.field756 = class21.getWidgetChild(var1, var0);
                           DState.method3548(Client.field756);
                        }
                     } else if(var2 == 31) {
                        var8 = DecorativeObject.method3115(ClientPacket.field2209, Client.field739.field1250);
                        var8.packetBuffer.putShort(class59.selectedItemIndex);
                        var8.packetBuffer.putInt(Huffman.field2296);
                        var8.packetBuffer.method3725(var3);
                        var8.packetBuffer.method3725(var0);
                        var8.packetBuffer.method3641(var1);
                        var8.packetBuffer.method3725(class24.field220);
                        Client.field739.method2019(var8);
                        Client.mouseCrosshair = 0;
                        class144.field1921 = OwnWorldComparator.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 32) {
                        var8 = DecorativeObject.method3115(ClientPacket.field2204, Client.field739.field1250);
                        var8.packetBuffer.method3641(var1);
                        var8.packetBuffer.method3725(var3);
                        var8.packetBuffer.method3707(Client.field748);
                        var8.packetBuffer.method3725(var0);
                        var8.packetBuffer.method3750(class142.field1911);
                        Client.field739.method2019(var8);
                        Client.mouseCrosshair = 0;
                        class144.field1921 = OwnWorldComparator.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 33) {
                        var8 = DecorativeObject.method3115(ClientPacket.field2187, Client.field739.field1250);
                        var8.packetBuffer.method3605(var3);
                        var8.packetBuffer.putShort(var0);
                        var8.packetBuffer.method3641(var1);
                        Client.field739.method2019(var8);
                        Client.mouseCrosshair = 0;
                        class144.field1921 = OwnWorldComparator.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 34) {
                        var8 = DecorativeObject.method3115(ClientPacket.field2184, Client.field739.field1250);
                        var8.packetBuffer.method3670(var1);
                        var8.packetBuffer.method3605(var0);
                        var8.packetBuffer.putShort(var3);
                        Client.field739.method2019(var8);
                        Client.mouseCrosshair = 0;
                        class144.field1921 = OwnWorldComparator.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 35) {
                        var8 = DecorativeObject.method3115(ClientPacket.field2238, Client.field739.field1250);
                        var8.packetBuffer.method3605(var0);
                        var8.packetBuffer.putInt(var1);
                        var8.packetBuffer.method3707(var3);
                        Client.field739.method2019(var8);
                        Client.mouseCrosshair = 0;
                        class144.field1921 = OwnWorldComparator.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 36) {
                        var8 = DecorativeObject.method3115(ClientPacket.field2199, Client.field739.field1250);
                        var8.packetBuffer.method3707(var0);
                        var8.packetBuffer.method3641(var1);
                        var8.packetBuffer.method3707(var3);
                        Client.field739.method2019(var8);
                        Client.mouseCrosshair = 0;
                        class144.field1921 = OwnWorldComparator.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 37) {
                        var8 = DecorativeObject.method3115(ClientPacket.field2198, Client.field739.field1250);
                        var8.packetBuffer.method3605(var0);
                        var8.packetBuffer.putShort(var3);
                        var8.packetBuffer.method3670(var1);
                        Client.field739.method2019(var8);
                        Client.mouseCrosshair = 0;
                        class144.field1921 = OwnWorldComparator.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else {
                        if(var2 == 38) {
                           WorldMapRegion.method456();
                           var23 = OwnWorldComparator.getWidget(var1);
                           Client.itemSelectionState = 1;
                           class59.selectedItemIndex = var0;
                           Huffman.field2296 = var1;
                           class24.field220 = var3;
                           DState.method3548(var23);
                           Client.lastSelectedItemName = class50.getColTags(16748608) + class120.getItemDefinition(var3).name + class50.getColTags(16777215);
                           if(Client.lastSelectedItemName == null) {
                              Client.lastSelectedItemName = "null";
                           }

                           return;
                        }

                        if(var2 == 39) {
                           var8 = DecorativeObject.method3115(ClientPacket.field2196, Client.field739.field1250);
                           var8.packetBuffer.method3707(var3);
                           var8.packetBuffer.putShort(var0);
                           var8.packetBuffer.method3641(var1);
                           Client.field739.method2019(var8);
                           Client.mouseCrosshair = 0;
                           class144.field1921 = OwnWorldComparator.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 40) {
                           var8 = DecorativeObject.method3115(ClientPacket.field2172, Client.field739.field1250);
                           var8.packetBuffer.putShort(var0);
                           var8.packetBuffer.method3641(var1);
                           var8.packetBuffer.method3707(var3);
                           Client.field739.method2019(var8);
                           Client.mouseCrosshair = 0;
                           class144.field1921 = OwnWorldComparator.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 41) {
                           var8 = DecorativeObject.method3115(ClientPacket.field2221, Client.field739.field1250);
                           var8.packetBuffer.putInt(var1);
                           var8.packetBuffer.putShort(var3);
                           var8.packetBuffer.method3707(var0);
                           Client.field739.method2019(var8);
                           Client.mouseCrosshair = 0;
                           class144.field1921 = OwnWorldComparator.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 42) {
                           var8 = DecorativeObject.method3115(ClientPacket.field2230, Client.field739.field1250);
                           var8.packetBuffer.method3605(var3);
                           var8.packetBuffer.method3725(var0);
                           var8.packetBuffer.method3670(var1);
                           Client.field739.method2019(var8);
                           Client.mouseCrosshair = 0;
                           class144.field1921 = OwnWorldComparator.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 43) {
                           var8 = DecorativeObject.method3115(ClientPacket.field2220, Client.field739.field1250);
                           var8.packetBuffer.putShort(var3);
                           var8.packetBuffer.method3707(var0);
                           var8.packetBuffer.putInt(var1);
                           Client.field739.method2019(var8);
                           Client.mouseCrosshair = 0;
                           class144.field1921 = OwnWorldComparator.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 44) {
                           var22 = Client.cachedPlayers[var3];
                           if(var22 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field843 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = DecorativeObject.method3115(ClientPacket.field2213, Client.field739.field1250);
                              var9.packetBuffer.method3605(var3);
                              var9.packetBuffer.method3594(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field739.method2019(var9);
                           }
                        } else if(var2 == 45) {
                           var22 = Client.cachedPlayers[var3];
                           if(var22 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field843 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = DecorativeObject.method3115(ClientPacket.field2216, Client.field739.field1250);
                              var9.packetBuffer.method3595(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.method3605(var3);
                              Client.field739.method2019(var9);
                           }
                        } else if(var2 == 46) {
                           var22 = Client.cachedPlayers[var3];
                           if(var22 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field843 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = DecorativeObject.method3115(ClientPacket.field2160, Client.field739.field1250);
                              var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.method3707(var3);
                              Client.field739.method2019(var9);
                           }
                        } else if(var2 == 47) {
                           var22 = Client.cachedPlayers[var3];
                           if(var22 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field843 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = DecorativeObject.method3115(ClientPacket.field2218, Client.field739.field1250);
                              var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.method3725(var3);
                              Client.field739.method2019(var9);
                           }
                        } else if(var2 == 48) {
                           var22 = Client.cachedPlayers[var3];
                           if(var22 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field843 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = DecorativeObject.method3115(ClientPacket.field2233, Client.field739.field1250);
                              var9.packetBuffer.method3596(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.method3707(var3);
                              Client.field739.method2019(var9);
                           }
                        } else if(var2 == 49) {
                           var22 = Client.cachedPlayers[var3];
                           if(var22 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field843 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = DecorativeObject.method3115(ClientPacket.field2164, Client.field739.field1250);
                              var9.packetBuffer.method3707(var3);
                              var9.packetBuffer.method3594(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field739.method2019(var9);
                           }
                        } else if(var2 == 50) {
                           var22 = Client.cachedPlayers[var3];
                           if(var22 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field843 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = DecorativeObject.method3115(ClientPacket.field2180, Client.field739.field1250);
                              var9.packetBuffer.method3725(var3);
                              var9.packetBuffer.method3594(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field739.method2019(var9);
                           }
                        } else if(var2 == 51) {
                           var22 = Client.cachedPlayers[var3];
                           if(var22 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field843 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = DecorativeObject.method3115(ClientPacket.field2203, Client.field739.field1250);
                              var9.packetBuffer.method3595(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.putShort(var3);
                              Client.field739.method2019(var9);
                           }
                        } else {
                           label1076: {
                              if(var2 != 57) {
                                 if(var2 == 58) {
                                    var23 = class21.getWidgetChild(var1, var0);
                                    if(var23 != null) {
                                       var9 = DecorativeObject.method3115(ClientPacket.field2194, Client.field739.field1250);
                                       var9.packetBuffer.method3750(var1);
                                       var9.packetBuffer.method3670(class142.field1911);
                                       var9.packetBuffer.method3725(var0);
                                       var9.packetBuffer.method3605(Client.field748);
                                       var9.packetBuffer.method3605(var23.itemId);
                                       var9.packetBuffer.method3605(Client.field749);
                                       Client.field739.method2019(var9);
                                    }
                                    break label1076;
                                 }

                                 if(var2 == 1001) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field843 = 0;
                                    Client.destinationX = var0;
                                    Client.destinationY = var1;
                                    var8 = DecorativeObject.method3115(ClientPacket.field2175, Client.field739.field1250);
                                    var8.packetBuffer.method3605(CombatInfoListHolder.baseY + var1);
                                    var8.packetBuffer.method3595(KeyFocusListener.keyPressed[82]?1:0);
                                    var8.packetBuffer.method3725(var0 + class178.baseX);
                                    var8.packetBuffer.method3725(var3);
                                    Client.field739.method2019(var8);
                                    break label1076;
                                 }

                                 if(var2 == 1002) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field843 = 0;
                                    var8 = DecorativeObject.method3115(ClientPacket.field2241, Client.field739.field1250);
                                    var8.packetBuffer.method3605(var3);
                                    Client.field739.method2019(var8);
                                    break label1076;
                                 }

                                 if(var2 == 1003) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field843 = 0;
                                    var19 = Client.cachedNPCs[var3];
                                    if(var19 != null) {
                                       NPCComposition var24 = var19.composition;
                                       if(var24.configs != null) {
                                          var24 = var24.transform();
                                       }

                                       if(var24 != null) {
                                          var10 = DecorativeObject.method3115(ClientPacket.field2236, Client.field739.field1250);
                                          var10.packetBuffer.method3605(var24.id);
                                          Client.field739.method2019(var10);
                                       }
                                    }
                                    break label1076;
                                 }

                                 if(var2 == 1004) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field843 = 0;
                                    var8 = DecorativeObject.method3115(ClientPacket.field2252, Client.field739.field1250);
                                    var8.packetBuffer.method3707(var3);
                                    Client.field739.method2019(var8);
                                    break label1076;
                                 }

                                 if(var2 == 1005) {
                                    var23 = OwnWorldComparator.getWidget(var1);
                                    if(var23 != null && var23.itemQuantities[var0] >= 100000) {
                                       OwnWorldComparator.sendGameMessage(27, "", var23.itemQuantities[var0] + " x " + class120.getItemDefinition(var3).name);
                                    } else {
                                       var9 = DecorativeObject.method3115(ClientPacket.field2252, Client.field739.field1250);
                                       var9.packetBuffer.method3707(var3);
                                       Client.field739.method2019(var9);
                                    }

                                    Client.mouseCrosshair = 0;
                                    class144.field1921 = OwnWorldComparator.getWidget(var1);
                                    Client.pressedItemIndex = var0;
                                    break label1076;
                                 }

                                 if(var2 != 1007) {
                                    if(var2 == 1011 || var2 == 1009 || var2 == 1008 || var2 == 1010 || var2 == 1012) {
                                       Preferences.renderOverview.onMapClicked(var2, var3, new Coordinates(var0), new Coordinates(var1));
                                    }
                                    break label1076;
                                 }
                              }

                              var23 = class21.getWidgetChild(var1, var0);
                              if(var23 != null) {
                                 var25 = var23.itemId;
                                 Widget var20 = class21.getWidgetChild(var1, var0);
                                 if(var20 != null) {
                                    if(var20.onOpListener != null) {
                                       ScriptEvent var11 = new ScriptEvent();
                                       var11.source = var20;
                                       var11.op = var3;
                                       var11.opbase = var5;
                                       var11.params = var20.onOpListener;
                                       FriendManager.method1728(var11);
                                    }

                                    boolean var16 = true;
                                    if(var20.contentType > 0) {
                                       var16 = class15.method163(var20);
                                    }

                                    if(var16 && MilliTimer.method3219(AbstractSoundSystem.getWidgetClickMask(var20), var3 - 1)) {
                                       PacketNode var12;
                                       if(var3 == 1) {
                                          var12 = DecorativeObject.method3115(ClientPacket.field2224, Client.field739.field1250);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var25);
                                          Client.field739.method2019(var12);
                                       }

                                       if(var3 == 2) {
                                          var12 = DecorativeObject.method3115(ClientPacket.field2174, Client.field739.field1250);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var25);
                                          Client.field739.method2019(var12);
                                       }

                                       if(var3 == 3) {
                                          var12 = DecorativeObject.method3115(ClientPacket.field2158, Client.field739.field1250);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var25);
                                          Client.field739.method2019(var12);
                                       }

                                       if(var3 == 4) {
                                          var12 = DecorativeObject.method3115(ClientPacket.field2171, Client.field739.field1250);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var25);
                                          Client.field739.method2019(var12);
                                       }

                                       if(var3 == 5) {
                                          var12 = DecorativeObject.method3115(ClientPacket.field2226, Client.field739.field1250);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var25);
                                          Client.field739.method2019(var12);
                                       }

                                       if(var3 == 6) {
                                          var12 = DecorativeObject.method3115(ClientPacket.field2177, Client.field739.field1250);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var25);
                                          Client.field739.method2019(var12);
                                       }

                                       if(var3 == 7) {
                                          var12 = DecorativeObject.method3115(ClientPacket.field2178, Client.field739.field1250);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var25);
                                          Client.field739.method2019(var12);
                                       }

                                       if(var3 == 8) {
                                          var12 = DecorativeObject.method3115(ClientPacket.field2229, Client.field739.field1250);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var25);
                                          Client.field739.method2019(var12);
                                       }

                                       if(var3 == 9) {
                                          var12 = DecorativeObject.method3115(ClientPacket.field2215, Client.field739.field1250);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var25);
                                          Client.field739.method2019(var12);
                                       }

                                       if(var3 == 10) {
                                          var12 = DecorativeObject.method3115(ClientPacket.field2245, Client.field739.field1250);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var25);
                                          Client.field739.method2019(var12);
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
         DState.method3548(OwnWorldComparator.getWidget(Huffman.field2296));
      }

      if(Client.spellSelected) {
         WorldMapRegion.method456();
      }

      if(class144.field1921 != null && Client.mouseCrosshair == 0) {
         DState.method3548(class144.field1921);
      }

   }
}

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
@Implements("DynamicObject")
public class DynamicObject extends Entity {
   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "Lfu;"
   )
   @Export("js5Socket")
   static AbstractSocket js5Socket;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1369707199
   )
   @Export("id")
   int id;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1713856147
   )
   @Export("type")
   int type;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 141031459
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 844945979
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -351084819
   )
   @Export("x")
   int x;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -126308963
   )
   @Export("y")
   int y;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   @Export("sequenceDefinition")
   SequenceDefinition sequenceDefinition;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2017547185
   )
   @Export("frame")
   int frame;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1596313489
   )
   @Export("cycleStart")
   int cycleStart;

   @ObfuscatedSignature(
      signature = "(IIIIIIIZLex;)V"
   )
   DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Entity var9) {
      this.id = var1;
      this.type = var2;
      this.orientation = var3;
      this.plane = var4;
      this.x = var5;
      this.y = var6;
      if(var7 != -1) {
         this.sequenceDefinition = WorldMapAreaData.getSequenceDefinition(var7);
         this.frame = 0;
         this.cycleStart = Client.cycle - 1;
         if(this.sequenceDefinition.__t == 0 && var9 != null && var9 instanceof DynamicObject) {
            DynamicObject var10 = (DynamicObject)var9;
            if(this.sequenceDefinition == var10.sequenceDefinition) {
               this.frame = var10.frame;
               this.cycleStart = var10.cycleStart;
               return;
            }
         }

         if(var8 && this.sequenceDefinition.frameCount != -1) {
            this.frame = (int)(Math.random() * (double)this.sequenceDefinition.frameIds.length);
            this.cycleStart -= (int)(Math.random() * (double)this.sequenceDefinition.frameLengths[this.frame]);
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Ldu;",
      garbageValue = "-2134947096"
   )
   protected final Model getModel() {
      if(this.sequenceDefinition != null) {
         int var1 = Client.cycle - this.cycleStart;
         if(var1 > 100 && this.sequenceDefinition.frameCount > 0) {
            var1 = 100;
         }

         label47: {
            do {
               do {
                  if(var1 <= this.sequenceDefinition.frameLengths[this.frame]) {
                     break label47;
                  }

                  var1 -= this.sequenceDefinition.frameLengths[this.frame];
                  ++this.frame;
               } while(this.frame < this.sequenceDefinition.frameIds.length);

               this.frame -= this.sequenceDefinition.frameCount;
            } while(this.frame >= 0 && this.frame < this.sequenceDefinition.frameIds.length);

            this.sequenceDefinition = null;
         }

         this.cycleStart = Client.cycle - var1;
      }

      ObjectDefinition var12 = class50.getObjectDefinition(this.id);
      if(var12.transforms != null) {
         var12 = var12.transform();
      }

      if(var12 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.orientation != 1 && this.orientation != 3) {
            var2 = var12.sizeX;
            var3 = var12.sizeY;
         } else {
            var2 = var12.sizeY;
            var3 = var12.sizeX;
         }

         int var4 = (var2 >> 1) + this.x;
         int var5 = (var2 + 1 >> 1) + this.x;
         int var6 = (var3 >> 1) + this.y;
         int var7 = (var3 + 1 >> 1) + this.y;
         int[][] var8 = Tiles.Tiles_heights[this.plane];
         int var9 = var8[var5][var6] + var8[var4][var6] + var8[var4][var7] + var8[var5][var7] >> 2;
         int var10 = (this.x << 7) + (var2 << 6);
         int var11 = (this.y << 7) + (var3 << 6);
         return var12.getModelDynamic(this.type, this.orientation, var8, var10, var9, var11, this.sequenceDefinition, this.frame);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "1172859329"
   )
   static void method2218(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method2218(var0, var1, var2, var5 - 1);
         method2218(var0, var1, var5 + 1, var3);
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(ILcg;ZB)I",
      garbageValue = "-83"
   )
   static int method2223(int var0, Script var1, boolean var2) {
      if(var0 == 5000) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.publicChatMode;
         return 1;
      } else if(var0 == 5001) {
         class179.Interpreter_intStackSize -= 3;
         Client.publicChatMode = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
         IndexCacheLoader.field512 = WorldMapElement.method4783(Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1]);
         if(IndexCacheLoader.field512 == null) {
            IndexCacheLoader.field512 = class310.field3805;
         }

         Client.__client_pl = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 2];
         PacketBufferNode var15 = Interpreter.method1915(ClientPacket.__gs_z, Client.packetWriter.isaacCipher);
         var15.packetBuffer.writeByte(Client.publicChatMode);
         var15.packetBuffer.writeByte(IndexCacheLoader.field512.field3804);
         var15.packetBuffer.writeByte(Client.__client_pl);
         Client.packetWriter.__q_167(var15);
         return 1;
      } else {
         String var3;
         int var4;
         int var5;
         if(var0 == 5002) {
            var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
            class179.Interpreter_intStackSize -= 2;
            var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
            var5 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
            PacketBufferNode var13 = Interpreter.method1915(ClientPacket.__gs_ae, Client.packetWriter.isaacCipher);
            var13.packetBuffer.writeByte(WorldMapRegion.method550(var3) + 2);
            var13.packetBuffer.writeStringCp1252NullTerminated(var3);
            var13.packetBuffer.writeByte(var4 - 1);
            var13.packetBuffer.writeByte(var5);
            Client.packetWriter.__q_167(var13);
            return 1;
         } else {
            Message var11;
            if(var0 == 5003) {
               class179.Interpreter_intStackSize -= 2;
               var5 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
               var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
               var11 = Message.method1226(var5, var4);
               if(var11 != null) {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var11.count;
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var11.cycle;
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var11.sender != null?var11.sender:"";
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var11.prefix != null?var11.prefix:"";
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var11.text != null?var11.text:"";
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var11.isFromFriend()?1:(var11.isFromIgnored()?2:0);
               } else {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 5004) {
               var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
               var11 = NetCache.method4708(var5);
               if(var11 != null) {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var11.type;
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var11.cycle;
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var11.sender != null?var11.sender:"";
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var11.prefix != null?var11.prefix:"";
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var11.text != null?var11.text:"";
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var11.isFromFriend()?1:(var11.isFromIgnored()?2:0);
               } else {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 5005) {
               if(IndexCacheLoader.field512 == null) {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
               } else {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = IndexCacheLoader.field512.field3804;
               }

               return 1;
            } else {
               String var6;
               if(var0 == 5008) {
                  var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                  var4 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                  var6 = var3.toLowerCase();
                  byte var12 = 0;
                  if(var6.startsWith("yellow:")) {
                     var12 = 0;
                     var3 = var3.substring("yellow:".length());
                  } else if(var6.startsWith("red:")) {
                     var12 = 1;
                     var3 = var3.substring("red:".length());
                  } else if(var6.startsWith("green:")) {
                     var12 = 2;
                     var3 = var3.substring("green:".length());
                  } else if(var6.startsWith("cyan:")) {
                     var12 = 3;
                     var3 = var3.substring("cyan:".length());
                  } else if(var6.startsWith("purple:")) {
                     var12 = 4;
                     var3 = var3.substring("purple:".length());
                  } else if(var6.startsWith("white:")) {
                     var12 = 5;
                     var3 = var3.substring("white:".length());
                  } else if(var6.startsWith("flash1:")) {
                     var12 = 6;
                     var3 = var3.substring("flash1:".length());
                  } else if(var6.startsWith("flash2:")) {
                     var12 = 7;
                     var3 = var3.substring("flash2:".length());
                  } else if(var6.startsWith("flash3:")) {
                     var12 = 8;
                     var3 = var3.substring("flash3:".length());
                  } else if(var6.startsWith("glow1:")) {
                     var12 = 9;
                     var3 = var3.substring("glow1:".length());
                  } else if(var6.startsWith("glow2:")) {
                     var12 = 10;
                     var3 = var3.substring("glow2:".length());
                  } else if(var6.startsWith("glow3:")) {
                     var12 = 11;
                     var3 = var3.substring("glow3:".length());
                  } else if(Client.language != 0) {
                     if(var6.startsWith("yellow:")) {
                        var12 = 0;
                        var3 = var3.substring("yellow:".length());
                     } else if(var6.startsWith("red:")) {
                        var12 = 1;
                        var3 = var3.substring("red:".length());
                     } else if(var6.startsWith("green:")) {
                        var12 = 2;
                        var3 = var3.substring("green:".length());
                     } else if(var6.startsWith("cyan:")) {
                        var12 = 3;
                        var3 = var3.substring("cyan:".length());
                     } else if(var6.startsWith("purple:")) {
                        var12 = 4;
                        var3 = var3.substring("purple:".length());
                     } else if(var6.startsWith("white:")) {
                        var12 = 5;
                        var3 = var3.substring("white:".length());
                     } else if(var6.startsWith("flash1:")) {
                        var12 = 6;
                        var3 = var3.substring("flash1:".length());
                     } else if(var6.startsWith("flash2:")) {
                        var12 = 7;
                        var3 = var3.substring("flash2:".length());
                     } else if(var6.startsWith("flash3:")) {
                        var12 = 8;
                        var3 = var3.substring("flash3:".length());
                     } else if(var6.startsWith("glow1:")) {
                        var12 = 9;
                        var3 = var3.substring("glow1:".length());
                     } else if(var6.startsWith("glow2:")) {
                        var12 = 10;
                        var3 = var3.substring("glow2:".length());
                     } else if(var6.startsWith("glow3:")) {
                        var12 = 11;
                        var3 = var3.substring("glow3:".length());
                     }
                  }

                  var6 = var3.toLowerCase();
                  byte var14 = 0;
                  if(var6.startsWith("wave:")) {
                     var14 = 1;
                     var3 = var3.substring("wave:".length());
                  } else if(var6.startsWith("wave2:")) {
                     var14 = 2;
                     var3 = var3.substring("wave2:".length());
                  } else if(var6.startsWith("shake:")) {
                     var14 = 3;
                     var3 = var3.substring("shake:".length());
                  } else if(var6.startsWith("scroll:")) {
                     var14 = 4;
                     var3 = var3.substring("scroll:".length());
                  } else if(var6.startsWith("slide:")) {
                     var14 = 5;
                     var3 = var3.substring("slide:".length());
                  } else if(Client.language != 0) {
                     if(var6.startsWith("wave:")) {
                        var14 = 1;
                        var3 = var3.substring("wave:".length());
                     } else if(var6.startsWith("wave2:")) {
                        var14 = 2;
                        var3 = var3.substring("wave2:".length());
                     } else if(var6.startsWith("shake:")) {
                        var14 = 3;
                        var3 = var3.substring("shake:".length());
                     } else if(var6.startsWith("scroll:")) {
                        var14 = 4;
                        var3 = var3.substring("scroll:".length());
                     } else if(var6.startsWith("slide:")) {
                        var14 = 5;
                        var3 = var3.substring("slide:".length());
                     }
                  }

                  PacketBufferNode var9 = Interpreter.method1915(ClientPacket.__gs_cz, Client.packetWriter.isaacCipher);
                  var9.packetBuffer.writeByte(0);
                  int var10 = var9.packetBuffer.index;
                  var9.packetBuffer.writeByte(var4);
                  var9.packetBuffer.writeByte(var12);
                  var9.packetBuffer.writeByte(var14);
                  TextureProvider.method2777(var9.packetBuffer, var3);
                  var9.packetBuffer.__h_300(var9.packetBuffer.index - var10);
                  Client.packetWriter.__q_167(var9);
                  return 1;
               } else if(var0 == 5009) {
                  Interpreter.Interpreter_stringStackSize -= 2;
                  var3 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
                  var6 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
                  PacketBufferNode var7 = Interpreter.method1915(ClientPacket.__gs_v, Client.packetWriter.isaacCipher);
                  var7.packetBuffer.writeShort(0);
                  int var8 = var7.packetBuffer.index;
                  var7.packetBuffer.writeStringCp1252NullTerminated(var3);
                  TextureProvider.method2777(var7.packetBuffer, var6);
                  var7.packetBuffer.__y_299(var7.packetBuffer.index - var8);
                  Client.packetWriter.__q_167(var7);
                  return 1;
               } else if(var0 != 5015) {
                  if(var0 == 5016) {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Client.__client_pl;
                     return 1;
                  } else if(var0 == 5017) {
                     var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = WidgetGroupParent.method1174(var5);
                     return 1;
                  } else if(var0 == 5018) {
                     var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = class12.method161(var5);
                     return 1;
                  } else if(var0 == 5019) {
                     var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = SpriteMask.method4391(var5);
                     return 1;
                  } else if(var0 == 5020) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     BoundaryObject.method3235(var3);
                     return 1;
                  } else if(var0 == 5021) {
                     Client.__client_pz = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize].toLowerCase().trim();
                     return 1;
                  } else if(var0 == 5022) {
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = Client.__client_pz;
                     return 1;
                  } else if(var0 == 5023) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     System.out.println(var3);
                     return 1;
                  } else {
                     return 2;
                  }
               } else {
                  if(Canvas.localPlayer != null && Canvas.localPlayer.username != null) {
                     var3 = Canvas.localPlayer.username.getName();
                  } else {
                     var3 = "";
                  }

                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3;
                  return 1;
               }
            }
         }
      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "47188688"
   )
   protected static int method2222() {
      int var0 = 0;
      if(AbstractIndexCache.garbageCollector == null || !AbstractIndexCache.garbageCollector.isValid()) {
         try {
            Iterator var1 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

            while(var1.hasNext()) {
               GarbageCollectorMXBean var2 = (GarbageCollectorMXBean)var1.next();
               if(var2.isValid()) {
                  AbstractIndexCache.garbageCollector = var2;
                  GameShell.garbageCollectorLastCheckTimeMs = -1L;
                  GameShell.garbageCollectorLastCollectionTime = -1L;
               }
            }
         } catch (Throwable var9) {
            ;
         }
      }

      if(AbstractIndexCache.garbageCollector != null) {
         long var10 = class203.currentTimeMs();
         long var3 = AbstractIndexCache.garbageCollector.getCollectionTime();
         if(GameShell.garbageCollectorLastCollectionTime != -1L) {
            long var5 = var3 - GameShell.garbageCollectorLastCollectionTime;
            long var7 = var10 - GameShell.garbageCollectorLastCheckTimeMs;
            if(0L != var7) {
               var0 = (int)(var5 * 100L / var7);
            }
         }

         GameShell.garbageCollectorLastCollectionTime = var3;
         GameShell.garbageCollectorLastCheckTimeMs = var10;
      }

      return var0;
   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "2072073729"
   )
   static final void method2224(int var0, int var1, boolean var2) {
      if(!var2 || var0 != GameObject.__eh_fy || WorldMapLabelSize.__s_fi != var1) {
         GameObject.__eh_fy = var0;
         WorldMapLabelSize.__s_fi = var1;
         GameShell.updateGameState(25);
         class68.drawLoadingMessage("Loading - please wait.", true);
         int var3 = class50.baseX;
         int var4 = GraphicsObject.baseY;
         class50.baseX = (var0 - 6) * 8;
         GraphicsObject.baseY = (var1 - 6) * 8;
         int var5 = class50.baseX - var3;
         int var6 = GraphicsObject.baseY - var4;
         var3 = class50.baseX;
         var4 = GraphicsObject.baseY;

         int var7;
         int var8;
         for(var7 = 0; var7 < 32768; ++var7) {
            NPC var9 = Client.npcs[var7];
            if(var9 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var9.pathX[var8] -= var5;
                  var9.pathY[var8] -= var6;
               }

               var9.x -= var5 * 128;
               var9.y -= var6 * 128;
            }
         }

         for(var7 = 0; var7 < 2048; ++var7) {
            Player var20 = Client.players[var7];
            if(var20 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var20.pathX[var8] -= var5;
                  var20.pathY[var8] -= var6;
               }

               var20.x -= var5 * 128;
               var20.y -= var6 * 128;
            }
         }

         byte var21 = 0;
         byte var10 = 104;
         byte var11 = 1;
         if(var5 < 0) {
            var21 = 103;
            var10 = -1;
            var11 = -1;
         }

         byte var12 = 0;
         byte var13 = 104;
         byte var14 = 1;
         if(var6 < 0) {
            var12 = 103;
            var13 = -1;
            var14 = -1;
         }

         int var15;
         for(int var16 = var21; var16 != var10; var16 += var11) {
            for(var15 = var12; var13 != var15; var15 += var14) {
               int var17 = var16 + var5;
               int var18 = var15 + var6;

               for(int var19 = 0; var19 < 4; ++var19) {
                  if(var17 >= 0 && var18 >= 0 && var17 < 104 && var18 < 104) {
                     Client.groundItems[var19][var16][var15] = Client.groundItems[var19][var17][var18];
                  } else {
                     Client.groundItems[var19][var16][var15] = null;
                  }
               }
            }
         }

         for(class68 var22 = (class68)Client.__client_kh.last(); var22 != null; var22 = (class68)Client.__client_kh.previous()) {
            var22.field913 -= var5;
            var22.field901 -= var6;
            if(var22.field913 < 0 || var22.field901 < 0 || var22.field913 >= 104 || var22.field901 >= 104) {
               var22.remove();
            }
         }

         if(Client.destinationX != 0) {
            Client.destinationX -= var5;
            Client.destinationY -= var6;
         }

         Client.soundEffectCount = 0;
         Client.isCameraLocked = false;
         WorldMapSection1.cameraX -= var5 << 7;
         class11.cameraZ -= var6 << 7;
         MouseHandler.oculusOrbFocalPointX -= var5 << 7;
         ScriptEvent.oculusOrbFocalPointY -= var6 << 7;
         Client.__client_ph = -1;
         Client.graphicsObjects.clear();
         Client.projectiles.clear();

         for(var15 = 0; var15 < 4; ++var15) {
            Client.collisionMaps[var15].clear();
         }
      }

   }
}

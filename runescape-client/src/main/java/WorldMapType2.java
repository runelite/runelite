import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
@Implements("WorldMapType2")
public class WorldMapType2 implements WorldMapSectionBase {
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "[Lkp;"
   )
   static SpritePixels[] field534;
   @ObfuscatedName("w")
   static int[][] field530;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 803598953
   )
   int field528;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 441696721
   )
   int field532;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 730296361
   )
   int field525;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1474384379
   )
   int field529;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1827675261
   )
   int field526;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1865960389
   )
   int field527;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "122"
   )
   public boolean vmethod762(int var1, int var2) {
      return var1 >> 6 == this.field532 && var2 >> 6 == this.field529;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "1"
   )
   public boolean vmethod741(int var1, int var2, int var3) {
      return var1 >= this.field528 && var1 < this.field525 + this.field528?var2 >> 6 == this.field526 && var3 >> 6 == this.field527:false;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lab;I)V",
      garbageValue = "239959050"
   )
   public void vmethod740(WorldMapData var1) {
      if(var1.field464 > this.field532) {
         var1.field464 = this.field532;
      }

      if(var1.field465 < this.field532) {
         var1.field465 = this.field532;
      }

      if(var1.field460 > this.field529) {
         var1.field460 = this.field529;
      }

      if(var1.field467 < this.field529) {
         var1.field467 = this.field529;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)Lhh;",
      garbageValue = "0"
   )
   public Coordinates vmethod744(int var1, int var2) {
      if(!this.vmethod762(var1, var2)) {
         return null;
      } else {
         int var3 = this.field526 * 64 - this.field532 * 64 + var1;
         int var4 = this.field527 * 64 - this.field529 * 64 + var2;
         return new Coordinates(this.field528, var3, var4);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "216213566"
   )
   public int[] vmethod759(int var1, int var2, int var3) {
      if(!this.vmethod741(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field532 * 64 - this.field526 * 64 + var2, var3 + (this.field529 * 64 - this.field527 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-985200438"
   )
   void method534() {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfb;I)V",
      garbageValue = "-2081425823"
   )
   public void vmethod742(Buffer var1) {
      this.field528 = var1.readUnsignedByte();
      this.field525 = var1.readUnsignedByte();
      this.field526 = var1.readUnsignedShort();
      this.field527 = var1.readUnsignedShort();
      this.field532 = var1.readUnsignedShort();
      this.field529 = var1.readUnsignedShort();
      this.method534();
   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(Lhi;IIZI)V",
      garbageValue = "-424948967"
   )
   static void method555(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2637 == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.field2637 == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.field2637 == 2) {
         var0.width = var0.originalWidth * var1 >> 14;
      }

      if(var0.buttonType == 0) {
         var0.height = var0.field2656;
      } else if(var0.buttonType == 1) {
         var0.height = var2 - var0.field2656;
      } else if(var0.buttonType == 2) {
         var0.height = var2 * var0.field2656 >> 14;
      }

      if(var0.field2637 == 4) {
         var0.width = var0.field2783 * var0.height / var0.field2667;
      }

      if(var0.buttonType == 4) {
         var0.height = var0.width * var0.field2667 / var0.field2783;
      }

      if(Client.field1096 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field1098 = var0;
      }

      if(var3 && var0.field2696 != null && (var4 != var0.width || var5 != var0.height)) {
         ScriptEvent var6 = new ScriptEvent();
         var6.widget = var0;
         var6.field856 = var0.field2696;
         Client.field964.addFront(var6);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lbh;B)V",
      garbageValue = "79"
   )
   static void method553(GameEngine var0) {
      if(MouseInput.field740 == 1 || !GrandExchangeOffer.field302 && MouseInput.field740 == 4) {
         int var1 = class93.field1434 + 280;
         if(MouseInput.field741 >= var1 && MouseInput.field741 <= var1 + 14 && MouseInput.field742 >= 4 && MouseInput.field742 <= 18) {
            class11.method57(0, 0);
            return;
         }

         if(MouseInput.field741 >= var1 + 15 && MouseInput.field741 <= var1 + 80 && MouseInput.field742 >= 4 && MouseInput.field742 <= 18) {
            class11.method57(0, 1);
            return;
         }

         int var2 = class93.field1434 + 390;
         if(MouseInput.field741 >= var2 && MouseInput.field741 <= var2 + 14 && MouseInput.field742 >= 4 && MouseInput.field742 <= 18) {
            class11.method57(1, 0);
            return;
         }

         if(MouseInput.field741 >= var2 + 15 && MouseInput.field741 <= var2 + 80 && MouseInput.field742 >= 4 && MouseInput.field742 <= 18) {
            class11.method57(1, 1);
            return;
         }

         int var3 = class93.field1434 + 500;
         if(MouseInput.field741 >= var3 && MouseInput.field741 <= var3 + 14 && MouseInput.field742 >= 4 && MouseInput.field742 <= 18) {
            class11.method57(2, 0);
            return;
         }

         if(MouseInput.field741 >= var3 + 15 && MouseInput.field741 <= var3 + 80 && MouseInput.field742 >= 4 && MouseInput.field742 <= 18) {
            class11.method57(2, 1);
            return;
         }

         int var4 = class93.field1434 + 610;
         if(MouseInput.field741 >= var4 && MouseInput.field741 <= var4 + 14 && MouseInput.field742 >= 4 && MouseInput.field742 <= 18) {
            class11.method57(3, 0);
            return;
         }

         if(MouseInput.field741 >= var4 + 15 && MouseInput.field741 <= var4 + 80 && MouseInput.field742 >= 4 && MouseInput.field742 <= 18) {
            class11.method57(3, 1);
            return;
         }

         if(MouseInput.field741 >= class93.field1434 + 708 && MouseInput.field742 >= 4 && MouseInput.field741 <= class93.field1434 + 708 + 50 && MouseInput.field742 <= 20) {
            class93.worldSelectShown = false;
            class244.field3300.method5107(class93.field1434, 0);
            class92.field1425.method5107(class93.field1434 + 382, 0);
            class12.logoSprite.method5058(class93.field1434 + 382 - class12.logoSprite.originalWidth / 2, 18);
            return;
         }

         if(class93.field1463 != -1) {
            World var5 = World.worldList[class93.field1463];
            SoundTask.method2101(var5);
            class93.worldSelectShown = false;
            class244.field3300.method5107(class93.field1434, 0);
            class92.field1425.method5107(class93.field1434 + 382, 0);
            class12.logoSprite.method5058(class93.field1434 + 382 - class12.logoSprite.originalWidth / 2, 18);
            return;
         }
      }

   }

   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1718524781"
   )
   @Export("flush")
   static final void flush(boolean var0) {
      class182.method3458();
      ++Client.audioEffectCount;
      if(Client.audioEffectCount >= 50 || var0) {
         Client.audioEffectCount = 0;
         if(!Client.socketError && VertexNormal.rssocket != null) {
            Client.secretPacketBuffer1.putOpcode(143);

            try {
               VertexNormal.rssocket.queueForWrite(Client.secretPacketBuffer1.payload, 0, Client.secretPacketBuffer1.offset);
               Client.secretPacketBuffer1.offset = 0;
            } catch (IOException var2) {
               Client.socketError = true;
            }
         }

      }
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "1223535330"
   )
   @Export("isFriended")
   static boolean isFriended(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = FloorUnderlayDefinition.method4398(var0, class22.field354);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(FloorUnderlayDefinition.method4398(Client.friends[var3].name, class22.field354)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(FloorUnderlayDefinition.method4398(GrandExchangeOffer.localPlayer.name, class22.field354))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfo;II)Z",
      garbageValue = "-1928942166"
   )
   @Export("decodeRegionHash")
   static boolean decodeRegionHash(PacketBuffer var0, int var1) {
      int var2 = var0.getBits(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.getBits(1) != 0) {
            decodeRegionHash(var0, var1);
         }

         var3 = var0.getBits(13);
         var4 = var0.getBits(13);
         boolean var12 = var0.getBits(1) == 1;
         if(var12) {
            class97.field1518[++class97.field1506 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field896 = var1;
            if(class97.field1519[var1] != null) {
               var6.decodeApperance(class97.field1519[var1]);
            }

            var6.orientation = class97.field1515[var1];
            var6.interacting = class97.field1516[var1];
            var7 = class97.field1505[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.field1251[0] = class97.field1508[var1];
            var6.field918 = (byte)var8;
            var6.method1190((var9 << 13) + var3 - class47.baseX, (var10 << 13) + var4 - class44.baseY);
            var6.field903 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.getBits(2);
         var4 = class97.field1505[var1];
         class97.field1505[var1] = (var4 & 268435455) + (((var4 >> 28) + var3 & 3) << 28);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.getBits(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class97.field1505[var1];
            var7 = (var11 >> 28) + var4 & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class97.field1505[var1] = (var8 << 14) + var9 + (var7 << 28);
            return false;
         } else {
            var3 = var0.getBits(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class97.field1505[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var11 + var7 & 255;
            class97.field1505[var1] = (var9 << 14) + var10 + (var8 << 28);
            return false;
         }
      }
   }
}

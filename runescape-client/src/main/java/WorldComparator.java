import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
@Implements("WorldComparator")
final class WorldComparator implements Comparator {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ly;Ly;S)I",
      garbageValue = "-19250"
   )
   int method72(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.world < var2.world?-1:(var2.world == var1.world?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method72((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lid;B)V",
      garbageValue = "-71"
   )
   public static void method79(IndexDataBase var0) {
      class259.field3462 = var0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BI)Lce;",
      garbageValue = "-1233129874"
   )
   @Export("newScript")
   static Script newScript(byte[] var0) {
      Script var1 = new Script();
      Buffer var2 = new Buffer(var0);
      var2.offset = var2.payload.length - 2;
      int var3 = var2.readUnsignedShort();
      int var4 = var2.payload.length - 2 - var3 - 12;
      var2.offset = var4;
      int var5 = var2.readInt();
      var1.localIntCount = var2.readUnsignedShort();
      var1.localStringCount = var2.readUnsignedShort();
      var1.intStackCount = var2.readUnsignedShort();
      var1.stringStackCount = var2.readUnsignedShort();
      int var6 = var2.readUnsignedByte();
      int var7;
      int var8;
      if(var6 > 0) {
         var1.switches = var1.method1900(var6);

         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var2.readUnsignedShort();
            IterableHashTable var9 = new IterableHashTable(NetWriter.nextPowerOfTwo(var8));
            var1.switches[var7] = var9;

            while(var8-- > 0) {
               int var10 = var2.readInt();
               int var11 = var2.readInt();
               var9.put(new IntegerNode(var11), (long)var10);
            }
         }
      }

      var2.offset = 0;
      var2.getNullString();
      var1.instructions = new int[var5];
      var1.intOperands = new int[var5];
      var1.stringOperands = new String[var5];

      for(var7 = 0; var2.offset < var4; var1.instructions[var7++] = var8) {
         var8 = var2.readUnsignedShort();
         if(var8 == 3) {
            var1.stringOperands[var7] = var2.readString();
         } else if(var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
            var1.intOperands[var7] = var2.readInt();
         } else {
            var1.intOperands[var7] = var2.readUnsignedByte();
         }
      }

      return var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lid;Ljava/lang/String;Ljava/lang/String;I)Lky;",
      garbageValue = "-1759268354"
   )
   public static SpritePixels method82(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return ClassInfo.method5123(var0, var3, var4);
   }

   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "107"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            Bounds.clientInstance.method881();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.loginState = 0;
            Client.field905 = 0;
            Client.field896 = 0;
            Client.field919.method5096(var0);
            if(var0 != 20) {
               ScriptVarType.method28(false);
            }
         }

         if(var0 != 20 && var0 != 40 && FileOnDisk.field1685 != null) {
            FileOnDisk.field1685.close();
            FileOnDisk.field1685 = null;
         }

         if(Client.gameState == 25) {
            Client.field955 = 0;
            Client.field921 = 0;
            Client.field922 = 1;
            Client.field923 = 0;
            Client.field924 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class27.method215(WorldMapType2.indexCache10, ContextMenuRow.indexSprites, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class27.method215(WorldMapType2.indexCache10, ContextMenuRow.indexSprites, false, 4);
            } else if(class91.field1342) {
               class91.field1341 = null;
               class91.field1340 = null;
               class272.runeSprites = null;
               class182.field2511 = null;
               class91.field1347 = null;
               class91.logoSprite = null;
               class91.titlemuteSprite = null;
               Fonts.field3694 = null;
               UrlRequester.field2098 = null;
               class46.field570 = null;
               class31.slFlagSprites = null;
               BoundingBox3D.slArrowSprites = null;
               class37.slStarSprites = null;
               IntegerToken.field13 = null;
               ScriptEvent.field811 = null;
               class295.field3851 = null;
               class91.field1350 = null;
               class34.field459 = null;
               class234.field3220 = null;
               BuildType.field3261 = null;
               class82.field1274 = null;
               class82.field1275 = null;
               IntegerToken.method6(2);
               class156.sendConInfo(true);
               class91.field1342 = false;
            }
         } else {
            class27.method215(WorldMapType2.indexCache10, ContextMenuRow.indexSprites, true, 0);
         }

         Client.gameState = var0;
      }
   }

   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2143515884"
   )
   static final void method77() {
      for(GraphicsObject var0 = (GraphicsObject)Client.graphicsObjectDeque.getFront(); var0 != null; var0 = (GraphicsObject)Client.graphicsObjectDeque.getNext()) {
         if(var0.level == class233.plane && !var0.finished) {
            if(Client.gameCycle >= var0.startCycle) {
               var0.method1721(Client.field992);
               if(var0.finished) {
                  var0.unlink();
               } else {
                  GrandExchangeEvent.region.method2808(var0.level, var0.x, var0.y, var0.height, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.unlink();
         }
      }

   }
}

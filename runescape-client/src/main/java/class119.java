import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
public class class119 {
   @ObfuscatedName("u")
   static int[] field2036;
   @ObfuscatedName("f")
   Inflater field2041;

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   class119(int var1, int var2, int var3) {
   }

   public class119() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "942721787"
   )
   static String method2476(int var0) {
      return "<img=" + var0 + ">";
   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(LWidget;IIII)V",
      garbageValue = "1764392434"
   )
   static final void method2477(Widget var0, int var1, int var2, int var3) {
      class49.method1012();
      class178 var4 = var0.method3474(false);
      if(var4 != null) {
         class82.method1895(var1, var2, var4.field2930 + var1, var2 + var4.field2931);
         if(Client.field369 != 2 && Client.field369 != 5) {
            int var5 = Client.mapScale + Client.mapAngle & 2047;
            int var6 = 48 + class34.localPlayer.x / 32;
            int var7 = 464 - class34.localPlayer.y / 32;
            DecorativeObject.field1660.method1783(var1, var2, var4.field2930, var4.field2931, var6, var7, var5, Client.mapScaleDelta + 256, var4.field2933, var4.field2932);

            int var8;
            int var9;
            int var10;
            for(var8 = 0; var8 < Client.field509; ++var8) {
               var9 = 2 + Client.field534[var8] * 4 - class34.localPlayer.x / 32;
               var10 = 4 * Client.field511[var8] + 2 - class34.localPlayer.y / 32;
               class18.method194(var1, var2, var9, var10, Client.field512[var8], var4);
            }

            int var11;
            int var12;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var9 = 0; var9 < 104; ++var9) {
                  Deque var17 = Client.groundItemDeque[XItemContainer.plane][var8][var9];
                  if(null != var17) {
                     var11 = 4 * var8 + 2 - class34.localPlayer.x / 32;
                     var12 = 4 * var9 + 2 - class34.localPlayer.y / 32;
                     class18.method194(var1, var2, var11, var12, class4.field74[0], var4);
                  }
               }
            }

            for(var8 = 0; var8 < Client.field321; ++var8) {
               NPC var18 = Client.cachedNPCs[Client.field405[var8]];
               if(null != var18 && var18.vmethod787()) {
                  NPCComposition var21 = var18.composition;
                  if(null != var21 && null != var21.field913) {
                     var21 = var21.method798();
                  }

                  if(null != var21 && var21.isMinimapVisible && var21.field916) {
                     var11 = var18.x / 32 - class34.localPlayer.x / 32;
                     var12 = var18.y / 32 - class34.localPlayer.y / 32;
                     class18.method194(var1, var2, var11, var12, class4.field74[1], var4);
                  }
               }
            }

            var8 = class34.field763;
            int[] var22 = class34.field758;

            for(var10 = 0; var10 < var8; ++var10) {
               Player var19 = Client.cachedPlayers[var22[var10]];
               if(null != var19 && var19.vmethod787() && !var19.field52 && var19 != class34.localPlayer) {
                  var12 = var19.x / 32 - class34.localPlayer.x / 32;
                  int var13 = var19.y / 32 - class34.localPlayer.y / 32;
                  boolean var14 = false;
                  if(class5.method79(var19.name, true)) {
                     var14 = true;
                  }

                  boolean var15 = false;

                  for(int var16 = 0; var16 < XItemContainer.field224; ++var16) {
                     if(var19.name.equals(TextureProvider.clanMembers[var16].username)) {
                        var15 = true;
                        break;
                     }
                  }

                  boolean var20 = false;
                  if(class34.localPlayer.team != 0 && var19.team != 0 && class34.localPlayer.team == var19.team) {
                     var20 = true;
                  }

                  if(var14) {
                     class18.method194(var1, var2, var12, var13, class4.field74[3], var4);
                  } else if(var20) {
                     class18.method194(var1, var2, var12, var13, class4.field74[4], var4);
                  } else if(var15) {
                     class18.method194(var1, var2, var12, var13, class4.field74[5], var4);
                  } else {
                     class18.method194(var1, var2, var12, var13, class4.field74[2], var4);
                  }
               }
            }

            if(Client.field298 != 0 && Client.gameCycle % 20 < 10) {
               if(Client.field298 == 1 && Client.field278 >= 0 && Client.field278 < Client.cachedNPCs.length) {
                  NPC var23 = Client.cachedNPCs[Client.field278];
                  if(var23 != null) {
                     var11 = var23.x / 32 - class34.localPlayer.x / 32;
                     var12 = var23.y / 32 - class34.localPlayer.y / 32;
                     class10.method123(var1, var2, var11, var12, class21.field584[1], var4);
                  }
               }

               if(Client.field298 == 2) {
                  var10 = 2 + (Client.field353 * 4 - class32.baseX * 4) - class34.localPlayer.x / 32;
                  var11 = 2 + (Client.field357 * 4 - class8.baseY * 4) - class34.localPlayer.y / 32;
                  class10.method123(var1, var2, var10, var11, class21.field584[1], var4);
               }

               if(Client.field298 == 10 && Client.field533 >= 0 && Client.field533 < Client.cachedPlayers.length) {
                  Player var24 = Client.cachedPlayers[Client.field533];
                  if(var24 != null) {
                     var11 = var24.x / 32 - class34.localPlayer.x / 32;
                     var12 = var24.y / 32 - class34.localPlayer.y / 32;
                     class10.method123(var1, var2, var11, var12, class21.field584[1], var4);
                  }
               }
            }

            if(Client.flagX != 0) {
               var10 = Client.flagX * 4 + 2 - class34.localPlayer.x / 32;
               var11 = 2 + Client.flagY * 4 - class34.localPlayer.y / 32;
               class18.method194(var1, var2, var10, var11, class21.field584[0], var4);
            }

            if(!class34.localPlayer.field52) {
               class82.method1861(var1 + var4.field2930 / 2 - 1, var2 + var4.field2931 / 2 - 1, 3, 3, 16777215);
            }
         } else {
            class82.method1859(var1, var2, 0, var4.field2933, var4.field2932);
         }

         Client.field485[var3] = true;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;[BB)V",
      garbageValue = "1"
   )
   public void method2478(Buffer var1, byte[] var2) {
      if(var1.payload[var1.offset] == 31 && var1.payload[1 + var1.offset] == -117) {
         if(this.field2041 == null) {
            this.field2041 = new Inflater(true);
         }

         try {
            this.field2041.setInput(var1.payload, 10 + var1.offset, var1.payload.length - (8 + 10 + var1.offset));
            this.field2041.inflate(var2);
         } catch (Exception var4) {
            this.field2041.reset();
            throw new RuntimeException("");
         }

         this.field2041.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "632762100"
   )
   public static void method2479() {
      ItemComposition.field1155.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
public class class72 extends class163 {
   @ObfuscatedName("x")
   public static String[] field879;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIILfq;I)Z",
      garbageValue = "1696204871"
   )
   protected boolean vmethod3147(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field2317 && var3 == super.field2318;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Lid;",
      garbageValue = "1309923236"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.npcs.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.field3555.getConfigData(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         NPCComposition.npcs.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Liv;",
      garbageValue = "-720630327"
   )
   public static FloorUnderlayDefinition method1166(int var0) {
      FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.underlays.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = FloorUnderlayDefinition.underlay_ref.getConfigData(1, var0);
         var1 = new FloorUnderlayDefinition();
         if(var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.post();
         FloorUnderlayDefinition.underlays.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "25762"
   )
   static final void method1164() {
      for(Projectile var0 = (Projectile)Client.projectiles.getFront(); var0 != null; var0 = (Projectile)Client.projectiles.getNext()) {
         if(var0.floor == class5.plane && Client.gameCycle <= var0.cycle) {
            if(Client.gameCycle >= var0.startTime) {
               if(var0.interacting > 0) {
                  NPC var1 = Client.cachedNPCs[var0.interacting - 1];
                  if(var1 != null && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                     var0.method1817(var1.x, var1.y, CacheFile.getTileHeight(var1.x, var1.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               if(var0.interacting < 0) {
                  int var2 = -var0.interacting - 1;
                  Player var3;
                  if(var2 == Client.localInteractingIndex) {
                     var3 = AbstractByteBuffer.localPlayer;
                  } else {
                     var3 = Client.cachedPlayers[var2];
                  }

                  if(var3 != null && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
                     var0.method1817(var3.x, var3.y, CacheFile.getTileHeight(var3.x, var3.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               var0.method1818(Client.field1122);
               class8.region.method2768(class5.plane, (int)var0.x, (int)var0.velocityZ, (int)var0.z, 60, var0, var0.rotationX, -1, false);
            }
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "1744869153"
   )
   static int method1165(int var0, Script var1, boolean var2) {
      if(var0 == 3200) {
         class81.intStackSize -= 3;
         WidgetNode.method1140(class81.intStack[class81.intStackSize], class81.intStack[class81.intStackSize + 1], class81.intStack[class81.intStackSize + 2]);
         return 1;
      } else {
         int var3;
         if(var0 != 3201) {
            if(var0 == 3202) {
               class81.intStackSize -= 2;
               var3 = class81.intStack[class81.intStackSize];
               int var6 = class81.intStack[class81.intStackSize + 1];
               if(Client.field976 != 0 && var3 != -1) {
                  IndexFile.method3094(Renderable.indexTrack2, var3, 0, Client.field976, false);
                  Client.field1151 = true;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            var3 = class81.intStack[--class81.intStackSize];
            if(var3 == -1 && !Client.field1151) {
               CombatInfoListHolder.method1750();
            } else if(var3 != -1 && var3 != Client.field1086 && Client.field976 != 0 && !Client.field1151) {
               IndexData var4 = class268.indexTrack1;
               int var5 = Client.field976;
               class203.field2521 = 1;
               class203.field2522 = var4;
               class203.field2520 = var3;
               Frames.field2138 = 0;
               class148.field2203 = var5;
               BufferProvider.field3778 = false;
               class288.field3814 = 2;
            }

            Client.field1086 = var3;
            return 1;
         }
      }
   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(Lbs;II)V",
      garbageValue = "-1657696792"
   )
   @Export("characterToScreen")
   static final void characterToScreen(Actor var0, int var1) {
      KeyFocusListener.method787(var0.x, var0.y, var1);
   }
}

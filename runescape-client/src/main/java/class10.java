import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
public final class class10 {
   @ObfuscatedName("e")
   @Export("tileSettings")
   static byte[][][] tileSettings = new byte[4][104][104];
   @ObfuscatedName("z")
   static final int[] field89 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("x")
   static final int[] field90 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("n")
   @Export("overlayPaths")
   static byte[][][] overlayPaths;
   @ObfuscatedName("q")
   static byte[][][] field92;
   @ObfuscatedName("s")
   static final int[] field94 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("d")
   static final int[] field95 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("y")
   static final int[] field96 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("m")
   static int[][][] field97;
   @ObfuscatedName("t")
   static final int[] field98 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("i")
   @Export("tileHeights")
   static int[][][] tileHeights = new int[4][105][105];
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -144600551
   )
   static int field100 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1704201013
   )
   static int field101 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1380325279
   )
   static int field102 = 99;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = 844507829
   )
   static int field103;
   @ObfuscatedName("iy")
   static Widget field105;
   @ObfuscatedName("go")
   static Widget field107;

   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1906325725"
   )
   static final void method134(String var0) {
      if(var0 != null) {
         if((Client.friendCount < 200 || Client.field410 == 1) && Client.friendCount < 400) {
            String var1 = class118.method2244(var0, class108.field1724);
            if(null != var1) {
               int var2;
               String var4;
               String var5;
               for(var2 = 0; var2 < Client.friendCount; ++var2) {
                  Friend var3 = Client.friends[var2];
                  var4 = class118.method2244(var3.name, class108.field1724);
                  if(null != var4 && var4.equals(var1)) {
                     ObjectComposition.method3581(30, "", var0 + " is already on your friend list");
                     return;
                  }

                  if(null != var3.previousName) {
                     var5 = class118.method2244(var3.previousName, class108.field1724);
                     if(null != var5 && var5.equals(var1)) {
                        ObjectComposition.method3581(30, "", var0 + " is already on your friend list");
                        return;
                     }
                  }
               }

               for(var2 = 0; var2 < Client.ignoreCount; ++var2) {
                  Ignore var6 = Client.ignores[var2];
                  var4 = class118.method2244(var6.name, class108.field1724);
                  if(null != var4 && var4.equals(var1)) {
                     ObjectComposition.method3581(30, "", "Please remove " + var0 + " from your ignore list first");
                     return;
                  }

                  if(null != var6.previousName) {
                     var5 = class118.method2244(var6.previousName, class108.field1724);
                     if(null != var5 && var5.equals(var1)) {
                        ObjectComposition.method3581(30, "", "Please remove " + var0 + " from your ignore list first");
                        return;
                     }
                  }
               }

               if(class118.method2244(class39.localPlayer.name, class108.field1724).equals(var1)) {
                  ObjectComposition.method3581(30, "", "You can\'t add yourself to your own friend list");
               } else {
                  Client.field294.method2976(49);
                  Client.field294.method2932(class57.method1067(var0));
                  Client.field294.method2757(var0);
               }
            }
         } else {
            ObjectComposition.method3581(30, "", "Your friend list is full. Max of 200 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "89"
   )
   static final void method146() {
      if(class156.field2118 != null) {
         class156.field2118.method2035();
         class156.field2118 = null;
      }

      class108.method2015();
      Client.region.method1698();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].method2210();
      }

      System.gc();
      class138.field1914 = 1;
      class145.field2014 = null;
      class30.field693 = -1;
      class138.field1915 = -1;
      ItemLayer.field1220 = 0;
      ItemLayer.field1221 = false;
      class138.field1916 = 2;
      Client.field414 = -1;
      Client.field525 = false;
      class203.method3734();
      XGrandExchangeOffer.setGameState(10);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1227780842"
   )
   static final void method147() {
      for(Projectile var0 = (Projectile)Client.projectiles.method2359(); var0 != null; var0 = (Projectile)Client.projectiles.method2361()) {
         if(var0.floor == class171.plane && Client.gameCycle <= var0.field865) {
            if(Client.gameCycle >= var0.startTime) {
               if(var0.interacting > 0) {
                  NPC var1 = Client.cachedNPCs[var0.interacting - 1];
                  if(var1 != null && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                     var0.method765(var1.x, var1.y, class85.method1686(var1.x, var1.y, var0.floor) - var0.field869, Client.gameCycle);
                  }
               }

               if(var0.interacting < 0) {
                  int var2 = -var0.interacting - 1;
                  Player var3;
                  if(var2 == Client.localInteractingIndex) {
                     var3 = class39.localPlayer;
                  } else {
                     var3 = Client.cachedPlayers[var2];
                  }

                  if(null != var3 && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
                     var0.method765(var3.x, var3.y, class85.method1686(var3.x, var3.y, var0.floor) - var0.field869, Client.gameCycle);
                  }
               }

               var0.method766(Client.field364);
               Client.region.method1739(class171.plane, (int)var0.x, (int)var0.velocityZ, (int)var0.z, 60, var0, var0.field864, -1, false);
            }
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("i")
   public static final void method149(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            class139.method2588(var0 - 1L);
            class139.method2588(1L);
         } else {
            try {
               Thread.sleep(var0);
            } catch (InterruptedException var3) {
               ;
            }
         }

      }
   }
}

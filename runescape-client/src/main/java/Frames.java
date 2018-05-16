import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("widgetIndex")
   static IndexDataBase widgetIndex;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Ldc;"
   )
   @Export("skeletons")
   Frame[] skeletons;

   @ObfuscatedSignature(
      signature = "(Liv;Liv;IZ)V"
   )
   Frames(IndexDataBase var1, IndexDataBase var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.fileCount(var3);
      this.skeletons = new Frame[var6];
      int[] var7 = var1.getChilds(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.getConfigData(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.getFront(); var12 != null; var12 = (FrameMap)var5.getNext()) {
            if(var11 == var12.id) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13;
            if(var4) {
               var13 = var2.getChild(0, var11);
            } else {
               var13 = var2.getChild(var11, 0);
            }

            var10 = new FrameMap(var11, var13);
            var5.addFront(var10);
         }

         this.skeletons[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "230121638"
   )
   public boolean method3085(int var1) {
      return this.skeletons[var1].showing;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1774422897"
   )
   static void method3084() {
      class251.field3229 = new int[2000];
      int var0 = 0;
      int var1 = 240;

      int var3;
      for(byte var2 = 12; var0 < 16; var1 -= var2) {
         var3 = GrandExchangeEvents.method15((double)((float)var1 / 360.0F), 0.9998999834060669D, (double)(0.425F * (float)var0 / 16.0F + 0.075F));
         class251.field3229[var0] = var3;
         ++var0;
      }

      var1 = 48;

      for(int var5 = var1 / 6; var0 < class251.field3229.length; var1 -= var5) {
         var3 = var0 * 2;

         for(int var4 = GrandExchangeEvents.method15((double)((float)var1 / 360.0F), 0.9998999834060669D, 0.5D); var0 < var3 && var0 < class251.field3229.length; ++var0) {
            class251.field3229[var0] = var4;
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BI)Ljava/lang/String;",
      garbageValue = "-759113708"
   )
   public static String method3087(byte[] var0) {
      int var2 = var0.length;
      StringBuilder var3 = new StringBuilder();

      for(int var4 = 0; var4 < var2 + 0; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class304.field3736[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class304.field3736[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class304.field3736[(var6 & 15) << 2 | var7 >>> 6]).append(class304.field3736[var7 & 63]);
            } else {
               var3.append(class304.field3736[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class304.field3736[(var5 & 3) << 4]).append("==");
         }
      }

      String var1 = var3.toString();
      return var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "279055576"
   )
   public static void method3092() {
      Spotanim.spotanims.reset();
      Spotanim.SpotAnimationDefinition_cachedModels.reset();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "48"
   )
   public static boolean method3095(char var0) {
      return var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-793987681"
   )
   static final void method3094(String var0) {
      CollisionData.method3448(var0 + " is already on your friend list");
   }

   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1163381700"
   )
   static final void method3091() {
      if(WorldMapType2.field245) {
         if(WorldComparator.clanMemberManager != null) {
            WorldComparator.clanMemberManager.method5383();
         }

         class15.method161();
         WorldMapType2.field245 = false;
      }

   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(ZLge;I)V",
      garbageValue = "687346891"
   )
   static final void method3096(boolean var0, PacketBuffer var1) {
      while(true) {
         if(var1.bitsAvail(Client.field739.packetLength) >= 27) {
            int var2 = var1.getBits(15);
            if(var2 != 32767) {
               boolean var3 = false;
               if(Client.cachedNPCs[var2] == null) {
                  Client.cachedNPCs[var2] = new NPC();
                  var3 = true;
               }

               NPC var4 = Client.cachedNPCs[var2];
               Client.npcIndices[++Client.npcIndexesCount - 1] = var2;
               var4.npcCycle = Client.gameCycle;
               int var5;
               if(var0) {
                  var5 = var1.getBits(8);
                  if(var5 > 127) {
                     var5 -= 256;
                  }
               } else {
                  var5 = var1.getBits(5);
                  if(var5 > 15) {
                     var5 -= 32;
                  }
               }

               int var6 = var1.getBits(1);
               if(var6 == 1) {
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var2;
               }

               int var7 = Client.field665[var1.getBits(3)];
               if(var3) {
                  var4.orientation = var4.angle = var7;
               }

               int var8 = var1.getBits(1);
               int var9;
               if(var0) {
                  var9 = var1.getBits(8);
                  if(var9 > 127) {
                     var9 -= 256;
                  }
               } else {
                  var9 = var1.getBits(5);
                  if(var9 > 15) {
                     var9 -= 32;
                  }
               }

               var4.composition = class59.getNpcDefinition(var1.getBits(14));
               var4.field885 = var4.composition.size;
               var4.field929 = var4.composition.rotation;
               if(var4.field929 == 0) {
                  var4.angle = 0;
               }

               var4.field890 = var4.composition.walkingAnimation;
               var4.field891 = var4.composition.rotate180Animation;
               var4.field882 = var4.composition.rotate90RightAnimation;
               var4.field893 = var4.composition.rotate90LeftAnimation;
               var4.idlePoseAnimation = var4.composition.standingAnimation;
               var4.field892 = var4.composition.field3509;
               var4.field889 = var4.composition.field3499;
               var4.method1823(MilliTimer.localPlayer.pathX[0] + var5, MilliTimer.localPlayer.pathY[0] + var9, var8 == 1);
               continue;
            }
         }

         var1.byteAccess();
         return;
      }
   }
}

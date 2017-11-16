import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public class class36 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lac;"
   )
   static final class36 field472;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lac;"
   )
   static final class36 field465;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lfs;"
   )
   static Buffer field473;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = 2087349797
   )
   static int field469;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1325914663
   )
   final int field464;

   static {
      field472 = new class36(0);
      field465 = new class36(1);
   }

   class36(int var1) {
      this.field464 = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lij;Ljava/lang/String;Ljava/lang/String;I)[Lks;",
      garbageValue = "-346804046"
   )
   public static IndexedSprite[] method477(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      IndexedSprite[] var5;
      if(!Sequence.method4738(var0, var3, var4)) {
         var5 = null;
      } else {
         IndexedSprite[] var7 = new IndexedSprite[class295.field3847];

         for(int var8 = 0; var8 < class295.field3847; ++var8) {
            IndexedSprite var9 = var7[var8] = new IndexedSprite();
            var9.width = class295.field3846;
            var9.originalHeight = class224.field2850;
            var9.offsetX = WidgetNode.field774[var8];
            var9.offsetY = class285.offsetsY[var8];
            var9.originalWidth = class295.field3848[var8];
            var9.height = class295.field3845[var8];
            var9.palette = class278.field3733;
            var9.pixels = class70.spritePixels[var8];
         }

         class274.method4876();
         var5 = var7;
      }

      return var5;
   }

   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      signature = "(ZLgd;I)V",
      garbageValue = "2084450392"
   )
   static final void method475(boolean var0, PacketBuffer var1) {
      Client.field1036 = 0;
      Client.pendingNpcFlagsCount = 0;
      PacketBuffer var2 = Client.field905.field1461;
      var2.bitAccess();
      int var3 = var2.getBits(8);
      int var4;
      if(var3 < Client.npcIndexesCount) {
         for(var4 = var3; var4 < Client.npcIndexesCount; ++var4) {
            Client.field971[++Client.field1036 - 1] = Client.npcIndices[var4];
         }
      }

      if(var3 > Client.npcIndexesCount) {
         throw new RuntimeException("");
      } else {
         Client.npcIndexesCount = 0;

         for(var4 = 0; var4 < var3; ++var4) {
            int var5 = Client.npcIndices[var4];
            NPC var6 = Client.cachedNPCs[var5];
            int var7 = var2.getBits(1);
            if(var7 == 0) {
               Client.npcIndices[++Client.npcIndexesCount - 1] = var5;
               var6.field1193 = Client.gameCycle;
            } else {
               int var8 = var2.getBits(2);
               if(var8 == 0) {
                  Client.npcIndices[++Client.npcIndexesCount - 1] = var5;
                  var6.field1193 = Client.gameCycle;
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var5;
               } else {
                  int var9;
                  int var10;
                  if(var8 == 1) {
                     Client.npcIndices[++Client.npcIndexesCount - 1] = var5;
                     var6.field1193 = Client.gameCycle;
                     var9 = var2.getBits(3);
                     var6.method1657(var9, (byte)1);
                     var10 = var2.getBits(1);
                     if(var10 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var5;
                     }
                  } else if(var8 == 2) {
                     Client.npcIndices[++Client.npcIndexesCount - 1] = var5;
                     var6.field1193 = Client.gameCycle;
                     var9 = var2.getBits(3);
                     var6.method1657(var9, (byte)2);
                     var10 = var2.getBits(3);
                     var6.method1657(var10, (byte)2);
                     int var11 = var2.getBits(1);
                     if(var11 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var5;
                     }
                  } else if(var8 == 3) {
                     Client.field971[++Client.field1036 - 1] = var5;
                  }
               }
            }
         }

         Actor.method1513(var0, var1);
         class182.method3419(var1);

         int var12;
         for(var12 = 0; var12 < Client.field1036; ++var12) {
            var3 = Client.field971[var12];
            if(Client.cachedNPCs[var3].field1193 != Client.gameCycle) {
               Client.cachedNPCs[var3].composition = null;
               Client.cachedNPCs[var3] = null;
            }
         }

         if(var1.offset != Client.field905.packetLength) {
            throw new RuntimeException(var1.offset + "," + Client.field905.packetLength);
         } else {
            for(var12 = 0; var12 < Client.npcIndexesCount; ++var12) {
               if(Client.cachedNPCs[Client.npcIndices[var12]] == null) {
                  throw new RuntimeException(var12 + "," + Client.npcIndexesCount);
               }
            }

         }
      }
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "22886"
   )
   static final void method476(int var0) {
      ClanMember.method1102();

      for(class81 var1 = (class81)class81.field1240.getFront(); var1 != null; var1 = (class81)class81.field1240.getNext()) {
         if(var1.field1250 != null) {
            var1.method1576();
         }
      }

      int var4 = class275.method4883(var0).configType;
      if(var4 != 0) {
         int var2 = class218.widgetSettings[var0];
         if(var4 == 1) {
            if(var2 == 1) {
               Graphics3D.setBrightness(0.9D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.9D);
            }

            if(var2 == 2) {
               Graphics3D.setBrightness(0.8D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.8D);
            }

            if(var2 == 3) {
               Graphics3D.setBrightness(0.7D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.7D);
            }

            if(var2 == 4) {
               Graphics3D.setBrightness(0.6D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.6D);
            }

            DState.method3166();
         }

         if(var4 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(var3 != Client.field945) {
               if(Client.field945 == 0 && Client.field1083 != -1) {
                  class226.method4079(class45.indexTrack1, Client.field1083, 0, var3, false);
                  Client.field1084 = false;
               } else if(var3 == 0) {
                  WorldMapData.method319();
                  Client.field1084 = false;
               } else if(class210.field2585 != 0) {
                  class230.field2909 = var3;
               } else {
                  class210.field2587.method3845(var3);
               }

               Client.field945 = var3;
            }
         }

         if(var4 == 4) {
            if(var2 == 0) {
               Client.field1085 = 127;
            }

            if(var2 == 1) {
               Client.field1085 = 96;
            }

            if(var2 == 2) {
               Client.field1085 = 64;
            }

            if(var2 == 3) {
               Client.field1085 = 32;
            }

            if(var2 == 4) {
               Client.field1085 = 0;
            }
         }

         if(var4 == 5) {
            Client.field984 = var2;
         }

         if(var4 == 6) {
            Client.field1009 = var2;
         }

         if(var4 == 9) {
            Client.field1010 = var2;
         }

         if(var4 == 10) {
            if(var2 == 0) {
               Client.field1051 = 127;
            }

            if(var2 == 1) {
               Client.field1051 = 96;
            }

            if(var2 == 2) {
               Client.field1051 = 64;
            }

            if(var2 == 3) {
               Client.field1051 = 32;
            }

            if(var2 == 4) {
               Client.field1051 = 0;
            }
         }

         if(var4 == 17) {
            Client.field1015 = var2 & 65535;
         }

         class90[] var5;
         if(var4 == 18) {
            var5 = new class90[]{class90.field1324, class90.field1328, class90.field1322, class90.field1325};
            Client.field1096 = (class90)class153.forOrdinal(var5, var2);
            if(Client.field1096 == null) {
               Client.field1096 = class90.field1325;
            }
         }

         if(var4 == 19) {
            if(var2 == -1) {
               Client.field1070 = -1;
            } else {
               Client.field1070 = var2 & 2047;
            }
         }

         if(var4 == 22) {
            var5 = new class90[]{class90.field1324, class90.field1328, class90.field1322, class90.field1325};
            Client.field950 = (class90)class153.forOrdinal(var5, var2);
            if(Client.field950 == null) {
               Client.field950 = class90.field1325;
            }
         }

      }
   }
}

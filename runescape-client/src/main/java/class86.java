import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
public class class86 {
   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1939330576"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.isDynamicRegion = var0;
      int var1;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.isDynamicRegion) {
         var1 = Client.secretPacketBuffer2.method3274();
         int var2 = Client.secretPacketBuffer2.method3299();
         var3 = Client.secretPacketBuffer2.readUnsignedShort();
         class37.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class37.xteaKeys[var4][var5] = Client.secretPacketBuffer2.readInt();
            }
         }

         CombatInfo1.mapRegions = new int[var3];
         BuildType.field3191 = new int[var3];
         Client.landRegionFielIds = new int[var3];
         class37.field529 = new byte[var3][];
         class12.field277 = new byte[var3][];
         boolean var15 = false;
         if((var1 / 8 == 48 || var1 / 8 == 49) && var2 / 8 == 48) {
            var15 = true;
         }

         if(var1 / 8 == 48 && var2 / 8 == 148) {
            var15 = true;
         }

         var3 = 0;

         for(var5 = (var1 - 6) / 8; var5 <= (var1 + 6) / 8; ++var5) {
            for(var6 = (var2 - 6) / 8; var6 <= (var2 + 6) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var15 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  CombatInfo1.mapRegions[var3] = var7;
                  BuildType.field3191[var3] = class226.indexMaps.getFile("m" + var5 + "_" + var6);
                  Client.landRegionFielIds[var3] = class226.indexMaps.getFile("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class11.method60(var1, var2, true);
      } else {
         var1 = Client.secretPacketBuffer2.method3274();
         boolean var14 = Client.secretPacketBuffer2.method3265() == 1;
         var3 = Client.secretPacketBuffer2.readUnsignedShort();
         var4 = Client.secretPacketBuffer2.readUnsignedShort();
         Client.secretPacketBuffer2.bitAccess();

         int var8;
         for(var5 = 0; var5 < 4; ++var5) {
            for(var6 = 0; var6 < 13; ++var6) {
               for(var7 = 0; var7 < 13; ++var7) {
                  var8 = Client.secretPacketBuffer2.getBits(1);
                  if(var8 == 1) {
                     Client.field986[var5][var6][var7] = Client.secretPacketBuffer2.getBits(26);
                  } else {
                     Client.field986[var5][var6][var7] = -1;
                  }
               }
            }
         }

         Client.secretPacketBuffer2.byteAccess();
         class37.xteaKeys = new int[var4][4];

         for(var5 = 0; var5 < var4; ++var5) {
            for(var6 = 0; var6 < 4; ++var6) {
               class37.xteaKeys[var5][var6] = Client.secretPacketBuffer2.readInt();
            }
         }

         CombatInfo1.mapRegions = new int[var4];
         BuildType.field3191 = new int[var4];
         Client.landRegionFielIds = new int[var4];
         class37.field529 = new byte[var4][];
         class12.field277 = new byte[var4][];
         var4 = 0;

         for(var5 = 0; var5 < 4; ++var5) {
            for(var6 = 0; var6 < 13; ++var6) {
               for(var7 = 0; var7 < 13; ++var7) {
                  var8 = Client.field986[var5][var6][var7];
                  if(var8 != -1) {
                     int var9 = var8 >> 14 & 1023;
                     int var10 = var8 >> 3 & 2047;
                     int var11 = (var9 / 8 << 8) + var10 / 8;

                     int var12;
                     for(var12 = 0; var12 < var4; ++var12) {
                        if(CombatInfo1.mapRegions[var12] == var11) {
                           var11 = -1;
                           break;
                        }
                     }

                     if(var11 != -1) {
                        CombatInfo1.mapRegions[var4] = var11;
                        var12 = var11 >> 8 & 255;
                        int var13 = var11 & 255;
                        BuildType.field3191[var4] = class226.indexMaps.getFile("m" + var12 + "_" + var13);
                        Client.landRegionFielIds[var4] = class226.indexMaps.getFile("l" + var12 + "_" + var13);
                        ++var4;
                     }
                  }
               }
            }
         }

         class11.method60(var3, var1, !var14);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lcg;I)V",
      garbageValue = "2072107926"
   )
   static void method1775(World var0) {
      if(var0.method1638() != Client.isMembers) {
         Client.isMembers = var0.method1638();
         boolean var1 = var0.method1638();
         if(var1 != class46.isMembersWorld) {
            ItemComposition.items.reset();
            ItemComposition.itemModelCache.reset();
            ItemComposition.itemSpriteCache.reset();
            class46.isMembersWorld = var1;
         }
      }

      GameEngine.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      SceneTilePaint.field2023 = Client.socketType == 0?'ꩊ':var0.id + '鱀';
      AbstractSoundSystem.field1631 = Client.socketType == 0?443:var0.id + '썐';
      class18.myWorldPort = SceneTilePaint.field2023;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BI)Ljava/lang/String;",
      garbageValue = "-1563774459"
   )
   public static String method1772(byte[] var0) {
      return BuildType.method4209(var0, 0, var0.length);
   }
}

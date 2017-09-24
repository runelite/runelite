import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
public class class87 {
   @ObfuscatedName("ai")
   @Export("clientInstance")
   @ObfuscatedSignature(
      signature = "Lclient;"
   )
   static Client clientInstance;
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      intValue = 373042967
   )
   static int field1393;

   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1081962246"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.isDynamicRegion = var0;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.isDynamicRegion) {
         int var1 = Client.secretPacketBuffer2.method3282();
         var2 = Client.secretPacketBuffer2.method3451();
         var3 = Client.secretPacketBuffer2.readUnsignedShort();
         GameEngine.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               GameEngine.xteaKeys[var4][var5] = Client.secretPacketBuffer2.readInt();
            }
         }

         class36.mapRegions = new int[var3];
         ScriptEvent.field869 = new int[var3];
         class175.landRegionFielIds = new int[var3];
         TextureProvider.field1793 = new byte[var3][];
         WidgetNode.field850 = new byte[var3][];
         boolean var15 = false;
         if((var2 / 8 == 48 || var2 / 8 == 49) && var1 / 8 == 48) {
            var15 = true;
         }

         if(var2 / 8 == 48 && var1 / 8 == 148) {
            var15 = true;
         }

         var3 = 0;

         for(var5 = (var2 - 6) / 8; var5 <= (var2 + 6) / 8; ++var5) {
            for(var6 = (var1 - 6) / 8; var6 <= (var1 + 6) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var15 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  class36.mapRegions[var3] = var7;
                  ScriptEvent.field869[var3] = RSCanvas.indexMaps.getFile("m" + var5 + "_" + var6);
                  class175.landRegionFielIds[var3] = RSCanvas.indexMaps.getFile("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class67.method1119(var2, var1, true);
      } else {
         boolean var14 = Client.secretPacketBuffer2.readUnsignedByte() == 1;
         var2 = Client.secretPacketBuffer2.method3309();
         var3 = Client.secretPacketBuffer2.method3282();
         var4 = Client.secretPacketBuffer2.readUnsignedShort();
         Client.secretPacketBuffer2.bitAccess();

         int var8;
         for(var5 = 0; var5 < 4; ++var5) {
            for(var6 = 0; var6 < 13; ++var6) {
               for(var7 = 0; var7 < 13; ++var7) {
                  var8 = Client.secretPacketBuffer2.getBits(1);
                  if(var8 == 1) {
                     Client.field1005[var5][var6][var7] = Client.secretPacketBuffer2.getBits(26);
                  } else {
                     Client.field1005[var5][var6][var7] = -1;
                  }
               }
            }
         }

         Client.secretPacketBuffer2.byteAccess();
         GameEngine.xteaKeys = new int[var4][4];

         for(var5 = 0; var5 < var4; ++var5) {
            for(var6 = 0; var6 < 4; ++var6) {
               GameEngine.xteaKeys[var5][var6] = Client.secretPacketBuffer2.readInt();
            }
         }

         class36.mapRegions = new int[var4];
         ScriptEvent.field869 = new int[var4];
         class175.landRegionFielIds = new int[var4];
         TextureProvider.field1793 = new byte[var4][];
         WidgetNode.field850 = new byte[var4][];
         var4 = 0;

         for(var5 = 0; var5 < 4; ++var5) {
            for(var6 = 0; var6 < 13; ++var6) {
               for(var7 = 0; var7 < 13; ++var7) {
                  var8 = Client.field1005[var5][var6][var7];
                  if(var8 != -1) {
                     int var9 = var8 >> 14 & 1023;
                     int var10 = var8 >> 3 & 2047;
                     int var11 = (var9 / 8 << 8) + var10 / 8;

                     int var12;
                     for(var12 = 0; var12 < var4; ++var12) {
                        if(class36.mapRegions[var12] == var11) {
                           var11 = -1;
                           break;
                        }
                     }

                     if(var11 != -1) {
                        class36.mapRegions[var4] = var11;
                        var12 = var11 >> 8 & 255;
                        int var13 = var11 & 255;
                        ScriptEvent.field869[var4] = RSCanvas.indexMaps.getFile("m" + var12 + "_" + var13);
                        class175.landRegionFielIds[var4] = RSCanvas.indexMaps.getFile("l" + var12 + "_" + var13);
                        ++var4;
                     }
                  }
               }
            }
         }

         class67.method1119(var3, var2, !var14);
      }

   }
}

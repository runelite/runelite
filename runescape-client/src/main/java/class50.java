import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class50 {
   @ObfuscatedName("m")
   @Export("__af_m")
   public static Applet __af_m;
   @ObfuscatedName("f")
   @Export("__af_f")
   public static String __af_f;
   @ObfuscatedName("ei")
   @Export("worldHost")
   static String worldHost;
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = -790717597
   )
   @Export("baseX")
   static int baseX;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)Lio;",
      garbageValue = "20"
   )
   @Export("getSpotAnimationDefinition")
   public static SpotAnimationDefinition getSpotAnimationDefinition(int var0) {
      SpotAnimationDefinition var1 = (SpotAnimationDefinition)SpotAnimationDefinition.SpotAnimationDefinition_cached.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = SpotAnimationDefinition.SpotAnimationDefinition_indexCache.takeRecord(13, var0);
         var1 = new SpotAnimationDefinition();
         var1.id = var0;
         if(var2 != null) {
            var1.read(new Buffer(var2));
         }

         SpotAnimationDefinition.SpotAnimationDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Ljr;",
      garbageValue = "151801733"
   )
   @Export("getObjectDefinition")
   public static ObjectDefinition getObjectDefinition(int var0) {
      ObjectDefinition var1 = (ObjectDefinition)ObjectDefinition.ObjectDefinition_cached.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectDefinition.ObjectDefinition_indexCache.takeRecord(6, var0);
         var1 = new ObjectDefinition();
         var1.id = var0;
         if(var2 != null) {
            var1.read(new Buffer(var2));
         }

         var1.init();
         if(var1.isSolid) {
            var1.interactType = 0;
            var1.boolean1 = false;
         }

         ObjectDefinition.ObjectDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "(ZLhx;B)V",
      garbageValue = "83"
   )
   @Export("loadRegions")
   static final void loadRegions(boolean var0, PacketBuffer var1) {
      Client.isInInstance = var0;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.isInInstance) {
         var2 = var1.__bm_326();
         var3 = var1.__bu_325();
         int var8 = var1.__ag_302();
         class190.xteaKeys = new int[var8][4];

         for(var4 = 0; var4 < var8; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class190.xteaKeys[var4][var5] = var1.readInt();
            }
         }

         class308.regions = new int[var8];
         IndexCacheLoader.regionMapArchiveIds = new int[var8];
         MouseHandler.regionLandArchiveIds = new int[var8];
         class40.regionLandArchives = new byte[var8][];
         HealthBarUpdate.regionMapArchives = new byte[var8][];
         boolean var9 = false;
         if((var3 / 8 == 48 || var3 / 8 == 49) && var2 / 8 == 48) {
            var9 = true;
         }

         if(var3 / 8 == 48 && var2 / 8 == 148) {
            var9 = true;
         }

         var8 = 0;

         for(var5 = (var3 - 6) / 8; var5 <= (var3 + 6) / 8; ++var5) {
            for(var6 = (var2 - 6) / 8; var6 <= (var2 + 6) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var9 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  class308.regions[var8] = var7;
                  IndexCacheLoader.regionMapArchiveIds[var8] = SecureRandomFuture.indexCache5.getArchiveId("m" + var5 + "_" + var6);
                  MouseHandler.regionLandArchiveIds[var8] = SecureRandomFuture.indexCache5.getArchiveId("l" + var5 + "_" + var6);
                  ++var8;
               }
            }
         }

         DynamicObject.method2224(var3, var2, true);
      } else {
         var2 = var1.__bu_325();
         var3 = var1.__bm_326();
         boolean var15 = var1.readUnsignedByte() == 1;
         var4 = var1.__ag_302();
         var1.importIndex();

         int var16;
         for(var5 = 0; var5 < 4; ++var5) {
            for(var6 = 0; var6 < 13; ++var6) {
               for(var7 = 0; var7 < 13; ++var7) {
                  var16 = var1.readBits(1);
                  if(var16 == 1) {
                     Client.instanceChunkTemplates[var5][var6][var7] = var1.readBits(26);
                  } else {
                     Client.instanceChunkTemplates[var5][var6][var7] = -1;
                  }
               }
            }
         }

         var1.exportIndex();
         class190.xteaKeys = new int[var4][4];

         for(var5 = 0; var5 < var4; ++var5) {
            for(var6 = 0; var6 < 4; ++var6) {
               class190.xteaKeys[var5][var6] = var1.readInt();
            }
         }

         class308.regions = new int[var4];
         IndexCacheLoader.regionMapArchiveIds = new int[var4];
         MouseHandler.regionLandArchiveIds = new int[var4];
         class40.regionLandArchives = new byte[var4][];
         HealthBarUpdate.regionMapArchives = new byte[var4][];
         var4 = 0;

         for(var5 = 0; var5 < 4; ++var5) {
            for(var6 = 0; var6 < 13; ++var6) {
               for(var7 = 0; var7 < 13; ++var7) {
                  var16 = Client.instanceChunkTemplates[var5][var6][var7];
                  if(var16 != -1) {
                     int var10 = var16 >> 14 & 1023;
                     int var11 = var16 >> 3 & 2047;
                     int var12 = (var10 / 8 << 8) + var11 / 8;

                     int var13;
                     for(var13 = 0; var13 < var4; ++var13) {
                        if(class308.regions[var13] == var12) {
                           var12 = -1;
                           break;
                        }
                     }

                     if(var12 != -1) {
                        class308.regions[var4] = var12;
                        var13 = var12 >> 8 & 255;
                        int var14 = var12 & 255;
                        IndexCacheLoader.regionMapArchiveIds[var4] = SecureRandomFuture.indexCache5.getArchiveId("m" + var13 + "_" + var14);
                        MouseHandler.regionLandArchiveIds[var4] = SecureRandomFuture.indexCache5.getArchiveId("l" + var13 + "_" + var14);
                        ++var4;
                     }
                  }
               }
            }
         }

         DynamicObject.method2224(var3, var2, !var15);
      }

   }

   @ObfuscatedName("kh")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-2128641115"
   )
   static void method900(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < class83.__cm_e; ++var4) {
         ItemDefinition var5 = Skills.getItemDefinition(var4);
         if((!var1 || var5.isTradable) && var5.noteTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               WorldMapSection0.__y_sn = -1;
               AttackOption.__cj_sp = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[var2.length * 2];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      AttackOption.__cj_sp = var2;
      class231.__hb_sg = 0;
      WorldMapSection0.__y_sn = var3;
      String[] var8 = new String[WorldMapSection0.__y_sn];

      for(int var9 = 0; var9 < WorldMapSection0.__y_sn; ++var9) {
         var8[var9] = Skills.getItemDefinition(var2[var9]).name;
      }

      Huffman.method3695(var8, AttackOption.__cj_sp);
   }

   @ObfuscatedName("kk")
   @ObfuscatedSignature(
      signature = "([BII)V",
      garbageValue = "-522943529"
   )
   static void method902(byte[] var0, int var1) {
      if(Client.__client_ev == null) {
         Client.__client_ev = new byte[24];
      }

      class212.method4109(var0, var1, Client.__client_ev, 0, 24);
   }

   static {
      __af_m = null;
      __af_f = "";
   }
}

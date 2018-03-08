import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
public class class110 {
   @ObfuscatedName("dw")
   @ObfuscatedGetter(
      intValue = 1221724165
   )
   @Export("port1")
   static int port1;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   @Export("sfx_index")
   IndexDataBase sfx_index;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   @Export("vorbis_index")
   IndexDataBase vorbis_index;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   HashTable field1578;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   HashTable field1577;

   @ObfuscatedSignature(
      signature = "(Ljc;Ljc;)V"
   )
   public class110(IndexDataBase var1, IndexDataBase var2) {
      this.field1578 = new HashTable(256);
      this.field1577 = new HashTable(256);
      this.sfx_index = var1;
      this.vorbis_index = var2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II[II)Ldp;",
      garbageValue = "-2041831209"
   )
   RawAudioNode method2283(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      RawAudioNode var7 = (RawAudioNode)this.field1577.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.getTrack(this.sfx_index, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method2143();
            this.field1577.put(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.audioBuffer.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II[II)Ldp;",
      garbageValue = "-1237810931"
   )
   RawAudioNode method2284(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      RawAudioNode var7 = (RawAudioNode)this.field1577.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class104 var8 = (class104)this.field1578.get(var5);
         if(var8 == null) {
            var8 = class104.getInstrument(this.vorbis_index, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1578.put(var8, var5);
         }

         var7 = var8.method2176(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1577.put(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I[II)Ldp;",
      garbageValue = "717423772"
   )
   public RawAudioNode method2285(int var1, int[] var2) {
      if(this.sfx_index.size() == 1) {
         return this.method2283(0, var1, var2);
      } else if(this.sfx_index.fileCount(var1) == 1) {
         return this.method2283(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I[II)Ldp;",
      garbageValue = "1205860490"
   )
   public RawAudioNode method2286(int var1, int[] var2) {
      if(this.vorbis_index.size() == 1) {
         return this.method2284(0, var1, var2);
      } else if(this.vorbis_index.fileCount(var1) == 1) {
         return this.method2284(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "(Lig;II)I",
      garbageValue = "-1651725826"
   )
   static final int method2292(Widget var0, int var1) {
      if(var0.dynamicValues != null && var1 < var0.dynamicValues.length) {
         try {
            int[] var2 = var0.dynamicValues[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = Client.boostedSkillLevels[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = Client.realSkillLevels[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = Client.skillExperiences[var2[var4++]];
               }

               int var9;
               Widget var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = GZipDecompressor.getWidget(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class81.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class237.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class248.field3006[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class237.widgetSettings[var2[var4++]] * 100 / 46875;
               }

               if(var6 == 8) {
                  var7 = WorldMapData.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class248.field3005[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = GZipDecompressor.getWidget(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class81.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = Client.energy;
               }

               if(var6 == 12) {
                  var7 = Client.weight;
               }

               if(var6 == 13) {
                  var9 = class237.widgetSettings[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = World.getVarbit(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = (WorldMapData.localPlayer.x >> 7) + class38.baseX;
               }

               if(var6 == 19) {
                  var7 = (WorldMapData.localPlayer.y >> 7) + PlayerComposition.baseY;
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }

   @ObfuscatedName("jt")
   @ObfuscatedSignature(
      signature = "(Lig;I)Lig;",
      garbageValue = "-1403648431"
   )
   static Widget method2298(Widget var0) {
      Widget var1 = RunException.method3217(var0);
      if(var1 == null) {
         var1 = var0.dragParent;
      }

      return var1;
   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("SpotAnimationDefinition_indexCache")
   static IndexDataBase SpotAnimationDefinition_indexCache;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("SpotAnimationDefinition_modelIndexCache")
   static IndexDataBase SpotAnimationDefinition_modelIndexCache;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   @Export("spotanims")
   public static NodeCache spotanims;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   @Export("SpotAnimationDefinition_cachedModels")
   public static NodeCache SpotAnimationDefinition_cachedModels;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1817587203
   )
   @Export("id")
   int id;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 387933725
   )
   int field3409;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 419987833
   )
   public int field3404;
   @ObfuscatedName("d")
   short[] field3411;
   @ObfuscatedName("z")
   short[] field3412;
   @ObfuscatedName("k")
   short[] field3413;
   @ObfuscatedName("c")
   short[] field3420;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -806500777
   )
   @Export("widthScale")
   int widthScale;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1465541299
   )
   @Export("heightScale")
   int heightScale;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1933010811
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1264262309
   )
   int field3418;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 885986067
   )
   int field3419;

   static {
      spotanims = new NodeCache(64);
      SpotAnimationDefinition_cachedModels = new NodeCache(30);
   }

   Spotanim() {
      this.field3404 = -1;
      this.widthScale = 128;
      this.heightScale = 128;
      this.orientation = 0;
      this.field3418 = 0;
      this.field3419 = 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgy;B)V",
      garbageValue = "0"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "-1698769945"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3409 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3404 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.widthScale = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.heightScale = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.orientation = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field3418 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field3419 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field3411 = new short[var3];
            this.field3412 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3411[var4] = (short)var1.readUnsignedShort();
               this.field3412[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field3413 = new short[var3];
            this.field3420 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3413[var4] = (short)var1.readUnsignedShort();
               this.field3420[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Les;",
      garbageValue = "-1354187976"
   )
   @Export("getModel")
   public final Model getModel(int var1) {
      Model var2 = (Model)SpotAnimationDefinition_cachedModels.get((long)this.id);
      if(var2 == null) {
         ModelData var3 = ModelData.method2620(SpotAnimationDefinition_modelIndexCache, this.field3409, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field3411 != null) {
            for(var4 = 0; var4 < this.field3411.length; ++var4) {
               var3.recolor(this.field3411[var4], this.field3412[var4]);
            }
         }

         if(this.field3413 != null) {
            for(var4 = 0; var4 < this.field3413.length; ++var4) {
               var3.method2635(this.field3413[var4], this.field3420[var4]);
            }
         }

         var2 = var3.light(this.field3418 + 64, this.field3419 + 850, -30, -50, -30);
         SpotAnimationDefinition_cachedModels.put(var2, (long)this.id);
      }

      Model var5;
      if(this.field3404 != -1 && var1 != -1) {
         var5 = FileRequest.getAnimation(this.field3404).method5081(var2, var1);
      } else {
         var5 = var2.method2736(true);
      }

      if(this.widthScale != 128 || this.heightScale != 128) {
         var5.scale(this.widthScale, this.heightScale, this.widthScale);
      }

      if(this.orientation != 0) {
         if(this.orientation == 90) {
            var5.rotateY90Ccw();
         }

         if(this.orientation == 180) {
            var5.rotateY90Ccw();
            var5.rotateY90Ccw();
         }

         if(this.orientation == 270) {
            var5.rotateY90Ccw();
            var5.rotateY90Ccw();
            var5.rotateY90Ccw();
         }
      }

      return var5;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Ljv;",
      garbageValue = "1994409381"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.npcs.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.NpcDefinition_indexCache.getConfigData(9, var0);
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILcf;ZI)I",
      garbageValue = "-1294512101"
   )
   static int method4746(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 3200) {
         class80.intStackSize -= 3;
         var3 = class80.intStack[class80.intStackSize];
         var4 = class80.intStack[class80.intStackSize + 1];
         int var5 = class80.intStack[class80.intStackSize + 2];
         if(Client.field1058 != 0 && var4 != 0 && Client.queuedSoundEffectCount < 50) {
            Client.queuedSoundEffectIDs[Client.queuedSoundEffectCount] = var3;
            Client.unknownSoundValues1[Client.queuedSoundEffectCount] = var4;
            Client.unknownSoundValues2[Client.queuedSoundEffectCount] = var5;
            Client.audioEffects[Client.queuedSoundEffectCount] = null;
            Client.soundLocations[Client.queuedSoundEffectCount] = 0;
            ++Client.queuedSoundEffectCount;
         }

         return 1;
      } else if(var0 == 3201) {
         Varcs.method1998(class80.intStack[--class80.intStackSize]);
         return 1;
      } else if(var0 == 3202) {
         class80.intStackSize -= 2;
         var3 = class80.intStack[class80.intStackSize];
         var4 = class80.intStack[class80.intStackSize + 1];
         if(Client.field1057 != 0 && var3 != -1) {
            class3.method7(class54.indexTrack2, var3, 0, Client.field1057, false);
            Client.field1059 = true;
         }

         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "(III)Lfj;",
      garbageValue = "-435186390"
   )
   static class168 method4732(int var0, int var1) {
      Client.field1094.field2229 = var0;
      Client.field1094.field2228 = var1;
      Client.field1094.field2233 = 1;
      Client.field1094.field2231 = 1;
      return Client.field1094;
   }
}

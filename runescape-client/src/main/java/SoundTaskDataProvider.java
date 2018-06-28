import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
@Implements("SoundTaskDataProvider")
public class SoundTaskDataProvider implements class89 {
   @ObfuscatedName("bl")
   @Export("sessionToken")
   static String sessionToken;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Lcc;",
      garbageValue = "2009259142"
   )
   public AbstractSoundSystem vmethod2093() {
      return new SourceDataSoundSystem();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Ljp;",
      garbageValue = "1348616283"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.objects.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.objects_ref.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         if(var1.isHollow) {
            var1.clipType = 0;
            var1.blocksProjectile = false;
         }

         ObjectComposition.objects.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lgy;IIIIIII)V",
      garbageValue = "1114930208"
   )
   @Export("loadTerrain")
   static final void loadTerrain(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class50.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  class50.tileHeights[0][var2][var3] = -class83.method1985(932731 + var2 + var4, var3 + 556238 + var5) * 8;
               } else {
                  class50.tileHeights[var1][var2][var3] = class50.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.readUnsignedByte();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class50.tileHeights[0][var2][var3] = -var8 * 8;
               } else {
                  class50.tileHeights[var1][var2][var3] = class50.tileHeights[var1 - 1][var2][var3] - var8 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class139.tileOverlayIds[var1][var2][var3] = var0.readByte();
               NPC.tileOverlayPath[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class50.overlayRotations[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class50.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class50.tileUnderlayIds[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if(var7 <= 49) {
               var0.readUnsignedByte();
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BI)Lkr;",
      garbageValue = "-248306191"
   )
   public static Font method767(byte[] var0) {
      if(var0 == null) {
         return null;
      } else {
         Font var1 = new Font(var0, class319.indexedSpriteOffsetXs, class319.indexedSpriteOffsetYs, class192.indexSpriteWidths, class319.indexedSpriteHeights, class319.indexedSpritePalette, class294.spritePixels);
         class319.indexedSpriteOffsetXs = null;
         class319.indexedSpriteOffsetYs = null;
         class192.indexSpriteWidths = null;
         class319.indexedSpriteHeights = null;
         class319.indexedSpritePalette = null;
         class294.spritePixels = null;
         return var1;
      }
   }
}

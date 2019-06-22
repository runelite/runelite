import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
@Implements("UnitPriceComparator")
final class UnitPriceComparator implements Comparator {
   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "Lln;"
   )
   @Export("compass")
   static Sprite compass;
   @ObfuscatedName("lr")
   @ObfuscatedSignature(
      signature = "Lcs;"
   )
   @Export("tempMenuAction")
   static MenuAction tempMenuAction;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ll;Ll;I)I",
      garbageValue = "-120071238"
   )
   @Export("__m_11")
   int __m_11(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.grandExchangeOffer.unitPrice < var2.grandExchangeOffer.unitPrice?-1:(var2.grandExchangeOffer.unitPrice == var1.grandExchangeOffer.unitPrice?0:1);
   }

   @Export("compare")
   @ObfuscatedName("compare")
   public int compare(Object var1, Object var2) {
      return this.__m_11((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   @Export("__equals_13")
   @ObfuscatedName("equals")
   public boolean __equals_13(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lir;B)V",
      garbageValue = "23"
   )
   public static void method135(AbstractIndexCache var0) {
      VarbitDefinition.VarbitDefinition_indexCache = var0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1500839037"
   )
   public static int method125(int var0, int var1) {
      return (var0 << 8) + var1;
   }

   @ObfuscatedName("f")
   public static int method134(long var0) {
      return (int)(var0 >>> 0 & 127L);
   }

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2032203362"
   )
   static final int method131() {
      if(ReflectionCheck.clientPreferences.roofsHidden) {
         return SoundSystem.plane;
      } else {
         int var0 = 3;
         if(WorldMapIcon1.cameraPitch < 310) {
            int var1;
            int var2;
            if(Client.oculusOrbState == 1) {
               var1 = MouseHandler.oculusOrbFocalPointX >> 7;
               var2 = ScriptEvent.oculusOrbFocalPointY >> 7;
            } else {
               var1 = Canvas.localPlayer.x >> 7;
               var2 = Canvas.localPlayer.y >> 7;
            }

            int var3 = WorldMapSection1.cameraX >> 7;
            int var4 = class11.cameraZ >> 7;
            if(var3 < 0 || var4 < 0 || var3 >= 104 || var4 >= 104) {
               return SoundSystem.plane;
            }

            if(var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
               return SoundSystem.plane;
            }

            if((Tiles.Tiles_renderFlags[SoundSystem.plane][var3][var4] & 4) != 0) {
               var0 = SoundSystem.plane;
            }

            int var5;
            if(var1 > var3) {
               var5 = var1 - var3;
            } else {
               var5 = var3 - var1;
            }

            int var6;
            if(var2 > var4) {
               var6 = var2 - var4;
            } else {
               var6 = var4 - var2;
            }

            int var7;
            int var8;
            if(var5 > var6) {
               var7 = var6 * 65536 / var5;
               var8 = 32768;

               while(var3 != var1) {
                  if(var3 < var1) {
                     ++var3;
                  } else if(var3 > var1) {
                     --var3;
                  }

                  if((Tiles.Tiles_renderFlags[SoundSystem.plane][var3][var4] & 4) != 0) {
                     var0 = SoundSystem.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var4 < var2) {
                        ++var4;
                     } else if(var4 > var2) {
                        --var4;
                     }

                     if((Tiles.Tiles_renderFlags[SoundSystem.plane][var3][var4] & 4) != 0) {
                        var0 = SoundSystem.plane;
                     }
                  }
               }
            } else if(var6 > 0) {
               var7 = var5 * 65536 / var6;
               var8 = 32768;

               while(var4 != var2) {
                  if(var4 < var2) {
                     ++var4;
                  } else if(var4 > var2) {
                     --var4;
                  }

                  if((Tiles.Tiles_renderFlags[SoundSystem.plane][var3][var4] & 4) != 0) {
                     var0 = SoundSystem.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var3 < var1) {
                        ++var3;
                     } else if(var3 > var1) {
                        --var3;
                     }

                     if((Tiles.Tiles_renderFlags[SoundSystem.plane][var3][var4] & 4) != 0) {
                        var0 = SoundSystem.plane;
                     }
                  }
               }
            }
         }

         if(Canvas.localPlayer.x >= 0 && Canvas.localPlayer.y >= 0 && Canvas.localPlayer.x < 13312 && Canvas.localPlayer.y < 13312) {
            if((Tiles.Tiles_renderFlags[SoundSystem.plane][Canvas.localPlayer.x >> 7][Canvas.localPlayer.y >> 7] & 4) != 0) {
               var0 = SoundSystem.plane;
            }

            return var0;
         } else {
            return SoundSystem.plane;
         }
      }
   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-239357025"
   )
   static final void method136(int var0, int var1) {
      if(Client.hintArrowType == 2) {
         WorldMapLabel.worldToScreen((Client.hintArrowX - class50.baseX << 7) + Client.hintArrowSubX, (Client.hintArrowY - GraphicsObject.baseY << 7) + Client.hintArrowSubY, Client.hintArrowHeight * 2);
         if(Client.viewportTempX > -1 && Client.cycle % 20 < 10) {
            Player.headIconHintSprites[0].drawAt2(var0 + Client.viewportTempX - 12, Client.viewportTempY + var1 - 28);
         }

      }
   }
}

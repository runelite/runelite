import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ir")
public final class class255 {
   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-6267"
   )
   static final int method4626() {
      if(Client.preferences.hideRoofs) {
         return ScriptVarType.plane;
      } else {
         int var0 = 3;
         if(class18.cameraPitch < 310) {
            int var1;
            int var2;
            if(Client.field926 == 1) {
               var1 = Size.field367 >> 7;
               var2 = class236.field2783 >> 7;
            } else {
               var1 = class265.localPlayer.x >> 7;
               var2 = class265.localPlayer.y >> 7;
            }

            int var3 = UrlRequest.cameraX >> 7;
            int var4 = Signlink.cameraY >> 7;
            if(var3 < 0 || var4 < 0 || var3 >= 104 || var4 >= 104) {
               return ScriptVarType.plane;
            }

            if(var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
               return ScriptVarType.plane;
            }

            if((class62.tileSettings[ScriptVarType.plane][var3][var4] & 4) != 0) {
               var0 = ScriptVarType.plane;
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

                  if((class62.tileSettings[ScriptVarType.plane][var3][var4] & 4) != 0) {
                     var0 = ScriptVarType.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var4 < var2) {
                        ++var4;
                     } else if(var4 > var2) {
                        --var4;
                     }

                     if((class62.tileSettings[ScriptVarType.plane][var3][var4] & 4) != 0) {
                        var0 = ScriptVarType.plane;
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

                  if((class62.tileSettings[ScriptVarType.plane][var3][var4] & 4) != 0) {
                     var0 = ScriptVarType.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var3 < var1) {
                        ++var3;
                     } else if(var3 > var1) {
                        --var3;
                     }

                     if((class62.tileSettings[ScriptVarType.plane][var3][var4] & 4) != 0) {
                        var0 = ScriptVarType.plane;
                     }
                  }
               }
            }
         }

         if(class265.localPlayer.x >= 0 && class265.localPlayer.y >= 0 && class265.localPlayer.x < 13312 && class265.localPlayer.y < 13312) {
            if((class62.tileSettings[ScriptVarType.plane][class265.localPlayer.x >> 7][class265.localPlayer.y >> 7] & 4) != 0) {
               var0 = ScriptVarType.plane;
            }

            return var0;
         } else {
            return ScriptVarType.plane;
         }
      }
   }
}

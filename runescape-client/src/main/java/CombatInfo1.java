import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("fj")
   @Export("mapRegions")
   @Hook("mapRegionsChanged")
   static int[] mapRegions;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 506383791
   )
   int field1271;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 189944667
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -738795851
   )
   @Export("health")
   int health;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1671731219
   )
   int field1274;

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.field1271 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1274 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-56335546"
   )
   void method1606(int var1, int var2, int var3, int var4) {
      this.field1271 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1274 = var4;
   }

   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1457384366"
   )
   static final int method1607() {
      if(class23.preferences.hideRoofs) {
         return class5.plane;
      } else {
         int var0 = 3;
         if(class9.cameraPitch < 310) {
            int var1 = class211.cameraX >> 7;
            int var2 = ChatLineBuffer.cameraY >> 7;
            int var3 = AbstractByteBuffer.localPlayer.x >> 7;
            int var4 = AbstractByteBuffer.localPlayer.y >> 7;
            if(var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
               return class5.plane;
            }

            if((class61.tileSettings[class5.plane][var1][var2] & 4) != 0) {
               var0 = class5.plane;
            }

            int var5;
            if(var3 > var1) {
               var5 = var3 - var1;
            } else {
               var5 = var1 - var3;
            }

            int var6;
            if(var4 > var2) {
               var6 = var4 - var2;
            } else {
               var6 = var2 - var4;
            }

            int var7;
            int var8;
            if(var5 > var6) {
               var7 = var6 * 65536 / var5;
               var8 = 32768;

               while(var1 != var3) {
                  if(var1 < var3) {
                     ++var1;
                  } else if(var1 > var3) {
                     --var1;
                  }

                  if((class61.tileSettings[class5.plane][var1][var2] & 4) != 0) {
                     var0 = class5.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var2 < var4) {
                        ++var2;
                     } else if(var2 > var4) {
                        --var2;
                     }

                     if((class61.tileSettings[class5.plane][var1][var2] & 4) != 0) {
                        var0 = class5.plane;
                     }
                  }
               }
            } else {
               var7 = var5 * 65536 / var6;
               var8 = 32768;

               while(var2 != var4) {
                  if(var2 < var4) {
                     ++var2;
                  } else if(var2 > var4) {
                     --var2;
                  }

                  if((class61.tileSettings[class5.plane][var1][var2] & 4) != 0) {
                     var0 = class5.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var1 < var3) {
                        ++var1;
                     } else if(var1 > var3) {
                        --var1;
                     }

                     if((class61.tileSettings[class5.plane][var1][var2] & 4) != 0) {
                        var0 = class5.plane;
                     }
                  }
               }
            }
         }

         if(AbstractByteBuffer.localPlayer.x >= 0 && AbstractByteBuffer.localPlayer.y >= 0 && AbstractByteBuffer.localPlayer.x < 13312 && AbstractByteBuffer.localPlayer.y < 13312) {
            if((class61.tileSettings[class5.plane][AbstractByteBuffer.localPlayer.x >> 7][AbstractByteBuffer.localPlayer.y >> 7] & 4) != 0) {
               var0 = class5.plane;
            }

            return var0;
         } else {
            return class5.plane;
         }
      }
   }

   @ObfuscatedName("k")
   public static String method1610(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class268.field3678[(int)(var6 - 37L * var0)];
               if(var8 == '_') {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }
}

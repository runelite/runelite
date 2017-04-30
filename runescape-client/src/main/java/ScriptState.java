import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("d")
   Script field113;
   @ObfuscatedName("n")
   int[] field114;
   @ObfuscatedName("q")
   String[] field115;
   @ObfuscatedName("kp")
   static Widget[] field117;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -380192045
   )
   int field118;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)LKitDefinition;",
      garbageValue = "584000944"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.field2833.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class6.field57.getConfigData(3, var0);
         var1 = new KitDefinition();
         if(var2 != null) {
            var1.method3510(new Buffer(var2));
         }

         KitDefinition.field2833.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIIIIII)V",
      garbageValue = "-457296553"
   )
   static final void method152(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class10.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  int[] var8 = class10.tileHeights[0][var2];
                  int var11 = var4 + var2 + 932731;
                  int var12 = var3 + 556238 + var5;
                  int var13 = class10.method150(var11 + '넵', var12 + 91923, 4) - 128 + (class10.method150(var11 + 10294, var12 + '鎽', 2) - 128 >> 1) + (class10.method150(var11, var12, 1) - 128 >> 2);
                  var13 = (int)(0.3D * (double)var13) + 35;
                  if(var13 < 10) {
                     var13 = 10;
                  } else if(var13 > 60) {
                     var13 = 60;
                  }

                  var8[var3] = -var13 * 8;
               } else {
                  class10.tileHeights[var1][var2][var3] = class10.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var14 = var0.readUnsignedByte();
               if(var14 == 1) {
                  var14 = 0;
               }

               if(var1 == 0) {
                  class10.tileHeights[0][var2][var3] = -var14 * 8;
               } else {
                  class10.tileHeights[var1][var2][var3] = class10.tileHeights[var1 - 1][var2][var3] - var14 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class119.overlayIds[var1][var2][var3] = var0.readByte();
               class10.overlayPaths[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class124.overlayRotations[var1][var2][var3] = (byte)(var6 + (var7 - 2) & 3);
            } else if(var7 <= 81) {
               class10.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class173.underlayIds[var1][var2][var3] = (byte)(var7 - 81);
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIZB)Ljava/lang/String;",
      garbageValue = "49"
   )
   public static String method153(int var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         if(var0 < 0) {
            return Integer.toString(var0, var1);
         } else {
            int var3 = 2;

            for(int var4 = var0 / var1; var4 != 0; ++var3) {
               var4 /= var1;
            }

            char[] var5 = new char[var3];
            var5[0] = 43;

            for(int var6 = var3 - 1; var6 > 0; --var6) {
               int var7 = var0;
               var0 /= var1;
               int var8 = var7 - var0 * var1;
               if(var8 >= 10) {
                  var5[var6] = (char)(var8 + 87);
               } else {
                  var5[var6] = (char)(var8 + 48);
               }
            }

            return new String(var5);
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   ScriptState() {
      this.field118 = -1;
   }
}

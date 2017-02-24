import java.awt.FontMetrics;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
public class class13 {
   @ObfuscatedName("co")
   static Font field154;
   @ObfuscatedName("bf")
   protected static FontMetrics field156;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZB)I",
      garbageValue = "0"
   )
   static int method169(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var10 + var1 * var5;
            if(var5 != var9 / var1) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BIIII[LCollisionData;B)V",
      garbageValue = "14"
   )
   static final void method170(byte[] var0, int var1, int var2, int var3, int var4, CollisionData[] var5) {
      int var7;
      int var8;
      for(int var6 = 0; var6 < 4; ++var6) {
         for(var7 = 0; var7 < 64; ++var7) {
            for(var8 = 0; var8 < 64; ++var8) {
               if(var7 + var1 > 0 && var7 + var1 < 103 && var2 + var8 > 0 && var2 + var8 < 103) {
                  var5[var6].flags[var1 + var7][var2 + var8] &= -16777217;
               }
            }
         }
      }

      Buffer var10 = new Buffer(var0);

      for(var7 = 0; var7 < 4; ++var7) {
         for(var8 = 0; var8 < 64; ++var8) {
            for(int var9 = 0; var9 < 64; ++var9) {
               class24.method251(var10, var7, var8 + var1, var2 + var9, var3, var4, 0);
            }
         }
      }

   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "-1909642072"
   )
   static final void method171(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class25 var9 = null;

      for(class25 var10 = (class25)Client.field436.method2458(); null != var10; var10 = (class25)Client.field436.method2472()) {
         if(var0 == var10.field594 && var10.field598 == var1 && var2 == var10.field595 && var10.field593 == var3) {
            var9 = var10;
            break;
         }
      }

      if(null == var9) {
         var9 = new class25();
         var9.field594 = var0;
         var9.field593 = var3;
         var9.field598 = var1;
         var9.field595 = var2;
         class105.method2057(var9);
         Client.field436.method2453(var9);
      }

      var9.field599 = var4;
      var9.field608 = var5;
      var9.field600 = var6;
      var9.field602 = var7;
      var9.field603 = var8;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "-71"
   )
   static final void method172(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(var6 != 0) {
         var11 = class84.field1468[var6];
         var12 = class84.field1462[var6];
         var13 = var9 * var12 - var11 * var5 >> 16;
         var10 = var11 * var9 + var5 * var12 >> 16;
         var9 = var13;
      }

      if(var7 != 0) {
         var11 = class84.field1468[var7];
         var12 = class84.field1462[var7];
         var13 = var12 * var8 + var10 * var11 >> 16;
         var10 = var10 * var12 - var8 * var11 >> 16;
         var8 = var13;
      }

      VertexNormal.cameraX = var0 - var8;
      class36.cameraZ = var1 - var9;
      class37.cameraY = var2 - var10;
      Actor.cameraPitch = var3;
      class26.cameraYaw = var4;
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "21"
   )
   static void method173() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         if(class164.method3158(Client.menuTypes[var0])) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var1 = var0; var1 < Client.menuOptionCount - 1; ++var1) {
                  Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
                  Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
                  Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
                  Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
                  Client.menuActionParams0[var1] = Client.menuActionParams0[var1 + 1];
                  Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }

   class13() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)LNPCComposition;",
      garbageValue = "1847946704"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.field3004.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.field3005.getConfigData(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(null != var2) {
            var1.method3737(new Buffer(var2));
         }

         var1.method3730();
         NPCComposition.field3004.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-34"
   )
   static final int method175(int var0, int var1) {
      int var2 = var0 + 57 * var1;
      var2 ^= var2 << 13;
      int var3 = (789221 + 15731 * var2 * var2) * var2 + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }
}

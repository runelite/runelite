import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jz")
public class class269 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   IndexDataBase field3681;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   IndexDataBase field3682;
   @ObfuscatedName("r")
   HashMap field3683;

   @ObfuscatedSignature(
      signature = "(Lij;Lij;)V"
   )
   public class269(IndexDataBase var1, IndexDataBase var2) {
      this.field3681 = var1;
      this.field3682 = var2;
      this.field3683 = new HashMap();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([Lju;B)Ljava/util/HashMap;",
      garbageValue = "97"
   )
   public HashMap method4748(class268[] var1) {
      HashMap var2 = new HashMap();
      class268[] var3 = var1;

      for(int var4 = 0; var4 < var3.length; ++var4) {
         class268 var5 = var3[var4];
         if(this.field3683.containsKey(var5)) {
            var2.put(var5, this.field3683.get(var5));
         } else {
            Font var6 = class44.method600(this.field3681, this.field3682, var5.field3675, "");
            if(var6 != null) {
               this.field3683.put(var5, var6);
               var2.put(var5, var6);
            }
         }
      }

      return var2;
   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "1782142227"
   )
   static final void method4754(int var0, int var1, int var2, int var3, int var4) {
      int var5 = Client.region.method2714(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = Client.region.method2718(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = GraphicsObject.field1280.pixels;
         var11 = var1 * 4 + (103 - var2) * 2048 + 24624;
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = ClientPacket.getObjectDefinition(var12);
         if(var13.mapSceneId != -1) {
            IndexedSprite var14 = ScriptEvent.mapscene[var13.mapSceneId];
            if(var14 != null) {
               int var15 = (var13.sizeX * 4 - var14.originalWidth) / 2;
               int var16 = (var13.sizeY * 4 - var14.height) / 2;
               var14.method5097(var1 * 4 + var15 + 48, var16 + (104 - var2 - var13.sizeY) * 4 + 48);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = Client.region.method2716(var0, var1, var2);
      if(var5 != 0) {
         var6 = Client.region.method2718(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = ClientPacket.getObjectDefinition(var9);
         int var18;
         if(var23.mapSceneId != -1) {
            IndexedSprite var17 = ScriptEvent.mapscene[var23.mapSceneId];
            if(var17 != null) {
               var12 = (var23.sizeX * 4 - var17.originalWidth) / 2;
               var18 = (var23.sizeY * 4 - var17.height) / 2;
               var17.method5097(var12 + var1 * 4 + 48, var18 + (104 - var2 - var23.sizeY) * 4 + 48);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var22 = GraphicsObject.field1280.pixels;
            var18 = var1 * 4 + (103 - var2) * 2048 + 24624;
            if(var7 != 0 && var7 != 2) {
               var22[var18] = var11;
               var22[var18 + 1 + 512] = var11;
               var22[var18 + 1024 + 2] = var11;
               var22[var18 + 1536 + 3] = var11;
            } else {
               var22[var18 + 1536] = var11;
               var22[var18 + 1 + 1024] = var11;
               var22[var18 + 512 + 2] = var11;
               var22[var18 + 3] = var11;
            }
         }
      }

      var5 = Client.region.method2717(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var19 = ClientPacket.getObjectDefinition(var6);
         if(var19.mapSceneId != -1) {
            IndexedSprite var20 = ScriptEvent.mapscene[var19.mapSceneId];
            if(var20 != null) {
               var9 = (var19.sizeX * 4 - var20.originalWidth) / 2;
               int var21 = (var19.sizeY * 4 - var20.height) / 2;
               var20.method5097(var1 * 4 + var9 + 48, (104 - var2 - var19.sizeY) * 4 + var21 + 48);
            }
         }
      }

   }
}

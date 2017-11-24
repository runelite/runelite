import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
final class class3 implements class0 {
   @ObfuscatedName("or")
   @ObfuscatedSignature(
      signature = "Ldo;"
   )
   @Export("soundSystem0")
   static AbstractSoundSystem soundSystem0;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   public static IndexDataBase field22;
   @ObfuscatedName("b")
   static int[] field23;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lcf;"
   )
   static class102 field20;
   @ObfuscatedName("dp")
   @ObfuscatedGetter(
      intValue = 1732262137
   )
   static int field19;
   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   @Export("mapedge")
   static SpritePixels mapedge;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Ljv;",
      garbageValue = "39"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.objects.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = SoundTask.objects_ref.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         if(var1.isSolid) {
            var1.interactType = 0;
            var1.field3517 = false;
         }

         ObjectComposition.objects.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1549395225"
   )
   @Export("ilog")
   public static int ilog(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)Z",
      garbageValue = "-353192749"
   )
   static final boolean method10(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = class133.field1901 + var6;
      if(var7 < var0 && var7 < var1 && var7 < var2) {
         return false;
      } else {
         var7 = class133.field1901 - var6;
         if(var7 > var0 && var7 > var1 && var7 > var2) {
            return false;
         } else {
            var7 = class133.field1900 + var6;
            if(var7 < var3 && var7 < var4 && var7 < var5) {
               return false;
            } else {
               var7 = class133.field1900 - var6;
               return var7 <= var3 || var7 <= var4 || var7 <= var5;
            }
         }
      }
   }

   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "(Lbw;ZS)V",
      garbageValue = "18121"
   )
   static void method7(Player var0, boolean var1) {
      if(var0 != null && var0.hasConfig() && !var0.hidden) {
         int var2 = var0.field857 << 14;
         var0.field841 = false;
         if((Client.lowMemory && class94.playerIndexesCount > 50 || class94.playerIndexesCount > 200) && var1 && var0.poseAnimation == var0.idlePoseAnimation) {
            var0.field841 = true;
         }

         int var3 = var0.x >> 7;
         int var4 = var0.y >> 7;
         if(var3 >= 0 && var3 < 104 && var4 >= 0 && var4 < 104) {
            if(var0.model != null && Client.gameCycle >= var0.field848 && Client.gameCycle < var0.field844) {
               var0.field841 = false;
               var0.field842 = class41.getTileHeight(var0.x, var0.y, class233.plane);
               class14.region.method2809(class233.plane, var0.x, var0.y, var0.field842, 60, var0, var0.angle, var2, var0.field849, var0.field850, var0.field851, var0.field852);
            } else {
               if((var0.x & 127) == 64 && (var0.y & 127) == 64) {
                  if(Client.field957[var3][var4] == Client.field958) {
                     return;
                  }

                  Client.field957[var3][var4] = Client.field958;
               }

               var0.field842 = class41.getTileHeight(var0.x, var0.y, class233.plane);
               class14.region.method2808(class233.plane, var0.x, var0.y, var0.field842, 60, var0, var0.angle, var2, var0.field1201);
            }
         }
      }

   }
}

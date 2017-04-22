import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
public class class15 {
   @ObfuscatedName("i")
   static final class15 field167 = new class15();
   @ObfuscatedName("u")
   static final class15 field168 = new class15();
   @ObfuscatedName("h")
   static final class15 field169 = new class15();
   @ObfuscatedName("es")
   static SpritePixels[] field170;
   @ObfuscatedName("ee")
   static SpritePixels[] field171;
   @ObfuscatedName("nm")
   @ObfuscatedGetter(
      intValue = -1540521129
   )
   static int field172;
   @ObfuscatedName("v")
   static String[] field173;
   @ObfuscatedName("f")
   static final class15 field174 = new class15();
   @ObfuscatedName("w")
   @Export("worldServersDownload")
   static class26 worldServersDownload;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIIB)V",
      garbageValue = "126"
   )
   static void method166(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var2 + var3) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method166(var0, var1, var2, var5 - 1);
         method166(var0, var1, var5 + 1, var3);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)LNPCComposition;",
      garbageValue = "1369460343"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.field3026.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.field3022.getConfigData(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.method3737(new Buffer(var2));
         }

         var1.method3752();
         NPCComposition.field3026.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1256684476"
   )
   public static int method168(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 <= 127) {
            ++var2;
         } else if(var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "2104301283"
   )
   static int method169(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = FaceNormal.method1932(class32.field743[--Preferences.field713]);
      } else {
         var3 = var2?class154.field2123:class32.field746;
      }

      class22.method197(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class32.field743[--Preferences.field713];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = Projectile.localPlayer.composition.method3208();
            return 1;
         } else {
            return 2;
         }
      } else {
         Preferences.field713 -= 2;
         int var4 = class32.field743[Preferences.field713];
         int var5 = class32.field743[Preferences.field713 + 1];
         var3.item = var4;
         var3.stackSize = var5;
         ItemComposition var6 = class196.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.field2268 = var6.offsetX2d;
         var3.field2269 = var6.offsetY2d;
         var3.field2320 = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2277 = 0;
         } else if(var0 == 1212 | var6.isStackable == 1) {
            var3.field2277 = 1;
         } else {
            var3.field2277 = 2;
         }

         if(var3.field2274 > 0) {
            var3.field2320 = var3.field2320 * 32 / var3.field2274;
         } else if(var3.originalWidth > 0) {
            var3.field2320 = var3.field2320 * 32 / var3.originalWidth;
         }

         return 1;
      }
   }
}

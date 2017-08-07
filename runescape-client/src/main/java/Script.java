import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   static NodeCache field1525;
   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "[Lkn;"
   )
   static SpritePixels[] field1523;
   @ObfuscatedName("n")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("g")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 317759745
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1661334907
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("y")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1209564951
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "[Lgw;"
   )
   @Export("switches")
   IterableHashTable[] switches;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1244418939
   )
   @Export("stringStackCount")
   int stringStackCount;

   static {
      field1525 = new NodeCache(128);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)[Lgw;",
      garbageValue = "635741090"
   )
   IterableHashTable[] method1882(int var1) {
      return new IterableHashTable[var1];
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lit;III)Z",
      garbageValue = "-1670433371"
   )
   static boolean method1883(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         Widget.decodeSprite(var3);
         return true;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljp;I)V",
      garbageValue = "270462294"
   )
   static final void method1891(IndexedSprite var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class18.field316.length; ++var2) {
         class18.field316[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class18.field316[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class97.field1503[var5] = (class18.field316[var5 + 128] + class18.field316[var5 + 1] + class18.field316[var5 - 1] + class18.field316[var5 - 128]) / 4;
            }
         }

         int[] var8 = class18.field316;
         class18.field316 = class97.field1503;
         class97.field1503 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + var0.offsetX + 16;
                  int var6 = var3 + var0.offsetY + 16;
                  int var7 = var5 + (var6 << 7);
                  class18.field316[var7] = 0;
               }
            }
         }
      }

   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   static NodeCache field1546;
   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "[Ljx;"
   )
   static IndexedSprite[] field1549;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Las;"
   )
   static class47 field1543;
   @ObfuscatedName("j")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("a")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1798142611
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1949922097
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("r")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -293602213
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 506993195
   )
   @Export("stringStackCount")
   int stringStackCount;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "[Lgi;"
   )
   @Export("switches")
   IterableHashTable[] switches;

   static {
      field1546 = new NodeCache(128);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)[Lgi;",
      garbageValue = "-1230171328"
   )
   IterableHashTable[] method1857(int var1) {
      return new IterableHashTable[var1];
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-617187399"
   )
   public static int method1861(CharSequence var0) {
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

   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "(Lbg;B)V",
      garbageValue = "48"
   )
   static final void method1860(Actor var0) {
      if(var0.field1276 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.field1263 + 1 > class216.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
         int var1 = var0.field1276 - var0.field1275;
         int var2 = Client.gameCycle - var0.field1275;
         int var3 = var0.field1271 * 128 + var0.field1233 * 64;
         int var4 = var0.field1233 * 64 + var0.field1229 * 128;
         int var5 = var0.field1233 * 64 + var0.field1239 * 128;
         int var6 = var0.field1274 * 128 + var0.field1233 * 64;
         var0.x = (var2 * var5 + var3 * (var1 - var2)) / var1;
         var0.y = (var6 * var2 + var4 * (var1 - var2)) / var1;
      }

      var0.field1287 = 0;
      var0.orientation = var0.field1277;
      var0.angle = var0.orientation;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "209574792"
   )
   static final boolean method1859(char var0) {
      if(Character.isISOControl(var0)) {
         return false;
      } else if(class44.method660(var0)) {
         return true;
      } else {
         char[] var1 = class268.field3661;

         int var2;
         char var3;
         for(var2 = 0; var2 < var1.length; ++var2) {
            var3 = var1[var2];
            if(var0 == var3) {
               return true;
            }
         }

         var1 = class268.field3662;

         for(var2 = 0; var2 < var1.length; ++var2) {
            var3 = var1[var2];
            if(var0 == var3) {
               return true;
            }
         }

         return false;
      }
   }
}

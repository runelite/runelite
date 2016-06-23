import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
@Implements("XItemContainer")
public class class15 extends class208 {
   @ObfuscatedName("u")
   @Export("itemIds")
   int[] field221 = new int[]{-1};
   @ObfuscatedName("x")
   @Export("stackSizes")
   int[] field223 = new int[]{0};
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 1285205255
   )
   static int field224;
   @ObfuscatedName("hc")
   @Export("localPlayer")
   static class2 field225;
   @ObfuscatedName("f")
   @Export("itemContainers")
   static class196 field229 = new class196(32);

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1624877793"
   )
   static final int method179(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var0 & '\uff00') * var3 + var2 * (var1 & '\uff00') & 16711680) + ((var0 & 16711935) * var3 + (var1 & 16711935) * var2 & -16711936) >> 8;
   }

   @ObfuscatedName("su")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "739975606"
   )
   protected static final void method182() {
      class111.field1965 = null;
      class25.field647 = null;
      class25.field652 = null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/String;",
      garbageValue = "8"
   )
   public static String method185(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            char var6;
            if(var5 != 181 && var5 != 402) {
               var6 = Character.toTitleCase(var5);
            } else {
               var6 = var5;
            }

            var5 = var6;
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "2027931024"
   )
   public static int method190(int var0) {
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

      return var1 + var0;
   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 833809969
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 270026369
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1396987937
   )
   @Export("x")
   int x;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1678907967
   )
   @Export("y")
   int y;
   @ObfuscatedName("b")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1266742377
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1660533217
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1498494521
   )
   @Export("height")
   int height;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1729456781
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 549594881
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -385252105
   )
   int field2206;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1751386743
   )
   int field2207;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 731070671
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1126082421
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = 1003642159
   )
   static int field2212;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "55"
   )
   public static boolean method2898(int var0) {
      return (var0 >> 30 & 1) != 0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)Z",
      garbageValue = "1191280799"
   )
   static final boolean method2899(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = class134.field2007 + var6;
      if(var7 < var0 && var7 < var1 && var7 < var2) {
         return false;
      } else {
         var7 = class134.field2007 - var6;
         if(var7 > var0 && var7 > var1 && var7 > var2) {
            return false;
         } else {
            var7 = var6 + class134.field2008;
            if(var7 < var3 && var7 < var4 && var7 < var5) {
               return false;
            } else {
               var7 = class134.field2008 - var6;
               return var7 <= var3 || var7 <= var4 || var7 <= var5;
            }
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-18745560"
   )
   public static boolean method2900(int var0) {
      return (var0 >> 28 & 1) != 0;
   }

   GameObject() {
      this.hash = 0;
      this.flags = 0;
   }
}

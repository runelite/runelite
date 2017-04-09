import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -366104387
   )
   @Export("x")
   int x;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1189537009
   )
   @Export("y")
   int y;
   @ObfuscatedName("h")
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 399561179
   )
   @Export("height")
   int height;
   @ObfuscatedName("o")
   @Export("top")
   Renderable top;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1842905521
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("r")
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1506530959
   )
   @Export("hash")
   int hash;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-10"
   )
   public static final boolean method1491() {
      class105 var0 = class105.keyboard;
      class105 var1 = class105.keyboard;
      class105 var2 = class105.keyboard;
      synchronized(class105.keyboard) {
         if(class105.field1726 == class105.field1742) {
            return false;
         } else {
            class203.field3084 = class105.field1739[class105.field1742];
            class37.field810 = class105.field1738[class105.field1742];
            class105.field1742 = class105.field1742 + 1 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "959481574"
   )
   public static void method1492() {
      PlayerComposition.field2193.reset();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)Lclass216;",
      garbageValue = "1"
   )
   public static class216 method1493(int var0) {
      class216[] var1 = new class216[]{class216.field3182, class216.field3184, class216.field3183};
      class216[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class216 var4 = var2[var3];
         if(var4.field3181 == var0) {
            return var4;
         }
      }

      return null;
   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1852266975
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1367765709
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1806805349
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1070600819
   )
   @Export("x")
   int x;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 237942733
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 188151517
   )
   @Export("y")
   int y;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1578198647
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Leq;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Leq;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1391964401
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 443380997
   )
   @Export("rotation")
   int rotation;

   DecorativeObject() {
      this.hash = 0;
      this.renderInfoBitPacked = 0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILfx;Lil;I)V",
      garbageValue = "-1639884748"
   )
   static void method2921(int var0, IndexFile var1, IndexData var2) {
      FileSystem var3 = new FileSystem();
      var3.field3196 = 1;
      var3.hash = (long)var0;
      var3.index = var1;
      var3.data = var2;
      Deque var4 = class237.field3224;
      synchronized(class237.field3224) {
         class237.field3224.addFront(var3);
      }

      class229.method4092();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "1486105043"
   )
   public static boolean method2923(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "1454752615"
   )
   static int method2922(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 612640247
   )
   @Export("x")
   int x;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1754899277
   )
   @Export("y")
   int y;
   @ObfuscatedName("z")
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 458059349
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 17920465
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -438014603
   )
   @Export("height")
   int height;
   @ObfuscatedName("g")
   @Export("top")
   Renderable top;
   @ObfuscatedName("p")
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 2037239257
   )
   static int field1726;

   @ObfuscatedName("pa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1250366375"
   )
   protected static final void method2181() {
      class14.field199.vmethod3110();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field2251[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field2238[var0] = 0L;
      }

      class34.field752 = 0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-935101126"
   )
   public static void method2182() {
      if(class174.field2772 != null) {
         class174.field2772.method2986();
      }

   }
}

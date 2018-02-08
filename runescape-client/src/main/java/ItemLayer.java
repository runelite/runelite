import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   static Widget field1668;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 977221795
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2046703061
   )
   @Export("x")
   int x;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Leh;"
   )
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -556157669
   )
   @Export("y")
   int y;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Leh;"
   )
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Leh;"
   )
   @Export("top")
   Renderable top;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 509129771
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 16299375
   )
   @Export("height")
   int height;

   @ObfuscatedName("jy")
   @ObfuscatedSignature(
      signature = "(Lhs;IIII)V",
      garbageValue = "-1532370272"
   )
   static final void method2618(Widget var0, int var1, int var2, int var3) {
      class221 var4 = var0.method4421(false);
      if(var4 != null) {
         if(Client.field978 < 3) {
            GameEngine.compass.method5695(var1, var2, var4.field2708, var4.field2703, 25, 25, Client.mapAngle, 256, var4.field2704, var4.field2702);
         } else {
            Rasterizer2D.method5598(var1, var2, 0, var4.field2704, var4.field2702);
         }

      }
   }
}

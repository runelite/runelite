import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class16 extends class131 {
   @ObfuscatedName("ha")
   @Export("localPlayer")
   static Player localPlayer;
   @ObfuscatedName("g")
   String field169;
   @ObfuscatedName("x")
   short field170;
   @ObfuscatedName("er")
   static SpritePixels[] field171;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1781922129
   )
   int field173 = (int)(FrameMap.method1695() / 1000L);

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1211798899"
   )
   public static int method185(int var0) {
      var0 = (var0 & 1431655765) + (var0 >>> 1 & 1431655765);
      var0 = (var0 >>> 2 & 858993459) + (var0 & 858993459);
      var0 = var0 + (var0 >>> 4) & 252645135;
      var0 += var0 >>> 8;
      var0 += var0 >>> 16;
      return var0 & 255;
   }

   class16(String var1, int var2) {
      this.field169 = var1;
      this.field170 = (short)var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;I)V",
      garbageValue = "-2073915257"
   )
   public static void method186(class182 var0, class182 var1) {
      class231.field3282 = var0;
      KitDefinition.field2819 = var1;
      KitDefinition.field2814 = class231.field3282.method3309(3);
   }
}

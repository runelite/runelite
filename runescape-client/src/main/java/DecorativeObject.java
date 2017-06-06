import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -625095219
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 49959151
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1844850333
   )
   @Export("y")
   int y;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1991191937
   )
   @Export("rotation")
   int rotation;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 971612093
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -117382965
   )
   @Export("x")
   int x;
   @ObfuscatedName("x")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("f")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -715980565
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2007977561
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 430291837
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2002002193
   )
   static int field2195;

   DecorativeObject() {
      this.hash = 0;
      this.renderInfoBitPacked = 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)[Lclass283;",
      garbageValue = "-631399032"
   )
   public static class283[] method2897() {
      return new class283[]{class283.field3765, class283.field3766, class283.field3768, class283.field3764, class283.field3769};
   }
}

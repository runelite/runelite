import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1188092841
   )
   @Export("height")
   int height;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1405222777
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("v")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1094554417
   )
   @Export("y")
   int y;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 419818415
   )
   int field1725;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2015916445
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1476008723
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -41944989
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 385126189
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1913647289
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -335681823
   )
   @Export("x")
   int x;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1638704879
   )
   int field1732;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -712256579
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1464297975
   )
   @Export("flags")
   int flags = 0;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1965089020"
   )
   public static void method2270(Buffer var0, int var1) {
      if(class152.field2283 != null) {
         try {
            class152.field2283.method4165(0L);
            class152.field2283.method4176(var0.payload, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }
}

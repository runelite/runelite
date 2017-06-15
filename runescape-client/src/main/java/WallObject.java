import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -848540847
   )
   int field2130;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -765934065
   )
   @Export("x")
   int x;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1055437563
   )
   @Export("y")
   int y;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 947079187
   )
   int field2134;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -408430209
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2106010175
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("z")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("ed")
   @Export("font_p12full")
   static Font font_p12full;
   @ObfuscatedName("q")
   static int[] field2140;
   @ObfuscatedName("j")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1767203635
   )
   int field2142;
   @ObfuscatedName("fa")
   static int[] field2143;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-568035514"
   )
   public static boolean method2761(char var0) {
      return var0 >= 48 && var0 <= 57;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-54"
   )
   static void method2762() {
      for(class82 var0 = (class82)class82.field1314.method3487(); var0 != null; var0 = (class82)class82.field1314.method3512()) {
         if(var0.field1319 != null) {
            var0.method1514();
         }
      }

   }

   WallObject() {
      this.hash = 0;
      this.field2134 = 0;
   }
}

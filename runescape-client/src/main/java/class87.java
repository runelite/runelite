import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
@Implements("WallObject")
public final class class87 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -658008531
   )
   int field1532;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -368256089
   )
   @Export("x")
   int field1533;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -400110427
   )
   @Export("y")
   int field1534;
   @ObfuscatedName("r")
   @Export("renderable1")
   public class85 field1535;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 754735853
   )
   int field1536;
   @ObfuscatedName("f")
   @Export("renderable2")
   public class85 field1538;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 214995467
   )
   @Export("floor")
   int field1539;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 501266397
   )
   int field1540 = 0;
   @ObfuscatedName("br")
   static class80 field1541;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 735788493
   )
   static int field1542;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1437571303
   )
   @Export("hash")
   public int field1543 = 0;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "21"
   )
   static void method2045() {
      Object var0 = class170.field2739;
      synchronized(class170.field2739) {
         if(class170.field2736 == 0) {
            class77.field1400.method2868(new class170(), 5);
         }

         class170.field2736 = 600;
      }
   }
}

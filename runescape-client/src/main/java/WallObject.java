import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = 900785193
   )
   static int field2113;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1572480857
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1572962761
   )
   @Export("config")
   int config;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2064834737
   )
   @Export("x")
   int x;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1155232631
   )
   @Export("y")
   int y;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 398892399
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -354676823
   )
   @Export("orientationA")
   int orientationA;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2061046043
   )
   @Export("orientationB")
   int orientationB;

   WallObject() {
      this.hash = 0;
      this.config = 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lit;I)V",
      garbageValue = "-77716496"
   )
   public static void method2907(IndexDataBase var0) {
      Varbit.varbit_ref = var0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)Lbs;",
      garbageValue = "1664501663"
   )
   static MessageNode method2908(int var0) {
      return (MessageNode)class99.field1516.get((long)var0);
   }
}

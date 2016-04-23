import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
@Implements("World")
public class class25 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 602462639
   )
   @Export("mask")
   int field613;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1680916519
   )
   static int field614 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1571771057
   )
   static int field615 = 0;
   @ObfuscatedName("x")
   @Export("worldList")
   static class25[] field616;
   @ObfuscatedName("n")
   static int[] field617 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1312459195
   )
   @Export("id")
   int field618;
   @ObfuscatedName("p")
   @Export("activity")
   String field620;
   @ObfuscatedName("mi")
   static class78 field621;
   @ObfuscatedName("c")
   static int[] field622 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2066452137
   )
   @Export("location")
   int field623;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1607830619
   )
   @Export("index")
   int field624;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -369024489
   )
   @Export("playerCount")
   int field625;
   @ObfuscatedName("d")
   @Export("address")
   String field627;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "30595"
   )
   boolean method599() {
      return 0 != (1 & this.field613);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "122"
   )
   boolean method602() {
      return (8 & this.field613) != 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "16"
   )
   boolean method603() {
      return 0 != (2 & this.field613);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1711172233"
   )
   boolean method604() {
      return (33554432 & this.field613) != 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "67"
   )
   boolean method605() {
      return (4 & this.field613) != 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1195110554"
   )
   boolean method620() {
      return 0 != (536870912 & this.field613);
   }
}

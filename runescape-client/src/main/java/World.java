import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
@Implements("World")
public class World {
   @ObfuscatedName("pk")
   @ObfuscatedGetter(
      intValue = -329175085
   )
   static int field1224;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2062675443
   )
   @Export("worldCount")
   static int worldCount;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -677262287
   )
   static int field1211;
   @ObfuscatedName("y")
   static int[] field1210;
   @ObfuscatedName("c")
   static int[] field1213;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -960732233
   )
   @Export("id")
   int id;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -412626375
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1102653745
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("r")
   @Export("address")
   String address;
   @ObfuscatedName("p")
   @Export("activity")
   String activity;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1567129033
   )
   @Export("location")
   int location;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 645250669
   )
   @Export("index")
   int index;

   static {
      worldCount = 0;
      field1211 = 0;
      field1210 = new int[]{1, 1, 1, 1};
      field1213 = new int[]{0, 1, 2, 3};
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-552123468"
   )
   boolean method1727() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-100"
   )
   boolean method1728() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-648455335"
   )
   boolean method1729() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1604899257"
   )
   boolean method1761() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-83"
   )
   boolean method1746() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-732077450"
   )
   boolean method1726() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Ldh;I)V",
      garbageValue = "-83448651"
   )
   static final void method1763(TaskDataNode var0) {
      var0.field1621 = false;
      if(var0.data != null) {
         var0.data.int1 = 0;
      }

      for(TaskDataNode var1 = var0.vmethod4437(); var1 != null; var1 = var0.vmethod4424()) {
         method1763(var1);
      }

   }
}

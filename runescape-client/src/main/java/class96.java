import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
@Implements("GroundObject")
public final class class96 {
   @ObfuscatedName("g")
   @Export("renderable")
   public class88 field1662;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -796879915
   )
   @Export("x")
   int field1663;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1415286119
   )
   @Export("floor")
   int field1665;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -876444219
   )
   @Export("hash")
   public int field1666;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1993760365
   )
   int field1667;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -243717087
   )
   @Export("y")
   int field1668;
   @ObfuscatedName("iq")
   @ObfuscatedGetter(
      intValue = -1347286939
   )
   static int field1669;
   @ObfuscatedName("b")
   static int[] field1672;

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "0"
   )
   static void method2248(int var0, int var1) {
      if(client.field507 != 0 && var0 != -1) {
         class153.method3190(class139.field2155, var0, 0, client.field507, false);
         client.field532 = true;
      }

   }
}

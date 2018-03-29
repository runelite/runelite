import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public class class1 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Li;"
   )
   static final class1 field8;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Li;"
   )
   static final class1 field6;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Li;"
   )
   static final class1 field2;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Li;"
   )
   static final class1 field3;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Li;"
   )
   static final class1 field4;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Li;"
   )
   static final class1 field5;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Li;"
   )
   static final class1 field13;
   @ObfuscatedName("d")
   @Export("floorSaturations")
   static int[] floorSaturations;
   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("indexMaps")
   static IndexData indexMaps;
   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("indexTrack1")
   static IndexData indexTrack1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -726771211
   )
   final int field7;

   static {
      field8 = new class1(5);
      field6 = new class1(2);
      field2 = new class1(1);
      field3 = new class1(4);
      field4 = new class1(0);
      field5 = new class1(6);
      field13 = new class1(3);
   }

   class1(int var1) {
      this.field7 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "-1"
   )
   public static boolean method0(char var0) {
      return var0 >= '0' && var0 <= '9';
   }
}

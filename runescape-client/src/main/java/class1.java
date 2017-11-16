import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
public class class1 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ls;"
   )
   static final class1 field7;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ls;"
   )
   static final class1 field3;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ls;"
   )
   static final class1 field2;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ls;"
   )
   static final class1 field0;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ls;"
   )
   static final class1 field4;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ls;"
   )
   static final class1 field5;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ls;"
   )
   static final class1 field1;
   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   @Export("rssocket")
   static RSSocket rssocket;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1432574153
   )
   final int field6;

   static {
      field7 = new class1(3);
      field3 = new class1(2);
      field2 = new class1(5);
      field0 = new class1(1);
      field4 = new class1(0);
      field5 = new class1(6);
      field1 = new class1(4);
   }

   class1(int var1) {
      this.field6 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(CIB)I",
      garbageValue = "49"
   )
   static int method0(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }
}

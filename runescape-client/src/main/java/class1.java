import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
public class class1 {
   @ObfuscatedName("v")
   static final class1 field0;
   @ObfuscatedName("c")
   static final class1 field1;
   @ObfuscatedName("e")
   static final class1 field2;
   @ObfuscatedName("b")
   static final class1 field4;
   @ObfuscatedName("y")
   static final class1 field5;
   @ObfuscatedName("fm")
   @Export("region")
   static Region region;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1246422345
   )
   final int field7;
   @ObfuscatedName("h")
   static final class1 field9;
   @ObfuscatedName("i")
   static final class1 field11;
   @ObfuscatedName("rp")
   static RenderOverview field14;

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "3"
   )
   class1(int var1) {
      this.field7 = var1;
   }

   static {
      field11 = new class1(3);
      field1 = new class1(5);
      field2 = new class1(1);
      field0 = new class1(6);
      field4 = new class1(0);
      field5 = new class1(2);
      field9 = new class1(4);
   }
}

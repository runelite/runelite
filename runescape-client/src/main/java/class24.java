import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class24 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lz;"
   )
   public static final class24 field338;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lz;"
   )
   public static final class24 field336;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lz;"
   )
   public static final class24 field337;
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = 1201223335
   )
   static int field343;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -270762701
   )
   final int field341;
   @ObfuscatedName("y")
   final String field342;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2080438547
   )
   final int field339;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2010048021
   )
   final int field335;

   static {
      field338 = new class24("SMALL", 1, 0, 4);
      field336 = new class24("MEDIUM", 0, 1, 2);
      field337 = new class24("LARGE", 2, 2, 0);
   }

   class24(String var1, int var2, int var3, int var4) {
      this.field342 = var1;
      this.field339 = var2;
      this.field335 = var3;
      this.field341 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(FI)Z",
      garbageValue = "-293341391"
   )
   boolean method166(float var1) {
      return var1 >= (float)this.field341;
   }
}

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class24 {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lj;"
   )
   public static final class24 field358;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lj;"
   )
   public static final class24 field361;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lj;"
   )
   public static final class24 field359;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -635012521
   )
   final int field360;
   @ObfuscatedName("y")
   final String field365;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -613911943
   )
   final int field362;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1755859593
   )
   final int field363;

   static {
      field358 = new class24("SMALL", 0, 0, 4);
      field361 = new class24("MEDIUM", 1, 1, 2);
      field359 = new class24("LARGE", 2, 2, 0);
   }

   class24(String var1, int var2, int var3, int var4) {
      this.field365 = var1;
      this.field362 = var2;
      this.field363 = var3;
      this.field360 = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(FI)Z",
      garbageValue = "129931996"
   )
   boolean method180(float var1) {
      return var1 >= (float)this.field360;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)Lj;",
      garbageValue = "48"
   )
   static class24 method177(int var0) {
      class24[] var1 = new class24[]{field359, field361, field358};
      class24[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class24 var4 = var2[var3];
         if(var0 == var4.field363) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Lhg;",
      garbageValue = "1572480857"
   )
   public static Widget method183(int var0, int var1) {
      Widget var2 = class266.method4862(var0);
      return var1 == -1?var2:(var2 != null && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }
}

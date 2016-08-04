import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
public class class85 implements class115 {
   @ObfuscatedName("l")
   public static final class85 field1505 = new class85(0, 0);
   @ObfuscatedName("r")
   static final class85 field1507 = new class85(2, 2);
   @ObfuscatedName("a")
   static int[] field1508;
   @ObfuscatedName("h")
   static final class85 field1509 = new class85(4, 4);
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1570428067
   )
   public final int field1510;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2110879391
   )
   final int field1511;
   @ObfuscatedName("g")
   static final class85 field1513 = new class85(1, 1);
   @ObfuscatedName("nq")
   @ObfuscatedGetter(
      intValue = -1952746971
   )
   static int field1514;
   @ObfuscatedName("e")
   static final class85 field1516 = new class85(3, 3);

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([Lclass115;II)Lclass115;",
      garbageValue = "-1741531425"
   )
   public static class115 method1971(class115[] var0, int var1) {
      class115[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class115 var4 = var2[var3];
         if(var1 == var4.vmethod3316()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class85(int var1, int var2) {
      this.field1510 = var1;
      this.field1511 = var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1633970528"
   )
   public int vmethod3316() {
      return this.field1511;
   }
}

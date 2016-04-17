import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
public class class82 implements class112 {
   @ObfuscatedName("d")
   static final class82 field1428 = new class82(2, 2);
   @ObfuscatedName("w")
   static final class82 field1429 = new class82(1, 1);
   @ObfuscatedName("a")
   public static final class82 field1430 = new class82(0, 0);
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1341293467
   )
   public final int field1431;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 225381885
   )
   final int field1434;
   @ObfuscatedName("y")
   static final class82 field1435 = new class82(4, 4);
   @ObfuscatedName("c")
   static final class82 field1438 = new class82(3, 3);
   @ObfuscatedName("nk")
   static class74 field1439;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1405875737"
   )
   public int vmethod3266() {
      return this.field1434;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BB)Lclass224;",
      garbageValue = "69"
   )
   static class224 method1981(byte[] var0) {
      if(var0 == null) {
         return null;
      } else {
         class224 var1 = new class224(var0, class76.field1389, class76.field1387, class126.field2042, class77.field1397, class8.field153, class76.field1388);
         class15.method203();
         return var1;
      }
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class82(int var1, int var2) {
      this.field1431 = var1;
      this.field1434 = var2;
   }
}

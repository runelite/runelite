import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
public final class class92 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1098720487
   )
   int field1634;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1366378845
   )
   int field1635;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2033232279
   )
   int field1636;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1691701653
   )
   int field1637;
   @ObfuscatedName("t")
   boolean field1639 = true;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1914130807
   )
   int field1640;
   @ObfuscatedName("qc")
   @ObfuscatedGetter(
      intValue = -1544477485
   )
   protected static int field1643;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1608972281
   )
   int field1645;

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-106040209"
   )
   static void method2112(int var0, int var1) {
      class32 var2 = WidgetNode.field65;
      class77.menuAction(var2.field734, var2.field725, var2.field726, var2.field727, var2.field728, var2.field728, var0, var1);
      WidgetNode.field65 = null;
   }

   @ObfuscatedSignature(
      signature = "(IIIIIIZ)V",
      garbageValue = "0"
   )
   class92(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field1645 = var1;
      this.field1635 = var2;
      this.field1636 = var3;
      this.field1637 = var4;
      this.field1640 = var5;
      this.field1634 = var6;
      this.field1639 = var7;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "565310358"
   )
   public static int method2113(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var1 + var0;
   }
}

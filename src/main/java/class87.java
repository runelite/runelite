import java.awt.Canvas;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cm")
public final class class87 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -28706739
   )
   int field1531;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -732525999
   )
   int field1532;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1436835183
   )
   int field1533;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 874562583
   )
   int field1534;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1018479613
   )
   int field1535;
   @ObfuscatedName("qf")
   public static Canvas field1537;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2100277823
   )
   public int field1538 = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -474801805
   )
   int field1539 = 0;
   @ObfuscatedName("y")
   public class85 field1540;
   @ObfuscatedName("m")
   public class85 field1541;

   @ObfuscatedName("m")
   public static int method2073(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }

   @ObfuscatedName("s")
   static final int method2074(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - class91.field1595[1024 * var2 / var3] >> 1;
      return (var4 * var1 >> 16) + (var0 * (65536 - var4) >> 16);
   }
}

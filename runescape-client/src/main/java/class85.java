import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
public class class85 implements class115 {
   @ObfuscatedName("e")
   public static final class85 field1503 = new class85(2, 2);
   @ObfuscatedName("w")
   public static final class85 field1504 = new class85(1, 1);
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = 1515726871
   )
   static int field1505;
   @ObfuscatedName("o")
   public static final class85 field1506 = new class85(3, 3);
   @ObfuscatedName("g")
   public static final class85 field1507 = new class85(4, 4);
   @ObfuscatedName("m")
   public static final class85 field1508 = new class85(0, 0);
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -371518651
   )
   final int field1509;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1572186101
   )
   public final int field1510;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1587180348"
   )
   public int vmethod3218() {
      return this.field1509;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class85(int var1, int var2) {
      this.field1510 = var1;
      this.field1509 = var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;B)Lclass83;",
      garbageValue = "-26"
   )
   public static class83 method1974(class170 var0, String var1, String var2) {
      int var3 = var0.method3319(var1);
      int var4 = var0.method3368(var3, var2);
      return class42.method879(var0, var3, var4);
   }
}

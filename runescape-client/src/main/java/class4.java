import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class4 implements class178 {
   @ObfuscatedName("bh")
   static String field20;
   @ObfuscatedName("h")
   static final class4 field21;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -288411119
   )
   final int field22;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -367583375
   )
   final int field23;
   @ObfuscatedName("i")
   static final class4 field24;
   @ObfuscatedName("bd")
   static Game field25;
   @ObfuscatedName("u")
   static final class4 field26;

   class4(int var1, int var2, Class var3, class0 var4) {
      this.field23 = var1;
      this.field22 = var2;
   }

   static {
      field24 = new class4(0, 0, Integer.class, new class2());
      field21 = new class4(2, 1, Long.class, new class3());
      field26 = new class4(1, 2, String.class, new class5());
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1015343640"
   )
   public int vmethod5090() {
      return this.field22;
   }

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   static int method8() {
      return Client.isResized?2:1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1812006985"
   )
   public static String method9(int var0) {
      return (var0 >> 24 & 255) + "." + (var0 >> 16 & 255) + "." + (var0 >> 8 & 255) + "." + (var0 & 255);
   }
}

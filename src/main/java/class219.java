import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
final class class219 implements Comparator {
   @ObfuscatedName("j")
   public static class167 field3172;

   public int compare(Object var1, Object var2) {
      return this.method3963((class214)var1, (class214)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;I)I",
      garbageValue = "-642633925"
   )
   int method3963(class214 var1, class214 var2) {
      return var1.field3162 < var2.field3162?-1:(var1.field3162 == var2.field3162?0:1);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "16777215"
   )
   static String method3968(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }
}

import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hd")
final class class213 implements Comparator {
   @ObfuscatedName("l")
   static class167 field3143;
   @ObfuscatedName("f")
   static class167 field3144;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -851880725
   )
   public static int field3145;

   public int compare(Object var1, Object var2) {
      return this.method3968((class214)var1, (class214)var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;I)I",
      garbageValue = "1984566612"
   )
   int method3968(class214 var1, class214 var2) {
      return var1.method3974().compareTo(var2.method3974());
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}

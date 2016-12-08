import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
final class class5 implements Comparator {
   @ObfuscatedName("cf")
   static class208 field40;
   @ObfuscatedName("hq")
   @Export("localPlayer")
   static Player localPlayer;

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;S)I",
      garbageValue = "-8479"
   )
   int method57(class2 var1, class2 var2) {
      return var1.field19.price < var2.field19.price?-1:(var2.field19.price == var1.field19.price?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method57((class2)var1, (class2)var2);
   }
}

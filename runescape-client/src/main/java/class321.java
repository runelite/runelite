import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lo")
public class class321 implements Comparator {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   static SpritePixels field3938;
   @ObfuscatedName("o")
   final boolean field3937;

   public class321(boolean var1) {
      this.field3937 = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lku;Lku;I)I",
      garbageValue = "-1114519277"
   )
   int method5655(Nameable var1, Nameable var2) {
      return this.field3937?var1.vmethod5448(var2):var2.vmethod5448(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method5655((Nameable)var1, (Nameable)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}

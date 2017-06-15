import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
final class class18 implements Comparator {
   @ObfuscatedName("j")
   @Export("validInterfaces")
   public static boolean[] validInterfaces;
   @ObfuscatedName("gx")
   static SpritePixels[] field332;
   @ObfuscatedName("pp")
   @ObfuscatedGetter(
      intValue = 760763785
   )
   static int field335;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;I)I",
      garbageValue = "-1525850891"
   )
   int method142(class14 var1, class14 var2) {
      return var1.method81().compareTo(var2.method81());
   }

   public int compare(Object var1, Object var2) {
      return this.method142((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-98"
   )
   public static boolean method149() {
      ClassInfo var0 = (ClassInfo)class280.field3749.method3457();
      return var0 != null;
   }
}

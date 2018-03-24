import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
@Implements("WorldComparator")
final class WorldComparator implements Comparator {
   @ObfuscatedName("pi")
   @ObfuscatedSignature(
      signature = "Ldr;"
   )
   @Export("soundSystem0")
   static AbstractSoundSystem soundSystem0;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   static IndexDataBase field258;
   @ObfuscatedName("e")
   @Export("validInterfaces")
   public static boolean[] validInterfaces;
   @ObfuscatedName("p")
   public static short[] field260;
   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   static Widget field261;
   @ObfuscatedName("mx")
   @ObfuscatedGetter(
      intValue = 1861335125
   )
   static int field262;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lu;Lu;I)I",
      garbageValue = "1001922856"
   )
   int method65(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.world < var2.world?-1:(var2.world == var1.world?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method65((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}

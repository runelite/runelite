import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ke")
@Implements("ChatPlayer")
public class ChatPlayer extends Nameable {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 839995305
   )
   @Export("world")
   public int world;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 806385205
   )
   public int field3839;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1824870945
   )
   @Export("rank")
   public int rank;

   ChatPlayer() {
      this.world = -1;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "86941883"
   )
   void method5395(int var1, int var2) {
      this.world = var1;
      this.field3839 = var2;
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1960925756"
   )
   public int method5400() {
      return this.world;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "362145921"
   )
   public boolean method5397() {
      return this.world > 0;
   }
}

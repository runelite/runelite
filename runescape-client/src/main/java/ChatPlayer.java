import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kd")
@Implements("ChatPlayer")
public class ChatPlayer extends Nameable {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1818299933
   )
   @Export("world")
   public int world;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -467035593
   )
   public int field3649;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1378703733
   )
   @Export("rank")
   public int rank;

   ChatPlayer() {
      this.world = -1;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "698375569"
   )
   void method5432(int var1, int var2) {
      this.world = var1;
      this.field3649 = var2;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-21"
   )
   public int method5433() {
      return this.world;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "5"
   )
   public boolean method5438() {
      return this.world > 0;
   }
}

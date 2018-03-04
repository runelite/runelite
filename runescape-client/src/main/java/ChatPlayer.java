import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kz")
@Implements("ChatPlayer")
public class ChatPlayer extends Nameable {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1600722583
   )
   @Export("world")
   public int world;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 210445581
   )
   public int field3840;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2088235327
   )
   @Export("rank")
   public int rank;

   ChatPlayer() {
      this.world = -1;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1744300386"
   )
   void method5508(int var1, int var2) {
      this.world = var1;
      this.field3840 = var2;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1828832037"
   )
   public int method5502() {
      return this.world;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "14"
   )
   public boolean method5503() {
      return this.world > 0;
   }
}

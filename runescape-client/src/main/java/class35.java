import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class35 {
   @ObfuscatedName("a")
   static final class35 field487;
   @ObfuscatedName("j")
   static final class35 field481;
   @ObfuscatedName("ig")
   static Widget field482;
   @ObfuscatedName("kp")
   static Widget field483;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1683261371
   )
   final int field480;

   static {
      field487 = new class35(0);
      field481 = new class35(1);
   }

   class35(int var1) {
      this.field480 = var1;
   }

   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "387058479"
   )
   static final void method484() {
      Region.lowMemory = false;
      Client.lowMemory = false;
   }
}

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
public class class191 extends CacheableNode {
   @ObfuscatedName("c")
   public static NodeCache field2795 = new NodeCache(64);
   @ObfuscatedName("n")
   public boolean field2796 = false;
   @ObfuscatedName("d")
   public static IndexDataBase field2797;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1755495501"
   )
   public void method3465(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3469(var1, var2);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;IS)V",
      garbageValue = "-278"
   )
   void method3469(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2796 = true;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "26"
   )
   public static void method3470() {
      CombatInfo2.field2848.reset();
      CombatInfo2.field2855.reset();
   }
}

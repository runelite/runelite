import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
public class class203 {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   class203 field2571;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   class203 field2570;

   @ObfuscatedName("m")
   public void method3814() {
      if(this.field2570 != null) {
         this.field2570.field2571 = this.field2571;
         this.field2571.field2570 = this.field2570;
         this.field2571 = null;
         this.field2570 = null;
      }
   }
}

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
public class class207 {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   class207 field2604;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   class207 field2605;

   @ObfuscatedName("n")
   public void method3855() {
      if(this.field2605 != null) {
         this.field2605.field2604 = this.field2604;
         this.field2604.field2605 = this.field2605;
         this.field2604 = null;
         this.field2605 = null;
      }
   }
}

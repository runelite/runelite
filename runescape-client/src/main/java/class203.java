import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
public class class203 {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   class203 field2563;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   class203 field2564;

   @ObfuscatedName("b")
   public void method3689() {
      if(this.field2564 != null) {
         this.field2564.field2563 = this.field2563;
         this.field2563.field2564 = this.field2564;
         this.field2563 = null;
         this.field2564 = null;
      }
   }
}

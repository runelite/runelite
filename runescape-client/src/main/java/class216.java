import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
public class class216 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   class216 field2619;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   class216 field2620;

   @ObfuscatedName("b")
   public void method4092() {
      if(this.field2620 != null) {
         this.field2620.field2619 = this.field2619;
         this.field2619.field2620 = this.field2620;
         this.field2619 = null;
         this.field2620 = null;
      }
   }
}

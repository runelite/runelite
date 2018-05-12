import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
public class class209 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   class209 field2458;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   class209 field2459;

   @ObfuscatedName("w")
   public void method4156() {
      if(this.field2459 != null) {
         this.field2459.field2458 = this.field2458;
         this.field2458.field2459 = this.field2459;
         this.field2458 = null;
         this.field2459 = null;
      }
   }
}

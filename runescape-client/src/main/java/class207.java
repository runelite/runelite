import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
public class class207 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   class207 field2593;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   class207 field2592;

   @ObfuscatedName("s")
   public void method4076() {
      if(this.field2592 != null) {
         this.field2592.field2593 = this.field2593;
         this.field2593.field2592 = this.field2592;
         this.field2593 = null;
         this.field2592 = null;
      }
   }
}

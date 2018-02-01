import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
public class class207 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   class207 field2570;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   class207 field2569;

   @ObfuscatedName("p")
   public void method3909() {
      if(this.field2569 != null) {
         this.field2569.field2570 = this.field2570;
         this.field2570.field2569 = this.field2569;
         this.field2570 = null;
         this.field2569 = null;
      }
   }
}

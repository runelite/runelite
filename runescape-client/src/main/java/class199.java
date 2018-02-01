import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
public class class199 implements Iterator {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   CombatInfoList field2547;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   Node field2546;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   Node field2545;

   @ObfuscatedSignature(
      signature = "(Lgk;)V"
   )
   class199(CombatInfoList var1) {
      this.field2545 = null;
      this.field2547 = var1;
      this.field2546 = this.field2547.node.next;
      this.field2545 = null;
   }

   public Object next() {
      Node var1 = this.field2546;
      if(var1 == this.field2547.node) {
         var1 = null;
         this.field2546 = null;
      } else {
         this.field2546 = var1.next;
      }

      this.field2545 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field2547.node != this.field2546;
   }

   public void remove() {
      if(this.field2545 == null) {
         throw new IllegalStateException();
      } else {
         this.field2545.unlink();
         this.field2545 = null;
      }
   }
}

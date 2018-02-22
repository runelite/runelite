import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
public class class208 implements Iterator {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   CombatInfoList field2595;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   Node field2596;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   Node field2597;

   @ObfuscatedSignature(
      signature = "(Lhl;)V"
   )
   class208(CombatInfoList var1) {
      this.field2597 = null;
      this.field2595 = var1;
      this.field2596 = this.field2595.node.next;
      this.field2597 = null;
   }

   public boolean hasNext() {
      return this.field2595.node != this.field2596;
   }

   public void remove() {
      if(this.field2597 == null) {
         throw new IllegalStateException();
      } else {
         this.field2597.unlink();
         this.field2597 = null;
      }
   }

   public Object next() {
      Node var1 = this.field2596;
      if(var1 == this.field2595.node) {
         var1 = null;
         this.field2596 = null;
      } else {
         this.field2596 = var1.next;
      }

      this.field2597 = var1;
      return var1;
   }
}

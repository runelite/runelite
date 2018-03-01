import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
public class class211 implements Iterator {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   CombatInfoList field2635;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   Node field2634;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   Node field2633;

   @ObfuscatedSignature(
      signature = "(Lhs;)V"
   )
   class211(CombatInfoList var1) {
      this.field2633 = null;
      this.field2635 = var1;
      this.field2634 = this.field2635.node.next;
      this.field2633 = null;
   }

   public boolean hasNext() {
      return this.field2635.node != this.field2634;
   }

   public void remove() {
      this.field2633.unlink();
      this.field2633 = null;
   }

   public Object next() {
      Node var1 = this.field2634;
      if(var1 == this.field2635.node) {
         var1 = null;
         this.field2634 = null;
      } else {
         this.field2634 = var1.next;
      }

      this.field2633 = var1;
      return var1;
   }
}

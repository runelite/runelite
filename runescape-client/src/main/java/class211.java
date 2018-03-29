import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
public class class211 implements Iterator {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   CombatInfoList field2625;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   Node field2624;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   Node field2623;

   @ObfuscatedSignature(
      signature = "(Lhe;)V"
   )
   class211(CombatInfoList var1) {
      this.field2623 = null;
      this.field2625 = var1;
      this.field2624 = this.field2625.node.next;
      this.field2623 = null;
   }

   public Object next() {
      Node var1 = this.field2624;
      if(var1 == this.field2625.node) {
         var1 = null;
         this.field2624 = null;
      } else {
         this.field2624 = var1.next;
      }

      this.field2623 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field2625.node != this.field2624;
   }

   public void remove() {
      if(this.field2623 == null) {
         throw new IllegalStateException();
      } else {
         this.field2623.unlink();
         this.field2623 = null;
      }
   }
}

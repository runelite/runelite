import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
public class class211 implements Iterator {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   CombatInfoList field2638;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lht;"
   )
   Node field2639;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lht;"
   )
   Node field2640;

   @ObfuscatedSignature(
      signature = "(Lhb;)V"
   )
   class211(CombatInfoList var1) {
      this.field2640 = null;
      this.field2638 = var1;
      this.field2639 = this.field2638.node.next;
      this.field2640 = null;
   }

   public boolean hasNext() {
      return this.field2638.node != this.field2639;
   }

   public void remove() {
      if(this.field2640 == null) {
         throw new IllegalStateException();
      } else {
         this.field2640.unlink();
         this.field2640 = null;
      }
   }

   public Object next() {
      Node var1 = this.field2639;
      if(var1 == this.field2638.node) {
         var1 = null;
         this.field2639 = null;
      } else {
         this.field2639 = var1.next;
      }

      this.field2640 = var1;
      return var1;
   }
}

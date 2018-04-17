import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
public class class211 implements Iterator {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   CombatInfoList field2632;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   Node field2633;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   Node field2634;

   @ObfuscatedSignature(
      signature = "(Lhm;)V"
   )
   class211(CombatInfoList var1) {
      this.field2634 = null;
      this.field2632 = var1;
      this.field2633 = this.field2632.node.next;
      this.field2634 = null;
   }

   public Object next() {
      Node var1 = this.field2633;
      if(var1 == this.field2632.node) {
         var1 = null;
         this.field2633 = null;
      } else {
         this.field2633 = var1.next;
      }

      this.field2634 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field2632.node != this.field2633;
   }

   public void remove() {
      if(this.field2634 == null) {
         throw new IllegalStateException();
      } else {
         this.field2634.unlink();
         this.field2634 = null;
      }
   }
}

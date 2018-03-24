import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
public class class211 implements Iterator {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhr;"
   )
   CombatInfoList field2616;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   Node field2617;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   Node field2618;

   @ObfuscatedSignature(
      signature = "(Lhr;)V"
   )
   class211(CombatInfoList var1) {
      this.field2618 = null;
      this.field2616 = var1;
      this.field2617 = this.field2616.node.next;
      this.field2618 = null;
   }

   public Object next() {
      Node var1 = this.field2617;
      if(var1 == this.field2616.node) {
         var1 = null;
         this.field2617 = null;
      } else {
         this.field2617 = var1.next;
      }

      this.field2618 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field2616.node != this.field2617;
   }

   public void remove() {
      this.field2618.unlink();
      this.field2618 = null;
   }
}

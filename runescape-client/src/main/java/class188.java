import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("go")
public class class188 implements Iterator {
   @ObfuscatedName("a")
   CombatInfoList field2449;
   @ObfuscatedName("j")
   Node field2450;
   @ObfuscatedName("n")
   Node field2451;

   class188(CombatInfoList var1) {
      this.field2451 = null;
      this.field2449 = var1;
      this.field2450 = this.field2449.node.next;
      this.field2451 = null;
   }

   public Object next() {
      Node var1 = this.field2450;
      if(var1 == this.field2449.node) {
         var1 = null;
         this.field2450 = null;
      } else {
         this.field2450 = var1.next;
      }

      this.field2451 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field2449.node != this.field2450;
   }

   public void remove() {
      this.field2451.unlink();
      this.field2451 = null;
   }
}

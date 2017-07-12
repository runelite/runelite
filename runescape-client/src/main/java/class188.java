import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("go")
public class class188 implements Iterator {
   @ObfuscatedName("i")
   CombatInfoList field2457;
   @ObfuscatedName("w")
   Node field2458;
   @ObfuscatedName("a")
   Node field2459;

   class188(CombatInfoList var1) {
      this.field2459 = null;
      this.field2457 = var1;
      this.field2458 = this.field2457.node.next;
      this.field2459 = null;
   }

   public Object next() {
      Node var1 = this.field2458;
      if(var1 == this.field2457.node) {
         var1 = null;
         this.field2458 = null;
      } else {
         this.field2458 = var1.next;
      }

      this.field2459 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field2457.node != this.field2458;
   }

   public void remove() {
      this.field2459.unlink();
      this.field2459 = null;
   }
}

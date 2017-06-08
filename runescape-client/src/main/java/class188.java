import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gk")
public class class188 implements Iterator {
   @ObfuscatedName("n")
   CombatInfoList field2466;
   @ObfuscatedName("p")
   Node field2467;
   @ObfuscatedName("i")
   Node field2468;

   public void remove() {
      if(this.field2468 == null) {
         throw new IllegalStateException();
      } else {
         this.field2468.unlink();
         this.field2468 = null;
      }
   }

   public boolean hasNext() {
      return this.field2467 != this.field2466.node;
   }

   class188(CombatInfoList var1) {
      this.field2468 = null;
      this.field2466 = var1;
      this.field2467 = this.field2466.node.next;
      this.field2468 = null;
   }

   public Object next() {
      Node var1 = this.field2467;
      if(var1 == this.field2466.node) {
         var1 = null;
         this.field2467 = null;
      } else {
         this.field2467 = var1.next;
      }

      this.field2468 = var1;
      return var1;
   }
}

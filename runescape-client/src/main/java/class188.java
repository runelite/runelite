import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gs")
public class class188 implements Iterator {
   @ObfuscatedName("e")
   Node field2466;
   @ObfuscatedName("p")
   CombatInfoList field2467;
   @ObfuscatedName("m")
   Node field2468;

   public boolean hasNext() {
      return this.field2468 != this.field2467.node;
   }

   public Object next() {
      Node var1 = this.field2468;
      if(this.field2467.node == var1) {
         var1 = null;
         this.field2468 = null;
      } else {
         this.field2468 = var1.next;
      }

      this.field2466 = var1;
      return var1;
   }

   class188(CombatInfoList var1) {
      this.field2466 = null;
      this.field2467 = var1;
      this.field2468 = this.field2467.node.next;
      this.field2466 = null;
   }

   public void remove() {
      if(this.field2466 == null) {
         throw new IllegalStateException();
      } else {
         this.field2466.unlink();
         this.field2466 = null;
      }
   }
}

import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gv")
public class class188 implements Iterator {
   @ObfuscatedName("c")
   Node field2464;
   @ObfuscatedName("i")
   CombatInfoList field2465;
   @ObfuscatedName("e")
   Node field2466;

   public Object next() {
      Node var1 = this.field2464;
      if(var1 == this.field2465.node) {
         var1 = null;
         this.field2464 = null;
      } else {
         this.field2464 = var1.next;
      }

      this.field2466 = var1;
      return var1;
   }

   public void remove() {
      if(this.field2466 == null) {
         throw new IllegalStateException();
      } else {
         this.field2466.unlink();
         this.field2466 = null;
      }
   }

   class188(CombatInfoList var1) {
      this.field2466 = null;
      this.field2465 = var1;
      this.field2464 = this.field2465.node.next;
      this.field2466 = null;
   }

   public boolean hasNext() {
      return this.field2464 != this.field2465.node;
   }
}

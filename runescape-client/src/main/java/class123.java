import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("df")
public class class123 implements Iterator {
   @ObfuscatedName("y")
   Node field1857;
   @ObfuscatedName("k")
   CombatInfoList field1858;
   @ObfuscatedName("o")
   Node field1859 = null;

   public boolean hasNext() {
      return this.field1857 != this.field1858.node;
   }

   public Object next() {
      Node var1 = this.field1857;
      if(var1 == this.field1858.node) {
         var1 = null;
         this.field1857 = null;
      } else {
         this.field1857 = var1.next;
      }

      this.field1859 = var1;
      return var1;
   }

   public void remove() {
      this.field1859.unlink();
      this.field1859 = null;
   }

   class123(CombatInfoList var1) {
      this.field1858 = var1;
      this.field1857 = this.field1858.node.next;
      this.field1859 = null;
   }
}

import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dr")
public class class123 implements Iterator {
   @ObfuscatedName("j")
   Node field1867;
   @ObfuscatedName("x")
   CombatInfoList field1868;
   @ObfuscatedName("c")
   Node field1869 = null;

   public void remove() {
      this.field1869.unlink();
      this.field1869 = null;
   }

   public Object next() {
      Node var1 = this.field1867;
      if(var1 == this.field1868.node) {
         var1 = null;
         this.field1867 = null;
      } else {
         this.field1867 = var1.next;
      }

      this.field1869 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field1867 != this.field1868.node;
   }

   class123(CombatInfoList var1) {
      this.field1868 = var1;
      this.field1867 = this.field1868.node.next;
      this.field1869 = null;
   }
}

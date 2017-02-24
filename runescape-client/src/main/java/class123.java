import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("di")
public class class123 implements Iterator {
   @ObfuscatedName("h")
   Node field1865 = null;
   @ObfuscatedName("d")
   Node field1866;
   @ObfuscatedName("q")
   CombatInfoList field1867;

   public boolean hasNext() {
      return this.field1866 != this.field1867.node;
   }

   public Object next() {
      Node var1 = this.field1866;
      if(var1 == this.field1867.node) {
         var1 = null;
         this.field1866 = null;
      } else {
         this.field1866 = var1.next;
      }

      this.field1865 = var1;
      return var1;
   }

   class123(CombatInfoList var1) {
      this.field1867 = var1;
      this.field1866 = this.field1867.node.next;
      this.field1865 = null;
   }

   public void remove() {
      if(this.field1865 == null) {
         throw new IllegalStateException();
      } else {
         this.field1865.unlink();
         this.field1865 = null;
      }
   }
}

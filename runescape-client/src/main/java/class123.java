import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("du")
public class class123 implements Iterator {
   @ObfuscatedName("n")
   Node field1868;
   @ObfuscatedName("g")
   Node field1869 = null;
   @ObfuscatedName("x")
   CombatInfoList field1870;

   public boolean hasNext() {
      return this.field1868 != this.field1870.node;
   }

   class123(CombatInfoList var1) {
      this.field1870 = var1;
      this.field1868 = this.field1870.node.next;
      this.field1869 = null;
   }

   public void remove() {
      if(this.field1869 == null) {
         throw new IllegalStateException();
      } else {
         this.field1869.unlink();
         this.field1869 = null;
      }
   }

   public Object next() {
      Node var1 = this.field1868;
      if(var1 == this.field1870.node) {
         var1 = null;
         this.field1868 = null;
      } else {
         this.field1868 = var1.next;
      }

      this.field1869 = var1;
      return var1;
   }
}

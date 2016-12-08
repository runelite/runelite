import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dt")
public class class123 implements Iterator {
   @ObfuscatedName("b")
   Node field1878 = null;
   @ObfuscatedName("o")
   CombatInfoList field1879;
   @ObfuscatedName("m")
   Node field1880;

   public Object next() {
      Node var1 = this.field1880;
      if(var1 == this.field1879.node) {
         var1 = null;
         this.field1880 = null;
      } else {
         this.field1880 = var1.next;
      }

      this.field1878 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field1880 != this.field1879.node;
   }

   public void remove() {
      if(this.field1878 == null) {
         throw new IllegalStateException();
      } else {
         this.field1878.unlink();
         this.field1878 = null;
      }
   }

   class123(CombatInfoList var1) {
      this.field1879 = var1;
      this.field1880 = this.field1879.node.next;
      this.field1878 = null;
   }
}

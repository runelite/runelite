import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("da")
public class class123 implements Iterator {
   @ObfuscatedName("u")
   CombatInfoList field1851;
   @ObfuscatedName("x")
   Node field1852;
   @ObfuscatedName("i")
   Node field1853 = null;

   public void remove() {
      if(this.field1853 == null) {
         throw new IllegalStateException();
      } else {
         this.field1853.unlink();
         this.field1853 = null;
      }
   }

   public boolean hasNext() {
      return this.field1852 != this.field1851.node;
   }

   public Object next() {
      Node var1 = this.field1852;
      if(var1 == this.field1851.node) {
         var1 = null;
         this.field1852 = null;
      } else {
         this.field1852 = var1.next;
      }

      this.field1853 = var1;
      return var1;
   }

   class123(CombatInfoList var1) {
      this.field1851 = var1;
      this.field1852 = this.field1851.node.next;
      this.field1853 = null;
   }
}

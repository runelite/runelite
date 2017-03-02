import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dt")
public class class123 implements Iterator {
   @ObfuscatedName("l")
   Node field1861;
   @ObfuscatedName("b")
   CombatInfoList field1862;
   @ObfuscatedName("i")
   Node field1863 = null;

   public Object next() {
      Node var1 = this.field1861;
      if(var1 == this.field1862.node) {
         var1 = null;
         this.field1861 = null;
      } else {
         this.field1861 = var1.next;
      }

      this.field1863 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field1861 != this.field1862.node;
   }

   public void remove() {
      if(this.field1863 == null) {
         throw new IllegalStateException();
      } else {
         this.field1863.unlink();
         this.field1863 = null;
      }
   }

   class123(CombatInfoList var1) {
      this.field1862 = var1;
      this.field1861 = this.field1862.node.next;
      this.field1863 = null;
   }
}

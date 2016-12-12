import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("du")
public class class123 implements Iterator {
   @ObfuscatedName("i")
   CombatInfoList field1861;
   @ObfuscatedName("e")
   Node field1862;
   @ObfuscatedName("f")
   Node field1863 = null;

   public Object next() {
      Node var1 = this.field1862;
      if(var1 == this.field1861.node) {
         var1 = null;
         this.field1862 = null;
      } else {
         this.field1862 = var1.next;
      }

      this.field1863 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field1862 != this.field1861.node;
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
      this.field1861 = var1;
      this.field1862 = this.field1861.node.next;
      this.field1863 = null;
   }
}

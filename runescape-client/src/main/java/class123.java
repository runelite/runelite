import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dv")
public class class123 implements Iterator {
   @ObfuscatedName("n")
   class126 field1862;
   @ObfuscatedName("d")
   Node field1863;
   @ObfuscatedName("m")
   Node field1864 = null;

   class123(class126 var1) {
      this.field1862 = var1;
      this.field1863 = this.field1862.field1875.next;
      this.field1864 = null;
   }

   public boolean hasNext() {
      return this.field1863 != this.field1862.field1875;
   }

   public void remove() {
      if(this.field1864 == null) {
         throw new IllegalStateException();
      } else {
         this.field1864.unlink();
         this.field1864 = null;
      }
   }

   public Object next() {
      Node var1 = this.field1863;
      if(var1 == this.field1862.field1875) {
         var1 = null;
         this.field1863 = null;
      } else {
         this.field1863 = var1.next;
      }

      this.field1864 = var1;
      return var1;
   }
}

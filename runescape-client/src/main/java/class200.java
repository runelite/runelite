import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gn")
public class class200 implements Iterable {
   @ObfuscatedName("s")
   public class204 field3110 = new class204();

   @ObfuscatedName("j")
   public void method3841(class204 var1) {
      if(var1.field3115 != null) {
         var1.method3876();
      }

      var1.field3115 = this.field3110.field3115;
      var1.field3114 = this.field3110;
      var1.field3115.field3114 = var1;
      var1.field3114.field3115 = var1;
   }

   public Iterator iterator() {
      return new class206(this);
   }

   @ObfuscatedName("s")
   public void method3846() {
      while(this.field3110.field3114 != this.field3110) {
         this.field3110.field3114.method3876();
      }

   }

   public class200() {
      this.field3110.field3114 = this.field3110;
      this.field3110.field3115 = this.field3110;
   }
}

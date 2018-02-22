import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ju")
public abstract class class283 implements Comparator {
   @ObfuscatedName("q")
   Comparator field3704;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;B)V",
      garbageValue = "123"
   )
   final void method5215(Comparator var1) {
      if(this.field3704 == null) {
         this.field3704 = var1;
      } else if(this.field3704 instanceof class283) {
         ((class283)this.field3704).method5215(var1);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljw;Ljw;B)I",
      garbageValue = "-30"
   )
   protected final int method5214(Nameable var1, Nameable var2) {
      return this.field3704 == null?0:this.field3704.compare(var1, var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}

import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ks")
public abstract class class297 implements Comparator {
   @ObfuscatedName("i")
   Comparator field3826;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;I)V",
      garbageValue = "2095282396"
   )
   final void method5287(Comparator var1) {
      if(this.field3826 == null) {
         this.field3826 = var1;
      } else if(this.field3826 instanceof class297) {
         ((class297)this.field3826).method5287(var1);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lku;Lku;I)I",
      garbageValue = "1526437592"
   )
   protected final int method5288(Nameable var1, Nameable var2) {
      return this.field3826 == null?0:this.field3826.compare(var1, var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1831387298"
   )
   static final void method5286() {
      Region.regionLowMemory = false;
      Client.lowMemory = false;
   }
}

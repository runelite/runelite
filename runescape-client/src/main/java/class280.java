import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jr")
public class class280 implements Comparable {
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      longValue = 2463806117149332691L
   )
   static long field3701;
   @ObfuscatedName("p")
   String field3699;
   @ObfuscatedName("i")
   String field3700;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lld;)V"
   )
   public class280(String var1, JagexLoginType var2) {
      this.field3699 = var1;
      this.field3700 = class159.cleanUsername(var1, var2);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "376482635"
   )
   public String method5137() {
      return this.field3699;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1149013516"
   )
   public boolean method5132() {
      return this.field3700 != null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljr;I)I",
      garbageValue = "-1491105622"
   )
   int method5135(class280 var1) {
      return this.field3700 == null?(var1.field3700 == null?0:1):(var1.field3700 == null?-1:this.field3700.compareTo(var1.field3700));
   }

   public boolean equals(Object var1) {
      if(var1 instanceof class280) {
         class280 var2 = (class280)var1;
         return this.field3700 == null?var2.field3700 == null:(var2.field3700 == null?false:(this.hashCode() != var2.hashCode()?false:this.field3700.equals(var2.field3700)));
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.field3700 == null?0:this.field3700.hashCode();
   }

   public String toString() {
      return this.method5137();
   }

   public int compareTo(Object var1) {
      return this.method5135((class280)var1);
   }
}

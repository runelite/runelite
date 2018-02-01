import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jr")
@Implements("Name")
public class Name implements Comparable {
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      longValue = 2463806117149332691L
   )
   static long field3701;
   @ObfuscatedName("p")
   @Export("name")
   String name;
   @ObfuscatedName("i")
   @Export("cleanName")
   String cleanName;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lld;)V"
   )
   public Name(String var1, JagexLoginType var2) {
      this.name = var1;
      this.cleanName = class159.cleanUsername(var1, var2);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "376482635"
   )
   @Export("getName")
   public String getName() {
      return this.name;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1149013516"
   )
   public boolean method5132() {
      return this.cleanName != null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljr;I)I",
      garbageValue = "-1491105622"
   )
   int method5135(Name var1) {
      return this.cleanName == null?(var1.cleanName == null?0:1):(var1.cleanName == null?-1:this.cleanName.compareTo(var1.cleanName));
   }

   public boolean equals(Object var1) {
      if(var1 instanceof Name) {
         Name var2 = (Name)var1;
         return this.cleanName == null?var2.cleanName == null:(var2.cleanName == null?false:(this.hashCode() != var2.hashCode()?false:this.cleanName.equals(var2.cleanName)));
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.cleanName == null?0:this.cleanName.hashCode();
   }

   public String toString() {
      return this.getName();
   }

   public int compareTo(Object var1) {
      return this.method5135((Name)var1);
   }
}

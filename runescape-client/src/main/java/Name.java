import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("km")
@Implements("Name")
public class Name implements Comparable {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -764982541
   )
   static int field3662;
   @ObfuscatedName("w")
   @Export("name")
   String name;
   @ObfuscatedName("m")
   @Export("cleanName")
   String cleanName;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lla;)V"
   )
   public Name(String var1, JagexLoginType var2) {
      this.name = var1;
      this.cleanName = SceneTilePaint.method2898(var1, var2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-69"
   )
   @Export("getName")
   public String getName() {
      return this.name;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1957595085"
   )
   @Export("isCleanNameValid")
   public boolean isCleanNameValid() {
      return this.cleanName != null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lkm;I)I",
      garbageValue = "-1019319110"
   )
   @Export("compareCleanName")
   public int compareCleanName(Name var1) {
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

   public int compareTo(Object var1) {
      return this.compareCleanName((Name)var1);
   }

   public String toString() {
      return this.getName();
   }
}

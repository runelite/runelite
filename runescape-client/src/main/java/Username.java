import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kp")
@Implements("Username")
public class Username implements Comparable {
   @ObfuscatedName("q")
   @Export("Interpreter_intLocals")
   static int[] Interpreter_intLocals;
   @ObfuscatedName("m")
   @Export("name")
   String name;
   @ObfuscatedName("f")
   @Export("cleanName")
   String cleanName;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Llx;)V"
   )
   public Username(String var1, LoginType var2) {
      this.name = var1;
      this.cleanName = Message.method1229(var1, var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1065850055"
   )
   @Export("getName")
   public String getName() {
      return this.name;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1468109942"
   )
   @Export("hasCleanName")
   public boolean hasCleanName() {
      return this.cleanName != null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lkp;B)I",
      garbageValue = "8"
   )
   @Export("compareToTyped")
   public int compareToTyped(Username other) {
      return this.cleanName == null ? (other.cleanName == null ? 0 : 1) : (other.cleanName == null ? -1 : this.cleanName.compareTo(other.cleanName));
   }

   public boolean equals(Object var1) {
      if (var1 instanceof Username) {
         Username var2 = (Username)var1;
         if (this.cleanName == null) {
            return var2.cleanName == null;
         } else {
            return var2.cleanName != null && this.hashCode() == var2.hashCode() && this.cleanName.equals(var2.cleanName);
         }
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.cleanName == null ? 0 : this.cleanName.hashCode();
   }

   public String toString() {
      return this.getName();
   }

   public int compareTo(Object var1) {
      return this.compareToTyped((Username)var1);
   }
}

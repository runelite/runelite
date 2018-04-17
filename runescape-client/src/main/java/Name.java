import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("kz")
@Implements("Name")
public class Name implements Comparable {
   @ObfuscatedName("o")
   @Export("name")
   String name;
   @ObfuscatedName("k")
   @Export("cleanName")
   String cleanName;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Llh;)V"
   )
   public Name(String var1, JagexLoginType var2) {
      this.name = var1;
      this.cleanName = class57.method861(var1, var2);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-328261912"
   )
   @Export("getName")
   public String getName() {
      return this.name;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-54"
   )
   public boolean method5427() {
      return this.cleanName != null;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lkz;I)I",
      garbageValue = "1291402109"
   )
   public int method5430(Name var1) {
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
      return this.method5430((Name)var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "1155175199"
   )
   @Export("loadClassFromDescriptor")
   public static Class loadClassFromDescriptor(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }
}

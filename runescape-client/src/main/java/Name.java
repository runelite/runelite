import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kb")
@Implements("Name")
public class Name implements Comparable {
   @ObfuscatedName("t")
   @Export("name")
   String name;
   @ObfuscatedName("q")
   @Export("cleanName")
   String cleanName;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Llu;)V"
   )
   public Name(String var1, JagexLoginType var2) {
      this.name = var1;
      this.cleanName = class33.method374(var1, var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "135186264"
   )
   @Export("getName")
   public String getName() {
      return this.name;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "5"
   )
   public boolean method5418() {
      return this.cleanName != null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lkb;I)I",
      garbageValue = "-567779570"
   )
   public int method5420(Name var1) {
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
      return this.method5420((Name)var1);
   }

   public String toString() {
      return this.getName();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(CII)Ljava/lang/String;",
      garbageValue = "-1943223368"
   )
   static String method5436(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }
}

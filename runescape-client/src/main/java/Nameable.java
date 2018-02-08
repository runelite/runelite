import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jq")
@Implements("Nameable")
public class Nameable implements Comparable {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   @Export("name")
   Name name;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   Name field3700;

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(S)Lja;",
      garbageValue = "3922"
   )
   public Name method5136() {
      return this.name;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1182479335"
   )
   public String method5137() {
      return this.name == null?"":this.name.getName();
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1075689815"
   )
   public String method5145() {
      return this.field3700 == null?"":this.field3700.getName();
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Lja;Lja;I)V",
      garbageValue = "-1742337772"
   )
   void method5139(Name var1, Name var2) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.name = var1;
         this.field3700 = var2;
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Ljq;I)I",
      garbageValue = "-1632311756"
   )
   int vmethod5337(Nameable var1) {
      return this.name.method5278(var1.name);
   }

   public int compareTo(Object var1) {
      return this.vmethod5337((Nameable)var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Z",
      garbageValue = "-462734788"
   )
   public static boolean method5146(String var0, int var1) {
      return MouseRecorder.method1078(var0, var1, "openjs");
   }
}

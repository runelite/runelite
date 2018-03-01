import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("km")
@Implements("Nameable")
public class Nameable implements Comparable {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   @Export("name")
   Name name;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   Name field3824;

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(B)Lko;",
      garbageValue = "-41"
   )
   public Name method5385() {
      return this.name;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "2019406618"
   )
   public String method5368() {
      return this.name == null?"":this.name.getName();
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1039871165"
   )
   public String method5369() {
      return this.field3824 == null?"":this.field3824.getName();
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Lko;Lko;I)V",
      garbageValue = "-408879770"
   )
   void method5367(Name var1, Name var2) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.name = var1;
         this.field3824 = var2;
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lkm;I)I",
      garbageValue = "-1994435588"
   )
   public int vmethod5558(Nameable var1) {
      return this.name.method5536(var1.name);
   }

   public int compareTo(Object var1) {
      return this.vmethod5558((Nameable)var1);
   }
}

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jn")
@Implements("Nameable")
public class Nameable implements Comparable {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lkm;"
   )
   @Export("name")
   Name name;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lkm;"
   )
   @Export("prevName")
   Name prevName;

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)Lkm;",
      garbageValue = "55"
   )
   @Export("getRsName")
   public Name getRsName() {
      return this.name;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-2092094287"
   )
   @Export("getName")
   public String getName() {
      return this.name == null?"":this.name.getName();
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "47"
   )
   @Export("getPrevName")
   public String getPrevName() {
      return this.prevName == null?"":this.prevName.getName();
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Lkm;Lkm;I)V",
      garbageValue = "1050931041"
   )
   @Export("setName")
   void setName(Name var1, Name var2) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.name = var1;
         this.prevName = var2;
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Ljn;I)I",
      garbageValue = "1707398523"
   )
   public int vmethod5482(Nameable var1) {
      return this.name.compareCleanName(var1.name);
   }

   public int compareTo(Object var1) {
      return this.vmethod5482((Nameable)var1);
   }
}

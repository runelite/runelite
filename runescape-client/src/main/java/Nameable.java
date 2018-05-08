import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kg")
@Implements("Nameable")
public class Nameable implements Comparable {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   @Export("name")
   Name name;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   @Export("prevName")
   Name prevName;

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)Lkb;",
      garbageValue = "2027427360"
   )
   @Export("getRsName")
   public Name getRsName() {
      return this.name;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-397639951"
   )
   @Export("getName")
   public String getName() {
      return this.name == null?"":this.name.getName();
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "43"
   )
   @Export("getPrevName")
   public String getPrevName() {
      return this.prevName == null?"":this.prevName.getName();
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Lkb;Lkb;I)V",
      garbageValue = "-2014040133"
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

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Lkg;I)I",
      garbageValue = "1389713193"
   )
   public int vmethod5501(Nameable var1) {
      return this.name.compareCleanName(var1.name);
   }

   public int compareTo(Object var1) {
      return this.vmethod5501((Nameable)var1);
   }
}

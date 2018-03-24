import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kv")
@Implements("Nameable")
public class Nameable implements Comparable {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   public static IndexDataBase field3824;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   @Export("name")
   Name name;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   Name field3825;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Lkb;",
      garbageValue = "1593357386"
   )
   public Name method5246() {
      return this.name;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "233820255"
   )
   public String method5264() {
      return this.name == null?"":this.name.getName();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "2083165839"
   )
   public String method5247() {
      return this.field3825 == null?"":this.field3825.getName();
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Lkb;Lkb;B)V",
      garbageValue = "1"
   )
   void method5263(Name var1, Name var2) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.name = var1;
         this.field3825 = var2;
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Lkv;I)I",
      garbageValue = "-1435662815"
   )
   public int vmethod5444(Nameable var1) {
      return this.name.method5420(var1.name);
   }

   public int compareTo(Object var1) {
      return this.vmethod5444((Nameable)var1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2135777349"
   )
   public static void method5271() {
      class281.field3573.reset();
      class281.field3584.reset();
      class281.field3590.reset();
   }
}

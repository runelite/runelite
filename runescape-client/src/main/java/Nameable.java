import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ku")
@Implements("Nameable")
public class Nameable implements Comparable {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   @Export("name")
   Name name;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   Name field3822;

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)Lko;",
      garbageValue = "1291806181"
   )
   public Name method5260() {
      return this.name;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-2050568132"
   )
   public String method5278() {
      return this.name == null?"":this.name.getName();
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-1"
   )
   public String method5262() {
      return this.field3822 == null?"":this.field3822.getName();
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Lko;Lko;B)V",
      garbageValue = "1"
   )
   void method5263(Name var1, Name var2) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.name = var1;
         this.field3822 = var2;
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Lku;B)I",
      garbageValue = "0"
   )
   public int vmethod5454(Nameable var1) {
      return this.name.method5441(var1.name);
   }

   public int compareTo(Object var1) {
      return this.vmethod5454((Nameable)var1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "-849451379"
   )
   public static char method5284(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      return var0 == 338?'O':(var0 == 339?'o':(var0 == 376?'Y':var0));
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Z",
      garbageValue = "0"
   )
   public static boolean method5280(CharSequence var0) {
      return RunException.method3229(var0, 10, true);
   }
}

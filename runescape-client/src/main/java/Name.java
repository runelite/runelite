import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kb")
@Implements("Name")
public class Name implements Comparable {
   @ObfuscatedName("g")
   @Export("name")
   String name;
   @ObfuscatedName("e")
   @Export("cleanName")
   String cleanName;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lly;)V"
   )
   public Name(String var1, JagexLoginType var2) {
      this.name = var1;
      String var4;
      if(var1 == null) {
         var4 = null;
      } else {
         int var5 = 0;

         int var6;
         boolean var7;
         char var8;
         for(var6 = var1.length(); var5 < var6; ++var5) {
            var8 = var1.charAt(var5);
            var7 = var8 == 160 || var8 == ' ' || var8 == '_' || var8 == '-';
            if(!var7) {
               break;
            }
         }

         while(var6 > var5) {
            var8 = var1.charAt(var6 - 1);
            var7 = var8 == 160 || var8 == ' ' || var8 == '_' || var8 == '-';
            if(!var7) {
               break;
            }

            --var6;
         }

         int var14 = var6 - var5;
         if(var14 >= 1 && var14 <= class160.method3262(var2)) {
            StringBuilder var13 = new StringBuilder(var14);

            for(int var9 = var5; var9 < var6; ++var9) {
               char var10 = var1.charAt(var9);
               if(class85.method1958(var10)) {
                  char var11;
                  switch(var10) {
                  case ' ':
                  case '-':
                  case '_':
                  case ' ':
                     var11 = '_';
                     break;
                  case '#':
                  case '[':
                  case ']':
                     var11 = var10;
                     break;
                  case 'À':
                  case 'Á':
                  case 'Â':
                  case 'Ã':
                  case 'Ä':
                  case 'à':
                  case 'á':
                  case 'â':
                  case 'ã':
                  case 'ä':
                     var11 = 'a';
                     break;
                  case 'Ç':
                  case 'ç':
                     var11 = 'c';
                     break;
                  case 'È':
                  case 'É':
                  case 'Ê':
                  case 'Ë':
                  case 'è':
                  case 'é':
                  case 'ê':
                  case 'ë':
                     var11 = 'e';
                     break;
                  case 'Í':
                  case 'Î':
                  case 'Ï':
                  case 'í':
                  case 'î':
                  case 'ï':
                     var11 = 'i';
                     break;
                  case 'Ñ':
                  case 'ñ':
                     var11 = 'n';
                     break;
                  case 'Ò':
                  case 'Ó':
                  case 'Ô':
                  case 'Õ':
                  case 'Ö':
                  case 'ò':
                  case 'ó':
                  case 'ô':
                  case 'õ':
                  case 'ö':
                     var11 = 'o';
                     break;
                  case 'Ù':
                  case 'Ú':
                  case 'Û':
                  case 'Ü':
                  case 'ù':
                  case 'ú':
                  case 'û':
                  case 'ü':
                     var11 = 'u';
                     break;
                  case 'ß':
                     var11 = 'b';
                     break;
                  case 'ÿ':
                  case 'Ÿ':
                     var11 = 'y';
                     break;
                  default:
                     var11 = Character.toLowerCase(var10);
                  }

                  if(var11 != 0) {
                     var13.append(var11);
                  }
               }
            }

            if(var13.length() == 0) {
               var4 = null;
            } else {
               var4 = var13.toString();
            }
         } else {
            var4 = null;
         }
      }

      this.cleanName = var4;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-257385908"
   )
   @Export("getName")
   public String getName() {
      return this.name;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-1"
   )
   @Export("isCleanNameValid")
   public boolean isCleanNameValid() {
      return this.cleanName != null;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lkb;I)I",
      garbageValue = "-1440326790"
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

   public String aac() {
      return this.getName();
   }

   public String aad() {
      return this.getName();
   }
}

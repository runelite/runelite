import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ja")
@Implements("Name")
public class Name implements Comparable {
   @ObfuscatedName("s")
   @Export("name")
   String name;
   @ObfuscatedName("g")
   @Export("cleanName")
   String cleanName;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lld;)V"
   )
   public Name(String var1, JagexLoginType var2) {
      this.name = var1;
      String var4;
      if(var1 == null) {
         var4 = null;
      } else {
         int var5 = 0;

         int var6;
         for(var6 = var1.length(); var5 < var6; ++var5) {
            char var8 = var1.charAt(var5);
            boolean var7 = var8 == 160 || var8 == ' ' || var8 == '_' || var8 == '-';
            if(!var7) {
               break;
            }
         }

         while(var6 > var5 && UrlRequest.method3163(var1.charAt(var6 - 1))) {
            --var6;
         }

         int var13 = var6 - var5;
         if(var13 >= 1 && var13 <= class216.method4246(var2)) {
            StringBuilder var12 = new StringBuilder(var13);

            for(int var9 = var5; var9 < var6; ++var9) {
               char var10 = var1.charAt(var9);
               if(BaseVarType.method11(var10)) {
                  char var11 = BoundingBox.method47(var10);
                  if(var11 != 0) {
                     var12.append(var11);
                  }
               }
            }

            if(var12.length() == 0) {
               var4 = null;
            } else {
               var4 = var12.toString();
            }
         } else {
            var4 = null;
         }
      }

      this.cleanName = var4;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-2000941969"
   )
   @Export("getName")
   public String getName() {
      return this.name;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1568757499"
   )
   public boolean method5276() {
      return this.cleanName != null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lja;S)I",
      garbageValue = "-6770"
   )
   int method5278(Name var1) {
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
      return this.method5278((Name)var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "62"
   )
   public static void method5282() {
      class219.field2698 = null;
      class263.offsetsY = null;
      class60.field708 = null;
      class310.field3911 = null;
      class289.field3786 = null;
      class310.spritePixels = null;
   }
}

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class26 extends Node {
   @ObfuscatedName("j")
   class49 field634;
   @ObfuscatedName("mt")
   static byte field636;
   @ObfuscatedName("bx")
   static ModIcon[] field637;
   @ObfuscatedName("z")
   class205 field641 = new class205();

   class26(class49 var1) {
      this.field634 = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "69580228"
   )
   void method581(int var1, int var2, int var3, int var4) {
      class20 var5 = null;
      int var6 = 0;

      for(class20 var7 = (class20)this.field641.method3897(); var7 != null; var7 = (class20)this.field641.method3882()) {
         ++var6;
         if(var7.field573 == var1) {
            var7.method542(var1, var2, var3, var4);
            return;
         }

         if(var7.field573 <= var1) {
            var5 = var7;
         }
      }

      if(null == var5) {
         if(var6 < 4) {
            this.field641.method3884(new class20(var1, var2, var3, var4));
         }

      } else {
         class205.method3885(new class20(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.field641.method3897().unlink();
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "31"
   )
   boolean method583() {
      return this.field641.method3889();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-72628954"
   )
   public static String method585(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            char var6;
            if(var5 != 181 && var5 != 402) {
               var6 = Character.toTitleCase(var5);
            } else {
               var6 = var5;
            }

            var5 = var6;
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Lclass20;",
      garbageValue = "1625546303"
   )
   class20 method587(int var1) {
      class20 var2 = (class20)this.field641.method3897();
      if(null != var2 && var2.field573 <= var1) {
         for(class20 var3 = (class20)this.field641.method3882(); var3 != null && var3.field573 <= var1; var3 = (class20)this.field641.method3882()) {
            var2.unlink();
            var2 = var3;
         }

         if(var2.field573 + var2.field568 + this.field634.field1080 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-28"
   )
   public static boolean method591(int var0) {
      return (var0 >> 20 & 1) != 0;
   }
}

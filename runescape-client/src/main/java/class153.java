import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
public class class153 extends RuntimeException {
   @ObfuscatedName("b")
   public static Applet field2120;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2011915583
   )
   @Export("revision")
   public static int revision;
   @ObfuscatedName("g")
   String field2119;
   @ObfuscatedName("x")
   Throwable field2122;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([Lgf;II)Lgf;",
      garbageValue = "1872003846"
   )
   @Export("forOrdinal")
   public static class185 forOrdinal(class185[] var0, int var1) {
      class185[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class185 var4 = var2[var3];
         if(var1 == var4.rsOrdinal()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lhf;III)Lcx;",
      garbageValue = "-1827426888"
   )
   static Script method2949(class226 var0, int var1, int var2) {
      int var3 = (var1 << 8) + var0.field2860;
      Script var5 = PendingSpawn.method1491(var3, var0);
      if(var5 != null) {
         return var5;
      } else {
         int var4 = Item.method1752(var2, var0);
         var5 = PendingSpawn.method1491(var4, var0);
         return var5 != null?var5:null;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
      garbageValue = "-22"
   )
   public static String method2950(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 'a' || var4 > 'z') && (var4 < 'A' || var4 > 'Z') && (var4 < '0' || var4 > '9') && var4 != '.' && var4 != '-' && var4 != '*' && var4 != '_') {
            if(var4 == ' ') {
               var2.append('+');
            } else {
               byte var5 = class89.method1681(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }
}

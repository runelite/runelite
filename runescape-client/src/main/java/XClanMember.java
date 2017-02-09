import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
@Implements("XClanMember")
public class XClanMember extends Node {
   @ObfuscatedName("y")
   String field268;
   @ObfuscatedName("k")
   @Export("username")
   String username;
   @ObfuscatedName("r")
   @Export("rank")
   byte rank;
   @ObfuscatedName("ca")
   public static char field273;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 749355327
   )
   @Export("world")
   int world;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "51"
   )
   public static void method261() {
      class115 var0 = class115.mouse;
      synchronized(class115.mouse) {
         class115.field1805 = class115.field1795;
         class115.field1799 = class115.field1796;
         class115.field1794 = class115.field1797;
         class115.field1804 = class115.field1801;
         class115.field1800 = class115.field1802;
         class115.field1807 = class115.field1803;
         class115.field1806 = class115.field1798;
         class115.field1801 = 0;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "1331959270"
   )
   public static String method262(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && var4 != 46 && var4 != 45 && var4 != 42 && var4 != 95) {
            if(var4 == 32) {
               var2.append('+');
            } else {
               byte var5 = class38.method765(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(55 + var6));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(48 + var6));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }
}

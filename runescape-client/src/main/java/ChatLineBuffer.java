import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1011803207
   )
   public static int field1464;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[Lbh;"
   )
   @Export("lines")
   MessageNode[] lines;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -445922717
   )
   @Export("length")
   int length;

   ChatLineBuffer() {
      this.lines = new MessageNode[100];
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)Lbh;",
      garbageValue = "-81"
   )
   @Export("addMessage")
   MessageNode addMessage(int var1, String var2, String var3, String var4) {
      MessageNode var5 = this.lines[99];

      for(int var6 = this.length; var6 > 0; --var6) {
         if(var6 != 100) {
            this.lines[var6] = this.lines[var6 - 1];
         }
      }

      if(var5 == null) {
         var5 = new MessageNode(var1, var2, var4, var3);
      } else {
         var5.unlink();
         var5.unlinkDual();
         var5.setMessage(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)Lbh;",
      garbageValue = "-76"
   )
   MessageNode method1921(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "899003134"
   )
   int method1916() {
      return this.length;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
      garbageValue = "0"
   )
   public static String method1918(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 'a' || var4 > 'z') && (var4 < 'A' || var4 > 'Z') && (var4 < '0' || var4 > '9') && var4 != '.' && var4 != '-' && var4 != '*' && var4 != '_') {
            if(var4 == ' ') {
               var2.append('+');
            } else {
               byte var5 = ItemContainer.method1102(var4);
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1811706787"
   )
   static final int method1923(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }
}

import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kr")
public abstract class class297 implements Comparator {
   @ObfuscatedName("i")
   static byte[][][] field3831;
   @ObfuscatedName("k")
   Comparator field3832;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;I)V",
      garbageValue = "261828528"
   )
   final void method5283(Comparator var1) {
      if(this.field3832 == null) {
         this.field3832 = var1;
      } else if(this.field3832 instanceof class297) {
         ((class297)this.field3832).method5283(var1);
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lku;Lku;B)I",
      garbageValue = "74"
   )
   protected final int method5282(Nameable var1, Nameable var2) {
      return this.field3832 == null?0:this.field3832.compare(var1, var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "1554152801"
   )
   public static String method5290(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 'a' || var4 > 'z') && (var4 < 'A' || var4 > 'Z') && (var4 < '0' || var4 > '9') && var4 != '.' && var4 != '-' && var4 != '*' && var4 != '_') {
            if(var4 == ' ') {
               var2.append('+');
            } else {
               byte var5 = Client.charToByteCp1252(var4);
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

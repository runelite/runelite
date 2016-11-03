import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class50 extends CacheableNode {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1275114535
   )
   public int field1101;
   @ObfuscatedName("q")
   public static NodeCache field1102 = new NodeCache(64);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1591707621
   )
   public int field1103;
   @ObfuscatedName("k")
   public static class170 field1104;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 813215381
   )
   public int field1105;
   @ObfuscatedName("l")
   static ModIcon field1109;
   @ObfuscatedName("kc")
   @Export("chatMessages")
   static ChatMessages chatMessages;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "1559665649"
   )
   public static String method1030(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 97 || var4 > 122) && (var4 < 65 || var4 > 90) && (var4 < 48 || var4 > 57) && var4 != 46 && var4 != 45 && var4 != 42 && var4 != 95) {
            if(var4 == 32) {
               var2.append('+');
            } else {
               byte var5 = BufferProvider.method1732(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(48 + var6));
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "46"
   )
   void method1033(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1103 = var1.method2691();
         this.field1101 = var1.method2571();
         this.field1105 = var1.method2571();
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-290583928"
   )
   void method1038(Buffer var1) {
      while(true) {
         int var2 = var1.method2571();
         if(var2 == 0) {
            return;
         }

         this.method1033(var1, var2);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)LMessageNode;",
      garbageValue = "958853190"
   )
   static MessageNode method1040(int var0) {
      return (MessageNode)class11.field167.method3835((long)var0);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)[Lclass156;",
      garbageValue = "-50"
   )
   static class156[] method1041() {
      return new class156[]{class156.field2316, class156.field2313, class156.field2321, class156.field2322};
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "124"
   )
   static final int method1042(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var0 & '\uff00') * var3 + var2 * (var1 & '\uff00') & 16711680) + ((var1 & 16711935) * var2 + (var0 & 16711935) * var3 & -16711936) >> 8;
   }
}

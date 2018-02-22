import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
public class class154 extends class283 {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   public static IndexDataBase field2096;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   @Export("widgetIndex")
   public static IndexDataBase widgetIndex;
   @ObfuscatedName("b")
   final boolean field2097;

   public class154(boolean var1) {
      this.field2097 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lku;Lku;I)I",
      garbageValue = "2102532668"
   )
   int method3146(ChatPlayer var1, ChatPlayer var2) {
      return var2.world != var1.world?(this.field2097?var1.world - var2.world:var2.world - var1.world):this.method5214(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3146((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "121"
   )
   static int method3148() {
      return 11;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "1953044606"
   )
   @Export("getString")
   public static String getString(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class300.cp1252AsciiExtension[var6 - 128];
               if(var7 == 0) {
                  var7 = '?';
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }
}

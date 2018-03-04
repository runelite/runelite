import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
public class class152 extends class297 {
   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("vorbisIndex")
   static IndexData vorbisIndex;
   @ObfuscatedName("d")
   final boolean field2123;

   public class152(boolean var1) {
      this.field2123 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lkz;Lkz;B)I",
      garbageValue = "4"
   )
   int method3210(ChatPlayer var1, ChatPlayer var2) {
      return Client.world == var1.world && var2.world == Client.world?(this.field2123?var1.field3840 - var2.field3840:var2.field3840 - var1.field3840):this.method5387(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3210((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "1188829556"
   )
   @Export("getString")
   public static String getString(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class314.cp1252AsciiExtension[var6 - 128];
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

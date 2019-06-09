import java.io.File;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public class class14 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;Ljava/io/File;I)V",
      garbageValue = "1360082712"
   )
   public static void method167(File var0, File var1) {
      try {
         AccessFile var2 = new AccessFile(class337.clDat, "rw", 10000L);
         Buffer var3 = new Buffer(500);
         var3.writeByte(3);
         var3.writeByte(var1 != null?1:0);
         var3.__j_296(var0.getPath());
         if(var1 != null) {
            var3.__j_296("");
         }

         var2.write(var3.array, 0, var3.index);
         var2.close();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(BI)C",
      garbageValue = "-1102775612"
   )
   public static char method171(byte var0) {
      int var1 = var0 & 255;
      if(var1 == 0) {
         throw new IllegalArgumentException("");
      } else {
         if(var1 >= 128 && var1 < 160) {
            char var2 = class304.cp1252AsciiExtension[var1 - 128];
            if(var2 == 0) {
               var2 = '?';
            }

            var1 = var2;
         }

         return (char)var1;
      }
   }

   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1103685678"
   )
   static boolean method169() {
      return (Client.__client_ke & 8) != 0;
   }
}

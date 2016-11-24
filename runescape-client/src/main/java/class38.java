import java.io.File;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class38 {
   @ObfuscatedName("w")
   String field790;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 546916889
   )
   int field791;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -75320835
   )
   int field792;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1386042115
   )
   int field793;
   @ObfuscatedName("r")
   static byte[][][] field797;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1769690823
   )
   int field798;
   @ObfuscatedName("b")
   static int[] field800;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1849952127"
   )
   public static void method769(int var0) {
      if(class138.field1917 != 0) {
         class101.field1649 = var0;
      } else {
         class138.field1919.method2550(var0);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;Ljava/io/File;B)V",
      garbageValue = "1"
   )
   static void method770(File var0, File var1) {
      try {
         FileOnDisk var2 = new FileOnDisk(class104.field1679, "rw", 10000L);
         Buffer var3 = new Buffer(500);
         var3.method2975(3);
         var3.method2975(null != var1?1:0);
         var3.method2983(var0.getPath());
         if(var1 != null) {
            var3.method2983("");
         }

         var2.method1441(var3.payload, 0, var3.offset);
         var2.method1442();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }
}

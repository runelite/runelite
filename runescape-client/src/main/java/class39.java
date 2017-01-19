import java.awt.Component;
import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class39 {
   @ObfuscatedName("s")
   static final BigInteger field796 = new BigInteger("10001", 16);
   @ObfuscatedName("c")
   static final BigInteger field797 = new BigInteger("c523591a74bf6d1e73388051d92637dea2b35de376d341c60f75a14d1998c89828f6a9fe98e12053b19c2b6335345e8b6f8861d66e5644f57ff400e8d327b0ca96eacebccfc839b3406ed66a074354a394a2ebc2db015ef1dcfa5c7a09c5a9aa19947d2d7c352335d278819935a95ba1ed44a274d8c0808c8f16d383af41430b", 16);
   @ObfuscatedName("k")
   static SpritePixels field798;
   @ObfuscatedName("ii")
   @ObfuscatedGetter(
      intValue = -1583136263
   )
   static int field800;
   @ObfuscatedName("q")
   static class20 field802;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass103;Ljava/awt/Component;IIB)Lclass57;",
      garbageValue = "69"
   )
   public static final class57 method722(class103 var0, Component var1, int var2, int var3) {
      if(class57.field1057 == 0) {
         throw new IllegalStateException();
      } else if(var2 >= 0 && var2 < 2) {
         if(var3 < 256) {
            var3 = 256;
         }

         try {
            class59 var4 = new class59();
            var4.field1051 = new int[256 * (class57.field1052?2:1)];
            var4.field1048 = var3;
            var4.vmethod1061(var1);
            var4.field1044 = 1024 + (var3 & -1024);
            if(var4.field1044 > 16384) {
               var4.field1044 = 16384;
            }

            var4.vmethod1062(var4.field1044);
            if(class231.field3281 > 0 && null == class57.field1038) {
               class57.field1038 = new class63();
               class57.field1038.field1090 = var0;
               var0.method1912(class57.field1038, class231.field3281);
            }

            if(null != class57.field1038) {
               if(class57.field1038.field1093[var2] != null) {
                  throw new IllegalArgumentException();
               }

               class57.field1038.field1093[var2] = var4;
            }

            return var4;
         } catch (Throwable var5) {
            return new class57();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
}

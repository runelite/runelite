import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public abstract class class168 {
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   @Export("currentRequest")
   public static FileRequest currentRequest;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-118954090"
   )
   public abstract boolean vmethod3341(int var1) throws IOException;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "26"
   )
   public abstract int vmethod3346() throws IOException;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1770569252"
   )
   public abstract int vmethod3318() throws IOException;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "1399740149"
   )
   public abstract int vmethod3321(byte[] var1, int var2, int var3) throws IOException;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-2027539026"
   )
   public abstract void vmethod3323(byte[] var1, int var2, int var3) throws IOException;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "32"
   )
   public abstract void vmethod3317();

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(CIB)I",
      garbageValue = "-30"
   )
   public static int method3281(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }
}

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class30 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1528305963
   )
   int field688;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -232155067
   )
   int field689;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 2124896505
   )
   int field690;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1353113041
   )
   int field691;
   @ObfuscatedName("x")
   String field692;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "0"
   )
   public static byte[] method663(Object var0, boolean var1) {
      if(null == var0) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var3 = (byte[])((byte[])var0);
         return var3;
      } else if(var0 instanceof class125) {
         class125 var2 = (class125)var0;
         return var2.vmethod2826();
      } else {
         throw new IllegalArgumentException();
      }
   }
}

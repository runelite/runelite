import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("d")
@Implements("Friend")
public class class17 {
   @ObfuscatedName("f")
   boolean field246;
   @ObfuscatedName("l")
   @Export("previousName")
   String field247;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1035471415
   )
   @Export("world")
   int field248;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 129022621
   )
   int field249;
   @ObfuscatedName("m")
   boolean field251;
   @ObfuscatedName("nr")
   static class55 field252;
   @ObfuscatedName("j")
   @Export("name")
   String field253;

   @ObfuscatedName("n")
   public static byte[] method188(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var6 = (byte[])((byte[])var0);
         if(var1) {
            int var4 = var6.length;
            byte[] var5 = new byte[var4];
            System.arraycopy(var6, 0, var5, 0, var4);
            return var5;
         } else {
            return var6;
         }
      } else if(var0 instanceof class124) {
         class124 var2 = (class124)var0;
         return var2.vmethod2728();
      } else {
         throw new IllegalArgumentException();
      }
   }
}

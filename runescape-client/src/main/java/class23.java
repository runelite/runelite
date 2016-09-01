import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public class class23 extends CacheableNode {
   @ObfuscatedName("r")
   int[] field591;
   @ObfuscatedName("x")
   static NodeCache field592 = new NodeCache(128);
   @ObfuscatedName("z")
   String[] field594;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1793729537
   )
   int field595;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 76539917
   )
   int field596;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1213357205
   )
   int field597;
   @ObfuscatedName("j")
   int[] field598;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1623555109
   )
   int field600;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1867551242"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      class13.addChatMessage(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "1706444500"
   )
   public static byte[] method566(Object var0, boolean var1) {
      if(null == var0) {
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
      } else if(var0 instanceof class128) {
         class128 var2 = (class128)var0;
         return var2.vmethod2858();
      } else {
         throw new IllegalArgumentException();
      }
   }
}

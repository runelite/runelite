import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
@Implements("AbstractByteBuffer")
public abstract class AbstractByteBuffer {
   @ObfuscatedName("z")
   @Export("directBufferUnavailable")
   static boolean directBufferUnavailable;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 374764243
   )
   static int field2602;

   static {
      directBufferUnavailable = false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "-2"
   )
   @Export("get")
   abstract byte[] get();

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1473071301"
   )
   @Export("put")
   abstract void put(byte[] var1);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljk;III)Z",
      garbageValue = "-660391723"
   )
   static boolean method3843(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         FontName.decodeSprite(var3);
         return true;
      }
   }
}

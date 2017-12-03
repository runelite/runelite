import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
@Implements("AbstractByteBuffer")
public abstract class AbstractByteBuffer {
   @ObfuscatedName("w")
   @Export("directBufferUnavailable")
   static boolean directBufferUnavailable;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 924680797
   )
   static int field2534;

   static {
      directBufferUnavailable = false;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1971888309"
   )
   @Export("get")
   abstract byte[] get();

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1446419567"
   )
   @Export("put")
   abstract void put(byte[] var1);

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IZII)V",
      garbageValue = "-1628995904"
   )
   public static final void method3518(int var0, boolean var1, int var2) {
      if(var0 >= 8000 && var0 <= 48000) {
         ScriptState.sampleRate = var0;
         ContextMenuRow.highMemory = var1;
         class218.priority = var2;
      } else {
         throw new IllegalArgumentException();
      }
   }
}

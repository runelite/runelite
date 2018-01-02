import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.IOException;

@ObfuscatedName("fx")
@Implements("AbstractSocket")
public abstract class AbstractSocket {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1430377833"
   )
   @Export("available")
   public abstract boolean available(int var1) throws IOException;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   @Export("readable")
   public abstract int readable() throws IOException;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1221609909"
   )
   @Export("read")
   public abstract int read() throws IOException;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-1823409792"
   )
   public abstract int vmethod3085(byte[] var1, int var2, int var3) throws IOException;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "906468650"
   )
   public abstract void vmethod3082(byte[] var1, int var2, int var3) throws IOException;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-124"
   )
   @Export("close")
   public abstract void close();
}

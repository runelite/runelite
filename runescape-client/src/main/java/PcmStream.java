import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
@Implements("PcmStream")
public abstract class PcmStream extends Node {
   @ObfuscatedName("w")
   @Export("active")
   volatile boolean active;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Ldc;"
   )
   @Export("after")
   PcmStream after;
   @ObfuscatedName("s")
   int field689;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ldd;"
   )
   @Export("sound")
   AbstractSound sound;

   protected PcmStream() {
      this.active = true;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "()Ldc;"
   )
   @Export("firstSubStream")
   protected abstract PcmStream firstSubStream();

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "()Ldc;"
   )
   @Export("nextSubStream")
   protected abstract PcmStream nextSubStream();

   @ObfuscatedName("l")
   protected abstract int vmethod262();

   @ObfuscatedName("e")
   @Export("fill")
   protected abstract void fill(int[] buffer, int start, int end);

   @ObfuscatedName("d")
   @Export("skip")
   protected abstract void skip(int length);

   @ObfuscatedName("az")
   int vmethod282() {
      return 255;
   }

   @ObfuscatedName("ef")
   @Export("update")
   final void update(int[] buffer, int start, int end) {
      if (this.active) {
         this.fill(buffer, start, end);
      } else {
         this.skip(end);
      }

   }
}

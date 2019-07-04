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
   protected abstract void vmethod263(int[] var1, int var2, int var3);

   @ObfuscatedName("d")
   protected abstract void vmethod264(int var1);

   @ObfuscatedName("az")
   int vmethod282() {
      return 255;
   }

   @ObfuscatedName("ef")
   @Export("update")
   final void update(int[] var1, int var2, int var3) {
      if (this.active) {
         this.vmethod263(var1, var2, var3);
      } else {
         this.vmethod264(var3);
      }

   }
}

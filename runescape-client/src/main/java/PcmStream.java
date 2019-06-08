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
   @Export("__s")
   int __s;
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
   protected abstract PcmStream firstSubStream();

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "()Ldc;"
   )
   protected abstract PcmStream nextSubStream();

   @ObfuscatedName("l")
   protected abstract int __l_171();

   @ObfuscatedName("e")
   protected abstract void __e_172(int[] var1, int var2, int var3);

   @ObfuscatedName("d")
   protected abstract void __d_173(int var1);

   @ObfuscatedName("az")
   int __az_179() {
      return 255;
   }

   @ObfuscatedName("ef")
   @Export("update")
   final void update(int[] var1, int var2, int var3) {
      if(this.active) {
         this.__e_172(var1, var2, var3);
      } else {
         this.__d_173(var3);
      }

   }
}

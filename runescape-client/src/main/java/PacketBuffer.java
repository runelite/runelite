import net.runelite.mapping.*;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@ObfuscatedName("gy")
@Implements("PacketBuffer")
public final class PacketBuffer extends Buffer {
   @ObfuscatedName("j")
   static final int[] field2543;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   @Export("cipher")
   ISAACCipher cipher;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1022606895
   )
   @Export("bitPosition")
   int bitPosition;

   static {
      field2543 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }

   public PacketBuffer(int var1) {
      super(var1);
   }

   @ObfuscatedName("jt")
   @ObfuscatedSignature(
      signature = "([IB)V",
      garbageValue = "12"
   )
   @Export("seed")
   public void seed(int[] var1) {
      this.cipher = new ISAACCipher(var1);
   }

   @ObfuscatedName("jg")
   @ObfuscatedSignature(
      signature = "(Lgj;I)V",
      garbageValue = "633383955"
   )
   @Export("setIsaacCipher")
   public void setIsaacCipher(ISAACCipher var1) {
      this.cipher = var1;
   }

   @ObfuscatedName("je")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-126"
   )
   @Export("putOpcode")
   public void putOpcode(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.cipher.nextInt());
   }

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1346768526"
   )
   @Export("readOpcode")
   public int readOpcode() {
      return super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
   }

   @ObfuscatedName("jq")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1470709432"
   )
   public boolean method3567() {
      int var1 = super.payload[super.offset] - this.cipher.method3583() & 255;
      return var1 >= 128;
   }

   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2108611718"
   )
   @Export("readShortOpcode")
   public int readShortOpcode() {
      int var1 = super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
      return var1 < 128?var1:(var1 - 128 << 8) + (super.payload[++super.offset - 1] - this.cipher.nextInt() & 255);
   }

   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "102"
   )
   @Export("bitAccess")
   public void bitAccess() {
      this.bitPosition = super.offset * 8;
   }

   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1886723881"
   )
   @Export("getBits")
   public int getBits(int var1) {
      int var2 = this.bitPosition >> 3;
      int var3 = 8 - (this.bitPosition & 7);
      int var4 = 0;

      for(this.bitPosition += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2543[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2543[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2543[var1];
      }

      return var4;
   }

   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-245555910"
   )
   @Export("byteAccess")
   public void byteAccess() {
      super.offset = (this.bitPosition + 7) / 8;
   }

   @ObfuscatedName("jl")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "-19954"
   )
   @Export("bitsAvail")
   public int bitsAvail(int var1) {
      return var1 * 8 - this.bitPosition;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "24"
   )
   public static void method3578() {
      PlayerComposition.field2737.reset();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2033731319"
   )
   public static void method3546() {
      Widget.field2753.reset();
      Widget.Widget_cachedModels.reset();
      Widget.Widget_cachedFonts.reset();
      Widget.field2756.reset();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfs;III)Ldn;",
      garbageValue = "-1301105916"
   )
   public static final AbstractSoundSystem method3579(Signlink var0, int var1, int var2) {
      if(ScriptState.sampleRate == 0) {
         throw new IllegalStateException();
      } else if(var1 >= 0 && var1 < 2) {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            AbstractSoundSystem var3 = AbstractSoundSystem.soundTaskDataProvider.taskData();
            var3.samples = new int[(ContextMenuRow.highMemory?2:1) * 256];
            var3.field1527 = var2;
            var3.vmethod2025();
            var3.offset = (var2 & -1024) + 1024;
            if(var3.offset > 16384) {
               var3.offset = 16384;
            }

            var3.create(var3.offset);
            if(class218.priority > 0 && GroundObject.task == null) {
               GroundObject.task = new SoundTask();
               AbstractSoundSystem.field1535 = Executors.newScheduledThreadPool(1);
               AbstractSoundSystem.field1535.scheduleAtFixedRate(GroundObject.task, 0L, 10L, TimeUnit.MILLISECONDS);
            }

            if(GroundObject.task != null) {
               if(GroundObject.task.systems[var1] != null) {
                  throw new IllegalArgumentException();
               }

               GroundObject.task.systems[var1] = var3;
            }

            return var3;
         } catch (Throwable var4) {
            return new AbstractSoundSystem();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
}

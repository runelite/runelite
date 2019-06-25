import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.SyncFailedException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
@Implements("AccessFile")
public final class AccessFile {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1762891465
   )
   @Export("__dk_o")
   static int __dk_o;
   @ObfuscatedName("lm")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   @Export("__dk_lm")
   static Widget __dk_lm;
   @ObfuscatedName("m")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -5849841282281477349L
   )
   @Export("capacity")
   long capacity;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = 7465414039279036117L
   )
   @Export("index")
   long index;

   public AccessFile(File var1, String var2, long var3) throws IOException {
      if(var3 == -1L) {
         var3 = Long.MAX_VALUE;
      }

      if(var1.length() >= var3) {
         var1.delete();
      }

      this.file = new RandomAccessFile(var1, var2);
      this.capacity = var3;
      this.index = 0L;
      int var5 = this.file.read();
      if(var5 != -1 && !var2.equals("r")) {
         this.file.seek(0L);
         this.file.write(var5);
      }

      this.file.seek(0L);
   }

   @ObfuscatedName("m")
   @Export("seek")
   final void seek(long var1) throws IOException {
      this.file.seek(var1);
      this.index = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-86"
   )
   @Export("write")
   public final void write(byte[] var1, int var2, int var3) throws IOException {
      if((long)var3 + this.index > this.capacity) {
         this.file.seek(this.capacity + 1L);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.index += (long)var3;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-189309573"
   )
   @Export("close")
   public final void close() throws IOException {
      this.closeSync(false);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "166642884"
   )
   @Export("closeSync")
   public final void closeSync(boolean var1) throws IOException {
      if(this.file != null) {
         if(var1) {
            try {
               this.file.getFD().sync();
            } catch (SyncFailedException var3) {
               ;
            }
         }

         this.file.close();
         this.file = null;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1069832112"
   )
   @Export("length")
   public final long length() throws IOException {
      return this.file.length();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "971670468"
   )
   @Export("read")
   public final int read(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.index += (long)var4;
      }

      return var4;
   }

   @Export("__finalize_211")
   @ObfuscatedName("finalize")
   protected void __finalize_211() throws Throwable {
      if(this.file != null) {
         System.out.println("");
         this.close();
      }

   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(Lho;Ljv;IIZI)V",
      garbageValue = "-728558316"
   )
   static final void addWidgetItemMenuItem(Widget widget, ItemDefinition definition, int var2, int actionIndex, boolean shiftClick) {
      String[] var5 = definition.inventoryActions;
      byte opcode = -1;
      String action = null;
      if(var5 != null && var5[actionIndex] != null) {
         if(actionIndex == 0) {
            opcode = 33;
         } else if(actionIndex == 1) {
            opcode = 34;
         } else if(actionIndex == 2) {
            opcode = 35;
         } else if(actionIndex == 3) {
            opcode = 36;
         } else {
            opcode = 37;
         }

         action = var5[actionIndex];
      } else if(actionIndex == 4) {
         opcode = 37;
         action = "Drop";
      }

      if(opcode != -1 && action != null) {
         class16.insertMenuItem(action, BufferedFile.colorStartTag(0xff9040) + definition.name, opcode, definition.id, var2, widget.id, shiftClick);
      }

   }
}

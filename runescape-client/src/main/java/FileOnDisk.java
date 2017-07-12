import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 5572046021208202383L
   )
   @Export("length")
   long length;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = -1707267051185505401L
   )
   @Export("position")
   long position;
   @ObfuscatedName("cv")
   @Export("rssocket")
   static RSSocket rssocket;
   @ObfuscatedName("eo")
   @ObfuscatedGetter(
      intValue = -499958675
   )
   static int field1777;
   @ObfuscatedName("i")
   @Export("file")
   RandomAccessFile file;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "167165863"
   )
   @Export("write")
   public final void write(byte[] var1, int var2, int var3) throws IOException {
      if((long)var3 + this.position > this.length) {
         this.file.seek(this.length + 1L);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += (long)var3;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "748090705"
   )
   static int method2366(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class83.field1364:class60.field766;
      if(var0 == 1800) {
         int[] var8 = class83.intStack;
         int var5 = ++class46.intStackSize - 1;
         int var6 = WorldMapType3.getWidgetConfig(var3);
         int var7 = var6 >> 11 & 63;
         var8[var5] = var7;
         return 1;
      } else if(var0 != 1801) {
         if(var0 == 1802) {
            if(var3.name == null) {
               class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
            } else {
               class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3.name;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var4 = class83.intStack[--class46.intStackSize];
         --var4;
         if(var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
            class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var3.actions[var4];
         } else {
            class83.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = "";
         }

         return 1;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "1897591308"
   )
   @Export("read")
   public final int read(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   protected void finalize() throws Throwable {
      if(this.file != null) {
         System.out.println("");
         this.close();
      }

   }

   @ObfuscatedName("i")
   @Export("seek")
   final void seek(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1398584935"
   )
   @Export("length")
   public final long length() throws IOException {
      return this.file.length();
   }

   public FileOnDisk(File var1, String var2, long var3) throws IOException {
      if(-1L == var3) {
         var3 = Long.MAX_VALUE;
      }

      if(var1.length() >= var3) {
         var1.delete();
      }

      this.file = new RandomAccessFile(var1, var2);
      this.length = var3;
      this.position = 0L;
      int var5 = this.file.read();
      if(var5 != -1 && !var2.equals("r")) {
         this.file.seek(0L);
         this.file.write(var5);
      }

      this.file.seek(0L);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1605625791"
   )
   @Export("close")
   public final void close() throws IOException {
      if(this.file != null) {
         this.file.close();
         this.file = null;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)[LSpritePixels;",
      garbageValue = "2086255941"
   )
   static SpritePixels[] method2382() {
      SpritePixels[] var0 = new SpritePixels[class286.field3798];

      for(int var1 = 0; var1 < class286.field3798; ++var1) {
         SpritePixels var2 = var0[var1] = new SpritePixels();
         var2.maxWidth = class286.field3801;
         var2.maxHeight = class286.field3796;
         var2.offsetX = class286.field3799[var1];
         var2.offsetY = class286.offsetsY[var1];
         var2.width = class7.field239[var1];
         var2.height = class226.field3146[var1];
         int var3 = var2.height * var2.width;
         byte[] var4 = class210.spritePixels[var1];
         var2.image = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.image[var5] = class278.field3745[var4[var5] & 255];
         }
      }

      XGrandExchangeOffer.method113();
      return var0;
   }
}

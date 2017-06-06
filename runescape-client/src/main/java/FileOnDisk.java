import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("i")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -6743454464588498539L
   )
   @Export("position")
   long position;
   @ObfuscatedName("v")
   static ModIcon field1782;
   @ObfuscatedName("g")
   static int[] field1783;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = -210835793448921061L
   )
   @Export("length")
   long length;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "728879475"
   )
   public final int method2343(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1323595172"
   )
   public final long method2344() throws IOException {
      return this.file.length();
   }

   protected void finalize() throws Throwable {
      if(this.file != null) {
         System.out.println("");
         this.method2348();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-361165486"
   )
   public final void method2348() throws IOException {
      if(this.file != null) {
         this.file.close();
         this.file = null;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)LWidget;",
      garbageValue = "1623079208"
   )
   public static Widget method2351(int var0, int var1) {
      Widget var2 = WorldMapType3.method199(var0);
      return var1 == -1?var2:(var2 != null && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }

   @ObfuscatedName("i")
   final void method2360(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   public FileOnDisk(File var1, String var2, long var3) throws IOException {
      if(var3 == -1L) {
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "0"
   )
   public static int method2363(int var0) {
      Varbit var2 = (Varbit)Varbit.field3379.get((long)var0);
      Varbit var1;
      if(var2 != null) {
         var1 = var2;
      } else {
         byte[] var7 = Varbit.field3380.getConfigData(14, var0);
         var2 = new Varbit();
         if(var7 != null) {
            var2.method4425(new Buffer(var7));
         }

         Varbit.field3379.put(var2, (long)var0);
         var1 = var2;
      }

      int var3 = var1.configId;
      int var4 = var1.leastSignificantBit;
      int var5 = var1.mostSignificantBit;
      int var6 = class211.field2612[var5 - var4];
      return class211.widgetSettings[var3] >> var4 & var6;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1636702183"
   )
   public final void method2364(byte[] var1, int var2, int var3) throws IOException {
      if((long)var3 + this.position > this.length) {
         this.file.seek(1L + this.length);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += (long)var3;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZB)[B",
      garbageValue = "26"
   )
   public static byte[] method2365(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var3 = (byte[])((byte[])var0);
         return var1?CombatInfo1.method1541(var3):var3;
      } else if(var0 instanceof class176) {
         class176 var2 = (class176)var0;
         return var2.vmethod3366();
      } else {
         throw new IllegalArgumentException();
      }
   }
}

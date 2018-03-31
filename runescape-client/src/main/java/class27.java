import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public enum class27 implements Enumerated {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lap;"
   )
   field383(0, (byte)0),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lap;"
   )
   field378(2, (byte)1),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lap;"
   )
   field379(1, (byte)2),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lap;"
   )
   field385(3, (byte)3);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ldh;"
   )
   @Export("task")
   static SoundTask task;
   @ObfuscatedName("b")
   @Export("cacheLocations")
   public static String[] cacheLocations;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1151877591
   )
   final int field381;
   @ObfuscatedName("x")
   final byte field384;

   class27(int var3, byte var4) {
      this.field381 = var3;
      this.field384 = var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1780726447"
   )
   public int rsOrdinal() {
      return this.field384;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "970232060"
   )
   public static int method240(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 <= 127) {
            ++var2;
         } else if(var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/io/File;",
      garbageValue = "72"
   )
   public static File method229(String var0) {
      if(!class170.field2220) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class170.field2219.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(SoundTaskDataProvider.field624, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class170.field2219.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1345664638"
   )
   public static int method239(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)[Lap;",
      garbageValue = "-2"
   )
   static class27[] method238() {
      return new class27[]{field385, field383, field378, field379};
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Led;IIII)Z",
      garbageValue = "1660277578"
   )
   @Export("boundingBox3DContainsMouse")
   static final boolean boundingBox3DContainsMouse(Model var0, int var1, int var2, int var3) {
      boolean var4 = class132.Viewport_containsMouse;
      if(!var4) {
         return false;
      } else {
         Signlink.method3246();
         int var5 = var0.centerX + var1;
         int var6 = var2 + var0.centerY;
         int var7 = var3 + var0.centerZ;
         int var8 = var0.extremeX;
         int var9 = var0.extremeY;
         int var10 = var0.extremeZ;
         int var11 = class132.field1915 - var5;
         int var12 = AbstractSoundSystem.field1570 - var6;
         int var13 = class132.field1918 - var7;
         return Math.abs(var11) > var8 + class25.field357?false:(Math.abs(var12) > var9 + ChatLineBuffer.field1470?false:(Math.abs(var13) > var10 + GameSocket.field2258?false:(Math.abs(var13 * Item.field1406 - var12 * class132.field1917) > var9 * GameSocket.field2258 + var10 * ChatLineBuffer.field1470?false:(Math.abs(var11 * class132.field1917 - var13 * class18.field306) > var10 * class25.field357 + var8 * GameSocket.field2258?false:Math.abs(var12 * class18.field306 - var11 * Item.field1406) <= var8 * ChatLineBuffer.field1470 + var9 * class25.field357))));
      }
   }

   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "(Ljs;Ljava/lang/String;I)V",
      garbageValue = "242480293"
   )
   static void method232(IndexData var0, String var1) {
      class64 var2 = new class64(var0, var1);
      Client.field1125.add(var2);
   }
}

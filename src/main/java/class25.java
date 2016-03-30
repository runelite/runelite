import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("b")
@Implements("World")
public class class25 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1145872369
   )
   @Export("playerCount")
   int field638;
   @ObfuscatedName("a")
   @Export("activity")
   String field639;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 696025367
   )
   static int field642 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1823953307
   )
   static int field643 = 0;
   @ObfuscatedName("c")
   static int[] field644 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("v")
   static int[] field645 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -232986337
   )
   @Export("mask")
   int field647;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1668721235
   )
   @Export("location")
   int field648;
   @ObfuscatedName("q")
   @Export("address")
   String field649;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1239707551
   )
   @Export("id")
   int field650;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 662979755
   )
   @Export("index")
   int field652;

   @ObfuscatedName("v")
   boolean method613() {
      return (2 & this.field647) != 0;
   }

   @ObfuscatedName("s")
   boolean method617() {
      return (536870912 & this.field647) != 0;
   }

   @ObfuscatedName("l")
   boolean method622() {
      return (4 & this.field647) != 0;
   }

   @ObfuscatedName("w")
   static int method623() {
      return ++class11.field192 - 1;
   }

   @ObfuscatedName("j")
   boolean method626() {
      return (33554432 & this.field647) != 0;
   }

   @ObfuscatedName("c")
   boolean method635() {
      return (1 & this.field647) != 0;
   }

   @ObfuscatedName("x")
   public static boolean method638(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("z")
   boolean method642() {
      return 0 != (8 & this.field647);
   }
}

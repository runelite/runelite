import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class31 {
   @ObfuscatedName("m")
   static int[] field456;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -310865313
   )
   final int field454;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -427675001
   )
   final int field451;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 115615729
   )
   final int field452;

   class31(int var1, int var2, int var3) {
      this.field454 = var1;
      this.field451 = var2;
      this.field452 = var3;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1998328057"
   )
   public static boolean method293(int var0) {
      return var0 >= class222.field2828.field2810 && var0 <= class222.field2829.field2810;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZI)V",
      garbageValue = "1520409259"
   )
   public static void method292(String var0, boolean var1, boolean var2) {
      class12.method70(var0, var1, "openjs", var2);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "1772957220"
   )
   public static File method295(String var0) {
      if(!class158.field2267) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class158.field2265.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class158.field2262, var0);
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
                  class158.field2265.put(var0, var2);
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

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "(Lcr;IB)V",
      garbageValue = "0"
   )
   @Export("characterToScreen")
   static final void characterToScreen(Actor var0, int var1) {
      class7.method24(var0.x, var0.y, var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IZIZI)V",
      garbageValue = "-1990141713"
   )
   static void method294(int var0, boolean var1, int var2, boolean var3) {
      if(World.worldList != null) {
         Ignore.method1172(0, World.worldList.length - 1, var0, var1, var2, var3);
      }

   }
}

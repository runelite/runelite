import java.awt.Component;
import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
@Implements("Item")
public final class class28 extends class85 {
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = 555985589
   )
   @Export("plane")
   static int field655;
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      intValue = -1425457043
   )
   static int field656;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1881209669
   )
   @Export("quantity")
   int field658;
   @ObfuscatedName("bb")
   static class168 field659;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -632248251
   )
   @Export("id")
   int field662;
   @ObfuscatedName("hd")
   @ObfuscatedGetter(
      intValue = -1700560271
   )
   static int field663;
   @ObfuscatedName("jk")
   static class173[] field665;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/io/File;",
      garbageValue = "120"
   )
   public static File method644(String var0) {
      if(!class135.field2065) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class135.field2064.get(var0);
         if(null != var1) {
            return var1;
         } else {
            File var2 = new File(class135.field2063, var0);
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
                  class135.field2064.put(var0, var2);
                  return var2;
               }
            } catch (Exception var7) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var6) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass167;I)V",
      garbageValue = "1171426787"
   )
   public static void method646(class167 var0) {
      class41.field959 = var0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Lclass105;",
      garbageValue = "-1145523992"
   )
   protected final class105 vmethod1900() {
      return class89.method2081(this.field662).method1058(this.field658);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "119717325"
   )
   public static void method648(Component var0) {
      var0.addMouseListener(class140.field2124);
      var0.addMouseMotionListener(class140.field2124);
      var0.addFocusListener(class140.field2124);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1915023627"
   )
   public static void method649() {
      class179.field2927.method3707();
   }
}

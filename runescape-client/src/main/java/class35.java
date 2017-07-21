import java.applet.Applet;
import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class35 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lar;"
   )
   static final class35 field484;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   @Export("widgetIndex")
   static IndexDataBase widgetIndex;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lar;"
   )
   static final class35 field482;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -224110895
   )
   static int field487;
   @ObfuscatedName("r")
   @Export("blendedSaturation")
   static int[] blendedSaturation;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -522526907
   )
   final int field481;

   static {
      field484 = new class35(0);
      field482 = new class35(1);
   }

   class35(int var1) {
      this.field481 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;I)V",
      garbageValue = "144687758"
   )
   public static void method484(Applet var0, String var1) {
      class56.field674 = var0;
      class56.field675 = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "1862979694"
   )
   static File method482(String var0) {
      if(!class157.field2220) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class157.field2217.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class157.field2216, var0);
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
                  class157.field2217.put(var0, var2);
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lbv;",
      garbageValue = "1464710283"
   )
   static MessageNode method483(int var0) {
      return (MessageNode)class98.field1495.get((long)var0);
   }
}

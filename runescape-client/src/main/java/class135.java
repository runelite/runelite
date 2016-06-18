import java.awt.Component;
import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
public class class135 {
   @ObfuscatedName("g")
   static File field2062;
   @ObfuscatedName("j")
   static Hashtable field2065 = new Hashtable(16);
   @ObfuscatedName("bt")
   static class168 field2069;
   @ObfuscatedName("b")
   static boolean field2071 = false;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "117"
   )
   public static void method2907(Component var0) {
      var0.removeMouseListener(class140.field2131);
      var0.removeMouseMotionListener(class140.field2131);
      var0.removeFocusListener(class140.field2131);
      class140.field2130 = 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "-77"
   )
   static void method2911(byte[] var0) {
      class119 var1 = new class119(var0);
      var1.field1976 = var0.length - 2;
      class76.field1361 = var1.method2516();
      class76.field1353 = new int[class76.field1361];
      class131.field2048 = new int[class76.field1361];
      class76.field1354 = new int[class76.field1361];
      class28.field674 = new int[class76.field1361];
      class76.field1355 = new byte[class76.field1361][];
      var1.field1976 = var0.length - 7 - class76.field1361 * 8;
      class109.field1890 = var1.method2516();
      class76.field1351 = var1.method2516();
      int var2 = (var1.method2514() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class76.field1361; ++var3) {
         class76.field1353[var3] = var1.method2516();
      }

      for(var3 = 0; var3 < class76.field1361; ++var3) {
         class131.field2048[var3] = var1.method2516();
      }

      for(var3 = 0; var3 < class76.field1361; ++var3) {
         class76.field1354[var3] = var1.method2516();
      }

      for(var3 = 0; var3 < class76.field1361; ++var3) {
         class28.field674[var3] = var1.method2516();
      }

      var1.field1976 = var0.length - 7 - class76.field1361 * 8 - (var2 - 1) * 3;
      class8.field135 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class8.field135[var3] = var1.method2518();
         if(class8.field135[var3] == 0) {
            class8.field135[var3] = 1;
         }
      }

      var1.field1976 = 0;

      for(var3 = 0; var3 < class76.field1361; ++var3) {
         int var4 = class76.field1354[var3];
         int var5 = class28.field674[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         class76.field1355[var3] = var7;
         int var8 = var1.method2514();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.method2515();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var4 * var10] = var1.method2515();
               }
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II)I",
      garbageValue = "-987112589"
   )
   public static int method2912(CharSequence var0, int var1) {
      return class9.method117(var0, var1, true);
   }
}

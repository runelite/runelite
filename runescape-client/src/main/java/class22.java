import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public class class22 extends class119 {
   @ObfuscatedName("bb")
   static class184 field254;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;B)I",
      garbageValue = "-102"
   )
   static int method217(class182 var0, class182 var1) {
      int var2 = 0;
      if(var0.method3321("title.jpg", "")) {
         ++var2;
      }

      if(var1.method3321("logo", "")) {
         ++var2;
      }

      if(var1.method3321("logo_deadman_mode", "")) {
         ++var2;
      }

      if(var1.method3321("titlebox", "")) {
         ++var2;
      }

      if(var1.method3321("titlebutton", "")) {
         ++var2;
      }

      if(var1.method3321("runes", "")) {
         ++var2;
      }

      if(var1.method3321("title_mute", "")) {
         ++var2;
      }

      if(var1.method3322("options_radio_buttons,0")) {
         ++var2;
      }

      if(var1.method3322("options_radio_buttons,2")) {
         ++var2;
      }

      var1.method3321("sl_back", "");
      var1.method3321("sl_flags", "");
      var1.method3321("sl_arrows", "");
      var1.method3321("sl_stars", "");
      var1.method3321("sl_button", "");
      return var2;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "-57"
   )
   public static boolean method218(char var0) {
      return var0 >= 48 && var0 <= 57;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZB)LFileOnDisk;",
      garbageValue = "-90"
   )
   public static FileOnDisk method220(String var0, String var1, boolean var2) {
      File var3 = new File(class104.field1691, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class116.field1815 == 33) {
         var4 = "_rc";
      } else if(class116.field1815 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class104.field1699, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)Ljava/io/File;",
      garbageValue = "11206"
   )
   static File method222(String var0) {
      if(!class107.field1731) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class107.field1733.get(var0);
         if(null != var1) {
            return var1;
         } else {
            File var2 = new File(class107.field1732, var0);
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
                  class107.field1733.put(var0, var2);
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1765403218"
   )
   public static void method223() {
      ItemComposition.field2953.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "245014910"
   )
   protected boolean vmethod2339(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field1857 && var3 == super.field1852;
   }
}

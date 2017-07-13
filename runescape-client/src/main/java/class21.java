import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public class class21 {
   @ObfuscatedName("ex")
   static Font field338;
   @ObfuscatedName("al")
   protected static boolean field339;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Lclass254;",
      garbageValue = "-1766720437"
   )
   public static class254 method154(int var0) {
      class254 var1 = (class254)class254.field3427.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class254.field3409.getConfigData(32, var0);
         var1 = new class254();
         if(var2 != null) {
            var1.method4450(new Buffer(var2));
         }

         class254.field3427.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LIndexData;II)V",
      garbageValue = "1341567098"
   )
   static void method155(IndexData var0, int var1) {
      if(class44.field568 != null) {
         class44.field568.offset = 8 * var1 + 5;
         int var2 = class44.field568.readInt();
         int var3 = class44.field568.readInt();
         var0.setInformation(var2, var3);
      } else {
         FileOnDisk.method2368((IndexData)null, 255, 255, 0, (byte)0, true);
         class238.field3267[var1] = var0;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "-388625390"
   )
   public static File method156(String var0) {
      if(!class157.field2250) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class157.field2251.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class157.field2254, var0);
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
                  class157.field2251.put(var0, var2);
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

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(ILCoordinates;ZB)V",
      garbageValue = "-30"
   )
   static void method151(int var0, Coordinates var1, boolean var2) {
      WorldMapData var3 = class39.method548().method5107(var0);
      int var4 = Script.localPlayer.field889;
      int var5 = (Script.localPlayer.x >> 7) + class163.baseX;
      int var6 = (Script.localPlayer.y >> 7) + class10.baseY;
      Coordinates var7 = new Coordinates(var4, var5, var6);
      class39.method548().method5227(var3, var7, var1, var2);
   }
}

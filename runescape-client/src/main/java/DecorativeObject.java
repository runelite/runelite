import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1940555023
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1464607475
   )
   @Export("x")
   int x;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 949463531
   )
   @Export("y")
   int y;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1968866089
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1593385217
   )
   @Export("rotation")
   int rotation;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1368295569
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1640671709
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Leh;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Leh;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2137466925
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 240325807
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   DecorativeObject() {
      this.hash = 0;
      this.renderInfoBitPacked = 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "1283410689"
   )
   static File method3142(String var0) {
      if(!class160.field2159) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class160.field2158.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class160.field2157, var0);
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
                  class160.field2158.put(var0, var2);
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "-1678784569"
   )
   public static char method3143(char var0) {
      return (char)(var0 == 198?69:(var0 == 230?101:(var0 == 223?115:(var0 == 338?69:(var0 == 339?'e':'\u0000')))));
   }
}

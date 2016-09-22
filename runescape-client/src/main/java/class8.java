import java.io.File;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class8 {
   @ObfuscatedName("v")
   boolean field131;
   @ObfuscatedName("r")
   boolean field133;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2075198061
   )
   int field134 = 1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -241756571
   )
   static int field135 = 4;
   @ObfuscatedName("t")
   LinkedHashMap field136 = new LinkedHashMap();
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = -1718034767
   )
   static int field137;
   @ObfuscatedName("g")
   public static byte[][] field139;
   @ObfuscatedName("bs")
   static class171 field140;

   class8(Buffer var1) {
      if(null != var1 && null != var1.payload) {
         int var2 = var1.method2528();
         if(var2 >= 0 && var2 <= field135) {
            if(var1.method2528() == 1) {
               this.field131 = true;
            }

            if(var2 > 1) {
               this.field133 = var1.method2528() == 1;
            }

            if(var2 > 3) {
               this.field134 = var1.method2528();
            }

            if(var2 > 2) {
               int var3 = var1.method2528();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.method2533();
                  int var6 = var1.method2533();
                  this.field136.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method112(true);
         }
      } else {
         this.method112(true);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1825667299"
   )
   void method112(boolean var1) {
   }

   class8() {
      this.method112(true);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)LBuffer;",
      garbageValue = "1132733096"
   )
   Buffer method115() {
      Buffer var1 = new Buffer(100);
      var1.method2513(field135);
      var1.method2513(this.field131?1:0);
      var1.method2513(this.field133?1:0);
      var1.method2513(this.field134);
      var1.method2513(this.field136.size());
      Iterator var2 = this.field136.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method2600(((Integer)var3.getKey()).intValue());
         var1.method2600(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "-1230576108"
   )
   public static File method122(String var0) {
      if(!class138.field2158) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class138.field2155.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class181.field2974, var0);
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
                  class138.field2155.put(var0, var2);
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass170;B)V",
      garbageValue = "30"
   )
   public static void method123(class170 var0) {
      class48.field1084 = var0;
   }
}

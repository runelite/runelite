import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
public class class157 {
   @ObfuscatedName("dl")
   @Export("region")
   static Region region;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "1488230921"
   )
   static final void method2957(Widget var0, int var1, int var2) {
      if(Client.field521 == 0 || Client.field521 == 3) {
         if(class115.field1808 == 1 || !MessageNode.field229 && class115.field1808 == 4) {
            class145 var3 = var0.method2846(true);
            if(null == var3) {
               return;
            }

            int var4 = class115.field1809 - var1;
            int var5 = class115.field1806 - var2;
            if(var3.method2784(var4, var5)) {
               var4 -= var3.field2028 / 2;
               var5 -= var3.field2020 / 2;
               int var6 = Client.mapScale + Client.mapAngle & 2047;
               int var7 = class84.field1444[var6];
               int var8 = class84.field1445[var6];
               var7 = (Client.mapScaleDelta + 256) * var7 >> 8;
               var8 = var8 * (256 + Client.mapScaleDelta) >> 8;
               int var9 = var4 * var8 + var7 * var5 >> 11;
               int var10 = var5 * var8 - var4 * var7 >> 11;
               int var11 = class40.localPlayer.x + var9 >> 7;
               int var12 = class40.localPlayer.y - var10 >> 7;
               Client.field330.method3234(35);
               Client.field330.method2975(18);
               Client.field330.method2976(class16.baseX + var11);
               Client.field330.method3098(class105.field1709[82]?(class105.field1709[81]?2:1):0);
               Client.field330.method3183(var12 + Client.baseY);
               Client.field330.method2975(var4);
               Client.field330.method2975(var5);
               Client.field330.method2976(Client.mapAngle);
               Client.field330.method2975(57);
               Client.field330.method2975(Client.mapScale);
               Client.field330.method2975(Client.mapScaleDelta);
               Client.field330.method2975(89);
               Client.field330.method2976(class40.localPlayer.x);
               Client.field330.method2976(class40.localPlayer.y);
               Client.field330.method2975(63);
               Client.flagX = var11;
               Client.flagY = var12;
            }
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "1996518200"
   )
   static File method2963(String var0) {
      if(!class107.field1735) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class107.field1727.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class107.field1726, var0);
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
                  class107.field1727.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(null != var3) {
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
}

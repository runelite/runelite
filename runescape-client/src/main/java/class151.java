import java.applet.Applet;
import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
public class class151 extends RuntimeException {
   @ObfuscatedName("f")
   static Applet field2268;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2004308247
   )
   static int field2269;
   @ObfuscatedName("v")
   String field2270;
   @ObfuscatedName("b")
   Throwable field2271;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2097156313"
   )
   static void method3149() {
      XItemContainer.itemContainers = new XHashTable(32);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass139;Ljava/awt/Component;IIB)Lclass59;",
      garbageValue = "-122"
   )
   public static final class59 method3153(class139 var0, Component var1, int var2, int var3) {
      if(class59.field1235 == 0) {
         throw new IllegalStateException();
      } else if(var2 >= 0 && var2 < 2) {
         if(var3 < 256) {
            var3 = 256;
         }

         try {
            class72 var4 = new class72();
            var4.field1223 = new int[256 * (class59.field1219?2:1)];
            var4.field1218 = var3;
            var4.vmethod1573(var1);
            var4.field1227 = (var3 & -1024) + 1024;
            if(var4.field1227 > 16384) {
               var4.field1227 = 16384;
            }

            var4.vmethod1561(var4.field1227);
            if(class59.field1241 > 0 && class59.field1240 == null) {
               class59.field1240 = new class75();
               class59.field1240.field1399 = var0;
               var0.method2910(class59.field1240, class59.field1241);
            }

            if(null != class59.field1240) {
               if(class59.field1240.field1394[var2] != null) {
                  throw new IllegalArgumentException();
               }

               class59.field1240.field1394[var2] = var4;
            }

            return var4;
         } catch (Throwable var5) {
            return new class59();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
}

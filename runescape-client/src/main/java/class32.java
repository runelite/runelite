import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public class class32 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2002354755
   )
   int field746;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1189186873
   )
   int field747;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 933638361
   )
   int field748;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 448804943
   )
   int field749;
   @ObfuscatedName("r")
   String field750;
   @ObfuscatedName("df")
   @ObfuscatedGetter(
      intValue = -188871089
   )
   static int field751;
   @ObfuscatedName("j")
   static int[] field752;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass139;Ljava/awt/Component;III)Lclass59;",
      garbageValue = "-2092635289"
   )
   public static final class59 method678(class139 var0, Component var1, int var2, int var3) {
      if(class59.field1260 == 0) {
         throw new IllegalStateException();
      } else if(var2 >= 0 && var2 < 2) {
         if(var3 < 256) {
            var3 = 256;
         }

         try {
            class72 var4 = new class72();
            var4.field1247 = new int[(class59.field1242?2:1) * 256];
            var4.field1241 = var3;
            var4.vmethod1610(var1);
            var4.field1254 = 1024 + (var3 & -1024);
            if(var4.field1254 > 16384) {
               var4.field1254 = 16384;
            }

            var4.vmethod1602(var4.field1254);
            if(class59.field1243 > 0 && null == class59.field1244) {
               class59.field1244 = new class75();
               class59.field1244.field1423 = var0;
               var0.method3005(class59.field1244, class59.field1243);
            }

            if(null != class59.field1244) {
               if(class59.field1244.field1418[var2] != null) {
                  throw new IllegalArgumentException();
               }

               class59.field1244.field1418[var2] = var4;
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

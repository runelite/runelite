import java.awt.Component;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class class35 {
   @ObfuscatedName("z")
   static final class35 field756 = new class35();
   @ObfuscatedName("t")
   static final class35 field757 = new class35();
   @ObfuscatedName("s")
   static final class35 field759 = new class35();
   @ObfuscatedName("y")
   static final class35 field760 = new class35();
   @ObfuscatedName("ea")
   static ModIcon[] field761;
   @ObfuscatedName("gk")
   static Widget field762;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass170;III)Z",
      garbageValue = "1116024025"
   )
   public static boolean method729(class170 var0, int var1, int var2) {
      byte[] var3 = var0.method3272(var1, var2);
      if(null == var3) {
         return false;
      } else {
         class0.method0(var3);
         return true;
      }
   }

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(LWidget;I)LWidget;",
      garbageValue = "-234180717"
   )
   static Widget method730(Widget var0) {
      int var2 = class11.method138(var0);
      int var1 = var2 >> 17 & 7;
      int var3 = var1;
      if(var1 == 0) {
         return null;
      } else {
         for(int var4 = 0; var4 < var3; ++var4) {
            var0 = class92.method2078(var0.parentId);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass139;Ljava/awt/Component;III)Lclass59;",
      garbageValue = "222478809"
   )
   public static final class59 method731(class139 var0, Component var1, int var2, int var3) {
      if(class59.field1219 == 0) {
         throw new IllegalStateException();
      } else if(var2 >= 0 && var2 < 2) {
         if(var3 < 256) {
            var3 = 256;
         }

         try {
            class72 var4 = new class72();
            var4.field1240 = new int[256 * (class59.field1222?2:1)];
            var4.field1241 = var3;
            var4.vmethod1522(var1);
            var4.field1213 = (var3 & -1024) + 1024;
            if(var4.field1213 > 16384) {
               var4.field1213 = 16384;
            }

            var4.vmethod1518(var4.field1213);
            if(class59.field1215 > 0 && null == class219.field3209) {
               class219.field3209 = new class75();
               class219.field3209.field1397 = var0;
               var0.method2878(class219.field3209, class59.field1215);
            }

            if(null != class219.field3209) {
               if(null != class219.field3209.field1390[var2]) {
                  throw new IllegalArgumentException();
               }

               class219.field3209.field1390[var2] = var4;
            }

            return var4;
         } catch (Throwable var5) {
            return new class59();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "-931639750"
   )
   static final void method732(Actor var0) {
      int var1 = var0.field847 - Client.gameCycle;
      int var2 = var0.field843 * 128 + var0.field805 * 64;
      int var3 = var0.field805 * 64 + var0.field845 * 128;
      var0.x += (var2 - var0.x) / var1;
      var0.y += (var3 - var0.y) / var1;
      var0.field859 = 0;
      var0.field852 = var0.field849;
   }
}

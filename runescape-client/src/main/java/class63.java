import java.awt.event.ActionEvent;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
public class class63 implements Runnable {
   @ObfuscatedName("u")
   class103 field1086;
   @ObfuscatedName("x")
   volatile class57[] field1087 = new class57[2];
   @ObfuscatedName("i")
   volatile boolean field1088 = false;
   @ObfuscatedName("a")
   volatile boolean field1089 = false;

   public void run() {
      this.field1089 = true;

      try {
         while(!this.field1088) {
            class57 var1;
            for(int var2 = 0; var2 < 2; ++var2) {
               var1 = this.field1087[var2];
               if(var1 != null) {
                  var1.method1019();
               }
            }

            VertexNormal.method1598(10L);
            class103 var9 = this.field1086;
            var1 = null;
            if(null != var9.field1659) {
               for(int var3 = 0; var3 < 50 && var9.field1659.peekEvent() != null; ++var3) {
                  VertexNormal.method1598(1L);
               }

               if(var1 != null) {
                  var9.field1659.postEvent(new ActionEvent(var1, 1001, "dummy"));
               }
            }
         }
      } catch (Exception var7) {
         class174.method3240((String)null, var7);
      } finally {
         this.field1089 = false;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-681496965"
   )
   static void method1109(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.method2339((long)var0);
      if(null != var1) {
         for(int var2 = 0; var2 < var1.itemIds.length; ++var2) {
            var1.itemIds[var2] = -1;
            var1.stackSizes[var2] = 0;
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;III)Lclass208;",
      garbageValue = "-432867519"
   )
   public static class208 method1110(class182 var0, class182 var1, int var2, int var3) {
      if(!XGrandExchangeOffer.method60(var0, var2, var3)) {
         return null;
      } else {
         byte[] var4 = var1.method3272(var2, var3);
         class208 var5;
         if(var4 == null) {
            var5 = null;
         } else {
            class208 var6 = new class208(var4, class225.field3213, class225.field3216, class225.field3217, class178.field2653, class225.field3218, class119.field1845);
            class225.field3213 = null;
            class225.field3216 = null;
            class225.field3217 = null;
            class178.field2653 = null;
            class225.field3218 = null;
            class119.field1845 = (byte[][])null;
            var5 = var6;
         }

         return var5;
      }
   }
}
